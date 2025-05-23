package com.qzone.reborn.feedx.widget.dragon;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.bean.QZoneDragonThreeLayerBadgeInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadComposeDragonView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qh.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0019\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010(\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadComposeDragonView;", "Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "Landroid/view/View$OnClickListener;", "", "H0", "B0", "D0", "A0", "", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "G0", "I0", "", "getLogTag", "", "getLayoutId", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "objData", com.tencent.luggage.wxa.c8.c.G, "F0", "m0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "flComposeDragonContainer", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "ivComposeBottomBg", "i", "ivComposeTopBg", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "rvComposeDragonBadge", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isLoadBottomPicSuccess", "D", "isLoadTopPicSuccess", "E", "isLoadAllBadgePicSuccess", "", UserInfo.SEX_FEMALE, "badgeStackAreaWidth", "Lqh/b;", "G", "Lqh/b;", "dragonBadgeAdapter", "H", "isSetItemDecoration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedHeadComposeDragonView extends QZoneFeedHeadBaseDragonView implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLoadBottomPicSuccess;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLoadTopPicSuccess;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isLoadAllBadgePicSuccess;

    /* renamed from: F, reason: from kotlin metadata */
    private final float badgeStackAreaWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private qh.b dragonBadgeAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isSetItemDecoration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout flComposeDragonContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivComposeBottomBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivComposeTopBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView rvComposeDragonBadge;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadComposeDragonView$b", "Lqh/b$b;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements b.InterfaceC11076b {
        b() {
        }

        @Override // qh.b.InterfaceC11076b
        public void a() {
            QLog.i("QZoneFeedHeadComposeDragonView", 4, "[loadDragonPic] loadBadgePics all success");
            QZoneFeedHeadComposeDragonView.this.isLoadAllBadgePicSuccess = true;
            QZoneFeedHeadComposeDragonView.this.I0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadComposeDragonView$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.left = -ar.d(QZoneFeedHeadComposeDragonView.this.badgeStackAreaWidth);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedHeadComposeDragonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.badgeStackAreaWidth = g.f53821a.b().F0();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View findViewById = findViewById(R.id.myw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026compose_dragon_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.flComposeDragonContainer = frameLayout;
        View findViewById2 = findViewById(R.id.myv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_\u2026compose_dragon_bottom_bg)");
        ImageView imageView = (ImageView) findViewById2;
        this.ivComposeBottomBg = imageView;
        View findViewById3 = findViewById(R.id.myx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_\u2026dx_compose_dragon_top_bg)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.ivComposeTopBg = imageView2;
        View findViewById4 = findViewById(R.id.myu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026_compose_dragon_badge_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.rvComposeDragonBadge = recyclerView;
        frameLayout.setOnClickListener(this);
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ph.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w06;
                w06 = QZoneFeedHeadComposeDragonView.w0(QZoneFeedHeadComposeDragonView.this, view, motionEvent);
                return w06;
            }
        });
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        H0();
    }

    private final void B0() {
        this.ivComposeBottomBg.setVisibility(4);
        this.isLoadBottomPicSuccess = false;
        QZoneDragonThreeLayerBadgeInfo threeLayerBadge = getData().getThreeLayerBadge();
        p0(this.ivComposeBottomBg, threeLayerBadge != null ? threeLayerBadge.getBottom() : null, new IPicLoadStateListener() { // from class: ph.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedHeadComposeDragonView.C0(QZoneFeedHeadComposeDragonView.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QZoneFeedHeadComposeDragonView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null) {
            this$0.isLoadBottomPicSuccess = true;
            this$0.I0();
        } else {
            QLog.e("QZoneFeedHeadComposeDragonView", 4, "[loadBottomImage] loadImage fail:" + loadState);
        }
    }

    private final void D0() {
        this.ivComposeTopBg.setVisibility(4);
        this.isLoadTopPicSuccess = false;
        QZoneDragonThreeLayerBadgeInfo threeLayerBadge = getData().getThreeLayerBadge();
        p0(this.ivComposeTopBg, threeLayerBadge != null ? threeLayerBadge.getTop() : null, new IPicLoadStateListener() { // from class: ph.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedHeadComposeDragonView.E0(QZoneFeedHeadComposeDragonView.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(QZoneFeedHeadComposeDragonView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null) {
            this$0.isLoadTopPicSuccess = true;
            this$0.I0();
        } else {
            QLog.e("QZoneFeedHeadComposeDragonView", 4, "[loadTopImage] loadImage fail:" + loadState);
        }
    }

    private final List<FeedResourceInfo> G0() {
        List<FeedResourceInfo> middle;
        ArrayList arrayList = new ArrayList();
        ViewGroup.LayoutParams layoutParams = this.rvComposeDragonBadge.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i3 = 0;
        int i16 = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
        QZoneDragonThreeLayerBadgeInfo threeLayerBadge = getData().getThreeLayerBadge();
        if (threeLayerBadge != null && (middle = threeLayerBadge.getMiddle()) != null) {
            int i17 = 0;
            for (Object obj : middle) {
                int i18 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                FeedResourceInfo feedResourceInfo = (FeedResourceInfo) obj;
                int resWidthFromUrl = feedResourceInfo.getResWidthFromUrl();
                if (i3 != 0) {
                    resWidthFromUrl -= ar.d(this.badgeStackAreaWidth);
                }
                i17 += resWidthFromUrl;
                if (i17 + i16 > getLayoutParams().width) {
                    QLog.e("QZoneFeedHeadComposeDragonView", 1, "[getShowBadgePicList] over containerWidth index:" + i3);
                } else {
                    arrayList.add(feedResourceInfo);
                }
                i3 = i18;
            }
        }
        QLog.i("QZoneFeedHeadComposeDragonView", 4, "[getShowBadgePicList] size=" + arrayList.size());
        return arrayList;
    }

    private final void H0() {
        RecyclerView recyclerView = this.rvComposeDragonBadge;
        recyclerView.setAdapter(this.dragonBadgeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = ar.d(g.f53821a.b().G0());
        }
        if (this.isSetItemDecoration) {
            return;
        }
        this.isSetItemDecoration = true;
        recyclerView.addItemDecoration(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        FeedResourceInfo top;
        if (this.isLoadBottomPicSuccess) {
            QZoneDragonThreeLayerBadgeInfo threeLayerBadge = getData().getThreeLayerBadge();
            String sourceMaterialUrl = (threeLayerBadge == null || (top = threeLayerBadge.getTop()) == null) ? null : top.getSourceMaterialUrl();
            QZoneDragonThreeLayerBadgeInfo threeLayerBadge2 = getData().getThreeLayerBadge();
            boolean z16 = bl.b(threeLayerBadge2 != null ? threeLayerBadge2.getMiddle() : null) && TextUtils.isEmpty(sourceMaterialUrl);
            QLog.i("QZoneFeedHeadComposeDragonView", 4, "[showFullDragonPicView] loadBottomPic success, isOnlyBottomData:" + z16);
            if (z16) {
                this.ivComposeBottomBg.setVisibility(0);
                return;
            }
            if (this.isLoadTopPicSuccess || TextUtils.isEmpty(sourceMaterialUrl)) {
                QLog.i("QZoneFeedHeadComposeDragonView", 4, "[showFullDragonPicView] loadTopPic success");
                if (this.isLoadAllBadgePicSuccess) {
                    this.ivComposeTopBg.setVisibility(0);
                    this.ivComposeBottomBg.setVisibility(0);
                    this.rvComposeDragonBadge.setVisibility(0);
                }
                QLog.i("QZoneFeedHeadComposeDragonView", 4, "[showFullDragonPicView] loadBadgePic:" + this.isLoadAllBadgePicSuccess);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w0(QZoneFeedHeadComposeDragonView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this$0.flComposeDragonContainer.performClick();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneDragonUserInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        if (objData.isValidThreeLayerResInfo()) {
            B0();
            A0();
            D0();
            r0();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cdg;
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    protected String getLogTag() {
        return "QZoneFeedHeadComposeDragonView";
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    public String m0() {
        List<FeedResourceInfo> arrayList;
        String str;
        String str2;
        String str3;
        FeedResourceInfo top;
        FeedResourceInfo bottom;
        qh.b bVar = this.dragonBadgeAdapter;
        if (bVar == null || (arrayList = bVar.j0()) == null) {
            arrayList = new ArrayList<>();
        }
        QZoneDragonThreeLayerBadgeInfo threeLayerBadge = getData().getThreeLayerBadge();
        if (threeLayerBadge == null || (bottom = threeLayerBadge.getBottom()) == null || (str = bottom.getResourceId()) == null) {
            str = "";
        }
        QZoneDragonThreeLayerBadgeInfo threeLayerBadge2 = getData().getThreeLayerBadge();
        if (threeLayerBadge2 == null || (top = threeLayerBadge2.getTop()) == null || (str2 = top.getResourceId()) == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = ((Object) "") + str + ",";
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = ((Object) str3) + str2 + ",";
        }
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String resourceId = ((FeedResourceInfo) obj).getResourceId();
            if (resourceId == null) {
                resourceId = "";
            }
            str3 = ((Object) str3) + resourceId;
            if (i3 < arrayList.size() - 1) {
                str3 = ((Object) str3) + ",";
            }
            i3 = i16;
        }
        return str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.myw) {
            QZoneDragonThreeLayerBadgeInfo threeLayerBadge = getData().getThreeLayerBadge();
            o0(threeLayerBadge != null ? threeLayerBadge.getJumpUrl() : null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void A0() {
        this.isLoadAllBadgePicSuccess = false;
        this.rvComposeDragonBadge.setVisibility(4);
        if (this.dragonBadgeAdapter == null) {
            qh.b bVar = new qh.b();
            this.dragonBadgeAdapter = bVar;
            this.rvComposeDragonBadge.setAdapter(bVar);
        }
        List<FeedResourceInfo> G0 = G0();
        qh.b bVar2 = this.dragonBadgeAdapter;
        if (bVar2 != null) {
            bVar2.m0(G0, new b());
        }
    }
}
