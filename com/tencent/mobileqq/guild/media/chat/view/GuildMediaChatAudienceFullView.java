package com.tencent.mobileqq.guild.media.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.chat.widget.GuildMediaAnchorInfoBar;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.immersive.GuildMediaImmersiveEvent;
import com.tencent.mobileqq.guild.media.widget.GuildMediaCountDownTimerView;
import com.tencent.mobileqq.guild.media.widget.zoom.ZoomLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u00019B\u001d\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0014`\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/view/GuildMediaChatAudienceFullView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/chat/view/j;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/media/immersive/GuildMediaImmersiveEvent;", "", "d", "event", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lrs1/a;", "chatViewModel", "Landroidx/fragment/app/Fragment;", "fragment", "E0", "F0", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "", "C0", "D0", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/widget/zoom/ZoomLayout;", "e", "Lcom/tencent/mobileqq/guild/media/widget/zoom/ZoomLayout;", "mAudienceVideoLayout", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "f", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "mAnchorInfoBar", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", tl.h.F, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", "mAudioQueueTimer", "i", "Lrs1/a;", "mChatViewModel", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "showAnchorBarRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChatAudienceFullView extends FrameLayout implements j, SimpleEventReceiver<GuildMediaImmersiveEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZoomLayout mAudienceVideoLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaAnchorInfoBar mAnchorInfoBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaCountDownTimerView mAudioQueueTimer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private rs1.a mChatViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable showAnchorBarRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChatAudienceFullView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(GuildMediaImmersiveEvent event) {
        TranslateAnimation translateAnimation;
        TranslateAnimation translateAnimation2;
        QLog.i("QGMC.GuildMediaChatAudienceFullView", 1, "[handleImmersiveEvent] " + event.getToEnterImmersiveState());
        float dimensionPixelSize = ((float) getContext().getResources().getDimensionPixelSize(R.dimen.f158984ch4)) + ((float) this.mAnchorInfoBar.getMeasuredHeight());
        boolean toEnterImmersiveState = event.getToEnterImmersiveState();
        if (toEnterImmersiveState) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, dimensionPixelSize);
            translateAnimation.setDuration(800L);
        } else if (!toEnterImmersiveState) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, dimensionPixelSize, 0.0f);
            translateAnimation.setDuration(300L);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        translateAnimation.setFillAfter(true);
        this.mAnchorInfoBar.startAnimation(translateAnimation);
        getContext().getResources().getDimensionPixelSize(R.dimen.ciq);
        this.mAudioQueueTimer.getMeasuredHeight();
        boolean toEnterImmersiveState2 = event.getToEnterImmersiveState();
        if (toEnterImmersiveState2) {
            translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -dimensionPixelSize);
            translateAnimation2.setDuration(800L);
        } else if (!toEnterImmersiveState2) {
            translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, -dimensionPixelSize, 0.0f);
            translateAnimation2.setDuration(300L);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        translateAnimation2.setFillAfter(true);
        this.mAudioQueueTimer.startAnimation(translateAnimation2);
    }

    private final void d() {
        p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        if (h16 != null) {
            this.mAnchorInfoBar.k(h16);
            this.mAnchorInfoBar.setToGridButton(true, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatAudienceFullView$initAnchorBarUI$1
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
                    rs1.a aVar;
                    MutableLiveData<Boolean> N1;
                    Intrinsics.checkNotNullParameter(it, "it");
                    QLog.i("QGMC.GuildMediaChatAudienceFullView", 1, "[initAnchorBarUI] on toGrid button clicked");
                    aVar = GuildMediaChatAudienceFullView.this.mChatViewModel;
                    if (aVar == null || (N1 = aVar.N1()) == null) {
                        return;
                    }
                    N1.postValue(Boolean.TRUE);
                }
            });
            this.mAnchorInfoBar.setOrientationButton(!AppSetting.t(getContext()), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatAudienceFullView$initAnchorBarUI$2
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
                    rs1.a aVar;
                    MutableLiveData<Boolean> P1;
                    Intrinsics.checkNotNullParameter(it, "it");
                    QLog.i("QGMC.GuildMediaChatAudienceFullView", 1, "[initAnchorBarUI] on orientation button clicked");
                    aVar = GuildMediaChatAudienceFullView.this.mChatViewModel;
                    if (aVar == null || (P1 = aVar.P1()) == null) {
                        return;
                    }
                    P1.postValue(Boolean.TRUE);
                }
            });
        }
        this.mAudioQueueTimer.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildMediaChatAudienceFullView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAnchorInfoBar.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public boolean C0() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public boolean D0() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public void E0(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull rs1.a chatViewModel, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(chatViewModel, "chatViewModel");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        QLog.d("QGMC.GuildMediaChatAudienceFullView", 1, "onChatSubViewCreated");
        this.mChatViewModel = chatViewModel;
        p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        us1.b H0 = com.tencent.mobileqq.guild.media.core.j.a().H0();
        if (h16 != null) {
            ZoomLayout zoomLayout = this.mAudienceVideoLayout;
            String str = h16.f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "anchorInfo.id");
            zoomLayout.addView(b.a.a(H0, str, false, 2, null));
        } else {
            QLog.w("QGMC.GuildMediaChatAudienceFullView", 1, "[onChatSubViewCreated] anchor not found");
        }
        d();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public void F0() {
        QLog.d("QGMC.GuildMediaChatAudienceFullView", 1, "onChatSubViewDestroy");
        this.mChatViewModel = null;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showAnchorBarRunnable);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.mAudioQueueTimer.g();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildMediaImmersiveEvent>> getEventClass() {
        ArrayList<Class<GuildMediaImmersiveEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildMediaImmersiveEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!(event instanceof GuildMediaImmersiveEvent)) {
            return;
        }
        c((GuildMediaImmersiveEvent) event);
    }

    public /* synthetic */ GuildMediaChatAudienceFullView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChatAudienceFullView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f168126ey3, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026audience_full_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.krz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.video_layout)");
        this.mAudienceVideoLayout = (ZoomLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.so7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.anchor_info_bar)");
        this.mAnchorInfoBar = (GuildMediaAnchorInfoBar) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.wpv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026ld_media_countdown_timer)");
        this.mAudioQueueTimer = (GuildMediaCountDownTimerView) findViewById3;
        this.showAnchorBarRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.chat.view.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaChatAudienceFullView.e(GuildMediaChatAudienceFullView.this);
            }
        };
    }
}
