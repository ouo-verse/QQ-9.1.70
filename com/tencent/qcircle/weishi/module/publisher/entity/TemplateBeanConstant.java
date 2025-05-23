package com.tencent.qcircle.weishi.module.publisher.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TemplateBeanConstant {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface TemplateModelType {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TemplateModelTypeConstant {
        public static final int MODEL_TYPE_AUTO = 1;
        public static final int MODEL_TYPE_LIGHT = 3;
        public static final int MODEL_TYPE_MV = 2;
        public static final int MODEL_TYPE_ORIGIN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface TemplateUiType {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TemplateUiTypeConstant {
        public static final int UI_TYPE_LOADING = 3;
        public static final int UI_TYPE_NORMAL = 0;
        public static final int UI_TYPE_ORIGIN = 1;
        public static final int UI_TYPE_REFRESH = 2;
    }
}
