package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WxShareHelperFromReadInjoy extends BroadcastReceiver implements IWXAPIEventHandler, IWxShareHelperFromReadInjoy {
    private static final String APP_ID = "wxeaef4303c20f3dea";
    private static final int LAUNCH_WX_PENDING_INTENT_REQUEST_CODE = 1;
    private static final String TAG = "WxShareHelperFromReadInjoy";
    private static final int TIME_GAP = 300;
    public static final int WX_IMAGE_THUMB_IMAGE_WIDTH = 100;
    private static byte[] lock = new byte[0];
    private static WxShareHelperFromReadInjoy sWXShareHelper;
    private IWXAPI api;
    private Boolean isInstallWechat;
    private int mWXAppSupportAPI;
    private ArrayList<IWxShareHelperFromReadInjoy.a> mObserverList = new ArrayList<>(1);
    private String mWXJumpUrlLastTime = "";
    private Long mWXJumpUrlLastTimeTime = 0L;
    private WeakReference<Activity> mWxEntryActivityRef = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements WXShareHelper.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            boolean z16 = baseResp.errCode == 0;
            WXShareHelper.b0().q0(this);
            x62.a.f447299a.c(z16);
        }
    }

    WxShareHelperFromReadInjoy() {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), APP_ID, true);
        this.api = createWXAPI;
        this.mWXAppSupportAPI = createWXAPI.getWXAppSupportAPI();
        BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
        registerApp();
    }

    public static WxShareHelperFromReadInjoy getInstance() {
        if (sWXShareHelper == null) {
            synchronized (lock) {
                if (sWXShareHelper == null) {
                    sWXShareHelper = new WxShareHelperFromReadInjoy();
                }
            }
        }
        return sWXShareHelper;
    }

    private boolean getSwitchValueByKey(String str) {
        SharedPreferences b16 = com.tencent.mobileqq.kandian.base.utils.c.b(BaseApplicationImpl.getApplication().getRuntime(), true, false);
        if (b16 != null) {
            return b16.getBoolean(str, false);
        }
        return false;
    }

    private void handleWXStartReport(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "handleWXStartReport error, url is empty ");
            return;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("from_source");
        String queryParameter2 = parse.getQueryParameter("from_rowkey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleWXStartReport fromSource = " + queryParameter + " fromRowkey = " + queryParameter2);
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from_source", queryParameter);
            jSONObject.put("from_rowkey", queryParameter2);
            PublicAccountReportUtils.n(null, "CliOper", "", "", "0X800A7BF", "0X800A7BF", 0, 0, "", "", "", jSONObject.toString(), false);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendReq(SendMessageToWX.Req req) {
        WXShareHelper.b0().A(new a());
        return WXShareHelper.b0().r0(this.api, req);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void addObserver(IWxShareHelperFromReadInjoy.a aVar) {
        synchronized (this.mObserverList) {
            if (!this.mObserverList.contains(aVar)) {
                this.mObserverList.add(aVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleWXEntryActivityIntent");
        }
        if (this.api != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleWXEntryActivityIntent api != null");
            }
            this.mWxEntryActivityRef = new WeakReference<>(activity);
            this.api.handleIntent(intent, this);
        }
    }

    public boolean isWXinstalled() {
        return this.api.isWXAppInstalled();
    }

    public boolean isWXsupportApi() {
        return this.api.getWXAppSupportAPI() >= 553779201;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.api.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "WXShareHelper.onReq:" + baseReq.getType());
        }
        WeakReference<Activity> weakReference = this.mWxEntryActivityRef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity == null) {
            QLog.e(TAG, 2, "WXShareHelper.onReq:" + baseReq.getType() + " activity == null.");
            return;
        }
        if (baseReq.getType() == 4 && (baseReq instanceof ShowMessageFromWX.Req)) {
            String str = ((ShowMessageFromWX.Req) baseReq).message.messageExt;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "WXShareHelper.onReq: url = " + str);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!str.equals(this.mWXJumpUrlLastTime) || valueOf.longValue() - this.mWXJumpUrlLastTimeTime.longValue() >= 300) {
                Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
                handleWXStartReport(str);
                this.mWXJumpUrlLastTime = str;
                this.mWXJumpUrlLastTimeTime = valueOf;
            }
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "WXShareHelper.onResp:" + baseResp.errCode + " ,errStr:" + baseResp.errStr);
        }
        try {
            synchronized (this.mObserverList) {
                for (int size = this.mObserverList.size() - 1; size >= 0; size--) {
                    this.mObserverList.get(size).onWXShareResp(baseResp);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "WXShareHelper.onResp error, ", e16);
        }
    }

    public void registerApp() {
        this.api.registerApp(APP_ID);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void removeObserver(IWxShareHelperFromReadInjoy.a aVar) {
        synchronized (this.mObserverList) {
            this.mObserverList.remove(aVar);
        }
    }

    public void shareImageToWX(String str, Bitmap bitmap, int i3) {
        shareImageToWX(str, bitmap, i3, true);
    }

    public void shareMiniProgram(String str, String str2, Bitmap bitmap, String str3, String str4, String str5) {
        shareToMiniProgramWithPath(str, str2, bitmap, str3, str4, "/pages/index/index?share=1&share_type=2&channel_id=10&rowkey=" + str5 + "&title=" + URLEncoder.encode(str2) + "&timeTips=" + new SimpleDateFormat("MM-dd").format(new Date()));
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareToMiniProgramWithPath(String str, String str2, Bitmap bitmap, String str3, String str4, String str5) {
        shareToMiniProgramWithPathAndId(str, str2, bitmap, str3, str4, str5, "gh_eaa1f0b1626b");
    }

    public void shareToMiniProgramWithPathAndId(final String str, final String str2, final Bitmap bitmap, final String str3, final String str4, final String str5, final String str6) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap o16;
                WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
                wXMiniProgramObject.withShareTicket = true;
                wXMiniProgramObject.webpageUrl = str4;
                wXMiniProgramObject.userName = str6;
                wXMiniProgramObject.path = str5;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
                wXMediaMessage.title = str2;
                wXMediaMessage.description = str3;
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    int min = Math.min(bitmap2.getWidth() / 5, bitmap.getHeight() / 4);
                    int i3 = min * 5;
                    int i16 = min * 4;
                    if (str5.startsWith("/pages/index/index?share=1&share_type=1")) {
                        o16 = com.tencent.biz.qqstory.utils.b.k(com.tencent.biz.qqstory.utils.b.o(bitmap, i3, i16, false, true), BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), R.drawable.d89), true);
                    } else {
                        o16 = com.tencent.biz.qqstory.utils.b.o(bitmap, i3, i16, false, true);
                    }
                    if (o16 != null) {
                        int width = o16.getWidth();
                        int height = o16.getHeight();
                        if (o16.getByteCount() > 128000) {
                            Bitmap copy = o16.copy(Bitmap.Config.RGB_565, true);
                            double sqrt = Math.sqrt(64000.0d / (width * height));
                            o16 = Bitmap.createScaledBitmap(copy, (int) (width * sqrt), (int) (height * sqrt), true);
                        }
                        wXMediaMessage.thumbData = WxShareHelperFromReadInjoy.bitmap2Bytes(o16);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e(WxShareHelperFromReadInjoy.TAG, 2, "shareToMiniProgramWithPathAndId, error icon == null! title" + str2 + ", description = " + str3 + ", path = " + str5 + ", webPageUrl = " + str4 + ", id = " + str6);
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = str;
                req.message = wXMediaMessage;
                req.scene = 0;
                WxShareHelperFromReadInjoy.this.sendReq(req);
            }
        }, 16, null, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shareToMiniProgramWithPathAndId, title = " + str2 + ", description = " + str3 + ", path = " + str5 + ", webPageUrl = " + str4 + ", id = " + str6);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareVideo(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
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
        boolean sendReq = sendReq(req);
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
            sb5.append(sendReq);
            QLog.i(TAG, 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareVideoMiniProgram(String str, String str2, Bitmap bitmap, String str3, String str4, String str5) {
        shareToMiniProgramWithPath(str, str2, bitmap, str3, str4, "/pages/index/index?share=1&share_type=1&channel_id=10&rowkey=" + str5);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareWebPage(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        String str5;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str4));
        wXMediaMessage.description = str3;
        wXMediaMessage.title = str2;
        wXMediaMessage.setThumbImage(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = i3;
        boolean sendReq = sendReq(req);
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
            sb5.append(sendReq);
            QLog.i(TAG, 2, sb5.toString());
        }
    }

    public void unRegisterApp() {
        this.api.unregisterApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        if (bitmap == null) {
            QLog.e(TAG, 1, "[bitmap2Bytes] bitmap is null.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        while (byteArray.length >= 131072 && i3 > 0) {
            i3 -= 10;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream2);
            byteArray = byteArrayOutputStream2.toByteArray();
        }
        QLog.i(TAG, 1, "[bitmap2Bytes] length = " + byteArray.length + ", quality = " + i3);
        return byteArray;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareImageToWX(String str, Bitmap bitmap, int i3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            h.T(1, R.string.dzx);
            return;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.imagePath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        byte[] compressToBytesForWX = compressToBytesForWX(bitmap, false, z16);
        wXMediaMessage.thumbData = compressToBytesForWX;
        if ((compressToBytesForWX == null || (compressToBytesForWX != null && compressToBytesForWX.length > 32768)) && QLog.isColorLevel()) {
            QLog.i(TAG, 2, "wxmsg.thumbData is invalid");
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.scene = i3;
        sendReq(req);
    }

    public static byte[] compressToBytesForWX(Bitmap bitmap, boolean z16, boolean z17) {
        byte[] a16;
        if (bitmap == null) {
            return null;
        }
        float max = Math.max(100.0f / bitmap.getWidth(), 100.0f / bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z17) {
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 100, 100);
            a16 = com.tencent.biz.common.util.e.a(createBitmap2);
            createBitmap2.recycle();
        } else {
            a16 = com.tencent.biz.common.util.e.a(createBitmap);
        }
        createBitmap.recycle();
        if (z16) {
            bitmap.recycle();
        }
        return a16;
    }

    public void shareImageToWX(String str, Bitmap bitmap, int i3, boolean z16, String str2) {
        if (TextUtils.isEmpty(str)) {
            h.T(1, R.string.dzx);
            return;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.imagePath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        byte[] compressToBytesForWX = compressToBytesForWX(bitmap, false, z16);
        wXMediaMessage.thumbData = compressToBytesForWX;
        if ((compressToBytesForWX == null || (compressToBytesForWX != null && compressToBytesForWX.length > 32768)) && QLog.isColorLevel()) {
            QLog.i(TAG, 2, "wxmsg.thumbData is invalid");
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = str2;
        req.message = wXMediaMessage;
        req.scene = i3;
        sendReq(req);
    }
}
