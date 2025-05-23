package com.tencent.mapsdk.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import com.tencent.mapsdk.shell.events.NetFlowEventModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class md implements RequestProcessor, ResponseProcessor {

    /* renamed from: b, reason: collision with root package name */
    private static final String f149300b = "NetFlow";

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f149301c = false;

    /* renamed from: a, reason: collision with root package name */
    protected NetFlowEventModel f149302a;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f149303d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f149304e;

    public md() {
        this.f149303d = new HashMap<>();
        this.f149304e = false;
    }

    private boolean a(String str) {
        Uri parse;
        String scheme;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (scheme = parse.getScheme()) == null || !scheme.startsWith("http")) {
            return false;
        }
        String str2 = parse.getHost() + parse.getPath();
        if (this.f149303d.containsKey(str2)) {
            this.f149302a.bizType = this.f149303d.get(str2);
            this.f149304e = true;
        } else {
            Iterator<String> it = this.f149303d.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str2.contains(next)) {
                    this.f149302a.bizType = this.f149303d.get(next);
                    this.f149304e = true;
                    break;
                }
            }
        }
        return this.f149304e;
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) throws Exception {
        Uri parse;
        String scheme;
        NetFlowEventModel netFlowEventModel = new NetFlowEventModel();
        this.f149302a = netFlowEventModel;
        netFlowEventModel.url = netRequest.url;
        netFlowEventModel.uploadFlow = r1.getBytes().length;
        if (netRequest.postData != null) {
            this.f149302a.uploadFlow += r0.length;
        }
        for (Map.Entry<String, String> entry : netRequest.mapHeaders.entrySet()) {
            this.f149302a.uploadFlow += entry.getKey().getBytes().length + entry.getValue().getBytes().length;
        }
        NetFlowEventModel netFlowEventModel2 = this.f149302a;
        netFlowEventModel2.uploadFlow = netFlowEventModel2.uploadFlow / 1000.0d;
        netFlowEventModel2.uploadFlow = Math.round(r1 * 1000.0d) / 1000.0d;
        this.f149302a.uploadTime = System.currentTimeMillis();
        String str = netRequest.url;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (scheme = parse.getScheme()) != null && scheme.startsWith("http")) {
            String str2 = parse.getHost() + parse.getPath();
            if (this.f149303d.containsKey(str2)) {
                this.f149302a.bizType = this.f149303d.get(str2);
                this.f149304e = true;
            } else {
                Iterator<String> it = this.f149303d.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (str2.contains(next)) {
                        this.f149302a.bizType = this.f149303d.get(next);
                        this.f149304e = true;
                        break;
                    }
                }
            }
            z16 = this.f149304e;
        }
        if (!z16) {
            this.f149302a.bizType = "";
        }
    }

    public void onResponse(NetResponse netResponse) throws Exception {
        if (netResponse.available()) {
            NetFlowEventModel netFlowEventModel = this.f149302a;
            netFlowEventModel.errorCode = netResponse.statusCode;
            if (netResponse.errorCode != 0) {
                if (netResponse.errorData != null) {
                    netFlowEventModel.downloadFlow = r6.length;
                } else {
                    netFlowEventModel.downloadFlow = -1.0d;
                }
            } else {
                if (netResponse.data != null) {
                    netFlowEventModel.downloadFlow = r6.length;
                } else {
                    netFlowEventModel.downloadFlow = -1.0d;
                }
            }
            netFlowEventModel.downloadFlow = netFlowEventModel.downloadFlow / 1000.0d;
            netFlowEventModel.downloadFlow = Math.round(r1 * 1000.0d) / 1000.0d;
        } else {
            this.f149302a.errorCode = -100;
        }
        this.f149302a.downloadTime = System.currentTimeMillis();
    }

    public md(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.f149303d = hashMap2;
        this.f149304e = false;
        hashMap2.putAll(hashMap);
    }
}
