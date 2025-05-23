package com.tencent.mobileqq.activity;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.SoftHideKeyBoardUtil;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class FriendProfileMoreInfoActivity extends ProfileActivity implements View.OnClickListener, View.OnFocusChangeListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    EditText A0;
    boolean A1;
    private FormSimpleItem B0;
    String B1;
    EditText C0;
    String C1;
    private FormSimpleItem D0;
    String D1;
    private TextView E0;
    private boolean E1;
    private String F0;
    private final int[] F1;
    private FormSimpleItem G0;
    private Map<Integer, Integer> G1;
    private TextView H0;
    CardObserver H1;
    private FormSimpleItem I0;
    private ProfileCardObserver I1;
    EditText J0;
    private com.tencent.mobileqq.businessCard.a J1;
    private FormSimpleItem K0;
    private com.tencent.mobileqq.app.ar K1;
    private TextView L0;
    private ConditionSearchManager.c L1;
    private View M0;
    private com.tencent.mobileqq.profile.PersonalityLabel.c M1;
    private LinearLayout N0;
    private PhotoWallObserver N1;
    private FormSimpleItem O0;
    protected BroadcastReceiver O1;
    private FormSimpleItem P0;
    private FormSimpleItem Q0;
    private FormSimpleItem R0;
    AllInOne S0;
    BusinessCard T0;
    q U0;
    q V0;
    q W0;
    q X0;
    CardHandler Y0;
    ConditionSearchManager Z0;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f175962a0;

    /* renamed from: a1, reason: collision with root package name */
    QQProgressDialog f175963a1;

    /* renamed from: b0, reason: collision with root package name */
    BounceScrollView f175964b0;

    /* renamed from: b1, reason: collision with root package name */
    int f175965b1;

    /* renamed from: c0, reason: collision with root package name */
    LinearLayout f175966c0;

    /* renamed from: c1, reason: collision with root package name */
    QQProgressDialog f175967c1;

    /* renamed from: d0, reason: collision with root package name */
    private FormSimpleItem f175968d0;

    /* renamed from: d1, reason: collision with root package name */
    boolean f175969d1;

    /* renamed from: e0, reason: collision with root package name */
    private FormSimpleItem f175970e0;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f175971e1;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f175972f0;

    /* renamed from: f1, reason: collision with root package name */
    boolean f175973f1;

    /* renamed from: g0, reason: collision with root package name */
    private FormSimpleItem f175974g0;

    /* renamed from: g1, reason: collision with root package name */
    private Card f175975g1;

    /* renamed from: h0, reason: collision with root package name */
    ColorNickTextView f175976h0;

    /* renamed from: h1, reason: collision with root package name */
    private String f175977h1;

    /* renamed from: i0, reason: collision with root package name */
    private FormSimpleItem f175978i0;

    /* renamed from: i1, reason: collision with root package name */
    private byte f175979i1;

    /* renamed from: j0, reason: collision with root package name */
    EditText f175980j0;

    /* renamed from: j1, reason: collision with root package name */
    private int f175981j1;

    /* renamed from: k0, reason: collision with root package name */
    private FormSimpleItem f175982k0;

    /* renamed from: k1, reason: collision with root package name */
    private int f175983k1;

    /* renamed from: l0, reason: collision with root package name */
    private TextView f175984l0;

    /* renamed from: l1, reason: collision with root package name */
    private int f175985l1;

    /* renamed from: m0, reason: collision with root package name */
    private String f175986m0;

    /* renamed from: m1, reason: collision with root package name */
    private int f175987m1;

    /* renamed from: n0, reason: collision with root package name */
    private FormSimpleItem f175988n0;

    /* renamed from: n1, reason: collision with root package name */
    String[] f175989n1;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f175990o0;

    /* renamed from: o1, reason: collision with root package name */
    String[] f175991o1;

    /* renamed from: p0, reason: collision with root package name */
    private String f175992p0;

    /* renamed from: p1, reason: collision with root package name */
    private String f175993p1;

    /* renamed from: q0, reason: collision with root package name */
    private FormSimpleItem f175994q0;

    /* renamed from: q1, reason: collision with root package name */
    boolean f175995q1;

    /* renamed from: r0, reason: collision with root package name */
    private TextView f175996r0;

    /* renamed from: r1, reason: collision with root package name */
    boolean f175997r1;

    /* renamed from: s0, reason: collision with root package name */
    private FormSimpleItem f175998s0;

    /* renamed from: s1, reason: collision with root package name */
    boolean f175999s1;

    /* renamed from: t0, reason: collision with root package name */
    private TextView f176000t0;

    /* renamed from: t1, reason: collision with root package name */
    boolean f176001t1;

    /* renamed from: u0, reason: collision with root package name */
    private FormSimpleItem f176002u0;

    /* renamed from: u1, reason: collision with root package name */
    boolean f176003u1;

    /* renamed from: v0, reason: collision with root package name */
    private FormSimpleItem f176004v0;

    /* renamed from: v1, reason: collision with root package name */
    boolean f176005v1;

    /* renamed from: w0, reason: collision with root package name */
    private FormSimpleItem f176006w0;

    /* renamed from: w1, reason: collision with root package name */
    WeakReferenceHandler f176007w1;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f176008x0;

    /* renamed from: x1, reason: collision with root package name */
    ProfileConfig f176009x1;

    /* renamed from: y0, reason: collision with root package name */
    private TextView f176010y0;

    /* renamed from: y1, reason: collision with root package name */
    Bundle f176011y1;

    /* renamed from: z0, reason: collision with root package name */
    private FormSimpleItem f176012z0;

    /* renamed from: z1, reason: collision with root package name */
    private String f176013z1;

    /* renamed from: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity$21, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass21 extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        AnonymousClass21() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("event");
            if (((TroopManager) FriendProfileMoreInfoActivity.this.app.getManager(QQManagerFactory.TROOP_MANAGER)).R(FriendProfileMoreInfoActivity.this.B1) && "com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(action) && IHWTroopUtilsApi.HW_TROOP_IDENTITY_CHANGED_EVENT.equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("data");
                if (TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    if (!TextUtils.equals(FriendProfileMoreInfoActivity.this.B1, jSONObject.optString("groupCode"))) {
                        return;
                    }
                    jSONObject.optString("content");
                    String optString = jSONObject.optString("source");
                    int optInt = jSONObject.optInt("rankId", 333);
                    String optString2 = jSONObject.optString("nickName");
                    String optString3 = jSONObject.optString("uin");
                    String optString4 = jSONObject.optString("course");
                    String optString5 = jSONObject.optString("name");
                    if ("qqProfile".equals(optString)) {
                        ThreadManagerV2.post(new Runnable(optString3, optString2, optInt, optString4, optString5) { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.21.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f176015d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f176016e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ int f176017f;

                            /* renamed from: h, reason: collision with root package name */
                            final /* synthetic */ String f176018h;

                            /* renamed from: i, reason: collision with root package name */
                            final /* synthetic */ String f176019i;

                            {
                                this.f176015d = optString3;
                                this.f176016e = optString2;
                                this.f176017f = optInt;
                                this.f176018h = optString4;
                                this.f176019i = optString5;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass21.this, optString3, optString2, Integer.valueOf(optInt), optString4, optString5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    ((IBizTroopMemberInfoService) FriendProfileMoreInfoActivity.this.app.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHomeworkTroopMemberIdentity(FriendProfileMoreInfoActivity.this.B1, this.f176015d, this.f176016e, this.f176017f, this.f176018h, this.f176019i);
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.21.1.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                            } else {
                                                FriendProfileMoreInfoActivity.this.i5();
                                            }
                                        }
                                    });
                                }
                            }
                        }, 8, null, false);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(FriendProfileMoreInfoActivity.this.app, "dc00898", "", "", "0X800A0D8", "0X800A0D8", 0, 0, "", "", "", "");
                FriendProfileMoreInfoActivity.this.K3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f176025d;

        b(ActionSheet actionSheet) {
            this.f176025d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            ActionSheet actionSheet = this.f176025d;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
            if (i3 == 0) {
                FriendProfileMoreInfoActivity.this.B4(1);
                FriendProfileMoreInfoActivity.this.b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", 3));
            } else if (i3 == 1) {
                FriendProfileMoreInfoActivity.this.B4(2);
                FriendProfileMoreInfoActivity.this.b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", 2));
            } else if (i3 == 2) {
                FriendProfileMoreInfoActivity.this.B4(3);
                FriendProfileMoreInfoActivity.this.b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FriendProfileMoreInfoActivity.this.c4();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f176028d;

        d(List list) {
            this.f176028d = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this, (Object) list);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FriendProfileMoreInfoActivity.this.H4(this.f176028d, true);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f176030d;

        e(List list) {
            this.f176030d = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this, (Object) list);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FriendProfileMoreInfoActivity.this.H4(this.f176030d, false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class f implements IProfileEditApi.LocationEditListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.LocationEditListener
        public void onPrivacyUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            FriendProfileMoreInfoActivity.this.G1.remove(41614);
            FriendProfileMoreInfoActivity.this.G1.put(41614, Integer.valueOf(i3));
            if (i3 == 2) {
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.h5(friendProfileMoreInfoActivity.E0, FriendProfileMoreInfoActivity.this.getResources().getString(R.string.f175922zv), true);
            } else {
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity2 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity2.h5(friendProfileMoreInfoActivity2.E0, FriendProfileMoreInfoActivity.this.F0, false);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.LocationEditListener
        public void onUpdate(String str, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) strArr);
                return;
            }
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
            if (!friendProfileMoreInfoActivity.L3(friendProfileMoreInfoActivity.f175989n1, strArr)) {
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity2 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity2.f176001t1 = true;
                friendProfileMoreInfoActivity2.f175989n1 = strArr;
                friendProfileMoreInfoActivity2.Y4(str);
                if (strArr != null && strArr.length >= 4) {
                    FriendProfileMoreInfoActivity.this.f175975g1.strLocationCodes = strArr[0] + "-" + strArr[1] + "-" + strArr[2] + "-" + strArr[3];
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    class g extends CardObserver {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetEducationList(boolean z16, long j3, ArrayList<com.tencent.mobileqq.profile.i> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), arrayList);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, "onGetEducationList, success:" + z16 + ", uin=" + j3);
            }
            if (z16) {
                FriendProfileMoreInfoActivity.this.G4(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetLocationDescription(boolean z16, String str, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, card);
            } else if (z16 && card != null && Utils.p(FriendProfileMoreInfoActivity.this.app.getCurrentAccountUin(), card.uin)) {
                FriendProfileMoreInfoActivity.this.z4(card, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class h implements IProfileEditApi.GenderEditListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.GenderEditListener
        public void onConfirm(int i3) {
            byte b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                b16 = 0;
            } else {
                b16 = 1;
            }
            if (FriendProfileMoreInfoActivity.this.f175979i1 != b16) {
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.f175995q1 = true;
                friendProfileMoreInfoActivity.e5(b16, false);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.GenderEditListener
        public void onPrivacyUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            FriendProfileMoreInfoActivity.this.G1.remove(41611);
            FriendProfileMoreInfoActivity.this.G1.put(41611, Integer.valueOf(i3));
            if (i3 == 2) {
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.h5(friendProfileMoreInfoActivity.f175984l0, FriendProfileMoreInfoActivity.this.getResources().getString(R.string.f175922zv), true);
            } else {
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity2 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity2.h5(friendProfileMoreInfoActivity2.f175984l0, FriendProfileMoreInfoActivity.this.f175986m0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class i extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    class j extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16 && (obj instanceof Card)) {
                Card card = (Card) obj;
                if (Utils.p(FriendProfileMoreInfoActivity.this.app.getCurrentAccountUin(), card.uin)) {
                    FriendProfileMoreInfoActivity.this.z4(card, true);
                    FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                    if (!friendProfileMoreInfoActivity.A1) {
                        FriendProfileMoreInfoActivity.this.G4(((BusinessCardManager) friendProfileMoreInfoActivity.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).n());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        public void onGetProfileDetail(boolean z16, String str, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, card);
            } else if (z16 && card != null && Utils.p(FriendProfileMoreInfoActivity.this.app.getCurrentAccountUin(), card.uin)) {
                FriendProfileMoreInfoActivity.this.z4(card, true);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onSetProfileDetail(boolean z16, int i3, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), card);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onSetProfileDetail success=%s resultCode=%s mDelayRemoveCardObserver=%s", Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(FriendProfileMoreInfoActivity.this.f175973f1)));
            }
            if (FriendProfileMoreInfoActivity.this.E1) {
                FriendProfileMoreInfoActivity.this.w4(z16, card);
                return;
            }
            if (!z16 || i3 != 0) {
                if (!z16 && i3 == 34) {
                    return;
                } else {
                    com.tencent.mobileqq.activity.editservice.g.t(i3);
                }
            }
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
            if (friendProfileMoreInfoActivity.f175973f1) {
                friendProfileMoreInfoActivity.removeObserver(friendProfileMoreInfoActivity.H1);
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity2 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity2.removeObserver(friendProfileMoreInfoActivity2.I1);
                FriendProfileMoreInfoActivity.this.f175973f1 = false;
            }
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity3 = FriendProfileMoreInfoActivity.this;
            if (!friendProfileMoreInfoActivity3.f175969d1 || friendProfileMoreInfoActivity3.f175967c1 == null) {
                friendProfileMoreInfoActivity3.z4(card, true);
                return;
            }
            if (z16) {
                ReportController.o(friendProfileMoreInfoActivity3.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity4 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity4.U0.f176048h) {
                    String obj = friendProfileMoreInfoActivity4.f175980j0.getText().toString();
                    if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj.trim())) {
                        ReportController.o(FriendProfileMoreInfoActivity.this.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
                    }
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity5 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity5.f175995q1) {
                    ReportController.o(friendProfileMoreInfoActivity5.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity6 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity6.f175997r1) {
                    ReportController.o(friendProfileMoreInfoActivity6.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity7 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity7.f175999s1) {
                    ReportController.o(friendProfileMoreInfoActivity7.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity8 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity8.V0.f176048h) {
                    ReportController.o(friendProfileMoreInfoActivity8.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity9 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity9.W0.f176048h) {
                    ReportController.o(friendProfileMoreInfoActivity9.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity10 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity10.f176001t1) {
                    ReportController.o(friendProfileMoreInfoActivity10.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity11 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity11.f176003u1) {
                    ReportController.o(friendProfileMoreInfoActivity11.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity12 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity12.X0.f176048h) {
                    String obj2 = friendProfileMoreInfoActivity12.J0.getText().toString();
                    Matcher matcher = SearchBaseActivity.f180755n0.matcher(obj2);
                    if (TextUtils.isEmpty(obj2) || matcher.matches()) {
                        ReportController.o(FriendProfileMoreInfoActivity.this.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
                    }
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity13 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity13.f176005v1) {
                    ReportController.o(friendProfileMoreInfoActivity13.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity14 = FriendProfileMoreInfoActivity.this;
                if (friendProfileMoreInfoActivity14.f176011y1 == null) {
                    friendProfileMoreInfoActivity14.f176011y1 = new Bundle();
                }
            }
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity15 = FriendProfileMoreInfoActivity.this;
            friendProfileMoreInfoActivity15.f175969d1 = false;
            friendProfileMoreInfoActivity15.S3();
        }
    }

    /* loaded from: classes9.dex */
    class k extends com.tencent.mobileqq.businessCard.a {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void c(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else if (z16) {
                FriendProfileMoreInfoActivity.this.T0 = ((BusinessCardManager) FriendProfileMoreInfoActivity.this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).i(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    class l extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        /* loaded from: classes9.dex */
        class a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = eVar.b().get(0);
                    if (cVar.r() != null) {
                        FriendProfileMoreInfoActivity.this.T0.cardName = cVar.r();
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        class b implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = eVar.b().get(0);
                    if (cVar.r() != null) {
                        FriendProfileMoreInfoActivity.this.T0.cardName = cVar.r();
                    }
                }
            }
        }

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetComment(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
                return;
            }
            if (FriendProfileMoreInfoActivity.this.S0.uin.equals(str) && ProfilePAUtils.isPaTypeFriend(FriendProfileMoreInfoActivity.this.S0)) {
                if (z16) {
                    FriendProfileMoreInfoActivity.this.T0.cardName = str2;
                } else {
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(FriendProfileMoreInfoActivity.this.S0.uin), "FriendProfileMoreInfoActivity", new b());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17) {
                AllInOne allInOne = FriendProfileMoreInfoActivity.this.S0;
                if (allInOne.uin != null && ProfilePAUtils.isPaTypeFriend(allInOne)) {
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(FriendProfileMoreInfoActivity.this.S0.uin), "FriendProfileMoreInfoActivity", new a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    class m implements ConditionSearchManager.c {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
            int i16 = friendProfileMoreInfoActivity.f175965b1;
            if (i16 == 1 || i16 == 2) {
                if (!z16) {
                    friendProfileMoreInfoActivity.M3();
                    QQToast.makeText(FriendProfileMoreInfoActivity.this, R.string.a8c, 0).show(FriendProfileMoreInfoActivity.this.getTitleBarHeight());
                    return;
                }
                if (i3 == 2) {
                    friendProfileMoreInfoActivity.M3();
                    FriendProfileMoreInfoActivity friendProfileMoreInfoActivity2 = FriendProfileMoreInfoActivity.this;
                    friendProfileMoreInfoActivity2.M4(friendProfileMoreInfoActivity2.f175965b1);
                }
                FriendProfileMoreInfoActivity.this.f175965b1 = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    class n extends com.tencent.mobileqq.profile.PersonalityLabel.c {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
        public void onGetPersonalityLabel(boolean z16, String str, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, byte[] bArr, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, profilePersonalityLabelInfo, bArr, Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", Boolean.valueOf(z16), str, Integer.valueOf(i3)));
            }
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
            friendProfileMoreInfoActivity.V4(friendProfileMoreInfoActivity.T3(profilePersonalityLabelInfo));
        }
    }

    /* loaded from: classes9.dex */
    class o extends PhotoWallObserver {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
        protected void onDelQZonePhotoWall(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onDelQZonePhotoWall isSuc=%s uin=%s", Boolean.valueOf(z16), str));
            }
            FriendProfileMoreInfoActivity.this.U3();
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
        protected void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar, str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onGetQZonePhotoWall isSuc=%s uin=%s", Boolean.valueOf(z16), str2));
            }
            FriendProfileMoreInfoActivity.this.d5(mobile_sub_get_photo_wall_rspVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.o(FriendProfileMoreInfoActivity.this.app, "dc00898", "", "", "0X800A0D9", "0X800A0D9", 0, 0, "", "", "", "");
            if (NetworkUtil.isNetSupport(FriendProfileMoreInfoActivity.this)) {
                FriendProfileMoreInfoActivity.this.K3();
            }
            FriendProfileMoreInfoActivity.this.b4("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class q implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f176045d;

        /* renamed from: e, reason: collision with root package name */
        private EditText f176046e;

        /* renamed from: f, reason: collision with root package name */
        boolean f176047f;

        /* renamed from: h, reason: collision with root package name */
        boolean f176048h;

        /* renamed from: i, reason: collision with root package name */
        private int f176049i;

        /* renamed from: m, reason: collision with root package name */
        private int f176050m;

        public q(int i3, EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FriendProfileMoreInfoActivity.this, Integer.valueOf(i3), editText);
                return;
            }
            this.f176047f = false;
            this.f176048h = false;
            this.f176045d = i3;
            this.f176046e = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = this.f176046e.getText().toString();
            if (obj.getBytes().length > this.f176045d) {
                try {
                    String substring = obj.substring(0, this.f176049i);
                    String substring2 = obj.substring(this.f176049i + this.f176050m, obj.length());
                    int i3 = this.f176049i;
                    String substring3 = obj.substring(i3, this.f176050m + i3);
                    if (substring.getBytes().length + substring2.getBytes().length <= this.f176045d) {
                        while (obj.getBytes().length > this.f176045d && substring3.length() > 0) {
                            substring3 = substring3.substring(0, substring3.length() - 1);
                            obj = substring + substring3 + substring2;
                        }
                        this.f176046e.setText(obj);
                        this.f176046e.setSelection(substring.length() + substring3.length());
                    }
                } catch (Exception unused) {
                }
            }
            if (this.f176047f) {
                this.f176047f = false;
            } else {
                this.f176048h = true;
            }
            EditText editText = this.f176046e;
            FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
            if (editText == friendProfileMoreInfoActivity.f175980j0) {
                FormSimpleItem formSimpleItem = friendProfileMoreInfoActivity.f175978i0;
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity2 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.X4(formSimpleItem, friendProfileMoreInfoActivity2.f175980j0, friendProfileMoreInfoActivity2.getString(R.string.d2_), obj);
                FriendProfileMoreInfoActivity.this.J3(obj);
                return;
            }
            if (editText == friendProfileMoreInfoActivity.A0) {
                FormSimpleItem formSimpleItem2 = friendProfileMoreInfoActivity.f176012z0;
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity3 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.X4(formSimpleItem2, friendProfileMoreInfoActivity3.A0, friendProfileMoreInfoActivity3.getString(R.string.f171191d11), obj);
            } else if (editText == friendProfileMoreInfoActivity.C0) {
                FormSimpleItem formSimpleItem3 = friendProfileMoreInfoActivity.B0;
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity4 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.X4(formSimpleItem3, friendProfileMoreInfoActivity4.C0, friendProfileMoreInfoActivity4.getString(R.string.f171198d30), obj);
            } else if (editText == friendProfileMoreInfoActivity.J0) {
                FormSimpleItem formSimpleItem4 = friendProfileMoreInfoActivity.I0;
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity5 = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.X4(formSimpleItem4, friendProfileMoreInfoActivity5.J0, friendProfileMoreInfoActivity5.getString(R.string.d1x), obj);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                this.f176049i = i3;
                this.f176050m = i17;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    public FriendProfileMoreInfoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175963a1 = null;
        this.f175965b1 = 0;
        this.f175967c1 = null;
        this.f175969d1 = false;
        this.f175971e1 = false;
        this.f175973f1 = false;
        this.f175995q1 = false;
        this.f175997r1 = false;
        this.f175999s1 = false;
        this.f176001t1 = false;
        this.f176003u1 = false;
        this.f176005v1 = false;
        this.A1 = false;
        this.B1 = "";
        this.C1 = "";
        this.D1 = "";
        this.E1 = false;
        this.F1 = new int[]{41611, 41610, 41607, 41614};
        this.G1 = new HashMap();
        this.H1 = new g();
        this.I1 = new j();
        this.J1 = new k();
        this.K1 = new l();
        this.L1 = new m();
        this.M1 = new n();
        this.N1 = new o();
        this.O1 = new AnonymousClass21();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B4(int i3) {
        ReportController.o(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, i3 + "", "", "", "");
    }

    private void C4() {
        this.Y0.U2(this.app.getLongAccountUin());
    }

    private Animator D4(List<View> list) {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(Color.parseColor("#E6E5F5FF"), Color.parseColor("#FFFFFF"));
        ofArgb.setDuration(100L);
        ofArgb.addUpdateListener(new e(list));
        return ofArgb;
    }

    private boolean E4() {
        boolean z16;
        String[] strArr;
        boolean z17;
        boolean z18;
        Bundle bundle = new Bundle();
        if (this.U0.f176048h) {
            String obj = this.f175980j0.getText().toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj.trim())) {
                I4(obj.trim());
            }
        }
        boolean z19 = true;
        if (this.G1.containsKey(41611) && a4(41611) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f175995q1 && !z16) {
            bundle.putByte("sex", this.f175979i1);
        }
        if (this.f175997r1) {
            if (this.G1.containsKey(41610) && a4(41610) == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (this.G1.containsKey(41607) && a4(41607) == 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18 || !z17) {
                bundle.putInt("birthday", this.f175981j1);
                bundle.putInt("age", this.f175983k1);
                bundle.putInt(IProfileProtocolConst.KEY_CONSTELLATION, this.f175985l1);
            }
        }
        if (this.f175999s1) {
            bundle.putInt(IProfileProtocolConst.KEY_PROFESSION, this.f175987m1);
        }
        if (this.V0.f176048h) {
            bundle.putString(IProfileProtocolConst.KEY_COMPANY, this.A0.getText().toString());
        }
        if (this.W0.f176048h) {
            bundle.putString(IProfileProtocolConst.KEY_COLLEGE, this.C0.getText().toString());
        }
        if (!this.G1.containsKey(41614) || a4(41614) != 2) {
            z19 = false;
        }
        if (this.f176001t1 && !z19) {
            String charSequence = this.E0.getText().toString();
            bundle.putStringArray("location", this.f175989n1);
            bundle.putString(IProfileProtocolConst.KEY_LOCATION_DESC, charSequence);
            try {
                strArr = this.Z0.N(this.f175989n1);
            } catch (Exception unused) {
                strArr = null;
            }
            bundle.putStringArray(IProfileProtocolConst.KEY_LOCATION_NAME, strArr);
        }
        if (this.f176003u1) {
            String charSequence2 = this.H0.getText().toString();
            bundle.putStringArray(IProfileProtocolConst.KEY_HOMETOWN, this.f175991o1);
            bundle.putString(IProfileProtocolConst.KEY_HOMETOWN_DESC, charSequence2);
        }
        if (this.X0.f176048h) {
            String obj2 = this.J0.getText().toString();
            Matcher matcher = SearchBaseActivity.f180755n0.matcher(obj2);
            if (TextUtils.isEmpty(obj2) || matcher.matches()) {
                bundle.putString("email", obj2);
            }
        }
        if (this.f176005v1) {
            bundle.putString(IProfileProtocolConst.KEY_PERSONAL_NOTE, this.f175993p1);
        }
        return F4(bundle, R.string.f171139ci4, 0);
    }

    private boolean F4(Bundle bundle, int i3, int i16) {
        if (!NetworkUtil.isNetSupport(this)) {
            notifyUser(i3, i16);
        } else if (bundle != null && !bundle.isEmpty()) {
            this.Y0.g5(bundle);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G4(ArrayList<com.tencent.mobileqq.profile.i> arrayList) {
        LinearLayout linearLayout;
        if (arrayList != null && this.M0.getVisibility() == 0 && (linearLayout = this.N0) != null) {
            linearLayout.removeAllViews();
            if (arrayList.size() > 0) {
                Iterator<com.tencent.mobileqq.profile.i> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.profile.i next = it.next();
                    if (!TextUtils.isEmpty(next.f260185d)) {
                        View inflate = View.inflate(this, R.layout.azy, null);
                        TextView textView = (TextView) inflate.findViewById(R.id.ihm);
                        if (next.f260193l) {
                            textView.setText(next.f260185d);
                            Drawable drawable = getResources().getDrawable(R.drawable.ne6);
                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            textView.setCompoundDrawables(null, null, drawable, null);
                            textView.setCompoundDrawablePadding(BaseAIOUtils.f(4.5f, textView.getResources()));
                        } else {
                            textView.setText(next.f260185d);
                        }
                        TextView textView2 = (TextView) inflate.findViewById(R.id.f165059bu0);
                        String b16 = next.b();
                        if (TextUtils.isEmpty(b16)) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setText(b16);
                        }
                        TextView textView3 = (TextView) inflate.findViewById(R.id.ur6);
                        if (next.f260192k) {
                            textView3.setVisibility(0);
                        } else {
                            textView3.setVisibility(8);
                        }
                        inflate.setOnClickListener(this);
                        inflate.setTag(next);
                        N4(inflate);
                        this.N0.addView(inflate);
                    }
                }
            } else {
                Card q16 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.app.getCurrentAccountUin());
                if (q16 != null && !TextUtils.isEmpty(q16.strSchool)) {
                    View inflate2 = View.inflate(this, R.layout.azy, null);
                    ((TextView) inflate2.findViewById(R.id.ihm)).setText(q16.strSchool);
                    ((TextView) inflate2.findViewById(R.id.f165059bu0)).setVisibility(8);
                    inflate2.setOnClickListener(this);
                    inflate2.setTag(q16);
                    N4(inflate2);
                    this.N0.addView(inflate2);
                }
            }
            if (this.N0.getChildCount() < 2) {
                if (this.N0.getChildCount() == 0) {
                    this.O0.setBgType(1);
                } else if (this.N0.getChildCount() == 1) {
                    this.O0.setBgType(2);
                }
                this.O0.setVisibility(0);
                this.P0.setVisibility(0);
                this.Q0.findViewById(R.id.ihh).setVisibility(0);
                this.R0.findViewById(R.id.ihd).setVisibility(8);
                return;
            }
            this.O0.findViewById(R.id.ihf).setVisibility(8);
            this.P0.findViewById(R.id.ihj).setVisibility(8);
            this.Q0.findViewById(R.id.ihh).setVisibility(8);
            this.R0.findViewById(R.id.ihd).setVisibility(0);
        }
    }

    private void H3() {
        ProfileCardFeatureSwitch profileCardFeatureSwitch = ProfileCardFeatureSwitch.INSTANCE;
        int i3 = 0;
        if (profileCardFeatureSwitch.isOwnerProfileCardEmptyItemFoldEnable()) {
            this.f175994q0.setVisibility(0);
            this.f176002u0.setVisibility(0);
            this.f175998s0.setVisibility(0);
        } else {
            this.f175994q0.setVisibility(8);
            this.f176002u0.setVisibility(8);
            this.f175998s0.setVisibility(8);
        }
        FormSimpleItem formSimpleItem = this.f176004v0;
        if (!profileCardFeatureSwitch.isMusicBoxEmptyItemFoldEnable()) {
            i3 = 8;
        }
        formSimpleItem.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H4(List<View> list, boolean z16) {
        for (View view : list) {
            if ((view instanceof FormSimpleItem) && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue == 1 || intValue == 2) {
                    ((FormSimpleItem) view).setPressed(z16);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3(Card card) {
        if (card != null && !this.A1 && ProfileCardUtil.O(card, this.app)) {
            if (QLog.isColorLevel()) {
                QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
            }
            DialogUtil.createCustomDialog(this, HardCodeUtil.qqStr(R.string.f172022msf), HardCodeUtil.qqStr(R.string.f172024mt0), (String) null, R.string.d0w, R.string.d0x, new p(), new a()).show();
            ProfileCardUtil.u0(card, this.app);
            ReportController.o(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
        }
    }

    private void I4(String str) {
        com.tencent.qqnt.kernel.api.y profileService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e("FriendProfileMoreInfoActivity", 1, "setSelfNick service is null");
        } else {
            this.f175971e1 = true;
            profileService.l0(str, new IOperateCallback() { // from class: com.tencent.mobileqq.activity.cj
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    FriendProfileMoreInfoActivity.this.r4(i3, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3(String str) {
        if (AppSetting.f99565y && !TextUtils.isEmpty(str)) {
            ViewCompat.setAccessibilityDelegate(this.f175980j0, new i());
        }
    }

    private void J4() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.addButton(R.string.d0t, 0);
        actionSheet.addButton(R.string.d0v, 0);
        actionSheet.addButton(R.string.d0u, 0);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new b(actionSheet));
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3() {
        Bundle bundle = new Bundle();
        bundle.putString(IProfileProtocolConst.KEY_COLLEGE, "");
        if (F4(bundle, R.string.f171139ci4, 0)) {
            this.E1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
    
        if (r2 == r6.length) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean L3(String[] strArr, String[] strArr2) {
        boolean z16 = true;
        if (strArr != strArr2) {
            try {
                if (strArr.length == strArr2.length) {
                    int i3 = 0;
                    while (i3 < strArr.length && strArr[i3].equals(strArr2[i3])) {
                        i3++;
                    }
                }
                z16 = false;
            } catch (Exception unused) {
                return false;
            }
        }
        return z16;
    }

    private void L4(int i3, String str) {
        this.f175965b1 = i3;
        if (this.f175963a1 == null) {
            this.f175963a1 = new QQProgressDialog(this, getTitleBarHeight());
        }
        this.f175963a1.setMessage(str);
        this.f175963a1.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M3() {
        QQProgressDialog qQProgressDialog = this.f175963a1;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f175963a1.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M4(int i3) {
        String[] strArr;
        int i16;
        this.Z0.h(this);
        int j3 = this.Z0.j();
        int i17 = 2;
        if (j3 != 0) {
            int h06 = this.Z0.h0(j3, true);
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + h06);
            }
            if (h06 == 2) {
                QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
                return;
            } else if (h06 == 0) {
                L4(i3, getString(R.string.a8f));
                this.Z0.g(this.L1);
                return;
            } else {
                L4(i3, getString(R.string.a8f));
                this.f176007w1.sendEmptyMessageDelayed(1000, 20000L);
                return;
            }
        }
        if (i3 != 1) {
            i17 = 3;
        }
        if (i3 == 1) {
            strArr = this.f175989n1;
        } else {
            strArr = this.f175991o1;
        }
        if (strArr == null || strArr.length != 4) {
            strArr = new String[]{"0", "0", "0", "0"};
        }
        Intent intent = new Intent(this, (Class<?>) LocationSelectActivity.class);
        intent.putExtra("param_is_popup", false);
        intent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, i17);
        intent.putExtra(IProfileCardConst.PARAM_LOCATION_CODE, strArr);
        intent.putExtra("param_location_param", this.Z0.Q(strArr));
        if (i3 == 1) {
            i16 = 1005;
        } else {
            i16 = 1006;
        }
        startActivityForResult(intent, i16);
    }

    private void N4(View view) {
        int i3;
        LinearLayout linearLayout = this.N0;
        if (linearLayout != null && (view instanceof FormSimpleItem)) {
            FormSimpleItem formSimpleItem = (FormSimpleItem) view;
            if (linearLayout.getChildCount() == 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            formSimpleItem.setBgType(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3() {
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra(IProfileCardConst.PROFILE_JUMP_WITH_BUBBLE, false)) {
            return;
        }
        Q3(X3(intent));
    }

    private void Q3(List<View> list) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(D4(list)).after(3000L).after(g4(list));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q4() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str = ProfileCardBubbleUtil.ENTER_EDIT_SP_NAME + peekAppRuntime.getCurrentAccountUin();
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations");
        QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations").edit().putLong("time", System.currentTimeMillis()).commit();
        QLog.d("FriendProfileMoreInfoActivity", 1, "[updateEditTimeSp] update sp success");
    }

    private void R3(Object obj, String str) {
        if (obj == null) {
            return;
        }
        VideoReport.setElementId(obj, str);
        VideoReport.setElementClickPolicy(obj, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3() {
        QQProgressDialog qQProgressDialog;
        if (!this.f175969d1 && !this.f175971e1 && (qQProgressDialog = this.f175967c1) != null) {
            qQProgressDialog.dismiss();
            if (!isFinishing()) {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.personalityLabelInfos != null) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<PersonalityLabelInfo> it = profilePersonalityLabelInfo.personalityLabelInfos.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().text);
                if (it.hasNext()) {
                    sb5.append("\u3001");
                }
            }
            return sb5.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U3() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            ((PhotoWallHandler) qQAppInterface.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.app.getCurrentAccountUin(), "");
        }
    }

    private String V3() {
        return String.format("%s-1-1", Integer.valueOf(Calendar.getInstance().get(1) - 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V4(String str) {
        if (TextUtils.isEmpty(str)) {
            h5(this.f175996r0, getString(R.string.f175632z3), true);
        } else {
            h5(this.f175996r0, str, false);
        }
    }

    private Map<String, String> W3() {
        HashMap hashMap = new HashMap();
        hashMap.put("profile_version", "1");
        return hashMap;
    }

    private List<View> X3(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent == null) {
            return arrayList;
        }
        int intExtra = intent.getIntExtra(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, 0);
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra == 3) {
                    arrayList.add(this.f175998s0);
                    arrayList.add(this.f175994q0);
                }
            } else {
                arrayList.add(this.f175994q0);
            }
        } else {
            arrayList.add(this.f175998s0);
        }
        return arrayList;
    }

    private int a4(int i3) {
        if (this.G1.containsKey(Integer.valueOf(i3))) {
            return this.G1.get(Integer.valueOf(i3)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b4(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileMoreInfoActivity", 2, "gotoSchoolWeb " + str);
        }
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("hide_more_button", true);
        startActivityForResult(intent, 1012);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4() {
        if (i4()) {
            if (this.f175967c1 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.f175967c1 = qQProgressDialog;
                qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.msd));
            }
            if (!this.f175969d1 && !this.f175971e1) {
                boolean E4 = E4();
                this.f175969d1 = E4;
                if (!E4 && !this.f175971e1) {
                    if (!isFinishing()) {
                        finish();
                        return;
                    }
                    return;
                }
                this.f175967c1.show();
                return;
            }
            this.f175967c1.dismiss();
            this.f175973f1 = true;
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        if (!isFinishing()) {
            finish();
        }
    }

    private void d4() {
        if (this.f175975g1 == null) {
            return;
        }
        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileLocationSelector(this, this.f175975g1, a4(41614), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d5(mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        ArrayList<PhotoWall> arrayList;
        if (mobile_sub_get_photo_wall_rspVar != null && (arrayList = mobile_sub_get_photo_wall_rspVar.vecUrls) != null && arrayList.size() != 0) {
            h5(this.f176000t0, String.format("%d\u5f20", Integer.valueOf(mobile_sub_get_photo_wall_rspVar.vecUrls.size())), false);
        } else {
            h5(this.f176000t0, getString(R.string.f175632z3), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e4() {
        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileGenderSelector(this, this.f175979i1, a4(41611), new h());
    }

    private void f4() {
        if (this.S0 == null) {
            return;
        }
        a33.b.e(this, this.app, 0, "signature_ziliaoka", 1002);
    }

    private Animator g4(List<View> list) {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(Color.parseColor("#FFFFFF"), Color.parseColor("#E6E5F5FF"));
        ofArgb.setDuration(100L);
        ofArgb.addUpdateListener(new d(list));
        return ofArgb;
    }

    private void h4() {
        this.M0 = findViewById(R.id.f165061bu2);
        this.N0 = (LinearLayout) findViewById(R.id.f164039i6);
        FormSimpleItem formSimpleItem = (FormSimpleItem) findViewById(R.id.ihf);
        this.O0 = formSimpleItem;
        formSimpleItem.setOnClickListener(this);
        FormSimpleItem formSimpleItem2 = (FormSimpleItem) findViewById(R.id.ihj);
        this.P0 = formSimpleItem2;
        formSimpleItem2.setOnClickListener(this);
        FormSimpleItem formSimpleItem3 = (FormSimpleItem) findViewById(R.id.ihh);
        this.Q0 = formSimpleItem3;
        formSimpleItem3.setOnClickListener(this);
        FormSimpleItem formSimpleItem4 = (FormSimpleItem) findViewById(R.id.ihd);
        this.R0 = formSimpleItem4;
        formSimpleItem4.setOnClickListener(this);
    }

    private boolean i4() {
        if (!this.U0.f176048h && !this.V0.f176048h && !this.W0.f176048h && !this.X0.f176048h && !this.f175995q1 && !this.f175997r1 && !this.f175999s1 && !this.f176001t1 && !this.f176003u1 && !this.f176005v1) {
            return false;
        }
        return true;
    }

    private void initDtReport() {
        if (this.f175962a0 == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.f175962a0, "pg_user_profile_edit");
        VideoReport.setPageParams(this.f175962a0, new PageParams(W3()));
        VideoReport.setPageContentId(this.f175962a0, FriendProfileMoreInfoActivity.class.getName());
        R3(this.f175994q0, "em_user_profile_edit_tag");
        R3(this.f175998s0, "em_user_profile_edit_picture");
        R3(this.f176002u0, "em_user_profile_edit_question");
        R3(this.f176004v0, "em_user_profile_edit_musicbox");
    }

    private void initViews() {
        this.f175964b0 = (BounceScrollView) findViewById(R.id.m78);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById(R.id.f28170i8);
        qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.buf));
        qUISecNavBar.R(this);
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new c());
        this.f175966c0 = (LinearLayout) findViewById(R.id.b9w);
        FormSimpleItem formSimpleItem = (FormSimpleItem) findViewById(R.id.a39);
        this.f175968d0 = formSimpleItem;
        formSimpleItem.setContentDescription(getString(R.string.b2q));
        this.f175968d0.setOnClickListener(this);
        FormSimpleItem formSimpleItem2 = (FormSimpleItem) findViewById(R.id.ivn);
        this.f175970e0 = formSimpleItem2;
        formSimpleItem2.setOnClickListener(this);
        this.f175972f0 = (TextView) findViewById(R.id.ivp);
        f5(null);
        FormSimpleItem formSimpleItem3 = (FormSimpleItem) findViewById(R.id.jzz);
        this.f175974g0 = formSimpleItem3;
        if (this.A1) {
            formSimpleItem3.setVisibility(0);
            this.f175976h0 = (ColorNickTextView) findViewById(R.id.f167015k02);
            TroopInfo k3 = ((TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.B1);
            if (k3 != null) {
                if (k3.isTroopAdmin(this.app.getCurrentAccountUin()) || k3.isTroopOwner(this.app.getCurrentAccountUin()) || TextUtils.equals(this.C1, this.app.getCurrentAccountUin())) {
                    this.f175974g0.setClickable(true);
                    this.f175974g0.setOnClickListener(this);
                    this.f175974g0.h(true);
                }
            } else {
                this.f175974g0.setClickable(false);
                this.f175974g0.setOnClickListener(null);
                this.f175974g0.h(false);
            }
            i5();
        }
        this.f175978i0 = (FormSimpleItem) findViewById(R.id.f9l);
        if (this.f175974g0.getVisibility() == 0) {
            this.f175978i0.setBgType(2);
        }
        this.f175978i0.setClickable(false);
        EditText editText = (EditText) findViewById(R.id.f9k);
        this.f175980j0 = editText;
        editText.setOnFocusChangeListener(this);
        q qVar = new q(100, this.f175980j0);
        this.U0 = qVar;
        this.f175980j0.addTextChangedListener(qVar);
        this.f175980j0.setFilters(new InputFilter[]{new ed(36)});
        this.U0.f176047f = true;
        Z4(null);
        FormSimpleItem formSimpleItem4 = (FormSimpleItem) findViewById(R.id.iqg);
        this.f175982k0 = formSimpleItem4;
        formSimpleItem4.setOnClickListener(this);
        this.f175984l0 = (TextView) findViewById(R.id.iqh);
        e5(-1, false);
        FormSimpleItem formSimpleItem5 = (FormSimpleItem) findViewById(R.id.a_y);
        this.f175988n0 = formSimpleItem5;
        formSimpleItem5.setOnClickListener(this);
        this.f175990o0 = (TextView) findViewById(R.id.a_z);
        O4(0, 0, 0);
        FormSimpleItem formSimpleItem6 = (FormSimpleItem) findViewById(R.id.xpo);
        this.f175994q0 = formSimpleItem6;
        formSimpleItem6.setOnClickListener(this);
        this.f175994q0.setTag(1);
        this.f175996r0 = (TextView) findViewById(R.id.xpp);
        V4(null);
        FormSimpleItem formSimpleItem7 = (FormSimpleItem) findViewById(R.id.f82704hl);
        this.f175998s0 = formSimpleItem7;
        formSimpleItem7.setOnClickListener(this);
        this.f175998s0.setTag(2);
        this.f176000t0 = (TextView) findViewById(R.id.f82714hm);
        this.f175998s0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    FriendProfileMoreInfoActivity.this.P3();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 100L);
        FormSimpleItem formSimpleItem8 = (FormSimpleItem) findViewById(R.id.f164338sq1);
        this.f176002u0 = formSimpleItem8;
        formSimpleItem8.setOnClickListener(this);
        FormSimpleItem formSimpleItem9 = (FormSimpleItem) findViewById(R.id.f166355zk0);
        this.f176004v0 = formSimpleItem9;
        formSimpleItem9.setOnClickListener(this);
        FormSimpleItem formSimpleItem10 = (FormSimpleItem) findViewById(R.id.fzu);
        this.f176006w0 = formSimpleItem10;
        formSimpleItem10.setOnClickListener(this);
        this.f176008x0 = (TextView) findViewById(R.id.fzt);
        this.f176010y0 = (TextView) findViewById(R.id.fzv);
        b5(-1);
        FormSimpleItem formSimpleItem11 = (FormSimpleItem) findViewById(R.id.b6j);
        this.f176012z0 = formSimpleItem11;
        formSimpleItem11.setClickable(false);
        EditText editText2 = (EditText) findViewById(R.id.b6i);
        this.A0 = editText2;
        editText2.setOnFocusChangeListener(this);
        q qVar2 = new q(120, this.A0);
        this.V0 = qVar2;
        this.A0.addTextChangedListener(qVar2);
        this.V0.f176047f = true;
        P4(null);
        FormSimpleItem formSimpleItem12 = (FormSimpleItem) findViewById(R.id.ihl);
        this.B0 = formSimpleItem12;
        formSimpleItem12.setClickable(false);
        EditText editText3 = (EditText) findViewById(R.id.ihk);
        this.C0 = editText3;
        editText3.setOnFocusChangeListener(this);
        q qVar3 = new q(40, this.C0);
        this.W0 = qVar3;
        this.C0.addTextChangedListener(qVar3);
        this.W0.f176047f = true;
        c5(null);
        FormSimpleItem formSimpleItem13 = (FormSimpleItem) findViewById(R.id.egi);
        this.D0 = formSimpleItem13;
        formSimpleItem13.setOnClickListener(this);
        this.E0 = (TextView) findViewById(R.id.ego);
        Y4(null);
        FormSimpleItem formSimpleItem14 = (FormSimpleItem) findViewById(R.id.d6w);
        this.G0 = formSimpleItem14;
        formSimpleItem14.setOnClickListener(this);
        this.H0 = (TextView) findViewById(R.id.d6x);
        U4(null);
        FormSimpleItem formSimpleItem15 = (FormSimpleItem) findViewById(R.id.buf);
        this.I0 = formSimpleItem15;
        formSimpleItem15.setClickable(false);
        EditText editText4 = (EditText) findViewById(R.id.bue);
        this.J0 = editText4;
        editText4.setOnFocusChangeListener(this);
        q qVar4 = new q(50, this.J0);
        this.X0 = qVar4;
        this.J0.addTextChangedListener(qVar4);
        this.X0.f176047f = true;
        S4(null);
        FormSimpleItem formSimpleItem16 = (FormSimpleItem) findViewById(R.id.flw);
        this.K0 = formSimpleItem16;
        formSimpleItem16.setOnClickListener(this);
        this.L0 = (TextView) findViewById(R.id.flx);
        a5(null);
        h4();
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (this.A1 && troopManager.V(this.B1)) {
            this.f175970e0.setVisibility(8);
            this.f176006w0.setVisibility(8);
            this.f176012z0.setVisibility(8);
            this.B0.setVisibility(8);
            this.G0.setVisibility(8);
            this.I0.setVisibility(8);
            this.K0.setVisibility(8);
        }
        if (!this.A1) {
            this.B0.setVisibility(8);
            this.M0.setVisibility(0);
        }
        if (QQTheme.isNowThemeIsNight()) {
            this.f175964b0.setBackgroundColor(-16777216);
        }
        H3();
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.n(this.f175966c0, false);
            AccessibilityUtil.n(this.f175964b0, false);
        }
    }

    private void k4() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            return;
        }
        AnonymousViewHelper.jumpToQuestionListAndAnswer(this, qQAppInterface.getCurrentAccountUin(), 1);
    }

    private void l4() {
        if (this.app == null) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) PersonalityLabelGalleryActivity.class);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
        intent.putExtra("uin", this.app.getCurrentAccountUin());
        startActivityForResult(intent, 1029);
    }

    private void m4() {
        QQAppInterface qQAppInterface;
        if (getActivity() != null && !getActivity().isFinishing() && (qQAppInterface = this.app) != null) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).jump2MusicBoxPage(getActivity(), qQAppInterface.getCurrentAccountUin());
        }
    }

    private void n4() {
        String str = IProfileCardConst.URL_PHOTO_WALL;
        Intent intent = new Intent();
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", str);
        RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTE_BROWSER, 100);
    }

    private void notifyUser(int i3, int i16) {
        new QQToastNotifier(this).notifyUser(i3, getTitleBarHeight(), 0, i16);
    }

    private void o4(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.f175964b0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.14
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                                    friendProfileMoreInfoActivity.f175964b0.scrollTo(0, friendProfileMoreInfoActivity.M0.getTop());
                                }
                            }
                        });
                        return;
                    }
                    return;
                } else {
                    this.f175964b0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.13
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                                friendProfileMoreInfoActivity.f175964b0.scrollTo(0, friendProfileMoreInfoActivity.D0.getTop());
                            }
                        }
                    });
                    M4(1);
                    return;
                }
            }
            Intent intent = new Intent(this, (Class<?>) AgeSelectionActivity.class);
            intent.putExtra("param_birthday", this.f175981j1);
            startActivityForResult(intent, 1003);
            return;
        }
        this.f175964b0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                FriendProfileMoreInfoActivity friendProfileMoreInfoActivity = FriendProfileMoreInfoActivity.this;
                friendProfileMoreInfoActivity.f175964b0.scrollTo(0, friendProfileMoreInfoActivity.f175982k0.getTop());
                FriendProfileMoreInfoActivity.this.e4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p4(Card card) {
        this.f175975g1 = card;
        for (int i3 : this.F1) {
            int profileSettingStateFromCard = ((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileSettingStateFromCard(i3, this.f175975g1);
            this.G1.put(Integer.valueOf(i3), Integer.valueOf(profileSettingStateFromCard));
            if (profileSettingStateFromCard == 2) {
                if (i3 != 41607) {
                    if (i3 != 41611) {
                        if (i3 == 41614) {
                            h5(this.E0, getResources().getString(R.string.f175922zv), true);
                        }
                    } else {
                        h5(this.f175984l0, getResources().getString(R.string.f175922zv), true);
                    }
                } else {
                    h5(this.f175990o0, getResources().getString(R.string.f175922zv), true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r4(int i3, String str) {
        this.f175971e1 = false;
        S3();
        QLog.d("FriendProfileMoreInfoActivity", 1, String.format("setSelfNick callback, result: %s, errMsg:%s", Integer.valueOf(i3), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s4(TextView textView, int i3, CharSequence charSequence) {
        textView.setTextColor(getResources().getColor(i3));
        textView.setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit t4(TroopMemberNickInfo troopMemberNickInfo) {
        String str;
        String str2 = "";
        if (troopMemberNickInfo == null) {
            str = "";
        } else {
            str = troopMemberNickInfo.getTroopNick();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.C1)) {
            str2 = str;
        }
        SpannableString j3 = new com.tencent.mobileqq.text.c(str2, 16).j();
        this.f175976h0.setText(j3);
        com.tencent.mobileqq.vas.f.q(this.app, this.f175976h0, j3);
        X4(this.f175974g0, this.f175976h0, getString(R.string.eqn), str2);
        return null;
    }

    private void u4() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadAndUpdateProfileData(this.app, new IProfileEditBusinessApi.OnProfileCacheLoadedListener() { // from class: com.tencent.mobileqq.activity.ci
            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnProfileCacheLoadedListener
            public final void onProfileCacheLoaded(Card card) {
                FriendProfileMoreInfoActivity.this.p4(card);
            }
        });
    }

    private void v4(@NonNull Intent intent) {
        short shortExtra = intent.getShortExtra("param_year", (short) 1990);
        byte byteExtra = intent.getByteExtra("param_month", (byte) 1);
        byte byteExtra2 = intent.getByteExtra("param_day", (byte) 1);
        int intExtra = intent.getIntExtra("param_age", 0);
        int intExtra2 = intent.getIntExtra("param_constellation_id", 0);
        int i3 = (shortExtra << 16) | (byteExtra << 8) | byteExtra2;
        int intExtra3 = intent.getIntExtra("param_age_privacy", 0);
        this.G1.remove(41610);
        this.G1.put(41610, Integer.valueOf(intExtra3));
        int intExtra4 = intent.getIntExtra("param_birth_privacy", 0);
        this.G1.remove(41607);
        this.G1.put(41607, Integer.valueOf(intExtra4));
        if (intExtra4 == 2) {
            h5(this.f175990o0, getResources().getString(R.string.f175922zv), true);
        } else {
            h5(this.f175990o0, this.f175992p0, false);
        }
        if (i3 != this.f175981j1) {
            this.f175997r1 = true;
        }
        O4(i3, intExtra, intExtra2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w4(boolean z16, Card card) {
        if (QLog.isColorLevel()) {
            QLog.e("FriendProfileMoreInfoActivity", 2, "onDeleteOldSchoolResult:" + z16);
        }
        this.E1 = false;
        if (z16) {
            G4(((BusinessCardManager) this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).n());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z4(Card card, boolean z16) {
        String str;
        String[] strArr;
        String str2;
        String str3;
        String str4;
        if (card == null) {
            return;
        }
        String str5 = ProfileCardTemplate.QVIP_PROFILE_TEMPLATE_JSON;
        this.f176013z1 = card.strNick;
        f5(RichStatusUtils.INSTANCE.getRichStatus(card));
        String obj = this.f175980j0.getText().toString();
        if (!this.U0.f176048h && (str4 = card.strNick) != null && !str4.equals(obj)) {
            this.U0.f176047f = true;
            Z4(card.strNick);
        } else if (!TextUtils.isEmpty(card.strNick)) {
            this.f175980j0.setHint(card.strNick);
        }
        if (!this.f175995q1) {
            e5(card.shGender, false);
            if (this.G1.containsKey(41611) && a4(41611) == 2) {
                h5(this.f175984l0, getResources().getString(R.string.f175922zv), true);
            }
        }
        if (!this.f175997r1) {
            O4((int) card.lBirthday, card.age, card.constellation);
            if (this.G1.containsKey(41607) && a4(41607) == 2) {
                h5(this.f175990o0, getResources().getString(R.string.f175922zv), true);
            }
        }
        V4(T3((ProfilePersonalityLabelInfo) card.getBusinessInfo(ProfilePersonalityLabelInfo.class)));
        if (!this.f175999s1) {
            b5(card.iProfession);
        }
        y4(card.iProfession);
        String obj2 = this.A0.getText().toString();
        if (!this.V0.f176048h && (str3 = card.strCompany) != null && !str3.equals(obj2)) {
            this.V0.f176047f = true;
            P4(card.strCompany);
        }
        String obj3 = this.C0.getText().toString();
        if (!this.W0.f176048h && (str2 = card.strSchool) != null && !str2.equals(obj3)) {
            this.W0.f176047f = true;
            c5(card.strSchool);
        }
        String[] strArr2 = null;
        if (!this.f176001t1) {
            if (!TextUtils.isEmpty(card.strLocationCodes)) {
                strArr = card.strLocationCodes.split("-");
            } else {
                strArr = null;
            }
            this.f175989n1 = strArr;
            Y4(card.strLocationDesc);
            if (this.G1.containsKey(41614) && a4(41614) == 2) {
                h5(this.E0, getResources().getString(R.string.f175922zv), true);
            }
        }
        if (!this.f176003u1) {
            if (!TextUtils.isEmpty(card.strHometownCodes)) {
                strArr2 = card.strHometownCodes.split("-");
            }
            this.f175991o1 = strArr2;
            U4(card.strHometownDesc);
        }
        String obj4 = this.J0.getText().toString();
        if (!this.X0.f176048h && (str = card.strEmail) != null && !str.equals(obj4)) {
            this.X0.f176047f = true;
            S4(card.strEmail);
        }
        if (!this.f176005v1) {
            a5(card.strPersonalNote);
        }
    }

    void O4(int i3, int i16, int i17) {
        this.f175981j1 = i3;
        this.f175983k1 = i16;
        this.f175985l1 = i17;
        boolean z16 = true;
        if (i3 == 0) {
            this.f175981j1 = ((Calendar.getInstance().get(1) - 18) << 16) | 256 | 1;
            this.f175983k1 = 18;
        }
        String V3 = V3();
        if (i3 != 0) {
            int i18 = ((-65536) & i3) >>> 16;
            int i19 = (65280 & i3) >>> 8;
            int i26 = i3 & 255;
            int a46 = a4(41610);
            int a47 = a4(41607);
            if (a46 == 2 && a47 != 2) {
                V3 = String.format(Locale.getDefault(), "%d-%d", Integer.valueOf(i19), Integer.valueOf(i26));
            } else if (a46 != 2 && a47 != 2) {
                V3 = String.format(Locale.getDefault(), "%d-%d-%d", Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            } else {
                V3 = getResources().getString(R.string.f175922zv);
            }
        }
        this.f175992p0 = V3;
        TextView textView = this.f175990o0;
        if (i3 != 0 && !getResources().getString(R.string.f175922zv).equals(V3)) {
            z16 = false;
        }
        h5(textView, V3, z16);
        FormSimpleItem formSimpleItem = this.f175988n0;
        TextView textView2 = this.f175990o0;
        String string = getString(R.string.d0p);
        if (i3 == 0) {
            V3 = "";
        }
        X4(formSimpleItem, textView2, string, V3);
    }

    void P4(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.A0.setText(str);
        this.A0.setHint(R.string.f171190d10);
        X4(this.f176012z0, this.A0, getString(R.string.f171191d11), str);
    }

    void S4(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.J0.setText(str);
        this.J0.setHint(R.string.d1w);
        X4(this.I0, this.J0, getString(R.string.d1x), str);
    }

    void U4(String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !str.equals(IProfileCardConst.NAME_NO_LIMIT)) {
            z16 = false;
        } else {
            str = getString(R.string.f171196d24);
            z16 = true;
        }
        h5(this.H0, str, z16);
        FormSimpleItem formSimpleItem = this.G0;
        TextView textView = this.H0;
        String string = getString(R.string.f171197d25);
        if (z16) {
            str = "";
        }
        X4(formSimpleItem, textView, string, str);
    }

    void X4(View view, View view2, String str, String str2) {
        String str3 = str + "," + str2 + ",";
        view.setContentDescription(str3);
        if (view2 instanceof EditText) {
            str3 = str + HardCodeUtil.qqStr(R.string.f172027mt4) + str2 + ",";
        }
        view2.setContentDescription(str3);
    }

    void Y4(String str) {
        boolean z16;
        this.F0 = str;
        if (!TextUtils.isEmpty(str) && !str.equals(IProfileCardConst.NAME_NO_LIMIT)) {
            z16 = false;
        } else {
            str = getString(R.string.d27);
            z16 = true;
        }
        h5(this.E0, str, z16);
        FormSimpleItem formSimpleItem = this.D0;
        TextView textView = this.E0;
        String string = getString(R.string.d28);
        if (z16) {
            str = "";
        }
        X4(formSimpleItem, textView, string, str);
    }

    void Z4(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = getString(R.string.d29);
            str = "";
        } else {
            str2 = str;
        }
        this.f175980j0.setText(str);
        this.f175980j0.setHint(str2);
        X4(this.f175978i0, this.f175980j0, getString(R.string.d2_), str);
        J3(str);
    }

    void a5(String str) {
        boolean z16;
        String str2;
        this.f175993p1 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = getString(R.string.d2s);
            z16 = true;
        } else {
            z16 = false;
            str2 = str;
        }
        h5(this.L0, str2, TextUtils.isEmpty(str));
        FormSimpleItem formSimpleItem = this.K0;
        TextView textView = this.L0;
        String string = getString(R.string.d2t);
        if (z16) {
            str2 = "";
        }
        X4(formSimpleItem, textView, string, str2);
    }

    void b5(int i3) {
        if (NearbyProfileUtil.g(i3)) {
            this.f175987m1 = i3;
        } else {
            this.f175987m1 = -1;
        }
        String d16 = NearbyProfileUtil.d(i3);
        if (TextUtils.isEmpty(d16)) {
            this.f175987m1 = -1;
            d16 = getString(R.string.d2x);
        }
        String[] strArr = NearbyProfileUtil.f306397f;
        boolean z16 = true;
        if (i3 < strArr.length - 1 && i3 > 0) {
            Drawable drawable = getResources().getDrawable(NearbyProfileUtil.f306398g[i3]);
            ProfileCardUtils.setNightModeFilterForDrawable(this.app, drawable);
            this.f176008x0.setVisibility(0);
            this.f176008x0.setBackgroundDrawable(drawable);
            this.f176008x0.setText(strArr[i3]);
        } else {
            this.f176008x0.setVisibility(8);
        }
        TextView textView = this.f176010y0;
        if (this.f175987m1 != -1) {
            z16 = false;
        }
        h5(textView, d16, z16);
        View view = this.f176006w0;
        View view2 = this.f176010y0;
        String string = getString(R.string.d2y);
        if (i3 == -1) {
            d16 = "";
        }
        X4(view, view2, string, d16);
    }

    void c5(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.C0.setText(str);
        this.C0.setHint(R.string.d2z);
        X4(this.B0, this.C0, getString(R.string.f171198d30), str);
    }

    @Override // com.tencent.mobileqq.activity.ProfileActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        int intExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1002) {
            if (i16 != 1001) {
                ((IProfileProtocolService) this.app.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
                return;
            }
            return;
        }
        if (i3 == 1003) {
            if (intent != null) {
                v4(intent);
                return;
            }
            return;
        }
        if (i3 == 1004) {
            if (intent != null && (intExtra = intent.getIntExtra("param_id", -1)) != this.f175987m1) {
                this.f175999s1 = true;
                b5(intExtra);
                return;
            }
            return;
        }
        String str = "";
        String str2 = null;
        if (i3 == 1005) {
            if (intent != null) {
                String[] stringArrayExtra = intent.getStringArrayExtra(IProfileCardConst.PARAM_LOCATION_CODE);
                if (!L3(this.f175989n1, stringArrayExtra)) {
                    this.f176001t1 = true;
                    this.f175989n1 = stringArrayExtra;
                    try {
                        str2 = this.Z0.O(stringArrayExtra);
                    } catch (Exception unused) {
                    }
                    if (!TextUtils.isEmpty(str2) && !str2.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                        str = str2;
                    }
                    Y4(str);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1006) {
            if (intent != null) {
                String[] stringArrayExtra2 = intent.getStringArrayExtra(IProfileCardConst.PARAM_LOCATION_CODE);
                if (!L3(this.f175991o1, stringArrayExtra2)) {
                    this.f176003u1 = true;
                    this.f175991o1 = stringArrayExtra2;
                    try {
                        str2 = this.Z0.O(stringArrayExtra2);
                    } catch (Exception unused2) {
                    }
                    if (!TextUtils.isEmpty(str2) && !str2.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                        str = str2;
                    }
                    U4(str);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1007) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("result");
                if (!stringExtra.equals(this.f175993p1)) {
                    this.f176005v1 = true;
                    a5(stringExtra);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1011) {
            i5();
            return;
        }
        if (i3 == 1012) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
            }
            if (this.Y0 != null) {
                String currentAccountUin = this.app.getCurrentAccountUin();
                this.Y0.m3(currentAccountUin, currentAccountUin, 1, 0L, (byte) 1, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
                C4();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = !isInMultiWindow();
        super.doOnCreate(bundle);
        if (!AppSetting.o(this)) {
            setRequestedOrientation(1);
        }
        try {
            super.setContentView(R.layout.azx);
            SoftHideKeyBoardUtil.assistActivity(this);
            this.f176007w1 = new WeakReferenceHandler(Looper.getMainLooper(), this);
            Intent intent = getIntent();
            this.A1 = intent.getBooleanExtra("isTroopMemberCard", false);
            this.B1 = intent.getStringExtra("troopUin");
            this.C1 = intent.getStringExtra("memberUin");
            String stringExtra = intent.getStringExtra("options");
            this.D1 = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.D1);
                    this.B1 = jSONObject.optString("troopUin");
                    this.C1 = jSONObject.optString("memberUin");
                    if (!TextUtils.isEmpty(this.B1) && !TextUtils.isEmpty(this.C1)) {
                        this.A1 = true;
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    QLog.d("FriendProfileMoreInfoActivity", 1, e16.getMessage());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileMoreInfoActivity", 2, String.format("openView options: %s", this.D1));
                }
            }
            this.Y0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            this.Z0 = (ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
            this.f176009x1 = new ProfileConfig(this.app);
            addObserver(this.H1);
            addObserver(this.I1);
            addObserver(this.K1);
            addObserver(this.M1);
            addObserver(this.N1);
            U3();
            this.app.registObserver(this.J1);
            this.Z0.h(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            registerReceiver(this.O1, intentFilter);
            this.f175962a0 = (LinearLayout) super.findViewById(R.id.iew);
            initViews();
            this.S0 = (AllInOne) getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
            this.T0 = (BusinessCard) getIntent().getParcelableExtra("BusinessCard");
            if (this.S0 == null) {
                this.S0 = new AllInOne(this.app.getCurrentUin(), 0);
            }
            if (this.T0 == null) {
                this.T0 = BusinessCardUtils.c(this.app);
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileMoreInfoActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    FriendProfileMoreInfoActivity.this.app.runOnUiThread(new Runnable(((FriendsManager) FriendProfileMoreInfoActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(FriendProfileMoreInfoActivity.this.app.getCurrentAccountUin())) { // from class: com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.8.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Card f176022d;

                        {
                            this.f176022d = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                FriendProfileMoreInfoActivity.this.z4(this.f176022d, false);
                                FriendProfileMoreInfoActivity.this.I3(this.f176022d);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    ((IProfileProtocolService) FriendProfileMoreInfoActivity.this.app.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
                    FriendProfileMoreInfoActivity.Q4();
                }
            }, 5, null, true);
            if (!this.A1) {
                G4(((BusinessCardManager) this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).n());
                C4();
            }
            int intExtra = intent.getIntExtra("profile_jump_to_edit", 0);
            if (intExtra > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileMoreInfoActivity", 2, "jump to edit type " + intExtra);
                }
                o4(intExtra);
            }
            u4();
            ReportController.o(this.app, "dc00898", "", "", "0X800A0D4", "0X800A0D4", 0, 0, "", "", "", "");
            initDtReport();
            return true;
        } catch (Exception e17) {
            e17.printStackTrace();
            finish();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        ProfileConfig profileConfig = this.f176009x1;
        if (profileConfig != null) {
            profileConfig.destroy();
            this.f176009x1 = null;
        }
        ConditionSearchManager conditionSearchManager = this.Z0;
        if (conditionSearchManager != null) {
            conditionSearchManager.o(this);
            this.Z0.S(this.L1);
            this.Z0 = null;
        }
        if (!this.f175973f1) {
            removeObserver(this.H1);
            removeObserver(this.I1);
        }
        removeObserver(this.K1);
        removeObserver(this.M1);
        removeObserver(this.N1);
        this.app.unRegistObserver(this.J1);
        try {
            unregisterReceiver(this.O1);
        } catch (IllegalArgumentException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + e16.getMessage());
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + e17.getMessage());
            }
        }
    }

    void e5(int i3, boolean z16) {
        boolean z17;
        this.f175979i1 = (byte) i3;
        String string = getString(R.string.f171199d31);
        if (i3 == 0) {
            string = getString(R.string.c7_);
        } else if (i3 == 1) {
            string = getString(R.string.b5e);
        }
        this.f175986m0 = string;
        if (z16) {
            g5(this.f175984l0, string, R.color.qui_common_text_link);
        } else {
            TextView textView = this.f175984l0;
            if (i3 != 0 && i3 != 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            h5(textView, string, z17);
        }
        if (i3 != 0 && i3 != 1) {
            string = "";
        }
        X4(this.f175982k0, this.f175984l0, getString(R.string.f171200d32), string);
    }

    void f5(RichStatus richStatus) {
        String qqStr;
        boolean z16;
        if (richStatus != null) {
            qqStr = richStatus.toSpannableString("").toString();
            this.f175977h1 = qqStr;
            z16 = false;
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.mtb);
            this.f175977h1 = "";
            z16 = true;
        }
        h5(this.f175972f0, qqStr, z16);
        X4(this.f175970e0, this.f175972f0, getString(R.string.bxe), qqStr);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = this.f176011y1;
        if (bundle != null) {
            intent.putExtra("result", bundle);
        }
        setResult(-1, intent);
        super.finish();
    }

    void g5(final TextView textView, final CharSequence charSequence, final int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            textView.setTextColor(getResources().getColor(i3));
            textView.setText(charSequence);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.ch
                @Override // java.lang.Runnable
                public final void run() {
                    FriendProfileMoreInfoActivity.this.s4(textView, i3, charSequence);
                }
            });
        }
    }

    void h5(TextView textView, CharSequence charSequence, boolean z16) {
        int i3;
        if (z16) {
            i3 = R.color.qui_common_text_secondary;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        g5(textView, charSequence, i3);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1000 && ((i3 = this.f175965b1) == 1 || i3 == 2)) {
            M3();
            QQToast.makeText(this, R.string.a8c, 0).show(getTitleBarHeight());
        }
        return true;
    }

    void i5() {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(this.B1, this.C1, "FriendProfileMoreInfoActivity", new Function1() { // from class: com.tencent.mobileqq.activity.cg
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t46;
                t46 = FriendProfileMoreInfoActivity.this.t4((TroopMemberNickInfo) obj);
                return t46;
            }
        });
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 100) {
            U3();
        } else if (i3 == 1029 && i16 == -1) {
            V4(intent.getStringExtra(IProfileCardConst.KEY_PERSONALITY_LABEL_GALLERY_RESULT));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            LinearLayout linearLayout = this.f175966c0;
            if (linearLayout != null) {
                linearLayout.requestFocus();
            }
        } catch (Exception unused) {
        }
        c4();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            LinearLayout linearLayout = this.f175966c0;
            if (linearLayout != null) {
                try {
                    linearLayout.requestFocus();
                } catch (Throwable th5) {
                    QLog.e("FriendProfileMoreInfoActivity", 1, "onClick fail.", th5);
                }
            }
            if (!com.tencent.mobileqq.utils.u.a().b()) {
                int id5 = view.getId();
                if (id5 == R.id.ivTitleBtnLeft) {
                    c4();
                } else if (id5 == R.id.a39) {
                    ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(this, "2");
                    ReportController.o(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
                } else if (id5 == R.id.ivn) {
                    f4();
                    ReportController.o(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
                } else if (id5 == R.id.iqg) {
                    e4();
                } else if (id5 == R.id.jzz) {
                    TroopInfo k3 = ((TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.B1);
                    if (k3 != null) {
                        if (!k3.isTroopAdmin(this.app.getCurrentAccountUin()) && !k3.isTroopOwner(this.app.getCurrentAccountUin()) && !TextUtils.equals(this.S0.uin, this.app.getCurrentAccountUin())) {
                            if (QLog.isColorLevel()) {
                                QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
                            }
                        } else {
                            x4(this.B1, this.S0.uin, 1011);
                        }
                    }
                } else if (id5 == R.id.a_y) {
                    Intent intent = new Intent(this, (Class<?>) AgeSelectionActivity.class);
                    intent.putExtra("param_birthday", this.f175981j1);
                    intent.putExtra("param_launch_from", "VAL_FROM_PROFILE_EDIT");
                    intent.putExtra("param_age_privacy", a4(41610));
                    intent.putExtra("param_birth_privacy", a4(41607));
                    startActivityForResult(intent, 1003);
                } else if (id5 == R.id.fzu) {
                    Intent intent2 = new Intent(this, (Class<?>) JobSelectionActivity.class);
                    intent2.putExtra("param_id", this.f175987m1);
                    startActivityForResult(intent2, 1004);
                } else if (id5 == R.id.egi) {
                    d4();
                } else if (id5 == R.id.d6w) {
                    M4(2);
                } else if (id5 == R.id.flw) {
                    Intent intent3 = new Intent(this, (Class<?>) EditActivity.class);
                    intent3.putExtra("title", R.string.d2t).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", R.string.d2s).putExtra("multiLine", true).putExtra("current", this.f175993p1).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
                    startActivityForResult(intent3, 1007);
                } else if (id5 == R.id.ihf) {
                    B4(1);
                    b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", 3));
                } else if (id5 == R.id.ihj) {
                    B4(2);
                    b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", 2));
                } else if (id5 == R.id.ihh) {
                    B4(3);
                    b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", 1));
                } else if (id5 == R.id.ihd) {
                    B4(4);
                    J4();
                } else if (id5 == R.id.f165060bu1) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
                    if (view.getTag() instanceof com.tencent.mobileqq.profile.i) {
                        com.tencent.mobileqq.profile.i iVar = (com.tencent.mobileqq.profile.i) view.getTag();
                        b4(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", Integer.valueOf(iVar.f260183b), Integer.valueOf(iVar.f260182a)));
                    } else if (view.getTag() instanceof Card) {
                        b4("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
                    }
                } else if (id5 == R.id.xpo) {
                    VideoReport.reportEvent("clck", this.f175994q0, W3());
                    l4();
                } else if (id5 == R.id.f82704hl) {
                    VideoReport.reportEvent("clck", this.f175998s0, W3());
                    n4();
                } else if (id5 == R.id.f164338sq1) {
                    VideoReport.reportEvent("clck", this.f176002u0, W3());
                    k4();
                } else if (id5 == R.id.f166355zk0) {
                    VideoReport.reportEvent("clck", this.f176004v0, W3());
                    m4();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.ProfileActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Boolean.valueOf(z16));
            return;
        }
        if (!z16) {
            EditText editText = this.f175980j0;
            if (view == editText) {
                if (this.U0.f176048h) {
                    String obj = editText.getText().toString();
                    if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj.trim())) {
                        QQToast.makeText(this, HardCodeUtil.qqStr(R.string.mse), 0).show(getTitleBarHeight());
                        return;
                    }
                    return;
                }
                return;
            }
            EditText editText2 = this.J0;
            if (view == editText2 && this.X0.f176048h) {
                String obj2 = editText2.getText().toString();
                Matcher matcher = SearchBaseActivity.f180755n0.matcher(obj2);
                if (!TextUtils.isEmpty(obj2) && !matcher.matches()) {
                    QQToast.makeText(this, HardCodeUtil.qqStr(R.string.f172026mt2), 0).show(getTitleBarHeight());
                }
            }
        }
    }

    public void x4(String str, String str2, int i3) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, Integer.valueOf(i3));
            return;
        }
        if (((TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)).R(str)) {
            com.tencent.mobileqq.troop.utils.d.c(this, str2, str, "qqProfile");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("edit_mode", 0);
        intent.putExtra("troopUin", str);
        intent.putExtra("uin", str2);
        if (i3 != 1011) {
            str3 = "";
        } else {
            str3 = getString(R.string.eqr);
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 5);
            intent.putExtra("default_nick_id", this.f175976h0.a());
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, this.f175976h0.getText().toString() + "");
            intent.putExtra("max_num", 60);
        }
        intent.putExtra("title", str3);
        if (TextUtils.isEmpty("")) {
            intent.putExtra("default_hint", HardCodeUtil.qqStr(R.string.msl));
        } else {
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, "");
        }
        RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, i3);
    }

    void y4(int i3) {
        if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(i3)) {
            this.f176006w0.setVisibility(8);
            FormSimpleItem formSimpleItem = this.f176012z0;
            if (formSimpleItem != null) {
                formSimpleItem.setBgType(1);
            }
        }
    }
}
