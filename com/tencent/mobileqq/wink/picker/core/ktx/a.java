package com.tencent.mobileqq.wink.picker.core.ktx;

import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "b", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @Nullable
    public static final WinkMediaPickerChildFragment a(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Fragment hostFragment = part.getHostFragment();
        if (hostFragment instanceof WinkMediaPickerChildFragment) {
            return (WinkMediaPickerChildFragment) hostFragment;
        }
        return null;
    }

    @Nullable
    public static final WinkMediaPickerMainBaseFragment<?> b(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part.getHostFragment() instanceof WinkMediaPickerMainBaseFragment) {
            Fragment hostFragment = part.getHostFragment();
            Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment<*>");
            return (WinkMediaPickerMainBaseFragment) hostFragment;
        }
        Fragment parentFragment = part.getHostFragment().getParentFragment();
        if (parentFragment instanceof WinkMediaPickerMainBaseFragment) {
            return (WinkMediaPickerMainBaseFragment) parentFragment;
        }
        return null;
    }
}
