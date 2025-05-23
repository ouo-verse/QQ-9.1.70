package com.tencent.aelight.camera.ae.album.adapter;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends AEAlbumListAdapter {
    public boolean L;
    public long M;
    boolean N;

    public a(com.tencent.aelight.camera.ae.album.fragment.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter
    protected void a(QQAlbumInfo qQAlbumInfo) {
        if (!this.f62009m.isEmpty()) {
            QQAlbumInfo qQAlbumInfo2 = this.f62009m.get(0);
            if (!qQAlbumInfo2.f203112id.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
                if (qQAlbumInfo2.f203112id.equals("qzone_album")) {
                    this.f62009m.add(1, qQAlbumInfo);
                } else {
                    this.f62009m.add(0, qQAlbumInfo);
                }
            }
        }
        if (this.L && this.M > 0 && q()) {
            QQAlbumInfo qQAlbumInfo3 = new QQAlbumInfo();
            qQAlbumInfo3.f203112id = "qzone_album";
            qQAlbumInfo3.name = "\u7a7a\u95f4\u76f8\u518c";
            qQAlbumInfo3.mMediaFileCount = (int) this.M;
            this.f62009m.add(0, qQAlbumInfo3);
            if (QLog.isColorLevel()) {
                QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
            }
        }
        if (this.N) {
            QQAlbumInfo qQAlbumInfo4 = new QQAlbumInfo();
            qQAlbumInfo4.f203112id = "$CustomAlbumId";
            List<LocalMediaInfo> k3 = SlideShowPhotoListManager.n().k();
            if (k3.size() > 0) {
                qQAlbumInfo4.name = k3.get(0).mAlbumName;
                qQAlbumInfo4.mCoverInfo = k3.get(0);
            }
            qQAlbumInfo4.mMediaFileCount = k3.size();
            this.f62009m.add(0, qQAlbumInfo4);
        }
    }

    boolean q() {
        if (this.f62009m.size() == 0) {
            return true;
        }
        for (int i3 = 0; i3 < this.f62009m.size(); i3++) {
            if (this.f62009m.get(i3).f203112id.equals("qzone_album")) {
                return false;
            }
        }
        return true;
    }
}
