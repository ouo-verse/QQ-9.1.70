package fj;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import cooperation.qzone.model.ForwardMediaInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J&\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019\u00a8\u0006\u001e"}, d2 = {"Lfj/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "videoElement", "f", "path", "", "a", DTConstants.TAG.ELEMENT, "", "msgTime", "Lcooperation/qzone/model/ForwardMediaInfo;", "g", tl.h.F, "", "mediaType", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "b", "", "thumbPath", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f399446a = new b();

    b() {
    }

    private final boolean a(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    private final String c(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        MsgElement msgElement = null;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                msgElement = next;
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        FileManagerEntity i3 = msgElement != null ? NTFileUtils.i((peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) ? null : (QQAppInterface) peekAppRuntime, null, msgRecord, msgElement.elementId) : null;
        if (i3 != null) {
            return i3.getFilePath();
        }
        return null;
    }

    private final String f(VideoElement videoElement) {
        if (videoElement == null) {
            return "";
        }
        String e16 = aj.e(videoElement);
        if (e16 == null) {
            e16 = "";
        }
        if (a(e16)) {
            return e16;
        }
        if (!a(videoElement.fileName)) {
            return "";
        }
        String str = videoElement.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "videoElement.fileName");
        return str;
    }

    public final ForwardMediaInfo b(int mediaType, FileElement element, long msgTime, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ForwardMediaInfo forwardMediaInfo = new ForwardMediaInfo();
        forwardMediaInfo.mediaType = mediaType;
        forwardMediaInfo.uin = LoginData.getInstance().getUin();
        forwardMediaInfo.dittoUin = LoginData.getInstance().getUid();
        forwardMediaInfo.msgTime = msgTime;
        HashMap<Integer, String> hashMap = element.picThumbPath;
        forwardMediaInfo.thumbPath = hashMap;
        if (mediaType == 4) {
            forwardMediaInfo.filePath = c(msgRecord);
        } else {
            forwardMediaInfo.filePath = d(hashMap);
        }
        forwardMediaInfo.fileName = element.fileName;
        forwardMediaInfo.fileMd5 = element.fileMd5;
        forwardMediaInfo.thumbMd5 = element.thumbMd5;
        Integer num = element.videoDuration;
        Intrinsics.checkNotNullExpressionValue(num, "element.videoDuration");
        forwardMediaInfo.fileTime = num.intValue();
        forwardMediaInfo.fileSha = element.fileSha;
        forwardMediaInfo.fileSha3 = element.fileSha3;
        forwardMediaInfo.fileSize = element.fileSize;
        Integer num2 = element.picHeight;
        Intrinsics.checkNotNullExpressionValue(num2, "element.picHeight");
        forwardMediaInfo.picHeight = num2.intValue();
        Integer num3 = element.picWidth;
        Intrinsics.checkNotNullExpressionValue(num3, "element.picWidth");
        forwardMediaInfo.picWidth = num3.intValue();
        forwardMediaInfo.fileUuid = element.fileUuid;
        forwardMediaInfo.fileSubId = element.fileSubId;
        forwardMediaInfo.fileBizId = element.fileBizId;
        Integer num4 = element.invalidState;
        Intrinsics.checkNotNullExpressionValue(num4, "element.invalidState");
        forwardMediaInfo.invalidState = num4.intValue();
        forwardMediaInfo.storeID = element.storeID;
        return forwardMediaInfo;
    }

    public final ForwardMediaInfo g(PicElement element, long msgTime) {
        Intrinsics.checkNotNullParameter(element, "element");
        ForwardMediaInfo forwardMediaInfo = new ForwardMediaInfo();
        forwardMediaInfo.mediaType = 1;
        forwardMediaInfo.uin = LoginData.getInstance().getUin();
        forwardMediaInfo.dittoUin = LoginData.getInstance().getUid();
        forwardMediaInfo.msgTime = msgTime;
        forwardMediaInfo.thumbPath = element.thumbPath;
        forwardMediaInfo.picSubType = element.picSubType;
        forwardMediaInfo.fileName = element.fileName;
        forwardMediaInfo.fileSize = element.fileSize;
        forwardMediaInfo.picWidth = element.picWidth;
        forwardMediaInfo.picHeight = element.picHeight;
        forwardMediaInfo.original = element.original;
        forwardMediaInfo.md5HexStr = element.md5HexStr;
        forwardMediaInfo.sourcePath = element.sourcePath;
        forwardMediaInfo.downloadIndex = element.downloadIndex;
        forwardMediaInfo.summary = element.summary;
        forwardMediaInfo.originImageMd5 = element.originImageMd5;
        forwardMediaInfo.originImageUrl = element.originImageUrl;
        forwardMediaInfo.filePath = e(element);
        forwardMediaInfo.isFlashPic = element.isFlashPic;
        forwardMediaInfo.fileUuid = element.fileUuid;
        forwardMediaInfo.storeID = element.storeID;
        Integer num = element.invalidState;
        Intrinsics.checkNotNullExpressionValue(num, "element.invalidState");
        forwardMediaInfo.invalidState = num.intValue();
        QLog.d("ForwardGroupAlbumDataConvertor", 1, "picToMediaInfo mediaInfo:" + forwardMediaInfo);
        return forwardMediaInfo;
    }

    public final ForwardMediaInfo h(VideoElement element, long msgTime) {
        Intrinsics.checkNotNullParameter(element, "element");
        ForwardMediaInfo forwardMediaInfo = new ForwardMediaInfo();
        forwardMediaInfo.mediaType = 2;
        forwardMediaInfo.uin = LoginData.getInstance().getUin();
        forwardMediaInfo.dittoUin = LoginData.getInstance().getUid();
        forwardMediaInfo.msgTime = msgTime;
        forwardMediaInfo.thumbPath = element.thumbPath;
        forwardMediaInfo.filePath = f(element);
        forwardMediaInfo.fileName = element.fileName;
        forwardMediaInfo.videoMd5 = element.videoMd5;
        forwardMediaInfo.thumbMd5 = element.thumbMd5;
        forwardMediaInfo.fileTime = element.fileTime;
        forwardMediaInfo.thumbSize = element.thumbSize;
        forwardMediaInfo.fileFormat = element.fileFormat;
        forwardMediaInfo.fileSize = element.fileSize;
        forwardMediaInfo.thumbWidth = element.thumbWidth;
        forwardMediaInfo.thumbHeight = element.thumbHeight;
        forwardMediaInfo.fileUuid = element.fileUuid;
        forwardMediaInfo.fileSubId = element.fileSubId;
        forwardMediaInfo.fileBizId = element.fileBizId;
        forwardMediaInfo.originVideoMd5 = element.originVideoMd5;
        forwardMediaInfo.storeID = element.storeID;
        Integer num = element.invalidState;
        Intrinsics.checkNotNullExpressionValue(num, "element.invalidState");
        forwardMediaInfo.invalidState = num.intValue();
        QLog.d("ForwardGroupAlbumDataConvertor", 1, "picToMediaInfo mediaInfo:" + forwardMediaInfo);
        return forwardMediaInfo;
    }

    public final String d(Map<Integer, String> thumbPath) {
        int i3 = 0;
        if (thumbPath == null || thumbPath.isEmpty()) {
            return null;
        }
        Iterator<Integer> it = thumbPath.keySet().iterator();
        while (it.hasNext()) {
            i3 = Math.max(i3, it.next().intValue());
        }
        a(thumbPath.get(Integer.valueOf(i3)));
        return thumbPath.get(Integer.valueOf(i3));
    }

    private final String e(PicElement picElement) {
        if (picElement == null) {
            return null;
        }
        String a16 = aj.a(picElement);
        if (a(a16)) {
            return a16;
        }
        String b16 = aj.b(picElement, 0);
        if (a(b16)) {
            return b16;
        }
        String b17 = aj.b(picElement, 720);
        if (a(b17)) {
            return b17;
        }
        String b18 = aj.b(picElement, 198);
        if (a(b18)) {
            return b18;
        }
        return null;
    }
}
