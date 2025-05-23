package com.tencent.mobileqq.activity.miniaio;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.h;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IConfirmDeleteCallback;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MiniMsgTabFragment extends PublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private View D;
    h.b E;
    private String F;
    private String G;
    private String H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private Parcelable M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;
    private ShareActionSheet W;
    private ShareActionSheet.OnItemClickListener X;
    private int Y;
    private View.OnClickListener Z;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgTabFragment.this);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01a5  */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            int i3 = actionSheetItem.action;
            int i16 = actionSheetItem.uinType;
            String str2 = actionSheetItem.uin;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniAppShareSheetItemClick(MiniMsgTabFragment.this.F, actionSheetItem.uin, actionSheetItem.source, actionSheetItem.action);
            if (i3 != 2) {
                if (i3 == 3) {
                    MiniMsgTabFragment.this.Jh(5, null);
                    ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).share2QZone(MiniMsgTabFragment.this.F, MiniMsgTabFragment.this.Nh(), MiniMsgTabFragment.this.getActivity(), MiniMsgTabFragment.this.getIntent().getStringExtra("videoPath"), MtpConstants.RESPONSE_NO_VALID_OBJECT_INFO);
                } else if (i3 == 9) {
                    MiniMsgTabFragment.this.Jh(6, null);
                } else if (i3 == 10) {
                    MiniMsgTabFragment.this.Jh(7, null);
                } else if (i3 == 158) {
                    MiniMsgTabFragment.this.Jh(15, null);
                } else if (i3 != 159) {
                    switch (i3) {
                        case 6:
                            MiniMsgTabFragment.this.Jh(17, null);
                            break;
                        case 14:
                            MiniMsgTabFragment.this.Jh(10, null);
                            break;
                        case 26:
                            str2 = AppConstants.DATALINE_NEW_VERSION_UIN;
                            MiniMsgTabFragment.this.Lh(str2, i16);
                            break;
                        case 39:
                            MiniMsgTabFragment.this.Th();
                            break;
                        case 70:
                            MiniMsgTabFragment.this.Jh(13, null);
                            break;
                        case 128:
                            MiniMsgTabFragment.this.Jh(14, null);
                            break;
                        case 151:
                            MiniMsgTabFragment.this.Jh(11, null);
                            break;
                        case 169:
                            MiniMsgTabFragment.this.Jh(18, null);
                            break;
                        case 171:
                            MiniMsgTabFragment.this.Jh(19, null);
                            break;
                        case 180:
                            MiniMsgTabFragment.this.Jh(21, null);
                            boolean isEverShowScreenRecord = ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).isEverShowScreenRecord();
                            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                            String str3 = MiniMsgTabFragment.this.F;
                            if (isEverShowScreenRecord) {
                                str = "0";
                            } else {
                                str = "1";
                            }
                            iMiniAppService.reportByQQ(str3, "set", "screenRecord", "screenRecord_on", "", str, "", "");
                            break;
                        case 182:
                            MiniMsgTabFragment.this.Jh(22, null);
                            break;
                        case 184:
                            ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).openQCirclePublishPage(MiniMsgTabFragment.this.F, MiniMsgTabFragment.this.getIntent().getStringExtra("videoPath"), MiniMsgTabFragment.this.getBaseActivity());
                            MiniMsgTabFragment.this.Jh(23, null);
                            break;
                        case 208:
                            SDKMiniProgramLpReportDC04239.reportAsync(null, "page_view", "em_click", "minigame_mission_page_mygame_entrance", "", MiniMsgTabFragment.this.F, "");
                            MiniMsgTabFragment.this.Jh(25, null);
                            break;
                        default:
                            switch (i3) {
                                case 72:
                                    MiniMsgTabFragment.this.Lh(str2, i16);
                                    break;
                                case 73:
                                    break;
                                case 74:
                                case 75:
                                    MiniMsgTabFragment.this.Jh(2, null);
                                    break;
                                case 76:
                                case 77:
                                    MiniMsgTabFragment.this.Jh(8, null);
                                    break;
                                case 78:
                                    if (MiniMsgTabFragment.this.N != -1) {
                                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMainPageFragment(MiniMsgTabFragment.this.getBaseActivity(), MiniMsgTabFragment.this.M, MiniMsgTabFragment.this.N);
                                        break;
                                    }
                                    break;
                                case 79:
                                case 80:
                                    MiniMsgTabFragment.this.Jh(3, null);
                                    break;
                                case 81:
                                    MiniMsgTabFragment.this.Jh(9, null);
                                    break;
                                case 82:
                                    break;
                                case 83:
                                    if (MiniMsgTabFragment.this.getBaseActivity() != null) {
                                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchPermissionSettingFragmentForResult(MiniMsgTabFragment.this.getBaseActivity(), MiniMsgTabFragment.this.F, MiniMsgTabFragment.this.G, MiniMsgTabFragment.this.getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_IS_MINI_GAME, false), 5);
                                        break;
                                    } else {
                                        QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick getActivity is null when ACTION_SETTING");
                                        break;
                                    }
                                default:
                                    QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick with invalid case:" + i3);
                                    break;
                            }
                    }
                } else {
                    MiniMsgTabFragment.this.Jh(16, null);
                }
                MiniMsgTabFragment.this.U = true;
            }
            MiniMsgTabFragment.this.Kh();
            MiniMsgTabFragment.this.U = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgTabFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QLog.i("MiniMsgTabFragment", 1, "shareActionSheet onCancel!");
                MiniMsgTabFragment.this.Jh(-1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements IConfirmDeleteCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f183464a;

        c(int i3) {
            this.f183464a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgTabFragment.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.mini.api.IConfirmDeleteCallback
        public void onConfirmDeleteVideo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MiniMsgTabFragment.this.Ih();
                MiniMsgTabFragment.this.Jh(this.f183464a, null);
                MiniMsgTabFragment.this.Sh(true);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgTabFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MiniMsgTabFragment.this.Hh(-1);
                QLog.i("MiniMsgTabFragment", 1, "shareActionSheet mClickCancelListener!");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MiniMsgTabFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.F = null;
        this.G = null;
        this.H = null;
        this.T = false;
        this.U = false;
        this.V = 0L;
        this.X = new a();
        this.Y = 0;
        this.Z = new d();
    }

    private boolean Gh() {
        IGPSService iGPSService;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            QLog.e("MiniMsgTabFragment", 2, "checkUserHaveGuild baseApplication is null");
            return false;
        }
        AppRuntime runtime = application.getRuntime();
        if (runtime == null) {
            QLog.e("MiniMsgTabFragment", 2, "checkUserHaveGuild appRuntime is null");
            return false;
        }
        try {
            iGPSService = (IGPSService) runtime.getRuntimeService(IGPSService.class, "");
        } catch (IllegalStateException e16) {
            QLog.e("MiniMsgTabFragment", 1, "checkUserHaveGuild error with IGPSService:" + e16);
            iGPSService = null;
        }
        if (iGPSService == null) {
            QLog.e("MiniMsgTabFragment", 2, "checkUserHaveGuild gpsService is null");
            return false;
        }
        List<IGProGuildInfo> guildList = iGPSService.getGuildList();
        if (guildList == null) {
            QLog.e("MiniMsgTabFragment", 2, "checkUserHaveGuild gProGuildInfoList is null");
            return false;
        }
        int size = guildList.size();
        QLog.d("MiniMsgTabFragment", 2, "checkUserHaveGuild guildNum = " + size);
        if (size <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(int i3) {
        if (!isClickable()) {
            return;
        }
        if (Oh() && this.C != null) {
            ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).showDeleteVideoConfirmDialog(this.F, this.C.getCurrentAccountUin(), new c(i3), getBaseActivity());
            return;
        }
        Ih();
        Jh(i3, null);
        Sh(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        if (!this.U && Nh()) {
            final String stringExtra = getIntent().getStringExtra("videoPath");
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.activity.miniaio.k
                @Override // java.lang.Runnable
                public final void run() {
                    FileUtils.deleteFile(stringExtra);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(int i3, Bundle bundle) {
        QQAppInterface qQAppInterface;
        int b16;
        ShareActionSheet shareActionSheet = this.W;
        if (shareActionSheet != null) {
            shareActionSheet.dismissImmediately();
        }
        if (getBaseActivity() == null) {
            QLog.e("MiniMsgTabFragment", 1, "getActivity is null when calling dismissMsgFragment");
            return;
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            b16 = 0;
        } else {
            b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
        }
        Intent intent = getIntent();
        intent.putExtra("miniAppID", this.F);
        intent.putExtra(MiniChatConstants.CLICK_ID, i3);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
        getBaseActivity().setResult(-1, intent);
        getBaseActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        if (Nh()) {
            ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).shareRecordVideo2Friend(this.F, getIntent().getStringExtra("videoPath"), getBaseActivity());
        }
        Jh(1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(String str, int i3) {
        if (Nh()) {
            ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).shareRecordVideo2TargetFriend(this.F, getIntent().getStringExtra("videoPath"), getBaseActivity(), str, i3);
            return;
        }
        Bundle bundle = new Bundle();
        QLog.d("MiniMsgTabFragment", 2, "shareToChatDirectly handleShareChatItemClick, uin:" + str + ",uinType:" + i3);
        bundle.putString("key_mini_app_share_chat_uin", str);
        bundle.putInt("key_mini_app_share_chat_type", i3);
        Jh(12, bundle);
        if (QLog.isColorLevel()) {
            QLog.d("MiniMsgTabFragment", 2, "handleShareChatItemClick");
        }
    }

    private void Mh() {
        boolean z16;
        this.Y = 1;
        ArrayList arrayList = new ArrayList();
        boolean booleanExtra = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QQ, false);
        if (booleanExtra) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_GUILD, false) && Gh()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_DATALINE, false)) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        }
        boolean booleanExtra2 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QZONE, false);
        if (booleanExtra2) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        }
        boolean booleanExtra3 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_FRIENDS, false);
        if (booleanExtra3) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        }
        boolean booleanExtra4 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_MOMENT, false);
        if (booleanExtra4) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        if (!booleanExtra && !booleanExtra2 && !booleanExtra3 && !booleanExtra4) {
            z16 = false;
        } else {
            this.Y++;
            z16 = true;
        }
        ArrayList arrayList2 = new ArrayList();
        boolean booleanExtra5 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_IS_MINI_GAME, false);
        if (booleanExtra5 && getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_COMPLAINT, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(151));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_ENABLE_GAME_BOX, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(208));
            SDKMiniProgramLpReportDC04239.reportAsync(null, "page_view", "em_expo", "minigame_mission_page_mygame_entrance", "", getIntent().getStringExtra("miniAppID"), "");
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_SAVE_2_LOCAL, false)) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        }
        int intExtra = getIntent().getIntExtra("key_color_note", 0);
        if (intExtra != 0) {
            if (intExtra == 1) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(70));
            } else if (intExtra == 2) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(82));
            }
        }
        int intExtra2 = getIntent().getIntExtra(MiniChatConstants.MINI_APP_TOP_TYPE, 0);
        getIntent().getBooleanExtra(MiniChatConstants.KEY_MINI_APP_IS_SPECIAL, false);
        boolean booleanExtra6 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_IS_LIMITED_ACCESS, false);
        if (!getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYAPP, false) && !booleanExtra6) {
            if (intExtra2 == 0) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(76));
            } else if (intExtra2 != -11) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(77));
            }
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_ADD_SHORTCUT, false) && !booleanExtra6) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
        }
        int intExtra3 = getIntent().getIntExtra(MiniChatConstants.MINI_APP_SHOW_BACK_HOME, -1);
        if (intExtra3 != -1 && intExtra3 == 1) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(81));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_RESTART_MINIAPP, true)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(128));
        }
        if (!getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYFAVOR, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SET_TO_TROOP, false) && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isTroopAdminOrCreated()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(158));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_ADD_TO_CURRENT_TROOP, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(159));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_DETAIL, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(78));
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SETTING, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(83));
        }
        if (!booleanExtra5 && getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_COMPLAINT, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(151));
        }
        boolean booleanExtra7 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_DEBUG, false);
        boolean booleanExtra8 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_DEBUG_ENABLE, false);
        if (booleanExtra7) {
            if (booleanExtra8) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(75));
            } else {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
            }
        }
        boolean booleanExtra9 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_MONITOR, false);
        boolean booleanExtra10 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_OPEN_MONITOR, false);
        if (booleanExtra9) {
            if (booleanExtra10) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(80));
            } else {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(79));
            }
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_EXPORT_LOG, false)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(169));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.M = arguments.getParcelable("key_mini_app_config");
        }
        this.N = getIntent().getIntExtra(MiniChatConstants.KEY_MINI_APP_VERSION_TYPE, -1);
        if ("1108291530".equals(this.F) || MiniAppSecurityUtil.doCheckSafeUnblockWithLogin(this.F)) {
            z16 = false;
        }
        this.S = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_KINGCARD_TIP, false);
        this.F = getIntent().getStringExtra("miniAppID");
        this.G = getIntent().getStringExtra(MiniChatConstants.MINI_APP_NAME);
        this.H = getIntent().getStringExtra(MiniChatConstants.MINI_APP_ICON_URL);
        getBaseActivity().getIntent().putExtra("big_brother_source_key", "biz_src_miniapp");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = getBaseActivity();
        param.canceledOnTouchOutside = true;
        param.flagNotTouchModal = true;
        param.dimAmount = 0.0f;
        if (Nh()) {
            param.isCancelable = false;
        }
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.W = create;
        if (booleanExtra) {
            this.Y++;
            Intent intent = new Intent();
            intent.putExtra("forward_type", 27);
            this.W.setIntentForStartForwardRecentActivity(intent);
            this.W.setRowVisibility(0, 0, 0);
        } else {
            create.setRowVisibility(8, 0, 0);
        }
        if (!z16) {
            this.W.setActionSheetTitle("");
        }
        this.W.setActionSheetItems(arrayList, arrayList2);
        this.W.setItemClickListenerV2(this.X);
        ShareActionSheet shareActionSheet = this.W;
        if (shareActionSheet instanceof com.tencent.mobileqq.widget.share.c) {
            ((com.tencent.mobileqq.widget.share.c) shareActionSheet).a(this.Z);
        }
        this.W.setCancelListener(new b());
        Vh(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nh() {
        if (getIntent().getIntExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_LAUNCH_FROM, 0) != 2) {
            return false;
        }
        return true;
    }

    private boolean Oh() {
        boolean booleanExtra = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_SCREEN_RECORD_SAVE_2_LOCAL, false);
        if (!Nh() || !booleanExtra || this.T) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(DialogInterface dialogInterface) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportShareSheetShow(this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rh(List list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ResultRecord resultRecord = (ResultRecord) it.next();
                arrayList.add(resultRecord.uin);
                arrayList2.add(Integer.valueOf(resultRecord.source));
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportShareSheetShareFriendExpo(this.F, arrayList, arrayList2);
            return;
        }
        QLog.i("MiniMsgTabFragment", 1, "setRecentlyUserSorter users is null or empty!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(boolean z16) {
        String str;
        if (!Nh()) {
            return;
        }
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        String str2 = this.F;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        iMiniAppService.reportByQQ(str2, "lp_result", "close", "", str2, str, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        ((IMiniGameScreenRecordApi) QRoute.api(IMiniGameScreenRecordApi.class)).saveRecordVideo(this.H, this.G, this.F, getIntent().getStringExtra("videoPath"), getBaseActivity());
        this.T = true;
    }

    private void Uh() {
        if (Nh()) {
            this.D.setBackgroundColor(Color.parseColor("#00000000"));
        } else {
            this.D.setBackgroundColor(Color.parseColor("#80000000"));
        }
    }

    private void Vh(List<ShareActionSheetBuilder.ActionSheetItem> list) {
        if (list != null && !list.isEmpty()) {
            ShareActionSheet shareActionSheet = this.W;
            if (shareActionSheet == null) {
                QLog.i("MiniMsgTabFragment", 1, "setShareSheetReportListener shareActionSheet is null!");
                return;
            }
            shareActionSheet.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.activity.miniaio.i
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    MiniMsgTabFragment.this.Qh(dialogInterface);
                }
            });
            this.W.setRecentlyUserSorter(new ShareActionSheet.a() { // from class: com.tencent.mobileqq.activity.miniaio.j
                @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.a
                public final void a(List list2) {
                    MiniMsgTabFragment.this.Rh(list2);
                }
            });
            ArrayList arrayList = new ArrayList();
            Iterator<ShareActionSheetBuilder.ActionSheetItem> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().action));
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportShareSheetChannelExpo(this.F, arrayList);
            return;
        }
        QLog.i("MiniMsgTabFragment", 1, "setShareSheetReportListener paths is null or empty!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getIntent() {
        if (getBaseActivity() != null) {
            return getBaseActivity().getIntent();
        }
        QLog.e("MiniMsgTabFragment", 1, "Fragment.getActivity() is null when calling getIntent()");
        return new Intent();
    }

    private boolean isClickable() {
        if (System.currentTimeMillis() - this.V > 1000) {
            this.V = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wh() {
        QQAppInterface qQAppInterface;
        int b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(MiniChatConstants.KEY_MINI_MSGTAB_BACK_PENDING_INTENT);
        if (intent != null) {
            intent.setComponent(SplashActivity.getAliasComponent(getBaseActivity()));
            h.v().z();
        } else {
            intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(getBaseActivity()));
            intent.setFlags(335544320);
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        startActivity(intent);
        if (qQAppInterface == null) {
            b16 = 0;
        } else {
            b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
        }
        Intent intent2 = getIntent();
        intent2.putExtra(MiniChatConstants.PARAM_PROC_BADGE_COUNT, b16);
        getBaseActivity().setResult(-1, intent2);
        getBaseActivity().finish();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onAccountChanged();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        QLog.i("MiniMsgTabFragment", 2, "[onActivityResult], resultCode:" + i16);
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            this.D.setVisibility(0);
            return;
        }
        if (8213 == i3) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(getContext(), this.F, "", "", 1131, null);
        } else if (1001 == i3 && getIntent().getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_CLOSE_WHEN_CHAT_CLOSE, false)) {
            Jh(-1, null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.J) {
            Hh(-1);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            if (view.getId() == R.id.f164059ir) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            Hh(i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.I = getIntent().getIntExtra(MiniChatConstants.KEY_MINI_MSGTAB_TYPE, 0);
        this.J = getIntent().getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_ACTION_SHEET, false);
        this.R = getIntent().getIntExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, 0);
        this.K = getIntent().getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_HEADER, true);
        this.L = getIntent().getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_SHIELD_GO_MSGTAB_BTN, false);
        com.tencent.mobileqq.activity.miniaio.c.d(getBaseActivity().app, this.R, false);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            if (getBaseActivity().app != null) {
                this.P = getBaseActivity().getResources().getDisplayMetrics().heightPixels;
                this.Q = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
                Intent intent = getIntent();
                boolean z16 = false;
                inflate = layoutInflater.inflate(R.layout.f168291sg, viewGroup, false);
                if (inflate == null) {
                    getBaseActivity().finish();
                } else {
                    this.C = getBaseActivity().app;
                    View findViewById = inflate.findViewById(R.id.f164059ir);
                    this.D = findViewById;
                    findViewById.setOnClickListener(this);
                    Uh();
                    Mh();
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniMsgTabFragment", 2, "mini msg tab oncreateView.mFilterMsgType " + this.I);
                    }
                    if (this.J) {
                        ShareActionSheet shareActionSheet = this.W;
                        if (shareActionSheet != null) {
                            shareActionSheet.show();
                        }
                        int dip2px = ((this.P - this.Q) - (this.Y * DisplayUtil.dip2px(getBaseActivity(), 120.0f))) - DisplayUtil.dip2px(getBaseActivity(), 36.0f);
                        ((FrameLayout) this.D.findViewById(R.id.zg5)).getLayoutParams().height = dip2px;
                        if (QLog.isColorLevel()) {
                            QLog.d("MiniMsgTabFragment", 2, "onCreateView: height = " + dip2px + ", line = " + this.W + ", ratio = " + ((dip2px * 1.0f) / DisplayUtil.getScreenHeight(getBaseActivity())));
                        }
                    } else {
                        ShareActionSheet shareActionSheet2 = this.W;
                        if (shareActionSheet2 != null) {
                            shareActionSheet2.dismissImmediately();
                        }
                    }
                    this.E = h.v().u();
                    if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_CHAT_NEWS_LIST, true)) {
                        if (!this.J && this.K) {
                            z16 = true;
                        }
                        MiniMsgTabFragmentExtKt.c(this, z16, this.L);
                    } else {
                        QLog.i("MiniMsgTabFragment", 1, "do not showMsgList");
                    }
                }
            }
            inflate = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        ShareActionSheet shareActionSheet = this.W;
        if (shareActionSheet != null) {
            shareActionSheet.dismissImmediately();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onResume();
            com.tencent.mobileqq.activity.miniaio.c.c(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            Jh(-1, null);
            super.onStop();
        }
    }
}
