package kl;

import com.tencent.qqnt.kernel.nativeinterface.Notice;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tenpay.sdk.util.UinConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkl/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "()Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "setNotice", "(Lcom/tencent/qqnt/kernel/nativeinterface/Notice;)V", UinConfigManager.KEY_ADS, "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "()Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "setStCommonExt", "(Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;)V", "stCommonExt", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/Notice;Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Notice notice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private StCommonExt stCommonExt;

    public a(Notice notice, StCommonExt stCommonExt) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        Intrinsics.checkNotNullParameter(stCommonExt, "stCommonExt");
        this.notice = notice;
        this.stCommonExt = stCommonExt;
    }

    /* renamed from: a, reason: from getter */
    public final Notice getNotice() {
        return this.notice;
    }

    /* renamed from: b, reason: from getter */
    public final StCommonExt getStCommonExt() {
        return this.stCommonExt;
    }
}
