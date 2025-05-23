package com.tencent.mobileqq.zplan.avatar.image.sharpP;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.ark.util.i;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.ZPlanAvatarShpImageCacheManagerV2;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageCacheManager;", "Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/d;", "Landroid/content/SharedPreferences;", "c", "", "path", "a", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarShpImageCacheManager implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f331848b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<String> f331849c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy<d> f331850d;

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanAvatarShpImageCacheManager> f331851e;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageCacheManager$a;", "", "Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/d;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/d;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "AVATAR_SHP_IMAGE_DIR", "Ljava/lang/String;", "DAY_PREFIX", "", "FILE_NUM", "I", "LIST_KEY", "MAX_CACHE_NUM", "NIGHT_PREFIX", "SP_KEY_AVATAR_SHP_IMAGE_CACHE_LIST", "SP_KEY_AVATAR_SHP_IMAGE_CACHE_MAP", "TAG", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageCacheManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return (d) ZPlanAvatarShpImageCacheManager.f331850d.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<d> lazy;
        Lazy<ZPlanAvatarShpImageCacheManager> lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<d>() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageCacheManager$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                if (ZPlanFeatureSwitch.f369852a.e0()) {
                    return new ZPlanAvatarShpImageCacheManagerV2();
                }
                return new ZPlanAvatarShpImageCacheManager(null);
            }
        });
        f331850d = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ZPlanAvatarShpImageCacheManager>() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageCacheManager$Companion$OLD_MANAGER$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanAvatarShpImageCacheManager invoke() {
                return new ZPlanAvatarShpImageCacheManager(null);
            }
        });
        f331851e = lazy2;
    }

    public /* synthetic */ ZPlanAvatarShpImageCacheManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final SharedPreferences c() {
        String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("zplan_sp" + currentAccountUin, 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplication()\n       \u2026ntext.MODE_MULTI_PROCESS)");
        return sharedPreferences;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.d
    public String a(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(MobileQQ.sMobileQQ.getApplicationContext().getExternalCacheDir(), "zplan/shpimage/" + path);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    ZPlanAvatarShpImageCacheManager() {
        f331848b = new HashMap<>();
        f331849c = new ArrayList<>();
        String string = c().getString("zplan_avatar_shp_image_cache_map", "");
        String string2 = c().getString("zplan_avatar_shp_image_cache_list", "");
        if (!(string == null || string.length() == 0)) {
            if (!(string2 == null || string2.length() == 0)) {
                Map<String, Object> cacheMapTmp = i.b(new JSONObject(string));
                List<Object> cacheListTmp = i.a(new JSONArray(string2));
                Intrinsics.checkNotNullExpressionValue(cacheMapTmp, "cacheMapTmp");
                if (!cacheMapTmp.isEmpty()) {
                    Intrinsics.checkNotNullExpressionValue(cacheListTmp, "cacheListTmp");
                    if ((!cacheListTmp.isEmpty()) && cacheMapTmp.size() == cacheListTmp.size()) {
                        try {
                            f331848b = (HashMap) cacheMapTmp;
                            f331849c = (ArrayList) cacheListTmp;
                        } catch (Exception e16) {
                            QLog.e("ZPlanAvatarShpImageCacheManager", 1, "init fail", e16);
                        }
                    }
                }
            }
        }
        QLog.i("ZPlanAvatarShpImageCacheManager", 1, "[init] cacheMap:" + f331848b + "\uff0c cacheList:" + f331849c);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.d
    public void clearCache() {
        QLog.i("ZPlanAvatarShpImageCacheManager", 1, "[clearCache]");
        c().edit().putString("zplan_avatar_shp_image_cache_map", "").putString("zplan_avatar_shp_image_cache_list", "").apply();
        f331848b = new HashMap<>();
        f331849c = new ArrayList<>();
    }
}
