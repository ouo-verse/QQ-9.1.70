package com.tencent.state.library.focus.component;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.FragmentComponent;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/library/focus/component/IFocusEventListener;", "Lcom/tencent/state/FragmentComponent;", "onChatBoxClicked", "", "v", "Landroid/view/View;", "onComeOnButtonClicked", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onEmptyTableClicked", "type", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "onEnterFocus", "data", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "onFuncButtonClicked", "Lcom/tencent/state/library/focus/view/ClickType;", "onViewClick", "viewId", "extra", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IFocusEventListener extends FragmentComponent {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentActivityCreated(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iFocusEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iFocusEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentPaused(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iFocusEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iFocusEventListener, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentStopped(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iFocusEventListener, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iFocusEventListener, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(IFocusEventListener iFocusEventListener, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iFocusEventListener, fragmentManager, f16, z16);
        }
    }

    void onChatBoxClicked(View v3);

    void onComeOnButtonClicked(User user);

    void onEmptyTableClicked(int type, FocusItem item);

    void onEnterFocus(FocusBaseItem data);

    void onFuncButtonClicked(ClickType type);

    void onViewClick(int viewId, Object extra);
}
