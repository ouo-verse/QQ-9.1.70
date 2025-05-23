package gf;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class t implements QZoneSinglePicWidgetView.b {
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
    public void a(BusinessFeedData businessFeedData, View view) {
        CellAlbumEntrance cellAlbumEntrance;
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        String str = pictureInfo != null ? pictureInfo.actionurl : null;
        if (TextUtils.isEmpty(str) && (cellAlbumEntrance = businessFeedData.cellAlbumEntrance) != null) {
            str = cellAlbumEntrance.guideUrl;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        yo.d.d(str, view.getContext(), null);
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
    public String b(BusinessFeedData businessFeedData) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        if (businessFeedData == null || (pictureInfo = businessFeedData.getPictureInfo()) == null || (arrayList = pictureInfo.pics) == null || arrayList.size() == 0 || pictureInfo.pics.get(0) == null || pictureInfo.pics.get(0).currentUrl == null) {
            return "";
        }
        return pictureInfo.pics.get(0).currentUrl.url;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
    public boolean c() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
    public FrameLayout.LayoutParams d(Context context, BusinessFeedData businessFeedData, FrameLayout.LayoutParams layoutParams) {
        ArrayList<PictureItem> arrayList;
        if (businessFeedData != null && layoutParams != null) {
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            if (pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.size() <= 0 || pictureInfo.pics.get(0) == null || pictureInfo.pics.get(0).currentUrl == null) {
                return null;
            }
            com.qzone.reborn.feedx.widget.picmixvideo.b.a(context, businessFeedData, layoutParams, pictureInfo.pics.get(0).currentUrl, pl.a.f426446a.l(context));
            return layoutParams;
        }
        QLog.e("QZoneAppShareSinglePicIoc", 1, "getLayoutParams error, feedData: " + businessFeedData + ", params: " + layoutParams);
        return null;
    }
}
