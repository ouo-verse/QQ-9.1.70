package com.qzone.album.business.photolist.controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.album.business.photolist.adapter.a;
import com.qzone.album.business.photolist.adapter.z;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZplanQzoneApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import u4.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SingleModelController extends BasePhotoModelController {
    private String D2;
    View E2;
    private a.f F2;
    private ProgressBar G2;
    private TextView H2;
    private ImageView I2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f43138a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, boolean z16) {
            super(looper);
            this.f43138a = z16;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            if (SingleModelController.this.k3()) {
                SingleModelController.this.F3(obj, Boolean.valueOf(this.f43138a), SingleModelController.this.f43008x0);
            } else {
                SingleModelController.this.E3(obj, Boolean.valueOf(this.f43138a), SingleModelController.this.f43008x0);
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends HdAsyncAction {
        b(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            ArrayList<PhotoCacheData> arrayList;
            SingleModelController singleModelController = SingleModelController.this;
            if (singleModelController.f43010y0 != null) {
                if (singleModelController.k3()) {
                    SingleModelController singleModelController2 = SingleModelController.this;
                    arrayList = singleModelController2.f43012z0.V(singleModelController2.S.longValue(), 2);
                    SingleModelController singleModelController3 = SingleModelController.this;
                    singleModelController3.f43008x0 = singleModelController3.f43012z0.x(singleModelController3.S.longValue(), String.valueOf(SingleModelController.this.S));
                } else if (TextUtils.isEmpty(SingleModelController.this.T)) {
                    arrayList = null;
                } else {
                    SingleModelController singleModelController4 = SingleModelController.this;
                    arrayList = singleModelController4.f43012z0.B(singleModelController4.T);
                    SingleModelController singleModelController5 = SingleModelController.this;
                    singleModelController5.f43008x0 = singleModelController5.f43012z0.x(singleModelController5.S.longValue(), SingleModelController.this.T);
                }
                return doNext(true, arrayList);
            }
            return doNext(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements a.f {
        c() {
        }

        @Override // com.qzone.album.business.photolist.adapter.a.f
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof z.d)) {
                SingleModelController.this.c5((PhotoCacheData) ((z.d) tag).f42866b);
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            SingleModelController singleModelController = SingleModelController.this;
            PhotoCacheData Z1 = singleModelController.Z1(singleModelController.f43000u0, intValue, false);
            if (Z1 == null || SingleModelController.this.Z4(Z1)) {
                return;
            }
            SingleModelController singleModelController2 = SingleModelController.this;
            if (!singleModelController2.f42958g0) {
                singleModelController2.b5(Z1);
                return;
            }
            Intent intent = new Intent();
            if (!Z1.isVideo()) {
                ParcelableWrapper.putDataToIntent(intent, "key_photo_new_cover_picitem", Z1.picItem);
            } else {
                PictureItem pictureItem = Z1.picItem;
                pictureItem.currentUrl = Z1.videodata.currentUrl;
                ParcelableWrapper.putDataToIntent(intent, "key_photo_new_cover_picitem", pictureItem);
            }
            SingleModelController.this.Q.setResult(-1, intent);
            SingleModelController.this.x1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnKeyListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            Dialog dialog = SingleModelController.this.X0;
            if (dialog == null || !dialog.isShowing()) {
                return false;
            }
            SingleModelController.this.X0.dismiss();
            SingleModelController.this.x1();
            return true;
        }
    }

    public SingleModelController(FragmentActivity fragmentActivity, h hVar) {
        super(fragmentActivity, hVar);
        this.F2 = new c();
        this.G2 = null;
        this.H2 = null;
        this.I2 = null;
    }

    private File X4(String str) {
        File imageFile = ImageLoader.getInstance().getImageFile(str);
        if (imageFile == null) {
            return null;
        }
        if (imageFile.exists()) {
            return imageFile;
        }
        ImageLoader.getInstance().removeImageFile(str);
        ImageLoader.getInstance().clear(str);
        return null;
    }

    private void Y4(PhotoCacheData photoCacheData) {
        String str;
        if (!photoCacheData.isVideo() && !photoCacheData.isGifPhoto()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("picUrl", photoCacheData.picItem.getPicUrlDec().url);
                ((IZplanQzoneApi) QRoute.api(IZplanQzoneApi.class)).onQzonePicSelected(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            Intent intent = new Intent();
            Activity activity = this.Q;
            if (activity != null) {
                activity.setResult(-1, intent);
            }
            x1();
            return;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (photoCacheData.isVideo()) {
            str = "\u4e0d\u80fd\u9009\u62e9\u89c6\u9891";
        } else {
            str = "\u4e0d\u80fd\u9009\u62e9\u52a8\u56fe";
        }
        QQToast.makeText(application, 1, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z4(PhotoCacheData photoCacheData) {
        if (!QZoneHelper.QZoneAlbumConstants.VALUE_SOURCE_FROM_XIAOWO.equals(this.D2)) {
            return false;
        }
        Y4(photoCacheData);
        return true;
    }

    private File a5(PhotoCacheData photoCacheData) {
        String str;
        if (!photoCacheData.isVideo()) {
            PictureItem pictureItem = photoCacheData.picItem;
            str = pictureItem != null ? pictureItem.getPicUrlDec().url : null;
        } else {
            str = photoCacheData.videodata.getPicUrlDec().url;
        }
        QZLog.d("[PhotoAlbum] SingleModelController", 2, "loadForUrl url:", str);
        File X4 = X4(str);
        if (X4 != null && X4.exists()) {
            return X4;
        }
        AlbumImageDownloadListener albumImageDownloadListener = new AlbumImageDownloadListener(str);
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        if (ImageLoader.getInstance().loadImage(str, albumImageDownloadListener, obtain) != null) {
            com.qzone.album.env.common.a.m().W(I(R.string.f173027gk3), 1);
            return null;
        }
        f5(I(R.string.gjc));
        return null;
    }

    private void e5() {
        Map<Integer, String> map;
        if (!QZoneHelper.QZoneAlbumConstants.VALUE_SOURCE_FROM_XIAOWO.equals(this.D2) || (map = this.f42971k1) == null) {
            return;
        }
        map.put(4, QZoneHelper.QZoneAlbumConstants.VALUE_SOURCE_FROM_XIAOWO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g5(String str) {
        if (this.X0 == null) {
            return;
        }
        this.H2.setText(str);
        this.I2.setVisibility(8);
        this.G2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void C3(Intent intent) {
        super.C3(intent);
        this.f42950d1 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void K2() {
        super.K2();
        V3(QZoneAlbumUtil.v(this.f42940a0, this, P2()));
        BaseAdapter B1 = B1();
        if (B1 != null) {
            if (B1 instanceof z) {
                ((z) B1()).i(this.F2);
            } else if (B1 instanceof com.qzone.album.business.photolist.adapter.a) {
                ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.F2);
                ((com.qzone.album.business.photolist.adapter.a) B1()).y(true);
                ((com.qzone.album.business.photolist.adapter.a) B1()).A(V2(this.f42970k0));
            }
        }
        O2(true);
        this.W1.getListView().j0().setAdapter((ListAdapter) B1());
        this.W1.getListView().setSupportPullUp(true);
        E4();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void N(Activity activity) {
        super.N(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void N2() {
        super.N2();
        this.E2.findViewById(R.id.f166672ha0).setVisibility(8);
        this.E2.findViewById(R.id.h_w).setVisibility(8);
        this.E2.findViewById(R.id.f166673ha1).setVisibility(8);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public boolean O2(boolean z16) {
        j0(z16);
        super.O2(z16);
        return true;
    }

    public void d5(String str) {
        this.D2 = str;
    }

    public void f5(String str) {
        Dialog dialog = this.X0;
        if (dialog == null || !dialog.isShowing()) {
            if (this.X0 == null) {
                ReportDialog reportDialog = new ReportDialog(this.Q, R.style.f174269ui);
                this.X0 = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.H2 = (TextView) this.X0.findViewById(R.id.dialogText);
                this.I2 = (ImageView) this.X0.findViewById(R.id.kja);
                this.G2 = (ProgressBar) this.X0.findViewById(R.id.cib);
                this.X0.setCancelable(false);
                this.X0.setCanceledOnTouchOutside(false);
                this.X0.setOnKeyListener(new d());
                this.I2.setVisibility(8);
                this.G2.setVisibility(0);
            }
            this.H2.setText(str);
            Dialog dialog2 = this.X0;
            if (dialog2 != null) {
                try {
                    dialog2.show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void l1() {
        if (this.f42962h1) {
            w2();
        } else if (com.qzone.album.base.b.a(BasePhotoModelController.I1(this.S.longValue(), this.T, this.f42955f0))) {
            I3();
            e5();
            this.f43010y0.g0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void n3(boolean z16) {
        HdAsync.with(this).then(new b(com.qzone.album.env.common.a.m().u().getLooper())).then(new a(Looper.getMainLooper(), z16)).call();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void q1() {
        View inflate = getLayoutInflater().inflate(R.layout.bo6, (ViewGroup) null, false);
        this.E2 = inflate;
        this.Q.setContentView(inflate);
        N2();
        K2();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void r1() {
        I3();
        e5();
        this.f43010y0.r1(this.S.longValue(), this.T, this.f42985p0, null, this.f42989q1, this.f42950d1 ? this.f42971k1 : null, this.f42940a0, this.f42991r0, this.U0, this.f42993r2);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public boolean M(Activity activity) {
        P3(false);
        return false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void o1() {
        n3(true);
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W4(final File file) {
        if (file != null && file.exists()) {
            com.qzone.album.env.common.a.m().H(new Runnable() { // from class: com.qzone.album.business.photolist.controller.SingleModelController.4
                @Override // java.lang.Runnable
                public void run() {
                    String m3 = u4.a.z().m(file, SingleModelController.this.f42961h0);
                    Intent intent = new Intent();
                    intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH, m3);
                    intent.putExtra("UploadPhoto.key_album_id", SingleModelController.this.T);
                    QLog.e("[PhotoAlbum] SingleModelController", 1, "backToCoverSetting | path = " + m3 + " , path.exists" + new File(m3).exists());
                    SingleModelController.this.Q.setResult(-1, intent);
                    SingleModelController.this.x1();
                }
            });
        } else {
            com.qzone.album.env.common.a.m().W(I(R.string.f173027gk3), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b5(PhotoCacheData photoCacheData) {
        File a56;
        if (photoCacheData == null || (a56 = a5(photoCacheData)) == null) {
            return;
        }
        W4(a56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c5(PhotoCacheData photoCacheData) {
        if (photoCacheData != null && u4.a.z().y(this.Q, this.P, photoCacheData)) {
            x1();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void v2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class AlbumImageDownloadListener implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private String f43132d;

        public AlbumImageDownloadListener(String str) {
            this.f43132d = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            onImageFailed(str, options);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            if (SingleModelController.this.Q.isFinishing()) {
                return;
            }
            SingleModelController singleModelController = SingleModelController.this;
            singleModelController.g5(singleModelController.I(R.string.gjd));
            SingleModelController.this.e0().postDelayed(new Runnable() { // from class: com.qzone.album.business.photolist.controller.SingleModelController.AlbumImageDownloadListener.1
                @Override // java.lang.Runnable
                public void run() {
                    Dialog dialog;
                    if (SingleModelController.this.Q.isFinishing() || (dialog = SingleModelController.this.X0) == null || !dialog.isShowing()) {
                        return;
                    }
                    SingleModelController.this.X0.dismiss();
                }
            }, 1000L);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(final String str, Drawable drawable, final ImageLoader.Options options) {
            if (SingleModelController.this.Q.isFinishing() || str == null || !str.equals(this.f43132d)) {
                return;
            }
            SingleModelController.this.Q.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.controller.SingleModelController.AlbumImageDownloadListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (SingleModelController.this.Q.isFinishing()) {
                        return;
                    }
                    Dialog dialog = SingleModelController.this.X0;
                    if (dialog != null && dialog.isShowing()) {
                        SingleModelController.this.X0.dismiss();
                    }
                    File imageFile = ImageLoader.getInstance().getImageFile(AlbumImageDownloadListener.this.f43132d);
                    if (imageFile != null) {
                        SingleModelController.this.W4(imageFile);
                    } else {
                        AlbumImageDownloadListener.this.onImageFailed(str, options);
                    }
                }
            });
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
