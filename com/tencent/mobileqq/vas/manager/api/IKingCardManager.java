package com.tencent.mobileqq.vas.manager.api;

import com.tencent.mobileqq.vas.api.IVasManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "addChangeListener", "", "block", "Lkotlin/Function1;", "", "isFreeFlow", "from", "", "isKingCard", "setKingCardState", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IKingCardManager extends IVasManager {
    void addChangeListener(@NotNull Function1<? super Boolean, Unit> block);

    boolean isFreeFlow(@NotNull String from);

    boolean isKingCard();

    void setKingCardState(boolean isKingCard);
}
