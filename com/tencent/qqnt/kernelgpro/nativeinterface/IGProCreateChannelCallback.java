package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public interface IGProCreateChannelCallback {
    void onCreateChannelResult(int i3, String str, GProSecurityResult gProSecurityResult, GProChannel gProChannel, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList);
}
