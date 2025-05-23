package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCommonSimpleTitleBottomDialogAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCommonSimpleTitleBottomDialogAttr.class, "isShowDialog", "isShowDialog()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCommonSimpleTitleBottomDialogAttr.class, "title", "getTitle()Ljava/lang/String;", 0)};
    public Function1<? super ViewContainer<?, ?>, Unit> contentBuilder;
    public final ReadWriteProperty isShowDialog$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty title$delegate = c.a("");

    public final void setShowDialog(boolean z16) {
        this.isShowDialog$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
