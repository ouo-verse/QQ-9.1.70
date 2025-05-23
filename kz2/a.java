package kz2;

import com.tencent.freesia.IConfigData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkz2/a;", "Lcom/tencent/freesia/IConfigData;", "", "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "heartbeatDeltaTimes", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> heartbeatDeltaTimes = new ArrayList();

    @NotNull
    public final List<Integer> a() {
        return this.heartbeatDeltaTimes;
    }
}
