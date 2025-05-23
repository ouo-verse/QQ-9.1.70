package fj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0005\u001a\f\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\b\u001a\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005\u001a&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a.\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0017j\b\u0012\u0004\u0012\u00020\u001a`\u0019*\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u0019\u00a8\u0006\u001c"}, d2 = {"Landroid/content/Intent;", "", "e", "Landroid/content/Context;", "d", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "g", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", tl.h.F, "pictureItem", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "b", "", "spec", "url", "width", "height", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "c", "Ljava/util/ArrayList;", "Lcom/qzone/album/data/model/AlbumCacheData;", "Lkotlin/collections/ArrayList;", "Lcooperation/qzone/model/BusinessAlbumInfo;", "f", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {
    public static final CommonStPicSpecUrlEntry a(int i3, String url, int i16, int i17) {
        Intrinsics.checkNotNullParameter(url, "url");
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        commonStPicSpecUrlEntry.c(i3);
        if (TextUtils.isEmpty(url)) {
            return commonStPicSpecUrlEntry;
        }
        commonStPicSpecUrlEntry.e(c(url, i16, i17));
        return commonStPicSpecUrlEntry;
    }

    public static final CommonStImage b(PictureItem pictureItem) {
        String str;
        Intrinsics.checkNotNullParameter(pictureItem, "pictureItem");
        CommonStImage commonStImage = new CommonStImage();
        String str2 = pictureItem.picname;
        Intrinsics.checkNotNullExpressionValue(str2, "pictureItem.picname");
        commonStImage.m(str2);
        String str3 = pictureItem.lloc;
        Intrinsics.checkNotNullExpressionValue(str3, "pictureItem.lloc");
        commonStImage.l(str3);
        String str4 = pictureItem.sloc;
        Intrinsics.checkNotNullExpressionValue(str4, "pictureItem.sloc");
        commonStImage.o(str4);
        List<CommonStPicSpecUrlEntry> e16 = commonStImage.e();
        int ordinal = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
        PictureUrl pictureUrl = pictureItem.originUrl;
        String str5 = pictureUrl.url;
        if (str5 == null) {
            str5 = "";
        }
        e16.add(a(ordinal, str5, pictureUrl.width, pictureUrl.height));
        List<CommonStPicSpecUrlEntry> e17 = commonStImage.e();
        int ordinal2 = CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal();
        PictureUrl pictureUrl2 = pictureItem.bigUrl;
        String str6 = pictureUrl2.url;
        if (str6 == null) {
            str6 = "";
        }
        e17.add(a(ordinal2, str6, pictureUrl2.width, pictureUrl2.height));
        List<CommonStPicSpecUrlEntry> e18 = commonStImage.e();
        int ordinal3 = CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal();
        PictureUrl pictureUrl3 = pictureItem.currentUrl;
        String str7 = pictureUrl3.url;
        if (str7 == null) {
            str7 = "";
        }
        e18.add(a(ordinal3, str7, pictureUrl3.width, pictureUrl3.height));
        List<CommonStPicSpecUrlEntry> e19 = commonStImage.e();
        int ordinal4 = CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal();
        PictureUrl pictureUrl4 = pictureItem.downloadUrl;
        String str8 = pictureUrl4.url;
        if (str8 == null) {
            str8 = "";
        }
        e19.add(a(ordinal4, str8, pictureUrl4.width, pictureUrl4.height));
        if (TextUtils.isEmpty(pictureItem.currentUrl.url)) {
            str = pictureItem.originUrl.url;
        } else {
            str = pictureItem.currentUrl.url;
        }
        String str9 = str != null ? str : "";
        PictureUrl pictureUrl5 = pictureItem.currentUrl;
        commonStImage.j(c(str9, pictureUrl5.width, pictureUrl5.height));
        return commonStImage;
    }

    public static final CommonStPicUrl c(String url, int i3, int i16) {
        Intrinsics.checkNotNullParameter(url, "url");
        CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
        commonStPicUrl.c(url);
        commonStPicUrl.e(i3);
        commonStPicUrl.b(i16);
        return commonStPicUrl;
    }

    public static final String d(Context context) {
        Intent intent;
        String e16;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        return (activity == null || (intent = activity.getIntent()) == null || (e16 = e(intent)) == null) ? "" : e16;
    }

    public static final String e(Intent intent) {
        String groupId;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return "";
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        GroupAlbumInitBean groupAlbumInitBean = serializable instanceof GroupAlbumInitBean ? (GroupAlbumInitBean) serializable : null;
        if (groupAlbumInitBean == null) {
            Object parcelable = extras.getParcelable("key_bundle_common_init_bean");
            groupAlbumInitBean = parcelable instanceof GroupAlbumInitBean ? (GroupAlbumInitBean) parcelable : null;
        }
        return (groupAlbumInitBean == null || (groupId = groupAlbumInitBean.getGroupId()) == null) ? "" : groupId;
    }

    public static final ArrayList<BusinessAlbumInfo> f(ArrayList<AlbumCacheData> arrayList) {
        BusinessAlbumInfo createFrom;
        int i3;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        ArrayList<BusinessAlbumInfo> arrayList2 = new ArrayList<>();
        Iterator<AlbumCacheData> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (next != null && (i3 = (createFrom = BusinessAlbumInfo.createFrom(next.albumid, next.albumtype, next.albumname, next.getLloc(), next.albumrights, next.albumnum, next.anonymity, next.individual, next.operatemask, next.allow_share, next.isSharingAlbumOnServer(), com.qzone.album.util.b.a(next), next.isSharingOwner)).mAlbumType) != 21 && i3 != 102 && i3 != 10 && i3 != 101 && (!createFrom.isShareAlbum() || createFrom.isSharingOwner != 0)) {
                arrayList2.add(createFrom);
            }
        }
        return arrayList2;
    }

    public static final CommonStVideo h(VideoInfo videoInfo) {
        CommonStVideo commonStVideo = new CommonStVideo();
        if (videoInfo == null) {
            return commonStVideo;
        }
        String videoId = videoInfo.videoId;
        Intrinsics.checkNotNullExpressionValue(videoId, "videoId");
        commonStVideo.j(videoId);
        commonStVideo.m(videoInfo.width);
        commonStVideo.g(videoInfo.height);
        commonStVideo.l(videoInfo.videoTime);
        VideoUrl videoUrl = videoInfo.videoUrl;
        String str = videoUrl != null ? videoUrl.url : null;
        if (str == null) {
            str = "";
        }
        commonStVideo.k(str);
        CommonStImage commonStImage = new CommonStImage();
        String lloc = videoInfo.lloc;
        Intrinsics.checkNotNullExpressionValue(lloc, "lloc");
        commonStImage.l(lloc);
        String sloc = videoInfo.sloc;
        Intrinsics.checkNotNullExpressionValue(sloc, "sloc");
        commonStImage.o(sloc);
        CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
        PictureUrl pictureUrl = videoInfo.coverUrl;
        String str2 = pictureUrl != null ? pictureUrl.url : null;
        commonStPicUrl.c(str2 != null ? str2 : "");
        commonStPicUrl.e(videoInfo.width);
        commonStPicUrl.b(videoInfo.height);
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        commonStPicSpecUrlEntry.e(commonStPicUrl);
        commonStImage.j(commonStPicUrl);
        commonStImage.e().add(commonStPicSpecUrlEntry);
        commonStVideo.f(commonStImage);
        return commonStVideo;
    }

    public static final CommonStMedia g(PictureItem pictureItem) {
        if (pictureItem == null) {
            return null;
        }
        CommonStMedia commonStMedia = new CommonStMedia();
        if (pictureItem.isVideo()) {
            commonStMedia.E(CommonEnumMediaType.VIDEO.ordinal());
            commonStMedia.V(h(pictureItem.videodata));
        } else {
            commonStMedia.E(CommonEnumMediaType.IMAGE.ordinal());
            commonStMedia.y(b(pictureItem));
        }
        commonStMedia.x(pictureItem.desc);
        commonStMedia.F(pictureItem.uploadUid);
        commonStMedia.M(pictureItem.uploadTime);
        return commonStMedia;
    }
}
