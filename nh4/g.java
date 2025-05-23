package nh4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.expand.hall.impl.mic.view.MicApplyListItemView;
import com.tencent.timi.game.ui.widget.k;
import com.tencent.timi.game.ui.widget.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$ApplyUser;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003LMNB\u0017\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0018\u0010!\u001a\u00060\u001eR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0016\u0010?\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00106R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006O"}, d2 = {"Lnh4/g;", "Lcom/tencent/timi/game/ui/widget/l;", "Lcom/tencent/timi/game/ui/widget/k;", "Lqh4/a;", "", "C0", "J0", "D0", "", "doNotify", "H0", "E0", "Landroid/view/View;", "e0", "Y", "hideLoadingView", "", "text", "K", "dismiss", "Ltrpc/yes/common/YoloRoomOuterClass$ApplyUser;", "data", HippyTKDListViewAdapter.X, "Lph4/f;", "J", "Lph4/f;", "mRepo", "", "Ljava/util/List;", "mListData", "Lnh4/g$b;", "L", "Lnh4/g$b;", "mAdapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "M", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLayoutManager", "N", "Landroid/view/View;", "mRootView", "Landroidx/lifecycle/Observer;", "", "P", "Landroidx/lifecycle/Observer;", "mDataObserver", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "shadowView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "closeIconIgv", "Landroid/widget/LinearLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/LinearLayout;", "contentRootView", "Landroidx/recyclerview/widget/RecyclerView;", "T", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "U", "clearArea", "V", "emptyView", "Lcom/tencent/image/URLImageView;", "W", "Lcom/tencent/image/URLImageView;", "emptyHintIgv", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "X", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "loadingView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lph4/f;)V", "b", "c", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g extends l implements k, qh4.a {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ph4.f mRepo;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final List<YoloRoomOuterClass$ApplyUser> mListData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final b mAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LinearLayoutManager mLayoutManager;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<YoloRoomOuterClass$ApplyUser>> mDataObserver;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private View shadowView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private ImageView closeIconIgv;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private LinearLayout contentRootView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private LinearLayout clearArea;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private LinearLayout emptyView;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private URLImageView emptyHintIgv;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private TimiGamePageLoadingView loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"nh4/g$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.timi.game.utils.l.b("MicApplyListDialog_", "onScrollStateChanged newState=" + newState);
            if (newState == 0) {
                int findLastVisibleItemPosition = g.this.mLayoutManager.findLastVisibleItemPosition();
                com.tencent.timi.game.utils.l.h("MicApplyListDialog_", 1, "onScrollStateChanged lastVisibleItemIndex:" + findLastVisibleItemPosition + ", itemCount:" + g.this.mAdapter.getNUM_BACKGOURND_ICON());
                if (findLastVisibleItemPosition + 1 >= g.this.mAdapter.getNUM_BACKGOURND_ICON()) {
                    g.this.J0();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.timi.game.utils.l.b("MicApplyListDialog_", "onScrolled dx:" + dx5 + ", dy=" + dy5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"Lnh4/g$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lnh4/g$d;", "Landroid/view/ViewGroup;", "viewGroup", "", com.tencent.luggage.wxa.c8.c.G, "j0", "vh", "", "i0", "getItemCount", "<init>", "(Lnh4/g;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class b extends RecyclerView.Adapter<d> {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return g.this.mListData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d vh5, int pos) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            vh5.getView().k(pos, g.this.mRepo.getMRoomId(), (YoloRoomOuterClass$ApplyUser) g.this.mListData.get(pos));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup viewGroup, int pos) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Context context = ((com.tencent.timi.game.ui.widget.b) g.this).G;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            MicApplyListItemView micApplyListItemView = new MicApplyListItemView(context, null, 0, 6, null);
            micApplyListItemView.h(g.this);
            micApplyListItemView.setApplyListOp(g.this);
            return new d(micApplyListItemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lnh4/g$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView;", "E", "Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView;", "l", "()Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView;", "view", "<init>", "(Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final MicApplyListItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull MicApplyListItemView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final MicApplyListItemView getView() {
            return this.view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"nh4/g$e", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> {
        e() {
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            QQToast.makeText(((com.tencent.timi.game.ui.widget.b) g.this).G, timiDisplayErrMsg, 0).show();
            wf4.a.f445618a.b(g.this);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            wf4.a.f445618a.b(g.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context, @NotNull ph4.f mRepo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mRepo, "mRepo");
        this.mRepo = mRepo;
        ArrayList arrayList = new ArrayList();
        this.mListData = arrayList;
        b bVar = new b();
        this.mAdapter = bVar;
        View inflate = View.inflate(context, R.layout.hvh, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026_apply_list_dialog, null)");
        this.mRootView = inflate;
        Observer<List<YoloRoomOuterClass$ApplyUser>> observer = new Observer() { // from class: nh4.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.F0(g.this, (List) obj);
            }
        };
        this.mDataObserver = observer;
        setContentView(inflate);
        View findViewById = findViewById(R.id.f84014l4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.shadowView)");
        this.shadowView = findViewById;
        View findViewById2 = findViewById(R.id.tza);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.closeIconIgv)");
        this.closeIconIgv = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.u7v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.contentRootView)");
        this.contentRootView = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.i4l);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.recyclerView)");
        this.recyclerView = (RecyclerView) findViewById4;
        View findViewById5 = findViewById(R.id.txg);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.clearArea)");
        this.clearArea = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.f165089bw3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.emptyView)");
        this.emptyView = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.uty);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.emptyHintIgv)");
        this.emptyHintIgv = (URLImageView) findViewById7;
        View findViewById8 = findViewById(R.id.ef6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.loadingView)");
        this.loadingView = (TimiGamePageLoadingView) findViewById8;
        this.shadowView.setOnClickListener(new View.OnClickListener() { // from class: nh4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p0(g.this, view);
            }
        });
        this.contentRootView.setOnClickListener(new View.OnClickListener() { // from class: nh4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.q0(view);
            }
        });
        this.closeIconIgv.setOnClickListener(new View.OnClickListener() { // from class: nh4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.r0(g.this, view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.mLayoutManager = linearLayoutManager;
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(bVar);
        this.recyclerView.setOverScrollMode(2);
        LiveData<List<YoloRoomOuterClass$ApplyUser>> d16 = mRepo.d();
        arrayList.clear();
        List<YoloRoomOuterClass$ApplyUser> value = d16.getValue();
        if (value != null) {
            arrayList.addAll(value);
            I0(this, false, 1, null);
        }
        d16.observeForever(observer);
        this.closeIconIgv.setOnClickListener(new View.OnClickListener() { // from class: nh4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.s0(g.this, view);
            }
        });
        this.clearArea.setOnClickListener(new View.OnClickListener() { // from class: nh4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.u0(g.this, view);
            }
        });
        this.recyclerView.addOnScrollListener(new a());
        C0();
    }

    private final void C0() {
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return;
        }
        gh4.d m06 = I0.m0();
        HashMap<String, String> E = m06.E();
        ((ug4.b) mm4.b.b(ug4.b.class)).b(this.mRootView, m06.C(), m06.D());
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, this.clearArea, false, null, m06.q(), E, 6, null);
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b17, this.closeIconIgv, false, null, m06.r(), E, 6, null);
    }

    private final void D0() {
        Object lastOrNull;
        Object obj;
        PBUInt64Field pBUInt64Field;
        wf4.a.f445618a.e(this);
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.mListData);
        YoloRoomOuterClass$ApplyUser yoloRoomOuterClass$ApplyUser = (YoloRoomOuterClass$ApplyUser) lastOrNull;
        if (yoloRoomOuterClass$ApplyUser != null && (pBUInt64Field = yoloRoomOuterClass$ApplyUser.apply_time_ms) != null) {
            obj = Long.valueOf(pBUInt64Field.get());
        } else {
            obj = "null";
        }
        com.tencent.timi.game.utils.l.a("MicApplyListDialog_", 1, "lastData time:" + obj);
        if (yoloRoomOuterClass$ApplyUser != null) {
            ph4.e.f426246a.Q(yoloRoomOuterClass$ApplyUser.apply_time_ms.get());
        }
        this.mRepo.f(new e());
    }

    private final void E0() {
        Drawable drawable = this.emptyHintIgv.getDrawable();
        URLImageView uRLImageView = this.emptyHintIgv;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026able = drawable\n        }");
        com.tencent.timi.game.utils.b.g(uRLImageView, "https://cdn.yes.qq.com/client_business/qq/fck_hall_mic_req_list_empty@3x.png", obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(g this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mListData.clear();
        List<YoloRoomOuterClass$ApplyUser> list = this$0.mListData;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        list.addAll(it);
        I0(this$0, false, 1, null);
    }

    private final void H0(boolean doNotify) {
        if (this.mListData.size() == 0) {
            E0();
            this.emptyView.setVisibility(0);
            this.recyclerView.setVisibility(4);
        } else {
            this.emptyView.setVisibility(4);
            this.recyclerView.setVisibility(0);
        }
        if (doNotify) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void I0(g gVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        gVar.H0(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0() {
        this.mRepo.g(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeIconIgv.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("MicApplyListDialog_", "donothing");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D0();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.loadingView.setHintText(text);
        this.loadingView.d();
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    public View Y() {
        return this.contentRootView;
    }

    @Override // com.tencent.timi.game.ui.widget.l, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.mRepo.d().removeObserver(this.mDataObserver);
        super.dismiss();
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    /* renamed from: e0, reason: from getter */
    public View getShadowView() {
        return this.shadowView;
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        this.loadingView.setVisibility(8);
    }

    @Override // qh4.a
    public void x(@NotNull YoloRoomOuterClass$ApplyUser data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int indexOf = this.mListData.indexOf(data);
        if (indexOf < 0) {
            return;
        }
        this.mListData.remove(indexOf);
        this.mAdapter.notifyItemRemoved(indexOf);
        H0(false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"nh4/g$f", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> {
        f() {
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            QQToast.makeText(((com.tencent.timi.game.ui.widget.b) g.this).G, timiDisplayErrMsg, 0).show();
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
        }
    }
}
