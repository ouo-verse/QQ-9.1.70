package com.tencent.ams.mosaic.jsengine.component.container;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface Linear {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AlignItems {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Direction {
        public static final String COLUMN = "column";
        public static final String ROW = "row";
    }

    void setAlignItems(String str);

    void setDirection(String str);
}
