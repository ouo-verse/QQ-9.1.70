package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarCompatibleServiceImpl implements IQQAvatarCompatibleService {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_TRY_COUNT = 3;
    public static final String QQ_HEAD_QAIF = "Q.qqhead.qaif";
    private Object faceDecodeFailMapLock;
    private AppInterface mApp;
    private HashMap<String, Integer> mFaceDecodeFailMap;

    public QQAvatarCompatibleServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.faceDecodeFailMapLock = new Object();
        }
    }

    private void freePartBitmapCache() {
        ImageCacheHelper.f98636a.e();
    }

    private void getBitmapFromNet(int i3, String str, byte b16, boolean z16, int i16, Bitmap bitmap, boolean z17, boolean z18, int i17, FaceInfo faceInfo) {
        boolean z19;
        boolean z26;
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getBitmapFromNet: ");
            if (bitmap == null) {
                z26 = true;
            } else {
                z26 = false;
            }
            sb5.append(z26);
            sb5.append(",");
            sb5.append(z16);
            sb5.append(",");
            sb5.append(z18);
            sb5.append(", needCheckQQHead: ");
            sb5.append(z17);
            QLog.d("Q.qqhead.qaif", 4, sb5.toString());
        }
        if (bitmap == null && z16 && !z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        if ((z19 || z17) && faceInfo != null && faceInfo.isRealLoadZplanStaticAvatar()) {
            if (((QQAvatarDataServiceImpl) this.mApp.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(i3, str, i16).second != null) {
                IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) this.mApp.getRuntimeService(IQQAvatarManagerService.class, "");
                if (iQQAvatarManagerService != null) {
                    iQQAvatarManagerService.downloadFace(faceInfo);
                    QLog.i("Q.qqhead.qaif", 1, "getBitmapFromNet download use setting");
                    return;
                }
            } else {
                QLog.e("Q.qqhead.qaif", 1, "getBitmapFromNet setting is null");
            }
        }
        if (z19 || z17) {
            byte b17 = 2;
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.QQ_HEAD, 2, "getFaceBitmap needUpdate, faceType=" + i3 + ", uin=" + str + ", shape=" + ((int) b16));
            }
            if (z18) {
                b17 = 1;
            }
            IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
            if (i3 != 1) {
                if (i3 != 4) {
                    if (i3 != 11) {
                        if (i3 != 16) {
                            if (i3 != 32) {
                                if (i3 != 115) {
                                    if (i3 == 116) {
                                        iQQAvatarHandlerService.getApolloHead(str, (byte) 1, b17, i17);
                                        return;
                                    }
                                    return;
                                }
                                iQQAvatarHandlerService.getCustomHead(str, (byte) 1, b17);
                                return;
                            }
                            iQQAvatarHandlerService.getStrangerHead(str, i16, (byte) 1, b17);
                            return;
                        }
                        iQQAvatarHandlerService.getQCallHead(str, i16, (byte) 1, b17);
                        return;
                    }
                    iQQAvatarHandlerService.getMobileQQHead(str, b17);
                    return;
                }
                iQQAvatarHandlerService.getTroopHead(str, b17);
                return;
            }
            if (faceInfo != null && faceInfo.isRealLoadZplanStaticAvatar()) {
                iQQAvatarHandlerService.getCustomHead(faceInfo);
            } else {
                iQQAvatarHandlerService.getCustomHead(str, (byte) 0, b17);
            }
        }
    }

    private boolean isGetFaceBitmapParamInValid(int i3, String str) {
        if ((i3 == 11 && !StringUtil.isValidMobileNumForHead(str)) || TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    private boolean isSpecialFaceType(int i3, String str) {
        if (i3 == 1 && str != null && (str.equals(AppConstants.QQBROADCAST_MSG_UIN) || str.equals(AppConstants.LBS_HELLO_UIN) || str.equals(AppConstants.VOTE_MSG_UIN) || str.equals(AppConstants.SYSTEM_MSG_UIN))) {
            return true;
        }
        return false;
    }

    private Bitmap realGetFaceBitmap(int i3, String str, byte b16, int i16, boolean z16, byte b17, int i17, @Nullable FaceInfo faceInfo) {
        boolean z17;
        Bitmap bitmap;
        boolean z18;
        boolean z19;
        boolean z26;
        byte b18;
        boolean z27;
        String str2;
        QQAvatarDataServiceImpl qQAvatarDataServiceImpl = (QQAvatarDataServiceImpl) this.mApp.getRuntimeService(IQQAvatarDataService.class, "");
        int i18 = 0;
        if (faceInfo == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        String faceBitmapCacheKey = qQAvatarDataServiceImpl.getFaceBitmapCacheKey(i3, str, b16, i17, i16, z17, faceInfo);
        Bitmap bitmapFromCache = qQAvatarDataServiceImpl.getBitmapFromCache(faceBitmapCacheKey);
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.qqhead.qaif", 4, "realGetFaceBitmap faceKey:" + faceBitmapCacheKey + " getBitmapFromCache:" + bitmapFromCache);
        }
        if (bitmapFromCache == null) {
            if (!z16 && i3 != 116) {
                z26 = false;
                b18 = 0;
            } else {
                Pair<Boolean, Setting> qQHeadSetting = qQAvatarDataServiceImpl.getQQHeadSetting(i3, str, i17);
                boolean booleanValue = ((Boolean) qQHeadSetting.first).booleanValue();
                Object obj = qQHeadSetting.second;
                if (obj != null) {
                    b18 = ((Setting) obj).bHeadType;
                    z26 = booleanValue;
                } else {
                    z26 = booleanValue;
                    b18 = 0;
                }
            }
            String customFaceFilePath = qQAvatarDataServiceImpl.getCustomFaceFilePath(null, i3, str, i17, i16, faceInfo);
            com.tencent.mobileqq.avatar.utils.c.r(customFaceFilePath);
            j.a decodeFace = decodeFace(customFaceFilePath);
            if (decodeFace.f306779b != 0) {
                QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + i3 + ", uin=" + str + ", result=" + decodeFace.f306779b + ", facePath=" + customFaceFilePath);
            }
            if (!z26 && decodeFace.f306779b == 1) {
                QLog.e("Q.qqhead.qaif", 1, "realGetFaceBitmap notNeedCheckQQHead android decode oom");
                return null;
            }
            int i19 = decodeFace.f306779b;
            if (i19 != 2) {
                z27 = true;
            } else {
                z27 = false;
            }
            Bitmap bitmap2 = decodeFace.f306778a;
            if (bitmap2 == null && i19 != 1 && z27) {
                if (i3 == 4) {
                    str2 = "troop_" + str;
                } else {
                    str2 = str;
                }
                synchronized (this.faceDecodeFailMapLock) {
                    if (this.mFaceDecodeFailMap == null) {
                        this.mFaceDecodeFailMap = new HashMap<>();
                    }
                    Integer num = this.mFaceDecodeFailMap.get(str2);
                    if (num != null) {
                        i18 = num.intValue();
                    }
                    QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + str2 + ", nDecodeFailCount = " + i18);
                    if (i18 < 3) {
                        int i26 = i18 + 1;
                        this.mFaceDecodeFailMap.put(str2, Integer.valueOf(i26));
                        FileUtils.deleteFile(customFaceFilePath);
                        QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + str2 + ", del the damaged file,nDecodeFailCount=" + i26);
                    }
                }
            }
            bitmap = qQAvatarDataServiceImpl.putSdcardBitmapToCache(i3, str, b16, faceBitmapCacheKey, bitmap2, customFaceFilePath, decodeFace, b18, faceInfo);
            z18 = z26;
            z19 = z27;
        } else {
            bitmap = bitmapFromCache;
            z18 = false;
            z19 = false;
        }
        getBitmapFromNet(i3, str, b16, z16, i17, bitmap, z18, z19, i16, faceInfo);
        return bitmap;
    }

    @NonNull
    public j.a decodeFace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j.a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
        j.a aVar = new j.a();
        int i3 = 0;
        do {
            j.e(str, options, aVar);
            if (aVar.f306779b == 1) {
                freePartBitmapCache();
            }
            i3++;
            if (i3 >= 2) {
                break;
            }
        } while (aVar.f306779b == 1);
        return aVar;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService
    public Bitmap getFaceBitmap(int i3, String str, byte b16, int i16, boolean z16, byte b17, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getFaceBitmap(i3, str, b16, i16, z16, b17, i17, null) : (Bitmap) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z16), Byte.valueOf(b17), Integer.valueOf(i17));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (AppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService
    public Bitmap getFaceBitmap(int i3, String str, byte b16, int i16, boolean z16, byte b17, int i17, @Nullable FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z16), Byte.valueOf(b17), Integer.valueOf(i17), faceInfo);
        }
        if (isSpecialFaceType(i3, str)) {
            return BaseImageUtil.getDefaultSystemIconBitmap();
        }
        if (i3 == 32 && AppConstants.LBS_HELLO_UIN.equals(str)) {
            return cn.d(BaseApplication.getContext().getResources().getDrawable(R.drawable.f160867mz2));
        }
        if (isGetFaceBitmapParamInValid(i3, str)) {
            return null;
        }
        byte b18 = (i3 == 101 || i3 == 1001) ? (byte) 3 : b16;
        int i18 = (i3 != 4 || ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(str)) ? i3 : 113;
        byte a16 = com.tencent.mobileqq.avatar.utils.c.a(i18 != 113 ? b18 : (byte) 3);
        if (AvatarOptimiseConfigUtil.b()) {
            return b.b(i18, str, a16, i16);
        }
        return realGetFaceBitmap(i18, str, a16, i16, z16, b17, i17, faceInfo);
    }
}
