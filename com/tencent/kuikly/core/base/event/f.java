package com.tencent.kuikly.core.base.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012R\"\u00107\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012\u00a8\u0006:"}, d2 = {"Lcom/tencent/kuikly/core/base/event/f;", "", "params", "Lcom/tencent/kuikly/core/base/event/h;", "a", "", "I", "getLastTouchSize", "()I", "setLastTouchSize", "(I)V", "lastTouchSize", "", "b", UserInfo.SEX_FEMALE, "getInitDistance", "()F", "setInitDistance", "(F)V", "initDistance", "c", "getLastScale", "setLastScale", "lastScale", "d", "getInitCenterX", "setInitCenterX", "initCenterX", "e", "getInitCenterY", "setInitCenterY", "initCenterY", "f", "getLastTranslateX", "setLastTranslateX", "lastTranslateX", "g", "getLastTranslateY", "setLastTranslateY", "lastTranslateY", "Lcom/tencent/kuikly/core/base/event/i;", tl.h.F, "Lcom/tencent/kuikly/core/base/event/i;", "getLastSegment", "()Lcom/tencent/kuikly/core/base/event/i;", "setLastSegment", "(Lcom/tencent/kuikly/core/base/event/i;)V", "lastSegment", "i", "getAnchorPageX", "setAnchorPageX", "anchorPageX", "j", "getAnchorPageY", "setAnchorPageY", "anchorPageY", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int lastTouchSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float initDistance;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float lastScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float initCenterX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float initCenterY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lastTranslateX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float lastTranslateY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Segment lastSegment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float anchorPageX;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float anchorPageY;

    public f() {
        Float valueOf = Float.valueOf(0.0f);
        this.lastSegment = new Segment(new Pair(valueOf, valueOf), new Pair(valueOf, valueOf));
    }

    public final PanGestureParams a(Object params) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
        if (eVar == null) {
            eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        }
        float h16 = (float) eVar.h(HippyTKDListViewAdapter.X);
        float h17 = (float) eVar.h("y");
        String p16 = eVar.p("state");
        float h18 = (float) eVar.h("pageX");
        float h19 = (float) eVar.h("pageY");
        ArrayList arrayList = new ArrayList();
        com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar.l("touches");
        if (l3 != null) {
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                arrayList.add(j.INSTANCE.a(l3.d(i3)));
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(h16, h17, h18, h19));
        }
        float f27 = 0.0f;
        if (!Intrinsics.areEqual(p16, "start") && !Intrinsics.areEqual(p16, "move")) {
            this.initDistance = 0.0f;
            this.lastScale = 1.0f;
            this.lastTouchSize = 0;
            f19 = 0.0f;
            f26 = 0.0f;
            f17 = 0.0f;
            f18 = 0.0f;
        } else {
            if (this.lastTouchSize <= 1 && arrayList.size() >= 2) {
                if (this.initDistance == 0.0f) {
                    Object obj = arrayList.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj, "touches[0]");
                    Object obj2 = arrayList.get(1);
                    Intrinsics.checkNotNullExpressionValue(obj2, "touches[1]");
                    this.initDistance = g.b((j) obj, (j) obj2);
                    float f28 = 2;
                    this.anchorPageX = (((j) arrayList.get(0)).getPageX() + ((j) arrayList.get(1)).getPageX()) / f28;
                    this.anchorPageY = (((j) arrayList.get(0)).getPageY() + ((j) arrayList.get(1)).getPageY()) / f28;
                }
                Object obj3 = arrayList.get(0);
                Intrinsics.checkNotNullExpressionValue(obj3, "touches[0]");
                Object obj4 = arrayList.get(1);
                Intrinsics.checkNotNullExpressionValue(obj4, "touches[1]");
                float b16 = g.b((j) obj3, (j) obj4);
                float f29 = this.initDistance;
                if (f29 > 0.0f) {
                    this.lastScale = b16 / f29;
                } else {
                    this.lastScale = 1.0f;
                }
            }
            if ((!arrayList.isEmpty()) && this.lastTouchSize != arrayList.size()) {
                Pair<Float, Float> c17 = g.c(arrayList);
                this.initCenterX = c17.getFirst().floatValue();
                this.initCenterY = c17.getSecond().floatValue();
                this.lastTranslateX = 0.0f;
                this.lastTranslateY = 0.0f;
                if (arrayList.size() >= 2) {
                    this.lastSegment = new Segment(new Pair(Float.valueOf(((j) arrayList.get(0)).getPageX()), Float.valueOf(((j) arrayList.get(0)).getPageY())), new Pair(Float.valueOf(((j) arrayList.get(1)).getPageX()), Float.valueOf(((j) arrayList.get(1)).getPageY())));
                }
            }
            if ((this.initDistance == 0.0f) || arrayList.size() < 2) {
                f16 = 0.0f;
            } else {
                Object obj5 = arrayList.get(0);
                Intrinsics.checkNotNullExpressionValue(obj5, "touches[0]");
                Object obj6 = arrayList.get(1);
                Intrinsics.checkNotNullExpressionValue(obj6, "touches[1]");
                float b17 = g.b((j) obj5, (j) obj6) / this.initDistance;
                f16 = (b17 - this.lastScale) * 1.8f;
                this.lastScale = b17;
            }
            Pair<Float, Float> c18 = g.c(arrayList);
            float floatValue = c18.getFirst().floatValue() - this.initCenterX;
            float floatValue2 = c18.getSecond().floatValue() - this.initCenterY;
            float f36 = floatValue - this.lastTranslateX;
            float f37 = floatValue2 - this.lastTranslateY;
            this.lastTranslateX = floatValue;
            this.lastTranslateY = floatValue2;
            if (arrayList.size() >= 2) {
                Segment segment = new Segment(new Pair(Float.valueOf(((j) arrayList.get(0)).getPageX()), Float.valueOf(((j) arrayList.get(0)).getPageY())), new Pair(Float.valueOf(((j) arrayList.get(1)).getPageX()), Float.valueOf(((j) arrayList.get(1)).getPageY())));
                f27 = g.a(segment, this.lastSegment);
                this.lastSegment = segment;
            }
            this.lastTouchSize = arrayList.size();
            f17 = f36;
            f18 = f37;
            f19 = f16;
            f26 = f27;
        }
        return new PanGestureParams(h16, h17, p16, h18, h19, arrayList, f19, f26, f17, f18, this.anchorPageX, this.anchorPageY);
    }
}
