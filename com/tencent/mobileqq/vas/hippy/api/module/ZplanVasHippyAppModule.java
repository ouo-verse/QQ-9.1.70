package com.tencent.mobileqq.vas.hippy.api.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.social.hippy.SquareHippyManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.action.h;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.c2c.ZootopiaC2CAvatarFragment;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.library.components.fragments.LibraryCalendarComponent;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.MoveType;
import com.tencent.state.square.components.SquareGroupUiComponent;
import com.tencent.state.square.detail.MainScene;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import sd3.f;
import zb3.ZootopiaShareArkInfo;

/* compiled from: P */
@HippyNativeModule(name = ZplanVasHippyAppModule.TAG)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010$\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010%\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010&\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010'\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010(\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010)\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007J,\u00100\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u001a\u00102\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010.H\u0016J\b\u00103\u001a\u00020\nH\u0016R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/module/ZplanVasHippyAppModule;", "Lcom/tencent/hippy/qq/module/QQBaseLifecycleModule;", "", "groupId", ZplanVasHippyAppModule.TARGET_ID_KEY, ZplanVasHippyAppModule.SUB_TEXT_KEY, "", ZplanVasHippyAppModule.SUB_SOURCE_KEY, "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "sendArkToGroup", "errCode", "errMsg", "", "", "ext", "promiseResult", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "findVasBaseFragment", AdMetricTag.EVENT_NAME, "Lcom/tencent/mtt/hippy/common/HippyMap;", "hippyMap", "sendEvent", "readableMap", "shareArkToGroup", "shareArkToGuild", "updateSquareFriendPickerNums", SquareJSConst.Method.METHOD_HIPPY_REFRESH_SQUARE, LibraryCalendarComponent.METHOD_HIPPY_AWARD_LIBRARY_MOTION, "params", "pop", "sharePoster", "addToSquare", SquareJSConst.Method.METHOD_HIPPY_ADD_LIST_SQUARE, "publish", "locateToAvatar", "dismissHippyPanel", "startAvatarRecord", "openFriendSelector", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "intent", "onNewIntent", "destroy", "Lcom/tencent/mobileqq/vas/social/hippy/SquareHippyManager;", "square$delegate", "Lkotlin/Lazy;", "getSquare", "()Lcom/tencent/mobileqq/vas/social/hippy/SquareHippyManager;", "square", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasHippyAppModule extends QQBaseLifecycleModule {
    private static final String CHANNEL_ID_KEY = "channelId";
    private static final String GROUP_ID_KEY = "groupId";
    private static final String GUILD_ID_KEY = "guildId";
    private static final String GUILD_ID_TYPE_KEY = "guildIdType";
    private static final String RESULT_MESSAGE = "message";
    private static final String RESULT_RET_CODE = "retCode";
    private static final String SUB_SOURCE_KEY = "subSource";
    private static final String SUB_TEXT_KEY = "subText";
    private static final String TAG = "ZplanVasHippyAppModule";
    private static final String TARGET_ID_KEY = "targetId";

    /* renamed from: square$delegate, reason: from kotlin metadata */
    private final Lazy square;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/hippy/api/module/ZplanVasHippyAppModule$c", "Lcom/tencent/mobileqq/zplan/share/action/c;", "", "f", "t", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zplan.share.action.c {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.share.action.c
        public void f() {
            ZplanVasHippyAppModule.this.sendEvent("shareBarAppear", new HippyMap());
        }

        @Override // com.tencent.mobileqq.zplan.share.action.c
        public void t() {
            ZplanVasHippyAppModule.this.sendEvent("shareBarDisappear", new HippyMap());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanVasHippyAppModule(HippyEngineContext context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareHippyManager>() { // from class: com.tencent.mobileqq.vas.hippy.api.module.ZplanVasHippyAppModule$square$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareHippyManager invoke() {
                return new SquareHippyManager();
            }
        });
        this.square = lazy;
    }

    private final SquareHippyManager getSquare() {
        return (SquareHippyManager) this.square.getValue();
    }

    private final void promiseResult(Promise promise, int errCode, String errMsg, Map<String, ? extends Object> ext) {
        Set<Map.Entry<String, ? extends Object>> entrySet;
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", errCode);
        hippyMap.pushString("message", errMsg);
        if (ext != null && (entrySet = ext.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                hippyMap.pushObject((String) entry.getKey(), entry.getValue());
            }
        }
        promise.resolve(hippyMap);
    }

    private final void sendArkToGroup(String groupId, String targetId, String subText, int subSource, Promise promise) {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                return;
            }
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
            z23.c.b(new z23.c(), appInterface, AdMetricID.Click.SUCCESS, 0, new b(targetId, subSource, qBaseActivity, this, promise, groupId, subText), 4, null);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "sendArkToGroup fail " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(String eventName, HippyMap hippyMap) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(eventName, hippyMap);
    }

    @HippyMethod(name = SquareJSConst.Method.METHOD_HIPPY_ADD_LIST_SQUARE)
    public final void addListToSquare(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 2, SquareJSConst.Method.METHOD_HIPPY_ADD_LIST_SQUARE);
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).onHippyMethodCall(SquareJSConst.Method.METHOD_HIPPY_ADD_LIST_SQUARE, params, promise);
        promiseResult$default(this, promise, 0, null, null, 8, null);
    }

    @HippyMethod(name = LibraryCalendarComponent.METHOD_HIPPY_AWARD_LIBRARY_MOTION)
    public final void awardLibraryMotion(HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 2, LibraryCalendarComponent.METHOD_HIPPY_AWARD_LIBRARY_MOTION);
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).onHippyMethodCall(LibraryCalendarComponent.METHOD_HIPPY_AWARD_LIBRARY_MOTION, readableMap, promise);
        promiseResult$default(this, promise, 0, null, null, 8, null);
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        getSquare().g();
    }

    @HippyMethod(name = "dismissHalfModalView")
    public final void dismissHippyPanel(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i(TAG, 1, "dismissHippyPanel.");
        Fragment parentFragment = getFragment().getParentFragment();
        ZootopiaC2CAvatarFragment zootopiaC2CAvatarFragment = parentFragment instanceof ZootopiaC2CAvatarFragment ? (ZootopiaC2CAvatarFragment) parentFragment : null;
        HippyMap hippyMap = new HippyMap();
        if (zootopiaC2CAvatarFragment == null) {
            QLog.e(TAG, 1, "dismissHippyPanel: current hippy page is not in a panel fragment.");
            hippyMap.pushInt("result", -1);
        } else {
            zootopiaC2CAvatarFragment.dismissAllowingStateLoss();
            hippyMap.pushInt("result", 0);
        }
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "locateToAvatar")
    public final void locateToAvatar(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final String uin = params.getString("uin");
        QLog.i(TAG, 1, "locateToAvatar: uin=" + uin);
        VasBaseFragment findVasBaseFragment = findVasBaseFragment(getFragment());
        final SquareGroupUiComponent squareGroupUiComponent = findVasBaseFragment != null ? (SquareGroupUiComponent) findVasBaseFragment.getComponent(SquareGroupUiComponent.class, null, null) : null;
        HippyMap hippyMap = new HippyMap();
        if (squareGroupUiComponent != null) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            squareGroupUiComponent.locateTo(uin, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.hippy.api.module.ZplanVasHippyAppModule$locateToAvatar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        SquareGroupUiComponent squareGroupUiComponent2 = SquareGroupUiComponent.this;
                        String uin2 = uin;
                        Intrinsics.checkNotNullExpressionValue(uin2, "uin");
                        squareGroupUiComponent2.playRing(uin2);
                    }
                }
            });
            hippyMap.pushInt("result", 0);
        } else {
            QLog.e(TAG, 1, "locateToAvatar: activity(" + getActivity() + ") has not SquareActivityUiComponent");
            hippyMap.pushInt("result", -1);
        }
        promise.resolve(hippyMap);
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        getSquare().c(data, requestCode, resultCode);
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onNewIntent(activity, intent);
    }

    @HippyMethod(name = "openFriendSelector")
    public final void openFriendSelector(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        SquareHippyManager square = getSquare();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        square.e(activity, params, promise);
    }

    @HippyMethod(name = "pop")
    public final void pop(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        HippyMap hippyMap = new HippyMap();
        Activity activity = getActivity();
        if (activity == null) {
            hippyMap.pushInt("retCode", -1);
            hippyMap.pushString("errMsg", "activity is null.");
        } else {
            QBaseFragment fragment = getFragment();
            FragmentManager fragmentManager = fragment.getFragmentManager();
            if (fragmentManager == null) {
                activity.finish();
                if (params.getBoolean("animated")) {
                    activity.overridePendingTransition(0, R.anim.f154376jx);
                }
            } else {
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
                if (params.getBoolean("animated")) {
                    beginTransaction.setCustomAnimations(0, R.anim.f154376jx, 0, R.anim.f154376jx);
                }
                beginTransaction.remove(fragment).commitAllowingStateLoss();
            }
            hippyMap.pushInt("retCode", 0);
        }
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "publish")
    public final void publish(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 2, "publish");
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).onHippyMethodCall("publish", params, promise);
    }

    @HippyMethod(name = SquareJSConst.Method.METHOD_HIPPY_REFRESH_SQUARE)
    public final void refreshSquare(HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 2, SquareJSConst.Method.METHOD_HIPPY_REFRESH_SQUARE);
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).onHippyMethodCall(SquareJSConst.Method.METHOD_HIPPY_REFRESH_SQUARE, readableMap, promise);
        promiseResult$default(this, promise, 0, null, null, 8, null);
    }

    @HippyMethod(name = "shareArkToGroup")
    public final void shareArkToGroup(HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        long j3 = readableMap.getLong("groupId");
        long j16 = readableMap.getLong(TARGET_ID_KEY);
        sendArkToGroup(String.valueOf(j3), String.valueOf(j16), readableMap.getString(SUB_TEXT_KEY), readableMap.getInt(SUB_SOURCE_KEY), promise);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    @HippyMethod(name = "shareArkToGuild")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void shareArkToGuild(HippyMap readableMap, final Promise promise) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (!(qBaseActivity instanceof Context)) {
            qBaseActivity = null;
        }
        QBaseActivity qBaseActivity2 = qBaseActivity;
        if (qBaseActivity2 == null) {
            v.f373305a.c(R.string.xdu, "context");
            promiseResult$default(this, promise, -1, "context is null", null, 8, null);
            return;
        }
        String hintText = readableMap.getString(SUB_TEXT_KEY);
        f fVar = f.f433689a;
        Bundle bundle = new Bundle();
        bundle.putString("g_guildId", readableMap.getString("guildId"));
        bundle.putString("g_channelId", readableMap.getString("channelId"));
        bundle.putLong("g_targetUin", readableMap.getLong(TARGET_ID_KEY));
        bundle.putInt("g_guildIdType", readableMap.getInt("guildIdType"));
        if (hintText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(hintText);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    hintText = "\u6765\u6211\u7684\u5c0f\u7a9d\u5750\u5750\u5427\uff5e";
                } else {
                    Intrinsics.checkNotNullExpressionValue(hintText, "hintText");
                }
                bundle.putString("g_subText", hintText);
                bundle.putString("g_subSource", readableMap.getString(SUB_SOURCE_KEY));
                Unit unit = Unit.INSTANCE;
                fVar.g(qBaseActivity2, AdMetricID.Click.SUCCESS, 3, bundle, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.hippy.api.module.ZplanVasHippyAppModule$shareArkToGuild$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        invoke(num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, String str) {
                        if (i3 != 0) {
                            v.f373305a.c(R.string.xdu, str);
                        }
                        ZplanVasHippyAppModule.promiseResult$default(ZplanVasHippyAppModule.this, promise, i3, str, null, 8, null);
                    }
                });
            }
        }
        z16 = true;
        if (!z16) {
        }
        bundle.putString("g_subText", hintText);
        bundle.putString("g_subSource", readableMap.getString(SUB_SOURCE_KEY));
        Unit unit2 = Unit.INSTANCE;
        fVar.g(qBaseActivity2, AdMetricID.Click.SUCCESS, 3, bundle, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.hippy.api.module.ZplanVasHippyAppModule$shareArkToGuild$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String str) {
                if (i3 != 0) {
                    v.f373305a.c(R.string.xdu, str);
                }
                ZplanVasHippyAppModule.promiseResult$default(ZplanVasHippyAppModule.this, promise, i3, str, null, 8, null);
            }
        });
    }

    @HippyMethod(name = "recordAvatar")
    public final void startAvatarRecord(HippyMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        getSquare().d(params, promise);
    }

    @HippyMethod(name = SquareJSConst.Method.METHOD_HIPPY_UPDATE_FRIEND_PICK)
    public final void updateSquareFriendPickerNums(HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 2, "updateSquareFriendPickerNums");
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).onHippyMethodCall(SquareJSConst.Method.METHOD_HIPPY_UPDATE_FRIEND_PICK, readableMap, promise);
        promiseResult$default(this, promise, 0, null, null, 8, null);
    }

    private final VasBaseFragment findVasBaseFragment(Fragment fragment) {
        while (fragment != null) {
            try {
                if (fragment instanceof VasBaseFragment) {
                    return (VasBaseFragment) fragment;
                }
                fragment = fragment.getParentFragment();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "findVasBaseFragment err.", th5);
                return null;
            }
        }
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/hippy/api/module/ZplanVasHippyAppModule$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/o;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<ZootopiaShareArkInfo> {
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f309481d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f309482e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f309483f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZplanVasHippyAppModule f309484h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Promise f309485i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f309486m;

        b(String str, int i3, Context context, ZplanVasHippyAppModule zplanVasHippyAppModule, Promise promise, String str2, String str3) {
            this.f309481d = str;
            this.f309482e = i3;
            this.f309483f = context;
            this.f309484h = zplanVasHippyAppModule;
            this.f309485i = promise;
            this.f309486m = str2;
            this.C = str3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZplanVasHippyAppModule.promiseResult$default(this.f309484h, this.f309485i, error, message, null, 8, null);
            QLog.e(ZplanVasHippyAppModule.TAG, 1, "sendArkToGroup fail " + error + " " + message);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(ZootopiaShareArkInfo result) {
            boolean z16;
            boolean isBlank;
            Intrinsics.checkNotNullParameter(result, "result");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("visitUin", this.f309481d);
            jSONObject.put(ZplanVasHippyAppModule.SUB_SOURCE_KEY, this.f309482e);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "info.toString()");
            result.h(jSONObject2);
            result.l(2);
            Context context = this.f309483f;
            String str = this.f309486m;
            String str2 = this.C;
            f fVar = f.f433689a;
            if (str2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        str2 = "\u6765\u6211\u7684\u5c0f\u7a9d\u5750\u5750\u5427\uff5e";
                    }
                    fVar.k(context, result, 1, str, str2, true);
                    ZplanVasHippyAppModule.promiseResult$default(this.f309484h, this.f309485i, 0, "success", null, 8, null);
                    QLog.i(ZplanVasHippyAppModule.TAG, 1, "sendArkToGroup success");
                }
            }
            z16 = true;
            if (z16) {
            }
            fVar.k(context, result, 1, str, str2, true);
            ZplanVasHippyAppModule.promiseResult$default(this.f309484h, this.f309485i, 0, "success", null, 8, null);
            QLog.i(ZplanVasHippyAppModule.TAG, 1, "sendArkToGroup success");
        }
    }

    @HippyMethod(name = "addToSquare")
    public final void addToSquare(HippyMap params, Promise promise) {
        List listOf;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String uin = params.getString("uin");
        int i3 = params.getInt("type");
        QLog.i(TAG, 1, "addToSquare: uin=" + uin + ", type=" + i3);
        VasBaseFragment findVasBaseFragment = findVasBaseFragment(getFragment());
        SquareGroupUiComponent squareGroupUiComponent = findVasBaseFragment != null ? (SquareGroupUiComponent) findVasBaseFragment.getComponent(SquareGroupUiComponent.class, null, null) : null;
        final HippyMap hippyMap = new HippyMap();
        if (squareGroupUiComponent != null) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            final MoveItem moveItem = new MoveItem(uin, i3, false, null, 12, null);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(moveItem);
            squareGroupUiComponent.addMultiRoles(listOf, 5, MainScene.HIPPY, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.mobileqq.vas.hippy.api.module.ZplanVasHippyAppModule$addToSquare$1

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes35.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f309480a;

                    static {
                        int[] iArr = new int[MoveType.values().length];
                        try {
                            iArr[MoveType.AddToSquare.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[MoveType.AlreadyInSquare.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[MoveType.NoPlace.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f309480a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map) {
                    invoke2((Map<MoveItem, MoveResult>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<MoveItem, MoveResult> moveResult) {
                    Intrinsics.checkNotNullParameter(moveResult, "moveResult");
                    int i16 = 1;
                    QLog.e("ZplanVasHippyAppModule", 1, "addToSquare: moveResult=" + moveResult);
                    MoveResult moveResult2 = moveResult.get(MoveItem.this);
                    MoveType type = moveResult2 != null ? moveResult2.getType() : null;
                    int i17 = type == null ? -1 : a.f309480a[type.ordinal()];
                    if (i17 == 1) {
                        i16 = 0;
                    } else if (i17 != 2) {
                        i16 = i17 != 3 ? -1 : 2;
                    }
                    hippyMap.pushInt("result", i16);
                }
            });
        } else {
            QLog.e(TAG, 1, "addToSquare: activity(" + getActivity() + ") has not SquareActivityUiComponent");
            hippyMap.pushInt("result", -2);
        }
        promise.resolve(hippyMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007e  */
    @HippyMethod(name = "sharePoster")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sharePoster(HippyMap params, Promise promise) {
        boolean z16;
        Map mutableMapOf;
        HippyMap hippyMap;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String string = params.getString("imagePath");
        int i3 = params.getInt("shareType");
        boolean z17 = params.getBoolean("noMask");
        int i16 = params.getInt("shareFrom");
        QLog.d(TAG, 2, "sharePoster imagePath:" + string + ", shareType:" + i3 + ", noMask:" + z17);
        HippyMap hippyMap2 = new HippyMap();
        if (string != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    hippyMap2.pushBoolean("success", false);
                    hippyMap2.pushString("errorMsg", "sharePoster posterFile is null or blank");
                } else if (!new File(string).exists()) {
                    QLog.e(TAG, 1, "sharePoster posterFile not exist");
                    hippyMap2.pushBoolean("success", false);
                    hippyMap2.pushString("errorMsg", "sharePoster posterFile not exist");
                } else {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (i3 == 0) {
                        arrayList.add(0);
                        arrayList.add(1);
                        arrayList.add(4);
                        arrayList.add(2);
                        arrayList.add(3);
                        arrayList2.add(1);
                    } else {
                        if ((i3 & 1) != 0) {
                            arrayList.add(0);
                        }
                        if ((i3 & 2) != 0) {
                            arrayList.add(1);
                        }
                        if ((i3 & 4) != 0) {
                            arrayList.add(4);
                        }
                        if ((i3 & 8) != 0) {
                            arrayList2.add(1);
                        }
                        if ((i3 & 16) != 0) {
                            arrayList.add(2);
                        }
                        if ((i3 & 32) != 0) {
                            arrayList.add(3);
                        }
                    }
                    h.INSTANCE.a(new c());
                    IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
                    Context topActivity = Foreground.getTopActivity();
                    if (topActivity == null) {
                        topActivity = BaseApplication.context;
                    }
                    Context context = topActivity;
                    Intrinsics.checkNotNullExpressionValue(context, "Foreground.getTopActivit\u2026seApplicationImpl.context");
                    Object[] array = arrayList.toArray(new Integer[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    Integer[] numArr = (Integer[]) array;
                    Object[] array2 = arrayList2.toArray(new Integer[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("source", Integer.valueOf(i16)));
                    iZPlanShareApi.launchForShareMedia(context, new ZPlanShareLaunchParam(5, null, 0, string, null, null, null, numArr, null, (Integer[]) array2, !z17, mutableMapOf, 368, null));
                    hippyMap = hippyMap2;
                    hippyMap.pushBoolean("success", true);
                    promise.resolve(hippyMap);
                }
                hippyMap = hippyMap2;
                promise.resolve(hippyMap);
            }
        }
        z16 = true;
        if (!z16) {
        }
        hippyMap = hippyMap2;
        promise.resolve(hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void promiseResult$default(ZplanVasHippyAppModule zplanVasHippyAppModule, Promise promise, int i3, String str, Map map, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            map = null;
        }
        zplanVasHippyAppModule.promiseResult(promise, i3, str, map);
    }
}
