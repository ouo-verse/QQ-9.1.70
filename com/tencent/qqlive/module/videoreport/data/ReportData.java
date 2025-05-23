package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.utils.reuse.IReusable;
import java.util.Collections;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportData implements IReusable {
    private String mId;
    private Map<String, ?> mParams;

    public String getId() {
        return this.mId;
    }

    @Nullable
    public Map<String, Object> getParams() {
        Map<String, ?> map = this.mParams;
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mId = null;
        this.mParams = null;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setParams(Map<String, ?> map) {
        this.mParams = map;
    }
}
