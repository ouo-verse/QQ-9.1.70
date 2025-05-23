package le;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.adapter.feedcomponent.q;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.reborn.albumx.qzonex.utils.c;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ \u0010\u0010\u001a\u00020\u000f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0013\u00a8\u0006\u0017"}, d2 = {"Lle/a;", "", "", "videoPath", "b", "path", "Landroid/graphics/BitmapFactory$Options;", "a", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaList", "", "c", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "e", "Lcooperation/qzone/model/BusinessAlbumInfo;", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414396a = new a();

    a() {
    }

    private final BitmapFactory.Options a(String path) {
        if (URLUtil.isNetworkUrl(path)) {
            return null;
        }
        return q.b().h(path);
    }

    private final String b(String videoPath) {
        if (RFWFileUtils.fileExists(videoPath)) {
            return videoPath;
        }
        String c16 = FakeShuoShuoDataCacheHelper.c(videoPath);
        return RFWFileUtils.fileExists(c16) ? c16 : videoPath;
    }

    public final void c(List<? extends MediaWrapper> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        ArrayList arrayList = new ArrayList();
        for (MediaWrapper mediaWrapper : mediaList) {
            if (mediaWrapper.isImage()) {
                arrayList.add(mediaWrapper.getImageInfo().mPath);
            } else {
                arrayList.add(mediaWrapper.getVideoInfo().mVideoPath);
            }
        }
        if (arrayList.size() > 0) {
            QZoneUploadRecommendDirector.INSTANCE.a().E(arrayList);
        }
    }

    public final CommonCellMedia d(List<? extends MediaWrapper> mediaList, CommonAlbumInfo albumInfo) {
        CommonCellMedia commonCellMedia = new CommonCellMedia();
        commonCellMedia.setAlbumId(albumInfo != null ? albumInfo.getAlbumId() : null);
        commonCellMedia.setAlbumName(albumInfo != null ? albumInfo.getName() : null);
        List<? extends MediaWrapper> list = mediaList;
        if (list == null || list.isEmpty()) {
            return commonCellMedia;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaWrapper mediaWrapper : mediaList) {
            CommonMedia commonMedia = new CommonMedia();
            if (mediaWrapper.isImage()) {
                commonMedia.setType(0);
                commonMedia.setImage(f414396a.e(mediaWrapper.getImageInfo().mPath));
            } else {
                commonMedia.setType(1);
                CommonVideo commonVideo = new CommonVideo();
                ShuoshuoVideoInfo videoInfo = mediaWrapper.getVideoInfo();
                if (videoInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(videoInfo, "mediaWrapper.videoInfo ?: return@apply");
                    a aVar = f414396a;
                    commonVideo.setCover(aVar.e(mediaWrapper.getVideoInfo().mCoverUrl));
                    commonVideo.setUrl(aVar.b(mediaWrapper.getVideoInfo().mVideoPath));
                    commonVideo.setWidth(mediaWrapper.getVideoInfo().mVideoWidth);
                    commonVideo.setHeight(mediaWrapper.getVideoInfo().mVideoHeight);
                    commonVideo.setVideoTime(mediaWrapper.getVideoInfo().mDuration);
                }
                commonMedia.setVideo(commonVideo);
            }
            arrayList.add(commonMedia);
        }
        commonCellMedia.setMediaItems(arrayList);
        return commonCellMedia;
    }

    public final CommonImage e(String path) {
        List<CommonPicSpecUrlEntry> mutableListOf;
        boolean equals;
        CommonImage commonImage = new CommonImage();
        if (TextUtils.isEmpty(path)) {
            return commonImage;
        }
        BitmapFactory.Options a16 = a(path);
        CommonPicUrl commonPicUrl = new CommonPicUrl();
        commonPicUrl.setUrl(path);
        commonPicUrl.setWidth(a16 != null ? a16.outWidth : 0);
        commonPicUrl.setHeight(a16 != null ? a16.outHeight : 0);
        CommonPicSpecUrlEntry commonPicSpecUrlEntry = new CommonPicSpecUrlEntry();
        commonPicSpecUrlEntry.setSpec(5);
        commonPicSpecUrlEntry.setUrl(commonPicUrl);
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(commonPicSpecUrlEntry);
        commonImage.setPhotoUrl(mutableListOf);
        commonImage.setDefaultUrl(commonPicUrl);
        equals = StringsKt__StringsJVMKt.equals("image/gif", a16 != null ? a16.outMimeType : null, true);
        if (equals) {
            commonImage.setGif(true);
        }
        return commonImage;
    }

    public final CommonAlbumInfo f(BusinessAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String id5 = albumInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id5, "albumInfo.id");
        commonAlbumInfo.V(id5);
        String title = albumInfo.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "albumInfo.title");
        commonAlbumInfo.m0(title);
        CommonStUser commonStUser = new CommonStUser();
        commonStUser.g(String.valueOf(albumInfo.mUin));
        commonAlbumInfo.e0(commonStUser);
        commonAlbumInfo.q0(c.f53402a.a(albumInfo.mAnonymity));
        CommonAlbumAccessPermission commonAlbumAccessPermission = new CommonAlbumAccessPermission();
        commonAlbumAccessPermission.g(albumInfo.mPrivacy);
        commonAlbumInfo.p0(commonAlbumAccessPermission);
        return commonAlbumInfo;
    }
}
