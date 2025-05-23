package com.tencent.mobileqq.zootopia.download.mod;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadEntity;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.space.j;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.ab;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/ZPlanModResManager;", "", "", "modId", "d", "engineVersion", "", "e", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModResManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanModResManager f328075a = new ZPlanModResManager();

    ZPlanModResManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, java.lang.Object, java.lang.String] */
    public static final void c(String modId) {
        Intrinsics.checkNotNullParameter(modId, "$modId");
        long currentTimeMillis = System.currentTimeMillis();
        final String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(f328075a.d(modId), "");
        String str = "res_last_clear_time_" + ab.INSTANCE.b() + "_" + modId;
        long j3 = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getLong(str, 0L);
        if (!TextUtils.isEmpty(string) && (j3 <= 0 || System.currentTimeMillis() - j3 >= 43200000)) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(str, System.currentTimeMillis());
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? y26 = ZPlanFeatureSwitch.f369852a.y2();
            objectRef.element = y26;
            QLog.i("ZPlanModResManager", 1, "urlMatchRulePrefix = " + ((Object) y26));
            if (TextUtils.isEmpty((CharSequence) objectRef.element)) {
                objectRef.element = "DynamicUpdate/Zplan_";
            }
            j jVar = j.f329276a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            final List<String> c16 = jVar.c(modId, context);
            FileDownloadManager.f328148a.g(modId, new Function1<FileDownloadEntity, Boolean>() { // from class: com.tencent.mobileqq.zootopia.download.mod.ZPlanModResManager$clearInvalidModRes$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FileDownloadEntity it) {
                    boolean contains$default;
                    boolean contains$default2;
                    boolean contains$default3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str2 = it.url;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.url");
                    boolean z16 = false;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) objectRef.element, false, 2, (Object) null);
                    if (contains$default) {
                        String str3 = it.url;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.url");
                        String str4 = objectRef.element;
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) (((Object) str4) + string), false, 2, (Object) null);
                        if (!contains$default2) {
                            Iterator<String> it5 = c16.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                String next = it5.next();
                                String str5 = it.filePath;
                                Intrinsics.checkNotNullExpressionValue(str5, "it.filePath");
                                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str5, (CharSequence) next, false, 2, (Object) null);
                                if (contains$default3) {
                                    z16 = true;
                                    break;
                                }
                            }
                        }
                    }
                    return Boolean.valueOf(z16);
                }
            });
        }
        QLog.i("ZPlanModResManager", 1, "clearInvalidModRes - " + modId + " finish, cachedEngineVersion= " + string + ", lastClearTime= " + j3 + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private final String d(String modId) {
        return "res_engine_version_" + ab.INSTANCE.b() + "_" + modId;
    }

    public final void b(final String modId) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        boolean C0 = ZPlanFeatureSwitch.f369852a.C0();
        QLog.i("ZPlanModResManager", 1, "clearInvalidModRes - " + modId + ", autoClearToggle= " + C0);
        if (C0) {
            try {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.mod.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanModResManager.c(modId);
                    }
                }, 64, null, true);
            } catch (Exception e16) {
                QLog.e("ZPlanModResManager", 1, "clearInvalidModRes - " + modId + ", exception", e16);
            }
        }
    }

    public final void e(String modId, String engineVersion) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(engineVersion, "engineVersion");
        QLog.i("ZPlanModResManager", 1, "saveResEngineVersion - " + modId + ", " + engineVersion);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(d(modId), engineVersion);
    }
}
