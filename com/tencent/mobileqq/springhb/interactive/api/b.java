package com.tencent.mobileqq.springhb.interactive.api;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqnt.msg.d;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\fH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/api/b;", "", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "d", "", "g", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/msg/d;", "msg", "e", "c", "Lkotlinx/coroutines/flow/Flow;", "b", "f", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "a", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    @NotNull
    InteractiveRecord a(@NotNull d record);

    @NotNull
    Flow<d> b();

    boolean c(@NotNull d msg2);

    @Nullable
    a d();

    boolean e(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull d msg2);

    @NotNull
    Flow<d> f();

    boolean g();
}
