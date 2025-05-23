package f93;

import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerPreviewFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFragment;", "a", "", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @Nullable
    public static final QCircleMediaPickerFragment a(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part.getHostFragment() instanceof QCircleMediaPickerFragment) {
            Fragment hostFragment = part.getHostFragment();
            Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment");
            return (QCircleMediaPickerFragment) hostFragment;
        }
        Fragment parentFragment = part.getHostFragment().getParentFragment();
        if (parentFragment instanceof QCircleMediaPickerFragment) {
            return (QCircleMediaPickerFragment) parentFragment;
        }
        return null;
    }

    public static final boolean b(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return part.getHostFragment() instanceof QCircleMediaPickerPreviewFragment;
    }
}
