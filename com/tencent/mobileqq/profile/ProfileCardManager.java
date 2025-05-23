package com.tencent.mobileqq.profile;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x703.cmd0x703$PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703$UinPhotoListInfo;

/* loaded from: classes16.dex */
public class ProfileCardManager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static Map<Long, Boolean> f259993h;

    /* renamed from: i, reason: collision with root package name */
    public static Map<Long, Boolean> f259994i;

    /* renamed from: j, reason: collision with root package name */
    public static String f259995j;

    /* renamed from: a, reason: collision with root package name */
    Map<Long, Integer> f259996a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, Boolean> f259997b;

    /* renamed from: c, reason: collision with root package name */
    protected AppInterface f259998c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f259999d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f260000e;

    /* renamed from: f, reason: collision with root package name */
    public Vector<Integer> f260001f;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, a> f260002g;

    /* loaded from: classes16.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f260008a;

        /* renamed from: b, reason: collision with root package name */
        public String f260009b;

        /* renamed from: c, reason: collision with root package name */
        public String f260010c;

        /* renamed from: d, reason: collision with root package name */
        public String f260011d;

        /* renamed from: e, reason: collision with root package name */
        public String f260012e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f260013f;

        public a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardManager.this, i3);
                return;
            }
            this.f260008a = i3;
            this.f260009b = "";
            this.f260013f = false;
        }
    }

    /* loaded from: classes16.dex */
    private static class b implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f260015a;

        /* renamed from: b, reason: collision with root package name */
        private final String f260016b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<ProfileCardManager> f260017c;

        public b(int i3, String str, ProfileCardManager profileCardManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, profileCardManager);
                return;
            }
            this.f260015a = i3;
            this.f260016b = str;
            this.f260017c = new WeakReference<>(profileCardManager);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            ProfileCardManager profileCardManager = this.f260017c.get();
            if (profileCardManager != null) {
                profileCardManager.i(this.f260015a, updateListenerParams, this.f260016b);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            ProfileCardManager profileCardManager = this.f260017c.get();
            if (profileCardManager != null) {
                profileCardManager.i(this.f260015a, updateListenerParams, this.f260016b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class c implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ProfileCardManager> f260018a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<CallBacker> f260019b;

        /* renamed from: c, reason: collision with root package name */
        private final String f260020c;

        public c(String str, ProfileCardManager profileCardManager, CallBacker callBacker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, profileCardManager, callBacker);
                return;
            }
            this.f260020c = str;
            this.f260018a = new WeakReference<>(profileCardManager);
            this.f260019b = new WeakReference<>(callBacker);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            ProfileCardManager profileCardManager = this.f260018a.get();
            if (profileCardManager != null) {
                profileCardManager.l(updateListenerParams, this.f260020c);
                profileCardManager.f(updateListenerParams, this.f260019b.get());
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            ProfileCardManager profileCardManager = this.f260018a.get();
            if (profileCardManager != null) {
                profileCardManager.m(updateListenerParams, this.f260020c, ProfileCardManager.s());
                profileCardManager.f(updateListenerParams, this.f260019b.get());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73772);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f259993h = new ConcurrentHashMap();
        f259994i = new ConcurrentHashMap();
        f259995j = "https://gxh.vip.qq.com/xydata";
    }

    public ProfileCardManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f259996a = new ConcurrentHashMap();
        this.f259997b = new ConcurrentHashMap();
        this.f260001f = new Vector<>();
        this.f260002g = new ConcurrentHashMap();
        this.f259998c = appInterface;
        this.f259999d = appInterface.getApp().getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(@NonNull UpdateListenerParams updateListenerParams, @Nullable CallBacker callBacker) {
        if (callBacker != null) {
            BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
            callBacker.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, @NonNull UpdateListenerParams updateListenerParams, String str) {
        this.f260001f.remove(Integer.valueOf(i3));
        if (updateListenerParams.mErrorCode == 0) {
            q(i3, false);
            return;
        }
        QLog.e("ProfileCardManager", 2, "onCompleted: default card download error: " + updateListenerParams.mErrorCode + " scid=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@NonNull UpdateListenerParams updateListenerParams, String str) {
        this.f259997b.put(str, Boolean.FALSE);
        QLog.w("ProfileCardManager", 1, "ProfileCardManager download failed code:" + updateListenerParams.mErrorCode + " msg:" + updateListenerParams.mErrorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@NonNull UpdateListenerParams updateListenerParams, String str, QQVasUpdateBusiness<?> qQVasUpdateBusiness) {
        long parseLong = Long.parseLong(str.substring(5, str.length()));
        Map<Long, Boolean> map = f259993h;
        Long valueOf = Long.valueOf(parseLong);
        Boolean bool = Boolean.TRUE;
        map.put(valueOf, bool);
        f259994i.put(Long.valueOf(parseLong), bool);
        this.f259997b.put(str, Boolean.FALSE);
        String str2 = qQVasUpdateBusiness.getSavePath(updateListenerParams.mBusinessUpdateParams.mScid) + File.separator;
        try {
            File file = new File(str2, "dynamic.zip");
            if (file.exists()) {
                FileUtils.uncompressZip(file.getAbsolutePath(), str2 + ".dynamic", false);
                VasUpdateUtil.safeDeleteFile(file);
            }
            File file2 = new File(str2, "extra_pag.zip");
            if (file2.exists()) {
                FileUtils.uncompressZip(file2.getAbsolutePath(), str2 + ".extra", false);
                VasUpdateUtil.safeDeleteFile(file2);
            }
        } catch (OutOfMemoryError e16) {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + str2, e16);
        } catch (Throwable th5) {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + str2, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCardManager", 1, "onDownloadComplete, resDir= " + str2);
        }
    }

    public static String n(Context context, long j3, long j16) {
        String t16 = t(context, j16);
        if (!VasProfileTemplateController.DELETE_WZRY) {
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
                return t16 + "wzBgImage.png";
            }
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
                return t16 + "wzJoinImage.png";
            }
            return t16 + "cardPreview.jpg";
        }
        if (new File(t16 + "cardPreview.jpg").exists()) {
            return t16 + "cardPreview.jpg";
        }
        if (new File(t16 + "wzJoinImage.png").exists()) {
            return t16 + "wzJoinImage.png";
        }
        if (new File(t16 + "wzBgImage.png").exists()) {
            return t16 + "wzBgImage.png";
        }
        return t16 + "cardPreview.jpg";
    }

    public static byte[] o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        cmd0x703$UinPhotoListInfo cmd0x703_uinphotolistinfo = new cmd0x703$UinPhotoListInfo();
        cmd0x703$PhotoInfo cmd0x703_photoinfo = new cmd0x703$PhotoInfo();
        cmd0x703_photoinfo.str_url.set(str);
        cmd0x703_photoinfo.uint32_id.set(-1);
        cmd0x703_photoinfo.uint32_timestamp.set(0);
        cmd0x703_uinphotolistinfo.rpt_msg_photo_info.add(cmd0x703_photoinfo);
        return cmd0x703_uinphotolistinfo.toByteArray();
    }

    public static String p(String str) {
        String str2 = VasUpdateConstants.SCID_DEFAULT_CARD_CFG_PREFIX + str;
        QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(33L);
        if (newBusiness != null) {
            return newBusiness.getBusinessItemInfo(newBusiness.getBid(), str2).mSavePath;
        }
        return AppConstants.PROFILE_CARD_BACKGROUND_DIR + "defaultCard" + File.separator + str + Sticker.JSON_SUFFIX;
    }

    public static String r(Context context, long j3, long j16) {
        if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
            return t(context, j16) + "wzDynamicDrawerImage.png";
        }
        if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
            return t(context, j16) + "wzJoinImage.png";
        }
        return t(context, j16) + "cardPreview.jpg";
    }

    public static QQVasUpdateBusiness<?> s() {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(15L).booleanValue()) {
            try {
                return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 15L);
            } catch (Exception e16) {
                QLog.i("ProfileCardManager", 1, "getNewBusiness", e16);
            }
        }
        return null;
    }

    public static String t(Context context, long j3) {
        QQVasUpdateBusiness<?> s16 = s();
        if (s16 != null) {
            return s16.getSavePath(VasUpdateConstants.SCID_CARD_PREFIX + j3) + File.separator;
        }
        return ProfileCardTemplateUtil.d() + j3 + File.separator;
    }

    @Deprecated
    public static String u(Context context, long j3) {
        return ProfileCardTemplateUtil.d() + j3 + ".zip";
    }

    public static boolean v(Context context, long j3) {
        File file;
        String t16 = t(context, j3);
        if (TextUtils.isEmpty(t16)) {
            file = null;
        } else {
            file = new File(t16);
        }
        if (file != null && file.exists() && file.isDirectory() && file.list().length > 1) {
            return true;
        }
        return false;
    }

    public static boolean w(Context context, long j3, String str) {
        File file = new File(t(context, j3), str);
        if (file.exists() && (!file.isDirectory() || file.list().length > 1)) {
            return true;
        }
        return false;
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        ((IVasQuickUpdateService) this.f259998c.getRuntimeService(IVasQuickUpdateService.class, "")).cancelDwonloadItem(15L, VasUpdateConstants.SCID_CARD_PREFIX + j3);
    }

    public boolean h(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(j3))).booleanValue();
        }
        return VasUpdateUtil.safeDeleteFile(new File(t(context, j3)));
    }

    public void j(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface, (Object) str);
        } else {
            k(qQAppInterface, str, null);
        }
    }

    public void k(QQAppInterface qQAppInterface, String str, @Nullable CallBacker callBacker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, str, callBacker);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardManager", 2, "downloadProfileCardRes scid=" + str);
        }
        QQVasUpdateBusiness<?> s16 = s();
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
        if (s16 == null && callBacker != null) {
            iVasQuickUpdateService.addCallBacker(callBacker);
        }
        if (this.f259997b.containsKey(str) && this.f259997b.get(str).booleanValue()) {
            return;
        }
        this.f259997b.put(str, Boolean.TRUE);
        if (s16 != null) {
            s16.addDownLoadListener(str, new c(str, this, callBacker));
            s16.startDownload(str);
        } else {
            iVasQuickUpdateService.downloadItem(15L, str, "ProfileCardRes");
        }
    }

    public synchronized a q(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        a aVar = this.f260002g.get(Integer.valueOf(i3));
        if (aVar == null) {
            aVar = new a(i3);
            this.f260002g.put(Integer.valueOf(i3), aVar);
        }
        if (!aVar.f260013f) {
            File file = new File(p(Integer.toString(i3)));
            if (file.exists()) {
                ThreadManagerV2.excute(new Runnable(file, i3) { // from class: com.tencent.mobileqq.profile.ProfileCardManager.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ File f260003d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f260004e;

                    {
                        this.f260003d = file;
                        this.f260004e = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ProfileCardManager.this, file, Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        String readFileToStringEx = FileUtils.readFileToStringEx(this.f260003d, -1);
                        if (!TextUtils.isEmpty(readFileToStringEx)) {
                            try {
                                JSONArray optJSONArray = new JSONObject(readFileToStringEx).optJSONArray("baseInfo");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    JSONObject jSONObject = optJSONArray.getJSONObject(0);
                                    a aVar2 = new a(this.f260004e);
                                    aVar2.f260009b = jSONObject.optString("name");
                                    JSONObject optJSONObject = jSONObject.optJSONObject("previewImage");
                                    if (optJSONObject != null) {
                                        aVar2.f260010c = ProfileCardManager.f259995j + optJSONObject.optString("src");
                                    }
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
                                    if (optJSONObject2 != null) {
                                        aVar2.f260011d = ProfileCardManager.f259995j + optJSONObject2.optString("src");
                                    }
                                    JSONObject optJSONObject3 = jSONObject.optJSONObject("detailImage");
                                    if (optJSONObject3 != null) {
                                        aVar2.f260012e = ProfileCardManager.f259995j + optJSONObject3.optString("src");
                                    }
                                    aVar2.f260013f = true;
                                    ProfileCardManager.this.f260002g.put(Integer.valueOf(this.f260004e), aVar2);
                                    Handler handler = ProfileCardManager.this.f260000e;
                                    if (handler != null) {
                                        handler.removeMessages(101);
                                        ProfileCardManager.this.f260000e.sendEmptyMessageDelayed(101, 100L);
                                    }
                                }
                            } catch (Exception e16) {
                                QLog.e("ProfileCardManager", 2, "getDefaultCardItem: ", e16);
                            }
                        }
                    }
                }, 64, null, true);
            } else if (z16 && this.f259998c != null && !this.f260001f.contains(Integer.valueOf(i3))) {
                this.f260001f.add(Integer.valueOf(i3));
                String str = VasUpdateConstants.SCID_DEFAULT_CARD_CFG_PREFIX + i3;
                QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(33L);
                if (newBusiness != null) {
                    ThreadManagerV2.excute(new Runnable(i3, str, newBusiness) { // from class: com.tencent.mobileqq.profile.ProfileCardManager.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f260005d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f260006e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ QQVasUpdateBusiness f260007f;

                        {
                            this.f260005d = i3;
                            this.f260006e = str;
                            this.f260007f = newBusiness;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ProfileCardManager.this, Integer.valueOf(i3), str, newBusiness);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            this.f260007f.addDownLoadListener(this.f260006e, new b(this.f260005d, this.f260006e, ProfileCardManager.this));
                            this.f260007f.startDownload(this.f260006e);
                        }
                    }, 16, null, false);
                } else {
                    ((IVasQuickUpdateService) this.f259998c.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(33L, str, "ProfileCardRes");
                }
            }
        }
        return aVar;
    }

    public void x(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, str2, Integer.valueOf(i3));
            return;
        }
        this.f259997b.put(str, Boolean.FALSE);
        if (i3 == 0) {
            long parseLong = Long.parseLong(str.substring(5, str.length()));
            Map<Long, Boolean> map = f259993h;
            Long valueOf = Long.valueOf(parseLong);
            Boolean bool = Boolean.TRUE;
            map.put(valueOf, bool);
            f259994i.put(Long.valueOf(parseLong), bool);
            String t16 = t(qQAppInterface.getApp(), parseLong);
            File file = new File(u(qQAppInterface.getApp(), parseLong));
            if (!file.exists()) {
                QLog.e("ProfileCardManager", 1, "unzip file is missing " + file.getAbsolutePath());
                return;
            }
            try {
                FileUtils.uncompressZip(file.getAbsolutePath(), t16, false);
                VasUpdateUtil.safeDeleteFile(file);
                File file2 = new File(t16, "dynamic.zip");
                if (file2.exists()) {
                    FileUtils.uncompressZip(file2.getAbsolutePath(), t16 + ".dynamic", false);
                    VasUpdateUtil.safeDeleteFile(file2);
                }
                File file3 = new File(t16, "extra_pag.zip");
                if (file3.exists()) {
                    FileUtils.uncompressZip(file3.getAbsolutePath(), t16 + ".extra", false);
                    VasUpdateUtil.safeDeleteFile(file3);
                }
            } catch (OutOfMemoryError e16) {
                QLog.e("ProfileCardManager", 1, "failed to unzip " + file.getAbsolutePath(), e16);
            } catch (Throwable th5) {
                QLog.e("ProfileCardManager", 1, "failed to unzip " + file.getAbsolutePath(), th5);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardManager", 2, "onDownloadComplete, resDir= " + t16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardManager", 2, "onDownloadComplete failed, errorCode = " + i3);
        }
    }

    public void y(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.f259996a.put(Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public int z(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, j3)).intValue();
        }
        if (this.f259996a.containsKey(Long.valueOf(j3))) {
            return this.f259996a.get(Long.valueOf(j3)).intValue();
        }
        return 0;
    }
}
