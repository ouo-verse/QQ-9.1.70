package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u001d!\u0018\u0000 +2\u00020\u0001:\u0001,B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", "Landroid/widget/FrameLayout;", "", "countDownTime", "", "k", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "", "j", "f", "g", tl.h.F, "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mAudioQueueTimerContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mAudioQueueTimerTv", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "countDownTimeObserver", "com/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView$c", "i", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView$c;", "audioQueueSpeakStartObserver", "com/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView$b;", "audioQueueSpeakFinishObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaCountDownTimerView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout mAudioQueueTimerContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mAudioQueueTimerTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Integer> countDownTimeObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c audioQueueSpeakStartObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b audioQueueSpeakFinishObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.a> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d("GuildMediaCountDownTimerView", 1, "AudioQueueSpeakFinishEvent onEventReceive");
            com.tencent.mobileqq.guild.media.core.data.p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
            if (GuildMediaCountDownTimerView.this.j(event, h16)) {
                QLog.d("GuildMediaCountDownTimerView", 1, "speak finished");
                if (h16 != null) {
                    com.tencent.mobileqq.guild.media.core.logic.ac M = com.tencent.mobileqq.guild.media.core.j.a().M();
                    String str = h16.f228093a;
                    Intrinsics.checkNotNullExpressionValue(str, "anchorUser.id");
                    com.tencent.mobileqq.guild.media.core.logic.ac.T0(M, str, false, 2, null);
                }
                com.tencent.mobileqq.guild.media.core.j.a().M().l0().removeObserver(GuildMediaCountDownTimerView.this.countDownTimeObserver);
                GuildMediaCountDownTimerView.this.k(0);
                if (h16 != null && !MediaChannelUtils.f228046a.t(h16)) {
                    com.tencent.mobileqq.guild.media.core.j.a().W().d(true);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/b;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.b> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.b event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d("GuildMediaCountDownTimerView", 1, "AudioQueueSpeakStartEvent onEventReceive");
            if (event.getNotifyAll()) {
                GuildMediaCountDownTimerView.i(GuildMediaCountDownTimerView.this, null, 1, null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaCountDownTimerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildMediaCountDownTimerView this$0, Integer countDownTime) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(countDownTime, "countDownTime");
        this$0.k(countDownTime.intValue());
    }

    public static /* synthetic */ void i(GuildMediaCountDownTimerView guildMediaCountDownTimerView, com.tencent.mobileqq.guild.media.core.data.p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pVar = null;
        }
        guildMediaCountDownTimerView.h(pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(com.tencent.mobileqq.guild.media.core.notify.a event, com.tencent.mobileqq.guild.media.core.data.p userInfo) {
        if (!event.getNotifyForAll() && event.b() != null && !event.b().isEmpty() && (userInfo == null || !event.b().contains(userInfo.f228093a))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int countDownTime) {
        if (countDownTime == 0) {
            this.mAudioQueueTimerContainer.setVisibility(8);
        } else {
            this.mAudioQueueTimerContainer.setVisibility(0);
            this.mAudioQueueTimerTv.setText(MediaChannelUtils.f228046a.f(countDownTime));
        }
    }

    public final void f() {
        QLog.d("GuildMediaCountDownTimerView", 1, OperateCustomButton.OPERATE_CREATE);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.b.class, this.audioQueueSpeakStartObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueSpeakFinishObserver);
        i(this, null, 1, null);
    }

    public final void g() {
        QLog.d("GuildMediaCountDownTimerView", 1, "destroy");
        com.tencent.mobileqq.guild.media.core.j.a().M().l0().removeObserver(this.countDownTimeObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.b.class, this.audioQueueSpeakStartObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueSpeakFinishObserver);
    }

    public final void h(@Nullable com.tencent.mobileqq.guild.media.core.data.p userInfo) {
        if (userInfo == null) {
            userInfo = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        }
        if (userInfo != null && MediaChannelUtils.f228046a.u(com.tencent.mobileqq.guild.media.core.j.a().E()) && userInfo.G > 0 && userInfo.E) {
            QLog.i("QGMC.GuildMediaChatAudienceFullView", 1, "[initCountDownTimer]");
            com.tencent.mobileqq.guild.media.core.logic.ac M = com.tencent.mobileqq.guild.media.core.j.a().M();
            long j3 = userInfo.H;
            long j16 = userInfo.G;
            String str = userInfo.f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "anchorInfo.id");
            com.tencent.mobileqq.guild.media.core.logic.ac.R0(M, j3, j16, str, false, 8, null);
            com.tencent.mobileqq.guild.media.core.j.a().M().l0().observeForever(this.countDownTimeObserver);
        }
    }

    public /* synthetic */ GuildMediaCountDownTimerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaCountDownTimerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eyf, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026untdown_timer_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.x08);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(\n\u2026ountdown_timer_container)");
        this.mAudioQueueTimerContainer = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.x09);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026share_countdown_timer_tv)");
        this.mAudioQueueTimerTv = (TextView) findViewById2;
        this.countDownTimeObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaCountDownTimerView.e(GuildMediaCountDownTimerView.this, (Integer) obj);
            }
        };
        this.audioQueueSpeakStartObserver = new c();
        this.audioQueueSpeakFinishObserver = new b();
    }
}
