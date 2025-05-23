package mb1;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001c\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017\u00a8\u0006\u001e"}, d2 = {"Lmb1/a;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "g", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;", "layerVideoInfo", "", "j", "mediaId", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemMediaInfoList", "i", "", h.F, "Lcom/tencent/mobileqq/filemanager/data/FileInfo;", "fileInfo", "c", "a", "e", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "fileManagerEntity", "d", "b", "f", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f416517a = new a();

    a() {
    }

    @NotNull
    public final RFWLayerItemMediaInfo a(@NotNull FileInfo fileInfo) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(String.valueOf(fileInfo.g()));
        if (!TextUtils.isEmpty(fileInfo.k())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(fileInfo.k());
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setBigPicInfo(rFWLayerPicInfo.getSmallPicInfo());
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
            Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
        }
        rFWLayerItemMediaInfo.setMediaId(String.valueOf(fileInfo.g()));
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        return rFWLayerItemMediaInfo;
    }

    @NotNull
    public final RFWLayerItemMediaInfo b(@NotNull FileManagerEntity fileManagerEntity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fileManagerEntity, "fileManagerEntity");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(String.valueOf(fileManagerEntity.nSessionId));
        if (!TextUtils.isEmpty(fileManagerEntity.strMiddleThumPath)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(fileManagerEntity.strMiddleThumPath);
            rFWPicInfo.setUrl(fileManagerEntity.strMiddleThumPath);
            rFWPicInfo.setSize(fileManagerEntity.fileSize);
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
            Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
        }
        if (!TextUtils.isEmpty(fileManagerEntity.strLargeThumPath)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo2.setLocalPath(fileManagerEntity.strLargeThumPath);
            rFWPicInfo2.setUrl(fileManagerEntity.strLargeThumPath);
            rFWPicInfo2.setSize(fileManagerEntity.fileSize);
            rFWLayerPicInfo.setBigPicInfo(rFWPicInfo2);
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = rFWLayerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(bigPicInfo);
        }
        if (!TextUtils.isEmpty(fileManagerEntity.getFilePath())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo3.setLocalPath(fileManagerEntity.getFilePath());
            rFWPicInfo3.setUrl(fileManagerEntity.getFilePath());
            rFWPicInfo3.setSize(fileManagerEntity.fileSize);
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo3);
            RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
            Intrinsics.checkNotNull(originPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(originPicInfo);
        } else {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo4 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo4.setLocalPath(AIOBrowserBaseData.MEDIA_FILE_NONE);
            rFWPicInfo4.setUrl(rFWPicInfo4.getLocalPath());
            rFWPicInfo4.setSize(fileManagerEntity.fileSize);
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo4);
        }
        rFWLayerItemMediaInfo.setMediaId(String.valueOf(fileManagerEntity.nSessionId));
        if (fileManagerEntity.status == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        rFWLayerItemMediaInfo.setInvalid(z16);
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        return rFWLayerItemMediaInfo;
    }

    @Nullable
    public final RFWLayerItemMediaInfo c(@NotNull FileInfo fileInfo) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        int type = fileInfo.getType();
        if (type != 0) {
            if (type != 2) {
                return null;
            }
            return e(fileInfo);
        }
        return a(fileInfo);
    }

    @Nullable
    public final RFWLayerItemMediaInfo d(@NotNull FileManagerEntity fileManagerEntity) {
        Intrinsics.checkNotNullParameter(fileManagerEntity, "fileManagerEntity");
        int i3 = fileManagerEntity.nFileType;
        if (i3 != 0) {
            if (i3 != 2) {
                return null;
            }
            return f(fileManagerEntity);
        }
        return b(fileManagerEntity);
    }

    @NotNull
    public final RFWLayerItemMediaInfo e(@NotNull FileInfo fileInfo) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(String.valueOf(fileInfo.g()));
        rFWLayerVideoInfo.setVideoOriginUrl(fileInfo.k());
        String videoOriginUrl = rFWLayerVideoInfo.getVideoOriginUrl();
        if (videoOriginUrl == null) {
            videoOriginUrl = "";
        }
        rFWLayerVideoInfo.setCurrentVideoUrl(videoOriginUrl);
        rFWLayerVideoInfo.setLocalPath(fileInfo.k());
        rFWLayerItemMediaInfo.setMediaId(String.valueOf(fileInfo.g()));
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        return rFWLayerItemMediaInfo;
    }

    @NotNull
    public final RFWLayerItemMediaInfo f(@NotNull FileManagerEntity fileManagerEntity) {
        Intrinsics.checkNotNullParameter(fileManagerEntity, "fileManagerEntity");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(String.valueOf(fileManagerEntity.nSessionId));
        rFWLayerVideoInfo.setVideoOriginUrl(fileManagerEntity.getFilePath());
        String videoOriginUrl = rFWLayerVideoInfo.getVideoOriginUrl();
        String str = "";
        if (videoOriginUrl == null) {
            videoOriginUrl = "";
        }
        rFWLayerVideoInfo.setCurrentVideoUrl(videoOriginUrl);
        rFWLayerVideoInfo.setLocalPath(fileManagerEntity.getFilePath());
        rFWLayerVideoInfo.setVideoHeight(fileManagerEntity.imgHeight);
        rFWLayerVideoInfo.setVideoWidth(fileManagerEntity.imgWidth);
        rFWLayerItemMediaInfo.setMediaId(String.valueOf(fileManagerEntity.nSessionId));
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        String str2 = fileManagerEntity.strLargeThumPath;
        if (str2 == null && (str2 = fileManagerEntity.strMiddleThumPath) == null) {
            String str3 = fileManagerEntity.strThumbPath;
            if (str3 != null) {
                str = str3;
            }
        } else {
            str = str2;
        }
        rFWPicInfo.setLocalPath(str);
        rFWPicInfo.setUrl(rFWPicInfo.getLocalPath());
        rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        return rFWLayerItemMediaInfo;
    }

    public final boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("forward_rich_media_view", false);
    }

    public final int h(@NotNull String mediaId, @NotNull List<? extends RFWLayerItemMediaInfo> itemMediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(itemMediaInfoList, "itemMediaInfoList");
        int size = itemMediaInfoList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(mediaId, itemMediaInfoList.get(i3).getMediaId())) {
                return i3;
            }
        }
        return 0;
    }

    @Nullable
    public final RFWLayerItemMediaInfo i(@NotNull String mediaId, @NotNull List<? extends RFWLayerItemMediaInfo> itemMediaInfoList) {
        Object obj;
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(itemMediaInfoList, "itemMediaInfoList");
        Iterator<T> it = itemMediaInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((RFWLayerItemMediaInfo) obj).getMediaId(), mediaId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (RFWLayerItemMediaInfo) obj;
    }

    @NotNull
    public final String j(@NotNull RFWLayerVideoInfo layerVideoInfo) {
        Intrinsics.checkNotNullParameter(layerVideoInfo, "layerVideoInfo");
        if (FileUtils.fileExistsAndNotEmpty(layerVideoInfo.getCurrentVideoUrl())) {
            return layerVideoInfo.getCurrentVideoUrl();
        }
        if (FileUtils.fileExistsAndNotEmpty(layerVideoInfo.getLocalPath())) {
            String localPath = layerVideoInfo.getLocalPath();
            Intrinsics.checkNotNull(localPath);
            return localPath;
        }
        return "";
    }

    public final boolean k() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("file_search_rich_media_switch", false);
    }

    public final boolean l() {
        return g();
    }

    public final boolean m() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("rich_media_for_file_switch", false);
    }
}
