package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementJudgeContentViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementJudgeContentViewAttr.class, "data", "getData()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/data/Tacit;", 0)};
    public final ReadWriteProperty data$delegate = c.a(null);
    public NBPHomePageBaseViewModel viewModel;

    public final Tacit getData() {
        return (Tacit) this.data$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
