package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.event.QZoneAlbumCategoryDeletePhotoEvent;
import com.qzone.preview.event.QZoneLayerDeletePhotoEvent;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h extends QZoneBaseShareAction {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f58184d;

        b(f fVar) {
            this.f58184d = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            h.this.H(this.f58184d);
        }
    }

    public h(Activity activity) {
        super(activity);
    }

    private QZoneDeletePhotoBean F(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder) {
        QZoneDeletePhotoBean qZoneDeletePhotoBean = new QZoneDeletePhotoBean();
        return qZoneInteractPhotoRequestBuilder == null ? qZoneDeletePhotoBean : qZoneDeletePhotoBean.setAlbumId(qZoneInteractPhotoRequestBuilder.albumId).setPhotoIdList(qZoneInteractPhotoRequestBuilder.photoIdList).setVideoIdList(qZoneInteractPhotoRequestBuilder.videoIdList);
    }

    public void E(f fVar) {
        PhotoInfo photoInfo = fVar.f58179c;
        if (photoInfo == null) {
            return;
        }
        if (G(fVar)) {
            VideoInfo videoInfo = photoInfo.videodata;
            if (videoInfo != null && !TextUtils.isEmpty(videoInfo.videoId)) {
                ArrayList<String> arrayList = new ArrayList<>(1);
                arrayList.add(photoInfo.videodata.videoId);
                QZLog.i("QZoneShareDeleteAction", 2, "delete shuoshuo video ", photoInfo.videodata.videoId);
                QZoneFeedxPictureManager.getInstance().deletePhoto(new QZoneInteractPhotoRequestBuilder().setAppId(311).setVideoIdList(arrayList), r());
                return;
            }
            QZLog.e("QZoneShareDeleteAction", 2, "delete shuoshuo video fail with empty vid");
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>(1);
        ArrayList<String> arrayList3 = new ArrayList<>(1);
        arrayList2.add(photoInfo.lloc);
        VideoInfo videoInfo2 = photoInfo.videodata;
        if (videoInfo2 != null && !TextUtils.isEmpty(videoInfo2.videoId)) {
            arrayList3.add(photoInfo.videodata.videoId);
        }
        QZLog.i("QZoneShareDeleteAction", 2, "delete album video ", photoInfo.lloc);
        QZoneFeedxPictureManager.getInstance().deletePhoto(new QZoneInteractPhotoRequestBuilder().setAlbumId(fVar.f58180d.albumid).setPhotoIdList(arrayList2).setVideoIdList(arrayList3), r());
    }

    protected void H(f fVar) {
        if (!PictureManager.getInstance().checkNetworkConnect()) {
            ToastUtil.n(R.string.gdc);
        } else {
            B("");
            E(fVar);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        String string;
        String string2 = n().getResources().getString(R.string.gdq);
        if (com.qzone.util.z.b(fVar.f58179c)) {
            string2 = n().getResources().getString(R.string.gdr);
            string = "";
        } else if (LoginData.getInstance().isQzoneVip()) {
            string = n().getResources().getString(R.string.gf5);
        } else {
            string = n().getResources().getString(R.string.f173008gf4);
        }
        DialogUtil.createCustomDialog(n(), 230).setTitle(string2).setMessage(string).setPositiveButton(com.qzone.util.l.a(R.string.f172558s42), new b(fVar)).setNegativeButton(com.qzone.util.l.a(R.string.j6l), new a()).show();
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "5", true);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && message.what == 999909) {
            i();
            if (unpack.getSucceed() && (unpack.getData() instanceof QZoneInteractPhotoRequestBuilder)) {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneLayerDeletePhotoEvent((QZoneInteractPhotoRequestBuilder) unpack.getData()));
                SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumCategoryDeletePhotoEvent(F((QZoneInteractPhotoRequestBuilder) unpack.getData())), true);
                QLog.d("QZoneShareDeleteAction", 1, "dispatch QZoneAlbumCategoryDeletePhotoEvent");
                ToastUtil.s("\u5220\u9664\u6210\u529f\uff0c\u8bf7\u5237\u65b0\u67e5\u770b", 2);
                return;
            }
            ToastUtil.s(unpack.getMessage(), 4);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{40};
    }

    protected boolean G(f fVar) {
        PhotoParam photoParam;
        if (fVar == null || (photoParam = fVar.f58180d) == null) {
            return false;
        }
        return com.qzone.preview.d.g(photoParam);
    }
}
