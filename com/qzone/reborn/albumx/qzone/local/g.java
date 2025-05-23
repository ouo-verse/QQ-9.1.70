package com.qzone.reborn.albumx.qzone.local;

import android.os.Build;
import com.qzone.util.af;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/g;", "", "", "l", DomainData.DOMAIN_NAME, "b", "a", "c", "j", "i", "", "d", "hasShowDialog", "o", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "e", tl.h.F, "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f52662a = new g();

    g() {
    }

    private final boolean l() {
        return com.qzone.reborn.util.i.b().d("exp_qzone_album_recommend_new_1", false);
    }

    private final boolean n() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND, 0) == 0;
    }

    public final boolean a() {
        if (!n()) {
            RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[enableDoRecommendLogic] close by wns");
            return false;
        }
        if (!l()) {
            RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[enableDoRecommendLogic] not hit tab experiment");
            return false;
        }
        if (!o7.c.b()) {
            RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[enableDoRecommendLogic] close by getLocalPhotoScanAuthorizeSwitch");
            return false;
        }
        if (j()) {
            return true;
        }
        RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[enableDoRecommendLogic] not has read storage permission");
        return false;
    }

    public final boolean b() {
        return n();
    }

    public final boolean c() {
        if (!n()) {
            RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[enableShowRecommendTab] close by wns");
            return false;
        }
        return l();
    }

    public final void d() {
        boolean d16 = com.qzone.reborn.a.f52169a.d("exp_qzone_album_recommend_new_1", null);
        RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[fetchAndSaveTabExperiment] isHitTabExperiment=" + d16);
        com.qzone.reborn.util.i.b().l("exp_qzone_album_recommend_new_1", d16);
    }

    public final String e() {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_NOT_OPEN_DESC, "\u5f00\u542f\u540e\uff0c\u5c06\u6839\u636e\u624b\u673a\u672c\u5730\u56fe\u7247\u53ca\u5176\u4fe1\u606f\uff0c\u5b9a\u671f\u4e3a\u4f60\u63a8\u8350\u7f8e\u597d\u56de\u5fc6\uff0c\u4e00\u952e\u5408\u6210\u5927\u7247\u6548\u679c (\u82e5\u672a\u4e3b\u52a8\u70b9\u51fb\u4e0a\u4f20\uff0c\u5e73\u53f0\u4e0d\u4f1a\u81ea\u52a8\u5c06\u4f60\u7684\u672c\u5730\u56fe\u7247\u4e0a\u4f20\u4e91\u7aef\uff0c\u8bf7\u653e\u5fc3\u5f00\u542f)\u3002");
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026E_NOT_OPEN_DESC\n        )");
        return config;
    }

    public final String f() {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_NOT_OPEN_TITLE, "\u6b22\u8fce\u4f53\u9a8c\u300c\u56de\u5fc6\u5f71\u96c6\u300d");
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026_NOT_OPEN_TITLE\n        )");
        return config;
    }

    public final String g() {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_OPENED_DESC, "\u8bbe\u7f6e\u6210\u529f\u540e\uff0c\u7a7a\u95f4\u5c06\u5b9a\u671f\u626b\u63cf\u672c\u5730\u76f8\u518c\u7684\u65b0\u589e\u5185\u5bb9\uff0c\u5e76\u8fdb\u884c\u63d0\u793a\uff0c\u540e\u7eed\u53ef\u5728QQ\u7a7a\u95f4-\u66f4\u591a\u8bbe\u7f6e-\u901a\u7528\u8bbe\u7f6e\u91cc\u8fdb\u884c\u6388\u6743\u66f4\u6539\u3002");
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026IZE_OPENED_DESC\n        )");
        return config;
    }

    public final String h() {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_AUTHORIZE_OPENED_TITLE, QzoneConfig.DefaultValue.DEFAULT_ALBUM_UPDATE_TIP_OPENED_TITLE);
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026ZE_OPENED_TITLE\n        )");
        return config;
    }

    public final boolean i() {
        return Build.VERSION.SDK_INT < 29 || af.a(RFWApplication.getApplication(), QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION) == 0;
    }

    public final boolean j() {
        return af.a(RFWApplication.getApplication(), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0;
    }

    public final boolean k() {
        return com.qzone.reborn.util.i.b().d("key_has_show_albumx_local_photo_authorized_dialog", false);
    }

    public final boolean m() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_UPLOAD_HISTORY, 0) == 0;
    }

    public final void o(boolean hasShowDialog) {
        com.qzone.reborn.util.i.b().l("key_has_show_albumx_local_photo_authorized_dialog", hasShowDialog);
    }
}
