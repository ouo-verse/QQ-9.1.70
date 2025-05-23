package com.tencent.ditto.reflect;

import com.tencent.ditto.shell.DittoUIEngine;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class DittoValue {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class GLOBAL {
        private static final GLOBAL sInstance = new GLOBAL();
        public static final int screenWidth = (int) DittoUIEngine.g().getScreenWidth();

        public static GLOBAL getInstance() {
            if (DittoUIEngine.getOuterGlobalData() != null) {
                return DittoUIEngine.getOuterGlobalData();
            }
            return sInstance;
        }
    }

    public abstract Object getValue(Object obj);

    public abstract void setValue(Object obj, String str);

    public abstract void setValue(Object obj, boolean z16);
}
