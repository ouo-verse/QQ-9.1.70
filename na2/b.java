package na2;

import com.tencent.mobileqq.nearbypro.utils.FormatUtils;
import kotlin.Metadata;
import op4.i;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lna2/b;", "Lna2/a;", "Lop4/i;", "Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "b", "Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "c", "()Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "d", "(Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;)V", "stateTagTime", "", "I", "getVisibleCount", "()I", "e", "(I)V", "visibleCount", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends a<i> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FormatUtils.StateTagTime stateTagTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int visibleCount;

    @Nullable
    /* renamed from: c, reason: from getter */
    public final FormatUtils.StateTagTime getStateTagTime() {
        return this.stateTagTime;
    }

    public final void d(@Nullable FormatUtils.StateTagTime stateTagTime) {
        this.stateTagTime = stateTagTime;
    }

    public final void e(int i3) {
        this.visibleCount = i3;
    }
}
