package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emoticonview.LooperGifImage;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class au {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f195283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f195284b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CustomEmotionData f195285c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f195286d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f195287e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IFavroamingDBManagerService f195288f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ IPicDownloadListener f195289g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f195290h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f195291i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Context f195292j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f195293k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f195294l;

        a(String str, File file, CustomEmotionData customEmotionData, boolean z16, boolean z17, IFavroamingDBManagerService iFavroamingDBManagerService, IPicDownloadListener iPicDownloadListener, List list, List list2, Context context, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
            this.f195283a = str;
            this.f195284b = file;
            this.f195285c = customEmotionData;
            this.f195286d = z16;
            this.f195287e = z17;
            this.f195288f = iFavroamingDBManagerService;
            this.f195289g = iPicDownloadListener;
            this.f195290h = list;
            this.f195291i = list2;
            this.f195292j = context;
            this.f195293k = atomicInteger;
            this.f195294l = atomicInteger2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, str, file, customEmotionData, Boolean.valueOf(z16), Boolean.valueOf(z17), iFavroamingDBManagerService, iPicDownloadListener, list, list2, context, atomicInteger, atomicInteger2);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
            } else {
                super.onDone(gVar);
                au.e(gVar, this.f195283a, this.f195284b, this.f195285c, this.f195286d, this.f195287e, this.f195288f, this.f195289g, this.f195290h, this.f195291i, this.f195292j, this.f195293k, this.f195294l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private IVipComicMqqManagerService f195295a;

        /* renamed from: b, reason: collision with root package name */
        private CustomEmotionData f195296b;

        /* renamed from: c, reason: collision with root package name */
        private String f195297c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f195298d;

        public b(IVipComicMqqManagerService iVipComicMqqManagerService, CustomEmotionData customEmotionData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVipComicMqqManagerService, (Object) customEmotionData);
            } else {
                this.f195295a = iVipComicMqqManagerService;
                this.f195296b = customEmotionData;
            }
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f195297c;
        }

        public b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            String str = AppConstants.SDCARD_IMG_FAVORITE;
            this.f195297c = str;
            this.f195298d = false;
            IVipComicMqqManagerService iVipComicMqqManagerService = this.f195295a;
            if (iVipComicMqqManagerService != null && iVipComicMqqManagerService.isComicEmoticon(this.f195296b)) {
                if (!TextUtils.isEmpty(this.f195296b.emoPath) && this.f195296b.emoPath.startsWith(str)) {
                    this.f195297c = this.f195296b.emoPath;
                } else if (!TextUtils.isEmpty(this.f195296b.md5)) {
                    this.f195297c = this.f195295a.getFilePath(this.f195296b.md5);
                } else if (!TextUtils.isEmpty(this.f195296b.resid)) {
                    this.f195297c += DiySecureFileHelper.secureUin(this.f195296b.resid);
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f195297c);
                    String str2 = this.f195296b.url;
                    sb5.append(str2.substring(str2.lastIndexOf("/") + 1));
                    this.f195297c = sb5.toString();
                }
            } else if (this.f195296b.url.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX)) {
                this.f195297c += FunnyPicHelperConstant.getFunnyPicName(this.f195296b.url);
            } else if (!TextUtils.isEmpty(FunnyPicHelperConstant.getFunnyPicName(this.f195296b.eId))) {
                this.f195297c += this.f195296b.eId;
                this.f195298d = true;
                if (QLog.isColorLevel()) {
                    QLog.d("FunyPicHelper", 2, "emotion is FunnyPic path download from server->" + this.f195296b.eId);
                }
            } else {
                this.f195297c += this.f195296b.resid;
            }
            return this;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f195298d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c extends AbsDownloader {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
        public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
            }
            Header header = downloadParams.getHeader(FunnyPicHelperConstant.FUNNYPIC_TYPE);
            if (header != null) {
                String value = header.getValue();
                float f16 = downloadParams.mGifRoundCorner;
                if (!TextUtils.isEmpty(value) && Integer.valueOf(value).intValue() == 2) {
                    return new LooperGifImage(file, true, f16, 3);
                }
                return null;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.transfile.AbsDownloader
        public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
            }
            Object obj = downloadParams.tag;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                File file = new File(AppConstants.SDCARD_IMG_FAVORITE + Utils.Crc64String(str));
                if (file.exists()) {
                    return file;
                }
                if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new com.tencent.mobileqq.vip.g(str, file), MobileQQ.sMobileQQ.waitAppRuntime(null)) == 0) {
                    return file;
                }
            }
            return null;
        }
    }

    private static void b(boolean z16, Context context, IPicDownloadListener iPicDownloadListener, com.tencent.mobileqq.vip.h hVar, IFavroamingDBManagerService iFavroamingDBManagerService, IVipComicMqqManagerService iVipComicMqqManagerService, List<CustomEmotionData> list, List<CustomEmotionData> list2, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, CustomEmotionData customEmotionData) {
        String str;
        String str2;
        if (!TextUtils.isEmpty(customEmotionData.url)) {
            if (hVar.getTask(customEmotionData.url) != null) {
                atomicInteger.decrementAndGet();
                return;
            }
            b b16 = new b(iVipComicMqqManagerService, customEmotionData).b();
            String a16 = b16.a();
            boolean c16 = b16.c();
            File file = new File(a16);
            if (file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("FunyPicHelper", 2, "download path is exsit->" + a16);
                }
                atomicInteger.decrementAndGet();
                customEmotionData.emoPath = file.getAbsolutePath();
                if (FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType)) {
                    customEmotionData.RomaingType = "isUpdate";
                }
                if (c16) {
                    customEmotionData.eId = "";
                }
                if (TextUtils.isEmpty(customEmotionData.md5) && !TextUtils.isEmpty(customEmotionData.emoPath)) {
                    customEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(customEmotionData.emoPath));
                }
                if (z16) {
                    iFavroamingDBManagerService.updateCustomEmotion(customEmotionData);
                }
                if (iPicDownloadListener != null) {
                    iPicDownloadListener.onFileDone(customEmotionData, true);
                }
                list.add(customEmotionData);
                if (QLog.isColorLevel()) {
                    QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + customEmotionData.eId + " emoPath->" + customEmotionData.emoPath + " download->sucess");
                }
            } else {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(customEmotionData.url, file);
                gVar.U = false;
                gVar.S = EmotionConstants.PROTOCOL_EMOTION_PIC;
                gVar.f313008f = 1;
                if (!customEmotionData.url.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX)) {
                    str2 = "";
                } else {
                    String funnyPicName = FunnyPicHelperConstant.getFunnyPicName(customEmotionData.url);
                    if (!TextUtils.isEmpty(funnyPicName) && funnyPicName.length() > 12) {
                        funnyPicName = funnyPicName.substring(0, 12);
                        FunnyPicHelperConstant.sloadingFunnyPics.add(funnyPicName);
                    }
                    str2 = funnyPicName;
                }
                hVar.startDownload(gVar, new a(str2, file, customEmotionData, c16, z16, iFavroamingDBManagerService, iPicDownloadListener, list, list2, context, atomicInteger2, atomicInteger), null);
            }
            if (atomicInteger.get() == 0 && iPicDownloadListener != null) {
                iPicDownloadListener.onDone(list, list2);
                return;
            }
            return;
        }
        if (iPicDownloadListener != null) {
            iPicDownloadListener.onFileDone(customEmotionData, false);
        }
        if (TextUtils.isEmpty(customEmotionData.RomaingType)) {
            str = "null";
        } else {
            str = customEmotionData.RomaingType;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FunyPicHelper", 2, "checkLoadEmotionPic, url is null : " + customEmotionData.resid + ", romaingType:" + str);
        }
    }

    public static void d(boolean z16, Context context, List<CustomEmotionData> list, AppInterface appInterface, IPicDownloadListener iPicDownloadListener) {
        if (context != null && appInterface != null && list != null && !list.isEmpty()) {
            if (NetworkUtil.isNetworkAvailable(context)) {
                com.tencent.mobileqq.vip.h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
                if (downloader == null) {
                    return;
                }
                IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) appInterface.getRuntimeService(IFavroamingDBManagerService.class, "");
                IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) appInterface.getRuntimeService(IVipComicMqqManagerService.class, "");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(list.size());
                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                Iterator<CustomEmotionData> it = list.iterator();
                while (it.hasNext()) {
                    b(z16, context, iPicDownloadListener, downloader, iFavroamingDBManagerService, iVipComicMqqManagerService, arrayList, arrayList2, atomicInteger, atomicInteger2, it.next());
                    atomicInteger = atomicInteger;
                }
                return;
            }
            if (iPicDownloadListener != null) {
                iPicDownloadListener.onDone(new ArrayList(), list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(com.tencent.mobileqq.vip.g gVar, String str, File file, CustomEmotionData customEmotionData, boolean z16, boolean z17, IFavroamingDBManagerService iFavroamingDBManagerService, IPicDownloadListener iPicDownloadListener, List<CustomEmotionData> list, List<CustomEmotionData> list2, Context context, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        FunnyPicHelperConstant.sloadingFunnyPics.remove(str);
        if (3 == gVar.i() && file.exists()) {
            customEmotionData.emoPath = file.getAbsolutePath();
            if (FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType)) {
                customEmotionData.RomaingType = "isUpdate";
            }
            if (z16) {
                customEmotionData.eId = "";
            }
            if (TextUtils.isEmpty(customEmotionData.md5) && !TextUtils.isEmpty(customEmotionData.emoPath)) {
                customEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(customEmotionData.emoPath));
            }
            if (z17) {
                iFavroamingDBManagerService.updateCustomEmotion(customEmotionData);
            }
            if (iPicDownloadListener != null) {
                iPicDownloadListener.onFileDone(customEmotionData, true);
            }
            list.add(customEmotionData);
            if (QLog.isColorLevel()) {
                QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + customEmotionData.eId + " emoPath->" + customEmotionData.emoPath + " download->sucess");
            }
        } else {
            list2.add(customEmotionData);
            if (iPicDownloadListener != null) {
                iPicDownloadListener.onFileDone(customEmotionData, false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + customEmotionData.eId + " emoPath->" + customEmotionData.emoPath + " download->faile");
            }
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACTION_FAV, "3", "", "", NetworkUtil.getNetworkType(context) + "", gVar.f313006d + "", "", "", "");
        }
        atomicInteger.getAndIncrement();
        if (atomicInteger.get() != atomicInteger2.get() || iPicDownloadListener == null) {
            return;
        }
        iPicDownloadListener.onDone(list, list2);
    }

    public static int f(String str) {
        String str2;
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(FunnyPicHelperConstant.FUNYPIC_PREFIX)) >= 0) {
            str2 = str.substring(lastIndexOf + 4, str.length());
        } else {
            str2 = "0";
        }
        try {
            return Integer.parseInt(str2);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FunyPicHelper", 2, e16.getMessage());
            }
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(AppInterface appInterface) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3;
        if (appInterface == null) {
            return;
        }
        String readFileContent = FileUtils.readFileContent(new File(appInterface.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.sFunnyPicTask.jsonName));
        String str4 = "";
        int i3 = 1;
        if (!TextUtils.isEmpty(readFileContent)) {
            try {
                jSONObject = new JSONObject(readFileContent);
            } catch (Exception e16) {
                e = e16;
                str = "";
            }
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("releaseZipInfo")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("releaseZipInfo");
                    if (jSONArray.length() > 0) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                        if (!jSONObject3.has("zipID")) {
                            str3 = "";
                        } else {
                            str3 = jSONObject3.getString("zipID");
                        }
                        try {
                            if (jSONObject3.has("img")) {
                                str4 = jSONObject3.getString("img");
                            }
                            if (jSONObject3.has("type")) {
                                i3 = jSONObject3.getInt("type");
                            }
                            str2 = str4;
                            str4 = str3;
                        } catch (Exception e17) {
                            e = e17;
                            str = str4;
                            str4 = str3;
                            if (QLog.isColorLevel()) {
                                QLog.d("FunyPicHelper", 2, e.getMessage());
                            }
                            str2 = str;
                            SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(FunnyPicHelperConstant.SP_FUNNY_PIC_INFO, 0);
                            if (!TextUtils.isEmpty(str4)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            sharedPreferences.edit().putInt(FunnyPicHelperConstant.FUNNYPIC_TYPE_SP_KEY, i3).commit();
                            if (QLog.isColorLevel()) {
                            }
                        }
                        SharedPreferences sharedPreferences2 = appInterface.getApp().getSharedPreferences(FunnyPicHelperConstant.SP_FUNNY_PIC_INFO, 0);
                        if (!TextUtils.isEmpty(str4)) {
                            sharedPreferences2.edit().putString(FunnyPicHelperConstant.FUNNYPIC_COUNT_SP_KEY, str4).commit();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sharedPreferences2.edit().putString(FunnyPicHelperConstant.FUNNYPIC_NAME_SP_KEY, str2).commit();
                        }
                        sharedPreferences2.edit().putInt(FunnyPicHelperConstant.FUNNYPIC_TYPE_SP_KEY, i3).commit();
                        if (QLog.isColorLevel()) {
                            QLog.d("FunyPicHelper", 2, "funnypic zipID->" + str4 + ";imgName -> " + str2 + ";type -> " + i3);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        str2 = "";
        SharedPreferences sharedPreferences22 = appInterface.getApp().getSharedPreferences(FunnyPicHelperConstant.SP_FUNNY_PIC_INFO, 0);
        if (!TextUtils.isEmpty(str4)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        sharedPreferences22.edit().putInt(FunnyPicHelperConstant.FUNNYPIC_TYPE_SP_KEY, i3).commit();
        if (QLog.isColorLevel()) {
        }
    }

    public static void c(Context context, List<CustomEmotionData> list, AppInterface appInterface, IPicDownloadListener iPicDownloadListener) {
    }
}
