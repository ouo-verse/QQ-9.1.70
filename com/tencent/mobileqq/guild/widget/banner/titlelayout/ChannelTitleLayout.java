package com.tencent.mobileqq.guild.widget.banner.titlelayout;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.internal.Intrinsics;
import o12.a;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 H2\u00020\u0001:\u0001!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H&J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\u001f\u0010(\"\u0004\b)\u0010*R\"\u0010-\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010'\u001a\u0004\b&\u0010(\"\u0004\b,\u0010*R\"\u00105\u001a\u00020.8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00108\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b\u001b\u0010(\"\u0004\b7\u0010*R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010'R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010G\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\bF\u0010(\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "Landroid/widget/FrameLayout;", "Lks1/a;", "guildTitleCallback", "", "setListener", "", "space", "setTopSpace", "alphaPosOffset", "setStartAlphaPosOffset", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, h.F, "", c.f123400v, "", "from", "setDefaultTitleAlpha", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Lcom/tencent/mobileqq/guild/widget/b;", "d", "Lcom/tencent/mobileqq/guild/widget/b;", "mBannerAnimHelper", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "e", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "a", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "setGuildFacadeType", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "guildFacadeType", "f", "I", "()I", "setTintBackgroundColor", "(I)V", "tintBackgroundColor", "setTintTextColor", "tintTextColor", "", "i", "Z", "b", "()Z", "setHasTint", "(Z)V", "hasTint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setPickBackgroundColor", "pickBackgroundColor", BdhLogUtil.LogTag.Tag_Conn, "mTopSpace", "Landroidx/lifecycle/Observer;", "D", "Landroidx/lifecycle/Observer;", "backgroundColorObserver", "Lo12/a;", "mParam", "Lo12/a;", "c", "()Lo12/a;", "setMParam", "(Lo12/a;)V", "g", "topSpace", "E", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class ChannelTitleLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int mTopSpace;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Observer<Integer> backgroundColorObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mBannerAnimHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFacadeType guildFacadeType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int tintBackgroundColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int tintTextColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasTint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int pickBackgroundColor;

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildFacadeType getGuildFacadeType() {
        return this.guildFacadeType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: from getter */
    public final boolean getHasTint() {
        return this.hasTint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final a c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: from getter */
    public final int getPickBackgroundColor() {
        return this.pickBackgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final int getTintBackgroundColor() {
        return this.tintBackgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: from getter */
    public final int getTintTextColor() {
        return this.tintTextColor;
    }

    /* renamed from: g, reason: from getter */
    public final int getMTopSpace() {
        return this.mTopSpace;
    }

    public abstract void h();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int color;
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg);
        g16.observeForever(this.backgroundColorObserver);
        if (g16.getValue() != null) {
            Integer value = g16.getValue();
            Intrinsics.checkNotNull(value);
            color = g.a(value.intValue(), 100);
        } else {
            color = getResources().getColor(R.color.qui_common_fill_light_primary);
        }
        this.pickBackgroundColor = color;
        h();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (newConfig.orientation == 2) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ChannelTitleLayout", 2, "onConfigurationChanged to landscape");
                return;
            }
            return;
        }
        super.onConfigurationChanged(newConfig);
        this.mBannerAnimHelper.f(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg).removeObserver(this.backgroundColorObserver);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.mBannerAnimHelper.g(w3, h16, oldw, oldh);
    }

    public abstract void setDefaultTitleAlpha(float alpha, @NotNull String from);

    public final void setListener(@NotNull ks1.a guildTitleCallback) {
        Intrinsics.checkNotNullParameter(guildTitleCallback, "guildTitleCallback");
    }

    public final void setStartAlphaPosOffset(int alphaPosOffset) {
        this.mBannerAnimHelper.i(alphaPosOffset);
    }

    public final void setTopSpace(int space) {
        this.mTopSpace = space;
        setPadding(0, space, 0, 0);
    }
}
