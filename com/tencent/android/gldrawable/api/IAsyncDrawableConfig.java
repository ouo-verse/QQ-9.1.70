package com.tencent.android.gldrawable.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bR\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/gldrawable/api/IAsyncDrawableConfig;", "", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "Companion", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public interface IAsyncDrawableConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEFAULT = -1;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/android/gldrawable/api/IAsyncDrawableConfig$Companion;", "", "()V", "DEFAULT", "", "api_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEFAULT = -1;

        Companion() {
        }
    }

    int getRequestLodingHeight();

    int getRequestLodingWidth();

    void setRequestLodingHeight(int i3);

    void setRequestLodingWidth(int i3);
}
