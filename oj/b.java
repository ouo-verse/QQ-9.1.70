package oj;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t\u00a8\u0006\u0011"}, d2 = {"Loj/b;", "", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapperList", "Lqzone/QZoneBaseMeta$StMedia;", "a", "", "url", "", "photoWidth", "photoHeight", "spec", "Lqzone/QZoneBaseMeta$StPicSpecUrlEntry;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f423009a = new b();

    b() {
    }

    public final List<QZoneBaseMeta$StMedia> a(List<? extends MediaWrapper> mediaWrapperList) {
        QZoneBaseMeta$StMedia a16;
        ArrayList arrayList = new ArrayList();
        if (mediaWrapperList == null) {
            return arrayList;
        }
        int size = mediaWrapperList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MediaWrapper mediaWrapper = mediaWrapperList.get(i3);
            if (mediaWrapper.isImage()) {
                ImageInfo imageInfo = mediaWrapper.getImageInfo();
                a16 = imageInfo != null ? c.b(imageInfo) : null;
                if (a16 != null) {
                    arrayList.add(a16);
                } else {
                    RFWLog.e("QZoneMediaInfoFactory", RFWLog.USR, "imageInfo.convertToStMedia error,stMediaInfo is null");
                }
            } else {
                ShuoshuoVideoInfo videoInfo = mediaWrapper.getVideoInfo();
                a16 = videoInfo != null ? c.a(videoInfo) : null;
                if (a16 != null) {
                    arrayList.add(a16);
                } else {
                    RFWLog.e("QZoneMediaInfoFactory", RFWLog.USR, "videoInfo.convertToStMedia error,stMediaInfo is null");
                }
            }
        }
        return arrayList;
    }

    public final QZoneBaseMeta$StPicSpecUrlEntry b(String url, int photoWidth, int photoHeight, int spec) {
        Intrinsics.checkNotNullParameter(url, "url");
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
        qZoneBaseMeta$StPicUrl.url.set(url);
        qZoneBaseMeta$StPicUrl.width.set(photoWidth);
        qZoneBaseMeta$StPicUrl.height.set(photoHeight);
        QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
        qZoneBaseMeta$StPicSpecUrlEntry.url.set(qZoneBaseMeta$StPicUrl);
        qZoneBaseMeta$StPicSpecUrlEntry.spec.set(spec);
        return qZoneBaseMeta$StPicSpecUrlEntry;
    }

    public static /* synthetic */ QZoneBaseMeta$StPicSpecUrlEntry c(b bVar, String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 8) != 0) {
            i17 = 5;
        }
        return bVar.b(str, i3, i16, i17);
    }
}
