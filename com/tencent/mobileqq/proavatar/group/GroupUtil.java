package com.tencent.mobileqq.proavatar.group;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J0\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nH\u0002J \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J'\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u001b\u0010%\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/proavatar/group/GroupUtil;", "Lcom/tencent/qqnt/avatar/meta/cache/b;", "", "troopUin", "", "value", "key", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "g", DomainData.DOMAIN_NAME, "i", "o", "k", "", "l", "j", "avatarType", "id", "b", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "infoArr", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "groupUinSet", "c", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "isSwitchOn", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class GroupUtil implements com.tencent.qqnt.avatar.meta.cache.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GroupUtil f259599a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArraySet<String> groupUinSet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isSwitchOn;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f259599a = new GroupUtil();
        groupUinSet = new CopyOnWriteArraySet<>();
        lazy = LazyKt__LazyJVMKt.lazy(GroupUtil$isSwitchOn$2.INSTANCE);
        isSwitchOn = lazy;
    }

    GroupUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(final String troopUin, final int value, final String key) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.proavatar.group.a
            @Override // java.lang.Runnable
            public final void run() {
                GroupUtil.f(troopUin, value, key);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String troopUin, int i3, String key) {
        int i16;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(key, "$key");
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHeadFromDb(troopUin, true)) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        QLog.i("GroupUtil", 1, "checkHasSetTroopHeadAndRefresh " + troopUin + MsgSummary.STR_COLON + i3 + " -> " + i16);
        if (i16 != i3) {
            f259599a.n(key, i16);
            AvatarInfoCheck.b(4, troopUin);
        }
    }

    private final void g(final String troopUin, final ArrayList<String> uinList, final String key) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.proavatar.group.b
            @Override // java.lang.Runnable
            public final void run() {
                GroupUtil.h(troopUin, uinList, key);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String troopUin, ArrayList uinList, String key) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(uinList, "$uinList");
        Intrinsics.checkNotNullParameter(key, "$key");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nstant.MAIN\n            )");
        ArrayList<String> newUinList = ((ITroopInfoService) runtimeService).getTroopMemberForTroopHead(troopUin);
        int i3 = 0;
        if (newUinList.size() > 0 && newUinList.size() != uinList.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int size = newUinList.size();
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (!Intrinsics.areEqual(newUinList.get(i3), uinList.get(i3))) {
                    z16 = true;
                    break;
                }
                i3++;
            }
        }
        QLog.i("GroupUtil", 1, "checkTroopMemberAndRefresh update(" + z16 + ") " + key + MsgSummary.STR_COLON + newUinList);
        if (z16) {
            GroupUtil groupUtil = f259599a;
            Intrinsics.checkNotNullExpressionValue(newUinList, "newUinList");
            groupUtil.o(key, newUinList);
            AvatarInfoCheck.b(4, troopUin);
        }
    }

    private final int i(String key) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeInt(key, 0);
    }

    private final ArrayList<String> k(String key) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String uinSet = from.decodeString(key, "");
        ArrayList<String> arrayList = new ArrayList<>();
        Intrinsics.checkNotNullExpressionValue(uinSet, "uinSet");
        Object[] array = new Regex(";").split(uinSet, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private final void n(String key, int value) {
        QLog.i("GroupUtil", 4, "saveHasSetTroopHeadToMMKV " + key + " " + value);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt(key, value);
    }

    private final void o(String key, ArrayList<String> value) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        StringBuilder sb5 = new StringBuilder(128);
        Iterator<String> it = value.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        QLog.i("GroupUtil", 4, "saveTroopMemberHeadToMMKV " + key + " " + ((Object) sb5));
        from.encodeString(key, sb5.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r0 != false) goto L21;
     */
    @Override // com.tencent.qqnt.avatar.meta.cache.b
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArr) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) avatarBean, (Object) infoArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        if ((avatarBean.a() == 4 || avatarBean.a() == 113) && !TextUtils.isEmpty(avatarBean.c())) {
            if (infoArr != null) {
                z16 = false;
                if (infoArr.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z16 = true;
            if (!z16 && infoArr.length > 1 && m()) {
                return "_splicing_v2";
            }
        }
        return "";
    }

    @Override // com.tencent.qqnt.avatar.meta.cache.b
    public void b(int avatarType, @Nullable String id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, avatarType, (Object) id5);
            return;
        }
        if ((avatarType != 4 && avatarType != 113) || TextUtils.isEmpty(id5)) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("GroupUtil", 4, "clearCache " + id5);
        }
        n("proavatar_key_has_set_troop_head_" + id5, 0);
        o("proavatar_key_get_troop_member_head_" + id5 + "_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), new ArrayList<>());
    }

    @NotNull
    public final ArrayList<String> j(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "proavatar_key_get_troop_member_head_" + troopUin + "_" + peekAppRuntime.getCurrentUin();
        ArrayList<String> k3 = k(str);
        if (k3.isEmpty()) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nstant.MAIN\n            )");
            k3 = ((ITroopInfoService) runtimeService).getTroopMemberForTroopHead(troopUin);
            Intrinsics.checkNotNullExpressionValue(k3, "troopInfoService.getTroo\u2026berForTroopHead(troopUin)");
            o(str, k3);
            QLog.i("GroupUtil", 1, "getTroopMemberForTroopHead " + str + MsgSummary.STR_COLON + k3);
        }
        CopyOnWriteArraySet<String> copyOnWriteArraySet = groupUinSet;
        if (!copyOnWriteArraySet.contains(str)) {
            copyOnWriteArraySet.add(str);
            g(troopUin, k3, str);
        }
        if (m()) {
            return k3;
        }
        if (k3.size() > 4) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(k3.subList(0, 4));
            return arrayList;
        }
        return k3;
    }

    public final boolean l(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String str = "proavatar_key_has_set_troop_head_" + troopUin;
        int i3 = i(str);
        if (i3 == 0) {
            if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHeadFromDb(troopUin, true)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            QLog.i("GroupUtil", 1, "hasSetTroopHead " + troopUin + ": default -> " + i3);
            n(str, i3);
        }
        CopyOnWriteArraySet<String> copyOnWriteArraySet = groupUinSet;
        if (!copyOnWriteArraySet.contains(str)) {
            copyOnWriteArraySet.add(str);
            e(troopUin, i3, str);
        }
        if (2 == i3) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) isSwitchOn.getValue()).booleanValue();
    }
}
