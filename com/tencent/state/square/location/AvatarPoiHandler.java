package com.tencent.state.square.location;

import android.content.Intent;
import com.tencent.state.square.Square;
import com.tencent.state.square.data.AvatarLocationInfo;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/location/AvatarPoiHandler;", "", "()V", "isPoiChange", "", "selectPoi", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "copy", "getAvatarLocation", "getPoiInfo", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "callback", "Lcom/tencent/state/square/location/IPoiHandler;", "setPoiInfo", "locationInfo", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarPoiHandler {
    private boolean isPoiChange;
    private AvatarLocationInfo selectPoi = new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int QZ_GET_LOCATION_FOR_POI = 1208;
    private static final String QZ_GET_LOCATION_FOR_EXTRA = "square_poi_info";
    private static final String INVALIDE_POI_ID = "invalide_poi_id";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/location/AvatarPoiHandler$Companion;", "", "()V", "INVALIDE_POI_ID", "", "getINVALIDE_POI_ID", "()Ljava/lang/String;", "QZ_GET_LOCATION_FOR_EXTRA", "getQZ_GET_LOCATION_FOR_EXTRA", "QZ_GET_LOCATION_FOR_POI", "", "getQZ_GET_LOCATION_FOR_POI", "()I", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final String getINVALIDE_POI_ID() {
            return AvatarPoiHandler.INVALIDE_POI_ID;
        }

        public final String getQZ_GET_LOCATION_FOR_EXTRA() {
            return AvatarPoiHandler.QZ_GET_LOCATION_FOR_EXTRA;
        }

        public final int getQZ_GET_LOCATION_FOR_POI() {
            return AvatarPoiHandler.QZ_GET_LOCATION_FOR_POI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final AvatarLocationInfo copy() {
        return new AvatarLocationInfo(this.selectPoi.getLongitude(), this.selectPoi.getLatitude(), this.selectPoi.getPoi(), this.selectPoi.getPoiId(), this.selectPoi.getPoiAddress());
    }

    /* renamed from: getAvatarLocation, reason: from getter */
    public final AvatarLocationInfo getSelectPoi() {
        return this.selectPoi;
    }

    public final void getPoiInfo(int requestCode, int resultCode, Intent data, IPoiHandler callback) {
        if (requestCode == (QZ_GET_LOCATION_FOR_POI & 65535) && resultCode == -1) {
            Square.INSTANCE.getConfig().getRouter().getSquarePoiInfo(data);
            Serializable serializableExtra = data != null ? data.getSerializableExtra(QZ_GET_LOCATION_FOR_EXTRA) : null;
            if (serializableExtra instanceof AvatarLocationInfo) {
                AvatarLocationInfo avatarLocationInfo = (AvatarLocationInfo) serializableExtra;
                boolean z16 = !Intrinsics.areEqual(avatarLocationInfo.getPoiId(), this.selectPoi.getPoiId());
                this.isPoiChange = z16;
                this.selectPoi = Intrinsics.areEqual(avatarLocationInfo.getPoiId(), INVALIDE_POI_ID) ? new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null) : avatarLocationInfo;
                if (callback != null) {
                    callback.poiChange(avatarLocationInfo, z16);
                }
            }
        }
    }

    /* renamed from: isPoiChange, reason: from getter */
    public final boolean getIsPoiChange() {
        return this.isPoiChange;
    }

    public final void setPoiInfo(AvatarLocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        if (locationInfo.getPoi().length() > 0) {
            this.selectPoi.setPoi(locationInfo.getPoi());
            this.selectPoi.setPoiId(locationInfo.getPoiId());
            this.selectPoi.setPoiAddress(locationInfo.getPoiAddress());
            this.selectPoi.setLongitude(locationInfo.getLongitude());
            this.selectPoi.setLatitude(locationInfo.getLatitude());
        }
    }
}
