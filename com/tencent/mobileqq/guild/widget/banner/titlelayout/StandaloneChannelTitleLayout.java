package com.tencent.mobileqq.guild.widget.banner.titlelayout;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/StandaloneChannelTitleLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "Landroid/view/View$OnClickListener;", "", "j", "k", "", c.f123400v, "i", h.F, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "from", "setDefaultTitleAlpha", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class StandaloneChannelTitleLayout extends ChannelTitleLayout implements View.OnClickListener {
    private final void i(float alpha) {
        Drawable background = getBackground();
        if (background != null) {
            if (alpha > 0.0f) {
                background.setAlpha((int) (alpha * 255));
            } else {
                background.setAlpha(0);
            }
        }
    }

    private final void j() {
        if (getHasTint()) {
            setBackgroundColor(getTintBackgroundColor());
        } else {
            setBackgroundColor(getPickBackgroundColor());
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final void k() {
        Intrinsics.throwUninitializedPropertyAccessException("binding");
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
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ChannelTitleLayout", 1, "onClick isFastDoubleClick");
            }
            EventCollector.getInstance().onViewClicked(v3);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("ChannelTitleLayout", 1, "onClick v:" + v3);
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout
    public void setDefaultTitleAlpha(float alpha, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        i(alpha);
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
