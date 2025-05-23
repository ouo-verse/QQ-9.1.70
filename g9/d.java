package g9;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.g;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QZoneConfigHelper;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends com.qzone.reborn.base.d {
    private static final int C = ImmersiveUtils.dpToPx(90.0f);

    /* renamed from: e, reason: collision with root package name */
    private b f401552e;

    /* renamed from: f, reason: collision with root package name */
    private h9.a f401553f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f401554h;

    /* renamed from: i, reason: collision with root package name */
    private g f401555i;

    /* renamed from: m, reason: collision with root package name */
    private e f401556m;

    public d(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        for (MultiViewBlock multiViewBlock : list) {
            if (this.f401552e != null) {
                return;
            }
            if (multiViewBlock instanceof b) {
                this.f401552e = (b) multiViewBlock;
            } else if (multiViewBlock instanceof e) {
                this.f401556m = (e) multiViewBlock;
            }
        }
    }

    private int N9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private void Q9() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(false);
        this.mBlockContainer.getRecyclerView().setNestedScrollingEnabled(true);
        this.mBlockContainer.getRecyclerView().setTag("fling");
        getBlockContainer().getBlockMerger().j0(QZoneConfigHelper.m0());
    }

    private void R9() {
        if (this.f401554h || getActivity() == null) {
            return;
        }
        this.f401554h = true;
        g gVar = new g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), N9());
        this.f401555i = gVar;
        gVar.f(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(this.f401555i);
    }

    @Override // com.qzone.reborn.base.d
    protected we.b C9() {
        return this.f401552e;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeListBlockPart";
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        h9.a aVar = (h9.a) getViewModel(h9.a.class);
        this.f401553f = aVar;
        aVar.T1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: g9.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.O9((UIStateData) obj);
            }
        });
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        getActivity().getWindow().setSoftInputMode(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9(UIStateData<List<BusinessFeedData>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        QLog.e("QZoneUserHomeListBlockPart", 1, "handleFeedListRsp() state" + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneUserHomeListBlockPart", 1, "handleFeedListRsp() return empty data");
            this.f401552e.notifyLoadingComplete(false);
            return;
        }
        if (state == 2 || state == 3) {
            this.f401552e.notifyLoadingComplete(true, uIStateData.getIsFinish());
            P9(uIStateData);
        } else {
            if (state != 4) {
                return;
            }
            QLog.e("QZoneUserHomeListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
            this.f401552e.notifyLoadingComplete(false);
        }
    }

    private void P9(UIStateData<List<BusinessFeedData>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        List<BusinessFeedData> data = uIStateData.getData();
        boolean isFinish = uIStateData.getIsFinish();
        if (data == null) {
            return;
        }
        QLog.d("QZoneUserHomeListBlockPart", 1, "get usr feed data:" + data.size());
        e eVar = this.f401556m;
        if (eVar != null) {
            eVar.setBlockVisible(data.size() > 0);
        }
        if (this.f401552e == null) {
            this.f401552e = new b(null);
        }
        if (isFinish) {
            getBlockContainer().setEnableLoadMore(false);
        }
        this.f401552e.setDatas(data);
        R9();
    }
}
