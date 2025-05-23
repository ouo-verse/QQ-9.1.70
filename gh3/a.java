package gh3;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lgh3/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setConfig", "(Ljava/lang/String;)V", DownloadInfo.spKey_Config, "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String config;

    public a(String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* renamed from: a, reason: from getter */
    public final String getConfig() {
        return this.config;
    }

    public String toString() {
        return this.config;
    }
}
