package com.tencent.mobileqq.app.nthiddenchat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.data.d;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.msg.f;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000eH\u0007J\"\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0004J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0004J&\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J&\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"J\u0018\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/app/nthiddenchat/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/lang/Class;", "cls", "", "a", "Landroid/content/ComponentName;", "componentName", "e", "d", "", "sendUin", "", "type", "Lcom/tencent/common/app/AppInterface;", "app", h.F, "g", "peerUin", "isHidden", "chatType", "Lcom/tencent/qqnt/chats/data/d;", "k", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "c", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "b", "c2cSendUin", "TroopSendUin", "isC2C", "i", "uin", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "j", "troopUin", "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f196422a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f196422a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@NotNull Activity activity, @Nullable Class<?> cls) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!activity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
            return false;
        }
        Intent intent = new Intent(activity, cls);
        intent.putExtra("back_for_hidden_chat", true);
        intent.setFlags(603979776);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        return true;
    }

    @JvmStatic
    public static final boolean d(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!activity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("back_for_hidden_chat", true);
        intent.setFlags(603979776);
        ((ISettingApi) QRoute.api(ISettingApi.class)).startMainSettingPage(activity, intent);
        activity.overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        return true;
    }

    @JvmStatic
    public static final boolean e(@NotNull Activity activity, @Nullable ComponentName componentName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!activity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setFlags(603979776);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra(SplashActivity.FROM_HIDDEN_CHAT, true);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        return true;
    }

    private final boolean g(String sendUin) {
        aa recentContactService;
        boolean z16;
        boolean z17;
        boolean z18;
        Object obj;
        IKernelService i3 = f.i();
        if (i3 == null || (recentContactService = i3.getRecentContactService()) == null) {
            return false;
        }
        List<RecentContactInfo> M = recentContactService.M(5);
        Object obj2 = null;
        if (QLog.isDebugVersion()) {
            List<RecentContactInfo> list = M;
            if (list != null && !list.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                Iterator<T> it = M.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(sendUin, String.valueOf(((RecentContactInfo) obj).peerUin))) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    z18 = true;
                    QLog.d("NTHiddenChatUtil", 1, "[isExistInRecentCache] uin=" + sendUin + ", exist=" + z18);
                }
            }
            z18 = false;
            QLog.d("NTHiddenChatUtil", 1, "[isExistInRecentCache] uin=" + sendUin + ", exist=" + z18);
        }
        List<RecentContactInfo> list2 = M;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        Iterator<T> it5 = M.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (Intrinsics.areEqual(sendUin, String.valueOf(((RecentContactInfo) next).peerUin))) {
                obj2 = next;
                break;
            }
        }
        if (obj2 == null) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean h(@NotNull String sendUin, int type, @NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(sendUin, "sendUin");
        Intrinsics.checkNotNullParameter(app, "app");
        b bVar = f196422a;
        if (bVar.g(sendUin)) {
            return true;
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
        if (type == 1 && bVar.f(sendUin, app)) {
            return true;
        }
        if (type == 0 && bVar.j(sendUin, 0, app, from)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final d k(@NotNull String peerUin, boolean isHidden, int chatType) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        if (chatType == 0) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(peerUin);
            if (uidFromUin != null && !Intrinsics.areEqual(uidFromUin, "")) {
                return new d(uidFromUin, peerUin, 1, isHidden, false, false, 0L, 0L, 240, null);
            }
            return new d(peerUin, peerUin, 1, isHidden, false, false, 0L, 0L, 240, null);
        }
        return new d(peerUin, peerUin, 2, isHidden, false, false, 0L, 0L, 240, null);
    }

    public final boolean b(@NotNull Activity activity, @Nullable Class<? extends QPublicBaseFragment> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) cls)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        if (!intent.getBooleanExtra("back_for_hidden_chat", false)) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("back_for_hidden_chat", true);
        intent2.setFlags(603979776);
        intent.putExtra(BaseFragment.SHOULD_RESTORE_FROM_KILL, false);
        QPublicFragmentActivity.startForResult(activity, intent, cls, -1);
        activity.overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        return true;
    }

    public final boolean c(@NotNull Activity activity, @Nullable Class<? extends QIphoneTitleBarFragment> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) cls)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!activity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("back_for_hidden_chat", true);
        intent.setFlags(603979776);
        QPublicFragmentActivity.start(activity, intent, cls);
        activity.overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        return true;
    }

    public final boolean f(@Nullable String troopUin, @NotNull AppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin, (Object) app)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Manager manager = app.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopInfo k3 = ((TroopManager) manager).k(troopUin);
        if (k3 == null) {
            k3 = new TroopInfo(troopUin);
        }
        return TroopInfo.isCmdUinFlagEx2Open(k3.cmdUinFlagEx2, 512);
    }

    public final boolean i(@NotNull String c2cSendUin, @NotNull String TroopSendUin, boolean isC2C, @NotNull AppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, c2cSendUin, TroopSendUin, Boolean.valueOf(isC2C), app)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(c2cSendUin, "c2cSendUin");
        Intrinsics.checkNotNullParameter(TroopSendUin, "TroopSendUin");
        Intrinsics.checkNotNullParameter(app, "app");
        if (!isC2C) {
            c2cSendUin = TroopSendUin;
        }
        return h(c2cSendUin, !isC2C ? 1 : 0, app);
    }

    public final boolean j(@NotNull String uin, int type, @NotNull AppInterface app, @NotNull MMKVOptionEntity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, uin, Integer.valueOf(type), app, entity)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(entity, "entity");
        return entity.containsKey("hiddenChatStore" + app.getCurrentUin() + uin + type);
    }
}
