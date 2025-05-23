package com.qzone.reborn.intimate.part.albumlist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.o;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.intimate.event.QZoneIntimateRefreshAlbumTabEvent;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import nk.z;
import qj.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u001e\u0010\u0018\u001a\u00020\b2\u0014\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u001c\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014H\u0002J\u001c\u0010\u001b\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014H\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u001e\u0010\u001d\u001a\u00020\b2\u0014\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u001c\u0010,\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010.\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010/\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u00100\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\bH\u0016J\u0012\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070605H\u0016R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010=R\u0016\u0010A\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010W\u00a8\u0006_"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumlist/e;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lqj/b;", "Lqj/c;", "Lqj/m;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "S9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "T9", "initViewModel", "J9", "X9", "P9", "K9", "e", "V9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "listUIStateData", "L9", "Z9", "aa", "M9", "I9", "N9", "Y9", "W9", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lnk/z;", "J7", "W7", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "fa", "W5", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "d", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "f", "Lnk/z;", "mAlbumViewModel", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Li9/b;", "i", "Li9/b;", "mAlbumListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/block/aa;", "mLoadMoreAdapter", "Lgj/g;", BdhLogUtil.LogTag.Tag_Conn, "Lgj/g;", "mAlbumHeaderAdapter", "Lba/o;", "D", "Lba/o;", "mRecyclerViewDecoration", "E", "Z", "mIsSetupItemDecoration", UserInfo.SEX_FEMALE, "mIsAddHeadView", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, qj.b, qj.c, m, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private gj.g mAlbumHeaderAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private o mRecyclerViewDecoration;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsSetupItemDecoration;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsAddHeadView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private z mAlbumViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private i9.b mAlbumListAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private aa mLoadMoreAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/albumlist/e$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SafeGridLayoutManager f57373b;

        b(SafeGridLayoutManager safeGridLayoutManager) {
            this.f57373b = safeGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            i9.b bVar = e.this.mAlbumListAdapter;
            i9.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
                bVar = null;
            }
            if (bVar.getItems().size() > 0) {
                if (position == 0 && e.this.mIsAddHeadView) {
                    return 2;
                }
                i9.b bVar3 = e.this.mAlbumListAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
                } else {
                    bVar2 = bVar3;
                }
                return position == bVar2.getNUM_BACKGOURND_ICON() + (e.this.mIsAddHeadView ? 1 : 0) ? 2 : 1;
            }
            return this.f57373b.getSpanCount();
        }
    }

    private final void I9() {
        z zVar = this.mAlbumViewModel;
        gj.g gVar = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (zVar.Z1() && !this.mIsAddHeadView) {
            this.mIsAddHeadView = true;
            RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
            if (rFWConcatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter = null;
            }
            gj.g gVar2 = this.mAlbumHeaderAdapter;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumHeaderAdapter");
                gVar2 = null;
            }
            rFWConcatAdapter.addAdapter(0, gVar2);
            gj.g gVar3 = this.mAlbumHeaderAdapter;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumHeaderAdapter");
            } else {
                gVar = gVar3;
            }
            CommonAlbumListBean commonAlbumListBean = new CommonAlbumListBean(new CommonAlbumInfo());
            commonAlbumListBean.setItemType(1);
            gVar.k0(commonAlbumListBean);
            return;
        }
        QLog.e("QZoneIntimateSpaceAlbumBlockPart", 1, "[addAlbumHeadView] is hide headview");
    }

    private final void J9() {
        this.mAlbumHeaderAdapter = new gj.g();
        this.mAlbumListAdapter = new i9.b();
        aa aaVar = new aa();
        this.mLoadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        aa aaVar2 = this.mLoadMoreAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.v1u)).f(HardCodeUtil.qqStr(R.string.v3z)));
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.setHasStableIds(true);
        aa aaVar3 = this.mLoadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        i9.b bVar2 = this.mAlbumListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar2 = null;
        }
        adapterArr[0] = bVar2;
        aa aaVar4 = this.mLoadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[1] = aaVar4;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        X9();
    }

    private final void K9() {
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        QZoneBlankStateView qZoneBlankStateView2 = null;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        ViewGroup.LayoutParams layoutParams = qZoneBlankStateView.getLayoutParams();
        if (layoutParams != null) {
            QZoneBlankStateView qZoneBlankStateView3 = this.mBlankView;
            if (qZoneBlankStateView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
                qZoneBlankStateView3 = null;
            }
            layoutParams.height = QZoneFeedxViewUtils.f(qZoneBlankStateView3);
            QZoneBlankStateView qZoneBlankStateView4 = this.mBlankView;
            if (qZoneBlankStateView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            } else {
                qZoneBlankStateView2 = qZoneBlankStateView4;
            }
            qZoneBlankStateView2.setLayoutParams(layoutParams);
        }
    }

    private final void M9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.setItems(new ArrayList(listUIStateData.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void P9() {
        K9();
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        z zVar = null;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        Context context = getContext();
        z zVar2 = this.mAlbumViewModel;
        if (zVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar2 = null;
        }
        boolean z16 = !zVar2.c2();
        z zVar3 = this.mAlbumViewModel;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            zVar = zVar3;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.f(context, z16, zVar.a2(), new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.albumlist.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.Q9(e.this, view);
            }
        }, new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.albumlist.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.R9(e.this, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S9() {
        registerIoc(this, qj.b.class);
        registerIoc(this, qj.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(e this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9(uIStateData);
    }

    private final void V9() {
        qj.g gVar = (qj.g) getIocInterface(qj.g.class);
        if (gVar != null) {
            gVar.E2(true);
        }
        W7();
    }

    private final void W9() {
        boolean contains$default;
        if (this.mIsAddHeadView) {
            StringBuilder sb5 = new StringBuilder();
            com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
            String u16 = gVar.h().u();
            if (!TextUtils.isEmpty(u16)) {
                sb5.append(u16);
                sb5.append(",");
            }
            z zVar = this.mAlbumViewModel;
            z zVar2 = null;
            if (zVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar = null;
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) u16, (CharSequence) zVar.getMSpaceId(), false, 2, (Object) null);
            if (!contains$default) {
                z zVar3 = this.mAlbumViewModel;
                if (zVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    zVar3 = null;
                }
                if (!TextUtils.isEmpty(zVar3.getMSpaceId())) {
                    z zVar4 = this.mAlbumViewModel;
                    if (zVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    } else {
                        zVar2 = zVar4;
                    }
                    sb5.append(zVar2.getMSpaceId());
                }
            }
            com.qzone.reborn.configx.h h16 = gVar.h();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            h16.G(sb6);
        }
    }

    private final void X9() {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        if (recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager");
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) layoutManager;
            safeGridLayoutManager.setSpanSizeLookup(new b(safeGridLayoutManager));
        }
    }

    private final void Y9() {
        if (this.mIsSetupItemDecoration || getActivity() == null) {
            return;
        }
        this.mIsSetupItemDecoration = true;
        z zVar = this.mAlbumViewModel;
        RecyclerView recyclerView = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        this.mRecyclerViewDecoration = new o(zVar.Z1());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        o oVar = this.mRecyclerViewDecoration;
        Intrinsics.checkNotNull(oVar);
        recyclerView.addItemDecoration(oVar);
    }

    private final void Z9() {
        P9();
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void aa(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        P9();
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.showErrorView();
    }

    private final void e() {
        qj.f fVar = (qj.f) getIocInterface(qj.f.class);
        if (fVar != null) {
            fVar.e();
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(z.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026istViewModel::class.java)");
        z zVar = (z) viewModel;
        this.mAlbumViewModel = zVar;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        zVar.S1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumlist.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.U9(e.this, (UIStateData) obj);
            }
        });
        z zVar3 = this.mAlbumViewModel;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            zVar2 = zVar3;
        }
        zVar2.f2(false);
    }

    @Override // qj.c
    public z J7() {
        z zVar = this.mAlbumViewModel;
        if (zVar != null) {
            return zVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        return null;
    }

    @Override // qj.m
    public void W5() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    @Override // qj.m
    public boolean fa() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        return !ah.b(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        S9();
        T9(rootView);
        initViewModel();
        J9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        z zVar = this.mAlbumViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        zVar.f2(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.l0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.onResume();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.onStop();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateRefreshAlbumTabEvent) {
            z zVar = this.mAlbumViewModel;
            if (zVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar = null;
            }
            zVar.f2(false);
        }
    }

    @Override // qj.b
    public void W7() {
        boolean contains;
        this.mIsAddHeadView = false;
        z zVar = this.mAlbumViewModel;
        gj.g gVar = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        zVar.k2(false);
        o oVar = this.mRecyclerViewDecoration;
        if (oVar != null) {
            oVar.a(false);
        }
        RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
            rFWConcatAdapter = null;
        }
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = rFWConcatAdapter.getAdapters();
        Intrinsics.checkNotNullExpressionValue(adapters, "mConcatAdapter.adapters");
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list = adapters;
        gj.g gVar2 = this.mAlbumHeaderAdapter;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumHeaderAdapter");
            gVar2 = null;
        }
        contains = CollectionsKt___CollectionsKt.contains(list, gVar2);
        if (contains) {
            RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
            if (rFWConcatAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter2 = null;
            }
            gj.g gVar3 = this.mAlbumHeaderAdapter;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumHeaderAdapter");
            } else {
                gVar = gVar3;
            }
            rFWConcatAdapter2.removeAdapter(gVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateRefreshAlbumTabEvent.class);
        return arrayListOf;
    }

    private final void L9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            Z9();
        } else if (state == 2 || state == 3) {
            N9(listUIStateData);
        } else if (state == 4) {
            aa(listUIStateData);
        } else if (state == 6 || state == 7) {
            M9(listUIStateData);
        }
        aa aaVar = this.mLoadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar = null;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void N9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("QZoneIntimateSpaceAlbumBlockPart", 1, "ui state data is null");
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        i9.b bVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        I9();
        i9.b bVar2 = this.mAlbumListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
        } else {
            bVar = bVar2;
        }
        bVar.setItems(new ArrayList(listUIStateData.getData()));
        if (!listUIStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.albumlist.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.O9(e.this);
                }
            }, 100L);
        }
        Y9();
        W9();
    }

    private final void T9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.mBlankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.nf9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rv_intimate_album_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.mRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(true);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new SafeGridLayoutManager(getContext(), 2));
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView2.setItemAnimator(defaultItemAnimator);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
