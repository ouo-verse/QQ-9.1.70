package com.tencent.state.publicchat.component;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/publicchat/component/IPublicChatOwnerEventListener;", "Lcom/tencent/state/FragmentComponent;", "onSceneExit", "", "onSceneReady", "forceReload", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IPublicChatOwnerEventListener extends FragmentComponent {
    void onSceneExit();

    void onSceneReady(boolean forceReload);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentActivityCreated(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iPublicChatOwnerEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iPublicChatOwnerEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentPaused(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iPublicChatOwnerEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iPublicChatOwnerEventListener, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentStopped(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iPublicChatOwnerEventListener, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iPublicChatOwnerEventListener, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iPublicChatOwnerEventListener, fragmentManager, f16, z16);
        }

        public static /* synthetic */ void onSceneReady$default(IPublicChatOwnerEventListener iPublicChatOwnerEventListener, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                iPublicChatOwnerEventListener.onSceneReady(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSceneReady");
        }
    }
}
