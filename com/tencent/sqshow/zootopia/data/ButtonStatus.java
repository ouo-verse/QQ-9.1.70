package com.tencent.sqshow.zootopia.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "WAITING", "LOADING", "LOADED", QzoneDataUpdateAction.UPDATE, "MAINTENANCE", "UPDATE_SYSTEM", Tracker.PAUSE, "INVALID", "APPOINTED", "CAN_APPOINTMENT", "ONLY_DOWNLOAD", "CLOUD_GAME", "PHONE_MODEL_INVALID", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public enum ButtonStatus {
    INIT,
    WAITING,
    LOADING,
    LOADED,
    UPDATE,
    MAINTENANCE,
    UPDATE_SYSTEM,
    PAUSE,
    INVALID,
    APPOINTED,
    CAN_APPOINTMENT,
    ONLY_DOWNLOAD,
    CLOUD_GAME,
    PHONE_MODEL_INVALID;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ButtonStatus$a;", "", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "a", "type", "", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.ButtonStatus$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.sqshow.zootopia.data.ButtonStatus$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public /* synthetic */ class C9807a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f370280a;

            static {
                int[] iArr = new int[ButtonStatus.values().length];
                try {
                    iArr[ButtonStatus.INIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonStatus.LOADING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonStatus.PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ButtonStatus.LOADED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ButtonStatus.UPDATE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ButtonStatus.MAINTENANCE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ButtonStatus.WAITING.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ButtonStatus.APPOINTED.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[ButtonStatus.CLOUD_GAME.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                f370280a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ButtonStatus a(MapStatus mapStatus) {
            Intrinsics.checkNotNullParameter(mapStatus, "mapStatus");
            if (mapStatus == MapStatus.MAP_STATUS_WAITING_DOWNLOAD) {
                return ButtonStatus.WAITING;
            }
            if (mapStatus != MapStatus.MAP_STATUS_LOADING && mapStatus != MapStatus.MAP_STATUS_UNZIPPING) {
                if (mapStatus == MapStatus.MAP_STATUS_UPDATE) {
                    return ButtonStatus.UPDATE;
                }
                if (mapStatus == MapStatus.MAP_STATUS_NEED_UPDATE_QQ) {
                    return ButtonStatus.UPDATE_SYSTEM;
                }
                if (mapStatus == MapStatus.MAP_STATUS_HIGHER_QQ_VERSION) {
                    return ButtonStatus.MAINTENANCE;
                }
                if (mapStatus == MapStatus.MAP_STATUS_PHONE_MODEL_INVALID) {
                    return ButtonStatus.PHONE_MODEL_INVALID;
                }
                if (mapStatus == MapStatus.MAP_STATUS_OFF_SHELF) {
                    return ButtonStatus.INVALID;
                }
                if (mapStatus == MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE) {
                    return ButtonStatus.LOADED;
                }
                if (mapStatus == MapStatus.MAP_STATUS_APPOINTED) {
                    return ButtonStatus.APPOINTED;
                }
                if (mapStatus == MapStatus.MAP_STATUS_CAN_APPOINTMENT) {
                    return ButtonStatus.CAN_APPOINTMENT;
                }
                if (mapStatus == MapStatus.MAP_STATUS_ONLY_DOWNLOAD) {
                    return ButtonStatus.ONLY_DOWNLOAD;
                }
                if (mapStatus == MapStatus.MAP_STATUS_PAUSE) {
                    return ButtonStatus.PAUSE;
                }
                return ButtonStatus.INIT;
            }
            return ButtonStatus.LOADING;
        }

        Companion() {
        }

        public final int b(ButtonStatus type) {
            switch (type == null ? -1 : C9807a.f370280a[type.ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                    return 4;
                case 6:
                    return 5;
                case 7:
                    return 6;
                case 8:
                    return 7;
                case 9:
                    return 8;
                case 10:
                    return 9;
                case 11:
                    return 10;
                case 12:
                    return 11;
                default:
                    return -1;
            }
        }
    }
}
