package com.tencent.mobileqq.wink.picker.qzone;

import NS_MOBILE_OPERATION.PicInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/mobileqq/wink/picker/MediaInfo;", "b", "LNS_MOBILE_OPERATION/PicInfo;", "a", "picInfo", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "c", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f325177a = new a();

    a() {
    }

    @NotNull
    public final PicInfo a(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        PicInfo picInfo = new PicInfo();
        picInfo.albumid = e93.i.h(localMediaInfo);
        picInfo.pictureid = e93.i.v(localMediaInfo);
        picInfo.sloc = e93.i.u(localMediaInfo);
        picInfo.pic_url = e93.i.j(localMediaInfo);
        picInfo.picwidth = localMediaInfo.mediaWidth;
        picInfo.picheight = localMediaInfo.mediaHeight;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("WINK_MEDIA_PICKER_SELECT_MEDIA_WIDTH", String.valueOf(localMediaInfo.mediaWidth));
        linkedHashMap.put("WINK_MEDIA_PICKER_SELECT_MEDIA_HEIGHT", String.valueOf(localMediaInfo.mediaHeight));
        linkedHashMap.put("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_URL", e93.i.w(localMediaInfo));
        linkedHashMap.put("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_WIDTH", String.valueOf(localMediaInfo.thumbWidth));
        linkedHashMap.put("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_HEIGHT", String.valueOf(localMediaInfo.thumbWidth));
        picInfo.pic_extend = linkedHashMap;
        return picInfo;
    }

    @NotNull
    public final MediaInfo b(@NotNull LocalMediaInfo localMediaInfo) {
        MediaType mediaType;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        PicInfo a16 = a(localMediaInfo);
        if (e93.i.I(localMediaInfo)) {
            mediaType = MediaType.QZONE_VIDEO;
        } else {
            mediaType = MediaType.QZONE_IMAGE;
        }
        return c(a16, mediaType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MediaInfo c(@NotNull PicInfo picInfo, @NotNull MediaType mediaType) {
        int i3;
        int i16;
        String str;
        int i17;
        int i18;
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Intrinsics.checkNotNullParameter(picInfo, "picInfo");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        String albumid = picInfo.albumid;
        String pictureid = picInfo.pictureid;
        Map<String, String> map = picInfo.pic_extend;
        if (map != null && (r1 = map.get("WINK_MEDIA_PICKER_SELECT_MEDIA_WIDTH")) != null && intOrNull4 != null) {
            i3 = intOrNull4.intValue();
        } else {
            i3 = 0;
        }
        Map<String, String> map2 = picInfo.pic_extend;
        if (map2 != null && (r1 = map2.get("WINK_MEDIA_PICKER_SELECT_MEDIA_HEIGHT")) != null && intOrNull3 != null) {
            i16 = intOrNull3.intValue();
        } else {
            i16 = 0;
        }
        Map<String, String> map3 = picInfo.pic_extend;
        if (map3 == null || (str = map3.get("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_URL")) == null) {
            str = "";
        }
        String str2 = str;
        Map<String, String> map4 = picInfo.pic_extend;
        if (map4 != null && (r1 = map4.get("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_WIDTH")) != null && intOrNull2 != null) {
            i17 = intOrNull2.intValue();
        } else {
            i17 = 0;
        }
        Map<String, String> map5 = picInfo.pic_extend;
        if (map5 != null && (r1 = map5.get("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_HEIGHT")) != null && intOrNull != null) {
            i18 = intOrNull.intValue();
        } else {
            i18 = 0;
        }
        String sloc = picInfo.sloc;
        String pic_url = picInfo.pic_url;
        Intrinsics.checkNotNullExpressionValue(albumid, "albumid");
        Intrinsics.checkNotNullExpressionValue(pictureid, "pictureid");
        Intrinsics.checkNotNullExpressionValue(pic_url, "pic_url");
        Intrinsics.checkNotNullExpressionValue(sloc, "sloc");
        return new MediaInfo(mediaType, albumid, i3, i16, null, pictureid, str2, i17, i18, pic_url, sloc, 0L, 2064, null);
    }
}
