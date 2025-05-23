package com.tencent.mobileqq.guild.profile.me;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u001f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildThreeLayout;", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "Landroid/view/View$OnClickListener;", "", "M0", "O0", "", "C0", "F0", "I0", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreatedGuildInfo;", "guildList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileMyGuildThreeLayout extends GuildProfileMyGuildsLayout implements View.OnClickListener {
    private static final int D = bi.b(10);
    private static final int E = bi.b(7);
    private static final int F = bi.b(30);
    private static int G;
    private static int H;
    private static int I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildThreeLayout(@NotNull Context context, @NotNull List<? extends IGProCreatedGuildInfo> guildList) {
        super(context, guildList);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildList, "guildList");
        J0();
        setClickable(false);
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(true);
        }
    }

    private final void M0() {
        post(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.ac
            @Override // java.lang.Runnable
            public final void run() {
                GuildProfileMyGuildThreeLayout.N0(GuildProfileMyGuildThreeLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(GuildProfileMyGuildThreeLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getWidth() > 0) {
            I = this$0.getWidth();
        }
        if (this$0.findViewById(R.id.wrv).getWidth() > 0) {
            G = this$0.findViewById(R.id.wrv).getWidth();
        }
        if (this$0.findViewById(R.id.wtz).getWidth() > 0) {
            H = this$0.findViewById(R.id.wtz).getWidth();
        }
    }

    private final void O0() {
        post(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.ab
            @Override // java.lang.Runnable
            public final void run() {
                GuildProfileMyGuildThreeLayout.P0(GuildProfileMyGuildThreeLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(GuildProfileMyGuildThreeLayout this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i16 = (I - G) - (D * 2);
        int i17 = H;
        int i18 = E;
        int i19 = ((i16 - i17) - i18) / (i17 + i18);
        View findViewById = this$0.findViewById(R.id.d_5);
        int i26 = 0;
        if (findViewById != null) {
            if (i19 >= 3) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
        View findViewById2 = this$0.findViewById(R.id.d_6);
        if (findViewById2 != null) {
            if (i19 < 2) {
                i26 = 8;
            }
            findViewById2.setVisibility(i26);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public int C0() {
        return R.layout.f2j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    @SuppressLint({"LongLogTag"})
    public void F0() {
        super.F0();
        View findViewById = findViewById(R.id.d_5);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.d_6);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        View findViewById3 = findViewById(R.id.f165722xd1);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
        B0().add(findViewById(R.id.d_5));
        B0().add(findViewById(R.id.d_6));
        B0().add(findViewById(R.id.f165722xd1));
        List<IGProCreatedGuildInfo> D0 = D0();
        if (D0 != null) {
            int i3 = 0;
            for (IGProCreatedGuildInfo iGProCreatedGuildInfo : D0) {
                int i16 = i3 + 1;
                if (i3 < 3) {
                    ImageView icon = B0().get(i3);
                    if (icon != null) {
                        String faceUrl = iGProCreatedGuildInfo.getFaceUrl();
                        Intrinsics.checkNotNullExpressionValue(faceUrl, "e.faceUrl");
                        Intrinsics.checkNotNullExpressionValue(icon, "icon");
                        com.tencent.mobileqq.guild.util.v.l(faceUrl, icon, null, 4, null);
                    }
                    ImageView imageView = B0().get(i3);
                    if (imageView != null) {
                        imageView.setOnClickListener(this);
                    }
                }
                i3 = i16;
            }
        }
        M0();
        O0();
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public void I0() {
        O0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p06) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(p06);
        List<IGProCreatedGuildInfo> D0 = D0();
        if (D0 != null) {
            if (p06 != null) {
                num = Integer.valueOf(p06.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.d_5) {
                if (D0.size() > 0) {
                    H0(p06, String.valueOf(D0.get(0).getGuildId()));
                }
            } else if (num != null && num.intValue() == R.id.d_6) {
                if (D0.size() > 1) {
                    H0(p06, String.valueOf(D0.get(1).getGuildId()));
                }
            } else if (num != null && num.intValue() == R.id.f165722xd1 && D0.size() > 2) {
                H0(p06, String.valueOf(D0.get(2).getGuildId()));
            }
        }
        EventCollector.getInstance().onViewClicked(p06);
    }
}
