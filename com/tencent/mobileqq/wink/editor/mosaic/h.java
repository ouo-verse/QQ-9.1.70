package com.tencent.mobileqq.wink.editor.mosaic;

import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/h;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "", "oa", "", "B9", "Landroid/os/Bundle;", "args", "L9", "", "onBackEvent", "<init>", "()V", "M", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h extends WinkEditorMenuPart {
    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zf_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        List<MediaClip> a06;
        dr H9;
        List<MosaicData> A;
        FragmentManager childFragmentManager;
        com.tencent.mobileqq.wink.editor.a aVar;
        super.L9(args);
        dr H92 = H9();
        if (H92 != null && (a06 = H92.a0()) != null && (H9 = H9()) != null && (A = H9.A()) != null) {
            dr H93 = H9();
            Intrinsics.checkNotNull(H93, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkImageTavCut");
            int currentPosition = ((WinkImageTavCut) H93).getCurrentPosition();
            Fragment hostFragment = getHostFragment();
            if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
                childFragmentManager.beginTransaction().add(R.id.f123867ht, WinkEditorMosaicFragment.INSTANCE.a(new ArrayList<>(a06), new ArrayList<>(A), currentPosition), "MOSAIC_TAG").addToBackStack("MOSAIC_TAG").commit();
                ActivityResultCaller hostFragment2 = getHostFragment();
                if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                    aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.g1(true);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.MOSAIC;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        FragmentManager fragmentManager;
        int i3;
        String str;
        FragmentManager.BackStackEntry backStackEntryAt;
        Fragment hostFragment = getHostFragment();
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (hostFragment != null) {
            fragmentManager = hostFragment.getChildFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            i3 = fragmentManager.getBackStackEntryCount();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (fragmentManager != null && (backStackEntryAt = fragmentManager.getBackStackEntryAt(i3 - 1)) != null) {
                str = backStackEntryAt.getName();
            } else {
                str = null;
            }
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
            if (Intrinsics.areEqual(str, "MOSAIC_TAG")) {
                ActivityResultCaller hostFragment2 = getHostFragment();
                if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                    aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
                }
                if (aVar != null) {
                    aVar.g1(false);
                }
                x9();
            }
            return true;
        }
        x9();
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
