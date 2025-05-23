package com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Node {
    public static final e DEF_JSON = new e();
    public e ext;
    public Node preNode;
    public int preStage;
    public final int stage;
    public long startTime;
    public Object transparentField;

    public Node(int i3, long j3) {
        this.ext = DEF_JSON;
        this.preStage = -10000;
        this.stage = i3;
        this.startTime = j3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Node(stage=");
        m3.append(this.stage);
        m3.append(", startTime=");
        m3.append(this.startTime);
        m3.append(", ext=");
        m3.append(this.ext);
        m3.append(", transparentField=");
        m3.append(this.transparentField);
        m3.append(')');
        return m3.toString();
    }

    public /* synthetic */ Node(int i3, long j3, e eVar, int i16, int i17) {
        this(i3, j3, (i17 & 4) != 0 ? DEF_JSON : eVar, (Object) null, (i17 & 16) != 0 ? -10000 : i16);
    }

    public Node(int i3, long j3, e eVar, Object obj, int i16) {
        this.stage = i3;
        this.startTime = j3;
        this.ext = eVar;
        this.transparentField = obj;
        this.preStage = i16;
    }
}
