package com.tencent.rdelivery.reshub;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rdelivery/reshub/FileSuffix;", "", "Companion", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public @interface FileSuffix {

    @NotNull
    public static final String COMP_ORIG_FILE = ".comp";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f364378b;

    @NotNull
    public static final String ENCRYPT_FILE = ".resc";

    @NotNull
    public static final String PATCH_FILE = ".patch";

    @NotNull
    public static final String RES_FILE = ".res";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rdelivery/reshub/FileSuffix$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "ZIP_FILE", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.reshub.FileSuffix$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String ZIP_FILE;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ Companion f364378b = new Companion();

        static {
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            ZIP_FILE = str;
        }

        Companion() {
        }

        @NotNull
        public final String a() {
            return ZIP_FILE;
        }
    }
}
