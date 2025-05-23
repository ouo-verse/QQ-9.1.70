package com.tencent.localedit.fakenative.convert;

import com.tencent.localedit.fakenative.core.BaseManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/localedit/fakenative/convert/c;", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "Lcom/tencent/localedit/fakenative/convert/a;", "convertDelegate", "", "f", "", "filePath", "e", "a", "Lcom/tencent/localedit/fakenative/convert/a;", "d", "()Lcom/tencent/localedit/fakenative/convert/a;", "setDelegate", "(Lcom/tencent/localedit/fakenative/convert/a;)V", "delegate", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class c extends BaseManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a delegate = new b();

    @NotNull
    /* renamed from: d, reason: from getter */
    public final a getDelegate() {
        return this.delegate;
    }

    public final void e(@Nullable String filePath) {
        this.delegate.d(filePath);
    }

    public final void f(@NotNull a convertDelegate) {
        Intrinsics.checkNotNullParameter(convertDelegate, "convertDelegate");
        this.delegate = convertDelegate;
    }
}
