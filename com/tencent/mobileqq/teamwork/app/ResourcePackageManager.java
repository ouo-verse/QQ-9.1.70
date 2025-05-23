package com.tencent.mobileqq.teamwork.app;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/teamwork/app/ResourcePackageManager;", "", "", "url", "i", "", "startHour", "endHour", "", "g", "", "a", "", "e", "bid", "j", "f", "Lorg/json/JSONObject;", "jsonObject", tl.h.F, "b", "relativeFilePath", "d", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "downloadTasks", "<init>", "()V", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ResourcePackageManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ResourcePackageManager f291881a = new ResourcePackageManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> downloadTasks = new ArrayList<>();

    ResourcePackageManager() {
    }

    @JvmStatic
    public static final void a() {
        QLog.i("ResourcePackageManager", 1, "checkAndExecuteDownloadTasks");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkAndExecuteDownloadTasks downloadTasks ");
        ArrayList<String> arrayList = downloadTasks;
        sb5.append(arrayList.size());
        QLog.i("ResourcePackageManager", 1, sb5.toString());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            j(it.next());
        }
        downloadTasks.clear();
    }

    @JvmStatic
    public static final boolean b(@Nullable String bid) {
        boolean z16;
        boolean z17;
        String f16 = f(bid);
        if (QLog.isColorLevel()) {
            QLog.i("ResourcePackageManager", 2, "checkLoadSuccess bid:" + bid + ", path:" + f16);
        }
        File file = new File(f16);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
            if (listFiles.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            z16 = !z17;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final Map<String, Object> e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, Object> map = null;
        if (peekAppRuntime == null) {
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026essConstant.ALL\n        )");
        JSONObject jSONObject = ((IFeatureRuntimeService) runtimeService).getJSONObject("tencent_docs_preview_offline_info", null);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "featureService.getJSONOb\u2026EVIEW_OFFLINE_INFO, null)");
        try {
            map = h(jSONObject);
        } catch (Exception e16) {
            QLog.e("ResourcePackageManager", 1, "getOfflineInfo, exception=" + e16);
        }
        QLog.i("ResourcePackageManager", 1, "getOfflineInfo" + map);
        return map;
    }

    @JvmStatic
    @NotNull
    public static final String f(@Nullable String bid) {
        boolean z16;
        boolean z17;
        if (bid != null && bid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        String a16 = DownLoadOfflinePackageFromShiplyHelper.f291873a.a(bid);
        if (a16 != null && a16.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return "";
        }
        QLog.d("ResourcePackageManager", 1, "getResourcePath, basePath:", a16);
        return a16;
    }

    private final boolean g(int startHour, int endHour) {
        int i3 = Calendar.getInstance().get(11);
        if (startHour <= endHour) {
            if (startHour <= i3 && i3 < endHour) {
                return true;
            }
        } else if (i3 >= startHour || i3 < endHour) {
            return true;
        }
        return false;
    }

    private final Map<String, Object> h(JSONObject jsonObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object opt = jsonObject.opt(key);
                if (opt != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, opt.toString());
                }
            }
        } catch (JSONException e16) {
            QLog.e("ResourcePackageManager", 1, "jsonObjectToMap with exception !", e16);
        }
        return hashMap;
    }

    private final String i(String url) {
        List split$default;
        Object first;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 2, 2, (Object) null);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
        return (String) first;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: all -> 0x0010, TRY_ENTER, TryCatch #0 {, blocks: (B:39:0x0007, B:10:0x0017, B:12:0x0021, B:14:0x002d, B:16:0x0033, B:18:0x003b, B:19:0x003f, B:21:0x004a, B:23:0x0050, B:25:0x0056, B:29:0x005a, B:31:0x0060, B:32:0x006e), top: B:38:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[DONT_GENERATE] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized void j(@Nullable final String bid) {
        boolean z16;
        String str;
        Integer num;
        String str2;
        synchronized (ResourcePackageManager.class) {
            int i3 = 0;
            if (bid != null) {
                if (bid.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return;
                    }
                    ResourcePackageManager resourcePackageManager = f291881a;
                    Map<String, Object> e16 = resourcePackageManager.e();
                    int i16 = 24;
                    if (e16 != null) {
                        Object obj = e16.get("startHour");
                        Integer num2 = null;
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            i3 = num.intValue();
                        }
                        Object obj2 = e16.get("endHour");
                        if (obj2 instanceof String) {
                            str2 = (String) obj2;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            num2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
                        }
                        if (num2 != null) {
                            i16 = num2.intValue();
                        }
                    }
                    if (!resourcePackageManager.g(i3, i16)) {
                        QLog.i("ResourcePackageManager", 1, "updateResource skipped, current time is not within the set download time range");
                        downloadTasks.add(bid);
                    }
                    DownLoadOfflinePackageFromShiplyHelper.f291873a.b(bid, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.teamwork.app.ResourcePackageManager$updateResource$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str3) {
                            invoke(bool.booleanValue(), str3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17, @Nullable String str3) {
                            QLog.i("ResourcePackageManager", 2, "loadOfflinePackage bid " + bid + " isLoadSuccess " + z17 + "  errMsg " + str3);
                        }
                    });
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
    }

    public final boolean c(@Nullable String bid) {
        boolean z16;
        if (bid != null && bid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (b(bid)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ResourcePackageManager", 2, "cannot find resource, currentBid = " + bid);
        }
        j(bid);
        return false;
    }

    @Nullable
    public final String d(@Nullable String bid, @NotNull String relativeFilePath) {
        Intrinsics.checkNotNullParameter(relativeFilePath, "relativeFilePath");
        String str = f(bid) + '/' + i(relativeFilePath);
        if (QLog.isColorLevel()) {
            QLog.i("ResourcePackageManager", 2, "getLocalOfflineFilePath completeFilePath = " + str);
        }
        if (new File(str).exists()) {
            return str;
        }
        return null;
    }
}
