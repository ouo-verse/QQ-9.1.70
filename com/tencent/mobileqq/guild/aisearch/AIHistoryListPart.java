package com.tencent.mobileqq.guild.aisearch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.AIHistoryListPart;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistoryGroupItem;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistorySessionItem;
import com.tencent.mobileqq.guild.aisearch.history.h;
import com.tencent.mobileqq.guild.aisearch.history.itemholder.AIChatHistorySessionHolder;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputCloseEvent;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.HistoryCheckData;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.drawerlayout.SafeDrawerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.widget.scroll.OverScrollDecorator;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef1.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te1.a;

@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0017\u0018\u0000 W2\u00020\u0001:\u0004XYZ$B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\bU\u0010VJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001e\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0013R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010%R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010L\u001a\u0004\bR\u0010S\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart;", "Lcom/tencent/mobileqq/guild/aisearch/x;", "Lcom/tencent/mobileqq/guild/aisearch/history/f;", "sessionItem", "", "T9", "", "width", "ta", "Lcom/tencent/mobileqq/guild/widget/drawerlayout/SafeDrawerLayout;", "drawer", "ca", "buttonType", "sa", "", "", "", "W9", "ra", "", "canSelected", "ba", "qa", "com/tencent/mobileqq/guild/aisearch/AIHistoryListPart$f", "aa", "()Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$f;", "closeDrawer", "Y9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "args", "getMessage", "oa", "S9", "d", "Landroid/view/View;", "Luy1/j;", "e", "Luy1/j;", "stickyDecoration", "f", "Lcom/tencent/mobileqq/guild/widget/drawerlayout/SafeDrawerLayout;", "guildAiSearchDrawer", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "aiHistoryListView", "i", "historyDrawerContent", "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$b;", "buttonManageUi", "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$a;", "bottomActionBarUi", "D", "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$f;", "historyListNotify", "Lcom/tencent/mobileqq/guild/aisearch/history/c;", "E", "Lcom/tencent/mobileqq/guild/aisearch/history/c;", "aiHistoryAdapter", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/e;", "listLayoutManager", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "G", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "loadMoreAdapter", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "H", "Lkotlin/Lazy;", "V9", "()Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "aiChatListViewModel", "Lcom/tencent/mobileqq/guild/aisearch/w;", "I", "X9", "()Lcom/tencent/mobileqq/guild/aisearch/w;", "historyViewModel", "<init>", "(Landroid/view/View;)V", "J", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIHistoryListPart extends x {
    private static final int K = com.tencent.biz.qui.quicommon.e.c(84.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a bottomActionBarUi;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final f historyListNotify;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.aisearch.history.c aiHistoryAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.widget.audiofaceview.e listLayoutManager;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.content.base.f loadMoreAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiChatListViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy historyViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private uy1.j stickyDecoration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SafeDrawerLayout guildAiSearchDrawer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView aiHistoryListView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View historyDrawerContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b buttonManageUi;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020\f\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0017\u0010&\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$a;", "", "", "newManageMode", "", "j", "Landroid/view/View$OnClickListener;", "listener", "g", "Lcom/tencent/mobileqq/guild/aisearch/models/g;", "checkData", "i", "Landroid/view/View;", "a", "Landroid/view/View;", "getBottomActionBar", "()Landroid/view/View;", "bottomActionBar", "b", "f", "selectAllButton", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "c", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getSelectAllCheckBox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "selectAllCheckBox", "d", "deleteButton", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "deleteImageView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getDeleteTextView", "()Landroid/widget/TextView;", "deleteTextView", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getOnSelectAllListener", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", tl.h.F, "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "onSelectAllListener", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View bottomActionBar;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View selectAllButton;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QUICheckBox selectAllCheckBox;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View deleteButton;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView deleteImageView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView deleteTextView;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private CompoundButton.OnCheckedChangeListener onSelectAllListener;

        public a(@NotNull View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            View findViewById = rootView.findViewById(R.id.t9z);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bottom_action_bar)");
            this.bottomActionBar = findViewById;
            View findViewById2 = findViewById.findViewById(R.id.f82004fp);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "bottomActionBar.findView\u2026d(R.id.select_all_layout)");
            this.selectAllButton = findViewById2;
            View findViewById3 = findViewById.findViewById(R.id.f164792ax1);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "bottomActionBar.findViewById(R.id.check_button)");
            this.selectAllCheckBox = (QUICheckBox) findViewById3;
            View findViewById4 = findViewById.findViewById(R.id.bfq);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "bottomActionBar.findViewById(R.id.delete_btn)");
            this.deleteButton = findViewById4;
            View findViewById5 = findViewById.findViewById(R.id.wk9);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "bottomActionBar.findViewById(R.id.guild_iv_delete)");
            ImageView imageView = (ImageView) findViewById5;
            this.deleteImageView = imageView;
            View findViewById6 = findViewById.findViewById(R.id.x26);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "bottomActionBar.findView\u2026d(R.id.guild_text_delete)");
            this.deleteTextView = (TextView) findViewById6;
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIHistoryListPart.a.c(AIHistoryListPart.a.this, view);
                }
            });
            GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(imageView.getResources(), R.drawable.guild_vector_icon_delete, null);
            if (create != null) {
                create.setTintList(ContextCompat.getColorStateList(imageView.getContext(), R.color.qui_common_feedback_error));
            }
            if (create != null) {
                create.setOverrideStrokeWidth(1.37f);
            }
            imageView.setImageDrawable(create);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.selectAllCheckBox.setChecked(!r0.isChecked());
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this$0.onSelectAllListener;
            if (onCheckedChangeListener != null) {
                QUICheckBox qUICheckBox = this$0.selectAllCheckBox;
                onCheckedChangeListener.onCheckedChanged(qUICheckBox, qUICheckBox.isChecked());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.bottomActionBar.setVisibility(8);
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final View getDeleteButton() {
            return this.deleteButton;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final ImageView getDeleteImageView() {
            return this.deleteImageView;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final View getSelectAllButton() {
            return this.selectAllButton;
        }

        public final void g(@NotNull View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.deleteButton.setOnClickListener(listener);
        }

        public final void h(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.onSelectAllListener = onCheckedChangeListener;
        }

        public final void i(@NotNull HistoryCheckData checkData) {
            boolean z16;
            Intrinsics.checkNotNullParameter(checkData, "checkData");
            String string = this.deleteTextView.getContext().getString(R.string.f143030kz);
            Intrinsics.checkNotNullExpressionValue(string, "deleteTextView.context.g\u2026ng(R.string.guild_delete)");
            if (checkData.getTotalCount() > 0) {
                QUICheckBox qUICheckBox = this.selectAllCheckBox;
                if (checkData.getCheckCount() >= checkData.getTotalCount()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qUICheckBox.setChecked(z16);
            }
            if (checkData.getCheckCount() > 0) {
                this.deleteButton.setEnabled(true);
                this.deleteButton.setAlpha(1.0f);
                this.deleteTextView.setText(string + "(" + checkData.getCheckCount() + ")");
                return;
            }
            this.deleteButton.setEnabled(false);
            this.deleteButton.setAlpha(0.3f);
            this.deleteTextView.setText(string);
        }

        public final void j(boolean newManageMode) {
            boolean z16;
            if (this.bottomActionBar.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 == newManageMode) {
                return;
            }
            this.bottomActionBar.setVisibility(0);
            if (newManageMode) {
                this.bottomActionBar.setTranslationY(AIHistoryListPart.K);
                this.bottomActionBar.animate().translationY(0.0f).setDuration(150L).setInterpolator(new DecelerateInterpolator()).start();
            } else {
                this.bottomActionBar.setTranslationY(0.0f);
                this.bottomActionBar.animate().translationY(AIHistoryListPart.K).setDuration(150L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIHistoryListPart.a.k(AIHistoryListPart.a.this);
                    }
                }).start();
            }
            if (newManageMode) {
                VideoReport.reportEvent("dt_imp", this.selectAllButton, null);
                VideoReport.reportEvent("dt_imp", this.deleteButton, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$b;", "", "", "newManageMode", "", tl.h.F, "Landroid/view/View$OnClickListener;", "listener", "e", "", "statusBarHeight", "g", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "c", "()Landroid/widget/LinearLayout;", TtmlNode.TAG_LAYOUT, "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "text", "<set-?>", "d", "Z", "()Z", "isManageMode", "Ljava/lang/Boolean;", "lastManageNode", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LinearLayout layout;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView icon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isManageMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean lastManageNode;

        public b(@NotNull View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            View findViewById = rootView.findViewById(R.id.tfe);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_manage)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            this.layout = linearLayout;
            View childAt = linearLayout.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            this.icon = (ImageView) childAt;
            View childAt2 = linearLayout.getChildAt(1);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            this.text = (TextView) childAt2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(View.OnClickListener listener, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(listener, "$listener");
            VideoReport.reportEvent("dt_clck", view, null);
            listener.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ImageView getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final LinearLayout getLayout() {
            return this.layout;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsManageMode() {
            return this.isManageMode;
        }

        public final void e(@NotNull final View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.layout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIHistoryListPart.b.f(listener, view);
                }
            });
        }

        public final void g(int statusBarHeight) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            int i3;
            LinearLayout linearLayout = this.layout;
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
                int i16 = -2;
                if (layoutParams2 != null) {
                    i3 = layoutParams2.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
                if (layoutParams3 != null) {
                    i16 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
            }
            marginLayoutParams.topMargin = statusBarHeight;
            linearLayout.setLayoutParams(marginLayoutParams);
        }

        public final void h(boolean newManageMode) {
            String str;
            int i3;
            if (Intrinsics.areEqual(this.lastManageNode, Boolean.valueOf(newManageMode)) && this.isManageMode == newManageMode) {
                return;
            }
            this.isManageMode = newManageMode;
            this.lastManageNode = Boolean.valueOf(newManageMode);
            TextView textView = this.text;
            if (this.isManageMode) {
                str = "\u53d6\u6d88\u7ba1\u7406";
            } else {
                str = "\u7ba1\u7406";
            }
            textView.setText(str);
            ImageView imageView = this.icon;
            if (!this.isManageMode) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            if (newManageMode) {
                if1.a.b(this.layout, "em_sgrp_history_cancel_manage", null, null, null, ClickPolicy.REPORT_NONE, null, null, null, 238, null);
                VideoReport.reportEvent("dt_imp", this.layout, null);
            } else {
                if1.a.b(this.layout, "em_sgrp_history_manage", null, null, null, ClickPolicy.REPORT_NONE, null, null, null, 238, null);
                VideoReport.reportEvent("dt_imp", this.layout, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0019\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$d;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View$OnTouchListener;", "e", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "onTouchListener", "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$d$b;", "f", "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$d$b;", "getOnItemTouchListener", "()Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$d$b;", "onItemTouchListener", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View$OnTouchListener;)V", tl.h.F, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements View.OnAttachStateChangeListener {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView recyclerView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View.OnTouchListener onTouchListener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b onItemTouchListener;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$d$a;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View$OnTouchListener;", "onTouchListener", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$d$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void a(@NotNull RecyclerView recyclerView, @NotNull View.OnTouchListener onTouchListener) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
                new d(recyclerView, onTouchListener, null);
            }

            Companion() {
            }
        }

        public /* synthetic */ d(RecyclerView recyclerView, View.OnTouchListener onTouchListener, DefaultConstructorMarker defaultConstructorMarker) {
            this(recyclerView, onTouchListener);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            this.recyclerView.addOnItemTouchListener(this.onItemTouchListener);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            this.recyclerView.removeOnItemTouchListener(this.onItemTouchListener);
        }

        d(RecyclerView recyclerView, View.OnTouchListener onTouchListener) {
            this.recyclerView = recyclerView;
            this.onTouchListener = onTouchListener;
            b bVar = new b(onTouchListener);
            this.onItemTouchListener = bVar;
            recyclerView.addOnAttachStateChangeListener(this);
            if (recyclerView.isAttachedToWindow()) {
                recyclerView.addOnItemTouchListener(bVar);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart$d$b;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "p0", "Landroid/view/MotionEvent;", "p1", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "Landroid/view/View$OnTouchListener;", "d", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "onTouchListener", "<init>", "(Landroid/view/View$OnTouchListener;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class b implements RecyclerView.OnItemTouchListener {

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final View.OnTouchListener onTouchListener;

            public b(@NotNull View.OnTouchListener onTouchListener) {
                Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
                this.onTouchListener = onTouchListener;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NotNull RecyclerView p06, @NotNull MotionEvent p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                if (p16.getAction() == 0) {
                    this.onTouchListener.onTouch(p06, p16);
                    return false;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(@NotNull RecyclerView p06, @NotNull MotionEvent p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean p06) {
            }
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/aisearch/AIHistoryListPart$f", "Lcom/tencent/mobileqq/guild/aisearch/history/h;", "Lcom/tencent/mobileqq/guild/aisearch/history/itemholder/AIChatHistorySessionHolder;", "holder", "", "e", "Lcom/tencent/mobileqq/guild/aisearch/history/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "", "d", "isChecked", "c", "b", "a", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "currentSessionHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f implements com.tencent.mobileqq.guild.aisearch.history.h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.avatar.meta.refresh.c<AIChatHistorySessionHolder> currentSessionHolder;

        f() {
        }

        @Override // com.tencent.mobileqq.guild.aisearch.history.h
        public boolean a() {
            b bVar = AIHistoryListPart.this.buttonManageUi;
            if (bVar == null || !bVar.getIsManageMode()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.aisearch.history.h
        public boolean b(@NotNull AIChatHistorySessionHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            boolean g26 = AIHistoryListPart.this.X9().g2(holder.getCurrentItem());
            Logger.f235387a.d().d("AIHistoryListPart", 1, "[isItemSelected] " + holder + " selected " + g26);
            return g26;
        }

        @Override // com.tencent.mobileqq.guild.aisearch.history.h
        public void c(@NotNull AIChatHistorySessionHolder holder, boolean isChecked) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Logger.f235387a.d().d("AIHistoryListPart", 1, "[onItemSelected] " + holder + " selected " + isChecked);
            AIHistoryListPart.this.X9().l2(holder.getCurrentItem(), isChecked);
        }

        @Override // com.tencent.mobileqq.guild.aisearch.history.h
        public boolean d(@NotNull AIChatHistorySessionHolder holder) {
            String str;
            Intrinsics.checkNotNullParameter(holder, "holder");
            AiChatSession value = AIHistoryListPart.this.V9().Q1().getValue();
            String str2 = null;
            if (value != null) {
                str = value.getSessionId();
            } else {
                str = null;
            }
            AIChatHistorySessionItem currentItem = holder.getCurrentItem();
            if (currentItem != null) {
                str2 = currentItem.getSessionId();
            }
            boolean areEqual = Intrinsics.areEqual(str, str2);
            if (areEqual) {
                this.currentSessionHolder = new com.tencent.qqnt.avatar.meta.refresh.c<>(holder);
            }
            return areEqual;
        }

        @Override // com.tencent.mobileqq.guild.aisearch.history.h
        public void e(@NotNull AIChatHistorySessionHolder holder) {
            String str;
            String str2;
            AIChatHistorySessionHolder aIChatHistorySessionHolder;
            Intrinsics.checkNotNullParameter(holder, "holder");
            AiChatSession value = AIHistoryListPart.this.V9().Q1().getValue();
            if (value != null) {
                str = value.getSessionId();
            } else {
                str = null;
            }
            AIChatHistorySessionItem currentItem = holder.getCurrentItem();
            if (currentItem != null) {
                str2 = currentItem.getSessionId();
            } else {
                str2 = null;
            }
            boolean z16 = !Intrinsics.areEqual(str, str2);
            com.tencent.qqnt.avatar.meta.refresh.c<AIChatHistorySessionHolder> cVar = this.currentSessionHolder;
            if (cVar != null && (aIChatHistorySessionHolder = cVar.get()) != null) {
                AIChatHistorySessionHolder.L(aIChatHistorySessionHolder, false, z16, 1, null);
            }
            AIHistoryListPart.Z9(AIHistoryListPart.this, holder.getCurrentItem(), false, 2, null);
        }

        @Override // com.tencent.mobileqq.guild.aisearch.history.h
        public void f(@NotNull AIChatHistorySessionItem item) {
            String str;
            Object firstOrNull;
            AIChatHistorySessionItem aIChatHistorySessionItem;
            ArrayList<AIChatHistorySessionItem> b16;
            Object firstOrNull2;
            Intrinsics.checkNotNullParameter(item, "item");
            Logger.f235387a.d().d("AIHistoryListPart", 1, "[onDeleted] item " + item);
            AIHistoryListPart.this.X9().Z1(item);
            AiChatSession value = AIHistoryListPart.this.V9().Q1().getValue();
            if (value != null) {
                str = value.getSessionId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, item.getSessionId())) {
                ArrayList<AIChatHistoryGroupItem> value2 = AIHistoryListPart.this.X9().d2().getValue();
                if (value2 == null) {
                    value2 = new ArrayList<>();
                }
                AIHistoryListPart aIHistoryListPart = AIHistoryListPart.this;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value2);
                AIChatHistoryGroupItem aIChatHistoryGroupItem = (AIChatHistoryGroupItem) firstOrNull;
                if (aIChatHistoryGroupItem != null && (b16 = aIChatHistoryGroupItem.b()) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) b16);
                    aIChatHistorySessionItem = (AIChatHistorySessionItem) firstOrNull2;
                } else {
                    aIChatHistorySessionItem = null;
                }
                AIHistoryListPart.Z9(aIHistoryListPart, aIChatHistorySessionItem, false, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/aisearch/AIHistoryListPart$g", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class g extends RecyclerView.ItemDecoration {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int c16;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null) {
                return;
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int num_backgournd_icon = adapter.getNUM_BACKGOURND_ICON();
            boolean z16 = true;
            if (childAdapterPosition == num_backgournd_icon - 1) {
                b bVar = AIHistoryListPart.this.buttonManageUi;
                if (bVar == null || !bVar.getIsManageMode()) {
                    z16 = false;
                }
                if (z16) {
                    c16 = AIHistoryListPart.K + com.tencent.biz.qui.quicommon.e.c(6.0f);
                } else {
                    c16 = com.tencent.biz.qui.quicommon.e.c(46.0f);
                }
                outRect.bottom = c16;
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/aisearch/AIHistoryListPart$h", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "Landroid/view/View;", "drawerView", "", "slideOffset", "", "onDrawerSlide", "onDrawerOpened", "onDrawerClosed", "", "newState", "onDrawerStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class h implements DrawerLayout.DrawerListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f213967a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f213968b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<SafeDrawerLayout> f213969c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIHistoryListPart f213970d;

        h(View view, float f16, Ref.ObjectRef<SafeDrawerLayout> objectRef, AIHistoryListPart aIHistoryListPart) {
            this.f213967a = view;
            this.f213968b = f16;
            this.f213969c = objectRef;
            this.f213970d = aIHistoryListPart;
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(@NotNull View drawerView) {
            Intrinsics.checkNotNullParameter(drawerView, "drawerView");
            this.f213969c.element.setVisibility(8);
            this.f213967a.setAlpha(0.0f);
            w.T1(this.f213970d.X9(), false, 1, null);
            b bVar = this.f213970d.buttonManageUi;
            if (bVar != null) {
                bVar.h(false);
            }
            a aVar = this.f213970d.bottomActionBarUi;
            if (aVar != null) {
                aVar.j(false);
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(@NotNull View drawerView) {
            Intrinsics.checkNotNullParameter(drawerView, "drawerView");
            this.f213967a.setAlpha(this.f213968b);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(drawerView, "em_sgrp_history_drawer", "", "imp", new HashMap());
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(@NotNull View drawerView, float slideOffset) {
            Intrinsics.checkNotNullParameter(drawerView, "drawerView");
            this.f213967a.setAlpha(this.f213968b * slideOffset);
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int newState) {
            if (newState == 0 && !this.f213969c.element.isDrawerVisible(8388611)) {
                this.f213969c.element.setVisibility(8);
                this.f213967a.setAlpha(0.0f);
            }
        }
    }

    public AIHistoryListPart(@NotNull View rootView) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        f aa5 = aa();
        this.historyListNotify = aa5;
        this.aiHistoryAdapter = new com.tencent.mobileqq.guild.aisearch.history.c(aa5);
        this.listLayoutManager = new com.tencent.mobileqq.guild.media.widget.audiofaceview.e(getContext());
        com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar = new com.tencent.mobileqq.guild.discoveryv2.content.base.f();
        fVar.setHasStableIds(true);
        fVar.registerLoadMoreListener(new e(fVar, this));
        this.loadMoreAdapter = fVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIChatListViewModel>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$aiChatListViewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f213951a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f213951a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new AIChatListViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIChatListViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                Fragment hostFragment = AIHistoryListPart.this.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                ViewModel viewModel = new ViewModelProvider(hostFragment, new a(hostFragment)).get(AIChatListViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (AIChatListViewModel) viewModel;
            }
        });
        this.aiChatListViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<w>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$historyViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                return (w) AIHistoryListPart.this.getViewModel(w.class);
            }
        });
        this.historyViewModel = lazy2;
    }

    private final void T9(AIChatHistorySessionItem sessionItem) {
        String str;
        String summary;
        VideoReport.reportPgOut(this.rootView.getParent());
        final HashMap hashMap = new HashMap();
        String str2 = "";
        if (sessionItem == null || (str = sessionItem.getSessionId()) == null) {
            str = "";
        }
        hashMap.put("sgrp_ai_session_id", str);
        if (sessionItem != null && (summary = sessionItem.getSummary()) != null) {
            str2 = summary;
        }
        hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, str2);
        VideoReport.setPageParams(this.rootView.getParent(), PageParams.builder().setBasicParams(hashMap).build());
        VideoReport.reportPgIn(this.rootView.getParent());
        RFWIocAbilityProvider.g().getIoc(z.class).originView(this.rootView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.aisearch.h
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                AIHistoryListPart.U9(hashMap, (z) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(HashMap map, z zVar) {
        Intrinsics.checkNotNullParameter(map, "$map");
        zVar.Eb(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIChatListViewModel V9() {
        return (AIChatListViewModel) this.aiChatListViewModel.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, Object> W9() {
        String joinToString$default;
        int i3;
        HistoryCheckData value;
        int i16;
        Map<String, Object> mapOf;
        Pair<Boolean, List<String>> a26 = X9().a2();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(a26.getSecond(), ",", null, null, 0, null, null, 62, null);
        if (!a26.getFirst().booleanValue()) {
            HistoryCheckData value2 = X9().c2().getValue();
            if (value2 != null && value2.getTotalCount() == value2.getCheckCount()) {
                joinToString$default = "";
            } else {
                i3 = 2;
                Pair[] pairArr = new Pair[3];
                value = X9().c2().getValue();
                if (value == null) {
                    i16 = value.getCheckCount();
                } else {
                    i16 = 0;
                }
                pairArr[0] = TuplesKt.to("sgrp_num", Integer.valueOf(i16));
                pairArr[1] = TuplesKt.to("sgrp_option_type", Integer.valueOf(i3));
                pairArr[2] = TuplesKt.to("sgrp_ai_session_id", joinToString$default);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                return mapOf;
            }
        }
        i3 = 1;
        Pair[] pairArr2 = new Pair[3];
        value = X9().c2().getValue();
        if (value == null) {
        }
        pairArr2[0] = TuplesKt.to("sgrp_num", Integer.valueOf(i16));
        pairArr2[1] = TuplesKt.to("sgrp_option_type", Integer.valueOf(i3));
        pairArr2[2] = TuplesKt.to("sgrp_ai_session_id", joinToString$default);
        mapOf = MapsKt__MapsKt.mapOf(pairArr2);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final w X9() {
        Object value = this.historyViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-historyViewModel>(...)");
        return (w) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(AIChatHistorySessionItem sessionItem, boolean closeDrawer) {
        String str;
        String str2;
        if (sessionItem == null || (str = sessionItem.getSessionId()) == null) {
            str = "";
        }
        AiChatSession value = V9().Q1().getValue();
        if (value != null) {
            str2 = value.getSessionId();
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str2, str)) {
            V9().S1(str);
            ra();
            T9(sessionItem);
        }
        if (closeDrawer) {
            S9();
        }
    }

    static /* synthetic */ void Z9(AIHistoryListPart aIHistoryListPart, AIChatHistorySessionItem aIChatHistorySessionItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        aIHistoryListPart.Y9(aIChatHistorySessionItem, z16);
    }

    private final f aa() {
        return new f();
    }

    private final void ba(boolean canSelected) {
        int findFirstVisibleItemPosition = this.listLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.listLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
            com.tencent.mobileqq.guild.aisearch.history.c cVar = this.aiHistoryAdapter;
            cVar.notifyItemRangeChanged(0, cVar.getNUM_BACKGOURND_ICON(), new h.a.UpdateSelectMode(canSelected));
        }
    }

    private final void ca(SafeDrawerLayout drawer) {
        LinearLayout layout;
        final b bVar = new b(this.rootView);
        bVar.e(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIHistoryListPart.la(AIHistoryListPart.this, bVar, view);
            }
        });
        bVar.g(ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ));
        GuildUIUtils.c(bVar.getIcon(), R.drawable.guild_vector_icon_nav_setting, 1.37f, Integer.valueOf(R.color.qui_common_text_primary));
        bVar.h(false);
        this.buttonManageUi = bVar;
        ko4.a<ArrayList<AIChatHistoryGroupItem>> d26 = X9().d2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<ArrayList<AIChatHistoryGroupItem>, Unit> function1 = new Function1<ArrayList<AIChatHistoryGroupItem>, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitDrawer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<AIChatHistoryGroupItem> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<AIChatHistoryGroupItem> historyList) {
                SafeDrawerLayout safeDrawerLayout;
                com.tencent.mobileqq.guild.aisearch.history.c cVar;
                LinearLayout layout2;
                safeDrawerLayout = AIHistoryListPart.this.guildAiSearchDrawer;
                if (safeDrawerLayout != null) {
                    Intrinsics.checkNotNullExpressionValue(historyList, "historyList");
                    safeDrawerLayout.d(!historyList.isEmpty());
                }
                cVar = AIHistoryListPart.this.aiHistoryAdapter;
                Intrinsics.checkNotNullExpressionValue(historyList, "historyList");
                cVar.setDataList(historyList);
                if (historyList.isEmpty()) {
                    AIHistoryListPart.b bVar2 = AIHistoryListPart.this.buttonManageUi;
                    if (bVar2 != null) {
                        bVar2.h(false);
                    }
                    AIHistoryListPart.a aVar = AIHistoryListPart.this.bottomActionBarUi;
                    if (aVar != null) {
                        aVar.j(false);
                    }
                    AIHistoryListPart.b bVar3 = AIHistoryListPart.this.buttonManageUi;
                    layout2 = bVar3 != null ? bVar3.getLayout() : null;
                    if (layout2 == null) {
                        return;
                    }
                    layout2.setVisibility(8);
                    return;
                }
                AIHistoryListPart.b bVar4 = AIHistoryListPart.this.buttonManageUi;
                layout2 = bVar4 != null ? bVar4.getLayout() : null;
                if (layout2 == null) {
                    return;
                }
                layout2.setVisibility(0);
            }
        };
        d26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.aisearch.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIHistoryListPart.ma(Function1.this, obj);
            }
        });
        ko4.a<Boolean> b26 = X9().b2();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitDrawer$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean hasMore) {
                com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar;
                com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar2;
                Intrinsics.checkNotNullExpressionValue(hasMore, "hasMore");
                if (hasMore.booleanValue()) {
                    fVar2 = AIHistoryListPart.this.loadMoreAdapter;
                    fVar2.j0(false, false, "");
                } else {
                    fVar = AIHistoryListPart.this.loadMoreAdapter;
                    fVar.j0(false, true, "");
                }
            }
        };
        b26.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.aisearch.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIHistoryListPart.na(Function1.this, obj);
            }
        });
        RecyclerView recyclerView = (RecyclerView) drawer.findViewById(R.id.sft);
        recyclerView.addItemDecoration(new g());
        View findViewById = this.rootView.findViewById(R.id.rlCommenTitle);
        if (findViewById != null) {
            int bottom = ((findViewById.getBottom() + findViewById.getTop()) / 2) - ((recyclerView.getResources().getDimensionPixelSize(R.dimen.cby) + recyclerView.getResources().getDimensionPixelSize(R.dimen.cbx)) / 2);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "onInitDrawer$lambda$10");
            ViewExtKt.f(recyclerView, bottom);
        }
        recyclerView.setLayoutManager(this.listLayoutManager);
        uy1.j jVar = new uy1.j(this.aiHistoryAdapter);
        this.stickyDecoration = jVar;
        recyclerView.addItemDecoration(jVar);
        recyclerView.setAdapter(new RFWConcatAdapter(this.aiHistoryAdapter, this.loadMoreAdapter));
        OverScrollDecorator overScrollDecorator = new OverScrollDecorator(recyclerView);
        overScrollDecorator.setVerticalOverScrollEnable(true, false);
        d.Companion companion = d.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        companion.a(recyclerView, overScrollDecorator);
        b bVar2 = this.buttonManageUi;
        if (bVar2 != null && (layout = bVar2.getLayout()) != null) {
            jf1.c.INSTANCE.a(recyclerView, layout);
        }
        this.aiHistoryListView = recyclerView;
        final a aVar = new a(this.rootView);
        aVar.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.aisearch.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                AIHistoryListPart.da(AIHistoryListPart.this, compoundButton, z16);
            }
        });
        aVar.g(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIHistoryListPart.ea(AIHistoryListPart.this, view);
            }
        });
        ko4.a<HistoryCheckData> c26 = X9().c2();
        LifecycleOwner a18 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<HistoryCheckData, Unit> function13 = new Function1<HistoryCheckData, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitDrawer$6$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HistoryCheckData historyCheckData) {
                invoke2(historyCheckData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HistoryCheckData checkData) {
                AIHistoryListPart.a aVar2 = AIHistoryListPart.a.this;
                Intrinsics.checkNotNullExpressionValue(checkData, "checkData");
                aVar2.i(checkData);
            }
        };
        c26.observe(a18, new Observer() { // from class: com.tencent.mobileqq.guild.aisearch.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIHistoryListPart.ia(Function1.this, obj);
            }
        });
        View selectAllButton = aVar.getSelectAllButton();
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        if1.a.b(selectAllButton, "em_sgrp_history_select_all", null, null, exposurePolicy, null, null, null, null, 246, null);
        if1.a.b(aVar.getDeleteButton(), "em_sgrp_batch_delete_history", null, null, exposurePolicy, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.aisearch.o
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map ja5;
                ja5 = AIHistoryListPart.ja(AIHistoryListPart.this, str);
                return ja5;
            }
        }, 118, null);
        this.bottomActionBarUi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(AIHistoryListPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9().R1(z16);
        this$0.aiHistoryAdapter.notifyDataSetChanged();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(final AIHistoryListPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        te1.d dVar = te1.d.f435883a;
        Context context = this$0.rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        String string = this$0.getContext().getString(R.string.f138940_x);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_ai_history_delete_title)");
        String string2 = this$0.getContext().getString(R.string.f138910_u);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026d_ai_history_delete_desc)");
        String string3 = this$0.getContext().getString(R.string.f138890_s);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026istory_delete_btn_cancel)");
        String string4 = this$0.getContext().getString(R.string.f138900_t);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026story_delete_btn_confirm)");
        dVar.a(context, 230, string, string2, string3, string4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AIHistoryListPart.ga(AIHistoryListPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AIHistoryListPart.ha(AIHistoryListPart.this, dialogInterface, i3);
            }
        }).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(final AIHistoryListPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa(1);
        this$0.X9().W1(new Function3<Integer, String, List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitDrawer$6$2$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, List<? extends String> list) {
                invoke(num.intValue(), str, (List<String>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(int i16, @NotNull String errMsg, @NotNull List<String> deleteList) {
                boolean contains;
                Object firstOrNull;
                ArrayList<AIChatHistorySessionItem> b16;
                Object firstOrNull2;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(deleteList, "deleteList");
                if (i16 == 0) {
                    a.Companion companion = te1.a.INSTANCE;
                    Context context = AIHistoryListPart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    String string = AIHistoryListPart.this.getContext().getString(R.string.f138930_w);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026i_history_delete_success)");
                    companion.b(context, string);
                    List<String> list = deleteList;
                    AiChatSession value = AIHistoryListPart.this.V9().Q1().getValue();
                    AIChatHistorySessionItem aIChatHistorySessionItem = null;
                    contains = CollectionsKt___CollectionsKt.contains(list, value != null ? value.getSessionId() : null);
                    if (contains) {
                        ArrayList<AIChatHistoryGroupItem> value2 = AIHistoryListPart.this.X9().d2().getValue();
                        if (value2 == null) {
                            value2 = new ArrayList<>();
                        }
                        AIHistoryListPart aIHistoryListPart = AIHistoryListPart.this;
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value2);
                        AIChatHistoryGroupItem aIChatHistoryGroupItem = (AIChatHistoryGroupItem) firstOrNull;
                        if (aIChatHistoryGroupItem != null && (b16 = aIChatHistoryGroupItem.b()) != null) {
                            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) b16);
                            aIChatHistorySessionItem = (AIChatHistorySessionItem) firstOrNull2;
                        }
                        aIHistoryListPart.Y9(aIChatHistorySessionItem, false);
                        return;
                    }
                    return;
                }
                a.Companion companion2 = te1.a.INSTANCE;
                Context context2 = AIHistoryListPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                AIHistoryListPart aIHistoryListPart2 = AIHistoryListPart.this;
                if (errMsg.length() == 0) {
                    errMsg = aIHistoryListPart2.getContext().getString(R.string.f138920_v);
                    Intrinsics.checkNotNullExpressionValue(errMsg, "context.getString(R.stri\u2026d_ai_history_delete_fail)");
                }
                companion2.b(context2, errMsg);
            }
        });
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(AIHistoryListPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa(2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map ja(AIHistoryListPart this$0, String str) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "dt_imp")) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return this$0.W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(AIHistoryListPart this$0, b ui5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ui5, "$ui");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            RecyclerView recyclerView = this$0.aiHistoryListView;
            if (recyclerView != null) {
                recyclerView.stopScroll();
            }
            ui5.h(!ui5.getIsManageMode());
            a aVar = this$0.bottomActionBarUi;
            if (aVar != null) {
                aVar.j(ui5.getIsManageMode());
            }
            if (ui5.getIsManageMode()) {
                this$0.qa();
            } else {
                this$0.X9().S1(false);
            }
            this$0.ba(ui5.getIsManageMode());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(AIHistoryListPart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i17 - i3;
        if (i29 != i27 - i19) {
            this$0.ta(i29);
            uy1.j jVar = this$0.stickyDecoration;
            if (jVar != null) {
                jVar.b();
            }
            RecyclerView recyclerView = this$0.aiHistoryListView;
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }
    }

    private final void qa() {
        RecyclerView recyclerView;
        if (this.listLayoutManager.findLastVisibleItemPosition() == this.listLayoutManager.getItemCount() - 1 && (recyclerView = this.aiHistoryListView) != null) {
            recyclerView.invalidateItemDecorations();
        }
    }

    private final void ra() {
        int findFirstVisibleItemPosition = this.listLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.listLayoutManager.findLastVisibleItemPosition();
        boolean z16 = false;
        if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            z16 = true;
        }
        if (z16) {
            this.aiHistoryAdapter.notifyItemRangeChanged(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        }
    }

    private final void sa(int buttonType) {
        ImageView imageView;
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        a aVar = this.bottomActionBarUi;
        if (aVar != null) {
            imageView = aVar.getDeleteImageView();
        } else {
            imageView = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(W9());
        hashMap.put("sgrp_btn_type", Integer.valueOf(buttonType));
        Unit unit = Unit.INSTANCE;
        iGuildDTReportApi.reportDtEventManual(imageView, "em_sgrp_batch_delete_history_pop", "", "clck", hashMap);
    }

    private final void ta(int width) {
        int roundToInt;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        boolean z16 = true;
        roundToInt = MathKt__MathJVMKt.roundToInt(TypedValue.applyDimension(1, QidPagView.DESIGN_PAG_WIDTH, Resources.getSystem().getDisplayMetrics()));
        int min = Math.min((int) (width * 0.75f), roundToInt);
        View view = this.historyDrawerContent;
        if (view == null || (layoutParams2 = view.getLayoutParams()) == null || layoutParams2.width != min) {
            z16 = false;
        }
        if (!z16) {
            View view2 = this.historyDrawerContent;
            if (view2 != null) {
                layoutParams = view2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = min;
            }
            View view3 = this.historyDrawerContent;
            if (view3 != null) {
                view3.requestLayout();
            }
        }
    }

    public final boolean S9() {
        boolean z16;
        SafeDrawerLayout safeDrawerLayout = this.guildAiSearchDrawer;
        if (safeDrawerLayout != null && safeDrawerLayout.isDrawerVisible(8388611)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        SafeDrawerLayout safeDrawerLayout2 = this.guildAiSearchDrawer;
        if (safeDrawerLayout2 != null) {
            safeDrawerLayout2.closeDrawer(8388611);
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        boolean z16;
        if (Intrinsics.areEqual(action, "broadcast_get_recyclerview_container")) {
            return this.aiHistoryListView;
        }
        if (Intrinsics.areEqual(action, "broadcast_get_drawer_opened")) {
            SafeDrawerLayout safeDrawerLayout = this.guildAiSearchDrawer;
            boolean z17 = false;
            if (safeDrawerLayout != null) {
                if (safeDrawerLayout.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            return Boolean.valueOf(z17);
        }
        return super.getMessage(action, args);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.tencent.mobileqq.guild.widget.drawerlayout.SafeDrawerLayout, androidx.drawerlayout.widget.DrawerLayout, T] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.guild.widget.drawerlayout.SafeDrawerLayout, T] */
    public final void oa() {
        ViewGroup viewGroup = null;
        SimpleEventBus.getInstance().dispatchEvent(new GuildAISearchInputCloseEvent(false, 1, null));
        X9().h2();
        View view = this.rootView;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        }
        if (viewGroup == null) {
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r16 = this.guildAiSearchDrawer;
        objectRef.element = r16;
        if (r16 == 0) {
            viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.aisearch.f
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    AIHistoryListPart.pa(AIHistoryListPart.this, view2, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.edw, viewGroup, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.drawerlayout.SafeDrawerLayout");
            ?? r17 = (SafeDrawerLayout) inflate;
            objectRef.element = r17;
            r17.setDrawerElevation(0.0f);
            viewGroup.addView((View) objectRef.element);
            T t16 = objectRef.element;
            this.guildAiSearchDrawer = (SafeDrawerLayout) t16;
            this.historyDrawerContent = ((SafeDrawerLayout) t16).findViewById(R.id.um_);
            ta(viewGroup.getWidth());
            ((SafeDrawerLayout) objectRef.element).addDrawerListener(new h(((SafeDrawerLayout) objectRef.element).findViewById(R.id.ump), 1.0f, objectRef, this));
            ca((SafeDrawerLayout) objectRef.element);
        }
        ((View) objectRef.element).setVisibility(0);
        ((SafeDrawerLayout) objectRef.element).openDrawer(8388611);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FlowKt.launchIn(FlowKt.onEach(V9().Q1(), new AIHistoryListPart$onInitView$1(new Ref.ObjectRef(), this, null)), com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this));
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/aisearch/AIHistoryListPart$e", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements ILoadMoreProvider$LoadMoreListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.discoveryv2.content.base.f f213962d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIHistoryListPart f213963e;

        e(com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar, AIHistoryListPart aIHistoryListPart) {
            this.f213962d = fVar;
            this.f213963e = aIHistoryListPart;
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            com.tencent.mobileqq.guild.discoveryv2.content.base.f.k0(this.f213962d, true, false, null, 4, null);
            this.f213963e.X9().j2();
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
