package com.tencent.component.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AppConfig {
    private static ConfigElem configElem = new ConfigElem();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class ConfigElem {
        int appid = 401;
        int clientType = 401;

        ConfigElem() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class DefaultConfigElem {
        public static final int APP_ID_NOW = 401;
        public static final int CLIENT_TYPE_ANDROID = 401;

        DefaultConfigElem() {
        }
    }

    public static int getClientType() {
        return configElem.clientType;
    }
}
