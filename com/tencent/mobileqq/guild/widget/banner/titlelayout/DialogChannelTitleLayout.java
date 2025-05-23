package com.tencent.mobileqq.guild.widget.banner.titlelayout;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/DialogChannelTitleLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "Landroid/view/View$OnClickListener;", "", "j", "k", "", c.f123400v, "i", h.F, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "from", "setDefaultTitleAlpha", UserInfo.SEX_FEMALE, "currentTitleAlpha", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DialogChannelTitleLayout extends ChannelTitleLayout implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private float currentTitleAlpha;

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

    private final void k() {
        c();
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout
    public void h() {
        j();
        k();
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
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
