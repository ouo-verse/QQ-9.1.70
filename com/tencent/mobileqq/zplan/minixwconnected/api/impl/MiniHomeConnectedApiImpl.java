package com.tencent.mobileqq.zplan.minixwconnected.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.helper.u;
import com.tencent.mobileqq.zplan.minixwconnected.AIOMiniHomeConnectedEntranceHelper;
import com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance;
import com.tencent.mobileqq.zplan.minixwconnected.api.IMiniHomeConnectedApi;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jp\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000628\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fH\u0016J3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00130\u0018H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/api/impl/MiniHomeConnectedApiImpl;", "Lcom/tencent/mobileqq/zplan/minixwconnected/api/IMiniHomeConnectedApi;", "()V", "generateAioMiniHomeConnectedEntranceHelper", "Lcom/tencent/mobileqq/zplan/minixwconnected/AIOMiniHomeConnectedEntranceHelper;", "contextGetter", "Lkotlin/Function0;", "Landroid/content/Context;", "c2cUinGetter", "", "c2cNicknameGetter", "sender", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "value", "", "showEntrance", "friendUin", "", "callback", "Lkotlin/Function1;", "", "result", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MiniHomeConnectedApiImpl implements IMiniHomeConnectedApi {
    @Override // com.tencent.mobileqq.zplan.minixwconnected.api.IMiniHomeConnectedApi
    public /* bridge */ /* synthetic */ u generateAioMiniHomeConnectedEntranceHelper(Function0 function0, Function0 function02, Function0 function03, Function2 function2) {
        return generateAioMiniHomeConnectedEntranceHelper((Function0<? extends Context>) function0, (Function0<String>) function02, (Function0<String>) function03, (Function2<? super Integer, Object, Unit>) function2);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.api.IMiniHomeConnectedApi
    public void showEntrance(long friendUin, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniHomeConnectedEntrance.f334439a.c(friendUin, callback);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.api.IMiniHomeConnectedApi
    public AIOMiniHomeConnectedEntranceHelper generateAioMiniHomeConnectedEntranceHelper(Function0<? extends Context> contextGetter, Function0<String> c2cUinGetter, Function0<String> c2cNicknameGetter, Function2<? super Integer, Object, Unit> sender) {
        Intrinsics.checkNotNullParameter(contextGetter, "contextGetter");
        Intrinsics.checkNotNullParameter(c2cUinGetter, "c2cUinGetter");
        Intrinsics.checkNotNullParameter(c2cNicknameGetter, "c2cNicknameGetter");
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (AIOMiniHomeConnectedEntranceHelper.INSTANCE.a() || !ZPlanQQMC.INSTANCE.getZPlanAioMiniHomeConnEntranceConfig().getEnable()) {
            return null;
        }
        return new AIOMiniHomeConnectedEntranceHelper(contextGetter, c2cUinGetter, c2cNicknameGetter, sender);
    }
}
