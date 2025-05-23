package com.tencent.state;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\r\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\u000f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\u0011\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J,\u0010\u0015\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\u0019\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0003H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/FragmentComponent;", "", "onBackPressed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentActivityCreated", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentCreated", "onFragmentDestroyed", "onFragmentPaused", "onFragmentPreCreated", "onFragmentResumed", "onFragmentSaveInstanceState", "outState", "onFragmentStarted", "onFragmentStopped", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentViewDestroyed", "onFragmentVisibilityChanged", "isVisible", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface FragmentComponent {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return false;
        }

        public static void onFragmentActivityCreated(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentCreated(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentDestroyed(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentPaused(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentPreCreated(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentResumed(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentSaveInstanceState(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        public static void onFragmentStarted(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentStopped(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentViewCreated(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
        }

        public static void onFragmentViewDestroyed(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }

        public static void onFragmentVisibilityChanged(FragmentComponent fragmentComponent, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
        }
    }

    boolean onBackPressed(FragmentManager fm5, Fragment f16);

    void onFragmentActivityCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState);

    void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState);

    void onFragmentDestroyed(FragmentManager fm5, Fragment f16);

    void onFragmentPaused(FragmentManager fm5, Fragment f16);

    void onFragmentPreCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState);

    void onFragmentResumed(FragmentManager fm5, Fragment f16);

    void onFragmentSaveInstanceState(FragmentManager fm5, Fragment f16, Bundle outState);

    void onFragmentStarted(FragmentManager fm5, Fragment f16);

    void onFragmentStopped(FragmentManager fm5, Fragment f16);

    void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState);

    void onFragmentViewDestroyed(FragmentManager fm5, Fragment f16);

    void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible);
}
