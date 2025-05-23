package com.tencent.ecommerce.biz.taskcenter.hippy.module;

import android.app.Activity;
import cg0.a;
import com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@HippyNativeModule(name = "QQUiModule")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/taskcenter/hippy/module/QQUiModule;", "Lcom/tencent/ecommerce/biz/hippy/module/ECHippyBaseModule;", "", "isDarkFont", "", "setStatusBarDarkFont", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "getStatusBarHeight", "isNightModeTheme", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class QQUiModule extends ECHippyBaseModule {
    private static final String TAG = "QQUiModule";

    public QQUiModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "getStatusBarHeight")
    public final void getStatusBarHeight(Promise promise) {
        a.b("QQUiModule", "getStatusBarHeight");
        int a16 = r.f104881b.a(getActivity());
        a.b("QQUiModule", "getStatusBarHeight statusBarHeight " + a16);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble("statusBarHeight", a16 == 0 ? 0.0d : (a16 / com.tencent.ecommerce.base.device.a.f100685b.e().density) + 0.5f);
        Unit unit = Unit.INSTANCE;
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "isNightModeTheme")
    public final void isNightModeTheme(Promise promise) {
        a.b("QQUiModule", "isNightModeTheme");
        promise.resolve(Boolean.valueOf(fg0.a.f398587b.a()));
    }

    @HippyMethod(name = "setStatusBarDarkFont")
    public final void setStatusBarDarkFont(final boolean isDarkFont) {
        a.b("QQUiModule", "setStatusBarDarkFont isDarkFont " + isDarkFont);
        final Activity activity = getActivity();
        if (activity == null) {
            a.a("QQUiModule", "setStatusBarDarkFont", "activity is null");
        } else {
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.taskcenter.hippy.module.QQUiModule$setStatusBarDarkFont$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    r.f104881b.e(activity, isDarkFont);
                }
            });
        }
    }
}
