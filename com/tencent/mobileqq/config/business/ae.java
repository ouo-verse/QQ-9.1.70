package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ae implements IConfigData {

    /* renamed from: m, reason: collision with root package name */
    private static final ae f202490m = new ae();

    /* renamed from: d, reason: collision with root package name */
    private boolean f202491d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f202492e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f202493f = "";

    /* renamed from: h, reason: collision with root package name */
    private long f202494h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f202495i = 0;

    public static ae d(String str) {
        try {
            ae aeVar = new ae();
            JSONObject jSONObject = new JSONObject(str);
            boolean z16 = false;
            if (jSONObject.optInt(NodeProps.VISIBLE, 0) == 1) {
                z16 = true;
            }
            aeVar.f202491d = z16;
            aeVar.f202492e = jSONObject.optString("guideText", "");
            aeVar.f202493f = jSONObject.optString("guideHighlightText", "");
            aeVar.f202494h = jSONObject.optLong("showIntervalMs", 0L);
            aeVar.f202495i = jSONObject.optLong("newShowIntervalMs", 0L);
            return aeVar;
        } catch (Exception e16) {
            QLog.e("NotificationBannerBean", 1, "parse: failed. ", e16);
            return f202490m;
        }
    }

    public long a() {
        return this.f202495i;
    }

    public String b() {
        return this.f202493f;
    }

    public String c() {
        return this.f202492e;
    }

    public long e() {
        return this.f202494h;
    }

    public boolean f() {
        return this.f202491d;
    }
}
