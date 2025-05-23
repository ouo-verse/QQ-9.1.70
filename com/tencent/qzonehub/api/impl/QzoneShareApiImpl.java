package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QzoneShareServlet;
import cooperation.qzone.share.WXShareFromQZHelper;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneShareApiImpl implements IQzoneShareApi {
    WXShareFromQZHelper helper = WXShareFromQZHelper.getInstance();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareImage$1(Context context, String str, byte[] bArr, int i3) {
        this.helper.shareImage(context, str, bArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareWebPage$0(String str, Bitmap bitmap, String str2, String str3, int i3) {
        this.helper.shareWebPage(str, bitmap, str2, str3, i3);
    }

    private void shareToQzone2(Context context, String str, QZoneShareData qZoneShareData, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IQzoneShareApi.TAG, 2, "shareToQzone()");
        }
        if (context != null && qZoneShareData != null) {
            dontShowContact();
            try {
                Intent intent = new Intent(context, (Class<?>) QZoneShareActivity.class);
                intent.putExtra("qzone_uin", str);
                intent.putExtra("extraIntentKeyParcelable", qZoneShareData);
                intent.putExtras(bundle);
                ((Activity) context).startActivityForResult(intent, i3);
                return;
            } catch (Exception unused) {
                Intent intent2 = new Intent(context, (Class<?>) QZoneShareActivity.class);
                intent2.putExtra("qzone_uin", str);
                intent2.putExtra("extraIntentKeyParcelable", qZoneShareData);
                intent2.addFlags(268435456);
                context.startActivity(intent2);
                return;
            }
        }
        QLog.e(IQzoneShareApi.TAG, 1, "shareToQzone() params error");
    }

    private void shareToQzoneForMiniApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9) {
        Intent intent = new Intent(context, (Class<?>) QZoneShareActivity.class);
        intent.putExtra(QZoneShareActivity.KEY_IS_SHARED_FROM_MINI_PROGRAM, true);
        intent.putExtra(QZoneShareActivity.KEY_IS_SHARED_FROM_THIRD_PARTY, true);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_APP_ID, str);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_TITLE, str2);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_DESCRIPTION, str3);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_SHARE_SCENE, 3);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_TEMPLATE_TYPE, 1);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_BUSINESS_TYPE, 0);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_PIC_URL, str4);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_ICON_URL, str5);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_JUMP_URL, str6);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_VERSION_TYPE, i3);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_APP_RICH_ID, str7);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_APP_PKG_NAME, str8);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_APP_OPEN_ID, str9);
        context.startActivity(intent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void addObserver(IQzoneShareApi.WXShareListener wXShareListener) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.addObserver(wXShareListener);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public String buildTransaction(String str) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return "";
        }
        return wXShareFromQZHelper.buildTransaction(str);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean checkAndroidNotBelowN() {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return false;
        }
        return wXShareFromQZHelper.checkAndroidNotBelowN();
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean checkVersionValid(Context context) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return false;
        }
        return wXShareFromQZHelper.checkVersionValid(context);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.handleWXEntryActivityIntent(activity, intent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean isWXinstalled() {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return false;
        }
        return wXShareFromQZHelper.isWXinstalled();
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean isWXsupportApi() {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return false;
        }
        return wXShareFromQZHelper.isWXsupportApi();
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean isWxSupportMiniProgramm() {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return false;
        }
        return wXShareFromQZHelper.isWxSupportMiniProgramm();
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean isWxSupportTimeLine() {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return false;
        }
        return wXShareFromQZHelper.isWxSupportTimeLine();
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void jmpWeixinDetail(Activity activity) {
        WXShareFromQZHelper.jmpWeixinDetail(activity);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean jumpToQzoneShare(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener) {
        return jumpToQzoneShare(appInterface, context, bundle, onDismissListener, -1);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void onReq(BaseReq baseReq) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.onReq(baseReq);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void onResp(BaseResp baseResp) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.onResp(baseResp);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void publishToQzone(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener) {
        publishToQzone(appInterface, context, bundle, onDismissListener, -1);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void publishToQzoneFromMiniApp(Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IQzoneShareApi.TAG, 2, "publishToQzone()");
        }
        if (bundle == null) {
            QLog.d(IQzoneShareApi.TAG, 1, "publishToQzone() params error");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("qzone_uin", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        intent.putExtras(bundle);
        QzonePluginProxyActivity.setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).dontShowContact();
        try {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
            QZoneHelper.forwardToFriendFeed((Activity) context, userInfo, intent, i3, onDismissListener);
        } catch (Exception unused) {
            Intent intent2 = new Intent(context, (Class<?>) TranslucentActivity.class);
            intent2.addFlags(268435456);
            intent2.putExtras(intent);
            context.startActivity(intent2);
        }
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void registerApp() {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.registerApp();
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void removeObserver(IQzoneShareApi.WXShareListener wXShareListener) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.removeObserver(wXShareListener);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareImage(final Context context, final String str, final byte[] bArr, final int i3) {
        if (this.helper == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.qzonehub.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                QzoneShareApiImpl.this.lambda$shareImage$1(context, str, bArr, i3);
            }
        });
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareMutilPicToWehat(Context context, ArrayList<File> arrayList) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.shareMutilPicToWehat(context, arrayList);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareQzoneForMini(Activity activity, String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, int i18, String str7, boolean z16, int i19) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
        intent.putExtra(QZoneShareActivity.KEY_IS_SHARED_FROM_MINI_PROGRAM, true);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_APP_ID, str);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_TITLE, str2);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_DESCRIPTION, str3);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_SHARE_SCENE, i3);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_TEMPLATE_TYPE, i16);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_BUSINESS_TYPE, i17);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_PIC_URL, str4);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_JUMP_URL, str5);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_ICON_URL, str6);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PARAM_VERSION_TYPE, i18);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_PRRAM_VERSION_ID, str7);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_APP_IS_FROM_INNER_BUTTON, z16);
        intent.putExtra(QZoneShareActivity.KEY_MINI_SHARE_SHARE_ORIGIN, i19);
        activity.startActivity(intent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareText(String str, int i3) {
        WXShareFromQZHelper wXShareFromQZHelper = this.helper;
        if (wXShareFromQZHelper == null) {
            return;
        }
        wXShareFromQZHelper.shareText(str, i3);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareToQzone(Context context, String str, QZoneShareData qZoneShareData, DialogInterface.OnDismissListener onDismissListener, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IQzoneShareApi.TAG, 2, "shareToQzone()");
        }
        if (context != null && qZoneShareData != null) {
            dontShowContact();
            try {
                Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QZoneShareActivity.class);
                intent.putExtra("qzone_uin", str);
                intent.putExtra("extraIntentKeyParcelable", qZoneShareData);
                ((Activity) context).startActivityForResult(intent, i3);
                return;
            } catch (Exception unused) {
                Intent intent2 = new Intent(BaseApplication.getContext(), (Class<?>) QZoneShareActivity.class);
                intent2.putExtra("qzone_uin", str);
                intent2.putExtra("extraIntentKeyParcelable", qZoneShareData);
                intent2.addFlags(268435456);
                context.startActivity(intent2);
                return;
            }
        }
        QLog.e(IQzoneShareApi.TAG, 1, "shareToQzone() params error");
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareToQzoneFromAskAnonymously(Context context, String str, QZoneShareData qZoneShareData, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IQzoneShareApi.TAG, 2, "shareToQzone()");
        }
        if (context != null && qZoneShareData != null) {
            dontShowContact();
            Intent intent = new Intent(context, (Class<?>) QZoneShareActivity.class);
            intent.putExtra("qzone_uin", str);
            intent.putExtra(QZoneShareActivity.KEY_IS_SHARED_FROM_ASK_ANONYMOUSLY, true);
            intent.putExtra(QZoneShareActivity.KEY_ASK_ANONYMOUSLY_SHARE_TYPE, i3);
            intent.putExtra("extraIntentKeyParcelable", qZoneShareData);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        QLog.e(IQzoneShareApi.TAG, 1, "shareToQzone() params error");
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareWebPage(final String str, final Bitmap bitmap, final String str2, final String str3, final int i3) {
        if (this.helper == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.qzonehub.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                QzoneShareApiImpl.this.lambda$shareWebPage$0(str, bitmap, str2, str3, i3);
            }
        });
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void startShareServlet(Context context, String str, long j3, QZoneShareData qZoneShareData) {
        NewIntent newIntent = new NewIntent(context, QzoneShareServlet.class);
        newIntent.putExtra("reason", str);
        newIntent.putExtra("uin", j3);
        newIntent.putExtra("sharedata", qZoneShareData);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareMiniProgram$2(String str, Bitmap bitmap, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.helper.shareMiniProgram(str, bitmap, str2, str3, str4, str5, str6, i3);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean jumpToQzoneShare(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        return jumpToQzoneShare(appInterface.getCurrentAccountUin(), context, bundle, onDismissListener, i3);
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void publishToQzone(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IQzoneShareApi.TAG, 2, "publishToQzone()");
        }
        if (bundle != null && appInterface != null) {
            Intent intent = new Intent();
            intent.putExtra("qzone_uin", appInterface.getAccount());
            intent.putExtra(QZoneShareManager.KEY_IS_THIRDPARTYSHARE, true);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("images");
            String name = (stringArrayList == null || stringArrayList.size() <= 9) ? ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName() : QZoneHelper.UPLOAD_PHOTO;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.getIntent() != null) {
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME, activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME));
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE));
                }
            }
            String string = bundle.getString(QZoneShareManager.QZONE_SHARE_HULIAN_APPID);
            String string2 = bundle.getString("file_send_path");
            String string3 = bundle.getString("shareSource");
            if (!QZoneShareManager.isQzoneShareWhite(string) && !QZoneShareManager.isShareFromQCircle(string3) && ((stringArrayList != null && stringArrayList.size() > 0) || !TextUtils.isEmpty(string2))) {
                bundle.putString("summary", "");
                bundle.putString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "");
            }
            if (!TextUtils.isEmpty(string)) {
                if (!TextUtils.isEmpty(string2)) {
                    bundle.putInt(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE, 207);
                    bundle.putString("refer", string);
                } else if (stringArrayList != null && stringArrayList.size() > 0) {
                    bundle.putInt(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE, 45);
                    bundle.putString("refer", string);
                }
            }
            intent.putExtras(bundle);
            QzonePluginProxyActivity.setActivityNameToIntent(intent, name);
            intent.putExtra(QZoneShareManager.KEY_IS_THIRDPARTYSHARE, true);
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).dontShowContact();
            try {
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = appInterface.getCurrentAccountUin();
                QZoneHelper.forwardToFriendFeed((Activity) context, userInfo, intent, i3, onDismissListener);
                return;
            } catch (Exception unused) {
                Intent intent2 = new Intent(context, (Class<?>) TranslucentActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtras(intent);
                context.startActivity(intent2);
                return;
            }
        }
        QLog.d(IQzoneShareApi.TAG, 1, "publishToQzone() params error");
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void shareMiniProgram(final String str, final Bitmap bitmap, final String str2, final String str3, final String str4, final String str5, final String str6, final int i3) {
        if (this.helper == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.qzonehub.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                QzoneShareApiImpl.this.lambda$shareMiniProgram$2(str, bitmap, str2, str3, str4, str5, str6, i3);
            }
        });
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public boolean jumpToQzoneShare(String str, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && !bundle.getBoolean(AppConstants.Key.IS_SHARE_MINI_PROGRAM_MSG)) {
            Intent intent = new Intent();
            intent.putExtra("qzone_uin", str);
            intent.putExtra(QZoneShareManager.KEY_IS_THIRDPARTYSHARE, true);
            intent.putExtra(QZoneShareManager.KEY_SAHRE_DATA, bundle);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.FRIEND_FEED);
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).dontShowContact();
            try {
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = str;
                QZoneHelper.forwardToFriendFeed((Activity) context, userInfo, intent, i3, onDismissListener);
            } catch (Exception unused) {
                Intent intent2 = new Intent(context, (Class<?>) TranslucentActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtras(intent);
                context.startActivity(intent2);
            }
            return true;
        }
        QZoneShareManager.checkQzoneShareParams(bundle);
        String string3 = bundle.getString("open_id");
        String string4 = bundle.getString("pkg_name");
        if (bundle.getBoolean(AppConstants.Key.IS_SHARE_MINI_PROGRAM_MSG)) {
            String string5 = bundle.getString("title");
            String string6 = bundle.getString("desc");
            shareToQzoneForMiniApp(context, bundle.getString(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_APP_ID), string5, string6, bundle.getString(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_IMAGE_URL), null, bundle.getString(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_APP_PATH), bundle.getInt(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_VER_TYPE), String.valueOf(bundle.getLong("req_share_id", -1L)), string4, string3);
            return true;
        }
        OpenSdkShareModel openSdkShareModel = (OpenSdkShareModel) bundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ");
        if (openSdkShareModel != null) {
            shareToQzoneForMiniApp(context, openSdkShareModel.miniAppAppid, openSdkShareModel.title, openSdkShareModel.desc, openSdkShareModel.imageUrl, openSdkShareModel.iconUrl, openSdkShareModel.miniAppPath, 3, openSdkShareModel.appRichId, string4, string3);
            return true;
        }
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = bundle.getString("title");
        qZoneShareData.mSummary = bundle.getString("desc");
        qZoneShareData.mImageUrls = bundle.getStringArrayList("image_url");
        qZoneShareData.extString = bundle.getString(AppConstants.Key.SHARE_REQ_EXT_STR);
        qZoneShareData.appid = bundle.getLong("req_share_id");
        qZoneShareData.openId = bundle.getString("open_id");
        qZoneShareData.appName = bundle.getString("app_name");
        qZoneShareData.targetUrl = bundle.getString("detail_url");
        qZoneShareData.iUrlInfoFrm = bundle.getInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, -1);
        qZoneShareData.mShareBeginTime = bundle.getLong(AppConstants.Key.SHARE_BEGIN_TIME, 0L);
        SerializableMap serializableMap = (SerializableMap) bundle.getSerializable("share_qzone_info");
        if (serializableMap != null) {
            qZoneShareData.qzoneShareInfo = serializableMap.getMap();
        }
        if (bundle.getBoolean(AppConstants.Key.SHARE_REQ_THIRDPART)) {
            qZoneShareData.from = 1;
        } else if (bundle.getBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB)) {
            qZoneShareData.from = 2;
        } else {
            qZoneShareData.from = 0;
        }
        qZoneShareData.action = bundle.getString(QZoneShareManager.QZONE_SHARE_ACTION);
        qZoneShareData.jFrom = bundle.getString(AppConstants.Key.SHARE_REQ_SHARE_JFROM);
        qZoneShareData.pkgname = bundle.getString("pkg_name");
        qZoneShareData.shareUin = bundle.getString("share_uin");
        qZoneShareData.mWebUrl = bundle.getString(AppConstants.Key.SHARE_REQ_CURURL);
        qZoneShareData.mDefaultForwardReason = bundle.getString(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        shareToQzone2(context, str, qZoneShareData, bundle, i3);
        return true;
    }

    @Override // com.tencent.qzonehub.api.IQzoneShareApi
    public void dontShowContact() {
    }
}
