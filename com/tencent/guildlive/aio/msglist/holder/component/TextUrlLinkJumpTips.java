package com.tencent.guildlive.aio.msglist.holder.component;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/TextUrlLinkJumpTips;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tips", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "a", "()Lkotlin/jvm/functions/Function0;", "confirmBlock", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class TextUrlLinkJumpTips implements MviUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tips;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> confirmBlock;

    public TextUrlLinkJumpTips(@NotNull String tips, @NotNull Function0<Unit> confirmBlock) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(confirmBlock, "confirmBlock");
        this.tips = tips;
        this.confirmBlock = confirmBlock;
    }

    @NotNull
    public final Function0<Unit> a() {
        return this.confirmBlock;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
