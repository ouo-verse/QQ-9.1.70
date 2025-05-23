package com.tencent.mobileqq.zplan.easteregg;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.easteregg.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002JS\u0010#\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0012\u0010$\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0006\u0010&\u001a\u00020\u0002J\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0'J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0002J;\u0010.\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\b2#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cR\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/EasterEggPagConfigRepo;", "", "", "r", "", "configInfo", "w", "folderPath", "", "v", "Lcom/tencent/mobileqq/zplan/easteregg/a;", "pagConfig", "gender", "url", "u", "path", "i", "isMale", HippyTKDListViewAdapter.X, "pagName", Constants.PAG_FILE_PATH, "Lcom/tencent/mobileqq/zplan/easteregg/a$a;", "pagResourcePath", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lkotlin/Function0;", "downloadSuccessHandler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "code", "errorHandler", "forceDownload", "l", "f", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "Ljava/util/concurrent/ConcurrentHashMap;", "o", "content", "y", "g", "res", "listener", "k", "b", "Ljava/util/concurrent/ConcurrentHashMap;", DownloadInfo.spKey_Config, "c", "Z", "hasConfigInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasWriteMMKV", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class EasterEggPagConfigRepo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasConfigInit;

    /* renamed from: a, reason: collision with root package name */
    public static final EasterEggPagConfigRepo f332820a = new EasterEggPagConfigRepo();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<String, com.tencent.mobileqq.zplan.easteregg.a> config = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean hasWriteMMKV = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/EasterEggPagConfigRepo$a", "Lpy2/a;", "Lgh3/a;", "data", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements py2.a<gh3.a> {
        a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(gh3.a data) {
            QLog.i("EasterEggPagConfigRepo", 1, "loadConfig callback, config=" + data);
            if (data != null) {
                EasterEggPagConfigRepo.f332820a.y(data.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String());
            }
        }
    }

    EasterEggPagConfigRepo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        try {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove("key_easter_egg_config");
            QLog.i("EasterEggPagConfigRepo", 1, "clearConfig remove");
        } catch (Throwable th5) {
            QLog.i("EasterEggPagConfigRepo", 1, "clearConfig exception", th5);
        }
    }

    private final void i(String path) {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
            file.delete();
        }
    }

    private final void j(String pagName, String pagFilePath, a.C9169a pagResourcePath) {
        if (!(pagFilePath.length() == 0) && new File(pagFilePath).exists() && new File(pagFilePath).isFile()) {
            switch (pagName.hashCode()) {
                case -1669176355:
                    if (pagName.equals("layer3_photo.pag")) {
                        pagResourcePath.h(pagFilePath);
                        return;
                    }
                    return;
                case -1037677030:
                    if (pagName.equals("layer2_effect_reversed.pag")) {
                        pagResourcePath.j(pagFilePath);
                        return;
                    }
                    return;
                case 234627283:
                    if (pagName.equals("layer3_avatar_reversed.pag")) {
                        pagResourcePath.k(pagFilePath);
                        return;
                    }
                    return;
                case 1068022018:
                    if (pagName.equals("layer1_fullscreen.pag")) {
                        pagResourcePath.i(pagFilePath);
                        return;
                    }
                    return;
                case 1772479023:
                    if (pagName.equals("layer1_fullscreen_reversed.pag")) {
                        pagResourcePath.l(pagFilePath);
                        return;
                    }
                    return;
                case 1933715639:
                    if (pagName.equals("layer2_effect.pag")) {
                        pagResourcePath.g(pagFilePath);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        QLog.e("EasterEggPagConfigRepo", 1, "doParseFile failed, pag file invalid.");
    }

    private final void l(final String url, String path, final Function0<Unit> downloadSuccessHandler, final Function1<? super Integer, Unit> errorHandler, boolean forceDownload) {
        if (!f(url)) {
            QLog.w("EasterEggPagConfigRepo", 1, "downloadResource url error");
            errorHandler.invoke(3);
            return;
        }
        final File file = new File(path);
        if (file.exists() && !forceDownload) {
            downloadSuccessHandler.invoke();
            QLog.d("EasterEggPagConfigRepo", 1, "downloadResource has download");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.e
                @Override // java.lang.Runnable
                public final void run() {
                    EasterEggPagConfigRepo.m(url, file, downloadSuccessHandler, errorHandler);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str, File f16, Function0 downloadSuccessHandler, Function1 errorHandler) {
        Intrinsics.checkNotNullParameter(f16, "$f");
        Intrinsics.checkNotNullParameter(downloadSuccessHandler, "$downloadSuccessHandler");
        Intrinsics.checkNotNullParameter(errorHandler, "$errorHandler");
        if (DownloaderFactory.o(new com.tencent.mobileqq.vip.g(str, f16), null) == 0 && f16.exists()) {
            downloadSuccessHandler.invoke();
        } else {
            QLog.w("EasterEggPagConfigRepo", 1, "downloadResource error");
            errorHandler.invoke(4);
        }
    }

    private final String n() {
        File file = new File(MobileQQ.sMobileQQ.getExternalCacheDir(), "zplan/pag/download/");
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    private final String p(com.tencent.mobileqq.zplan.easteregg.a pagConfig, String url) {
        List split$default;
        String q16 = q(url);
        if (!(q16 == null || q16.length() == 0)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) q16, new String[]{"."}, false, 0, 6, (Object) null);
            return (String) split$default.get(0);
        }
        return String.valueOf(pagConfig.getPortraitID());
    }

    private final void r() {
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("key_easter_egg_config", "");
        if (string.length() == 0) {
            return;
        }
        w(string);
        Iterator<Map.Entry<String, com.tencent.mobileqq.zplan.easteregg.a>> it = config.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.zplan.easteregg.a aVar = config.get(it.next().getKey());
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(aVar, "config[it.key] ?: return@forEach");
                EasterEggPagConfigRepo easterEggPagConfigRepo = f332820a;
                String n3 = easterEggPagConfigRepo.n();
                String maleUrl = aVar.getMaleUrl();
                if (maleUrl == null) {
                    maleUrl = "";
                }
                String p16 = easterEggPagConfigRepo.p(aVar, maleUrl);
                String str = File.separator;
                String str2 = n3 + p16 + str + LightConstants.MALE + str;
                String n16 = easterEggPagConfigRepo.n();
                String femaleUrl = aVar.getFemaleUrl();
                if (femaleUrl == null) {
                    femaleUrl = "";
                }
                easterEggPagConfigRepo.x(n16 + easterEggPagConfigRepo.p(aVar, femaleUrl) + str + LightConstants.FEMALE + str, aVar, false);
                easterEggPagConfigRepo.x(str2, aVar, true);
            }
        }
        s();
    }

    private final String u(com.tencent.mobileqq.zplan.easteregg.a pagConfig, String gender, String url) {
        File[] listFiles;
        String n3 = n();
        String p16 = p(pagConfig, url);
        String str = File.separator;
        String str2 = n3 + p16 + str + "zip" + str;
        try {
            File file = new File(str2, gender);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                for (File file2 : listFiles) {
                    if (file2.exists() && file2.isDirectory()) {
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "zipFile.name");
                        long parseLong = Long.parseLong(name);
                        if (pagConfig.getCom.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY java.lang.String() > parseLong) {
                            EasterEggPagConfigRepo easterEggPagConfigRepo = f332820a;
                            String str3 = File.separator;
                            easterEggPagConfigRepo.i(str2 + gender + str3 + parseLong + str3);
                        } else {
                            String str4 = File.separator;
                            return str2 + gender + str4 + parseLong + str4;
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("EasterEggPagConfigRepo", 1, "needDownloadPagResource failed, exception: " + e16);
        }
        return null;
    }

    private final void w(String configInfo) {
        int optInt;
        try {
            JSONObject jSONObject = new JSONObject(configInfo);
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "configJson.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject != null && (optInt = optJSONObject.optInt("portraitId", -1)) != -1) {
                    com.tencent.mobileqq.zplan.easteregg.a aVar = new com.tencent.mobileqq.zplan.easteregg.a();
                    aVar.G(optInt);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("textKeywords");
                    if (optJSONArray != null) {
                        aVar.M(new HashSet<>());
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            HashSet<String> r16 = aVar.r();
                            if (r16 != null) {
                                Object obj = optJSONArray.get(i3);
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                r16.add((String) obj);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("androidAssociatedMsgTypes");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        Object obj2 = optJSONArray2.get(0);
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        aVar.E(((Integer) obj2).intValue());
                    }
                    aVar.D(optJSONObject.optString("maleUrl", ""));
                    aVar.B(optJSONObject.optString("femaleUrl", ""));
                    aVar.I(optJSONObject.optInt("priority", 0));
                    aVar.J(optJSONObject.optInt("repeatCount", 1));
                    aVar.w(Integer.valueOf(optJSONObject.optInt("avatarBackgroundLayer", -1)));
                    aVar.x(Integer.valueOf(optJSONObject.optInt("avatarCharacterLayer", -1)));
                    aVar.K(optJSONObject.optBoolean("shouldReverseForAvatar", false));
                    aVar.L(optJSONObject.optBoolean("shouldReverseForEffect", false));
                    aVar.z(optJSONObject.optBoolean("enablePrerecord", false));
                    aVar.A(optJSONObject.optBoolean("enableReport", false));
                    String time = optJSONObject.optString("timestamp", "0");
                    Intrinsics.checkNotNullExpressionValue(time, "time");
                    aVar.N(Long.parseLong(time));
                    config.put(str, aVar);
                }
            }
        } catch (JSONException e16) {
            QLog.e("EasterEggPagConfigRepo", 1, "parseConfigInfo error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void x(String folderPath, com.tencent.mobileqq.zplan.easteregg.a pagConfig, boolean isMale) {
        a.C9169a femalePagResourcePath;
        if (isMale) {
            femalePagResourcePath = pagConfig.getMalePagResourcePath();
        } else {
            femalePagResourcePath = pagConfig.getFemalePagResourcePath();
        }
        if (femalePagResourcePath == null) {
            return;
        }
        File file = new File(folderPath, "pag");
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                for (File file2 : listFiles) {
                    if (file2.exists() && file2.isFile()) {
                        String pagName = file2.getName();
                        String str = file.getAbsolutePath() + File.separator + pagName;
                        EasterEggPagConfigRepo easterEggPagConfigRepo = f332820a;
                        Intrinsics.checkNotNullExpressionValue(pagName, "pagName");
                        easterEggPagConfigRepo.j(pagName, str, femalePagResourcePath);
                    }
                    QLog.e("EasterEggPagConfigRepo", 1, "parseUnzippedFile failed, pag file invalid: " + file2.getAbsolutePath());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(String content) {
        Intrinsics.checkNotNullParameter(content, "$content");
        QLog.i("EasterEggPagConfigRepo", 1, "updateAndSaveConfig");
        hasConfigInit = true;
        if (hasWriteMMKV.compareAndSet(false, true)) {
            QLog.i("EasterEggPagConfigRepo", 1, "updateAndSaveConfig updateMMKV");
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("key_easter_egg_config", content);
        }
        f332820a.w(content);
        if (ZPlanFeatureSwitch.f369852a.r0()) {
            Iterator<Map.Entry<String, com.tencent.mobileqq.zplan.easteregg.a>> it = config.entrySet().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.zplan.easteregg.a aVar = config.get(it.next().getKey());
                if (aVar != null) {
                    Intrinsics.checkNotNullExpressionValue(aVar, "config[it.key] ?: return@forEach");
                    EasterEggPagConfigRepo easterEggPagConfigRepo = f332820a;
                    easterEggPagConfigRepo.k(aVar, true, null);
                    easterEggPagConfigRepo.k(aVar, false, null);
                }
            }
        }
    }

    public final void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.c
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagConfigRepo.h();
            }
        }, 64, null, true);
    }

    public final ConcurrentHashMap<String, com.tencent.mobileqq.zplan.easteregg.a> o() {
        if (!hasConfigInit) {
            r();
            hasConfigInit = true;
        }
        return config;
    }

    public final void s() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.b
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagConfigRepo.t();
            }
        }, 64, null, true);
    }

    public final void y(final String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(content)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.d
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagConfigRepo.z(content);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        QLog.i("EasterEggPagConfigRepo", 1, "loadConfig start");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("zplan_aio_egg_manager_large_config", new a());
    }

    private final boolean v(String folderPath) {
        File[] listFiles;
        try {
            File file = new File(folderPath);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                if (listFiles.length > 0) {
                    File file2 = listFiles[0];
                    if (file2.exists() && file2.isDirectory()) {
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 != null) {
                            if (listFiles2.length == 0) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.e("EasterEggPagConfigRepo", 1, "needUnzipFile failed, exception: " + e16);
        }
        return true;
    }

    private final String q(String url) {
        if (url == null) {
            return null;
        }
        Object[] array = new Regex("/").split(url, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (!f(url)) {
            return null;
        }
        if ((strArr.length == 0) || TextUtils.isEmpty(strArr[strArr.length - 1])) {
            return null;
        }
        return strArr[strArr.length - 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean f(String url) {
        boolean z16;
        boolean z17;
        boolean startsWith$default;
        boolean startsWith$default2;
        if (url != null) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
            if (startsWith$default2) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                if (url != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                    if (startsWith$default) {
                        z17 = true;
                        return !z17;
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public final void k(final com.tencent.mobileqq.zplan.easteregg.a pagConfig, final boolean isMale, final Function1<? super Boolean, Unit> listener) {
        String femaleUrl;
        String str;
        Intrinsics.checkNotNullParameter(pagConfig, "pagConfig");
        if (!isMale ? (femaleUrl = pagConfig.getFemaleUrl()) == null : (femaleUrl = pagConfig.getMaleUrl()) == null) {
            femaleUrl = "";
        }
        if (TextUtils.isEmpty(femaleUrl)) {
            if (listener != null) {
                listener.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (isMale) {
            str = LightConstants.MALE;
        } else {
            str = LightConstants.FEMALE;
        }
        String q16 = q(femaleUrl);
        if (q16 == null || q16.length() == 0) {
            if (listener != null) {
                listener.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String n3 = n();
        String p16 = p(pagConfig, femaleUrl);
        String str2 = File.separator;
        final String str3 = n3 + p16 + str2 + str + str2;
        String u16 = u(pagConfig, str, femaleUrl);
        String str4 = u16 + q16;
        File file = new File(str4 != null ? str4 : "");
        if (u16 != null && file.exists() && !file.isDirectory()) {
            try {
                if (v(str3)) {
                    ZipUtils.unZipFile(file, str3);
                }
                x(str3, pagConfig, isMale);
                if (listener != null) {
                    listener.invoke(Boolean.TRUE);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.d("EasterEggPagConfigRepo", 1, "download pag zip resource fail " + e16);
                return;
            }
        }
        String str5 = n() + p(pagConfig, femaleUrl) + str2 + "zip" + str2 + str + str2 + pagConfig.getCom.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY java.lang.String() + str2;
        final String str6 = str5 + Math.random();
        final String str7 = str5 + q16;
        l(femaleUrl, str6, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.EasterEggPagConfigRepo$downloadPagZipResource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                File file2 = new File(str6);
                if (!file2.exists()) {
                    QLog.d("EasterEggPagConfigRepo", 1, "download pag zip resource fail");
                    Function1<Boolean, Unit> function1 = listener;
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                try {
                    File file3 = new File(str7);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    if (!file2.renameTo(file3)) {
                        Function1<Boolean, Unit> function12 = listener;
                        if (function12 != null) {
                            function12.invoke(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    ZipUtils.unZipFile(file3, str3);
                    EasterEggPagConfigRepo.f332820a.x(str3, pagConfig, isMale);
                    Function1<Boolean, Unit> function13 = listener;
                    if (function13 != null) {
                        function13.invoke(Boolean.TRUE);
                    }
                } catch (Exception e17) {
                    QLog.d("EasterEggPagConfigRepo", 1, "download pag zip resource fail " + e17);
                    Function1<Boolean, Unit> function14 = listener;
                    if (function14 != null) {
                        function14.invoke(Boolean.FALSE);
                    }
                }
            }
        }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.EasterEggPagConfigRepo$downloadPagZipResource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Function1<Boolean, Unit> function1 = listener;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
                QLog.d("EasterEggPagConfigRepo", 1, "download pag zip resource fail");
            }
        }, true);
    }
}
