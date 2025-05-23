package com.tencent.mobileqq.wink.inspirationlibrary.part;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTopicView;
import com.tencent.mobileqq.wink.templatelibrary.viewmodel.WinkTemplateViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import feedcloud.FeedCloudActivityLandingPage$GetActivityTopicListRsp;
import feedcloud.FeedCloudActivityLandingPage$Topic;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 52\u00020\u0001:\u0004678\u0010B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00102\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g;", "Lp53/b;", "", "K9", "Landroid/view/View;", "view", "", "J9", "L9", "M9", "Q9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "d", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootContainer", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "labelTextView", tl.h.F, "moreButtonText", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "moreButtonArrow", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$c;", "adapter", "", BdhLogUtil.LogTag.Tag_Conn, "I", "curItemIndex", "D", "curTopicSize", "E", "Z", "isRspFinish", UserInfo.SEX_FEMALE, "isLoading", "G", "Landroid/view/View;", "snapView", "<init>", "()V", "H", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g extends p53.b {

    /* renamed from: C, reason: from kotlin metadata */
    private int curItemIndex = -1;

    /* renamed from: D, reason: from kotlin metadata */
    private int curTopicSize;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isRspFinish;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View snapView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout rootContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView labelTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView moreButtonText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView moreButtonArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
                outRect.right = c.INSTANCE.b();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$d;", "", "Lfeedcloud/FeedCloudActivityLandingPage$Topic;", "data", "", "addData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "topicList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static int D = ViewUtils.dip2px(31.0f);
        private static int E = ViewUtils.dip2px(375.0f);

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<FeedCloudActivityLandingPage$Topic> topicList = new ArrayList();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$c$a;", "", "", "RIGHT_SPACE_PX", "I", "b", "()I", "setRIGHT_SPACE_PX", "(I)V", "ITEM_WIDTH_IN_PAD_DEVICE_PX", "a", "setITEM_WIDTH_IN_PAD_DEVICE_PX", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.inspirationlibrary.part.g$c$a, reason: from kotlin metadata */
        /* loaded from: classes21.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.E;
            }

            public final int b() {
                return c.D;
            }

            Companion() {
            }
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public final void addData(@NotNull List<FeedCloudActivityLandingPage$Topic> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.topicList.addAll(data);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return ((this.topicList.size() + 3) - 1) / 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            int screenWidth;
            Object orNull;
            Object orNull2;
            Object orNull3;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
                screenWidth = E;
            } else {
                screenWidth = ViewUtils.getScreenWidth() - D;
            }
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            layoutParams.width = screenWidth;
            holder.itemView.setLayoutParams(layoutParams);
            int i3 = position * 3;
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.topicList, i3);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.topicList, i3 + 1);
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(this.topicList, i3 + 2);
            holder.l((FeedCloudActivityLandingPage$Topic) orNull, (FeedCloudActivityLandingPage$Topic) orNull2, (FeedCloudActivityLandingPage$Topic) orNull3, position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i5v, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new d(itemView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\bR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/g$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfeedcloud/FeedCloudActivityLandingPage$Topic;", "topic", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTopicView;", "topicView", "", "topicIndex", "", DomainData.DOMAIN_NAME, "o", "topic1", "topic2", "topic3", "listItemPosition", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTopicView;", "topicView1", UserInfo.SEX_FEMALE, "topicView2", "G", "topicView3", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final WinkInspirationTopicView topicView1;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final WinkInspirationTopicView topicView2;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final WinkInspirationTopicView topicView3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f100435sh);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.topic_view_1)");
            this.topicView1 = (WinkInspirationTopicView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f100445si);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.topic_view_2)");
            this.topicView2 = (WinkInspirationTopicView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f100455sj);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.topic_view_3)");
            this.topicView3 = (WinkInspirationTopicView) findViewById3;
        }

        private final void n(FeedCloudActivityLandingPage$Topic topic, WinkInspirationTopicView topicView, int topicIndex) {
            if (topic == null) {
                topicView.setVisibility(8);
            } else {
                topicView.setVisibility(0);
                topicView.D0(topic, topicIndex);
            }
        }

        private final void o(WinkInspirationTopicView topicView) {
            if (topicView.getVisibility() == 0) {
                topicView.J0();
            }
        }

        public final void l(@Nullable FeedCloudActivityLandingPage$Topic topic1, @Nullable FeedCloudActivityLandingPage$Topic topic2, @Nullable FeedCloudActivityLandingPage$Topic topic3, int listItemPosition) {
            int i3 = listItemPosition * 3;
            n(topic1, this.topicView1, i3);
            n(topic2, this.topicView2, i3 + 1);
            n(topic3, this.topicView3, i3 + 2);
        }

        public final void m() {
            o(this.topicView1);
            o(this.topicView2);
            o(this.topicView3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/g$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(linearLayoutManager);
            int itemCount = linearLayoutManager.getItemCount();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (!g.this.isRspFinish && !g.this.isLoading && itemCount <= findLastVisibleItemPosition + 1) {
                g.this.isLoading = true;
                g.this.Q9();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/g$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f323018e;

        f(a aVar) {
            this.f323018e = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            int i3;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            g.this.snapView = this.f323018e.findSnapView(recyclerView.getLayoutManager());
            View view = g.this.snapView;
            if (view != null) {
                g gVar = g.this;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    i3 = layoutManager.getPosition(view);
                } else {
                    i3 = -1;
                }
                if (gVar.curItemIndex != i3) {
                    gVar.curItemIndex = i3;
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3);
                    Intrinsics.checkNotNull(findViewHolderForAdapterPosition, "null cannot be cast to non-null type com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationHotTopicPart.TopicViewHolder");
                    ((d) findViewHolderForAdapterPosition).m();
                    QLog.d("WinkInspirationHotTopicPart", 1, "topicRecyclerView curItemIndex: " + gVar.curItemIndex);
                }
            }
        }
    }

    private final void J9(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_HOT_TOPIC_MODULE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private final boolean K9() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    private final void L9(View view) {
        VideoReport.setElementId(view, "em_xsj_more_button");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final void M9() {
        boolean z16;
        String optString;
        if (SSODebugUtil.isTestEnv()) {
            optString = "https://mtest.xsj.qq.com/h5/create-inspiration/home?_wv=3&_wwv=8193&xsj_h5_page_source=lgk";
        } else {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102201", "");
            if (loadAsString.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                try {
                    optString = new JSONObject(loadAsString).optString("create_inspiration_url", "https://m.xsj.qq.com/h5/create-inspiration/home?_wv=3&_wwv=8193&xsj_h5_page_source=growth_center&open_kuikly_info=%7B%22page_name%22%3A%22QVideoCreateInspiration%22%2C%22bundle_name%22%3A%22qq_video_create_inspiration%22%2C%22kr_min_qq_version%22%3A%229.0.35%22%2C%22kr_turbo_display%22%3A%221%22%2C%22error_url%22%3A%22https%253A%252F%252Fm.xsj.qq.com%252Fh5%252Fcreate-inspiration%252Fhome%253F_wv%253D3%2526_wwv%253D8193%2526xsj_h5_page_source%253Dlgk%22%7D");
                } catch (Exception e16) {
                    QLog.e("WinkInspirationHotTopicPart", 1, "onClickMore error:" + e16);
                }
            }
            optString = "https://m.xsj.qq.com/h5/create-inspiration/home?_wv=3&_wwv=8193&xsj_h5_page_source=growth_center&open_kuikly_info=%7B%22page_name%22%3A%22QVideoCreateInspiration%22%2C%22bundle_name%22%3A%22qq_video_create_inspiration%22%2C%22kr_min_qq_version%22%3A%229.0.35%22%2C%22kr_turbo_display%22%3A%221%22%2C%22error_url%22%3A%22https%253A%252F%252Fm.xsj.qq.com%252Fh5%252Fcreate-inspiration%252Fhome%253F_wv%253D3%2526_wwv%253D8193%2526xsj_h5_page_source%253Dlgk%22%7D";
        }
        com.tencent.mobileqq.wink.f.l(getContext(), optString);
        TextView textView = this.moreButtonText;
        if (textView != null) {
            L9(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(g this$0, FeedCloudActivityLandingPage$GetActivityTopicListRsp feedCloudActivityLandingPage$GetActivityTopicListRsp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isLoading = false;
        this$0.curTopicSize += feedCloudActivityLandingPage$GetActivityTopicListRsp.topics.size();
        this$0.isRspFinish = feedCloudActivityLandingPage$GetActivityTopicListRsp.is_finish.get();
        List<FeedCloudActivityLandingPage$Topic> list = feedCloudActivityLandingPage$GetActivityTopicListRsp.topics.get();
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ConstraintLayout constraintLayout = this$0.rootContainer;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout2 = this$0.rootContainer;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        c cVar = this$0.adapter;
        if (cVar != null) {
            List<FeedCloudActivityLandingPage$Topic> list2 = feedCloudActivityLandingPage$GetActivityTopicListRsp.topics.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rsp.topics.get()");
            cVar.addData(list2);
        }
        TextView textView = this$0.labelTextView;
        if (textView != null) {
            this$0.J9(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        ((WinkTemplateViewModel) getViewModel(WinkTemplateViewModel.class)).T1(45, this.curTopicSize / 45);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkInspirationHotTopicPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ConstraintLayout constraintLayout;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        super.onInitView(rootView);
        RecyclerView recyclerView = null;
        if (rootView != null) {
            constraintLayout = (ConstraintLayout) rootView.findViewById(R.id.f122937fa);
        } else {
            constraintLayout = null;
        }
        this.rootContainer = constraintLayout;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f122947fb);
        } else {
            textView = null;
        }
        this.labelTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f122967fd);
        } else {
            textView2 = null;
        }
        this.moreButtonText = textView2;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f122957fc);
        } else {
            imageView = null;
        }
        this.moreButtonArrow = imageView;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f123107fr);
        }
        this.recyclerView = recyclerView;
        TextView textView3 = this.labelTextView;
        if (textView3 != null) {
            textView3.setText("\u70ed\u95e8\u8bdd\u9898");
        }
        ImageView imageView2 = this.moreButtonArrow;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        TextView textView4 = this.moreButtonText;
        if (textView4 != null) {
            textView4.setPadding(0, 0, ViewUtils.dip2px(12.0f), 0);
        }
        TextView textView5 = this.moreButtonText;
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.N9(g.this, view);
                }
            });
        }
        ImageView imageView3 = this.moreButtonArrow;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.O9(g.this, view);
                }
            });
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(new e());
        }
        a aVar = new a(K9(), c.INSTANCE.a());
        aVar.attachToRecyclerView(this.recyclerView);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            c cVar = new c();
            this.adapter = cVar;
            recyclerView3.setAdapter(cVar);
            recyclerView3.setLayoutManager(new LinearLayoutManager(getPartHost().getHostActivity(), 0, false));
            recyclerView3.addItemDecoration(new b());
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 != null) {
            recyclerView4.addOnScrollListener(new f(aVar));
        }
        ((WinkTemplateViewModel) getViewModel(WinkTemplateViewModel.class)).S1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.P9(g.this, (FeedCloudActivityLandingPage$GetActivityTopicListRsp) obj);
            }
        });
    }
}
