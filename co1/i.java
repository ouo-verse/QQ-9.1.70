package co1;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lco1/i;", "Lco1/j;", "", "d", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", IECDtReport.ACTION_IDENTIFIER, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i implements j {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String identifier = "";

    @Override // co1.h
    @NotNull
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // co1.j
    public void setIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identifier = str;
    }
}
