package com.tencent.mobileqq.relation.nt.mqqapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.IPartnerApi;
import com.tencent.mobileqq.partner.signin.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi;
import com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import cooperation.qzone.api.QZoneContant;
import h44.OpenRobotProfileCardArgs;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001)B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010$\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\u0006R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/relation/nt/mqqapi/RelationOpenPageAction;", "Lcom/tencent/mobileqq/utils/ax;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "uin", "", "I", "V", "Y", "X", "W", "U", BdhLogUtil.LogTag.Tag_Req, "T", "N", "Landroid/content/Intent;", "it", "Z", "O", "P", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "b", "J", "Ljava/lang/String;", "ATTR_UINS", "ATTR_TITLE", "ATTR_MEMBERUID", "ATTR_MEMBERNAME", "ATTR_GROUPCODE", "ATTR_ISTROOP", "ATTR_UIN", "ATTR_FRIEND_UIN", "ATTR_MUTUAL_MARK_ID", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "Landroid/content/Context;", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RelationOpenPageAction extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_UINS;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_TITLE;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_MEMBERUID;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_MEMBERNAME;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_GROUPCODE;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_ISTROOP;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_UIN;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_FRIEND_UIN;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final String ATTR_MUTUAL_MARK_ID;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/relation/nt/mqqapi/RelationOpenPageAction$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.relation.nt.mqqapi.RelationOpenPageAction$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SVR_COMM_SDKAPPID_FREQ_LIMIT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RelationOpenPageAction(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        this.ATTR_UINS = "uins";
        this.ATTR_TITLE = "title";
        this.ATTR_MEMBERUID = "memberUid";
        this.ATTR_MEMBERNAME = "memberName";
        this.ATTR_GROUPCODE = "groupCode";
        this.ATTR_ISTROOP = "isTroop";
        this.ATTR_UIN = "uin";
        this.ATTR_FRIEND_UIN = "friend_uin";
        this.ATTR_MUTUAL_MARK_ID = "mutualmark_id";
    }

    private final void I(QQAppInterface app, String uin) {
        if (app != null && uin != null) {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            if (!iFriendsInfoService.isFriend(uid, "RelationOpenPageAction")) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RelationOpenPageAction", 2, "deleteFriend " + uin);
            }
            BusinessHandler businessHandler = app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
            ((FriendListHandler) businessHandler).delFriend("RelationOpenPageAction", uin, (byte) 2);
            MqqHandler handler = app.getHandler(ChatSettingFragment.class);
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(16711681, uin));
                return;
            }
            return;
        }
        QLog.e("RelationOpenPageAction", 1, "deleteFriends is error! uin is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(RelationOpenPageAction this$0, List list, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NetworkUtil.isNetSupport(this$0.f307437b)) {
            dialogInterface.dismiss();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this$0.I((QQAppInterface) this$0.f307436a, (String) it.next());
            }
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.ajl, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(QBaseActivity qBaseActivity, QQCustomDialog qQCustomDialog) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            qQCustomDialog.show();
        } else {
            QLog.e("RelationOpenPageAction", 1, "deleteFriends is error! show dialog activity is invalid!");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void N() {
        int i3;
        int i16;
        Intent startAddFriend;
        Integer intOrNull;
        Integer intOrNull2;
        QLog.i("RelationOpenPageAction", 1, "doAddFriend will executed!");
        String str = this.f307441f.get(this.ATTR_UIN);
        if (str == null) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface != null && k.l(qQAppInterface, str)) {
            Context context = this.f307437b;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, str, "", 6, 0, null, 48, null));
            return;
        }
        boolean z16 = !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("addfriend_scheme_revert_9085", false);
        QLog.i("RelationOpenPageAction", 1, "doAddFriend enableSourceAndSubSource=" + z16);
        int i17 = 3071;
        if (z16) {
            String str2 = this.f307441f.get("sourceID");
            if (str2 != null && intOrNull2 != null) {
                i17 = intOrNull2.intValue();
            }
            String str3 = this.f307441f.get("subSourceID");
            if (str3 != null && intOrNull != null) {
                i16 = intOrNull.intValue();
                i3 = i17;
                startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f307437b, 1, str, null, i3, i16, X(), null, null, "", null);
                if (startAddFriend == null) {
                    Z(startAddFriend);
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f307437b, startAddFriend);
                    return;
                }
                return;
            }
        }
        i3 = i17;
        i16 = 5193;
        startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f307437b, 1, str, null, i3, i16, X(), null, null, "", null);
        if (startAddFriend == null) {
        }
    }

    private final void O() {
        PermissionPrivacyFragmentKotlin.INSTANCE.b(this.f307437b);
    }

    private final void P() {
        boolean z16;
        String str = this.f307441f.get(this.ATTR_UIN);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RelationOpenPageAction", 1, "doIntimateInfo uin is null or empty");
            return;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str.toString());
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (!iFriendsInfoService.isFriend(uid, "RelationOpenPageAction")) {
            QLog.e("RelationOpenPageAction", 1, "doIntimateInfo " + str + " is not friend");
            return;
        }
        if (TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), str)) {
            QLog.e("RelationOpenPageAction", 1, "doIntimateInfo selfUin");
            return;
        }
        QLog.d("RelationOpenPageAction", 1, "doIntimateInfo");
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_PEER_UIN, str);
        if (!(this.f307437b instanceof Activity)) {
            intent.addFlags(268435456);
        }
        PublicFragmentActivity.start(this.f307437b, intent, IntimateInfoFragment.class);
    }

    private final void Q() {
        Intent intent = new Intent(this.f307437b, (Class<?>) VisitorsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_show_rank", true);
        intent.putExtras(bundle);
        this.f307437b.startActivity(intent);
    }

    private final void R() {
        QLog.i("RelationOpenPageAction", 1, "doModifyGroupName will executed!");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("RelationOpenPageAction", 1, "doModifyGroupName is error! activity is null!");
            return;
        }
        String str = this.f307441f.get(this.ATTR_GROUPCODE);
        if (str == null) {
            QLog.e("RelationOpenPageAction", 1, "doModifyGroupName is error! groupCode is null!");
            return;
        }
        Manager manager = this.f307436a.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopInfo B = ((TroopManager) manager).B(str);
        if (B == null) {
            QLog.e("RelationOpenPageAction", 1, "doModifyGroupName executed is error!");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 1);
        intent.putExtra("edit_mode", 2);
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.o2c));
        if (B.hasSetNewTroopName) {
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, B.troopname);
        }
        intent.putExtra("max_num", 96);
        intent.putExtra("canPostNull", false);
        RouteUtils.startActivityForResult(qBaseActivity, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 13010);
    }

    private final void S() {
        boolean z16;
        boolean z17;
        String str;
        String str2 = this.f307441f.get(this.ATTR_UIN);
        String str3 = this.f307441f.get(this.ATTR_FRIEND_UIN);
        String str4 = this.f307441f.get(this.ATTR_MUTUAL_MARK_ID);
        boolean z18 = true;
        QLog.d("RelationOpenPageAction", 1, "doPartnerSignIn senderUin=" + str2 + " receiverUin=" + str3 + " markId=" + str4);
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str3 != null && str3.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (str4 != null && str4.length() != 0) {
                    z18 = false;
                }
                if (!z18) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        str = peekAppRuntime.getCurrentAccountUin();
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    if (Intrinsics.areEqual(str2, str)) {
                        str2 = str3;
                    }
                    ((IPartnerApi) QRoute.api(IPartnerApi.class)).openPartnerSignInDialog(new i(str2, RFWStringsKt.toLongOrDefault$default(str4, 0L, 0, 2, null), null, "1"));
                }
            }
        }
    }

    private final void T() {
        int i3;
        String str = this.f307441f.get(this.ATTR_ISTROOP);
        if (str != null) {
            i3 = Integer.parseInt(str);
        } else {
            i3 = 0;
        }
        Intent intent = new Intent();
        intent.putExtra("uinType", i3);
        ISettingSearchHightApi iSettingSearchHightApi = (ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class);
        Context context = this.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSettingSearchHightApi.startQUITempMsgSettingPage(context, intent);
    }

    private final void U() {
        String Y;
        String str;
        String str2;
        QLog.i("RelationOpenPageAction", 1, "doTroopWelcomeOperate will execute!");
        if (!(this.f307436a instanceof QQAppInterface)) {
            QLog.e("RelationOpenPageAction", 1, "doTroopWelcomeOperate is error! app is invalid!");
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null || (Y = Y()) == null || (str = this.f307441f.get(this.ATTR_MEMBERUID)) == null || (str2 = this.f307441f.get(this.ATTR_MEMBERNAME)) == null) {
            return;
        }
        String decode = URLDecoder.decode(str2, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(decode, "decode(memberName, \"UTF-8\")");
        Manager manager = this.f307436a.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopManager.e M = ((TroopManager) manager).M();
        if (M == null) {
            return;
        }
        BaseQQAppInterface baseQQAppInterface = this.f307436a;
        Intrinsics.checkNotNull(baseQQAppInterface, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        String a16 = M.a((QQAppInterface) baseQQAppInterface, 0);
        com.tencent.qqnt.aio.utils.c cVar = com.tencent.qqnt.aio.utils.c.f352293a;
        cVar.b(qBaseActivity, Y, InputEditTextMsgIntent.ClearEditTextContent.f189408d);
        cVar.b(qBaseActivity, Y, new InputAtMsgIntent.InsertAtMemberSpan(str, "", decode, true));
        cVar.b(qBaseActivity, Y, new InputEditTextMsgIntent.AppendTextToEditText(new SpannableString(a16), false));
    }

    private final void V() {
        boolean z16;
        QLog.i("RelationOpenPageAction", 1, "editTroopNick will execute!");
        if (this.f307436a == null) {
            QLog.e("RelationOpenPageAction", 1, "editTroopNick is error! app is invalid!");
            return;
        }
        final String Y = Y();
        final String W = W();
        boolean z17 = false;
        if (Y != null && Y.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (W == null || W.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(Y, W, "RelationOpenPageAction", new Function1<TroopMemberNickInfo, Unit>(Y, W, this) { // from class: com.tencent.mobileqq.relation.nt.mqqapi.RelationOpenPageAction$editTroopNick$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $memberUin;
                    final /* synthetic */ String $troopUin;
                    final /* synthetic */ RelationOpenPageAction this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$troopUin = Y;
                        this.$memberUin = W;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, Y, W, this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                        invoke2(troopMemberNickInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                        String str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                            return;
                        }
                        if (troopMemberNickInfo == null || (str = troopMemberNickInfo.getTroopNick()) == null) {
                            str = "";
                        }
                        Intent intent = new Intent();
                        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 5);
                        intent.putExtra("edit_mode", 0);
                        intent.putExtra("troopUin", this.$troopUin);
                        intent.putExtra("uin", this.$memberUin);
                        intent.putExtra("title", this.this$0.f307437b.getResources().getString(R.string.eqr));
                        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
                        intent.putExtra("max_num", 60);
                        intent.putExtra("default_hint", HardCodeUtil.qqStr(R.string.f172173o21));
                        intent.putExtra("auto_remark", true);
                        RouteUtils.startActivity(this.this$0.f307437b, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY);
                    }
                });
                return;
            }
        }
        QLog.e("RelationOpenPageAction", 1, "editTroopNick is error! troopUin or memberUid is invalid!");
    }

    private final String W() {
        boolean z16;
        String str = this.f307441f.get(this.ATTR_MEMBERUID);
        boolean z17 = false;
        if (str != null) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            QLog.e("RelationOpenPageAction", 1, "getTroopUin is error! memberUid is invalid!");
            return null;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        if (iRelationNTUinAndUidApi.isValidUin(str)) {
            return str;
        }
        return iRelationNTUinAndUidApi.getUinFromUid(str);
    }

    private final String X() {
        if (this.f307441f.get("addfriend_nick") != null) {
            return this.f307441f.get("addfriend_nick");
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && qBaseActivity.getIntent() != null) {
            return qBaseActivity.getIntent().getStringExtra("key_chat_name");
        }
        QLog.e("RelationOpenPageAction", 1, "getPeerName is error! activity is invalid!");
        return "";
    }

    private final String Y() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("RelationOpenPageAction", 1, "getTroopUin is error! activity is invalid!");
            return null;
        }
        String str = this.f307441f.get(this.ATTR_GROUPCODE);
        if (TextUtils.isEmpty(str)) {
            return qBaseActivity.getIntent().getStringExtra("key_peerId");
        }
        return str;
    }

    private final void Z(Intent it) {
        String str = this.f307441f.get("alghrithm");
        if (str != null) {
            boolean z16 = false;
            try {
                byte[] decode = Base64.decode(str, 0);
                String str2 = "";
                if (decode != null) {
                    if (decode.length == 0) {
                        z16 = true;
                    }
                    if (!z16) {
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        str2 = new String(decode, UTF_8);
                    }
                }
                Intrinsics.checkNotNullExpressionValue(it.putExtra("algo_id", str2), "{\n                val bu\u2026ID, algoId)\n            }");
            } catch (Exception e16) {
                QLog.e("RelationOpenPageAction", 1, "handleIntent error:" + e16);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void J() {
        final List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f307436a == null) {
            QLog.e("RelationOpenPageAction", 1, "deleteFriends is error! app is null!");
            return;
        }
        String str = this.f307441f.get(this.ATTR_TITLE);
        String str2 = this.f307441f.get(this.ATTR_UINS);
        if (str2 != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, (String) null, str, (String) null, R.string.cancel, R.string.asn, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.relation.nt.mqqapi.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        RelationOpenPageAction.K(RelationOpenPageAction.this, list, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.relation.nt.mqqapi.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        RelationOpenPageAction.L(dialogInterface, i3);
                    }
                });
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.relation.nt.mqqapi.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        RelationOpenPageAction.M(QBaseActivity.this, createCustomDialog);
                    }
                });
                return;
            } else {
                QLog.e("RelationOpenPageAction", 1, "deleteFriends is error! activity is invalid!");
                return;
            }
        }
        QLog.e("RelationOpenPageAction", 1, "deleteFriends is error! uinList is null!");
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.d("RelationOpenPageAction", 1, "doAction , action_name is :" + this.f307440e);
        String str = this.f307440e;
        if (str != null) {
            switch (str.hashCode()) {
                case -1254407763:
                    if (str.equals("intimateInfo")) {
                        P();
                        break;
                    }
                    break;
                case -976588507:
                    if (str.equals("visitorLike")) {
                        Q();
                        break;
                    }
                    break;
                case -804866710:
                    if (str.equals("deleteFriends")) {
                        J();
                        break;
                    }
                    break;
                case -373443937:
                    if (str.equals(QQFriendJsPlugin.API_ADD_FRIEND)) {
                        N();
                        break;
                    }
                    break;
                case 21179705:
                    if (str.equals("tempManager")) {
                        T();
                        break;
                    }
                    break;
                case 185339346:
                    if (str.equals("friendSetting")) {
                        O();
                        break;
                    }
                    break;
                case 617953749:
                    if (str.equals(AppConstants.Preferences.TROOP_NICK)) {
                        V();
                        break;
                    }
                    break;
                case 971251449:
                    if (str.equals("partner_signin")) {
                        S();
                        break;
                    }
                    break;
                case 1233099618:
                    if (str.equals("welcome")) {
                        U();
                        break;
                    }
                    break;
                case 1837262352:
                    if (str.equals("modifyGroupName")) {
                        R();
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
