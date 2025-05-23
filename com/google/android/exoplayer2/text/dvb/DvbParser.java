package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes2.dex */
final class DvbParser {
    private static final int DATA_TYPE_24_TABLE_DATA = 32;
    private static final int DATA_TYPE_28_TABLE_DATA = 33;
    private static final int DATA_TYPE_2BP_CODE_STRING = 16;
    private static final int DATA_TYPE_48_TABLE_DATA = 34;
    private static final int DATA_TYPE_4BP_CODE_STRING = 17;
    private static final int DATA_TYPE_8BP_CODE_STRING = 18;
    private static final int DATA_TYPE_END_LINE = 240;
    private static final int OBJECT_CODING_PIXELS = 0;
    private static final int OBJECT_CODING_STRING = 1;
    private static final int PAGE_STATE_NORMAL = 0;
    private static final int REGION_DEPTH_4_BIT = 2;
    private static final int REGION_DEPTH_8_BIT = 3;
    private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
    private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
    private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
    private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
    private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
    private static final String TAG = "DvbParser";
    private static final byte[] defaultMap2To4 = {0, 7, 8, RegisterType.DOUBLE_HI};
    private static final byte[] defaultMap2To8 = {0, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -120, -1};
    private static final byte[] defaultMap4To8 = {0, 17, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 51, 68, 85, 102, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas canvas;
    private final ClutDefinition defaultClutDefinition;
    private final DisplayDefinition defaultDisplayDefinition;
    private final Paint defaultPaint;
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;

        /* renamed from: id, reason: collision with root package name */
        public final int f32949id;

        public ClutDefinition(int i3, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f32949id = i3;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int i3, int i16, int i17, int i18, int i19, int i26) {
            this.width = i3;
            this.height = i16;
            this.horizontalPositionMinimum = i17;
            this.horizontalPositionMaximum = i18;
            this.verticalPositionMinimum = i19;
            this.verticalPositionMaximum = i26;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ObjectData {
        public final byte[] bottomFieldData;

        /* renamed from: id, reason: collision with root package name */
        public final int f32950id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i3, boolean z16, byte[] bArr, byte[] bArr2) {
            this.f32950id = i3;
            this.nonModifyingColorFlag = z16;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class PageComposition {
        public final SparseArray<PageRegion> regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int i3, int i16, int i17, SparseArray<PageRegion> sparseArray) {
            this.timeOutSecs = i3;
            this.version = i16;
            this.state = i17;
            this.regions = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i3, int i16) {
            this.horizontalAddress = i3;
            this.verticalAddress = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;

        /* renamed from: id, reason: collision with root package name */
        public final int f32951id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray<RegionObject> regionObjects;
        public final int width;

        public RegionComposition(int i3, boolean z16, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, SparseArray<RegionObject> sparseArray) {
            this.f32951id = i3;
            this.fillFlag = z16;
            this.width = i16;
            this.height = i17;
            this.levelOfCompatibility = i18;
            this.depth = i19;
            this.clutId = i26;
            this.pixelCode8Bit = i27;
            this.pixelCode4Bit = i28;
            this.pixelCode2Bit = i29;
            this.regionObjects = sparseArray;
        }

        public void mergeFrom(RegionComposition regionComposition) {
            if (regionComposition == null) {
                return;
            }
            SparseArray<RegionObject> sparseArray = regionComposition.regionObjects;
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                this.regionObjects.put(sparseArray.keyAt(i3), sparseArray.valueAt(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int i3, int i16, int i17, int i18, int i19, int i26) {
            this.type = i3;
            this.provider = i16;
            this.horizontalPosition = i17;
            this.verticalPosition = i18;
            this.foregroundPixelCode = i19;
            this.backgroundPixelCode = i26;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SubtitleService {
        public final int ancillaryPageId;
        public DisplayDefinition displayDefinition;
        public PageComposition pageComposition;
        public final int subtitlePageId;
        public final SparseArray<RegionComposition> regions = new SparseArray<>();
        public final SparseArray<ClutDefinition> cluts = new SparseArray<>();
        public final SparseArray<ObjectData> objects = new SparseArray<>();
        public final SparseArray<ClutDefinition> ancillaryCluts = new SparseArray<>();
        public final SparseArray<ObjectData> ancillaryObjects = new SparseArray<>();

        public SubtitleService(int i3, int i16) {
            this.subtitlePageId = i3;
            this.ancillaryPageId = i16;
        }

        public void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    public DvbParser(int i3, int i16) {
        Paint paint = new Paint();
        this.defaultPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.fillRegionPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.canvas = new Canvas();
        this.defaultDisplayDefinition = new DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.defaultClutDefinition = new ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
        this.subtitleService = new SubtitleService(i3, i16);
    }

    private static byte[] buildClutMapTable(int i3, int i16, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            bArr[i17] = (byte) parsableBitArray.readBits(i16);
        }
        return bArr;
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] generateDefault4BitClutEntries() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i26 = 1; i26 < 16; i26++) {
            if (i26 < 8) {
                if ((i26 & 1) != 0) {
                    i17 = 255;
                } else {
                    i17 = 0;
                }
                if ((i26 & 2) != 0) {
                    i18 = 255;
                } else {
                    i18 = 0;
                }
                if ((i26 & 4) != 0) {
                    i19 = 255;
                } else {
                    i19 = 0;
                }
                iArr[i26] = getColor(255, i17, i18, i19);
            } else {
                int i27 = 127;
                if ((i26 & 1) != 0) {
                    i3 = 127;
                } else {
                    i3 = 0;
                }
                if ((i26 & 2) != 0) {
                    i16 = 127;
                } else {
                    i16 = 0;
                }
                if ((i26 & 4) == 0) {
                    i27 = 0;
                }
                iArr[i26] = getColor(255, i3, i16, i27);
            }
        }
        return iArr;
    }

    private static int[] generateDefault8BitClutEntries() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i57 = 0; i57 < 256; i57++) {
            int i58 = 255;
            if (i57 < 8) {
                if ((i57 & 1) != 0) {
                    i49 = 255;
                } else {
                    i49 = 0;
                }
                if ((i57 & 2) != 0) {
                    i56 = 255;
                } else {
                    i56 = 0;
                }
                if ((i57 & 4) == 0) {
                    i58 = 0;
                }
                iArr[i57] = getColor(63, i49, i56, i58);
            } else {
                int i59 = i57 & 136;
                int i65 = 170;
                int i66 = 85;
                if (i59 != 0) {
                    if (i59 != 8) {
                        int i67 = 43;
                        if (i59 != 128) {
                            if (i59 == 136) {
                                if ((i57 & 1) != 0) {
                                    i39 = 43;
                                } else {
                                    i39 = 0;
                                }
                                if ((i57 & 16) != 0) {
                                    i46 = 85;
                                } else {
                                    i46 = 0;
                                }
                                int i68 = i39 + i46;
                                if ((i57 & 2) != 0) {
                                    i47 = 43;
                                } else {
                                    i47 = 0;
                                }
                                if ((i57 & 32) != 0) {
                                    i48 = 85;
                                } else {
                                    i48 = 0;
                                }
                                int i69 = i47 + i48;
                                if ((i57 & 4) == 0) {
                                    i67 = 0;
                                }
                                if ((i57 & 64) == 0) {
                                    i66 = 0;
                                }
                                iArr[i57] = getColor(255, i68, i69, i67 + i66);
                            }
                        } else {
                            if ((i57 & 1) != 0) {
                                i29 = 43;
                            } else {
                                i29 = 0;
                            }
                            int i75 = i29 + 127;
                            if ((i57 & 16) != 0) {
                                i36 = 85;
                            } else {
                                i36 = 0;
                            }
                            int i76 = i75 + i36;
                            if ((i57 & 2) != 0) {
                                i37 = 43;
                            } else {
                                i37 = 0;
                            }
                            int i77 = i37 + 127;
                            if ((i57 & 32) != 0) {
                                i38 = 85;
                            } else {
                                i38 = 0;
                            }
                            int i78 = i77 + i38;
                            if ((i57 & 4) == 0) {
                                i67 = 0;
                            }
                            int i79 = i67 + 127;
                            if ((i57 & 64) == 0) {
                                i66 = 0;
                            }
                            iArr[i57] = getColor(255, i76, i78, i79 + i66);
                        }
                    } else {
                        if ((i57 & 1) != 0) {
                            i19 = 85;
                        } else {
                            i19 = 0;
                        }
                        if ((i57 & 16) != 0) {
                            i26 = 170;
                        } else {
                            i26 = 0;
                        }
                        int i85 = i19 + i26;
                        if ((i57 & 2) != 0) {
                            i27 = 85;
                        } else {
                            i27 = 0;
                        }
                        if ((i57 & 32) != 0) {
                            i28 = 170;
                        } else {
                            i28 = 0;
                        }
                        int i86 = i27 + i28;
                        if ((i57 & 4) == 0) {
                            i66 = 0;
                        }
                        if ((i57 & 64) == 0) {
                            i65 = 0;
                        }
                        iArr[i57] = getColor(127, i85, i86, i66 + i65);
                    }
                } else {
                    if ((i57 & 1) != 0) {
                        i3 = 85;
                    } else {
                        i3 = 0;
                    }
                    if ((i57 & 16) != 0) {
                        i16 = 170;
                    } else {
                        i16 = 0;
                    }
                    int i87 = i3 + i16;
                    if ((i57 & 2) != 0) {
                        i17 = 85;
                    } else {
                        i17 = 0;
                    }
                    if ((i57 & 32) != 0) {
                        i18 = 170;
                    } else {
                        i18 = 0;
                    }
                    int i88 = i17 + i18;
                    if ((i57 & 4) == 0) {
                        i66 = 0;
                    }
                    if ((i57 & 64) == 0) {
                        i65 = 0;
                    }
                    iArr[i57] = getColor(255, i87, i88, i66 + i65);
                }
            }
        }
        return iArr;
    }

    private static int getColor(int i3, int i16, int i17, int i18) {
        return (i3 << 24) | (i16 << 16) | (i17 << 8) | i18;
    }

    private static int paint2BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i3, int i16, Paint paint, Canvas canvas) {
        boolean z16;
        int i17;
        int readBits;
        int readBits2;
        int i18 = i3;
        boolean z17 = false;
        while (true) {
            int readBits3 = parsableBitArray.readBits(2);
            if (readBits3 != 0) {
                z16 = z17;
                i17 = 1;
            } else {
                if (parsableBitArray.readBit()) {
                    readBits = parsableBitArray.readBits(3) + 3;
                    readBits2 = parsableBitArray.readBits(2);
                } else {
                    if (parsableBitArray.readBit()) {
                        z16 = z17;
                        i17 = 1;
                    } else {
                        int readBits4 = parsableBitArray.readBits(2);
                        if (readBits4 != 0) {
                            if (readBits4 != 1) {
                                if (readBits4 != 2) {
                                    if (readBits4 != 3) {
                                        z16 = z17;
                                    } else {
                                        readBits = parsableBitArray.readBits(8) + 29;
                                        readBits2 = parsableBitArray.readBits(2);
                                    }
                                } else {
                                    readBits = parsableBitArray.readBits(4) + 12;
                                    readBits2 = parsableBitArray.readBits(2);
                                }
                            } else {
                                z16 = z17;
                                i17 = 2;
                            }
                        } else {
                            z16 = true;
                        }
                        readBits3 = 0;
                        i17 = 0;
                    }
                    readBits3 = 0;
                }
                z16 = z17;
                i17 = readBits;
                readBits3 = readBits2;
            }
            if (i17 != 0 && paint != null) {
                if (bArr != null) {
                    readBits3 = bArr[readBits3];
                }
                paint.setColor(iArr[readBits3]);
                canvas.drawRect(i18, i16, i18 + i17, i16 + 1, paint);
            }
            i18 += i17;
            if (z16) {
                return i18;
            }
            z17 = z16;
        }
    }

    private static int paint4BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i3, int i16, Paint paint, Canvas canvas) {
        boolean z16;
        int i17;
        int readBits;
        int readBits2;
        int i18 = i3;
        boolean z17 = false;
        while (true) {
            int readBits3 = parsableBitArray.readBits(4);
            if (readBits3 != 0) {
                z16 = z17;
                i17 = 1;
            } else if (!parsableBitArray.readBit()) {
                int readBits4 = parsableBitArray.readBits(3);
                if (readBits4 != 0) {
                    z16 = z17;
                    i17 = readBits4 + 2;
                    readBits3 = 0;
                } else {
                    z16 = true;
                    readBits3 = 0;
                    i17 = 0;
                }
            } else {
                if (!parsableBitArray.readBit()) {
                    readBits = parsableBitArray.readBits(2) + 4;
                    readBits2 = parsableBitArray.readBits(4);
                } else {
                    int readBits5 = parsableBitArray.readBits(2);
                    if (readBits5 != 0) {
                        if (readBits5 != 1) {
                            if (readBits5 != 2) {
                                if (readBits5 != 3) {
                                    z16 = z17;
                                    readBits3 = 0;
                                    i17 = 0;
                                } else {
                                    readBits = parsableBitArray.readBits(8) + 25;
                                    readBits2 = parsableBitArray.readBits(4);
                                }
                            } else {
                                readBits = parsableBitArray.readBits(4) + 9;
                                readBits2 = parsableBitArray.readBits(4);
                            }
                        } else {
                            z16 = z17;
                            i17 = 2;
                        }
                    } else {
                        z16 = z17;
                        i17 = 1;
                    }
                    readBits3 = 0;
                }
                z16 = z17;
                i17 = readBits;
                readBits3 = readBits2;
            }
            if (i17 != 0 && paint != null) {
                if (bArr != null) {
                    readBits3 = bArr[readBits3];
                }
                paint.setColor(iArr[readBits3]);
                canvas.drawRect(i18, i16, i18 + i17, i16 + 1, paint);
            }
            i18 += i17;
            if (z16) {
                return i18;
            }
            z17 = z16;
        }
    }

    private static int paint8BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i3, int i16, Paint paint, Canvas canvas) {
        boolean z16;
        int readBits;
        int i17 = i3;
        boolean z17 = false;
        while (true) {
            int readBits2 = parsableBitArray.readBits(8);
            if (readBits2 != 0) {
                z16 = z17;
                readBits = 1;
            } else if (!parsableBitArray.readBit()) {
                int readBits3 = parsableBitArray.readBits(7);
                if (readBits3 != 0) {
                    z16 = z17;
                    readBits = readBits3;
                    readBits2 = 0;
                } else {
                    z16 = true;
                    readBits2 = 0;
                    readBits = 0;
                }
            } else {
                z16 = z17;
                readBits = parsableBitArray.readBits(7);
                readBits2 = parsableBitArray.readBits(8);
            }
            if (readBits != 0 && paint != null) {
                if (bArr != null) {
                    readBits2 = bArr[readBits2];
                }
                paint.setColor(iArr[readBits2]);
                canvas.drawRect(i17, i16, i17 + readBits, i16 + 1, paint);
            }
            i17 += readBits;
            if (z16) {
                return i17;
            }
            z17 = z16;
        }
    }

    private static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i3, int i16, int i17, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i18 = i16;
        int i19 = i17;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 240) {
                switch (readBits) {
                    case 16:
                        if (i3 == 3) {
                            if (bArr5 == null) {
                                bArr3 = defaultMap2To8;
                            } else {
                                bArr3 = bArr5;
                            }
                        } else if (i3 == 2) {
                            if (bArr6 == null) {
                                bArr3 = defaultMap2To4;
                            } else {
                                bArr3 = bArr6;
                            }
                        } else {
                            bArr2 = null;
                            i18 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr2, i18, i19, paint, canvas);
                            parsableBitArray.byteAlign();
                            break;
                        }
                        bArr2 = bArr3;
                        i18 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr2, i18, i19, paint, canvas);
                        parsableBitArray.byteAlign();
                    case 17:
                        if (i3 == 3) {
                            bArr4 = defaultMap4To8;
                        } else {
                            bArr4 = null;
                        }
                        i18 = paint4BitPixelCodeString(parsableBitArray, iArr, bArr4, i18, i19, paint, canvas);
                        parsableBitArray.byteAlign();
                        break;
                    case 18:
                        i18 = paint8BitPixelCodeString(parsableBitArray, iArr, null, i18, i19, paint, canvas);
                        break;
                    default:
                        switch (readBits) {
                            case 32:
                                bArr6 = buildClutMapTable(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr5 = buildClutMapTable(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr5 = buildClutMapTable(16, 8, parsableBitArray);
                                break;
                        }
                }
            } else {
                i19 += 2;
                i18 = i16;
            }
        }
    }

    private static void paintPixelDataSubBlocks(ObjectData objectData, ClutDefinition clutDefinition, int i3, int i16, int i17, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i3 == 3) {
            iArr = clutDefinition.clutEntries8Bit;
        } else if (i3 == 2) {
            iArr = clutDefinition.clutEntries4Bit;
        } else {
            iArr = clutDefinition.clutEntries2Bit;
        }
        int[] iArr2 = iArr;
        paintPixelDataSubBlock(objectData.topFieldData, iArr2, i3, i16, i17, paint, canvas);
        paintPixelDataSubBlock(objectData.bottomFieldData, iArr2, i3, i16, i17 + 1, paint, canvas);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int i3) {
        int[] iArr;
        int readBits;
        int i16;
        int readBits2;
        int i17;
        int i18;
        int i19 = 8;
        int readBits3 = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(8);
        int i26 = 2;
        int i27 = i3 - 2;
        int[] generateDefault2BitClutEntries = generateDefault2BitClutEntries();
        int[] generateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] generateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i27 > 0) {
            int readBits4 = parsableBitArray.readBits(i19);
            int readBits5 = parsableBitArray.readBits(i19);
            int i28 = i27 - 2;
            if ((readBits5 & 128) != 0) {
                iArr = generateDefault2BitClutEntries;
            } else if ((readBits5 & 64) != 0) {
                iArr = generateDefault4BitClutEntries;
            } else {
                iArr = generateDefault8BitClutEntries;
            }
            if ((readBits5 & 1) != 0) {
                i17 = parsableBitArray.readBits(i19);
                i18 = parsableBitArray.readBits(i19);
                readBits = parsableBitArray.readBits(i19);
                readBits2 = parsableBitArray.readBits(i19);
                i16 = i28 - 4;
            } else {
                int readBits6 = parsableBitArray.readBits(6) << i26;
                int readBits7 = parsableBitArray.readBits(4) << 4;
                readBits = parsableBitArray.readBits(4) << 4;
                i16 = i28 - 2;
                readBits2 = parsableBitArray.readBits(i26) << 6;
                i17 = readBits6;
                i18 = readBits7;
            }
            if (i17 == 0) {
                readBits2 = 255;
                i18 = 0;
                readBits = 0;
            }
            double d16 = i17;
            double d17 = i18 - 128;
            double d18 = readBits - 128;
            iArr[readBits4] = getColor((byte) (255 - (readBits2 & 255)), Util.constrainValue((int) (d16 + (1.402d * d17)), 0, 255), Util.constrainValue((int) ((d16 - (0.34414d * d18)) - (d17 * 0.71414d)), 0, 255), Util.constrainValue((int) (d16 + (d18 * 1.772d)), 0, 255));
            i27 = i16;
            readBits3 = readBits3;
            i19 = 8;
            i26 = 2;
        }
        return new ClutDefinition(readBits3, generateDefault2BitClutEntries, generateDefault4BitClutEntries, generateDefault8BitClutEntries);
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray) {
        int i3;
        int i16;
        int i17;
        int i18;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            int readBits5 = parsableBitArray.readBits(16);
            i18 = parsableBitArray.readBits(16);
            i17 = readBits4;
            i16 = readBits5;
            i3 = readBits3;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = readBits;
            i18 = readBits2;
        }
        return new DisplayDefinition(readBits, readBits2, i3, i17, i16, i18);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = null;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new ObjectData(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(readBits, readBit, bArr2, bArr);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray, int i3) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i16 = i3 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i16 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i16 -= 6;
            sparseArray.put(readBits4, new PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int i3) {
        int readBits;
        int readBits2;
        int readBits3 = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int i16 = 16;
        int readBits4 = parsableBitArray.readBits(16);
        int readBits5 = parsableBitArray.readBits(16);
        int readBits6 = parsableBitArray.readBits(3);
        int readBits7 = parsableBitArray.readBits(3);
        int i17 = 2;
        parsableBitArray.skipBits(2);
        int readBits8 = parsableBitArray.readBits(8);
        int readBits9 = parsableBitArray.readBits(8);
        int readBits10 = parsableBitArray.readBits(4);
        int readBits11 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i18 = i3 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i18 > 0) {
            int readBits12 = parsableBitArray.readBits(i16);
            int readBits13 = parsableBitArray.readBits(i17);
            int readBits14 = parsableBitArray.readBits(i17);
            int readBits15 = parsableBitArray.readBits(12);
            int i19 = readBits11;
            parsableBitArray.skipBits(4);
            int readBits16 = parsableBitArray.readBits(12);
            i18 -= 6;
            if (readBits13 != 1 && readBits13 != 2) {
                readBits = 0;
                readBits2 = 0;
            } else {
                i18 -= 2;
                readBits = parsableBitArray.readBits(8);
                readBits2 = parsableBitArray.readBits(8);
            }
            sparseArray.put(readBits12, new RegionObject(readBits13, readBits14, readBits15, readBits16, readBits, readBits2));
            readBits11 = i19;
            i17 = 2;
            i16 = 16;
        }
        return new RegionComposition(readBits3, readBit, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, readBits10, readBits11, sparseArray);
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, SubtitleService subtitleService) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            Log.w(TAG, "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService.subtitlePageId) {
                    PageComposition pageComposition = subtitleService.pageComposition;
                    PageComposition parsePageComposition = parsePageComposition(parsableBitArray, readBits3);
                    if (parsePageComposition.state != 0) {
                        subtitleService.pageComposition = parsePageComposition;
                        subtitleService.regions.clear();
                        subtitleService.cluts.clear();
                        subtitleService.objects.clear();
                        break;
                    } else if (pageComposition != null && pageComposition.version != parsePageComposition.version) {
                        subtitleService.pageComposition = parsePageComposition;
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService.pageComposition;
                if (readBits2 == subtitleService.subtitlePageId && pageComposition2 != null) {
                    RegionComposition parseRegionComposition = parseRegionComposition(parsableBitArray, readBits3);
                    if (pageComposition2.state == 0) {
                        parseRegionComposition.mergeFrom(subtitleService.regions.get(parseRegionComposition.f32951id));
                    }
                    subtitleService.regions.put(parseRegionComposition.f32951id, parseRegionComposition);
                    break;
                }
                break;
            case 18:
                if (readBits2 == subtitleService.subtitlePageId) {
                    ClutDefinition parseClutDefinition = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService.cluts.put(parseClutDefinition.f32949id, parseClutDefinition);
                    break;
                } else if (readBits2 == subtitleService.ancillaryPageId) {
                    ClutDefinition parseClutDefinition2 = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService.ancillaryCluts.put(parseClutDefinition2.f32949id, parseClutDefinition2);
                    break;
                }
                break;
            case 19:
                if (readBits2 == subtitleService.subtitlePageId) {
                    ObjectData parseObjectData = parseObjectData(parsableBitArray);
                    subtitleService.objects.put(parseObjectData.f32950id, parseObjectData);
                    break;
                } else if (readBits2 == subtitleService.ancillaryPageId) {
                    ObjectData parseObjectData2 = parseObjectData(parsableBitArray);
                    subtitleService.ancillaryObjects.put(parseObjectData2.f32950id, parseObjectData2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService.subtitlePageId) {
                    subtitleService.displayDefinition = parseDisplayDefinition(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    public List<Cue> decode(byte[] bArr, int i3) {
        int i16;
        ObjectData objectData;
        int i17;
        SparseArray<RegionObject> sparseArray;
        Paint paint;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i3);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            parseSubtitlingSegment(parsableBitArray, this.subtitleService);
        }
        SubtitleService subtitleService = this.subtitleService;
        if (subtitleService.pageComposition == null) {
            return Collections.emptyList();
        }
        DisplayDefinition displayDefinition = subtitleService.displayDefinition;
        if (displayDefinition == null) {
            displayDefinition = this.defaultDisplayDefinition;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || displayDefinition.width + 1 != bitmap.getWidth() || displayDefinition.height + 1 != this.bitmap.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(displayDefinition.width + 1, displayDefinition.height + 1, Bitmap.Config.ARGB_8888);
            this.bitmap = createBitmap;
            this.canvas.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray2 = this.subtitleService.pageComposition.regions;
        for (int i18 = 0; i18 < sparseArray2.size(); i18++) {
            PageRegion valueAt = sparseArray2.valueAt(i18);
            RegionComposition regionComposition = this.subtitleService.regions.get(sparseArray2.keyAt(i18));
            int i19 = valueAt.horizontalAddress + displayDefinition.horizontalPositionMinimum;
            int i26 = valueAt.verticalAddress + displayDefinition.verticalPositionMinimum;
            float f16 = i19;
            float f17 = i26;
            this.canvas.clipRect(f16, f17, Math.min(regionComposition.width + i19, displayDefinition.horizontalPositionMaximum), Math.min(regionComposition.height + i26, displayDefinition.verticalPositionMaximum), Region.Op.REPLACE);
            ClutDefinition clutDefinition = this.subtitleService.cluts.get(regionComposition.clutId);
            if (clutDefinition == null && (clutDefinition = this.subtitleService.ancillaryCluts.get(regionComposition.clutId)) == null) {
                clutDefinition = this.defaultClutDefinition;
            }
            SparseArray<RegionObject> sparseArray3 = regionComposition.regionObjects;
            int i27 = 0;
            while (i27 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i27);
                RegionObject valueAt2 = sparseArray3.valueAt(i27);
                ObjectData objectData2 = this.subtitleService.objects.get(keyAt);
                if (objectData2 == null) {
                    objectData = this.subtitleService.ancillaryObjects.get(keyAt);
                } else {
                    objectData = objectData2;
                }
                if (objectData != null) {
                    if (objectData.nonModifyingColorFlag) {
                        paint = null;
                    } else {
                        paint = this.defaultPaint;
                    }
                    i17 = i27;
                    sparseArray = sparseArray3;
                    paintPixelDataSubBlocks(objectData, clutDefinition, regionComposition.depth, valueAt2.horizontalPosition + i19, i26 + valueAt2.verticalPosition, paint, this.canvas);
                } else {
                    i17 = i27;
                    sparseArray = sparseArray3;
                }
                i27 = i17 + 1;
                sparseArray3 = sparseArray;
            }
            if (regionComposition.fillFlag) {
                int i28 = regionComposition.depth;
                if (i28 == 3) {
                    i16 = clutDefinition.clutEntries8Bit[regionComposition.pixelCode8Bit];
                } else if (i28 == 2) {
                    i16 = clutDefinition.clutEntries4Bit[regionComposition.pixelCode4Bit];
                } else {
                    i16 = clutDefinition.clutEntries2Bit[regionComposition.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(i16);
                this.canvas.drawRect(f16, f17, regionComposition.width + i19, regionComposition.height + i26, this.fillRegionPaint);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(this.bitmap, i19, i26, regionComposition.width, regionComposition.height);
            int i29 = displayDefinition.width;
            int i36 = displayDefinition.height;
            arrayList.add(new Cue(createBitmap2, f16 / i29, 0, f17 / i36, 0, regionComposition.width / i29, regionComposition.height / i36));
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public void reset() {
        this.subtitleService.reset();
    }
}
