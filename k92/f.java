package k92;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002\u00a8\u0006\u000f"}, d2 = {"Lk92/f;", "", "", "friendUin", "c", "", "d", "", "e", "", "msgResId", "iconType", "g", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f411911a = new f();

    f() {
    }

    @JvmStatic
    public static final String c(String friendUin) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101723", false)) {
            QLog.d("SpecialCareGrayTipsHelper", 2, "getIntimateSpecialCareWording switch off");
            return null;
        }
        if (friendUin == null || friendUin.length() == 0) {
            QLog.d("SpecialCareGrayTipsHelper", 2, "getIntimateSpecialCareWording check params fail");
            return null;
        }
        if (d(friendUin)) {
            QLog.d("SpecialCareGrayTipsHelper", 2, "getIntimateSpecialCareWording is already special care friend");
            return null;
        }
        String string = BaseApplication.getContext().getString(R.string.wyf);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ng.intimate_special_care)");
        String str = "(" + string + ")#special_care{" + friendUin + "}";
        QLog.d("SpecialCareGrayTipsHelper", 1, "getIntimateSpecialCareWording wording=" + str + " friendUin=" + StringUtil.getSimpleUinForPrint(friendUin));
        return str;
    }

    @JvmStatic
    public static final boolean d(String friendUin) {
        SpecialCareInfo O;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
        return (friendsManager == null || (O = friendsManager.O(friendUin)) == null || O.globalSwitch != 1) ? false : true;
    }

    @JvmStatic
    public static final void e(String friendUin) {
        String str;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (d(friendUin)) {
            QLog.d("SpecialCareGrayTipsHelper", 1, "setSpecialCare is already special care friend");
            h(f411911a, R.string.wyc, 0, 2, null);
            return;
        }
        try {
            str = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUidFromUin(Long.parseLong(friendUin));
        } catch (Exception unused) {
            str = null;
        }
        if (str == null || str.length() == 0) {
            QLog.d("SpecialCareGrayTipsHelper", 1, "setSpecialCare friendUid is null");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            f411911a.g(R.string.b3j, 1);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        QLog.d("SpecialCareGrayTipsHelper", 1, "setSpecialCare friendUid=" + StringUtil.getSimpleUinForPrint(friendUin));
        NTFriendSettingHelper.V(NTFriendSettingHelper.f352067a, new NTFriendSettingHelper.a(qQAppInterface, friendUin, str, true, 0), false, false, new IOperateCallback() { // from class: k92.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                f.f(i3, str2);
            }
        }, 6, null);
    }

    private final void g(final int msgResId, final int iconType) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: k92.e
            @Override // java.lang.Runnable
            public final void run() {
                f.i(iconType, msgResId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, int i16) {
        QQToast.makeText(BaseApplication.getContext(), i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String str) {
        if (i3 == 0) {
            f411911a.g(R.string.wye, 2);
        } else {
            f411911a.g(R.string.wyd, 1);
        }
    }

    static /* synthetic */ void h(f fVar, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        fVar.g(i3, i16);
    }
}
