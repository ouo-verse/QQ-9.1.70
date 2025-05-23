package com.tencent.state.library.components;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.common.push.BasePushManager;
import com.tencent.state.event.EnterLibraryEvent;
import com.tencent.state.library.LibraryFragment;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareGroupFragmentLibraryBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J,\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/library/components/LibraryGroupUiComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareGroupFragmentLibraryBinding;", "libraryFragment", "Lcom/tencent/state/library/LibraryFragment;", "pushManager", "Lcom/tencent/state/common/push/BasePushManager;", "getPushManager", "()Lcom/tencent/state/common/push/BasePushManager;", "initFragment", "", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryGroupUiComponent extends VasBaseFragmentComponent {
    private static final String TAG = "LibraryGroupUiComponent";
    private VasSquareGroupFragmentLibraryBinding binding;
    private LibraryFragment libraryFragment;
    private final BasePushManager pushManager = new BasePushManager(PageType.Library, 0, 2, null);

    private final void initFragment() {
        this.libraryFragment = new LibraryFragment();
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            fragment.pushFragment(this.libraryFragment);
        }
        SquareBaseKt.getSquareLog().i(TAG, "[LibraryEndFocus] doOnActivityCreate and dispatchEvent: EnterLibraryEvent");
        SimpleEventBus.getInstance().dispatchEvent(new EnterLibraryEvent());
    }

    public final BasePushManager getPushManager() {
        return this.pushManager;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareGroupFragmentLibraryBinding.bind(v3);
        initFragment();
    }
}
