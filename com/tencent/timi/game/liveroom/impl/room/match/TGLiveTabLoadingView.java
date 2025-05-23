package com.tencent.timi.game.liveroom.impl.room.match;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.af;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGLiveTabLoadingView;", "Landroid/widget/FrameLayout;", "", "resId", "", "setIcon", "", "tipText", "setTip", TuxUIConstants.POP_BTN_TEXT, "Landroid/view/View$OnClickListener;", "onClickListener", "setBtn", "setBlackMode", "setWhiteMode", "Lnr2/af;", "d", "Lnr2/af;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveTabLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final af binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveTabLoadingView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setBlackMode() {
        this.binding.f420801d.setTextColor(-1);
    }

    public final void setBtn(@Nullable String btnText, @Nullable View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(btnText)) {
            this.binding.f420799b.setText(btnText);
            this.binding.f420799b.setVisibility(0);
            this.binding.f420799b.setOnClickListener(onClickListener);
            return;
        }
        this.binding.f420799b.setVisibility(8);
    }

    public final void setIcon(int resId) {
        if (resId > 0) {
            this.binding.f420800c.setVisibility(0);
            this.binding.f420800c.setImageResource(resId);
        } else {
            this.binding.f420800c.setVisibility(8);
        }
    }

    public final void setTip(@Nullable String tipText) {
        if (!TextUtils.isEmpty(tipText)) {
            this.binding.f420801d.setText(tipText);
            this.binding.f420801d.setVisibility(0);
        } else {
            this.binding.f420801d.setVisibility(8);
        }
    }

    public final void setWhiteMode() {
        this.binding.f420801d.setTextColor(-16777216);
    }

    public /* synthetic */ TGLiveTabLoadingView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveTabLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        af g16 = af.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }
}
