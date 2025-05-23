package com.tencent.mobileqq.guild.media.chat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.widget.GuildMediaCountDownTimerView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u0001:\u0001@B\u001d\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareView;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "l", "t", "o", "", "available", "isSelfSharing", "p", "isSelfJustSharing", "r", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lrs1/a;", "chatViewModel", "f", tl.h.F, "setCurPageIsAvailable", "d", "Z", "isCurPageAvailable", "e", "isVideoViewAddFailed", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareContainer;", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareContainer;", "mShareLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mCloseScreenShareBtn", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "mAnchorHintLayout", "D", "Landroid/widget/FrameLayout;", "mAudienceVideoLayout", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "E", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "mAnchorInfoBar", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", "mAudioQueueTimer", "G", "Lrs1/a;", "mChatViewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaScreenShareView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mAnchorHintLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout mAudienceVideoLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaAnchorInfoBar mAnchorInfoBar;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaCountDownTimerView mAudioQueueTimer;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private rs1.a mChatViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCurPageAvailable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoViewAddFailed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private y mAudioRoomObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaScreenShareContainer mShareLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mCloseScreenShareBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\r\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareView$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "userId", "", "available", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "from", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", HippyTKDListViewAdapter.X, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@Nullable String from, @Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo) {
            if (Intrinsics.areEqual("onFetchAudioChannelUserList", from)) {
                if (!GuildMediaScreenShareView.this.isCurPageAvailable) {
                    QLog.i("QGMC.GuildMediaScreenShareView", 1, "page isCurPageAvailable is false return");
                    return;
                }
                QLog.i("QGMC.GuildMediaScreenShareView", 1, "[onUserDataUpdate] ON_FETCH_AUDIO_CHANNEL_USER_LIST");
                GuildMediaScreenShareView.this.j();
                GuildMediaScreenShareView.s(GuildMediaScreenShareView.this, false, 1, null);
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void z(@Nullable String userId, boolean available) {
            QLog.i("QGMC.GuildMediaScreenShareView", 1, "[onUserVideoAvailable] userId: " + userId + ", " + available);
            if (GuildMediaScreenShareView.this.isCurPageAvailable) {
                GuildMediaScreenShareView.this.p(available, Intrinsics.areEqual(userId, j.c().getSelfUserInfo().f228093a));
            } else {
                QLog.i("QGMC.GuildMediaScreenShareView", 1, "page isCurPageAvailable is false return");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaScreenShareView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void g(GuildMediaScreenShareView guildMediaScreenShareView, rs1.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        guildMediaScreenShareView.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        FragmentActivity fragmentActivity;
        MutableLiveData<Boolean> O1;
        rs1.a aVar = this.mChatViewModel;
        if (aVar != null && (O1 = aVar.O1()) != null) {
            O1.postValue(Boolean.TRUE);
        }
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            GuildMediaAioViewModel.INSTANCE.a(fragmentActivity).l2(b.l.f227878a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        p h16 = j.c().getUserInfoList().h();
        if (h16 != null) {
            this.mAnchorInfoBar.k(h16);
            this.mAnchorInfoBar.setToFullViewButton(true, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.chat.widget.GuildMediaScreenShareView$initAnchorBarView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    QLog.i("QGMC.GuildMediaScreenShareView", 1, "[initAnchorBarView] on full view button clicked");
                    GuildMediaScreenShareView.this.i();
                }
            });
        }
    }

    private final void k() {
        ch.Y0(this.mRootView, "em_sgrp_avchannel_screenshare_window", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        ch.Y0(this.mCloseScreenShareBtn, "em_sgrp_avchannel_end_screenshare", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    private final void l() {
        this.mAudioRoomObserver = new b();
        AudioNotifyHelper l06 = j.a().l0();
        y yVar = this.mAudioRoomObserver;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioRoomObserver");
            yVar = null;
        }
        l06.b(yVar);
    }

    private final void m() {
        this.mShareLayout.g();
        this.mCloseScreenShareBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaScreenShareView.n(GuildMediaScreenShareView.this, view);
            }
        });
        k();
        j();
        s(this, false, 1, null);
        this.mAudioQueueTimer.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildMediaScreenShareView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o() {
        QLog.i("QGMC.GuildMediaScreenShareView", 1, "[onScreenShareBtnClicked] ");
        j.a().W().d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean available, boolean isSelfSharing) {
        if (!available) {
            setVisibility(8);
            return;
        }
        j();
        r(isSelfSharing);
        GuildMediaCountDownTimerView.i(this.mAudioQueueTimer, null, 1, null);
    }

    private final void q(boolean isSelfSharing) {
        HashMap hashMap = new HashMap();
        int i3 = 1;
        if (!isSelfSharing) {
            if (!isSelfSharing) {
                i3 = 2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        hashMap.put("sgrp_user_screenshare_owner", Integer.valueOf(i3));
        VideoReport.reportEvent("imp", this, hashMap);
    }

    private final void r(boolean isSelfJustSharing) {
        this.mAnchorHintLayout.setVisibility(8);
        boolean z16 = false;
        this.mAudienceVideoLayout.setVisibility(0);
        p h16 = j.c().getUserInfoList().h();
        QLog.i("QGMC.GuildMediaScreenShareView", 1, "[tryAddVideoView] anchorUser: " + h16);
        if (h16 == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (Intrinsics.areEqual(j.c().getSelfUserInfo().f228093a, h16.f228093a)) {
            q(true);
            if (isSelfJustSharing) {
                i();
                return;
            } else {
                this.mAnchorHintLayout.setVisibility(0);
                this.mAudienceVideoLayout.setVisibility(8);
                return;
            }
        }
        if (this.mAudienceVideoLayout.getChildCount() > 0 && !this.isVideoViewAddFailed) {
            QLog.i("QGMC.GuildMediaScreenShareView", 1, "[tryAddVideoView] already in layout. ignore");
            return;
        }
        q(false);
        this.mAudienceVideoLayout.removeAllViews();
        us1.b H0 = j.a().H0();
        String str = h16.f228093a;
        Intrinsics.checkNotNullExpressionValue(str, "anchorUser.id");
        View a16 = b.a.a(H0, str, false, 2, null);
        this.mAudienceVideoLayout.addView(a16);
        if (a16.getWidth() <= 0) {
            z16 = true;
        }
        this.isVideoViewAddFailed = z16;
    }

    static /* synthetic */ void s(GuildMediaScreenShareView guildMediaScreenShareView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMediaScreenShareView.r(z16);
    }

    private final void t() {
        if (this.mAudioRoomObserver != null) {
            AudioNotifyHelper l06 = j.a().l0();
            y yVar = this.mAudioRoomObserver;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioRoomObserver");
                yVar = null;
            }
            l06.B(yVar);
        }
    }

    public final void f(@Nullable rs1.a chatViewModel) {
        QLog.i("QGMC.GuildMediaScreenShareView", 1, "[doOnCreate] ");
        this.mChatViewModel = chatViewModel;
        m();
        l();
    }

    public final void h() {
        QLog.i("QGMC.GuildMediaScreenShareView", 1, "[doOnDestroy] ");
        this.mAudioQueueTimer.g();
        t();
        this.mChatViewModel = null;
    }

    public final void setCurPageIsAvailable(boolean available) {
        this.isCurPageAvailable = available;
        if (available) {
            j();
            s(this, false, 1, null);
        }
    }

    public /* synthetic */ GuildMediaScreenShareView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaScreenShareView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isCurPageAvailable = true;
        View inflate = View.inflate(context, R.layout.eyb, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026_screen_share_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.e37);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.layout_container)");
        this.mShareLayout = (GuildMediaScreenShareContainer) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tzr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026d.close_screen_share_btn)");
        this.mCloseScreenShareBtn = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f164320so4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.anchor_hint_layout)");
        this.mAnchorHintLayout = (LinearLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.swp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.audience_layout)");
        this.mAudienceVideoLayout = (FrameLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.so7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.anchor_info_bar)");
        this.mAnchorInfoBar = (GuildMediaAnchorInfoBar) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.wpv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(\n\u2026ld_media_countdown_timer)");
        this.mAudioQueueTimer = (GuildMediaCountDownTimerView) findViewById6;
    }
}
