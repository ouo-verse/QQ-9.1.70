package lc;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0012"}, d2 = {"Llc/a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "", "c", "g", "e", "b", tl.h.F, "d", "a", "f", "i", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414334a = new a();

    a() {
    }

    private final void a(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        if ((bl.c(initBean.getSelectImageList()) || bundle.containsKey(QQWinkConstants.INPUT_MEDIA)) && initBean.getIsLaunchSelectPhotoPage()) {
            initBean.setLaunchSelectPhotoPage(false);
        }
    }

    private final void b(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        if (bundle.getInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM) == 4) {
            initBean.setFromType(7);
            initBean.setLaunchSelectPhotoPage(false);
            initBean.setHideAddBtn(true);
            initBean.setClassifyId(bundle.getString("QZoneUploadRecommend.CLASSIFY_ID"));
        }
    }

    private final void c(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        String string = bundle.getString("UploadPhoto.key_album_id");
        String string2 = bundle.getString("UploadPhoto.key_album_name");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (initBean.getAlbumInfo() != null) {
            CommonAlbumInfo albumInfo = initBean.getAlbumInfo();
            Intrinsics.checkNotNull(albumInfo);
            if (!TextUtils.isEmpty(albumInfo.getAlbumId())) {
                return;
            }
        }
        initBean.setAlbumInfo(new CommonAlbumInfo());
        CommonAlbumInfo albumInfo2 = initBean.getAlbumInfo();
        Intrinsics.checkNotNull(albumInfo2);
        if (string == null) {
            string = "";
        }
        albumInfo2.V(string);
        CommonAlbumInfo albumInfo3 = initBean.getAlbumInfo();
        Intrinsics.checkNotNull(albumInfo3);
        if (string2 == null) {
            string2 = "";
        }
        albumInfo3.m0(string2);
    }

    private final void d(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        if (bundle.getInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM) == 1) {
            initBean.setFromType(8);
        }
    }

    private final void e(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        initBean.setPhotoRepairTaskId(bundle.getString(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_TASK_ID));
        initBean.setPhotoRepairSrUrl(bundle.getString(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_URL));
        if (TextUtils.isEmpty(initBean.getPhotoRepairTaskId()) || TextUtils.isEmpty(initBean.getPhotoRepairSrUrl())) {
            return;
        }
        initBean.setFromType(6);
        initBean.setHideAddBtn(true);
        initBean.setPhotoRepairByOpr(bundle.getBoolean(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_SR_BY_OPR));
    }

    private final void f(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        if (bundle.getInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM) == 3) {
            initBean.setFromType(9);
        }
    }

    private final void g(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        initBean.setSelectImageList(bundle.getStringArrayList("QZoneUploadPhotoActivity.key_selected_image_path"));
        if (bl.b(initBean.getSelectImageList())) {
            initBean.setSelectImageList(bundle.getStringArrayList("images"));
        }
    }

    private final void h(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        initBean.setTianShuAdId(bundle.getString("adId"));
    }

    public final void i(Bundle bundle, QZAlbumxUploadAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        c(bundle, initBean);
        g(bundle, initBean);
        e(bundle, initBean);
        b(bundle, initBean);
        h(bundle, initBean);
        d(bundle, initBean);
        f(bundle, initBean);
        a(bundle, initBean);
    }
}
