package com.tencent.sqshow.zootopia.widget.tab;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "T", "Ljava/io/Serializable;", "id", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getId", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public class BaseZPlanTabTitleData<T> implements Serializable {
    private final T id;
    private String title;

    public BaseZPlanTabTitleData(T t16, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = t16;
        this.title = title;
    }

    public final T getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
