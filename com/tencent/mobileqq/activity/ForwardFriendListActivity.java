package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFriendPermissionOption;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactsSearchNTFragment;
import com.tencent.mobileqq.search.business.contact.fragment.FriendPermissionSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ZPlanSearchFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import wn2.ContactSearchModelNtBuddy;
import wn2.ContactSearchModelNtTroop;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ForwardFriendListActivity extends BaseForwardSelectionActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private LinearLayout A0;
    private boolean B0;
    private boolean C0;
    private com.tencent.mobileqq.search.k D0;
    private List<String> E0;
    FormItemRelativeLayout F0;
    FormItemRelativeLayout G0;
    FormItemRelativeLayout H0;
    FormItemRelativeLayout I0;
    FormItemRelativeLayout J0;
    TipsBar K0;
    private hx3.b<Boolean> L0;
    private hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> M0;
    private Map<String, ResultRecord> N0;
    private com.tencent.mobileqq.search.view.f O0;
    private SelectedAndSearchBar.i P0;
    private com.tencent.mobileqq.search.view.d Q0;
    private o.d R0;
    private IFaceDecoder S0;
    private IQQGuildService T0;
    private InputMethodManager U0;
    private Dialog V0;
    private final com.tencent.mobileqq.friend.observer.a W0;
    private com.tencent.mobileqq.matchfriend.utils.d X0;
    private boolean Y0;

    /* renamed from: e0, reason: collision with root package name */
    LinearLayout f175780e0;

    /* renamed from: f0, reason: collision with root package name */
    RelativeLayout f175781f0;

    /* renamed from: g0, reason: collision with root package name */
    private QUISecNavBar f175782g0;

    /* renamed from: h0, reason: collision with root package name */
    private PinnedHeaderExpandableListView f175783h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.adapter.o f175784i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.biz.widgets.a f175785j0;

    /* renamed from: k0, reason: collision with root package name */
    private Handler f175786k0;

    /* renamed from: l0, reason: collision with root package name */
    private FriendsManager f175787l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f175788m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f175789n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f175790o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f175791p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f175792q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f175793r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f175794s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f175795t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f175796u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f175797v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f175798w0;

    /* renamed from: x0, reason: collision with root package name */
    private SelectedAndSearchBar f175799x0;

    /* renamed from: y0, reason: collision with root package name */
    private FrameLayout f175800y0;

    /* renamed from: z0, reason: collision with root package name */
    private View f175801z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            String inputValue = ForwardFriendListActivity.this.f175785j0.getInputValue();
            if (!TextUtils.isEmpty(inputValue)) {
                ForwardFriendListActivity forwardFriendListActivity = ForwardFriendListActivity.this;
                forwardFriendListActivity.D3(forwardFriendListActivity.f175785j0.getEditText());
                Intent intent = new Intent();
                intent.putExtras(ForwardFriendListActivity.this.getIntent().getExtras());
                intent.putExtra("extra_choose_friend_name", inputValue);
                ForwardFriendListActivity.this.setResult(-1, intent);
                ForwardFriendListActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ForwardFriendListActivity.this.f175785j0.dismiss();
            ForwardFriendListActivity forwardFriendListActivity = ForwardFriendListActivity.this;
            forwardFriendListActivity.D3(forwardFriendListActivity.f175785j0.getEditText());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements SelectedAndSearchBar.i {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void a(ResultRecord resultRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultRecord);
                return;
            }
            if (resultRecord != null) {
                ForwardFriendListActivity.this.removeFromForwardTargetList(resultRecord.uin, resultRecord.getUinType());
            }
            ForwardFriendListActivity.this.f175784i0.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                ForwardFriendListActivity.this.Y0 = true;
                if (ForwardFriendListActivity.this.f175800y0.getVisibility() == 0 && ForwardFriendListActivity.this.O0 != null) {
                    ForwardFriendListActivity.this.O0.y8();
                }
                ForwardFriendListActivity.this.f175800y0.setVisibility(8);
                if (!ForwardFriendListActivity.this.f175793r0) {
                    if (ForwardFriendListActivity.this.getIntent().getIntExtra("forward_type", Integer.MAX_VALUE) == 23) {
                        ForwardFriendListActivity.this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.f172003mp2));
                    } else if (ForwardFriendListActivity.this.f175788m0 == 4) {
                        ForwardFriendListActivity.this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.j6l));
                    } else {
                        ForwardFriendListActivity.this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.button_back));
                    }
                }
            } else {
                if (ForwardFriendListActivity.this.Y0) {
                    ForwardFriendListActivity.this.T3();
                    ForwardFriendListActivity.this.Y0 = false;
                }
                if (ForwardFriendListActivity.this.f175800y0.getVisibility() == 8) {
                    ForwardFriendListActivity.this.notifySearchFragmentShow();
                }
                ForwardFriendListActivity.this.f175800y0.setVisibility(0);
                if (!ForwardFriendListActivity.this.f175793r0) {
                    ForwardFriendListActivity.this.f175782g0.setLeftType(2);
                }
            }
            if (ForwardFriendListActivity.this.O0 != null) {
                ForwardFriendListActivity.this.O0.startSearch(obj);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean z16) {
            ArrayList<String> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (z16) {
                if (ForwardFriendListActivity.this.O0 == null) {
                    int i3 = 1;
                    if (ForwardFriendListActivity.this.f175788m0 == 8) {
                        i3 = ForwardFriendListActivity.this.getIntent().getIntExtra(ForwardRecentActivity.KEY_SEARCH_SOURCE, 1);
                    }
                    int i16 = i3;
                    if (ForwardFriendListActivity.this.f175796u0) {
                        List singletonList = Collections.singletonList(ForwardFriendListActivity.this.app.getCurrentAccountUin());
                        ForwardFriendListActivity forwardFriendListActivity = ForwardFriendListActivity.this;
                        forwardFriendListActivity.O0 = ZPlanSearchFragment.Eh(6, i16, null, singletonList, forwardFriendListActivity.Q0, 0, 1L, ForwardFriendListActivity.this.f175797v0);
                    } else if (!ForwardFriendListActivity.this.f175798w0) {
                        boolean z17 = ForwardFriendListActivity.this.f175793r0;
                        if (ForwardFriendListActivity.this.C0) {
                            ForwardFriendListActivity.this.initSearchOperationIoc();
                            z17 = false;
                        }
                        boolean z18 = z17;
                        ForwardFriendListActivity forwardFriendListActivity2 = ForwardFriendListActivity.this;
                        forwardFriendListActivity2.O0 = ContactsSearchNTFragment.INSTANCE.a(6, i16, null, null, forwardFriendListActivity2.Q0, 0, -1L, z18, ForwardFriendListActivity.this.C0, ForwardFriendListActivity.this.D0);
                        ForwardFriendListActivity.this.O0.B5(ForwardFriendListActivity.this.getSelectedUins(), null);
                    } else {
                        ForwardBaseOption forwardBaseOption = ForwardFriendListActivity.this.f175036a0;
                        if (forwardBaseOption instanceof ForwardFriendPermissionOption) {
                            arrayList = ((ForwardFriendPermissionOption) forwardBaseOption).l();
                        } else {
                            arrayList = new ArrayList<>();
                        }
                        ArrayList<String> arrayList2 = arrayList;
                        ForwardFriendListActivity forwardFriendListActivity3 = ForwardFriendListActivity.this;
                        forwardFriendListActivity3.O0 = FriendPermissionSearchFragment.Fh(6, i16, null, null, forwardFriendListActivity3.Q0, 0, 1L, 2, arrayList2);
                    }
                    FragmentTransaction beginTransaction = ForwardFriendListActivity.this.getSupportFragmentManager().beginTransaction();
                    beginTransaction.add(R.id.result_layout, ForwardFriendListActivity.this.O0.getFragment());
                    beginTransaction.commitAllowingStateLoss();
                }
                ForwardFriendListActivity.this.S3();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements com.tencent.mobileqq.search.view.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0158 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0116  */
        @Override // com.tencent.mobileqq.search.view.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAction(View view) {
            String str;
            String uin;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
            if (kVar == null) {
                return;
            }
            int i3 = 0;
            boolean g16 = com.tencent.relation.common.config.toggle.c.T.g(false);
            if (QLog.isColorLevel()) {
                QLog.i("ForwardFriendListActivity", 2, "isForwardOpt = " + g16);
            }
            String uin2 = kVar.getUin();
            String charSequence = kVar.getTitle().toString();
            if (kVar instanceof wn2.b) {
                uin = ((wn2.b) kVar).d();
            } else {
                if (kVar instanceof wn2.i) {
                    str2 = ((wn2.i) kVar).X;
                } else if (kVar instanceof wn2.q) {
                    str2 = ((wn2.q) kVar).a().troopuin;
                } else {
                    str = "-1";
                    if (!(kVar instanceof wn2.c)) {
                        if (g16 && (kVar instanceof wn2.a)) {
                            uin = ((wn2.a) kVar).getUin();
                        } else if ((kVar instanceof wn2.n) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100388", false)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ForwardFriendListActivity", 2, "isSetTypeToggle " + ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100388", false));
                            }
                            i3 = 1004;
                        } else if (kVar instanceof ContactSearchModelNtBuddy) {
                            String fromGroupCode = ((ContactSearchModelNtBuddy) kVar).getFromGroupCode();
                            if (!TextUtils.isEmpty(fromGroupCode)) {
                                str = fromGroupCode;
                            }
                            i3 = kVar.M();
                        } else if (kVar instanceof ContactSearchModelNtTroop) {
                            String uin3 = kVar.getUin();
                            i3 = kVar.M();
                            str = uin3;
                        } else {
                            i3 = -1;
                        }
                    }
                    if (ForwardFriendListActivity.this.f175793r0) {
                        if (i3 != -1 && ForwardFriendListActivity.this.add2ForwardTargetList(new ResultRecord(uin2, charSequence, i3, str, ""))) {
                            ForwardFriendListActivity.this.f175784i0.notifyDataSetChanged();
                        }
                    } else {
                        if (TextUtils.isEmpty(uin2)) {
                            return;
                        }
                        View view2 = new View(ForwardFriendListActivity.this);
                        o.e eVar = new o.e();
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin2);
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                        dVar.w0(uin2);
                        dVar.v0(uidFromUin);
                        dVar.k0(charSequence);
                        dVar.m0(charSequence);
                        eVar.f187232i = dVar;
                        view2.setTag(eVar);
                        ForwardFriendListActivity.this.M3(view2);
                    }
                    if (ForwardFriendListActivity.this.O0 == null) {
                        return;
                    }
                    if (!ForwardFriendListActivity.this.O0.L5()) {
                        ForwardFriendListActivity.this.quitSearchState();
                        return;
                    } else {
                        ForwardFriendListActivity.this.f175799x0.w();
                        return;
                    }
                }
                i3 = 1;
                str = str2;
                if (ForwardFriendListActivity.this.f175793r0) {
                }
                if (ForwardFriendListActivity.this.O0 == null) {
                }
            }
            str = uin;
            i3 = 3000;
            if (ForwardFriendListActivity.this.f175793r0) {
            }
            if (ForwardFriendListActivity.this.O0 == null) {
            }
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void selectedItemClick(String str, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (ForwardFriendListActivity.this.f175793r0 && z16) {
                ForwardFriendListActivity.this.removeFromForwardTargetList(str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements com.tencent.mobileqq.search.k {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.i("ForwardFriendListActivity", 1, "setSearchFragmentVisibility " + z16);
            if (!z16) {
                ForwardFriendListActivity.this.quitSearchState();
            } else if (ForwardFriendListActivity.this.f175800y0.getVisibility() == 8) {
                ForwardFriendListActivity.this.f175800y0.setVisibility(0);
                if (ForwardFriendListActivity.this.O0 != null) {
                    ForwardFriendListActivity.this.O0.tb();
                }
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f implements o.d {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.adapter.o.d
        public boolean a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ForwardFriendListActivity.this.isForwardTargetSelected(str, i3);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).booleanValue();
        }

        @Override // com.tencent.mobileqq.adapter.o.d
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else if (ForwardFriendListActivity.this.f175793r0) {
                ForwardFriendListActivity.this.onListViewItemClickedInMultiSelectStatus(view);
            } else {
                ForwardFriendListActivity.this.M3(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFriendListActivity.this.L3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class h extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateSetFriendPermission(boolean z16, HashMap<String, Integer> hashMap, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap, Integer.valueOf(i3));
                return;
            }
            ForwardBaseOption forwardBaseOption = ForwardFriendListActivity.this.f175036a0;
            if (forwardBaseOption != null) {
                forwardBaseOption.hideProgressDialog();
            }
            if (z16 && hashMap != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                for (String str : hashMap.keySet()) {
                    Integer num = 0;
                    if (num.equals(hashMap.get(str))) {
                        arrayList.add(str);
                    } else {
                        arrayList2.add(str);
                    }
                }
                int size = arrayList2.size();
                if (size > 0) {
                    QQToastUtil.showQQToast(1, R.string.f225476lq, Integer.valueOf(size));
                } else {
                    QQToastUtil.showQQToast(2, R.string.f225446ln, Integer.valueOf(arrayList.size()));
                }
                Intent intent = new Intent();
                intent.putStringArrayListExtra("only_chat_add_uins", arrayList);
                ForwardFriendListActivity.this.setResult(-1, intent);
                ForwardFriendListActivity.this.finish();
                return;
            }
            QQToastUtil.showQQToast(-1, R.string.ykp);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class i implements hx3.b<Boolean> {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else if (ForwardFriendListActivity.this.f175793r0) {
                ForwardFriendListActivity.this.H3(ForwardFriendListActivity.this.getIntent().getParcelableArrayListExtra("selected_target_list"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ForwardFriendListActivity.this.app != null) {
                Intent intent = new Intent();
                intent.putExtras(ForwardFriendListActivity.this.getIntent().getExtras());
                intent.putExtra("extra_choose_friend_uin", ForwardFriendListActivity.this.app.getAccount());
                intent.putExtra("extra_choose_friend_name", ForwardFriendListActivity.this.app.getCurrentNickname());
                ForwardFriendListActivity.this.setResult(-1, intent);
                ForwardFriendListActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFriendListActivity.this.K3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFriendListActivity.this.K3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFriendListActivity.this.L3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFriendListActivity.this.L3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFriendListActivity.this.K3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements hx3.b<Boolean> {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else if (ForwardFriendListActivity.this.f175793r0) {
                ForwardFriendListActivity.this.H3(ForwardFriendListActivity.this.getIntent().getParcelableArrayListExtra("selected_target_list"));
            }
        }
    }

    public ForwardFriendListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175786k0 = new Handler();
        this.f175790o0 = false;
        this.f175792q0 = false;
        this.f175794s0 = 9;
        this.f175795t0 = "";
        this.f175796u0 = false;
        this.f175798w0 = false;
        this.B0 = false;
        this.C0 = false;
        this.E0 = new ArrayList();
        this.L0 = new i();
        this.M0 = new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.activity.ForwardFriendListActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar != null && eVar.a() == 0 && eVar.b() != null) {
                    ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16 = eVar.b();
                    ArrayList arrayList = new ArrayList();
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
                    if (b16.size() > 0) {
                        com.tencent.mobileqq.adapter.o.p(1003);
                    } else {
                        com.tencent.mobileqq.adapter.o.p(0);
                    }
                    bVar.j(com.tencent.mobileqq.adapter.o.m());
                    bVar.l(HardCodeUtil.qqStr(R.string.mov));
                    arrayList.add(0, bVar);
                    arrayList.addAll(b16);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.activity.ForwardFriendListActivity.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ List f175805d;

                        {
                            this.f175805d = arrayList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) arrayList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            QLog.e("ForwardFriendListActivity", 2, "onQueryResult recentInfo list size: " + this.f175805d.size());
                            if (ForwardFriendListActivity.this.f175784i0 == null) {
                                if (ForwardFriendListActivity.this.f175796u0) {
                                    ForwardFriendListActivity forwardFriendListActivity = ForwardFriendListActivity.this;
                                    ForwardFriendListActivity forwardFriendListActivity2 = ForwardFriendListActivity.this;
                                    PinnedHeaderExpandableListView pinnedHeaderExpandableListView = forwardFriendListActivity2.f175783h0;
                                    ForwardFriendListActivity forwardFriendListActivity3 = ForwardFriendListActivity.this;
                                    forwardFriendListActivity.f175784i0 = new com.tencent.mobileqq.adapter.am(forwardFriendListActivity2, pinnedHeaderExpandableListView, forwardFriendListActivity3.app, this.f175805d, forwardFriendListActivity3.R0, ForwardFriendListActivity.this.f175793r0, null);
                                } else if (ForwardFriendListActivity.this.f175798w0) {
                                    ForwardFriendListActivity forwardFriendListActivity4 = ForwardFriendListActivity.this;
                                    ForwardFriendListActivity forwardFriendListActivity5 = ForwardFriendListActivity.this;
                                    PinnedHeaderExpandableListView pinnedHeaderExpandableListView2 = forwardFriendListActivity5.f175783h0;
                                    ForwardFriendListActivity forwardFriendListActivity6 = ForwardFriendListActivity.this;
                                    forwardFriendListActivity4.f175784i0 = new com.tencent.mobileqq.adapter.p(forwardFriendListActivity5, pinnedHeaderExpandableListView2, forwardFriendListActivity6.app, this.f175805d, forwardFriendListActivity6.R0, ForwardFriendListActivity.this.f175793r0, null);
                                } else {
                                    ForwardFriendListActivity forwardFriendListActivity7 = ForwardFriendListActivity.this;
                                    ForwardFriendListActivity forwardFriendListActivity8 = ForwardFriendListActivity.this;
                                    PinnedHeaderExpandableListView pinnedHeaderExpandableListView3 = forwardFriendListActivity8.f175783h0;
                                    ForwardFriendListActivity forwardFriendListActivity9 = ForwardFriendListActivity.this;
                                    forwardFriendListActivity7.f175784i0 = new com.tencent.mobileqq.adapter.o(forwardFriendListActivity8, pinnedHeaderExpandableListView3, forwardFriendListActivity9.app, this.f175805d, forwardFriendListActivity9.R0, ForwardFriendListActivity.this.f175793r0, null, ForwardFriendListActivity.this.B0);
                                }
                                ForwardFriendListActivity.this.f175783h0.setAdapter(ForwardFriendListActivity.this.f175784i0);
                                if (ForwardFriendListActivity.this.f175792q0 && this.f175805d.size() > 1) {
                                    ForwardFriendListActivity.this.f175783h0.expandGroup(1);
                                } else {
                                    ForwardFriendListActivity.this.f175783h0.expandGroup(0);
                                }
                                if (ForwardFriendListActivity.this.L0 != null) {
                                    ForwardFriendListActivity.this.L0.onQueryResult(null);
                                }
                            } else {
                                ForwardFriendListActivity.this.f175784i0.o(this.f175805d, true, null);
                            }
                            if (ForwardFriendListActivity.this.L0 != null) {
                                ForwardFriendListActivity.this.L0.onQueryResult(null);
                            }
                        }
                    });
                    return;
                }
                if (ForwardFriendListActivity.this.L0 != null) {
                    ForwardFriendListActivity.this.L0.onQueryResult(null);
                }
            }
        };
        this.N0 = new LinkedHashMap();
        this.P0 = new c();
        this.Q0 = new d();
        this.R0 = new f();
        this.W0 = new h();
        this.Y0 = true;
    }

    private void A3() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.N0.values());
        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
        Intent intent = new Intent();
        intent.putExtras(getIntent().getExtras());
        intent.putParcelableArrayListExtra("selected_target_list", arrayList);
        setResult(-1, intent);
        finish();
    }

    private String B3() {
        if (!TextUtils.isEmpty(this.f175795t0)) {
            return this.f175795t0;
        }
        return HardCodeUtil.qqStr(R.string.mpq);
    }

    private String C3(int i3) {
        return "(" + i3 + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3(View view) {
        this.f175786k0.post(new Runnable(view) { // from class: com.tencent.mobileqq.activity.ForwardFriendListActivity.13
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f175803d;

            {
                this.f175803d = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    InputMethodUtil.hide(this.f175803d);
                }
            }
        });
    }

    private void E3() {
        int i3 = 0;
        View inflate = LayoutInflater.from(this).inflate(R.layout.f167969o3, (ViewGroup) this.f175783h0, false);
        this.f175801z0 = inflate;
        inflate.setOverScrollMode(2);
        if (getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 0) != 9501) {
            this.f175783h0.addHeaderView(this.f175801z0);
        }
        this.A0 = (LinearLayout) this.f175801z0.findViewById(R.id.ed_);
        this.F0 = (FormItemRelativeLayout) this.f175801z0.findViewById(R.id.cje);
        this.G0 = (FormItemRelativeLayout) this.f175801z0.findViewById(R.id.cjh);
        this.H0 = (FormItemRelativeLayout) this.f175801z0.findViewById(R.id.cjk);
        this.I0 = (FormItemRelativeLayout) this.f175801z0.findViewById(R.id.cjg);
        this.J0 = (FormItemRelativeLayout) this.f175801z0.findViewById(R.id.lik);
        this.K0 = (TipsBar) this.f175801z0.findViewById(R.id.m_l);
        this.F0.setVisibility(8);
        this.G0.setVisibility(8);
        this.I0.setVisibility(8);
        this.J0.setVisibility(8);
        this.K0.setVisibility(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_forward_is_show_troop", false);
        getIntent().getBooleanExtra("key_forward_is_show_guild", false);
        FormItemRelativeLayout formItemRelativeLayout = this.H0;
        if (!booleanExtra) {
            i3 = 8;
        }
        formItemRelativeLayout.setVisibility(i3);
        this.H0.setOnClickListener(this);
        this.H0.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        V3();
        if (this.F0.getVisibility() == 0 || this.G0.getVisibility() == 0 || this.H0.getVisibility() == 0 || this.I0.getVisibility() == 0 || this.J0.getVisibility() == 0) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dpToPx(12.0f)));
            this.f175783h0.addHeaderView(linearLayout);
        }
    }

    private void G3() {
        if (!this.f175790o0) {
            this.f175782g0.setLeftType(2);
        }
        this.f175782g0.setRightType(1);
        this.f175782g0.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new g());
        refreshRightBtn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H3(List<ResultRecord> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<ResultRecord> it = list.iterator();
            while (it.hasNext()) {
                add2ForwardTargetList(it.next());
            }
        }
    }

    private boolean I3(String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return false;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b friendsCategoryInfo = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsCategoryInfo(String.valueOf(((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()), "ForwardFriendListActivity");
        if (friendsCategoryInfo == null) {
            return false;
        }
        Iterator<String> it = friendsCategoryInfo.c().iterator();
        while (it.hasNext()) {
            if (uidFromUin.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J3(DialogInterface dialogInterface, int i3) {
        if (!isFinishing()) {
            this.V0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3() {
        quitSearchState();
        if (this.f175793r0) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(this.N0.values()));
            setResult(0, intent);
            finish();
            return;
        }
        if (this.f175782g0.getLeftText().equals("")) {
            this.f175800y0.setVisibility(8);
            if (getIntent().getIntExtra("forward_type", Integer.MAX_VALUE) == 23) {
                this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.f172003mp2));
                return;
            } else if (this.f175788m0 == 4) {
                this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.j6l));
                return;
            } else {
                this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.button_back));
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3() {
        Q3();
        int i3 = this.f175788m0;
        if (i3 == 6) {
            X3();
            return;
        }
        if (i3 == 9) {
            A3();
            return;
        }
        if (this.f175793r0) {
            forward2MultiTargets();
            return;
        }
        ForwardBaseOption forwardBaseOption = this.f175036a0;
        if (forwardBaseOption != null) {
            forwardBaseOption.endForwardCallback(false);
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
        }
        setResult(1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M3(View view) {
        String str;
        o.e eVar = (o.e) view.getTag();
        if (eVar != null) {
            Object obj = eVar.f187232i;
            Object obj2 = obj;
            if (this.f175787l0 != null) {
                boolean z16 = obj instanceof RobotCoreInfo;
                obj2 = obj;
                if (z16) {
                    String valueOf = String.valueOf(((RobotCoreInfo) obj).robotUin);
                    obj2 = obj;
                    if (this.f175787l0.c0(valueOf)) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                        dVar.w0(valueOf);
                        dVar.v0(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf));
                        obj2 = dVar;
                    }
                }
            }
            if (obj2 != null && (obj2 instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d)) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj2;
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(dVar2.x()), "ForwardFriendListActivity");
                boolean z17 = false;
                if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                    int i3 = this.f175788m0;
                    if (i3 != 1 && i3 != 4 && i3 != 3 && i3 != 6 && i3 != 7 && i3 != 9) {
                        TextView textView = (TextView) view.findViewById(R.id.text1);
                        if (textView != null) {
                            if (textView.getText() != null) {
                                str = textView.getText().toString();
                            } else {
                                str = null;
                            }
                        } else {
                            str = "Ta";
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", dVar2.x());
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(dVar2.x());
                        if (!TextUtils.isEmpty(uidFromUin)) {
                            bundle.putString(AppConstants.Key.UID, uidFromUin);
                        }
                        bundle.putInt("uintype", 0);
                        bundle.putString("uinname", str);
                        bundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.f307203d0.intValue());
                        if (getIntent() != null) {
                            z17 = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
                        }
                        if (z17) {
                            String stringExtra = getIntent().getStringExtra("choose_friend_confirmTitle");
                            String stringExtra2 = getIntent().getStringExtra("choose_friend_confirmContent");
                            bundle.putBoolean("choose_friend_needConfirm", z17);
                            bundle.putString("choose_friend_confirmTitle", stringExtra);
                            bundle.putString("choose_friend_confirmContent", stringExtra2);
                        }
                        this.f175036a0.buildForwardDialog(com.tencent.mobileqq.forward.e.O3.intValue(), bundle);
                        return;
                    }
                    if (this.f175789n0 == 2) {
                        if (I3(dVar2.x())) {
                            QQToast.makeText(this, getString(R.string.fu5), 0).show(getTitleBarHeight());
                            return;
                        }
                        if (this.app.getCurrentUin().equals(dVar2.x())) {
                            QQToast.makeText(this, getString(R.string.f170678y9), 0).show(getTitleBarHeight());
                            return;
                        }
                        Intent intent = new Intent(this, (Class<?>) QQSpecialFriendSettingActivity.class);
                        intent.putExtra("key_friend_uin", dVar2.x());
                        intent.putExtra("key_is_from_friendsforward_activity", true);
                        startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtras(getIntent().getExtras());
                    intent2.putExtra("extra_choose_friend_uin", dVar2.x());
                    intent2.putExtra("extra_choose_friend_name", dVar2.p());
                    intent2.putExtra("extraChooseFriendRemark", dVar2.r());
                    setResult(-1, intent2);
                    finish();
                    return;
                }
                QQToast.makeText(this, 1, getString(R.string.f2047953v), 0).show(getTitleBarHeight());
            }
        }
    }

    private void Q3() {
        if (this.X0 != null) {
            Iterator it = new ArrayList(this.N0.values()).iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                int i17 = ((ResultRecord) it.next()).uinType;
                if (i17 == 0) {
                    i3++;
                } else if (i17 == 1) {
                    i16++;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("choose_multiple_finish_fri_quantity", Integer.valueOf(i3));
            hashMap.put("choose_multiple_finish_grp_quantity", Integer.valueOf(i16));
            this.X0.e("em_choose_multiple_finish", hashMap);
        }
    }

    private void R3(Map<String, Object> map) {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.X0;
        if (dVar != null) {
            dVar.i(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3() {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.X0;
        if (dVar != null) {
            dVar.d("em_choose_fri_multiple_search");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T3() {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.X0;
        if (dVar != null) {
            dVar.l("em_choose_fri_multiple_search", "ev_choose_multiple_enter");
        }
    }

    private void V3() {
        if (this.H0.getVisibility() == 0) {
            String stringExtra = getIntent().getStringExtra("extra_troop_entrance_title");
            if (!TextUtils.isEmpty(stringExtra)) {
                ((TextView) this.H0.findViewById(R.id.akw)).setText(stringExtra);
            }
        }
    }

    private void W3(View view) {
        this.f175786k0.post(new Runnable(view) { // from class: com.tencent.mobileqq.activity.ForwardFriendListActivity.12
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f175802d;

            {
                this.f175802d = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFriendListActivity.this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    InputMethodUtil.show(this.f175802d);
                }
            }
        });
    }

    private void X3() {
        if (this.f175785j0 == null) {
            this.f175785j0 = com.tencent.biz.widgets.a.N(this, HardCodeUtil.qqStr(R.string.moq), "", R.string.cancel, R.string.f171151ok, new a(), new b());
        }
        if (!this.f175785j0.isShowing()) {
            this.f175785j0.show();
            W3(this.f175785j0.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean add2ForwardTargetList(ResultRecord resultRecord) {
        if (resultRecord == null) {
            return false;
        }
        String forwardTargetKey = getForwardTargetKey(resultRecord.uin, resultRecord.getUinType());
        ResultRecord resultRecord2 = this.N0.get(forwardTargetKey);
        if (resultRecord2 != null) {
            resultRecord2.lastChooseTime = SystemClock.elapsedRealtime();
            this.f175799x0.H(new ArrayList(this.N0.values()), false);
            return false;
        }
        if (this.N0.size() == this.f175794s0) {
            showForwardCountLimitDialog();
            return false;
        }
        ResultRecord copyResultRecord = ResultRecord.copyResultRecord(resultRecord);
        copyResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
        this.N0.put(forwardTargetKey, copyResultRecord);
        refreshRightBtn();
        this.f175799x0.H(new ArrayList(this.N0.values()), true);
        setSearchSelectedAndJoinedUins();
        return true;
    }

    private void forward2MultiTargets() {
        if (this.f175036a0 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ForwardFriendListActivity", 2, "forwardOption is null, return.");
            }
        } else if (this.N0.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("ForwardFriendListActivity", 2, "forward2MultiTargets map is empty !");
            }
        } else {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.N0.values());
            Collections.sort(arrayList, new ResultRecord.DefaultComparator());
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, arrayList);
            this.f175036a0.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle);
            this.f175036a0.reportForward();
        }
    }

    private String getForwardTargetKey(String str, int i3) {
        return i3 + "_" + str;
    }

    private List<String> getJoinUins() {
        if (this.C0) {
            return this.E0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getSelectedUins() {
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.N0.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        return arrayList;
    }

    private void initData() {
        if (this.f175787l0 == null) {
            this.f175787l0 = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        }
        P3(new p());
    }

    private void initReport() {
        int i3;
        int i16;
        this.X0 = new com.tencent.mobileqq.matchfriend.utils.d(this);
        HashMap hashMap = new HashMap();
        if (this.f175790o0) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("choose_fri_multiple_type", Integer.valueOf(i3));
        if (this.f175788m0 == 9) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        hashMap.put("choose_fri_multiple_source", Integer.valueOf(i16));
        hashMap.put("choose_fri_multiple_page_type", 1);
        this.X0.c("pg_choose_fri_multiple", hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_choose_fri_multiple_search");
        arrayList.add("em_choose_multiple_finish");
        this.X0.b(arrayList);
        R3(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSearchOperationIoc() {
        if (this.D0 == null) {
            this.D0 = new e();
        }
    }

    private void initSelectedAndSearchBar() {
        this.U0 = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.f175799x0 = (SelectedAndSearchBar) super.findViewById(R.id.imi);
        this.S0 = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        IQQGuildService iQQGuildService = (IQQGuildService) this.app.getRuntimeService(IQQGuildService.class, "");
        this.T0 = iQQGuildService;
        this.f175799x0.t(null, this.S0, this.P0, iQQGuildService);
        this.f175799x0.setVisibility(0);
    }

    @TargetApi(14)
    private void initTitleBar() {
        this.f175780e0 = (LinearLayout) findViewById(R.id.root);
        findViewById(R.id.idz).setVisibility(8);
        findViewById(R.id.vdz).setVisibility(0);
        if (ImmersiveUtils.isSupporImmersive() == 1 && this.mNeedStatusTrans) {
            this.f175780e0.setFitsSystemWindows(true);
            this.f175780e0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        this.f175781f0 = (RelativeLayout) findViewById(R.id.idz);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById(R.id.vdz);
        this.f175782g0 = qUISecNavBar;
        qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.f172001mp0));
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("extra_forward_title");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f175782g0.setCenterText(stringExtra);
            }
        }
        if (this.f175788m0 == 8) {
            this.f175782g0.setCenterText(HardCodeUtil.qqStr(R.string.f170745zm3));
        }
        this.f175782g0.setLeftType(2);
        QUISecNavBar qUISecNavBar2 = this.f175782g0;
        BaseAction baseAction = BaseAction.ACTION_LEFT_BUTTON;
        qUISecNavBar2.setBaseClickListener(baseAction, new k());
        if (this.f175789n0 == 2) {
            this.f175782g0.setLeftType(0);
        } else {
            this.f175782g0.setLeftType(1);
            this.f175782g0.setBaseClickListener(BaseAction.ACTION_LEFT_TEXT, new l());
            if (getIntent().getIntExtra("forward_type", Integer.MAX_VALUE) == 23) {
                this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.f172003mp2));
            } else if (this.f175788m0 == 4) {
                this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.j6l));
            } else {
                this.f175782g0.setLeftText(HardCodeUtil.qqStr(R.string.button_back));
            }
        }
        this.f175782g0.setRightType(0);
        int i3 = this.f175788m0;
        if (i3 == 6) {
            this.f175782g0.setRightType(1);
            this.f175782g0.setRightText(HardCodeUtil.qqStr(R.string.moz));
            this.f175782g0.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new m());
        } else if (i3 != 4 && i3 != 5) {
            this.f175782g0.setRightType(1);
            this.f175782g0.setRightText(HardCodeUtil.qqStr(R.string.cancel));
            this.f175782g0.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new n());
        }
        if (this.f175790o0) {
            if (this.f175788m0 == 9 && !this.f175793r0) {
                this.f175782g0.setLeftType(0);
                return;
            }
            this.f175782g0.setLeftType(2);
            this.f175782g0.setLeftImageRes(R.drawable.qui_close_icon_navigation_01);
            this.f175782g0.setBaseClickListener(baseAction, new o());
        }
    }

    private void initUI() {
        initTitleBar();
        PinnedHeaderExpandableListView pinnedHeaderExpandableListView = (PinnedHeaderExpandableListView) findViewById(R.id.cny);
        this.f175783h0 = pinnedHeaderExpandableListView;
        pinnedHeaderExpandableListView.setGroupIndicator(null);
        LayoutInflater.from(this);
        this.f175800y0 = (FrameLayout) findViewById(R.id.result_layout);
        if (this.f175790o0) {
            ((RoundFrameLayout) findViewById(R.id.ifd)).setRadius(ViewUtils.dip2px(10.0f));
        }
        initSelectedAndSearchBar();
        E3();
        if (this.f175793r0) {
            G3();
        }
        int i3 = this.f175788m0;
        if (i3 == 6 || i3 == 7) {
            z3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isForwardTargetSelected(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.N0.containsKey(getForwardTargetKey(str, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySearchFragmentShow() {
        this.E0.clear();
        this.E0.addAll(getSelectedUins());
        setSearchSelectedAndJoinedUins();
        com.tencent.mobileqq.search.view.f fVar = this.O0;
        if (fVar != null) {
            fVar.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListViewItemClickedInMultiSelectStatus(View view) {
        ResultRecord resultRecord = ((ForwardRecentItemView) view).J;
        if (resultRecord != null && isForwardTargetSelected(resultRecord.uin, resultRecord.getUinType())) {
            removeFromForwardTargetList(resultRecord.uin, resultRecord.getUinType());
        } else {
            add2ForwardTargetList(resultRecord);
        }
        this.f175784i0.notifyDataSetChanged();
    }

    private void popupSearchDialog(int i3) {
        int i16;
        int i17 = 1;
        if (i3 == 11) {
            i16 = 21003;
        } else if (i3 == 6) {
            i16 = 21002;
        } else if (i3 == 16) {
            i16 = 21009;
        } else if (i3 == 18) {
            i16 = 21010;
        } else {
            if (i3 == 27) {
                i17 = getIntent().getIntExtra(ForwardRecentActivity.KEY_SEARCH_SOURCE, 1);
            }
            i16 = 21001;
        }
        ContactSearchComponentActivity.V2(this, null, i3, i17, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitSearchState() {
        com.tencent.mobileqq.search.view.f fVar;
        this.U0.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
        this.f175799x0.u();
        this.f175799x0.v();
        FrameLayout frameLayout = this.f175800y0;
        if (frameLayout != null && frameLayout.getVisibility() == 0 && (fVar = this.O0) != null) {
            fVar.y8();
        }
        this.f175800y0.setVisibility(8);
    }

    private void refreshRightBtn() {
        if (this.N0.isEmpty()) {
            this.f175782g0.setRightText(B3());
            this.f175782g0.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
            return;
        }
        this.f175782g0.setRightText(B3() + C3(this.N0.size()));
        this.f175782g0.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromForwardTargetList(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.N0.remove(getForwardTargetKey(str, i3));
        refreshRightBtn();
        this.f175799x0.H(new ArrayList(this.N0.values()), true);
        this.E0.remove(str);
        setSearchSelectedAndJoinedUins();
    }

    private void setSearchSelectedAndJoinedUins() {
        List<String> selectedUins = getSelectedUins();
        com.tencent.mobileqq.search.view.f fVar = this.O0;
        if (fVar != null) {
            fVar.B5(selectedUins, getJoinUins());
        }
    }

    private void showForwardCountLimitDialog() {
        if (this.V0 == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, (String) null, String.format(getString(R.string.f199254ox), Integer.valueOf(this.f175794s0)), (String) null, getString(R.string.cpy), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.bu
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ForwardFriendListActivity.this.J3(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            this.V0 = createCustomDialog;
            createCustomDialog.setCanceledOnTouchOutside(false);
        }
        if (!isFinishing()) {
            this.V0.show();
        }
    }

    private void z3() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            String currentNickname = this.app.getCurrentNickname();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f169062bw4, (ViewGroup) this.f175783h0, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
            TextView textView = (TextView) inflate.findViewById(R.id.text1);
            if (imageView != null) {
                imageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, account));
            }
            if (textView != null) {
                textView.setText(currentNickname);
            }
            inflate.setOnClickListener(new j());
            PinnedHeaderExpandableListView pinnedHeaderExpandableListView = this.f175783h0;
            if (pinnedHeaderExpandableListView != null) {
                pinnedHeaderExpandableListView.addHeaderView(inflate);
            }
        }
    }

    public void F3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.f175790o0) {
            return;
        }
        try {
            U3();
            Window window = getWindow();
            window.setFormat(-3);
            WindowManager.LayoutParams attributes = window.getAttributes();
            int height = getWindowManager().getDefaultDisplay().getHeight() - ViewUtils.dpToPx(88.0f);
            attributes.height = height;
            this.f175791p0 = height;
            attributes.gravity = 81;
            window.setAttributes(attributes);
            View decorView = window.getDecorView();
            decorView.setScaleX(1.0f);
            decorView.setScaleY(1.0f);
        } catch (Exception e16) {
            QLog.e("ForwardFriendListActivity", 1, "initMiniWindow ", e16);
        }
    }

    protected void P3(hx3.b<Boolean> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(false, "ForwardFriendListActivity", false, this.M0);
        }
    }

    public void U3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarVisible(2, 0);
        }
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16 = true;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        } else if (!this.f175790o0) {
            z16 = super.dispatchTouchEvent(motionEvent);
        } else {
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            motionEvent.offsetLocation(((x16 - ((defaultDisplay.getWidth() * 0.0f) / 2.0f)) / 1.0f) - x16, ((y16 - ((defaultDisplay.getHeight() * 0.0f) / 2.0f)) / 1.0f) - y16);
            if (!super.dispatchTouchEvent(motionEvent) && (y16 > this.f175791p0 || y16 < 0.0f)) {
                finish();
            } else {
                z16 = false;
            }
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        ArrayList parcelableArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 != 20000) {
                if (i3 != 21002) {
                    if (i3 != 21003) {
                        if (i3 != 21009) {
                            if (i3 == 21010 && intent != null) {
                                Intent intent2 = new Intent();
                                intent2.putExtras(getIntent().getExtras());
                                intent2.putExtra("extra_choose_friend_uin", intent.getStringExtra("contactSearchResultUin"));
                                intent2.putExtra("extraChooseFriendRemark", intent.getStringExtra("contactSearchResultName"));
                                intent2.putExtra("extra_choose_friend_name", intent.getStringExtra("contactSearchResultNick"));
                                setResult(-1, intent2);
                                finish();
                                return;
                            }
                            return;
                        }
                        if (intent != null) {
                            Intent intent3 = new Intent();
                            intent3.putExtras(getIntent().getExtras());
                            intent3.putExtra("extra_choose_friend_uin", intent.getStringExtra("contactSearchResultUin"));
                            intent3.putExtra("extra_choose_friend_name", intent.getStringExtra("contactSearchResultName"));
                            setResult(-1, intent3);
                            finish();
                            return;
                        }
                        return;
                    }
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("contactSearchResultUin");
                        Intent intent4 = new Intent(this, (Class<?>) QQSpecialFriendSettingActivity.class);
                        intent4.putExtra("key_friend_uin", stringExtra);
                        intent4.putExtra("key_is_from_friendsforward_activity", true);
                        startActivity(intent4);
                        return;
                    }
                    return;
                }
                if (getIntent() != null) {
                    z16 = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
                }
                if (z16) {
                    String stringExtra2 = getIntent().getStringExtra("choose_friend_confirmTitle");
                    String stringExtra3 = getIntent().getStringExtra("choose_friend_confirmContent");
                    intent.putExtra("choose_friend_needConfirm", z16);
                    intent.putExtra("choose_friend_confirmTitle", stringExtra2);
                    intent.putExtra("choose_friend_confirmContent", stringExtra3);
                }
                SearchUtil.h(intent, this.f175036a0);
                return;
            }
            setResult(-1, intent);
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        if (i16 == 0 && i3 == 20000 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("selected_target_list")) != null) {
            this.N0.clear();
            if (parcelableArrayListExtra.isEmpty()) {
                this.f175799x0.H(parcelableArrayListExtra, false);
                this.f175784i0.notifyDataSetChanged();
                refreshRightBtn();
            } else {
                Collections.sort(parcelableArrayListExtra, new ResultRecord.DefaultComparator());
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    add2ForwardTargetList((ResultRecord) it.next());
                }
                this.f175784i0.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100231", false);
        if (this.f175793r0 || !isSwitchOn) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(this.N0.values()));
            setResult(0, intent);
        }
        super.doOnBackPressed();
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        if (!AppSetting.t(this)) {
            setRequestedOrientation(1);
        }
        this.f175790o0 = getIntent().getBooleanExtra("extra_mini_mode", false);
        this.f175792q0 = getIntent().getBooleanExtra("extra_show_friend_first", false);
        this.B0 = getIntent().getBooleanExtra("extra_shield_robot_friend", false);
        this.f175789n0 = getIntent().getIntExtra("extra_add_special_friend", 0);
        this.f175788m0 = getIntent().getIntExtra("extra_choose_friend", 0);
        this.f175794s0 = Math.min(getIntent().getIntExtra(AppConstants.Key.GUILD_PASS_CHECK_NUMBER, this.f175794s0), this.f175794s0);
        this.f175794s0 = getIntent().getIntExtra("extra_max_num", this.f175794s0);
        super.doOnCreate(bundle);
        getWindow().setBackgroundDrawable(null);
        super.setContentView(R.layout.f167970o4);
        this.f175793r0 = !getIntent().getBooleanExtra("only_single_selection", true);
        boolean booleanExtra = getIntent().getBooleanExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, false);
        this.f175796u0 = booleanExtra;
        if (booleanExtra) {
            this.f175797v0 = getIntent().getStringExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID);
        }
        this.f175798w0 = getIntent().getBooleanExtra(ForwardRecentActivity.KEY_FORWARD_FROM_FRIEND_PERMISSION, false);
        this.f175795t0 = getIntent().getStringExtra("extra_select_finish_text");
        this.C0 = getIntent().getBooleanExtra("key_is_search_default_single_mode", false);
        initUI();
        F3();
        initData();
        initReport();
        this.app.addObserver(this.W0);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.app.removeObserver(this.W0);
        com.tencent.mobileqq.adapter.o oVar = this.f175784i0;
        if (oVar != null) {
            oVar.destroy();
            this.f175783h0.setAdapter((ExpandableListAdapter) null);
        }
        com.tencent.biz.widgets.a aVar = this.f175785j0;
        if (aVar != null) {
            aVar.dismiss();
        }
        IFaceDecoder iFaceDecoder = this.S0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.M0 = null;
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.finish();
        if (this.f175789n0 != 2 && this.f175788m0 != 4) {
            overridePendingTransition(0, R.anim.f154423k);
        } else {
            overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f175800y0.getVisibility() != 8) {
            quitSearchState();
            return true;
        }
        if (this.f175799x0.E()) {
            quitSearchState();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.et_search_keyword) {
                int i3 = this.f175788m0;
                if (i3 == 1) {
                    popupSearchDialog(11);
                } else if (i3 != 3 && i3 != 6 && i3 != 7) {
                    if (i3 == 4) {
                        popupSearchDialog(18);
                    } else if (i3 == 8) {
                        popupSearchDialog(27);
                        QQAppInterface qQAppInterface = this.app;
                        String currentUin = qQAppInterface.getCurrentUin();
                        boolean z16 = this.f175793r0;
                        if (z16) {
                            str3 = "2";
                        } else {
                            str3 = "1";
                        }
                        if (z16) {
                            str4 = "0";
                        } else {
                            str4 = "1";
                        }
                        ReportController.n(qQAppInterface, "P_CliOper", "dc00898", currentUin, "0X800C01B", "0X800C01B", 0, 1, 0, str3, str4, "", "");
                    } else {
                        popupSearchDialog(6);
                    }
                } else {
                    popupSearchDialog(16);
                }
            } else if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.f165972dz1) {
                if (id5 == R.id.ivTitleBtnRightText) {
                    L3();
                } else if (id5 == R.id.cjk) {
                    QQAppInterface qQAppInterface2 = this.app;
                    String currentUin2 = qQAppInterface2.getCurrentUin();
                    boolean z17 = this.f175793r0;
                    if (z17) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                    if (z17) {
                        str2 = "0";
                    } else {
                        str2 = "1";
                    }
                    ReportController.n(qQAppInterface2, "P_CliOper", "dc00898", currentUin2, "0X800C01C", "0X800C01C", 0, 1, 0, str, str2, "", "");
                    Intent intent = getIntent();
                    if (!this.f175793r0) {
                        intent.setClass(this, TroopActivity.class);
                        ForwardBaseOption forwardBaseOption = this.f175036a0;
                        if (forwardBaseOption != null && !forwardBaseOption.isSupportAbility(com.tencent.mobileqq.forward.e.Q3)) {
                            intent.putExtra("onlyOneSegement", true);
                            intent.putExtra("_key_mode", 0);
                        } else {
                            ForwardBaseOption forwardBaseOption2 = this.f175036a0;
                            if (forwardBaseOption2 != null && !forwardBaseOption2.isSupportAbility(com.tencent.mobileqq.forward.e.P3)) {
                                intent.putExtra("onlyOneSegement", true);
                                intent.putExtra("_key_mode", 1);
                            }
                        }
                        intent.putExtra("only_single_selection", !this.f175793r0);
                        startActivityForResult(intent, 20000);
                    } else {
                        intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(this.N0.values()));
                        intent.putExtra("public_fragment_window_feature", 1);
                        intent.putExtra("key_is_search_default_single_mode", this.C0);
                        PublicFragmentActivity.b.d(this, intent, PublicTransFragmentActivity.class, ForwardTroopListFragment.class, 20000);
                    }
                }
            } else {
                K3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroy();
        ForwardBaseOption forwardBaseOption = this.f175036a0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
    }
}
