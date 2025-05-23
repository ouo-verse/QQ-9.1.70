package com.tencent.mobileqq.shortvideo.filter;

import android.text.TextUtils;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQAVFilter extends QQBaseFilter {
    private int lastHeight;
    private int lastWidth;
    private FilterRender mFilterRender;
    private List<FragmentFilterDesc> mFragmentFilterDescs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class FragmentFilterDesc {
        public FilterDesc filterDesc;
        public String filterPath;
        public Long timeSlamp;

        FragmentFilterDesc() {
        }
    }

    public QQAVFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.lastWidth = 0;
        this.lastHeight = 0;
        this.mFragmentFilterDescs = new CopyOnWriteArrayList();
    }

    private void doInternaldestroyFilter() {
        FilterRender filterRender = this.mFilterRender;
        if (filterRender != null) {
            filterRender.destroy();
            this.mFilterRender = null;
            SLog.i("avFilterRender", "destroyNewFilter");
        }
    }

    private String getLocalResFold(String str, FilterDesc filterDesc) {
        String str2 = "";
        if (filterDesc == null) {
            return "";
        }
        if (filterDesc.name.equals(PatternUtils.NO_MATCH)) {
            str2 = null;
        }
        if (filterDesc.name.equals("MANHUA")) {
            str2 = str + "COMIC";
        }
        if (filterDesc.name.equals("SHENGXIA")) {
            str2 = str + "GESE";
        }
        if (filterDesc.name.equals("NUANYANG")) {
            str2 = str + "BRIGHTFIRE";
        }
        if (filterDesc.name.equals("YUEGUANG")) {
            str2 = str + "SKYLINE";
        }
        if (filterDesc.name.equals("QIANGWEI")) {
            str2 = str + Constants.APK_CERTIFICATE;
        }
        if (filterDesc.name.equals("YOULAN")) {
            str2 = str + "ORCHID";
        }
        if (filterDesc.name.equals("SHENGDAE")) {
            str2 = str + "SHENGDAI";
        }
        if (filterDesc.name.equals("BOHE")) {
            str2 = str + "AMARO";
        }
        if (filterDesc.name.equals("LANGMAN")) {
            str2 = str + "FENBI";
        }
        if (filterDesc.name.equals("NATURE")) {
            str2 = str + "NATURE";
        }
        if (filterDesc.name.equals("VSCOG3")) {
            str2 = str + "VSCOG3";
        }
        if (filterDesc.name.equals("VUEF1")) {
            str2 = str + "VUEF1";
        }
        if (filterDesc.name.equals("VSCOC1")) {
            str2 = str + "VSCOC1";
        }
        if (filterDesc.name.equals("FOODIEYU5")) {
            str2 = str + "FOODIEYU5";
        }
        if (filterDesc.name.equals("FOODIECH1")) {
            str2 = str + "FOODIECH1";
        }
        if (filterDesc.name.equals("ANALOGFILM04")) {
            str2 = str + "ANALOGFILM04";
        }
        if (filterDesc.name.equals("INSLARK")) {
            str2 = str + "INSLARK";
        }
        if (filterDesc.name.equals("BEAUTYCAM")) {
            str2 = str + "BEAUTYCAM";
        }
        if (filterDesc.name.equals("ANALOGFILM02")) {
            str2 = str + "ANALOGFILM02";
        }
        if (filterDesc.name.equals("BLACKWHITE")) {
            str2 = str + "BLACKWHITE";
        }
        if (filterDesc.name.equals("B612HONGRUN")) {
            str2 = str + "B612HONGRUN";
        }
        if (filterDesc.name.equals("INSTASIZETOKYO")) {
            str2 = str + "INSTASIZETOKYO";
        }
        if (filterDesc.name.equals("MEITUJIAOPIAN")) {
            str2 = str + "MEITUJIAOPIAN";
        }
        if (filterDesc.name.equals("MEIYANHUAYAN")) {
            str2 = str + "MEIYANHUAYAN";
        }
        if (filterDesc.name.equals("VUELANMEIZHIYE")) {
            str2 = str + "VUELANMEIZHIYE";
        }
        if (filterDesc.name.equals("HEAVYFELLING")) {
            str2 = str + "HEAVYFELLING";
        }
        if (filterDesc.name.equals("ANHONG")) {
            str2 = str + "ANHONG";
        }
        if (filterDesc.name.equals("BOPU")) {
            str2 = str + "BOPU";
        }
        if (filterDesc.name.equals("KLEINBLUE")) {
            str2 = str + "KLEINBLUE";
        }
        if (filterDesc.name.equals("PURPLEORANGE")) {
            str2 = str + "PURPLEORANGE";
        }
        if (filterDesc.name.equals("TEATIME")) {
            str2 = str + "TEATIME";
        }
        if (filterDesc.name.equals("FOREST")) {
            str2 = str + "FOREST";
        }
        if (filterDesc.name.equals("NORGE")) {
            str2 = str + "NORGE";
        }
        if (filterDesc.name.equals("SANTORINI")) {
            str2 = str + "SANTORINI";
        }
        if (filterDesc.name.equals("SHIFTER")) {
            str2 = str + "SHIFTER";
        }
        if (filterDesc.name.equals("BLACKNOISE")) {
            str2 = str + "BLACKNOISE";
        }
        if (filterDesc.name.equals("STRONG")) {
            str2 = str + "STRONG";
        }
        if (filterDesc.name.equals("DELICIOUS")) {
            str2 = str + "DELICIOUS";
        }
        if (filterDesc.name.equals("WHITETEA")) {
            str2 = str + "WHITETEA";
        }
        if (filterDesc.name.equals("SALIS")) {
            str2 = str + "SALIS";
        }
        if (filterDesc.name.equals("CLEANCOLD")) {
            str2 = str + "CLEANCOLD";
        }
        if (filterDesc.name.equals("FILM")) {
            str2 = str + "FILM";
        }
        if (filterDesc.name.equals("MACAROON")) {
            str2 = str + "MACAROON";
        }
        if (filterDesc.name.equals("GRASS")) {
            return str + "GRASS";
        }
        return str2;
    }

    public int getAVFilterType() {
        FilterRender filterRender = this.mFilterRender;
        if (filterRender != null) {
            return filterRender.getFilterType();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        FilterRender filterRender = this.mFilterRender;
        if (filterRender == null || filterRender.getFilterType() == -1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        FilterBusinessOperation businessOperation = getQQFilterRenderManager().getBusinessOperation();
        businessOperation.getPresentTimeStamp();
        long orgTimeStamp = businessOperation.getOrgTimeStamp();
        boolean z16 = false;
        if (this.mFilterRender == null) {
            this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
            setCurrentId(businessOperation.getCurrentAVFilterIdByType(0), false);
        }
        if (this.mFragmentFilterDescs.size() > 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.mFragmentFilterDescs.size()) {
                    break;
                }
                if (orgTimeStamp < this.mFragmentFilterDescs.get(i3).timeSlamp.longValue()) {
                    FragmentFilterDesc fragmentFilterDesc = this.mFragmentFilterDescs.get(i3);
                    FilterDesc currentAVFilterIdByType = businessOperation.getCurrentAVFilterIdByType(0);
                    if (currentAVFilterIdByType != null) {
                        if (!currentAVFilterIdByType.name.equals(fragmentFilterDesc.filterDesc.name)) {
                            this.mFilterRender.setFilterPath(fragmentFilterDesc.filterPath);
                            businessOperation.addSelectedFilterDesc(fragmentFilterDesc.filterDesc);
                        }
                    } else {
                        this.mFilterRender.setFilterPath(fragmentFilterDesc.filterPath);
                        businessOperation.addSelectedFilterDesc(fragmentFilterDesc.filterDesc);
                    }
                } else {
                    i3++;
                }
            }
        }
        this.lastWidth = getQQFilterRenderManager().getFilterWidth();
        int filterHeight = getQQFilterRenderManager().getFilterHeight();
        this.lastHeight = filterHeight;
        this.mOutputTextureID = this.mFilterRender.process(this.mInputTextureID, -1, this.lastWidth, filterHeight).getTextureId();
        if (this.mFilterRender.getFilterType() != -1) {
            z16 = true;
        }
        QQFilterLogManager.setFilterStatus("QQAvFilter", z16);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        if (this.lastWidth != i3 || this.lastHeight != i16) {
            doInternaldestroyFilter();
        }
        if (this.mFilterRender == null) {
            this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
        }
        setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(0), false);
        SLog.i("avFilterRender", "AVFILTER onSurfaceChange");
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        if (this.mFilterRender != null) {
            doInternaldestroyFilter();
        }
        if (this.mFilterRender == null) {
            this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
            this.lastWidth = getQQFilterRenderManager().getFilterWidth();
            int filterHeight = getQQFilterRenderManager().getFilterHeight();
            this.lastHeight = filterHeight;
            this.mFilterRender.preProcess(this.lastWidth, filterHeight);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        doInternaldestroyFilter();
        SLog.i("avFilterRender", "AVFILTER onSurfaceDestroy");
    }

    public void setAVListAndTimeSlamp(List<FilterDesc> list, List<Long> list2) {
        SLog.i("avFilterRender", "setAVListAndTimeSlamp");
        if (this.mFilterRender == null) {
            this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
        }
        String filterResPath = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (list != null && list2 != null && list.size() == list2.size()) {
            this.mFragmentFilterDescs.clear();
            for (int i3 = 0; i3 < list.size(); i3++) {
                FilterDesc filterDesc = list.get(i3);
                FragmentFilterDesc fragmentFilterDesc = new FragmentFilterDesc();
                if (filterDesc != null) {
                    fragmentFilterDesc.filterPath = filterDesc.getResFold(filterResPath);
                }
                if (TextUtils.isEmpty(fragmentFilterDesc.filterPath)) {
                    fragmentFilterDesc.filterPath = getLocalResFold(filterResPath, filterDesc);
                }
                fragmentFilterDesc.filterDesc = filterDesc;
                fragmentFilterDesc.timeSlamp = list2.get(i3);
                this.mFragmentFilterDescs.add(fragmentFilterDesc);
                if (i3 == 0) {
                    this.mFilterRender.setFilterPath(fragmentFilterDesc.filterPath);
                    getQQFilterRenderManager().getBusinessOperation().addSelectedFilterDesc(fragmentFilterDesc.filterDesc);
                }
            }
        }
    }

    public void setCurrentId(FilterDesc filterDesc, boolean z16) {
        String str;
        if (z16) {
            this.mFragmentFilterDescs.clear();
        }
        String filterResPath = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (filterDesc != null) {
            if (!TextUtils.isEmpty(filterDesc.resRootPath)) {
                str = filterDesc.getResFold(filterDesc.resRootPath);
            } else {
                str = filterDesc.getResFold(filterResPath);
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = getLocalResFold(filterResPath, filterDesc);
        }
        if (this.mFilterRender == null) {
            this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
        }
        this.mFilterRender.setFilterPath(str);
        if (!TextUtils.isEmpty(str)) {
            SLog.i("avFilterRender", "setNewSdkFilterID path:" + str);
            return;
        }
        SLog.i("avFilterRender", "set empty path~~");
    }
}
