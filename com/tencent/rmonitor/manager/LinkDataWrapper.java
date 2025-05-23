package com.tencent.rmonitor.manager;

import android.content.Context;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.utils.ContextUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class LinkDataWrapper {
    public static void initLinkage(Context context, String str) {
        if (ContextUtil.getGlobalContext() == null) {
            ContextUtil.setGlobalContext(context);
        }
        PluginLinkDataProxy pluginLinkDataProxy = PluginLinkDataProxy.getInstance();
        if (pluginLinkDataProxy.getLinkDataDBCacheMng() == null) {
            pluginLinkDataProxy.setLinkDataDBCacheMng(new LinkDataDBCacheMngImpl(str));
        }
    }
}
