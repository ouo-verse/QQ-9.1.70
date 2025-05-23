package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ax extends aw<ap> implements Marker {

    /* renamed from: b, reason: collision with root package name */
    public final ap f147778b;

    public ax(ap apVar) {
        this.f147778b = apVar;
    }

    private ap b() {
        return this.f147778b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final MarkerCollisionRelationUnit addCollisionUnit(MarkerOptions markerOptions) {
        return this.f147778b.addCollisionUnit(markerOptions);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ax.class == obj.getClass()) {
            return Objects.equals(this.f147778b.getId(), ((ax) obj).f147778b.getId());
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ ap f_() {
        return this.f147778b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public final float getAlpha() {
        return this.f147778b.getAlpha();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public final float getAnchorU() {
        return this.f147778b.getAnchorU();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public final float getAnchorV() {
        return this.f147778b.getAnchorV();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible
    public final String getContentDescription() {
        ap apVar = this.f147778b;
        if (apVar != null) {
            return apVar.getContentDescription();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final float getEqualScale() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return 0.0f;
        }
        return apVar.getEqualScale();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final int getHeight(Context context) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return 0;
        }
        return apVar.getHeight(context);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final MarkerOptions getOptions() {
        return this.f147778b.getOptions();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final LatLng getPosition() {
        return this.f147778b.getPosition();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable
    public final float getRotation() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return 0.0f;
        }
        return apVar.getRotation();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final float[] getScale() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return new float[]{0.0f, 0.0f};
        }
        return apVar.getScale();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final String getSnippet() {
        return this.f147778b.getSnippet();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final Object getTag() {
        return this.f147778b.getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final String getTitle() {
        return this.f147778b.getTitle();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final int getWidth(Context context) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return 0;
        }
        return apVar.getWidth(context);
    }

    public final int hashCode() {
        return Objects.hash(this.f147778b.getId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void hideInfoWindow() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.hideInfoWindow();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final boolean isClickable() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return false;
        }
        return apVar.isClickable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final boolean isCollisionBy(Collision collision) {
        ap apVar = this.f147778b;
        if (apVar != null) {
            return apVar.isCollisionBy(collision);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable
    public final boolean isDraggable() {
        return this.f147778b.isDraggable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final boolean isFastLoad() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return false;
        }
        return apVar.isFastLoad();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final boolean isInfoWindowEnable() {
        return this.f147778b.isInfoWindowEnable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final boolean isInfoWindowShown() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return false;
        }
        return apVar.isInfoWindowShown();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void refreshInfoWindow() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.refreshInfoWindow();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void removeCollisionUnit(MarkerCollisionRelationUnit markerCollisionRelationUnit) {
        this.f147778b.removeCollisionUnit(markerCollisionRelationUnit);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public final void setAlpha(float f16) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setAlpha(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public final void setAnchor(float f16, float f17) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setAnchor(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void setAnimation(Animation animation) {
        ap apVar = this.f147778b;
        if (apVar != null && animation != null) {
            apVar.setAnimation(animation);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final void setClickable(boolean z16) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setClickable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public final void setCollisions(Collision... collisionArr) {
        ap apVar = this.f147778b;
        if (apVar != null) {
            apVar.setCollisions(collisionArr);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible
    public final void setContentDescription(String str) {
        ap apVar = this.f147778b;
        if (apVar != null) {
            apVar.setContentDescription(str);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable
    public final void setDraggable(boolean z16) {
        boolean z17;
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setDraggable(z16);
        ap apVar2 = this.f147778b;
        if (!z16 && apVar2.b()) {
            z17 = true;
        } else {
            z17 = false;
        }
        apVar2.setFixingPointEnable(z17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final void setEqualScale(float f16) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setEqualScale(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setFastLoad(boolean z16) {
        this.f147778b.setFastLoad(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setFixingPoint(int i3, int i16) {
        this.f147778b.setFixingPoint(i3, i16);
        this.f147778b.setDraggable(false);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setFixingPointEnable(boolean z16) {
        this.f147778b.setFixingPointEnable(z16);
        if (this.f147778b.isDraggable()) {
            setDraggable(!z16);
        }
        if (!z16) {
            ap apVar = this.f147778b;
            apVar.setPosition(apVar.getPosition());
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setIcon(bitmapDescriptor);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setIconLooper(BitmapDescriptor bitmapDescriptor, boolean z16, int i3) {
        this.f147778b.setIconLooper(bitmapDescriptor, z16, i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setInfoWindowAnchor(float f16, float f17) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setInfoWindowAnchor(f16, f17);
        refreshInfoWindow();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setInfoWindowEnable(boolean z16) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setInfoWindowEnable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setInfoWindowOffset(int i3, int i16) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setInfoWindowOffset(i3, i16);
        refreshInfoWindow();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setOnTop() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setOnTop();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setPosition(LatLng latLng) {
        ap apVar = this.f147778b;
        if (apVar != null && latLng != null) {
            apVar.setPosition(latLng);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable
    public final void setRotation(float f16) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setRotation(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public final void setScale(float f16, float f17) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setScale(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setSnippet(String str) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setSnippet(str);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final void setTag(Object obj) {
        this.f147778b.setTag(obj);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void setTitle(String str) {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.setTitle(str);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public final void showInfoWindow() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return;
        }
        apVar.showInfoWindow();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final boolean startAnimation() {
        ap apVar = this.f147778b;
        if (apVar == null) {
            return false;
        }
        return apVar.startAnimation();
    }

    public final String toString() {
        return "MarkerOverlay{id='" + getId() + "'nativeId='" + this.f147778b.a() + "'}";
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public final void startAnimation(Animation animation) {
        setAnimation(animation);
        startAnimation();
    }
}
