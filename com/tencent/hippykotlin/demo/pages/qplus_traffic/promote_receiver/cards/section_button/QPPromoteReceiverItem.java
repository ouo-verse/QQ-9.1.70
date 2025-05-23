package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverItem {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverItem.class, "labelText", "getLabelText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverItem.class, "labelValue", "getLabelValue()I", 0)};
    public Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit> handleDataBlock;
    public boolean hasArrow;
    public boolean isDefault;
    public boolean isSingleSelect;
    public int labelIndex;
    public final ReadWriteProperty labelText$delegate;
    public final ReadWriteProperty labelValue$delegate;

    public QPPromoteReceiverItem() {
        this((String) null, 0, 0, false, false, (Function3) null, 127);
    }

    public final String getLabelText() {
        return (String) this.labelText$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getLabelValue() {
        return ((Number) this.labelValue$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final int hashCode() {
        int i3 = this.labelIndex * 31;
        Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit> function3 = this.handleDataBlock;
        return i3 + (function3 != null ? function3.hashCode() : 0);
    }

    public QPPromoteReceiverItem(String str, int i3, int i16, boolean z16, boolean z17, Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit> function3, boolean z18) {
        this.labelIndex = i16;
        this.isSingleSelect = z16;
        this.isDefault = z17;
        this.handleDataBlock = function3;
        this.hasArrow = z18;
        this.labelText$delegate = c.a(str);
        this.labelValue$delegate = c.a(Integer.valueOf(i3));
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QPPromoteReceiverItem)) {
            return false;
        }
        QPPromoteReceiverItem qPPromoteReceiverItem = (QPPromoteReceiverItem) obj;
        return Intrinsics.areEqual(qPPromoteReceiverItem.getLabelText(), getLabelText()) && qPPromoteReceiverItem.labelIndex == this.labelIndex;
    }

    public /* synthetic */ QPPromoteReceiverItem(String str, int i3, int i16, boolean z16, boolean z17, Function3 function3, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? false : z17, (Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit>) ((i17 & 32) != 0 ? null : function3), false);
    }
}
