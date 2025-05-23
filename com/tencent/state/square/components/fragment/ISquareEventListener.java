package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/components/fragment/ISquareEventListener;", "Lcom/tencent/state/map/IMapViewListener;", "Lcom/tencent/state/FragmentComponent;", "onBackFromDetail", "", "bundle", "Landroid/os/Bundle;", "onFriendStatusPanelClosed", "onGoToDetail", "onMapDataReceived", "data", "Lcom/tencent/state/map/MapData;", "onMapWelcomeScaleAnimEnd", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareEventListener extends IMapViewListener, FragmentComponent {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iSquareEventListener, fragmentManager, f16);
        }

        public static void onDoubleClick(ISquareEventListener iSquareEventListener, MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onDoubleClick(iSquareEventListener, vh5, i3, mapItem, i16);
        }

        public static void onFragmentActivityCreated(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iSquareEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iSquareEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iSquareEventListener, fragmentManager, f16);
        }

        public static void onFragmentPaused(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iSquareEventListener, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iSquareEventListener, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iSquareEventListener, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iSquareEventListener, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iSquareEventListener, fragmentManager, f16);
        }

        public static void onFragmentStopped(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iSquareEventListener, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iSquareEventListener, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iSquareEventListener, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(ISquareEventListener iSquareEventListener, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iSquareEventListener, fragmentManager, f16, z16);
        }

        public static void onInVisible(ISquareEventListener iSquareEventListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onInVisible(iSquareEventListener, vh5, i3, mapItem);
        }

        public static void onItemBind(ISquareEventListener iSquareEventListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onItemBind(iSquareEventListener, vh5, i3, mapItem);
        }

        public static void onItemRecycled(ISquareEventListener iSquareEventListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onItemRecycled(iSquareEventListener, vh5, i3, mapItem);
        }

        public static void onMapSizeInitReady(ISquareEventListener iSquareEventListener) {
            IMapViewListener.DefaultImpls.onMapSizeInitReady(iSquareEventListener);
        }

        public static void onMapZoomEnd(ISquareEventListener iSquareEventListener, int i3, float f16, boolean z16) {
            IMapViewListener.DefaultImpls.onMapZoomEnd(iSquareEventListener, i3, f16, z16);
        }

        public static void onVisible(ISquareEventListener iSquareEventListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onVisible(iSquareEventListener, vh5, i3, mapItem);
        }

        public static void onItemBind(ISquareEventListener iSquareEventListener, MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onItemBind(iSquareEventListener, vh5, i3, mapItem, i16);
        }

        public static void onFriendStatusPanelClosed(ISquareEventListener iSquareEventListener) {
        }
    }

    void onBackFromDetail(Bundle bundle);

    void onFriendStatusPanelClosed();

    void onGoToDetail();

    void onMapDataReceived(MapData data);

    void onMapWelcomeScaleAnimEnd(MapData data);
}
