package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class u extends Part {
    private static final String TAG = "QFSBasePart";
    protected boolean mIsFirstResume = true;
    protected boolean mPartIsResumed = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getActivityHashCode() {
        Activity activity = getActivity();
        if (activity != null) {
            return activity.hashCode();
        }
        return 0;
    }

    public int getFromPageId() {
        return getReportBean().getFromPageId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getIocInterface(Class<T> cls) {
        return (T) PartIOCKt.getIocInterface(this, cls);
    }

    public int getPageId() {
        return getReportBean().getPageId();
    }

    public QCircleReportBean getReportBean() {
        Object viewTagData = getViewTagData();
        if (!(viewTagData instanceof QCircleReportBean)) {
            if (!RFWApplication.isDebug()) {
                QLog.e(TAG, 1, "getReportBean but QCircleReportBean is null");
                return new QCircleReportBean();
            }
            QLog.e(TAG, 1, "getReportBean but QCircleReportBean is null , debug");
            throw new RuntimeException("getReportBean but QCircleReportBean is null");
        }
        return (QCircleReportBean) viewTagData;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_force_skin_change".equals(str) && (obj instanceof Boolean)) {
            onEnableSkinChange(((Boolean) obj).booleanValue());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.mPartIsResumed = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.mIsFirstResume = false;
        this.mPartIsResumed = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, obj, cls);
    }

    protected void unregisterIoc(Class<?> cls) {
        PartIOCKt.unregisterIoc(this, cls);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public QFSBaseFragment getHostFragment() {
        Fragment hostFragment = super.getHostFragment();
        if (hostFragment instanceof QFSBaseFragment) {
            return (QFSBaseFragment) hostFragment;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(View view, Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, view, obj, cls);
    }

    protected void onEnableSkinChange(boolean z16) {
    }
}
