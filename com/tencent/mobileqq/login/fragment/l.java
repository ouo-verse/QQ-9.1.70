package com.tencent.mobileqq.login.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J,\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010H\u0007J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010H\u0007J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u0006\u0010 \u001a\u00020\u0017J\u0010\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\f2\u0006\u0010&\u001a\u00020\tJ\u0016\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cR(\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\f0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010,R\"\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010E\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0013\u0010H\u001a\u0004\u0018\u00010\u00128F\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010K\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/l;", "", "Landroid/content/Intent;", "intent", "", "o", "", "Lcom/tencent/mobileqq/login/account/a;", "accountList", "", "i", "jumpFragmentType", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "f", "e", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "args", "forceRoot", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fragment", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "uin", "finishAllActivity", "r", "l", "finishRoot", "b", "Lcom/tencent/mobileqq/loginregister/w;", "proxy", "a", "fragmentType", "g", "phone1", "phone2", DomainData.DOMAIN_NAME, "", "Ljava/util/Map;", "typeFragmentMap", "", "Lmqq/util/WeakReference;", "c", "Ljava/util/List;", "loginActivityList", "loginFragmentList", "I", "getRootFragmentType", "()I", "setRootFragmentType", "(I)V", "rootFragmentType", "Z", "getHasShownRegisterGuide", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "hasShownRegisterGuide", "Lcom/tencent/mobileqq/loginregister/w;", tl.h.F, "()Lcom/tencent/mobileqq/loginregister/w;", "t", "(Lcom/tencent/mobileqq/loginregister/w;)V", "loginProxy", "j", "()Landroid/app/Activity;", "topLoginActivity", "k", "()Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "topLoginFragment", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f242160a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Class<? extends BaseLoginFragment>> typeFragmentMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<Activity>> loginActivityList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<BaseLoginFragment>> loginFragmentList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int rootFragmentType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean hasShownRegisterGuide;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.loginregister.w loginProxy;

    static {
        Map<Integer, Class<? extends BaseLoginFragment>> mutableMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        f242160a = new l();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, LoginRegisterGuideFragment.class), TuplesKt.to(3, GatewayLoginFragment.class), TuplesKt.to(4, PhoneNumLoginFragment.class), TuplesKt.to(5, AccountLoginFragment.class), TuplesKt.to(6, ReLoginFragment.class));
        typeFragmentMap = mutableMapOf;
        loginActivityList = new ArrayList();
        loginFragmentList = new ArrayList();
        rootFragmentType = 5;
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(l lVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        lVar.b(z16);
    }

    private final Class<? extends QBaseActivity> f(int jumpFragmentType) {
        int i3 = rootFragmentType;
        if (i3 == 1) {
            return LoginActivity.class;
        }
        if (i3 == 6 && jumpFragmentType == 6) {
            return LoginActivity.class;
        }
        return LoginPublicFragmentActivity.class;
    }

    private final int i(Intent intent, List<com.tencent.mobileqq.login.account.a> accountList) {
        String str;
        com.tencent.mobileqq.login.account.a aVar;
        Integer num;
        boolean z16;
        PBStringField pBStringField;
        String stringExtra = intent.getStringExtra("uin");
        int size = accountList.size();
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 < size) {
                if (Intrinsics.areEqual(accountList.get(i3).f(), stringExtra)) {
                    aVar = accountList.get(i3);
                    break;
                }
                i3++;
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar != null) {
            num = Integer.valueOf(aVar.b());
        } else {
            num = null;
        }
        if ((num != null && num.intValue() == 4) || (num != null && num.intValue() == 5)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String a16 = aVar.a();
            String str2 = "";
            if (a16 == null) {
                a16 = "";
            }
            GetLocalPhone$MaskPhoneData mMaskPhoneData = aj.f306554f.getMMaskPhoneData();
            if (mMaskPhoneData != null && (pBStringField = mMaskPhoneData.str_mask_phone) != null) {
                str = pBStringField.get();
            }
            if (str != null) {
                str2 = str;
            }
            if (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(a16) || n(a16, str2))) {
                z17 = true;
            }
            if (z17) {
                return 3;
            }
            Pair<String, String> e16 = aVar.e();
            if (e16 == null) {
                return 4;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                extras.putString("country_code", e16.getFirst());
            }
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                return 4;
            }
            extras2.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, e16.getSecond());
            return 4;
        }
        if (num != null && num.intValue() == 7) {
            Pair<String, String> e17 = aVar.e();
            if (e17 != null) {
                Bundle extras3 = intent.getExtras();
                if (extras3 != null) {
                    extras3.putString("country_code", e17.getFirst());
                }
                Bundle extras4 = intent.getExtras();
                if (extras4 != null) {
                    extras4.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, e17.getSecond());
                }
            }
            return 4;
        }
        Bundle extras5 = intent.getExtras();
        if (extras5 != null) {
            extras5.putString("uin", stringExtra);
        }
        return 5;
    }

    private final boolean o(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("isActionSend", false);
        boolean booleanExtra2 = intent.getBooleanExtra("is_need_login_with_mask", false);
        if (hasShownRegisterGuide || booleanExtra || booleanExtra2) {
            return false;
        }
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null && !allAccounts.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void a(@Nullable com.tencent.mobileqq.loginregister.w proxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) proxy);
        } else if (Intrinsics.areEqual(proxy, loginProxy)) {
            loginProxy = null;
        }
    }

    public final void b(boolean finishRoot) {
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, finishRoot);
            return;
        }
        Iterator<WeakReference<Activity>> it = loginActivityList.iterator();
        BaseLoginFragment baseLoginFragment = null;
        Activity activity = null;
        while (it.hasNext()) {
            Activity activity2 = it.next().get();
            if (activity2 != null) {
                if (!finishRoot && (activity2 instanceof LoginActivity)) {
                    LoginActivity loginActivity = (LoginActivity) activity2;
                    if (!loginActivity.isFinishing() && !loginActivity.isDestroyed()) {
                        activity = activity2;
                    }
                } else if (!activity2.isFinishing()) {
                    activity2.finish();
                }
            }
        }
        if (activity != null) {
            Iterator<WeakReference<BaseLoginFragment>> it5 = loginFragmentList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                BaseLoginFragment baseLoginFragment2 = it5.next().get();
                if (baseLoginFragment2 != null) {
                    fragmentActivity = baseLoginFragment2.getActivity();
                } else {
                    fragmentActivity = null;
                }
                if (Intrinsics.areEqual(fragmentActivity, activity)) {
                    baseLoginFragment = baseLoginFragment2;
                    break;
                }
            }
        }
        List<WeakReference<Activity>> list = loginActivityList;
        list.clear();
        if (activity != null) {
            list.add(new WeakReference<>(activity));
        }
        List<WeakReference<BaseLoginFragment>> list2 = loginFragmentList;
        list2.clear();
        if (baseLoginFragment != null) {
            list2.add(new WeakReference<>(baseLoginFragment));
        }
    }

    @NotNull
    public final BaseLoginFragment d(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BaseLoginFragment) iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        int e16 = e(intent);
        Class<? extends BaseLoginFragment> cls = typeFragmentMap.get(Integer.valueOf(e16));
        if (cls != null) {
            try {
                BaseLoginFragment fragment = cls.newInstance();
                fragment.Nh(e16);
                fragment.setArguments(intent.getExtras());
                rootFragmentType = e16;
                QLog.i("LoginFragmentManager", 1, "root login fragment " + e16);
                Intrinsics.checkNotNullExpressionValue(fragment, "fragment");
                return fragment;
            } catch (Exception e17) {
                QLog.e("LoginFragmentManager", 1, "newInstance fragment exception", e17);
            }
        }
        rootFragmentType = 5;
        QLog.i("LoginFragmentManager", 1, "root login fragment 5");
        AccountLoginFragment accountLoginFragment = new AccountLoginFragment();
        accountLoginFragment.Nh(5);
        accountLoginFragment.setArguments(intent.getExtras());
        return accountLoginFragment;
    }

    public final int e(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent)).intValue();
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("loginFragmentType", 0);
        Class<? extends BaseLoginFragment> cls = typeFragmentMap.get(Integer.valueOf(intExtra));
        if (cls == null && o(intent)) {
            QLog.i("LoginFragmentManager", 2, "getFirstLoginFragmentType register guide");
            return 1;
        }
        if (cls != null) {
            QLog.i("LoginFragmentManager", 1, "getFirstLoginFragmentType assign " + intExtra);
            return intExtra;
        }
        List<com.tencent.mobileqq.login.account.a> f16 = com.tencent.mobileqq.login.account.d.f241848a.f();
        if (f16.isEmpty()) {
            if (aj.f306554f.g()) {
                return 3;
            }
            return 4;
        }
        if (intent.getBooleanExtra("switch_account_fail", false)) {
            QLog.i("LoginFragmentManager", 1, "switch fail jump");
            return i(intent, f16);
        }
        return 6;
    }

    @NotNull
    public final Class<? extends BaseLoginFragment> g(int fragmentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Class) iPatchRedirector.redirect((short) 19, (Object) this, fragmentType);
        }
        Class<? extends BaseLoginFragment> cls = typeFragmentMap.get(Integer.valueOf(fragmentType));
        if (cls != null) {
            return cls;
        }
        throw new IllegalArgumentException("fragmentType " + fragmentType + " is not support");
    }

    @Nullable
    public final com.tencent.mobileqq.loginregister.w h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.loginregister.w) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return loginProxy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Activity j() {
        List reversed;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            reversed = CollectionsKt___CollectionsKt.reversed(loginActivityList);
            Iterator it = reversed.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) ((WeakReference) it.next()).get();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final BaseLoginFragment k() {
        List reversed;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            reversed = CollectionsKt___CollectionsKt.reversed(loginFragmentList);
            Iterator it = reversed.iterator();
            while (true) {
                FragmentActivity fragmentActivity = null;
                if (!it.hasNext()) {
                    return null;
                }
                BaseLoginFragment baseLoginFragment = (BaseLoginFragment) ((WeakReference) it.next()).get();
                if (baseLoginFragment != null) {
                    fragmentActivity = baseLoginFragment.getActivity();
                }
                if (fragmentActivity != null && !fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
                    return baseLoginFragment;
                }
            }
        } else {
            return (BaseLoginFragment) iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Iterator<WeakReference<BaseLoginFragment>> it = loginFragmentList.iterator();
        while (it.hasNext()) {
            BaseLoginFragment baseLoginFragment = it.next().get();
            if (baseLoginFragment != null) {
                baseLoginFragment.hideLoading();
            }
            if (baseLoginFragment != null) {
                baseLoginFragment.Ph();
            }
        }
    }

    public final void m(@Nullable Activity activity, int jumpFragmentType, @Nullable Bundle args, boolean forceRoot) {
        Class<? extends QBaseActivity> f16;
        String str;
        String str2;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, Integer.valueOf(jumpFragmentType), args, Boolean.valueOf(forceRoot));
            return;
        }
        if (activity == null) {
            QLog.w("LoginFragmentManager", 1, "jumpLoginFragment but activity is null");
            return;
        }
        if (jumpFragmentType == 3) {
            String str3 = "";
            if (args == null || (str = args.getString("previousPhoneNum")) == null) {
                str = "";
            }
            GetLocalPhone$MaskPhoneData mMaskPhoneData = aj.f306554f.getMMaskPhoneData();
            if (mMaskPhoneData != null && (pBStringField = mMaskPhoneData.str_mask_phone) != null) {
                str2 = pBStringField.get();
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str3 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                if (!TextUtils.isEmpty(str) && !n(str, str3)) {
                    QLog.i("LoginFragmentManager", 1, "try to jump gateway fragment, but maskPhoneNum is not match");
                }
            } else {
                QLog.i("LoginFragmentManager", 1, "try to jump gateway fragment, but maskPhoneNum is not exist");
            }
            jumpFragmentType = 4;
        }
        Bundle bundle = new Bundle();
        if (args != null) {
            bundle.putAll(args);
        }
        bundle.putInt("loginFragmentType", jumpFragmentType);
        if (forceRoot) {
            f16 = LoginActivity.class;
        } else {
            f16 = f(jumpFragmentType);
        }
        if (Intrinsics.areEqual(f16, LoginActivity.class)) {
            rootFragmentType = jumpFragmentType;
            QLog.i("LoginFragmentManager", 1, "root login fragment " + jumpFragmentType);
            Intent intent = new Intent(activity, (Class<?>) LoginActivity.class);
            intent.putExtras(bundle);
            intent.addFlags(536870912);
            activity.startActivity(intent);
            QLog.i("LoginFragmentManager", 2, "jump LoginActivity fragmentType=" + jumpFragmentType);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtras(bundle);
        LoginPublicFragmentActivity.INSTANCE.a(activity, intent2, g(jumpFragmentType));
        QLog.i("LoginFragmentManager", 2, "jump LoginPublicFragmentActivity fragmentType=" + jumpFragmentType);
    }

    public final boolean n(@NotNull String phone1, @NotNull String phone2) {
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) phone1, (Object) phone2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(phone1, "phone1");
        Intrinsics.checkNotNullParameter(phone2, "phone2");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(phone1, Marker.ANY_NON_NULL_MARKER, false, 2, null);
        if (!startsWith$default) {
            phone1 = "+86 " + phone1;
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(phone2, Marker.ANY_NON_NULL_MARKER, false, 2, null);
        if (!startsWith$default2) {
            phone2 = "+86 " + phone2;
        }
        if (phone1.length() != phone2.length()) {
            return false;
        }
        int length = phone1.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (phone1.charAt(i3) != '*' && phone2.charAt(i3) != '*' && phone1.charAt(i3) != phone2.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    public final void p(@NotNull BaseLoginFragment fragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        loginFragmentList.add(new WeakReference<>(fragment));
        FragmentActivity activity = fragment.getActivity();
        Iterator<WeakReference<Activity>> it = loginActivityList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().get(), activity)) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            loginActivityList.add(new WeakReference<>(activity));
        }
    }

    @MainThread
    public final void q(@NotNull BaseLoginFragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Iterator<WeakReference<BaseLoginFragment>> it = loginFragmentList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), fragment)) {
                it.remove();
            }
        }
    }

    @MainThread
    public final void r(@NotNull String uin, boolean finishAllActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, uin, Boolean.valueOf(finishAllActivity));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("LoginFragmentManager", 1, "onLoginSuccessCompleted uin=" + StringUtil.getSimpleUinForPrint(uin));
        Iterator<WeakReference<BaseLoginFragment>> it = loginFragmentList.iterator();
        while (it.hasNext()) {
            BaseLoginFragment baseLoginFragment = it.next().get();
            if (baseLoginFragment != null) {
                baseLoginFragment.Mh(uin);
            }
        }
        b(finishAllActivity);
    }

    public final void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            hasShownRegisterGuide = z16;
        }
    }

    public final void t(@Nullable com.tencent.mobileqq.loginregister.w wVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) wVar);
        } else {
            loginProxy = wVar;
        }
    }
}
