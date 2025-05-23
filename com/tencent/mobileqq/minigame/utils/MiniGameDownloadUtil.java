package com.tencent.mobileqq.minigame.utils;

import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0012J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019Jj\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042H\u0010\u001f\u001aD\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001b\u0018\u00010 j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`%J\u0010\u0010&\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/minigame/utils/MiniGameDownloadUtil;", "", "()V", "BASE_NUMBER", "", "GB", "", "KB", "getKB", "()D", "MB", "TAG", "", "compareVersionCode", "versionCode", "miniVersionCode", "convertSizeToReadableDesc", "fileSize", "", "needDotForMB", "", "getAvailableAppInnerStorage", "getShowStr", "size", "getUpdateApkData", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "loadImage", "", "url", "width", "height", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "saveUpdateApkData", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameDownloadUtil {
    private static final int BASE_NUMBER;
    private static final double GB;
    public static final MiniGameDownloadUtil INSTANCE = new MiniGameDownloadUtil();
    private static final double KB;
    private static final double MB;
    private static final String TAG = "MiniGameDownloadUtil";

    static {
        int baseNumber = (int) com.tencent.mobileqq.utils.FileUtils.getBaseNumber();
        BASE_NUMBER = baseNumber;
        double d16 = baseNumber;
        KB = d16;
        double d17 = baseNumber * d16;
        MB = d17;
        GB = baseNumber * d17;
    }

    MiniGameDownloadUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImage$lambda$0(Option option, Function2 function2, String str, LoadState loadState, Option option2) {
        if (loadState.isFinishSuccess()) {
            String localPath = option.getLocalPath();
            if (localPath == null || !new File(localPath).exists()) {
                QLog.w(TAG, 1, "loadImage localPath get null.");
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE, null);
                }
            } else if (function2 != null) {
                function2.invoke(Boolean.TRUE, localPath);
            }
        }
        if (loadState.isFinishError()) {
            QLog.w(TAG, 1, "loadImage errorCode url:" + str);
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compareVersionCode(String versionCode, int miniVersionCode) {
        Integer intOrNull;
        int intValue = (versionCode == null || intOrNull == null) ? 0 : intOrNull.intValue();
        if (intValue > miniVersionCode) {
            return 1;
        }
        return intValue < miniVersionCode ? -1 : 0;
    }

    public final String convertSizeToReadableDesc(long fileSize, boolean needDotForMB) {
        double d16;
        String str = "";
        double d17 = fileSize;
        try {
            d16 = KB;
        } catch (ArithmeticException unused) {
            QLog.e(TAG, 4, " DecimalFormat \u6570\u5b57\u8f6c\u6362\u5b57\u7b26\u4e32 error ");
        }
        if (d17 < d16) {
            return fileSize + "B";
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0");
        double d18 = MB;
        if (d17 < d18) {
            str = decimalFormat.format(Math.round(d17 / d16)) + "KB";
            if (Intrinsics.areEqual(str, BASE_NUMBER + "KB")) {
                return "1MB";
            }
            return str;
        }
        double d19 = GB;
        if (d17 >= d19) {
            DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
            decimalFormat2.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat2.format(d17 / d19) + "GB";
        }
        if (needDotForMB) {
            DecimalFormat decimalFormat3 = new DecimalFormat("#.#");
            decimalFormat3.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat3.format(d17 / d18) + "MB";
        }
        return decimalFormat.format(Math.round(d17 / d18)) + "MB";
    }

    public final long getAvailableAppInnerStorage() {
        StatFs statFs = new StatFs(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        long availableBytes = statFs.getAvailableBytes();
        QLog.i(TAG, 1, "availableSize:" + availableBytes + " allSize:" + statFs.getTotalBytes());
        return availableBytes / 1024;
    }

    public final double getKB() {
        return KB;
    }

    public final MiniGameDownloadDataWrapper getUpdateApkData() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(BaseApplication.g\u2026QMMKVFile.FILE_MINI_GAME)");
        return (MiniGameDownloadDataWrapper) fromV2.getParcelable(MiniGameVAMMKVKEY.UPDATE_DATA, MiniGameDownloadDataWrapper.class, null);
    }

    public final void loadImage(final String url, int width, int height, final Function2<? super Boolean, ? super String, Unit> callback) {
        if (TextUtils.isEmpty(url)) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE, null);
                return;
            }
            return;
        }
        final Option imageOption = Option.obtain().setUrl(url);
        imageOption.setRequestWidth(width);
        imageOption.setRequestHeight(height);
        imageOption.setEnableAutoDeleteLocalCache(false);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(imageOption, "imageOption");
        qQPicLoader.e(imageOption, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.minigame.utils.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                MiniGameDownloadUtil.loadImage$lambda$0(Option.this, callback, url, loadState, option);
            }
        });
    }

    public final void saveUpdateApkData(MiniGameDownloadDataWrapper data) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(BaseApplication.g\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.putParcelable(MiniGameVAMMKVKEY.UPDATE_DATA, data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compareVersionCode(String versionCode, String miniVersionCode) {
        Integer intOrNull;
        Integer intOrNull2;
        int intValue = (versionCode == null || intOrNull2 == null) ? 0 : intOrNull2.intValue();
        int intValue2 = (miniVersionCode == null || intOrNull == null) ? 0 : intOrNull.intValue();
        if (intValue > intValue2) {
            return 1;
        }
        return intValue < intValue2 ? -1 : 0;
    }

    public final String getShowStr(long size) {
        if (size <= 0) {
            return "0MB";
        }
        return convertSizeToReadableDesc(size, false);
    }
}
