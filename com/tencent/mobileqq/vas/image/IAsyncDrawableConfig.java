package com.tencent.mobileqq.vas.image;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0018\u0010\u0011\u001a\u00020\u0012X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/image/IAsyncDrawableConfig;", "", "requestLayoutAfterDrawableChange", "", "getRequestLayoutAfterDrawableChange", "()Z", "setRequestLayoutAfterDrawableChange", "(Z)V", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "scaleXY", "", "getScaleXY", "()F", "setScaleXY", "(F)V", "Companion", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IAsyncDrawableConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEFAULT = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/image/IAsyncDrawableConfig$Companion;", "", "()V", "DEFAULT", "", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEFAULT = -1;

        Companion() {
        }
    }

    boolean getRequestLayoutAfterDrawableChange();

    int getRequestLodingHeight();

    int getRequestLodingWidth();

    float getScaleXY();

    void setRequestLayoutAfterDrawableChange(boolean z16);

    void setRequestLodingHeight(int i3);

    void setRequestLodingWidth(int i3);

    void setScaleXY(float f16);
}
