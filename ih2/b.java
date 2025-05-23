package ih2;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0002#$B\u0007\u00a2\u0006\u0004\b!\u0010\"J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J(\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J?\u0010\u0014\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0015\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0016\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0017\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0018\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JG\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002JI\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006%"}, d2 = {"Lih2/b;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "itemId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "appId", "", "action", "j", "r", "d", "l", "p", "o", "", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "i", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "method", "call", "<init>", "()V", "a", "b", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends i01.e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0004\u0018\u0001`\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR;\u0010\u0013\u001a)\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\rj\u0002`\u00110\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lih2/b$b;", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "Ljava/lang/ref/WeakReference;", "Lih2/b;", "d", "Ljava/lang/ref/WeakReference;", "moduleRef", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "e", "callbackRef", "module", "callback", "<init>", "(Lih2/b;Lkotlin/jvm/functions/Function1;)V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ih2.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C10529b implements TianShuGetAdvCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<b> moduleRef;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Function1<Object, Unit>> callbackRef;

        public C10529b(@NotNull b module, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.moduleRef = new WeakReference<>(module);
            this.callbackRef = new WeakReference<>(function1);
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean result, @NotNull TianShuAccess.GetAdsRsp getAdsRsp) {
            Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
            b bVar = this.moduleRef.get();
            Function1<Object, Unit> function1 = this.callbackRef.get();
            if (bVar != null && function1 != null) {
                bVar.i(result, getAdsRsp, function1);
                return;
            }
            QLog.e("GamePubAccountKuiklyModule", 1, "[onGetAdvs] ref is null,module:" + bVar + ",promise:" + function1);
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        GamePubAccountHelper.d();
        QLog.i("GamePubAccountKuiklyModule", 1, "clearGameNoticeCache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean result, TianShuAccess.GetAdsRsp getAdsRsp, Function1<Object, Unit> callback) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (result && getAdsRsp != null) {
            jSONObject = m(getAdsRsp);
            QLog.i("GamePubAccountKuiklyModule", 1, "[reqBubbleNoticeInfo] " + jSONObject);
        } else {
            QLog.i("GamePubAccountKuiklyModule", 1, "[reqBubbleNoticeInfo] response has exception");
            GamePubAccountHelper.d();
        }
        if (callback != null) {
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = null;
            }
            callback.invoke(str);
        }
    }

    private final void j(String itemId, String traceInfo, String appId, int action) {
        com.tencent.mobileqq.qqgamepub.data.a aVar = new com.tencent.mobileqq.qqgamepub.data.a();
        aVar.f264496a = appId;
        aVar.f264499d = itemId;
        aVar.f264500e = traceInfo;
        aVar.f264498c = action;
        ((IQQGameAdService) QRoute.api(IQQGameAdService.class)).reportTianShu(aVar);
    }

    private final void l(String params, Function1<Object, Unit> callback) {
        String str;
        JSONObject q16 = GamePubAccountHelper.q();
        if (callback != null) {
            if (q16 != null) {
                str = q16.toString();
            } else {
                str = null;
            }
            callback.invoke(str);
        }
        QLog.i("GamePubAccountKuiklyModule", 1, "[getGameNoticeCache] " + q16);
    }

    private final JSONObject m(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        try {
            if (getAdsRsp.mapAds.has()) {
                list = getAdsRsp.mapAds.get();
            } else {
                list = null;
            }
            if (list != null && list.size() != 0) {
                TianShuAccess.RspEntry rspEntry = list.get(0);
                if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
                    List<TianShuAccess.AdItem> list2 = pBRepeatMessageField.get();
                    if (list2 != null && list2.size() != 0) {
                        JSONObject b16 = com.tencent.mobileqq.qqgamepub.utils.a.b(list2.get(0));
                        GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("770").setModuleType("77002").setOperId("209300").setExt(2, b16.optString("notice_id")).setExt(4, "18").report();
                        return b16;
                    }
                    QLog.i("GamePubAccountKuiklyModule", 1, "[reqBubbleNoticeInfo] no ads item~");
                    GamePubAccountHelper.d();
                    return null;
                }
                QLog.i("GamePubAccountKuiklyModule", 1, "[reqBubbleNoticeInfo] ads resp param is error.");
                GamePubAccountHelper.d();
                return null;
            }
            GamePubAccountHelper.d();
            return null;
        } catch (Throwable th5) {
            QLog.e("GamePubAccountKuiklyModule", 1, "[handleGetAdvCallback], error: " + th5.getMessage());
            GamePubAccountHelper.d();
            return null;
        }
    }

    private final void o(String params, Function1<Object, Unit> callback) {
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin("GamePubAccountKuiklyModule", Long.parseLong("2747277822")) != null) {
            Intent intent = new Intent();
            intent.putExtra("uin", "2747277822");
            intent.putExtra("chatPage", true);
            Activity activity = getActivity();
            if (activity != null) {
                ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(activity, intent);
                return;
            }
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", "2747277822");
        activityURIRequest.extra().putBoolean("fromQGamePub", true);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    private final void p(String params, Function1<Object, Unit> callback) {
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterAIO(getActivity(), true);
    }

    private final void q(String params, Function1<Object, Unit> callback) {
        if (!TextUtils.isEmpty(params)) {
            try {
                JSONObject jSONObject = new JSONObject(params);
                String itemId = jSONObject.optString("itemId");
                String traceInfo = jSONObject.optString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO);
                String appId = jSONObject.optString("appId");
                int optInt = jSONObject.optInt("action");
                Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
                Intrinsics.checkNotNullExpressionValue(traceInfo, "traceInfo");
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                j(itemId, traceInfo, appId, optInt);
                QLog.i("GamePubAccountKuiklyModule", 1, "[reportBubbleNotice] reportJson:" + jSONObject);
            } catch (Exception e16) {
                QLog.e("GamePubAccountKuiklyModule", 1, e16, new Object[0]);
            }
        }
    }

    private final void r(String params, final Function1<Object, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: ih2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.t(b.this, callback);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(b this$0, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(com.tencent.mobileqq.qqgamepub.utils.a.g(902), new C10529b(this$0, function1));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1611643388:
                if (method.equals("queryMoreMsg")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1564726136:
                if (method.equals("closePubAccount")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -780476271:
                if (method.equals("clearBubbleNoticeCache")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -458451440:
                if (method.equals("reqBubbleNoticeInfo")) {
                    r(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 172825256:
                if (method.equals("getBubbleNoticeCache")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 905255384:
                if (method.equals("reportBubbleNotice")) {
                    q(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1880106803:
                if (method.equals("openPubDetailPage")) {
                    o(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    private final void g(String params, Function1<Object, Unit> callback) {
    }
}
