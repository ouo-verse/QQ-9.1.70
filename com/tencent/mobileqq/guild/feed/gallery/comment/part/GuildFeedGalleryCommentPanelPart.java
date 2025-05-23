package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2;
import com.tencent.mobileqq.guild.feed.gallery.widget.FeedHalfScreenFloatingView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.CommentLoadInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import hk1.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002IO\u0018\u0000 f2\u00020\u0001:\u0001gB\u0011\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u00a2\u0006\u0004\bd\u0010eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002`\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\f\u0010\u001b\u001a\u00020\u0004*\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\u001c\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R$\u0010H\u001a\u00020B2\u0006\u0010C\u001a\u00020B8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001b\u0010R\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010K\u001a\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010K\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010K\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010K\u001a\u0004\b_\u0010`\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart;", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "", "args", "", "va", "dismissCommentPanel", "", "oa", "", "aa", "na", "ma", "wa", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "da", "sa", "pa", "la", "canSlide", "enableSlide", "ca", "ba", "initHalfScreenView", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView;", "ta", "Y9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onBackEvent", "action", "handleBroadcastMessage", "getMessage", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "containerView", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView;", "halfScreenFloatingView", "i", "Landroid/view/View;", "bottomInput", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "commentPanelDragging", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "commentContentView", "D", "I", "touchSlop", "E", "onShowCompletely", UserInfo.SEX_FEMALE, "commentPanelHeight", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/InterceptState;", "value", "G", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/InterceptState;", "ua", "(Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/InterceptState;)V", "interceptState", "com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2$a", "H", "Lkotlin/Lazy;", "ia", "()Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2$a;", "halfScreenFloatingControllerAdapter", "com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2$a", LocaleUtils.L_JAPANESE, "()Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2$a;", "halfScreenOnShowEventListenerAdapter", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$k;", "J", "ea", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$k;", "halfDialogHeightChangeListener", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$m;", "K", "ha", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$m;", "halfScreenDismissStartListenerAdapter", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "L", "ga", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "halfScreenDismissListenerAdapter", "Lgk1/b;", "contextProvider", "<init>", "(Lgk1/b;)V", "M", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentPanelPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ViewGroup commentContentView;

    /* renamed from: D, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean onShowCompletely;

    /* renamed from: F, reason: from kotlin metadata */
    private int commentPanelHeight;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private InterceptState interceptState;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfScreenFloatingControllerAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfScreenOnShowEventListenerAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfDialogHeightChangeListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfScreenDismissStartListenerAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfScreenDismissListenerAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout containerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedHalfScreenFloatingView halfScreenFloatingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View bottomInput;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean commentPanelDragging;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$n;", "", "onStartDrag", "onFinishDrag", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.n {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onFinishDrag() {
            GuildFeedGalleryCommentPanelPart.this.commentPanelDragging = false;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onStartDrag() {
            GuildFeedGalleryCommentPanelPart.this.commentPanelDragging = true;
        }
    }

    public GuildFeedGalleryCommentPanelPart(@Nullable gk1.b bVar) {
        super(bVar);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        this.interceptState = InterceptState.IDLE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", NodeProps.MAX_HEIGHT, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends com.tencent.mobileqq.widget.qus.e {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryCommentPanelPart f219576d;

                a(GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart) {
                    this.f219576d = guildFeedGalleryCommentPanelPart;
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public boolean canScrollDown(float x16, float y16) {
                    boolean aa5;
                    InterceptState interceptState;
                    InterceptState interceptState2;
                    aa5 = this.f219576d.aa();
                    interceptState = this.f219576d.interceptState;
                    if (interceptState == InterceptState.SCROLLED_UP && !aa5) {
                        this.f219576d.ua(InterceptState.INTERCEPTING);
                    }
                    interceptState2 = this.f219576d.interceptState;
                    if (interceptState2 == InterceptState.INTERCEPTING) {
                        return true;
                    }
                    return aa5;
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public boolean canScrollUp(float x16, float y16) {
                    boolean z16;
                    z16 = this.f219576d.onShowCompletely;
                    if (z16) {
                        Object broadcastGetMessage = this.f219576d.broadcastGetMessage("action_get_comment_load_info", null);
                        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.model.CommentLoadInfo");
                        if (((CommentLoadInfo) broadcastGetMessage).getListSize() != 0) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // com.tencent.mobileqq.widget.qus.d
                @Nullable
                /* renamed from: createContentView */
                public View getF57179d() {
                    ViewGroup viewGroup;
                    ViewGroup viewGroup2;
                    GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart = this.f219576d;
                    Object broadcastGetMessage = guildFeedGalleryCommentPanelPart.broadcastGetMessage("message_get_comment_content_view", null);
                    if (broadcastGetMessage instanceof ViewGroup) {
                        viewGroup = (ViewGroup) broadcastGetMessage;
                    } else {
                        viewGroup = null;
                    }
                    guildFeedGalleryCommentPanelPart.commentContentView = viewGroup;
                    viewGroup2 = this.f219576d.commentContentView;
                    if (viewGroup2 == null) {
                        return null;
                    }
                    this.f219576d.touchSlop = ViewConfiguration.get(viewGroup2.getContext()).getScaledTouchSlop();
                    return viewGroup2;
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public int maxHeight() {
                    int ca5;
                    ca5 = this.f219576d.ca();
                    return ca5;
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public int showMode() {
                    return 1;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedGalleryCommentPanelPart.this);
            }
        });
        this.halfScreenFloatingControllerAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2$a", "Lcom/tencent/mobileqq/widget/qus/a;", "", "onShowTotal", "onShowTotalStart", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends com.tencent.mobileqq.widget.qus.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryCommentPanelPart f219577d;

                a(GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart) {
                    this.f219577d = guildFeedGalleryCommentPanelPart;
                }

                @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
                public void onShowTotal() {
                    this.f219577d.onShowCompletely = true;
                    this.f219577d.enableSlide(true);
                    this.f219577d.broadcastMessage("message_comment_panel_open_finish_even", null);
                    this.f219577d.broadcastMessage("message_comment_panel_animation_ing", Boolean.FALSE);
                    QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "showCommentPanel onShowTotal");
                }

                @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
                public void onShowTotalStart() {
                    FrameLayout frameLayout;
                    wk1.i a16;
                    int oa5;
                    frameLayout = this.f219577d.containerView;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                    this.f219577d.broadcastMessage("message_comment_panel_start_open_even", null);
                    this.f219577d.broadcastMessage("message_comment_panel_animation_ing", Boolean.TRUE);
                    gk1.b contextProvide = this.f219577d.getContextProvide();
                    if (contextProvide != null && (a16 = contextProvide.a()) != null) {
                        oa5 = this.f219577d.oa();
                        a16.lh("message_comment_panel_start_open_even", Integer.valueOf(oa5));
                    }
                    this.f219577d.na();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedGalleryCommentPanelPart.this);
            }
        });
        this.halfScreenOnShowEventListenerAdapter = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new GuildFeedGalleryCommentPanelPart$halfDialogHeightChangeListener$2(this));
        this.halfDialogHeightChangeListener = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new GuildFeedGalleryCommentPanelPart$halfScreenDismissStartListenerAdapter$2(this));
        this.halfScreenDismissStartListenerAdapter = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new GuildFeedGalleryCommentPanelPart$halfScreenDismissListenerAdapter$2(this));
        this.halfScreenDismissListenerAdapter = lazy5;
    }

    private final void Y9() {
        gk1.b contextProvide = getContextProvide();
        boolean z16 = false;
        if (contextProvide != null && contextProvide.getBusinessType() == 17) {
            z16 = true;
        }
        if (z16) {
            FrameLayout frameLayout = this.containerView;
            Intrinsics.checkNotNull(frameLayout);
            ViewCompat.setOnApplyWindowInsetsListener(frameLayout, new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.l
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat Z9;
                    Z9 = GuildFeedGalleryCommentPanelPart.Z9(view, windowInsetsCompat);
                    return Z9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat Z9(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets, "insets.getInsets(WindowI\u2026at.Type.navigationBars())");
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "enableAdjustForNavigationInsets: " + insets.bottom + "px");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.bottom);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean aa() {
        Object broadcastGetMessage = broadcastGetMessage("message_get_comment_content_can_scroll_vertically", -1);
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) broadcastGetMessage).booleanValue();
    }

    private final int ba() {
        View view = this.bottomInput;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomInput");
            view = null;
        }
        if (view.getVisibility() != 0) {
            return 0;
        }
        View view3 = this.bottomInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomInput");
        } else {
            view2 = view3;
        }
        return view2.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ca() {
        int i3 = this.commentPanelHeight;
        if (i3 != 0) {
            return i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int screenHeight = DisplayUtil.getScreenHeight();
        if (!mk1.e.g()) {
            screenWidth = RangesKt___RangesKt.coerceAtMost(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
            screenHeight = RangesKt___RangesKt.coerceAtLeast(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int i16 = (int) (screenWidth * 0.5625f);
        int ba5 = (screenHeight - i16) - ba();
        if (ba5 < i16) {
            ba5 = (int) (cx.b(getContext()) * 0.7d);
        }
        this.commentPanelHeight = ba5;
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "[getCommentPanelHeight] panelHeight: " + ba5 + ", topSpaceHeight: " + i16 + ", screenHeight: " + DisplayUtil.getScreenHeight());
        return ba5;
    }

    private final HashMap<String, Object> da() {
        Object obj;
        int i3;
        wk1.i a16;
        HashMap<String, Object> d16 = mk1.e.d(z9());
        gk1.b contextProvide = getContextProvide();
        Integer num = null;
        if (contextProvide != null && (a16 = contextProvide.a()) != null) {
            obj = a16.I2("message_get_feed_position_event", null);
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "getDTParams position=" + i3);
        d16.put("sgrp_rank", Integer.valueOf(i3));
        return d16;
    }

    private final void dismissCommentPanel() {
        FeedHalfScreenFloatingView feedHalfScreenFloatingView = this.halfScreenFloatingView;
        if (feedHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            feedHalfScreenFloatingView = null;
        }
        feedHalfScreenFloatingView.t();
        ua(InterceptState.IDLE);
    }

    private final QUSBaseHalfScreenFloatingView.k ea() {
        return (QUSBaseHalfScreenFloatingView.k) this.halfDialogHeightChangeListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableSlide(boolean canSlide) {
        FeedHalfScreenFloatingView feedHalfScreenFloatingView = this.halfScreenFloatingView;
        if (feedHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            feedHalfScreenFloatingView = null;
        }
        feedHalfScreenFloatingView.setDraggable(canSlide);
        feedHalfScreenFloatingView.setCanSlide(canSlide);
    }

    private final QUSBaseHalfScreenFloatingView.l ga() {
        return (QUSBaseHalfScreenFloatingView.l) this.halfScreenDismissListenerAdapter.getValue();
    }

    private final QUSBaseHalfScreenFloatingView.m ha() {
        return (QUSBaseHalfScreenFloatingView.m) this.halfScreenDismissStartListenerAdapter.getValue();
    }

    private final GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2.a ia() {
        return (GuildFeedGalleryCommentPanelPart$halfScreenFloatingControllerAdapter$2.a) this.halfScreenFloatingControllerAdapter.getValue();
    }

    private final void initHalfScreenView() {
        Y9();
        FeedHalfScreenFloatingView feedHalfScreenFloatingView = this.halfScreenFloatingView;
        if (feedHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            feedHalfScreenFloatingView = null;
        }
        feedHalfScreenFloatingView.setHeadNeedDragIcon(true);
        feedHalfScreenFloatingView.v(false);
        feedHalfScreenFloatingView.r();
        feedHalfScreenFloatingView.i(new b());
        feedHalfScreenFloatingView.setQUSDragFloatController(ia());
        feedHalfScreenFloatingView.j(ja());
        feedHalfScreenFloatingView.setOnDismissListener(ga());
        feedHalfScreenFloatingView.setOnDismissStartListener(ha());
        feedHalfScreenFloatingView.l(ea());
        ta(feedHalfScreenFloatingView);
    }

    private final GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2.a ja() {
        return (GuildFeedGalleryCommentPanelPart$halfScreenOnShowEventListenerAdapter$2.a) this.halfScreenOnShowEventListenerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean la() {
        FrameLayout frameLayout = this.containerView;
        if (frameLayout != null) {
            Intrinsics.checkNotNull(frameLayout);
            if (frameLayout.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma() {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "onCommentPanelHide");
        sa();
        wa();
        ua(InterceptState.IDLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "onCommentPanelShown");
        pa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int oa() {
        return this.commentPanelHeight + ba();
    }

    private final void pa() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.containerView, "pg_sgrp_forum_comment_float");
        VideoReport.setPageParams(this.containerView, new PageParams(da()));
        VideoReport.ignorePageInOutEvent(this.containerView, true);
        VideoReport.reportPgIn(this.containerView);
        RFWIocAbilityProvider.g().getIoc(vl1.a.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.m
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                GuildFeedGalleryCommentPanelPart.qa(GuildFeedGalleryCommentPanelPart.this, (vl1.a) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(GuildFeedGalleryCommentPanelPart this$0, final vl1.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.setEventDynamicParams(this$0.containerView, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.n
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map ra5;
                ra5 = GuildFeedGalleryCommentPanelPart.ra(vl1.a.this, str);
                return ra5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map ra(vl1.a aVar, String str) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_forum_comment_region_imp_number", Integer.valueOf(aVar.z3())));
        return mapOf;
    }

    private final void sa() {
        VideoReport.setPageParams(this.containerView, new PageParams(da()));
        VideoReport.reportPgOut(this.containerView);
    }

    private final void ta(FeedHalfScreenFloatingView feedHalfScreenFloatingView) {
        gk1.b contextProvide = getContextProvide();
        boolean z16 = false;
        if (contextProvide != null && contextProvide.getBusinessType() == 21) {
            z16 = true;
        }
        if (!z16) {
            feedHalfScreenFloatingView.setBackgroundResource(R.color.bnp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(InterceptState interceptState) {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "interceptState change: " + this.interceptState + " -> " + interceptState);
        this.interceptState = interceptState;
    }

    private final void va(Object args) {
        if (!(args instanceof a.ShowCommentPanelArgs) || B9().getShowInputOnly()) {
            return;
        }
        FeedHalfScreenFloatingView feedHalfScreenFloatingView = this.halfScreenFloatingView;
        if (feedHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            feedHalfScreenFloatingView = null;
        }
        FrameLayout frameLayout = this.containerView;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        feedHalfScreenFloatingView.P(0);
        if (((a.ShowCommentPanelArgs) args).getLoadData()) {
            broadcastMessage("message_on_comment_panel_show_begin", args);
        }
    }

    private final void wa() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.k
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedGalleryCommentPanelPart.xa(GuildFeedGalleryCommentPanelPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(GuildFeedGalleryCommentPanelPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 2, "updateNavBarBg");
            QUIImmersiveHelper.s(this$0.getActivity(), false, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_get_comment_panel_show")) {
            return Boolean.valueOf(la());
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        a.CommentListOnScroll commentListOnScroll;
        if (action != null) {
            switch (action.hashCode()) {
                case -1197908258:
                    if (action.equals("message_on_scroll_idle")) {
                        InterceptState interceptState = this.interceptState;
                        if (interceptState == InterceptState.INTERCEPTING) {
                            ua(InterceptState.INTERCEPTED);
                            return;
                        } else {
                            if (interceptState == InterceptState.SCROLLED_UP && !aa()) {
                                ua(InterceptState.INTERCEPTED);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 417561184:
                    if (action.equals("message_on_comment_panel_show")) {
                        va(args);
                        return;
                    }
                    return;
                case 944419911:
                    if (action.equals("message_on_comment_panel_dismiss")) {
                        dismissCommentPanel();
                        return;
                    }
                    return;
                case 2136743461:
                    if (action.equals("message_on_comment_on_scroll")) {
                        if (args instanceof a.CommentListOnScroll) {
                            commentListOnScroll = (a.CommentListOnScroll) args;
                        } else {
                            commentListOnScroll = null;
                        }
                        if (commentListOnScroll != null && commentListOnScroll.getDy() >= this.touchSlop && this.interceptState == InterceptState.IDLE) {
                            ua(InterceptState.SCROLLED_UP);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (la()) {
            dismissCommentPanel();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.halfScreenFloatingView == null) {
            return;
        }
        this.commentPanelHeight = 0;
        dismissCommentPanel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.u28);
        this.containerView = frameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        View findViewById = rootView.findViewById(R.id.vha);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026comment_half_screen_view)");
        this.halfScreenFloatingView = (FeedHalfScreenFloatingView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.xoi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.input_bottom_root)");
        this.bottomInput = findViewById2;
        initHalfScreenView();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "onPartDestroy");
        super.onPartDestroy(activity);
        if (la()) {
            ma();
        }
    }
}
