package com.tencent.mobileqq.guild.mainframe;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.app.FrameFragment;
import kotlin.Metadata;
import kotlin.time.ExperimentalTime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/app/FrameFragment;", "Landroidx/fragment/app/Fragment;", "fragment", "", "f", "d", "Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame;", AIInput.KEY_FRAME, "Ljava/lang/Runnable;", "e", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFragmentDelegateFrameKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FrameFragment frameFragment, Fragment fragment) {
        frameFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalTime
    public static final Runnable e(final GuildFragmentDelegateFrame guildFragmentDelegateFrame) {
        return new Runnable(guildFragmentDelegateFrame) { // from class: com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrameKt$newWeakDestroyGuildMainFragmentRunnable$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<GuildFragmentDelegateFrame> weakReference;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.weakReference = new WeakReference<>(guildFragmentDelegateFrame);
            }

            @Override // java.lang.Runnable
            public void run() {
                GuildFragmentDelegateFrame guildFragmentDelegateFrame2 = this.weakReference.get();
                if (guildFragmentDelegateFrame2 == null) {
                    return;
                }
                guildFragmentDelegateFrame2.recycleGuildMainFragment();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FrameFragment frameFragment, Fragment fragment) {
        frameFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.RESUMED).commitNowAllowingStateLoss();
    }
}
