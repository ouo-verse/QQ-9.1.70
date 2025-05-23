package com.tencent.mapsdk.engine.jni.models;

import android.support.annotation.Keep;
import com.tencent.mapsdk.internal.mt;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class TappedElement {
    private static final int BUILDING_ID_LENGTH = 128;
    private static final int BUILDING_NAME_LENGTH = 68;
    private static final int FLOOR_NAME_LENGTH = 32;
    private static final int POI_ID_LENGTH = 64;
    public static final int TYPE_ANNO = 1;
    public static final int TYPE_ANNO_INDOOR_MAP = 1;
    public static final int TYPE_BLOCKROUTE_ANNO = 7;
    public static final int TYPE_COMPASS = 3;
    public static final int TYPE_INDOORMAP_AREA = 8;
    public static final int TYPE_LINE = 5;
    public static final int TYPE_LOCATION_MARKER = 6;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OVERLAY_ITEM = 4;
    public String buildingId;
    public String buildingName;
    public String floorName;
    public long itemId;
    public int itemType;
    public String name;
    public int nameLen;
    public int pixelX;
    public int pixelY;
    public String poiId;
    public int type;

    TappedElement() {
    }

    public static TappedElement fromBytes(byte[] bArr) {
        TappedElement tappedElement = new TappedElement();
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        tappedElement.type = mt.a(bArr2);
        System.arraycopy(bArr, 4, bArr2, 0, 4);
        tappedElement.pixelX = mt.a(bArr2);
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        tappedElement.pixelY = mt.a(bArr2);
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        tappedElement.itemType = mt.a(bArr2);
        System.arraycopy(bArr, 16, bArr2, 0, 4);
        tappedElement.nameLen = mt.a(bArr2);
        int i3 = 20;
        if (tappedElement.type != 7) {
            byte[] bArr3 = new byte[64];
            System.arraycopy(bArr, 20, bArr3, 0, 64);
            if (tappedElement.type != 8) {
                tappedElement.name = mt.b(bArr3);
            } else {
                tappedElement.name = mt.a(bArr3, "UTF-8");
            }
            i3 = 84;
        }
        System.arraycopy(bArr, i3, bArr2, 0, 4);
        int a16 = mt.a(bArr2);
        int i16 = i3 + 4;
        System.arraycopy(bArr, i16, bArr2, 0, 4);
        tappedElement.itemId = (a16 << 32) + mt.a(bArr2);
        int i17 = i16 + 4;
        byte[] bArr4 = new byte[64];
        System.arraycopy(bArr, i17, bArr4, 0, 64);
        tappedElement.poiId = String.valueOf(mt.a(bArr4, "UTF-8"));
        int i18 = i17 + 64;
        if (tappedElement.itemType == 1) {
            byte[] bArr5 = new byte[128];
            System.arraycopy(bArr, i18, bArr5, 0, 128);
            int i19 = i18 + 128;
            tappedElement.buildingId = mt.a(bArr5, "UTF-8");
            byte[] bArr6 = new byte[68];
            System.arraycopy(bArr, i19, bArr6, 0, 68);
            tappedElement.buildingName = mt.b(bArr6);
            byte[] bArr7 = new byte[32];
            System.arraycopy(bArr, i19 + 68, bArr7, 0, 32);
            tappedElement.floorName = mt.a(bArr7, "UTF-8");
        }
        return tappedElement;
    }
}
