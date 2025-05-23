package com.tencent.biz.richframework.localupload.recommend;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.scanner.RFWMediaScanResult;
import com.tencent.biz.richframework.localupload.recommend.scanner.RFWMediaScanner;
import com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0006\u0010\u001c\u001a\u00020\u0012J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoScanManager;", "", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mDbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "mIsScanIng", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mMediaScanner", "Lcom/tencent/biz/richframework/localupload/recommend/scanner/RFWMediaScanner;", "canScanPhoto", "", "lastScanTime", "", "(Ljava/lang/Long;)Z", "deviceHaveEnoughSpace", "doFirstScan", "", "doIncreaseScan", "getFirstScanCountLimit", "", "getIncreaseScanCountLimit", "getLastScanTime", "handleScanResult", "scanResult", "Lcom/tencent/biz/richframework/localupload/recommend/scanner/RFWMediaScanResult;", "isIncreaseScan", "scanLocalPhoto", "setLastScanTime", "", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWLocalPhotoScanManager {

    @NotNull
    private final RecommendContext mContext;

    @NotNull
    private final RFWUploadRecommendDbManager mDbManager;

    @NotNull
    private final AtomicBoolean mIsScanIng;

    @NotNull
    private final RFWMediaScanner mMediaScanner;

    public RFWLocalPhotoScanManager(@NotNull RecommendContext mContext, @NotNull RFWUploadRecommendDbManager mDbManager) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mDbManager, "mDbManager");
        this.mContext = mContext;
        this.mDbManager = mDbManager;
        this.mMediaScanner = new RFWMediaScanner(mContext);
        this.mIsScanIng = new AtomicBoolean(false);
    }

    private final boolean canScanPhoto(Long lastScanTime) {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return true;
        }
        if (!deviceHaveEnoughSpace()) {
            this.mContext.d("RFWLocalPhotoScanManager", "[canScanPhoto] device not have enough space");
            return false;
        }
        if (lastScanTime == null || lastScanTime.longValue() == 0 || RFWRecommendDateUtils.isDifferentDay(lastScanTime.longValue(), System.currentTimeMillis())) {
            return true;
        }
        this.mContext.d("RFWLocalPhotoScanManager", "[canScanPhoto] today has scanned");
        return false;
    }

    private final void doFirstScan() {
        this.mContext.d("RFWLocalPhotoScanManager", "[doFirstScan]");
        RFWMediaScanResult startScan = this.mMediaScanner.startScan(0L, Long.MAX_VALUE, getFirstScanCountLimit());
        this.mContext.notifyScanProgressChange(false);
        handleScanResult(startScan, false);
    }

    private final void doIncreaseScan(long lastScanTime) {
        int increaseScanCountLimit = getIncreaseScanCountLimit();
        this.mContext.notifyScanProgressChange(false);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j3 = lastScanTime / 1000;
        if (currentTimeMillis > j3) {
            this.mContext.d("RFWLocalPhotoScanManager", "[doIncreaseScan] start increase scan; startTime: " + j3 + ", endTime:" + currentTimeMillis);
            handleScanResult(this.mMediaScanner.startScan(j3, currentTimeMillis, increaseScanCountLimit), true);
            return;
        }
        this.mContext.e("RFWLocalPhotoScanManager", "[doIncreaseScan] start increase but last scan time is future, so scan from:" + currentTimeMillis);
        handleScanResult(this.mMediaScanner.startScan(0L, currentTimeMillis, increaseScanCountLimit), true);
    }

    private final int getFirstScanCountLimit() {
        return this.mContext.getDelegate().getConfigDelegate().getFirstScanCountLimit();
    }

    private final int getIncreaseScanCountLimit() {
        return this.mContext.getDelegate().getConfigDelegate().getIncreaseScanCountLimit();
    }

    private final long getLastScanTime() {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.mContext.getDelegate().getConfigDelegate().getConfig("KEY_LAST_SCAN_TIME"));
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    private final void handleScanResult(RFWMediaScanResult scanResult, boolean isIncreaseScan) {
        List<RFWMediaInfo> asReversedMutable;
        if (!scanResult.getIsSuccess()) {
            this.mContext.e("RFWLocalPhotoScanManager", "[handleScanResult] scan failed");
            return;
        }
        ArrayList<RFWMediaInfo> mediaList = scanResult.getMediaList();
        this.mIsScanIng.set(false);
        String valueOf = String.valueOf(System.currentTimeMillis());
        RFWLocalPhotoTracer rFWLocalPhotoTracer = RFWLocalPhotoTracer.INSTANCE;
        rFWLocalPhotoTracer.onScanFinish(isIncreaseScan, mediaList.size(), valueOf);
        if (!mediaList.isEmpty()) {
            asReversedMutable = CollectionsKt__ReversedViewsKt.asReversedMutable(mediaList);
            this.mDbManager.insertMediaInfo(asReversedMutable);
            setLastScanTime(valueOf);
            this.mContext.d("RFWLocalPhotoScanManager", "[handleScanResult] scan finish, mediaInfo size: " + mediaList.size() + ", save lastScanTime: " + valueOf);
            rFWLocalPhotoTracer.onScanResultDbInsertFinish();
            return;
        }
        this.mContext.e("RFWLocalPhotoScanManager", "[handleScanResult] mediaInfo is empty");
        setLastScanTime(valueOf);
    }

    private final void setLastScanTime(String lastScanTime) {
        this.mContext.getDelegate().getConfigDelegate().saveConfig("KEY_LAST_SCAN_TIME", lastScanTime);
    }

    public final boolean deviceHaveEnoughSpace() {
        long systemAvailableSize;
        if (!this.mContext.getDelegate().getConfigDelegate().enableSdCardSpaceAdjudge()) {
            return true;
        }
        RFWRecommendUtil rFWRecommendUtil = RFWRecommendUtil.INSTANCE;
        if (rFWRecommendUtil.isExistSDCard()) {
            systemAvailableSize = rFWRecommendUtil.getSDCardAvailableSize();
        } else {
            systemAvailableSize = rFWRecommendUtil.getSystemAvailableSize();
        }
        if (systemAvailableSize > 50) {
            return true;
        }
        return false;
    }

    public final void scanLocalPhoto() {
        RFWLocalPhotoTracer rFWLocalPhotoTracer = RFWLocalPhotoTracer.INSTANCE;
        rFWLocalPhotoTracer.onStartScan();
        long lastScanTime = getLastScanTime();
        this.mContext.d("RFWLocalPhotoScanManager", "[scanLocalPhoto] lastScanTimeStr: " + lastScanTime);
        if (canScanPhoto(Long.valueOf(lastScanTime))) {
            if (this.mIsScanIng.compareAndSet(false, true)) {
                if (lastScanTime == 0) {
                    doFirstScan();
                    return;
                } else {
                    doIncreaseScan(lastScanTime);
                    return;
                }
            }
            this.mContext.e("RFWLocalPhotoScanManager", "[checkPhotoScan] is scanIng");
            rFWLocalPhotoTracer.onScanError("\u6b63\u5728\u626b\u63cf");
            return;
        }
        rFWLocalPhotoTracer.onScanError("\u4e0d\u6ee1\u8db3\u626b\u63cf\u6761\u4ef6");
    }
}
