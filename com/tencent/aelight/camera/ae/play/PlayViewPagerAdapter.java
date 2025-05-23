package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.part.c;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes32.dex */
public class PlayViewPagerAdapter extends PagerAdapter {
    public static final String DEFAULT_TAB_ID = "-1";
    private AEPlayShowPageView currentPageView;
    private int lastPos = -1;
    private List<AEMaterialCategory> mCategoryList;
    private Context mContext;
    private c mPartManager;

    public PlayViewPagerAdapter(Context context, c cVar, List<AEMaterialCategory> list) {
        this.mContext = context;
        this.mPartManager = cVar;
        this.mCategoryList = list;
    }

    private int getLayoutType(int i3) {
        AEMaterialCategory aEMaterialCategory = this.mCategoryList.get(i3);
        if (aEMaterialCategory == null) {
            return 2;
        }
        return aEMaterialCategory.f69048i;
    }

    private List<AEMaterialMetaData> getMaterialList(int i3) {
        List<AEMaterialMetaData> list;
        List<AEMaterialCategory> list2 = this.mCategoryList;
        AEMaterialCategory aEMaterialCategory = (list2 == null || list2.size() <= i3) ? null : this.mCategoryList.get(i3);
        return (aEMaterialCategory == null || (list = aEMaterialCategory.f69044d) == null) ? new LinkedList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMaterialTabId(int i3) {
        List<AEMaterialCategory> list = this.mCategoryList;
        if (list != null && list.size() > i3) {
            return this.mCategoryList.get(i3).f69046f;
        }
        return "-1";
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        if (obj instanceof AEPlayShowPageView) {
            ((AEPlayShowPageView) obj).onDestroy();
        }
        ms.a.a("AEPlayShowPart", "page destroy.......");
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<AEMaterialCategory> list = this.mCategoryList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public AEPlayShowPageView getCurrentPageView() {
        return this.currentPageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public String getLastMaterialTabId() {
        int i3 = this.lastPos;
        if (i3 <= 0) {
            return "-1";
        }
        return getMaterialTabId(i3);
    }

    public List<AEMaterialCategory> getmCategoryList() {
        return this.mCategoryList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        AEPlayShowPageView aEPlayShowPageView = new AEPlayShowPageView(this.mContext, this.mPartManager, getLayoutType(i3), getMaterialList(i3));
        viewGroup.addView(aEPlayShowPageView);
        return aEPlayShowPageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void setCategoryList(List<AEMaterialCategory> list) {
        this.mCategoryList = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, final int i3, Object obj) {
        AEMaterialCategory aEMaterialCategory;
        super.setPrimaryItem(viewGroup, i3, obj);
        boolean z16 = obj instanceof AEPlayShowPageView;
        if (z16) {
            this.currentPageView = (AEPlayShowPageView) obj;
        }
        if (this.lastPos != i3) {
            this.lastPos = i3;
            List<AEMaterialCategory> list = this.mCategoryList;
            if (list != null && list.size() > i3 && (aEMaterialCategory = this.mCategoryList.get(i3)) != null) {
                AEBaseReportParam.U().S0(aEMaterialCategory.f69046f + "");
            }
            if (z16) {
                this.currentPageView.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.PlayViewPagerAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PlayViewPagerAdapter.this.currentPageView.reportItemExpose();
                        PlayViewPagerAdapter.this.currentPageView.setTabId(PlayViewPagerAdapter.this.getMaterialTabId(i3));
                    }
                });
                this.currentPageView.initDownloadObservers();
            }
        }
    }
}
