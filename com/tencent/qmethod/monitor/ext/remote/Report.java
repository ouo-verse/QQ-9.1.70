package com.tencent.qmethod.monitor.ext.remote;

import android.os.Build;
import android.os.Handler;
import com.tencent.av.so.ResInfo;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/remote/Report;", "", "", "d", "", "e", "", "b", "f", "Landroid/os/Handler;", "a", "Lkotlin/Lazy;", "c", "()Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class Report {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Runnable runnable;

    /* renamed from: c, reason: collision with root package name */
    public static final Report f343665c = new Report();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.ext.remote.Report$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        handler = lazy;
        runnable = new Runnable() { // from class: com.tencent.qmethod.monitor.ext.remote.Report$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                double d16;
                try {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("report start, debug = ");
                    com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
                    sb5.append(String.valueOf(aVar.g().getDebug()));
                    o.a("ext.d.Report", sb5.toString());
                    if (!aVar.g().getDebug()) {
                        SampleHelper sampleHelper = SampleHelper.f343779l;
                        e eVar = ConfigManager.f343549h.p().g().get("func_dynamic_resource");
                        if (eVar != null) {
                            d16 = eVar.getRate();
                        } else {
                            d16 = 0.0d;
                        }
                        if (!SampleHelper.z(sampleHelper, d16, 0, 0, 6, null)) {
                            return;
                        }
                    }
                    o.a("ext.d.Report", "do report");
                    Report.f343665c.e();
                } catch (Throwable th5) {
                    o.d("ext.d.Report", "report error: " + th5.getMessage(), th5);
                }
            }
        };
    }

    Report() {
    }

    private final String b() {
        boolean z16;
        String str;
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.checkExpressionValueIsNotNull(strArr, "Build.SUPPORTED_ABIS");
        if (strArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str = strArr[0];
        } else {
            str = "unknown";
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "if (Build.SUPPORTED_ABIS\u2026ED_ABIS[0] else \"unknown\"");
        return str;
    }

    private final Handler c() {
        return (Handler) handler.getValue();
    }

    private final long d() {
        return (((int) (Math.random() * 60 * 10)) + 180) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean isBlank;
        boolean z16;
        List split$default;
        ResourceType resourceType;
        List split$default2;
        JSONArray jSONArray = new JSONArray();
        List<String> e16 = b.f343675b.e();
        ArrayList<String> arrayList = new ArrayList();
        Iterator<T> it = e16.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) next, new String[]{"||"}, false, 0, 6, (Object) null);
            if (split$default2.size() == 2) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (String str : arrayList) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"||"}, false, 0, 6, (Object) null);
            o.a("ext.d.Report", str);
            String str2 = (String) split$default.get(0);
            String str3 = (String) split$default.get(1);
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                int hashCode = lowerCase.hashCode();
                if (hashCode != 3676) {
                    if (hashCode != 99351) {
                        if (hashCode == 120609 && lowerCase.equals("zip")) {
                            resourceType = ResourceType.PLUGIN;
                        }
                        resourceType = ResourceType.UNKNOWN;
                    } else {
                        if (lowerCase.equals("dex")) {
                            resourceType = ResourceType.PATCH;
                        }
                        resourceType = ResourceType.UNKNOWN;
                    }
                } else {
                    if (lowerCase.equals(ResInfo.RES_TYPE_SO)) {
                        resourceType = ResourceType.SO;
                    }
                    resourceType = ResourceType.UNKNOWN;
                }
                ResourceInfo resourceInfo = new ResourceInfo(str2, resourceType);
                long currentTimeMillis = System.currentTimeMillis() - resourceInfo.getModifyTime();
                String str4 = resourceInfo.getPath() + resourceInfo.getModifyTime();
                if (1 <= currentTimeMillis && 25920000 > currentTimeMillis && !f.a(str4)) {
                    resourceInfo.h();
                    f.e(str4, true);
                }
                arrayList2.add(resourceInfo);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        ArrayList<ResourceInfo> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            ResourceInfo resourceInfo2 = (ResourceInfo) obj;
            isBlank = StringsKt__StringsJVMKt.isBlank(resourceInfo2.getMd5());
            if ((!isBlank) && !f.a(resourceInfo2.getMd5())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList<String> arrayList4 = new ArrayList(collectionSizeOrDefault2);
        for (ResourceInfo resourceInfo3 : arrayList3) {
            f.e(resourceInfo3.getMd5(), true);
            arrayList4.add(or3.a.c(or3.a.f423465b, "resource", resourceInfo3.getMd5(), resourceInfo3.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.PARAM_FILENAME java.lang.String(), resourceInfo3.getType().name(), resourceInfo3.getFileSize() + "##" + resourceInfo3.getCom.tencent.ams.dsdk.monitor.metric.event.TagName.FILE_TYPE java.lang.String() + "##" + resourceInfo3.getModifyTime() + "##" + resourceInfo3.getPath() + "##" + f343665c.b(), null, 32, null));
        }
        for (String str5 : arrayList4) {
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                o.a("ext.d.Report", "report info[ " + str5 + " ]");
            }
            jSONArray.mo162put(str5);
        }
        o.a("ext.d.Report", "report array.length = " + String.valueOf(jSONArray.length()) + ", content = " + jSONArray.toString());
        if (jSONArray.length() > 0) {
            or3.a.f423465b.a(jSONArray);
        }
    }

    public final void f() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("start = ");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        sb5.append(String.valueOf(aVar.g().getResourceMonitor()));
        o.a("ext.d.Report", sb5.toString());
        if (aVar.g().getResourceMonitor()) {
            long d16 = d();
            o.a("ext.d.Report", "start randomDelayTime = " + String.valueOf(d16));
            c().postDelayed(runnable, d16);
        }
    }
}
