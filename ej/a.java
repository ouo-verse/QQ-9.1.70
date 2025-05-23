package ej;

import android.view.View;
import com.qzone.common.business.service.media.c;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadYellowDiamondShowEvent;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import cooperation.qzone.media.QZoneMediaBusiness;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends tl.a {
    @Override // tl.a
    public int c() {
        return 100;
    }

    @Override // tl.a
    public QZoneMediaBusiness d() {
        return QZoneMediaBusiness.QZONE_GROUP_UPLOAD_ALBUM;
    }

    @Override // tl.a
    public boolean i() {
        return true;
    }

    @Override // tl.a
    public void l(c cVar, DynamicGridView dynamicGridView) {
        RFWLog.d("GroupUploadSelectPhotoParams", RFWLog.USR, "reportSelectPhotoClk");
        fo.c.b("dt_clck", dynamicGridView, "em_qz_upload_pictures_videos", null);
    }

    @Override // tl.a
    public void b(View view, e9.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new CommonAlbumUploadYellowDiamondShowEvent(aVar.getCount() <= 9));
    }

    @Override // tl.a
    public void j(int i3) {
    }

    @Override // tl.a
    public void k(int i3) {
    }
}
