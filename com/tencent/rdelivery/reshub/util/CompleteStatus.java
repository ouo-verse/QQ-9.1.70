package com.tencent.rdelivery.reshub.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/CompleteStatus;", "", "Companion", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public @interface CompleteStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f364580a;
    public static final int FAIL_AS_CHECK = 205;
    public static final int FAIL_AS_COMP_ORIG_FILE_DOWNLOAD = 210;
    public static final int FAIL_AS_COMP_ORIG_FILE_UNZIP = 211;
    public static final int FAIL_AS_COPY_DUPLICATE_FILE = 210;
    public static final int FAIL_AS_DECRYPT = 209;
    public static final int FAIL_AS_DOWNLOAD = 203;
    public static final int FAIL_AS_EXCEPTION = 208;
    public static final int FAIL_AS_FETCH = 201;
    public static final int FAIL_AS_PATCH = 207;
    public static final int FAIL_AS_UNZIP = 204;
    public static final int FAIL_AS_UPDATE = 206;
    public static final int FAIL_NO_ENOUGH_SPACE = 202;
    public static final int SUCCESS_WITHOUT_UPDATE = 101;
    public static final int SUCCESS_WITH_CLOSE = 103;
    public static final int SUCCESS_WITH_LOCK = 104;
    public static final int SUCCESS_WITH_UPDATE = 102;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/CompleteStatus$a;", "", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.reshub.util.CompleteStatus$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f364580a = new Companion();

        Companion() {
        }
    }
}
