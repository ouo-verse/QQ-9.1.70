package com.tencent.mobileqq.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WXShareHelper extends BroadcastReceiver implements IWXAPIEventHandler {
    static IPatchRedirector $redirector_;
    public static final String H;
    private static boolean I;
    private static byte[] J;
    private static WXShareHelper K;
    private IWXAPI C;
    private IWXAPI D;
    private final HashMap<String, IWXAPI> E;
    private final ArrayList<a> F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    Context f327453d;

    /* renamed from: e, reason: collision with root package name */
    private IWXAPI f327454e;

    /* renamed from: f, reason: collision with root package name */
    private IWXAPI f327455f;

    /* renamed from: h, reason: collision with root package name */
    private IWXAPI f327456h;

    /* renamed from: i, reason: collision with root package name */
    private IWXAPI f327457i;

    /* renamed from: m, reason: collision with root package name */
    private IWXAPI f327458m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wxapi.WXShareHelper$5, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f327507d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f327508e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bitmap f327509f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f327510h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f327511i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f327512m;
        final /* synthetic */ WXShareHelper this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.W(this.f327507d, this.f327508e, this.f327509f, this.f327510h, this.f327511i, this.f327512m);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void onWXShareResp(BaseResp baseResp);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        H = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
        I = false;
        J = new byte[0];
        K = null;
    }

    WXShareHelper(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.E = new HashMap<>();
        this.F = new ArrayList<>(1);
        this.G = false;
        I = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_common_appid_for_wx_share_api", false);
        String str = "wxf14070172bb44e41";
        this.f327454e = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxf14070172bb44e41", true);
        String str2 = "wxf0a80d0ac2e82aa7";
        this.f327455f = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxf0a80d0ac2e82aa7", true);
        BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
        this.f327456h = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxcb89b8fc34e4e304", true);
        this.f327457i = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wx1d0f5457c7556472", true);
        this.f327458m = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wx24f6adf674778541", true);
        this.C = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxf0a80d0ac2e82aa7", true);
        this.D = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxf14070172bb44e41", true);
        this.G = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openconnect_wx_share_api_subthread_switch", false);
        QLog.e("WXShareHelper", 1, "WXShareHelper configWxApiSubThreadSwitch= " + this.G);
        if (z16) {
            z17 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openconnect_wx_share_api_async_register_app", true);
            QLog.i("WXShareHelper", 1, "WXShareHelper asyncRegisterAppEnable: " + z17);
        } else {
            z17 = false;
        }
        if (z17) {
            ThreadManagerV2.excute(new Runnable(str2, str) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327459d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327460e;

                {
                    this.f327459d = str2;
                    this.f327460e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str2, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("WXShareHelper", 1, "WXShareHelper async registerApp");
                    try {
                        WXShareHelper.this.p0();
                        WXShareHelper.this.f327456h.registerApp("wxcb89b8fc34e4e304");
                        WXShareHelper.this.f327457i.registerApp("wx1d0f5457c7556472");
                        WXShareHelper.this.f327458m.registerApp("wx24f6adf674778541");
                        WXShareHelper.this.C.registerApp(this.f327459d);
                        WXShareHelper.this.D.registerApp(this.f327460e);
                    } catch (Exception e16) {
                        QLog.e("WXShareHelper", 1, "async registerApp ", e16);
                    }
                }
            }, 240, null, false);
            return;
        }
        p0();
        this.f327456h.registerApp("wxcb89b8fc34e4e304");
        this.f327457i.registerApp("wx1d0f5457c7556472");
        this.f327458m.registerApp("wx24f6adf674778541");
        this.C.registerApp("wxf0a80d0ac2e82aa7");
        this.D.registerApp("wxf14070172bb44e41");
    }

    private static byte[] B(Bitmap bitmap) {
        if (bitmap == null) {
            QLog.e("WXShareHelper", 1, "[bitmap2Bytes] bitmap is null.");
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            while (byteArray.length >= 131072 && i3 > 0) {
                i3 -= 10;
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream2);
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                byteArrayOutputStream2.close();
                byteArray = byteArray2;
            }
            QLog.i("WXShareHelper", 1, "[bitmap2Bytes] length = " + byteArray.length + ", quality = " + i3);
            return byteArray;
        } catch (Exception e16) {
            QLog.e("WXShareHelper", 1, "bitmap2Bytes exception", e16);
            return null;
        }
    }

    private String C(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public static byte[] F(Bitmap bitmap, int i3) {
        byte[] byteArray;
        if (bitmap == null) {
            return null;
        }
        float f16 = i3;
        float max = Math.max(f16 / bitmap.getWidth(), f16 / bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i16 = 100;
        do {
            byteArrayOutputStream.reset();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, i16, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
            i16 -= 5;
        } while (byteArray.length > 32768);
        return byteArray;
    }

    public static byte[] G(Bitmap bitmap, boolean z16, boolean z17) {
        return H(bitmap, 100, z16, z17);
    }

    public static byte[] H(Bitmap bitmap, int i3, boolean z16, boolean z17) {
        byte[] bitmap2Bytes;
        if (bitmap == null) {
            return null;
        }
        float f16 = i3;
        float max = Math.max(f16 / bitmap.getWidth(), f16 / bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z17) {
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, i3, i3);
            bitmap2Bytes = BaseImageUtil.bitmap2Bytes(createBitmap2);
            createBitmap2.recycle();
        } else {
            bitmap2Bytes = BaseImageUtil.bitmap2Bytes(createBitmap);
        }
        createBitmap.recycle();
        if (z16) {
            bitmap.recycle();
        }
        return bitmap2Bytes;
    }

    private static void I(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(file2).getChannel();
            fileChannel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            fileChannel2.close();
        } catch (Throwable th6) {
            th = th6;
            FileChannel fileChannel3 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel3;
            fileChannel2.close();
            fileChannel.close();
            throw th;
        }
    }

    private Bitmap J(Bitmap bitmap, float f16) {
        int i3;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f17 = width;
        float f18 = height;
        int i16 = 0;
        if ((1.0f * f17) / f18 > f16) {
            int i17 = (int) (f18 * f16);
            int i18 = (width - i17) / 2;
            width = i17;
            i3 = 0;
            i16 = i18;
        } else {
            int i19 = (int) (f17 / f16);
            int i26 = (height - i19) / 2;
            height = i19;
            i3 = i26;
        }
        return Bitmap.createBitmap(bitmap, i16, i3, width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, byte[] bArr, int i3, String str2) {
        QLog.d("WXShareHelper", 1, "--shareEmojiToWX");
        if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.dzx);
            return;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        Uri a06 = a0(str);
        if (a06 != null) {
            str = a06.toString();
        }
        wXEmojiObject.emojiPath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = bArr;
        if ((bArr == null || bArr.length > 32768) && QLog.isColorLevel()) {
            QLog.i("WXShareHelper", 2, "wxmsg.thumbData is invalid");
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str2;
        req.message = wXMediaMessage;
        req.scene = i3;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, Bitmap bitmap) {
        String uri;
        QLog.d("WXShareHelper", 1, "--shareFileToWx");
        if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.dzx);
            return;
        }
        WXFileObject wXFileObject = new WXFileObject();
        Uri a06 = a0(str);
        if (a06 == null) {
            uri = str;
        } else {
            uri = a06.toString();
        }
        wXFileObject.filePath = uri;
        byte[] G = G(bitmap, false, true);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = FileUtils.getFileName(str);
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = G;
        if ((G == null || G.length > 32768) && QLog.isColorLevel()) {
            QLog.i("WXShareHelper", 2, "wxmsg.thumbData is invalid");
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = C("file");
        req.message = wXMediaMessage;
        req.scene = 0;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, byte[] bArr, int i3, String str2) {
        QLog.d("WXShareHelper", 1, "--shareImageToWX");
        if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.dzx);
            return;
        }
        WXImageObject wXImageObject = new WXImageObject();
        Uri a06 = a0(str);
        if (a06 != null) {
            str = a06.toString();
        }
        wXImageObject.imagePath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = bArr;
        if ((bArr == null || bArr.length > 32768) && QLog.isColorLevel()) {
            QLog.i("WXShareHelper", 2, "wxmsg.thumbData is invalid");
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str2;
        req.message = wXMediaMessage;
        req.scene = i3;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, String str2, Bitmap bitmap, String str3, String str4, String str5) {
        if (QLog.isColorLevel()) {
            QLog.i("WXShareHelper", 2, "shareMiniProgramToWX:");
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = str5;
        wXMiniProgramObject.userName = str2;
        wXMiniProgramObject.path = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = str3;
        wXMediaMessage.description = str4;
        if (bitmap != null) {
            wXMediaMessage.setThumbImage(bitmap);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = C("miniProgram");
        req.message = wXMediaMessage;
        req.scene = 0;
        r0(this.f327456h, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("WXShareHelper", 2, "shareMiniProgramToWXForPicShare:");
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.userName = str3;
        wXMiniProgramObject.webpageUrl = str2;
        wXMiniProgramObject.path = str;
        wXMiniProgramObject.withShareTicket = z16;
        wXMiniProgramObject.miniprogramType = i3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = str4;
        wXMediaMessage.description = str5;
        if (bitmap != null) {
            wXMediaMessage.setThumbImage(bitmap);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = C("miniProgram");
        req.message = wXMediaMessage;
        req.scene = 0;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(String str, String str2, Bitmap bitmap, String str3, String str4, int i3, String str5) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicLowBandUrl = str4;
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str5;
        wXMusicObject.musicLowBandDataUrl = str5;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMusicObject);
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        wXMediaMessage.setThumbImage(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = i3;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        String str5;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str4));
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        if (bitmap != null) {
            wXMediaMessage.setThumbImage(bitmap);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = i3;
        boolean r06 = r0(this.f327458m, req);
        if (!r06) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.17
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) WXShareHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
                    }
                }
            });
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shareQQWeatherToWX.transaction: ");
            sb5.append(str);
            sb5.append(" title:");
            sb5.append(str2);
            sb5.append(" description:");
            sb5.append(str3);
            sb5.append(" webPageUrl:");
            sb5.append(str4);
            sb5.append(" scene:");
            if (i3 == 0) {
                str5 = "Friend";
            } else {
                str5 = "FriendCircle";
            }
            sb5.append(str5);
            sb5.append(" reqResult:");
            sb5.append(r06);
            QLog.i("WXShareHelper", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, byte[] bArr, int i3) {
        if (str == null) {
            return;
        }
        if (!str.contains(AppConstants.SDCARD_PATH + "photo/")) {
            String str2 = System.currentTimeMillis() + ".jpeg";
            StringBuilder sb5 = new StringBuilder();
            String str3 = H;
            sb5.append(str3);
            sb5.append(str2);
            String sb6 = sb5.toString();
            try {
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                I(new File(str), new File(sb6));
                str = sb6;
            } catch (Throwable th5) {
                QLog.e("WXShareHelper", 2, "shareImage exception:", th5);
                return;
            }
        }
        WXImageObject wXImageObject = new WXImageObject();
        Uri a06 = a0(str);
        if (a06 != null) {
            str = a06.toString();
        }
        wXImageObject.imagePath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i3 == 0) {
            wXMediaMessage.thumbData = bArr;
            if (bArr == null || bArr.length > 32768) {
                QLog.e("WXShareHelper", 1, "wxmsg.thumbData is invalid");
            }
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = C("img");
        req.message = wXMediaMessage;
        req.scene = i3;
        if (!r0(this.f327457i, req)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.15
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) WXShareHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        String str5;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str4));
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        if (bitmap != null) {
            wXMediaMessage.setThumbImage(bitmap);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = i3;
        boolean r06 = r0(this.f327457i, req);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shareWebPage.transaction: ");
            sb5.append(str);
            sb5.append(" title:");
            sb5.append(str2);
            sb5.append(" description:");
            sb5.append(str3);
            sb5.append(" webPageUrl:");
            sb5.append(str4);
            sb5.append(" scene:");
            if (i3 == 0) {
                str5 = "Friend";
            } else {
                str5 = "FriendCircle";
            }
            sb5.append(str5);
            sb5.append(" reqResult:");
            sb5.append(r06);
            QLog.i("WXShareHelper", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str, String str2, Bitmap bitmap, String str3, String str4) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str4));
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        wXMediaMessage.setThumbImage(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = 0;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str, String str2, Bitmap bitmap, String str3, String str4) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str4));
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        wXMediaMessage.setThumbImage(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = 1;
        r0(this.f327455f, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        String str5;
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str4;
        wXVideoObject.videoLowBandUrl = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        wXMediaMessage.setThumbImage(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = i3;
        boolean r06 = r0(this.f327455f, req);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shareVideo.transaction: ");
            sb5.append(str);
            sb5.append(" title:");
            sb5.append(str2);
            sb5.append(" description:");
            sb5.append(str3);
            sb5.append(" webPageUrl:");
            sb5.append(str4);
            sb5.append(" scene:");
            if (i3 == 0) {
                str5 = "Friend";
            } else {
                str5 = "FriendCircle";
            }
            sb5.append(str5);
            sb5.append(" reqResult:");
            sb5.append(r06);
            QLog.i("WXShareHelper", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        String str5;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str4));
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        if (bitmap != null) {
            wXMediaMessage.setThumbImage(bitmap);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = i3;
        boolean r06 = r0(this.f327455f, req);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shareWebPage.transaction: ");
            sb5.append(str);
            sb5.append(" title:");
            sb5.append(str2);
            sb5.append(" description:");
            sb5.append(str3);
            sb5.append(" webPageUrl:");
            sb5.append(str4);
            sb5.append(" scene:");
            if (i3 == 0) {
                str5 = "Friend";
            } else {
                str5 = "FriendCircle";
            }
            sb5.append(str5);
            sb5.append(" reqResult:");
            sb5.append(r06);
            QLog.i("WXShareHelper", 2, sb5.toString());
        }
    }

    private void Y(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.G && Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable(runnable) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.18
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Runnable f327490d;

                {
                    this.f327490d = runnable;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) WXShareHelper.this, (Object) runnable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        this.f327490d.run();
                    } catch (Exception e16) {
                        QLog.e("WXShareHelper", 1, "executeWxApiRunnable exception", e16);
                    }
                }
            }, 16, null, false);
        } else {
            runnable.run();
        }
    }

    private Uri a0(String str) {
        if (str.startsWith("content://")) {
            QLog.d("WXShareHelper", 1, "getFileUri path.startsWith(CONTENT_PREFIX)");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.d("WXShareHelper", 1, "file == null || !file.exists()");
            return null;
        }
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            QLog.d("WXShareHelper", 1, "null == context");
            return null;
        }
        if (D()) {
            QLog.d("WXShareHelper", 1, "android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N");
            return null;
        }
        if (!E()) {
            QLog.d("WXShareHelper", 1, "api.getWXAppSupportAPI()=", Integer.valueOf(this.f327455f.getWXAppSupportAPI()), " < 0x27000D00");
            return null;
        }
        try {
            Uri uriForFile = FileProvider.getUriForFile(context, "com.tencent.mobileqq.fileprovider", file);
            context.grantUriPermission("com.tencent.mm", uriForFile, 1);
            return uriForFile;
        } catch (Exception e16) {
            QLog.e("WXShareHelper", 1, "getFileUri exception:", e16);
            return null;
        }
    }

    public static WXShareHelper b0() {
        return c0(false);
    }

    public static WXShareHelper c0(boolean z16) {
        if (K == null) {
            synchronized (J) {
                if (K == null) {
                    K = new WXShareHelper(z16);
                }
            }
        }
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(String str, String str2, byte[] bArr, String str3, String str4, String str5) {
        Q(this.C, str, str2, bArr, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Bitmap bitmap, final String str, final String str2, final String str3, final String str4, final String str5) {
        final byte[] B = B(J(bitmap, 1.25f));
        Y(new Runnable() { // from class: com.tencent.mobileqq.wxapi.d
            @Override // java.lang.Runnable
            public final void run() {
                WXShareHelper.this.h0(str, str2, B, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(String str, String str2, byte[] bArr, String str3, String str4, String str5) {
        Q(this.C, str, str2, bArr, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(Bitmap bitmap, final String str, final String str2, final String str3, final String str4, final String str5) {
        final byte[] B = B(bitmap);
        Y(new Runnable() { // from class: com.tencent.mobileqq.wxapi.g
            @Override // java.lang.Runnable
            public final void run() {
                WXShareHelper.this.j0(str, str2, B, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(String str, String str2, String str3, byte[] bArr, String str4, String str5, String str6) {
        Q(this.E.get(str), str2, str3, bArr, str4, str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(final String str, Bitmap bitmap, final String str2, final String str3, final String str4, final String str5, final String str6) {
        QLog.d("WXShareHelper", 1, "shareTargetMiniProgramToWX targetAppId ", str);
        if (!this.E.containsKey(str)) {
            QLog.d("WXShareHelper", 1, "shareTargetMiniProgramToWX createTargetWXAPI ", str);
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(BaseApplication.getContext(), str, true);
            createWXAPI.registerApp(str);
            this.E.put(str, createWXAPI);
        }
        final byte[] B = B(bitmap);
        Y(new Runnable() { // from class: com.tencent.mobileqq.wxapi.e
            @Override // java.lang.Runnable
            public final void run() {
                WXShareHelper.this.l0(str, str2, str3, B, str4, str5, str6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, String str2, byte[] bArr, String str3, String str4, String str5) {
        Q(this.D, str, str2, bArr, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(Bitmap bitmap, final String str, final String str2, final String str3, final String str4, final String str5) {
        final byte[] B = B(bitmap);
        Y(new Runnable() { // from class: com.tencent.mobileqq.wxapi.h
            @Override // java.lang.Runnable
            public final void run() {
                WXShareHelper.this.n0(str, str2, B, str3, str4, str5);
            }
        });
    }

    public void A(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.F) {
            if (!this.F.contains(aVar)) {
                this.F.add(aVar);
            }
        }
    }

    public void A0(String str, String str2, Bitmap bitmap, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, bitmap, str3, str4, Integer.valueOf(i3), str5);
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4, i3, str5) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ String C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327513d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327514e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327515f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327516h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327517i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f327518m;

                {
                    this.f327513d = str;
                    this.f327514e = str2;
                    this.f327515f = bitmap;
                    this.f327516h = str3;
                    this.f327517i = str4;
                    this.f327518m = i3;
                    this.C = str5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4, Integer.valueOf(i3), str5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.P(this.f327513d, this.f327514e, this.f327515f, this.f327516h, this.f327517i, this.f327518m, this.C);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void B0(final String str, final String str2, final Bitmap bitmap, final String str3, final String str4, final String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, str, str2, bitmap, str3, str4, str5);
            return;
        }
        if (bitmap == null) {
            QLog.e("WXShareHelper", 1, "doShareQQMiniProgramToWX: icon must not be null");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxapi.a
            @Override // java.lang.Runnable
            public final void run() {
                WXShareHelper.this.i0(bitmap, str, str2, str3, str4, str5);
            }
        }, 64, null, false);
    }

    public void C0(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4, i3) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.16
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327484d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327485e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327486f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327487h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327488i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f327489m;

                {
                    this.f327484d = str;
                    this.f327485e = str2;
                    this.f327486f = bitmap;
                    this.f327487h = str3;
                    this.f327488i = str4;
                    this.f327489m = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.R(this.f327484d, this.f327485e, this.f327486f, this.f327487h, this.f327488i, this.f327489m);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return true;
        }
        return false;
    }

    public void D0(String str, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, bArr, Integer.valueOf(i3));
        } else {
            Y(new Runnable(str, bArr, i3) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.14
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327481d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ byte[] f327482e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f327483f;

                {
                    this.f327481d = str;
                    this.f327482e = bArr;
                    this.f327483f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, bArr, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.S(this.f327481d, this.f327482e, this.f327483f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.f327455f.getWXAppSupportAPI() >= 654314752) {
            return true;
        }
        return false;
    }

    public void E0(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4, i3) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.13
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327475d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327476e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327477f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327478h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327479i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f327480m;

                {
                    this.f327475d = str;
                    this.f327476e = str2;
                    this.f327477f = bitmap;
                    this.f327478h = str3;
                    this.f327479i = str4;
                    this.f327480m = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.T(this.f327475d, this.f327476e, this.f327477f, this.f327478h, this.f327479i, this.f327480m);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void F0(final String str, final String str2, final Bitmap bitmap, final String str3, final String str4, final String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, str2, bitmap, str3, str4, str5);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxapi.b
                @Override // java.lang.Runnable
                public final void run() {
                    WXShareHelper.this.k0(bitmap, str, str2, str3, str4, str5);
                }
            }, 64, null, true);
        }
    }

    public void G0(final String str, final String str2, final String str3, final Bitmap bitmap, final String str4, final String str5, final String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, str2, str3, bitmap, str4, str5, str6);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxapi.c
                @Override // java.lang.Runnable
                public final void run() {
                    WXShareHelper.this.m0(str, bitmap, str2, str3, str4, str5, str6);
                }
            }, 64, null, false);
        }
    }

    public void H0(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(str));
        wXMediaMessage.description = str;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str2;
        req.message = wXMediaMessage;
        req.scene = i3;
        r0(this.f327455f, req);
    }

    public void I0(final String str, final String str2, final Bitmap bitmap, final String str3, final String str4, final String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, str, str2, bitmap, str3, str4, str5);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxapi.f
                @Override // java.lang.Runnable
                public final void run() {
                    WXShareHelper.this.o0(bitmap, str, str2, str3, str4, str5);
                }
            }, 64, null, false);
        }
    }

    public void J0(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, bitmap, str3, str4);
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327496d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327497e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327498f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327499h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327500i;

                {
                    this.f327496d = str;
                    this.f327497e = str2;
                    this.f327498f = bitmap;
                    this.f327499h = str3;
                    this.f327500i = str4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.U(this.f327496d, this.f327497e, this.f327498f, this.f327499h, this.f327500i);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void K0(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, bitmap, str3, str4);
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327491d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327492e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327493f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327494h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327495i;

                {
                    this.f327491d = str;
                    this.f327492e = str2;
                    this.f327493f = bitmap;
                    this.f327494h = str3;
                    this.f327495i = str4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.V(this.f327491d, this.f327492e, this.f327493f, this.f327494h, this.f327495i);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void L0(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4, i3) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327501d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327502e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327503f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327504h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327505i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f327506m;

                {
                    this.f327501d = str;
                    this.f327502e = str2;
                    this.f327503f = bitmap;
                    this.f327504h = str3;
                    this.f327505i = str4;
                    this.f327506m = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.X(this.f327501d, this.f327502e, this.f327503f, this.f327504h, this.f327505i, this.f327506m);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void M0(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, bitmap, str3, str4);
        } else {
            L0(str, str2, bitmap, str3, str4, 0);
        }
    }

    public void N0(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, bitmap, str3, str4);
        } else {
            L0(str, str2, bitmap, str3, str4, 1);
        }
    }

    public void Q(IWXAPI iwxapi, String str, String str2, byte[] bArr, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, iwxapi, str, str2, bArr, str3, str4, str5);
            return;
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = str5;
        wXMiniProgramObject.userName = str2;
        wXMiniProgramObject.path = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = str3;
        wXMediaMessage.description = str4;
        wXMediaMessage.thumbData = bArr;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = C("miniProgram");
        req.message = wXMediaMessage;
        req.scene = 0;
        QLog.d("WXShareHelper", 1, "doShareQQMiniProgramToWX:", iwxapi, APLogFileUtil.SEPARATOR_LOG, Boolean.valueOf(r0(iwxapi, req)), APLogFileUtil.SEPARATOR_LOG, str, "-", str2, "-", str5);
    }

    public IWXAPI Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IWXAPI) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f327455f;
    }

    public boolean d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.f327455f.getWXAppSupportAPI() > 654314752) {
            return true;
        }
        return false;
    }

    public boolean e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f327455f.isWXAppInstalled();
    }

    public boolean f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f327455f.getWXAppSupportAPI() >= 553779201) {
            return true;
        }
        return false;
    }

    public boolean g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f327455f.getWXAppSupportAPI() >= 553779201) {
            return true;
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WXShareHelper", 2, "onReceive:");
        }
        this.f327453d = context;
        this.f327455f.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) baseReq);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WXShareHelper", 2, "WXShareHelper.onReq:" + baseReq);
        }
        try {
            Map<String, String> c16 = com.tencent.mobileqq.service.qzone.f.c(((ShowMessageFromWX.Req) baseReq).message.messageExt);
            if (c16.get("actiontype") != null && c16.get("actiontype").equals(QZoneDTLoginReporter.SCHEMA) && c16.get(QZoneDTLoginReporter.SCHEMA) != null) {
                String decode = Uri.decode(c16.get(QZoneDTLoginReporter.SCHEMA));
                if (QLog.isColorLevel()) {
                    QLog.d("WXShareHelper", 2, "schemaInfo = " + decode);
                }
                if (!TextUtils.isEmpty(decode) && this.f327453d != null) {
                    this.f327453d.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(decode)));
                }
            }
        } catch (Exception e16) {
            QLog.e("WXShareHelper", 1, "onReq error.", e16);
        }
        this.f327453d = null;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) baseResp);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WXShareHelper", 2, "WXShareHelper.onResp:" + baseResp.errCode + " ,errStr:" + baseResp.errStr);
        }
        try {
            synchronized (this.F) {
                for (int size = this.F.size() - 1; size >= 0; size--) {
                    this.F.get(size).onWXShareResp(baseResp);
                }
            }
        } catch (Exception e16) {
            QLog.e("WXShareHelper", 1, "WXShareHelper.onResp error, ", e16);
        }
    }

    public void p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        IWXAPI iwxapi = this.f327455f;
        if (iwxapi != null) {
            iwxapi.registerApp("wxf0a80d0ac2e82aa7");
        }
        IWXAPI iwxapi2 = this.f327454e;
        if (iwxapi2 != null) {
            iwxapi2.registerApp("wxf14070172bb44e41");
        }
    }

    public void q0(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.F) {
            if (this.F.contains(aVar)) {
                this.F.remove(aVar);
            }
        }
    }

    public boolean r0(@NonNull IWXAPI iwxapi, @NonNull SendMessageToWX.Req req) {
        WXMediaMessage.IMediaObject iMediaObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iwxapi, (Object) req)).booleanValue();
        }
        if (!I) {
            QLog.d("WXShareHelper", 2, "sendReq by originApi:" + iwxapi);
            return iwxapi.sendReq(req);
        }
        WXMediaMessage wXMediaMessage = req.message;
        if (wXMediaMessage != null && (iMediaObject = wXMediaMessage.mediaObject) != null && !(iMediaObject instanceof WXMiniProgramObject)) {
            QLog.d("WXShareHelper", 2, "sendReq by common qq api:" + this.f327454e);
            return this.f327454e.sendReq(req);
        }
        QLog.d("WXShareHelper", 2, "sendReq by originApi:" + iwxapi);
        return iwxapi.sendReq(req);
    }

    public void s0(String str, Bitmap bitmap, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.dzx);
        } else {
            Y(new Runnable(str, bitmap, i3, i16, str2) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327524d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bitmap f327525e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f327526f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f327527h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327528i;

                {
                    this.f327524d = str;
                    this.f327525e = bitmap;
                    this.f327526f = i3;
                    this.f327527h = i16;
                    this.f327528i = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.K(this.f327524d, WXShareHelper.F(this.f327525e, this.f327526f), this.f327527h, this.f327528i);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void t0(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) bitmap);
        } else {
            Y(new Runnable(str, bitmap) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327461d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bitmap f327462e;

                {
                    this.f327461d = str;
                    this.f327462e = bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.L(this.f327461d, this.f327462e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void u0(String str, Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, bitmap, Integer.valueOf(i3));
        } else {
            w0(str, bitmap, i3, true);
        }
    }

    public void v0(String str, Bitmap bitmap, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.dzx);
        } else {
            Y(new Runnable(str, bitmap, i3, i16, str2) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327529d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bitmap f327530e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f327531f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f327532h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327533i;

                {
                    this.f327529d = str;
                    this.f327530e = bitmap;
                    this.f327531f = i3;
                    this.f327532h = i16;
                    this.f327533i = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.M(this.f327529d, WXShareHelper.F(this.f327530e, this.f327531f), this.f327532h, this.f327533i);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void w0(String str, Bitmap bitmap, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            x0(str, bitmap, i3, z16, null);
        }
    }

    public void x0(String str, Bitmap bitmap, int i3, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16), str2);
        } else if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.dzx);
        } else {
            Y(new Runnable(bitmap, z16, str, i3, str2) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f327519d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f327520e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f327521f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f327522h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327523i;

                {
                    this.f327519d = bitmap;
                    this.f327520e = z16;
                    this.f327521f = str;
                    this.f327522h = i3;
                    this.f327523i = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, bitmap, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        WXShareHelper.this.M(this.f327521f, WXShareHelper.G(this.f327519d, false, this.f327520e), this.f327522h, this.f327523i);
                    }
                }
            });
        }
    }

    public void y0(String str, String str2, Bitmap bitmap, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, str2, bitmap, str3, str4, str5);
        } else {
            Y(new Runnable(str, str2, bitmap, str3, str4, str5) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327463d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327464e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f327465f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f327466h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327467i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f327468m;

                {
                    this.f327463d = str;
                    this.f327464e = str2;
                    this.f327465f = bitmap;
                    this.f327466h = str3;
                    this.f327467i = str4;
                    this.f327468m = str5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, bitmap, str3, str4, str5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.N(this.f327463d, this.f327464e, this.f327465f, this.f327466h, this.f327467i, this.f327468m);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void z0(String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, str2, str3, bitmap, str4, str5, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            Y(new Runnable(str, str2, str3, bitmap, str4, str5, z16, i3) { // from class: com.tencent.mobileqq.wxapi.WXShareHelper.12
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean C;
                final /* synthetic */ int D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f327469d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f327470e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f327471f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bitmap f327472h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f327473i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f327474m;

                {
                    this.f327469d = str;
                    this.f327470e = str2;
                    this.f327471f = str3;
                    this.f327472h = bitmap;
                    this.f327473i = str4;
                    this.f327474m = str5;
                    this.C = z16;
                    this.D = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WXShareHelper.this, str, str2, str3, bitmap, str4, str5, Boolean.valueOf(z16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        WXShareHelper.this.O(this.f327469d, this.f327470e, this.f327471f, this.f327472h, this.f327473i, this.f327474m, this.C, this.D);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
