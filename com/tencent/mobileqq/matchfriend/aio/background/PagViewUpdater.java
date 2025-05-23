package com.tencent.mobileqq.matchfriend.aio.background;

import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.state.a;
import com.tencent.mobileqq.matchfriend.aio.background.state.h;
import com.tencent.mobileqq.matchfriend.aio.background.state.k;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/PagViewUpdater;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$b;", "Landroid/view/View;", "view", "", "a", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "immediate", "", Constants.PAG_FILE_PATH, "b", "errMsg", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a;", "Ljava/util/Map;", "stateAnimatorMap", "Landroid/view/View;", "containView", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "animatorParams", "d", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a;", "currentStateAnimator", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PagViewUpdater implements BaseMutualMarkAIOBackgroundProxy.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, com.tencent.mobileqq.matchfriend.aio.background.state.a> stateAnimatorMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View containView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy animatorParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.aio.background.state.a currentStateAnimator;

    public PagViewUpdater() {
        Map<Integer, com.tencent.mobileqq.matchfriend.aio.background.state.a> mapOf;
        Lazy lazy;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new com.tencent.mobileqq.matchfriend.aio.background.state.f()), TuplesKt.to(2, new h()), TuplesKt.to(3, new h()), TuplesKt.to(4, new h()), TuplesKt.to(5, new k()));
        this.stateAnimatorMap = mapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a.AnimatorParams>() { // from class: com.tencent.mobileqq.matchfriend.aio.background.PagViewUpdater$animatorParams$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a.AnimatorParams invoke() {
                View view;
                view = PagViewUpdater.this.containView;
                if (view == null) {
                    return null;
                }
                View findViewById = view.findViewById(R.id.f163139oi3);
                Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.animator_view)");
                PAGViewDelegate pAGViewDelegate = (PAGViewDelegate) findViewById;
                View findViewById2 = view.findViewById(R.id.f163162on1);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.polar_light_view)");
                View findViewById3 = view.findViewById(R.id.oqp);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.relationship_tv)");
                return new a.AnimatorParams(pAGViewDelegate, (QUIPolarLightView) findViewById2, (TextView) findViewById3, null, 8, null);
            }
        });
        this.animatorParams = lazy;
    }

    private final a.AnimatorParams e() {
        return (a.AnimatorParams) this.animatorParams.getValue();
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.b
    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.containView = view;
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.b
    public void b(BaseMutualMarkAIOBackgroundProxy.f state, boolean immediate, String pagFilePath) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pagFilePath, "pagFilePath");
        a.AnimatorParams e16 = e();
        if (e16 != null) {
            e16.e(pagFilePath);
            com.tencent.mobileqq.matchfriend.aio.background.state.a aVar = this.stateAnimatorMap.get(Integer.valueOf(state.a()));
            if (aVar != null) {
                aVar.b(state, e16, immediate);
            } else {
                aVar = null;
            }
            this.currentStateAnimator = aVar;
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.b
    public void c(BaseMutualMarkAIOBackgroundProxy.f state, boolean immediate, String errMsg) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.b
    public void onDestroy() {
        com.tencent.mobileqq.matchfriend.aio.background.state.a aVar;
        a.AnimatorParams e16 = e();
        if (e16 == null || (aVar = this.currentStateAnimator) == null) {
            return;
        }
        aVar.a(e16);
    }
}
