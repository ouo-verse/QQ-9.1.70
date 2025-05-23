package com.qq.e.tg.tangram;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface TangramManagerListener {
    public static final int ERR_CODE_FACTORY_ERROR = 4;
    public static final int ERR_CODE_INIT_NOT_READY = 1;
    public static final int ERR_CODE_PARAMS_ERROR = 2;
    public static final int ERR_CODE_PLUGIN_FACTORY_NOT_READY = 3;

    void onError(int i3);

    void onSuccess();
}
