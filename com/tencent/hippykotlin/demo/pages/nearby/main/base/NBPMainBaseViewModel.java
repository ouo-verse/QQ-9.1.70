package com.tencent.hippykotlin.demo.pages.nearby.main.base;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.kuikly.core.base.event.ClickParams;
import f35.g;
import java.util.List;
import o25.f;

/* loaded from: classes31.dex */
public abstract class NBPMainBaseViewModel implements INBPMainLifeCycle {
    public NBPMainMode mainMode = NBPMainMode.Normal;
    public NBPSubMode subMode = NBPSubMode.Normal;

    public void onModeChanged(NBPMainMode nBPMainMode, NBPSubMode nBPSubMode) {
        this.mainMode = nBPMainMode;
        this.subMode = nBPSubMode;
    }

    public void onBeforeSetSigData() {
    }

    public void onEnterMap() {
    }

    public void onFirstPositionChangeFinish() {
    }

    public void onLocationPermissionGranted(boolean z16) {
    }

    public void onMapCameraChanged(CameraPosition cameraPosition) {
    }

    public void onMapCameraChangedFinish(CameraPosition cameraPosition) {
    }

    public void onMapClick(ClickParams clickParams) {
    }

    public void onMapThemeChanged(f fVar) {
    }

    public void onMapThemesLoaded() {
    }

    public void onMarkersDisplayed(List<NBPMapMarker> list) {
    }

    public void onNBPBeforeLogin() {
    }

    public void onPageDidAppear() {
    }

    public void onPageDidDisappear() {
    }

    public void onPagerCreated() {
    }

    public void onPagerViewDidLoad() {
    }

    public void onPagerWillDestroy() {
    }

    public void onRequestLocationPermission() {
    }

    public void onFetchMaker(int i3, String str) {
    }

    public void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
    }

    public void onNBPLogin(boolean z16, g gVar) {
    }

    public void onReceiveEvent(String str, Object obj) {
    }
}
