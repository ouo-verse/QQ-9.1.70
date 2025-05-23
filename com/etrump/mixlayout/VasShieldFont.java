package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes2.dex */
public class VasShieldFont {

    /* renamed from: h, reason: collision with root package name */
    private static String f32675h;

    /* renamed from: i, reason: collision with root package name */
    private static Typeface f32676i;

    /* renamed from: j, reason: collision with root package name */
    public static Typeface f32677j;

    /* renamed from: a, reason: collision with root package name */
    public static final String f32668a = "default_font" + File.separator;

    /* renamed from: b, reason: collision with root package name */
    public static int f32669b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static String f32670c = "";

    /* renamed from: d, reason: collision with root package name */
    public static int f32671d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static int f32672e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f32673f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f32674g = true;

    /* renamed from: k, reason: collision with root package name */
    private static AtomicBoolean f32678k = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    private static AtomicBoolean f32679l = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private static AtomicBoolean f32680m = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f32685a;

        a(QQAppInterface qQAppInterface) {
            this.f32685a = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            VasShieldFont.u(this.f32685a, updateListenerParams.mErrorCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            VasShieldFont.u(this.f32685a, updateListenerParams.mErrorCode);
        }
    }

    static /* bridge */ /* synthetic */ boolean g() {
        return k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(QQAppInterface qQAppInterface, String str, int i3) {
        String qqStr = HardCodeUtil.qqStr(R.string.uy_);
        int length = qqStr.length();
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, f32670c, qqStr, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 1179653, com.tencent.mobileqq.service.message.e.K0());
        gVar.f213692o = new int[]{1179653};
        Bundle bundle = new Bundle();
        bundle.putInt("key_action", 1);
        bundle.putString("key_action_DATA", IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.MY_FONT));
        gVar.b(length - 7, length - 3, bundle);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187 A[Catch: all -> 0x01a0, TRY_LEAVE, TryCatch #0 {all -> 0x01a0, blocks: (B:85:0x0181, B:87:0x0187), top: B:84:0x0181 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0199 A[Catch: Exception -> 0x019c, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x019c, blocks: (B:67:0x016d, B:92:0x0199), top: B:5:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean k() {
        String str;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Exception exc;
        File file;
        File file2;
        String str2;
        BufferedReader bufferedReader2;
        QQVasUpdateBusiness<?> o16 = o();
        if (o16 != null) {
            str = o16.getSavePath(VasUpdateConstants.SCID_DEFAULT_FONT) + "/";
        } else {
            str = VasConstant.INTERNAL_VAS_SO_DIR + f32668a;
        }
        BufferedReader bufferedReader3 = null;
        bufferedReader3 = null;
        r3 = null;
        FileInputStream fileInputStream2 = null;
        InputStreamReader inputStreamReader2 = null;
        try {
            try {
                file = new File(str + "md5");
                file2 = new File(n());
                str2 = "";
                if (file.exists() && file.isFile()) {
                    InputStreamReader inputStreamReader3 = new InputStreamReader(new FileInputStream(file), "UTF-8");
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader3);
                    } catch (Exception e16) {
                        bufferedReader = null;
                        exc = e16;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                    }
                    try {
                        String readLine = bufferedReader2.readLine();
                        inputStreamReader = inputStreamReader3;
                        str2 = readLine;
                        bufferedReader = bufferedReader2;
                    } catch (Exception e17) {
                        exc = e17;
                        bufferedReader = bufferedReader2;
                        fileInputStream = null;
                        inputStreamReader2 = inputStreamReader3;
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.e("VasShieldFont", 2, "checkFontFile: ", exc);
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            FileUtils.deleteDirectory(str);
                            return false;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader3 = bufferedReader;
                            if (bufferedReader3 != null) {
                                try {
                                    bufferedReader3.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    throw th;
                                } catch (Exception unused5) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = null;
                        bufferedReader3 = bufferedReader2;
                        inputStreamReader = inputStreamReader3;
                        if (bufferedReader3 != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (fileInputStream != null) {
                        }
                    }
                } else {
                    inputStreamReader = null;
                    bufferedReader = null;
                }
                try {
                } catch (Exception e18) {
                    exc = e18;
                    fileInputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    fileInputStream = null;
                }
            } catch (Exception e19) {
                bufferedReader = null;
                exc = e19;
                fileInputStream = null;
            } catch (Throwable th9) {
                th = th9;
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (Exception unused6) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("VasShieldFont", 2, "checkFontFile: md5file exists = " + file.exists() + ", isFile = " + file.isFile());
            }
            FileUtils.deleteDirectory(str);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused7) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception unused8) {
                }
            }
            return false;
        }
        if (file2.exists() && file2.isFile()) {
            fileInputStream = new FileInputStream(file2);
            try {
                String bytesToHexString = StructLongMessageDownloadProcessor.bytesToHexString(MD5.toMD5Byte(fileInputStream, file2.length()));
                if (QLog.isColorLevel()) {
                    QLog.d("VasShieldFont", 2, "checkFontFile: localMd5 = " + bytesToHexString + " srvMd5=" + str2);
                }
                if (bytesToHexString.equals(str2)) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused9) {
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception unused10) {
                        }
                    }
                    try {
                        fileInputStream.close();
                        return true;
                    } catch (Exception unused11) {
                        return true;
                    }
                }
                fileInputStream2 = fileInputStream;
            } catch (Exception e26) {
                exc = e26;
                inputStreamReader2 = inputStreamReader;
                if (QLog.isColorLevel()) {
                }
                if (bufferedReader != null) {
                }
                if (inputStreamReader2 != null) {
                }
                if (fileInputStream != null) {
                }
                FileUtils.deleteDirectory(str);
                return false;
            } catch (Throwable th10) {
                th = th10;
                bufferedReader3 = bufferedReader;
                if (bufferedReader3 != null) {
                }
                if (inputStreamReader != null) {
                }
                if (fileInputStream != null) {
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "checkFontFile: fontFile exists = " + file2.exists() + ", isFile = " + file2.isFile());
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Exception unused12) {
            }
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (Exception unused13) {
            }
        }
        if (fileInputStream2 != null) {
            fileInputStream2.close();
        }
        FileUtils.deleteDirectory(str);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060 A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:5:0x000b, B:7:0x0024, B:10:0x002b, B:12:0x0048, B:17:0x0050, B:23:0x0058, B:25:0x0060, B:26:0x0077, B:28:0x0086), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086 A[Catch: Exception -> 0x009c, TRY_LEAVE, TryCatch #0 {Exception -> 0x009c, blocks: (B:5:0x000b, B:7:0x0024, B:10:0x002b, B:12:0x0048, B:17:0x0050, B:23:0x0058, B:25:0x0060, B:26:0x0077, B:28:0x0086), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(TextView textView) {
        boolean z16;
        if (f32671d < 0) {
            int i3 = 1;
            try {
                textView.setDrawingCacheEnabled(true);
                Bitmap drawingCache = textView.getDrawingCache();
                f32677j = textView.getTypeface();
                int currentTextColor = textView.getCurrentTextColor() & 16777215;
                if (drawingCache != null && !drawingCache.isRecycled()) {
                    int width = drawingCache.getWidth();
                    int height = drawingCache.getHeight();
                    int i16 = width * height;
                    int[] iArr = new int[i16];
                    drawingCache.getPixels(iArr, 0, width, 0, 0, width, height);
                    z16 = false;
                    for (int i17 = 0; i17 < i16; i17++) {
                        int i18 = iArr[i17] & 16777215;
                        if (i18 != 0 && i18 != currentTextColor) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        i3 = 0;
                    }
                    f32671d = i3;
                    if (QLog.isColorLevel()) {
                        QLog.d("VasShieldFont", 2, "checkColorFont: sSysColorFont=" + f32671d);
                    }
                    textView.setDrawingCacheEnabled(false);
                    if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
                        ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class).sendEmptyMessage(1060);
                        return;
                    }
                    return;
                }
                z16 = false;
                if (z16) {
                }
                f32671d = i3;
                if (QLog.isColorLevel()) {
                }
                textView.setDrawingCacheEnabled(false);
                if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
                }
            } catch (Exception e16) {
                QLog.e("VasShieldFont", 2, "checkSysColorFont: ", e16);
            }
        } else {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null || f32678k.get()) {
            return;
        }
        f32678k.set(true);
        if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "downloadDefaultFont");
        }
        QQVasUpdateBusiness<?> o16 = o();
        if (o16 != null) {
            o16.addDownLoadListener(VasUpdateConstants.SCID_DEFAULT_FONT, new a(qQAppInterface));
            o16.startDownload(VasUpdateConstants.SCID_DEFAULT_FONT);
        } else {
            ((IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, VasUpdateConstants.SCID_DEFAULT_FONT, "defaultFont");
        }
    }

    public static String n() {
        QQVasUpdateBusiness<?> o16 = o();
        if (o16 != null) {
            if (TextUtils.isEmpty(f32675h)) {
                f32675h = o16.getSavePath(VasUpdateConstants.SCID_DEFAULT_FONT) + "/default.ttf";
            }
        } else if (TextUtils.isEmpty(f32675h)) {
            f32675h = VasConstant.INTERNAL_VAS_SO_DIR + f32668a + "default.ttf";
        }
        return f32675h;
    }

    private static QQVasUpdateBusiness<?> o() {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(1004L).booleanValue()) {
            try {
                return QQVasUpdateBusiness.getBusiness(1004L);
            } catch (Exception e16) {
                QLog.w("VasShieldFont", 1, "getNewBusiness", e16);
                return null;
            }
        }
        return null;
    }

    public static int p() {
        if (f32673f < 0) {
            f32673f = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt("keySysFontSetting", 0);
        }
        return f32673f;
    }

    public static int q() {
        if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "hasSysColorFont: defaultFontType=" + f32669b + " sysColorFont=" + f32671d + " sUserFontId=" + f32672e);
        }
        if (f32669b > 1 && f32672e == 0) {
            return f32671d;
        }
        return 0;
    }

    public static void r(QQAppInterface qQAppInterface) {
        s(qQAppInterface, null, null);
    }

    public static void s(final QQAppInterface qQAppInterface, final MqqHandler mqqHandler, final SessionInfo sessionInfo) {
        if (qQAppInterface == null) {
            return;
        }
        if (f32671d < 1) {
            if (QLog.isColorLevel()) {
                QLog.d("VasShieldFont", 2, "loadDefaultFont: user not uses color font.");
                return;
            }
            return;
        }
        if (f32679l.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.etrump.mixlayout.VasShieldFont.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    if (QLog.isColorLevel()) {
                        QLog.d("VasShieldFont", 2, "loadDefaultFont: type=" + VasShieldFont.f32669b);
                    }
                    if (!VasShieldFont.f32678k.get()) {
                        if (VasShieldFont.f32676i == null) {
                            if (VasShieldFont.g()) {
                                VasShieldFont.t();
                                VasShieldFont.v();
                            } else {
                                VasShieldFont.m(QQAppInterface.this);
                            }
                        }
                        MqqHandler mqqHandler2 = mqqHandler;
                        if (mqqHandler2 != null) {
                            mqqHandler2.removeMessages(89);
                            mqqHandler.sendEmptyMessage(89);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("loadDefaultFont: typeface=");
                        if (VasShieldFont.f32676i != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        QLog.d("VasShieldFont", 2, sb5.toString());
                    }
                    VasShieldFont.f32679l.set(false);
                }
            }, 64, null, true);
        }
        if (mqqHandler != null && sessionInfo != null && f32674g && f32671d > 0 && f32669b > 1 && f32672e == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("VasShieldFont", 2, "loadDefaultFont: ShowGrayTip: sSysColorFont=" + f32671d + " sDefaultFontType=" + f32669b);
            }
            mqqHandler.removeMessages(89);
            mqqHandler.sendEmptyMessage(89);
            ThreadManagerV2.getTimer().schedule(new TimerTask() { // from class: com.etrump.mixlayout.VasShieldFont.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("VasShieldFont", 2, "schedule: userfontid=" + VasShieldFont.f32672e);
                    }
                    if (VasShieldFont.f32672e == 0 && VasShieldFont.f32674g) {
                        VasShieldFont.f32674g = false;
                        QQAppInterface qQAppInterface2 = QQAppInterface.this;
                        SessionInfo sessionInfo2 = sessionInfo;
                        VasShieldFont.j(qQAppInterface2, sessionInfo2.f179557e, sessionInfo2.f179555d);
                        QQAppInterface.this.getPreferences().edit().putBoolean("keySysFontGrayTip", false).commit();
                    }
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        if (com.tencent.mobileqq.filemanager.util.q.p(n())) {
            int i3 = f32669b;
            if (i3 == 3 || i3 == 5 || i3 == 6) {
                try {
                    f32676i = Typeface.createFromFile(n());
                } catch (Exception e16) {
                    QLog.e("VasShieldFont", 2, "createFromFile:", e16);
                }
            }
        }
    }

    public static void u(QQAppInterface qQAppInterface, int i3) {
        if (i3 == 0) {
            if (o() == null) {
                String str = FontManagerConstants.FONT_DOWN_LOAD_PATH + File.separator + "default.zip";
                if (com.tencent.mobileqq.filemanager.util.q.p(str)) {
                    try {
                        FileUtils.uncompressZip(str, VasConstant.INTERNAL_VAS_SO_DIR + f32668a, false);
                    } catch (IOException e16) {
                        QLog.e("VasShieldFont", 2, "uncompress zip failed", e16);
                    }
                }
            }
            r(qQAppInterface);
        }
        f32678k.set(false);
    }

    public static void v() {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            VasUtils.c(qQAppInterface);
            MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
            if (handler != null) {
                handler.removeMessages(89);
                handler.sendEmptyMessage(89);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "refreshAIO: " + BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    public static boolean w(int i3) {
        if (i3 > -1) {
            f32673f = i3;
            v();
            return BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("keySysFontSetting", i3).commit();
        }
        return false;
    }
}
