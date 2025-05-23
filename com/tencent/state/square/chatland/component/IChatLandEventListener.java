package com.tencent.state.square.chatland.component;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "Lcom/tencent/state/FragmentComponent;", "onChatLandLeaveRoom", "", "onChatLandSeatAdded", "onPublicChatConfigLoaded", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IChatLandEventListener extends FragmentComponent {
    void onChatLandLeaveRoom();

    void onChatLandSeatAdded();

    void onPublicChatConfigLoaded(PublicChatConfInfo conf);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentActivityCreated(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iChatLandEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iChatLandEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentPaused(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iChatLandEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iChatLandEventListener, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentStopped(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iChatLandEventListener, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iChatLandEventListener, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(IChatLandEventListener iChatLandEventListener, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iChatLandEventListener, fragmentManager, f16, z16);
        }

        public static void onPublicChatConfigLoaded(IChatLandEventListener iChatLandEventListener, PublicChatConfInfo conf) {
            Intrinsics.checkNotNullParameter(conf, "conf");
        }

        public static void onChatLandLeaveRoom(IChatLandEventListener iChatLandEventListener) {
        }

        public static void onChatLandSeatAdded(IChatLandEventListener iChatLandEventListener) {
        }
    }
}
