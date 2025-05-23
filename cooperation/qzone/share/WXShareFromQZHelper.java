package cooperation.qzone.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.qzone.f;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class WXShareFromQZHelper {
    public static String TAG = "WXShareFromQZHelper";
    private static byte[] lock = new byte[0];
    private static WXShareFromQZHelper sWXShareHelper;
    private CopyOnWriteArrayList<IQzoneShareApi.WXShareListener> mObserverList = new CopyOnWriteArrayList<>();
    private IWXAPIEventHandler handler = new IWXAPIEventHandler() { // from class: cooperation.qzone.share.WXShareFromQZHelper.1
        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
            WeakReference<Activity> weakReference = WXShareFromQZHelper.this.wxEntryActivityRef;
            WXShareFromQZHelper.doParseApp(weakReference != null ? weakReference.get() : null, baseReq);
        }

        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onResp(BaseResp baseResp) {
            synchronized (WXShareFromQZHelper.this.mObserverList) {
                Iterator it = WXShareFromQZHelper.this.mObserverList.iterator();
                while (it.hasNext()) {
                    ((IQzoneShareApi.WXShareListener) it.next()).onWXShareResp(baseResp);
                }
            }
        }
    };
    WeakReference<Activity> wxEntryActivityRef = null;
    private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx34b037fdb0f655ee", true);

    WXShareFromQZHelper() {
        registerApp();
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void doParseApp(Activity activity, BaseReq baseReq) {
        if (activity == null || baseReq == null) {
            return;
        }
        try {
            String str = ((ShowMessageFromWX.Req) baseReq).message.messageExt;
            Map<String, String> c16 = f.c(str);
            if (c16.get("actiontype") != null && c16.get("actiontype").equals(QZoneDTLoginReporter.SCHEMA) && c16.get(QZoneDTLoginReporter.SCHEMA) != null) {
                String decode = Uri.decode(c16.get(QZoneDTLoginReporter.SCHEMA));
                if (TextUtils.isEmpty(decode)) {
                    return;
                }
                if (decode.startsWith("mqzone") || decode.startsWith("mqqzone") || decode.startsWith("mqqapi://qzoneschema")) {
                    Intent intent = new Intent();
                    intent.putExtra("cmd", "Schema");
                    intent.putExtra(QZoneDTLoginReporter.SCHEMA, decode);
                    QZoneHelper.forwardToQzoneTransluentActivity(activity, QZoneHelper.UserInfo.getInstance(), intent);
                    String str2 = c16.get("appid");
                    new LpReportInfo_pf00064(2000, 3000, str2 == null ? 0 : Integer.parseInt(str2)).reportImediately();
                    return;
                }
                return;
            }
            if (c16.get("appid") == null || !c16.get("appid").equals("1000398")) {
                return;
            }
            if (c16.containsKey("albumId") || c16.containsKey("aid")) {
                Intent intent2 = new Intent();
                intent2.putExtra("cmd", "Schema");
                if ("1".equals(c16.get("pagetype"))) {
                    intent2.putExtra(QZoneDTLoginReporter.SCHEMA, "mqzone://arouse/album?" + str.replace("aid", "albumid") + "&source=doNotJumpQzone");
                } else if ("0".equals(c16.get("pagetype"))) {
                    intent2.putExtra(QZoneDTLoginReporter.SCHEMA, "mqzone://arouse/photofromwxapp?" + str + "&source=doNotJumpQzone");
                }
                QZoneHelper.forwardToQzoneTransluentActivity(activity, QZoneHelper.UserInfo.getInstance(), intent2);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static WXShareFromQZHelper getInstance() {
        if (sWXShareHelper == null) {
            synchronized (lock) {
                if (sWXShareHelper == null) {
                    sWXShareHelper = new WXShareFromQZHelper();
                }
            }
        }
        return sWXShareHelper;
    }

    public void addObserver(IQzoneShareApi.WXShareListener wXShareListener) {
        synchronized (this.mObserverList) {
            if (!this.mObserverList.contains(wXShareListener)) {
                this.mObserverList.add(wXShareListener);
            }
        }
    }

    public boolean checkAndroidNotBelowN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public boolean checkVersionValid(Context context) {
        return this.api.getWXAppSupportAPI() >= 654314752;
    }

    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        if (this.api != null) {
            this.wxEntryActivityRef = new WeakReference<>(activity);
            this.api.handleIntent(intent, this.handler);
        }
    }

    public boolean isWXinstalled() {
        try {
            return this.api.isWXAppInstalled();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isWXinstalled error ", th5);
            return false;
        }
    }

    @Deprecated
    public boolean isWXsupportApi() {
        return this.api.getWXAppSupportAPI() >= 553779201;
    }

    public boolean isWxSupportMiniProgramm() {
        return this.api.getWXAppSupportAPI() >= 620756993;
    }

    public boolean isWxSupportTimeLine() {
        return this.api.getWXAppSupportAPI() >= 553779201;
    }

    public void onReq(BaseReq baseReq) {
        WeakReference<Activity> weakReference = this.wxEntryActivityRef;
        doParseApp(weakReference != null ? weakReference.get() : null, baseReq);
    }

    public void onResp(BaseResp baseResp) {
        synchronized (this.mObserverList) {
            Iterator<IQzoneShareApi.WXShareListener> it = this.mObserverList.iterator();
            while (it.hasNext()) {
                it.next().onWXShareResp(baseResp);
            }
        }
    }

    public void registerApp() {
        try {
            this.api.registerApp("wx34b037fdb0f655ee");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public void removeObserver(IQzoneShareApi.WXShareListener wXShareListener) {
        synchronized (this.mObserverList) {
            if (this.mObserverList.contains(wXShareListener)) {
                this.mObserverList.remove(wXShareListener);
            }
        }
    }

    public void shareImage(Context context, String str, byte[] bArr, int i3) {
        if (!str.contains(AppConstants.SDCARD_PATH + "photo/")) {
            String str2 = System.currentTimeMillis() + ".jpeg";
            StringBuilder sb5 = new StringBuilder();
            String str3 = IQzoneShareApi.PHOTO_PATH;
            sb5.append(str3);
            sb5.append(str2);
            String sb6 = sb5.toString();
            try {
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                copyFileUsingFileChannels(new File(str), new File(sb6));
                str = sb6;
            } catch (Throwable th5) {
                QZLog.e(TAG, "shareImage exception:", th5);
                return;
            }
        }
        WXImageObject wXImageObject = new WXImageObject();
        if (checkVersionValid(context) && checkAndroidNotBelowN()) {
            QZLog.d(TAG, 1, "shareImage... use getFileUri");
            Uri fileUri = getFileUri(context, new File(str));
            if (fileUri == null) {
                QLog.e(TAG, 1, "uri is invalid");
                return;
            }
            wXImageObject.imagePath = fileUri.toString();
        } else {
            QZLog.d(TAG, 1, "shareImage... use old path");
            wXImageObject.imagePath = str;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i3 == 0) {
            wXMediaMessage.thumbData = bArr;
            if (bArr == null || (bArr != null && bArr.length > 32768)) {
                QLog.e(TAG, 1, "wxmsg.thumbData is invalid");
            }
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = wXMediaMessage;
        req.scene = i3;
        if (WXShareHelper.b0().r0(this.api, req)) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.WXShareFromQZHelper.3
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
            }
        });
    }

    public void shareMiniProgram(String str, Bitmap bitmap, String str2, String str3, String str4, String str5, String str6, int i3) {
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = str3;
        wXMiniProgramObject.userName = str5;
        if (!TextUtils.isEmpty(str6)) {
            wXMiniProgramObject.path = str4 + "&sk=" + str6;
        } else {
            wXMiniProgramObject.path = str4;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        try {
            if (bitmap != null) {
                float min = Math.min(400.0f / bitmap.getWidth(), 400.0f / bitmap.getHeight());
                Matrix matrix = new Matrix();
                matrix.postScale(min, min);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                int i16 = 100;
                wXMediaMessage.thumbData = Bitmap2Bytes(createBitmap, 100);
                QZLog.e(TAG, "wxshare thumbData:" + wXMediaMessage.thumbData.length);
                int i17 = 4;
                while (true) {
                    byte[] bArr = wXMediaMessage.thumbData;
                    if (bArr == null || bArr.length < 131072 || i17 - 1 <= 0) {
                        break;
                    }
                    i16 -= 10;
                    wXMediaMessage.thumbData = Bitmap2Bytes(createBitmap, i16);
                    QZLog.e(TAG, "wxshare thumbData -- :" + wXMediaMessage.thumbData.length);
                }
                createBitmap.recycle();
            } else {
                QZLog.e(TAG, "wxshare bmp null");
            }
        } catch (Throwable th5) {
            QZLog.e(TAG, "excetion:" + th5.getMessage());
            ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.WXShareFromQZHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
                }
            });
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = wXMediaMessage;
        req.scene = i3;
        boolean r06 = WXShareHelper.b0().r0(this.api, req);
        if (r06) {
            return;
        }
        QZLog.e(TAG, "wxshare failed ,ret:" + r06);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.WXShareFromQZHelper.6
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
            }
        });
    }

    public void shareMutilPicToWehat(Context context, ArrayList<File> arrayList) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        intent.setFlags(268435456);
        intent.setType("image/*");
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        Iterator<File> it = arrayList.iterator();
        while (it.hasNext()) {
            Uri fileUri = getFileUri(context, it.next());
            if (fileUri != null) {
                arrayList2.add(fileUri);
            }
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
        FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getApplication(), intent);
        context.startActivity(intent);
    }

    public void shareText(String str, int i3) {
        WXTextObject wXTextObject = new WXTextObject(str);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("text");
        req.message = wXMediaMessage;
        req.scene = i3;
        if (WXShareHelper.b0().r0(this.api, req)) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.WXShareFromQZHelper.4
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
            }
        });
    }

    public void shareWebPage(String str, Bitmap bitmap, String str2, String str3, int i3) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(str3));
        wXMediaMessage.description = str2;
        wXMediaMessage.title = str;
        wXMediaMessage.thumbData = WXShareHelper.G(bitmap, false, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = wXMediaMessage;
        req.scene = i3;
        if (WXShareHelper.b0().r0(this.api, req)) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.WXShareFromQZHelper.2
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), R.string.gjn, 0).show();
            }
        });
    }

    private static void copyFileUsingFileChannels(File file, File file2) throws IOException {
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

    public static void jmpWeixinDetail(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_WEIXIN_DOWNLOAD, IQzoneShareApi.QZONE_WEIXINDOWNLOAD));
            intent.putExtra("fromQZone", true);
            intent.addFlags(268435456);
            activity.startActivity(intent);
        }
    }

    public String buildTransaction(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public static Uri getFileUri(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                Uri uriForFile = FileProvider.getUriForFile(context, "com.tencent.mobileqq.fileprovider", file);
                context.grantUriPermission("com.tencent.mm", uriForFile, 1);
                return uriForFile;
            } catch (Exception e16) {
                QZLog.e(TAG, "getFileUri exception:", e16);
            }
        }
        return null;
    }
}
