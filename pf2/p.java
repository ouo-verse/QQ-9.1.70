package pf2;

import Wallet.AcsBatchSubNoticeRsp;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.module.QQUiModule;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJE\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J=\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J=\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002JE\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b\u00a8\u0006\u001c"}, d2 = {"Lpf2/p;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule;", "module", "Lorg/json/JSONObject;", "paramsObj", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "f", "r", "o", "Lcom/tencent/common/app/AppInterface;", "k", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u000e\u001a\u00020\u00062+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lpf2/p$a;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "", "code", "", "msg", "data", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pf2.p$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public static /* synthetic */ void b(Companion companion, Function1 function1, int i3, String str, String str2, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                str = "";
            }
            if ((i16 & 8) != 0) {
                str2 = "";
            }
            companion.a(function1, i3, str, str2);
        }

        public final void a(Function1<Object, Unit> callback, int code, String msg2, String data) {
            if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", code);
                if (msg2 != null) {
                    jSONObject.put("msg", msg2);
                }
                if (data != null) {
                    jSONObject.put("data", data);
                }
                callback.invoke(jSONObject);
            }
        }
    }

    private final void f(JSONObject paramsObj, final Function1<Object, Unit> callback) {
        JSONArray optJSONArray = paramsObj.optJSONArray("msg_id_list");
        String optString = paramsObj.optString("domain");
        ArrayList<String> arrayList = new ArrayList<>();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    arrayList.add(optJSONArray.getString(i3));
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQNotifyImpl", 2, e16, new Object[0]);
                    }
                }
            }
        }
        AppInterface k3 = k();
        IQQReminderService iQQReminderService = k3 != null ? (IQQReminderService) k3.getRuntimeService(IQQReminderService.class, "") : null;
        if (iQQReminderService == null) {
            return;
        }
        iQQReminderService.sendBatchSubscribeReminder(arrayList, optString, new BusinessObserver() { // from class: pf2.l
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i16, boolean z16, Bundle bundle) {
                p.g(Function1.this, i16, z16, bundle);
            }
        });
    }

    private final void h(QQUIModule module, JSONObject paramsObj, final Function1<Object, Unit> callback) {
        String optString = paramsObj.optString("msgid");
        String optString2 = paramsObj.optString("busiid");
        String optString3 = paramsObj.optString("domain");
        QLog.i("QQNotifyImpl", 2, "deleteNotify: msgId: " + optString + ", busiId: " + optString2 + ", domain: " + optString3);
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2) && !StringUtil.isEmpty(optString3)) {
            AppInterface k3 = k();
            IQQReminderService iQQReminderService = k3 != null ? (IQQReminderService) k3.getRuntimeService(IQQReminderService.class, "") : null;
            if (iQQReminderService == null) {
                return;
            }
            iQQReminderService.sendDelReminderListById(optString, 0L, 2, new BusinessObserver() { // from class: pf2.k
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    p.i(Function1.this, i3, z16, bundle);
                }
            });
            IRuntimeService runtimeService = BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderCalendarService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getApplication().runtime\u2026va, ProcessConstant.MAIN)");
            IQQReminderCalendarService iQQReminderCalendarService = (IQQReminderCalendarService) runtimeService;
            CalendarEntity calendarEntity = new CalendarEntity();
            calendarEntity.msg_id = optString;
            Activity activity = module.getActivity();
            iQQReminderCalendarService.deleteCalendarAlarm(activity instanceof AppActivity ? (AppActivity) activity : null, calendarEntity);
            return;
        }
        Companion.b(INSTANCE, callback, 4, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final Function1 function1, final int i3, final boolean z16, final Bundle bundle) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: pf2.o
            @Override // java.lang.Runnable
            public final void run() {
                p.j(i3, z16, bundle, function1);
            }
        });
    }

    private final AppInterface k() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void l(QQUIModule module, JSONObject paramsObj, Function1<Object, Unit> callback) {
        String optString = paramsObj.optString("msgid");
        String optString2 = paramsObj.optString("busiid");
        String optString3 = paramsObj.optString("domain");
        module.T(null);
        module.T(callback);
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
            ae.p(module.getActivity(), optString, optString3, optString2, QQNotifySettingBaseFragment.U);
        } else {
            Companion.b(INSTANCE, callback, -1, null, null, 12, null);
        }
    }

    private final void n(QQUIModule module, JSONObject paramsObj, Function1<Object, Unit> callback) {
        String optString = paramsObj.optString("msgid");
        String optString2 = paramsObj.optString("busiid");
        String optString3 = paramsObj.optString("domain");
        module.T(null);
        module.T(callback);
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
            ae.k(optString, optString3, optString2, module);
        } else {
            Companion.b(INSTANCE, callback, -1, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, Bundle bundle, Bundle bundle2) {
        Companion.b(INSTANCE, function1, bundle.getInt("retcode"), bundle.getString("retmsg"), null, 8, null);
    }

    private final void q(QQUIModule module, JSONObject paramsObj, Function1<Object, Unit> callback) {
        String optString = paramsObj.optString("msgid");
        String optString2 = paramsObj.optString("busiid");
        String optString3 = paramsObj.optString("domain");
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2) && !StringUtil.isEmpty(optString3)) {
            module.T(null);
            module.T(callback);
            QQNotifySettingInnerFragment.Ih(module.getActivity(), optString, optString2, optString3);
            return;
        }
        Companion.b(INSTANCE, callback, -1, null, null, 12, null);
    }

    private final void r(JSONObject paramsObj, final Function1<Object, Unit> callback) {
        String optString = paramsObj.optString("msgid");
        String optString2 = paramsObj.optString("busiid");
        String optString3 = paramsObj.optString("domain");
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
            ae.s(optString, optString3, optString2, new ae.c() { // from class: pf2.m
                @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
                public final void onResult(Bundle bundle, Bundle bundle2) {
                    p.s(Function1.this, bundle, bundle2);
                }
            });
        } else {
            Companion.b(INSTANCE, callback, -1, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 function1, Bundle bundle, Bundle bundle2) {
        Companion.b(INSTANCE, function1, bundle.getInt("retcode"), bundle.getString("retmsg"), null, 8, null);
    }

    public final void m(QQUIModule module, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            if (TextUtils.isEmpty(params)) {
                Companion.b(INSTANCE, callback, -1, "no params", null, 8, null);
                return;
            }
            Intrinsics.checkNotNull(params);
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (QLog.isColorLevel()) {
                QLog.i("QQNotifyImpl", 2, "qqNotify: action " + optString + ",paramsObj: " + optJSONObject);
            }
            if (optJSONObject == null) {
                Companion.b(INSTANCE, callback, -1, "no params", null, 8, null);
                return;
            }
            if (Intrinsics.areEqual("newSubscribe", optString)) {
                l(module, optJSONObject, callback);
                return;
            }
            if (Intrinsics.areEqual("query", optString)) {
                n(module, optJSONObject, callback);
                return;
            }
            if (Intrinsics.areEqual("subscribe", optString)) {
                q(module, optJSONObject, callback);
                return;
            }
            if (Intrinsics.areEqual("delete", optString)) {
                h(module, optJSONObject, callback);
                return;
            }
            if (Intrinsics.areEqual(QQUiModule.METHOD_ACTION_NOTIFY_BATCH_SUBSCRIBE, optString)) {
                f(optJSONObject, callback);
            } else if (Intrinsics.areEqual("subscribe_directly", optString)) {
                r(optJSONObject, callback);
            } else if (Intrinsics.areEqual("subscribeCalendarDirectly", optString)) {
                o(module, optJSONObject, callback);
            }
        } catch (Throwable th5) {
            QLog.e("QQNotifyImpl", 2, "qqNotify error:" + th5.getMessage());
        }
    }

    private final void o(QQUIModule module, JSONObject paramsObj, final Function1<Object, Unit> callback) {
        String optString = paramsObj.optString("domain");
        String optString2 = paramsObj.optString("msgid");
        String optString3 = paramsObj.optString("busiid");
        String optString4 = paramsObj.optString("ifAddCalendar");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            AppInterface k3 = k();
            Activity activity = module.getActivity();
            ae.r(k3, activity instanceof AppActivity ? (AppActivity) activity : null, optString2, optString, optString3, optString4, new ae.c() { // from class: pf2.n
                @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
                public final void onResult(Bundle bundle, Bundle bundle2) {
                    p.p(Function1.this, bundle, bundle2);
                }
            });
            return;
        }
        Companion.b(INSTANCE, callback, -1, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, int i3, boolean z16, Bundle bundle) {
        try {
            if (i3 == 2007 && z16) {
                AcsBatchSubNoticeRsp acsBatchSubNoticeRsp = (AcsBatchSubNoticeRsp) bundle.getSerializable("rsp");
                if (acsBatchSubNoticeRsp != null) {
                    QLog.i("QQNotifyImpl", 2, "batchSubscribeNotify#onReceive, rsp retCode:" + acsBatchSubNoticeRsp.ret_code);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("success_count", acsBatchSubNoticeRsp.succeed_count);
                    jSONObject.put("retry_msgs", acsBatchSubNoticeRsp.retry_msgs);
                    INSTANCE.a(function1, acsBatchSubNoticeRsp.ret_code, acsBatchSubNoticeRsp.err_str, jSONObject.toString());
                    ArrayList<AcsMsg> arrayList = acsBatchSubNoticeRsp.msgs;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.msgs");
                    if (!arrayList.isEmpty()) {
                        IRuntimeService runtimeService = BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderDataService.class, "");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApplication().runtime\u2026va, ProcessConstant.MAIN)");
                        IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) runtimeService;
                        Iterator<AcsMsg> it = arrayList.iterator();
                        while (it.hasNext()) {
                            iQQReminderDataService.doNotifyByPush(it.next());
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.i("QQNotifyImpl", 2, "batchSubscribeNotify#onReceive, not success");
        } catch (Exception e16) {
            QLog.e("QQNotifyImpl", 1, "batchSubscribeNotify#onReceive", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, boolean z16, Bundle bundle, Function1 function1) {
        if (i3 == 2001) {
            try {
                if (z16) {
                    AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) bundle.getSerializable("rsp");
                    if (acsDelMsgRsp != null && acsDelMsgRsp.ret_code == 0) {
                        QLog.i("QQNotifyImpl", 2, "@qqnotify req success ");
                        Companion.b(INSTANCE, function1, acsDelMsgRsp.ret_code, acsDelMsgRsp.err_str, null, 8, null);
                    } else if (acsDelMsgRsp != null) {
                        Companion.b(INSTANCE, function1, acsDelMsgRsp.ret_code, acsDelMsgRsp.err_str, null, 8, null);
                        QLog.i("QQNotifyImpl", 2, "@qqnotify ret_code =  " + acsDelMsgRsp.ret_code);
                    }
                } else {
                    Companion.b(INSTANCE, function1, 2, "error", null, 8, null);
                    QLog.i("QQNotifyImpl", 2, "@qqnotify delete faield not success  ");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQNotifyImpl", 1, "sendDelReminderListById onReceive", e16);
                }
                Companion.b(INSTANCE, function1, 3, "exception: " + e16, null, 8, null);
            }
        }
    }
}
