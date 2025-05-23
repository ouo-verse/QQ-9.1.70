package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes22.dex */
public class PageInfo {
    private final List<PageInfo> allPages = new ArrayList();
    private WeakReference<Object> mPage;
    private int mPageHashCode;
    private WeakReference<View> mPageView;
    private PageInfo mParentPage;
    private Set<PageInfo> updateInPages;
    private Set<PageInfo> updateOutPages;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageInfo(@NonNull Object obj, @NonNull View view) {
        this.mPage = new WeakReference<>(obj);
        this.mPageView = new WeakReference<>(view);
        this.mPageHashCode = obj.hashCode();
    }

    private static Set<PageInfo> getPageLinker(PageInfo pageInfo) {
        HashSet hashSet = new HashSet();
        if (ReportHelper.allPageReportEnabled(pageInfo)) {
            hashSet.add(pageInfo);
            hashSet.addAll(pageInfo.getAllPages());
            return hashSet;
        }
        while (pageInfo != null) {
            hashSet.add(pageInfo);
            pageInfo = pageInfo.getParentPage();
        }
        return hashSet;
    }

    public void collectPage(PageInfo pageInfo) {
        this.allPages.add(pageInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataEntity constructDataEntityLink() {
        DataEntity dataEntity = DataBinder.getDataEntity(getPage());
        PageInfo pageInfo = this.mParentPage;
        DataEntity dataEntity2 = dataEntity;
        while (pageInfo != null && pageInfo.getPage() != null) {
            DataEntity dataEntity3 = DataBinder.getDataEntity(pageInfo.getPage());
            DataEntityOperator.setParentEntity(dataEntity2, dataEntity3);
            pageInfo = pageInfo.mParentPage;
            dataEntity2 = dataEntity3;
        }
        return dataEntity;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PageInfo) {
            if (this.mPageHashCode == ((PageInfo) obj).mPageHashCode) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public Set<PageInfo> findInPagesWhenUpdate(PageInfo pageInfo) {
        Set<PageInfo> pageLinker = getPageLinker(pageInfo);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (ReportHelper.allPageReportEnabled(this)) {
            for (PageInfo pageInfo2 : getPageLinker(this)) {
                if (!pageLinker.contains(pageInfo2)) {
                    linkedHashSet.add(pageInfo2);
                }
            }
            return linkedHashSet;
        }
        return null;
    }

    public Set<PageInfo> findNewInPage(PageInfo pageInfo) {
        Set<PageInfo> pageLinker = getPageLinker(pageInfo);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean equals = equals(pageInfo);
        if (ReportHelper.allPageReportEnabled(this)) {
            for (PageInfo pageInfo2 : getPageLinker(this)) {
                if (equals || !pageLinker.contains(pageInfo2)) {
                    linkedHashSet.add(pageInfo2);
                }
            }
            return linkedHashSet;
        }
        for (PageInfo pageInfo3 = this; pageInfo3 != null; pageInfo3 = pageInfo3.mParentPage) {
            if (equals || !pageLinker.contains(pageInfo3)) {
                linkedHashSet.add(pageInfo3);
            }
        }
        return linkedHashSet;
    }

    public Set<PageInfo> findNewOutPage(PageInfo pageInfo) {
        boolean z16;
        Set<PageInfo> pageLinker = getPageLinker(this);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this == pageInfo) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (ReportHelper.allPageReportEnabled(pageInfo)) {
            for (PageInfo pageInfo2 : getPageLinker(pageInfo)) {
                if (z16 || !pageLinker.contains(pageInfo2)) {
                    linkedHashSet.add(pageInfo2);
                }
            }
            return linkedHashSet;
        }
        while (pageInfo != null) {
            if (z16 || !pageLinker.contains(pageInfo)) {
                linkedHashSet.add(pageInfo);
            }
            pageInfo = pageInfo.mParentPage;
        }
        return linkedHashSet;
    }

    public Set<PageInfo> findOutPagesWhenUpdate(PageInfo pageInfo) {
        Set<PageInfo> pageLinker = getPageLinker(this);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (ReportHelper.allPageReportEnabled(pageInfo)) {
            for (PageInfo pageInfo2 : getPageLinker(pageInfo)) {
                if (!pageLinker.contains(pageInfo2)) {
                    linkedHashSet.add(pageInfo2);
                }
            }
            return linkedHashSet;
        }
        return null;
    }

    public List<PageInfo> getAllPages() {
        return this.allPages;
    }

    public Set<PageInfo> getInPagesWhenUpdate() {
        return this.updateInPages;
    }

    public Set<PageInfo> getOutPagesWhenUpdate() {
        return this.updateOutPages;
    }

    @Nullable
    public Object getPage() {
        return this.mPage.get();
    }

    public int getPageHashCode() {
        return this.mPageHashCode;
    }

    @Nullable
    public String getPageId() {
        Object obj = this.mPage.get();
        if (obj != null) {
            return DataRWProxy.getPageId(obj);
        }
        return null;
    }

    @Nullable
    public View getPageView() {
        return this.mPageView.get();
    }

    public PageInfo getParentPage() {
        return this.mParentPage;
    }

    public int hashCode() {
        WeakReference<Object> weakReference = this.mPage;
        if (weakReference != null && this.mPageView != null) {
            Object obj = weakReference.get();
            View view = this.mPageView.get();
            if (obj != null && view != null) {
                return obj.hashCode() + view.hashCode();
            }
        }
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParentPage(@Nullable PageInfo pageInfo) {
        this.mParentPage = pageInfo;
    }

    public void setUpdateInPages(Set<PageInfo> set) {
        this.updateInPages = set;
    }

    public void setUpdateOutPages(Set<PageInfo> set) {
        this.updateOutPages = set;
    }

    public String toString() {
        String pageId;
        Map<String, ?> pageParams;
        String obj;
        if (VideoReportInner.getInstance().isDebugMode()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\n  size = ");
            sb5.append(getPageLinker(this).size());
            for (PageInfo pageInfo = this; pageInfo != null; pageInfo = pageInfo.mParentPage) {
                Object page = pageInfo.getPage();
                String str = "_null_page_";
                if (page == null) {
                    pageId = "_null_page_";
                } else {
                    pageId = DataRWProxy.getPageId(page);
                }
                if (page != null) {
                    str = DataRWProxy.getContentId(page);
                }
                if (page == null) {
                    pageParams = null;
                } else {
                    pageParams = DataRWProxy.getPageParams(page);
                }
                if (pageParams == null) {
                    obj = "_null_params_";
                } else {
                    obj = pageParams.toString();
                }
                sb5.append("\n pageId = ");
                sb5.append(pageId);
                sb5.append(", contentId = ");
                sb5.append(str);
                sb5.append(", pageParams = ");
                sb5.append(obj);
                sb5.append(", page = ");
                sb5.append(page);
                sb5.append(", pageView = ");
                sb5.append(pageInfo.getPageView());
                sb5.append("\n");
            }
            return sb5.toString();
        }
        return super.toString();
    }
}
