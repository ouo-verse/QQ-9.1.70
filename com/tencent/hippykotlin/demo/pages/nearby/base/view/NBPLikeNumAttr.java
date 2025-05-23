package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.log.KLog;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPLikeNumAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeNumAttr.class, "number", "getNumber()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeNumAttr.class, "newNumber", "getNewNumber()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeNumAttr.class, "needAnimation", "getNeedAnimation()Z", 0)};
    public float fontSize;
    public int fontWeight;
    public float innerHeight;
    public h color = h.INSTANCE.m();
    public final ReadWriteProperty number$delegate = c.a(0);
    public final ReadWriteProperty newNumber$delegate = c.a(0);
    public String defaultText = "\u70b9\u8d5e";
    public final ReadWriteProperty needAnimation$delegate = c.a(Boolean.FALSE);

    public final int getNewNumber() {
        return ((Number) this.newNumber$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final int getNumber() {
        return ((Number) this.number$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setNeedAnimation(boolean z16) {
        this.needAnimation$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public final void setData(NBPLikeData nBPLikeData) {
        NBPLikeData.NumberData numberData;
        if (nBPLikeData == null || (numberData = nBPLikeData.getNumberData()) == null) {
            return;
        }
        if (numberData.numberAnimation && numberData.number < 100) {
            setNeedAnimation(true);
            this.newNumber$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(numberData.number));
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("1: ");
            m3.append(getNewNumber());
            m3.append("\u3001 ");
            m3.append(getNumber());
            kLog.d("NBPLikeNumberView", m3.toString());
            return;
        }
        setNeedAnimation(false);
        this.number$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(numberData.number));
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("2: ");
        m16.append(getNewNumber());
        m16.append("\u3001 ");
        m16.append(getNumber());
        kLog2.d("NBPLikeNumberView", m16.toString());
    }
}
