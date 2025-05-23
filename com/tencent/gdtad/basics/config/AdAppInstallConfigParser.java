package com.tencent.gdtad.basics.config;

import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import km0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/gdtad/basics/config/AdAppInstallConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lkm0/a;", "", "contentBytes", "d", "c", "<init>", "()V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AdAppInstallConfigParser extends BaseConfigParser<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f108728e = "102405";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/gdtad/basics/config/AdAppInstallConfigParser$a;", "", "", "ID", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.basics.config.AdAppInstallConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return AdAppInstallConfigParser.f108728e;
        }

        Companion() {
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NotNull byte[] contentBytes) {
        Intrinsics.checkNotNullParameter(contentBytes, "contentBytes");
        a aVar = new a();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return aVar.c(new String(contentBytes, UTF_8));
    }
}
