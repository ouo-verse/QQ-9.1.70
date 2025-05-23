package com.tencent.state.library.focus.component;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusTimerComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "timeHandler", "Landroid/os/Handler;", "timeTask", "com/tencent/state/library/focus/component/FocusTimerComponent$timeTask$1", "Lcom/tencent/state/library/focus/component/FocusTimerComponent$timeTask$1;", "onFragmentDestroyed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "pauseTimer", "restartTimer", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusTimerComponent extends FocusBaseComponent {
    private static final long DELAY_TIME = 1000;
    private final Handler timeHandler = new Handler(Looper.getMainLooper());
    private FocusTimerComponent$timeTask$1 timeTask = new Runnable() { // from class: com.tencent.state.library.focus.component.FocusTimerComponent$timeTask$1
        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            Handler handler2;
            IFocusParentView fragmentView;
            FocusCommonView commonView;
            VasSquareLibraryCommonViewBinding binding;
            LibraryFocusTimeBubble libraryFocusTimeBubble;
            handler = FocusTimerComponent.this.timeHandler;
            handler.removeCallbacks(this);
            FocusBaseFragment focusFragment = FocusTimerComponent.this.getFocusFragment();
            if (focusFragment != null && (fragmentView = focusFragment.getFragmentView()) != null && (commonView = fragmentView.getCommonView()) != null && (binding = commonView.getBinding()) != null && (libraryFocusTimeBubble = binding.focusTimeBubble) != null) {
                LibraryFocusTimeBubble.updateFocusTimeUI$default(libraryFocusTimeBubble, null, 1, null);
            }
            handler2 = FocusTimerComponent.this.timeHandler;
            handler2.postDelayed(this, 1000L);
        }
    };

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        pauseTimer();
    }

    public final void pauseTimer() {
        this.timeHandler.removeCallbacks(this.timeTask);
    }

    public final void restartTimer() {
        this.timeHandler.removeCallbacks(this.timeTask);
        this.timeHandler.post(this.timeTask);
    }
}
