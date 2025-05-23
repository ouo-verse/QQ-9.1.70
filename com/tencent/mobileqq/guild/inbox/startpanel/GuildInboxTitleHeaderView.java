package com.tencent.mobileqq.guild.inbox.startpanel;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.GuildInboxSettingDialog;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.message.unread.api.d;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0003:;<B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b1\u00102B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b1\u00105B#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b1\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;", "Landroid/widget/FrameLayout;", "", "k", "f", "Landroid/content/Context;", "context", "g", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "isVisible", "onVisibilityAggregated", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/activity/recent/cur/b;", "listener", "e", "Lcom/tencent/mobileqq/banner/TipsBar;", "d", "Lcom/tencent/mobileqq/banner/TipsBar;", "mNetworkTipsBar", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "mInboxTitle", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "mUnreadView", "Landroid/view/View;", tl.h.F, "Landroid/view/View;", "mSettingIcon", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "mMineUnreadCount", "Z", "currentVisible", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildTotalUnreadService;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildTotalUnreadService;", "totalUnreadService", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView$b;", "D", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView$b;", "mUnreadChangeCallback", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView$InnerNetworkUpdateListener;", "E", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView$InnerNetworkUpdateListener;", "mNetworkListener", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "InnerNetworkUpdateListener", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInboxTitleHeaderView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private IGuildTotalUnreadService totalUnreadService;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mUnreadChangeCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final InnerNetworkUpdateListener mNetworkListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TipsBar mNetworkTipsBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildChannelNameTextView mInboxTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildDragTextView mUnreadView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mSettingIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private UnreadInfo.a mMineUnreadCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean currentVisible;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView$InnerNetworkUpdateListener;", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "", "connected", "", "onNetworkConnect", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;", "a", "Lmqq/util/WeakReference;", "viewRef", "view", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class InnerNetworkUpdateListener implements INetworkStateApi.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildInboxTitleHeaderView> viewRef;

        public InnerNetworkUpdateListener(@NotNull GuildInboxTitleHeaderView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.viewRef = new WeakReference<>(view);
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
        public void onNetworkConnect(boolean connected) {
            final GuildInboxTitleHeaderView guildInboxTitleHeaderView = this.viewRef.get();
            if (guildInboxTitleHeaderView != null) {
                ThreadUtils threadUtils = ThreadUtils.f235400a;
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    guildInboxTitleHeaderView.l();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.GuildInboxTitleHeaderView$InnerNetworkUpdateListener$onNetworkConnect$lambda$1$$inlined$ensureUiThread$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildInboxTitleHeaderView it = GuildInboxTitleHeaderView.this;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            GuildInboxTitleHeaderView.this.l();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView$b;", "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;", "a", "Lmqq/util/WeakReference;", "viewRef", "view", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.message.unread.api.d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildInboxTitleHeaderView> viewRef;

        public b(@NotNull GuildInboxTitleHeaderView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.viewRef = new WeakReference<>(view);
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.d
        public void a(@NotNull UnreadInfo.a aVar) {
            d.a.a(this, aVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildInboxTitleHeaderView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f() {
        int i3;
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.mNetworkListener);
        IGuildTotalUnreadService iGuildTotalUnreadService = this.totalUnreadService;
        if (iGuildTotalUnreadService != null) {
            iGuildTotalUnreadService.unRegisterGuildTabUnreadCallback(this.mUnreadChangeCallback);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            int hashCode = hashCode();
            IGuildTotalUnreadService iGuildTotalUnreadService2 = this.totalUnreadService;
            if (iGuildTotalUnreadService2 != null) {
                i3 = iGuildTotalUnreadService2.hashCode();
            } else {
                i3 = 0;
            }
            Log.d("GuildInboxTitleHeaderView", "hide " + hashCode + " " + i3);
        }
        this.totalUnreadService = null;
    }

    private final void g(final Context context) {
        View.inflate(context, R.layout.euw, this);
        View findViewById = findViewById(R.id.xm6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.inbox_title)");
        this.mInboxTitle = (GuildChannelNameTextView) findViewById;
        View findViewById2 = findViewById(R.id.ws9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_network_status_bar)");
        this.mNetworkTipsBar = (TipsBar) findViewById2;
        View findViewById3 = findViewById(R.id.xm7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.inbox_unread)");
        this.mUnreadView = (GuildDragTextView) findViewById3;
        View findViewById4 = findViewById(R.id.wj_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_inbox_setting)");
        this.mSettingIcon = findViewById4;
        GuildDragTextView guildDragTextView = this.mUnreadView;
        View view = null;
        if (guildDragTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            guildDragTextView = null;
        }
        guildDragTextView.setTypeface(TypefaceProvider.c(getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
        GuildDragTextView guildDragTextView2 = this.mUnreadView;
        if (guildDragTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            guildDragTextView2 = null;
        }
        guildDragTextView2.setDragViewType(2, this);
        GuildDragTextView guildDragTextView3 = this.mUnreadView;
        if (guildDragTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            guildDragTextView3 = null;
        }
        guildDragTextView3.setTag("GuildInboxTitleHeaderView");
        i();
        m();
        View view2 = this.mSettingIcon;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingIcon");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildInboxTitleHeaderView.h(GuildInboxTitleHeaderView.this, context, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GuildInboxTitleHeaderView this$0, Context context, View view) {
        FragmentActivity fragmentActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                new GuildInboxSettingDialog(false, 1, defaultConstructorMarker).show(fragmentActivity.getSupportFragmentManager(), "GuildInboxTitleHeaderView");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        TipsBar tipsBar = this.mNetworkTipsBar;
        TipsBar tipsBar2 = null;
        if (tipsBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNetworkTipsBar");
            tipsBar = null;
        }
        tipsBar.setBarType(2);
        TipsBar tipsBar3 = this.mNetworkTipsBar;
        if (tipsBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNetworkTipsBar");
            tipsBar3 = null;
        }
        tipsBar3.setTipsText(getResources().getText(R.string.f1510916r));
        TipsBar tipsBar4 = this.mNetworkTipsBar;
        if (tipsBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNetworkTipsBar");
            tipsBar4 = null;
        }
        tipsBar4.setTipsIcon(getResources().getDrawable(R.drawable.common_banner_tips_warning));
        l();
        TipsBar tipsBar5 = this.mNetworkTipsBar;
        if (tipsBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNetworkTipsBar");
        } else {
            tipsBar2 = tipsBar5;
        }
        tipsBar2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInboxTitleHeaderView.j(GuildInboxTitleHeaderView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildInboxTitleHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            ch.i().startActivity(new Intent("android.settings.SETTINGS"));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k() {
        int i3;
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(this.mNetworkListener);
        IRuntimeService S0 = ch.S0(IGuildTotalUnreadService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGuildTotalUnreadService iGuildTotalUnreadService = (IGuildTotalUnreadService) S0;
        this.mMineUnreadCount = iGuildTotalUnreadService.getTotalCount().getMine();
        iGuildTotalUnreadService.registerGuildTabUnreadCallback(this.mUnreadChangeCallback);
        this.totalUnreadService = iGuildTotalUnreadService;
        l();
        m();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            int hashCode = hashCode();
            IGuildTotalUnreadService iGuildTotalUnreadService2 = this.totalUnreadService;
            if (iGuildTotalUnreadService2 != null) {
                i3 = iGuildTotalUnreadService2.hashCode();
            } else {
                i3 = 0;
            }
            Log.d("GuildInboxTitleHeaderView", "show " + hashCode + " " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        int i3;
        boolean isNetworkAvailable = ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).isNetworkAvailable();
        TipsBar tipsBar = this.mNetworkTipsBar;
        GuildChannelNameTextView guildChannelNameTextView = null;
        if (tipsBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNetworkTipsBar");
            tipsBar = null;
        }
        if (!isNetworkAvailable) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        tipsBar.setVisibility(i3);
        GuildChannelNameTextView guildChannelNameTextView2 = this.mInboxTitle;
        if (guildChannelNameTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxTitle");
        } else {
            guildChannelNameTextView = guildChannelNameTextView2;
        }
        String string = getResources().getString(R.string.f146660us);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.guild_inbox_title)");
        guildChannelNameTextView.setTitleText(string, isNetworkAvailable);
    }

    private final void m() {
        String valueOf;
        GuildDragTextView guildDragTextView = null;
        if (!this.mMineUnreadCount.getIsStrongUnread()) {
            GuildDragTextView guildDragTextView2 = this.mUnreadView;
            if (guildDragTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            } else {
                guildDragTextView = guildDragTextView2;
            }
            guildDragTextView.setVisibility(8);
            return;
        }
        if (this.mMineUnreadCount.getCount() <= 0) {
            GuildDragTextView guildDragTextView3 = this.mUnreadView;
            if (guildDragTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            } else {
                guildDragTextView = guildDragTextView3;
            }
            guildDragTextView.setVisibility(8);
            return;
        }
        GuildDragTextView guildDragTextView4 = this.mUnreadView;
        if (guildDragTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            guildDragTextView4 = null;
        }
        guildDragTextView4.setVisibility(0);
        GuildDragTextView guildDragTextView5 = this.mUnreadView;
        if (guildDragTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            guildDragTextView5 = null;
        }
        guildDragTextView5.j(R.drawable.guild_inbox_leading_icon, QQGuildUIUtil.f(12.0f));
        GuildDragTextView guildDragTextView6 = this.mUnreadView;
        if (guildDragTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
        } else {
            guildDragTextView = guildDragTextView6;
        }
        if (this.mMineUnreadCount.getCount() > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(this.mMineUnreadCount.getCount());
        }
        guildDragTextView.setText(valueOf);
    }

    public final void e(@NotNull com.tencent.mobileqq.activity.recent.cur.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        GuildDragTextView guildDragTextView = this.mUnreadView;
        if (guildDragTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadView");
            guildDragTextView = null;
        }
        guildDragTextView.setOnModeChangeListener(listener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (this.currentVisible == isVisible) {
            return;
        }
        if (isVisible) {
            k();
        } else {
            f();
        }
        this.currentVisible = isVisible;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildInboxTitleHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInboxTitleHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMineUnreadCount = new UnreadInfo.a(false, 0, 0, 7, null);
        this.mUnreadChangeCallback = new b(this);
        this.mNetworkListener = new InnerNetworkUpdateListener(this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        g(context2);
    }
}
