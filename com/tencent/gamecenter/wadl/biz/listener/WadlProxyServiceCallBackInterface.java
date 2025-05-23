package com.tencent.gamecenter.wadl.biz.listener;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public interface WadlProxyServiceCallBackInterface {
    void onQueryCallback(ArrayList<WadlResult> arrayList);

    void onQueryCallbackVia(ArrayList<WadlResult> arrayList);

    void onWadlTaskStatusChanged(WadlResult wadlResult);
}
