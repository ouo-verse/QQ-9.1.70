package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.er;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ch;", "Lwh2/er;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserAVRspInfo;", "rspInfo", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/media/core/logic/t;", "Ljava/lang/ref/WeakReference;", "ref", "b", "I", "screenState", "", "c", "Z", "needCheckRsp", "<init>", "(Ljava/lang/ref/WeakReference;IZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ch implements er {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<t> ref;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int screenState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean needCheckRsp;

    public ch(@NotNull WeakReference<t> ref, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
        this.screenState = i3;
        this.needCheckRsp = z16;
    }

    @Override // wh2.er
    public void a(int result, @Nullable String errMsg, @Nullable IGProUserAVRspInfo rspInfo) {
        t tVar = this.ref.get();
        if (tVar != null) {
            tVar.k(result, errMsg, rspInfo, this.screenState, this.needCheckRsp);
        }
    }
}
