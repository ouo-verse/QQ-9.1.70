package com.tencent.nativepreview.biz;

import com.tencent.nativepreview.wrapper.model.DocSearchState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/nativepreview/biz/i;", "", "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", "getCurrentState", "searchState", "", "offset", "", "c", "all", "b", "", "a", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public interface i {
    void a(@Nullable DocSearchState searchState);

    boolean b(@Nullable DocSearchState searchState, boolean all);

    boolean c(@Nullable DocSearchState searchState, long offset);

    @Nullable
    DocSearchState getCurrentState();
}
