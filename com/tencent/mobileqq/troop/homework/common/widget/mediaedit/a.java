package com.tencent.mobileqq.troop.homework.common.widget.mediaedit;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import qs2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/a;", "Lqs2/c;", "Lqs2/b;", "listener", "", "showPickerView", "", "B", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "manager", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "setMediaEditManager", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a extends c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8729a {
        public static /* synthetic */ void a(a aVar, qs2.b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                aVar.B(bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMediaPickerView");
        }
    }

    void B(@NotNull qs2.b listener, boolean showPickerView);

    void setMediaEditManager(@NotNull f manager, @NotNull LifecycleOwner lifecycleOwner);
}
