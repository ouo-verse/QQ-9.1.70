package com.tencent.ams.dynamicwidget;

import com.tencent.ams.dynamicwidget.data.AdInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J&\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ams/dynamicwidget/e;", "", "", "moduleId", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "ad", "", "a", "errorMsg", "b", "f", h.F, "", "exposureArea", "e", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface e {
    void a(@Nullable String moduleId, @Nullable AdInfo ad5);

    void b(@Nullable String moduleId, @Nullable AdInfo ad5, @Nullable String errorMsg);

    void e(int exposureArea);

    void f();

    void h();
}
