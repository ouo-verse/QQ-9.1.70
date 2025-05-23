package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.block.r;
import com.qzone.reborn.feedx.viewmodel.t;
import com.qzone.util.ar;
import com.qzone.widget.recommendfriend.QZoneRecommendFriendView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.ProtoUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.troop.findtroop.TabRecommendPB$GetTabRecommendReq;
import tencent.im.troop.findtroop.TabRecommendPB$GetTabRecommendRsp;
import tencent.im.troop.findtroop.TabRecommendPB$Session;
import tencent.im.troop.findtroop.TabRecommendPB$TabRecommendResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0012\u0010(\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010)\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/feedx/block/r;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/reborn/feedx/viewmodel/t$c;", "Lgf/l;", "Lgp/a;", "", "args", "", "I9", "L9", "O9", "", "data", "J9", "", "H9", "Ltencent/im/troop/findtroop/TabRecommendPB$GetTabRecommendRsp;", "N9", "Ltencent/im/oidb/oidb_0xc26$MayKnowPerson;", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "Q9", "Lx6/a;", "", "M9", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "handleBroadcastMessage", "totalY", "onStart", "offset", "g0", "onEnd", "position", "m8", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "R7", "e3", "Lcom/qzone/widget/recommendfriend/QZoneRecommendFriendView;", "d", "Lcom/qzone/widget/recommendfriend/QZoneRecommendFriendView;", "recommendFriendView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recommendRV", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "f", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreen", tl.h.F, "Lx6/a;", "userInfoData", "i", "I", "recommendPosition", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "recommendData", "Lcom/qzone/reborn/feedx/viewmodel/t;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/viewmodel/t;", "forbiddenPageViewModel", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends com.qzone.reborn.base.k implements t.c, gf.l, gp.a {
    private static final int E = ar.e(102.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.t forbiddenPageViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneRecommendFriendView recommendFriendView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recommendRV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenFloatingView halfScreen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private x6.a userInfoData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int recommendPosition = -1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<MayKnowRecommend> recommendData = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/qzone/reborn/feedx/block/r$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", NodeProps.MIN_HEIGHT, "initState", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "", "d", "[Z", "canScroll", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean[] canScroll = new boolean[2];

        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            RecyclerView recyclerView = r.this.recommendRV;
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (r.this.recommendRV != null && linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() != 0) {
                    return true;
                }
                RecyclerView recyclerView2 = r.this.recommendRV;
                Intrinsics.checkNotNull(recyclerView2);
                View childAt = recyclerView2.getChildAt(0);
                this.canScroll[1] = childAt == null || childAt.getTop() != 0;
                return this.canScroll[1];
            }
            return super.canScrollDown(x16, y16);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            RecyclerView recyclerView = r.this.recommendRV;
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (r.this.recommendRV != null && linearLayoutManager != null) {
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                RecyclerView recyclerView2 = r.this.recommendRV;
                Intrinsics.checkNotNull(recyclerView2);
                boolean z16 = true;
                if (findLastVisibleItemPosition != recyclerView2.getChildCount() - 1) {
                    return true;
                }
                RecyclerView recyclerView3 = r.this.recommendRV;
                Intrinsics.checkNotNull(recyclerView3);
                RecyclerView recyclerView4 = r.this.recommendRV;
                Intrinsics.checkNotNull(recyclerView4);
                View childAt = recyclerView3.getChildAt(recyclerView4.getChildCount() - 1);
                boolean[] zArr = this.canScroll;
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    RecyclerView recyclerView5 = r.this.recommendRV;
                    Intrinsics.checkNotNull(recyclerView5);
                    if (bottom == recyclerView5.getHeight()) {
                        z16 = false;
                    }
                }
                zArr[0] = z16;
                return this.canScroll[0];
            }
            return super.canScrollUp(x16, y16);
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF52508d() {
            return r.this.recommendFriendView;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return r.E;
        }
    }

    private final int H9() {
        return ef.d.j(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_userhome_recommend_friend_min_size", "3"), 3);
    }

    private final void I9(Object args) {
        if (!(args instanceof x6.a)) {
            QLog.e("QZoneFeedxRecommendFriendPart", 1, "not BusinessUserInfoData");
            return;
        }
        x6.a aVar = (x6.a) args;
        this.userInfoData = aVar;
        if (!M9(aVar)) {
            L9();
        } else {
            O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(byte[] data) {
        Object obj;
        int collectionSizeOrDefault;
        if (data == null) {
            QLog.e("QZoneFeedxRecommendFriendPart", 1, "fetchRecommendDataRemote error. data is null. ");
            return;
        }
        TabRecommendPB$GetTabRecommendRsp N9 = N9(data);
        if (N9 == null) {
            QLog.e("QZoneFeedxRecommendFriendPart", 1, "fetchRecommendDataRemote error. data parse error. ");
            return;
        }
        List<TabRecommendPB$TabRecommendResult> list = N9.tab_recommend_result.get();
        Intrinsics.checkNotNullExpressionValue(list, "retData.tab_recommend_result.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            TabRecommendPB$TabRecommendResult tabRecommendPB$TabRecommendResult = (TabRecommendPB$TabRecommendResult) obj;
            if (tabRecommendPB$TabRecommendResult.type.get() == 2 && tabRecommendPB$TabRecommendResult.recommend_person.has()) {
                break;
            }
        }
        TabRecommendPB$TabRecommendResult tabRecommendPB$TabRecommendResult2 = (TabRecommendPB$TabRecommendResult) obj;
        if (tabRecommendPB$TabRecommendResult2 != null) {
            List<oidb_0xc26$MayKnowPerson> list2 = tabRecommendPB$TabRecommendResult2.recommend_person.get();
            Intrinsics.checkNotNullExpressionValue(list2, "personData.recommend_person.get()");
            List<oidb_0xc26$MayKnowPerson> list3 = list2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (oidb_0xc26$MayKnowPerson it5 : list3) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                MayKnowRecommend Q9 = Q9(it5);
                Intrinsics.checkNotNull(Q9);
                arrayList.add(Q9);
            }
            this.recommendData.clear();
            this.recommendData.addAll(arrayList);
            int H9 = H9();
            if (this.recommendData.size() < H9) {
                QLog.e("QZoneFeedxRecommendFriendPart", 1, "recommendData.size(" + this.recommendData.size() + ") < getLimitSize(" + H9 + ")");
                return;
            }
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.block.q
                @Override // java.lang.Runnable
                public final void run() {
                    r.K9(r.this);
                }
            });
            return;
        }
        this.recommendData.clear();
        QLog.w("QZoneFeedxRecommendFriendPart", 1, "fetchRecommendDataRemote error. data is empty. ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(r this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
    }

    private final void L9() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreen;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setVisibility(8);
        }
        com.qzone.reborn.feedx.viewmodel.t tVar = this.forbiddenPageViewModel;
        if (tVar != null) {
            tVar.B2();
        }
    }

    private final TabRecommendPB$GetTabRecommendRsp N9(byte[] data) {
        try {
            return new TabRecommendPB$GetTabRecommendRsp().mergeFrom(data);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZoneFeedxRecommendFriendPart", 1, e16, "parseTabRecommendRsp error.");
            return null;
        }
    }

    private final void O9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        TabRecommendPB$GetTabRecommendReq tabRecommendPB$GetTabRecommendReq = new TabRecommendPB$GetTabRecommendReq();
        tabRecommendPB$GetTabRecommendReq.tab.set(3);
        tabRecommendPB$GetTabRecommendReq.session_info.set(new TabRecommendPB$Session());
        tabRecommendPB$GetTabRecommendReq.source.set(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(3);
        tabRecommendPB$GetTabRecommendReq.filter_type.set(arrayList);
        ProtoUtils.a(peekAppRuntime, new b(), tabRecommendPB$GetTabRecommendReq.toByteArray(), "OidbSvcTrpcTcp.0x904d", 36941, 0);
    }

    private final void P9() {
        if (this.halfScreen == null) {
            this.halfScreen = new QUSHalfScreenFloatingView(getContext());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QZoneRecommendFriendView qZoneRecommendFriendView = new QZoneRecommendFriendView(context, null, 0, 6, null);
            this.recommendFriendView = qZoneRecommendFriendView;
            this.recommendRV = qZoneRecommendFriendView.f();
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreen;
            Intrinsics.checkNotNull(qUSHalfScreenFloatingView);
            qUSHalfScreenFloatingView.setQUSDragFloatController(new c());
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.halfScreen;
            Intrinsics.checkNotNull(qUSHalfScreenFloatingView2);
            qUSHalfScreenFloatingView2.x().setVisibility(8);
            View partRootView = getPartRootView();
            Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) partRootView).addView(this.halfScreen);
        }
        QZoneRecommendFriendView qZoneRecommendFriendView2 = this.recommendFriendView;
        if (qZoneRecommendFriendView2 != null) {
            qZoneRecommendFriendView2.a(this.recommendData);
        }
        com.qzone.reborn.feedx.viewmodel.t tVar = this.forbiddenPageViewModel;
        if (tVar != null) {
            tVar.J2(E, 500L);
        }
    }

    private final MayKnowRecommend Q9(oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson) {
        return MayKnowRecommend.convertServerDataToLocal((int) (System.currentTimeMillis() / 1000), 23, "", "", oidb_0xc26_mayknowperson);
    }

    @Override // gf.l
    public boolean R7() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreen;
        return qUSHalfScreenFloatingView != null && qUSHalfScreenFloatingView.z() == 2;
    }

    @Override // gf.l
    public void e3() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreen;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.O(0);
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void g0(int offset, int totalY) {
        View x16;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreen;
        if (qUSHalfScreenFloatingView == null || (x16 = qUSHalfScreenFloatingView.x()) == null) {
            return;
        }
        float f16 = offset;
        x16.setY(getPartRootView().getHeight() - f16);
        if (f16 / totalY > 0.0f) {
            x16.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals("user_home_business_info", action)) {
            I9(args);
        }
    }

    @Override // gp.a
    public void m8(int position) {
        this.recommendPosition = position;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.l.class);
        registerIoc(this, gp.a.class);
        com.qzone.reborn.feedx.viewmodel.t tVar = (com.qzone.reborn.feedx.viewmodel.t) getViewModel(com.qzone.reborn.feedx.viewmodel.t.class);
        this.forbiddenPageViewModel = tVar;
        if (tVar != null) {
            tVar.q2(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.recommendPosition = -1;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        int i3;
        super.onPartStop(activity);
        if (this.recommendFriendView == null || (i3 = this.recommendPosition) == -1) {
            return;
        }
        if (i3 < this.recommendData.size()) {
            this.recommendData.remove(this.recommendPosition);
        }
        QZoneRecommendFriendView qZoneRecommendFriendView = this.recommendFriendView;
        if (qZoneRecommendFriendView != null) {
            qZoneRecommendFriendView.a(this.recommendData);
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void onStart(int totalY) {
        View x16;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreen;
        if (qUSHalfScreenFloatingView == null || (x16 = qUSHalfScreenFloatingView.x()) == null) {
            return;
        }
        QLog.d("QZoneFeedxRecommendFriendPart", 1, "onStart");
        x16.setY(getPartRootView().getHeight());
        x16.setAlpha(0.0f);
        x16.setVisibility(0);
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public /* synthetic */ void s0() {
        com.qzone.reborn.feedx.viewmodel.u.a(this);
    }

    private final boolean M9(x6.a data) {
        if (data == null || !y6.b.f(data.uin) || !com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_blockedpagerecommend", null, 2, null)) {
            return false;
        }
        int i3 = data.relationShip;
        return i3 == 0 || i3 == 3 || i3 == 4 || i3 == 5;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedx/block/r$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(r this$0, byte[] bArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.J9(bArr);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZoneFeedxRecommendFriendPart", 1, "fetchRecommendDataRemote error. onError:" + errorCode + " ");
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, final byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final r rVar = r.this;
                rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.block.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.b.c(r.this, data);
                    }
                });
            } else {
                QLog.e("QZoneFeedxRecommendFriendPart", 1, "fetchRecommendDataRemote error. data is null. code: " + errorCode);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void onEnd() {
    }
}
