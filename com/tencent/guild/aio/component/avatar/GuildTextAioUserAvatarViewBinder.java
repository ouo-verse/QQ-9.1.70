package com.tencent.guild.aio.component.avatar;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarUIState;
import com.tencent.guild.aio.component.avatar.a;
import com.tencent.guild.aio.util.ae;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0004R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/GuildTextAioUserAvatarViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/component/avatar/a;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", "j1", "l1", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState$JumpToSelfMsgState;", "state", "h1", "Lcom/tencent/aio/base/mvvm/b;", "f1", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "bindViewAndData", "i1", "", "guildId", "e1", "m1", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mAvatarLayout", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "e", "Lkotlin/Lazy;", "g1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatarView", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildTextAioUserAvatarViewBinder extends com.tencent.aio.base.mvvm.a<a, GuildAioUserAvatarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAvatarLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAvatarView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/avatar/GuildTextAioUserAvatarViewBinder$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@Nullable MotionEvent e16) {
            GuildTextAioUserAvatarViewBinder.this.l1();
            return true;
        }
    }

    public GuildTextAioUserAvatarViewBinder() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.component.avatar.GuildTextAioUserAvatarViewBinder$mAvatarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildUserAvatarView invoke() {
                LinearLayout linearLayout;
                linearLayout = GuildTextAioUserAvatarViewBinder.this.mAvatarLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
                    linearLayout = null;
                }
                return (GuildUserAvatarView) linearLayout.findViewById(R.id.vx5);
            }
        });
        this.mAvatarView = lazy;
    }

    private final GuildUserAvatarView g1() {
        Object value = this.mAvatarView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mAvatarView>(...)");
        return (GuildUserAvatarView) value;
    }

    private final void h1(GuildAioUserAvatarUIState.JumpToSelfMsgState state) {
        int result = state.getResult();
        if (result != 0) {
            if (result != 1) {
                if (result == 2) {
                    g.c(0, R.string.f145860sm);
                    ae.e(ae.f112367a, getMContext(), new long[]{0, 30, 100, 30}, 0, 4, null);
                    return;
                }
                return;
            }
            g.c(0, R.string.f145850sl);
            ae.e(ae.f112367a, getMContext(), new long[]{0, 30, 100, 30}, 0, 4, null);
            return;
        }
        QLog.i("GuildTextAioUserAvatarViewBinder", 4, "handleJumpToSelfMsg msgSeq=" + state.getMsgSeq());
        ae.d(ae.f112367a, getMContext(), 0L, 2, null);
        com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.d(state.getMsgSeq(), true));
    }

    private final void j1() {
        final GestureDetector gestureDetector = new GestureDetector(getMContext(), new b());
        g1().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.guild.aio.component.avatar.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean k16;
                k16 = GuildTextAioUserAvatarViewBinder.k1(gestureDetector, view, motionEvent);
                return k16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k1(GestureDetector avatarGestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(avatarGestureDetector, "$avatarGestureDetector");
        avatarGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        m1();
        if (!NetworkUtil.isNetworkAvailable(null)) {
            g.c(0, R.string.f1511016s);
        } else {
            sendIntent(new a.b());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        j1();
        sendIntent(a.C1180a.f110160d);
    }

    public final void e1(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        g1().setAvatarTinyId(guildId, ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildAioUserAvatarUIState> createVM() {
        return new e();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioUserAvatarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioUserAvatarUIState.JumpToSelfMsgState) {
            h1((GuildAioUserAvatarUIState.JumpToSelfMsgState) state);
        } else if (state instanceof GuildAioUserAvatarUIState.UpdateAvatarState) {
            e1(((GuildAioUserAvatarUIState.UpdateAvatarState) state).getGuildId());
        }
    }

    public final void m1() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ViewUtils.dpToPx(1.3333334f));
        translateAnimation.setInterpolator(new CycleInterpolator(2.0f));
        translateAnimation.setDuration(200L);
        g1().startAnimation(translateAnimation);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        View findViewById = params.b().findViewById(R.id.vyo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "params.parent.findViewBy\u2026d_aio_user_avatar_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mAvatarLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
            return null;
        }
        return linearLayout;
    }
}
