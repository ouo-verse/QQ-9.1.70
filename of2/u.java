package of2;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.CompressFileFolderInfo;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FileDownLoadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileDownloadStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileUploadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileUploadStatus;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferFileType;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferPauseReason;
import com.tencent.qqnt.kernel.nativeinterface.FolderDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FolderUploadInfo;
import com.tencent.qqnt.kernel.nativeinterface.PhysicalInfo;
import com.tencent.qqnt.kernel.nativeinterface.Picture;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/File;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/File;)[Ljava/lang/Object;", "b", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/File;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class u {
    public static final Object[] a(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = file.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("cliFileId");
        String cliFileId = file.cliFileId;
        Intrinsics.checkNotNullExpressionValue(cliFileId, "cliFileId");
        arrayList.add(cliFileId);
        arrayList.add("compressedFileFolderId");
        String compressedFileFolderId = file.compressedFileFolderId;
        Intrinsics.checkNotNullExpressionValue(compressedFileFolderId, "compressedFileFolderId");
        arrayList.add(compressedFileFolderId);
        arrayList.add("archiveIndex");
        arrayList.add(String.valueOf(file.archiveIndex));
        arrayList.add("indexPath");
        String indexPath = file.indexPath;
        Intrinsics.checkNotNullExpressionValue(indexPath, "indexPath");
        arrayList.add(indexPath);
        arrayList.add("isDir");
        arrayList.add(Integer.valueOf(file.isDir ? 1 : 0));
        arrayList.add("parentId");
        String parentId = file.parentId;
        Intrinsics.checkNotNullExpressionValue(parentId, "parentId");
        arrayList.add(parentId);
        arrayList.add("depth");
        arrayList.add(String.valueOf(file.depth));
        arrayList.add("cliFileIndex");
        arrayList.add(String.valueOf(file.cliFileIndex));
        arrayList.add(TagName.FILE_TYPE);
        arrayList.add(Integer.valueOf(file.fileType.ordinal()));
        arrayList.add("name");
        String name = file.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        arrayList.add(name);
        arrayList.add("namePinyin");
        String namePinyin = file.namePinyin;
        Intrinsics.checkNotNullExpressionValue(namePinyin, "namePinyin");
        arrayList.add(namePinyin);
        arrayList.add("isCover");
        arrayList.add(Integer.valueOf(file.isCover ? 1 : 0));
        arrayList.add("isCoverOriginal");
        arrayList.add(Integer.valueOf(file.isCoverOriginal ? 1 : 0));
        arrayList.add("fileSize");
        arrayList.add(String.valueOf(file.fileSize));
        arrayList.add(QuotaFileSystem.STAT_FILE_COUNT);
        arrayList.add(String.valueOf(file.fileCount));
        arrayList.add(AssetExtension.SCENE_THUMBNAIL);
        Picture thumbnail = file.thumbnail;
        Intrinsics.checkNotNullExpressionValue(thumbnail, "thumbnail");
        Object[] a16 = bq.a(thumbnail);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add("physical");
        PhysicalInfo physical = file.physical;
        Intrinsics.checkNotNullExpressionValue(physical, "physical");
        Object[] a17 = bp.a(physical);
        arrayList.add(Integer.valueOf(a17.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a17);
        arrayList.add("srvFileId");
        String srvFileId = file.srvFileId;
        Intrinsics.checkNotNullExpressionValue(srvFileId, "srvFileId");
        arrayList.add(srvFileId);
        arrayList.add("srvParentFileId");
        String srvParentFileId = file.srvParentFileId;
        Intrinsics.checkNotNullExpressionValue(srvParentFileId, "srvParentFileId");
        arrayList.add(srvParentFileId);
        arrayList.add("svrLastUpdateTimestamp");
        arrayList.add(String.valueOf(file.svrLastUpdateTimestamp));
        arrayList.add("downloadInfo");
        FileDownLoadInfo downloadInfo = file.downloadInfo;
        Intrinsics.checkNotNullExpressionValue(downloadInfo, "downloadInfo");
        Object[] a18 = t.a(downloadInfo);
        arrayList.add(Integer.valueOf(a18.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a18);
        arrayList.add("saveFilePath");
        String saveFilePath = file.saveFilePath;
        Intrinsics.checkNotNullExpressionValue(saveFilePath, "saveFilePath");
        arrayList.add(saveFilePath);
        arrayList.add("searchRelativePath");
        String searchRelativePath = file.searchRelativePath;
        Intrinsics.checkNotNullExpressionValue(searchRelativePath, "searchRelativePath");
        arrayList.add(searchRelativePath);
        arrayList.add("diskRelativePath");
        String diskRelativePath = file.diskRelativePath;
        Intrinsics.checkNotNullExpressionValue(diskRelativePath, "diskRelativePath");
        arrayList.add(diskRelativePath);
        arrayList.add("uploadInfo");
        FileUploadInfo uploadInfo = file.uploadInfo;
        Intrinsics.checkNotNullExpressionValue(uploadInfo, "uploadInfo");
        Object[] a19 = ab.a(uploadInfo);
        arrayList.add(Integer.valueOf(a19.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a19);
        arrayList.add("status");
        arrayList.add(Integer.valueOf(file.status.ordinal()));
        arrayList.add("uploadStatus");
        arrayList.add(Integer.valueOf(file.uploadStatus.ordinal()));
        arrayList.add(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
        arrayList.add(Integer.valueOf(file.downloadStatus.ordinal()));
        arrayList.add("folderUploadInfo");
        FolderUploadInfo folderUploadInfo = file.folderUploadInfo;
        Intrinsics.checkNotNullExpressionValue(folderUploadInfo, "folderUploadInfo");
        Object[] a26 = ao.a(folderUploadInfo);
        arrayList.add(Integer.valueOf(a26.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a26);
        arrayList.add("folderDownloadInfo");
        FolderDownloadInfo folderDownloadInfo = file.folderDownloadInfo;
        Intrinsics.checkNotNullExpressionValue(folderDownloadInfo, "folderDownloadInfo");
        Object[] a27 = an.a(folderDownloadInfo);
        arrayList.add(Integer.valueOf(a27.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a27);
        arrayList.add("sha1");
        String sha1 = file.sha1;
        Intrinsics.checkNotNullExpressionValue(sha1, "sha1");
        arrayList.add(sha1);
        arrayList.add("bookmark");
        String bookmark = file.bookmark;
        Intrinsics.checkNotNullExpressionValue(bookmark, "bookmark");
        arrayList.add(bookmark);
        arrayList.add("compressFileFolderInfo");
        CompressFileFolderInfo compressFileFolderInfo = file.compressFileFolderInfo;
        Intrinsics.checkNotNullExpressionValue(compressFileFolderInfo, "compressFileFolderInfo");
        Object[] b16 = j.b(compressFileFolderInfo);
        arrayList.add(Integer.valueOf(b16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, b16);
        arrayList.add("uploadPauseReason");
        arrayList.add(Integer.valueOf(file.uploadPauseReason.ordinal()));
        arrayList.add("downloadPauseReason");
        arrayList.add(Integer.valueOf(file.downloadPauseReason.ordinal()));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    public static final File b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        File file = new File();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                file.fileSetId = (String) next2;
            } else if (Intrinsics.areEqual(next, "cliFileId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                file.cliFileId = (String) next3;
            } else if (Intrinsics.areEqual(next, "compressedFileFolderId")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                file.compressedFileFolderId = (String) next4;
            } else if (Intrinsics.areEqual(next, "archiveIndex")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                file.archiveIndex = Integer.parseInt((String) next5);
            } else if (Intrinsics.areEqual(next, "indexPath")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                file.indexPath = (String) next6;
            } else {
                if (Intrinsics.areEqual(next, "isDir")) {
                    Object next7 = it.next();
                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                    file.isDir = ((Integer) next7).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "parentId")) {
                    Object next8 = it.next();
                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                    file.parentId = (String) next8;
                } else if (Intrinsics.areEqual(next, "depth")) {
                    Object next9 = it.next();
                    Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                    file.depth = Integer.parseInt((String) next9);
                } else if (Intrinsics.areEqual(next, "cliFileIndex")) {
                    Object next10 = it.next();
                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                    file.cliFileIndex = Integer.parseInt((String) next10);
                } else if (Intrinsics.areEqual(next, TagName.FILE_TYPE)) {
                    FlashTransferFileType[] values = FlashTransferFileType.values();
                    Object next11 = it.next();
                    Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.Int");
                    file.fileType = values[((Integer) next11).intValue()];
                } else if (Intrinsics.areEqual(next, "name")) {
                    Object next12 = it.next();
                    Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.String");
                    file.name = (String) next12;
                } else if (Intrinsics.areEqual(next, "namePinyin")) {
                    Object next13 = it.next();
                    Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                    file.namePinyin = (String) next13;
                } else if (Intrinsics.areEqual(next, "isCover")) {
                    Object next14 = it.next();
                    Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.Int");
                    file.isCover = ((Integer) next14).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "isCoverOriginal")) {
                    Object next15 = it.next();
                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int");
                    file.isCoverOriginal = ((Integer) next15).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "fileSize")) {
                    Object next16 = it.next();
                    Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.String");
                    file.fileSize = Long.parseLong((String) next16);
                } else if (Intrinsics.areEqual(next, QuotaFileSystem.STAT_FILE_COUNT)) {
                    Object next17 = it.next();
                    Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.String");
                    file.fileCount = Integer.parseInt((String) next17);
                } else if (Intrinsics.areEqual(next, AssetExtension.SCENE_THUMBNAIL)) {
                    Object next18 = it.next();
                    Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) next18).intValue();
                    Object[] objArr2 = new Object[intValue];
                    for (int i3 = 0; i3 < intValue; i3++) {
                        objArr2[i3] = it.next();
                    }
                    file.thumbnail = bq.b(objArr2);
                } else if (Intrinsics.areEqual(next, "physical")) {
                    Object next19 = it.next();
                    Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next19).intValue();
                    Object[] objArr3 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr3[i16] = it.next();
                    }
                    file.physical = bp.b(objArr3);
                } else if (Intrinsics.areEqual(next, "srvFileId")) {
                    Object next20 = it.next();
                    Intrinsics.checkNotNull(next20, "null cannot be cast to non-null type kotlin.String");
                    file.srvFileId = (String) next20;
                } else if (Intrinsics.areEqual(next, "srvParentFileId")) {
                    Object next21 = it.next();
                    Intrinsics.checkNotNull(next21, "null cannot be cast to non-null type kotlin.String");
                    file.srvParentFileId = (String) next21;
                } else if (Intrinsics.areEqual(next, "svrLastUpdateTimestamp")) {
                    Object next22 = it.next();
                    Intrinsics.checkNotNull(next22, "null cannot be cast to non-null type kotlin.String");
                    file.svrLastUpdateTimestamp = Long.parseLong((String) next22);
                } else if (Intrinsics.areEqual(next, "downloadInfo")) {
                    Object next23 = it.next();
                    Intrinsics.checkNotNull(next23, "null cannot be cast to non-null type kotlin.Int");
                    int intValue3 = ((Integer) next23).intValue();
                    Object[] objArr4 = new Object[intValue3];
                    for (int i17 = 0; i17 < intValue3; i17++) {
                        objArr4[i17] = it.next();
                    }
                    file.downloadInfo = t.b(objArr4);
                } else if (Intrinsics.areEqual(next, "saveFilePath")) {
                    Object next24 = it.next();
                    Intrinsics.checkNotNull(next24, "null cannot be cast to non-null type kotlin.String");
                    file.saveFilePath = (String) next24;
                } else if (Intrinsics.areEqual(next, "searchRelativePath")) {
                    Object next25 = it.next();
                    Intrinsics.checkNotNull(next25, "null cannot be cast to non-null type kotlin.String");
                    file.searchRelativePath = (String) next25;
                } else if (Intrinsics.areEqual(next, "diskRelativePath")) {
                    Object next26 = it.next();
                    Intrinsics.checkNotNull(next26, "null cannot be cast to non-null type kotlin.String");
                    file.diskRelativePath = (String) next26;
                } else if (Intrinsics.areEqual(next, "uploadInfo")) {
                    Object next27 = it.next();
                    Intrinsics.checkNotNull(next27, "null cannot be cast to non-null type kotlin.Int");
                    int intValue4 = ((Integer) next27).intValue();
                    Object[] objArr5 = new Object[intValue4];
                    for (int i18 = 0; i18 < intValue4; i18++) {
                        objArr5[i18] = it.next();
                    }
                    file.uploadInfo = ab.b(objArr5);
                } else if (Intrinsics.areEqual(next, "status")) {
                    FileStatus[] values2 = FileStatus.values();
                    Object next28 = it.next();
                    Intrinsics.checkNotNull(next28, "null cannot be cast to non-null type kotlin.Int");
                    file.status = values2[((Integer) next28).intValue()];
                } else if (Intrinsics.areEqual(next, "uploadStatus")) {
                    FileUploadStatus[] values3 = FileUploadStatus.values();
                    Object next29 = it.next();
                    Intrinsics.checkNotNull(next29, "null cannot be cast to non-null type kotlin.Int");
                    file.uploadStatus = values3[((Integer) next29).intValue()];
                } else if (Intrinsics.areEqual(next, VirtualAppProxy.KEY_DOWNLOAD_STATUS)) {
                    FileDownloadStatus[] values4 = FileDownloadStatus.values();
                    Object next30 = it.next();
                    Intrinsics.checkNotNull(next30, "null cannot be cast to non-null type kotlin.Int");
                    file.downloadStatus = values4[((Integer) next30).intValue()];
                } else if (Intrinsics.areEqual(next, "folderUploadInfo")) {
                    Object next31 = it.next();
                    Intrinsics.checkNotNull(next31, "null cannot be cast to non-null type kotlin.Int");
                    int intValue5 = ((Integer) next31).intValue();
                    Object[] objArr6 = new Object[intValue5];
                    for (int i19 = 0; i19 < intValue5; i19++) {
                        objArr6[i19] = it.next();
                    }
                    file.folderUploadInfo = ao.b(objArr6);
                } else if (Intrinsics.areEqual(next, "folderDownloadInfo")) {
                    Object next32 = it.next();
                    Intrinsics.checkNotNull(next32, "null cannot be cast to non-null type kotlin.Int");
                    int intValue6 = ((Integer) next32).intValue();
                    Object[] objArr7 = new Object[intValue6];
                    for (int i26 = 0; i26 < intValue6; i26++) {
                        objArr7[i26] = it.next();
                    }
                    file.folderDownloadInfo = an.b(objArr7);
                } else if (Intrinsics.areEqual(next, "sha1")) {
                    Object next33 = it.next();
                    Intrinsics.checkNotNull(next33, "null cannot be cast to non-null type kotlin.String");
                    file.sha1 = (String) next33;
                } else if (Intrinsics.areEqual(next, "bookmark")) {
                    Object next34 = it.next();
                    Intrinsics.checkNotNull(next34, "null cannot be cast to non-null type kotlin.String");
                    file.bookmark = (String) next34;
                } else if (Intrinsics.areEqual(next, "compressFileFolderInfo")) {
                    Object next35 = it.next();
                    Intrinsics.checkNotNull(next35, "null cannot be cast to non-null type kotlin.Int");
                    int intValue7 = ((Integer) next35).intValue();
                    Object[] objArr8 = new Object[intValue7];
                    for (int i27 = 0; i27 < intValue7; i27++) {
                        objArr8[i27] = it.next();
                    }
                    file.compressFileFolderInfo = j.a(objArr8);
                } else if (Intrinsics.areEqual(next, "uploadPauseReason")) {
                    FlashTransferPauseReason[] values5 = FlashTransferPauseReason.values();
                    Object next36 = it.next();
                    Intrinsics.checkNotNull(next36, "null cannot be cast to non-null type kotlin.Int");
                    file.uploadPauseReason = values5[((Integer) next36).intValue()];
                } else if (Intrinsics.areEqual(next, "downloadPauseReason")) {
                    FlashTransferPauseReason[] values6 = FlashTransferPauseReason.values();
                    Object next37 = it.next();
                    Intrinsics.checkNotNull(next37, "null cannot be cast to non-null type kotlin.Int");
                    file.downloadPauseReason = values6[((Integer) next37).intValue()];
                }
            }
        }
        return file;
    }
}
