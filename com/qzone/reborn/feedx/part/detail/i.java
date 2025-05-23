package com.qzone.reborn.feedx.part.detail;

import ELABORATE_FEED_REPORT.SingleExposeInfo;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedx.event.QZoneFeedxDetailAnimEvent;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i extends com.qzone.reborn.base.c implements SimpleEventReceiver<QZoneFeedxDetailAnimEvent> {
    private boolean C;
    private boolean D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.h f55172d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55173e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.j f55174f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.g f55175h;

    /* renamed from: i, reason: collision with root package name */
    private BusinessFeedData f55176i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.k f55177m;

    public i(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        this.C = false;
        this.D = false;
        this.E = false;
        for (MultiViewBlock multiViewBlock : list) {
            if (multiViewBlock instanceof com.qzone.reborn.feedx.block.h) {
                this.f55172d = (com.qzone.reborn.feedx.block.h) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.j) {
                this.f55174f = (com.qzone.reborn.feedx.block.j) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.g) {
                this.f55175h = (com.qzone.reborn.feedx.block.g) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.k) {
                this.f55177m = (com.qzone.reborn.feedx.block.k) multiViewBlock;
            }
        }
    }

    private void D9(QZoneFeedxDetailAnimEvent qZoneFeedxDetailAnimEvent) {
        boolean isAnimPlaying = qZoneFeedxDetailAnimEvent.getIsAnimPlaying();
        this.E = isAnimPlaying;
        if (isAnimPlaying || !this.D) {
            return;
        }
        G9(this.f55173e.X1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(UIStateData<com.qzone.reborn.feedx.bean.a> uIStateData) {
        QLog.i("QZoneFeedxDetailBlockPart", 1, "handleDetailMoreCommentRsp() commentUIStateData = " + uIStateData);
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 3) {
            if (uIStateData.getData() != null && uIStateData.getData().b() != null) {
                this.f55176i.setCommentInfo(uIStateData.getData().b());
            } else if (uIStateData.getData() != null && uIStateData.getData().a() != null) {
                this.f55176i.setCommentEssence(uIStateData.getData().a());
            }
            O9(this.f55176i);
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailMoreCommentRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
        this.f55174f.notifyLoadingComplete(false);
    }

    private void G9(BusinessFeedData businessFeedData) {
        this.f55176i = businessFeedData;
        this.f55172d.getDataList().clear();
        this.f55172d.getDataList().add(businessFeedData);
        O9(businessFeedData);
        com.qzone.reborn.feedx.block.g gVar = this.f55175h;
        if (gVar != null) {
            gVar.l0(businessFeedData);
        }
        L9();
        this.D = false;
    }

    private void H9() {
        this.f55172d.clearData();
        this.f55174f.clearData();
        if (this.f55175h != null) {
            QLog.i("QZoneFeedxDetailBlockPart", 1, "hideAdViewBlock");
            this.f55175h.setBlockVisible(false);
        }
        L9();
    }

    private void I9() {
        this.mBlockContainer.getBlockMerger().setNoMoreHint(HardCodeUtil.qqStr(R.string.mdt));
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(101, 10);
        recycledViewPool.setMaxRecycledViews(102, 10);
        this.mBlockContainer.getRecyclerView().setRecycledViewPool(recycledViewPool);
        this.f55173e.C.observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.detail.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.this.E9((UIStateData) obj);
            }
        });
        this.f55174f.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.qzone.reborn.feedx.part.detail.h
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                i.this.J9(loadInfo, obj);
            }
        });
        com.qzone.reborn.feedx.util.v.a(this.mBlockContainer.getRecyclerView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(LoadInfo loadInfo, Object obj) {
        if (loadInfo.isFinish()) {
            return;
        }
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        this.f55173e.D2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(UIStateData uIStateData) {
        if (this.f55172d != null) {
            F9(uIStateData);
        }
    }

    private void L9() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getBlockMerger() == null) {
            return;
        }
        this.mBlockContainer.getBlockMerger().notifyDataSetChanged();
    }

    private void M9(UIStateData<BusinessFeedData> uIStateData) {
        QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
        this.f55172d.notifyLoadingComplete(false);
        if (uIStateData.getRetCode() == -4404) {
            this.f55177m.setBlockVisible(true);
            this.f55177m.l0(true, com.qzone.reborn.feedx.util.k.a(HardCodeUtil.qqStr(R.string.jmr)));
            H9();
        } else if (uIStateData.getRetCode() != -10650 && uIStateData.getRetCode() != -4403) {
            if (TextUtils.isEmpty(uIStateData.getMsg())) {
                return;
            }
            ToastUtil.s(uIStateData.getMsg(), 1);
        } else {
            this.f55177m.setBlockVisible(true);
            this.f55177m.l0(true, com.qzone.reborn.feedx.util.k.a(QzoneConfig.DefaultValue.DEFAULT_MEMORY_DEFAUL_TEXT));
            H9();
        }
    }

    private void N9() {
        BusinessFeedData businessFeedData = this.f55176i;
        if (businessFeedData == null || businessFeedData.getOperationInfoV2() == null) {
            return;
        }
        SingleExposeInfo singleExposeInfo = new SingleExposeInfo();
        singleExposeInfo.mapFeedCookie = this.f55176i.getOperationInfoV2().feedReportCookie;
        singleExposeInfo.exposeTime = System.currentTimeMillis();
        com.qzone.misc.network.ttt.h.g().b(new ArrayList<>(Collections.singleton(singleExposeInfo)));
    }

    private void O9(BusinessFeedData businessFeedData) {
        List<pg.a> b16 = com.qzone.reborn.feedx.util.u.b(businessFeedData);
        this.f55174f.getDataList().clear();
        this.f55174f.getDataList().addAll(b16);
        this.f55174f.notifyLoadingComplete(true, !this.f55173e.A2());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneFeedxDetailAnimEvent>> getEventClass() {
        ArrayList<Class<QZoneFeedxDetailAnimEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxDetailAnimEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailBlockPart";
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55173e = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        this.f55173e.f55901m.observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.detail.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.this.K9((UIStateData) obj);
            }
        });
        I9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
        com.qzone.reborn.feedx.viewmodel.h hVar = this.f55173e;
        if (hVar != null) {
            hVar.L1();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxDetailAnimEvent) {
            D9((QZoneFeedxDetailAnimEvent) simpleBaseEvent);
        }
    }

    private void F9(UIStateData<BusinessFeedData> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailRsp() return empty data");
            this.f55172d.notifyLoadingComplete(false);
            return;
        }
        if (state != 2 && state != 3) {
            if (state != 4) {
                return;
            }
            M9(uIStateData);
            return;
        }
        this.f55172d.notifyLoadingComplete(true, uIStateData.getIsFinish());
        this.D = true;
        if (!this.C || !this.E) {
            G9(uIStateData.getData());
            this.C = true;
        }
        if (uIStateData.getState() == 3) {
            N9();
        }
    }
}
