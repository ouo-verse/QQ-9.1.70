package db;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadYellowDiamondShowEvent;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import cooperation.qzone.media.QZoneMediaBusiness;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends tl.a {

    /* renamed from: a, reason: collision with root package name */
    private QZAlbumxUploadAlbumInitBean f393484a;

    public d(QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean) {
        this.f393484a = qZAlbumxUploadAlbumInitBean;
    }

    @Override // tl.a
    public int c() {
        return 1000;
    }

    @Override // tl.a
    public QZoneMediaBusiness d() {
        return QZoneMediaBusiness.QZONE_ALBUMX_UPLOAD_ALBUM;
    }

    @Override // tl.a
    public boolean f() {
        return !this.f393484a.getIsHideAddBtn();
    }

    @Override // tl.a
    public boolean g() {
        return this.f393484a.getFromType() == 7;
    }

    @Override // tl.a
    public boolean i() {
        return true;
    }

    @Override // tl.a
    public void l(com.qzone.common.business.service.media.c cVar, DynamicGridView dynamicGridView) {
        RFWLog.d("QZAlbumxUploadSelectPhotoParams", RFWLog.USR, "reportSelectPhotoClk");
        fo.c.b("dt_clck", dynamicGridView, "em_qz_upload_pictures_videos", null);
    }

    @Override // tl.a
    public int n() {
        if (this.f393484a.getFromType() == 10) {
            return 2;
        }
        return super.n();
    }

    @Override // tl.a
    public void b(View view, e9.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        pl.a aVar2 = pl.a.f426446a;
        SimpleEventBus.getInstance().dispatchEvent(new CommonAlbumUploadYellowDiamondShowEvent(aVar.getCount() <= ((!aVar2.y() || !aVar2.z(view.getContext())) ? 6 : 1)));
    }

    @Override // tl.a
    public void j(int i3) {
    }

    @Override // tl.a
    public void k(int i3) {
    }
}
