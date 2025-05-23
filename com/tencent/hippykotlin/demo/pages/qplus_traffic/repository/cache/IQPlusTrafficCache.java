package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache;

import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;

/* loaded from: classes31.dex */
public interface IQPlusTrafficCache<RSP extends ISSORspModel<RSP>> {

    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ISSORspModel getCache$default(IQPlusTrafficCache iQPlusTrafficCache, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = "";
            }
            return ((QPlusTrafficCache) iQPlusTrafficCache).getCache(str, false);
        }
    }
}
