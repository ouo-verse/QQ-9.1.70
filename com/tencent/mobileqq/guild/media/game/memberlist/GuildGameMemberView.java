package com.tencent.mobileqq.guild.media.game.memberlist;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ViewKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.l;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.GuildMediaMemberListView;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001%\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u001d\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0003H\u0007J\b\u0010\n\u001a\u00020\u0003H\u0007J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0003J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0006\u0010\u0012\u001a\u00020\u0003J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0014R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010!R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "e", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "c", h.F, "Landroid/content/res/Configuration;", "newConfig", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onConfigurationChanged", "d", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "mMemberRecyclerView", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "f", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "mListAdapter", "I", "viewerCount", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "com/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView$b;", "userInfoObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGameMemberView extends FrameLayout implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaMemberListView mMemberRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseMediaUserDelegateAdapter mListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int viewerCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<LifecycleOwner> lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b userInfoObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/l;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements o<l> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull l event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildGameMemberView.this.mMemberRecyclerView.j0("onSmobaGameUserChangeNotifyForAll");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGameMemberView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e() {
        try {
            Fragment findFragment = ViewKt.findFragment(this);
            Intrinsics.checkNotNull(findFragment);
            com.tencent.mobileqq.guild.media.widget.user.adapter.b bVar = new com.tencent.mobileqq.guild.media.widget.user.adapter.b(findFragment);
            this.mListAdapter = bVar;
            this.mMemberRecyclerView.h0(bVar);
            this.mMemberRecyclerView.c0();
            i();
        } catch (IllegalStateException e16) {
            QLog.e("QGMC.GuildGameMemberView", 1, "[initRecyclerView] failed", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GuildGameMemberView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    private final void i() {
        this.mMemberRecyclerView.V();
        this.mMemberRecyclerView.j0("updateGridLayoutManagerCount");
    }

    public final void c() {
        boolean z16;
        if (isAttachedToWindow() && this.mListAdapter != null) {
            e();
            this.mMemberRecyclerView.setNeedIgnoreSelf(true);
            h();
            d();
            return;
        }
        boolean isAttachedToWindow = isAttachedToWindow();
        if (this.mListAdapter == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.w("QGMC.GuildGameMemberView", 1, "[configFromScene] ignore. attached: " + isAttachedToWindow + ", adapter: " + z16);
    }

    public final void d() {
        this.mMemberRecyclerView.c0();
        this.mMemberRecyclerView.j0("GuildGameMemberView");
    }

    public final void g(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        i();
    }

    public final void h() {
        j.d().V(l.class, this.userInfoObserver);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        QLog.i("QGMC.GuildGameMemberView", 1, "[onConfigurationChanged] ");
        this.mMemberRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.game.memberlist.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildGameMemberView.f(GuildGameMemberView.this);
            }
        });
    }

    public final void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.viewerCount = MediaChannelUtils.r(this);
        e();
        lifecycleOwner.getLifecycle().addObserver(this);
        this.lifecycleOwner = new WeakReference<>(lifecycleOwner);
    }

    public final void onDestroy() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        this.mMemberRecyclerView.onDestroy();
        j.d().j(l.class, this.userInfoObserver);
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference != null && (lifecycleOwner = weakReference.get()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        w.b("QGMC.GuildGameMemberView", "onMeasure.");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        w.a("QGMC.GuildGameMemberView", "onMeasure.");
    }

    public /* synthetic */ GuildGameMemberView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGameMemberView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.esp, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026mberview_rv_layout, this)");
        this.mRootView = inflate;
        View findViewById = findViewById(R.id.wh7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_game_member_rv)");
        this.mMemberRecyclerView = (GuildMediaMemberListView) findViewById;
        this.viewerCount = 5;
        this.userInfoObserver = new b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
    }
}
