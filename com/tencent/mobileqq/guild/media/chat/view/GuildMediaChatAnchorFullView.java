package com.tencent.mobileqq.guild.media.chat.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.chat.view.j;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.widget.GuildMediaCountDownTimerView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u001d\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J(\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010$\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010)R\u0014\u0010,\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010&R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/view/GuildMediaChatAnchorFullView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/chat/view/j;", "", "i", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "o", "p", "g", "", "toEnable", "r", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lrs1/a;", "chatViewModel", "Landroidx/fragment/app/Fragment;", "fragment", "E0", "F0", "C0", "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "e", "mCloseIv", "mEnableAudio", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mEnableAudioIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mEnableAudioTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mToGridBtn", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", "mAudioQueueTimer", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "E", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", UserInfo.SEX_FEMALE, "Lrs1/a;", "mChatViewModel", "Le12/e;", "G", "Le12/e;", "mAudioIsOpen", "Landroidx/lifecycle/Observer;", "H", "Landroidx/lifecycle/Observer;", "mAudioIsOpenObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChatAnchorFullView extends FrameLayout implements j {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaCountDownTimerView mAudioQueueTimer;

    /* renamed from: D, reason: from kotlin metadata */
    private IGProGuildInfo mGuildInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private IGProChannelInfo mChannelInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private rs1.a mChatViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private e12.e<Boolean> mAudioIsOpen;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Observer<Boolean> mAudioIsOpenObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mCloseIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mEnableAudio;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mEnableAudioIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mEnableAudioTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mToGridBtn;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChatAnchorFullView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> f() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_user_screenshare_owner", 1);
        return hashMap;
    }

    private final void g() {
        HashMap<String, Object> f16 = f();
        View view = this.mEnableAudio;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.T0(view, "em_sgrp_avchannel_end_screenshare", clickPolicy, exposurePolicy, f16);
        View view2 = this.mCloseIv;
        ClickPolicy clickPolicy2 = ClickPolicy.REPORT_ALL;
        ch.T0(view2, "em_sgrp_avchannel_end_screenshare", clickPolicy2, exposurePolicy, f16);
        ch.T0(this.mToGridBtn, "em_sgrp_avchannel_transfer_gridpage", clickPolicy2, exposurePolicy, f16);
    }

    private final void h() {
        this.mAudioIsOpen.observeForever(this.mAudioIsOpenObserver);
    }

    private final void i() {
        this.mAudioQueueTimer.f();
        this.mCloseIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaChatAnchorFullView.j(GuildMediaChatAnchorFullView.this, view);
            }
        });
        this.mEnableAudio.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaChatAnchorFullView.k(GuildMediaChatAnchorFullView.this, view);
            }
        });
        this.mToGridBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaChatAnchorFullView.l(GuildMediaChatAnchorFullView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildMediaChatAnchorFullView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildMediaChatAnchorFullView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildMediaChatAnchorFullView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildMediaChatAnchorFullView this$0, Context context, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.i("QGMC.GuildMediaChatAnchorFullView", 1, "observe audio is open state changed:  " + it);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.mEnableAudioTv.setText(context.getString(R.string.f140320dn));
            this$0.mEnableAudio.setBackgroundResource(R.drawable.guild_audio_screen_border_bg);
            this$0.mEnableAudioIv.setImageResource(R.drawable.guild_open_audio_share);
            com.tencent.mobileqq.guild.media.core.j.c().getScreenShareAnchorInfo().p(true);
        } else {
            this$0.mEnableAudioTv.setText(context.getString(R.string.f140310dm));
            this$0.mEnableAudio.setBackgroundResource(R.drawable.guild_audio_screen_border_bg_dark);
            this$0.mEnableAudioIv.setImageResource(R.drawable.guild_close_audio_share);
            com.tencent.mobileqq.guild.media.core.j.c().getScreenShareAnchorInfo().p(false);
        }
        this$0.r(it.booleanValue());
    }

    private final void n() {
        if (o.c("QGMC.GuildMediaChatAnchorFullView")) {
            return;
        }
        QLog.i("QGMC.GuildMediaChatAnchorFullView", 1, "[onCloseClicked] ");
        com.tencent.mobileqq.guild.performance.report.e.b("audio_room_screen_close_button", null, 0, null, 0, null, 62, null);
        com.tencent.mobileqq.guild.media.core.j.a().W().d(true);
    }

    private final void o() {
        if (o.c("QGMC.GuildMediaChatAnchorFullView")) {
            return;
        }
        QLog.i("QGMC.GuildMediaChatAnchorFullView", 1, "[onEnableAudioClicked] " + this.mAudioIsOpen.getValue());
        if (Build.VERSION.SDK_INT >= 29) {
            MediaChannelUtils.O(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatAnchorFullView$onEnableAudioClicked$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(boolean z16, boolean z17) {
                    e12.e eVar;
                    e12.e eVar2;
                    e12.e eVar3;
                    if (z16) {
                        eVar = GuildMediaChatAnchorFullView.this.mAudioIsOpen;
                        eVar2 = GuildMediaChatAnchorFullView.this.mAudioIsOpen;
                        T value = eVar2.getValue();
                        Intrinsics.checkNotNull(value);
                        eVar.setValue(Boolean.valueOf(true ^ ((Boolean) value).booleanValue()));
                        com.tencent.mobileqq.guild.media.core.logic.o J = com.tencent.mobileqq.guild.media.core.j.a().J();
                        eVar3 = GuildMediaChatAnchorFullView.this.mAudioIsOpen;
                        T value2 = eVar3.getValue();
                        Intrinsics.checkNotNull(value2);
                        J.d(((Boolean) value2).booleanValue());
                        return;
                    }
                    QLog.i("QGMC.GuildMediaChatAnchorFullView", 1, "[onEnableAudioClicked] request permission failed");
                }
            });
        } else {
            QQToast.makeText(getContext(), R.string.f140330do, 0).show();
        }
    }

    private final void p() {
        if (o.c("QGMC.GuildMediaChatAnchorFullView")) {
            return;
        }
        QLog.i("QGMC.GuildMediaChatAnchorFullView", 1, "[onToGridBtnClicked] ");
        rs1.a aVar = this.mChatViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar = null;
        }
        aVar.N1().postValue(Boolean.TRUE);
    }

    private final void q() {
        this.mAudioIsOpen.removeObserver(this.mAudioIsOpenObserver);
    }

    private final void r(boolean toEnable) {
        int i3;
        HashMap<String, Object> f16 = f();
        if (toEnable) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        f16.put("sgrp_switch_type", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", this.mEnableAudio, f16);
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public boolean C0() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public boolean D0() {
        return j.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public void E0(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull rs1.a chatViewModel, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(chatViewModel, "chatViewModel");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mGuildInfo = guildInfo;
        this.mChannelInfo = channelInfo;
        this.mChatViewModel = chatViewModel;
        i();
        h();
        g();
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public void F0() {
        q();
        this.mAudioQueueTimer.g();
    }

    public /* synthetic */ GuildMediaChatAnchorFullView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChatAnchorFullView(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.egj, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026nchor_video_layout, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.tzq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.close_screen_share)");
        this.mCloseIv = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f165098uv3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.enable_audio)");
        this.mEnableAudio = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f165099uv4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.enable_audio_iv)");
        this.mEnableAudioIv = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.uv5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.enable_audio_tv)");
        this.mEnableAudioTv = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f99125oy);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.to_grid)");
        this.mToGridBtn = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.wpv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(\n\u2026ld_media_countdown_timer)");
        this.mAudioQueueTimer = (GuildMediaCountDownTimerView) findViewById6;
        this.mAudioIsOpen = new e12.e<>(Boolean.valueOf(com.tencent.mobileqq.guild.media.core.j.c().getScreenShareAnchorInfo().P));
        this.mAudioIsOpenObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.chat.view.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChatAnchorFullView.m(GuildMediaChatAnchorFullView.this, context, (Boolean) obj);
            }
        };
    }
}
