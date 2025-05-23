package com.tencent.mobileqq.aio.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u0000\u001a\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\b\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\b\u001a\f\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "", "a", "", "c", "", "thumbSize", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "e", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "d", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class aj {
    @Nullable
    public static final String a(@NotNull PicElement picElement) {
        String str;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            str = e16.assembleMobileQQRichMediaFilePath(new RichMediaFilePathInfo(2, picElement.picSubType, picElement.md5HexStr, picElement.fileName, 1, 0, null, picElement.fileUuid, false));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return picElement.sourcePath;
        }
        return str;
    }

    @Nullable
    public static final String b(@NotNull PicElement picElement, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        String str2 = null;
        if (e16 != null) {
            str = e16.assembleMobileQQRichMediaFilePath(new RichMediaFilePathInfo(2, picElement.picSubType, picElement.md5HexStr, picElement.fileName, 2, i3, picElement.importRichMediaContext, picElement.fileUuid, false));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            HashMap<Integer, String> hashMap = picElement.thumbPath;
            if (hashMap != null) {
                str2 = hashMap.get(Integer.valueOf(i3));
            }
            return str2;
        }
        return str;
    }

    @NotNull
    public static final List<String> c(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer[] numArr = {720, 0, 198};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            String b16 = b(picElement, numArr[i3].intValue());
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final String d(@NotNull PttElement pttElement) {
        String str;
        Intrinsics.checkNotNullParameter(pttElement, "<this>");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            str = e16.assembleMobileQQRichMediaFilePath(new RichMediaFilePathInfo(4, 3, pttElement.md5HexStr, pttElement.fileName, 1, 0, pttElement.importRichMediaContext, pttElement.fileUuid, false));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return pttElement.filePath;
        }
        return str;
    }

    @Nullable
    public static final String e(@NotNull VideoElement videoElement) {
        String str;
        Intrinsics.checkNotNullParameter(videoElement, "<this>");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            str = e16.assembleMobileQQRichMediaFilePath(new RichMediaFilePathInfo(5, 0, videoElement.videoMd5, FileUtils.getFileName(videoElement.fileName), 1, 0, videoElement.importRichMediaContext, videoElement.fileUuid, false));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return videoElement.filePath;
        }
        return str;
    }

    @Nullable
    public static final String f(@NotNull VideoElement videoElement) {
        String str;
        Intrinsics.checkNotNullParameter(videoElement, "<this>");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        String str2 = null;
        if (e16 != null) {
            str = e16.assembleMobileQQRichMediaFilePath(new RichMediaFilePathInfo(5, 0, videoElement.videoMd5, FileUtils.getFileName(videoElement.fileName), 2, 0, videoElement.importRichMediaContext, videoElement.fileUuid, false));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            HashMap<Integer, String> hashMap = videoElement.thumbPath;
            if (hashMap != null) {
                str2 = hashMap.get(0);
            }
            return str2;
        }
        return str;
    }
}
