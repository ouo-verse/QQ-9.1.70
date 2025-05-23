package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.webviewplugin.NTJuBaoUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.mobileqq.troop.utils.y;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$GroupMemberProfileInfo;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public class ChatSettingForTroopApiImpl implements IChatSettingForTroopApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ChatSettingForTroopApiImpl";
    protected com.tencent.mobileqq.troopshare.e mTroopShareUtility;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294221d;

        a(boolean z16) {
            this.f294221d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatSettingForTroopApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294221d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294223d;

        b(boolean z16) {
            this.f294223d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatSettingForTroopApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294223d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c extends y.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f294225d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Handler f294226e;

        c(int i3, Handler handler) {
            this.f294225d = i3;
            this.f294226e = handler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatSettingForTroopApiImpl.this, Integer.valueOf(i3), handler);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.y.a
        protected void b(boolean z16, long j3, IPublicAccountDetail iPublicAccountDetail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), iPublicAccountDetail);
                return;
            }
            if (z16) {
                Message obtain = Message.obtain();
                obtain.what = this.f294225d;
                Bundle bundle = new Bundle();
                bundle.putString("uinname", iPublicAccountDetail.getName());
                bundle.putString(AppConstants.Key.EXTRA_TYPE, iPublicAccountDetail.getSummary());
                bundle.putLong("uin", j3);
                obtain.setData(bundle);
                this.f294226e.sendMessage(obtain);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements LongClickCopyAction.ICopyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f294228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f294229b;

        d(AppRuntime appRuntime, View view) {
            this.f294228a = appRuntime;
            this.f294229b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatSettingForTroopApiImpl.this, appRuntime, view);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onCopyContent(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                ReportController.o(this.f294228a, "grp_set", "", "", "grp_data", "grp_set_copy", 0, 0, str, "", "", "");
                QQToast.makeText(this.f294229b.getContext(), 2, R.string.zow, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onShowCopyMenu() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294231d;

        e(boolean z16) {
            this.f294231d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatSettingForTroopApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294231d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    public ChatSettingForTroopApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void bindKeywordStatusToView(Object obj, @NonNull com.tencent.mobileqq.troop.a aVar) {
        if (obj instanceof QFormSimpleItem) {
            QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) obj;
            qFormSimpleItem.setRightText(aVar.f293499a);
            qFormSimpleItem.setTag(R.id.f166671d25, aVar);
            qFormSimpleItem.setContentDescription(HardCodeUtil.qqStr(R.string.vvt) + HardCodeUtil.qqStr(R.string.f2060757b) + aVar.f293499a);
            return;
        }
        if (obj instanceof FormItemRelativeLayout) {
            FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) obj;
            View findViewById = formItemRelativeLayout.findViewById(R.id.i_f);
            if (findViewById instanceof TextView) {
                ((TextView) findViewById).setText(aVar.f293499a);
            }
            formItemRelativeLayout.setTag(R.id.f166671d25, aVar);
            formItemRelativeLayout.setContentDescription(HardCodeUtil.qqStr(R.string.vvt) + HardCodeUtil.qqStr(R.string.f2060757b) + aVar.f293499a);
        }
    }

    private Intent getTroopNameEntryIntent(Intent intent, Object obj, Activity activity, boolean z16, int i3) {
        boolean z17;
        boolean z18;
        String str;
        boolean z19;
        int i16;
        String str2;
        if (!(obj instanceof TroopInfoData)) {
            return null;
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopInfoData.troopUin);
        if (troopInfoFromCache != null && troopInfoFromCache.canModifyTroopName()) {
            z17 = true;
        } else {
            z17 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getTroopNameEntryIntent] canChangeTroopName:");
        sb5.append(z17);
        sb5.append(", info:");
        if (troopInfoFromCache != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        QLog.i(TAG, 1, sb5.toString());
        if (!z17) {
            return null;
        }
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && troopInfoData.mIsFreezed == 1 && troopInfoData.isOwnerOrAdim()) {
            boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
            if (troopInfoData.bOwner) {
                String str3 = troopInfoData.troopUin;
                if (a16) {
                    i16 = 15;
                } else {
                    i16 = 8;
                }
                String spannableString = ff.j(0, i16).toString();
                String qqStr = HardCodeUtil.qqStr(R.string.kgm);
                a aVar = new a(a16);
                if (a16) {
                    str2 = "0X800A57F";
                } else {
                    str2 = "0X8009E38";
                }
                ff.b0(activity, str3, spannableString, qqStr, aVar, str2, 1, a16);
            } else {
                ff.d0(activity, a16);
            }
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E37", 1, 0, "", "", "", "");
            return null;
        }
        String str4 = "";
        if (!troopInfoData.hasSetNewTroopName) {
            str = "";
        } else {
            str = troopInfoData.newTroopName;
        }
        if (str == null) {
            str = "";
        }
        if (!z16 && !troopInfoData.isNewTroop) {
            z19 = true;
        } else {
            z19 = false;
        }
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 1);
        intent.putExtra("edit_mode", 2);
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.kh5));
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
        intent.putExtra("max_num", i3);
        intent.putExtra("canPostNull", false);
        intent.putExtra("edit_mode", z17);
        if (z19) {
            str4 = troopInfoData.troopUin;
        }
        intent.putExtra("troopUin", str4);
        intent.putExtra("max_limit_mode", 1);
        intent.putExtra("default_hint", HardCodeUtil.qqStr(R.string.f235047al));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.tencent.mobileqq.troop.a lambda$initKeyword$0(AppRuntime appRuntime, String str, Void r26) {
        return TroopKeywordManager.e(appRuntime).f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKeyword$1(boolean z16, Object obj, String str, com.tencent.mobileqq.troop.a aVar) {
        if (z16) {
            return;
        }
        bindKeywordStatusToView(obj, aVar);
        ReportController.n(null, "dc00898", "", str, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A8F7", aVar.f293504f, 1, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.tencent.mobileqq.troop.a lambda$queryKeywordEntryStatus$2(AppRuntime appRuntime, String str, Void r26) {
        return TroopKeywordManager.e(appRuntime).f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryKeywordEntryStatus$3(IChatSettingForTroopApi.a aVar, String str, com.tencent.mobileqq.troop.a aVar2) {
        throw null;
    }

    private void sendCommentMessage(Intent intent, SessionInfo sessionInfo) {
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, stringExtra);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void StoryReportor(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void StoryReportorReportEvent(String str, String str2, int i3, int i16, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), strArr);
        } else {
            id0.a.n(str, str2, i3, i16, strArr);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void TroopNameEntry(Object obj, Activity activity, boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, obj, activity, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Intent troopNameEntryIntent = getTroopNameEntryIntent(new Intent(), obj, activity, z16, i3);
        if (troopNameEntryIntent != null) {
            RouteUtils.startActivityForResult(activity, troopNameEntryIntent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, i16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Object actionSheetHelperCreateDialog(Context context, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return iPatchRedirector.redirect((short) 82, (Object) this, (Object) context, (Object) view);
        }
        return ActionSheetHelper.createDialog(context, view);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void addRecentTroopItemIntoRecentMsgList(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        TroopManager troopManager = (TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            troopManager.d(troopManager.k(str));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean appOnClick_Special(AppRuntime appRuntime, Activity activity, long j3, Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, this, appRuntime, activity, Long.valueOf(j3), obj, obj2)).booleanValue();
        }
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        TroopInfo troopInfo = (TroopInfo) obj;
        TroopInfoData troopInfoData = (TroopInfoData) obj2;
        if (troopInfo == null) {
            return false;
        }
        if (j3 == 101761547) {
            com.tencent.mobileqq.listentogether.g.b((QQAppInterface) appRuntime, qBaseActivity.getApplicationContext(), 1, troopInfoData.troopUin, 0);
            return true;
        }
        if (j3 == 101817424 && (appRuntime instanceof QQAppInterface)) {
            com.tencent.mobileqq.troop.utils.r.g((QQAppInterface) appRuntime, qBaseActivity, troopInfo, troopInfoData.troopUin);
            return true;
        }
        if (j3 == 101847770) {
            Intent intent = new Intent();
            intent.putExtra("troop_uin", troopInfoData.troopUin);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 19);
            intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, troopInfo.wMemberNum);
            RouteUtils.startActivity(qBaseActivity, intent, "/troop/memberlist/TroopMemberList");
            return true;
        }
        if (j3 == 101872203) {
            return true;
        }
        if (j3 == 102061052) {
            com.tencent.mobileqq.troop.utils.r.i(qBaseActivity, troopInfo, appRuntime.getCurrentUin());
            return true;
        }
        if (j3 == 102075478) {
            ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openNoticeListPage(qBaseActivity, troopInfoData.troopUin);
            return true;
        }
        if (j3 == 102083361) {
            ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openClockInListPage(qBaseActivity, troopInfoData.troopUin);
            return true;
        }
        if (j3 != 1109863013) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("troop_uin", troopInfoData.troopUin);
        intent2.putExtra("is_from_app_item_clk", true);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopManageForResult(qBaseActivity, intent2, troopInfo.isTroopOwner(appRuntime.getCurrentUin()), 8);
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void bnrReport(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, i3);
        } else {
            qx.a.j(appInterface, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean canShowAppShortCutBar(AppRuntime appRuntime, String str, Boolean bool, int i3) {
        com.tencent.mobileqq.troop.shortcutbar.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, appRuntime, str, bool, Integer.valueOf(i3))).booleanValue();
        }
        try {
            TroopShortcutBarInfo m3 = ((TroopShortcutBarManager) appRuntime.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(Long.parseLong(str)));
            if (m3 == null || (eVar = (com.tencent.mobileqq.troop.shortcutbar.e) am.s().y(c0.CTRL_INDEX, true)) == null) {
                return false;
            }
            if (bool.booleanValue()) {
                return eVar.b(i3);
            }
            if (m3.getGroupDisabled() == 0 && eVar.f298638c == 1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "canShowAppShortCutBar parse troopUin error", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void clearTroopAssistTipTime(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) appRuntime, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Dialog createQuestionDialog(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Dialog) iPatchRedirector.redirect((short) 28, (Object) this, (Object) context);
        }
        return com.tencent.mobileqq.qqexpand.utils.q.b(context);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Intent getChatActivityIntent(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (Intent) iPatchRedirector.redirect((short) 64, (Object) this, (Object) activity);
        }
        return new Intent(activity, (Class<?>) ChatActivity.class);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Intent getJumpActionIntent(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (Intent) iPatchRedirector.redirect((short) 69, (Object) this, (Object) activity);
        }
        return new Intent(activity, (Class<?>) JumpActivity.class);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void getOpenID(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str);
        } else {
            com.tencent.mobileqq.app.handler.a.a(((QQAppInterface) appInterface).getMsgHandler(), str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public String getQzoneHelperQunPhotoDataHasChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return QZoneHelper.Constants.KEY_QUN_PHOTO_DATA_HAS_CHANGED;
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void getReportMsgIfNull(@Nullable String str, String str2, String str3, int i3, @Nullable Bundle bundle, Function1<String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, Integer.valueOf(i3), bundle, function1);
        } else {
            NTJuBaoUtil.b(str, str2, str3, i3, bundle, function1);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public SpannableString getSpannableStringFromColorNickText(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (SpannableString) iPatchRedirector.redirect((short) 41, (Object) this, (Object) charSequence, i3);
        }
        return new com.tencent.mobileqq.text.c(charSequence, i3).j();
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Intent getSplashActivityIntent(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (Intent) iPatchRedirector.redirect((short) 65, (Object) this, (Object) activity);
        }
        return SplashActivity.getAliasIntent(activity);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Object getStrOpenIDFromCacheAndDB(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        }
        return ((QQAppInterface) appInterface).getMsgHandler().b3(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Intent getTroopNameEntryIntentForFragment(Object obj, Activity activity, boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Intent) iPatchRedirector.redirect((short) 31, this, obj, activity, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return getTroopNameEntryIntent(new Intent(activity, (Class<?>) EditInfoActivity.class), obj, activity, z16, i3);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Bundle getTroopProfileExtra(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Bundle) iPatchRedirector.redirect((short) 51, (Object) this, (Object) str, i3);
        }
        return aq.b(str, i3);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Intent getTroopTagViewIntent(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (Intent) iPatchRedirector.redirect((short) 52, (Object) this, (Object) activity);
        }
        return new Intent(activity, (Class<?>) TroopTagViewActivity.class);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public String getUrlFromIndividuationUrlHelper_entryEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (String) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.TROOP_ENTER_EFFECT);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public String getUrlFromIndividuationUrlHelper_keyWord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.GROUP_KEYWORD);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void gotoSettingOrShare(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void handleARKAppShareAction(AppRuntime appRuntime, Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, appRuntime, activity, intent);
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
        m3.putExtras(new Bundle(intent.getExtras()));
        SessionInfo n06 = ForwardUtils.n0(m3);
        sendCommentMessage(intent, n06);
        ForwardUtils.q((QQAppInterface) appRuntime, n06, m3);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void handleAppClick1101236949(Object obj, Activity activity) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, obj, (Object) activity);
            return;
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && troopInfoData.mIsFreezed == 1 && troopInfoData.isOwnerOrAdim()) {
            boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
            if (troopInfoData.bOwner) {
                String str2 = troopInfoData.troopUin;
                if (a16) {
                    i3 = 15;
                } else {
                    i3 = 8;
                }
                String spannableString = ff.j(0, i3).toString();
                String qqStr = HardCodeUtil.qqStr(R.string.j6l);
                e eVar = new e(a16);
                if (a16) {
                    str = "0X800A57F";
                } else {
                    str = "0X8009E38";
                }
                String str3 = str;
                if (a16) {
                    i16 = 1;
                } else {
                    i16 = 3;
                }
                ff.b0(activity, str2, spannableString, qqStr, eVar, str3, i16, a16);
            } else {
                ff.d0(activity, a16);
            }
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E37", 3, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void handleAppShareAction(AppRuntime appRuntime, Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, appRuntime, activity, intent);
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
        m3.putExtras(new Bundle(intent.getExtras()));
        ForwardUtils.p((QQAppInterface) appRuntime, activity, ForwardUtils.n0(m3), m3);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void handleTroopAppManageShortcutBar(AppRuntime appRuntime, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, appRuntime, str, obj);
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) obj;
        com.tencent.mobileqq.troop.utils.r.b(2, Long.parseLong(str), (QQAppInterface) appRuntime, qBaseActivity.getApplicationContext(), qBaseActivity);
        TroopShortcutBarInfo m3 = ((TroopShortcutBarManager) appRuntime.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(Long.parseLong(str)));
        if (m3 != null) {
            m3.setCacheTSMil(0);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean hasKeywords(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        return TroopKeywordManager.e(MobileQQ.sMobileQQ.peekAppRuntime()).g(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void hiddenChatShowGuideDialog(AppRuntime appRuntime, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) appRuntime, (Object) activity);
        } else {
            com.tencent.mobileqq.app.hiddenchat.a.c((QQAppInterface) appRuntime).f(activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void hideJuhua(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, obj, (Object) str);
            return;
        }
        try {
            QQProgressDialog qQProgressDialog = (QQProgressDialog) obj;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                qQProgressDialog.dismiss();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(str, 2, e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void initKeyword(final AppRuntime appRuntime, final String str, final boolean z16, final Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, appRuntime, str, Boolean.valueOf(z16), obj);
        } else {
            new QueryTask(new QueryTask.a() { // from class: com.tencent.mobileqq.troop.api.impl.c
                @Override // com.tencent.mobileqq.model.QueryTask.a
                public final Object query(Object obj2) {
                    com.tencent.mobileqq.troop.a lambda$initKeyword$0;
                    lambda$initKeyword$0 = ChatSettingForTroopApiImpl.lambda$initKeyword$0(AppRuntime.this, str, (Void) obj2);
                    return lambda$initKeyword$0;
                }
            }, new QueryCallback() { // from class: com.tencent.mobileqq.troop.api.impl.d
                @Override // com.tencent.mobileqq.vas.theme.api.QueryCallback
                public final void postQuery(Object obj2) {
                    ChatSettingForTroopApiImpl.this.lambda$initKeyword$1(z16, obj, str, (com.tencent.mobileqq.troop.a) obj2);
                }
            }).a(null);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void initTroopShareUtility(Activity activity, Object obj, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 78)) {
            this.mTroopShareUtility = TroopUtils.Q((QBaseActivity) activity, (TroopInfoData) obj, (QQAppInterface) appRuntime, Boolean.FALSE);
        } else {
            iPatchRedirector.redirect((short) 78, this, activity, obj, appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void inviteMember(Activity activity, String str, boolean z16, ArrayList<String> arrayList, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, activity, str, Boolean.valueOf(z16), arrayList, Integer.valueOf(i3));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[inviteMember] troopUin: ");
        if (str == null) {
            str2 = "null";
        } else {
            str2 = str;
        }
        sb5.append(str2);
        QLog.i(TAG, 1, sb5.toString());
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str);
        intent.putExtra("param_type", 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_IS_TROOP_ADMIN, z16);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, activity.getString(R.string.b9f));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, activity.getString(R.string.dpe));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 100);
        if (!((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).canInviteRobotInGroup(MobileQQ.sMobileQQ.peekAppRuntime(), str)) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, false);
        }
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 38);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 38);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_WITH_HISTORY, activity.getIntent().getBooleanExtra(ISelectMemberActivityConstants.PARAM_WITH_HISTORY, false));
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, i3);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean isGrayTroopForTroopAssociations(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        com.tencent.mobileqq.troop.association.a aVar = (com.tencent.mobileqq.troop.association.a) am.s().x(LpReportInfoConfig.ACTION_TYPE_DAWANG);
        if (aVar != null && aVar.a(str, i3, j3)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean isGroupEntranceSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        TroopFansEntryConfig troopFansEntryConfig = (TroopFansEntryConfig) am.s().x(701);
        if (troopFansEntryConfig != null) {
            return troopFansEntryConfig.isGroupEntranceSwitchOn();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean isShowingAppShortCutBar(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        try {
            TroopShortcutBarInfo m3 = ((TroopShortcutBarManager) appRuntime.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(Long.parseLong(str)));
            if (m3 == null) {
                return false;
            }
            if (m3.getDisabled() != 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "isShowingAppShortCutBar parse troopUin error", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void jump2PayJoinTroopWeb(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, context, str, str2);
        } else {
            com.tencent.mobileqq.troop.troopnotification.utils.h.d(context, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean keyWordIsEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return TroopKeywordManager.h();
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void launcherTroopShortcutFragment(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) activity, (Object) str);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("troop_uin", str);
        new SessionInfo();
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = str;
        sessionInfo.f179555d = 1;
        sessionInfo.f179559f = str;
        intent.putExtra(AppConstants.Key.SESSION_INFO, sessionInfo);
        intent.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
        intent.putExtra(FlingConstant.FLING_CODE_KEY, hashCode());
        intent.putExtra("reportfrom", 2);
        PublicFragmentActivity.b.a(activity, intent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void markNewMemberIndexAndUinDailyFromPush(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
            return;
        }
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        if (troopBatchAddFriendMgr.l("newMember") && troopBatchAddFriendMgr.R(str)) {
            troopBatchAddFriendMgr.E(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void messageNotificationSettingFragmentLaunch(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) activity, (Object) intent);
        } else {
            MessageNotificationSettingFragment.hi(activity, intent);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean needAnswerQuestion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str)).booleanValue();
        }
        return ((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void newReportTask(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, appRuntime, str, Integer.valueOf(i3));
        } else {
            new com.tencent.mobileqq.statistics.q((QQAppInterface) appRuntime).i("dc00899").a("Grp_private").f("Grp_data").d("exp").b(str, String.valueOf(i3)).g();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void newTroopShareUtility(Activity activity, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) activity, obj);
        } else {
            this.mTroopShareUtility = new com.tencent.mobileqq.troopshare.e((QBaseActivity) activity, (TroopInfoData) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void notifyTroopMaskChanged(String str, GroupMsgMask groupMsgMask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) groupMsgMask);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface.getTroopMask(str) == GroupMsgMask.SHIELD && ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(str)) {
            QLog.d("TroopMaskTroopInfoProcessor", 1, "notifyTroopMaskChanged setTroopGuildMsgRead troopUin " + str);
            ((ITroopGuildUnreadCntService) qQAppInterface.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(str, GuildGroupSceneType.KALL, false);
        }
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
            if (qQAppInterface.isLogin()) {
                ((IAppBadgeService) qQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void openAddTroopWeb(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, activity, str, str2);
            return;
        }
        String str3 = str + "?_wv=1031&troopUin=" + str2 + "&isVerify=0";
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str3);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        intent.putExtra("show_right_close_button", true);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void openTroopAssociationWebPage(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) context, (Object) str);
        } else {
            com.tencent.mobileqq.troop.associations.a.b(context, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void openTroopInfoActivity(Context context, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, context, bundle, Integer.valueOf(i3));
        } else {
            TroopUtils.I(context, bundle, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void openTroopManageForResult(Activity activity, Intent intent, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, activity, intent, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            QPublicFragmentActivity.startForResult(activity, intent, com.tencent.mobileqq.troopmanage.base.b.d(z16), i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void openTroopmemberCard(AppRuntime appRuntime, Context context, String str, String str2, int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, appRuntime, context, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
        } else {
            com.tencent.mobileqq.profile.l.e((QQAppInterface) appRuntime, context, str, str2, i3, i16, bundle);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void preDownloadRing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            MessageNotificationSettingManager.l((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).O(i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void preloadQunAlbum(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void queryKeywordEntryStatus(final AppRuntime appRuntime, final String str, final IChatSettingForTroopApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, appRuntime, str, aVar);
        } else {
            new QueryTask(new QueryTask.a() { // from class: com.tencent.mobileqq.troop.api.impl.e
                @Override // com.tencent.mobileqq.model.QueryTask.a
                public final Object query(Object obj) {
                    com.tencent.mobileqq.troop.a lambda$queryKeywordEntryStatus$2;
                    lambda$queryKeywordEntryStatus$2 = ChatSettingForTroopApiImpl.lambda$queryKeywordEntryStatus$2(AppRuntime.this, str, (Void) obj);
                    return lambda$queryKeywordEntryStatus$2;
                }
            }, new QueryCallback(aVar, str) { // from class: com.tencent.mobileqq.troop.api.impl.f

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f294282a;

                {
                    this.f294282a = str;
                }

                @Override // com.tencent.mobileqq.vas.theme.api.QueryCallback
                public final void postQuery(Object obj) {
                    ChatSettingForTroopApiImpl.lambda$queryKeywordEntryStatus$3(null, this.f294282a, (com.tencent.mobileqq.troop.a) obj);
                }
            }).a(null);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void refreshAppShortCutBarAppList(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        try {
            ((TroopShortcutBarHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).E2(Long.parseLong(str), i3, null);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "refreshAppShortCutBarAppList parse troopUin error", e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void reportClockTroopAppShowOrClick(Object obj, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, obj, Boolean.valueOf(z16));
            return;
        }
        if (obj != null) {
            str = ((TroopInfo) obj).troopuin;
        } else {
            str = "";
        }
        QQGameTroopManager.p(1, str, false);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void reportCommercialDrainage(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str5, str6, str7);
        } else {
            VasWebviewUtil.reportCommercialDrainage(str, str2, str3, str4, i3, i16, i17, str5, str6, str7);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void reportDC00087(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, appInterface, str, str2, str3, str4, str5, str6);
        } else {
            hl0.a.b(null, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void requestForPubAccountInfo(AppRuntime appRuntime, long j3, int i3, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, appRuntime, Long.valueOf(j3), Integer.valueOf(i3), handler);
        } else {
            y.a((QQAppInterface) appRuntime, j3, new c(i3, handler));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void sendBroadcastQunMsgUnreadCount(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) activity, i3);
        } else {
            QZoneHelper.sendBroadcastQunMsgUnreadCount(activity, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void setAppIcon(Context context, ImageView imageView, String str, float f16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, context, imageView, str, Float.valueOf(f16), Boolean.valueOf(z16));
        } else {
            com.tencent.mobileqq.troop.utils.r.l(context, imageView, str, f16, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void setAppShortCutBarSwitch(AppRuntime appRuntime, String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, appRuntime, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        try {
            ((TroopShortcutBarHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).I2(Long.parseLong(str), i3, z16);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "setAppShortCutBarSwitch parse troopUin error", e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void setBooleanForQVipConfigManager_keyWordGuideClicked(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) appRuntime);
        } else {
            QVipConfigManager.setBoolean(appRuntime, QVipConfigManager.KEY_BOOLEAN_KEYWORD_GUIDE_CLICKED, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void setColorText(AppRuntime appRuntime, TextView textView, Spannable spannable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) {
            com.tencent.mobileqq.vas.f.q((QQAppInterface) appRuntime, textView, spannable);
        } else {
            iPatchRedirector.redirect((short) 42, this, appRuntime, textView, spannable);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void setStringForQVipConfigManager_keyWordExpireList(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, appRuntime, str, str2);
            return;
        }
        QVipConfigManager.setString(appRuntime, QVipConfigManager.KEY_STRING_LAST_TROOP_KEYWORD_EXPIRE_LIST + str, str2);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startActivityForTroop(Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, activity, str, Integer.valueOf(i3));
        } else {
            QRoute.createNavigator(activity, "/base/chathistory/main").withInt("nt_chat_history_chatType", 2).withString("nt_chat_history_peerId", str).request();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startChatBackgroundSettingActivity(Activity activity, AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, activity, appRuntime, str, Integer.valueOf(i3));
        } else {
            TroopUtils.R(activity, (QQAppInterface) appRuntime, str, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startFansTroopIdolPage(Context context, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, context, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            com.tencent.mobileqq.troop.utils.b.d(context, str, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startFansTroopIdolRank(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, context, str, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.troop.utils.b.e(context, str, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startGameSdkCallback(Activity activity, boolean z16, String str, long j3, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, activity, Boolean.valueOf(z16), str, Long.valueOf(j3), Integer.valueOf(i3), str2);
        } else {
            ForwardSdkBaseOption.E(activity, z16, str, j3, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public Intent startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Intent) iPatchRedirector.redirect((short) 37, this, context, str, str2, Short.valueOf(s16), Integer.valueOf(i3), str3, str4, str5, str6, str7, str8, str9);
        }
        return AddFriendLogicActivity.startJoinTroop(context, str, str2, s16, i3, str3, str4, str5, str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startJumpAccountLogin(Activity activity, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) activity, obj);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("is_change_account", true);
        intent.putExtra("if_check_account_same", true);
        intent.putExtras(activity.getIntent().getExtras());
        intent.putExtra("key_action", ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity());
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        ((QQCustomDialog) obj).cancel();
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startModifyHomeworkTroopNickname(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, context, str, str2, str3);
        } else {
            com.tencent.mobileqq.troop.utils.d.c(context, str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startModifyLocationActivityForResult(Activity activity, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, activity, str, str2, Integer.valueOf(i3));
        } else {
            TroopLocationModifyActivity.startModifyLocationActivityForResult(activity, str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startTroop2DCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this);
        } else {
            this.mTroopShareUtility.b0();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startTroopMemberCard(Activity activity, AppRuntime appRuntime, com.tencent.mobileqq.troop.k kVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, activity, appRuntime, kVar, Integer.valueOf(i3));
            return;
        }
        if (kVar.b()) {
            com.tencent.mobileqq.troop.utils.d.c(activity, appRuntime.getCurrentAccountUin(), kVar.e(), IHWTroopUtilsApi.HOMEWORK_TROOP_PROFILE_SOURCE);
            ReportController.o(appRuntime, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, kVar.e(), "", "", "");
        } else {
            Intent intent = new Intent();
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 5);
            intent.putExtra("edit_mode", 0);
            intent.putExtra("title", HardCodeUtil.qqStr(R.string.eqr));
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, kVar.c());
            intent.putExtra("max_num", 60);
            intent.putExtra("default_nick_id", kVar.d());
            intent.putExtra("troopUin", kVar.e());
            intent.putExtra("uin", appRuntime.getAccount());
            intent.putExtra("from", 0);
            intent.putExtra("max_limit_mode", 1);
            RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, i3);
        }
        ReportController.o(appRuntime, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, kVar.e(), "", "", "");
        eu.g("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, kVar.e(), kVar.a());
        VasWebviewUtil.reportCommercialDrainage(appRuntime.getCurrentUin(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void startTroopRemarkActivity(Activity activity, String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, activity, str, str2, str3, str4, Integer.valueOf(i3));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "startTroopRemarkActivity: troop uin null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(TroopRemarkEditFragment.P, str);
        intent.putExtra(TroopRemarkEditFragment.R, str3);
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra(TroopRemarkEditFragment.S, str4);
        }
        PublicFragmentActivity.startForResult(activity, intent, TroopRemarkEditFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public boolean troopNoticeFreezed(Activity activity, Object obj) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, (Object) activity, obj)).booleanValue();
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        if (!QVipBigTroopExpiredProcessor.getConfig().mIsEnable || troopInfoData.mIsFreezed != 1 || !troopInfoData.isOwnerOrAdim()) {
            return false;
        }
        boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
        if (troopInfoData.bOwner) {
            String str2 = troopInfoData.troopUin;
            if (a16) {
                i3 = 15;
            } else {
                i3 = 8;
            }
            String spannableString = ff.j(0, i3).toString();
            String qqStr = HardCodeUtil.qqStr(R.string.j6l);
            b bVar = new b(a16);
            if (a16) {
                str = "0X800A57F";
            } else {
                str = "0X8009E38";
            }
            if (a16) {
                i16 = 1;
            } else {
                i16 = 3;
            }
            ff.b0(activity, str2, spannableString, qqStr, bVar, str, i16, a16);
        } else {
            ff.d0(activity, a16);
        }
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E37", 3, 0, "", "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void troopShareUtilityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
            return;
        }
        com.tencent.mobileqq.troopshare.e eVar = this.mTroopShareUtility;
        if (eVar != null) {
            eVar.O();
            this.mTroopShareUtility = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void updateEntryItem(AppRuntime appRuntime, View view, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z16, String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, appRuntime, view, charSequence, charSequence2, charSequence3, Boolean.valueOf(z16), str, str2);
            return;
        }
        if (str2 == null) {
            str3 = HardCodeUtil.qqStr(R.string.f170798cj0);
        } else {
            str3 = str2;
        }
        TroopUtils.X(view, charSequence, null, null, z16, str, str3, new d(appRuntime, view));
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void updateHiddenChat(AppRuntime appRuntime, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) appRuntime, obj);
        } else {
            com.tencent.mobileqq.app.hiddenchat.c.a((QQAppInterface) appRuntime, (TroopInfo) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void updateTroopMemberCard(String str, String str2, MessageMicro messageMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, str, str2, messageMicro);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopMemberCardInfo troopMemberCardInfo = ((ITroopDBUtilsApi) QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(peekAppRuntime, str, str2);
        SubMsgType0x27$GroupMemberProfileInfo subMsgType0x27$GroupMemberProfileInfo = (SubMsgType0x27$GroupMemberProfileInfo) messageMicro;
        if (subMsgType0x27$GroupMemberProfileInfo.uint32_field.has() && subMsgType0x27$GroupMemberProfileInfo.bytes_value.has()) {
            if (subMsgType0x27$GroupMemberProfileInfo.uint32_field.get() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + subMsgType0x27$GroupMemberProfileInfo.bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + subMsgType0x27$GroupMemberProfileInfo.bytes_value.get().size());
                }
                QQProfileItem.d("cardpush", subMsgType0x27$GroupMemberProfileInfo.bytes_value.get().toByteArray(), subMsgType0x27$GroupMemberProfileInfo.bytes_value.get().size());
                if (troopMemberCardInfo != null) {
                    String j3 = com.tencent.mobileqq.vas.f.j(subMsgType0x27$GroupMemberProfileInfo.bytes_value.get());
                    troopMemberCardInfo.colorNick = j3;
                    troopMemberCardInfo.name = com.tencent.mobileqq.vas.f.o(j3);
                    troopMemberCardInfo.colorNickId = com.tencent.mobileqq.vas.f.k(subMsgType0x27$GroupMemberProfileInfo.bytes_value.get().toByteArray());
                }
            } else if (subMsgType0x27$GroupMemberProfileInfo.uint32_field.get() == 7 && troopMemberCardInfo != null) {
                String j16 = com.tencent.mobileqq.vas.f.j(subMsgType0x27$GroupMemberProfileInfo.bytes_value.get());
                troopMemberCardInfo.colorNick = j16;
                troopMemberCardInfo.name = com.tencent.mobileqq.vas.f.o(j16);
                troopMemberCardInfo.colorNickId = com.tencent.mobileqq.vas.f.k(subMsgType0x27$GroupMemberProfileInfo.bytes_value.get().toByteArray());
            }
        }
        if (troopMemberCardInfo != null) {
            ((ITroopDBUtilsApi) QRoute.api(ITroopDBUtilsApi.class)).saveTroopMemberCardInfo(peekAppRuntime, troopMemberCardInfo);
            ArrayList arrayList = new ArrayList();
            arrayList.add(troopMemberCardInfo);
            if (peekAppRuntime instanceof AppInterface) {
                ((AppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH, true, arrayList);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void initTroopShareUtility(Activity activity, QBaseFragment qBaseFragment, Object obj, AppRuntime appRuntime, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 79)) {
            this.mTroopShareUtility = TroopUtils.P((QBaseActivity) activity, qBaseFragment, (TroopInfoData) obj, (QQAppInterface) appRuntime, bundle, Boolean.FALSE);
        } else {
            iPatchRedirector.redirect((short) 79, this, activity, qBaseFragment, obj, appRuntime, bundle);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IChatSettingForTroopApi
    public void setColorText(TextView textView, Spannable spannable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
            com.tencent.mobileqq.vas.f.p(textView, spannable, i3);
        } else {
            iPatchRedirector.redirect((short) 43, this, textView, spannable, Integer.valueOf(i3));
        }
    }
}
