package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeDataDateTitle {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeDataDateTitle.class, "isSelect", "isSelect()Z", 0)};
    public final int dateType;
    public final ReadWriteProperty isSelect$delegate = c.a(Boolean.FALSE);
    public final Lazy title$delegate;

    public QPlusTrafficHomeDataDateTitle(int i3) {
        Lazy lazy;
        this.dateType = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusTrafficHomeDataDateTitle$title$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                int i16 = QPlusTrafficHomeDataDateTitle.this.dateType;
                int[] values = BoxType$EnumUnboxingSharedUtility.values(3);
                int length = values.length;
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    if (i18 >= length) {
                        break;
                    }
                    int i19 = values[i18];
                    if (QPlusDateTypeTitles$EnumUnboxingLocalUtility.getType(i19) == i16) {
                        i17 = i19;
                        break;
                    }
                    i18++;
                }
                if (i17 != 0) {
                    return QPlusDateTypeTitles$EnumUnboxingLocalUtility.getTitle(i17);
                }
                return "\u672a\u77e5";
            }
        });
        this.title$delegate = lazy;
    }
}
