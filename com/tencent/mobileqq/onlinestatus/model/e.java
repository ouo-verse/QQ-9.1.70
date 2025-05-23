package com.tencent.mobileqq.onlinestatus.model;

import com.tencent.state.data.SquareJSConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0003B%\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/e;", "", "", "a", "I", "()I", "dataType", "", "", "b", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "uins", SquareJSConst.Params.PARAMS_NUMS, "<init>", "(I[Ljava/lang/String;I)V", "d", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int dataType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] uins;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int nums;

    public e(int i3, @NotNull String[] uins, int i16) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        this.dataType = i3;
        this.uins = uins;
        this.nums = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getDataType() {
        return this.dataType;
    }

    /* renamed from: b, reason: from getter */
    public final int getNums() {
        return this.nums;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String[] getUins() {
        return this.uins;
    }
}
