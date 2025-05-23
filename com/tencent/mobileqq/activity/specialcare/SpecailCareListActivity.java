package com.tencent.mobileqq.activity.specialcare;

import QQService.EVIPSPEC;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.group.d;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.bp;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.theme.SkinEngine;
import com.tencent.util.BadgeUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df$FriendScore;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SpecailCareListActivity extends IphoneTitleBarActivity implements View.OnClickListener, DecodeTaskCompletionListener, ActivateFriendGrid.d, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    static String L0;
    static final String M0;
    static final String N0;
    boolean A0;
    private String[] B0;
    boolean C0;
    private hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> D0;
    Handler E0;
    OverScrollViewListener F0;
    x G0;
    ar H0;
    private CompoundButton.OnCheckedChangeListener I0;
    private CardObserver J0;
    int K0;

    /* renamed from: a0, reason: collision with root package name */
    private int f186451a0;

    /* renamed from: b0, reason: collision with root package name */
    int f186452b0;

    /* renamed from: c0, reason: collision with root package name */
    int f186453c0;

    /* renamed from: d0, reason: collision with root package name */
    RelativeLayout f186454d0;

    /* renamed from: e0, reason: collision with root package name */
    LinearLayout f186455e0;

    /* renamed from: f0, reason: collision with root package name */
    View f186456f0;

    /* renamed from: g0, reason: collision with root package name */
    XListView f186457g0;

    /* renamed from: h0, reason: collision with root package name */
    QQProgressDialog f186458h0;

    /* renamed from: i0, reason: collision with root package name */
    PullRefreshHeader f186459i0;

    /* renamed from: j0, reason: collision with root package name */
    Drawable f186460j0;

    /* renamed from: k0, reason: collision with root package name */
    View f186461k0;

    /* renamed from: l0, reason: collision with root package name */
    View f186462l0;

    /* renamed from: m0, reason: collision with root package name */
    Button f186463m0;

    /* renamed from: n0, reason: collision with root package name */
    private QUISingleLineListItem f186464n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f186465o0;

    /* renamed from: p0, reason: collision with root package name */
    private CardHandler f186466p0;

    /* renamed from: q0, reason: collision with root package name */
    SpecailCareListAdapter f186467q0;

    /* renamed from: r0, reason: collision with root package name */
    IFaceDecoder f186468r0;

    /* renamed from: s0, reason: collision with root package name */
    int f186469s0;

    /* renamed from: t0, reason: collision with root package name */
    boolean f186470t0;

    /* renamed from: u0, reason: collision with root package name */
    ActivateFriendGrid f186471u0;

    /* renamed from: v0, reason: collision with root package name */
    ArrayList<w> f186472v0;

    /* renamed from: w0, reason: collision with root package name */
    ArrayList<String> f186473w0;

    /* renamed from: x0, reason: collision with root package name */
    FriendListHandler f186474x0;

    /* renamed from: y0, reason: collision with root package name */
    FriendsManager f186475y0;

    /* renamed from: z0, reason: collision with root package name */
    StatusManager f186476z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class SpecailCareListAdapter extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        View f186486d;

        /* renamed from: e, reason: collision with root package name */
        LayoutInflater f186487e;

        public SpecailCareListAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            } else {
                this.f186487e = (LayoutInflater) SpecailCareListActivity.this.getSystemService("layout_inflater");
            }
        }

        public View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f186486d;
        }

        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                this.f186486d = view;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            int size = SpecailCareListActivity.this.f186473w0.size();
            if (size > 0) {
                return size;
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            if (i3 < SpecailCareListActivity.this.f186473w0.size()) {
                return SpecailCareListActivity.this.f186473w0.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            if (SpecailCareListActivity.this.f186473w0.size() == 0) {
                return 1;
            }
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:100:0x0407  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x03b3  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x045e  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x04c0  */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r5v5, types: [com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity] */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i3, View view, ViewGroup viewGroup) {
            y yVar;
            y yVar2;
            FormItemRelativeLayout formItemRelativeLayout;
            String string;
            boolean z16;
            int i16;
            int i17;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view2 = view;
                view3 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (getItemViewType(i3) == 1) {
                    if (view == null) {
                        View inflate = this.f186487e.inflate(R.layout.b2z, viewGroup, false);
                        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = SpecailCareListActivity.this.f186457g0.getHeight();
                            layoutParams.width = SpecailCareListActivity.this.f186457g0.getWidth();
                        } else {
                            layoutParams = new ViewGroup.LayoutParams(SpecailCareListActivity.this.f186457g0.getWidth(), SpecailCareListActivity.this.f186457g0.getHeight());
                        }
                        inflate.setLayoutParams(layoutParams);
                        formItemRelativeLayout = inflate;
                    } else {
                        formItemRelativeLayout = view;
                    }
                    ((FriendsManager) SpecailCareListActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).A(new vc1.a((TextView) formItemRelativeLayout.findViewById(R.id.e_3), (TextView) formItemRelativeLayout.findViewById(R.id.e_4), (Button) formItemRelativeLayout.findViewById(R.id.f165091bw4)) { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.SpecailCareListAdapter.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ TextView f186489a;

                        /* renamed from: b, reason: collision with root package name */
                        final /* synthetic */ TextView f186490b;

                        /* renamed from: c, reason: collision with root package name */
                        final /* synthetic */ Button f186491c;

                        {
                            this.f186489a = r6;
                            this.f186490b = r7;
                            this.f186491c = r8;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, SpecailCareListAdapter.this, r6, r7, r8);
                            }
                        }

                        @Override // vc1.a
                        public void a(int i18) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, i18);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SpecialCare", 2, "getView  friends count = " + i18);
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i18) { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.SpecailCareListAdapter.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ int f186493d;

                                {
                                    this.f186493d = i18;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, i18);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    TextView textView;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (anonymousClass1.f186489a != null && (textView = anonymousClass1.f186490b) != null && anonymousClass1.f186491c != null) {
                                        if (this.f186493d <= 0) {
                                            textView.setVisibility(8);
                                            AnonymousClass1.this.f186491c.setVisibility(8);
                                            return;
                                        }
                                        textView.setVisibility(0);
                                        AnonymousClass1.this.f186491c.setVisibility(0);
                                        AnonymousClass1.this.f186489a.setText(R.string.hon);
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        anonymousClass12.f186491c.setOnClickListener(SpecailCareListActivity.this);
                                    }
                                }
                            });
                        }
                    });
                } else {
                    if (view != null) {
                        yVar = (y) view.getTag();
                    } else {
                        yVar = null;
                    }
                    if (yVar == null) {
                        View inflate2 = this.f186487e.inflate(R.layout.f168877b33, viewGroup, false);
                        yVar2 = new y();
                        formItemRelativeLayout = inflate2;
                        if (inflate2 != null) {
                            inflate2.setTag(yVar2);
                            yVar2.f186534c = (ImageView) inflate2.findViewById(R.id.icon);
                            yVar2.f186535d = (TextView) inflate2.findViewById(R.id.text1);
                            yVar2.f186538g = (TextView) inflate2.findViewById(R.id.k_1);
                            yVar2.f186536e = (TextView) inflate2.findViewById(R.id.text2);
                            yVar2.f186537f = (ImageView) inflate2.findViewById(R.id.dyk);
                            yVar2.f186540i = (ImageView) inflate2.findViewById(R.id.f166293ey3);
                            yVar2.f186541j = (ImageView) inflate2.findViewById(R.id.f164473yx);
                            yVar2.f186542k = (ImageView) inflate2.findViewById(R.id.dyc);
                            yVar2.f186543l = (ImageView) inflate2.findViewById(R.id.dxc);
                            yVar2.f186544m = (ImageView) inflate2.findViewById(R.id.dxf);
                            yVar2.f186545n = inflate2.findViewById(R.id.ikp);
                            yVar2.f186546o = (MutualMarkIconsView) inflate2.findViewById(R.id.lwx);
                            OnlineStatusView onlineStatusView = (OnlineStatusView) inflate2.findViewById(R.id.a86);
                            yVar2.f186539h = onlineStatusView;
                            onlineStatusView.setViewStyle(2);
                            yVar2.f186539h.setTextSize(ViewUtils.dip2px(14.0f));
                            inflate2.setOnClickListener(SpecailCareListActivity.this);
                            formItemRelativeLayout = inflate2;
                        }
                    } else {
                        yVar2 = yVar;
                        formItemRelativeLayout = view;
                    }
                    if (formItemRelativeLayout instanceof FormItemRelativeLayout) {
                        if (i3 == getCount() - 1) {
                            formItemRelativeLayout.setBGType(3);
                        } else {
                            FormItemRelativeLayout formItemRelativeLayout2 = formItemRelativeLayout;
                            formItemRelativeLayout2.setNeedFocusBg(true);
                            formItemRelativeLayout2.setBGType(2);
                        }
                    }
                    String str = SpecailCareListActivity.this.f186473w0.get(i3);
                    yVar2.f186532a = str;
                    String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
                    yVar2.f186533b = uinFromUid;
                    yVar2.f186540i.setTag(uinFromUid);
                    yVar2.f186540i.setOnClickListener(SpecailCareListActivity.this);
                    if (AppSetting.f99565y) {
                        yVar2.f186540i.setContentDescription(HardCodeUtil.qqStr(R.string.f172725tn0));
                    }
                    Bitmap bitmapFromCache = SpecailCareListActivity.this.f186468r0.getBitmapFromCache(1, uinFromUid, 0);
                    if (bitmapFromCache == null) {
                        if (!SpecailCareListActivity.this.f186468r0.isPausing()) {
                            SpecailCareListActivity.this.f186468r0.requestDecodeFace(uinFromUid, 1, true);
                        }
                        yVar2.f186534c.setBackgroundDrawable((BitmapDrawable) BaseImageUtil.getDefaultFaceDrawable140_140());
                    } else {
                        yVar2.f186534c.setBackgroundDrawable(new BitmapDrawable(bitmapFromCache));
                    }
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(str, "SpecailCareListActivity");
                    int a16 = com.tencent.mobileqq.friend.status.b.a(onlineStatusSimpleInfoWithUid.u(), onlineStatusSimpleInfoWithUid.z());
                    FriendListHandler friendListHandler = (FriendListHandler) SpecailCareListActivity.this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    switch (a16) {
                        case 1:
                            string = SpecailCareListActivity.this.getString(R.string.hpd);
                            break;
                        case 2:
                            string = SpecailCareListActivity.this.getString(R.string.hpg);
                            break;
                        case 3:
                            string = SpecailCareListActivity.this.getString(R.string.hpu);
                            break;
                        case 4:
                        case 8:
                            string = ac.P(onlineStatusSimpleInfoWithUid.C());
                            break;
                        case 5:
                        default:
                            string = friendListHandler.getOfflineTipsConfig(onlineStatusSimpleInfoWithUid.B());
                            if (string == null) {
                                string = SpecailCareListActivity.this.getString(R.string.hps);
                                break;
                            }
                            break;
                        case 6:
                            string = "";
                            break;
                        case 7:
                            string = SpecailCareListActivity.this.getString(R.string.hpm);
                            break;
                    }
                    if (a16 != 0 && a16 != 6) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(SpecailCareListActivity.this.app, onlineStatusSimpleInfoWithUid, yVar2.f186539h)) {
                        yVar2.f186539h.setVisibility(0);
                        yVar2.f186538g.setVisibility(8);
                    } else {
                        yVar2.f186539h.setVisibility(8);
                        yVar2.f186538g.setVisibility(0);
                        yVar2.f186538g.setText("[" + string + "]");
                    }
                    SpecailCareListActivity.this.j3(str, yVar2);
                    yVar2.f186537f.setVisibility(8);
                    if (!z16) {
                        i16 = onlineStatusSimpleInfoWithUid.C();
                    } else {
                        i16 = 0;
                    }
                    boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
                    if (!z16 && !simpleUISwitch) {
                        d.Companion companion = com.tencent.mobileqq.friend.group.d.INSTANCE;
                        if (companion.a(EVIPSPEC.E_SP_SUPERQQ, str) || companion.a(EVIPSPEC.E_SP_SUPERVIP, str) || companion.a(EVIPSPEC.E_SP_QQVIP, str)) {
                            yVar2.f186535d.setTextColor(SpecailCareListActivity.this.getResources().getColorStateList(R.color.skin_red));
                            if (simpleUISwitch && com.tencent.mobileqq.friend.group.d.INSTANCE.a(EVIPSPEC.E_SP_SUPERVIP, str)) {
                                yVar2.f186535d.setCompoundDrawablePadding(SpecailCareListActivity.this.f186452b0);
                                yVar2.f186535d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.h39, 0);
                            } else if (simpleUISwitch && com.tencent.mobileqq.friend.group.d.INSTANCE.a(EVIPSPEC.E_SP_QQVIP, str)) {
                                yVar2.f186535d.setCompoundDrawablePadding(SpecailCareListActivity.this.f186452b0);
                                yVar2.f186535d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.h7y, 0);
                            } else {
                                yVar2.f186535d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            }
                            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                            aVar.d(str);
                            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                            yVar2.f186535d.setText(nameWithConfig);
                            yVar2.f186546o.j(SpecailCareListActivity.this.app, uinFromUid, 4);
                            ?? r56 = SpecailCareListActivity.this;
                            int l3 = r56.l3(formItemRelativeLayout, yVar2, r56.C0);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 50.0f), (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 50.0f));
                            layoutParams2.addRule(15);
                            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams3.addRule(1, R.id.icon);
                            layoutParams3.addRule(10);
                            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams4.addRule(1, R.id.icon);
                            if (!SpecailCareListActivity.this.C0) {
                                yVar2.f186540i.setVisibility(0);
                                yVar2.f186545n.setVisibility(4);
                                yVar2.f186541j.setVisibility(0);
                                layoutParams2.setMargins((int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 46.0f), 0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 10.0f), 0);
                                layoutParams3.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 22.0f), (int) ((((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 23.0f) + l3), 0);
                                layoutParams4.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 24.0f), 0, 0);
                            } else {
                                yVar2.f186540i.setVisibility(8);
                                yVar2.f186545n.setVisibility(0);
                                yVar2.f186541j.setVisibility(8);
                                layoutParams2.setMargins((int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 12.0f), 0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 10.0f), 0);
                                layoutParams3.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 10.0f), l3, 0);
                                layoutParams4.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 36.0f), 0, 0);
                            }
                            yVar2.f186534c.setLayoutParams(layoutParams2);
                            yVar2.f186535d.setLayoutParams(layoutParams3);
                            yVar2.f186545n.setLayoutParams(layoutParams4);
                            if (AppSetting.f99565y) {
                                StringBuilder sb5 = new StringBuilder(24);
                                sb5.append(nameWithConfig);
                                sb5.append(".");
                                sb5.append(string);
                                sb5.append(".");
                                d.Companion companion2 = com.tencent.mobileqq.friend.group.d.INSTANCE;
                                if (companion2.a(EVIPSPEC.E_SP_SUPERVIP, str) || companion2.a(EVIPSPEC.E_SP_QQVIP, str)) {
                                    sb5.append("QQ\u4f1a\u5458");
                                    sb5.append(".");
                                }
                                sb5.append(yVar2.f186536e.getText());
                                sb5.append(".");
                                if (!z16) {
                                    sb5.append(ac.O(i16));
                                }
                                if (!TextUtils.isEmpty(yVar2.f186546o.D)) {
                                    sb5.append(yVar2.f186546o.D.toString());
                                }
                                if (formItemRelativeLayout != 0) {
                                    formItemRelativeLayout.setContentDescription(sb5);
                                }
                            }
                            if (formItemRelativeLayout != 0) {
                                if (i3 == 0) {
                                    Resources resources = SpecailCareListActivity.this.getResources();
                                    if (getCount() == 1) {
                                        i17 = R.drawable.lki;
                                    } else {
                                        i17 = R.drawable.lkj;
                                    }
                                    formItemRelativeLayout.setBackgroundDrawable(resources.getDrawable(i17));
                                } else if (i3 == getCount() - 1) {
                                    formItemRelativeLayout.setBackgroundDrawable(SpecailCareListActivity.this.getResources().getDrawable(R.drawable.lkf));
                                } else {
                                    formItemRelativeLayout.setBackgroundDrawable(SpecailCareListActivity.this.getResources().getDrawable(R.drawable.lkg));
                                }
                            }
                        }
                    }
                    yVar2.f186535d.setTextColor(SpecailCareListActivity.this.getResources().getColorStateList(R.color.qui_common_text_primary));
                    if (simpleUISwitch) {
                    }
                    if (simpleUISwitch) {
                    }
                    yVar2.f186535d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.tencent.relation.common.bean.nameservice.a aVar2 = new com.tencent.relation.common.bean.nameservice.a();
                    aVar2.d(str);
                    String nameWithConfig2 = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar2);
                    yVar2.f186535d.setText(nameWithConfig2);
                    yVar2.f186546o.j(SpecailCareListActivity.this.app, uinFromUid, 4);
                    ?? r562 = SpecailCareListActivity.this;
                    int l36 = r562.l3(formItemRelativeLayout, yVar2, r562.C0);
                    RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams((int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 50.0f), (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 50.0f));
                    layoutParams22.addRule(15);
                    RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams32.addRule(1, R.id.icon);
                    layoutParams32.addRule(10);
                    RelativeLayout.LayoutParams layoutParams42 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams42.addRule(1, R.id.icon);
                    if (!SpecailCareListActivity.this.C0) {
                    }
                    yVar2.f186534c.setLayoutParams(layoutParams22);
                    yVar2.f186535d.setLayoutParams(layoutParams32);
                    yVar2.f186545n.setLayoutParams(layoutParams42);
                    if (AppSetting.f99565y) {
                    }
                    if (formItemRelativeLayout != 0) {
                    }
                }
                view2 = formItemRelativeLayout;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            SpecailCareListActivity.this.f186462l0.clearAnimation();
            ((FrameLayout) SpecailCareListActivity.this.getWindow().getDecorView()).removeView(SpecailCareListActivity.this.f186462l0);
            SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
            specailCareListActivity.f186462l0 = null;
            ActivateFriendGrid activateFriendGrid = specailCareListActivity.f186471u0;
            if (activateFriendGrid != null) {
                activateFriendGrid.i();
                SpecailCareListActivity.this.f186471u0 = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f186497a;

        c(Intent intent) {
            this.f186497a = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) intent);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NonNull List<RecentUser> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                SpecailCareListActivity.this.startActivity(this.f186497a);
                SpecailCareListActivity.this.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f186499a;

        d(Intent intent) {
            this.f186499a = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) intent);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NonNull List<RecentUser> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                SpecailCareListActivity.this.startActivity(this.f186499a);
                SpecailCareListActivity.this.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                SpecailCareListActivity.this.f186456f0.clearAnimation();
                SpecailCareListActivity.this.f186456f0.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186502d;

        f(y yVar) {
            this.f186502d = yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) yVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                this.f186502d.f186540i.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186504d;

        g(y yVar) {
            this.f186504d = yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) yVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f186504d.f186534c.getLayoutParams());
            layoutParams.addRule(15);
            layoutParams.setMargins((int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 46.0f), 0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 10.0f), 0);
            this.f186504d.f186534c.setLayoutParams(layoutParams);
            this.f186504d.f186534c.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186506d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f186507e;

        h(y yVar, int i3) {
            this.f186506d = yVar;
            this.f186507e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SpecailCareListActivity.this, yVar, Integer.valueOf(i3));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            this.f186506d.f186535d.clearAnimation();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(1, R.id.icon);
            layoutParams.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 22.0f), (int) ((((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 23.0f) + this.f186507e), 0);
            this.f186506d.f186535d.setLayoutParams(layoutParams);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186509d;

        i(y yVar) {
            this.f186509d = yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) yVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            this.f186509d.f186545n.clearAnimation();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, R.id.icon);
            layoutParams.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 24.0f), 0, 0);
            this.f186509d.f186545n.setLayoutParams(layoutParams);
            this.f186509d.f186545n.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            SpecailCareListActivity.this.leftView.clearAnimation();
            SpecailCareListActivity.this.f186455e0.clearAnimation();
            SpecailCareListActivity.this.leftView.setVisibility(4);
            SpecailCareListActivity.this.f186455e0.setVisibility(8);
            SpecailCareListActivity.this.rightViewText.setClickable(true);
            SpecailCareListActivity.this.rightViewText.setText(SpecailCareListActivity.N0);
            SpecailCareListActivity.this.rightViewText.setContentDescription(HardCodeUtil.qqStr(R.string.f172728tn3));
            SpecailCareListActivity.this.C0 = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186512d;

        k(y yVar) {
            this.f186512d = yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) yVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                this.f186512d.f186540i.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186514d;

        l(y yVar) {
            this.f186514d = yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) yVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f186514d.f186534c.getLayoutParams());
            layoutParams.addRule(15);
            layoutParams.setMargins((int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 12.0f), 0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 10.0f), 0);
            this.f186514d.f186534c.setLayoutParams(layoutParams);
            this.f186514d.f186534c.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class m implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186516d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f186517e;

        m(y yVar, int i3) {
            this.f186516d = yVar;
            this.f186517e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SpecailCareListActivity.this, yVar, Integer.valueOf(i3));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            this.f186516d.f186535d.clearAnimation();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, R.id.icon);
            layoutParams.addRule(10);
            layoutParams.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 10.0f), this.f186517e, 0);
            this.f186516d.f186535d.setLayoutParams(layoutParams);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class n implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f186519d;

        n(y yVar) {
            this.f186519d = yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this, (Object) yVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            this.f186519d.f186545n.clearAnimation();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, R.id.icon);
            layoutParams.setMargins(0, (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 36.0f), (int) (((IphoneTitleBarActivity) SpecailCareListActivity.this).mDensity * 30.0f), 0);
            this.f186519d.f186545n.setLayoutParams(layoutParams);
            this.f186519d.f186545n.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class o implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            SpecailCareListActivity.this.leftView.clearAnimation();
            SpecailCareListActivity.this.f186455e0.clearAnimation();
            SpecailCareListActivity.this.leftView.setVisibility(0);
            SpecailCareListActivity.this.f186455e0.setVisibility(0);
            SpecailCareListActivity.this.rightViewText.setClickable(true);
            SpecailCareListActivity.this.rightViewText.setText(SpecailCareListActivity.M0);
            SpecailCareListActivity.this.rightViewText.setContentDescription(HardCodeUtil.qqStr(R.string.tmx));
            SpecailCareListActivity.this.C0 = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class p extends Handler {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 2000:
                    SpecailCareListActivity.this.f186457g0.springBackOverScrollHeaderView();
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.f171139ci4, 0).show(SpecailCareListActivity.this.getTitleBarHeight());
                    return;
                case 2001:
                    SpecailCareListActivity.this.f186457g0.springBackOverScrollHeaderView();
                    return;
                case 2002:
                    SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
                    if (specailCareListActivity.f186458h0 == null) {
                        SpecailCareListActivity specailCareListActivity2 = SpecailCareListActivity.this;
                        specailCareListActivity.f186458h0 = new QQProgressDialog(specailCareListActivity2, specailCareListActivity2.getTitleBarHeight());
                    }
                    SpecailCareListActivity.this.f186458h0.setMessage(R.string.f171530fu3);
                    if (!SpecailCareListActivity.this.isFinishing() && !SpecailCareListActivity.this.f186458h0.isShowing()) {
                        SpecailCareListActivity.this.f186458h0.show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class q implements OverScrollViewListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, listView);
            } else {
                SpecailCareListActivity.this.f186459i0.i(0L);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), view, listView);
            } else {
                SpecailCareListActivity.this.f186459i0.d(0L);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), view, listView)).booleanValue();
            }
            SpecailCareListActivity.this.f186459i0.h(0L);
            if (NetworkUtil.isNetSupport(SpecailCareListActivity.this)) {
                SpecailCareListActivity.this.f186474x0.getFriendGroupList(true);
                SpecailCareListActivity.this.f186470t0 = true;
            } else {
                SpecailCareListActivity.this.E0.sendMessageDelayed(SpecailCareListActivity.this.E0.obtainMessage(2000, 0, 0), 1000L);
            }
            return true;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, listView);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class r extends x {
        static IPatchRedirector $redirector_;

        r() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
                return;
            }
            SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
            if (specailCareListActivity.K0 != 0) {
                specailCareListActivity.A0 = true;
            } else if (i16 == 200 && bitmap != null) {
                specailCareListActivity.f186467q0.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class s extends ar {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_global(boolean z16, Object[] objArr) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), objArr);
                return;
            }
            int intValue = ((Integer) objArr[0]).intValue();
            String[] strArr = (String[]) objArr[1];
            if (QLog.isColorLevel() && strArr != null) {
                QLog.d("SpecailCareListActivity", 2, "onSetSpecialCareSwitch_global isSucess= " + z16 + ",type=" + intValue + ",uinSize=" + strArr.length);
            }
            if (SpecailCareListActivity.this.B0 != null && strArr != null) {
                z17 = Arrays.equals(SpecailCareListActivity.this.B0, strArr);
            } else {
                z17 = false;
            }
            if (z17) {
                if (strArr.length >= 1) {
                    SpecailCareListActivity.this.hideProgressDialog();
                    if (z16) {
                        SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
                        if (specailCareListActivity.f186462l0 != null) {
                            specailCareListActivity.p3();
                            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f170041dp, 0).show(SpecailCareListActivity.this.getTitleBarHeight());
                        } else {
                            QQToast.makeText(BaseApplication.getContext(), 2, R.string.fuf, 0).show(SpecailCareListActivity.this.getTitleBarHeight());
                        }
                        SpecailCareListActivity.this.u3();
                        SpecailCareListActivity.this.f186467q0.notifyDataSetChanged();
                        return;
                    }
                    if (SpecailCareListActivity.this.f186462l0 != null) {
                        QQToast.makeText(BaseApplication.getContext(), 1, R.string.ftz, 0).show(SpecailCareListActivity.this.getTitleBarHeight());
                        return;
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), 1, R.string.fue, 0).show(SpecailCareListActivity.this.getTitleBarHeight());
                        return;
                    }
                }
                if (z16) {
                    SpecailCareListActivity.this.u3();
                    SpecailCareListActivity.this.f186467q0.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (z16) {
                SpecailCareListActivity.this.u3();
                SpecailCareListActivity.this.f186467q0.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "onUpdateDelFriend isSucess= " + z16 + ", uin=" + ((Long) obj));
            }
            if (z16) {
                SpecailCareListActivity.this.u3();
                SpecailCareListActivity.this.f186467q0.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "onUpdateFriendList isSuccess=" + z16 + ", isComplete=" + z17 + " mIsPullRefresh=" + SpecailCareListActivity.this.f186470t0);
            }
            if (!z16 || z17) {
                SpecailCareListActivity.this.u3();
                SpecailCareListActivity.this.f186467q0.notifyDataSetChanged();
            }
            SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
            if (specailCareListActivity.f186470t0) {
                if (z16 && z17) {
                    specailCareListActivity.f186459i0.l(0);
                    SpecailCareListActivity.this.E0.sendEmptyMessageDelayed(2001, 1000L);
                    SpecailCareListActivity.this.f186470t0 = false;
                } else if (!z16) {
                    specailCareListActivity.f186459i0.l(1);
                    SpecailCareListActivity.this.E0.sendEmptyMessageDelayed(2001, 1000L);
                    SpecailCareListActivity.this.f186470t0 = false;
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOnlineFriend(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), strArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "onUpdateSignature isSucess= " + z16);
            }
            if (z16) {
                SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
                if (specailCareListActivity.K0 != 0) {
                    specailCareListActivity.A0 = true;
                } else {
                    specailCareListActivity.f186467q0.notifyDataSetChanged();
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSignature(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), strArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "onUpdateSignature isSucess= " + z16);
            }
            SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
            if (specailCareListActivity.K0 != 0) {
                specailCareListActivity.A0 = true;
            } else {
                specailCareListActivity.f186467q0.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSpecialCareList(boolean z16, boolean z17, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList, arrayList2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "onUpdateSpecialCareList isSucess= " + z16 + ",isComplete=" + z17);
            }
            if (z16) {
                SpecailCareListActivity.this.u3();
                SpecailCareListActivity.this.f186467q0.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class t implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                SpecailCareListActivity specailCareListActivity = SpecailCareListActivity.this;
                SettingCloneUtil.writeValue(specailCareListActivity, specailCareListActivity.f186465o0, SpecailCareListActivity.this.getString(R.string.vou), AppConstants.QQSETTING_SPECIAL_CARE_BAR, z16);
                SpecailCareListActivity.this.f186466p0.f5(z16);
                com.tencent.util.notification.d.s(z16);
                if (QLog.isColorLevel()) {
                    QLog.i("SpecailCareListActivity", 2, "onCheckedChanged: invoked. care bar  isChecked: " + z16);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class u extends CardObserver {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onGetCareBarEnable(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            super.onGetCareBarEnable(z16, z17);
            if (QLog.isColorLevel()) {
                QLog.i("SpecailCareListActivity", 2, "onGetCareBarEnable: invoked.  barEnable: " + z17);
            }
            SpecailCareListActivity.this.f186464n0.setConfig(new x.b.d(HardCodeUtil.qqStr(R.string.vou)), new x.c.f(z17, SpecailCareListActivity.this.I0, true));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetCareBarEnable(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                super.onSetCareBarEnable(z16, z17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class v implements vc1.a {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }

        @Override // vc1.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 > 0) {
                ReportController.o(SpecailCareListActivity.this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
            } else {
                ReportController.o(SpecailCareListActivity.this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class w {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f186529a;

        /* renamed from: b, reason: collision with root package name */
        public String f186530b;

        w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class x implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class y {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f186532a;

        /* renamed from: b, reason: collision with root package name */
        public String f186533b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f186534c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f186535d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f186536e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f186537f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f186538g;

        /* renamed from: h, reason: collision with root package name */
        public OnlineStatusView f186539h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f186540i;

        /* renamed from: j, reason: collision with root package name */
        public ImageView f186541j;

        /* renamed from: k, reason: collision with root package name */
        public ImageView f186542k;

        /* renamed from: l, reason: collision with root package name */
        public ImageView f186543l;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f186544m;

        /* renamed from: n, reason: collision with root package name */
        public View f186545n;

        /* renamed from: o, reason: collision with root package name */
        public MutualMarkIconsView f186546o;

        public y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69411);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        L0 = "setting_search_title";
        M0 = HardCodeUtil.qqStr(R.string.f172726tn1);
        N0 = HardCodeUtil.qqStr(R.string.f172727tn2);
    }

    public SpecailCareListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f186465o0 = "";
        this.f186470t0 = false;
        this.f186472v0 = new ArrayList<>();
        this.f186473w0 = new ArrayList<>();
        this.A0 = false;
        this.C0 = false;
        this.D0 = new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpecailCareListActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SpecailCareListActivity", 2, " interrupt internet onQueryResult");
                }
                if (eVar != null && eVar.a() == 0) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.1.1
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
                                return;
                            }
                            SpecailCareListActivity.this.u3();
                            SpecailCareListAdapter specailCareListAdapter = SpecailCareListActivity.this.f186467q0;
                            if (specailCareListAdapter != null) {
                                specailCareListAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    QLog.d("SpecailCareListActivity", 2, "responseData.getCode() != RelationResponseConstant.RELATION_RESPONSE_SUCCESS || responseData == null");
                    com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.NORMAL, 1);
                }
            }
        };
        this.E0 = new p();
        this.F0 = new q();
        this.G0 = new r();
        this.H0 = new s();
        this.I0 = new t();
        this.J0 = new u();
        this.K0 = 0;
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.d
    public void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else if (i3 > 0) {
            this.f186463m0.setEnabled(true);
        } else {
            this.f186463m0.setEnabled(false);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        PBBytesField pBBytesField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.doOnCreate(bundle);
        setContentView(R.layout.f168875b31);
        super.setTitle(R.string.f172976g92);
        super.setRightButton(R.string.c7a, this);
        this.app.addObserver(this.H0);
        this.app.addObserver(this.J0);
        this.f186452b0 = (int) al.a(this, 9.0f);
        this.f186453c0 = (int) al.a(this, 12.0f);
        this.f186469s0 = (int) al.a(this, 20.0f);
        this.f186454d0 = (RelativeLayout) super.findViewById(R.id.f166799ic3);
        this.f186457g0 = (XListView) super.findViewById(R.id.ebs);
        View findViewById = super.findViewById(R.id.cbn);
        this.f186456f0 = findViewById;
        findViewById.setBackgroundDrawable(getResources().getDrawable(R.drawable.lki));
        this.f186456f0.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.b2y, (ViewGroup) null);
        this.f186455e0 = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.f164010gx);
        textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.lki));
        textView.setPadding(ViewUtils.dpToPx(28.0f), 0, 0, 0);
        this.f186455e0.setOnClickListener(this);
        this.f186457g0.addFooterView(this.f186455e0);
        SpecailCareListAdapter specailCareListAdapter = new SpecailCareListAdapter();
        this.f186467q0 = specailCareListAdapter;
        this.f186457g0.setAdapter((ListAdapter) specailCareListAdapter);
        PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) getLayoutInflater().inflate(R.layout.a3z, (ViewGroup) this.f186457g0, false);
        this.f186459i0 = pullRefreshHeader;
        this.f186457g0.setOverScrollHeader(pullRefreshHeader);
        this.f186457g0.setOverScrollHeight(getResources().getDimensionPixelSize(R.dimen.auf));
        this.f186457g0.setOverScrollListener(this.F0);
        this.f186457g0.setOnScrollListener(this);
        this.f186460j0 = getResources().getDrawable(R.drawable.abc);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        this.f186468r0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.f186474x0 = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.f186475y0 = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        StatusManager statusManager = (StatusManager) this.app.getManager(QQManagerFactory.STATUS_MANAGER);
        this.f186476z0 = statusManager;
        statusManager.C(this.G0);
        this.f186464n0 = (QUISingleLineListItem) findViewById(R.id.m9d);
        this.f186466p0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        this.f186465o0 = this.app.getCurrentAccountUin();
        boolean e16 = com.tencent.util.notification.d.e();
        this.f186464n0.setConfig(new x.b.d(HardCodeUtil.qqStr(R.string.vou)), new x.c.f(e16, this.I0, true));
        this.f186464n0.setBackgroundType(QUIListItemBackgroundType.AllRound);
        if (QLog.isColorLevel()) {
            QLog.i("SpecailCareListActivity", 2, "initUI: invoked. special bar enable: " + e16);
        }
        this.f186466p0.f5(e16);
        this.f186464n0.setContentDescription(getString(R.string.vou));
        this.f186464n0.setVisibility(0);
        u3();
        if (this.f186473w0.size() <= 0 && r3(1)) {
            this.f186474x0.getFriendGroupList(true);
            FriendListHandler.getSpecialRecommendStat = 2;
            ArrayList<oidb_0x7df$FriendScore> recommendList = this.f186474x0.getRecommendList();
            if (recommendList != null && recommendList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList() return size:" + recommendList.size());
                }
                this.f186472v0.clear();
                Iterator<oidb_0x7df$FriendScore> it = recommendList.iterator();
                while (it.hasNext()) {
                    oidb_0x7df$FriendScore next = it.next();
                    w wVar = new w();
                    wVar.f186529a = String.valueOf(next.uint64_friend_uin.get());
                    com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                    aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(wVar.f186529a));
                    String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                    wVar.f186530b = nameWithConfig;
                    if (TextUtils.isEmpty(nameWithConfig) && (pBBytesField = next.bytes_nick) != null && pBBytesField.get() != null) {
                        wVar.f186530b = next.bytes_nick.get().toStringUtf8();
                    }
                    this.f186472v0.add(wVar);
                }
                y3();
            } else if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
            }
        }
        v3(1, true);
        v3(2, true);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "doOnCreate cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        if (AppSetting.f99565y) {
            this.leftView.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
            this.f186456f0.setContentDescription(HardCodeUtil.qqStr(R.string.tmz));
        }
        this.f186474x0.getOnlineFriend(this.app.getCurrentAccountUin(), (byte) 3);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryCacheInfoV2(RelationListReqType.NORMAL, true, "SpecailCareListActivity", false, this.D0);
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
        IFaceDecoder iFaceDecoder = this.f186468r0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.J0);
            if (BadgeUtils.j(this.app.getApplication())) {
                BadgeUtils.d();
            }
            this.app.removeObserver(this.H0);
        }
        this.f186476z0.b0(this.G0);
        hideProgressDialog();
        ActivateFriendGrid activateFriendGrid = this.f186471u0;
        if (activateFriendGrid != null) {
            activateFriendGrid.i();
            this.f186471u0 = null;
        }
        if (this.D0 != null) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).unregisterFriendCategoryInfoV2Callback(RelationListReqType.NORMAL, "SpecailCareListActivity", this.D0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        u3();
        SpecailCareListAdapter specailCareListAdapter = this.f186467q0;
        if (specailCareListAdapter == null) {
            return;
        }
        specailCareListAdapter.notifyDataSetChanged();
        Intent intent = getIntent();
        if (intent != null && TextUtils.equals(intent.getStringExtra(L0), getString(R.string.vou))) {
            ((ISettingApi) QRoute.api(ISettingApi.class)).checkAndStartAnimation(this.f186464n0);
        }
    }

    void hideProgressDialog() {
        QQProgressDialog qQProgressDialog = this.f186458h0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f186458h0.dismiss();
            this.f186458h0 = null;
        }
    }

    void j3(String str, y yVar) {
        ((IZoneInfoService) QRoute.api(IZoneInfoService.class)).getZoneDetailInfoWithUid(str, "SpecailCareListActivity", new hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a>(str, yVar) { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.25
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f186479a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ y f186480b;

            {
                this.f186479a = str;
                this.f186480b = yVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SpecailCareListActivity.this, str, yVar);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.25.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f186482d;

                        {
                            this.f186482d = eVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass25.this, (Object) eVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z16;
                            RichStatus richStatus;
                            boolean z17;
                            boolean z18;
                            SpannableString spannableString;
                            int i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar2 = this.f186482d;
                            if (eVar2 != null && eVar2.a() == 0 && this.f186482d.b() != null && !this.f186482d.b().isEmpty()) {
                                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(AnonymousClass25.this.f186479a, "SpecailCareListActivity");
                                int i16 = 0;
                                com.tencent.qqnt.ntrelation.zoneinfo.bean.a aVar = (com.tencent.qqnt.ntrelation.zoneinfo.bean.a) this.f186482d.b().get(0);
                                if (friendsSimpleInfoWithUid != null && aVar != null && !TextUtils.isEmpty(aVar.b())) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (friendsSimpleInfoWithUid != null) {
                                    richStatus = com.tencent.mobileqq.richstatus.c.h(friendsSimpleInfoWithUid);
                                } else {
                                    richStatus = null;
                                }
                                if (richStatus != null && !richStatus.isEmpty()) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17 && !TextUtils.isEmpty(richStatus.actionText)) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z16 && (aVar.f() > friendsSimpleInfoWithUid.t() || !z17)) {
                                    spannableString = new SpannableString(aVar.b());
                                    AnonymousClass25.this.f186480b.f186536e.setCompoundDrawables(null, null, null, null);
                                    if (aVar.j() == 2) {
                                        AnonymousClass25.this.f186480b.f186542k.setVisibility(0);
                                        if (!TextUtils.isEmpty(aVar.e())) {
                                            bp.a(AnonymousClass25.this.f186480b.f186542k, aVar.e(), SpecailCareListActivity.this.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                                        } else {
                                            AnonymousClass25.this.f186480b.f186542k.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                                        }
                                        AnonymousClass25.this.f186480b.f186543l.setVisibility(8);
                                        AnonymousClass25.this.f186480b.f186544m.setVisibility(8);
                                    } else {
                                        AnonymousClass25.this.f186480b.f186543l.setVisibility(0);
                                        ImageView imageView = AnonymousClass25.this.f186480b.f186543l;
                                        if (aVar.j() == 1) {
                                            i3 = R.drawable.f162391gm3;
                                        } else {
                                            i3 = R.drawable.f162389gm1;
                                        }
                                        imageView.setBackgroundResource(i3);
                                        ImageView imageView2 = AnonymousClass25.this.f186480b.f186544m;
                                        if (!aVar.c()) {
                                            i16 = 8;
                                        }
                                        imageView2.setVisibility(i16);
                                        AnonymousClass25.this.f186480b.f186542k.setVisibility(8);
                                        AnonymousClass25.this.f186480b.f186542k.setImageDrawable(null);
                                    }
                                } else {
                                    if (z18) {
                                        BitmapDrawable bitmapDrawable = new BitmapDrawable(SpecailCareListActivity.this.getResources(), SpecailCareListActivity.this.f186476z0.K(richStatus.actionId, 200));
                                        int i17 = SpecailCareListActivity.this.f186453c0;
                                        bitmapDrawable.setBounds(0, 0, Math.round(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * i17), i17);
                                        AnonymousClass25.this.f186480b.f186536e.setCompoundDrawables(bitmapDrawable, null, null, null);
                                    } else if (!z17) {
                                        richStatus = RichStatus.getEmptyStatus();
                                        AnonymousClass25.this.f186480b.f186536e.setCompoundDrawables(null, null, null, null);
                                    }
                                    spannableString = richStatus.toSpannableString(null);
                                    AnonymousClass25.this.f186480b.f186543l.setVisibility(8);
                                    AnonymousClass25.this.f186480b.f186544m.setVisibility(8);
                                    AnonymousClass25.this.f186480b.f186542k.setVisibility(8);
                                    AnonymousClass25.this.f186480b.f186542k.setImageDrawable(null);
                                }
                                AnonymousClass25.this.f186480b.f186536e.setText(spannableString);
                            }
                        }
                    });
                }
            }
        });
    }

    public int l3(View view, y yVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, view, yVar, Boolean.valueOf(z16))).intValue();
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158599k2);
        if (z16) {
            return dimensionPixelSize;
        }
        XListView xListView = this.f186457g0;
        if (xListView != null) {
            i3 = xListView.getWidth();
        }
        int f16 = yVar.f186546o.f(view, yVar, dimensionPixelSize, i3);
        if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "getNickRightMargin=" + f16);
        }
        return f16;
    }

    void n3() {
        View view = this.f186461k0;
        if (view != null && view.getParent() != null) {
            ((FrameLayout) getWindow().getDecorView()).removeView(this.f186461k0);
            this.f186461k0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.C0) {
            this.C0 = false;
            t3();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (!fb0.a.a("SpecailCareListActivity")) {
            if ((view instanceof ImageView) && view.getTag() != null && (view.getTag() instanceof String)) {
                String str = (String) view.getTag();
                if (!StringUtil.isEmpty(str)) {
                    ReportController.o(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
                    if (NetworkUtil.isNetSupport(this)) {
                        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                        String[] strArr = {str};
                        this.B0 = strArr;
                        friendListHandler.setSpecialCareSwitch(1, strArr, new boolean[]{false});
                        this.E0.sendEmptyMessage(2002);
                    } else {
                        QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
                    }
                }
            } else {
                int id5 = view.getId();
                if (id5 == R.id.ivTitleBtnRightText) {
                    if (this.f186462l0 != null) {
                        p3();
                        ReportController.o(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
                    } else {
                        s3();
                    }
                } else if (id5 == R.id.f163996ge) {
                    if (!NetworkUtil.isNetSupport(this)) {
                        QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
                        if (QLog.isColorLevel()) {
                            QLog.i("SpecailCareListActivity", 2, "No Network!");
                        }
                    } else {
                        long[] j3 = this.f186471u0.j();
                        boolean[] zArr = new boolean[j3.length];
                        int length = j3.length;
                        String[] strArr2 = new String[length];
                        this.B0 = new String[length];
                        for (int i3 = 0; i3 < j3.length; i3++) {
                            zArr[i3] = true;
                            String valueOf = String.valueOf(j3[i3]);
                            strArr2[i3] = valueOf;
                            this.B0[i3] = valueOf;
                        }
                        showProgressDialog();
                        if (QLog.isColorLevel()) {
                            QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
                        }
                        this.f186474x0.setSpecialCareSwitch(1, strArr2, zArr);
                        ReportController.o(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(j3.length), "", "", "");
                    }
                } else if (id5 == R.id.f165996e15) {
                    n3();
                } else if (id5 == R.id.f165091bw4) {
                    ReportController.o(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
                    Intent intent = new Intent(this, (Class<?>) ForwardFriendListActivity.class);
                    intent.putExtra("extra_shield_robot_friend", true);
                    intent.putExtra("extra_choose_friend", 1);
                    intent.putExtra("extra_add_special_friend", 2);
                    ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(this.app, new c(intent), false);
                } else if (id5 != R.id.f166630gs2) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof y)) {
                        Intent intent2 = new Intent(this, (Class<?>) QQSpecialCareSettingActivity.class);
                        intent2.putExtra("key_friend_uin", ((y) tag).f186533b);
                        intent2.putExtra("key_start_from", 5);
                        startActivity(intent2);
                    } else {
                        ReportController.o(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
                        Intent intent3 = new Intent(this, (Class<?>) ForwardFriendListActivity.class);
                        intent3.putExtra("extra_shield_robot_friend", true);
                        intent3.putExtra("extra_choose_friend", 1);
                        intent3.putExtra("extra_add_special_friend", 2);
                        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(this.app, new d(intent3), false);
                    }
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

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        y yVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "uin=" + str + ", type=" + i16 + ",avatar= " + bitmap);
        }
        if (bitmap != null && !this.f186468r0.isPausing()) {
            if (this.K0 != 0) {
                this.A0 = true;
                return;
            }
            int childCount = this.f186457g0.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = this.f186457g0.getChildAt(i17);
                if (childAt != null && (yVar = (y) childAt.getTag()) != null && !TextUtils.isEmpty(str) && str.equals(yVar.f186533b)) {
                    yVar.f186534c.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    return;
                }
            }
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f186451a0 = i17;
        if (this.f186473w0.size() > 0 && absListView != null) {
            if (this.C0) {
                this.f186456f0.setVisibility(8);
                return;
            }
            int i18 = i3 + i16;
            int bottom = this.f186455e0.getBottom();
            int bottom2 = absListView.getBottom();
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "onScroll.firstVisibleItem=" + i3 + ", visibleItemCount=" + i16 + ",totalItemCount=" + i17 + ",addBtnBottom=" + bottom + ",listviewBottom=" + bottom2 + ",mBottomBtnBottomMargin=" + this.f186469s0);
            }
            if (i18 == i17) {
                int i19 = this.f186469s0;
                if (bottom > i19 && bottom2 >= bottom - i19) {
                    this.f186456f0.setVisibility(8);
                    return;
                } else {
                    this.f186456f0.setVisibility(0);
                    return;
                }
            }
            this.f186456f0.setVisibility(0);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absListView, i3);
            return;
        }
        this.K0 = i3;
        if (this.A0 && i3 == 0) {
            this.f186467q0.notifyDataSetChanged();
            this.A0 = false;
        } else if (i3 == 0) {
            int childCount = this.f186457g0.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                y yVar = (y) this.f186457g0.getChildAt(i16).getTag();
                if (yVar != null && (str = yVar.f186533b) != null && str.length() > 0) {
                    j3(yVar.f186532a, yVar);
                }
            }
        }
    }

    void p3() {
        View view = this.f186462l0;
        if (view != null && view.getParent() != null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new b());
            this.f186462l0.startAnimation(translateAnimation);
        }
        this.rightViewText.setVisibility(4);
    }

    boolean r3(int i3) {
        SharedPreferences preferences = getPreferences(0);
        return !preferences.getBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + i3, false);
    }

    void s3() {
        this.rightViewText.setClickable(false);
        int childCount = this.f186457g0.getChildCount();
        String charSequence = this.rightViewText.getText().toString();
        if (M0.equals(charSequence)) {
            if (this.f186456f0.getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new e());
                this.f186456f0.startAnimation(alphaAnimation);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f186457g0.getChildAt(i3);
                Object tag = childAt.getTag();
                if (tag != null && (tag instanceof y)) {
                    y yVar = (y) tag;
                    int l3 = l3(childAt, yVar, true);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-(this.mDensity * 34.0f), 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation2.setStartOffset(120L);
                    alphaAnimation2.setDuration(180L);
                    AnimationSet animationSet = new AnimationSet(true);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.addAnimation(alphaAnimation2);
                    yVar.f186540i.setVisibility(0);
                    translateAnimation.setAnimationListener(new f(yVar));
                    yVar.f186540i.startAnimation(animationSet);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, this.mDensity * 34.0f, 0.0f, 0.0f);
                    translateAnimation2.setDuration(300L);
                    translateAnimation2.setAnimationListener(new g(yVar));
                    yVar.f186534c.startAnimation(translateAnimation2);
                    TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, this.mDensity * 34.0f, 0.0f, 0.0f);
                    translateAnimation3.setDuration(300L);
                    TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.mDensity * 12.0f);
                    translateAnimation4.setDuration(300L);
                    AnimationSet animationSet2 = new AnimationSet(true);
                    animationSet2.addAnimation(translateAnimation3);
                    animationSet2.addAnimation(translateAnimation4);
                    animationSet2.setFillAfter(true);
                    animationSet2.setAnimationListener(new h(yVar, l3));
                    yVar.f186535d.startAnimation(animationSet2);
                    float f16 = this.mDensity;
                    TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, 34.0f * f16, 0.0f, f16 * (-12.0f));
                    translateAnimation5.setDuration(300L);
                    AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation3.setDuration(300L);
                    AnimationSet animationSet3 = new AnimationSet(true);
                    animationSet3.addAnimation(translateAnimation5);
                    animationSet3.addAnimation(alphaAnimation3);
                    animationSet3.setAnimationListener(new i(yVar));
                    yVar.f186545n.startAnimation(animationSet3);
                    TranslateAnimation translateAnimation6 = new TranslateAnimation(0.0f, this.mDensity * 28.0f, 0.0f, 0.0f);
                    translateAnimation6.setDuration(300L);
                    AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation4.setDuration(240L);
                    AnimationSet animationSet4 = new AnimationSet(true);
                    animationSet4.addAnimation(translateAnimation6);
                    animationSet4.addAnimation(alphaAnimation4);
                    animationSet4.setFillAfter(true);
                    yVar.f186546o.startAnimation(animationSet4);
                    AlphaAnimation alphaAnimation5 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation5.setDuration(300L);
                    alphaAnimation5.setFillAfter(true);
                    yVar.f186541j.setVisibility(0);
                    yVar.f186541j.startAnimation(alphaAnimation5);
                }
                if (i3 == childCount - 2) {
                    AlphaAnimation alphaAnimation6 = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation6.setDuration(300L);
                    alphaAnimation6.setAnimationListener(new j());
                    this.leftView.startAnimation(alphaAnimation6);
                    this.f186455e0.startAnimation(alphaAnimation6);
                }
            }
            return;
        }
        if (N0.equals(charSequence)) {
            t3();
        }
    }

    void showProgressDialog() {
        if (this.f186458h0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this);
            this.f186458h0 = qQProgressDialog;
            qQProgressDialog.setOffsetY(getTitleBarHeight());
        }
        this.f186458h0.setMessage(R.string.h_);
        if (!this.f186458h0.isShowing()) {
            this.f186458h0.show();
        }
    }

    void t3() {
        int lastVisiblePosition = this.f186457g0.getLastVisiblePosition();
        int bottom = this.f186455e0.getBottom();
        int bottom2 = this.f186457g0.getBottom();
        if (lastVisiblePosition == this.f186457g0.getCount() - 1) {
            int i3 = this.f186469s0;
            if (bottom > i3 && bottom2 >= bottom - i3) {
                this.f186456f0.setVisibility(8);
            } else {
                this.f186456f0.setVisibility(0);
            }
        } else {
            this.f186456f0.setVisibility(0);
        }
        int childCount = this.f186457g0.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.f186457g0.getChildAt(i16);
            Object tag = childAt.getTag();
            if (tag != null && (tag instanceof y)) {
                y yVar = (y) tag;
                int l3 = l3(childAt, yVar, false);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -(this.mDensity * 34.0f), 0.0f, 0.0f);
                translateAnimation.setDuration(300L);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(180L);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                translateAnimation.setAnimationListener(new k(yVar));
                yVar.f186540i.startAnimation(animationSet);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, -(this.mDensity * 34.0f), 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setAnimationListener(new l(yVar));
                yVar.f186534c.startAnimation(translateAnimation2);
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, this.mDensity * (-34.0f), 0.0f, 0.0f);
                translateAnimation3.setDuration(300L);
                TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.mDensity * (-12.0f));
                translateAnimation4.setDuration(300L);
                AnimationSet animationSet2 = new AnimationSet(true);
                animationSet2.addAnimation(translateAnimation3);
                animationSet2.addAnimation(translateAnimation4);
                animationSet2.setFillAfter(true);
                animationSet2.setAnimationListener(new m(yVar, l3));
                yVar.f186535d.startAnimation(animationSet2);
                TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, this.mDensity * (-34.0f), 0.0f, 0.0f);
                translateAnimation5.setDuration(300L);
                TranslateAnimation translateAnimation6 = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.mDensity * 12.0f);
                translateAnimation6.setDuration(300L);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(300L);
                AnimationSet animationSet3 = new AnimationSet(true);
                animationSet3.addAnimation(translateAnimation5);
                animationSet3.addAnimation(translateAnimation6);
                animationSet3.addAnimation(alphaAnimation2);
                animationSet3.setFillAfter(true);
                animationSet3.setAnimationListener(new n(yVar));
                yVar.f186545n.startAnimation(animationSet3);
                TranslateAnimation translateAnimation7 = new TranslateAnimation(this.mDensity * 24.0f, 0.0f, 0.0f, 0.0f);
                translateAnimation7.setDuration(300L);
                translateAnimation7.setFillAfter(true);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation3.setStartOffset(60L);
                alphaAnimation3.setDuration(240L);
                AnimationSet animationSet4 = new AnimationSet(true);
                animationSet4.addAnimation(translateAnimation7);
                animationSet4.addAnimation(alphaAnimation3);
                animationSet4.setFillAfter(true);
                yVar.f186546o.startAnimation(animationSet4);
                AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation4.setDuration(300L);
                alphaAnimation4.setFillAfter(true);
                yVar.f186541j.startAnimation(alphaAnimation4);
            }
            if (i16 == childCount - 2) {
                AlphaAnimation alphaAnimation5 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation5.setDuration(300L);
                alphaAnimation5.setAnimationListener(new o());
                this.leftView.startAnimation(alphaAnimation5);
                this.f186455e0.startAnimation(alphaAnimation5);
            }
        }
    }

    void u3() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f186473w0.clear();
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b friendsCategoryInfo = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsCategoryInfo(String.valueOf(((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()), "SpecailCareListActivity");
        if (friendsCategoryInfo == null) {
            return;
        }
        ArrayList<String> c16 = friendsCategoryInfo.c();
        if (c16 != null && c16.size() != 0) {
            this.rightViewText.setVisibility(0);
            if (this.C0) {
                this.rightViewText.setText(N0);
                this.f186455e0.setVisibility(8);
            } else {
                this.rightViewText.setText(M0);
                this.f186455e0.setVisibility(0);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos return size:" + c16.size());
            }
            for (int i3 = 0; i3 < c16.size(); i3++) {
                String str = c16.get(i3);
                if (!TextUtils.isEmpty(str)) {
                    this.f186473w0.add(str);
                }
            }
            ThreadManagerV2.post(new Runnable(r3(2)) { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f186484d;

                {
                    this.f186484d = r6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, SpecailCareListActivity.this, Boolean.valueOf(r6));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f186484d) {
                        SpecailCareListActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.8.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    SpecailCareListActivity.this.x3();
                                }
                            }
                        });
                    }
                    SpecailCareListActivity.this.v3(2, true);
                }
            }, 8, null, true);
        } else {
            w3();
            this.leftView.setVisibility(0);
            this.C0 = false;
            this.rightViewText.setVisibility(4);
            this.f186455e0.setVisibility(8);
            if (QLog.isColorLevel()) {
                QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos: empty...");
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "refreshSpecialCareData cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    void v3(int i3, boolean z16) {
        getPreferences(0).edit().putBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + i3, z16).commit();
    }

    void w3() {
        SpecailCareListAdapter specailCareListAdapter = this.f186467q0;
        if (specailCareListAdapter != null && specailCareListAdapter.a() != null) {
            return;
        }
        ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).A(new v());
        View inflate = getLayoutInflater().inflate(R.layout.b2z, (ViewGroup) null);
        SpecailCareListAdapter specailCareListAdapter2 = this.f186467q0;
        if (specailCareListAdapter2 != null) {
            specailCareListAdapter2.b(inflate);
        }
    }

    void x3() {
        if (this.f186461k0 != null || this.f186462l0 != null) {
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        View inflate = LayoutInflater.from(this).inflate(R.layout.f168874b30, (ViewGroup) null);
        this.f186461k0 = inflate;
        Button button = (Button) inflate.findViewById(R.id.f165996e15);
        this.f186461k0.findViewById(R.id.f166630gs2).setOnClickListener(this);
        button.setOnClickListener(this);
        if (this.f186461k0.getParent() == null) {
            frameLayout.addView(this.f186461k0);
        }
    }

    void y3() {
        if (this.f186462l0 != null) {
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
        this.f186462l0 = LayoutInflater.from(this).inflate(R.layout.f168876b32, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int i3 = 0;
        layoutParams.setMargins(0, BaseAIOUtils.f(75.0f, getResources()), 0, 0);
        this.f186462l0.setLayoutParams(layoutParams);
        this.f186462l0.setOnClickListener(new a());
        Button button = (Button) this.f186462l0.findViewById(R.id.f163996ge);
        this.f186463m0 = button;
        button.setOnClickListener(this);
        ActivateFriendGrid activateFriendGrid = (ActivateFriendGrid) this.f186462l0.findViewById(R.id.cx6);
        this.f186471u0 = activateFriendGrid;
        activateFriendGrid.setGridCallBack(this);
        ArrayList<ActivateFriendItem> arrayList = new ArrayList<>();
        Iterator<w> it = this.f186472v0.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(next.f186529a), "SpecailCareListActivity")) {
                if (QLog.isColorLevel()) {
                    QLog.d("SpecialCare", 2, next.f186529a + " is not friend.. ");
                }
            } else {
                ActivateFriendItem activateFriendItem = new ActivateFriendItem(1, Long.valueOf(next.f186529a).longValue(), next.f186530b);
                if (i3 < 6) {
                    arrayList.add(activateFriendItem);
                    i3++;
                }
            }
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i3), "", "", "");
        this.f186471u0.setData(this.app, arrayList);
        if (this.f186462l0.getParent() == null) {
            ((FrameLayout) getWindow().getDecorView()).addView(this.f186462l0);
        }
        setRightButton(R.string.fnj, this);
    }
}
