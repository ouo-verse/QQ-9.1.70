package com.tencent.state.template.map.component;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/template/map/component/ITemplateMapEvent;", "Lcom/tencent/state/FragmentComponent;", "Lcom/tencent/state/map/IMapViewListener;", "onCalendarButtonClicked", "", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onSeatButtonClicked", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ITemplateMapEvent extends FragmentComponent, IMapViewListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean onBackPressed(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            return FragmentComponent.DefaultImpls.onBackPressed(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onDoubleClick(ITemplateMapEvent iTemplateMapEvent, MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onDoubleClick(iTemplateMapEvent, vh5, i3, mapItem, i16);
        }

        public static void onFragmentActivityCreated(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentActivityCreated(iTemplateMapEvent, fragmentManager, f16, bundle);
        }

        public static void onFragmentCreated(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentCreated(iTemplateMapEvent, fragmentManager, f16, bundle);
        }

        public static void onFragmentDestroyed(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentDestroyed(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onFragmentPaused(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPaused(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onFragmentPreCreated(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentPreCreated(iTemplateMapEvent, fragmentManager, f16, bundle);
        }

        public static void onFragmentResumed(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentResumed(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onFragmentSaveInstanceState(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16, Bundle outState) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(outState, "outState");
            FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(iTemplateMapEvent, fragmentManager, f16, outState);
        }

        public static void onFragmentStarted(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStarted(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onFragmentStopped(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentStopped(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onFragmentViewCreated(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(v3, "v");
            FragmentComponent.DefaultImpls.onFragmentViewCreated(iTemplateMapEvent, fragmentManager, f16, v3, bundle);
        }

        public static void onFragmentViewDestroyed(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentViewDestroyed(iTemplateMapEvent, fragmentManager, f16);
        }

        public static void onFragmentVisibilityChanged(ITemplateMapEvent iTemplateMapEvent, FragmentManager fragmentManager, Fragment f16, boolean z16) {
            Intrinsics.checkNotNullParameter(f16, "f");
            FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(iTemplateMapEvent, fragmentManager, f16, z16);
        }

        public static void onInVisible(ITemplateMapEvent iTemplateMapEvent, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onInVisible(iTemplateMapEvent, vh5, i3, mapItem);
        }

        public static void onItemBind(ITemplateMapEvent iTemplateMapEvent, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onItemBind(iTemplateMapEvent, vh5, i3, mapItem);
        }

        public static void onItemRecycled(ITemplateMapEvent iTemplateMapEvent, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onItemRecycled(iTemplateMapEvent, vh5, i3, mapItem);
        }

        public static void onMapSizeInitReady(ITemplateMapEvent iTemplateMapEvent) {
            IMapViewListener.DefaultImpls.onMapSizeInitReady(iTemplateMapEvent);
        }

        public static void onMapZoomEnd(ITemplateMapEvent iTemplateMapEvent, int i3, float f16, boolean z16) {
            IMapViewListener.DefaultImpls.onMapZoomEnd(iTemplateMapEvent, i3, f16, z16);
        }

        public static void onVisible(ITemplateMapEvent iTemplateMapEvent, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onVisible(iTemplateMapEvent, vh5, i3, mapItem);
        }

        public static void onItemBind(ITemplateMapEvent iTemplateMapEvent, MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            IMapViewListener.DefaultImpls.onItemBind(iTemplateMapEvent, vh5, i3, mapItem, i16);
        }
    }

    void onCalendarButtonClicked();

    void onEnterRoom(EnterRoomInfo info);

    void onMeFocusEnd();

    void onMeFocusStart(User user);

    void onSeatButtonClicked(SeatButtonState state);
}
