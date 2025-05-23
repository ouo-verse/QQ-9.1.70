package com.qzone.reborn.feedx.widget.dragon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonListBadgeInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadAppendDragonView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B\u0019\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadAppendDragonView;", "Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "Landroid/view/View$OnClickListener;", "", "w0", "", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "y0", "", "getLogTag", "", "getLayoutId", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "objData", c.G, "x0", "m0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "flAppendDragonContainer", "Landroidx/recyclerview/widget/RecyclerView;", h.F, "Landroidx/recyclerview/widget/RecyclerView;", "rvAppendDragonBadge", "Lqh/b;", "i", "Lqh/b;", "dragonBadgeAdapter", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isLoadAllBadgePicSuccess", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedHeadAppendDragonView extends QZoneFeedHeadBaseDragonView implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout flAppendDragonContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView rvAppendDragonBadge;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private qh.b dragonBadgeAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadAllBadgePicSuccess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadAppendDragonView$b", "Lqh/b$b;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements b.InterfaceC11076b {
        b() {
        }

        @Override // qh.b.InterfaceC11076b
        public void a() {
            QLog.i("QZoneFeedHeadAppendDragonView", 1, "[loadDragonPic] loadBadgePics all success");
            QZoneFeedHeadAppendDragonView.this.isLoadAllBadgePicSuccess = true;
            QZoneFeedHeadAppendDragonView.this.rvAppendDragonBadge.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedHeadAppendDragonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View findViewById = findViewById(R.id.myk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026_append_dragon_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.flAppendDragonContainer = frameLayout;
        frameLayout.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.myj);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ph.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z06;
                z06 = QZoneFeedHeadAppendDragonView.z0(QZoneFeedHeadAppendDragonView.this, view, motionEvent);
                return z06;
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<RecyclerVie\u2026          }\n            }");
        this.rvAppendDragonBadge = recyclerView;
    }

    private final List<FeedResourceInfo> y0() {
        List<FeedResourceInfo> list;
        ArrayList arrayList = new ArrayList();
        QZoneDragonListBadgeInfo listBadge = getData().getListBadge();
        if (listBadge != null && (list = listBadge.getList()) != null) {
            int i3 = 0;
            int i16 = 0;
            for (Object obj : list) {
                int i17 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                FeedResourceInfo feedResourceInfo = (FeedResourceInfo) obj;
                i16 += feedResourceInfo.getResWidthFromUrl();
                if (i16 > getLayoutParams().width) {
                    QLog.e("QZoneFeedHeadAppendDragonView", 1, "[getShowBadgePicList] over containerWidth index:" + i3);
                } else {
                    arrayList.add(feedResourceInfo);
                }
                i3 = i17;
            }
        }
        QLog.i("QZoneFeedHeadAppendDragonView", 1, "[getShowBadgePicList] size=" + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z0(QZoneFeedHeadAppendDragonView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this$0.flAppendDragonContainer.performClick();
        return false;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cdf;
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    protected String getLogTag() {
        return "QZoneFeedHeadAppendDragonView";
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    public String m0() {
        List<FeedResourceInfo> arrayList;
        qh.b bVar = this.dragonBadgeAdapter;
        if (bVar == null || (arrayList = bVar.j0()) == null) {
            arrayList = new ArrayList<>();
        }
        int i3 = 0;
        String str = "";
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String resourceId = ((FeedResourceInfo) obj).getResourceId();
            if (resourceId == null) {
                resourceId = "";
            }
            str = ((Object) str) + resourceId;
            if (i3 < arrayList.size() - 1) {
                str = ((Object) str) + ",";
            }
            i3 = i16;
        }
        return str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.myk) {
            QZoneDragonListBadgeInfo listBadge = getData().getListBadge();
            o0(listBadge != null ? listBadge.getJumpUrl() : null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneDragonUserInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        if (!objData.isValidListTypeResInfo()) {
            QLog.e("QZoneFeedHeadAppendDragonView", 1, "[bindData] dragonResInfo is no valid");
        } else {
            w0();
            r0();
        }
    }

    private final void w0() {
        this.isLoadAllBadgePicSuccess = false;
        this.rvAppendDragonBadge.setVisibility(4);
        if (this.dragonBadgeAdapter == null) {
            qh.b bVar = new qh.b();
            this.dragonBadgeAdapter = bVar;
            this.rvAppendDragonBadge.setAdapter(bVar);
        }
        List<FeedResourceInfo> y06 = y0();
        qh.b bVar2 = this.dragonBadgeAdapter;
        if (bVar2 != null) {
            bVar2.m0(y06, new b());
        }
    }
}
