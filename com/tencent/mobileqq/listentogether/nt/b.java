package com.tencent.mobileqq.listentogether.nt;

import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/listentogether/nt/b;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "a", "I", "b", "()I", "uinType", "", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "<init>", "(ILjava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int uinType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    public b(int i3, String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uinType = i3;
        this.uin = uin;
    }

    /* renamed from: a, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: b, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        return 59;
    }
}
