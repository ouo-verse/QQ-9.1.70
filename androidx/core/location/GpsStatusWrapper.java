package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;

    @GuardedBy("mWrapped")
    private Iterator<GpsSatellite> mCachedIterator;

    @GuardedBy("mWrapped")
    private int mCachedIteratorPosition;

    @GuardedBy("mWrapped")
    private GpsSatellite mCachedSatellite;

    @GuardedBy("mWrapped")
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int i3) {
        if (i3 > 0 && i3 <= 32) {
            return 1;
        }
        if (i3 >= 33 && i3 <= 64) {
            return 2;
        }
        if (i3 > 64 && i3 <= 88) {
            return 3;
        }
        if (i3 > 200 && i3 <= 235) {
            return 5;
        }
        if (i3 >= 193 && i3 <= 200) {
            return 4;
        }
        return 0;
    }

    private GpsSatellite getSatellite(int i3) {
        GpsSatellite gpsSatellite;
        synchronized (this.mWrapped) {
            if (i3 < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }
            while (true) {
                int i16 = this.mCachedIteratorPosition;
                if (i16 >= i3) {
                    break;
                }
                this.mCachedIteratorPosition = i16 + 1;
                if (!this.mCachedIterator.hasNext()) {
                    this.mCachedSatellite = null;
                    break;
                }
                this.mCachedSatellite = this.mCachedIterator.next();
            }
            gpsSatellite = this.mCachedSatellite;
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    private static int getSvidFromPrn(int i3) {
        int constellationFromPrn = getConstellationFromPrn(i3);
        if (constellationFromPrn != 2) {
            if (constellationFromPrn != 3) {
                if (constellationFromPrn == 5) {
                    return i3 - 200;
                }
                return i3;
            }
            return i3 - 64;
        }
        return i3 + 87;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i3) {
        return getSatellite(i3).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i3) {
        return getSatellite(i3).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i3) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return getConstellationFromPrn(getSatellite(i3).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i3) {
        return getSatellite(i3).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int i3;
        synchronized (this.mWrapped) {
            if (this.mCachedSatelliteCount == -1) {
                for (GpsSatellite gpsSatellite : this.mWrapped.getSatellites()) {
                    this.mCachedSatelliteCount++;
                }
                this.mCachedSatelliteCount++;
            }
            i3 = this.mCachedSatelliteCount;
        }
        return i3;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i3) {
        if (Build.VERSION.SDK_INT < 24) {
            return getSatellite(i3).getPrn();
        }
        return getSvidFromPrn(getSatellite(i3).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i3) {
        return getSatellite(i3).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i3) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i3) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i3) {
        return getSatellite(i3).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i3) {
        return getSatellite(i3).usedInFix();
    }
}
