package com.tencent.hippy.qq.module;

import Wallet.AcsBatchSubNoticeRsp;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.HippyFileManagerUtil;
import com.tencent.hippy.qq.utils.HippyResultCodeCallback;
import com.tencent.hippy.qq.utils.HippySaveToPhotoHelper;
import com.tencent.hippy.qq.utils.HippySharePanelHelper;
import com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper;
import com.tencent.hippy.qq.utils.screenshot.ShareImageUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi;
import com.tencent.mobileqq.jsp.ShareMsgImpl;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.api.IMiniGameHippyApi;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.api.IVasColorNoteApi;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQUiModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQUiModule extends QQBaseLifecycleModule implements ae.b, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, ActionSheet.WatchDismissActions, DialogInterface.OnCancelListener {
    public static final String CLASSNAME = "QQUiModule";
    static final byte CODE_OPEN_CUSTOM_WEBVIEW = 14;
    private static final int CODE_OPEN_VIEW = 101;
    private static final int CODE_SUBSCRIBE = ao.b(QWalletMixJsPlugin.OBJECT_NAME_QWALLET_MIX) << 8;
    private static final SparseArray<Integer> FRIEND_TYPE_MAP = new SparseArray<Integer>() { // from class: com.tencent.hippy.qq.module.QQUiModule.1
        {
            put(0, 1);
            put(1, 2);
            put(10018, 3);
        }
    };
    private static final String IMG_PATH = "imgPath";
    public static final String METHOD_ACTION_NOTIFY_BATCH_SUBSCRIBE = "batchSubscribe";
    public static final String METHOD_ACTION_NOTIFY_DELETE = "delete";
    public static final String METHOD_ACTION_NOTIFY_NEW_SUBSCRIBE = "newSubscribe";
    public static final String METHOD_ACTION_NOTIFY_QUERY = "query";
    public static final String METHOD_ACTION_NOTIFY_SUBSCRIBE = "subscribe";
    public static final String METHOD_ACTION_SUBSCRIBE_CALENDAR_DIRECTLY = "subscribeCalendarDirectly";
    public static final String METHOD_ACTION_SUBSCRIBE_DIRECTLY = "subscribe_directly";
    public static final String PARAMS_BUSINESS_ID = "busiid";
    public static final String PARAMS_DOMAIN = "domain";
    public static final String PARAMS_MSG_ID = "msgid";
    private static final int REQ_CODE_CHOOSE_FRIEND = 16;
    private static final String RET_CODE = "retCode";
    private static final String ROOTVIEW_ID = "rootViewId";
    private static final String TYPE = "type";
    private static final int TYPE_FOLLOW = 1;
    private ActionSheet mActionSheet;
    private boolean mActionSheetIsCancle;
    public int mActionSheetItemCount;
    private String mActionSheetParamStr;
    private Promise mActionSheetPromise;
    com.tencent.biz.troop.b mClient;
    private Promise mGetFriendInfoPromise;
    private HashMap<String, Long> mLastSendProgressEventTimeMap;
    private Promise mNotifyPromise;
    private Promise mOpenViewPromise;
    private ShareMsgImpl mShareMsgImpl;
    ShareMsgImpl.b mShareMsgImplListener;
    private Promise mShareMsgPromise;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface TroopMemberBindServiceCallback {
        void toBind();
    }

    public QQUiModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mLastSendProgressEventTimeMap = new HashMap<>();
        this.mActionSheetItemCount = 0;
        this.mClient = null;
        this.mShareMsgImplListener = new ShareMsgImpl.b() { // from class: com.tencent.hippy.qq.module.QQUiModule.2
            @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
            public void onSharMsgcallback(String str, String str2) {
                if (QQUiModule.this.mShareMsgPromise != null && QQUiModule.this.mShareMsgPromise.getCallId().equals(str)) {
                    QQUiModule.this.mShareMsgPromise.resolve(str2);
                }
            }

            @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
            public void startActivityForResult(Intent intent, byte b16) {
                QBaseFragment fragment = QQUiModule.this.getFragment();
                if (fragment != null) {
                    fragment.startActivityForResult(intent, b16);
                }
            }
        };
        this.mActionSheetIsCancle = false;
    }

    private void batchSubscribeNotify(JSONObject jSONObject, final Promise promise) {
        JSONArray optJSONArray = jSONObject.optJSONArray("msg_id_list");
        String optString = jSONObject.optString("domain");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                arrayList.add(optJSONArray.getString(i3));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(CLASSNAME, 2, e16, new Object[0]);
                }
            }
        }
        IQQReminderService iQQReminderService = (IQQReminderService) getAppInterface().getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService == null) {
            return;
        }
        iQQReminderService.sendBatchSubscribeReminder(arrayList, optString, new BusinessObserver() { // from class: com.tencent.hippy.qq.module.QQUiModule.15
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i16, boolean z16, Bundle bundle) {
                try {
                    if (i16 == 2007 && z16) {
                        AcsBatchSubNoticeRsp acsBatchSubNoticeRsp = (AcsBatchSubNoticeRsp) bundle.getSerializable("rsp");
                        if (acsBatchSubNoticeRsp != null) {
                            QLog.i(QQUiModule.CLASSNAME, 2, "batchSubscribeNotify#onReceive, rsp retCode:" + acsBatchSubNoticeRsp.ret_code);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("retcode", acsBatchSubNoticeRsp.ret_code);
                            jSONObject2.put("retmsg", acsBatchSubNoticeRsp.err_str);
                            jSONObject2.put("success_count", acsBatchSubNoticeRsp.succeed_count);
                            jSONObject2.put("retry_msgs", acsBatchSubNoticeRsp.retry_msgs);
                            Promise promise2 = promise;
                            if (promise2 != null) {
                                promise2.resolve(jSONObject2);
                            }
                            ArrayList<AcsMsg> arrayList2 = acsBatchSubNoticeRsp.msgs;
                            if (arrayList2 != null && !arrayList2.isEmpty()) {
                                IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderDataService.class, "");
                                Iterator<AcsMsg> it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    iQQReminderDataService.doNotifyByPush(it.next());
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    QLog.i(QQUiModule.CLASSNAME, 2, "batchSubscribeNotify#onReceive, not success");
                } catch (Exception e17) {
                    QLog.e(QQUiModule.CLASSNAME, 1, "batchSubscribeNotify#onReceive", e17);
                }
            }
        });
    }

    private void callBackToJs(int i3, String str, Promise promise) {
        if (promise == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", i3);
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("errMsg", str);
            }
            promise.resolve(jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "callBackToJs error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callback(Promise promise, int i3, String str) {
        try {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retcode", i3);
            hippyMap.pushString("retmsg", str);
            if (promise != null) {
                promise.resolve(hippyMap);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(CLASSNAME, 2, e16.getMessage());
            }
        }
    }

    private void cancelFullScreen(final Activity activity, final View view, final Promise promise) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.m
            @Override // java.lang.Runnable
            public final void run() {
                QQUiModule.this.lambda$cancelFullScreen$5(view, activity, promise);
            }
        });
    }

    private void deleteNotify(JSONObject jSONObject, final Promise promise) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        String optString3 = jSONObject.optString("domain");
        QLog.i(CLASSNAME, 2, "deleteNotify: msgId: " + optString + ", busiId: " + optString2 + ", domain: " + optString3);
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2) && !StringUtil.isEmpty(optString3)) {
            IQQReminderService iQQReminderService = (IQQReminderService) getAppInterface().getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService == null) {
                return;
            }
            iQQReminderService.sendDelReminderListById(optString, 0L, 2, new BusinessObserver() { // from class: com.tencent.hippy.qq.module.QQUiModule.16
                @Override // mqq.observer.BusinessObserver
                public void onReceive(final int i3, final boolean z16, final Bundle bundle) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.QQUiModule.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (i3 == 2001) {
                                    if (z16) {
                                        AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) bundle.getSerializable("rsp");
                                        if (acsDelMsgRsp != null && acsDelMsgRsp.ret_code == 0) {
                                            QLog.i(QQUiModule.CLASSNAME, 2, "@qqnotify req success ");
                                            AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                                            QQUiModule.this.callback(promise, acsDelMsgRsp.ret_code, acsDelMsgRsp.err_str);
                                        } else if (acsDelMsgRsp != null) {
                                            AnonymousClass16 anonymousClass162 = AnonymousClass16.this;
                                            QQUiModule.this.callback(promise, acsDelMsgRsp.ret_code, acsDelMsgRsp.err_str);
                                            QLog.i(QQUiModule.CLASSNAME, 2, "@qqnotify ret_code =  " + acsDelMsgRsp.ret_code);
                                        }
                                    } else {
                                        AnonymousClass16 anonymousClass163 = AnonymousClass16.this;
                                        QQUiModule.this.callback(promise, 2, "error");
                                        QLog.i(QQUiModule.CLASSNAME, 2, "@qqnotify delete faield not success  ");
                                    }
                                }
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(QQUiModule.CLASSNAME, 1, "sendDelReminderListById onReceive", e16);
                                }
                                AnonymousClass16 anonymousClass164 = AnonymousClass16.this;
                                QQUiModule.this.callback(promise, 3, "exception: " + e16);
                            }
                        }
                    });
                }
            });
            IQQReminderCalendarService iQQReminderCalendarService = (IQQReminderCalendarService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderCalendarService.class, "");
            CalendarEntity calendarEntity = new CalendarEntity();
            calendarEntity.msg_id = optString;
            iQQReminderCalendarService.deleteCalendarAlarm((AppActivity) getActivity(), calendarEntity);
            return;
        }
        callback(promise, 4, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void excuteOpenView(String str, Promise promise) {
        int i3;
        JSONObject jSONObject = null;
        this.mOpenViewPromise = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
        }
        Activity activity = getActivity();
        QBaseFragment fragment = getFragment();
        if ((activity instanceof QBaseActivity) && !activity.isFinishing() && fragment != null) {
            Pair<Boolean, Boolean> innerOpenView = innerOpenView(jSONObject, activity, fragment, new TroopMemberBindServiceCallback() { // from class: com.tencent.hippy.qq.module.p
                @Override // com.tencent.hippy.qq.module.QQUiModule.TroopMemberBindServiceCallback
                public final void toBind() {
                    QQUiModule.this.lambda$excuteOpenView$0();
                }
            });
            boolean booleanValue = ((Boolean) innerOpenView.first).booleanValue();
            if (((Boolean) innerOpenView.second).booleanValue() && booleanValue) {
                this.mOpenViewPromise = promise;
                return;
            }
            HippyMap hippyMap = new HippyMap();
            if (booleanValue) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            hippyMap.pushInt("code", i3);
            promise.resolve(hippyMap);
            return;
        }
        QLog.e(CLASSNAME, 1, "shareMessage activity is finishing");
    }

    private HippyMap getCallbackHippyMap(int i3, String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("code", i3);
        if (!TextUtils.isEmpty(str)) {
            hippyMap.pushString("msg", str);
        }
        return hippyMap;
    }

    private void handleChooseFriendResult(Intent intent, int i3) {
        if (i3 != -1) {
            return;
        }
        IGameCenterFriendApi iGameCenterFriendApi = (IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class);
        final int intValue = FRIEND_TYPE_MAP.get(intent.getIntExtra("uintype", -1)).intValue();
        final String stringExtra = intent.getStringExtra("uinname");
        final String stringExtra2 = intent.getStringExtra("uin");
        String stringExtra3 = intent.getStringExtra(AppConstants.Key.KEY_GC_SENDER_ID);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = getAppInterface().getCurrentAccountUin();
        }
        final String str = stringExtra3;
        iGameCenterFriendApi.reportFriendChooseResult(intent.getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID), intValue, "1");
        iGameCenterFriendApi.getTokenForFriendChosen(str, stringExtra2, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.hippy.qq.module.o
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                QQUiModule.this.lambda$handleChooseFriendResult$1(stringExtra, intValue, stringExtra2, str, (String) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017f  */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Boolean, Boolean> innerOpenView(JSONObject jSONObject, Activity activity, QBaseFragment qBaseFragment, TroopMemberBindServiceCallback troopMemberBindServiceCallback) {
        ?? r85;
        boolean z16;
        String str;
        JSONObject jSONObject2;
        QBaseFragment qBaseFragment2 = qBaseFragment;
        QBaseFragment qBaseFragment3 = null;
        r8 = false;
        r8 = false;
        boolean z17 = false;
        r8 = null;
        r8 = null;
        r8 = null;
        QBaseFragment qBaseFragment4 = null;
        if (jSONObject != null && (activity instanceof QBaseActivity)) {
            try {
                String optString = jSONObject.optString("viewType", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                String optString2 = jSONObject.optString("name");
                String optString3 = jSONObject.optString("options");
                int optInt = jSONObject.optInt("animation", -1);
                z16 = jSONObject.optBoolean("isNeedCloseCallback");
                try {
                    try {
                        jSONObject2 = new JSONObject(optString3);
                    } catch (Exception e16) {
                        e = e16;
                        str = CLASSNAME;
                        qBaseFragment2 = qBaseFragment3;
                        if (QLog.isColorLevel()) {
                        }
                        r85 = qBaseFragment2;
                        return new Pair<>(Boolean.valueOf((boolean) r85), Boolean.valueOf(z16));
                    }
                } catch (JSONException unused) {
                    jSONObject2 = new JSONObject();
                }
                if ("popWindow".equals(optString)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("options", jSONObject2.toString());
                    if ("com.tencent.mobileqq.troop.activity.PublicCommentActivity".equals(optString2)) {
                        new PublicCommentWindow((QBaseActivity) activity, bundle).U(activity);
                    } else if ("com.tencent.mobileqq.troop.activity.TroopBarCommentActivity".equals(optString2)) {
                        new com.tencent.mobileqq.troop.activity.j((QBaseActivity) activity, bundle).U(activity);
                    }
                } else {
                    try {
                        try {
                            if (WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY.equals(optString)) {
                                Intent intent = new Intent();
                                try {
                                    if ("cooperation.comic.VipComicJumpActivity".equals(optString2)) {
                                        intent.setComponent(new ComponentName(activity, optString2));
                                        str = CLASSNAME;
                                        intent.putExtra("click_start_time", System.currentTimeMillis());
                                    } else {
                                        str = CLASSNAME;
                                        if ("cooperation.qqindividuality.QQIndividualityBridgeActivity".equals(optString2)) {
                                            intent.setComponent(new ComponentName(activity, optString2));
                                            intent.putExtra("k_source", 0);
                                            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                                            intent.putExtra(cooperation.qqindividuality.b.f390742j, 1);
                                            intent.putExtra(cooperation.qqindividuality.b.f390735c, "path");
                                            intent.putExtra(cooperation.qqindividuality.b.f390736d, "name");
                                            qBaseFragment4 = "path";
                                        } else if ("com.tencent.mobileqq.activity.AuthDevOpenUgActivity".equals(optString2)) {
                                            intent.setComponent(new ComponentName(activity, optString2));
                                            intent.putExtra(AuthDevOpenUgActivity.H5_CALL_ME, "true");
                                        } else {
                                            intent.setComponent(new ComponentName(activity, optString2));
                                        }
                                    }
                                    intent.putExtra("options", jSONObject2.toString());
                                    if (!z16) {
                                        if (qBaseFragment2 != null) {
                                            qBaseFragment2.startActivity(intent);
                                        } else {
                                            activity.startActivity(intent);
                                        }
                                    } else if (qBaseFragment2 != null) {
                                        qBaseFragment2.startActivityForResult(intent, 101);
                                    } else {
                                        activity.startActivityForResult(intent, 101);
                                    }
                                    if (optInt != 1) {
                                        if (optInt == 1001) {
                                            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
                                        }
                                    } else {
                                        activity.overridePendingTransition(0, 0);
                                    }
                                    if (PoiMapActivity.class.getName().equals(optString2) && troopMemberBindServiceCallback != null) {
                                        troopMemberBindServiceCallback.toBind();
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    qBaseFragment3 = qBaseFragment4;
                                    qBaseFragment2 = qBaseFragment3;
                                    if (QLog.isColorLevel()) {
                                        String str2 = str;
                                        QLog.d(str2, 2, " openView startActivity failed");
                                        QLog.d(str2, 2, QLog.getStackTraceString(e));
                                    }
                                    r85 = qBaseFragment2;
                                    return new Pair<>(Boolean.valueOf((boolean) r85), Boolean.valueOf(z16));
                                }
                            } else if ("activityWrapper".equals(optString) && optString2.equals("com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity")) {
                                jSONObject2.optInt("openSource", 0);
                            }
                            z17 = z16;
                        } catch (Exception e18) {
                            e = e18;
                            qBaseFragment2 = null;
                            if (QLog.isColorLevel()) {
                            }
                            r85 = qBaseFragment2;
                            return new Pair<>(Boolean.valueOf((boolean) r85), Boolean.valueOf(z16));
                        }
                    } catch (Exception e19) {
                        e = e19;
                        if (QLog.isColorLevel()) {
                        }
                        r85 = qBaseFragment2;
                        return new Pair<>(Boolean.valueOf((boolean) r85), Boolean.valueOf(z16));
                    }
                }
                z16 = z17;
                r85 = 1;
            } catch (Exception e26) {
                e = e26;
                str = CLASSNAME;
                qBaseFragment2 = null;
                z16 = false;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "openView error, json is NULL-----");
            }
            r85 = 0;
            z16 = false;
        }
        return new Pair<>(Boolean.valueOf((boolean) r85), Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelFullScreen$5(View view, Activity activity, Promise promise) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i3 = systemUiVisibility & (-257) & (-1025) & (-3) & (-513) & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS & (-5);
        activity.getWindow().addFlags(67108864);
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
        activity.getWindow().clearFlags(134218752);
        HippyMap callbackHippyMap = getCallbackHippyMap(0, "");
        callbackHippyMap.pushBoolean("result", true);
        promise.resolve(callbackHippyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$excuteOpenView$0() {
        if (this.mClient == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.mClient = A;
            A.p();
        }
        this.mClient.j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getFriendInfo$2(String str, boolean z16, Promise promise, Boolean bool) {
        startChooseFriendPage(str, bool.booleanValue(), z16, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChooseFriendResult$1(String str, int i3, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put("name", str);
                jSONObject2.put("type", i3);
                jSONObject2.put("friendId", str2);
                jSONObject2.put("senderId", str3);
                jSONObject2.put("token", str4);
                jSONObject.put(GuildMsgItem.NICK_FRIEND, jSONObject2);
                jSONObject.put("ret", 0);
            } else {
                jSONObject.put("ret", 1);
            }
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 2, "[handleChooseFriendResult] " + e16);
        }
        this.mGetFriendInfoPromise.resolve(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$saveToPhoto$3(String str, Float f16) {
        Long l3 = this.mLastSendProgressEventTimeMap.get(str);
        if (l3 == null) {
            l3 = 0L;
        }
        if (Math.abs(System.currentTimeMillis() - l3.longValue()) < 100 && f16.floatValue() != 100.0f) {
            return null;
        }
        this.mLastSendProgressEventTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("progress", f16);
            sendEvent(HippySaveToPhotoHelper.EVENT_HIPPY_SAVE_TO_PHOTO_PROGRESS_CHANGE, jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(CLASSNAME, 1, e16, new Object[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toFullScreen$4(View view, Activity activity, Promise promise) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i3 = systemUiVisibility | 256 | 1024 | 2 | 512 | 2048 | 4;
        activity.getWindow().addFlags(67108864);
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
        activity.getWindow().addFlags(134218752);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
        }
        HippyMap callbackHippyMap = getCallbackHippyMap(0, "");
        callbackHippyMap.pushBoolean("result", true);
        promise.resolve(callbackHippyMap);
    }

    private void newSubscribeRecurrentNotifyFragment(JSONObject jSONObject, Promise promise) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        String optString3 = jSONObject.optString("domain");
        this.mNotifyPromise = promise;
        HippyMap hippyMap = new HippyMap();
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
            ae.p(getActivity(), optString, optString3, optString2, QQNotifySettingBaseFragment.U);
            return;
        }
        hippyMap.pushInt("code", -1);
        if (promise != null) {
            promise.resolve(hippyMap);
        }
    }

    private void onActionSheetCancel() {
        if (this.mActionSheetPromise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("type", 1);
            hippyMap.pushInt("index", this.mActionSheetItemCount);
            this.mActionSheetPromise.resolve(hippyMap);
        }
    }

    private void queryBusinessHasSet(JSONObject jSONObject, Promise promise) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        String optString3 = jSONObject.optString("domain");
        this.mNotifyPromise = promise;
        HippyMap hippyMap = new HippyMap();
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
            ae.k(optString, optString3, optString2, this);
            return;
        }
        hippyMap.pushInt("code", -1);
        if (promise != null) {
            promise.resolve(hippyMap);
        }
    }

    private void sendEvent(String str, Object obj) {
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext != null) {
            ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, obj);
        }
    }

    private void startChooseFriendPage(String str, boolean z16, boolean z17, Promise promise) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1058);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(AppConstants.Key.KEY_GC_GAME_APPID, str);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_GAME_FRIEND_ENTRANCE, z16);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_TROOP_ENTRANCE, z17);
        intent.putExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC, "1");
        this.mGetFriendInfoPromise = promise;
        activity.startActivityForResult(intent, 16);
    }

    private void subscribeCalendarNotify(JSONObject jSONObject, final Promise promise) {
        String optString = jSONObject.optString("domain");
        String optString2 = jSONObject.optString("msgid");
        String optString3 = jSONObject.optString("busiid");
        String optString4 = jSONObject.optString("ifAddCalendar");
        HippyMap hippyMap = new HippyMap();
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            ae.r(getAppInterface(), (AppActivity) getActivity(), optString2, optString, optString3, optString4, new ae.c() { // from class: com.tencent.hippy.qq.module.QQUiModule.13
                @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
                public void onResult(Bundle bundle, Bundle bundle2) {
                    QQUiModule.this.callback(promise, bundle.getInt("retcode"), bundle.getString("retmsg"));
                }
            });
            return;
        }
        hippyMap.pushInt("code", -1);
        if (promise != null) {
            promise.resolve(hippyMap);
        }
    }

    private void subscribeNotify(JSONObject jSONObject, Promise promise) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        String optString3 = jSONObject.optString("domain");
        HippyMap hippyMap = new HippyMap();
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2) && !StringUtil.isEmpty(optString3)) {
            this.mNotifyPromise = promise;
            QQNotifySettingInnerFragment.Ih(getActivity(), optString, optString2, optString3);
        } else {
            hippyMap.pushInt("code", -1);
            if (promise != null) {
                promise.resolve(hippyMap);
            }
        }
    }

    private void subscribeNotifyDirectly(JSONObject jSONObject, final Promise promise) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        String optString3 = jSONObject.optString("domain");
        HippyMap hippyMap = new HippyMap();
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
            ae.s(optString, optString3, optString2, new ae.c() { // from class: com.tencent.hippy.qq.module.QQUiModule.14
                @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
                public void onResult(Bundle bundle, Bundle bundle2) {
                    QQUiModule.this.callback(promise, bundle.getInt("retcode"), bundle.getString("retmsg"));
                }
            });
            return;
        }
        hippyMap.pushInt("code", -1);
        if (promise != null) {
            promise.resolve(hippyMap);
        }
    }

    private void toFullScreen(final Activity activity, final View view, final Promise promise) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.q
            @Override // java.lang.Runnable
            public final void run() {
                QQUiModule.this.lambda$toFullScreen$4(view, activity, promise);
            }
        });
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        ShareMsgImpl shareMsgImpl = this.mShareMsgImpl;
        if (shareMsgImpl != null) {
            shareMsgImpl.g();
        }
        com.tencent.biz.troop.b bVar = this.mClient;
        if (bVar != null) {
            bVar.q();
        }
    }

    @HippyMethod(name = "displayColorNote")
    public void displayColorNote(HippyMap hippyMap) {
        if (hippyMap != null) {
            boolean z16 = hippyMap.getBoolean("display");
            ((IVasColorNoteApi) QRoute.api(IVasColorNoteApi.class)).displayColorNote(z16);
            QLog.d(CLASSNAME, 1, "displayColorNote: " + z16);
            return;
        }
        QLog.e(CLASSNAME, 1, "displayColorNote: param null");
    }

    public void downloadShortVideoFilterSo() {
        if (this.mClient == null) {
            this.mClient = com.tencent.biz.troop.b.A();
        }
        this.mClient.r();
    }

    @HippyMethod(name = "followAnchor")
    public void followAnchor(String str, final Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN);
            if (jSONObject.optInt("type") == 1) {
                IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                iPublicAccountObserver.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.hippy.qq.module.QQUiModule.11
                    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
                    public void onFollowPublicAccount(boolean z16, String str2) {
                        if (QLog.isColorLevel()) {
                            QLog.i(QQUiModule.CLASSNAME, 1, "onFollowPublicAccount issuccess = " + z16);
                        }
                        HippyMap hippyMap = new HippyMap();
                        hippyMap.pushInt("ret", !z16 ? 1 : 0);
                        promise.resolve(hippyMap);
                    }
                });
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(getAppInterface(), getAppInterface().getApplicationContext(), optString, iPublicAccountObserver);
            } else {
                IPublicAccountObserver iPublicAccountObserver2 = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                iPublicAccountObserver2.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.hippy.qq.module.QQUiModule.12
                    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
                    public void onUnfollowPublicAccount(boolean z16, String str2) {
                        if (QLog.isColorLevel()) {
                            QLog.i(QQUiModule.CLASSNAME, 1, "onUnfollowPublicAccount issuccess = " + z16);
                        }
                        HippyMap hippyMap = new HippyMap();
                        hippyMap.pushInt("ret", !z16 ? 1 : 0);
                        promise.resolve(hippyMap);
                    }
                });
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(getAppInterface(), getAppInterface().getApplicationContext(), optString, false, iPublicAccountObserver2);
            }
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, "followAnchor error:" + th5.getMessage());
        }
    }

    @HippyMethod(name = "getBatteryPercent")
    public void getBatteryPercentage(Promise promise) {
        QLog.i(CLASSNAME, 1, "getBatteryPercentage");
        Activity activity = getActivity();
        int i3 = -1;
        if (activity == null) {
            HippyMap callbackHippyMap = getCallbackHippyMap(-1, "\u7cfb\u7edf\u9519\u8bef");
            callbackHippyMap.pushInt("percent", -1);
            promise.reject(callbackHippyMap);
            return;
        }
        Intent registerReceiver = activity.getApplication().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            HippyMap callbackHippyMap2 = getCallbackHippyMap(-1, "\u7cfb\u7edf\u9519\u8bef2");
            callbackHippyMap2.pushInt("percent", -1);
            promise.reject(callbackHippyMap2);
            return;
        }
        int intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra != -1 && intExtra2 != -1) {
            i3 = (int) (((intExtra * 1.0f) / intExtra2) * 100.0f);
        }
        HippyMap callbackHippyMap3 = getCallbackHippyMap(0, "");
        callbackHippyMap3.pushInt("percent", i3);
        promise.resolve(callbackHippyMap3);
    }

    @HippyMethod(name = VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO)
    public void getFriendInfo(HippyMap hippyMap, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "[getFriendInfo], params:" + hippyMap);
        }
        final String string = hippyMap.getString("appid");
        final boolean z16 = hippyMap.getBoolean("withGroup");
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).getGameFriendEnableStatus(string, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.hippy.qq.module.n
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                QQUiModule.this.lambda$getFriendInfo$2(string, z16, promise, (Boolean) obj);
            }
        });
    }

    @HippyMethod(name = "gotoNoticeServicePage")
    public void gotoNoticeServicePage(HippyMap hippyMap, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "[gotoNoticeServicePage], params:" + hippyMap);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("key_notify_app_id", hippyMap.getLong("appId"));
            intent.putExtra("key_notify_app_type", hippyMap.getInt("appType"));
            QPublicFragmentActivity.start(getActivity(), intent, NotifyServiceBisConfigFragment.class);
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 2, "[gotoNoticeServicePage], exception:" + th5);
        }
    }

    @HippyMethod(name = "isNightModeTheme")
    public void isNightModeTheme(Promise promise) {
        promise.resolve(Boolean.valueOf(QQTheme.isNowThemeIsNight()));
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        String stringExtra;
        if (i3 != 16) {
            if (i3 != 101) {
                ShareMsgImpl shareMsgImpl = this.mShareMsgImpl;
                if (shareMsgImpl != null) {
                    shareMsgImpl.f(intent, (byte) i3, i16);
                }
            } else if (this.mOpenViewPromise != null) {
                HippyMap hippyMap = new HippyMap();
                if (i16 == -1) {
                    if (intent == null) {
                        stringExtra = "";
                    } else {
                        stringExtra = intent.getStringExtra("result");
                    }
                    hippyMap.pushInt("code", 0);
                    hippyMap.pushString("result", stringExtra);
                } else {
                    hippyMap.pushInt("code", -1);
                }
                this.mOpenViewPromise.resolve(hippyMap);
            }
        } else {
            handleChooseFriendResult(intent, i16);
        }
        if (i3 == CODE_SUBSCRIBE && this.mNotifyPromise != null) {
            HippyMap hippyMap2 = new HippyMap();
            if (i16 == -1 && intent != null) {
                hippyMap2.pushInt("retcode", intent.getIntExtra("errorCode", 0));
                hippyMap2.pushString("retmsg", intent.getStringExtra("msg"));
            } else {
                hippyMap2.pushInt("retcode", -1);
            }
            this.mNotifyPromise.resolve(hippyMap2);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        onActionSheetCancel();
    }

    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
    public void onClick(View view, int i3) {
        if (this.mActionSheetPromise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("index", i3);
            if (this.mActionSheetIsCancle && i3 == 0) {
                hippyMap.pushInt("type", 2);
            } else {
                hippyMap.pushInt("type", 0);
            }
            this.mActionSheetPromise.resolve(hippyMap);
        }
        ActionSheet actionSheet = this.mActionSheet;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    @Override // com.tencent.widget.ActionSheet.OnDismissListener
    public void onDismiss() {
        if (this.mActionSheetPromise != null) {
            onActionSheetCancel();
        }
    }

    @Override // com.tencent.widget.ActionSheet.WatchDismissActions
    public void onDismissOperations() {
        Activity activity = getActivity();
        if (activity instanceof PublicFragmentActivity) {
            ((PublicFragmentActivity) activity).G2();
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
        super.onNewIntent(activity, intent);
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_OPEN_MINI_APP)
    public void openMiniApp(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "openMiniApp:" + str);
        }
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e(CLASSNAME, 1, "openMiniApp activity is null");
            return;
        }
        try {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2016, null);
        } catch (Exception e16) {
            QLog.e(CLASSNAME, 1, "openMiniApp error: " + e16.getMessage());
        }
    }

    @HippyMethod(name = "openQQScheme")
    public void openQQScheme(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            callBackToJs(-1, "openQQScheme with empty scheme", promise);
            QLog.e(CLASSNAME, 1, "openQQScheme with empty scheme");
            return;
        }
        try {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(getActivity(), str);
            callBackToJs(0, null, promise);
        } catch (Throwable th5) {
            String str2 = "openQQScheme error: " + th5;
            callBackToJs(-1, str2, promise);
            QLog.e(CLASSNAME, 1, str2);
        }
    }

    @HippyMethod(name = "openUrl")
    public void openUrl(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "openUrl:" + str);
        }
        Activity activity = getActivity();
        AppInterface appInterface = getAppInterface();
        if (activity != null && appInterface != null) {
            if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isLaunchByMiniApp(activity)) {
                ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).openUrl(activity, str);
                return;
            } else {
                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).interceptUrl(activity, str) || ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).interceptHttpUrl(activity, str)) {
                    return;
                }
                UiApiPlugin.g0(activity, null, appInterface, str, true, true);
                return;
            }
        }
        QLog.e(CLASSNAME, 1, "openUrl activity or appinterface is null");
    }

    @HippyMethod(name = "openUrlScheme")
    public void openUrlScheme(String str, String str2, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e(CLASSNAME, 1, "openUrlScheme activity is null");
            return;
        }
        try {
            if (((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).checkIfOpenFloatInCurProcess(str)) {
                QLog.e(CLASSNAME, 1, "openUrlScheme isJumpInCurProcess");
                callBackToJs(0, null, promise);
            } else {
                if (((IMiniGameHippyApi) QRoute.api(IMiniGameHippyApi.class)).isMiniGameHandled(getFragment(), str, str2)) {
                    QLog.e(CLASSNAME, 1, "openUrlScheme isMiniGameHandled");
                    callBackToJs(0, null, promise);
                    return;
                }
                Intent intent = new Intent();
                intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.putExtra("big_brother_source_key", str2);
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
                callBackToJs(0, null, promise);
            }
        } catch (Exception e16) {
            String str3 = "openUrlScheme error: " + e16;
            callBackToJs(-1, str3, promise);
            QLog.e(CLASSNAME, 1, str3);
        }
    }

    @HippyMethod(name = "openView")
    public void openView(final String str, final Promise promise) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.module.QQUiModule.5
            @Override // java.lang.Runnable
            public void run() {
                QQUiModule.this.excuteOpenView(str, promise);
            }
        });
    }

    @HippyMethod(name = "preloadToolProcess")
    public void preloadToolProcess(HippyMap hippyMap) {
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "preloadToolProcess===>");
        }
        if (hippyMap != null) {
            try {
                IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IWebProcessManagerService.class, "");
                int i3 = hippyMap.getInt("from");
                QLog.i(CLASSNAME, 1, "[preloadToolProcess]from:" + i3);
                iWebProcessManagerService.startWebProcess(i3, null);
            } catch (Throwable th5) {
                QLog.e(CLASSNAME, 1, th5, new Object[0]);
            }
        }
    }

    @HippyMethod(name = "qqNotify")
    public void qqNotify(String str, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (QLog.isColorLevel()) {
                QLog.i(CLASSNAME, 2, "qqNotify: action " + optString + ",paramsObj: " + optJSONObject);
            }
            if ("newSubscribe".equals(optString)) {
                newSubscribeRecurrentNotifyFragment(optJSONObject, promise);
                return;
            }
            if ("query".equals(optString)) {
                queryBusinessHasSet(optJSONObject, promise);
                return;
            }
            if ("subscribe".equals(optString)) {
                subscribeNotify(optJSONObject, promise);
                return;
            }
            if ("delete".equals(optString)) {
                deleteNotify(optJSONObject, promise);
                return;
            }
            if (METHOD_ACTION_NOTIFY_BATCH_SUBSCRIBE.equals(optString)) {
                batchSubscribeNotify(optJSONObject, promise);
            } else if ("subscribe_directly".equals(optString)) {
                subscribeNotifyDirectly(optJSONObject, promise);
            } else if ("subscribeCalendarDirectly".equals(optString)) {
                subscribeCalendarNotify(optJSONObject, promise);
            }
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 2, "qqNotify error:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ae.b
    public void queryHasSetNotify(Bundle bundle, @Nullable Bundle bundle2) {
        int i3 = bundle.getInt("retcode", -1);
        String string = bundle.getString("retmsg", "");
        int i16 = bundle.getInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, -1);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retcode", i3);
        hippyMap.pushString("retmsg", string);
        if (i3 == 0) {
            hippyMap.pushInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, i16);
        }
        Promise promise = this.mNotifyPromise;
        if (promise != null) {
            promise.resolve(hippyMap);
        }
    }

    @HippyMethod(name = "saveImage")
    public void saveImage(HippyMap hippyMap, final Promise promise) {
        HippyFileManagerUtil.saveImage(MobileQQ.sMobileQQ, hippyMap, new HippyResultCodeCallback() { // from class: com.tencent.hippy.qq.module.QQUiModule.10
            @Override // com.tencent.hippy.qq.utils.HippyResultCodeCallback
            public void callBack(HippyMap hippyMap2) {
                promise.resolve(hippyMap2);
            }
        });
    }

    @HippyMethod(name = "saveToPhoto")
    public void saveToPhoto(String str, Promise promise) {
        HippySaveToPhotoHelper.INSTANCE.saveToPhoto(str, promise, new Function2() { // from class: com.tencent.hippy.qq.module.r
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$saveToPhoto$3;
                lambda$saveToPhoto$3 = QQUiModule.this.lambda$saveToPhoto$3((String) obj, (Float) obj2);
                return lambda$saveToPhoto$3;
            }
        }, getActivity());
    }

    @HippyMethod(name = "screenShot")
    public void screenShot(HippyMap hippyMap, final Promise promise) {
        int i3 = hippyMap.getInt(ROOTVIEW_ID);
        if (getHippyQQEngine() != null && getHippyQQEngine().getHippyRootView() != null) {
            View findViewById = getHippyQQEngine().getHippyRootView().findViewById(i3);
            if (findViewById != null) {
                new ScreenShotHelper().screenShot(findViewById, new ScreenShotHelper.ScreenShotResultCallBack() { // from class: com.tencent.hippy.qq.module.QQUiModule.8
                    @Override // com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper.ScreenShotResultCallBack
                    public void callback(int i16, @NotNull String str) {
                        HippyMap hippyMap2 = new HippyMap();
                        hippyMap2.pushInt("retCode", i16);
                        hippyMap2.pushString(QQUiModule.IMG_PATH, str);
                        promise.resolve(hippyMap2);
                    }
                });
                return;
            }
            return;
        }
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushInt("retCode", -1);
        promise.resolve(hippyMap2);
    }

    @HippyMethod(name = "setStatusBarDarkFont")
    public void setStatusBarDarkFont(final boolean z16) {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.hippy.qq.module.QQUiModule.3
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = QQUiModule.this.getActivity();
                    QBaseFragment fragment = QQUiModule.this.getFragment();
                    if (activity2 != null && fragment != null) {
                        Bundle bundle = fragment.getArguments().getBundle("params");
                        if (bundle != null) {
                            bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, z16);
                        }
                        if (fragment.getUserVisibleHint()) {
                            com.tencent.mobileqq.qwallet.utils.d.b(QQUiModule.this.getActivity(), z16);
                        }
                    }
                }
            });
        } else {
            QLog.e(CLASSNAME, 1, "setStatusBarDarkFont activity is null");
        }
    }

    @HippyMethod(name = "shareArkMessage")
    public void shareArkMessage(String str, Promise promise) {
        shareArkMessage(str, promise, true);
    }

    @HippyMethod(name = "shareArkMessageSafe")
    public void shareArkMessageSafe(String str, Promise promise) {
        shareArkMessage(str, promise, false);
    }

    @HippyMethod(name = "shareImage")
    public void shareImage(HippyMap hippyMap, final Promise promise) {
        ShareImageUtils.shareImage(hippyMap.getString(IMG_PATH), hippyMap.getInt("type"), getFragment(), new ShareImageUtils.ShareResultCallBack() { // from class: com.tencent.hippy.qq.module.QQUiModule.9
            @Override // com.tencent.hippy.qq.utils.screenshot.ShareImageUtils.ShareResultCallBack
            public void callBack(int i3) {
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushInt("retCode", i3);
                promise.resolve(hippyMap2);
            }
        });
    }

    @HippyMethod(name = "shareMessage")
    public void shareMessage(String str, Promise promise) {
        if (!TextUtils.isEmpty(str)) {
            Activity activity = getActivity();
            AppInterface appInterface = getAppInterface();
            if ((activity instanceof QBaseActivity) && appInterface != null) {
                QBaseActivity qBaseActivity = (QBaseActivity) activity;
                if (this.mShareMsgImpl == null) {
                    this.mShareMsgImpl = new ShareMsgImpl(qBaseActivity, qBaseActivity, appInterface, this.mShareMsgImplListener);
                }
                try {
                    this.mShareMsgPromise = null;
                    JSONObject jSONObject = new JSONObject(str);
                    if (promise != null) {
                        jSONObject.put("callback", promise.getCallId());
                        this.mShareMsgPromise = promise;
                    }
                    this.mShareMsgImpl.r(jSONObject.toString(), false);
                    return;
                } catch (Throwable th5) {
                    QLog.e(CLASSNAME, 1, "shareMessage error:" + th5);
                    return;
                }
            }
            QLog.e(CLASSNAME, 1, "shareMessage activity isn'o't BaseActivity or appinterface is null");
        }
    }

    @HippyMethod(name = "showActionSheet")
    public void showActionSheet(final String str, final Promise promise) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(CLASSNAME, 1, "showActionSheet params is empty");
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.module.QQUiModule.7
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    boolean z16;
                    if (QQUiModule.this.mActionSheet != null) {
                        if (QQUiModule.this.mActionSheet.isShowing()) {
                            QQUiModule.this.mActionSheet.dismiss();
                        }
                        if (str.equals(QQUiModule.this.mActionSheetParamStr)) {
                            QQUiModule.this.mActionSheetPromise = promise;
                            QQUiModule.this.mActionSheet.show();
                            return;
                        }
                    }
                    Activity activity = QQUiModule.this.getActivity();
                    if (activity == null) {
                        QLog.e(QQUiModule.CLASSNAME, 1, "showActionSheet activity is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        ActionSheet create = ActionSheet.create(activity);
                        String optString = jSONObject.optString("title");
                        if (!TextUtils.isEmpty(optString)) {
                            create.setMainTitle(optString);
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray("items");
                        int optInt = jSONObject.optInt("selected", -1);
                        QQUiModule.this.mActionSheetIsCancle = false;
                        String optString2 = jSONObject.optString("close");
                        if (!TextUtils.isEmpty(optString2)) {
                            QQUiModule.this.mActionSheetIsCancle = true;
                            create.addButton(optString2, 3);
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            int length = optJSONArray.length();
                            if (optInt >= 0 && optInt < length) {
                                for (int i16 = 0; i16 < length; i16++) {
                                    String string = optJSONArray.getString(i16);
                                    if (i16 == optInt) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    create.addRadioButton(string, z16);
                                }
                            } else {
                                for (int i17 = 0; i17 < length; i17++) {
                                    create.addButton(optJSONArray.getString(i17));
                                }
                            }
                            i3 += length;
                        }
                        String optString3 = jSONObject.optString("cancel");
                        if (!TextUtils.isEmpty(optString3)) {
                            create.addCancelButton(optString3);
                        }
                        create.setOnButtonClickListener(QQUiModule.this);
                        create.setOnDismissListener(QQUiModule.this);
                        create.setOnCancelListener(QQUiModule.this);
                        create.registerWatchDisMissActionListener(QQUiModule.this);
                        QQUiModule.this.mActionSheet = create;
                        QQUiModule.this.mActionSheetPromise = promise;
                        QQUiModule qQUiModule = QQUiModule.this;
                        qQUiModule.mActionSheetItemCount = i3;
                        qQUiModule.mActionSheetParamStr = str;
                        QQUiModule.this.mActionSheet.show();
                    } catch (Exception e16) {
                        QLog.e(QQUiModule.CLASSNAME, 2, "showActionSheet error:" + e16.getMessage());
                    }
                }
            });
        }
    }

    @HippyMethod(name = "showDialog")
    public void showDialog(String str, final Promise promise) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.module.QQUiModule.6
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = QQUiModule.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.hippy.qq.module.QQUiModule.6.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                if (i3 == 0) {
                                    promise.resolve("{\"button\":1}");
                                } else if (i3 == 1) {
                                    promise.resolve("{\"button\":0}");
                                }
                            }
                        };
                        UiApiPlugin.C0(activity, jSONObject, onClickListener, onClickListener, new DialogInterface.OnCancelListener() { // from class: com.tencent.hippy.qq.module.QQUiModule.6.2
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                promise.resolve("{\"button\": -1}");
                            }
                        });
                        return;
                    }
                    QLog.e(QQUiModule.CLASSNAME, 1, "showDialog activity is finish");
                }
            });
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @HippyMethod(name = "showKuiklyFloat")
    public void showKuiklyFloat(String str) {
        try {
            ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).openKuiklyFloatDialog(getActivity(), new JSONObject(str));
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, th5, new Object[0]);
        }
    }

    @HippyMethod(name = "showProfile")
    public void showProfile(String str) {
        if (!TextUtils.isEmpty(str)) {
            Activity activity = getActivity();
            AppInterface appInterface = getAppInterface();
            if ((activity instanceof QBaseActivity) && appInterface != null) {
                ((IPublicAccountJavascriptInterface) QRoute.api(IPublicAccountJavascriptInterface.class)).excuteShowProfile(appInterface, (QBaseActivity) activity, str);
            } else {
                QLog.e(CLASSNAME, 1, "showProfile activity isvnot BaseActivity or appInterface is null");
            }
        }
    }

    @HippyMethod(name = "showSharePanel")
    public void showSharePanel(String str, Promise promise) {
        HippySharePanelHelper.INSTANCE.showSharePanel(str, promise, getActivity());
    }

    @HippyMethod(name = "showTips")
    public void showTips(final String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.module.QQUiModule.4
                @Override // java.lang.Runnable
                public void run() {
                    UiApiPlugin.F0(QQUiModule.this.getActivity(), str);
                }
            });
        }
    }

    @HippyMethod(name = "toggleToFullScreen")
    public void toggleToFullScreen(HippyMap hippyMap, Promise promise) {
        QLog.i(CLASSNAME, 1, "toggleToFullScreen jsonParam:" + hippyMap);
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().getDecorView();
            if (hippyMap != null && hippyMap.size() != 0 && hippyMap.containsKey(ReportConst.ACTION.FULLSCREEN)) {
                try {
                    View decorView = activity.getWindow().getDecorView();
                    if (hippyMap.getBoolean(ReportConst.ACTION.FULLSCREEN)) {
                        toFullScreen(activity, decorView, promise);
                    } else {
                        cancelFullScreen(activity, decorView, promise);
                    }
                    return;
                } catch (Exception e16) {
                    HippyMap callbackHippyMap = getCallbackHippyMap(-3, "\u5f02\u5e38:" + e16.getMessage());
                    callbackHippyMap.pushBoolean("result", false);
                    promise.reject(callbackHippyMap);
                    return;
                }
            }
            HippyMap callbackHippyMap2 = getCallbackHippyMap(-2, "\u53c2\u6570\u4e3a\u7a7a");
            callbackHippyMap2.pushBoolean("result", false);
            promise.reject(callbackHippyMap2);
            return;
        }
        HippyMap callbackHippyMap3 = getCallbackHippyMap(-1, "\u7cfb\u7edf\u9519\u8bef");
        callbackHippyMap3.pushBoolean("result", false);
        promise.reject(callbackHippyMap3);
    }

    private void shareArkMessage(String str, Promise promise, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Activity activity = getActivity();
        AppInterface appInterface = getAppInterface();
        if ((activity instanceof QBaseActivity) && appInterface != null) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            if (this.mShareMsgImpl == null) {
                this.mShareMsgImpl = new ShareMsgImpl(qBaseActivity, qBaseActivity, appInterface, this.mShareMsgImplListener);
            }
            try {
                this.mShareMsgPromise = null;
                JSONObject jSONObject = new JSONObject(str);
                if (promise != null) {
                    jSONObject.put("callback", promise.getCallId());
                    this.mShareMsgPromise = promise;
                }
                this.mShareMsgImpl.o(jSONObject.toString(), z16);
                return;
            } catch (Throwable th5) {
                QLog.e(CLASSNAME, 1, "shareMessage error:" + th5);
                return;
            }
        }
        QLog.e(CLASSNAME, 1, "shareArkMessage activity isn'o't BaseActivity or appinterface is null");
    }
}
