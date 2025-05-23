package com.tencent.mobileqq.emosm.favroaming;

import android.graphics.BitmapFactory;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f204343a = 16777216;

    /* renamed from: b, reason: collision with root package name */
    public static int f204344b = 10240;

    /* renamed from: c, reason: collision with root package name */
    public static kb1.a f204345c = new kb1.a();

    public static boolean a(String str) {
        try {
        } catch (Exception e16) {
            QLog.e("FavEmoSendControl", 1, "checkPicFavEnable exception, ", e16);
        }
        if (new File(str).length() >= f204343a) {
            return false;
        }
        if (!BaseImageUtil.isGifFile(str)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i16 = f204344b;
            if (i3 < i16) {
                if (options.outHeight >= i16) {
                }
            }
            return false;
        }
        return true;
    }

    public static String b(String str) {
        CompressInfo compressInfo = new CompressInfo(str, 0, -1);
        compressInfo.T = true;
        boolean start = ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        if (QLog.isColorLevel()) {
            QLog.d("FavEmoSendControl", 2, "compressBeforeUpload, success: ", Boolean.valueOf(start));
        }
        if (start) {
            return compressInfo.H;
        }
        return str;
    }

    public static BaseQQAppInterface c() {
        return (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static boolean d() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v22 */
    public static void e(List<String> list) {
        String str;
        Iterator<String> it;
        String str2;
        boolean z16;
        boolean z17;
        Iterator<CustomEmotionData> it5;
        boolean z18;
        ?? r26 = 1;
        QLog.i("FavEmoSendControl", 1, "uploadCameraEmoList");
        BaseQQAppInterface c16 = c();
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) c16.getRuntimeService(IFavroamingDBManagerService.class);
        FavEmoRoamingHandler favEmoRoamingHandler = (FavEmoRoamingHandler) c16.getBusinessHandler(FavEmoRoamingHandler.f194632e);
        String currentUin = c16.getCurrentUin();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it6 = list.iterator();
        ?? r75 = 0;
        int i3 = 0;
        int i16 = 0;
        while (it6.hasNext()) {
            String next = it6.next();
            List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
            Iterator<CustomEmotionData> it7 = emoticonDataList.iterator();
            int i17 = r26;
            while (it7.hasNext()) {
                int i18 = it7.next().emoId;
                if (i17 < i18) {
                    i17 = i18;
                }
            }
            CustomEmotionData customEmotionData = new CustomEmotionData();
            customEmotionData.uin = currentUin;
            customEmotionData.emoId = i17 + 1;
            customEmotionData.emoOriginalPath = next;
            customEmotionData.RomaingType = "needUpload";
            if (!a(next)) {
                Object[] objArr = new Object[2];
                objArr[r75] = "doStep, checkPicFavEnable false, path ";
                objArr[r26] = customEmotionData.emoOriginalPath;
                QLog.e("FavEmoSendControl", (int) r26, objArr);
                customEmotionData.emoPath = next;
                customEmotionData.RomaingType = "failed";
                iFavroamingDBManagerService.insertCustomEmotion(customEmotionData);
                i3++;
                favEmoRoamingHandler.notifyUI(2, r26, null);
                g.a(r75, r26, r75);
                str2 = currentUin;
                z17 = r26;
                it = it6;
            } else {
                String str3 = customEmotionData.emoOriginalPath;
                if (d()) {
                    str3 = b(customEmotionData.emoOriginalPath);
                }
                String fileMd5 = SecUtil.getFileMd5(str3);
                int lastIndexOf = str3.lastIndexOf(".");
                if (lastIndexOf > 0) {
                    str = str3.substring(lastIndexOf);
                } else {
                    str = ".jpg";
                }
                StringBuilder sb5 = new StringBuilder();
                it = it6;
                sb5.append(AppConstants.SDCARD_IMG_FAVORITE);
                sb5.append(DiySecureFileHelper.secureUin(currentUin));
                sb5.append(fileMd5);
                sb5.append(str);
                String sb6 = sb5.toString();
                boolean copyFile = FileUtils.copyFile(str3, sb6);
                str2 = currentUin;
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoSendControl", 2, "doStep, copyFile completed, result:", Boolean.valueOf(copyFile));
                }
                if (!str3.equals(customEmotionData.emoOriginalPath)) {
                    FileUtils.deleteFile(str3);
                }
                Iterator<CustomEmotionData> it8 = emoticonDataList.iterator();
                boolean z19 = false;
                while (true) {
                    if (it8.hasNext()) {
                        CustomEmotionData next2 = it8.next();
                        if (!sb6.equals(next2.emoPath) && !fileMd5.equals(next2.md5)) {
                            it5 = it8;
                            z18 = z19;
                        } else {
                            it5 = it8;
                            z18 = z19;
                            QLog.e("FavEmoSendControl", 1, "doStep fail, duplicate path, path:", next2.emoPath);
                            g.a(false, 2, 0);
                            if ("needDel".equals(next2.RomaingType)) {
                                iFavroamingDBManagerService.updateDeletedEmoticon(next2, emoticonDataList.indexOf(next2));
                                z19 = true;
                                it8 = it5;
                            } else if ("failed".equals(next2.RomaingType)) {
                                iFavroamingDBManagerService.deleteCustomEmotion(next2);
                            } else {
                                i16++;
                                z16 = true;
                                break;
                            }
                        }
                        z19 = z18;
                        it8 = it5;
                    } else {
                        z16 = z19;
                        break;
                    }
                }
                if (!z16) {
                    customEmotionData.md5 = fileMd5;
                    customEmotionData.emoPath = sb6;
                    iFavroamingDBManagerService.insertCustomEmotion(customEmotionData);
                    arrayList.add(customEmotionData);
                    if (list.indexOf(next) % 4 == 3) {
                        z17 = true;
                        favEmoRoamingHandler.notifyUI(2, true, null);
                    } else {
                        z17 = true;
                    }
                    r26 = z17;
                    it6 = it;
                    currentUin = str2;
                    r75 = 0;
                } else {
                    z17 = true;
                }
            }
            r26 = z17;
            it6 = it;
            currentUin = str2;
            r75 = 0;
        }
        boolean z26 = r26;
        if (!arrayList.isEmpty()) {
            favEmoRoamingHandler.notifyUI(2, z26, null);
            QLog.d("FavEmoSendControl", z26 ? 1 : 0, "doStep, insert completed");
            Object[] objArr2 = new Object[4];
            objArr2[0] = arrayList;
            objArr2[z26 ? 1 : 0] = Integer.valueOf(list.size());
            objArr2[2] = Integer.valueOf(i3);
            objArr2[3] = Integer.valueOf(i16);
            f204345c.b(String.valueOf(1000), objArr2);
            return;
        }
        new CameraEmoAllSend().p(list.size(), 0, 0, i3, i16);
    }
}
