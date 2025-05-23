package com.tencent.timi.game.ui;

import android.view.View;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0003R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/ui/ViewWrapper;", "", "target", "Landroid/view/View;", "(Landroid/view/View;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "rView", "width", "getWidth", "setWidth", "getView", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class ViewWrapper {

    @NotNull
    private final View rView;

    public ViewWrapper(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.rView = target;
    }

    public final int getHeight() {
        return this.rView.getLayoutParams().height;
    }

    @NotNull
    /* renamed from: getView, reason: from getter */
    public final View getRView() {
        return this.rView;
    }

    public final int getWidth() {
        return this.rView.getLayoutParams().width;
    }

    public final void setHeight(int i3) {
        this.rView.getLayoutParams().height = i3;
        this.rView.requestLayout();
    }

    public final void setWidth(int i3) {
        this.rView.getLayoutParams().width = i3;
        this.rView.requestLayout();
    }
}
