package com.tencent.open.agent.report;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BaseData implements Serializable {
    protected static final long serialVersionUID = 10000;
    public final HashMap<String, String> attrs = new HashMap<>();

    public BaseData(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.attrs.put(str, bundle.getString(str));
            }
        }
    }
}
