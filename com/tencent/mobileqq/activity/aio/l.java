package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.v;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOConvertApi;
import com.tencent.qqnt.aio.adapter.api.UnsupportedChatTypeException;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class l extends BaseAIOUtils {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f179525a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f179526b = false;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f179527c = false;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f179528d = false;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f179529e = false;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f179530f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f179531g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f179532h = false;

    /* renamed from: k, reason: collision with root package name */
    private static Field f179535k;

    /* renamed from: i, reason: collision with root package name */
    private static SparseIntArray f179533i = new SparseIntArray();

    /* renamed from: j, reason: collision with root package name */
    public static boolean f179534j = true;

    /* renamed from: l, reason: collision with root package name */
    private static Boolean f179536l = Boolean.TRUE;

    /* renamed from: m, reason: collision with root package name */
    private static ThreadLocal<char[]> f179537m = new a();

    /* renamed from: n, reason: collision with root package name */
    private static String f179538n = "OPPO;R7Plusm;22|OPPO;R7007;18|OPPO;R2017;18|OPPO;N5117;18|OPPO;A33;22|OPPO;OPPO A33;22";

    /* renamed from: o, reason: collision with root package name */
    private static String f179539o = "HM NOTE 1LTETD";

    /* renamed from: p, reason: collision with root package name */
    private static String f179540p = "NX507J";

    /* renamed from: q, reason: collision with root package name */
    static String f179541q = "aio_pad_adapt_story";

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends ThreadLocal<char[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static final Object A(View view) {
        if (view == null) {
            return null;
        }
        if (view.getParent() != null && !(view.getParent() instanceof ListView)) {
            if (view.getParent() instanceof View) {
                return A((View) view.getParent());
            }
            QLog.d("AIOUtils", 1, "view.getParent() not instanceof View");
            return null;
        }
        return view.getTag();
    }

    public static Drawable B(boolean z16) {
        int i3;
        int dip2px = ViewUtils.dip2px(10.0f);
        Resources resources = MobileQQ.sMobileQQ.getResources();
        if (z16) {
            i3 = R.drawable.kdb;
        } else {
            i3 = R.drawable.kdi;
        }
        Drawable drawable = ResourcesCompat.getDrawable(resources, i3, null);
        drawable.setBounds(0, 0, dip2px, dip2px);
        return drawable;
    }

    @Deprecated
    public static final ChatMessage C(View view) {
        v.a aVar = (v.a) A(view);
        if (aVar != null) {
            return aVar.f180131a;
        }
        return null;
    }

    public static int D(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public static final View E(ListView listView, int i3) {
        if (i3 >= listView.getFirstVisiblePosition() && i3 <= listView.getLastVisiblePosition()) {
            return listView.getChildAt(i3 - listView.getFirstVisiblePosition());
        }
        return null;
    }

    private static int F(int i3) {
        int z16 = z(i3);
        try {
            z16 = f179533i.get(i3, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOUtils", 2, "AIOTime getVisibilityFromCache|" + f179533i.toString() + "|" + i3 + "|" + z16);
        }
        return z16;
    }

    public static void G(CharSequence charSequence) {
        LinkedList<LinkSpan> v3;
        if (!f179534j || charSequence == null || (v3 = v(charSequence)) == null || v3.isEmpty() || !t(charSequence)) {
            return;
        }
        U(v3);
    }

    public static boolean H(MsgRecord msgRecord) {
        int chatType = msgRecord.getChatType();
        if (msgRecord.getMsgType() != 3 || chatType == 2) {
            return false;
        }
        return true;
    }

    public static boolean I(MsgRecord msgRecord) {
        MarkdownElement markdownElement;
        if (msgRecord.getMsgType() != 31) {
            return false;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            MsgElement msgElement = arrayList.get(i3);
            if (msgElement.elementType == 14 && (markdownElement = msgElement.markdownElement) != null && markdownElement.mdExtType == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean J(Intent intent) {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra("uin");
        int intExtra = intent.getIntExtra("uintype", -1);
        if (!AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(stringExtra) || intExtra != 1008) {
            return false;
        }
        return true;
    }

    public static boolean K() {
        return false;
    }

    private static boolean L(String str, int i3, Bundle bundle) {
        if (i3 == 0 && ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(str) && !bundle.containsKey("key_avatar_dominantColor")) {
            return true;
        }
        return false;
    }

    public static boolean M(MsgRecord msgRecord) {
        int chatType = msgRecord.getChatType();
        if (msgRecord.getMsgType() != 3 || chatType != 2) {
            return false;
        }
        return true;
    }

    private static boolean N(BaseActivity baseActivity, QQAppInterface qQAppInterface, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("uin");
            int intExtra = intent.getIntExtra("uintype", -1);
            if (stringExtra == null) {
                return false;
            }
            if (intExtra == -1) {
                QQToast.makeText(baseActivity, baseActivity.getString(R.string.hkd), 0).show(baseActivity.getTitleBarHeight());
                return false;
            }
            if (intent.hasExtra("account")) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
                if (!com.tencent.qqnt.contact.friends.b.f355778a.c(stringExtra, "AIOUtils")) {
                    intent.removeExtra("account");
                    intent.putExtra("shotcut_forward", ChatActivity.class.getName());
                    intent.setClassName(baseActivity, ShortcutRouterActivity.class.getName());
                    baseActivity.startActivity(intent);
                    return false;
                }
            }
            if (intent.getBooleanExtra("shortcut", false) && !com.tencent.qqnt.contact.friends.b.f355778a.c(stringExtra, "AIOUtils")) {
                QQToast.makeText(baseActivity.getApplicationContext(), baseActivity.getString(R.string.hke), 0).show(baseActivity.getTitleBarHeight());
                return false;
            }
            return true;
        } catch (RuntimeException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.AIOUtils", 2, "RuntimeException isValidChat beforeEnterAIO.");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit O(Boolean bool, com.tencent.mobileqq.onlinestatus.model.f fVar) {
        QLog.i("AIOUtils", 1, "[showOnlineStatusLikeDialog]: updateFriendSwitch result is " + bool + " remoteSwitch is " + fVar);
        return null;
    }

    public static StringBuilder P() {
        StringBuilder sb5 = new StringBuilder();
        try {
            if (f179536l.booleanValue()) {
                Field declaredField = StringBuilder.class.getSuperclass().getDeclaredField("value");
                f179535k = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                f179536l = Boolean.FALSE;
            }
            Field field = f179535k;
            if (field != null) {
                field.set(sb5, f179537m.get());
            }
        } catch (Exception unused) {
        }
        return sb5;
    }

    public static int Q(QQAppInterface qQAppInterface, BaseActivity baseActivity, Intent intent) {
        Fragment findFragmentByTag;
        if (!intent.getBooleanExtra("open_chatfragment", false) || !(baseActivity instanceof SplashActivity) || (findFragmentByTag = baseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName())) == null || !findFragmentByTag.isVisible()) {
            return 0;
        }
        if (q(baseActivity, qQAppInterface, false, intent)) {
            return 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "openAIO by MT");
        }
        ChatFragment chatFragment = (ChatFragment) findFragmentByTag;
        intent.putExtra("isBack2Root", true);
        baseActivity.setIntent(intent);
        chatFragment.onPause();
        chatFragment.onStop();
        chatFragment.onStart();
        chatFragment.onResume();
        w.a("AIOUtils.openAioToAIOByMT");
        return 1;
    }

    private static void R(Context context, String str, Bundle bundle) {
        if (!(context instanceof Activity)) {
            QLog.e("AIOUtils", 1, "[openRobotScaleChat] context is not activity");
        } else {
            ((IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class)).fetchAndRouteToRobotAIO(new RobotAIORouteArgs((Activity) context, str, "", "14", "1000", true, bundle));
        }
    }

    public static int S(com.tencent.mobileqq.structmsg.j jVar, String str) {
        String a16 = jVar.a(str);
        if (TextUtils.isEmpty(a16)) {
            return 0;
        }
        try {
            return Integer.parseInt(a16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, e16.getMessage());
            }
            return 0;
        }
    }

    private static Intent T(Context context, String str, int i3, String str2, Bundle bundle, int i16) {
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("uinname", str2);
        intent.putExtra("KEY_OPEN_MINI_CHAT_FROM", i16);
        intent.putExtra("key_is_scale_chat", true);
        if (bundle != null) {
            if (bundle.getBoolean("key_square_aio_show_keyboard", false)) {
                intent.putExtra("enter_ext_panel", 1);
                if (QQUtils.k(context)) {
                    intent.putExtra("ext_panel_onresume", 2);
                } else {
                    intent.putExtra("ext_panel_onresume", 1);
                }
                bundle.remove("key_square_aio_show_keyboard");
            }
            intent.putExtras(bundle);
        }
        return intent;
    }

    protected static void U(LinkedList<LinkSpan> linkedList) {
        Iterator<LinkSpan> it = linkedList.iterator();
        while (it.hasNext()) {
            it.next().p(false);
        }
    }

    public static void V(Activity activity, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && activity != null && dVar != null && cVar != null) {
            if (i3 == 1) {
                ((IOnlineStatusAvatarSwitchService) peekAppRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "")).updateFriendSwitchStatus(dVar.x(), new Function2() { // from class: com.tencent.mobileqq.activity.aio.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit O;
                        O = l.O((Boolean) obj, (com.tencent.mobileqq.onlinestatus.model.f) obj2);
                        return O;
                    }
                });
            }
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) qQAppInterface.getRuntimeService(IOnlineStatusService.class, "");
            if (com.tencent.mobileqq.friend.status.b.a(cVar.u(), cVar.z()) != 0 || (cVar.c0() != null && cVar.c0().contains("TIM"))) {
                if (iOnlineStatusService.isAIODialogNotShowing() && !be.d(dVar.x())) {
                    ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(dVar.x(), false);
                    ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).requestNTOnlineStatusByUin(dVar.x(), false, "AIOUtils");
                }
                iOnlineStatusService.showAIOStatusPopupDialog(new com.tencent.mobileqq.onlinestatus.model.d(dVar, cVar), activity, i3, z16);
            }
        }
    }

    public static void W(Activity activity, String str, int i3, boolean z16) {
        if ((MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) && activity != null && !TextUtils.isEmpty(str)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (TextUtils.isEmpty(uidFromUin)) {
                return;
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "AIOUtils");
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(uidFromUin, "AIOUtils");
            if (friendsSimpleInfoWithUid != null && onlineStatusSimpleInfoWithUid != null) {
                V(activity, friendsSimpleInfoWithUid, onlineStatusSimpleInfoWithUid, i3, z16);
            }
        }
    }

    public static final float X(int i3, int i16, Resources resources) {
        return TypedValue.applyDimension(i3, i16, resources.getDisplayMetrics());
    }

    public static void Y(Context context, String str, int i3, String str2, Bundle bundle, int i16) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        activityURIRequest.extra().putString("key_chat_name", str2);
        activityURIRequest.extra().putString("key_peerId", str);
        activityURIRequest.extra().putInt("key_chat_type", i3);
        int i17 = 0;
        if (bundle != null) {
            activityURIRequest.extra().putAll(bundle);
            i17 = bundle.getInt("key_from", 0);
        }
        activityURIRequest.extra().putString("key_from", String.valueOf(i17));
        activityURIRequest.setFlags(67108864);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    public static void Z(Context context, String str, int i3, String str2, Bundle bundle, int i16) {
        a0(context, str, i3, str2, bundle, i16, true);
    }

    public static void a0(Context context, String str, int i3, String str2, Bundle bundle, int i16, boolean z16) {
        if (L(str, i3, bundle)) {
            R(context, str, bundle);
            return;
        }
        Intent T = T(context, str, i3, str2, bundle, i16);
        try {
            ((IAIOConvertApi) QRoute.api(IAIOConvertApi.class)).handleAIOIntent(T);
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/scaleaio");
            activityURIRequest.extra().putAll(T.getExtras());
            if (z16) {
                activityURIRequest.setFlags(67108864);
                v61.a b16 = v61.b.a().b();
                if (b16 != null && b16.d()) {
                    activityURIRequest.extra().putBoolean("key_is_backto_scale_chat", true);
                }
            }
            if (bundle != null && bundle.getBoolean("key_square_aio_start_activity_for_result", false)) {
                if (context instanceof Activity) {
                    activityURIRequest.setRequestCode(1001);
                    QRoute.startUri(activityURIRequest);
                    return;
                }
                QLog.w("AIOUtils", 1, "startScaleChat, try to start activity for result without activity");
            }
            QRoute.startUri(activityURIRequest);
        } catch (UnsupportedChatTypeException e16) {
            QLog.e("AIOUtils", 1, "UnsupportedChatTypeException", e16.getMessage(), e16);
        }
    }

    public static boolean q(BaseActivity baseActivity, QQAppInterface qQAppInterface, boolean z16, Intent intent) {
        ei.a(null, "AIO_doOnCreate_BeforeEnterCost");
        if (!qQAppInterface.isLogin()) {
            Intent intent2 = new Intent();
            intent2.addFlags(262144);
            RouteUtils.startActivity(baseActivity, intent2, RouterConstants.UI_ROUTER_LOGIN);
            baseActivity.finish();
            return true;
        }
        if (com.tencent.mobileqq.troop.blocktroop.k.l(baseActivity, qQAppInterface, intent)) {
            return true;
        }
        if (J(intent)) {
            ((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).launchQCircleFromPublicAccount(qQAppInterface, baseActivity, QCirclePublicAccountLauncherSource.AIO);
            return true;
        }
        if (z16) {
            if (!N(baseActivity, qQAppInterface, intent)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.AIOUtils", 2, " isValidChat 1 false");
                }
                baseActivity.finish();
                return true;
            }
        } else {
            if (baseActivity.isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.AIOUtils", 2, "onNewIntent isFinishing");
                }
                return true;
            }
            if (df0.a.a().c(intent, baseActivity, qQAppInterface)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.AIOUtils", 2, "onNewIntent ThridApp to chatactivity");
                }
                return true;
            }
            Bundle extras = intent.getExtras();
            if (extras != null && extras.getBoolean("back_from_emojimall", false)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.AIOUtils", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
                }
                return true;
            }
            if (!N(baseActivity, qQAppInterface, intent)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.AIOUtils", 2, " isValidChat 2 false");
                }
                baseActivity.finish();
                return true;
            }
        }
        ei.a("AIO_doOnCreate_BeforeEnterCost", null);
        return false;
    }

    @Deprecated
    public static void r(String str, String str2, Exception exc) {
        QLog.e(str, 1, str2, exc);
    }

    public static void s(String str, String str2, RuntimeException runtimeException) {
        QLog.e(str, 1, str2, runtimeException);
    }

    protected static boolean t(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i3) == '\u202e') {
                return true;
            }
        }
        return false;
    }

    public static final int u(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) (f16 * Math.round(resources.getDisplayMetrics().density));
    }

    protected static LinkedList<LinkSpan> v(CharSequence charSequence) {
        QQText qQText;
        Object[] objArr;
        if (!(charSequence instanceof QQText) || (objArr = (qQText = (QQText) charSequence).mSpans) == null || objArr.length == 0) {
            return null;
        }
        LinkedList<LinkSpan> linkedList = new LinkedList<>();
        for (Object obj : qQText.mSpans) {
            if (obj instanceof LinkSpan) {
                linkedList.add((LinkSpan) obj);
            }
        }
        return linkedList;
    }

    public static Intent w(Context context, String str) {
        v61.a b16 = v61.b.a().b();
        if (b16.c() != null) {
            str = b16.c().getName();
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, str));
        if (b16.d()) {
            intent.putExtra("KEY_OPEN_MINI_CHAT", true);
            intent.addFlags(67108864);
            intent.putExtra("key_is_scale_chat", true);
            intent.putExtra("key_is_backto_scale_chat", true);
        }
        return intent;
    }

    public static int x(int i3) {
        long j3;
        String[] split;
        int z16 = z(i3);
        if (QLog.isColorLevel()) {
            j3 = SystemClock.uptimeMillis();
        } else {
            j3 = 0;
        }
        try {
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", e16);
            }
        }
        if (f179532h) {
            return F(i3);
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), IDPCApiConstant.AIO_MSG_MENU_UI_STATE_DEFAULT);
        if (QLog.isColorLevel()) {
            QLog.d("AIOUtils", 2, "aioConfig:" + featureValue);
        }
        String[] split2 = featureValue.split("\\|");
        if (split2.length > 1 && (split = split2[1].split(",")) != null) {
            for (String str : split) {
                String[] split3 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length > 1) {
                    f179533i.put(Integer.valueOf(split3[0]).intValue(), Integer.valueOf(split3[1]).intValue());
                }
            }
        }
        f179532h = true;
        z16 = F(i3);
        if (QLog.isColorLevel()) {
            QLog.d("AIOUtils", 2, "AIOTime initAIOMsgMenuState|" + i3 + "|" + z16 + "|" + (SystemClock.uptimeMillis() - j3));
        }
        return z16;
    }

    public static ActivityURIRequest y(Context context, String str) {
        v61.a b16 = v61.b.a().b();
        if (b16 != null && b16.d()) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/scaleaio");
            activityURIRequest.extra().putBoolean("key_is_scale_chat", true);
            activityURIRequest.extra().putBoolean("key_is_backto_scale_chat", true);
            return activityURIRequest;
        }
        return new ActivityURIRequest(context, str);
    }

    private static int z(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return 1;
        }
        return 0;
    }
}
