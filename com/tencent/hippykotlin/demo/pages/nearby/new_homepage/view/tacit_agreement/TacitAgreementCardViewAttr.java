package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementCardViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementCardViewAttr.class, "data", "getData()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/data/Tacit;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementCardViewAttr.class, "index", "getIndex()Lkotlin/jvm/internal/IntCompanionObject;", 0)};
    public final ReadWriteProperty data$delegate = c.a(null);
    public NBPHomePageBaseViewModel viewModel;

    public TacitAgreementCardViewAttr() {
        c.a(IntCompanionObject.INSTANCE);
    }

    public final Tacit getData() {
        return (Tacit) this.data$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
