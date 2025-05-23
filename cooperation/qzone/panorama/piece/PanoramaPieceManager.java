package cooperation.qzone.panorama.piece;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.panorama.util.TextureUtil;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import sy3.b;

/* loaded from: classes28.dex */
public class PanoramaPieceManager implements PanoramaTouchListener {
    public static final int CACHE_PIECE_SIZE = 8;
    public static final int CHECK_SIZE = 1;
    public static final int CLIPPING = 2;
    public static final int DIVIDE_PIECE = 4;
    public static final int END = 7;
    public static final int INIT_LOCATION = 0;
    public static final int NONE = -1;
    public static final int NOTIFY = 5;
    public static final int ONRESUME = 6;
    private static final String TAG = "PanoramaPieceManager";
    public static final int WAITING = 3;
    private BitmapRegionDecoder bitmapRegionDecoder;
    private PanoramaConfig.Builder builder;
    private int cacheEndIndex;
    private int[] cacheIndex;
    private PieceCacheList cachePieceDataList;
    private int cacheStartIndex;
    private volatile int endIndex;
    private boolean isRightOrientataion;
    private int mProcessState;
    private long maxSize;
    private int orgHeight;
    private int orgWidth;
    private Bitmap pieceOrgBitmap;
    private Bitmap pieceOrgBitmap2;
    private int pieceSize;
    private float scaleRate;
    private int screenHeight;
    private int screenWidth;
    private float sectorDegree;
    private ShapeModel shapeModel;
    private volatile int startIndex;
    private int tempEndIndex;
    private int tempEndIndex2;
    private int tempStartIndex;
    private int tempStartIndex2;

    public PanoramaPieceManager(PanoramaConfig.Builder builder, String str) {
        this.scaleRate = 1.0f;
        this.mProcessState = -1;
        this.cacheStartIndex = -1;
        this.cacheEndIndex = -1;
        this.cacheIndex = new int[8];
        this.tempStartIndex = -1;
        this.tempEndIndex = -1;
        this.tempStartIndex2 = -1;
        this.tempEndIndex2 = -1;
        this.builder = builder;
        this.shapeModel = builder.getShapeModel();
        try {
            this.bitmapRegionDecoder = BitmapRegionDecoder.newInstance(str, false);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        initManager();
    }

    private Bitmap checkIfScale(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i3 = this.orgWidth;
        int i16 = this.orgHeight;
        if (i3 > i16) {
            i3 = i16;
        }
        int i17 = this.screenHeight;
        if (i3 > i17) {
            float f16 = i17 / i3;
            this.scaleRate = f16;
            return scaleBitmap(bitmap, f16);
        }
        return bitmap;
    }

    private void checkListSize(int i3, int i16) {
        boolean z16;
        PieceCacheList pieceCacheList = this.cachePieceDataList;
        if (pieceCacheList != null && pieceCacheList.size() >= 8 && this.cachePieceDataList.isNeedCheckSize()) {
            for (int i17 : this.cacheIndex) {
                boolean z17 = true;
                if (i3 < i16) {
                    int i18 = i3;
                    while (true) {
                        if (i18 < i16) {
                            if (i17 == i18) {
                                break;
                            } else {
                                i18++;
                            }
                        } else {
                            z17 = false;
                            break;
                        }
                    }
                } else {
                    int i19 = i3;
                    while (true) {
                        if (i19 < this.pieceSize) {
                            if (i17 == i19) {
                                z16 = true;
                                break;
                            }
                            i19++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    int i26 = 0;
                    while (true) {
                        if (i26 < i16) {
                            if (i17 == i26) {
                                break;
                            } else {
                                i26++;
                            }
                        } else {
                            z17 = z16;
                            break;
                        }
                    }
                }
                if (!z17) {
                    removeCache(i17);
                }
            }
        }
    }

    private void dividePiece() {
        int i3;
        int i16;
        Bitmap bitmap = this.pieceOrgBitmap;
        if (bitmap != null && !bitmap.isRecycled() && this.tempStartIndex != -1 && this.tempEndIndex != -1) {
            int width = this.pieceOrgBitmap.getWidth();
            int i17 = this.tempEndIndex + 1;
            int i18 = this.tempStartIndex;
            int i19 = width / (i17 - i18);
            while (true) {
                i16 = this.tempEndIndex;
                if (i18 > i16) {
                    break;
                }
                setCachePieceDataList(this.cachePieceDataList, i18, (i18 - this.tempStartIndex) * i19, i19, this.pieceOrgBitmap, this.isRightOrientataion);
                i18++;
            }
            if (this.tempStartIndex != i16) {
                this.pieceOrgBitmap.recycle();
            }
            this.pieceOrgBitmap = null;
        }
        Bitmap bitmap2 = this.pieceOrgBitmap2;
        if (bitmap2 != null && !bitmap2.isRecycled() && this.tempStartIndex2 != -1 && this.tempEndIndex2 != -1) {
            int width2 = this.pieceOrgBitmap2.getWidth();
            int i26 = this.tempEndIndex2 + 1;
            int i27 = this.tempStartIndex2;
            int i28 = width2 / (i26 - i27);
            while (true) {
                i3 = this.tempEndIndex2;
                if (i27 > i3) {
                    break;
                }
                setCachePieceDataList(this.cachePieceDataList, i27, (i27 - this.tempStartIndex2) * i28, i28, this.pieceOrgBitmap2, this.isRightOrientataion);
                i27++;
            }
            if (this.tempStartIndex2 != i3) {
                this.pieceOrgBitmap2.recycle();
            }
            this.pieceOrgBitmap2 = null;
        }
    }

    private Bitmap getOrgBitmap(int i3, int i16) {
        int i17;
        Rect rect;
        QZLog.e(TAG, 4, "startIndex = ", Integer.valueOf(this.startIndex), " endIndex = ", Integer.valueOf(this.endIndex), " tempStart = ", Integer.valueOf(i3), " tempEnd = ", Integer.valueOf(i16));
        if (this.bitmapRegionDecoder == null) {
            return null;
        }
        int i18 = this.orgWidth;
        int i19 = this.orgHeight;
        if (i18 > i19) {
            i17 = i18;
        } else {
            i17 = i19;
        }
        int i26 = (int) (i17 / (this.sectorDegree / 10.0f));
        if (i18 > i19) {
            i18 = i19;
        }
        Rect rect2 = new Rect(i3 * i26, 0, (i3 + 1) * i26, i18);
        Rect rect3 = new Rect(i16 * i26, 0, (i16 + 1) * i26, i18);
        if (this.orgWidth < this.orgHeight) {
            int i27 = rect2.top;
            int i28 = this.orgHeight;
            rect = new Rect(i27, i28 - rect3.right, rect3.bottom, i28 - rect2.left);
        } else {
            rect = new Rect(rect2.left, rect2.top, rect3.right, rect3.bottom);
        }
        try {
            return this.bitmapRegionDecoder.decodeRegion(rect, null);
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            QZLog.e(TAG, "decodeRegion IllegalArgumentException");
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            QZLog.e(TAG, "decodeRegion OutOfMemoryError");
            return null;
        }
    }

    private void initManager() {
        ShapeModel shapeModel = this.shapeModel;
        if (shapeModel != null) {
            this.pieceSize = shapeModel.getPieceSize();
        }
        this.mProcessState = 0;
        BitmapRegionDecoder bitmapRegionDecoder = this.bitmapRegionDecoder;
        if (bitmapRegionDecoder != null) {
            this.orgWidth = bitmapRegionDecoder.getWidth();
            this.orgHeight = this.bitmapRegionDecoder.getHeight();
            QZLog.i(TAG, 4, "orgWidth = ", Integer.valueOf(this.orgWidth), " orgHeight = " + this.orgHeight);
        }
        this.screenWidth = ViewUtils.getScreenWidth();
        this.screenHeight = ViewUtils.getScreenHeight();
        this.maxSize = b.a() / 8;
        if (this.cachePieceDataList == null) {
            this.cachePieceDataList = new PieceCacheList(this.maxSize);
        }
        QZLog.i(TAG, 4, "initManager: maxSize = " + this.maxSize);
    }

    private void notifyPieceChange() {
        if (this.cachePieceDataList == null) {
            return;
        }
        for (int i3 = 0; i3 < this.cachePieceDataList.size(); i3++) {
            this.cachePieceDataList.valueAt(i3).notifyTextureChange();
        }
    }

    private Bitmap pieceOperation(int i3, int i16) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap orgBitmap = getOrgBitmap(i3, i16);
        if (this.orgWidth < this.orgHeight) {
            orgBitmap = rotateBitmap(orgBitmap, 90.0f);
        }
        if (orgBitmap == null) {
            return null;
        }
        Bitmap checkIfScale = checkIfScale(orgBitmap);
        QZLog.i(TAG, 4, "pieceOperation:current time =  " + (System.currentTimeMillis() - currentTimeMillis));
        return checkIfScale;
    }

    private void removeCache(int i3) {
        PieceCacheList pieceCacheList = this.cachePieceDataList;
        if (pieceCacheList == null) {
            return;
        }
        pieceCacheList.remove(i3);
    }

    private Bitmap rotateBitmap(Bitmap bitmap, float f16) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f16);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            QZLog.e(TAG, "rotateBitmap OutOfMemoryError");
        }
        bitmap.recycle();
        return bitmap2;
    }

    private Bitmap scaleBitmap(Bitmap bitmap, float f16) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    private void setCachePieceDataList(PieceCacheList pieceCacheList, int i3, int i16, int i17, Bitmap bitmap, boolean z16) {
        QZLog.i(TAG, 4, "index = ", Integer.valueOf(i3), " x = ", Integer.valueOf(i16), " perWidth = ", Integer.valueOf(i17), " (orgHeight * scaleRate) = ", Float.valueOf(this.orgHeight * this.scaleRate));
        if (bitmap != null && !bitmap.isRecycled() && pieceCacheList.get(i3) == null) {
            try {
                PieceData pieceData = new PieceData();
                pieceData.setPieceIndex(i3);
                int i18 = this.orgWidth;
                int i19 = this.orgHeight;
                if (i18 > i19) {
                    i18 = i19;
                }
                pieceData.setOrgBitmap(Bitmap.createBitmap(bitmap, i16, 0, i17, (int) (i18 * this.scaleRate)));
                pieceCacheList.put(i3, pieceData, z16);
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
                QZLog.e(TAG, "createBitmap IllegalArgumentException");
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
                QZLog.e(TAG, "createBitmap OutOfMemoryError");
            }
        }
    }

    public void doProcess() {
        int i3;
        int i16;
        int i17 = this.mProcessState;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 4) {
                        if (i17 != 5) {
                            if (i17 != 6) {
                                if (i17 == 7) {
                                    this.cacheStartIndex = -1;
                                    this.cacheEndIndex = -1;
                                    this.mProcessState = 0;
                                    return;
                                }
                                return;
                            }
                            PieceCacheList pieceCacheList = this.cachePieceDataList;
                            if (pieceCacheList != null) {
                                TextureUtil.deleteTexture(pieceCacheList);
                                this.cachePieceDataList.clear();
                            }
                            this.mProcessState = 7;
                            return;
                        }
                        notifyPieceChange();
                        this.mProcessState = 7;
                        return;
                    }
                    dividePiece();
                    this.mProcessState = 5;
                    return;
                }
                int i18 = this.cacheStartIndex;
                if (i18 != -1 && (i16 = this.cacheEndIndex) != -1 && i18 != i16) {
                    this.mProcessState = 3;
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: cooperation.qzone.panorama.piece.PanoramaPieceManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PanoramaPieceManager.this.loadOrgPieceData();
                            PanoramaPieceManager.this.mProcessState = 4;
                        }
                    });
                    return;
                } else {
                    this.mProcessState = 7;
                    return;
                }
            }
            int i19 = this.cacheStartIndex;
            if (i19 != -1 && (i3 = this.cacheEndIndex) != -1 && i19 != i3) {
                checkListSize(i19, i3);
                this.mProcessState = 2;
                return;
            } else {
                this.mProcessState = 7;
                return;
            }
        }
        this.cacheStartIndex = this.startIndex;
        this.cacheEndIndex = this.endIndex;
        this.mProcessState = 1;
    }

    public PieceCacheList getCachePieceDataList() {
        return this.cachePieceDataList;
    }

    public void loadOrgPieceData() {
        int i3;
        int i16;
        int i17;
        if (this.bitmapRegionDecoder == null) {
            return;
        }
        int i18 = this.cacheStartIndex;
        int i19 = this.cacheEndIndex;
        if (i18 != -1 && i19 != -1 && i18 != i19) {
            int[] iArr = this.cacheIndex;
            boolean z16 = false;
            int i26 = iArr[0];
            int i27 = iArr[iArr.length - 1];
            this.tempStartIndex = -1;
            this.tempEndIndex = -1;
            if (i18 < i19) {
                int i28 = 0;
                while (i18 < i19) {
                    if (this.cachePieceDataList.get(i18) == null) {
                        if (this.tempStartIndex == -1) {
                            this.tempStartIndex = i18;
                        }
                        this.tempEndIndex = i18;
                    }
                    this.cacheIndex[i28] = i18;
                    i18++;
                    i28++;
                }
                int i29 = this.tempStartIndex;
                if (i26 < i29 || i27 < this.tempEndIndex) {
                    z16 = true;
                }
                this.isRightOrientataion = z16;
                if (i29 != -1 && (i17 = this.tempEndIndex) != -1) {
                    this.pieceOrgBitmap = pieceOperation(i29, i17);
                    return;
                }
                return;
            }
            int i36 = i18;
            int i37 = 0;
            while (i36 < this.pieceSize) {
                if (this.cachePieceDataList.get(i36) == null) {
                    if (this.tempStartIndex == -1) {
                        this.tempStartIndex = i36;
                    }
                    this.tempEndIndex = i36;
                }
                this.cacheIndex[i37] = i36;
                i36++;
                i37++;
            }
            int i38 = this.tempStartIndex;
            if (i38 != -1 && (i16 = this.tempEndIndex) != -1) {
                this.pieceOrgBitmap = pieceOperation(i38, i16);
            }
            this.tempStartIndex2 = -1;
            this.tempEndIndex2 = -1;
            int i39 = 0;
            while (i39 < i19) {
                if (this.cachePieceDataList.get(i39) == null) {
                    if (this.tempStartIndex2 == -1) {
                        this.tempStartIndex2 = i39;
                    }
                    this.tempEndIndex2 = i39;
                }
                this.cacheIndex[i37] = i39;
                i39++;
                i37++;
            }
            int i46 = this.tempStartIndex2;
            if (i46 != -1 && (i3 = this.tempEndIndex2) != -1) {
                this.pieceOrgBitmap2 = pieceOperation(i46, i3);
            }
            if (this.pieceSize - i18 > 4) {
                z16 = true;
            }
            this.isRightOrientataion = z16;
        }
    }

    public void onResume() {
        this.mProcessState = 6;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTouchMove(float f16, float f17) {
        int i3;
        float f18;
        float f19 = f17 % 360.0f;
        int i16 = this.pieceSize;
        int i17 = 360 / i16;
        float f26 = this.sectorDegree;
        if (f26 == 360.0f) {
            if (f19 <= 0.0f) {
                i3 = -((int) (f19 / i17));
                f18 = i17;
                if (Math.abs(f19) % f18 >= i17 / 2 && Math.abs(f19) % f18 < f18) {
                    i3++;
                }
                if (this.sectorDegree != 360.0f) {
                    this.startIndex = (i3 - 4) % this.pieceSize;
                    if (this.startIndex < 0) {
                        this.startIndex += this.pieceSize;
                    }
                    this.endIndex = (i3 + 4) % this.pieceSize;
                    int i18 = this.startIndex;
                    int i19 = this.pieceSize;
                    if (i18 == i19 - 8) {
                        this.endIndex = i19;
                        return;
                    }
                    return;
                }
                this.startIndex = i3 - 4;
                this.endIndex = i3 + 4;
                if (this.startIndex < 0) {
                    this.startIndex = 0;
                }
                float f27 = this.endIndex;
                float f28 = this.sectorDegree;
                if (f27 > f28 / 10.0f) {
                    this.endIndex = (int) (f28 / 10.0f);
                    return;
                }
                return;
            }
        } else {
            i16 = (int) (f26 / 10.0f);
        }
        i3 = i16 - ((int) (f19 / i17));
        f18 = i17;
        if (Math.abs(f19) % f18 >= i17 / 2) {
            i3++;
        }
        if (this.sectorDegree != 360.0f) {
        }
    }

    public void setSectorDegree(float f16) {
        this.sectorDegree = f16;
    }

    public PanoramaPieceManager(PanoramaConfig.Builder builder, byte[] bArr) {
        this.scaleRate = 1.0f;
        this.mProcessState = -1;
        this.cacheStartIndex = -1;
        this.cacheEndIndex = -1;
        this.cacheIndex = new int[8];
        this.tempStartIndex = -1;
        this.tempEndIndex = -1;
        this.tempStartIndex2 = -1;
        this.tempEndIndex2 = -1;
        this.builder = builder;
        this.shapeModel = builder.getShapeModel();
        try {
            this.bitmapRegionDecoder = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        initManager();
    }

    @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
    public void onClickListener() {
    }

    @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
    public void onTouchScale(float f16) {
    }
}
