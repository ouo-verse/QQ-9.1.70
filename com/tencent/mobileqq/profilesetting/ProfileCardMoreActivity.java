package com.tencent.mobileqq.profilesetting;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.cy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.ProfileCardShareHelper;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ag;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.GuidanceSource;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfo;
import com.tencent.mobileqq.zplan.minihome.ao;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qidian.QidianManager;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.helper.api.IAIOGetHandlerClzApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.RelationDialogUtil;
import com.tencent.state.report.SquareReportConst;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListRsp;

/* loaded from: classes16.dex */
public class ProfileCardMoreActivity extends IphoneTitleBarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, FriendProfilePhotoHelper.b, SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    boolean A0;
    int B0;
    boolean C0;
    String D0;
    String E0;
    boolean F0;
    BusinessCardManager G0;
    String H0;
    Intent I0;
    String J0;
    Boolean K0;
    FormSimpleItem L0;
    FormSimpleItem M0;
    FormSwitchSimpleItem N0;
    FormSwitchSimpleItem O0;
    FormSimpleItem P0;
    FormSimpleItem Q0;
    TextView R0;
    View S0;
    public FriendProfilePhotoHelper T0;
    public AllInOne U0;
    com.tencent.mobileqq.relationx.friendclue.c V0;
    Bundle W0;
    private ProfileCardShareHelper X0;
    private Boolean Y0;
    private QQCustomDialog Z0;

    /* renamed from: a0, reason: collision with root package name */
    String f260973a0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f260974a1;

    /* renamed from: b0, reason: collision with root package name */
    AllInOne f260975b0;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f260976b1;

    /* renamed from: c0, reason: collision with root package name */
    BusinessCard f260977c0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f260978c1;

    /* renamed from: d0, reason: collision with root package name */
    FormItemRelativeLayout f260979d0;

    /* renamed from: d1, reason: collision with root package name */
    private WeakReference<Activity> f260980d1;

    /* renamed from: e0, reason: collision with root package name */
    TextView f260981e0;

    /* renamed from: e1, reason: collision with root package name */
    public QQProgressDialog f260982e1;

    /* renamed from: f0, reason: collision with root package name */
    FormSimpleItem f260983f0;

    /* renamed from: f1, reason: collision with root package name */
    bs f260984f1;

    /* renamed from: g0, reason: collision with root package name */
    FormSimpleItem f260985g0;

    /* renamed from: g1, reason: collision with root package name */
    cy f260986g1;

    /* renamed from: h0, reason: collision with root package name */
    FormSimpleItem f260987h0;

    /* renamed from: h1, reason: collision with root package name */
    ar f260988h1;

    /* renamed from: i0, reason: collision with root package name */
    FormSimpleItem f260989i0;

    /* renamed from: i1, reason: collision with root package name */
    com.tencent.mobileqq.businessCard.a f260990i1;

    /* renamed from: j0, reason: collision with root package name */
    FormSimpleItem f260991j0;

    /* renamed from: j1, reason: collision with root package name */
    CardObserver f260992j1;

    /* renamed from: k0, reason: collision with root package name */
    FormSimpleItem f260993k0;

    /* renamed from: k1, reason: collision with root package name */
    private ProfileCardObserver f260994k1;

    /* renamed from: l0, reason: collision with root package name */
    FormSimpleItem f260995l0;

    /* renamed from: l1, reason: collision with root package name */
    com.tencent.mobileqq.friends.intimate.d f260996l1;

    /* renamed from: m0, reason: collision with root package name */
    FormSimpleItem f260997m0;

    /* renamed from: m1, reason: collision with root package name */
    MqqHandler f260998m1;

    /* renamed from: n0, reason: collision with root package name */
    FormSwitchItem f260999n0;

    /* renamed from: o0, reason: collision with root package name */
    FormSwitchItem f261000o0;

    /* renamed from: p0, reason: collision with root package name */
    FormSwitchItem f261001p0;

    /* renamed from: q0, reason: collision with root package name */
    FormSwitchItem f261002q0;

    /* renamed from: r0, reason: collision with root package name */
    FormSwitchItem f261003r0;

    /* renamed from: s0, reason: collision with root package name */
    QUISingleLineListItem f261004s0;

    /* renamed from: t0, reason: collision with root package name */
    TextView f261005t0;

    /* renamed from: u0, reason: collision with root package name */
    TextView f261006u0;

    /* renamed from: v0, reason: collision with root package name */
    int[] f261007v0;

    /* renamed from: w0, reason: collision with root package name */
    String f261008w0;

    /* renamed from: x0, reason: collision with root package name */
    String f261009x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f261010y0;

    /* renamed from: z0, reason: collision with root package name */
    boolean f261011z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements RelationBlacklistListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f261032a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f261033b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f261034c;

        a(boolean z16, String str, Activity activity) {
            this.f261032a = z16;
            this.f261033b = str;
            this.f261034c = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16), str, activity);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
        public void onResult(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (!z16) {
                ProfileCardMoreActivity.this.h4(this.f261032a);
                return;
            }
            RelationBlacklist$BlockRsp relationBlacklist$BlockRsp = (RelationBlacklist$BlockRsp) obj;
            if (relationBlacklist$BlockRsp.code.get() == 0) {
                ProfileCardMoreActivity.this.H4(true);
                ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(this.f261033b, true);
                ((IProfileCardBlacklistService) ProfileCardMoreActivity.this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).deleteBlacklistUinMessage(this.f261033b);
            } else {
                if (relationBlacklist$BlockRsp.code.get() == 10001) {
                    ProfileCardMoreActivity.this.B4(this.f261034c, relationBlacklist$BlockRsp.f436002msg.get(), this.f261032a);
                    return;
                }
                ProfileCardMoreActivity.this.h4(this.f261032a);
                String str = relationBlacklist$BlockRsp.f436002msg.get();
                if (!TextUtils.isEmpty(str)) {
                    QQToastUtil.showQQToastInUiThread(1, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f261036d;

        b(boolean z16) {
            this.f261036d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ProfileCardMoreActivity.this.h4(this.f261036d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements RelationBlacklistListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261038a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f261039b;

        c(String str, boolean z16) {
            this.f261038a = str;
            this.f261039b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, str, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
        public void onResult(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16) {
                ProfileCardMoreActivity.this.H4(false);
                ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(this.f261038a, false);
            } else {
                ProfileCardMoreActivity.this.h4(this.f261039b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            boolean z16 = false;
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                int o16 = eVar.b().get(0).o();
                ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                if ((o16 & 1) > 0) {
                    z16 = true;
                }
                profileCardMoreActivity.f261010y0 = z16;
            } else {
                ProfileCardMoreActivity.this.f261010y0 = false;
            }
            ProfileCardMoreActivity.this.Q4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class e implements CheckBlacklistListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16) {
            ProfileCardMoreActivity.this.G4(z16);
        }

        @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
        public void onResult(final boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileCardMoreActivity.e.this.b(z16);
                    }
                });
            }
        }
    }

    /* loaded from: classes16.dex */
    class f extends bs {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onInsertIntoBlackList(boolean z16, String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (str != null && (str2 = ProfileCardMoreActivity.this.f260975b0.uin) != null && str2.equals(str)) {
                ProfileCardMoreActivity.this.v4(z16, false);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onRemoveFromBlackList(boolean z16, String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            } else if (str != null && (str2 = ProfileCardMoreActivity.this.f260975b0.uin) != null && str2.equals(str)) {
                ProfileCardMoreActivity.this.v4(z16, true);
            }
        }
    }

    /* loaded from: classes16.dex */
    class g extends cy {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void a(boolean z16, List<Long> list) {
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            AllInOne allInOne = ProfileCardMoreActivity.this.f260975b0;
            if (allInOne == null) {
                return;
            }
            String str = allInOne.uin;
            if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                str = ProfileCardMoreActivity.this.getContactStrangerUin();
            }
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            boolean z17 = false;
            for (int i3 = 0; !z17 && i3 < size; i3++) {
                if (Utils.p(String.valueOf(list.get(i3)), str)) {
                    z17 = true;
                }
            }
            if (z17) {
                ProfileCardMoreActivity.this.v4(z16, false);
            }
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void c(boolean z16, List<Long> list) {
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), list);
                return;
            }
            AllInOne allInOne = ProfileCardMoreActivity.this.f260975b0;
            if (allInOne == null) {
                return;
            }
            String str = allInOne.uin;
            if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                str = ProfileCardMoreActivity.this.getContactStrangerUin();
            }
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            for (int i3 = 0; !z17 && i3 < size; i3++) {
                if (Utils.p(String.valueOf(list.get(i3)), str)) {
                    z17 = true;
                }
            }
            if (z17) {
                ProfileCardMoreActivity.this.v4(z16, true);
            }
        }
    }

    /* loaded from: classes16.dex */
    class h extends com.tencent.mobileqq.businessCard.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void a(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else {
                super.a(z16, str, i3);
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void b(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
            } else {
                super.b(z16, str);
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void c(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            super.c(z16, str, i3);
            if (z16) {
                BusinessCard i16 = ((BusinessCardManager) ProfileCardMoreActivity.this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).i(str);
                QLog.i("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo success : cardId = " + str);
                ProfileCardMoreActivity.this.O4(i16);
                ProfileCardMoreActivity.this.f260977c0 = i16;
                return;
            }
            QLog.e("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo faild : cardId = " + str);
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void e(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                super.e(z16, str);
            }
        }
    }

    /* loaded from: classes16.dex */
    class i extends CardObserver {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetBabyQSwitch(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17 != ProfileCardMoreActivity.this.f261003r0.isChecked()) {
                ProfileCardMoreActivity.this.f261003r0.setOnCheckedChangeListener(null);
                ProfileCardMoreActivity.this.f261003r0.setChecked(z17);
                ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                profileCardMoreActivity.f261003r0.setOnCheckedChangeListener(profileCardMoreActivity);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onImpeach(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (!ProfileCardMoreActivity.this.f260975b0.uin.equals(str)) {
                return;
            }
            ProfileCardMoreActivity.this.l3();
            if (z16) {
                ProfileCardMoreActivity.this.notifyUser(R.string.f170692yq, 2);
            } else {
                ProfileCardMoreActivity.this.notifyUser(R.string.f170690yo, 1);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetBabyQSwitch(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17 != ProfileCardMoreActivity.this.f261003r0.isChecked()) {
                ProfileCardMoreActivity.this.f261003r0.setOnCheckedChangeListener(null);
                ProfileCardMoreActivity.this.f261003r0.setChecked(z17);
                ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                profileCardMoreActivity.f261003r0.setOnCheckedChangeListener(profileCardMoreActivity);
            }
        }
    }

    /* loaded from: classes16.dex */
    class j extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onSetProfileDetail(boolean z16, int i3, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), card);
                return;
            }
            if (!z16 || i3 != 0) {
                if (z16 || i3 != 34) {
                    ProfileCardMoreActivity.this.notifyUser(R.string.f171201d33, 1);
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class k extends com.tencent.mobileqq.friends.intimate.d {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onBandIntimateRelationship(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
            }
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(ProfileCardMoreActivity.this.f260975b0.uin)) {
                if (z16) {
                    ProfileCardMoreActivity.this.L4();
                    return;
                }
                return;
            }
            QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", str));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onDisbandIntimateRelationship(boolean z16, String str, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, "ProfileCard onDisbandIntimateRelationship");
            }
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(ProfileCardMoreActivity.this.f260975b0.uin)) {
                if (z16) {
                    ProfileCardMoreActivity.this.L4();
                    return;
                }
                return;
            }
            QLog.d("intimate_relationship", 1, String.format("ProfileCard onDisbandIntimateRelationship, friendUin: %s", str));
        }
    }

    /* loaded from: classes16.dex */
    class l extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QLog.d("ProfileCardMoreActivity", 1, "User requestPermissions grant...");
            ProfileCardMoreActivity.this.S4();
        }
    }

    /* loaded from: classes16.dex */
    class m implements ProfileCardShareHelper.d {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.ProfileCardShareHelper.d
        public void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 == 2) {
                if (ProfilePAUtils.isPaTypeFriend(ProfileCardMoreActivity.this.f260975b0)) {
                    i16 = 1;
                }
                ReportController.o(ProfileCardMoreActivity.this.app, "CliOper", "", "", "0X80050E7", "0X80050E7", i16, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800A4FD", "0X800A4FD", 0, 0, "", "0", "0", "");
                return;
            }
            if (i3 == 9) {
                ReportController.o(null, "dc00898", "", "", "0X800A4FE", "0X800A4FE", 0, 0, "", "0", "0", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class n implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = eVar.b().get(0);
                if (!Utils.p(ProfileCardMoreActivity.this.f261009x0, bVar.f())) {
                    ProfileCardMoreActivity.this.f261009x0 = bVar.f();
                    ProfileCardMoreActivity.this.J4();
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class o implements nk3.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f261052a;

        o(boolean z16) {
            this.f261052a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16));
            }
        }

        @Override // nk3.a
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (!z16) {
                ProfileCardMoreActivity.this.f4(this.f261052a);
            }
        }
    }

    /* loaded from: classes16.dex */
    class p extends MqqHandler {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what != 36) {
                QLog.d("ProfileCardMoreActivity", 2, "TEST more info message handler: " + message.what);
                return;
            }
            if (((String) message.obj).equals(ProfileCardMoreActivity.this.f260975b0.uin)) {
                boolean z17 = false;
                if (message.arg1 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 != ProfileCardMoreActivity.this.f260999n0.isChecked()) {
                    ProfileCardMoreActivity.this.f260999n0.setOnCheckedChangeListener(null);
                    FormSwitchItem formSwitchItem = ProfileCardMoreActivity.this.f260999n0;
                    if (message.arg1 == 1) {
                        z17 = true;
                    }
                    formSwitchItem.setChecked(z17);
                    ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                    profileCardMoreActivity.f260999n0.setOnCheckedChangeListener(profileCardMoreActivity);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class q implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
            FormSwitchItem formSwitchItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = eVar.b().get(0);
                if (cVar.n().byteValue() == 1 && (formSwitchItem = ProfileCardMoreActivity.this.f261002q0) != null) {
                    formSwitchItem.setOnCheckedChangeListener(null);
                    ProfileCardMoreActivity.this.f261002q0.setChecked(true);
                    ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                    profileCardMoreActivity.f261002q0.setOnCheckedChangeListener(profileCardMoreActivity);
                }
                FormSwitchItem formSwitchItem2 = ProfileCardMoreActivity.this.f261000o0;
                if (formSwitchItem2 != null && formSwitchItem2.getVisibility() == 0) {
                    if ((cVar.o() & 1) > 0) {
                        ProfileCardMoreActivity.this.f261010y0 = true;
                    } else {
                        ProfileCardMoreActivity.this.f261010y0 = false;
                    }
                    ProfileCardMoreActivity.this.Q4();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class r implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IVipColorName) QRoute.api(IVipColorName.class)).openChangeColorNamePage(view.getContext());
                ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "data_card_set", "cover_display", "", "nickname_color", "4", 102, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ProfileCardMoreActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.B0 = 0;
        this.F0 = false;
        this.H0 = "";
        this.J0 = "";
        this.K0 = null;
        this.Y0 = Boolean.FALSE;
        this.f260974a1 = true;
        this.f260976b1 = false;
        this.f260978c1 = false;
        this.f260980d1 = null;
        this.f260984f1 = new f();
        this.f260986g1 = new g();
        this.f260988h1 = new ar() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.21
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity$21$a */
            /* loaded from: classes16.dex */
            class a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass21.this);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                        return;
                    }
                    if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = eVar.b().get(0);
                        if (!Utils.p(ProfileCardMoreActivity.this.f261009x0, bVar.f())) {
                            ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                            if (profileCardMoreActivity.f260983f0 != null) {
                                profileCardMoreActivity.f261009x0 = bVar.f();
                                ProfileCardMoreActivity.this.J4();
                            }
                        }
                    }
                }
            }

            /* renamed from: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity$21$b */
            /* loaded from: classes16.dex */
            class b implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass21.this);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                        return;
                    }
                    if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = eVar.b().get(0);
                        ProfileCardMoreActivity.this.f261009x0 = bVar.f();
                        ProfileCardMoreActivity.this.J4();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onSetAsNormalContacts(boolean z16, List<String> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Boolean.valueOf(z16), list);
                    return;
                }
                if (!z16) {
                    ProfileCardMoreActivity.this.notifyUser(R.string.hfp, 1);
                    ProfileCardMoreActivity.this.f261002q0.setOnCheckedChangeListener(null);
                    ProfileCardMoreActivity.this.f261002q0.setChecked(true);
                    ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                    profileCardMoreActivity.f261002q0.setOnCheckedChangeListener(profileCardMoreActivity);
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onSetAsUncommonlyUsedContacts(boolean z16, List<String> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, this, Boolean.valueOf(z16), list);
                    return;
                }
                if (!z16) {
                    ProfileCardMoreActivity.this.notifyUser(R.string.hfp, 1);
                    ProfileCardMoreActivity.this.f261002q0.setOnCheckedChangeListener(null);
                    ProfileCardMoreActivity.this.f261002q0.setChecked(false);
                    ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                    profileCardMoreActivity.f261002q0.setOnCheckedChangeListener(profileCardMoreActivity);
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onSetComment(boolean z16, String str, String str2, byte b16) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i16 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
                    return;
                }
                if (ProfileCardMoreActivity.this.f260975b0.uin.equals(str) && ProfilePAUtils.isPaTypeFriend(ProfileCardMoreActivity.this.f260975b0)) {
                    if (z16) {
                        ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                        profileCardMoreActivity.D0 = str2;
                        profileCardMoreActivity.setNewRemark(str2);
                    } else {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(ProfileCardMoreActivity.this.f260975b0.uin), "ProfileCardMoreActivity");
                        if (friendsSimpleInfoWithUid != null) {
                            if (friendsSimpleInfoWithUid.r() != null) {
                                ProfileCardMoreActivity.this.D0 = friendsSimpleInfoWithUid.r();
                            }
                            ProfileCardMoreActivity profileCardMoreActivity2 = ProfileCardMoreActivity.this;
                            profileCardMoreActivity2.setNewRemark(profileCardMoreActivity2.D0);
                        }
                    }
                    ProfileCardMoreActivity profileCardMoreActivity3 = ProfileCardMoreActivity.this;
                    if ((profileCardMoreActivity3.B0 & 1) == 1) {
                        if (z16) {
                            i3 = R.string.bwa;
                        } else {
                            i3 = R.string.bw_;
                        }
                        if (!z16) {
                            i16 = 1;
                        }
                        profileCardMoreActivity3.notifyUser(i3, i16);
                    }
                    ProfileCardMoreActivity.this.B0 &= -2;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.ar
            public void onUpdateDelFriend(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (z16 && ProfileCardMoreActivity.this.f260975b0.uin.equals(String.valueOf(obj))) {
                    synchronized (ProfileCardMoreActivity.this) {
                        if (!ProfileCardMoreActivity.this.f260978c1) {
                            ProfileCardMoreActivity.this.f260978c1 = true;
                        } else {
                            QLog.i("qqBaseActivity", 1, "ProfileCardMoreActivity onUpdateDelFriend has toast!");
                        }
                    }
                    ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                    if (profileCardMoreActivity.I0 == null) {
                        profileCardMoreActivity.I0 = new Intent();
                    }
                    ProfileCardMoreActivity.this.I0.putExtra("finchat", true);
                    ProfileCardMoreActivity profileCardMoreActivity2 = ProfileCardMoreActivity.this;
                    profileCardMoreActivity2.setResult(-1, profileCardMoreActivity2.I0);
                    ProfileCardMoreActivity.this.finish();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.ar
            public void onUpdateFriendList(boolean z16, boolean z17) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    return;
                }
                if (z16 && z17) {
                    AllInOne allInOne = ProfileCardMoreActivity.this.f260975b0;
                    if (allInOne.uin != null && ProfilePAUtils.isPaTypeFriend(allInOne) && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(ProfileCardMoreActivity.this.f260975b0.uin), "ProfileCardMoreActivity")) != null) {
                        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(friendsSimpleInfoWithUid.f(), "ProfileCardMoreActivity", new a());
                        if (friendsSimpleInfoWithUid.r() != null) {
                            ProfileCardMoreActivity.this.D0 = friendsSimpleInfoWithUid.r();
                        }
                        ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                        profileCardMoreActivity.setNewRemark(profileCardMoreActivity.D0);
                    }
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateFriendShieldFlag(long j3, boolean z16, boolean z17, boolean z18, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str);
                    return;
                }
                if (!String.valueOf(j3).equals(ProfileCardMoreActivity.this.f260975b0.uin)) {
                    return;
                }
                boolean z19 = !z16;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ProfileCardMoreActivity.this.v4(z17, z19);
                    return;
                }
                FormSwitchItem formSwitchItem = ProfileCardMoreActivity.this.f261000o0;
                if (formSwitchItem != null) {
                    formSwitchItem.post(new Runnable(z17, z19) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.21.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f261013d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ boolean f261014e;

                        {
                            this.f261013d = z17;
                            this.f261014e = z19;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass21.this, Boolean.valueOf(z17), Boolean.valueOf(z19));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ProfileCardMoreActivity.this.v4(this.f261013d, this.f261014e);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateMoveGroup(String str, byte b16, byte b17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
                    return;
                }
                AllInOne allInOne = ProfileCardMoreActivity.this.f260975b0;
                if (allInOne != null && !TextUtils.isEmpty(allInOne.uin) && Utils.p(ProfileCardMoreActivity.this.f260975b0.uin, str)) {
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(b16, "ProfileCardMoreActivity", new b());
                }
            }
        };
        this.f260990i1 = new h();
        this.f260992j1 = new i();
        this.f260994k1 = new j();
        this.f260996l1 = new k();
        this.f260998m1 = new p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B4(Activity activity, String str, boolean z16) {
        RelationDialogUtil.c(activity, 230, HardCodeUtil.qqStr(R.string.f159971tr), str, HardCodeUtil.qqStr(R.string.f159961tq), "", null, new b(z16));
        ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", ProfileCardBlacklistReportConst.PAGE_ID_PG_BLACKLIST_LIMIT_POP, null, new HashMap<String, String>() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                } else {
                    put("to_uin", ProfileCardMoreActivity.this.f260975b0.uin);
                }
            }
        }, null);
    }

    private void D3() {
        UnitedProxy a16 = com.tencent.mobileqq.vas.ar.a("linkliang", "2024-03-07", "vas_colorfulnick_profile");
        View findViewById = findViewById(R.id.zlv);
        if (this.app.getCurrentUin().equals(this.f260975b0.uin) && a16.isEnable(true)) {
            ((TextView) findViewById(R.id.zlw)).setText(a16.getJson().optString("cover_display1", getString(R.string.f160671vn)));
            FormSimpleItem formSimpleItem = (FormSimpleItem) findViewById(R.id.xwd);
            formSimpleItem.setLeftText(a16.getJson().optString("cover_display2", getString(R.string.f160661vm)));
            formSimpleItem.setOnClickListener(new r());
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "data_card_set", "cover_display", "", "nickname_color", "4", 101, 0);
            findViewById.setVisibility(0);
            return;
        }
        findViewById.setVisibility(8);
    }

    private void D4(final String str) {
        if (this.Z0 == null) {
            this.Z0 = DialogUtil.createCustomDialog(this, 0, getString(R.string.f175412yh), "", R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.s
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ProfileCardMoreActivity.this.S3(str, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ProfileCardMoreActivity.this.T3(dialogInterface, i3);
                }
            });
        }
        QQCustomDialog qQCustomDialog = this.Z0;
        if (qQCustomDialog != null || !qQCustomDialog.isShowing()) {
            this.Z0.show();
            ReportController.o(this.app, "dc00898", "", "", "0X800C00A", "0X800C00A", 0, 0, "", "", "", "");
        }
    }

    private void E3() {
        Card r16;
        String str;
        FormSimpleItem formSimpleItem;
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            r16 = null;
        } else {
            r16 = friendsManager.r(this.f260975b0.uin);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("card: ");
        if (r16 == null) {
            str = "null";
        } else {
            str = r16.isForbidAccount + "," + r16.hashCode();
        }
        sb5.append(str);
        QLog.d("ProfileCardMoreActivity", 2, sb5.toString());
        if (r16 != null && r16.isForbidAccount && (formSimpleItem = this.f260987h0) != null) {
            formSimpleItem.setVisibility(8);
        }
    }

    private void E4(String str) {
        int i3;
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            ((FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend("ProfileCardMoreActivity", str, (byte) 2, !this.f260974a1 ? 1 : 0);
            b4(ChatActivity.class, str);
            b4(ChatSettingFragment.class, str);
            b4(((IAIOGetHandlerClzApi) QRoute.api(IAIOGetHandlerClzApi.class)).getC2CDelFriendHelperClz(), str);
            if (this.I0 == null) {
                this.I0 = new Intent();
            }
            this.I0.putExtra("finchat", true);
            setResult(-1, this.I0);
            QQAppInterface qQAppInterface = this.app;
            if (this.f260974a1) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C00B", "0X800C00B", i3, 0, "", "", "", "");
            finish();
        } else {
            notifyUser(R.string.ajl, 1);
        }
        this.Z0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H4(boolean z16) {
        if (z16) {
            t4(this.f260993k0, 8);
            t4(this.f260999n0, 8);
            t4(this.f260995l0, 8);
            t4(this.f260997m0, 8);
            FormSwitchItem formSwitchItem = this.f261001p0;
            if (formSwitchItem != null && formSwitchItem.getVisibility() == 0) {
                this.f261001p0.setBgType(0);
            }
            N4(1);
            return;
        }
        if (ProfilePAUtils.isPaTypeFriend(this.f260975b0) && !Utils.G(this.f260975b0.uin)) {
            t4(this.f260993k0, 0);
            t4(this.f260999n0, 0);
            t4(this.f260995l0, 0);
            t4(this.f260997m0, 0);
            FormSwitchItem formSwitchItem2 = this.f261001p0;
            if (formSwitchItem2 != null && formSwitchItem2.getVisibility() == 0) {
                this.f261001p0.setBgType(3);
            }
            N4(2);
        }
    }

    private boolean I3() {
        FormSimpleItem formSimpleItem;
        FormSwitchSimpleItem formSwitchSimpleItem = this.N0;
        if ((formSwitchSimpleItem != null && formSwitchSimpleItem.isChecked()) || (formSimpleItem = this.L0) == null || formSimpleItem.getVisibility() != 0 || !uq3.c.c7() || !QMMKV.from(getActivity(), QMMKVFile.FILE_QCIRCLE).decodeBool("qcircle_cover_red_dot_show", true)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J3(DialogInterface dialogInterface, int i3) {
        j3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J4() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.22
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                FormSimpleItem formSimpleItem = profileCardMoreActivity.f260983f0;
                if (formSimpleItem != null) {
                    if (TextUtils.isEmpty(profileCardMoreActivity.f261009x0)) {
                        str = "";
                    } else {
                        str = ProfileCardMoreActivity.this.f261009x0;
                    }
                    formSimpleItem.setRightText(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K3(DialogInterface dialogInterface, int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this.f260974a1 = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L3(String str, DialogInterface dialogInterface, int i3) {
        E4(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L4() {
        int i3;
        String str;
        boolean z16;
        Drawable mutate;
        if (this.f260995l0.getVisibility() == 0) {
            com.tencent.mobileqq.mutualmark.info.c e16 = com.tencent.mobileqq.mutualmark.c.e(this.app, this.f260975b0.uin, true);
            if (e16 != null) {
                str = com.tencent.mobileqq.activity.aio.intimate.e.b(this, e16.f252085a);
                i3 = e16.f252101q;
                z16 = e16.d();
            } else {
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin), "ProfileCardMoreActivity");
                i3 = 0;
                if (intimateSimpleInfoWithUid != null && intimateSimpleInfoWithUid.j() != 0) {
                    str = com.tencent.mobileqq.activity.aio.intimate.e.b(this, intimateSimpleInfoWithUid.j());
                    z16 = Boolean.TRUE.equals(intimateSimpleInfoWithUid.o());
                } else {
                    str = "";
                    z16 = false;
                }
            }
            this.f260995l0.setRightText(str);
            if (i3 != 0) {
                Drawable drawable = getResources().getDrawable(i3);
                if (drawable instanceof SkinnableBitmapDrawable) {
                    mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
                } else {
                    mutate = drawable.mutate();
                }
                if (z16) {
                    mutate.setAlpha(102);
                } else {
                    mutate.setAlpha(255);
                }
                this.f260995l0.setRightIcon(mutate);
                return;
            }
            this.f260995l0.setRightIcon(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M3(boolean z16) {
        if (!z16) {
            notifyUser(R.string.cpo, 1);
        }
    }

    private void M4(final boolean z16) {
        WeakReference weakReference = new WeakReference(new IMiniHomeHelper.b() { // from class: com.tencent.mobileqq.profilesetting.n
            @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.b
            public final void onResult(boolean z17, MiniHomeInfo miniHomeInfo) {
                ProfileCardMoreActivity.this.W3(z16, z17, miniHomeInfo);
            }
        });
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).miniHomeQQMCSwitchOn()) {
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).requestMiniHomeInfoFromNet(this.app.getCurrentUin(), weakReference);
        }
    }

    private void N4(int i3) {
        FormSimpleItem formSimpleItem = this.f260995l0;
        if (formSimpleItem != null && formSimpleItem.getVisibility() == 0) {
            this.f260995l0.setBgType(i3);
            return;
        }
        FormSimpleItem formSimpleItem2 = this.f260997m0;
        if (formSimpleItem2 != null && formSimpleItem2.getVisibility() == 0) {
            this.f260997m0.setBgType(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P3(DialogInterface dialogInterface, int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this.f260976b1 = z16;
    }

    private void P4() {
        String str;
        final String p36 = p3();
        if (TextUtils.isEmpty(p36)) {
            str = "\u672a\u8bbe\u7f6e";
        } else {
            str = p36;
        }
        this.f261004s0.setConfig(new x<>(new x.b.d("\u5907\u6ce8"), new x.c.g(str, true, false)));
        this.f261004s0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileCardMoreActivity.this.X3(p36, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q3(Activity activity, String str, boolean z16, boolean z17, DialogInterface dialogInterface, int i3) {
        String str2;
        m4(activity, str, z16);
        String str3 = "2";
        if (z17) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        if (!this.f260976b1) {
            str3 = "1";
        }
        i4(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R3(boolean z16, boolean z17, DialogInterface dialogInterface, int i3) {
        String str;
        h4(z16);
        if (z17) {
            str = "2";
        } else {
            str = "1";
        }
        i4(str, "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S3(String str, DialogInterface dialogInterface, int i3) {
        E4(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T3(DialogInterface dialogInterface, int i3) {
        j3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U3(boolean z16) {
        if (!z16) {
            notifyUser(R.string.cpo, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V3(Activity activity, boolean z16) {
        if (z16) {
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).startCreateMiniHomePageForResult(activity, this.app.getCurrentUin(), 1040, CreateMiniHomeSource.PROFILE_SETTING);
        } else {
            this.O0.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W3(boolean z16, boolean z17, MiniHomeInfo miniHomeInfo) {
        final Activity activity;
        WeakReference<Activity> weakReference = this.f260980d1;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (!z17) {
            QLog.e("ProfileCardMoreActivity", 1, "updateMiniHomeSettings minihome \u83b7\u53d6\u5c0f\u7a9d\u72b6\u6001\u5931\u8d25");
            QQToast.makeText(activity, "\u8bbe\u7f6e\u5931\u8d25(1)\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1, 0).show();
            this.O0.setChecked(false);
            return;
        }
        if (miniHomeInfo == null) {
            QLog.e("ProfileCardMoreActivity", 1, "updateMiniHomeSettings minihome info\u4e3a\u7a7a");
            QQToast.makeText(activity, "\u8bbe\u7f6e\u5931\u8d25(2)\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1, 0).show();
            this.O0.setChecked(false);
            return;
        }
        if (miniHomeInfo.getHasCreatedMiniHome()) {
            QLog.i("ProfileCardMoreActivity", 1, "updateMiniHomeSettings minihome \u5df2\u521b\u7a9d \u65e0\u9700\u5f15\u5bfc");
            this.P0.setVisibility(8);
            int visibility = this.Q0.getVisibility();
            if (z16 && ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableMiniHomeEdit()) {
                this.Q0.setVisibility(0);
                this.Q0.setOnClickListener(this);
                this.O0.setBgType(2);
            }
            if (visibility != 0) {
                l4(this.Q0, "em_zplan_mini_xiaowo_decorate", null);
            }
            QLog.i("ProfileCardMoreActivity", 1, "updateMiniHomeSettings minihome requestSetZPlanMiniHomeSettingSwitch true");
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).requestSetZPlanMiniHomeSettingSwitch(true, new nk3.a() { // from class: com.tencent.mobileqq.profilesetting.i
                @Override // nk3.a
                public final void onResult(boolean z18) {
                    ProfileCardMoreActivity.this.U3(z18);
                }
            });
            return;
        }
        QLog.i("ProfileCardMoreActivity", 1, "updateMiniHomeSettings minihome showGuidanceDialog");
        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).showGuidanceDialog(activity, null, GuidanceSource.SOURCE_SETTING, new IMiniHomeHelper.c() { // from class: com.tencent.mobileqq.profilesetting.j
            @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.c
            public final void onResult(boolean z18) {
                ProfileCardMoreActivity.this.V3(activity, z18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X3(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        e4(str);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void b4(Class cls, String str) {
        MqqHandler handler;
        if (this.app != null && !TextUtils.isEmpty(str) && (handler = this.app.getHandler(cls)) != null) {
            handler.removeMessages(16711681);
            handler.sendMessage(handler.obtainMessage(16711681, str));
        }
    }

    private void e4(String str) {
        Intent intent = new Intent();
        intent.putExtra("title", "\u8bbe\u7f6e\u5907\u6ce8");
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
        intent.putExtra("default_hint", this.f260975b0.nickname);
        intent.putExtra("uin", this.f260975b0.uin);
        intent.putExtra("uid", this.f260975b0.uid);
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 4);
        intent.putExtra("max_limit_mode", 1);
        intent.putExtra("edit_mode", 2);
        intent.putExtra("max_num", 96);
        intent.putExtra("from", ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).getSourceTypeFromeProfileType(this.U0.f260789pa));
        intent.putExtra("troopUin", this.U0.troopUin);
        RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 1034);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f4(boolean z16) {
        runOnUiThread(new Runnable(z16) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.33
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f261020d;

            {
                this.f261020d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ProfileCardMoreActivity.this.notifyUser(R.string.cpo, 1);
                FormSwitchSimpleItem formSwitchSimpleItem = ProfileCardMoreActivity.this.N0;
                if (formSwitchSimpleItem != null) {
                    formSwitchSimpleItem.setOnCheckedChangeListener(null);
                    ProfileCardMoreActivity.this.N0.setChecked(!this.f261020d);
                    ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                    profileCardMoreActivity.N0.setOnCheckedChangeListener(profileCardMoreActivity);
                }
            }
        });
    }

    private static com.tencent.mobileqq.structmsg.a h3(String str) {
        ag agVar = new ag();
        agVar.C(1);
        agVar.s(str);
        return agVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h4(boolean z16) {
        G4(!z16);
    }

    private void i3() {
        int i3;
        if (this.R0 == null) {
            return;
        }
        boolean l3 = com.tencent.mobileqq.widget.o.l();
        Resources resources = getResources();
        if (l3) {
            i3 = R.dimen.d6i;
        } else {
            i3 = R.dimen.aes;
        }
        this.R0.setPadding(resources.getDimensionPixelSize(i3), getResources().getDimensionPixelSize(R.dimen.d6j), getResources().getDimensionPixelSize(R.dimen.f159492al3), getResources().getDimensionPixelSize(R.dimen.d6h));
    }

    private void i4(String str, String str2) {
        ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_zplan_qqusercard_setting", ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_ACTIONSHEET, t3(), new HashMap<String, String>(str, str2) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$option;
            final /* synthetic */ String val$type;

            {
                this.val$type = str;
                this.val$option = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, str, str2);
                } else {
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_TYPE, str);
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_OPTION, str2);
                }
            }
        });
    }

    private void j3() {
        this.Z0.dismiss();
        ReportController.o(this.app, "dc00898", "", "", "0X800C00C", "0X800C00C", 0, 0, "", "", "", "");
    }

    private void k4(View view, HashMap<String, Object> hashMap) {
        if (view == null) {
            QLog.e("ProfileCardMoreActivity_ProfileCardMoreActivity", 1, "[reportClickForZPlan] view is null");
            return;
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    private void l4(View view, String str, HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, hashMap);
    }

    private void m4(Activity activity, String str, boolean z16) {
        o4(activity, str, z16);
        if (this.f260976b1) {
            QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.f227626rj));
            com.tencent.relation.common.utils.i.c().i(true);
            ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendShieldListTransferRequest(null);
        }
    }

    private void o4(Activity activity, String str, boolean z16) {
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendAddBlacklistRequest(str, new a(z16, str, activity));
    }

    private String p3() {
        String str = this.f260975b0.uid;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null) {
            QLog.e("ProfileCardMoreActivity", 1, "getBuddyRemark service is null");
            return "";
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        Map<String, String> buddyRemark = b16.getBuddyRemark(arrayList);
        if (buddyRemark == null) {
            return "";
        }
        String str2 = buddyRemark.get(str);
        QLog.i("ProfileCardMoreActivity", 2, "getBuddyRemark remark:" + str2);
        return str2;
    }

    private void p4(String str, boolean z16) {
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendDeleteBlacklistRequest(str, new c(str, z16));
    }

    private void r4() {
        boolean z16;
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.mContentView, "pg_zplan_qqusercard_setting");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        FormSimpleItem formSimpleItem = this.P0;
        if (formSimpleItem != null && formSimpleItem.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("em_zplan_xiaowo_displaybackground", str);
        VideoReport.setPageParams(this.mContentView, new PageParams(hashMap));
    }

    private int s3() {
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            return 13;
        }
        return 12;
    }

    private void s4() {
        boolean k3 = FriendsStatusUtil.k(this.f260975b0.uin, this.app);
        FormSwitchItem formSwitchItem = this.f260999n0;
        if (formSwitchItem != null) {
            formSwitchItem.setOnCheckedChangeListener(null);
            this.f260999n0.setChecked(k3);
            this.f260999n0.setOnCheckedChangeListener(this);
            if (AppSetting.f99565y) {
                this.f260999n0.setContentDescription(getString(R.string.f170650xg));
            }
        }
    }

    private HashMap<String, String> t3() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.f260975b0.uin.equals(this.app.getCurrentAccountUin())) {
            hashMap.put(ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, "1");
        } else {
            hashMap.put(ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, "2");
            hashMap.put("to_uin", this.f260975b0.uin);
        }
        return hashMap;
    }

    private void t4(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    private void u3(Activity activity, String str, boolean z16) {
        if (com.tencent.relation.common.utils.i.c().b()) {
            z4(activity, false, str, z16);
        } else {
            ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendGetShieldListNumberRequest(new RelationBlacklistListener(z16, activity, str) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.7
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ boolean f261021a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Activity f261022b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f261023c;

                {
                    this.f261021a = z16;
                    this.f261022b = activity;
                    this.f261023c = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16), activity, str);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
                public void onResult(boolean z17, Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), obj);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(z17, obj) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.7.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f261025d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ Object f261026e;

                            {
                                this.f261025d = z17;
                                this.f261026e = obj;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass7.this, Boolean.valueOf(z17), obj);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z18;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (!this.f261025d) {
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    ProfileCardMoreActivity.this.h4(anonymousClass7.f261021a);
                                    return;
                                }
                                RelationBlacklist$CountBlockListRsp relationBlacklist$CountBlockListRsp = (RelationBlacklist$CountBlockListRsp) this.f261026e;
                                AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                                ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                                Activity activity2 = anonymousClass72.f261022b;
                                if (relationBlacklist$CountBlockListRsp.count.get() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                AnonymousClass7 anonymousClass73 = AnonymousClass7.this;
                                profileCardMoreActivity.z4(activity2, z18, anonymousClass73.f261023c, anonymousClass73.f261021a);
                            }
                        });
                    }
                }
            });
        }
    }

    private void v3(int i3, Intent intent) {
        if (i3 == -1) {
            this.Y0 = Boolean.valueOf(intent.getBooleanExtra(IProfileCardConst.PARAM_SWITCHES_CHANGED, false));
            boolean booleanExtra = intent.getBooleanExtra("key_weishi_switch", false);
            boolean hasExtra = intent.hasExtra("key_personality_label_switch");
            if (this.W0 == null && (booleanExtra || hasExtra)) {
                this.W0 = new Bundle();
            }
            Bundle bundle = this.W0;
            if (bundle != null && booleanExtra) {
                bundle.putBoolean("key_weishi_switch", true);
            }
            Bundle bundle2 = this.W0;
            if (bundle2 != null && hasExtra) {
                bundle2.putBoolean("key_personality_label_switch", intent.getBooleanExtra("key_personality_label_switch", false));
            }
            if (QLog.isColorLevel()) {
                QLog.i("ProfileCardMoreActivity", 2, "handleActivityResultForInterestSwitch mHasInterestStateChanged:" + this.Y0 + " isWeiShiChangeToOpen:" + booleanExtra + " isPersonalityLabelChanged:" + hasExtra);
            }
        }
    }

    private void w3(final String str) {
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            this.f260974a1 = false;
            D4(str);
            return;
        }
        if (this.Z0 == null) {
            QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(this, 0, getString(R.string.f175412yh), null, getString(R.string.f175402yg), true, getString(R.string.cancel), getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ProfileCardMoreActivity.this.K3(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ProfileCardMoreActivity.this.L3(str, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ProfileCardMoreActivity.this.J3(dialogInterface, i3);
                }
            });
            this.Z0 = createDialogWithCheckBox;
            createDialogWithCheckBox.setTitleMutiLine();
        }
        if (!this.Z0.isShowing()) {
            this.Z0.show();
            ReportController.o(this.app, "dc00898", "", "", "0X800C00A", "0X800C00A", 0, 0, "", "", "", "");
        }
    }

    private void w4(boolean z16) {
        long j3;
        boolean z17;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            Q4();
            return;
        }
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        try {
            j3 = Long.parseLong(this.f260975b0.uin);
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (j3 > 0) {
            friendListHandler.changeFriendShieldFlag(j3, !z16);
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            this.f261010y0 = !z16;
            this.B0 |= 2;
            C4();
        } else {
            if (z16) {
                notifyUser(R.string.hju, 1);
            } else {
                notifyUser(R.string.hjw, 1);
            }
            Q4();
        }
    }

    private void x3() {
        startActivityForResult(new Intent(this, (Class<?>) InterestSwitchEditActivity.class), 1008);
    }

    private void y3(View view, String str) {
        new HashMap().put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y4(final Activity activity, final boolean z16, final String str, final boolean z17) {
        this.f260976b1 = z16;
        QQCustomDialog addBlacklistDialog = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getAddBlacklistDialog(activity, z16, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ProfileCardMoreActivity.this.P3(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ProfileCardMoreActivity.this.Q3(activity, str, z17, z16, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ProfileCardMoreActivity.this.R3(z17, z16, dialogInterface, i3);
            }
        });
        if (activity != null && !activity.isFinishing() && addBlacklistDialog != null) {
            addBlacklistDialog.show();
            ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", "pg_zplan_qqusercard_setting", ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_ACTIONSHEET, t3(), new HashMap<String, String>(z16) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$needTransferButton;

                {
                    String str2;
                    this.val$needTransferButton = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16));
                        return;
                    }
                    if (z16) {
                        str2 = "2";
                    } else {
                        str2 = "1";
                    }
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_TYPE, str2);
                }
            });
        } else {
            QLog.e("ProfileCardMoreActivity", 1, "showAddBlacklistDialog is error!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z4(Activity activity, boolean z16, String str, boolean z17) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity, z16, str, z17) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f261028d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f261029e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f261030f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f261031h;

            {
                this.f261028d = activity;
                this.f261029e = z16;
                this.f261030f = str;
                this.f261031h = z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ProfileCardMoreActivity.this, activity, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ProfileCardMoreActivity.this.y4(this.f261028d, this.f261029e, this.f261030f, this.f261031h);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    void A3(int i3, FormSimpleItem formSimpleItem, int i16, int i17) {
        int[] iArr = this.f261007v0;
        if (i3 < iArr.length && formSimpleItem != null) {
            if (iArr[i3] == 1) {
                formSimpleItem.setVisibility(0);
                formSimpleItem.setOnClickListener(this);
                if (i3 == i16 && i3 == i17) {
                    formSimpleItem.setBgType(0);
                    return;
                }
                if (i3 == i16) {
                    formSimpleItem.setBgType(1);
                    return;
                } else if (i3 == i17) {
                    formSimpleItem.setBgType(3);
                    return;
                } else {
                    formSimpleItem.setBgType(2);
                    return;
                }
            }
            formSimpleItem.setVisibility(8);
        }
    }

    void B3(int i3, FormSwitchItem formSwitchItem, int i16, int i17) {
        int[] iArr = this.f261007v0;
        if (i3 < iArr.length && formSwitchItem != null) {
            if (iArr[i3] == 1) {
                formSwitchItem.setVisibility(0);
                formSwitchItem.setOnCheckedChangeListener(this);
                if (i3 == i16 && i3 == i17) {
                    formSwitchItem.setBgType(0);
                    return;
                }
                if (i3 == i16) {
                    formSwitchItem.setBgType(1);
                    return;
                } else if (i3 == i17) {
                    formSwitchItem.setBgType(3);
                    return;
                } else {
                    formSwitchItem.setBgType(2);
                    return;
                }
            }
            formSwitchItem.setVisibility(8);
        }
    }

    void C3() {
        boolean z16;
        this.f261007v0 = new int[21];
        for (int i3 = 0; i3 < 21; i3++) {
            this.f261007v0[i3] = 0;
        }
        if (this.app.getCurrentUin().equals(this.f260975b0.uin)) {
            int[] iArr = this.f261007v0;
            iArr[17] = 1;
            iArr[19] = 1;
            iArr[18] = 1;
            iArr[20] = 1;
            this.A0 = true;
        } else if (ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
            this.f261007v0[1] = 1;
            if (Utils.G(this.f260975b0.uin)) {
                int[] iArr2 = this.f261007v0;
                iArr2[2] = 1;
                iArr2[11] = 1;
                iArr2[14] = 1;
            } else {
                this.f261007v0[0] = 1;
                if (!nx.a.d(this.f260975b0.uin) && !QidianManager.P(this.app, this.f260975b0.uin)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    if (((QidianManager) this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).L(this.f260975b0.uin)) {
                        this.f261007v0[3] = 0;
                    } else {
                        this.f261007v0[3] = 1;
                    }
                }
                int[] iArr3 = this.f261007v0;
                iArr3[4] = 1;
                if (!z16) {
                    iArr3[5] = 1;
                    iArr3[10] = 1;
                }
                iArr3[6] = 1;
                if (FriendIntimateRelationshipHelper.m(this.app.getCurrentUin())) {
                    this.f261007v0[7] = 1;
                }
                if (com.tencent.mobileqq.relationx.friendclue.c.a()) {
                    this.f261007v0[8] = 1;
                }
                int[] iArr4 = this.f261007v0;
                iArr4[9] = 1;
                iArr4[s3()] = 1;
                int[] iArr5 = this.f261007v0;
                iArr5[14] = 1;
                iArr5[15] = 1;
            }
        } else {
            int i16 = this.f260975b0.f260789pa;
            if (i16 != 21 && i16 != 22 && i16 != 46 && i16 != 47 && i16 != 3 && i16 != 2 && i16 != 74) {
                if (i16 != 41 && i16 != 42 && i16 != 86 && i16 != 56 && i16 != 57 && i16 != 58) {
                    if (i16 != 32 && i16 != 31 && i16 != 50 && i16 != 51 && i16 != 34) {
                        if (i16 != 71 && i16 != 72 && i16 != 27) {
                            if (i16 == 96) {
                                this.f261007v0[s3()] = 1;
                                this.f261007v0[15] = 1;
                            } else if (ac.q0(i16)) {
                                this.f261007v0[s3()] = 1;
                                this.f261007v0[15] = 1;
                            } else {
                                AllInOne allInOne = this.f260975b0;
                                int i17 = allInOne.f260789pa;
                                if (i17 == 78) {
                                    int[] iArr6 = this.f261007v0;
                                    iArr6[15] = 1;
                                    iArr6[s3()] = 1;
                                } else if (i17 == 95) {
                                    this.f261007v0[15] = 1;
                                } else if (i17 == 117) {
                                    this.f261007v0[s3()] = 1;
                                    this.f261007v0[15] = 1;
                                } else if (ProfilePAUtils.isPaTypeShowAccount(allInOne)) {
                                    this.f261007v0[s3()] = 1;
                                    this.f261007v0[15] = 1;
                                } else if (ProfilePAUtils.isPaTypeStrangerInContact(this.f260975b0)) {
                                    this.f261007v0[15] = 1;
                                }
                            }
                        } else {
                            this.f261007v0[s3()] = 1;
                            this.f261007v0[15] = 1;
                        }
                    } else {
                        this.f261007v0[s3()] = 1;
                        this.f261007v0[15] = 1;
                    }
                } else {
                    this.f261007v0[s3()] = 1;
                    this.f261007v0[15] = 1;
                }
            } else {
                this.f261007v0[s3()] = 1;
                this.f261007v0[15] = 1;
            }
        }
        if ("troopMembercard".equals(this.J0)) {
            this.f261007v0[4] = 0;
        }
    }

    void C4() {
        if (this.f260982e1 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.f260982e1 = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.hex);
        }
        this.f260982e1.show();
    }

    protected void F3() {
        Card r16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String str3 = null;
        if (friendsManager == null) {
            r16 = null;
        } else {
            r16 = friendsManager.r(this.f260975b0.uin);
        }
        if (r16 != null && (str2 = r16.strReMark) != null && str2.length() > 0) {
            str = r16.strReMark;
        } else {
            str = null;
        }
        if ((str == null || str.length() <= 0) && this.f260975b0.f260789pa == 30) {
            ProfileContactInfo r36 = r3();
            if (r36 != null) {
                str3 = r36.phoneName;
            }
            str = str3;
        }
        this.D0 = str;
        if (QLog.isDevelopLevel()) {
            QLog.i("ProfileCardMoreActivity", 4, "initRemark, " + this.D0);
        }
    }

    public void F4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f261011z0 = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlacklistUin(this.f260975b0.uin, new e());
        ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", "pg_zplan_qqusercard_setting", ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_SWITCH, t3(), new HashMap<String, String>() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.17
            static IPatchRedirector $redirector_;

            {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                    return;
                }
                if (ProfileCardMoreActivity.this.f261011z0) {
                    str = "1";
                } else {
                    str = "2";
                }
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
            }
        });
        G4(this.f261011z0);
    }

    boolean G3() {
        String str;
        int i3 = this.f260975b0.f260789pa;
        if (i3 != 41 && i3 != 42 && i3 != 86) {
            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if (shieldMsgManger == null) {
                return false;
            }
            if (ProfilePAUtils.isPaTypeHasUin(this.f260975b0)) {
                str = this.f260975b0.uin;
            } else if (ProfilePAUtils.isPaTypeStrangerInContact(this.f260975b0)) {
                str = getContactStrangerUin();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return shieldMsgManger.h(str);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin), "ProfileCardMoreActivity");
        if (friendsSimpleInfoWithUid == null || friendsSimpleInfoWithUid.f() != -1002) {
            return false;
        }
        return true;
    }

    public void G4(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        FormSwitchItem formSwitchItem = this.f261001p0;
        if (formSwitchItem == null) {
            return;
        }
        formSwitchItem.setOnCheckedChangeListener(null);
        this.f261001p0.setChecked(z16);
        this.f261001p0.setOnCheckedChangeListener(this);
        H4(z16);
    }

    void H3(int i3, int i16) {
        FormItemRelativeLayout formItemRelativeLayout;
        int f16;
        if (TextUtils.isEmpty(cl.d(this, "bc_remark_first")) && (formItemRelativeLayout = this.f260979d0) != null && formItemRelativeLayout.getVisibility() != 8) {
            if (this.f261005t0 == null) {
                this.f261005t0 = (TextView) findViewById(R.id.bqt);
            }
            if (ThemeUtil.isInNightMode(this.app)) {
                this.f261005t0.setBackgroundResource(R.drawable.ngb);
            } else {
                this.f261005t0.setBackgroundResource(R.drawable.f3h);
            }
            if (i3 < 0) {
                f16 = 0;
            } else {
                f16 = BaseAIOUtils.f(30.0f, getResources());
            }
            if (i16 < 0) {
                i16 = 0;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(f16, i16, 0, 0);
            this.f261005t0.setLayoutParams(layoutParams);
            this.f261005t0.setVisibility(0);
            cl.j(this, "bc_remark_first", "false");
        }
    }

    void I4(Card card) {
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.T0;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.m(card);
        }
    }

    void O4(BusinessCard businessCard) {
        String str;
        if (businessCard == null) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin), "ProfileCardMoreActivity");
        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.r() != null) {
            str = friendsSimpleInfoWithUid.r();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(businessCard.picUrl)) {
            u4(this.f260981e0, getResources().getDrawable(R.drawable.f3k));
        } else {
            u4(this.f260981e0, null);
        }
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(businessCard.company)) {
            if (sb5.length() != 0) {
                sb5.append("\uff0c");
            }
            sb5.append(businessCard.company);
        }
        List<String> list = businessCard.mobilesNum;
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < businessCard.mobilesNum.size(); i3++) {
                if (sb5.length() != 0) {
                    sb5.append("\uff0c");
                }
                sb5.append(businessCard.mobilesNum.get(i3));
            }
        }
        List<String> list2 = businessCard.descs;
        if (list2 != null && !list2.isEmpty()) {
            if (sb5.length() != 0) {
                sb5.append("\uff0c");
            }
            for (int i16 = 0; i16 < businessCard.descs.size(); i16++) {
                sb5.append(businessCard.descs.get(i16));
            }
        }
        this.H0 = sb5.toString();
        setNewRemark(str);
    }

    public void Q4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            return;
        }
        this.f261000o0.setChecked(this.f261010y0);
        if (this.f261010y0) {
            this.f260993k0.setVisibility(8);
            this.f260999n0.setVisibility(8);
        } else if (ProfilePAUtils.isPaTypeFriend(this.f260975b0) && !Utils.G(this.f260975b0.uin)) {
            this.f260993k0.setVisibility(0);
            this.f260999n0.setVisibility(0);
        }
    }

    public void S4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (!this.C0) {
            this.C0 = true;
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.29
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                        i3 = profileCardMoreActivity.g3(profileCardMoreActivity.f260975b0.uin);
                    } catch (Exception unused) {
                        i3 = -1;
                    }
                    ProfileCardMoreActivity profileCardMoreActivity2 = ProfileCardMoreActivity.this;
                    profileCardMoreActivity2.C0 = false;
                    profileCardMoreActivity2.app.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.29.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f261018d;

                        {
                            this.f261018d = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass29.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            int i16 = this.f261018d;
                            if (i16 == 0) {
                                ProfileCardMoreActivity.this.c4(R.string.f170064ep, 2);
                            } else if (i16 == 1) {
                                ProfileCardMoreActivity.this.c4(R.string.f170634wn, 2);
                            } else if (i16 == -1) {
                                ProfileCardMoreActivity.this.c4(R.string.f170633wm, 1);
                            }
                        }
                    });
                }
            });
        }
    }

    void a4() {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin), "ProfileCardMoreActivity");
        if (friendsSimpleInfoWithUid != null) {
            startActivityForResult(new Intent(getActivity(), (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", this.f260975b0.uin).putExtra("mgid", (byte) friendsSimpleInfoWithUid.f()), 0);
        }
    }

    public void c4(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show(getTitleBarHeight() - ((int) (getResources().getDisplayMetrics().density * 10.0f)));
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            dispatchTouchEvent = ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            TextView textView = this.f261005t0;
            if (textView != null && textView.getVisibility() == 0) {
                this.f261005t0.setVisibility(8);
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardMoreActivity", 2, "onActivityResult, resultCode : " + i3 + ", resultCode : " + i16 + ", data : " + intent);
        }
        if (i16 == -1) {
            if (i3 != 0) {
                String str = null;
                if (i3 != 21) {
                    if (i3 != 1003) {
                        if (i3 != 1008) {
                            if (i3 != 1024) {
                                if (i3 == 1040) {
                                    QLog.i("ProfileCardMoreActivity", 1, "REQUEST_FOR_CREATE_MINI_HOME");
                                    if (this.N0.isChecked() && ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableMiniHomeEdit()) {
                                        this.Q0.setVisibility(0);
                                        this.Q0.setOnClickListener(this);
                                        this.O0.setBgType(2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            FriendProfilePhotoHelper friendProfilePhotoHelper = this.T0;
                            if (friendProfilePhotoHelper != null) {
                                friendProfilePhotoHelper.j(i16, intent);
                                return;
                            }
                            return;
                        }
                        if (intent != null) {
                            v3(i16, intent);
                            return;
                        }
                        return;
                    }
                    if (intent != null) {
                        str = intent.getStringExtra("result");
                        z16 = intent.getBooleanExtra("hasChange", false);
                    } else {
                        z16 = false;
                    }
                    if (str == null) {
                        str = "";
                    }
                    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        if (!z16 && str.equals(this.E0)) {
                            return;
                        }
                        if (!str.equals(this.f261008w0)) {
                            FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                            if (friendListHandler != null) {
                                friendListHandler.setFriendComment(this.f260975b0.uin, str, false);
                                this.B0 |= 1;
                                setNewRemark(str);
                                return;
                            }
                            notifyUser(R.string.bw_, 1);
                            return;
                        }
                        notifyUser(R.string.bvs, 0);
                        return;
                    }
                    notifyUser(R.string.cjl, 1);
                    return;
                }
                if (intent != null && intent.getExtras() != null && !intent.getExtras().isEmpty() && intent.getExtras().getInt("uintype", 0) != 10027) {
                    intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.hvn));
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                    m3.putExtras(new Bundle(intent.getExtras()));
                    ForwardUtils.p(this.app, this, ForwardUtils.n0(m3), m3);
                    return;
                }
                return;
            }
            QLog.i("ProfileCardMoreActivity", 1, "REQUEST_FOR_MOVE_FRIEND_GROUP");
            this.f261009x0 = intent.getStringExtra("group_name");
            J4();
            return;
        }
        if (i16 == 0 && i3 == 1040) {
            this.O0.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f260975b0 = (AllInOne) getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
        this.f260977c0 = (BusinessCard) getIntent().getParcelableExtra("BusinessCard");
        this.J0 = getIntent().getStringExtra("from");
        this.E0 = getIntent().getStringExtra("key_nick_name");
        this.F0 = getIntent().getBooleanExtra("key_is_personal_card", false);
        this.f260980d1 = new WeakReference<>(this);
        AllInOne allInOne = this.f260975b0;
        if (allInOne != null && !TextUtils.isEmpty(allInOne.uin)) {
            if (QLog.isColorLevel()) {
                AllInOne allInOne2 = this.f260975b0;
                QLog.i("ProfileCardMoreActivity", 2, String.format("check params [%s, %s, %s]", Integer.valueOf(this.f260975b0.f260789pa), allInOne2.uin, allInOne2.reportExtra));
            }
            this.V0 = new com.tencent.mobileqq.relationx.friendclue.c();
            try {
                C3();
                initUI();
            } catch (NoSuchFieldError unused) {
                super.finish();
            }
            FriendProfilePhotoHelper friendProfilePhotoHelper = new FriendProfilePhotoHelper(this, this);
            this.T0 = friendProfilePhotoHelper;
            friendProfilePhotoHelper.f176062k = getIntent().getIntExtra("coverTimeStamp", 0);
            this.T0.f176061j = getIntent().getStringExtra("coverUrl");
            AllInOne allInOne3 = (AllInOne) getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
            this.U0 = allInOne3;
            if (allInOne3 == null) {
                this.U0 = new AllInOne(this.app.getCurrentUin(), 0);
            }
            this.G0 = (BusinessCardManager) this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
            addObserver(this.f260984f1);
            addObserver(this.f260986g1);
            addObserver(this.f260992j1);
            addObserver(this.f260994k1);
            addObserver(this.f260988h1);
            addObserver(this.f260996l1);
            this.app.registObserver(this.f260990i1);
            this.app.setHandler(ProfileCardMoreActivity.class, this.f260998m1);
            if (this.D0 == null || ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ProfileCardMoreActivity.this.F3();
                        ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                        profileCardMoreActivity.K0 = Boolean.valueOf(com.tencent.mobileqq.mutualmark.c.l(profileCardMoreActivity.app, profileCardMoreActivity.f260975b0.uin, true));
                    }
                }, 16, null, true);
            }
            SimpleEventBus.getInstance().registerReceiver(this);
            return true;
        }
        super.finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.T0;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.c();
            this.T0 = null;
        }
        l3();
        removeObserver(this.f260984f1);
        removeObserver(this.f260986g1);
        removeObserver(this.f260992j1);
        removeObserver(this.f260994k1);
        removeObserver(this.f260988h1);
        removeObserver(this.f260996l1);
        this.app.unRegistObserver(this.f260990i1);
        this.app.removeHandler(ProfileCardMoreActivity.class);
        QQCustomDialog qQCustomDialog = this.Z0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.Z0.dismiss();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        FriendProfilePhotoHelper friendProfilePhotoHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0 && (friendProfilePhotoHelper = this.T0) != null) {
            friendProfilePhotoHelper.f(intent, stringArrayListExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        boolean specialCareGlobalSwitch = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(this.f260975b0.uin), "ProfileCardMoreActivity");
        if (this.f260993k0.getVisibility() == 0) {
            if (!specialCareGlobalSwitch) {
                this.f260993k0.setRightText(getString(R.string.hbd));
            } else {
                this.f260993k0.setRightText(getString(R.string.hbe));
            }
        }
        L4();
        View view = this.S0;
        if (view != null) {
            if (I3()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        P4();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.I0 == null) {
            this.I0 = new Intent();
        }
        if (this.Y0.booleanValue()) {
            this.I0.putExtra(IProfileCardConst.PARAM_SWITCHES_CHANGED, true);
        }
        Bundle bundle = this.W0;
        if (bundle != null) {
            this.I0.putExtra("result", bundle);
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.T0;
        if (friendProfilePhotoHelper != null && friendProfilePhotoHelper.f176059h) {
            this.I0.putExtra("is_set_cover", true);
            this.I0.putExtra("cover_data", this.T0.f176060i);
        }
        setResult(-1, this.I0);
        super.finish();
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x05f6, code lost:
    
        r26 = getContentResolver();
        r27 = android.provider.ContactsContract.Data.CONTENT_URI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x05fc, code lost:
    
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x05fe, code lost:
    
        r28 = new java.lang.String[]{"raw_contact_id", r2, "mimetype", r1, com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2};
        r0 = new java.lang.StringBuilder();
        r0.append("raw_contact_id=");
        r0.append(r10);
        r0.append(r7);
        r0.append("mimetype");
        r0.append(r5);
        r8 = r16;
        r0.append(r8);
        r0.append(r4);
        r0.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r0.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0624, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0627, code lost:
    
        r0.append(2);
        r0.append(r14);
        r2 = com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.query(r26, r27, r28, r0.toString(), null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x063d, code lost:
    
        if (r2.moveToFirst() == false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x063f, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", r8);
        r3.put(r1, r15.mBmqqEmail);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x065f, code lost:
    
        r16 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0661, code lost:
    
        getContentResolver().update(android.provider.ContactsContract.Data.CONTENT_URI, r3, "raw_contact_id=" + r10 + r7 + "mimetype" + r5 + r8 + r4 + com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2 + r5 + 2 + r14, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x06d1, code lost:
    
        r16.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0691, code lost:
    
        r16 = r2;
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", r8);
        r3.put(r1, r15.mBmqqEmail);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x06cf, code lost:
    
        if (r16 != 0) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x06b7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x06bc, code lost:
    
        r15 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x06c7, code lost:
    
        if (r15 != null) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x06c9, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x06cc, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x06bf, code lost:
    
        r16 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x06b9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x06ba, code lost:
    
        r16 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x06c2, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x06cd, code lost:
    
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x06c5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x06c6, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x06d4, code lost:
    
        r26 = getContentResolver();
        r27 = android.provider.ContactsContract.Data.CONTENT_URI;
        r28 = new java.lang.String[]{"raw_contact_id", r18, "mimetype", r1, com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2};
        r0 = new java.lang.StringBuilder();
        r0.append("raw_contact_id=");
        r0.append(r10);
        r0.append(r7);
        r0.append("mimetype");
        r0.append(r5);
        r2 = r20;
        r0.append(r2);
        r0.append(r4);
        r0.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r0.append(r5);
        r0.append(2);
        r0.append(r14);
        r8 = com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.query(r26, r27, r28, r0.toString(), null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0719, code lost:
    
        if (r8.moveToFirst() == false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x071b, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", r2);
        r3.put(r1, r33);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        r0 = getContentResolver();
        r1 = android.provider.ContactsContract.Data.CONTENT_URI;
        r0.update(r1, r3, "raw_contact_id=" + r10 + r7 + "mimetype" + r5 + r2 + r4 + com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2 + r5 + 2 + r14, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x078f, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x076c, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", r2);
        r3.put(r1, r33);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0796, code lost:
    
        r15 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x07a3, code lost:
    
        if (r15 != null) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x07a5, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x07a8, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0793, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0794, code lost:
    
        r15 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x079b, code lost:
    
        if (r15 != null) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x079d, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x07a0, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x07a1, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0798, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0799, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0509, code lost:
    
        r26 = getContentResolver();
        r27 = android.provider.ContactsContract.Data.CONTENT_URI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x050f, code lost:
    
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0511, code lost:
    
        r28 = new java.lang.String[]{"raw_contact_id", r2, "mimetype", r1, com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2};
        r0 = new java.lang.StringBuilder();
        r0.append("raw_contact_id=");
        r0.append(r10);
        r0.append(r7);
        r0.append("mimetype");
        r0.append(r5);
        r8 = r19;
        r0.append(r8);
        r0.append(r4);
        r0.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r0.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0537, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x053a, code lost:
    
        r0.append(3);
        r0.append(r14);
        r2 = com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.query(r26, r27, r28, r0.toString(), null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0550, code lost:
    
        if (r2.moveToFirst() == false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0552, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", r8);
        r3.put(r1, r15.mBmqqTelphone);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0564, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0567, code lost:
    
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0574, code lost:
    
        r21 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0576, code lost:
    
        getContentResolver().update(android.provider.ContactsContract.Data.CONTENT_URI, r3, "raw_contact_id=" + r10 + r7 + "mimetype" + r5 + r8 + r4 + com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2 + r5 + 3 + r14, null);
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x05ef, code lost:
    
        r17.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x05a8, code lost:
    
        r21 = r1;
        r17 = r2;
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x05bb, code lost:
    
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x05bd, code lost:
    
        r3.put(r1, r15.mBmqqTelphone);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 3);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x05ed, code lost:
    
        if (r17 == 0) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x05d2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x05da, code lost:
    
        r15 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x05e5, code lost:
    
        if (r15 != null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x05e7, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x05ea, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x05d4, code lost:
    
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x05dd, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x05d7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x05d8, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x05e0, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x05eb, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x05e3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x05e4, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0410, code lost:
    
        r26 = getContentResolver();
        r27 = android.provider.ContactsContract.Data.CONTENT_URI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0416, code lost:
    
        r1 = r17;
        r2 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x041a, code lost:
    
        r28 = new java.lang.String[]{"raw_contact_id", r2, "mimetype", r1, com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2};
        r0 = new java.lang.StringBuilder();
        r0.append("raw_contact_id=");
        r0.append(r10);
        r0.append(r7);
        r0.append("mimetype");
        r0.append(r5);
        r0.append("vnd.android.cursor.item/organization");
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0435, code lost:
    
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0437, code lost:
    
        r0.append(r4);
        r0.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r0.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0440, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0443, code lost:
    
        r0.append(1);
        r0.append(r14);
        r2 = com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.query(r26, r27, r28, r0.toString(), null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0459, code lost:
    
        if (r2.moveToFirst() == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x045b, code lost:
    
        r3.clear();
        r3.put("mimetype", "vnd.android.cursor.item/organization");
        r3.put(r1, r15.mBmqqCompany);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0473, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0477, code lost:
    
        r21 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0479, code lost:
    
        getContentResolver().update(android.provider.ContactsContract.Data.CONTENT_URI, r3, "raw_contact_id=" + r10 + r7 + "mimetype" + r5 + "vnd.android.cursor.item/organization" + r4 + com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2 + r5 + 1 + r14, null);
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04fb, code lost:
    
        r17.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x04ab, code lost:
    
        r21 = r1;
        r17 = r2;
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", "vnd.android.cursor.item/organization");
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x04be, code lost:
    
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x04c0, code lost:
    
        r3.put(r1, r15.mBmqqCompany);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 1);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04d5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x04dd, code lost:
    
        r15 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x04eb, code lost:
    
        if (r15 != null) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x04ed, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x04f0, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x04f9, code lost:
    
        if (r17 != 0) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x04d7, code lost:
    
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x04e0, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x04da, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x04db, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04f7, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x04e3, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04e6, code lost:
    
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x04f5, code lost:
    
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x04f1, code lost:
    
        r1 = r17;
        r18 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x04e9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04ea, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0321, code lost:
    
        r26 = getContentResolver();
        r27 = android.provider.ContactsContract.Data.CONTENT_URI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0327, code lost:
    
        r1 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0329, code lost:
    
        r28 = new java.lang.String[]{"raw_contact_id", r1, "mimetype", "data4", com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2};
        r0 = new java.lang.StringBuilder();
        r0.append("raw_contact_id=");
        r0.append(r10);
        r0.append(r7);
        r0.append("mimetype");
        r0.append(r5);
        r0.append("vnd.android.cursor.item/organization");
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0346, code lost:
    
        r0.append(r22);
        r0.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r0.append(r5);
        r0.append(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0353, code lost:
    
        r14 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0355, code lost:
    
        r0.append(r14);
        r18 = com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.query(r26, r27, r28, r0.toString(), null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0368, code lost:
    
        if (r18.moveToFirst() == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x036a, code lost:
    
        r3.clear();
        r3.put("mimetype", "vnd.android.cursor.item/organization");
        r3.put("data4", r15.mBmqqJobTitle);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 1);
        r0 = getContentResolver();
        r2 = android.provider.ContactsContract.Data.CONTENT_URI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0383, code lost:
    
        r21 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0385, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("raw_contact_id=");
        r1.append(r10);
        r1.append(r7);
        r1.append("mimetype");
        r1.append(r5);
        r1.append("vnd.android.cursor.item/organization");
        r1.append(r22);
        r1.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r1.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x03a5, code lost:
    
        r22 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x03a8, code lost:
    
        r1.append(1);
        r1.append(r14);
        r0.update(r2, r3, r1.toString(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0404, code lost:
    
        r18.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x03e5, code lost:
    
        r22 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0402, code lost:
    
        if (r18 != null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x03b7, code lost:
    
        r21 = r1;
        r22 = r22;
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r10));
        r3.put("mimetype", "vnd.android.cursor.item/organization");
        r3.put("data4", r15.mBmqqJobTitle);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 1);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x03e3, code lost:
    
        r21 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x03df, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x03e0, code lost:
    
        r15 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x03f6, code lost:
    
        if (r15 != null) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x03f8, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x03fb, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x03e8, code lost:
    
        r21 = r1;
        r22 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0400, code lost:
    
        r18 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x03ed, code lost:
    
        r22 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x03ef, code lost:
    
        r14 = r21;
        r21 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x03fc, code lost:
    
        r14 = r21;
        r21 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x03f4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x03f5, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x030f, code lost:
    
        r17 = com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1;
        r16 = "vnd.android.cursor.item/email_v2";
        r7 = " AND ";
        r10 = r7;
        r20 = "vnd.android.cursor.item/im";
        r5 = "='";
        r19 = "vnd.android.cursor.item/phone_v2";
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x07aa, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x018a, code lost:
    
        if (r20 != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x018d, code lost:
    
        r18 = "_id";
        r0 = false;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x016a, code lost:
    
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x017a, code lost:
    
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017f, code lost:
    
        r21 = r7;
        r7 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0183, code lost:
    
        if (r0 != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0185, code lost:
    
        r18 = "_id";
        r0 = true;
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0191, code lost:
    
        r3 = new android.content.ContentValues();
        r22 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ab, code lost:
    
        if (r0 != true) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ad, code lost:
    
        r0 = android.content.ContentUris.parseId(getContentResolver().insert(android.provider.ContactsContract.RawContacts.CONTENT_URI, r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01bf, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01c1, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r0));
        r3.put("mimetype", "vnd.android.cursor.item/name");
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r14);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01df, code lost:
    
        if (r15.mBmqqJobTitle != null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e3, code lost:
    
        if (r15.mBmqqCompany == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0213, code lost:
    
        if (r15.mBmqqMobileNum == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0215, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r0));
        r3.put("mimetype", "vnd.android.cursor.item/phone_v2");
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r15.mBmqqMobileNum);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x023a, code lost:
    
        if (r15.mBmqqTelphone == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x023c, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r0));
        r3.put("mimetype", "vnd.android.cursor.item/phone_v2");
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r15.mBmqqTelphone);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 3);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0261, code lost:
    
        if (r15.mBmqqEmail == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0263, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r0));
        r3.put("mimetype", "vnd.android.cursor.item/email_v2");
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r15.mBmqqEmail);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0286, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r0));
        r3.put("mimetype", "vnd.android.cursor.item/im");
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r33);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02aa, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e5, code lost:
    
        r3.clear();
        r3.put("raw_contact_id", java.lang.Long.valueOf(r0));
        r3.put("mimetype", "vnd.android.cursor.item/organization");
        r6 = r15.mBmqqCompany;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f4, code lost:
    
        if (r6 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01f6, code lost:
    
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f9, code lost:
    
        r6 = r15.mBmqqJobTitle;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01fb, code lost:
    
        if (r6 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01fd, code lost:
    
        r3.put("data4", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0200, code lost:
    
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 1);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02ae, code lost:
    
        if (r1 != true) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02b2, code lost:
    
        if (r15.mBmqqMobileNum == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02b4, code lost:
    
        r3.clear();
        r3.put("mimetype", "vnd.android.cursor.item/phone_v2");
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1, r15.mBmqqMobileNum);
        r3.put(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2, (java.lang.Integer) 2);
        r0 = getContentResolver();
        r1 = android.provider.ContactsContract.Data.CONTENT_URI;
        r14 = new java.lang.StringBuilder();
        r14.append("raw_contact_id=");
        r17 = com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1;
        r16 = "vnd.android.cursor.item/email_v2";
        r10 = r7;
        r14.append(r10);
        r7 = " AND ";
        r14.append(r7);
        r14.append("mimetype");
        r20 = "vnd.android.cursor.item/im";
        r5 = "='";
        r14.append(r5);
        r14.append("vnd.android.cursor.item/phone_v2");
        r19 = "vnd.android.cursor.item/phone_v2";
        r14.append(r22);
        r14.append(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA2);
        r14.append(r5);
        r14.append(2);
        r14.append(r21);
        r0.update(r1, r3, r14.toString(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x031f, code lost:
    
        if (r15.mBmqqJobTitle == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0408, code lost:
    
        r14 = r21;
        r21 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x040e, code lost:
    
        if (r15.mBmqqCompany == null) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x04ff, code lost:
    
        r1 = r17;
        r18 = r21;
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0507, code lost:
    
        if (r15.mBmqqTelphone == null) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x05f4, code lost:
    
        if (r15.mBmqqEmail == null) goto L390;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x014c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x013c A[Catch: Exception -> 0x0162, all -> 0x0164, TRY_ENTER, TryCatch #24 {Exception -> 0x0162, blocks: (B:333:0x013c, B:334:0x013f, B:325:0x0149), top: B:324:0x0149 }] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v14 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v17 */
    /* JADX WARN: Type inference failed for: r17v18, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r17v19 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v22 */
    /* JADX WARN: Type inference failed for: r17v23 */
    /* JADX WARN: Type inference failed for: r17v24 */
    /* JADX WARN: Type inference failed for: r17v25 */
    /* JADX WARN: Type inference failed for: r17v26 */
    /* JADX WARN: Type inference failed for: r17v27 */
    /* JADX WARN: Type inference failed for: r17v28 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int g3(String str) {
        BmqqUserSimpleInfo bmqqUserSimpleInfo;
        String str2;
        String str3;
        Cursor cursor;
        String str4;
        boolean z16;
        Cursor cursor2;
        Cursor cursor3;
        ContentResolver contentResolver;
        Uri uri;
        String[] strArr;
        StringBuilder sb5;
        String str5 = "'";
        String str6 = "' AND ";
        if (str == null || str.trim().length() == 0) {
            return -1;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            bmqqUserSimpleInfo = (BmqqUserSimpleInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) BmqqUserSimpleInfo.class, str);
        } else {
            bmqqUserSimpleInfo = null;
        }
        if (createEntityManager != null) {
            createEntityManager.close();
        }
        if (bmqqUserSimpleInfo == null) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(this.f261008w0)) {
                str2 = this.f261008w0;
            } else {
                str2 = bmqqUserSimpleInfo.mBmqqNickName;
                if (str2 == null) {
                    if (!TextUtils.isEmpty(str)) {
                        str3 = str;
                    } else {
                        str3 = null;
                    }
                    long j3 = 0;
                    cursor2 = ContactsMonitor.query(getContentResolver(), ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id", "_id", "mimetype", StepCounterConstants.BEACON_PARAM_KEY_DATA1}, "mimetype='vnd.android.cursor.item/name' AND data1='" + str3 + "'", null, null);
                    z16 = false;
                    boolean z17 = false;
                    while (cursor2 != null) {
                        try {
                            try {
                                if (!cursor2.moveToNext()) {
                                    break;
                                }
                                String str7 = str5;
                                String str8 = str6;
                                try {
                                    long j16 = cursor2.getLong(0);
                                    try {
                                        if (bmqqUserSimpleInfo.mBmqqMobileNum != null) {
                                            try {
                                                contentResolver = getContentResolver();
                                                uri = ContactsContract.Data.CONTENT_URI;
                                                strArr = new String[]{"raw_contact_id", "_id", "mimetype", StepCounterConstants.BEACON_PARAM_KEY_DATA1, StepCounterConstants.BEACON_PARAM_KEY_DATA2};
                                                sb5 = new StringBuilder();
                                                sb5.append("raw_contact_id=");
                                                sb5.append(j16);
                                                sb5.append(" AND ");
                                                sb5.append("mimetype");
                                                sb5.append("='");
                                                sb5.append("vnd.android.cursor.item/phone_v2");
                                                str4 = str8;
                                                try {
                                                    sb5.append(str4);
                                                    sb5.append(StepCounterConstants.BEACON_PARAM_KEY_DATA1);
                                                    sb5.append("='");
                                                    j3 = j16;
                                                } catch (Exception unused) {
                                                    j3 = j16;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    j3 = j16;
                                                }
                                            } catch (Exception unused2) {
                                                j3 = j16;
                                                str5 = str7;
                                                str4 = str8;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                j3 = j16;
                                                str5 = str7;
                                                str4 = str8;
                                            }
                                            try {
                                                sb5.append(bmqqUserSimpleInfo.mBmqqMobileNum);
                                                sb5.append(str4);
                                                sb5.append(StepCounterConstants.BEACON_PARAM_KEY_DATA2);
                                                sb5.append("='");
                                                sb5.append(2);
                                                str5 = str7;
                                            } catch (Exception unused3) {
                                                str5 = str7;
                                                cursor3 = null;
                                                if (cursor3 != null) {
                                                }
                                                str6 = str4;
                                                z16 = true;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                str5 = str7;
                                                cursor3 = null;
                                                if (cursor3 != null) {
                                                }
                                                throw th;
                                            }
                                            try {
                                                sb5.append(str5);
                                                cursor3 = ContactsMonitor.query(contentResolver, uri, strArr, sb5.toString(), null, null);
                                                if (cursor3 != null) {
                                                    try {
                                                        if (cursor3.moveToFirst()) {
                                                            try {
                                                                cursor3.close();
                                                                z16 = true;
                                                                z17 = true;
                                                                break;
                                                            } catch (Exception unused4) {
                                                                z17 = true;
                                                                if (cursor3 != null) {
                                                                }
                                                                str6 = str4;
                                                                z16 = true;
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                z17 = true;
                                                                if (cursor3 != null) {
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Exception unused5) {
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                    }
                                                }
                                                if (cursor3 != null) {
                                                    try {
                                                        cursor3.close();
                                                    } catch (Exception unused6) {
                                                        z16 = true;
                                                        z17 = false;
                                                    }
                                                }
                                                z17 = false;
                                            } catch (Exception unused7) {
                                                cursor3 = null;
                                                if (cursor3 != null) {
                                                    try {
                                                        cursor3.close();
                                                    } catch (Exception unused8) {
                                                        z16 = true;
                                                    }
                                                }
                                                str6 = str4;
                                                z16 = true;
                                            } catch (Throwable th10) {
                                                th = th10;
                                                cursor3 = null;
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                                throw th;
                                            }
                                            str6 = str4;
                                            z16 = true;
                                        } else {
                                            j3 = j16;
                                            str5 = str7;
                                            str4 = str8;
                                            z16 = true;
                                            z17 = false;
                                            break;
                                        }
                                    } catch (Exception unused9) {
                                        j3 = j16;
                                        str5 = str7;
                                        str4 = str8;
                                        z16 = true;
                                    }
                                } catch (Exception unused10) {
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused11) {
                            str4 = str6;
                        }
                    }
                    str4 = str6;
                }
            }
            cursor2 = ContactsMonitor.query(getContentResolver(), ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id", "_id", "mimetype", StepCounterConstants.BEACON_PARAM_KEY_DATA1}, "mimetype='vnd.android.cursor.item/name' AND data1='" + str3 + "'", null, null);
            z16 = false;
            boolean z172 = false;
            while (cursor2 != null) {
            }
            str4 = str6;
        } catch (Exception unused12) {
            str4 = "' AND ";
            z16 = false;
            cursor2 = null;
        } catch (Throwable th12) {
            th = th12;
            cursor = null;
        }
        str3 = str2;
        long j36 = 0;
    }

    public void g4(String str, String str2, int i3) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, str2, Integer.valueOf(i3));
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ProfileCardMoreActivity");
        if (friendsSimpleInfoWithUid != null) {
            if (friendsSimpleInfoWithUid.e() == null) {
                b16 = 0;
            } else {
                b16 = friendsSimpleInfoWithUid.e().byteValue();
            }
        } else {
            b16 = 17;
        }
        String str3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + str + "&cspecialflag=" + ((int) b16);
        String str4 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + str + "&version=1&cspecialflag=" + ((int) b16);
        String str5 = "https://share.mp.qq.com/cgi/share.php?uin=" + str + "&account_flag=-7&jumptype=1&card_type=crm&cspecialflag=" + ((int) b16);
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(14).f(2).f(1).d(HardCodeUtil.qqStr(R.string.pdc) + str2).b("plugin", str5, "", str3, str4).e(getResources().getString(R.string.gzb)).a();
        com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
        uVar.C(1);
        uVar.m(new com.tencent.mobileqq.structmsg.view.c("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + str));
        uVar.m(new StructMsgItemTitle(str2));
        uVar.m(new ap(HardCodeUtil.qqStr(R.string.pd_) + QidianManager.w(this.app, str)));
        a16.addItem(h3(HardCodeUtil.qqStr(R.string.pek)));
        a16.addItem(uVar);
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 20);
        bundle.putInt(AppConstants.Key.STRUCT_MSG_SERVICE_ID, i3);
        bundle.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        bundle.putBoolean("k_dataline", false);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(this, intent, 21);
    }

    String getContactStrangerUin() {
        try {
            return ac.m0(this.app, this.f260973a0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, e16.toString());
            }
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ArrayList) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSetCoverFeedEvent.class);
        return arrayList;
    }

    void initUI() {
        int i3;
        FormSimpleItem formSimpleItem;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        Card q16;
        boolean z16;
        setContentViewB(R.layout.azw);
        r4();
        if ("troopMembercard".equals(this.J0)) {
            setTitle(HardCodeUtil.qqStr(R.string.pdr));
        } else {
            setTitle(R.string.d3u);
        }
        TextView textView = this.mLeftBackText;
        if (textView != null) {
            textView.setText("");
            this.mLeftBackText.setContentDescription(HardCodeUtil.qqStr(R.string.f172319pe1));
        }
        enableRightHighlight(false);
        View findViewById = findViewById(R.id.bfm);
        if (this.f261007v0[14] == 1) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        } else {
            findViewById.setVisibility(8);
        }
        View findViewById2 = findViewById(R.id.f166922j45);
        if (this.f261007v0[15] == 1) {
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(this);
        } else {
            findViewById2.setVisibility(8);
        }
        int i27 = -1;
        int i28 = -1;
        int i29 = -1;
        for (int i36 = 0; i36 <= 3; i36++) {
            if (this.f261007v0[i36] == 1) {
                if (i28 < 0) {
                    i28 = i36;
                }
                if (i29 < i36) {
                    i29 = i36;
                }
            }
        }
        this.f260979d0 = (FormItemRelativeLayout) findViewById(R.id.f165874dr1);
        this.f260981e0 = (TextView) findViewById(R.id.i6t);
        z3(0, this.f260979d0, i28, i29);
        FormSimpleItem formSimpleItem2 = (FormSimpleItem) findViewById(R.id.dpn);
        this.f260983f0 = formSimpleItem2;
        A3(1, formSimpleItem2, i28, i29);
        FormSimpleItem formSimpleItem3 = (FormSimpleItem) findViewById(R.id.drf);
        this.f260985g0 = formSimpleItem3;
        A3(2, formSimpleItem3, i28, i29);
        FormSimpleItem formSimpleItem4 = (FormSimpleItem) findViewById(R.id.dph);
        this.f260989i0 = formSimpleItem4;
        A3(3, formSimpleItem4, i28, i29);
        FormSimpleItem formSimpleItem5 = (FormSimpleItem) findViewById(R.id.dqp);
        this.f260987h0 = formSimpleItem5;
        A3(4, formSimpleItem5, 4, 4);
        if (this.app.getCurrentUin().equals(this.f260975b0.uin)) {
            this.f260987h0.setLeftText(HardCodeUtil.qqStr(R.string.pen));
        } else if (ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
            this.f260987h0.setLeftText(HardCodeUtil.qqStr(R.string.pec));
        }
        E3();
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1004L, this.app.getLongAccountUin());
        boolean z17 = this.F0;
        this.L0 = (FormSimpleItem) findViewById(R.id.lmu);
        this.N0 = (FormSwitchSimpleItem) findViewById(R.id.xya);
        this.O0 = (FormSwitchSimpleItem) findViewById(R.id.xy_);
        FormSimpleItem formSimpleItem6 = (FormSimpleItem) findViewById(R.id.xy8);
        this.P0 = formSimpleItem6;
        formSimpleItem6.setBgType(3);
        FormSimpleItem formSimpleItem7 = (FormSimpleItem) findViewById(R.id.xy9);
        this.Q0 = formSimpleItem7;
        formSimpleItem7.setBgType(3);
        this.R0 = (TextView) findViewById(R.id.f98405n0);
        y3(this.P0, "em_zplan_superqqshow_custombackground");
        y3(this.L0, "em_zplan_customcover");
        y3(this.O0, "em_zplan_mini_xiaowo_switch");
        y3(this.Q0, "em_zplan_mini_xiaowo_decorate");
        i3();
        I4(null);
        FormSimpleItem formSimpleItem8 = (FormSimpleItem) findViewById(R.id.lmw);
        this.M0 = formSimpleItem8;
        y3(formSimpleItem8, "em_zplan_datadisplay_setting");
        A3(18, this.M0, 18, 18);
        FormSimpleItem formSimpleItem9 = (FormSimpleItem) findViewById(R.id.dqo);
        this.f260991j0 = formSimpleItem9;
        A3(5, formSimpleItem9, 5, 5);
        int s36 = s3();
        int i37 = -1;
        for (int i38 = 6; i38 <= s36; i38++) {
            if (this.f261007v0[i38] == 1) {
                if (i27 < 0) {
                    i27 = i38;
                }
                if (i37 < i38) {
                    i37 = i38;
                }
            }
        }
        FormSimpleItem formSimpleItem10 = (FormSimpleItem) findViewById(R.id.izn);
        this.f260993k0 = formSimpleItem10;
        A3(6, formSimpleItem10, i27, i37);
        FormSimpleItem formSimpleItem11 = (FormSimpleItem) findViewById(R.id.dpy);
        this.f260995l0 = formSimpleItem11;
        A3(7, formSimpleItem11, i27, i37);
        if (this.f260995l0.getVisibility() == 0) {
            ReportController.o(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
        }
        FormSimpleItem formSimpleItem12 = (FormSimpleItem) findViewById(R.id.xv5);
        this.f260997m0 = formSimpleItem12;
        A3(8, formSimpleItem12, i27, i37);
        if (this.f260997m0.getVisibility() == 0) {
            com.tencent.mobileqq.relationx.friendclue.d.b(2);
        }
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById(R.id.iow);
        this.f261002q0 = formSwitchItem;
        B3(10, formSwitchItem, i27, i37);
        if (ac.M(this.app)) {
            this.f261002q0.setVisibility(8);
        }
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) findViewById(R.id.ioz);
        this.f260999n0 = formSwitchItem2;
        B3(9, formSwitchItem2, i27, i37);
        FormSwitchItem formSwitchItem3 = (FormSwitchItem) findViewById(R.id.f166335f22);
        this.f261003r0 = formSwitchItem3;
        B3(11, formSwitchItem3, i27, i37);
        FormSwitchItem formSwitchItem4 = (FormSwitchItem) findViewById(R.id.f166856ip0);
        this.f261000o0 = formSwitchItem4;
        B3(12, formSwitchItem4, i27, i37);
        FormSwitchItem formSwitchItem5 = (FormSwitchItem) findViewById(R.id.f83474jn);
        this.f261001p0 = formSwitchItem5;
        B3(13, formSwitchItem5, i27, i37);
        TextView textView2 = (TextView) findViewById(R.id.sck);
        this.f261006u0 = textView2;
        textView2.setVisibility(this.f261001p0.getVisibility());
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) findViewById(R.id.f83614k1);
        this.f261004s0 = qUISingleLineListItem;
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.AllRound);
        this.f261004s0.setStyle(QUIListItemStyle.Card);
        P4();
        if (ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "ProfileCardMoreActivity");
            if (friendsSimpleInfoWithUid != null) {
                ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(friendsSimpleInfoWithUid.f(), "ProfileCardMoreActivity", new n());
                String r16 = friendsSimpleInfoWithUid.r();
                this.f261008w0 = r16;
                this.D0 = r16;
            }
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(uidFromUin, "ProfileCardMoreActivity", new q());
            if (this.f260983f0.getVisibility() == 0) {
                J4();
            }
            if (this.f260979d0.getVisibility() == 0) {
                O4(this.f260977c0);
                this.f260979d0.post(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ProfileCardMoreActivity profileCardMoreActivity = ProfileCardMoreActivity.this;
                            profileCardMoreActivity.H3(profileCardMoreActivity.f260979d0.getLeft(), (ProfileCardMoreActivity.this.f260979d0.getTop() + ProfileCardMoreActivity.this.f260979d0.getMeasuredHeight()) - 20);
                        }
                    }
                });
            }
            if (this.f261003r0.getVisibility() == 0) {
                FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                if (friendsManager == null) {
                    q16 = null;
                } else {
                    q16 = friendsManager.q(AppConstants.BABY_Q_UIN);
                }
                FormSwitchItem formSwitchItem6 = this.f261003r0;
                if (q16 != null && q16.babyQSwitch) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                formSwitchItem6.setChecked(z16);
                TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
                if (tempGetProfileDetailProcessor != null) {
                    tempGetProfileDetailProcessor.getBabyQSwitch();
                }
            }
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ProfileCardMoreActivity")) {
                s4();
            }
        } else {
            if (!TextUtils.isEmpty(this.f260975b0.uid) && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(this.f260975b0.uid, "ProfileCardMoreActivity")) {
                this.f261004s0.setVisibility(0);
            }
            if (this.f261000o0.getVisibility() == 0) {
                this.f261010y0 = G3();
                Q4();
            }
        }
        if (this.f261000o0.getVisibility() == 0) {
            ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", "pg_zplan_qqusercard_setting", ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_SWITCH, t3(), new HashMap<String, String>() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.5
                static IPatchRedirector $redirector_;

                {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                        return;
                    }
                    if (ProfileCardMoreActivity.this.f261010y0) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
                }
            });
        }
        if (this.f261001p0.getVisibility() == 0) {
            F4();
        }
        if (AppSetting.f99565y) {
            this.f261002q0.setContentDescription(getString(R.string.f173105hf0));
            this.f261002q0.setFocusable(true);
            this.f260993k0.setContentDescription(getString(R.string.f172976g92));
            this.f260995l0.setContentDescription(getString(R.string.ivp));
            this.f260997m0.setContentDescription(getString(R.string.f175492yp));
            this.f260987h0.setContentDescription(HardCodeUtil.qqStr(R.string.pda));
            this.f260999n0.setContentDescription(getString(R.string.f170650xg));
            this.f260999n0.setFocusable(true);
            this.f261000o0.setContentDescription(HardCodeUtil.qqStr(R.string.pdk));
            this.f261000o0.setFocusable(true);
            this.f261003r0.setContentDescription(getString(R.string.d4g));
            this.f261003r0.setFocusable(true);
            this.f261001p0.setContentDescription(HardCodeUtil.qqStr(R.string.zlu));
            this.f261001p0.setFocusable(true);
            AccessibilityUtil.n(findViewById(R.id.adt), false);
        }
        this.S0 = findViewById(R.id.xt6);
        FormSwitchSimpleItem formSwitchSimpleItem = this.N0;
        Object obj = "1";
        String str = "2";
        if (formSwitchSimpleItem != null && formSwitchSimpleItem.isChecked()) {
            VideoReport.setElementParam(this.L0, ProfileCardDtReportUtil.IS_REDDOT, "2");
        } else {
            boolean I3 = I3();
            View view = this.S0;
            if (I3) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            FormSimpleItem formSimpleItem13 = this.L0;
            if (I3) {
                str = "1";
            }
            VideoReport.setElementParam(formSimpleItem13, ProfileCardDtReportUtil.IS_REDDOT, str);
        }
        if (this.N0 != null && (formSimpleItem = this.L0) != null && this.R0 != null) {
            A3(17, formSimpleItem, i27, i37);
            this.L0.setBgType(3);
            boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1004L, this.app.getLongAccountUin());
            IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class);
            if (this.A0) {
                i16 = 2;
            } else {
                i16 = 3;
            }
            boolean enableZPlanNativeAppFilament = iZPlanAccessibleHelper.enableZPlanNativeAppFilament(i16);
            TextView textView3 = this.R0;
            if (this.A0) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            textView3.setVisibility(i17);
            QLog.i("ProfileCardMoreActivity", 1, "isVasProfileCard : " + this.F0);
            if (isZplanAccessibleWithoutSetting && this.A0 && !this.F0 && enableZPlanNativeAppFilament) {
                this.N0.setVisibility(0);
                this.N0.setChecked(isZPlanAccessible);
                B3(19, this.N0, i27, i37);
                this.N0.setBgType(1);
                FormSimpleItem formSimpleItem14 = this.P0;
                if (isZPlanAccessible) {
                    i18 = 0;
                } else {
                    i18 = 8;
                }
                formSimpleItem14.setVisibility(i18);
                this.P0.setOnClickListener(this);
                FormSimpleItem formSimpleItem15 = this.L0;
                if (isZPlanAccessible) {
                    i19 = 8;
                } else {
                    i19 = 0;
                }
                formSimpleItem15.setVisibility(i19);
                if (this.F0) {
                    i26 = 8;
                    this.N0.setVisibility(8);
                    this.P0.setBgType(0);
                    this.L0.setBgType(0);
                } else {
                    i26 = 8;
                }
                this.O0.setVisibility(i26);
                this.O0.setOnCheckedChangeListener(this);
                QLog.i("ProfileCardMoreActivity", 1, "setVisibility itemZplanMiniHomeSetting GONE");
                this.Q0.setVisibility(i26);
                this.Q0.setOnClickListener(this);
                boolean miniHomeQQMCSwitchOn = ((IZPlanApi) QRoute.api(IZPlanApi.class)).miniHomeQQMCSwitchOn();
                boolean isZPlanAccessible2 = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1004L, this.app.getLongAccountUin());
                boolean zPlanMiniHomeSettingSwitch = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(this.app.getLongAccountUin());
                if (!StudyModeManager.t() && miniHomeQQMCSwitchOn && isZPlanAccessible2) {
                    this.O0.setVisibility(0);
                    if (zPlanMiniHomeSettingSwitch) {
                        if (((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableMiniHomeEdit()) {
                            this.Q0.setVisibility(0);
                        }
                        this.O0.setChecked(true);
                    }
                    this.O0.setBgType(2);
                }
            } else {
                this.N0.setVisibility(8);
                this.P0.setVisibility(8);
                this.Q0.setVisibility(8);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (!isZPlanAccessible) {
                obj = "0";
            }
            hashMap.put("zplan_btn_switch_status", obj);
            l4(this.N0, "em_zplan_btn_switch", hashMap);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put(SquareReportConst.Key.KEY_SWITCH_STATUS, Integer.valueOf(this.O0.isChecked() ? 1 : 0));
            l4(this.O0, "em_zplan_mini_xiaowo_switch", hashMap2);
            if (this.Q0.getVisibility() == 0) {
                l4(this.Q0, "em_zplan_mini_xiaowo_decorate", null);
            }
            D3();
        }
    }

    void l3() {
        QQProgressDialog qQProgressDialog = this.f260982e1;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f260982e1.cancel();
                this.f260982e1 = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void n3() {
        String str;
        Bundle bundle;
        int u16;
        Bundle bundle2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        String str2 = this.f260975b0.troopCode;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f260975b0.discussUin;
        }
        String str3 = str2;
        if (ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
            str = "1";
        } else {
            str = "0";
        }
        String str4 = str;
        Bundle bundle3 = this.f260975b0.reportExtra;
        if (bundle3 != null && bundle3.containsKey("chatuin") && this.f260975b0.reportExtra.containsKey("chattype")) {
            bundle = this.f260975b0.reportExtra;
        } else {
            bundle = null;
        }
        int i16 = this.f260975b0.f260789pa;
        if (i16 == 96) {
            bundle2 = bundle;
            i3 = 20005;
        } else {
            if (ProfilePAUtils.isFromTroopMemberCard(i16)) {
                u16 = 20008;
                if (bundle == null) {
                    bundle = NewReportPlugin.G(this.f260975b0.troopCode, 1);
                }
            } else {
                int i17 = this.f260975b0.f260789pa;
                if (i17 == 117) {
                    u16 = 25028;
                } else if (ProfilePAUtils.isFromDiscussion(i17)) {
                    u16 = 20013;
                    if (bundle == null) {
                        bundle = NewReportPlugin.G(this.f260975b0.discussUin, 3000);
                    }
                } else {
                    u16 = bundle != null ? bundle.containsKey("chattype") ? NewReportPlugin.u(bundle.getInt("chattype")) : ProfilePAUtils.isPaTypeFriend(this.f260975b0) ? 21000 : 20002 : ProfilePAUtils.isPaTypeFriend(this.f260975b0) ? 21001 : 20001;
                }
            }
            bundle2 = bundle;
            i3 = u16;
        }
        if (i3 != 20005 && i3 != 20015 && i3 != 25020) {
            NewReportPlugin.S(this, this.f260975b0.uin, null, str4, str3, this.app.getAccount(), i3, null, bundle2);
        } else {
            String str5 = this.f260975b0.uin;
            NewReportPlugin.S(this, str5, NewReportPlugin.j(str5, NewReportPlugin.p(2)), str4, null, this.app.getCurrentAccountUin(), i3, null, bundle2);
        }
        if (QLog.isColorLevel()) {
            AllInOne allInOne = this.f260975b0;
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", allInOne.uin, Integer.valueOf(allInOne.f260789pa), Integer.valueOf(i3), str4, str3, bundle2));
        }
        ReportController.o(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileEntryUtils.getProfileEntryType(this.f260975b0.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.f260975b0)), "", "", "");
    }

    public void n4(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr);
            return;
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.T0;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.k(bArr);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            I4(null);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.18
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardMoreActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ProfileCardMoreActivity.this.I4(null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
    public void notifyUser(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).create(getTitleBarHeight()).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        int i3;
        int i16;
        Object obj;
        byte b16;
        int i17;
        String str;
        int i18;
        int i19;
        int i26;
        long j3;
        int i27;
        int i28;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton == this.f261000o0.getSwitch()) {
            QQAppInterface qQAppInterface = this.app;
            if (z16) {
                i28 = 1;
            } else {
                i28 = 2;
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, i28, "0", "0", "", "");
            ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_zplan_qqusercard_setting", ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_SWITCH, t3(), new HashMap<String, String>(z16) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.30
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isCheck;

                {
                    String str2;
                    this.val$isCheck = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16));
                        return;
                    }
                    if (z16) {
                        str2 = "1";
                    } else {
                        str2 = "2";
                    }
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_CLICK, str2);
                }
            });
            if (this.f261010y0 != z16) {
                if (ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
                    w4(!z16);
                } else {
                    x4(!z16);
                }
            }
        } else if (compoundButton == this.f261001p0.getSwitch()) {
            ((IProfileCardBlacklistService) this.app.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_zplan_qqusercard_setting", ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_SWITCH, t3(), new HashMap<String, String>(z16) { // from class: com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.31
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isCheck;

                {
                    String str2;
                    this.val$isCheck = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileCardMoreActivity.this, Boolean.valueOf(z16));
                        return;
                    }
                    if (z16) {
                        str2 = "1";
                    } else {
                        str2 = "2";
                    }
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_CLICK, str2);
                }
            });
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                if (z16) {
                    u3(this, this.f260975b0.uin, z16);
                } else {
                    p4(this.f260975b0.uin, z16);
                }
            } else {
                notifyUser(R.string.b3j, 1);
                h4(z16);
            }
        } else if (compoundButton == this.f261002q0.getSwitch()) {
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f260975b0.uin);
                friendListHandler.gatherContacts((short) 1, arrayList, z16);
                if (z16) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
                }
            } else {
                notifyUser(R.string.b3j, 1);
                this.f261002q0.setOnCheckedChangeListener(null);
                this.f261002q0.setChecked(!z16);
                this.f261002q0.setOnCheckedChangeListener(this);
            }
        } else if (compoundButton == this.f261003r0.getSwitch()) {
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                ((CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).Z4(z16);
                ReportController.o(this.app, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(z16 ? 1 : 0), "", "", "");
            } else {
                notifyUser(R.string.b3j, 1);
                this.f261003r0.setOnCheckedChangeListener(null);
                this.f261003r0.setChecked(!z16);
                this.f261003r0.setOnCheckedChangeListener(this);
            }
        } else {
            FormSwitchItem formSwitchItem = this.f260999n0;
            if (formSwitchItem != null && formSwitchItem.getSwitch() == compoundButton) {
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    notifyUser(R.string.b3j, 1);
                    this.f260999n0.setOnCheckedChangeListener(null);
                    this.f260999n0.setChecked(!compoundButton.isChecked());
                    this.f260999n0.setOnCheckedChangeListener(this);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCardMoreActivity", 2, "mDoNotDisturb switch, now value=", Boolean.valueOf(compoundButton.isChecked()));
                    }
                    QQAppInterface qQAppInterface2 = this.app;
                    String str2 = this.f260975b0.uin;
                    if (compoundButton.isChecked()) {
                        j3 = com.tencent.mobileqq.service.message.e.K0();
                    } else {
                        j3 = 0;
                    }
                    FriendsStatusUtil.s(qQAppInterface2, str2, 0, j3, true, false);
                    QQAppInterface qQAppInterface3 = this.app;
                    if (compoundButton.isChecked()) {
                        i27 = 1;
                    } else {
                        i27 = 2;
                    }
                    ReportController.o(qQAppInterface3, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, i27, "0", "0", "", "");
                }
            } else {
                int i29 = 8;
                if (compoundButton == this.N0.getSwitch()) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    String str3 = "1";
                    if (!z16) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    hashMap.put("zplan_btn_switch_status", obj);
                    k4(this.N0, hashMap);
                    ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).setZplanProfileCardSettingSwitch(z16, new o(z16));
                    if (z16 && !StudyModeManager.t()) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    FormSwitchSimpleItem formSwitchSimpleItem = this.O0;
                    if (b16 != false) {
                        i17 = 0;
                    } else {
                        i17 = 8;
                    }
                    formSwitchSimpleItem.setVisibility(i17);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("setVisibility itemZplanMiniHomeSetting ");
                    if (b16 != false) {
                        str = ParseCommon.VISIBLE;
                    } else {
                        str = ParseCommon.GONE;
                    }
                    sb5.append(str);
                    QLog.i("ProfileCardMoreActivity", 1, sb5.toString());
                    boolean zPlanMiniHomeSettingSwitch = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(this.app.getLongAccountUin());
                    this.O0.setOnCheckedChangeListener(null);
                    this.O0.setChecked(zPlanMiniHomeSettingSwitch);
                    this.O0.setOnCheckedChangeListener(this);
                    FormSwitchSimpleItem formSwitchSimpleItem2 = this.O0;
                    if (zPlanMiniHomeSettingSwitch) {
                        i18 = 3;
                    } else {
                        i18 = 2;
                    }
                    formSwitchSimpleItem2.setBgType(i18);
                    FormSimpleItem formSimpleItem = this.P0;
                    if (z16 && !zPlanMiniHomeSettingSwitch) {
                        i19 = 0;
                    } else {
                        i19 = 8;
                    }
                    formSimpleItem.setVisibility(i19);
                    FormSimpleItem formSimpleItem2 = this.L0;
                    if (z16) {
                        i26 = 8;
                    } else {
                        i26 = 0;
                    }
                    formSimpleItem2.setVisibility(i26);
                    View view = this.S0;
                    if (view != null) {
                        if (I3()) {
                            i29 = 0;
                        }
                        view.setVisibility(i29);
                    }
                    if (!z16) {
                        str3 = "0";
                    }
                    hashMap.put("zplan_btn_switch_status", str3);
                    VideoReport.reportEvent("dt_imp", this.N0, hashMap);
                    if (!z16) {
                        this.O0.setChecked(false);
                    }
                } else if (compoundButton == this.O0.getSwitch()) {
                    FormSimpleItem formSimpleItem3 = this.P0;
                    if (!z16 && this.N0.isChecked()) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    formSimpleItem3.setVisibility(i3);
                    FormSwitchSimpleItem formSwitchSimpleItem3 = this.O0;
                    if (z16) {
                        i16 = 3;
                    } else {
                        i16 = 2;
                    }
                    formSwitchSimpleItem3.setBgType(i16);
                    if (!z16) {
                        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).requestSetZPlanMiniHomeSettingSwitch(false, new nk3.a() { // from class: com.tencent.mobileqq.profilesetting.g
                            @Override // nk3.a
                            public final void onResult(boolean z17) {
                                ProfileCardMoreActivity.this.M3(z17);
                            }
                        });
                        this.Q0.setVisibility(8);
                    } else {
                        M4(this.N0.isChecked());
                    }
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap2.put(SquareReportConst.Key.KEY_SWITCH_STATUS, Integer.valueOf(z16 ? 1 : 0));
                    k4(this.O0, hashMap2);
                }
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            boolean z16 = false;
            if (view == null) {
                id5 = 0;
            } else {
                id5 = view.getId();
            }
            if (id5 == R.id.f165874dr1) {
                ProfileCardUtil.l0(this, this.f260977c0, this.f260975b0);
                ReportController.o(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileEntryUtils.getProfileEntryType(this.f260975b0.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.f260975b0)), "", "", "");
                ReportController.o(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
            } else if (id5 == R.id.dpn) {
                a4();
                ReportController.o(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileEntryUtils.getProfileEntryType(this.f260975b0.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.f260975b0)), "", "", "");
            } else if (id5 == R.id.dph) {
                QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PROFILE_CARD_CONTACT, QQPermissionConstants.Business.SCENE.COMPANY_QQ_ADD_CONTACT)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_CONTACTS}, 2, new l());
            } else if (id5 == R.id.dqp) {
                if (((QidianManager) this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).R(this.f260975b0.uin)) {
                    if (TextUtils.isEmpty(this.f260975b0.nickname)) {
                        AllInOne allInOne = this.f260975b0;
                        allInOne.nickname = ac.f(this.app, allInOne.uin);
                    }
                    String stringExtra = getIntent().getStringExtra("key_nick_name");
                    if (stringExtra == null) {
                        stringExtra = this.f260975b0.nickname;
                    }
                    g4(this.f260975b0.uin, stringExtra, 14);
                } else {
                    if (this.X0 == null) {
                        this.X0 = new ProfileCardShareHelper(this, this.app, 0, new m());
                    }
                    if (TextUtils.isEmpty(this.f260975b0.nickname)) {
                        AllInOne allInOne2 = this.f260975b0;
                        allInOne2.nickname = ac.f(this.app, allInOne2.uin);
                    }
                    if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("relationship_recommend")) {
                        ProfileCardShareHelper profileCardShareHelper = this.X0;
                        AllInOne allInOne3 = this.f260975b0;
                        profileCardShareHelper.w(allInOne3.uin, allInOne3.nickname);
                    } else {
                        ProfileCardShareHelper profileCardShareHelper2 = this.X0;
                        AllInOne allInOne4 = this.f260975b0;
                        profileCardShareHelper2.A(allInOne4.uin, allInOne4.nickname);
                    }
                }
                ReportController.o(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
            } else {
                String str2 = null;
                if (id5 == R.id.bfm) {
                    try {
                        AllInOne allInOne5 = this.f260975b0;
                        if (allInOne5 != null) {
                            str2 = allInOne5.uin;
                        }
                        w3(str2);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCardMoreActivity", 2, e16, new Object[0]);
                        }
                    }
                } else if (id5 == R.id.f166922j45) {
                    n3();
                } else if (id5 == R.id.dqo) {
                    try {
                        if (NetworkUtil.isNetSupport(getActivity())) {
                            Intent intent = new Intent();
                            intent.putExtra("uin", this.f260975b0.uin);
                            PublicFragmentActivity.start(getActivity(), intent, ProfilePermissionSettingFragment.class);
                            ReportController.o(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileEntryUtils.getProfileEntryType(this.f260975b0.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.f260975b0)), "", "", "");
                        } else {
                            QQToastUtil.showQQToast(4, R.string.f171139ci4);
                        }
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, e17.toString());
                        }
                    }
                } else if (id5 == R.id.izn) {
                    com.tencent.mobileqq.activity.specialcare.h.a(this, this.f260975b0.uin, 3);
                    ReportController.o(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
                } else if (id5 == R.id.dpy) {
                    ReportController.o(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin);
                    com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "ProfileCardMoreActivity");
                    if (intimateSimpleInfoWithUid == null) {
                        intimateSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uidFromUin, this.f260975b0.uin);
                    }
                    if (com.tencent.mobileqq.activity.aio.intimate.e.e(intimateSimpleInfoWithUid.j())) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(AppConstants.Key.FORWARD_PEER_UIN, this.f260975b0.uin);
                        PublicFragmentActivity.b.a(this, intent2, PublicFragmentActivity.class, IntimateInfoFragment.class);
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCardMoreActivity", 2, "jumpIntimatePage");
                        }
                    } else {
                        String b16 = FriendIntimateRelationshipHelper.b(this.f260975b0.uin);
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCardMoreActivity", 2, "click item_friend_intimate url:" + b16);
                        }
                        if (!TextUtils.isEmpty(b16)) {
                            startActivity(new Intent(this, (Class<?>) QQBrowserActivity.class).putExtra("url", b16));
                        }
                    }
                } else if (id5 == R.id.xv5) {
                    this.V0.b(this, this.f260975b0.uin);
                    com.tencent.mobileqq.relationx.friendclue.d.a(2);
                } else if (id5 == R.id.lms) {
                    ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(this, "6");
                    ReportController.o(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
                } else if (id5 == R.id.lmu) {
                    FriendProfilePhotoHelper friendProfilePhotoHelper = this.T0;
                    if (friendProfilePhotoHelper != null) {
                        if (friendProfilePhotoHelper.f176062k == 0) {
                            z16 = true;
                        }
                        friendProfilePhotoHelper.h(z16);
                    }
                    ReportController.o(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
                    k4(this.L0, null);
                } else if (id5 == R.id.lmw) {
                    x3();
                    ReportController.o(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
                    k4(this.M0, null);
                } else if (id5 == R.id.xy8) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("from_type", "from_profile_setting");
                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).startZPlanBackgroundEdit(this, intent3);
                    k4(this.P0, null);
                } else if (id5 == R.id.xy9) {
                    IMiniHomeHelper iMiniHomeHelper = (IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class);
                    ao saveRoomDesc = iMiniHomeHelper.getSaveRoomDesc(this.app.getCurrentUin());
                    String currentUin = this.app.getCurrentUin();
                    String currentUin2 = this.app.getCurrentUin();
                    if (saveRoomDesc != null) {
                        str = saveRoomDesc.getRoomDescJson();
                    } else {
                        str = "";
                    }
                    iMiniHomeHelper.startEditMiniHomeFragment(this, currentUin, currentUin2, str, EditMiniHomeSource.PROFILE_CARD_SETTING);
                    k4(this.Q0, null);
                } else if (QLog.isColorLevel()) {
                    QLog.d("ProfileCardMoreActivity", 2, "case default do nothing");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof QFSSetCoverFeedEvent) && getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
    public void onUploadResult(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
        } else if (bArr != null) {
            n4(bArr);
        }
    }

    protected ProfileContactInfo r3() {
        ArrayList<ProfileContactInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ProfileContactInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        AllInOne allInOne = this.f260975b0;
        if (allInOne != null && (arrayList = allInOne.contactArray) != null && arrayList.size() > 0) {
            return this.f260975b0.contactArray.get(0);
        }
        return null;
    }

    void setNewRemark(String str) {
        String str2;
        this.f261008w0 = str;
        String str3 = "";
        if (!TextUtils.isEmpty(this.H0)) {
            TextView textView = this.f260981e0;
            if (TextUtils.isEmpty(this.f261008w0)) {
                str2 = "" + this.H0;
            } else {
                str2 = this.f261008w0 + "\uff0c" + this.H0;
            }
            textView.setText(str2);
        } else {
            TextView textView2 = this.f260981e0;
            if (!TextUtils.isEmpty(this.f261008w0)) {
                str3 = this.f261008w0;
            }
            textView2.setText(str3);
        }
        if (this.I0 == null) {
            this.I0 = new Intent();
        }
        this.I0.putExtra("remark", this.f261008w0);
        setResult(-1, this.I0);
    }

    void u4(TextView textView, Drawable drawable) {
        if (textView != null) {
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(null, null, drawable, null);
            } else {
                textView.setCompoundDrawables(null, null, drawable, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
    public void updateCover(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
        } else if (bArr != null) {
            n4(bArr);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    void v4(boolean z16, boolean z17) {
        l3();
        if ((this.B0 & 2) == 2) {
            if (z16) {
                if (z17) {
                    notifyUser(R.string.hjv, 2);
                } else {
                    notifyUser(R.string.hk8, 2);
                }
            } else if (z17) {
                notifyUser(R.string.hju, 1);
            } else {
                notifyUser(R.string.hjw, 1);
            }
        }
        this.B0 &= -3;
        if (ProfilePAUtils.isPaTypeFriend(this.f260975b0)) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f260975b0.uin), "ProfileCardMoreActivity", new d());
        } else {
            this.f261010y0 = G3();
            Q4();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void x4(boolean z16) {
        boolean z17;
        int i3;
        String str;
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if (shieldMsgManger != null) {
                try {
                    AllInOne allInOne = this.f260975b0;
                    String str2 = allInOne.uin;
                    if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                        str2 = getContactStrangerUin();
                    }
                    long parseLong = Long.parseLong(str2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(parseLong));
                    int p16 = ProfileCardUtil.p(this.f260975b0);
                    if (z16) {
                        shieldMsgManger.m(p16, arrayList);
                    } else {
                        shieldMsgManger.k(p16, arrayList);
                    }
                    z17 = true;
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, "shieldMsg() " + e16.toString());
                    }
                }
                AllInOne allInOne2 = this.f260975b0;
                i3 = allInOne2.f260789pa;
                if ((i3 != 41 || i3 == 42 || i3 == 86) && (str = allInOne2.uin) != null && str.length() > 0) {
                    if (!z16) {
                        this.app.getMsgHandler().S2(this.f260975b0.uin);
                    } else {
                        this.app.getMsgHandler().o4(this.f260975b0.uin);
                    }
                    z17 = true;
                }
                if (!z17) {
                    this.f261010y0 = !z16;
                    this.B0 |= 2;
                    C4();
                    return;
                } else {
                    if (z16) {
                        notifyUser(R.string.hju, 1);
                    } else {
                        notifyUser(R.string.hjw, 1);
                    }
                    Q4();
                    return;
                }
            }
            z17 = false;
            AllInOne allInOne22 = this.f260975b0;
            i3 = allInOne22.f260789pa;
            if (i3 != 41) {
            }
            if (!z16) {
            }
            z17 = true;
            if (!z17) {
            }
        } else {
            notifyUser(R.string.b3j, 1);
            Q4();
        }
    }

    void z3(int i3, FormItemRelativeLayout formItemRelativeLayout, int i16, int i17) {
        int[] iArr = this.f261007v0;
        if (i3 < iArr.length && formItemRelativeLayout != null) {
            if (iArr[i3] == 1) {
                formItemRelativeLayout.setVisibility(0);
                formItemRelativeLayout.setOnClickListener(this);
                if (i3 == i16 && i3 == i17) {
                    formItemRelativeLayout.setBGType(0);
                    return;
                }
                if (i3 == i16) {
                    formItemRelativeLayout.setBGType(1);
                    return;
                } else if (i3 == i17) {
                    formItemRelativeLayout.setBGType(2);
                    return;
                } else {
                    formItemRelativeLayout.setBGType(3);
                    return;
                }
            }
            formItemRelativeLayout.setVisibility(8);
        }
    }
}
