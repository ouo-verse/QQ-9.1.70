package com.tencent.localedit.fakenative.intercept;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.localedit.fakenative.core.BaseManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B)\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/localedit/fakenative/intercept/c;", "Req", "Resp", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "", "url", Const.BUNDLE_KEY_REQUEST, "d", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Lu11/d;", "a", "Lu11/d;", "getContext", "()Lu11/d;", "context", "", "Lcom/tencent/localedit/fakenative/intercept/e;", "b", "Ljava/util/List;", "interceptors", "interceptorList", "<init>", "(Ljava/util/List;Lu11/d;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class c<Req, Resp> extends BaseManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u11.d context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e<Req, Resp>> interceptors;

    public c(@NotNull List<? extends e<Req, Resp>> interceptorList, @NotNull u11.d context) {
        List<e<Req, Resp>> sortedDescending;
        Intrinsics.checkNotNullParameter(interceptorList, "interceptorList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        sortedDescending = CollectionsKt___CollectionsKt.sortedDescending(interceptorList);
        this.interceptors = sortedDescending;
    }

    @Nullable
    public Resp d(@NotNull String url, @Nullable Req request) {
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            Resp resp = (Resp) ((e) it.next()).d(url, request);
            if (resp != null) {
                return resp;
            }
        }
        return null;
    }
}
