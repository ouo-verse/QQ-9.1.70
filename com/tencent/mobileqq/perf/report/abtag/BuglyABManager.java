package com.tencent.mobileqq.perf.report.abtag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/perf/report/abtag/BuglyABManager;", "", "", "key", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "a", "<init>", "()V", "ABTag", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class BuglyABManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final BuglyABManager f258016a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/perf/report/abtag/BuglyABManager$ABTag;", "", "(Ljava/lang/String;I)V", "ZPlanFilament", "SwitchAccountRebootExp", "SwitchAccountRebootContrast", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class ABTag {
        private static final /* synthetic */ ABTag[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ABTag SwitchAccountRebootContrast;
        public static final ABTag SwitchAccountRebootExp;
        public static final ABTag ZPlanFilament;

        private static final /* synthetic */ ABTag[] $values() {
            return new ABTag[]{ZPlanFilament, SwitchAccountRebootExp, SwitchAccountRebootContrast};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35199);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ZPlanFilament = new ABTag("ZPlanFilament", 0);
            SwitchAccountRebootExp = new ABTag("SwitchAccountRebootExp", 1);
            SwitchAccountRebootContrast = new ABTag("SwitchAccountRebootContrast", 2);
            $VALUES = $values();
        }

        ABTag(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ABTag valueOf(String str) {
            return (ABTag) Enum.valueOf(ABTag.class, str);
        }

        public static ABTag[] values() {
            return (ABTag[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258016a = new BuglyABManager();
        }
    }

    BuglyABManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String key, boolean r17) {
        Set<String> emptySet;
        Set<String> mutableSet;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        emptySet = SetsKt__SetsKt.emptySet();
        Set<String> decodeStringSet = from.decodeStringSet("bugly_ab_saved_tag", emptySet);
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "entity.decodeStringSet(B\u2026AB_SAVED_TAG, emptySet())");
        mutableSet = CollectionsKt___CollectionsKt.toMutableSet(decodeStringSet);
        if (r17 == mutableSet.contains(key)) {
            QLog.d("BuglyABManager", 1, "updateABTag return, same state, key:" + key + ", switch:" + r17);
            return;
        }
        if (r17) {
            mutableSet.add(key);
        } else {
            mutableSet.remove(key);
        }
        from.encodeStringSet("bugly_ab_saved_tag", mutableSet);
        a aVar = a.f258017a;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(mutableSet, "|", null, null, 0, null, null, 62, null);
        aVar.a(joinToString$default, key, r17);
        QLog.d("BuglyABManager", 1, "updateABTag ok, key:" + key + ", switch:" + r17);
    }
}
