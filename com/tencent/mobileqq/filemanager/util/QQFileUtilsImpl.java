package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileUtilsImpl {
    public static boolean b(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        if ((!messageRecord.isMultiMsg && !messageRecord.isReplySource) || TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("_m_ForwardFileType"))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x0069 -> B:36:0x009e). Please report as a decompilation issue!!! */
    public static boolean c(Context context, String str, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptor;
        FileOutputStream fileOutputStream;
        boolean z16;
        boolean z17 = false;
        if (!FileUtils.fileExistsAndNotEmpty(str) || uri == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
            } catch (Exception e16) {
                e = e16;
                parcelFileDescriptor = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                parcelFileDescriptor = null;
                fileOutputStream = null;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        if (parcelFileDescriptor == null) {
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                        while (true) {
                            int read = fileInputStream2.read(buf);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(buf, 0, read);
                        }
                        ByteArrayPool.getGenericInstance().returnBuf(buf);
                        fileOutputStream.flush();
                        try {
                            fileInputStream2.close();
                            z16 = true;
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            z16 = false;
                        }
                        try {
                            fileOutputStream.close();
                            z17 = z16;
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                        parcelFileDescriptor.close();
                    } catch (Exception e27) {
                        e = e27;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e28) {
                                e28.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                            }
                        }
                        if (parcelFileDescriptor != null) {
                            parcelFileDescriptor.close();
                        }
                        return z17;
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e36) {
                                e36.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e37) {
                                e37.printStackTrace();
                            }
                        }
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                                throw th;
                            } catch (IOException e38) {
                                e38.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Exception e39) {
                e = e39;
            }
        } catch (Exception e46) {
            e = e46;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
        return z17;
    }

    public static void d(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, MessageRecord messageRecord) {
        if (fileManagerEntity == null) {
            return;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return;
        }
        int parseInt = Integer.parseInt(extInfoFromExtStr);
        String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (parseInt == 1) {
            fileManagerEntity.peerType = 0;
            if (!TextUtils.isEmpty(currentAccountUin) && !TextUtils.isEmpty(extInfoFromExtStr2) && currentAccountUin.equals(extInfoFromExtStr2)) {
                fileManagerEntity.peerUin = extInfoFromExtStr3;
                return;
            }
            return;
        }
        if (parseInt == 2) {
            fileManagerEntity.peerType = 3000;
        }
    }

    public static String e(Context context, int i3, int i16, TextView textView, TextView textView2, String str, String str2) {
        TextPaint paint = textView.getPaint();
        int dp2px = ((i16 - (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(7, context.getResources()) * 2)) - ((int) textView2.getPaint().measureText(str2))) - ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(15, context.getResources());
        if (i3 == 2) {
            return (String) TextUtils.ellipsize(str, paint, dp2px, TextUtils.TruncateAt.END);
        }
        return str;
    }

    public static int f(int i3, int i16) {
        if ((i3 * 1.0f) / i16 >= 1.7777778f) {
            return 2;
        }
        return 1;
    }

    private static SpannableString g(String str, String str2, ah.f fVar) {
        int indexOf = str.indexOf(str2);
        int indexOf2 = str.indexOf(String.format(HardCodeUtil.qqStr(R.string.zyl), ""));
        if (indexOf2 != -1) {
            String substring = str.substring(indexOf2, str.length());
            if (substring.contains(str2)) {
                indexOf = substring.indexOf(str2) + indexOf2;
            }
        }
        int i3 = indexOf;
        if (i3 < 0) {
            return new SpannableString(str);
        }
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSpannableString(str, fVar, BaseApplication.getContext().getResources().getColorStateList(R.color.qui_common_text_link, null), i3, i3 + str2.length());
    }

    private static String h(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb5.length() > 0) {
                sb5.append(context.getString(R.string.b78));
            }
            sb5.append(String.format(HardCodeUtil.qqStr(R.string.zyl), str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            if (sb5.length() > 0) {
                sb5.append(context.getString(R.string.b78));
            }
            sb5.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            if (sb5.length() > 0) {
                sb5.append(context.getString(R.string.b78));
            }
            sb5.append(str4);
        }
        return sb5.toString();
    }

    public static int i() {
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        if (activeNetIpFamily == 1) {
            return 1;
        }
        if (activeNetIpFamily == 2) {
            return 3;
        }
        if (activeNetIpFamily == 3) {
            return 2;
        }
        return 0;
    }

    public static int j(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$").matcher(str).matches()) {
            return 1;
        }
        String replaceAll = str.replaceAll("[\\[\\]]", "");
        if (TextUtils.isEmpty(replaceAll) || !IPAddressUtil.isIPv6LiteralAddress(replaceAll)) {
            return 0;
        }
        return 2;
    }

    public static int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return j(new URL(str).getHost());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int l() {
        int i3 = i();
        if (1 == i3) {
            return 1;
        }
        if (3 == i3) {
            return 2;
        }
        if (2 == i3) {
            return 3;
        }
        return 0;
    }

    public static int m() {
        int connectedIPFamily = MsfServiceSdk.get().getConnectedIPFamily();
        if (2 == connectedIPFamily) {
            return 2;
        }
        if (1 == connectedIPFamily) {
            return 1;
        }
        return 0;
    }

    private static String n(String str, String str2, String str3) {
        int indexOf = str.indexOf(str3);
        if (indexOf < 0) {
            return str2;
        }
        int indexOf2 = str.indexOf("\n");
        if (indexOf2 > indexOf) {
            String substring = str.substring(indexOf + str3.length(), indexOf2);
            if (substring.contains(str2)) {
                return str2;
            }
            if (substring.length() < str2.length()) {
                StringBuilder sb5 = new StringBuilder(str2);
                sb5.insert(substring.length(), "\n");
                return sb5.toString();
            }
        }
        return str2;
    }

    public static boolean o(Context context, String str) {
        if (QQFileManagerUtilImpl.Q0(str) <= 10485760) {
            return true;
        }
        FMDialogUtil.b(context, "", R.string.f187243tg, new a(context, str));
        return false;
    }

    public static void p(final Context context, final TextView textView, final String str, final String str2, final String str3, final String str4, final String str5, final boolean z16, final ah.f fVar) {
        String h16 = h(context, str, str2, str3, str4);
        if (!TextUtils.isEmpty(h16) && !TextUtils.isEmpty(str2)) {
            if (textView.getWidth() != 0 && textView.getLayout() != null) {
                q(context, textView, str, str2, str3, str4, str5, z16, fVar);
                return;
            } else {
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQFileUtilsImpl.q(context, textView, str, str2, str3, str4, str5, z16, fVar);
                    }
                });
                return;
            }
        }
        if (!TextUtils.isEmpty(h16.replace(" ", ""))) {
            textView.setText(str5 + h16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Context context, TextView textView, String str, String str2, String str3, String str4, String str5, boolean z16, ah.f fVar) {
        SpannableString spannableString;
        String V = QQFileManagerUtilImpl.V(textView, 1, str5 + h(context, str, str2, str3, str4), str2);
        if (!TextUtils.isEmpty(V)) {
            String str6 = str5 + h(context, str, V, str3, str4);
            String n3 = n(str6, V, String.format(HardCodeUtil.qqStr(R.string.zyl), ""));
            if (z16) {
                spannableString = g(str6, n3, fVar);
            } else {
                spannableString = new SpannableString(str6);
            }
        } else {
            spannableString = null;
        }
        if (QVipTroopFileProcessor.get().isEnable() && !TextUtils.isEmpty(spannableString)) {
            QVipTroopFileProcessor.get().focusFileExpired(spannableString, str4, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getVipType());
        }
        if (spannableString != null && spannableString.length() > 0) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableString);
            textView.setFocusable(false);
            textView.setClickable(false);
            textView.setLongClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f209296a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f209297b;

        a(Context context, String str) {
            this.f209296a = context;
            this.f209297b = str;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startActivityByLinkByWeiyunFragment(this.f209296a, null, this.f209297b, false);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
