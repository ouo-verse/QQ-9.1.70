package com.tencent.biz.qcircleshadow.lib;

import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class QCirclePluginInitBean implements Serializable {
    private static final long serialVersionUID = 5838484954956837977L;
    private int mLoadAction;
    private QCircleSchemeBean mSchemeBean;
    private long mStartTime;
    private QCirclePluginTrace mTrace;

    public int getLoadAction() {
        return this.mLoadAction;
    }

    public QCircleSchemeBean getSchemeBean() {
        return this.mSchemeBean;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public QCirclePluginTrace getTrace() {
        return this.mTrace;
    }

    public QCirclePluginInitBean setLoadAction(int i3) {
        this.mLoadAction = i3;
        return this;
    }

    public QCirclePluginInitBean setSchemeBean(QCircleSchemeBean qCircleSchemeBean) {
        this.mSchemeBean = qCircleSchemeBean;
        return this;
    }

    public QCirclePluginInitBean setStartTime(long j3) {
        this.mStartTime = j3;
        return this;
    }

    public QCirclePluginInitBean setTrace(QCirclePluginTrace qCirclePluginTrace) {
        this.mTrace = qCirclePluginTrace;
        return this;
    }
}
