package com.tencent.mobileqq.guild.profile.me;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildOneLayout;", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "Landroid/view/View$OnClickListener;", "", "C0", "", "F0", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreatedGuildInfo;", "guildList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileMyGuildOneLayout extends GuildProfileMyGuildsLayout implements View.OnClickListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildOneLayout(@NotNull Context context, @NotNull List<? extends IGProCreatedGuildInfo> guildList) {
        super(context, guildList);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildList, "guildList");
        J0();
        setClickable(false);
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public int C0() {
        return R.layout.f2h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public void F0() {
        super.F0();
        B0().add(findViewById(R.id.icon));
        View findViewById = findViewById(R.id.x5b);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        List<IGProCreatedGuildInfo> D0 = D0();
        if (D0 != null) {
            for (IGProCreatedGuildInfo iGProCreatedGuildInfo : D0) {
                ImageView it12 = B0().get(0);
                if (it12 != null) {
                    String faceUrl = iGProCreatedGuildInfo.getFaceUrl();
                    Intrinsics.checkNotNullExpressionValue(faceUrl, "it.faceUrl");
                    Intrinsics.checkNotNullExpressionValue(it12, "it1");
                    com.tencent.mobileqq.guild.util.v.l(faceUrl, it12, null, 4, null);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p06) {
        Integer num;
        List<IGProCreatedGuildInfo> D0;
        EventCollector.getInstance().onViewClickedBefore(p06);
        if (p06 != null) {
            num = Integer.valueOf(p06.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.x5b && (D0 = D0()) != null && (!D0.isEmpty())) {
            H0(p06, String.valueOf(D0.get(0).getGuildId()));
        }
        EventCollector.getInstance().onViewClicked(p06);
    }
}
