package com.tencent.mobileqq.qwallet.utils.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ArkPubicEventWrapImpl extends Observable implements IArkPubicEventWrap {
    public static final String APP_EVENT_CALLBACK_GET_DSL_CONTENT = "gc_ark_get_dsl_content_callback";
    public static final String APP_EVENT_CALLBACK_GET_VIEW_LOCATION = "get_view_location_callback";
    public static final String APP_POST_MUTE = "ad_query_mute_callback";
    public static final String APP_POST_PACKAGE = "event_query_package_callback";
    public static final String ARK_BEACON_REPORT = "beacon_report";
    public static final String ARK_FULL_SCREEN_PLAY = "event_fullscreen_play";
    public static final String ARK_GET_DSL_CONTENT = "gc_ark_get_dsl_content";
    public static final String ARK_GET_VIEW_LOCATION = "get_view_location";
    public static final String ARK_OPEN_HIPPY = "gc_ark_open_hippy";
    public static final String ARK_QUERY_MUTE = "ad_query_mute";
    public static final String ARK_QUERY_PACKAGE = "event_query_package";
    public static final String ARK_REVERSE_FEEDBACK = "gc_ark_msg_delete";
    private static final String TAG = "ArkPubicEventWrap";
    private static a receiver;
    private List<String> volumnArkAppNameList = new ArrayList();

    /* loaded from: classes16.dex */
    private static class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (QLog.isColorLevel()) {
                QLog.i(ArkPubicEventWrapImpl.TAG, 2, "--VolumeReceiver---" + intent.getAction());
            }
            ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).callbackMuteStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arkNotify(String str, String str2, String str3, String str4) {
        try {
            ark.arkNotify(str, "", str2, str3, str4);
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "load ark.so error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackMuteStatus(String str) {
        try {
            try {
                boolean z16 = ((AudioManager) BaseApplication.getContext().getApplicationContext().getSystemService("audio")).getRingerMode() != 2;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_muted", z16);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "ad_query_mute: " + jSONObject.toString());
                }
                arkNotify(str, APP_POST_MUTE, jSONObject.toString(), ark.ARKMETADATA_JSON);
            } catch (Throwable unused) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("is_muted", false);
                arkNotify(str, APP_POST_MUTE, jSONObject2.toString(), ark.ARKMETADATA_JSON);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public static Rect getVisibilityRect(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewLocation(String str, String str2) {
        ArkPubicEventWrapImpl arkPubicEventWrapImpl;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Class<IQWalletTemp> cls;
        View view;
        Class<IQWalletTemp> cls2 = IQWalletTemp.class;
        JSONObject jSONObject = new JSONObject();
        try {
            if (StringUtil.isEmpty(str2)) {
                return;
            }
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            View chatXListViewFromChatFragment = ((IQWalletTemp) QRoute.api(cls2)).getChatXListViewFromChatFragment(qBaseActivity);
            try {
                if (chatXListViewFromChatFragment != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    jSONObject.put(ForwardMiniChooseFriendOption.RESULT_LIST, jSONArray3);
                    float h16 = x.h(qBaseActivity, ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ));
                    float dimension = qBaseActivity.getResources().getDimension(R.dimen.title_bar_height);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("width", x.h(qBaseActivity, ImmersiveUtils.getScreenWidth()));
                    jSONObject2.put("height", x.h(qBaseActivity, h16 + dimension));
                    jSONObject2.put(HippyTKDListViewAdapter.X, 0);
                    jSONObject2.put("y", 0);
                    jSONObject.put("navigationBarRect", jSONObject2);
                    JSONArray optJSONArray = new JSONObject(str2).optJSONArray("arkViewIDs");
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        String optString = optJSONArray.optString(i3);
                        ChatMessage messageByMID = ((IQWalletTemp) QRoute.api(cls2)).getMessageByMID(optString);
                        if (messageByMID == null) {
                            cls = cls2;
                            jSONArray = optJSONArray;
                            view = chatXListViewFromChatFragment;
                            jSONArray2 = jSONArray3;
                        } else {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONArray3.mo162put(jSONObject3);
                            jSONArray = optJSONArray;
                            JSONObject jSONObject4 = new JSONObject();
                            jSONArray2 = jSONArray3;
                            jSONObject3.put(PTSNodeAttributeConstant.VIEW_ID, optString);
                            jSONObject3.put(CanvasView.ACTION_RECT, jSONObject4);
                            View viewByPosition = ((IQWalletTemp) QRoute.api(cls2)).getViewByPosition(chatXListViewFromChatFragment, messageByMID);
                            if (viewByPosition != null) {
                                View findViewById = viewByPosition.findViewById(R.id.y_);
                                if (findViewById != null) {
                                    if (getVisibilityRect(findViewById) != null) {
                                        float h17 = x.h(findViewById.getContext(), r12.top);
                                        cls = cls2;
                                        float h18 = x.h(findViewById.getContext(), r12.bottom);
                                        view = chatXListViewFromChatFragment;
                                        float h19 = x.h(findViewById.getContext(), findViewById.getMeasuredHeight());
                                        if (h18 <= h19) {
                                            h17 = h18 - h19;
                                        }
                                        jSONObject4.put(HippyTKDListViewAdapter.X, x.h(findViewById.getContext(), r12.left));
                                        jSONObject4.put("y", h17);
                                        jSONObject4.put("width", x.h(findViewById.getContext(), r12.width()));
                                        jSONObject4.put("height", h19);
                                    } else {
                                        cls = cls2;
                                        view = chatXListViewFromChatFragment;
                                        jSONObject4.put(HippyTKDListViewAdapter.X, 0);
                                        jSONObject4.put("y", 0);
                                        jSONObject4.put("width", 0);
                                        jSONObject4.put("height", 0);
                                    }
                                } else {
                                    cls = cls2;
                                    view = chatXListViewFromChatFragment;
                                    jSONObject4.put(HippyTKDListViewAdapter.X, 0);
                                    jSONObject4.put("y", 0);
                                    jSONObject4.put("width", 0);
                                    jSONObject4.put("height", 0);
                                }
                            } else {
                                cls = cls2;
                                view = chatXListViewFromChatFragment;
                                jSONObject4.put(HippyTKDListViewAdapter.X, 0);
                                jSONObject4.put("y", 0);
                                jSONObject4.put("width", 0);
                                jSONObject4.put("height", 0);
                            }
                        }
                        i3++;
                        optJSONArray = jSONArray;
                        jSONArray3 = jSONArray2;
                        cls2 = cls;
                        chatXListViewFromChatFragment = view;
                    }
                    arkPubicEventWrapImpl = this;
                } else {
                    arkPubicEventWrapImpl = this;
                    try {
                        arkPubicEventWrapImpl.arkNotify(str, APP_EVENT_CALLBACK_GET_VIEW_LOCATION, jSONObject.toString(), ark.ARKMETADATA_JSON);
                    } catch (Exception unused) {
                        arkPubicEventWrapImpl.arkNotify(str, APP_EVENT_CALLBACK_GET_VIEW_LOCATION, jSONObject.toString(), ark.ARKMETADATA_JSON);
                        return;
                    }
                }
                arkPubicEventWrapImpl.arkNotify(str, APP_EVENT_CALLBACK_GET_VIEW_LOCATION, jSONObject.toString(), ark.ARKMETADATA_JSON);
            } catch (Exception unused2) {
                arkPubicEventWrapImpl = this;
            }
        } catch (Exception unused3) {
            arkPubicEventWrapImpl = this;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void addNotify(String str) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(str, ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).newQWalletArkNotifyTemp(new IQWalletTemp.a() { // from class: com.tencent.mobileqq.qwallet.utils.impl.ArkPubicEventWrapImpl.1
            @Override // com.qwallet.temp.IQWalletTemp.a
            public boolean notify(final String str2, String str3, final String str4) {
                if (QLog.isColorLevel()) {
                    QLog.i(ArkPubicEventWrapImpl.TAG, 2, String.format(Locale.getDefault(), "appName:%1$s;eventName:%2$s;params:%3$s;", str2, str3, str4));
                }
                if (ArkPubicEventWrapImpl.ARK_QUERY_MUTE.equals(str3)) {
                    ArkPubicEventWrapImpl.this.callbackMuteStatus(str2);
                    return true;
                }
                if (ArkPubicEventWrapImpl.ARK_QUERY_PACKAGE.equals(str3)) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            String checkAppInstalled = PackageUtil.checkAppInstalled(BaseApplication.getContext(), new JSONObject(str4).optString("packageName"));
                            JSONObject jSONObject = new JSONObject();
                            if ("0".equals(checkAppInstalled)) {
                                jSONObject.put("errCode", 0);
                                jSONObject.put("isInstall", false);
                            } else {
                                jSONObject.put("errCode", 0);
                                jSONObject.put("isInstall", true);
                                jSONObject.put("version", checkAppInstalled);
                            }
                            ArkPubicEventWrapImpl.this.arkNotify(str2, ArkPubicEventWrapImpl.APP_POST_PACKAGE, jSONObject.toString(), ark.ARKMETADATA_JSON);
                        } catch (Throwable th5) {
                            QLog.e(ArkPubicEventWrapImpl.TAG, 1, "error msg in qqpay-impl module: ", th5);
                            ArkPubicEventWrapImpl.this.arkNotify(str2, ArkPubicEventWrapImpl.APP_POST_PACKAGE, "", ark.ARKMETADATA_JSON);
                        }
                    }
                    return true;
                }
                if (ArkPubicEventWrapImpl.ARK_FULL_SCREEN_PLAY.equals(str3)) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str4);
                            jSONObject2.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
                            jSONObject2.optString("playRate");
                            jSONObject2.optString("totalRate");
                        } catch (Throwable th6) {
                            QLog.e(ArkPubicEventWrapImpl.TAG, 1, "error msg in qqpay-impl module: ", th6);
                        }
                    }
                    return true;
                }
                if (ArkPubicEventWrapImpl.ARK_BEACON_REPORT.equals(str3)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str4);
                        ReportUtils.d(jSONObject3.optString("event_name"), jSONObject3.optJSONObject("params"));
                    } catch (Throwable th7) {
                        QLog.e(ArkPubicEventWrapImpl.TAG, 1, th7, new Object[0]);
                    }
                    return true;
                }
                if (ArkPubicEventWrapImpl.ARK_GET_VIEW_LOCATION.equals(str3)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.utils.impl.ArkPubicEventWrapImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ArkPubicEventWrapImpl.this.notifyViewLocation(str2, str4);
                        }
                    });
                    return true;
                }
                if (ArkPubicEventWrapImpl.ARK_REVERSE_FEEDBACK.equals(str3)) {
                    ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).handleGcArkDeleteMsg(str4);
                    return true;
                }
                if (ArkPubicEventWrapImpl.ARK_OPEN_HIPPY.equals(str3)) {
                    HippyMap hippyMap = new HippyMap();
                    try {
                        hippyMap.pushJSONObject(new JSONObject(str4));
                        new OpenHippyInfo(hippyMap).openHippy(MobileQQ.sMobileQQ);
                        if (QLog.isColorLevel()) {
                            QLog.i(ArkPubicEventWrapImpl.TAG, 2, "ARK_OPEN_HIPPY:" + str4);
                        }
                    } catch (Exception e16) {
                        QLog.e(ArkPubicEventWrapImpl.TAG, 1, "ARK_OPEN_HIPPY..." + e16);
                    }
                    return true;
                }
                if (!ArkPubicEventWrapImpl.ARK_GET_DSL_CONTENT.equals(str3)) {
                    ArkPubicEventWrapImpl.this.setChanged();
                    ArkPubicEventWrapImpl.this.notifyObservers(new IArkPubicEventWrap.a(str2, str3, str4));
                    return false;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject4 = new JSONObject(str4);
                    String activityDSL = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getActivityDSL(jSONObject4.optString("dslId"), 0);
                    if (!TextUtils.isEmpty(activityDSL)) {
                        jSONObject4.put("dsl", activityDSL);
                    }
                    ArkPubicEventWrapImpl.this.arkNotify(str2, ArkPubicEventWrapImpl.APP_EVENT_CALLBACK_GET_DSL_CONTENT, jSONObject4.toString(), ark.ARKMETADATA_JSON);
                    if (QLog.isColorLevel()) {
                        QLog.i(ArkPubicEventWrapImpl.TAG, 2, "ARK_GET_DSL_CONTENT:" + str4 + ", jsonObject:" + jSONObject4 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (Exception e17) {
                    QLog.e(ArkPubicEventWrapImpl.TAG, 1, "ARK_GET_DSL_CONTENT..." + e17);
                }
                return true;
            }
        }));
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void registVolumnReceiver(String... strArr) {
        if (strArr.length > 0) {
            for (String str : strArr) {
                this.volumnArkAppNameList.add(str);
            }
            if (receiver == null) {
                receiver = new a();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.media.RINGER_MODE_CHANGED");
            BaseApplication.getContext().getBaseContext().registerReceiver(receiver, intentFilter);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void removeNotify(String str) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(str, null);
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void unRegistVolumnReceiver(String... strArr) {
        if (strArr.length > 0) {
            for (String str : strArr) {
                this.volumnArkAppNameList.remove(str);
            }
        }
        if (receiver != null) {
            BaseApplication.getContext().getBaseContext().unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void unRegistVolumnReceiver(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.volumnArkAppNameList.removeAll(list);
        if (receiver != null) {
            BaseApplication.getContext().getBaseContext().unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void callbackMuteStatus() {
        try {
            try {
                boolean z16 = ((AudioManager) BaseApplication.getContext().getApplicationContext().getSystemService("audio")).getRingerMode() != 2;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_muted", z16);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "ad_query_mute: " + jSONObject.toString());
                }
                Iterator<String> it = this.volumnArkAppNameList.iterator();
                while (it.hasNext()) {
                    arkNotify(it.next(), APP_POST_MUTE, jSONObject.toString(), ark.ARKMETADATA_JSON);
                }
            } catch (Throwable unused) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("is_muted", false);
                Iterator<String> it5 = this.volumnArkAppNameList.iterator();
                while (it5.hasNext()) {
                    arkNotify(it5.next(), APP_POST_MUTE, jSONObject2.toString(), ark.ARKMETADATA_JSON);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
    public void registVolumnReceiver(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.volumnArkAppNameList.addAll(list);
        if (receiver == null) {
            receiver = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        intentFilter.addAction("android.media.RINGER_MODE_CHANGED");
        BaseApplication.getContext().getBaseContext().registerReceiver(receiver, intentFilter);
    }
}
