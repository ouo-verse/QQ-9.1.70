package com.tencent.mobileqq.guild.media.aio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.GuildFadeOutTextView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaRoomMsgGuideView;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/GuildMediaRoomMsgGuideController;", "", "", "j", "", "k", "l", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f", "Landroid/view/View;", "a", "Landroid/view/View;", "guideContainerView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRoomMsgGuideView;", "b", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRoomMsgGuideView;", "guideAnimView", "Lcom/tencent/mobileqq/guild/media/widget/GuildFadeOutTextView;", "c", "Lcom/tencent/mobileqq/guild/media/widget/GuildFadeOutTextView;", "guideTextView", "d", "Landroid/view/ViewGroup;", "rootViewGroup", "Ljava/lang/Runnable;", "e", "Lkotlin/Lazy;", "i", "()Ljava/lang/Runnable;", "delayRunnable", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaRoomMsgGuideController {

    /* renamed from: g, reason: collision with root package name */
    private static final int f227822g = Color.parseColor("#C0000000");

    /* renamed from: h, reason: collision with root package name */
    private static final int f227823h = ViewUtils.dip2px(100.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final float f227824i = ViewUtils.dip2px(17.0f);

    /* renamed from: j, reason: collision with root package name */
    private static final int f227825j = Color.parseColor("#FFFCEF");

    /* renamed from: k, reason: collision with root package name */
    private static final long f227826k = 300;

    /* renamed from: l, reason: collision with root package name */
    private static final long f227827l = 500;

    /* renamed from: m, reason: collision with root package name */
    private static final int f227828m = 4;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View guideContainerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMediaRoomMsgGuideView guideAnimView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFadeOutTextView guideTextView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup rootViewGroup;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy delayRunnable;

    public GuildMediaRoomMsgGuideController() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new GuildMediaRoomMsgGuideController$delayRunnable$2(this));
        this.delayRunnable = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(GuildMediaRoomMsgGuideController this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GuildMediaRoomMsgGuideController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    private final Runnable i() {
        return (Runnable) this.delayRunnable.getValue();
    }

    private final void j() {
        ViewGroup viewGroup;
        QLog.i("GMediaRMsgGuideContainer", 1, "[hideGuideView] ");
        GuildMediaRoomMsgGuideView guildMediaRoomMsgGuideView = this.guideAnimView;
        if (guildMediaRoomMsgGuideView != null) {
            guildMediaRoomMsgGuideView.removeCallbacks(i());
        }
        View view = this.guideContainerView;
        boolean z16 = false;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            bw.f235485a.v1(true);
            View view2 = this.guideContainerView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            GuildMediaRoomMsgGuideView guildMediaRoomMsgGuideView2 = this.guideAnimView;
            if (guildMediaRoomMsgGuideView2 != null) {
                guildMediaRoomMsgGuideView2.l();
            }
            GuildFadeOutTextView guildFadeOutTextView = this.guideTextView;
            if (guildFadeOutTextView != null) {
                guildFadeOutTextView.e();
            }
        }
        View view3 = this.guideContainerView;
        if (view3 != null && (viewGroup = this.rootViewGroup) != null) {
            viewGroup.removeView(view3);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void f(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (bw.f235485a.O()) {
            QLog.i("GMediaRMsgGuideContainer", 1, "[checkToAddGuildView] hasShow");
            return;
        }
        this.rootViewGroup = rootView;
        Context context = rootView.getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.media.aio.y
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g16;
                g16 = GuildMediaRoomMsgGuideController.g(GuildMediaRoomMsgGuideController.this, view, motionEvent);
                return g16;
            }
        });
        frameLayout.setBackgroundColor(f227822g);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        GuildMediaRoomMsgGuideView guildMediaRoomMsgGuideView = new GuildMediaRoomMsgGuideView(context, null, 0, 6, null);
        guildMediaRoomMsgGuideView.setLayoutParams(new LinearLayout.LayoutParams(-1, f227823h));
        guildMediaRoomMsgGuideView.setAnimMaxStartCount(f227828m);
        guildMediaRoomMsgGuideView.setAnimFinishCallBack(new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.z
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaRoomMsgGuideController.h(GuildMediaRoomMsgGuideController.this);
            }
        });
        this.guideAnimView = guildMediaRoomMsgGuideView;
        linearLayout.addView(guildMediaRoomMsgGuideView);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildFadeOutTextView guildFadeOutTextView = new GuildFadeOutTextView(context, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        guildFadeOutTextView.setLayoutParams(layoutParams2);
        guildFadeOutTextView.setText(context.getResources().getString(R.string.f1492211p));
        guildFadeOutTextView.setTextColor(f227825j);
        guildFadeOutTextView.setTextSize(0, f227824i);
        guildFadeOutTextView.f(f227826k);
        this.guideTextView = guildFadeOutTextView;
        linearLayout.addView(guildFadeOutTextView);
        frameLayout.addView(linearLayout);
        this.guideContainerView = frameLayout;
        rootView.addView(frameLayout);
        GuildMediaRoomMsgGuideView guildMediaRoomMsgGuideView2 = this.guideAnimView;
        if (guildMediaRoomMsgGuideView2 != null) {
            guildMediaRoomMsgGuideView2.postDelayed(i(), f227827l);
        }
        QLog.i("GMediaRMsgGuideContainer", 1, "[checkToShowGuideView] ");
    }

    public final boolean k() {
        View view = this.guideContainerView;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final void l() {
        j();
    }
}
