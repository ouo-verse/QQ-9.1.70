package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.QZoneAlbumMediaRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.ArrayUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oo.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class z extends QZoneBaseShareAction {

    /* renamed from: l, reason: collision with root package name */
    private static int f58218l = -1;

    /* renamed from: j, reason: collision with root package name */
    private long f58219j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f58220k;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f58221a;

        a(f fVar) {
            this.f58221a = fVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            z zVar = z.this;
            zVar.f58112g = 0;
            zVar.J(this.f58221a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            super.onDeniedWithoutShowDlg(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements tk.a {
        b() {
        }

        @Override // tk.a
        public void a() {
            z.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -1) {
                z.this.f58219j = -1L;
                return;
            }
            if (i3 == 1) {
                z.this.i();
                ToastUtil.o(R.string.gkh, 4);
                z.this.f58219j = -1L;
                return;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    z.this.i();
                    if (QZonePermission.requestStoragePermission(z.this.n(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                        ToastUtil.o(R.string.gkk, 4);
                        z.this.f58219j = -1L;
                        return;
                    }
                    return;
                }
                if (i3 != 4) {
                    return;
                }
                Dialog dialog = z.this.f58106a;
                if (dialog == null || !dialog.isShowing()) {
                    z.this.B(com.qzone.util.l.a(R.string.jzm));
                    return;
                }
                return;
            }
            z.this.i();
            String string = z.this.n().getString(R.string.gki);
            Object obj = message.obj;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                RFWSaveUtil.insertMedia(BaseApplication.getContext(), str, new a(string));
                QZLog.d("QZoneShareSaveAction", 1, "savePicture time cost:" + (System.currentTimeMillis() - z.this.f58219j) + ", filePath: " + str);
            }
            z.this.f58219j = -1L;
        }

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a implements Consumer<RFWSaveMediaResultBean> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f58225d;

            a(String str) {
                this.f58225d = str;
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
                if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
                    ToastUtil.s(this.f58225d, 5);
                } else {
                    ToastUtil.o(R.string.gkh, 4);
                }
            }
        }
    }

    public z(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(f fVar) {
        if (!L()) {
            QLog.e("QZoneShareSaveAction", 1, "[MORE_SAVE] this function is closed and not suposed to show!");
        } else if (com.qzone.util.z.b(fVar.f58179c)) {
            R();
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "24", true);
        } else {
            P();
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "2", true);
        }
    }

    private void K(String str) {
        tk.h.R(n(), str, false, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        QQToast.makeText(n(), 0, R.string.f174762wq, 0).show();
    }

    private void P() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        final String str;
        if (!com.qzone.reborn.configx.g.f53821a.k().l()) {
            O();
            return;
        }
        if (this.f58109d == null) {
            QLog.e("QZoneShareSaveAction", 1, "current photo is null");
            return;
        }
        f fVar = this.f58107b;
        if (fVar != null && (rFWLayerItemMediaInfo = fVar.f58182f) != null && rFWLayerItemMediaInfo.getLayerPicInfo() != null && this.f58107b.f58182f.getLayerPicInfo().getCurrentPicInfo() != null) {
            QLog.i("QZoneShareSaveAction", 2, "org url is " + this.f58109d.orgUrl + ", download url is " + this.f58109d.downloadUrl + ", big url is " + this.f58109d.bigUrl + ", is show origin state is " + this.f58109d.isShowOriginState);
            if (!TextUtils.isEmpty(this.f58109d.downloadUrl)) {
                str = this.f58109d.downloadUrl;
            } else {
                str = "";
            }
            QLog.i("QZoneShareSaveAction", 1, "download pic url is " + str);
            if (TextUtils.isEmpty(str)) {
                A(this.f58107b);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.layer.share.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.this.M();
                    }
                });
                return;
            } else if (oo.b.l()) {
                oo.b.f(null, 1, Collections.singletonList(str), new b.InterfaceC10931b() { // from class: com.qzone.reborn.layer.share.y
                    @Override // oo.b.InterfaceC10931b
                    public final void a(ArrayList arrayList) {
                        z.this.N(str, arrayList);
                    }
                });
                return;
            } else {
                K(str);
                return;
            }
        }
        A(this.f58107b);
    }

    private void Q() {
        VideoInfo videoInfo;
        PhotoInfo photoInfo = this.f58109d;
        if (photoInfo == null || (videoInfo = photoInfo.videodata) == null) {
            return;
        }
        VideoUrl videoUrl = videoInfo.downloadVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            QLog.d("QzonePhotoUtil", 1, "saveVideo downloadVideoUrl: " + photoInfo.videodata.downloadVideoUrl.url);
            QZoneFeedxPictureManager.getInstance().downloadVideo(new QZoneAlbumMediaRequestBuilder().setVideoDownloadUrl(photoInfo.videodata.downloadVideoUrl.url), null);
            return;
        }
        VideoUrl videoUrl2 = photoInfo.videodata.originVideoUrl;
        if (videoUrl2 != null && !TextUtils.isEmpty(videoUrl2.url)) {
            QLog.d("QzonePhotoUtil", 1, "saveVideo originVideoUrl: " + photoInfo.videodata.originVideoUrl.url);
            QZoneFeedxPictureManager.getInstance().downloadVideo(new QZoneAlbumMediaRequestBuilder().setVideoDownloadUrl(photoInfo.videodata.originVideoUrl.url), null);
            return;
        }
        VideoUrl videoUrl3 = photoInfo.videodata.videoUrl;
        if (videoUrl3 == null || TextUtils.isEmpty(videoUrl3.url)) {
            return;
        }
        QLog.d("QzonePhotoUtil", 1, "saveVideo videoUrl: " + photoInfo.videodata.videoUrl.url);
        QZoneFeedxPictureManager.getInstance().downloadVideo(new QZoneAlbumMediaRequestBuilder().setVideoDownloadUrl(photoInfo.videodata.videoUrl.url), null);
    }

    private void R() {
        VideoInfo videoInfo;
        if (!com.qzone.reborn.configx.g.f53821a.k().m()) {
            Q();
            return;
        }
        PhotoInfo photoInfo = this.f58109d;
        if (photoInfo == null || (videoInfo = photoInfo.videodata) == null) {
            return;
        }
        VideoUrl videoUrl = videoInfo.downloadVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            QLog.d("QZoneShareSaveAction", 1, "saveVideo downloadVideoUrl: " + photoInfo.videodata.downloadVideoUrl.url);
            tk.h.Q(n(), photoInfo.videodata.downloadVideoUrl.url, true);
            return;
        }
        VideoUrl videoUrl2 = photoInfo.videodata.originVideoUrl;
        if (videoUrl2 != null && !TextUtils.isEmpty(videoUrl2.url)) {
            QLog.d("QZoneShareSaveAction", 1, "saveVideo originVideoUrl: " + photoInfo.videodata.originVideoUrl.url);
            tk.h.Q(n(), photoInfo.videodata.originVideoUrl.url, true);
            return;
        }
        VideoUrl videoUrl3 = photoInfo.videodata.videoUrl;
        if (videoUrl3 != null && !TextUtils.isEmpty(videoUrl3.url)) {
            QLog.d("QZoneShareSaveAction", 1, "saveVideo videoUrl: " + photoInfo.videodata.videoUrl.url);
            tk.h.Q(n(), photoInfo.videodata.videoUrl.url, true);
            return;
        }
        A(this.f58107b);
    }

    protected boolean L() {
        if (f58218l == -1) {
            f58218l = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_PHOTO_SAVE, 1);
        }
        return f58218l == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
        if (this.f58219j == -1) {
            this.f58219j = System.currentTimeMillis();
        }
        B("");
        if (this.f58220k == null) {
            this.f58220k = new c();
        }
        f(3, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), this.f58220k);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (!QZonePermission.requestStoragePermission(n(), new a(fVar), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            QLog.e("QZoneShareSaveAction", 1, "[MORE_SAVE] don't has store permission");
        } else {
            J(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        super.x(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000065) {
            D();
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(String str, ArrayList arrayList) {
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            K(str);
            RFWLog.e("QZoneWatermark", RFWLog.USR, "savePictureNew byWatermarkManger return invalid result,originUrl:", str);
        } else {
            String str2 = (String) arrayList.get(0);
            RFWLog.d("QZoneWatermark", RFWLog.CLR, "savePictureNew byWatermarkManger,originUrl:", str, ",replaceUrl:", str2);
            K(str2);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{39};
    }
}
