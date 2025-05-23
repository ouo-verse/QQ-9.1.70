package com.tencent.biz.richframework.ioc.operate.api;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.ioc.bean.FindIocKeyResult;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IViewTreeFindOperate {
    FindIocKeyResult findIocKey(int i3, View view, ViewGroup viewGroup, String str);

    void injectILogicParentViewGetter(ILogicParentViewGetter iLogicParentViewGetter);
}
