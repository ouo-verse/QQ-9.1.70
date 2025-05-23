package com.tencent.biz.qqcircle.publish.plusentry.composer;

import android.view.View;
import com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.BasePlusEntryOperationPosComposer;
import com.tencent.biz.qqcircle.publish.plusentry.helper.PlusEntryExp;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b5\u00106J/\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR.\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010(\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010/\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R.\u00104\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u00100\u001a\u0004\b1\u00102\"\u0004\b)\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/b;", "", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/a;", "T", "curComposer", "newComposer", "f", "(Lcom/tencent/biz/qqcircle/publish/plusentry/composer/a;Lcom/tencent/biz/qqcircle/publish/plusentry/composer/a;)Lcom/tencent/biz/qqcircle/publish/plusentry/composer/a;", "Landroid/view/View;", "plusEntryLayout", "", "j", "Lcom/tencent/biz/qqcircle/publish/plusentry/helper/PlusEntryExp;", "exp", "Lna0/a;", "c", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer;", "b", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/BasePlusEntryOperationPosComposer;", "d", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/bubble/PlusEntryBubbleComposer;", "a", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "getPartHost", "()Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "value", "Lna0/a;", "getNormalComposer", "()Lna0/a;", h.F, "(Lna0/a;)V", "normalComposer", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer;", "getDailyPagComposer", "()Lcom/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer;", "g", "(Lcom/tencent/biz/qqcircle/publish/plusentry/composer/dailypag/PlusEntryDailyPagComposer;)V", "dailyPagComposer", "e", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/BasePlusEntryOperationPosComposer;", "getOperationComposer", "()Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/BasePlusEntryOperationPosComposer;", "i", "(Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/BasePlusEntryOperationPosComposer;)V", "operationComposer", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/bubble/PlusEntryBubbleComposer;", "getBubbleComposer", "()Lcom/tencent/biz/qqcircle/publish/plusentry/composer/bubble/PlusEntryBubbleComposer;", "(Lcom/tencent/biz/qqcircle/publish/plusentry/composer/bubble/PlusEntryBubbleComposer;)V", "bubbleComposer", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPartHost partHost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View plusEntryLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private na0.a normalComposer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PlusEntryDailyPagComposer dailyPagComposer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BasePlusEntryOperationPosComposer operationComposer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PlusEntryBubbleComposer bubbleComposer;

    public b(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.partHost = partHost;
        this.plusEntryLayout = plusEntryLayout;
    }

    private final void e(PlusEntryBubbleComposer plusEntryBubbleComposer) {
        this.bubbleComposer = (PlusEntryBubbleComposer) f(this.bubbleComposer, plusEntryBubbleComposer);
    }

    private final <T extends a> T f(T curComposer, T newComposer) {
        if (curComposer != null) {
            curComposer.a();
        }
        if (newComposer != null) {
            newComposer.b();
            return newComposer;
        }
        return null;
    }

    private final void g(PlusEntryDailyPagComposer plusEntryDailyPagComposer) {
        this.dailyPagComposer = (PlusEntryDailyPagComposer) f(this.dailyPagComposer, plusEntryDailyPagComposer);
    }

    private final void h(na0.a aVar) {
        this.normalComposer = (na0.a) f(this.normalComposer, aVar);
    }

    private final void i(BasePlusEntryOperationPosComposer basePlusEntryOperationPosComposer) {
        this.operationComposer = (BasePlusEntryOperationPosComposer) f(this.operationComposer, basePlusEntryOperationPosComposer);
    }

    @NotNull
    public final PlusEntryBubbleComposer a() {
        PlusEntryBubbleComposer plusEntryBubbleComposer = new PlusEntryBubbleComposer(this.partHost, this.plusEntryLayout);
        e(plusEntryBubbleComposer);
        return plusEntryBubbleComposer;
    }

    @NotNull
    public final PlusEntryDailyPagComposer b() {
        PlusEntryDailyPagComposer plusEntryDailyPagComposer = new PlusEntryDailyPagComposer(this.partHost, this.plusEntryLayout);
        g(plusEntryDailyPagComposer);
        return plusEntryDailyPagComposer;
    }

    @NotNull
    public final na0.a c(@NotNull PlusEntryExp exp) {
        Intrinsics.checkNotNullParameter(exp, "exp");
        na0.a i3 = new na0.a(this.partHost, this.plusEntryLayout).i(exp);
        h(i3);
        return i3;
    }

    @NotNull
    public final BasePlusEntryOperationPosComposer d(@NotNull PlusEntryExp exp) {
        Intrinsics.checkNotNullParameter(exp, "exp");
        BasePlusEntryOperationPosComposer j3 = new BasePlusEntryOperationPosComposer(this.partHost, this.plusEntryLayout).j(exp);
        i(j3);
        return j3;
    }

    public final void j(@NotNull View plusEntryLayout) {
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.plusEntryLayout = plusEntryLayout;
    }
}
