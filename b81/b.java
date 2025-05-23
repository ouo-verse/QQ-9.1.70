package b81;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lb81/b;", "", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "", "a", "", "", "Lb81/a;", "Ljava/util/Map;", "handlerMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, a> handlerMap;

    public b() {
        HashMap hashMap = new HashMap();
        this.handlerMap = hashMap;
        hashMap.put("com.tencent.multimsgcontact", new c());
    }

    public final int a(@NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        a aVar = this.handlerMap.get(arkMsgModel.d() + arkMsgModel.e());
        if (aVar != null) {
            return aVar.a(arkMsgModel);
        }
        return 0;
    }
}
