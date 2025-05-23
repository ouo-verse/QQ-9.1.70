package com.qzone.reborn.albumx.qzonex.utils;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.tencent.mobileqq.R;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u0017\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/c;", "", "", "ugcPrivType", tl.h.F, "(Ljava/lang/Integer;)I", "permissionType", "k", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "d", "j", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "f", "info", "g", "e", "qzAlbumType", "c", "albumType", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f53402a = new c();

    c() {
    }

    public final int a(int albumType) {
        if (albumType == 1) {
            return 0;
        }
        if (albumType == 5) {
            return 8;
        }
        if (albumType == 6) {
            return 9;
        }
        if (albumType != 8) {
            if (albumType != 9) {
                return 0;
            }
            return 12;
        }
        return 11;
    }

    public final String b(int albumType) {
        if (albumType == 0) {
            return "\u666e\u901a" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (albumType == 8) {
            return "\u4eb2\u5b50" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (albumType == 9) {
            return "\u65c5\u6e38" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (albumType == 11) {
            return "\u60c5\u4fa3" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (albumType != 12) {
            return QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        return "\u591a\u4eba" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
    }

    public final boolean g(CommonAlbumInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        String uinString = LoginData.getInstance().getUinString();
        if (!info.getIsShareAlbum() && Intrinsics.areEqual(info.getCreator().getUin(), uinString)) {
            return false;
        }
        if (!info.getIsShareAlbum()) {
            return true;
        }
        Iterator<CommonClientAttr> it = info.getShareAlbum().e().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), uinString)) {
                return false;
            }
        }
        return true;
    }

    public final String i(int permission) {
        if (permission == 3) {
            return "qui_lock";
        }
        return "qui_user";
    }

    public final int c(Integer qzAlbumType) {
        if (qzAlbumType == null) {
            return 1;
        }
        switch (qzAlbumType.intValue()) {
            case 8:
                return 2;
            case 9:
                return 3;
            case 10:
            default:
                return 1;
            case 11:
                return 4;
            case 12:
                return 5;
        }
    }

    public final boolean e(CommonAlbumInfo info) {
        if (info == null) {
            return false;
        }
        String uinString = LoginData.getInstance().getUinString();
        if (!info.getIsShareAlbum() && Intrinsics.areEqual(info.getCreator().getUin(), uinString)) {
            return true;
        }
        if (info.getIsShareAlbum()) {
            Iterator<CommonClientAttr> it = info.getShareAlbum().e().iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), uinString)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f(CommonAlbumInfo albumInfo) {
        String uin;
        if (albumInfo == null) {
            return false;
        }
        if (albumInfo.getIsShareAlbum()) {
            uin = albumInfo.getShareAlbum().getOwner().getUin();
        } else {
            uin = albumInfo.getCreator().getUin();
        }
        return Intrinsics.areEqual(uin, LoginData.getInstance().getUinString());
    }

    public final int h(Integer ugcPrivType) {
        if (ugcPrivType != null && ugcPrivType.intValue() == 1) {
            return 1;
        }
        if (ugcPrivType != null && ugcPrivType.intValue() == 4) {
            return 4;
        }
        if (ugcPrivType != null && ugcPrivType.intValue() == 3) {
            return 64;
        }
        if (ugcPrivType != null && ugcPrivType.intValue() == 6) {
            return 16;
        }
        if (ugcPrivType != null && ugcPrivType.intValue() == 8) {
            return 128;
        }
        return (ugcPrivType != null && ugcPrivType.intValue() == 5) ? 9999 : 1;
    }

    public final int k(Integer permissionType) {
        if (permissionType != null && permissionType.intValue() == 1) {
            return 1;
        }
        if (permissionType != null && permissionType.intValue() == 4) {
            return 4;
        }
        if (permissionType != null && permissionType.intValue() == 64) {
            return 3;
        }
        if (permissionType != null && permissionType.intValue() == 16) {
            return 6;
        }
        if (permissionType != null && permissionType.intValue() == 128) {
            return 8;
        }
        return (permissionType != null && permissionType.intValue() == 9999) ? 5 : 1;
    }

    public final String j(int permission) {
        if (permission == 1) {
            return "qui_lock_off";
        }
        if (permission == 8) {
            return "qui_group";
        }
        if (permission != 3) {
            if (permission == 4) {
                return "qui_qq";
            }
            if (permission == 5) {
                return "qui_remark";
            }
            if (permission == 6) {
                return "qui_group";
            }
        }
        return "qui_lock";
    }

    public final String d(int permission) {
        int i3 = permission != 1 ? permission != 8 ? permission != 3 ? permission != 4 ? permission != 5 ? permission != 6 ? 0 : R.string.gc7 : R.string.f172992gc2 : R.string.f172994gc4 : R.string.ghd : R.string.f172993gc3 : R.string.ghc;
        if (i3 == 0) {
            return null;
        }
        return MobileQQ.sMobileQQ.getResources().getString(i3);
    }
}
