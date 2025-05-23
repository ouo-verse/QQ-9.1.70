package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.supportui.utils.struct.Pools;

/* loaded from: classes20.dex */
public class HippyCallNativeParams {
    private static final Pools.SynchronizedPool<HippyCallNativeParams> INSTANCE_POOL = new Pools.SynchronizedPool<>(20);
    private static final int POOL_SIZE = 20;
    public String callId;
    public String moduleFunc;
    public String moduleName;
    public Object params;

    private void init(String str, String str2, String str3, Object obj) {
        this.moduleName = str;
        this.moduleFunc = str2;
        this.callId = str3;
        this.params = obj;
    }

    public static HippyCallNativeParams obtain(String str, String str2, String str3, Object obj) {
        HippyCallNativeParams acquire = INSTANCE_POOL.acquire();
        if (acquire == null) {
            acquire = new HippyCallNativeParams();
        }
        acquire.init(str, str2, str3, obj);
        return acquire;
    }

    public void onDispose() {
        this.params = null;
        INSTANCE_POOL.release(this);
    }
}
