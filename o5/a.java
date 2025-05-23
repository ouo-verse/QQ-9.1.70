package o5;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static String a() {
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhoneAlbum", "\u624b\u673a\u76f8\u518c");
    }

    public static BusinessAlbumInfo b() {
        long uin = LoginData.getInstance().getUin();
        String string4Uin = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_ID, "", uin);
        if (TextUtils.isEmpty(string4Uin)) {
            return null;
        }
        BusinessAlbumInfo create = BusinessAlbumInfo.create(string4Uin);
        create.mCover = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_COVER, "", uin);
        create.mTitle = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_NAME, "", uin);
        create.mAlbumType = LocalMultiProcConfig.getInt4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_TYPE, 0, uin);
        create.mPrivacy = LocalMultiProcConfig.getInt4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_PRIVACY, 0, uin);
        return create;
    }

    public static void d(BusinessAlbumInfo businessAlbumInfo) {
        if (businessAlbumInfo != null) {
            long uin = LoginData.getInstance().getUin();
            LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_ID, businessAlbumInfo.mAlbumId, uin);
            LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_COVER, businessAlbumInfo.mCover, uin);
            LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_NAME, businessAlbumInfo.mTitle, uin);
            LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_TYPE, businessAlbumInfo.mAlbumType, uin);
            LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.Constants.KEY_RESHIP_PHOTO_ALBUM_PRIVACY, businessAlbumInfo.mPrivacy, uin);
        }
    }

    public static void c(int i3, int i16) {
        int i17 = 1;
        if (i16 != 1) {
            i17 = 2;
            if (i16 != 2) {
                i17 = 3;
                if (i16 != 3) {
                    i17 = 4;
                    if (i16 != 4) {
                        i17 = 0;
                    }
                }
            }
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(682, i3, i17), false, false);
    }
}
