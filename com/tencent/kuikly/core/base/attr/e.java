package com.tencent.kuikly.core.base.attr;

import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0004B\u0019\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/base/attr/e;", "", "", "pageName", "a", "Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, "b", "path", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String scheme;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String path;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/base/attr/e$a;", "", "", "path", "Lcom/tencent/kuikly/core/base/attr/e;", "a", "PAGE_PLACEHOLDER", "Ljava/lang/String;", "SCHEME_BASE64", "SCHEME_COMMON_ASSETS", "SCHEME_FILE", "SCHEME_PAGE_ASSETS", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.attr.e$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(String path) {
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(path, "path");
            String str = "file://";
            DefaultConstructorMarker defaultConstructorMarker = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "file://", false, 2, null);
            if (startsWith$default) {
                String substring = path.substring(0, 7);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring2 = path.substring(7);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                return new e(substring, substring2, defaultConstructorMarker);
            }
            return new e(str, path, defaultConstructorMarker);
        }

        Companion() {
        }
    }

    public /* synthetic */ e(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String a(String pageName) {
        String replaceFirst$default;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        String str = this.scheme + this.path;
        if (!Intrinsics.areEqual(this.scheme, "assets://#pageName#/")) {
            return str;
        }
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(str, "#pageName#", pageName, false, 4, (Object) null);
        return replaceFirst$default;
    }

    e(String str, String str2) {
        this.scheme = str;
        this.path = str2;
    }
}
