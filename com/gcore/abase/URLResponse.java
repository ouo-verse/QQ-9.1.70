package com.gcore.abase;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class URLResponse {
    public byte[] body;
    public int status;
    public String statusMsg = "";
    public String URL = "";
    public String version = "";
    public Map<String, String> headers = new HashMap();
}
