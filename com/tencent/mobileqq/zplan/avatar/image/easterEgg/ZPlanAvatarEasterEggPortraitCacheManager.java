package com.tencent.mobileqq.zplan.avatar.image.easterEgg;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.common.model.UploadConfig;
import di3.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ \u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J,\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00022\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d\u0018\u00010 J\u001e\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002R\u001b\u0010)\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/easterEgg/ZPlanAvatarEasterEggPortraitCacheManager;", "", "", "appearanceKey", "", "e", "zipFilePath", "uin", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository$b;", "listener", "", "retryCount", DomainData.DOMAIN_NAME, "l", "", "idList", "", "b", "Ljava/io/File;", "fromFile", "c", "id", h.F, "localQueryIdList", "j", "fromPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cacheDirPath", "d", "", "lastTimeStamp", "requestAppearanceKey", "Lkotlin/Pair;", "errorAppearanceInfo", "f", "g", "childName", "i", "Lkotlin/Lazy;", "k", "()J", "cacheValidTimeInterval", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarEasterEggPortraitCacheManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanAvatarEasterEggPortraitCacheManager f331820a = new ZPlanAvatarEasterEggPortraitCacheManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy cacheValidTimeInterval;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.avatar.image.easterEgg.ZPlanAvatarEasterEggPortraitCacheManager$cacheValidTimeInterval$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanFeatureSwitch.f369852a.h1());
            }
        });
        cacheValidTimeInterval = lazy;
    }

    ZPlanAvatarEasterEggPortraitCacheManager() {
    }

    private final boolean b(String appearanceKey, List<Integer> idList) {
        return ((appearanceKey.length() == 0) || idList.isEmpty()) ? false : true;
    }

    private final boolean c(File fromFile) {
        if (!fromFile.exists() || !fromFile.isFile()) {
            return false;
        }
        String name = fromFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this");
        return !(name.length() == 0);
    }

    private final void e(String appearanceKey) {
        String l3 = l(appearanceKey);
        if (l3.length() == 0) {
            return;
        }
        File file = new File(l3);
        if (file.exists() && file.isDirectory()) {
            FileUtils.deleteDirectory(l3);
        }
    }

    private final String h(int id5, String appearanceKey, File fromFile) {
        if (!c(fromFile)) {
            QLog.e("ZPlanAvatarEasterEggPortraitCacheManager", 1, "setCache failed, from file invalid.");
            return null;
        }
        String l3 = l(appearanceKey);
        File file = new File(l3);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        File file2 = new File(l3 + "/" + id5 + ".png");
        if (FileUtils.copyFile(fromFile, file2)) {
            return file2.getAbsolutePath();
        }
        return null;
    }

    private final long k() {
        return ((Number) cacheValidTimeInterval.getValue()).longValue();
    }

    private final String l(String appearanceKey) {
        return b.f393984a.c("zplan/easteregg/portrait/").getAbsolutePath() + "/" + appearanceKey + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final String zipFilePath, final String uin, final RecordRepository.b listener, final int retryCount) {
        ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.c().k(zipFilePath, System.currentTimeMillis() + ".zip", UploadConfig.UploadTarget.CDN, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.image.easterEgg.ZPlanAvatarEasterEggPortraitCacheManager$uploadZipFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                QLog.i("ZPlanAvatarEasterEggPortraitCacheManager", 1, "upload package finished, zipFilePath: " + zipFilePath + ", uin: " + uin + " -> code: " + z16 + ", url: " + url + ", retryCount: " + retryCount);
                if (!z16) {
                    int i3 = retryCount - 1;
                    if (i3 > 0) {
                        ZPlanAvatarEasterEggPortraitCacheManager.f331820a.n(zipFilePath, uin, listener, i3);
                        return;
                    } else {
                        RecordRepository.b.a.a(listener, false, null, 2, null);
                        return;
                    }
                }
                listener.a(true, url);
            }
        });
    }

    public final void d(String cacheDirPath) {
        Intrinsics.checkNotNullParameter(cacheDirPath, "cacheDirPath");
        if (cacheDirPath.length() == 0) {
            return;
        }
        FileUtils.deleteDirectory(cacheDirPath);
    }

    public final boolean f(long lastTimeStamp, String requestAppearanceKey, Pair<String, Long> errorAppearanceInfo) {
        Intrinsics.checkNotNullParameter(requestAppearanceKey, "requestAppearanceKey");
        QLog.i("ZPlanAvatarEasterEggPortraitCacheManager", 1, "clearCacheIfExpired, lastTimeStamp: " + lastTimeStamp + ", timeInterval: " + k() + ".");
        if (k() + lastTimeStamp < System.currentTimeMillis()) {
            QLog.i("ZPlanAvatarEasterEggPortraitCacheManager", 1, "cache out of date, clear. key: " + requestAppearanceKey);
            e(requestAppearanceKey);
            return true;
        }
        if (!Intrinsics.areEqual(errorAppearanceInfo != null ? errorAppearanceInfo.getFirst() : null, requestAppearanceKey) || errorAppearanceInfo.getSecond().longValue() <= lastTimeStamp) {
            return false;
        }
        QLog.i("ZPlanAvatarEasterEggPortraitCacheManager", 1, "appearance does not meet the regulations, clear. key: " + requestAppearanceKey);
        e(requestAppearanceKey);
        return true;
    }

    public final void g(String appearanceKey, String uin, RecordRepository.b listener) {
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (appearanceKey.length() == 0) {
            QLog.e("ZPlanAvatarEasterEggPortraitCacheManager", 1, "compress easterEgg portrait zip failed, appearanceKey empty.");
            RecordRepository.b.a.a(listener, false, null, 2, null);
            return;
        }
        String b16 = a.f331822a.b(l(appearanceKey));
        if (b16 == null || b16.length() == 0) {
            QLog.e("ZPlanAvatarEasterEggPortraitCacheManager", 1, "compress easterEgg portrait zip failed.");
            RecordRepository.b.a.a(listener, false, null, 2, null);
        } else {
            n(b16, uin, listener, 3);
        }
    }

    public final String i(String childName) {
        Intrinsics.checkNotNullParameter(childName, "childName");
        File file = new File(b.f393984a.c("zplan/easteregg/portrait/").getAbsolutePath(), childName);
        if (file.exists()) {
            file.delete();
        }
        file.mkdirs();
        return file.getAbsolutePath() + File.separator;
    }

    public final List<String> j(String appearanceKey, List<Integer> localQueryIdList) {
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(localQueryIdList, "localQueryIdList");
        if (!b(appearanceKey, localQueryIdList)) {
            QLog.e("ZPlanAvatarEasterEggPortraitCacheManager", 1, "checkBeforeGetCache failed, appearanceKey: " + appearanceKey + ", localQueryList: " + localQueryIdList);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = localQueryIdList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            ZPlanAvatarEasterEggPortraitCacheManager zPlanAvatarEasterEggPortraitCacheManager = f331820a;
            String str = zPlanAvatarEasterEggPortraitCacheManager.l(appearanceKey) + intValue + ".png";
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                arrayList.add(str);
            } else {
                zPlanAvatarEasterEggPortraitCacheManager.d(zPlanAvatarEasterEggPortraitCacheManager.l(appearanceKey));
                return null;
            }
        }
        return arrayList;
    }

    public final String m(int id5, String appearanceKey, String fromPath) {
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(fromPath, "fromPath");
        if (fromPath.length() == 0) {
            return null;
        }
        String h16 = f331820a.h(id5, appearanceKey, new File(fromPath));
        if (h16 != null) {
            if (h16.length() > 0) {
                return h16;
            }
        }
        return null;
    }
}
