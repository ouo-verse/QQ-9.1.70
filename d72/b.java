package d72;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    private static boolean d(RecentContactInfo recentContactInfo) {
        if (recentContactInfo != null && recentContactInfo.getAbstractContent().size() > 0) {
            MsgAbstractElement msgAbstractElement = recentContactInfo.getAbstractContent().get(0);
            if (msgAbstractElement != null && !TextUtils.isEmpty(msgAbstractElement.getCustomContent())) {
                String customContent = msgAbstractElement.getCustomContent();
                try {
                    JSONObject jSONObject = new JSONObject(customContent);
                    if (jSONObject.has("app") && "com.tencent.together".equals(jSONObject.getString("app"))) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ListenTogetherUtils", 1, "checkIsNTTogetherOpenArkMsg content = " + customContent);
                        }
                        return true;
                    }
                    return false;
                } catch (JSONException e16) {
                    QLog.e("ListenTogetherUtils", 1, e16, new Object[0]);
                    return false;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherUtils", 1, "checkIsNTTogetherOpenArkMsg return, element == null or element.getCustomContent() == null");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherUtils", 1, "checkIsNTTogetherOpenArkMsg return, msgRecord == null or msgRecord.getAbstractContent() == null");
        }
        return false;
    }

    public static boolean e(QQAppInterface qQAppInterface, Message message) {
        MessageForArkApp messageForArkApp;
        ArkAppMessage arkAppMessage;
        boolean z16;
        if (qQAppInterface == null || message == null || message.msgtype != -5008) {
            return false;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        if (messageFacade != null) {
            MessageRecord P = messageFacade.P(message.frienduin, message.istroop, message.uniseq);
            if (P instanceof MessageForArkApp) {
                messageForArkApp = (MessageForArkApp) P;
                if (messageForArkApp != null || (arkAppMessage = messageForArkApp.ark_app_message) == null || !"com.tencent.together".equals(arkAppMessage.appName) || !"invite".equals(messageForArkApp.ark_app_message.appView)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(messageForArkApp.ark_app_message.metaList);
                    JSONObject jSONObject2 = jSONObject.has("invite") ? jSONObject.getJSONObject("invite") : null;
                    String str = "";
                    if (jSONObject2 != null) {
                        str = jSONObject2.optString("type", "");
                    }
                    z16 = str.equals("listen");
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ListenTogetherUtils", 1, "handleListenTogetherIntentFromArkMsg", th5);
                    }
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ListenTogetherUtils", 2, String.format("checkIsTogetherOpenArkMsg uinType=%d uin=%s isListenTogether=%b", Integer.valueOf(message.istroop), MobileQQ.getShortUinStr(message.frienduin), Boolean.valueOf(z16)));
                }
                return z16;
            }
        }
        messageForArkApp = null;
        return messageForArkApp != null ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(QQAppInterface qQAppInterface, int i3, String str) {
        boolean g06 = ListenTogetherManager.J(qQAppInterface).g0(i3, str);
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherUtils", 2, String.format("checkEnterAioByListenTogetherNotifyMsg sessionType=%d uin=%s isOpen=%b", Integer.valueOf(i3), str, Boolean.valueOf(g06)));
        }
        if (!g06) {
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.isa));
        }
        return g06;
    }

    public static String h() {
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        return ("3064".equals(currentThemeId) || "3063".equals(currentThemeId) || "3066".equals(currentThemeId) || "3065".equals(currentThemeId) || "3067".equals(currentThemeId)) ? currentThemeId : "";
    }

    public static String k(QQAppInterface qQAppInterface, String str, int i3, String str2) {
        String str3;
        TroopMemberInfo troopMemberInfoSync;
        String str4 = null;
        if (!"0".equals(str2) && !MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN.equals(str2) && !TextUtils.isEmpty(str2)) {
            if (i3 == 2) {
                str3 = ac.F(qQAppInterface, str2);
            } else if (i3 == 1 && (troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "ListenTogetherUtils")) != null) {
                str3 = troopMemberInfoSync.nickInfo.getShowName();
            } else {
                str3 = "";
            }
            str4 = str3;
            if (TextUtils.isEmpty(str4)) {
                str4 = str2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherUtils", 2, "getNickName, uin=" + str + ",sessionType=" + i3 + ", frdUin=" + str2);
        }
        return str4;
    }

    public static final String m(int i3, String str) {
        return i3 + "_" + str;
    }

    public static void n(QQAppInterface qQAppInterface, Activity activity, int i3, String str) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter("https://web.qun.qq.com/qunmusic/listener", "uin", str), "uinType", String.valueOf(i3)), "_wwv", "128"), "_wv", "2"));
        activity.startActivity(intent);
    }

    public static void o(QQAppInterface qQAppInterface, Context context, int i3, String str, int i16) {
        String str2;
        String str3;
        String checkAVFocus = AVBizModuleFactory.getModuleByName(Constants.Business.LISTEN_TOGETHER).checkAVFocus();
        if (!"true".equals(checkAVFocus)) {
            QQToast.makeText(context, String.format(context.getString(R.string.z_k), checkAVFocus), 1).show();
            QLog.e("ListenTogetherUtils", 1, "preCheckIsUserGamePlaying, res[" + checkAVFocus + "]");
            return;
        }
        if (tr2.b.q(qQAppInterface).f(context, 1, str, i16)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        String addParameter = URLUtil.addParameter("https://web.qun.qq.com/qunmusic/index", "uin", str);
        ListenTogetherManager listenTogetherManager = (ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
        listenTogetherManager.v1();
        boolean h06 = listenTogetherManager.h0(i3, str);
        String h16 = h();
        if (!TextUtils.isEmpty(h16)) {
            addParameter = URLUtil.addParameter(addParameter, "themeId", h16);
        }
        String addParameter2 = URLUtil.addParameter(addParameter, "uinType", String.valueOf(i3));
        String str4 = "1";
        if (h06) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        String addParameter3 = URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(addParameter2, "showlrc", str2), "_wv", "2"), "_wwv", "128");
        if (listenTogetherManager.l0(i3, str)) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        String addParameter4 = URLUtil.addParameter(URLUtil.addParameter(addParameter3, "isJoin", str3), "from", String.valueOf(i16));
        if (!l(qQAppInterface, "is_not_first_join_listen_together_" + i3, false, false)) {
            str4 = "0";
        }
        intent.putExtra("url", URLUtil.addParameter(addParameter4, "isNew", str4));
        context.startActivity(intent);
        ListenTogetherManager.J(qQAppInterface).G(context, i3, str);
    }

    public static void p(RecentContactInfo recentContactInfo, Intent intent) {
        if (d(recentContactInfo)) {
            intent.putExtra("key_from_listen_together_notify_msg", true);
        }
    }

    public static void s(Context context, int i3, String str, int i16, boolean z16, String str2) {
        String str3;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ListenTogetherManager J = ListenTogetherManager.J(qQAppInterface);
        boolean l06 = J.l0(i3, str);
        boolean g06 = J.g0(i3, str);
        QLog.d("ListenTogetherUtils", 1, "onJoinClick sessionType=", Integer.valueOf(i3), ",uin=", MobileQQ.getShortUinStr(str), ",joinFrom=", Integer.valueOf(i16), ",reopenIfNeed=", Boolean.valueOf(z16), ",songId=", str2, ",meJoined=", Boolean.valueOf(l06), ",isOpened=", Boolean.valueOf(g06));
        if (l06 || g06) {
            ListenTogetherManager.J(qQAppInterface).m0((QBaseActivity) context, i3, str);
            return;
        }
        if (z16) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
            a aVar = new a(i3, str, str2, i16);
            createCustomDialog.setTitle(R.string.f1625020l);
            createCustomDialog.setTitleMutiLine();
            createCustomDialog.setMessage((CharSequence) null);
            createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), aVar);
            createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f1624620h), aVar);
            createCustomDialog.setCanceledOnTouchOutside(false);
            if (((BaseActivity) context).isFinishing()) {
                return;
            }
            createCustomDialog.show();
            if (i16 == 1) {
                str3 = "exp_openframe";
            } else {
                str3 = "exp_joinbar";
            }
            u(i3 == 1, str3, str);
        }
    }

    public static int j(String str, String str2) {
        int i3;
        try {
            TroopInfo B = ((TroopManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).B(str2);
            if (B == null) {
                return -1;
            }
            if (B.isTroopOwner(str)) {
                i3 = 0;
            } else {
                i3 = B.isTroopAdmin(str) ? 1 : 2;
            }
            return i3;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String g(MusicInfo musicInfo) {
        if (musicInfo == null) {
            return "";
        }
        String trim = musicInfo.f240911e.trim();
        if (musicInfo.f240913h != null) {
            boolean z16 = true;
            for (int i3 = 0; i3 < musicInfo.f240913h.size(); i3++) {
                String str = musicInfo.f240913h.get(i3);
                if (!TextUtils.isEmpty(str)) {
                    if (z16) {
                        trim = trim + "\u2014" + str.trim();
                        z16 = false;
                    } else {
                        trim = trim + "/" + str.trim();
                    }
                }
            }
        }
        return trim;
    }

    public static boolean l(QQAppInterface qQAppInterface, String str, boolean z16, boolean z17) {
        String str2;
        if (qQAppInterface == null) {
            QLog.w("ListenTogetherUtils", 1, "[getPrefValue] app is null. return defaultValue: " + z16);
            return z16;
        }
        if (z17) {
            str2 = qQAppInterface.getCurrentUin();
        } else {
            str2 = "qq_listen_together_pref";
        }
        return VasMMKV.getListenTogether(qQAppInterface.getApplication(), str2).getBoolean(str, z16);
    }

    public static void u(boolean z16, String str, String str2) {
        String str3;
        if (z16) {
            str3 = "Grp_AIO";
        } else {
            str3 = "c2c_AIO";
        }
        String str4 = str3;
        if (!z16) {
            str2 = "0";
        }
        ReportController.o(null, "dc00899", str4, "", "music_tab", str, 0, 0, str2, "0", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(QBaseActivity qBaseActivity, QQAppInterface qQAppInterface, int i3, String str) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230);
        DialogInterfaceOnClickListenerC10164b dialogInterfaceOnClickListenerC10164b = new DialogInterfaceOnClickListenerC10164b(qQAppInterface, i3, str, qBaseActivity);
        createCustomDialog.setTitle(R.string.f1624920k);
        createCustomDialog.setMessage((CharSequence) null);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), dialogInterfaceOnClickListenerC10164b);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.oce), dialogInterfaceOnClickListenerC10164b);
        createCustomDialog.setCanceledOnTouchOutside(false);
        if (qBaseActivity.isFinishing()) {
            return;
        }
        createCustomDialog.show();
        u(i3 == 1, "exp_joinframe", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f393149d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f393150e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f393151f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f393152h;

        a(int i3, String str, String str2, int i16) {
            this.f393149d = i3;
            this.f393150e = str;
            this.f393151f = str2;
            this.f393152h = i16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            String str2;
            if (i3 == 1) {
                ((ListenTogetherHandler) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).Z2(this.f393149d, this.f393150e, this.f393151f, this.f393152h);
                dialogInterface.dismiss();
                if (this.f393152h == 1) {
                    str2 = "clk_openframe_open";
                } else {
                    str2 = "clk_joinbar_open";
                }
                b.u(this.f393149d == 1, str2, this.f393150e);
                return;
            }
            if (i3 == 0) {
                dialogInterface.dismiss();
                if (this.f393152h == 1) {
                    str = "clk_openframe_cancel";
                } else {
                    str = "clk_joinbar_cancel";
                }
                b.u(this.f393149d == 1, str, this.f393150e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: d72.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class DialogInterfaceOnClickListenerC10164b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f393153d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f393154e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f393155f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f393156h;

        DialogInterfaceOnClickListenerC10164b(QQAppInterface qQAppInterface, int i3, String str, QBaseActivity qBaseActivity) {
            this.f393153d = qQAppInterface;
            this.f393154e = i3;
            this.f393155f = str;
            this.f393156h = qBaseActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                if (b.f(this.f393153d, this.f393154e, this.f393155f)) {
                    b.s(this.f393156h, this.f393154e, this.f393155f, 3, false, null);
                }
                dialogInterface.dismiss();
                b.u(this.f393154e == 1, "clk_joinframe_join", this.f393155f);
                return;
            }
            if (i3 == 0) {
                dialogInterface.dismiss();
                b.u(this.f393154e == 1, "clk_joinframe_cancel", this.f393155f);
            }
        }
    }

    public static void c(final QBaseActivity qBaseActivity, final QQAppInterface qQAppInterface, final int i3, final String str) {
        if (qBaseActivity == null) {
            return;
        }
        if (!qBaseActivity.getIntent().getBooleanExtra("key_from_listen_together_notify_msg", false)) {
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherUtils", 2, "checkEnterAioByListenTogetherNotifyMsg return, fromListenTogetherNotifyMsg is false");
            }
        } else {
            boolean f16 = f(qQAppInterface, i3, str);
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherUtils", 2, String.format("checkEnterAioByListenTogetherNotifyMsg sessionType=%d uin=%s isOpen=%b", Integer.valueOf(i3), str, Boolean.valueOf(f16)));
            }
            if (f16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: d72.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.w(QBaseActivity.this, qQAppInterface, i3, str);
                    }
                });
            }
        }
    }

    public static void v(QQAppInterface qQAppInterface, String str, boolean z16, boolean z17) {
        String str2;
        if (qQAppInterface == null) {
            QLog.w("ListenTogetherUtils", 1, "[setPrefValue] app is null. ignore set operation");
            return;
        }
        if (z17) {
            str2 = qQAppInterface.getCurrentUin();
        } else {
            str2 = "qq_listen_together_pref";
        }
        VasMMKV.getListenTogether(qQAppInterface.getApplication(), str2).edit().putBoolean(str, z16).apply();
    }

    public static boolean q(QQAppInterface qQAppInterface, Message message, Intent intent) {
        if (qQAppInterface == null || message == null || message.msgtype != -5008) {
            return false;
        }
        boolean e16 = e(qQAppInterface, message);
        if (e16) {
            intent.putExtra("key_from_listen_together_notify_msg", e16);
        }
        return e16;
    }

    public static void t(Context context, int i3, String str) {
        int i16 = i3 == 1 ? 1 : 2;
        u(i16 == 1, "clk_join_bar", str);
        s(context, i16, str, 2, true, null);
    }

    public static String i(int i3, int i16, int i17) {
        if (i3 == 2) {
            if (i17 == 3) {
                return HardCodeUtil.qqStr(R.string.irv);
            }
            if (i17 == 2) {
                return HardCodeUtil.qqStr(R.string.is6);
            }
            if (i17 == 1) {
                return HardCodeUtil.qqStr(R.string.iso);
            }
            return HardCodeUtil.qqStr(R.string.isg);
        }
        if (i16 > 1) {
            return i16 + HardCodeUtil.qqStr(R.string.ise);
        }
        if (i16 == 1) {
            return i16 + HardCodeUtil.qqStr(R.string.isq);
        }
        return HardCodeUtil.qqStr(R.string.isg);
    }
}
