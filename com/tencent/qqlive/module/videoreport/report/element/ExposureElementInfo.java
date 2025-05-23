package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ExposureElementInfo {
    private boolean mCanReport = true;
    private FinalData mFinalData;
    private String mIdentifier;
    private WeakReference<Object> mPage;
    private PathData mPathData;
    private long mUniqueId;
    private WeakReference<View> mView;

    public ExposureElementInfo() {
    }

    public boolean canReport() {
        return this.mCanReport;
    }

    public FinalData getFinalData() {
        return this.mFinalData;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    @Nullable
    public Object getPage() {
        WeakReference<Object> weakReference = this.mPage;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public PathData getPathData() {
        return this.mPathData;
    }

    public long getUniqueId() {
        return this.mUniqueId;
    }

    @Nullable
    public View getView() {
        WeakReference<View> weakReference = this.mView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setCanReport(boolean z16) {
        this.mCanReport = z16;
    }

    public void setFinalData(FinalData finalData) {
        this.mFinalData = finalData;
    }

    public void setIdentifier(String str) {
        this.mIdentifier = str;
    }

    public void setPage(Object obj) {
        this.mPage = new WeakReference<>(obj);
    }

    public void setPathData(PathData pathData) {
        this.mPathData = pathData;
    }

    public void setUniqueId(long j3) {
        this.mUniqueId = j3;
    }

    public void setView(View view) {
        this.mView = new WeakReference<>(view);
    }

    public String toString() {
        View view;
        WeakReference<View> weakReference = this.mView;
        if (weakReference == null) {
            view = null;
        } else {
            view = weakReference.get();
        }
        if (view == null) {
            return "_null_view_";
        }
        return "uniqueId = " + this.mUniqueId + ", identifier = " + this.mIdentifier + ", eid = " + DataRWProxy.getElementId(view) + ",view = " + view;
    }

    public ExposureElementInfo(View view, Object obj, FinalData finalData, PathData pathData) {
        setView(view);
        setPage(obj);
        setFinalData(finalData);
        setPathData(pathData);
    }
}
