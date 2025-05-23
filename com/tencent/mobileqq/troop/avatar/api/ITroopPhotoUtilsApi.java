package com.tencent.mobileqq.troop.avatar.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.avatar.a;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupHeadPortrait;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$RspBody;

@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopPhotoUtilsApi extends QRouteApi {
    public static final int DEFAULT_HD_AVATAR_SIZE = 640;
    public static final String KEY_CLIP_INFO = "key_clip_info";
    public static final String KEY_DEL_PICS = "key_del_pics";
    public static final int MAX_SAMPLE_SIZE = 1024;
    public static final int REQUEST_CODE_AVATAR_EDIT = 260;
    public static final int REQUEST_CODE_AVATAR_VIEW = 261;
    public static final int REQUEST_CODE_COVER_EDIT = 258;
    public static final int REQUEST_CODE_COVER_VIEW = 259;
    public static final int REQUEST_CODE_PORTRAIT_SHOTPHOTO = 257;
    public static final int SUB_VER = 101;

    void cacheFileFromLocal(int i3, String str, String str2);

    int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16);

    int copySdcardFile(String str, String str2);

    boolean deleteFoder(File file);

    String getAllPicFromDb(List<TroopClipPic> list, TroopInfo troopInfo);

    int getBusiByType(int i3);

    void getClipRect(Rect rect, String str);

    Point getClipRectSize(Activity activity, int i3);

    String getClipStr(int i3, int i16, int i17, int i18);

    String getCoverFromDb(List<a> list, TroopInfo troopInfo);

    String getErrText(Context context, int i3);

    int getInSampleSize(int i3, int i16, int i17, int i18);

    int getPicsFrom88d(oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait, List<TroopClipPic> list);

    int getPicsFrom8b8(oidb_0x8b8$RspBody oidb_0x8b8_rspbody, List<TroopClipPic> list);

    int getScaledCoverHeight(int i3);

    int getShapeOfBusi(int i3);

    int getSubcmdByType(int i3);

    URL getURL4TroopPhoto(String str);

    String getUploadPhotoTempPath();

    int saveBitmapToFile(String str, String str2);

    Set<String> setVerifyingAvatarPicId(oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait);

    void startPhotoEdit(Activity activity, Intent intent, String str, int i3);

    void startPhotoEdit(Activity activity, String str, int i3);

    void startPhotoEditForResult(Activity activity, Intent intent, String str, int i3, int i16);

    void startPhotoEditForResult(Activity activity, Intent intent, String str, String str2, int i3, int i16);

    void startPhotoList(Activity activity, int i3);

    void startPhotoListEdit(Activity activity, int i3);

    void startPhotoListEditForResult(Activity activity, Intent intent, int i3, int i16);

    void startPhotoListEditWithIntent(Activity activity, Intent intent, int i3);
}
