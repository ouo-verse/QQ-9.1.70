package com.tencent.mobileqq.guild.homev2.views.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.channel.joinchannel.h;
import com.tencent.mobileqq.guild.homev2.views.widget.GuildHomeVisitorJoinView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/widget/GuildHomeVisitorJoinView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "c", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeVisitorJoinView extends FrameLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeVisitorJoinView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final GuildHomeVisitorJoinView this$0, JumpGuildParam jumpGuildParam, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "$jumpGuildParam");
        if (!QQGuildUIUtil.v()) {
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.c(false);
            jumpParam.a(1);
            jumpParam.d(true ^ ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
            h.a(this$0.getContext(), jumpGuildParam, jumpParam, "GuildHomeVisitorJoinView", new bv() { // from class: sp1.b
                @Override // vh2.bv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    GuildHomeVisitorJoinView.e(GuildHomeVisitorJoinView.this, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildHomeVisitorJoinView this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!h.d(i3, iGProSecurityResult)) {
            h.c(this$0.getContext(), i3, str, iGProSecurityResult);
        }
    }

    public final void c(@NotNull final JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        QUIButton qUIButton = (QUIButton) findViewById(R.id.wku);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: sp1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeVisitorJoinView.d(GuildHomeVisitorJoinView.this, jumpGuildParam, view);
            }
        });
        int color = getContext().getResources().getColor(R.color.qui_common_fill_light_primary);
        setBackground(GuildUIUtils.f235378a.i(color, g.a(color, 0), 255));
        ch.Y0(qUIButton, "em_sgrp_bottom_join_channel", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeVisitorJoinView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeVisitorJoinView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeVisitorJoinView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eue, this);
    }
}
