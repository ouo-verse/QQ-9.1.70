package com.tencent.mobileqq.msf.core.net.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterInputStream;
import tencent.im.oidb.cmd0x769.Oidb_0x769;

/* loaded from: classes15.dex */
public class MsfPullConfigUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_TEST_CRASH_SWITCH = "key_test_crash_switch";
    public static final String SP_SAFEMODE_TEST_CRASH_CONFIG = "sp_safemode_test_crash_config";
    private static final String TAG = "MsfPullConfigUtil";
    private static final int TYPE_COMMAND = 283;
    private static final int TYPE_PATCH = 46;
    public static volatile boolean sRecvProxy = false;
    public static volatile boolean sRecvRegister = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f249474a;

        a(String str) {
            this.f249474a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                Toast.makeText(BaseApplication.getContext(), this.f249474a, 0).show();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24192);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public MsfPullConfigUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void execConfigCmd(int i3, int i16, List<String> list) {
        if (i3 != 46) {
            if (i3 == 283) {
                MsfCmdConfig.executeManageSafeModeCmd(i16, list.get(0));
                return;
            }
            return;
        }
        MsfHandlePatchUtils.handlePatchConfig(i16, list);
    }

    private static byte[] inflateConfigString(byte[] bArr) {
        InflaterInputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inflaterInputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                QLog.e(TAG, 1, "[inflateConfigString] IO error, ", e16);
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "inflateConfigString error", th);
                }
                if (inflaterInputStream != null) {
                    try {
                    } catch (IOException e17) {
                        return null;
                    }
                }
                return null;
            } finally {
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (IOException e172) {
                        QLog.e(TAG, 1, "[inflateConfigString] IO error, ", e172);
                    }
                }
                byteArrayOutputStream.close();
            }
        }
    }

    private static List<String> parseConfigContent(Oidb_0x769.Config config) {
        String stringUtf8;
        PBRepeatMessageField<Oidb_0x769.Content> pBRepeatMessageField = config.rpt_msg_content_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "parseConfigContent rpt_msg_content_list size=" + config.rpt_msg_content_list.size());
            }
            for (Oidb_0x769.Content content : config.rpt_msg_content_list.get()) {
                if (content != null && content.content.has()) {
                    if (content.compress.get() == 1) {
                        byte[] inflateConfigString = inflateConfigString(content.content.get().toByteArray());
                        if (inflateConfigString != null) {
                            try {
                                stringUtf8 = new String(inflateConfigString, "UTF-8");
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "parseConfigContent rpt_msg_content_list uncompress failed", e16);
                                }
                            }
                        }
                        stringUtf8 = null;
                    } else {
                        stringUtf8 = content.content.get().toStringUtf8();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "parseConfigContent rpt_msg_content_list content item=" + stringUtf8);
                    }
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        arrayList.add(stringUtf8);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "parseConfigContent rpt_msg_content_list content item empty");
                }
            }
            return arrayList;
        }
        PBRepeatField<String> pBRepeatField = config.rpt_content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "parseConfigContent rpt_content_list size=" + config.rpt_content_list.size());
            }
            for (String str : config.rpt_content_list.get()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList2.add(str);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "parseConfigContent rpt_content_list content item=" + str);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "parseConfigContent rpt_content_list content item empty");
                }
            }
            return arrayList2;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, "parseConfigContent msg_content_list and rpt_content_list are empty, version=" + config.uint32_version.get());
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0122, code lost:
    
        if (r7 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0124, code lost:
    
        com.tencent.mobileqq.msf.core.net.utils.b.a(1, 1, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0103, code lost:
    
        if (r7 != false) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void parseConfigResponse(byte[] bArr, boolean z16) {
        boolean z17;
        boolean z18;
        Object valueOf;
        try {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("parseConfigResponse response len=");
                if (bArr == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(bArr.length);
                }
                sb5.append(valueOf);
                sb5.append(", isRegProxy=");
                sb5.append(z16);
                QLog.d(TAG, 2, sb5.toString());
            }
        } catch (Throwable th5) {
            th = th5;
            z17 = false;
            z18 = false;
        }
        if (bArr != null && bArr.length > 0) {
            Oidb_0x769.RspBody rspBody = new Oidb_0x769.RspBody();
            if (z16) {
                int length = bArr.length - 4;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 4, bArr2, 0, length);
                bArr = bArr2;
            }
            rspBody.mergeFrom(bArr);
            int i3 = rspBody.uint32_result.get();
            if (i3 == 0) {
                PBRepeatMessageField<Oidb_0x769.Config> pBRepeatMessageField = rspBody.rpt_config_list;
                if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                    int size = rspBody.rpt_config_list.size();
                    z17 = false;
                    z18 = false;
                    for (int i16 = 0; i16 < size; i16++) {
                        try {
                            Oidb_0x769.Config config = rspBody.rpt_config_list.get(i16);
                            if (config != null && config.uint32_type.has()) {
                                List<String> parseConfigContent = parseConfigContent(config);
                                if (parseConfigContent != null && parseConfigContent.size() > 0) {
                                    execConfigCmd(config.uint32_type.get(), config.uint32_version.get(), parseConfigContent);
                                    int i17 = config.uint32_type.get();
                                    if (i17 == 283) {
                                        z17 = true;
                                    } else if (i17 == 46) {
                                        z18 = true;
                                    }
                                } else if (config.uint32_type.get() == 46) {
                                    execConfigCmd(46, config.uint32_version.get(), parseConfigContent);
                                    z18 = true;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "parseConfigResponse decode Oidb_0x769.RspBody --> throwable=", th);
                                }
                                if (z17 || z18) {
                                    if (!z17) {
                                        b.a(2, 1, false);
                                    }
                                }
                                b.a(0, 1, false);
                                if (!z16) {
                                }
                            } catch (Throwable th7) {
                                if (!z17 && !z18) {
                                    b.a(0, 1, false);
                                } else {
                                    if (!z17) {
                                        b.a(2, 1, false);
                                    }
                                    if (!z18) {
                                        b.a(1, 1, false);
                                    }
                                }
                                throw th7;
                            }
                        }
                    }
                    if (!z17 || z18) {
                        if (!z17) {
                            b.a(2, 1, false);
                        }
                    }
                    b.a(0, 1, false);
                    if (!z16) {
                        sRecvProxy = true;
                        return;
                    } else {
                        sRecvRegister = true;
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    if (rspBody.rpt_config_list.isEmpty()) {
                        QLog.d(TAG, 2, "parseConfigResponse decode Oidb_0x769.RspBody --> rpt_config_list is empty");
                    } else {
                        QLog.d(TAG, 2, "parseConfigResponse decode Oidb_0x769.RspBody --> rpt_config_list size 0");
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseConfigResponse decode Oidb_0x769.RspBody --> result error=" + i3);
            }
        }
        z17 = false;
        z18 = false;
        if (!z17) {
        }
        if (!z17) {
        }
    }

    public static byte[] pullConfigRequest(boolean z16) {
        Oidb_0x769.ReqBody reqBody = new Oidb_0x769.ReqBody();
        Oidb_0x769.ConfigSeq configSeq = new Oidb_0x769.ConfigSeq();
        configSeq.type.set(46);
        configSeq.version.set(MsfHandlePatchUtils.getPatchConfigVersion());
        reqBody.rpt_config_list.add(configSeq);
        Oidb_0x769.ConfigSeq configSeq2 = new Oidb_0x769.ConfigSeq();
        configSeq2.type.set(283);
        configSeq2.version.set(0);
        reqBody.rpt_config_list.add(configSeq2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pullConfigRequest isRegProxy=" + z16);
        }
        return reqBody.toByteArray();
    }

    public static void showToastForSafeModeTest(String str) {
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && BaseApplication.getContext().getSharedPreferences(SP_SAFEMODE_TEST_CRASH_CONFIG, 4).getBoolean(KEY_TEST_CRASH_SWITCH, false)) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                new Handler(Looper.getMainLooper()).post(new a(str));
            } else {
                Toast.makeText(BaseApplication.getContext(), str, 0).show();
            }
        }
    }
}
