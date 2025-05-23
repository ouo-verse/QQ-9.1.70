package com.tencent.minibox.loader.core;

import com.tencent.minibox.common.log.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/minibox/loader/core/d;", "", "Ljava/io/InputStream;", "a", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/minibox/loader/core/d$a;", "", "Ljava/io/File;", "file", "Lcom/tencent/minibox/loader/core/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.minibox.loader.core.d$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/minibox/loader/core/d$a$a", "Lcom/tencent/minibox/loader/core/d;", "Ljava/io/InputStream;", "a", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.minibox.loader.core.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7045a extends d {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ File f151661b;

            C7045a(File file) {
                this.f151661b = file;
            }

            @Override // com.tencent.minibox.loader.core.d
            @NotNull
            public InputStream a() {
                LogUtils.e("DexFile", "dex file from file: " + this.f151661b);
                return new FileInputStream(this.f151661b);
            }
        }

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final d a(@NotNull File file) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            return new C7045a(file);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public abstract InputStream a() throws IOException;
}
