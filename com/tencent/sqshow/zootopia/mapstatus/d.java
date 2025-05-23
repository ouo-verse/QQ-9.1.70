package com.tencent.sqshow.zootopia.mapstatus;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ!\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/d;", "", "", "mapStatus", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "b", "(ILjava/lang/Integer;)Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "qqVerTip", "c", "mapVer", "", "localVersion", "serverVersion", "a", "", "progress", "f", "(Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;Ljava/lang/Float;)Ljava/lang/Float;", "errorCode", "d", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f370777a = new d();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f370778a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f370778a = iArr;
        }
    }

    d() {
    }

    public final MapStatus a(int mapVer, String localVersion, String serverVersion) {
        Intrinsics.checkNotNullParameter(localVersion, "localVersion");
        Intrinsics.checkNotNullParameter(serverVersion, "serverVersion");
        if (mapVer != 1 || Intrinsics.areEqual(serverVersion, localVersion)) {
            return null;
        }
        return MapStatus.MAP_STATUS_UPDATE;
    }

    public final Float f(MapStatus mapStatus, Float progress) {
        Intrinsics.checkNotNullParameter(mapStatus, "mapStatus");
        int i3 = a.f370778a[mapStatus.ordinal()];
        return (i3 == 1 || i3 == 2 || i3 == 3) ? Float.valueOf(0.0f) : progress;
    }

    public final MapStatus d(Integer downloadStatus, Integer errorCode) {
        if (downloadStatus != null && downloadStatus.intValue() == 1) {
            return MapStatus.MAP_STATUS_WAITING_DOWNLOAD;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 2) {
            return MapStatus.MAP_STATUS_LOADING;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 3) {
            return MapStatus.MAP_STATUS_UNZIPPING;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 4) {
            return MapStatus.MAP_STATUS_PAUSE;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 8) {
            return MapStatus.MAP_STATUS_DOWNLOAD_INTERRUPT;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 5) {
            return MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 6) {
            if (errorCode != null && errorCode.intValue() == -2) {
                return MapStatus.MAP_STATUS_DEPRESS_FAILED;
            }
            if (errorCode != null && errorCode.intValue() == -5) {
                return MapStatus.MAP_STATUS_DEPRESS_FAILED;
            }
            return MapStatus.MAP_STATUS_DOWNLOAD_FAILED;
        }
        if (downloadStatus != null && downloadStatus.intValue() == 7) {
            return MapStatus.MAP_STATUS_UPDATE;
        }
        return MapStatus.MAP_STATUS_INIT;
    }

    public static /* synthetic */ MapStatus e(d dVar, Integer num, Integer num2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num2 = null;
        }
        return dVar.d(num, num2);
    }

    public final MapStatus c(int qqVerTip) {
        if (qqVerTip == 1) {
            return MapStatus.MAP_STATUS_NEED_UPDATE_QQ;
        }
        if (qqVerTip != 2) {
            return null;
        }
        return MapStatus.MAP_STATUS_HIGHER_QQ_VERSION;
    }

    public final MapStatus b(int mapStatus, Integer downloadStatus) {
        if (mapStatus == 1) {
            return MapStatus.MAP_STATUS_OFF_SHELF;
        }
        if (mapStatus != 2) {
            switch (mapStatus) {
                case 11:
                    return MapStatus.MAP_STATUS_CAN_APPOINTMENT;
                case 12:
                    return MapStatus.MAP_STATUS_APPOINTED;
                case 13:
                    if (downloadStatus != null && downloadStatus.intValue() == 5) {
                        return MapStatus.MAP_STATUS_ONLY_DOWNLOAD;
                    }
                    return null;
                default:
                    return null;
            }
        }
        return MapStatus.MAP_STATUS_PHONE_MODEL_INVALID;
    }
}
