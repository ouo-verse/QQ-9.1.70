package be3;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import be3.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
import com.tencent.mobileqq.zplan.aigc.data.EndHintItem;
import com.tencent.mobileqq.zplan.aigc.data.LikeData;
import com.tencent.mobileqq.zplan.aigc.data.PromoteItemInfo;
import com.tencent.mobileqq.zplan.aigc.view.component.GuildMemberLoopView;
import com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.sqshow.zootopia.aigc.view.component.GuildUserAvatarView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005STUVWBm\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140 \u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0$\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0$\u0012\u0006\u0010-\u001a\u00020*\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0$\u0012\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\r00\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0014\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010&R&\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\r008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R$\u0010?\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010E\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00109\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00109\u00a8\u0006X"}, d2 = {"Lbe3/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "status", "Lcom/tencent/mobileqq/zplan/aigc/data/f;", "w0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "_state", "E0", "getItemViewType", "", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "newDataList", "setData", "z0", "y0", "", "channelSig", "A0", "from", "B0", "v0", "C0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "onItemCreateClick", "D", "onItemContractClick", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", "E", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", "likeDataCallback", UserInfo.SEX_FEMALE, "refreshCallback", "Lkotlin/Function2;", "", "G", "Lkotlin/jvm/functions/Function2;", "itemViewClickCallBack", "Lzd3/a;", "H", "Lzd3/a;", "dtReporter", "I", "Ljava/lang/String;", "x0", "()Ljava/lang/String;", "setChannelSig_", "(Ljava/lang/String;)V", "channelSig_", "J", "getFeedFrom_", "()I", "setFeedFrom_", "(I)V", "feedFrom_", "Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment;", "K", "Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment;", "getReportFragment", "()Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment;", "D0", "(Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment;)V", "reportFragment", "L", "fullSpanItemPosition", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lzd3/a;)V", "M", "a", "b", "c", "d", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: b0, reason: collision with root package name */
    private static final List<String> f28311b0;

    /* renamed from: C, reason: from kotlin metadata */
    private final Function0<Unit> onItemCreateClick;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function0<Unit> onItemContractClick;

    /* renamed from: E, reason: from kotlin metadata */
    private final SuitFeedViewModel.c likeDataCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private final Function0<Unit> refreshCallback;

    /* renamed from: G, reason: from kotlin metadata */
    private final Function2<Integer, Long, Unit> itemViewClickCallBack;

    /* renamed from: H, reason: from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: I, reason: from kotlin metadata */
    private String channelSig_;

    /* renamed from: J, reason: from kotlin metadata */
    private int feedFrom_;

    /* renamed from: K, reason: from kotlin metadata */
    private SuitParentFragment reportFragment;

    /* renamed from: L, reason: from kotlin metadata */
    private int fullSpanItemPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.mobileqq.zplan.aigc.data.b> dataList;

    /* renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int P = 1;
    private static final int Q = 2;
    private static final int R = 3;
    private static final int S = 4;
    private static final int N = 0;
    private static int T = N;
    private static final int U = 1;
    private static final int V = 2;
    private static final int W = 3;
    private static final int X = 4;
    private static final int Y = 5;
    private static final String Z = "71096591635406847";

    /* renamed from: a0, reason: collision with root package name */
    private static final String f28310a0 = "608123899";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00158\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017\u00a8\u0006!"}, d2 = {"Lbe3/a$a;", "", "", "STATE_LOAIND", "I", "e", "()I", "STATE_ERROR", "c", "STATE_FINISHED", "d", "VIEW_TYPE_FEED_ITEM", "g", "VIEW_TYPE_PROMOTE", "i", "VIEW_TYPE_BANNER", "f", "VIEW_TYPE_ITEM2", tl.h.F, "VIEW_TYPE_TAIL", "j", "", "GUID_ID_SUPER_AVATAR", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "GUID_CHANNEL_SUB_ID", "a", "SUIT_SIZE_TYPE_LONG", "SUIT_SIZE_TYPE_NORMAL", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: be3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return a.f28310a0;
        }

        public final String b() {
            return a.Z;
        }

        public final int c() {
            return a.R;
        }

        public final int d() {
            return a.S;
        }

        public final int e() {
            return a.P;
        }

        public final int f() {
            return a.W;
        }

        public final int g() {
            return a.U;
        }

        public final int h() {
            return a.X;
        }

        public final int i() {
            return a.V;
        }

        public final int j() {
            return a.Y;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lbe3/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "text", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "loadingIcon", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/a;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView text;

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView loadingIcon;
        final /* synthetic */ a H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, View itemView, zd3.a aVar2) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = aVar;
            this.dtReporter = aVar2;
            this.text = (TextView) itemView.findViewById(R.id.qqa);
            this.loadingIcon = (ImageView) itemView.findViewById(R.id.q6s);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.refreshCallback.invoke();
        }

        private final void o() {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setRepeatCount(-1);
            this.loadingIcon.startAnimation(rotateAnimation);
        }

        public final void m(com.tencent.mobileqq.zplan.aigc.data.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            EndHintItem endHintItem = (EndHintItem) data;
            if (endHintItem.getStatus() == -1) {
                this.text.setVisibility(8);
                return;
            }
            QLog.d("SuitFeedAdapter", 2, "data status: " + endHintItem.getStatus() + "," + endHintItem.getHintText());
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            layoutParams2.setFullSpan(true);
            int status = endHintItem.getStatus();
            Companion companion = a.INSTANCE;
            if (status == companion.c()) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ImmersiveUtils.dpToPx(20.0f);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ImmersiveUtils.dpToPx(10.0f);
            }
            this.text.setText(endHintItem.getHintText());
            if (endHintItem.getStatus() == companion.e()) {
                QLog.d("SuitFeedAdapter", 2, "data status: laoding " + endHintItem.getStatus() + "," + endHintItem.getHintText());
                this.loadingIcon.setVisibility(0);
                o();
            } else {
                this.loadingIcon.clearAnimation();
                this.loadingIcon.setVisibility(4);
            }
            if (endHintItem.getStatus() == companion.c()) {
                this.loadingIcon.clearAnimation();
                this.loadingIcon.setVisibility(4);
                TextView textView = this.text;
                final a aVar = this.H;
                textView.setOnClickListener(new View.OnClickListener() { // from class: be3.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.c.n(a.this, view);
                    }
                });
                QLog.d("SuitFeedAdapter", 2, "data status: error" + endHintItem.getStatus() + "," + endHintItem.getHintText());
            }
            this.itemView.setLayoutParams(layoutParams2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010!\u001a\n \u0017*\u0004\u0018\u00010\u001d0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010'\u001a\n \u0017*\u0004\u0018\u00010\"0\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010*\u001a\n \u0017*\u0004\u0018\u00010\u001d0\u001d8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 R\u001f\u0010-\u001a\n \u0017*\u0004\u0018\u00010\u001d0\u001d8\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010 R\u001f\u00100\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001bR\u001f\u00106\u001a\n \u0017*\u0004\u0018\u000101018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lbe3/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "data", "", DomainData.DOMAIN_NAME, "", "E", "I", "suitType", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", "likeDataCallback", "Lzd3/a;", "G", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/ImageView;", "getClothImg", "()Landroid/widget/ImageView;", "clothImg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getClothDesc", "()Landroid/widget/TextView;", "clothDesc", "Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView;", "J", "Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView;", "getAvatarImg", "()Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView;", "avatarImg", "K", "getFeedHotCount", "feedHotCount", "L", "getUserName", "userName", "M", "getLikeIcon", "likeIcon", "Landroid/widget/LinearLayout;", "N", "Landroid/widget/LinearLayout;", "getLikeRegion", "()Landroid/widget/LinearLayout;", "likeRegion", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/a;Landroid/view/View;ILcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final int suitType;

        /* renamed from: F, reason: from kotlin metadata */
        private final SuitFeedViewModel.c likeDataCallback;

        /* renamed from: G, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView clothImg;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView clothDesc;

        /* renamed from: J, reason: from kotlin metadata */
        private final GuildUserAvatarView avatarImg;

        /* renamed from: K, reason: from kotlin metadata */
        private final TextView feedHotCount;

        /* renamed from: L, reason: from kotlin metadata */
        private final TextView userName;

        /* renamed from: M, reason: from kotlin metadata */
        private final ImageView likeIcon;

        /* renamed from: N, reason: from kotlin metadata */
        private final LinearLayout likeRegion;
        final /* synthetic */ a P;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, View itemView, int i3, SuitFeedViewModel.c likeDataCallback, zd3.a aVar2) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(likeDataCallback, "likeDataCallback");
            this.P = aVar;
            this.suitType = i3;
            this.likeDataCallback = likeDataCallback;
            this.dtReporter = aVar2;
            this.clothImg = (ImageView) itemView.findViewById(R.id.q2y);
            this.clothDesc = (TextView) itemView.findViewById(R.id.f163432q33);
            this.avatarImg = (GuildUserAvatarView) itemView.findViewById(R.id.qvu);
            this.feedHotCount = (TextView) itemView.findViewById(R.id.q0_);
            this.userName = (TextView) itemView.findViewById(R.id.qwb);
            this.likeIcon = (ImageView) itemView.findViewById(R.id.q57);
            this.likeRegion = (LinearLayout) itemView.findViewById(R.id.q5b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(AIGCFeedItemInfo2 itemInfoData, d this$0, com.tencent.mobileqq.zplan.aigc.data.b data, View view) {
            Intrinsics.checkNotNullParameter(itemInfoData, "$itemInfoData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            LikeData likeData = itemInfoData.getLikeData();
            long likeCount = likeData != null ? likeData.getLikeCount() : 0L;
            LikeData likeData2 = itemInfoData.getLikeData();
            int i3 = 1;
            if (likeData2 != null && likeData2.getIsLike()) {
                this$0.likeIcon.setImageResource(R.drawable.ijo);
                itemInfoData.getLikeData().c(false);
                LikeData likeData3 = itemInfoData.getLikeData();
                likeData3.d(likeData3.getLikeCount() - 1);
                i3 = 0;
            } else {
                this$0.likeIcon.setImageResource(R.drawable.i7r);
                if (itemInfoData.getLikeData() != null) {
                    itemInfoData.getLikeData().c(true);
                    LikeData likeData4 = itemInfoData.getLikeData();
                    likeData4.d(likeData4.getLikeCount() + 1);
                }
            }
            TextView textView = this$0.feedHotCount;
            LikeData likeData5 = itemInfoData.getLikeData();
            textView.setText(String.valueOf(likeData5 != null ? Long.valueOf(likeData5.getLikeCount()) : null));
            this$0.likeDataCallback.b(itemInfoData);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", Integer.valueOf(i3));
            AIGCFeedItemInfo2 aIGCFeedItemInfo2 = (AIGCFeedItemInfo2) data;
            linkedHashMap.put("zplan_clothes_ugcid", Long.valueOf(aIGCFeedItemInfo2.getUgcId()));
            linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_LIKE_NUM, Long.valueOf(likeCount));
            zd3.a aVar = this$0.dtReporter;
            if (aVar != null) {
                LinearLayout likeRegion = this$0.likeRegion;
                Intrinsics.checkNotNullExpressionValue(likeRegion, "likeRegion");
                aVar.u(likeRegion, "em_zplan_thumbs", linkedHashMap, aIGCFeedItemInfo2.getUgcId() + "_like");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(com.tencent.mobileqq.zplan.aigc.data.b data, a this$0, d this$1, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            AIGCFeedItemInfo2 aIGCFeedItemInfo2 = (AIGCFeedItemInfo2) data;
            if (TextUtils.isEmpty(aIGCFeedItemInfo2.getDesc())) {
                QQToastUtil.showQQToast(1, "\u63cf\u8ff0\u8bcd\u7f3a\u5931\uff0c\u65e0\u6cd5\u5236\u4f5c");
            } else {
                this$0.itemViewClickCallBack.invoke(Integer.valueOf(aIGCFeedItemInfo2.getItemId()), Long.valueOf(aIGCFeedItemInfo2.getUgcId()));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_card_pos", Integer.valueOf(aIGCFeedItemInfo2.getIndex()));
            linkedHashMap.put("zplan_clothes_ugcid", Long.valueOf(aIGCFeedItemInfo2.getUgcId()));
            linkedHashMap.put("zplan_create_uin", aIGCFeedItemInfo2.getAuthorUin());
            zd3.a aVar = this$1.dtReporter;
            if (aVar != null) {
                View itemView = this$1.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                aVar.u(itemView, "em_zplan_feed_clothes_card", linkedHashMap, String.valueOf(aIGCFeedItemInfo2.getUgcId()));
            }
        }

        public void n(final com.tencent.mobileqq.zplan.aigc.data.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.P.v0();
            final AIGCFeedItemInfo2 aIGCFeedItemInfo2 = (AIGCFeedItemInfo2) data;
            QLog.e("SuitFeedAdapter", 1, "TypeOneViewHolder :" + aIGCFeedItemInfo2.getClothImgUrl() + ", " + aIGCFeedItemInfo2.getAuthorHeaderUrl() + ", " + aIGCFeedItemInfo2 + ",");
            com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
            if (aVar.g(aIGCFeedItemInfo2.getClothImgUrl())) {
                ImageView imageView = this.clothImg;
                String clothImgUrl = aIGCFeedItemInfo2.getClothImgUrl();
                Context context = this.clothImg.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "clothImg.context");
                imageView.setImageDrawable(URLDrawable.getDrawable(clothImgUrl, aVar.b(context)));
            }
            LikeData likeData = aIGCFeedItemInfo2.getLikeData();
            int i3 = 0;
            if (likeData != null && likeData.getIsLike()) {
                this.likeIcon.setImageResource(R.drawable.i7r);
                i3 = 1;
            } else {
                this.likeIcon.setImageResource(R.drawable.ijo);
            }
            if (this.suitType == 1) {
                ViewGroup.LayoutParams layoutParams = this.clothImg.getLayoutParams();
                layoutParams.width = ImmersiveUtils.dpToPx(130.0f);
                layoutParams.height = ImmersiveUtils.dpToPx(130.0f);
                this.clothImg.setLayoutParams(layoutParams);
            }
            Rect rect = new Rect();
            this.likeRegion.getHitRect(rect);
            rect.top -= 20;
            rect.bottom += 20;
            rect.left -= 20;
            rect.right += 20;
            TouchDelegate touchDelegate = new TouchDelegate(rect, this.likeRegion);
            View view = this.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.View");
            view.setTouchDelegate(touchDelegate);
            LikeData likeData2 = aIGCFeedItemInfo2.getLikeData();
            long likeCount = likeData2 != null ? likeData2.getLikeCount() : 0L;
            this.likeRegion.setOnClickListener(new View.OnClickListener() { // from class: be3.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.d.o(AIGCFeedItemInfo2.this, this, data, view2);
                }
            });
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", Integer.valueOf(i3));
            linkedHashMap.put("zplan_clothes_ugcid", Long.valueOf(aIGCFeedItemInfo2.getUgcId()));
            linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_LIKE_NUM, Long.valueOf(likeCount));
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                LinearLayout likeRegion = this.likeRegion;
                Intrinsics.checkNotNullExpressionValue(likeRegion, "likeRegion");
                aVar2.b(likeRegion, "em_zplan_thumbs", aIGCFeedItemInfo2.getUgcId() + "_like", linkedHashMap);
            }
            this.clothDesc.setText(aIGCFeedItemInfo2.getDesc());
            this.userName.setText(aIGCFeedItemInfo2.getAuthorName());
            if (aVar.g(aIGCFeedItemInfo2.getAuthorHeaderUrl())) {
                this.avatarImg.setImageDrawable(URLDrawable.getDrawable(aIGCFeedItemInfo2.getAuthorHeaderUrl(), aVar.e()));
            }
            TextView textView = this.feedHotCount;
            LikeData likeData3 = aIGCFeedItemInfo2.getLikeData();
            textView.setText(String.valueOf(likeData3 != null ? Long.valueOf(likeData3.getLikeCount()) : null));
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("zplan_card_pos", Integer.valueOf(aIGCFeedItemInfo2.getIndex()));
            linkedHashMap2.put("zplan_clothes_ugcid", Long.valueOf(aIGCFeedItemInfo2.getUgcId()));
            linkedHashMap2.put("zplan_create_uin", aIGCFeedItemInfo2.getAuthorUin());
            zd3.a aVar3 = this.dtReporter;
            if (aVar3 != null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                aVar3.b(itemView, "em_zplan_feed_clothes_card", String.valueOf(aIGCFeedItemInfo2.getUgcId()), linkedHashMap2);
            }
            View view2 = this.itemView;
            final a aVar4 = this.P;
            view2.setOnClickListener(new View.OnClickListener() { // from class: be3.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    a.d.p(com.tencent.mobileqq.zplan.aigc.data.b.this, aVar4, this, view3);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n \u000f*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011\u00a8\u0006!"}, d2 = {"Lbe3/a$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "_data", "", DomainData.DOMAIN_NAME, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "promoteTitle", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "enterBtn", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "img", "I", QQWinkConstants.TAB_SUBTITLE, "Landroid/view/View;", "itemView", "<init>", "(Lbe3/a;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public final class e extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView promoteTitle;

        /* renamed from: G, reason: from kotlin metadata */
        private final Button enterBtn;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView img;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView subTitle;
        final /* synthetic */ a J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, View itemView, zd3.a aVar2) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.J = aVar;
            this.dtReporter = aVar2;
            this.promoteTitle = (TextView) itemView.findViewById(R.id.f163432q33);
            this.enterBtn = (Button) itemView.findViewById(R.id.prz);
            this.img = (ImageView) itemView.findViewById(R.id.q2y);
            this.subTitle = (TextView) itemView.findViewById(R.id.qo8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(PromoteItemInfo data, e this$0, a this$1, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.g(data.getJumpUrl())) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                iZPlanApi.launchScheme(context, data.getJumpUrl());
            }
            this$1.v0();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_act_id", data.getName());
            zd3.a aVar = this$0.dtReporter;
            if (aVar != null) {
                View itemView = this$0.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                aVar.u(itemView, "em_zplan_feed_act_card", linkedHashMap, EventKey.ACT);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewGroup.LayoutParams layoutParams = this$0.img.getLayoutParams();
            layoutParams.height = (int) (this$0.img.getWidth() / 0.8549222797927462d);
            this$0.img.setLayoutParams(layoutParams);
        }

        public final void n(com.tencent.mobileqq.zplan.aigc.data.b _data) {
            Intrinsics.checkNotNullParameter(_data, "_data");
            final PromoteItemInfo promoteItemInfo = (PromoteItemInfo) _data;
            if (com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.g(promoteItemInfo.getImageUrl())) {
                this.img.setImageDrawable(URLDrawable.getDrawable(promoteItemInfo.getImageUrl(), (URLDrawable.URLDrawableOptions) null));
            }
            this.img.setClipToOutline(true);
            this.subTitle.setText(promoteItemInfo.getSubTitle());
            this.promoteTitle.setText(promoteItemInfo.getTitle());
            View view = this.itemView;
            final a aVar = this.J;
            view.setOnClickListener(new View.OnClickListener() { // from class: be3.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.e.o(PromoteItemInfo.this, this, aVar, view2);
                }
            });
            this.img.post(new Runnable() { // from class: be3.i
                @Override // java.lang.Runnable
                public final void run() {
                    a.e.p(a.e.this);
                }
            });
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_act_id", promoteItemInfo.getName());
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                aVar2.b(itemView, "em_zplan_feed_act_card", EventKey.ACT, linkedHashMap);
            }
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://downv6.qq.com/shadow_qqcamera/zshow/test_avatar1.png", "https://downv6.qq.com/shadow_qqcamera/zshow/test_avatar2.png", "https://downv6.qq.com/shadow_qqcamera/zshow/test_avatar3.png", "https://downv6.qq.com/shadow_qqcamera/zshow/test_avatar4.png", "https://downv6.qq.com/shadow_qqcamera/zshow/test_avatar5.png", "https://downv6.qq.com/shadow_qqcamera/zshow/test_avatar6.png"});
        f28311b0 = listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<com.tencent.mobileqq.zplan.aigc.data.b> dataList, Function0<Unit> onItemCreateClick, Function0<Unit> onItemContractClick, SuitFeedViewModel.c likeDataCallback, Function0<Unit> refreshCallback, Function2<? super Integer, ? super Long, Unit> itemViewClickCallBack, zd3.a aVar) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(onItemCreateClick, "onItemCreateClick");
        Intrinsics.checkNotNullParameter(onItemContractClick, "onItemContractClick");
        Intrinsics.checkNotNullParameter(likeDataCallback, "likeDataCallback");
        Intrinsics.checkNotNullParameter(refreshCallback, "refreshCallback");
        Intrinsics.checkNotNullParameter(itemViewClickCallBack, "itemViewClickCallBack");
        this.dataList = dataList;
        this.onItemCreateClick = onItemCreateClick;
        this.onItemContractClick = onItemContractClick;
        this.likeDataCallback = likeDataCallback;
        this.refreshCallback = refreshCallback;
        this.itemViewClickCallBack = itemViewClickCallBack;
        this.dtReporter = aVar;
        this.feedFrom_ = 1;
        this.fullSpanItemPosition = -1;
    }

    private final EndHintItem w0(int status) {
        EndHintItem endHintItem = new EndHintItem(null, 0, null, 7, null);
        endHintItem.g(status);
        if (status == P) {
            endHintItem.f("\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019...");
        } else if (status == S) {
            endHintItem.f("\u6ca1\u6709\u66f4\u591a\u6570\u636e\u4e86");
        } else if (status == R) {
            endHintItem.f("\u52a0\u8f7d\u9519\u8bef\uff0c\u70b9\u51fb\u91cd\u8bd5");
        }
        return endHintItem;
    }

    public final void A0(String channelSig) {
        this.channelSig_ = channelSig;
    }

    public final void B0(int from) {
        this.feedFrom_ = from;
    }

    public final void C0(int position) {
        this.fullSpanItemPosition = position;
    }

    public final void D0(SuitParentFragment suitParentFragment) {
        this.reportFragment = suitParentFragment;
    }

    public final void E0(int _state) {
        if (T != _state) {
            T = _state;
            notifyItemChanged(getNUM_BACKGOURND_ICON() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (this.dataList.size() == 0) {
            return 0;
        }
        return this.dataList.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == getNUM_BACKGOURND_ICON() - 1) {
            return Y;
        }
        if (this.dataList.get(position).getType() == 1) {
            return U;
        }
        if (this.dataList.get(position).getType() == 2) {
            return V;
        }
        if (this.dataList.get(position).getType() == 4) {
            return X;
        }
        if (this.dataList.get(position).getType() == 3) {
            return W;
        }
        if (this.dataList.get(position).getType() == 5) {
            return Y;
        }
        return U;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = holder.getItemViewType();
        if (itemViewType == U) {
            ((d) holder).n(this.dataList.get(position));
            return;
        }
        if (itemViewType == V) {
            ((e) holder).n(this.dataList.get(position));
            return;
        }
        if (itemViewType == W) {
            ((b) holder).o();
            return;
        }
        if (itemViewType == X) {
            ((d) holder).n(this.dataList.get(position));
        } else if (itemViewType == Y) {
            ((c) holder).m(w0(T));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder cVar;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == X) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167464dg3, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new d(this, view, 1, this.likeDataCallback, this.dtReporter);
        }
        if (viewType == U) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167464dg3, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new d(this, view2, 0, this.likeDataCallback, this.dtReporter);
        }
        if (viewType == V) {
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167465dg4, parent, false);
            Intrinsics.checkNotNullExpressionValue(view3, "view");
            cVar = new e(this, view3, this.dtReporter);
        } else if (viewType == W) {
            View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.d2g, parent, false);
            Intrinsics.checkNotNullExpressionValue(view4, "view");
            cVar = new b(this, view4, this.dtReporter);
        } else if (viewType == Y) {
            View view5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167462dg1, parent, false);
            Intrinsics.checkNotNullExpressionValue(view5, "view");
            cVar = new c(this, view5, this.dtReporter);
        } else {
            throw new IllegalArgumentException("Invalid view type");
        }
        return cVar;
    }

    public final void setData(List<? extends com.tencent.mobileqq.zplan.aigc.data.b> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.dataList.clear();
        this.dataList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public final void v0() {
        SuitParentFragment suitParentFragment = this.reportFragment;
        if (suitParentFragment != null) {
            Intrinsics.checkNotNull(suitParentFragment);
            suitParentFragment.Ii("pg_zplan_create_home", true);
        }
    }

    /* renamed from: x0, reason: from getter */
    public final String getChannelSig_() {
        return this.channelSig_;
    }

    public final void y0(int position) {
        if (position < this.dataList.size()) {
            notifyItemChanged(position);
        }
    }

    public final void z0() {
        int size = this.dataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.dataList.get(i3).getType() == 2) {
                y0(i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u001c\u0010\u001e\u001a\n \r*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010*\u001a\u00020&8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lbe3/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "girlBanner", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "startButton", "Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView;", "H", "Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView;", "guildAvatars", "I", "contractInfo", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "hint", "", "K", "getLastTimeToast", "()J", "setLastTimeToast", "(J)V", "lastTimeToast", "", "L", "getDefaultInterval", "()I", "defaultInterval", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/a;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView girlBanner;

        /* renamed from: G, reason: from kotlin metadata */
        private final LinearLayout startButton;

        /* renamed from: H, reason: from kotlin metadata */
        private final GuildMemberLoopView guildAvatars;

        /* renamed from: I, reason: from kotlin metadata */
        private final ImageView contractInfo;

        /* renamed from: J, reason: from kotlin metadata */
        private final TextView hint;

        /* renamed from: K, reason: from kotlin metadata */
        private long lastTimeToast;

        /* renamed from: L, reason: from kotlin metadata */
        private final int defaultInterval;
        final /* synthetic */ a M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, View itemView, zd3.a aVar2) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.M = aVar;
            this.dtReporter = aVar2;
            this.girlBanner = (ImageView) itemView.findViewById(R.id.pdg);
            this.startButton = (LinearLayout) itemView.findViewById(R.id.qna);
            this.guildAvatars = (GuildMemberLoopView) itemView.findViewById(R.id.pcu);
            this.contractInfo = (ImageView) itemView.findViewById(R.id.pmg);
            this.hint = (TextView) itemView.findViewById(R.id.pzd);
            this.defaultInterval = 1000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b this$0, a this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (SystemClock.elapsedRealtime() - this$0.lastTimeToast > this$0.defaultInterval) {
                this$0.lastTimeToast = SystemClock.elapsedRealtime();
                this$1.onItemCreateClick.invoke();
                zd3.a aVar = this$0.dtReporter;
                if (aVar != null) {
                    LinearLayout startButton = this$0.startButton;
                    Intrinsics.checkNotNullExpressionValue(startButton, "startButton");
                    aVar.t(startButton, "em_zplan_create_now", null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean q(b this$0, View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int action = motionEvent.getAction();
            if (action == 0) {
                xd3.a aVar = xd3.a.f447833a;
                LinearLayout startButton = this$0.startButton;
                Intrinsics.checkNotNullExpressionValue(startButton, "startButton");
                aVar.c(startButton, 0.95f);
            } else if (action == 1) {
                this$0.startButton.performClick();
                xd3.a aVar2 = xd3.a.f447833a;
                LinearLayout startButton2 = this$0.startButton;
                Intrinsics.checkNotNullExpressionValue(startButton2, "startButton");
                aVar2.c(startButton2, 1.0f);
            } else if (action == 3) {
                xd3.a aVar3 = xd3.a.f447833a;
                LinearLayout startButton3 = this$0.startButton;
                Intrinsics.checkNotNullExpressionValue(startButton3, "startButton");
                aVar3.c(startButton3, 1.0f);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(a this$0, b this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.getChannelSig_() == null) {
                QQToastUtil.showQQToast(0, HardCodeUtil.qqStr(R.string.bce));
                return;
            }
            zd3.a aVar = this$1.dtReporter;
            if (aVar != null) {
                GuildMemberLoopView guildAvatars = this$1.guildAvatars;
                Intrinsics.checkNotNullExpressionValue(guildAvatars, "guildAvatars");
                aVar.t(guildAvatars, "em_zplan_channel_entrance", null);
            }
            Companion companion = a.INSTANCE;
            JumpGuildParam jumpGuildParam = new JumpGuildParam(companion.b(), companion.a());
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(this$0.getChannelSig_(), "share", "others"));
            com.tencent.mobileqq.guild.report.b.g("functional_superqqshow_square", "SuitFeedAdapter");
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(this$1.itemView.getContext(), jumpGuildParam);
        }

        public final void o() {
            Rect rect = new Rect();
            this.contractInfo.getHitRect(rect);
            rect.top -= 20;
            rect.bottom += 20;
            rect.left -= 20;
            rect.right += 20;
            TouchDelegate touchDelegate = new TouchDelegate(rect, this.contractInfo);
            View view = this.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.View");
            view.setTouchDelegate(touchDelegate);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            layoutParams2.setFullSpan(true);
            this.itemView.setLayoutParams(layoutParams2);
            ImageView imageView = this.girlBanner;
            com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
            imageView.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_feed_banner_girl.png", aVar.e()));
            LinearLayout linearLayout = this.startButton;
            final a aVar2 = this.M;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: be3.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.b.p(a.b.this, aVar2, view2);
                }
            });
            this.startButton.setOnTouchListener(new View.OnTouchListener() { // from class: be3.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean q16;
                    q16 = a.b.q(a.b.this, view2, motionEvent);
                    return q16;
                }
            });
            this.guildAvatars.setAnimateEnable(true);
            GuildMemberLoopView guildAvatars = this.guildAvatars;
            Intrinsics.checkNotNullExpressionValue(guildAvatars, "guildAvatars");
            GuildMemberLoopView.J(guildAvatars, aVar.a(5), false, 2, null);
            this.guildAvatars.setAvatarSize(50);
            new Bundle().putString("sgrp_stream_pgin_source_name", "functional_superqqshow_square");
            GuildMemberLoopView guildMemberLoopView = this.guildAvatars;
            final a aVar3 = this.M;
            guildMemberLoopView.setOnClickListener(new View.OnClickListener() { // from class: be3.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.b.r(a.this, this, view2);
                }
            });
            zd3.a aVar4 = this.dtReporter;
            if (aVar4 != null) {
                GuildMemberLoopView guildAvatars2 = this.guildAvatars;
                Intrinsics.checkNotNullExpressionValue(guildAvatars2, "guildAvatars");
                zd3.a.y(aVar4, guildAvatars2, "em_zplan_channel_entrance", null, null, 8, null);
            }
            zd3.a aVar5 = this.dtReporter;
            if (aVar5 != null) {
                LinearLayout startButton = this.startButton;
                Intrinsics.checkNotNullExpressionValue(startButton, "startButton");
                zd3.a.y(aVar5, startButton, "em_zplan_create_now", null, null, 8, null);
            }
            zd3.a aVar6 = this.dtReporter;
            if (aVar6 != null) {
                ImageView contractInfo = this.contractInfo;
                Intrinsics.checkNotNullExpressionValue(contractInfo, "contractInfo");
                zd3.a.y(aVar6, contractInfo, "em_zplan_create_convention", null, null, 8, null);
            }
        }
    }
}
