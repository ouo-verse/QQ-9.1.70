package com.tencent.rdelivery.reshub.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rdelivery.reshub.local.ConfigStorage;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/PendingDeleteManager;", "", "", "path", "", "d", "", "deleteSet", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Ljz3/e;", "resConfig", "e", "o", "l", "", "k", "g", "j", "i", "Landroid/content/Context;", "context", tl.h.F, "Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", "a", "Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", QQPermissionConstants.Permission.STORAGE_GROUP, "b", "Z", "hasDeletePendingFiles", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class PendingDeleteManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasDeletePendingFiles;

    /* renamed from: c, reason: collision with root package name */
    public static final PendingDeleteManager f364584c = new PendingDeleteManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConfigStorage storage = new ConfigStorage("pending_delete_files", new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.PendingDeleteManager$storage$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    });

    PendingDeleteManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String path) {
        boolean z16;
        Set<String> plus;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            plus = SetsKt___SetsKt.plus((Set<? extends String>) ((Set<? extends Object>) m()), path);
            n(plus);
            jz3.d.a("PendingDelete", "Add Pending Delete: " + path);
        }
    }

    private final void f(final Set<String> deleteSet) {
        ThreadUtil.c(ThreadUtil.f364593c, "DeletePendingFiles", null, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.PendingDeleteManager$doDeleteFilesAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                for (String str : deleteSet) {
                    if (!TextUtils.isEmpty(str)) {
                        File file = new File(str);
                        if (file.exists()) {
                            jz3.c.f(file, true);
                            jz3.d.a("PendingDelete", "PendingDelete Deleted Success: " + str);
                        } else {
                            jz3.d.a("PendingDelete", "Ignore PendingDelete, Path Not Exists: " + str);
                        }
                    }
                }
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> m() {
        List split$default;
        Set<String> set;
        split$default = StringsKt__StringsKt.split$default((CharSequence) storage.e(), new String[]{"|"}, false, 0, 6, (Object) null);
        set = CollectionsKt___CollectionsKt.toSet(split$default);
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Set<String> deleteSet) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(deleteSet, "|", null, null, 0, null, null, 62, null);
        storage.g(joinToString$default);
    }

    public final void e(@Nullable final jz3.e resConfig) {
        jz3.d.e("ResHub_PendingDeleteManager", "addToPendingDelete resConfig = " + resConfig + '.');
        if (resConfig == null) {
            return;
        }
        storage.h(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.PendingDeleteManager$addToPendingDelete$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                PendingDeleteManager pendingDeleteManager = PendingDeleteManager.f364584c;
                pendingDeleteManager.d(jz3.e.this.H);
                pendingDeleteManager.d(jz3.e.this.G);
            }
        });
    }

    @Nullable
    public final String g() {
        String j3 = j();
        if (TextUtils.isEmpty(j3)) {
            j3 = i();
        }
        if (TextUtils.isEmpty(j3)) {
            return h(com.tencent.rdelivery.reshub.core.g.d());
        }
        return j3;
    }

    @Nullable
    public final String h(@Nullable Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        try {
            Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            activityManager = (ActivityManager) systemService;
        } catch (Exception e16) {
            jz3.d.d("PendingDelete", "getCurrentProcessNameByActivityManager error ", e16);
        }
        if (activityManager == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    @Nullable
    public final String i() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "Class.forName(\n         \u2026rayOfNulls<Class<*>?>(0))");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Throwable th5) {
            jz3.d.d("PendingDelete", "getCurrentProcessNameByActivityThread error", th5);
            return null;
        }
    }

    @Nullable
    public final String j() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        return "";
    }

    public final boolean k() {
        return com.tencent.rdelivery.reshub.core.g.d().getPackageName().equals(g());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.Set] */
    public final void l() {
        ?? emptySet;
        if (!k()) {
            jz3.d.e("PendingDelete", "performPendingDelete return for subprocess");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        emptySet = SetsKt__SetsKt.emptySet();
        objectRef.element = emptySet;
        storage.h(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.PendingDeleteManager$performPendingDelete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.Set] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ?? m3;
                Set emptySet2;
                Ref.ObjectRef objectRef2 = Ref.ObjectRef.this;
                PendingDeleteManager pendingDeleteManager = PendingDeleteManager.f364584c;
                m3 = pendingDeleteManager.m();
                objectRef2.element = m3;
                emptySet2 = SetsKt__SetsKt.emptySet();
                pendingDeleteManager.n(emptySet2);
            }
        });
        jz3.d.e("PendingDelete", "performPendingDelete: " + ((Set) objectRef.element));
        if (!((Set) objectRef.element).isEmpty()) {
            f((Set) objectRef.element);
        }
    }

    public final void o() {
        if (!hasDeletePendingFiles) {
            hasDeletePendingFiles = true;
            l();
        }
    }
}
