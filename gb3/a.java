package gb3;

import com.tencent.freesia.IConfigData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u000f\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lgb3/a;", "Lcom/tencent/freesia/IConfigData;", "", "appId", "", "c", "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "blackAppIdList", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "errorTips", "<init>", "()V", "f", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<String> blackAppIdList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String errorTips = "";

    public final List<String> a() {
        return this.blackAppIdList;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorTips() {
        return this.errorTips;
    }

    public final boolean c(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return this.blackAppIdList.contains(appId);
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorTips = str;
    }
}
