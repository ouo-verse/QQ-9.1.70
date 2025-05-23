package com.tencent.mobileqq.zplan.aio.badge;

import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/a;", "Lcom/tencent/mobileqq/zplan/aio/badge/c;", "", "", "d", "Ljava/util/List;", "c", "()Ljava/util/List;", SquareJSConst.Params.PARAMS_UIN_LIST, "", "type", "", "text", "lifeTime", "<init>", "(ILjava/lang/String;ILjava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Long> uinList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i3, String text, int i16, List<Long> uinList) {
        super(i3, text, i16);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        this.uinList = uinList;
    }

    public final List<Long> c() {
        return this.uinList;
    }
}
