package com.tencent.mobileqq.guild.media.chat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatNormalView;
import com.tencent.mobileqq.guild.media.chat.view.j;
import com.tencent.mobileqq.guild.media.chat.widget.GuildMediaScreenShareView;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.widget.GuildMediaMemberListView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u001d\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0004J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\b\u0010\u0019\u001a\u00020\u0006H\u0007R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/view/GuildMediaChatNormalView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/chat/view/j;", "Landroidx/lifecycle/LifecycleObserver;", "", "fromPreview", "", "g", "e", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lrs1/a;", "chatViewModel", "Landroidx/fragment/app/Fragment;", "fragment", "E0", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "F0", "C0", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareView;", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareView;", "mScreenShareLayout", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "f", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "mUserLayout", tl.h.F, "Landroidx/fragment/app/Fragment;", "mFragment", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "mHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "viewInited", "com/tencent/mobileqq/guild/media/chat/view/GuildMediaChatNormalView$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/chat/view/GuildMediaChatNormalView$b;", "mMediaRoomObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChatNormalView extends FrameLayout implements j, LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mMediaRoomObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaScreenShareView mScreenShareLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaMemberListView mUserLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler mHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean viewInited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/chat/view/GuildMediaChatNormalView$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(GuildMediaChatNormalView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.mUserLayout.Y();
            this$0.mUserLayout.j0("onUserListFirstFetched");
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void i() {
            QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onUserListFirstFetched] ");
            if (GuildMediaChatNormalView.this.viewInited) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final GuildMediaChatNormalView guildMediaChatNormalView = GuildMediaChatNormalView.this;
                uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.chat.view.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMediaChatNormalView.b.C(GuildMediaChatNormalView.this);
                    }
                }, 1000L);
                return;
            }
            GuildMediaChatNormalView.h(GuildMediaChatNormalView.this, false, 1, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChatNormalView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(boolean fromPreview) {
        GuildMediaMemberListView guildMediaMemberListView = this.mUserLayout;
        Fragment fragment = this.mFragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragment");
            fragment = null;
        }
        guildMediaMemberListView.i0(new com.tencent.mobileqq.guild.media.widget.user.adapter.c(fragment), fromPreview);
        this.mUserLayout.c0();
        this.mUserLayout.j0("GuildMediaChatNormalView");
    }

    static /* synthetic */ void f(GuildMediaChatNormalView guildMediaChatNormalView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMediaChatNormalView.e(z16);
    }

    private final void g(boolean fromPreview) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGMC.GuildMediaChatNormalView", 2, "[initView]");
        }
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (guildInfo != null && channelInfo != null) {
            if (this.mFragment == null) {
                QLog.w("QGMC.GuildMediaChatNormalView", 1, "[initView] fragment is not initialized");
                return;
            }
            if (this.viewInited) {
                logger.d().i("QGMC.GuildMediaChatNormalView", 1, "initView has been Invoked");
                return;
            }
            this.viewInited = true;
            e(fromPreview);
            Fragment fragment = this.mFragment;
            if (fragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragment");
                fragment = null;
            }
            fragment.getLifecycle().addObserver(this);
            return;
        }
        QLog.w("QGMC.GuildMediaChatNormalView", 1, "[initView] guildInfo or channelInfo is null");
    }

    static /* synthetic */ void h(GuildMediaChatNormalView guildMediaChatNormalView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMediaChatNormalView.g(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildMediaChatNormalView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f(this$0, false, 1, null);
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
        QLog.e("QGMC.GuildMediaChatNormalView", 1, " onChatSubViewCreated ");
        this.mFragment = fragment;
        this.mScreenShareLayout.f(chatViewModel);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mMediaRoomObserver);
        if (com.tencent.mobileqq.guild.media.core.j.a().I0().getListFetched()) {
            Intrinsics.checkNotNullExpressionValue(com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a, "getDataHub().userInfoList.anchors");
            if (!r2.isEmpty()) {
                QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onChatSubViewCreated] init user view directly");
                h(this, false, 1, null);
                return;
            }
        }
        if (!MediaChannelCore.INSTANCE.a().o0().getStartParams().getPreviewData().e().isEmpty()) {
            Logger.f235387a.d().i("QGMC.GuildMediaChatNormalView", 1, "[onChatSubViewCreated] init with preview data");
            g(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.chat.view.j
    public void F0() {
        QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onChatSubViewDestroy] ");
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mMediaRoomObserver);
        this.mScreenShareLayout.h();
        this.mUserLayout.onDestroy();
        Fragment fragment = this.mFragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragment");
            fragment = null;
        }
        fragment.getLifecycle().removeObserver(this);
    }

    public final boolean d() {
        return this.mUserLayout.W();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onConfigurationChanged] ");
        this.mUserLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.chat.view.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaChatNormalView.i(GuildMediaChatNormalView.this);
            }
        }, 500L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.mScreenShareLayout.setCurPageIsAvailable(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.mScreenShareLayout.setCurPageIsAvailable(true);
    }

    public /* synthetic */ GuildMediaChatNormalView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChatNormalView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f168127ey4, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026l_chat_normal_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f80424bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.screen_share_layout)");
        this.mScreenShareLayout = (GuildMediaScreenShareView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f115246vi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.user_grid_layout)");
        this.mUserLayout = (GuildMediaMemberListView) findViewById2;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mMediaRoomObserver = new b();
    }
}
