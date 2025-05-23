package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchLabelItemAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchLabelItemAttr.class, "text", "getText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchLabelItemAttr.class, "isSelected", "isSelected()Z", 0)};
    public final ReadWriteProperty isSelected$delegate;
    public final ReadWriteProperty text$delegate;

    public QSearchLabelItemAttr(String str, boolean z16) {
        this.text$delegate = c.a(str);
        this.isSelected$delegate = c.a(Boolean.valueOf(z16));
    }
}
