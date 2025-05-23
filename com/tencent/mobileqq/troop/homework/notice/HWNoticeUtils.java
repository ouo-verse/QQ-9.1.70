package com.tencent.mobileqq.troop.homework.notice;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.homework.b;
import com.tencent.mobileqq.troop.k;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.util.LoadingUtil;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J=\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0007J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J2\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeUtils;", "", "", "troopUin", "", "forceRefresh", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hasRole", "", "callback", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, h.F, "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeRoleType;", "f", "memberUin", "from", "e", "publishUin", "j", "i", "", "fileSize", "d", "g", "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HWNoticeUtils f297171a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/HWNoticeUtils$a", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f297172a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f297173b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f297174c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f297175d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/HWNoticeUtils$a$a", "Lcom/tencent/mobileqq/troop/homework/observer/a;", "", "isSuccess", "", "troopUin", "memberUin", "", "identity", "course", "stuName", "", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8739a extends com.tencent.mobileqq.troop.homework.observer.a {
            static IPatchRedirector $redirector_;
            final /* synthetic */ AppRuntime C;
            final /* synthetic */ long D;
            final /* synthetic */ Function1<Boolean, Unit> E;

            C8739a(AppRuntime appRuntime, long j3, Function1<? super Boolean, Unit> function1) {
                this.C = appRuntime;
                this.D = j3;
                this.E = function1;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, appRuntime, Long.valueOf(j3), function1);
                }
            }

            @Override // com.tencent.mobileqq.troop.homework.observer.a
            public void d(boolean isSuccess, @Nullable String troopUin, @Nullable String memberUin, int identity, @Nullable String course, @Nullable String stuName) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, memberUin, Integer.valueOf(identity), course, stuName);
                    return;
                }
                ((AppInterface) this.C).removeObserver(this);
                if (System.currentTimeMillis() - this.D > 3000) {
                    QLog.i("HW.Notice.", 1, "checkHasHWRoleInTroop, onGetHomeworkTroopIdentity time out.");
                    return;
                }
                QLog.i("HW.Notice.", 1, "checkHasHWRoleInTroop, onGetHomeworkTroopIdentity is " + identity + ".");
                ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateHwIdentity(troopUin, memberUin, identity, "HWNoticeUtils");
                this.E.invoke(Boolean.valueOf(((IHWTroopUtilsApi) QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(identity)));
            }
        }

        a(String str, Function1<? super Boolean, Unit> function1, boolean z16, AppRuntime appRuntime) {
            this.f297172a = str;
            this.f297173b = function1;
            this.f297174c = z16;
            this.f297175d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, function1, Boolean.valueOf(z16), appRuntime);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
                return;
            }
            if (troopMemberInfo == null) {
                QLog.w("HW.Notice.", 1, "checkHasHWRoleInTroop, member info is null, troop:" + this.f297172a + ".");
                this.f297173b.invoke(Boolean.FALSE);
                return;
            }
            int hWIdentity = troopMemberInfo.getHWIdentity();
            if (troopMemberInfo.extInfo != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("HW.Notice.", 1, "checkHasHWRoleInTroop, member hwIdentity is " + hWIdentity + ", hasExtInfo:" + z16 + ".");
            if (((IHWTroopUtilsApi) QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(troopMemberInfo.getHWIdentity()) && !this.f297174c) {
                this.f297173b.invoke(Boolean.TRUE);
                return;
            }
            AppRuntime appRuntime = this.f297175d;
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            Object businessHandler = ((AppInterface) appRuntime).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.homework.IHomeworkHandler");
            ((AppInterface) this.f297175d).addObserver(new C8739a(this.f297175d, System.currentTimeMillis(), this.f297173b));
            ((b) businessHandler).w2(this.f297172a, ((AppInterface) this.f297175d).getCurrentAccountUin());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52285);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f297171a = new HWNoticeUtils();
        }
    }

    HWNoticeUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String troopUin, boolean forceRefresh, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("HWNoticeUtils", 1, "checkHasHWRoleInTroop for " + troopUin + ", forceRefresh:" + forceRefresh);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(troopUin, peekAppRuntime.getCurrentUin(), false, null, "HWNoticeUtils", new a(troopUin, callback, forceRefresh, peekAppRuntime));
    }

    public static /* synthetic */ void b(String str, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        a(str, z16, function1);
    }

    @JvmStatic
    public static final void h(@NotNull Activity activity, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin);
        if (findTroopInfo == null) {
            QLog.e("HW.Notice.", 1, "gotoSetHWRoleTypeInTroop err, troop info is null.");
            return;
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.updateForTroopChatSetting(findTroopInfo, peekAppRuntime.getApplication().getResources(), peekAppRuntime.getCurrentUin());
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startTroopMemberCard(activity, peekAppRuntime, new k(findTroopInfo.troopuin, troopInfoData.isHomeworkTroop(), troopInfoData.troopColorNick, troopInfoData.troopColorNickId, eu.c(troopInfoData)), 2);
    }

    @NotNull
    public final View c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        View loadingView = LoadingUtil.getLoadingView(context, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        loadingView.setLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(loadingView, "getLoadingView(context,\n\u2026Params = params\n        }");
        return loadingView;
    }

    @NotNull
    public final String d(long fileSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, fileSize);
        }
        if (fileSize < 1024) {
            return fileSize + "B";
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0");
        double d16 = 1024;
        double d17 = d16 * 1024.0d;
        double d18 = d16 * d17;
        double d19 = fileSize;
        if (d19 < d17) {
            return decimalFormat.format(d19 / 1024.0d) + "KB";
        }
        if (d19 < d18) {
            return decimalFormat.format(d19 / d17) + "MB";
        }
        return decimalFormat.format(d19 / d18) + "GB";
    }

    public final void e(@NotNull String memberUin, @NotNull String troopUin, @NotNull String from, @NotNull Function1<? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, memberUin, troopUin, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(troopUin, memberUin, from, new HWNoticeUtils$getNickName$1(memberUin, callback));
    }

    @NotNull
    public final HWNoticeCons$HWNoticeRoleType f(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HWNoticeCons$HWNoticeRoleType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopMemberInfo troopMemberWithExtInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberWithExtInfoSync(troopUin, peekAppRuntime.getCurrentUin(), null, "HWNoticeUtils");
        TroopInfo troopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(troopUin);
        if (troopMemberWithExtInfoSync != null && (troopMemberWithExtInfoSync.getHWIdentity() == 332 || troopMemberWithExtInfoSync.getHWIdentity() == 333)) {
            return HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_TEACHER;
        }
        if (troopInfo.isOwnerOrAdmin()) {
            return HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_ADMIN_OR_OWNER;
        }
        return HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_PARENT;
    }

    @NotNull
    public final String g(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String str = ((ITroopInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(troopUin).troopname;
        Intrinsics.checkNotNullExpressionValue(str, "app.getRuntimeService(\n \u2026pInfo(troopUin).troopname");
        return str;
    }

    public final boolean i(@NotNull String publishUin, @NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) publishUin, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(publishUin, "publishUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return !j(publishUin, troopUin);
    }

    public final boolean j(@NotNull String publishUin, @NotNull String troopUin) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) publishUin, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(publishUin, "publishUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, publishUin) && f(troopUin) != HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_TEACHER) {
            return false;
        }
        return true;
    }
}
