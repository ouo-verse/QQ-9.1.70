package ny2;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lny2/a;", "", "", "b", "", "c", "", "a", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Ljava/lang/String;", "agreePrivateState", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f421586a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity entity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String agreePrivateState;

    static {
        MMKVOptionEntity from = QMMKV.from(RFWApplication.getApplication(), "QCIRCLE_MMKV_COMMON");
        Intrinsics.checkNotNullExpressionValue(from, "from(RFWApplication.getA\u2026File.FILE_QCIRCLE_COMMON)");
        entity = from;
        agreePrivateState = "-1";
    }

    a() {
    }

    @NotNull
    public final String a() {
        if (b()) {
            return "1";
        }
        return "0";
    }

    public final boolean b() {
        if (!Intrinsics.areEqual(agreePrivateState, "-1")) {
            return Intrinsics.areEqual(agreePrivateState, "1");
        }
        boolean decodeBool = entity.decodeBool("key_tvideo_has_shown_privacy", false);
        if (decodeBool) {
            agreePrivateState = "1";
        } else {
            agreePrivateState = "0";
        }
        return decodeBool;
    }

    public final void c() {
        entity.encodeBool("key_tvideo_has_shown_privacy", true);
        agreePrivateState = "1";
    }
}
