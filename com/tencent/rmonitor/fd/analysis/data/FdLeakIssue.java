package com.tencent.rmonitor.fd.analysis.data;

import com.tencent.rmonitor.fd.data.FdCountable;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdLeakIssue implements Serializable {
    private List<FdCountable> features;
    private List<FdCountable> gcPaths;
    private final String issueType;

    public FdLeakIssue(String str) {
        this.issueType = str;
    }

    public List<FdCountable> getFeatures() {
        return this.features;
    }

    @Nullable
    public List<FdCountable> getGcPaths() {
        return this.gcPaths;
    }

    public String getIssueType() {
        return this.issueType;
    }

    public void setFeatures(List<FdCountable> list) {
        this.features = list;
    }

    public void setGcPaths(List<FdCountable> list) {
        this.gcPaths = list;
    }
}
