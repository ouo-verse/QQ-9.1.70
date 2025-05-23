package com.tencent.mobileqq.vas.pendant;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasSafeUnzip;
import com.tencent.mobileqq.vas.pendant.api.IPendantResDownloadApi;
import com.tencent.mobileqq.vas.pendant.toggle.PendantGreyToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.util.b;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0014J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tJ\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010-\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u001bH\u0002J\u000e\u0010/\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u00100\u001a\u00020+2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0012\u00100\u001a\u00020+2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u00101\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/PendantBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "Lcom/tencent/vas/update/business/BaseUpdateBusiness;", "()V", "avifFailMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "avifFileValid", "", "pendantId", "checkPngsIsValid", "", "dstDir", "checkScid", "scid", "getBid", "getBusinessDir", "getBusinessItemInfo", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "bid", "getCustomItemInfo", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness$CustomBusinessItemInfo;", "getFrom", "getKeyForCallLoad", "getPendantNumFontScid", MessageForRichState.SIGN_MSG_FONT_ID, "", "getPendantScid", "isSupportAvif", "isFilterAvifFail", "getSavePath", "getScid", "id", "getStickerScid", "pasterId", "isEnableCheckFile", "isEnableFileClean", "isFileExists", "isNeedRedirectionToPngs", "params", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "onLoadFail", "", "onLoadSuccess", "pendantCompleted", "errorCode", "pngsFileValid", "startDownload", "staticPngsValid", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PendantBusiness extends QQVasUpdateBusiness<BaseUpdateBusiness> {

    @NotNull
    private static final String AVIF_SUFFIX = "avif-image.avif";

    @NotNull
    private static final String PNGS_SUFFIX = "aio_file.zip";

    @NotNull
    private static final String SCID_PENDANT_FONT_PREFIX = "faceAddon.stickerFont.android.";

    @NotNull
    private static final String SCID_PENDANT_PASTER_PREFIX = "faceAddon.sticker.";

    @NotNull
    private static final String SCID_PENDANT_PREFIX = "pendant.";

    @NotNull
    private static final String SCID_SUFFIX_AVIF = ".other.avif.zip";

    @NotNull
    private static final String SCID_SUFFIX_OTHER = ".other.zip";

    @NotNull
    private static final String SPECIAL_SHAPE_PRE_AVIF = "special-";

    @NotNull
    private static final String SPECIAL_SHAPE_PRE_PNGS = "special_shape";

    @NotNull
    private static final String TAG = "VasUpdate_PendantBusiness";

    @NotNull
    private final ConcurrentHashMap<Long, Object> avifFailMap = new ConcurrentHashMap<>();

    @NotNull
    private static final HashMap<String, String> CHECK_RESULT = new HashMap<>();

    private final boolean checkPngsIsValid(String dstDir) {
        ArrayList<String> childFiles = FileUtils.getChildFiles(dstDir);
        boolean z16 = false;
        if (childFiles.size() <= 0) {
            return false;
        }
        String str = dstDir + File.separator;
        int size = childFiles.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            i3++;
            if (!new File(str + i3 + ".png").exists()) {
                FileUtils.deleteDirectory(dstDir);
                z16 = true;
                break;
            }
        }
        return !z16;
    }

    private final boolean checkScid(String scid) {
        boolean contains$default;
        if (scid == null) {
            return false;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) scid, (CharSequence) DownloadInfo.spKey_Config, false, 2, (Object) null);
        if (contains$default) {
            return false;
        }
        return true;
    }

    private final String getKeyForCallLoad(String scid) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, "pendant.", false, 2, null);
        if (startsWith$default) {
            List<String> split = new Regex("\\.").split(scid, 0);
            if (split.size() > 2) {
                return split.get(1);
            }
            return scid;
        }
        return scid;
    }

    private final String getPendantScid(long pendantId, boolean isSupportAvif, boolean isFilterAvifFail) {
        StringBuilder sb5 = new StringBuilder("pendant.");
        sb5.append(pendantId);
        if (isSupportAvif) {
            if (isFilterAvifFail && this.avifFailMap.containsKey(Long.valueOf(pendantId))) {
                sb5.append(".other.zip");
            } else {
                sb5.append(".other.avif.zip");
            }
        } else {
            sb5.append(".other.zip");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "resultBuilder.toString()");
        return sb6;
    }

    static /* synthetic */ String getPendantScid$default(PendantBusiness pendantBusiness, long j3, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return pendantBusiness.getPendantScid(j3, z16, z17);
    }

    private final boolean isNeedRedirectionToPngs(UpdateListenerParams params) {
        boolean z16;
        if (params.mErrorCode == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i(TAG, 1, "url code error happened! please check server code!!!!");
        }
        if (!b.f362976b.isDebugVersion() || !z16) {
            return false;
        }
        return true;
    }

    private final void pendantCompleted(String scid, int errorCode) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.stickerFont.android.", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.sticker.", false, 2, null);
            if (startsWith$default2 && errorCode == 0) {
                ((IPendantResDownloadApi) QRoute.api(IPendantResDownloadApi.class)).notifyPasterDownloadComplete(scid);
                return;
            }
            return;
        }
        if (errorCode == 0) {
            ((IPendantResDownloadApi) QRoute.api(IPendantResDownloadApi.class)).notifyFontDownloadComplete(scid);
        }
    }

    @NotNull
    public final String avifFileValid(long pendantId) {
        if (!PendantGreyToggle.INSTANCE.isSupportAvifImage()) {
            return "";
        }
        String pendantScid$default = getPendantScid$default(this, pendantId, true, false, 4, null);
        HashMap<String, String> hashMap = CHECK_RESULT;
        String str = hashMap.get(pendantScid$default);
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        String savePath = getSavePath(pendantScid$default);
        String str2 = File.separator;
        File file = new File(savePath + str2 + "special-avif-image.avif");
        if (!file.exists()) {
            file = new File(savePath + str2 + AVIF_SUFFIX);
        }
        if (!file.exists() || !file.isFile() || file.length() <= 0) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "avifFile.absolutePath");
        hashMap.put(pendantScid$default, absolutePath);
        String absolutePath2 = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "{\n            CHECK_RESU\u2026le.absolutePath\n        }");
        return absolutePath2;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 4L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return IndividuationUrlHelper.UrlId.PENDANT_HOME;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @NotNull String scid) {
        boolean contains$default;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(scid, "scid");
        BusinessItemInfo itemInfo = super.getBusinessItemInfo(bid, scid);
        boolean z16 = false;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) scid, (CharSequence) DownloadInfo.spKey_Config, false, 2, (Object) null);
        if (contains$default) {
            itemInfo.mIsCanUpdate = false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.sticker.", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.stickerFont.android.", false, 2, null);
            if (!startsWith$default2) {
                z16 = true;
            }
        }
        itemInfo.mSaveInDir = z16;
        itemInfo.mSavePath = getSavePath(scid);
        Intrinsics.checkNotNullExpressionValue(itemInfo, "itemInfo");
        return itemInfo;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long bid, @NotNull String scid) {
        boolean contains$default;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(scid, "scid");
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        boolean z16 = false;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) scid, (CharSequence) DownloadInfo.spKey_Config, false, 2, (Object) null);
        if (contains$default) {
            customBusinessItemInfo.mIsCanUpdate = false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.sticker.", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.stickerFont.android.", false, 2, null);
            if (!startsWith$default2) {
                z16 = true;
            }
        }
        customBusinessItemInfo.mSaveInDir = z16;
        customBusinessItemInfo.mSavePath = getSavePath(scid);
        return customBusinessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "PendantBusiness";
    }

    @NotNull
    public final String getPendantNumFontScid(int fontId) {
        return "faceAddon.stickerFont.android." + fontId;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public String getSavePath(@NotNull String scid) {
        boolean startsWith$default;
        boolean startsWith$default2;
        List emptyList;
        boolean z16;
        List emptyList2;
        boolean z17;
        Intrinsics.checkNotNullParameter(scid, "scid");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.stickerFont.android.", false, 2, null);
        String str = "";
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scid, "faceAddon.sticker.", false, 2, null);
            if (startsWith$default2) {
                List<String> split = new Regex("\\.").split(scid, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr.length > 2) {
                    str = strArr[2];
                }
                return super.getSavePath(scid) + File.separator + str + ".png";
            }
            String savePath = super.getSavePath(scid);
            Intrinsics.checkNotNullExpressionValue(savePath, "super.getSavePath(scid)");
            return savePath;
        }
        List<String> split2 = new Regex("\\.").split(scid, 0);
        if (!split2.isEmpty()) {
            ListIterator<String> listIterator2 = split2.listIterator(split2.size());
            while (listIterator2.hasPrevious()) {
                if (listIterator2.previous().length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        Object[] array2 = emptyList2.toArray(new String[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr2 = (String[]) array2;
        if (strArr2.length > 3) {
            str = strArr2[3];
        }
        String savePath2 = super.getSavePath(scid);
        String str2 = File.separator;
        return savePath2 + str2 + "font_info/" + str + str2 + str + ".ttf";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public String getScid(int id5) {
        return String.valueOf(id5);
    }

    @NotNull
    public final String getStickerScid(@NotNull String pasterId) {
        Intrinsics.checkNotNullParameter(pasterId, "pasterId");
        return "faceAddon.sticker." + pasterId + ".png";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int id5) {
        long j3 = id5;
        String pendantScid$default = getPendantScid$default(this, j3, true, false, 4, null);
        String pendantScid$default2 = getPendantScid$default(this, j3, false, false, 4, null);
        if (PendantGreyToggle.INSTANCE.isSupportAvifImage()) {
            if (!isFileExist(pendantScid$default) && !isFileExist(pendantScid$default2)) {
                return false;
            }
            return true;
        }
        return isFileExist(pendantScid$default2);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NotNull UpdateListenerParams params) {
        boolean endsWith$default;
        String replace$default;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.e(TAG, 1, "onLoadFail errorCode=" + params.mErrorCode + " httpCode=" + params.mHttpCode + " errorMessage=" + params.mErrorMessage + " scid=" + params.mBusinessUpdateParams.mScid);
        String str = params.mBusinessUpdateParams.mScid;
        Intrinsics.checkNotNullExpressionValue(str, "params.mBusinessUpdateParams.mScid");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, "avif.zip", false, 2, null);
        if (endsWith$default && (params.mErrorCode == 24 || isNeedRedirectionToPngs(params))) {
            String str2 = params.mBusinessUpdateParams.mScid;
            Intrinsics.checkNotNullExpressionValue(str2, "params.mBusinessUpdateParams.mScid");
            replace$default = StringsKt__StringsJVMKt.replace$default(str2, BasePicDownloadProcessor.AVIF_FILE_SUFFIX, "", false, 4, (Object) null);
            QLog.i(TAG, 2, "\u8bf7\u6c42avif=" + params.mBusinessUpdateParams.mScid + "\u5931\u8d25\uff0c\u5c1d\u8bd5\u8bf7\u6c42png=" + replace$default);
            startDownload(replace$default);
            try {
                String str3 = params.mBusinessUpdateParams.mScid;
                Intrinsics.checkNotNullExpressionValue(str3, "params.mBusinessUpdateParams.mScid");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(getKeyForCallLoad(str3));
                if (longOrNull != null) {
                    this.avifFailMap.put(Long.valueOf(longOrNull.longValue()), 1);
                    return;
                }
                return;
            } catch (Exception unused) {
                QLog.i(TAG, 1, "toLong fail : " + params.mBusinessUpdateParams.mScid);
                return;
            }
        }
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        String str4 = businessUpdateParams.mScid;
        Intrinsics.checkNotNullExpressionValue(str4, "params.mBusinessUpdateParams.mScid");
        businessUpdateParams.mScid = getKeyForCallLoad(str4);
        super.onLoadFail(params);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NotNull UpdateListenerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (QQVasUpdateBusiness.fixBugs122584537) {
            if (!this.downloadedStatus.contains(params.mBusinessUpdateParams.mScid)) {
                this.downloadedStatus.add(params.mBusinessUpdateParams.mScid);
            }
        } else {
            this.downloadedStatus.add(params.mBusinessUpdateParams.mScid);
        }
        String str = params.mBusinessUpdateParams.mScid;
        Intrinsics.checkNotNullExpressionValue(str, "params.mBusinessUpdateParams.mScid");
        pendantCompleted(str, params.mErrorCode);
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        String str2 = businessUpdateParams.mScid;
        Intrinsics.checkNotNullExpressionValue(str2, "params.mBusinessUpdateParams.mScid");
        businessUpdateParams.mScid = getKeyForCallLoad(str2);
        super.onLoadSuccess(params);
    }

    @NotNull
    public final String pngsFileValid(long pendantId) {
        String pendantScid$default = getPendantScid$default(this, pendantId, false, false, 4, null);
        String savePath = getSavePath(pendantScid$default);
        HashMap<String, String> hashMap = CHECK_RESULT;
        String str = hashMap.get(pendantScid$default);
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        if (new File(savePath).exists()) {
            String str2 = File.separator;
            File file = new File(savePath + str2 + "special_shape_aio_file.zip");
            if (file.exists()) {
                String str3 = savePath + str2 + "special_shape_aio_file";
                if (checkPngsIsValid(str3)) {
                    hashMap.put(pendantScid$default, str3);
                    return str3;
                }
                if (!TextUtils.isEmpty(VasSafeUnzip.safeUnZipFile$default(file, str3, false, 4, null)) && checkPngsIsValid(str3)) {
                    hashMap.put(pendantScid$default, str3);
                    return str3;
                }
            }
            File file2 = new File(savePath + str2 + PNGS_SUFFIX);
            if (file2.exists()) {
                String str4 = savePath + str2 + MiniProgramLpReportDC04239.FILE_MATERIAL_ACTION_TYPE;
                if (checkPngsIsValid(str4)) {
                    hashMap.put(pendantScid$default, str4);
                    return str4;
                }
                if (!TextUtils.isEmpty(VasSafeUnzip.safeUnZipFile$default(file2, str4, false, 4, null)) && checkPngsIsValid(str4)) {
                    hashMap.put(pendantScid$default, str4);
                    return str4;
                }
                return "";
            }
            return "";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness
    public void startDownload(@Nullable String scid) {
        if (checkScid(scid)) {
            super.startDownload(scid);
        }
    }

    @NotNull
    public final String staticPngsValid(long pendantId) {
        String savePath = getSavePath(getPendantScid$default(this, pendantId, false, false, 4, null));
        String str = savePath + "/preview_50.png";
        if (!new File(savePath).exists() || !new File(str).exists()) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void startDownload(int id5) {
        super.startDownload(getPendantScid(id5, PendantGreyToggle.INSTANCE.isSupportAvifImage(), true));
    }
}
