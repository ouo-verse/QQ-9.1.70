package com.tencent.state.square.detail.components;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.FragmentComponent;
import com.tencent.state.square.data.SquareAvatarItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/square/detail/components/IDetailEventListener;", "Lcom/tencent/state/FragmentComponent;", "onFragmentEnter", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/square/data/SquareAvatarItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IDetailEventListener extends FragmentComponent {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentActivityCreated(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iDetailEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iDetailEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentPaused(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iDetailEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iDetailEventListener, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentStopped(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iDetailEventListener, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iDetailEventListener, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(IDetailEventListener iDetailEventListener, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iDetailEventListener, fragmentManager, f16, z16);
        }
    }

    void onFragmentEnter(SquareAvatarItem item);
}
