package com.tencent.mobileqq.troop.troopownertask.api.impl;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J \u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001fJ\u0016\u0010$\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0015J\u0016\u0010%\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0015R&\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskCacheRepo;", "", "", "troopUin", "paramName", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "", "r", "g", "f", "", "k", "expectExpireTimeAbs", "o", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "task", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/a;", TabPreloadItem.TAB_NAME_MESSAGE, "p", h.F, "", "b", "c", ReportConstant.COSTREPORT_PREFIX, "d", "t", "", "l", "time", "u", "msg", "a", "e", "", "Ljava/util/Map;", "troopOwnerMsgMap", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "cacheKV", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopOwnerTaskCacheRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopOwnerTaskCacheRepo f300970a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, List<a>> troopOwnerMsgMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cacheKV;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        f300970a = new TroopOwnerTaskCacheRepo();
        troopOwnerMsgMap = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(TroopOwnerTaskCacheRepo$cacheKV$2.INSTANCE);
        cacheKV = lazy;
    }

    TroopOwnerTaskCacheRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MMKVOptionEntity i() {
        return (MMKVOptionEntity) cacheKV.getValue();
    }

    private final String j(String troopUin, String paramName) {
        return QMMKVFile.getKeyWithUin("TroopOwnerTaskRepo", "common_" + paramName + "_" + troopUin);
    }

    private final String m(String troopUin, String paramName) {
        return QMMKVFile.getKeyWithUin("TroopOwnerTaskRepo", "task_" + paramName + "_" + troopUin);
    }

    private final void r(String troopUin) {
        String j3 = j("", "allTroopUin");
        Set<String> decodeStringSet = i().decodeStringSet(j3, new LinkedHashSet());
        int size = decodeStringSet.size();
        decodeStringSet.add(troopUin);
        if (size != decodeStringSet.size()) {
            i().encodeStringSet(j3, decodeStringSet);
        }
    }

    public final void a(@NotNull String troopUin, @NotNull a msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) troopUin, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        i().encodeInt(j(troopUin, "closeMsgID_" + msg2.e()), 1);
    }

    public final boolean b(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (i().containsKey(m(troopUin, "taskNumber")) && i().containsKey(m(troopUin, "jumUrl"))) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        boolean decodeBool = i().decodeBool(j("", "hadShowRedDot"), false);
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskRepo", 2, "checkHadShowRedDot: " + decodeBool);
        }
        return decodeBool;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return i().decodeBool(j("", "hadShowTaskSettingItem"), false);
    }

    public final boolean e(@NotNull String troopUin, @NotNull a msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) troopUin, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (i().decodeInt(j(troopUin, "closeMsgID_" + msg2.e()), 0) != 1) {
            return false;
        }
        return true;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        for (String uin : i().decodeStringSet(j("", "allTroopUin"), new LinkedHashSet())) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            g(uin);
        }
    }

    public final void g(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            i().encodeLong(j(troopUin, "expireTimeAbsolute"), 0L);
        }
    }

    @Nullable
    public final List<a> h(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return troopOwnerMsgMap.get(troopUin);
    }

    public final long k(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin)).longValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return i().decodeLong(j(troopUin, "expireTimeAbsolute"), -1L);
    }

    public final int l(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) troopUin)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return i().decodeInt(j(troopUin, "lastCloseTaskTime"), 0);
    }

    @NotNull
    public final b n(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        int decodeInt = i().decodeInt(m(troopUin, "taskNumber"), 0);
        int decodeInt2 = i().decodeInt(m(troopUin, "latestTaskTime"), 0);
        String decodeString = i().decodeString(m(troopUin, "jumUrl"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "cacheKV.decodeString(get\u2026(troopUin, \"jumUrl\"), \"\")");
        int decodeInt3 = i().decodeInt(m(troopUin, "totalTaskNum"), 0);
        String decodeString2 = i().decodeString(m(troopUin, CacheTable.TABLE_NAME), "");
        Intrinsics.checkNotNullExpressionValue(decodeString2, "cacheKV.decodeString(get\u2026opUin, \"reportInfo\"), \"\")");
        return new b(troopUin, decodeInt, decodeInt2, decodeString, decodeInt3, decodeString2);
    }

    public final void o(@NotNull String troopUin, long expectExpireTimeAbs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, Long.valueOf(expectExpireTimeAbs));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        r(troopUin);
        i().encodeLong(j(troopUin, "expireTimeAbsolute"), expectExpireTimeAbs);
    }

    public final synchronized void p(@NotNull String troopUin, @NotNull List<a> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        troopOwnerMsgMap.put(troopUin, msgList);
    }

    public final void q(@NotNull String troopUin, @NotNull b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(task, "task");
        i().encodeInt(m(troopUin, "taskNumber"), task.c());
        i().encodeInt(m(troopUin, "latestTaskTime"), task.b());
        i().encodeString(m(troopUin, "jumUrl"), task.a());
        i().encodeInt(m(troopUin, "totalTaskNum"), task.e());
        i().encodeString(m(troopUin, CacheTable.TABLE_NAME), task.d());
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            i().encodeBool(j("", "hadShowRedDot"), true);
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            i().encodeBool(j("", "hadShowTaskSettingItem"), true);
        }
    }

    public final void u(@NotNull String troopUin, int time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) troopUin, time);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            i().encodeInt(j(troopUin, "lastCloseTaskTime"), time);
        }
    }
}
