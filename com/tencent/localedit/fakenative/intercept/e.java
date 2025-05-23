package com.tencent.localedit.fakenative.intercept;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0007\u001a\u0004\u0018\u00018\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH&J\u0019\u0010\f\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0096\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/localedit/fakenative/intercept/e;", "Req", "Resp", "", "", "url", Const.BUNDLE_KEY_REQUEST, "d", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", "getPriority", "other", "c", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class e<Req, Resp> implements Comparable<e<?, ?>> {
    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull e<?, ?> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(getPriority(), other.getPriority());
    }

    @Nullable
    public abstract Resp d(@Nullable String url, @Nullable Req request);

    public abstract int getPriority();
}
