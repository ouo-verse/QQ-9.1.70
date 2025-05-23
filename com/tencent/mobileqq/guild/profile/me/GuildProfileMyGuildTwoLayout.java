package com.tencent.mobileqq.guild.profile.me;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildTwoLayout;", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "Landroid/view/View$OnClickListener;", "", "K0", "", "C0", "F0", "I0", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreatedGuildInfo;", "guildList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileMyGuildTwoLayout extends GuildProfileMyGuildsLayout implements View.OnClickListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildTwoLayout(@NotNull Context context, @NotNull List<? extends IGProCreatedGuildInfo> guildList) {
        super(context, guildList);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildList, "guildList");
        J0();
        setClickable(false);
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(true);
        }
    }

    private final void K0() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        measure(makeMeasureSpec, makeMeasureSpec);
        if (getMeasuredWidth() < 450) {
            View findViewById = findViewById(R.id.d_5);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Logger.f235387a.d().w("Guild.profile.GuildProfileMyGuildsLayout", 1, "updateVisibility measuredWidth:" + getMeasuredWidth());
            return;
        }
        View findViewById2 = findViewById(R.id.d_5);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public int C0() {
        return R.layout.f2i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public void F0() {
        super.F0();
        B0().add(findViewById(R.id.icon));
        B0().add(findViewById(R.id.d_6));
        View findViewById = findViewById(R.id.x5b);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.x5c);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        List<IGProCreatedGuildInfo> D0 = D0();
        if (D0 != null) {
            int i3 = 0;
            for (IGProCreatedGuildInfo iGProCreatedGuildInfo : D0) {
                int i16 = i3 + 1;
                ImageView it12 = B0().get(i3);
                if (it12 != null) {
                    String faceUrl = iGProCreatedGuildInfo.getFaceUrl();
                    Intrinsics.checkNotNullExpressionValue(faceUrl, "item.faceUrl");
                    Intrinsics.checkNotNullExpressionValue(it12, "it1");
                    com.tencent.mobileqq.guild.util.v.l(faceUrl, it12, null, 4, null);
                }
                i3 = i16;
            }
        }
        K0();
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public void I0() {
        K0();
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
        if (num != null && num.intValue() == R.id.x5b) {
            List<IGProCreatedGuildInfo> D02 = D0();
            if (D02 != null && (true ^ D02.isEmpty())) {
                H0(p06, String.valueOf(D02.get(0).getGuildId()));
            }
        } else if (num != null && num.intValue() == R.id.x5c && (D0 = D0()) != null && D0.size() > 1) {
            H0(p06, String.valueOf(D0.get(1).getGuildId()));
        }
        EventCollector.getInstance().onViewClicked(p06);
    }
}
