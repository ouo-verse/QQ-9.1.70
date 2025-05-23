package com.qzone.homepage.ui.Facade.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* loaded from: classes39.dex */
abstract class _ProfileRectArea implements SmartParcelable {

    @NeedParcel
    protected int mAlignType;

    @NeedParcel
    protected int mHp;

    @NeedParcel
    protected ArrayList<Integer> mIndexContainer;

    @NeedParcel
    protected int mWp;

    @NeedParcel
    protected int mXp;

    @NeedParcel
    protected int mYp;

    public _ProfileRectArea() {
    }

    public _ProfileRectArea(ArrayList<Integer> arrayList, int i3, int i16, int i17, int i18, int i19) {
        this.mIndexContainer = arrayList;
        this.mXp = i3;
        this.mYp = i16;
        this.mWp = i17;
        this.mHp = i18;
        this.mAlignType = i19;
    }
}
