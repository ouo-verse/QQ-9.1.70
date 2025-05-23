package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/sharedengine/anim/state/PullDownAnimState;", "Lcom/tencent/sqshow/sharedengine/anim/state/AnimState;", "", "getStateType", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/sqshow/sharedengine/anim/state/a;", "listener", "", "a", "Lr74/b;", "stateContext", "", "now", "c", "Lq74/a;", "params", "<init>", "(Lq74/a;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PullDownAnimState extends AnimState {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private static int f369851g = 5061;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/sharedengine/anim/state/PullDownAnimState$a;", "", "", "PULL_DOWN_ANIM_ACTION_ID", "I", "a", "()I", "setPULL_DOWN_ANIM_ACTION_ID", "(I)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.sharedengine.anim.state.PullDownAnimState$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PullDownAnimState.f369851g;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullDownAnimState(q74.a params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("PullDownAnimState", 1, "PULL_DOWN_ANIM_ACTION_ID:" + f369851g);
    }

    @Override // com.tencent.sqshow.sharedengine.anim.state.b
    public void a(c zplanSpanContext, EnumUserGender gender, FilamentUrlTemplate urlTemplate, a listener) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        BuildersKt__Builders_commonKt.launch$default(getParams().getScope(), null, null, new PullDownAnimState$fetchAnim$1(gender, this, zplanSpanContext, urlTemplate, listener, null), 3, null);
    }

    @Override // com.tencent.sqshow.sharedengine.anim.state.AnimState
    public void c(r74.b stateContext, EnumUserGender gender, double now, c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(stateContext, "stateContext");
        Intrinsics.checkNotNullParameter(gender, "gender");
        if (getAnimateBeginTime() == 0.0d) {
            m(now);
        }
        if (now - getAnimateBeginTime() < f(gender)) {
            super.c(stateContext, gender, now, zplanSpanContext);
        } else {
            stateContext.c(2);
            j();
        }
    }

    @Override // com.tencent.sqshow.sharedengine.anim.state.b
    public int getStateType() {
        return 1;
    }
}
