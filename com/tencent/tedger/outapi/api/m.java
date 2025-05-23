package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface m extends ue4.a {
    void init(String str, EdgeStatus edgeStatus);

    ArrayList<String> rank(EdgeUser edgeUser, List<EdgeItem> list, List<EdgeItemInfer> list2, EdgeStatus edgeStatus);

    int[] select(List<EdgeItem> list, EdgeStatus edgeStatus);
}
