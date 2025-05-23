package com.tencent.ttpic.openapi.extrastickerutil;

import com.tencent.aekit.openrender.internal.IPluginFilter;

/* loaded from: classes27.dex */
public class PluginFilterAgent {
    private IPluginFilterFactory mPluginFilterFactory;

    /* loaded from: classes27.dex */
    private static final class SINGLETON {
        public static final PluginFilterAgent instance = new PluginFilterAgent();

        SINGLETON() {
        }
    }

    public static PluginFilterAgent g() {
        return SINGLETON.instance;
    }

    public IPluginFilter createPlugFilter(String str, String str2) {
        IPluginFilterFactory iPluginFilterFactory = this.mPluginFilterFactory;
        if (iPluginFilterFactory == null) {
            return null;
        }
        return iPluginFilterFactory.createPluginFilter(str, str2);
    }

    public void setPluginFilterFactory(IPluginFilterFactory iPluginFilterFactory) {
        this.mPluginFilterFactory = iPluginFilterFactory;
    }
}
