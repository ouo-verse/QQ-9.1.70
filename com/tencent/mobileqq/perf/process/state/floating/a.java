package com.tencent.mobileqq.perf.process.state.floating;

import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/floating/a;", "", "", "", "floatingBlackList", "", "a", "d", "", "c", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "defaultSensitiveFloating", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257938a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> defaultSensitiveFloating;

    static {
        List<String> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f257938a = new a();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("com.tencent.mobileqq.guild.window.GuildAudioChannelFloatWrapper", "com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper", "com.tencent.mobileqq.guild.window.GuildWorldChannelFloatWrapper", "com.tencent.timi.game.liveroom.impl.room.floatwindow.QQLiveFloatingProxyWrapper", "com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowWrapper", "com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager", "com.tencent.mobileqq.listentogether.lyrics.LyricsController");
        defaultSensitiveFloating = mutableListOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0082, code lost:
    
        if (r12.contains(r6.a(r8, r5.pid)) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@NotNull Set<String> floatingBlackList) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) floatingBlackList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(floatingBlackList, "floatingBlackList");
        Set<String> d16 = d(floatingBlackList);
        if (d16.isEmpty()) {
            return false;
        }
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
            String str = runningAppProcessInfo.processName;
            Intrinsics.checkNotNullExpressionValue(str, "it.processName");
            String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
            Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
            if (startsWith$default) {
                b bVar = b.f257940a;
                String str2 = runningAppProcessInfo.processName;
                Intrinsics.checkNotNullExpressionValue(str2, "it.processName");
            }
            z16 = false;
            if (z16) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() != d16.size()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return defaultSensitiveFloating;
    }

    @NotNull
    public final Set<String> c() {
        Set<String> emptySet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        emptySet = SetsKt__SetsKt.emptySet();
        Set<String> decodeStringSet = from.decodeStringSet("float_window_state", emptySet);
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "entity.decodeStringSet(F\u2026WINDOW_STATE, emptySet())");
        return decodeStringSet;
    }

    @NotNull
    public final Set<String> d(@NotNull Set<String> floatingBlackList) {
        Set<String> intersect;
        Set<String> set;
        String decodeString;
        Set<String> emptySet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this, (Object) floatingBlackList);
        }
        Intrinsics.checkNotNullParameter(floatingBlackList, "floatingBlackList");
        intersect = CollectionsKt___CollectionsKt.intersect(c(), floatingBlackList);
        if (intersect.isEmpty()) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            if (!from.containsKey("process_prefix_" + str)) {
                decodeString = null;
            } else {
                decodeString = from.decodeString("process_prefix_" + str, "");
            }
            if (decodeString != null) {
                arrayList.add(decodeString);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        QLog.d("FloatingStateHelper", 2, "getFloatingProcess, " + set);
        return set;
    }
}
