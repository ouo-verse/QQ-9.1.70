package dk;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends ck.b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ck.b
    public String c() {
        return "QZoneIntimateUploadPhotoPageParser";
    }

    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo;
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("spaceid");
        if (TextUtils.isEmpty(str)) {
            RFWLog.e(c(), RFWLog.USR, "[parseScheme] spaceid is empty");
            return;
        }
        String str2 = qZoneSchemeBean.getAttrs().get("albumid");
        String str3 = qZoneSchemeBean.getAttrs().get("albumname");
        int d16 = d(qZoneSchemeBean);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            qZoneBaseAlbumMeta$AlbumInfo = null;
        } else {
            qZoneBaseAlbumMeta$AlbumInfo = new QZoneBaseAlbumMeta$AlbumInfo();
            qZoneBaseAlbumMeta$AlbumInfo.album_id.set(str2);
            qZoneBaseAlbumMeta$AlbumInfo.name.set(str3);
        }
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = new QZoneIntimateUploadAlbumInitBean(str, d16, true, qZoneBaseAlbumMeta$AlbumInfo);
        qZoneIntimateUploadAlbumInitBean.setInsertSpacePage(b(qZoneSchemeBean));
        qZoneIntimateUploadAlbumInitBean.setAdId(a(qZoneSchemeBean));
        ho.i.o().y(context, qZoneIntimateUploadAlbumInitBean);
    }
}
