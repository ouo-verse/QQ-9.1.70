package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class SizeValue extends BaseValue {
    public static final int MATCH_PARENT = 1001;
    public static final int VALUE_ABSOLUTELY = 1004;
    public static final int VALUE_RELATIVE = 1003;
    public static final int WRAP_CONTENT = 1002;
    public double value;
    public int valueType;

    public SizeValue() {
        super(1);
    }

    public int getLayoutSize() {
        return getLayoutSize(this.valueType, this.value);
    }

    public static int getLayoutSize(int i3, double d16) {
        if (i3 == 1001) {
            return -1;
        }
        if (i3 == 1002) {
            return -2;
        }
        if (i3 != 1004) {
            return Utils.rp2px(d16);
        }
        return Utils.dp2px(d16);
    }
}
