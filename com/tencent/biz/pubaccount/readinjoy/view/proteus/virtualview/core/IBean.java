package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface IBean {
    void appendData(Object obj);

    void click(int i3, boolean z16);

    void doEvent(int i3, int i16, Object obj);

    void init(Context context, ViewBase viewBase);

    void setData(Object obj);

    void uninit();
}
