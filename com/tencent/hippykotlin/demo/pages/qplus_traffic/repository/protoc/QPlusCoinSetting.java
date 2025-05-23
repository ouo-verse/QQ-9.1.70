package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusCoinSetting implements ISSOReqModel, ISSORspModel<QPlusCoinSetting> {
    public final int amount;
    public final int coinDiscount;
    public final int coinType;
    public final int maxAmountLimit;
    public final String settingId;

    public QPlusCoinSetting() {
        this(null, 0, 0, 0, 0, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("setting_id", this.settingId);
        eVar.t("amount", this.amount);
        eVar.t("coin_discount", this.coinDiscount);
        eVar.t("coin_type", this.coinType);
        eVar.t("max_amount_limit", this.maxAmountLimit);
        return eVar;
    }

    public QPlusCoinSetting(String str, int i3, int i16, int i17, int i18) {
        this.settingId = str;
        this.amount = i3;
        this.coinDiscount = i16;
        this.coinType = i17;
        this.maxAmountLimit = i18;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCoinSetting decode(e eVar) {
        return new QPlusCoinSetting(eVar.q("setting_id", ""), eVar.k("amount", 0), eVar.k("coin_discount", 0), eVar.k("coin_type", 0), eVar.k("max_amount_limit", 0));
    }

    public /* synthetic */ QPlusCoinSetting(String str, int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0, 0, 0);
    }
}
