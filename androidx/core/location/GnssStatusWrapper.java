package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* compiled from: P */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GnssStatusWrapper(GnssStatus gnssStatus) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull(gnssStatus);
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (obj instanceof GnssStatusWrapper) {
            equals = this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
            return equals;
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i3) {
        float azimuthDegrees;
        azimuthDegrees = this.mWrapped.getAzimuthDegrees(i3);
        return azimuthDegrees;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i3) {
        float basebandCn0DbHz;
        if (Build.VERSION.SDK_INT >= 30) {
            basebandCn0DbHz = this.mWrapped.getBasebandCn0DbHz(i3);
            return basebandCn0DbHz;
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i3) {
        float carrierFrequencyHz;
        if (Build.VERSION.SDK_INT >= 26) {
            carrierFrequencyHz = this.mWrapped.getCarrierFrequencyHz(i3);
            return carrierFrequencyHz;
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i3) {
        float cn0DbHz;
        cn0DbHz = this.mWrapped.getCn0DbHz(i3);
        return cn0DbHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i3) {
        int constellationType;
        constellationType = this.mWrapped.getConstellationType(i3);
        return constellationType;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i3) {
        float elevationDegrees;
        elevationDegrees = this.mWrapped.getElevationDegrees(i3);
        return elevationDegrees;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int satelliteCount;
        satelliteCount = this.mWrapped.getSatelliteCount();
        return satelliteCount;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i3) {
        int svid;
        svid = this.mWrapped.getSvid(i3);
        return svid;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i3) {
        boolean hasAlmanacData;
        hasAlmanacData = this.mWrapped.hasAlmanacData(i3);
        return hasAlmanacData;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i3) {
        boolean hasBasebandCn0DbHz;
        if (Build.VERSION.SDK_INT >= 30) {
            hasBasebandCn0DbHz = this.mWrapped.hasBasebandCn0DbHz(i3);
            return hasBasebandCn0DbHz;
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i3) {
        boolean hasCarrierFrequencyHz;
        if (Build.VERSION.SDK_INT >= 26) {
            hasCarrierFrequencyHz = this.mWrapped.hasCarrierFrequencyHz(i3);
            return hasCarrierFrequencyHz;
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i3) {
        boolean hasEphemerisData;
        hasEphemerisData = this.mWrapped.hasEphemerisData(i3);
        return hasEphemerisData;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.mWrapped.hashCode();
        return hashCode;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i3) {
        boolean usedInFix;
        usedInFix = this.mWrapped.usedInFix(i3);
        return usedInFix;
    }
}
