package com.tencent.mobileqq.guild.widget.banner.titlelayout;

import android.animation.ArgbEvaluator;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/SettingPreviewChannelTitleLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "Landroid/view/View$OnClickListener;", "", "j", "", c.f123400v, "i", "k", h.F, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "from", "setDefaultTitleAlpha", "Landroid/animation/ArgbEvaluator;", UserInfo.SEX_FEMALE, "Landroid/animation/ArgbEvaluator;", "mEvaluator", "G", "currentTitleAlpha", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SettingPreviewChannelTitleLayout extends ChannelTitleLayout implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArgbEvaluator mEvaluator;

    /* renamed from: G, reason: from kotlin metadata */
    private float currentTitleAlpha;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236315a;

        static {
            int[] iArr = new int[GuildFacadeType.values().length];
            try {
                iArr[GuildFacadeType.SettingEntrance.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildFacadeType.PreviewVisitorCards.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildFacadeType.PreviewVisitorLeaveMsg.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f236315a = iArr;
        }
    }

    private final void i(float alpha) {
        if (getBackground() != null) {
            if (alpha > 0.0f) {
                getBackground().setAlpha((int) (alpha * 255));
            } else {
                getBackground().setAlpha(0);
            }
        }
    }

    private final void j() {
        if (getHasTint()) {
            setBackgroundColor(getTintBackgroundColor());
        } else {
            setBackgroundColor(getPickBackgroundColor());
        }
        i(this.currentTitleAlpha);
    }

    private final void k(float alpha) {
        int g16;
        if (getHasTint()) {
            g16 = getTintTextColor();
        } else {
            g16 = ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000);
        }
        Object evaluate = this.mEvaluator.evaluate(alpha, -1, Integer.valueOf(g16));
        Intrinsics.checkNotNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
        ((Integer) evaluate).intValue();
        int i3 = a.f236315a[getGuildFacadeType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout
    public void h() {
        j();
        k(this.currentTitleAlpha);
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (QQGuildUIUtil.v()) {
            EventCollector.getInstance().onViewClicked(v3);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout
    public void setDefaultTitleAlpha(float alpha, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.currentTitleAlpha = alpha;
        i(alpha);
        k(alpha);
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
