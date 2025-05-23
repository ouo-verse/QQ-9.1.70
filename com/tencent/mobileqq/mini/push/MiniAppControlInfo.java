package com.tencent.mobileqq.mini.push;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppControlInfo {
    public String cmd;
    public Map<String, String> data = new HashMap();

    public String toString() {
        return "ctrlInfo:[cmd = " + this.cmd + ", data = " + this.data + "]";
    }
}
