package com.tencent.qqnt.qbasealbum.ktx;

import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseMainFragment;", "a", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    @Nullable
    public static final QAlbumBaseMainFragment<?> a(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part.getPartHost() instanceof QAlbumBaseMainFragment) {
            IPartHost partHost = part.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment<*>");
            return (QAlbumBaseMainFragment) partHost;
        }
        Object partHost2 = part.getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment parentFragment = ((Fragment) partHost2).getParentFragment();
        if (parentFragment instanceof QAlbumBaseMainFragment) {
            return (QAlbumBaseMainFragment) parentFragment;
        }
        return null;
    }
}
