package com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendVerifyDlgEvent;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.x;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.pad.l;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ0\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u000eJ0\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\bR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R*\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", "Landroidx/lifecycle/ViewModel;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "W1", "Landroid/content/Intent;", "intent", "", "X1", "", "sourceId", "friendSetting", "P1", "", "troopUin", "prefix", "verifyMsg", "O1", "S1", "N1", "mSourceId", "mAddUin", "U1", "result", "msg", "R1", "Landroid/os/Bundle;", "bundle", "d2", "errorStr", "e2", "c2", "M1", "i", "Z", "getMIsFromNearby", "()Z", "b2", "(Z)V", "mIsFromNearby", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMIsFromMatchFriend", ICustomDataEditor.STRING_ARRAY_PARAM_2, "mIsFromMatchFriend", BdhLogUtil.LogTag.Tag_Conn, "getMIsFromGroup", "Z1", "mIsFromGroup", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "setTicket", "(Landroidx/lifecycle/MutableLiveData;)V", "ticket", "<init>", "()V", "E", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsFromGroup;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<String> ticket;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFromNearby;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFromMatchFriend;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f$a;", "", "", "DELAY_BACK_TIME", "I", "MAX_TROOP_NAME_LENGTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24134);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.ticket = new MutableLiveData<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(int i3, int i16, boolean z16, String troopUin, int i17) {
        String str;
        String valueOf;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (i3 == 3004) {
            if (i16 == 5 || i16 == 6 || i16 == 7 || i16 == 8) {
                if (z16) {
                    str = "multiMode_send";
                } else {
                    str = "singleMode_send";
                }
                String str2 = str;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (z16) {
                    valueOf = "1";
                } else {
                    valueOf = String.valueOf(i17);
                }
                ReportController.o(peekAppRuntime, "dc00899", "Grp_addFrd", "", "frd_select", str2, 0, 0, troopUin, valueOf, "", "");
            }
        }
    }

    private final boolean W1(Activity activity) {
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
            QLog.i("SendViewModel", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is true");
            if (activity != null) {
                activity.onKeyDown(4, new KeyEvent(4, 4));
            }
            return true;
        }
        QLog.i("SendViewModel", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is false");
        return false;
    }

    public final void M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new AddFriendVerifyDlgEvent(4));
        }
    }

    @NotNull
    public final String N1(@NotNull Intent intent, @NotNull String prefix, @NotNull String verifyMsg) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, intent, prefix, verifyMsg);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(verifyMsg, "verifyMsg");
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        if (!TextUtils.isEmpty(stringExtra)) {
            String matchFriendAppName = ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).matchFriendAppName(MobileQQ.sMobileQQ.peekAppRuntime());
            if (TextUtils.isEmpty(matchFriendAppName)) {
                str = prefix + stringExtra;
            } else {
                str = prefix + matchFriendAppName + '\u7684' + stringExtra;
            }
            verifyMsg = str;
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return verifyMsg + com.tencent.mobileqq.addfriend.utils.a.g(MobileQQ.sMobileQQ.peekAppRuntime());
        }
        return verifyMsg;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String O1(@NotNull Intent intent, @Nullable Activity activity, @NotNull String troopUin, @NotNull String prefix, @NotNull String verifyMsg) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, this, intent, activity, troopUin, prefix, verifyMsg);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(verifyMsg, "verifyMsg");
        AppInterface f16 = com.tencent.mobileqq.addfriend.utils.a.f();
        if (this.mIsFromNearby) {
            String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (stringExtra != null && stringExtra.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(prefix);
                if (activity != null) {
                    str = activity.getString(R.string.ykd);
                } else {
                    str = null;
                }
                sb5.append(str);
                verifyMsg = sb5.toString() + stringExtra;
                z17 = false;
            }
            if (z17) {
                return verifyMsg + com.tencent.mobileqq.addfriend.utils.a.g(f16);
            }
            return verifyMsg;
        }
        if (this.mIsFromMatchFriend) {
            verifyMsg = N1(intent, prefix, verifyMsg);
        } else {
            if (this.mIsFromGroup) {
                verifyMsg = S1(activity, troopUin);
            }
            if (z17) {
            }
        }
        z17 = false;
        if (z17) {
        }
    }

    public final void P1(@Nullable Activity activity, @NotNull Intent intent, final int sourceId, final int friendSetting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, intent, Integer.valueOf(sourceId), Integer.valueOf(friendSetting));
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (activity == null) {
            return;
        }
        final boolean booleanExtra = intent.getBooleanExtra("select_multi_mode", false);
        String stringExtra = intent.getStringExtra("troop_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        final String str = stringExtra;
        final int intExtra = intent.getIntExtra("sub_source_id", 0);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.e
            @Override // java.lang.Runnable
            public final void run() {
                f.Q1(sourceId, intExtra, booleanExtra, str, friendSetting);
            }
        }, 5, null, true);
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddFriendClick(sourceId);
    }

    public final void R1(int mSourceId, @NotNull Intent intent, @Nullable Activity activity, int result, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(mSourceId), intent, activity, Integer.valueOf(result), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (activity != null && !activity.isFinishing() && mSourceId == 3090) {
            try {
                String stringExtra = intent.getStringExtra("extra");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                ((IForwardApi) QRoute.api(IForwardApi.class)).startGameSdkCallback(activity, true, "action_game_make_friend", Long.parseLong(stringExtra), result, msg2);
            } catch (Exception e16) {
                QLog.e("SendViewModel", 1, "feedBackToGameSDK error = " + e16);
            }
        }
    }

    @NotNull
    public final String S1(@Nullable Activity activity, @NotNull String troopUin) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppInterface f16 = com.tencent.mobileqq.addfriend.utils.a.f();
        String str3 = "";
        if (f16 == null) {
            str = "";
            str2 = str;
        } else {
            str2 = com.tencent.mobileqq.addfriend.utils.a.l(f16, troopUin);
            Intrinsics.checkNotNullExpressionValue(str2, "getTroopName(mApp, troopUin)");
            if (Intrinsics.areEqual(troopUin, str2)) {
                QLog.i("SendViewModel", 1, "get TroopName Fail " + troopUin);
                str2 = "";
            }
            str = com.tencent.mobileqq.addfriend.utils.a.k(f16, troopUin, f16.getAccount());
            Intrinsics.checkNotNullExpressionValue(str, "getTroopMemberName(mApp, troopUin, mApp.account)");
            if (TextUtils.isEmpty(str) || Intrinsics.areEqual(str, f16.getAccount())) {
                str = com.tencent.mobileqq.addfriend.utils.a.g(f16);
                Intrinsics.checkNotNullExpressionValue(str, "getFriendNick(mApp)");
            }
        }
        String str4 = null;
        if (TextUtils.isEmpty(str2)) {
            if (activity != null) {
                str4 = activity.getString(R.string.axv);
            }
            if (str4 != null) {
                str3 = str4;
            }
            return str3 + str;
        }
        if (str2.length() > 20) {
            StringBuilder sb5 = new StringBuilder();
            String substring = str2.substring(0, 17);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            str2 = sb5.toString();
        }
        if (activity != null) {
            str4 = activity.getString(R.string.zvc, str2, str);
        }
        if (str4 == null) {
            return str2 + " - " + str;
        }
        return str4;
    }

    @NotNull
    public final MutableLiveData<String> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.ticket;
    }

    public final void U1(int mSourceId, @NotNull Intent intent, @Nullable Activity activity, @NotNull String mAddUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(mSourceId), intent, activity, mAddUin);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(mAddUin, "mAddUin");
        if (activity != null && !activity.isFinishing()) {
            if (intent.getBooleanExtra("need_jumpto_splash", false)) {
                if (W1(activity)) {
                    return;
                }
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToSplash(activity);
                activity.finish();
                return;
            }
            String stringExtra = intent.getStringExtra("param_return_addr");
            if (QLog.isColorLevel()) {
                QLog.d("SendViewModel", 2, "goBack | retAddr = " + stringExtra);
            }
            if (stringExtra != null) {
                try {
                    Intent composeReturnIntent = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).composeReturnIntent(Class.forName(stringExtra), mAddUin, activity);
                    AllInOne allInOne = (AllInOne) composeReturnIntent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
                    if (allInOne != null) {
                        allInOne.uid = intent.getStringExtra("profile_uid");
                    }
                    if (allInOne != null) {
                        allInOne.nickname = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
                    }
                    if (AppSetting.t(activity) && (activity instanceof l)) {
                        i.e(activity, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardBundle(activity, allInOne, new Bundle()), ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardFragmentClass(), new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.singleTop).a());
                        return;
                    } else {
                        activity.startActivity(composeReturnIntent);
                        return;
                    }
                } catch (ClassNotFoundException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SendViewModel", 2, "goBack | exception = ", e16);
                    }
                    e16.printStackTrace();
                    if (W1(activity)) {
                        return;
                    }
                    activity.setResult(-1);
                    activity.finish();
                    return;
                }
            }
            if (W1(activity)) {
                return;
            }
            if (intent.getBooleanExtra("from_newer_guide", false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("has_operation", true);
                intent2.putExtra("uin", mAddUin);
                activity.setResult(-1, intent2);
            } else {
                R1(mSourceId, intent, activity, 0, "");
                activity.setResult(-1);
            }
            activity.finish();
        }
    }

    public final void X1(@Nullable Activity activity, @NotNull Intent intent) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(INewFriendVerificationService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
        INewFriendVerificationService iNewFriendVerificationService = (INewFriendVerificationService) runtimeService;
        if (activity != null) {
            int intExtra = intent.getIntExtra("friend_setting", 0);
            int intExtra2 = intent.getIntExtra("source_id", BuddySource.DEFAULT);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                str = extras.getString("extra");
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            iNewFriendVerificationService.reportAddFriendBlocked(intent.getStringExtra("uin"), intExtra, intExtra2, intent.getIntExtra("sub_source_id", 0), str2);
        }
    }

    public final void Z1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mIsFromGroup = z16;
        }
    }

    public final void a2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mIsFromMatchFriend = z16;
        }
    }

    public final void b2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mIsFromNearby = z16;
        }
    }

    public final void c2(@NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AddFriendVerifyDlgEvent addFriendVerifyDlgEvent = new AddFriendVerifyDlgEvent(3);
        addFriendVerifyDlgEvent.setErrorTips(msg2);
        SimpleEventBus.getInstance().dispatchEvent(addFriendVerifyDlgEvent);
    }

    public final void d2(@NotNull Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AddFriendVerifyDlgEvent addFriendVerifyDlgEvent = new AddFriendVerifyDlgEvent(1);
        String string = bundle.getString("error_tips_wording");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        String string2 = bundle.getString("error_tips_cancel_wording");
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        String string3 = bundle.getString("error_tips_jump_btn_wording");
        if (string3 == null) {
            str3 = "";
        } else {
            str3 = string3;
        }
        String string4 = bundle.getString("error_tips_h5_url");
        if (string4 == null) {
            str4 = "";
        } else {
            str4 = string4;
        }
        String string5 = bundle.getString("error_tips_mini_app_url");
        if (string5 == null) {
            string5 = "";
        }
        addFriendVerifyDlgEvent.setShowErrorTipsParamsWithHandleAbility(new x(str, str2, str3, str4, string5));
        SimpleEventBus.getInstance().dispatchEvent(addFriendVerifyDlgEvent);
    }

    public final void e2(@NotNull String errorStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) errorStr);
            return;
        }
        Intrinsics.checkNotNullParameter(errorStr, "errorStr");
        AddFriendVerifyDlgEvent addFriendVerifyDlgEvent = new AddFriendVerifyDlgEvent(2);
        addFriendVerifyDlgEvent.setSecurityTips(errorStr);
        SimpleEventBus.getInstance().dispatchEvent(addFriendVerifyDlgEvent);
    }
}
