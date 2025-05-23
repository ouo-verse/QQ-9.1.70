package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\u00048\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/OneStrokeHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/DefaultHbView;", "", "H0", "", "N", "Ljava/lang/String;", "V0", "()Ljava/lang/String;", "typeText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class OneStrokeHbView extends DefaultHbView {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneStrokeHbView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.typeText = "\u4e00\u7b14\u753b\u7ea2\u5305";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void H0() {
        Map<String, ? extends Object> emptyMap;
        AIOContextHolder.f361707d.c(new UnclaimedEvent.UpdateHbList(false));
        GrabHbViewModel F0 = F0();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        rx3.b M1 = W0().M1();
        emptyMap = MapsKt__MapsKt.emptyMap();
        F0.X1(context, M1, emptyMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: V0, reason: from getter */
    public String getTypeText() {
        return this.typeText;
    }
}
