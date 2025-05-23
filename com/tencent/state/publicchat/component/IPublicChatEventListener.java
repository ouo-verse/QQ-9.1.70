package com.tencent.state.publicchat.component;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/publicchat/component/IPublicChatEventListener;", "Lcom/tencent/state/FragmentComponent;", "onConfigLoaded", "", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IPublicChatEventListener extends FragmentComponent {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentActivityCreated(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iPublicChatEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iPublicChatEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentPaused(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iPublicChatEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iPublicChatEventListener, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentStopped(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iPublicChatEventListener, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iPublicChatEventListener, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(IPublicChatEventListener iPublicChatEventListener, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iPublicChatEventListener, fragmentManager, f16, z16);
        }
    }

    void onConfigLoaded(PublicChatConfInfo conf);

    void onMsgAction(MsgAction action);
}
