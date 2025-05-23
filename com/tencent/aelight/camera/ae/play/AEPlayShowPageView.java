package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.part.c;
import com.tencent.aelight.camera.ae.play.AEPlayShowGridAdapter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* loaded from: classes32.dex */
public class AEPlayShowPageView extends FrameLayout {
    private static final String TAG = "AEPlayShowPageView";
    private GridLayoutManager gridLayoutManager;
    private List<AEMaterialMetaData> mInfoWrappers;
    private int mLayoutType;
    private c mPartManger;
    private AEPlayShowGridAdapter mPlayShowGridAdapter;
    private RecyclerView mPlayShowGridView;
    private static final AEPlayShowGridAdapter.SizeInfo ONE_COLUMN_SIZE = calcSizeInfo(1);
    private static final AEPlayShowGridAdapter.SizeInfo TWO_COLUMN_SIZE = calcSizeInfo(2);

    public AEPlayShowPageView(Context context, c cVar, int i3, List<AEMaterialMetaData> list) {
        this(context, null, cVar, i3, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPositionFlag() {
        c cVar = this.mPartManger;
        if (cVar == null) {
            return;
        }
        Object b16 = cVar.b(65537, new Object[0]);
        if (b16 instanceof AEPituCameraUnit) {
            AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) b16;
            if (aEPituCameraUnit.z() == null || aEPituCameraUnit.z().getIntent() == null) {
                return;
            }
            aEPituCameraUnit.z().getIntent().putExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID, "");
            aEPituCameraUnit.z().getIntent().putExtra(IAECameraUnit.KEY_CURRENT_TYPE, "");
        }
    }

    private void initConfig(c cVar, int i3, List<AEMaterialMetaData> list) {
        this.mPartManger = cVar;
        this.mLayoutType = i3;
        this.mInfoWrappers = list;
    }

    private void initViews(Context context) {
        final AEPlayShowGridAdapter.SizeInfo sizeInfo;
        LayoutInflater.from(context).inflate(R.layout.dnh, (ViewGroup) this, true);
        this.mPlayShowGridView = (RecyclerView) findViewById(R.id.rng);
        ms.a.a("AEPlayShowPart", "rv toString " + this.mPlayShowGridView.toString());
        this.mPlayShowGridView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (i3 == 0) {
                    ApngImage.resumeAll();
                } else {
                    ApngImage.pauseAll();
                }
                super.onScrollStateChanged(recyclerView, i3);
            }
        });
        if (this.mLayoutType == 1) {
            this.gridLayoutManager = new GridLayoutManager(context, 1, 1, false);
        } else {
            this.gridLayoutManager = new GridLayoutManager(context, 2, 1, false);
        }
        this.mPlayShowGridView.setLayoutManager(this.gridLayoutManager);
        if (this.mLayoutType == 1) {
            sizeInfo = new AEPlayShowGridAdapter.SizeInfo(calcSizeInfo(1));
        } else {
            sizeInfo = new AEPlayShowGridAdapter.SizeInfo(calcSizeInfo(2));
        }
        this.mPlayShowGridView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPageView.2
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (AEPlayShowPageView.this.mLayoutType != 1) {
                    AEPlayShowGridAdapter.SizeInfo sizeInfo2 = sizeInfo;
                    int i3 = sizeInfo2.itemHorizontalPadding;
                    rect.left = i3;
                    rect.right = i3;
                    int i16 = sizeInfo2.itemVerticalPadding;
                    rect.top = i16;
                    rect.bottom = i16;
                    return;
                }
                rect.bottom = sizeInfo.itemVerticalPadding;
            }
        });
        AEPlayShowGridAdapter aEPlayShowGridAdapter = new AEPlayShowGridAdapter(context, this.mPartManger, sizeInfo, this.mLayoutType);
        this.mPlayShowGridAdapter = aEPlayShowGridAdapter;
        this.mPlayShowGridView.setAdapter(aEPlayShowGridAdapter);
        updateData(this.mInfoWrappers);
    }

    public int getCurrentY() {
        RecyclerView recyclerView = this.mPlayShowGridView;
        if (recyclerView == null) {
            return 0;
        }
        return recyclerView.getScrollY();
    }

    public void initDownloadObservers() {
        this.mPlayShowGridAdapter.initObservers();
    }

    public void onDestroy() {
        RecyclerView recyclerView = this.mPlayShowGridView;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(null);
        }
        AEPlayShowGridAdapter aEPlayShowGridAdapter = this.mPlayShowGridAdapter;
        if (aEPlayShowGridAdapter != null) {
            aEPlayShowGridAdapter.onDestroy();
        }
    }

    public void reportItemExpose() {
        int findFirstVisibleItemPosition = this.gridLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.gridLayoutManager.findLastVisibleItemPosition();
        if (this.mInfoWrappers == null || findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
            return;
        }
        while (findFirstVisibleItemPosition < this.mInfoWrappers.size() && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            AEMaterialMetaData aEMaterialMetaData = this.mInfoWrappers.get(findFirstVisibleItemPosition);
            AEBaseReportParam.U().T0(aEMaterialMetaData.playShowType);
            findFirstVisibleItemPosition++;
            AEBaseReportParam.U().R0(findFirstVisibleItemPosition);
            com.tencent.aelight.camera.ae.report.b.b().q1(aEMaterialMetaData.f69050id);
        }
    }

    public void scrollTo(int i3) {
        RecyclerView recyclerView = this.mPlayShowGridView;
        if (recyclerView != null) {
            recyclerView.scrollTo(0, i3);
        }
    }

    public void scrollToPosWithClick(final int i3) {
        if (this.mPlayShowGridView != null) {
            GridLayoutManager gridLayoutManager = this.gridLayoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.scrollToPositionWithOffset(i3, 0);
            }
            ms.a.a("AEPlayShowPart", "out........" + this.mPlayShowGridView.toString());
            this.mPlayShowGridView.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPageView.3
                @Override // java.lang.Runnable
                public void run() {
                    View findViewByPosition;
                    ms.a.a("AEPlayShowPart", "in........");
                    if (AEPlayShowPageView.this.gridLayoutManager == null || (findViewByPosition = AEPlayShowPageView.this.gridLayoutManager.findViewByPosition(i3)) == null) {
                        return;
                    }
                    AEPlayShowPageView.this.clearPositionFlag();
                    findViewByPosition.performClick();
                }
            });
        }
    }

    public void setTabId(String str) {
        this.mPlayShowGridAdapter.setCurTabId(str);
    }

    public void updateData(List<AEMaterialMetaData> list) {
        AEPlayShowGridAdapter aEPlayShowGridAdapter = this.mPlayShowGridAdapter;
        if (aEPlayShowGridAdapter != null) {
            aEPlayShowGridAdapter.putData(list);
        }
    }

    public AEPlayShowPageView(Context context, AttributeSet attributeSet, c cVar, int i3, List<AEMaterialMetaData> list) {
        this(context, attributeSet, 0, cVar, i3, list);
    }

    public AEPlayShowPageView(Context context, AttributeSet attributeSet, int i3, c cVar, int i16, List<AEMaterialMetaData> list) {
        super(context, attributeSet, i3);
        this.mLayoutType = 2;
        initConfig(cVar, i16, list);
        initViews(context);
    }

    private static AEPlayShowGridAdapter.SizeInfo calcSizeInfo(int i3) {
        int i16;
        int a16 = x.a(10.0f);
        int a17 = x.a(4.0f);
        int i17 = (int) (a17 * 0.96f);
        if (i3 == 1) {
            i16 = (BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels - (a16 * 2)) - (a17 * 2);
        } else {
            i16 = ((BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels - (a16 * 2)) - (a17 * 4)) / 2;
        }
        AEPlayShowGridAdapter.SizeInfo sizeInfo = new AEPlayShowGridAdapter.SizeInfo();
        sizeInfo.itemWidth = i16 + (a17 * 2);
        sizeInfo.itemHeight = ((int) (((i16 * 0.96f) * 59.0f) / 34.0f)) + (i17 * 2);
        sizeInfo.itemHorizontalPadding = a17;
        sizeInfo.itemVerticalPadding = i17;
        if (i3 == 1) {
            sizeInfo.itemVerticalPadding = a16;
        }
        return sizeInfo;
    }
}
