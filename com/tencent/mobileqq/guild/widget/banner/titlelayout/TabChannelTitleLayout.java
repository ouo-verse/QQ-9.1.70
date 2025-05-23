package com.tencent.mobileqq.guild.widget.banner.titlelayout;

import android.graphics.Color;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/TabChannelTitleLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "Landroid/view/View$OnClickListener;", "", "i", "j", h.F, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", c.f123400v, "", "from", "setDefaultTitleAlpha", UserInfo.SEX_FEMALE, "currentTitleAlpha", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TabChannelTitleLayout extends ChannelTitleLayout implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private float currentTitleAlpha;

    private final void i() {
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final void j() {
        if (!QQTheme.isVasTheme()) {
            if (GuildThemeManager.f235286a.b()) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        g.a(Color.parseColor("#FFFFFF"), 10);
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout
    public void h() {
        i();
        j();
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
