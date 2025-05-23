package com.tencent.mobileqq.troop.avatar.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.a;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$GroupPicListInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8$RspBody;

/* loaded from: classes19.dex */
public class TroopPhotoUtilsApiImpl implements ITroopPhotoUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final int CMD_TYPE_AVATAR = 1;
    public static final int CMD_TYPE_COVER = 0;
    public static final float FIX_SCALE_HW_COVER = 0.5653333f;
    public static final String TAG = "TroopPhotoUtilsApiImpl";

    public TroopPhotoUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean getIsKeepClipInfo(int i3) {
        if (i3 != 102) {
            return false;
        }
        return true;
    }

    private boolean isNumeric(String str) {
        if (!Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void cacheFileFromLocal(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), str, str2);
            return;
        }
        String valueOf = String.valueOf(i3);
        ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
        URL uRL4TroopPhoto = getURL4TroopPhoto(iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(valueOf, str2, 1)));
        if (uRL4TroopPhoto != null) {
            int copySdcardFile = copySdcardFile(str, AbsDownloader.getFilePath(uRL4TroopPhoto.toString()));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cacheFileFromLocal origin photo,result:" + copySdcardFile);
            }
        }
        URL uRL4TroopPhoto2 = getURL4TroopPhoto(iTroopAvatarUtilApi.getThumbPhoto(iTroopAvatarUtilApi.getAvatarAddress(valueOf, str2, 1)));
        if (uRL4TroopPhoto2 != null) {
            int saveBitmapToFile = saveBitmapToFile(str, AbsDownloader.getFilePath(uRL4TroopPhoto2.toString()));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cacheFileFromLocal thumb photo,result:" + saveBitmapToFile);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, this, options, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 == 0 || i16 == 0 || i3 == -1 || i16 == -1) {
            return 1;
        }
        int inSampleSize = getInSampleSize(i3, i16, options.outHeight, options.outWidth);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("calculateInSampleSize [%d,%d,%d]", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(inSampleSize)));
        }
        return inSampleSize;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int copySdcardFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception unused) {
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (Exception unused2) {
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            fileInputStream.close();
            try {
                fileOutputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            return 0;
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    return -1;
                } catch (IOException e19) {
                    e19.printStackTrace();
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (IOException e27) {
                    e27.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public boolean deleteFoder(File file) {
        File[] listFiles;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) file)).booleanValue();
        }
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    deleteFoder(file2);
                }
            }
            if (!file.delete()) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public String getAllPicFromDb(List<TroopClipPic> list, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) list, (Object) troopInfo);
        }
        String str = a.f294527k;
        if (troopInfo == null) {
            return str;
        }
        list.addAll(troopInfo.mTroopPicList);
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("getAllPicFromDb infs=%s", Arrays.toString(list.toArray())));
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getBusiByType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, i3)).intValue();
        }
        if (i3 != 0) {
            if (i3 != 1) {
                return 0;
            }
            return 103;
        }
        return 102;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void getClipRect(Rect rect, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rect, (Object) str);
            return;
        }
        rect.set(0, 0, 0, 0);
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length == 4 && isNumeric(split[0]) && isNumeric(split[1]) && isNumeric(split[2]) && isNumeric(split[3])) {
                int intValue = Integer.valueOf(split[0]).intValue();
                int intValue2 = Integer.valueOf(split[1]).intValue();
                int intValue3 = Integer.valueOf(split[2]).intValue();
                int intValue4 = Integer.valueOf(split[3]).intValue();
                if (intValue >= 0 && intValue2 >= 0 && intValue3 > intValue && intValue4 > intValue2) {
                    rect.set(intValue, intValue2, intValue3, intValue4);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public Point getClipRectSize(Activity activity, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Point) iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity, i3);
        }
        Point point = new Point();
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int i17 = displayMetrics.widthPixels;
        int i18 = displayMetrics.heightPixels;
        if (i17 < i18) {
            i16 = i17;
        } else {
            i16 = i18;
        }
        if (i3 != 102) {
            if (i3 != 104) {
                if (i3 != 107) {
                    int n3 = i16 - Utils.n(65.0f, activity.getResources());
                    point.set(n3, n3);
                } else {
                    int min = Math.min(i17, i18 - Utils.n(180.0f, activity.getResources())) - Utils.n(65.0f, activity.getResources());
                    point.set(min, min);
                }
            } else {
                point.set(i16, i16);
            }
        } else {
            point.set(i16, getScaledCoverHeight(i16));
        }
        return point;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public String getClipStr(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        return "" + i3 + "_" + i16 + "_" + i17 + "_" + i18;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public String getCoverFromDb(List<a> list, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) list, (Object) troopInfo);
        }
        String str = a.f294527k;
        if (troopInfo == null) {
            return str;
        }
        for (TroopClipPic troopClipPic : new ArrayList(troopInfo.mTroopPicList)) {
            if (troopClipPic.type == 1) {
                str = troopClipPic.f203184id;
            } else {
                list.add(a.b(troopClipPic, troopInfo.mTroopVerifyingPics));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("getCoverFromDb infs=%s", Arrays.toString(list.toArray())));
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public String getErrText(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, i3);
        }
        if (i3 == 0) {
            return context.getString(R.string.hfd);
        }
        if (i3 == 1) {
            return context.getString(R.string.f171282dq2);
        }
        if (i3 == 2) {
            return context.getString(R.string.f171281dq1);
        }
        if (i3 == 3) {
            return context.getString(R.string.f171283dq3);
        }
        if (i3 == 5) {
            return context.getString(R.string.f171280dq0);
        }
        if (i3 == 100) {
            return context.getString(R.string.dpk);
        }
        if (i3 == 101) {
            return context.getString(R.string.dpl);
        }
        if (i3 == 102) {
            return context.getString(R.string.dpi);
        }
        if (i3 == 103) {
            return context.getString(R.string.dpm);
        }
        if (i3 == 1793) {
            return context.getString(R.string.iqx);
        }
        return context.getString(R.string.dpz);
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getInSampleSize(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        while (true) {
            if (i17 <= i16 && i18 <= i3) {
                break;
            }
            int round = Math.round(i17 / i16);
            int round2 = Math.round(i18 / i3);
            if (round <= round2) {
                round = round2;
            }
            if (round < 2) {
                break;
            }
            i18 /= 2;
            i17 /= 2;
            i19 *= 2;
        }
        return i19;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getPicsFrom88d(oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait, List<TroopClipPic> list) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) oidb_0x88d_groupheadportrait, (Object) list)).intValue();
        }
        int i18 = oidb_0x88d_groupheadportrait.uint32_default_id.get();
        Iterator<oidb_0x88d$GroupHeadPortraitInfo> it = oidb_0x88d_groupheadportrait.rpt_msg_info.get().iterator();
        while (true) {
            int i19 = 0;
            if (!it.hasNext()) {
                break;
            }
            oidb_0x88d$GroupHeadPortraitInfo next = it.next();
            TroopClipPic troopClipPic = new TroopClipPic();
            troopClipPic.f203184id = String.valueOf(next.rpt_uint32_pic_id.get());
            if (next.uint32_left_x.has()) {
                i3 = next.uint32_left_x.get();
            } else {
                i3 = 0;
            }
            if (next.uint32_left_y.has()) {
                i16 = next.uint32_left_y.get();
            } else {
                i16 = 0;
            }
            if (next.uint32_right_x.has()) {
                i17 = next.uint32_right_x.get();
            } else {
                i17 = 0;
            }
            if (next.uint32_right_y.has()) {
                i19 = next.uint32_right_y.get();
            }
            if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i19 >= 0) {
                troopClipPic.clipInfo = getClipStr(i3, i16, i17, i19);
            }
            if (i18 == next.rpt_uint32_pic_id.get()) {
                troopClipPic.type = 1;
            }
            list.add(troopClipPic);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("getPicsFrom88d avatarId=%d %s", Integer.valueOf(i18), Arrays.toString(list.toArray())));
        }
        return i18;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getPicsFrom8b8(oidb_0x8b8$RspBody oidb_0x8b8_rspbody, List<TroopClipPic> list) {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) oidb_0x8b8_rspbody, (Object) list)).intValue();
        }
        int i19 = oidb_0x8b8_rspbody.uint32_default_id.get();
        if (oidb_0x8b8_rspbody.rpt_msg_pic_list_info.has() && oidb_0x8b8_rspbody.rpt_msg_pic_list_info.get().size() > 0) {
            for (oidb_0x8b8$GroupPicListInfo oidb_0x8b8_grouppiclistinfo : oidb_0x8b8_rspbody.rpt_msg_pic_list_info.get()) {
                if (oidb_0x8b8_grouppiclistinfo.uint32_pic_id.get() > 0) {
                    TroopClipPic troopClipPic = new TroopClipPic();
                    troopClipPic.f203184id = String.valueOf(oidb_0x8b8_grouppiclistinfo.uint32_pic_id.get());
                    if (oidb_0x8b8_grouppiclistinfo.uint32_left_x.has()) {
                        i3 = oidb_0x8b8_grouppiclistinfo.uint32_left_x.get();
                    } else {
                        i3 = 0;
                    }
                    if (oidb_0x8b8_grouppiclistinfo.uint32_left_y.has()) {
                        i16 = oidb_0x8b8_grouppiclistinfo.uint32_left_y.get();
                    } else {
                        i16 = 0;
                    }
                    if (oidb_0x8b8_grouppiclistinfo.uint32_right_x.has()) {
                        i17 = oidb_0x8b8_grouppiclistinfo.uint32_right_x.get();
                    } else {
                        i17 = 0;
                    }
                    if (oidb_0x8b8_grouppiclistinfo.uint32_right_y.has()) {
                        i18 = oidb_0x8b8_grouppiclistinfo.uint32_right_y.get();
                    } else {
                        i18 = 0;
                    }
                    if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0) {
                        troopClipPic.clipInfo = getClipStr(i3, i16, i17, i18);
                    }
                    if (i19 == oidb_0x8b8_grouppiclistinfo.uint32_pic_id.get()) {
                        troopClipPic.type = 1;
                    }
                    list.add(troopClipPic);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("getPicsFrom8b8 avatarId=%d %s", Integer.valueOf(i19), Arrays.toString(list.toArray())));
        }
        return i19;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getScaledCoverHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        return (int) (i3 * 0.5653333f);
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getShapeOfBusi(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        if (i3 != 102 && i3 != 105) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int getSubcmdByType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public URL getURL4TroopPhoto(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (URL) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        }
        String scheme = Uri.parse(str).getScheme();
        if (!TextUtils.isEmpty(scheme) && (scheme.equals("http") || scheme.equals("https"))) {
            try {
                return ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).nearbyImgDownloader_convertURL(str);
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.troopinfo", 2, e16.toString());
                }
            }
        } else {
            try {
                return new File(str).toURL();
            } catch (MalformedURLException e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.troopinfo", 2, e17.toString());
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public String getUploadPhotoTempPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (cu.e()) {
            sb5.append(AppConstants.SDCARD_PATH_TROOPPHOTO);
            sb5.append("tmp/");
            sb5.append(System.currentTimeMillis());
            sb5.append("_photo.tmp");
            return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        }
        sb5.append(MobileQQ.sMobileQQ.getBaseContext().getFilesDir());
        sb5.append("/tmp/");
        sb5.append(System.currentTimeMillis());
        sb5.append("_photo.tmp");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public int saveBitmapToFile(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (str == null) {
            return -1;
        }
        File file = new File(str);
        try {
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(file.getPath(), BaseImageUtil.calculateInSampleSize2(file.getPath(), 100));
            File file2 = new File(str2);
            if (file2.exists()) {
                return 0;
            }
            try {
                int readPictureDegree = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).readPictureDegree(str);
                if (readPictureDegree != 0) {
                    decodeFileWithBufferedStream = BaseImageUtil.rotateAndFrame(decodeFileWithBufferedStream, readPictureDegree);
                }
                if (decodeFileWithBufferedStream == null) {
                    return -1;
                }
                BaseImageUtil.saveBitmapToFile(decodeFileWithBufferedStream, file2);
                return 0;
            } catch (IOException e16) {
                e16.printStackTrace();
                return -1;
            }
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public Set<String> setVerifyingAvatarPicId(oidb_0x88d$GroupHeadPortrait oidb_0x88d_groupheadportrait) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Set) iPatchRedirector.redirect((short) 20, (Object) this, (Object) oidb_0x88d_groupheadportrait);
        }
        int i3 = oidb_0x88d_groupheadportrait.uint32_verifying_pic_cnt.get();
        int size = oidb_0x88d_groupheadportrait.rpt_msg_verifyingpic_info.size();
        if (i3 != size && QLog.isColorLevel()) {
            QLog.d(TroopInfo.TAG, 2, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", Integer.valueOf(i3), Integer.valueOf(size)));
        }
        HashSet hashSet = new HashSet();
        Iterator<oidb_0x88d$GroupHeadPortraitInfo> it = oidb_0x88d_groupheadportrait.rpt_msg_verifyingpic_info.get().iterator();
        while (it.hasNext()) {
            hashSet.add(String.valueOf(it.next().rpt_uint32_pic_id.get()));
        }
        return hashSet;
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoEdit(Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            startPhotoEdit(activity, new Intent(), str, i3);
        } else {
            iPatchRedirector.redirect((short) 11, this, activity, str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoEditForResult(Activity activity, Intent intent, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, activity, intent, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Point clipRectSize = getClipRectSize(activity, i3);
        intent.putExtra("Business_Origin", i3);
        intent.putExtra("BUSINESS_ORIGIN_NEW", i3);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
        intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1024);
        intent.putExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, getIsKeepClipInfo(i3));
        intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
        intent.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoEditForResult(intent, activity, activity.getClass().getName(), clipRectSize.x, clipRectSize.y, 640, 640, str, getUploadPhotoTempPath(), i16);
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoList(Activity activity, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, i3);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", i3);
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", z16);
        bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoList(activity, bundle);
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoListEdit(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, i3);
        } else {
            startPhotoListEditWithIntent(activity, new Intent(), i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoListEditForResult(Activity activity, Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, intent, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Point clipRectSize = getClipRectSize(activity, i3);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", i3);
        intent.putExtra("BUSINESS_ORIGIN_NEW", i3);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1024);
        intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
        intent.putExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, getIsKeepClipInfo(i3));
        intent.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoListEditForResult(intent, activity, activity.getClass().getName(), clipRectSize.x, clipRectSize.y, 640, 640, getUploadPhotoTempPath(), i16);
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoListEditWithIntent(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, activity, intent, Integer.valueOf(i3));
            return;
        }
        Point clipRectSize = getClipRectSize(activity, i3);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", i3);
        intent.putExtra("BUSINESS_ORIGIN_NEW", i3);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1024);
        intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
        intent.putExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, getIsKeepClipInfo(i3));
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoListEdit(intent, activity, activity.getClass().getName(), clipRectSize.x, clipRectSize.y, 640, 640, getUploadPhotoTempPath());
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoEdit(Activity activity, Intent intent, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activity, intent, str, Integer.valueOf(i3));
            return;
        }
        Point clipRectSize = getClipRectSize(activity, i3);
        intent.putExtra("Business_Origin", i3);
        intent.putExtra("BUSINESS_ORIGIN_NEW", i3);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
        intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1024);
        intent.putExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, getIsKeepClipInfo(i3));
        intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoEdit(intent, activity, activity.getClass().getName(), clipRectSize.x, clipRectSize.y, 640, 640, str, getUploadPhotoTempPath());
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
    public void startPhotoEditForResult(Activity activity, Intent intent, String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, activity, intent, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Point clipRectSize = getClipRectSize(activity, i3);
        intent.putExtra("Business_Origin", i3);
        intent.putExtra("BUSINESS_ORIGIN_NEW", i3);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
        intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1024);
        intent.putExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, getIsKeepClipInfo(i3));
        intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoEditForResult(intent, activity, activity.getClass().getName(), clipRectSize.x, clipRectSize.y, 640, 640, str, str2, i16);
    }
}
