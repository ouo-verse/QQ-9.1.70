package pc4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ'\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lpc4/a;", "", "Lcom/google/protobuf/nano/MessageNano;", "T", "", "key", "value", "", "b", "(Ljava/lang/String;Lcom/google/protobuf/nano/MessageNano;)V", "targetIns", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f425898a = new a();

    a() {
    }

    public final <T extends MessageNano> void a(String key, T targetIns) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(targetIns, "targetIns");
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes(key, new byte[0]);
        if (!(bytes.length == 0)) {
            try {
                MessageNano.mergeFrom(targetIns, bytes);
            } catch (Exception unused) {
            }
        }
    }

    public final <T extends MessageNano> void b(String key, T value) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            bArr = MessageNano.toByteArray(value);
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr == null) {
            return;
        }
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBytes(key, bArr);
    }
}
