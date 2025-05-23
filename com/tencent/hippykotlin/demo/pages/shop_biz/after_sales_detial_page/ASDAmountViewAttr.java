package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDAmountViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDAmountViewAttr.class, "integerStr", "getIntegerStr()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDAmountViewAttr.class, "decimalStr", "getDecimalStr()Ljava/lang/String;", 0)};
    public final ReadWriteProperty integerStr$delegate = c.a("");
    public final ReadWriteProperty decimalStr$delegate = c.a("");

    public final void amountString(String str) {
        List split$default;
        Object first;
        Object last;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
        ReadWriteProperty readWriteProperty = this.integerStr$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], (String) first);
        if (split$default.size() > 1) {
            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('.');
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
            m3.append((String) last);
            this.decimalStr$delegate.setValue(this, kPropertyArr[1], m3.toString());
        }
    }
}
