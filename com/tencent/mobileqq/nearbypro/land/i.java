package com.tencent.mobileqq.nearbypro.land;

import android.view.MotionEvent;
import com.tencent.biz.richframework.part.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/i;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/nearbypro/land/h;", "areaParam", "", "C9", "update", "Leb2/a;", "clickedData", "Landroid/view/MotionEvent;", "clickEvent", "", "A9", "", "d", "I", "z9", "()I", "containerId", "e", "Lcom/tencent/mobileqq/nearbypro/land/h;", "x9", "()Lcom/tencent/mobileqq/nearbypro/land/h;", "B9", "(Lcom/tencent/mobileqq/nearbypro/land/h;)V", "<init>", "(I)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class i extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int containerId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected AreaParam areaParam;

    public i(int i3) {
        this.containerId = i3;
    }

    public boolean A9(@NotNull eb2.a clickedData, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        return false;
    }

    protected final void B9(@NotNull AreaParam areaParam) {
        Intrinsics.checkNotNullParameter(areaParam, "<set-?>");
        this.areaParam = areaParam;
    }

    public final void C9(@NotNull AreaParam areaParam) {
        Intrinsics.checkNotNullParameter(areaParam, "areaParam");
        B9(areaParam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AreaParam x9() {
        AreaParam areaParam = this.areaParam;
        if (areaParam != null) {
            return areaParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("areaParam");
        return null;
    }

    /* renamed from: z9, reason: from getter */
    public final int getContainerId() {
        return this.containerId;
    }

    public void update() {
    }
}
