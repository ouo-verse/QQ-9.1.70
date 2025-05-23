package com.tencent.mobileqq.guild.profile.me;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 ;2\u00020\u0001:\u0001<B\u001f\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0004\b4\u00105B\u001b\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b4\u00108B#\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00109\u001a\u00020\u0002\u00a2\u0006\u0004\b4\u0010:J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J-\u0010\u000e\u001a\u00020\u00042%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tR*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010$\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e`\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R?\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "C0", "", "I0", "onThemeChanged", "J0", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "guildId", "clickGuildFun", "E0", "F0", "Landroid/view/View;", "view", "A0", "H0", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreatedGuildInfo;", "d", "Ljava/util/List;", "D0", "()Ljava/util/List;", "setMyGuildList", "(Ljava/util/List;)V", "myGuildList", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "B0", "()Ljava/util/ArrayList;", "iconList", "f", "Lkotlin/jvm/functions/Function1;", "getClickGuildFun", "()Lkotlin/jvm/functions/Function1;", "setClickGuildFun", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/text/DecimalFormat;", tl.h.F, "Ljava/text/DecimalFormat;", "getDecimalFormat", "()Ljava/text/DecimalFormat;", "decimalFormat", "Landroid/content/Context;", "context", "guildList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class GuildProfileMyGuildsLayout extends ConstraintLayout {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f231118m = "https://qun.qq.com/guild/h5/guild-create/index.html?_wv=54183&_wwv=128&cateid=50000&from=plus#/";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends IGProCreatedGuildInfo> myGuildList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ImageView> iconList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> clickGuildFun;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DecimalFormat decimalFormat;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildsLayout(@NotNull Context context, @NotNull List<? extends IGProCreatedGuildInfo> guildList) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildList, "guildList");
        QLog.d("Guild.profile.GuildProfileMyGuildsLayout", 4, " create new object" + this);
        this.myGuildList = guildList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(GuildProfileMyGuildsLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.A0(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void A0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, "em_sgrp_head_create");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_mine");
        VideoReport.reportEvent("clck", view, hashMap);
        if (FastClickUtils.isFastDoubleClick("Guild.profile.GuildProfileMyGuildsLayout")) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f1510816q);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT, true);
        cx.b(getContext(), f231118m, bundle);
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).overridePendingTransition(R.anim.f154630p2, R.anim.f154442w);
        }
    }

    @NotNull
    public ArrayList<ImageView> B0() {
        return this.iconList;
    }

    public abstract int C0();

    @Nullable
    public final List<IGProCreatedGuildInfo> D0() {
        return this.myGuildList;
    }

    public final void E0(@Nullable Function1<? super String, Unit> clickGuildFun) {
        B0().clear();
        this.clickGuildFun = clickGuildFun;
        F0();
    }

    public void F0() {
        View findViewById = findViewById(R.id.wtz);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildProfileMyGuildsLayout.G0(GuildProfileMyGuildsLayout.this, view);
                }
            });
        }
    }

    public final void H0(@NotNull View view, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        VideoReport.setElementId(view, "em_sgrp_head_mine_create");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_mine");
        hashMap.put("sgrp_channel_id", guildId);
        VideoReport.reportEvent("clck", view, hashMap);
        Function1<? super String, Unit> function1 = this.clickGuildFun;
        if (function1 != null) {
            function1.invoke(guildId);
        }
    }

    public final void J0() {
        int i3;
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.guild_vas_theme_channel_item_bg_with_border;
        } else {
            i3 = R.drawable.guild_theme_channel_item_bg_with_border;
        }
        setBackground(ResourcesCompat.getDrawable(getResources(), i3, null));
    }

    public final void setClickGuildFun(@Nullable Function1<? super String, Unit> function1) {
        this.clickGuildFun = function1;
    }

    public final void setMyGuildList(@Nullable List<? extends IGProCreatedGuildInfo> list) {
        this.myGuildList = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconList = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        this.decimalFormat = decimalFormat;
        int C0 = C0();
        if (C0 > 0) {
            LayoutInflater.from(context).inflate(C0, (ViewGroup) this, true);
        }
    }

    public void I0() {
    }

    public void onThemeChanged() {
    }
}
