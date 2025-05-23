package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/sharedengine/anim/state/PortalInitAnimState;", "Lcom/tencent/sqshow/sharedengine/anim/state/AnimState;", "", "getStateType", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/sqshow/sharedengine/anim/state/a;", "listener", "", "a", "Lq74/a;", "params", "<init>", "(Lq74/a;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalInitAnimState extends AnimState {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalInitAnimState(q74.a params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // com.tencent.sqshow.sharedengine.anim.state.b
    public void a(c zplanSpanContext, EnumUserGender gender, FilamentUrlTemplate urlTemplate, a listener) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        BuildersKt__Builders_commonKt.launch$default(getParams().getScope(), null, null, new PortalInitAnimState$fetchAnim$1(gender, this, zplanSpanContext, urlTemplate, listener, null), 3, null);
    }

    @Override // com.tencent.sqshow.sharedengine.anim.state.b
    public int getStateType() {
        return 2;
    }
}
