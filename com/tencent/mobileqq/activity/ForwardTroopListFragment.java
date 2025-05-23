package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.cc;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactsSearchNTFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ForwardTroopListFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    protected cc C;
    protected SwipPinnedHeaderExpandableListView D;
    protected h E;
    protected j F;
    protected MyTroopObserver G;
    protected k H;
    protected i I;
    private QQAppInterface J;
    private Context K;
    private View L;
    private QUISecNavBar M;
    private FrameLayout N;
    private SelectedAndSearchBar P;
    private int Q;
    private boolean R;
    private int S;
    private String T;
    private boolean U;
    private com.tencent.mobileqq.search.k V;
    private List<String> W;
    private AutomatorObserver X;
    private Map<String, ResultRecord> Y;
    private IFaceDecoder Z;

    /* renamed from: a0, reason: collision with root package name */
    private IQQGuildService f175876a0;

    /* renamed from: b0, reason: collision with root package name */
    private cc.c f175877b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.search.view.f f175878c0;

    /* renamed from: d0, reason: collision with root package name */
    private SelectedAndSearchBar.i f175879d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.search.view.d f175880e0;

    /* renamed from: f0, reason: collision with root package name */
    private InputMethodManager f175881f0;

    /* renamed from: g0, reason: collision with root package name */
    private Dialog f175882g0;

    /* renamed from: h0, reason: collision with root package name */
    private ForwardBaseOption f175883h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.matchfriend.utils.d f175884i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f175885j0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class MyTroopObserver extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        protected MyTroopObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGenNewTroopName(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
                return;
            }
            cc ccVar = ForwardTroopListFragment.this.C;
            if (ccVar != null) {
                ccVar.v();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetMutilTroopInfoResult(boolean z16, ArrayList<TroopInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList);
            } else if (z16) {
                ForwardTroopListFragment.this.gi();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                ForwardTroopListFragment.this.gi();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + z16);
            }
            if (z16) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ForwardTroopListFragment.MyTroopObserver.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyTroopObserver.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ForwardTroopListFragment.this.gi();
                        }
                    }
                }, 500L);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopNickname(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (z16) {
                ForwardTroopListFragment.this.gi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardTroopListFragment.this.ei();
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(ForwardTroopListFragment.this.Y.values()));
                ForwardTroopListFragment.this.getBaseActivity().setResult(0, intent);
                ForwardTroopListFragment.this.getBaseActivity().finish();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardTroopListFragment.this.ji();
                if (ForwardTroopListFragment.this.Q == 9) {
                    ForwardTroopListFragment.this.Ph();
                } else {
                    ForwardTroopListFragment.this.Qh();
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends AutomatorObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.AutomatorObserver
        protected void onCacheInited(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("contacts.fragment.TroopFragment", 2, "onCacheInited " + i3);
                }
                cc ccVar = ForwardTroopListFragment.this.C;
                if (ccVar != null) {
                    ccVar.t();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements cc.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.cc.c
        public boolean a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ForwardTroopListFragment.this.ai(str, i3);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).booleanValue();
        }

        @Override // com.tencent.mobileqq.activity.cc.c
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ForwardTroopListFragment.this.di(view);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements SelectedAndSearchBar.i {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
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
                ForwardTroopListFragment.this.hi(resultRecord.uin, resultRecord.getUinType());
            }
            ForwardTroopListFragment.this.C.notifyDataSetChanged();
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
                ForwardTroopListFragment.this.f175885j0 = true;
                if (ForwardTroopListFragment.this.N.getVisibility() == 0 && ForwardTroopListFragment.this.f175878c0 != null) {
                    ForwardTroopListFragment.this.f175878c0.y8();
                }
                ForwardTroopListFragment.this.N.setVisibility(8);
            } else {
                if (ForwardTroopListFragment.this.f175885j0) {
                    ForwardTroopListFragment.this.mi();
                    ForwardTroopListFragment.this.f175885j0 = false;
                }
                if (ForwardTroopListFragment.this.N.getVisibility() == 8) {
                    ForwardTroopListFragment.this.ci();
                }
                ForwardTroopListFragment.this.N.setVisibility(0);
            }
            if (ForwardTroopListFragment.this.f175878c0 != null) {
                ForwardTroopListFragment.this.f175878c0.startSearch(obj);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (z16) {
                if (ForwardTroopListFragment.this.f175878c0 == null) {
                    if (ForwardTroopListFragment.this.U) {
                        ForwardTroopListFragment.this.Xh();
                        ForwardTroopListFragment forwardTroopListFragment = ForwardTroopListFragment.this;
                        forwardTroopListFragment.f175878c0 = ContactsSearchNTFragment.INSTANCE.a(8, 2097176, null, null, forwardTroopListFragment.f175880e0, 0, -1L, false, ForwardTroopListFragment.this.U, ForwardTroopListFragment.this.V);
                    } else {
                        ForwardTroopListFragment forwardTroopListFragment2 = ForwardTroopListFragment.this;
                        forwardTroopListFragment2.f175878c0 = ContactSearchFragment.zh(8, 2097176, null, null, forwardTroopListFragment2.f175880e0, false, null);
                    }
                    FragmentTransaction beginTransaction = ForwardTroopListFragment.this.getBaseActivity().getSupportFragmentManager().beginTransaction();
                    beginTransaction.add(R.id.result_layout, ForwardTroopListFragment.this.f175878c0.getFragment());
                    beginTransaction.commitAllowingStateLoss();
                    ForwardTroopListFragment.this.f175878c0.B5(ForwardTroopListFragment.this.Vh(), null);
                }
                ForwardTroopListFragment.this.li();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements com.tencent.mobileqq.search.k {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.i("contacts.fragment.TroopFragment", 1, "setSearchFragmentVisibility " + z16);
            if (!z16) {
                ForwardTroopListFragment.this.ei();
            } else if (ForwardTroopListFragment.this.N.getVisibility() == 8) {
                ForwardTroopListFragment.this.N.setVisibility(0);
                if (ForwardTroopListFragment.this.f175878c0 != null) {
                    ForwardTroopListFragment.this.f175878c0.tb();
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
    class g implements com.tencent.mobileqq.search.view.d {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.search.view.d
        public void onAction(View view) {
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
            if (kVar == 0) {
                return;
            }
            String uin = kVar.getUin();
            String charSequence = kVar.getTitleSpans().toString();
            if (kVar instanceof wn2.b) {
                str = ((wn2.b) kVar).d();
                i3 = 3000;
            } else {
                i3 = 1;
                if (kVar instanceof com.tencent.mobileqq.search.model.o) {
                    TroopInfo a16 = ((com.tencent.mobileqq.search.model.o) kVar).a();
                    if (a16 != null) {
                        str = a16.getTroopUin();
                    } else {
                        QLog.e("contacts.fragment.TroopFragment", 1, "error params, return");
                        return;
                    }
                } else if (kVar instanceof wn2.q) {
                    str = ((wn2.q) kVar).a().troopuin;
                } else if (!(kVar instanceof wn2.c)) {
                    str = "-1";
                    i3 = -1;
                } else {
                    i3 = 0;
                    str = "-1";
                }
            }
            if (i3 != -1 && ForwardTroopListFragment.this.Nh(new ResultRecord(uin, charSequence, i3, str, ""))) {
                ForwardTroopListFragment.this.C.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void selectedItemClick(String str, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (ForwardTroopListFragment.this.f175878c0 != null && ForwardTroopListFragment.this.f175878c0.L5()) {
                ForwardTroopListFragment.this.hi(str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        protected h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                ForwardTroopListFragment.this.gi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i extends com.tencent.mobileqq.app.bs {
        static IPatchRedirector $redirector_;

        protected i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateTroopList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ForwardTroopListFragment.this.gi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        protected j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void c(String str, GroupMsgMask groupMsgMask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) groupMsgMask);
            } else {
                ForwardTroopListFragment.this.gi();
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                ForwardTroopListFragment.this.gi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        protected k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            if (i3 == 6) {
                if (i16 == 0) {
                    ForwardTroopListFragment.this.gi();
                }
            } else if (i3 == 2) {
                if (i16 == 0) {
                    ForwardTroopListFragment.this.gi();
                }
            } else if (i3 == 9 && i16 == 0) {
                ForwardTroopListFragment.this.gi();
            }
        }
    }

    public ForwardTroopListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R = false;
        this.T = "";
        this.U = false;
        this.W = new ArrayList();
        this.X = new c();
        this.Y = new LinkedHashMap();
        this.f175877b0 = new d();
        this.f175879d0 = new e();
        this.f175880e0 = new g();
        this.f175885j0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nh(ResultRecord resultRecord) {
        if (resultRecord == null) {
            return false;
        }
        String Sh = Sh(resultRecord.uin, resultRecord.getUinType());
        ResultRecord resultRecord2 = this.Y.get(Sh);
        if (resultRecord2 != null) {
            resultRecord2.lastChooseTime = SystemClock.elapsedRealtime();
            this.P.H(new ArrayList(this.Y.values()), false);
            return false;
        }
        if (this.Y.size() == 9) {
            qi();
            return false;
        }
        ResultRecord copyResultRecord = ResultRecord.copyResultRecord(resultRecord);
        copyResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
        this.Y.put(Sh, copyResultRecord);
        fi();
        this.P.H(new ArrayList(this.Y.values()), true);
        oi();
        return true;
    }

    private void Oh() {
        if (this.E == null) {
            this.E = new h();
        }
        if (this.F == null) {
            this.F = new j();
        }
        if (this.H == null) {
            this.H = new k();
        }
        if (this.G == null) {
            this.G = new MyTroopObserver();
        }
        if (this.I == null) {
            this.I = new i();
        }
        this.J.addObserver(this.E);
        this.J.addObserver(this.F);
        this.J.addObserver(this.G);
        this.J.addObserver(this.H);
        this.J.addObserver(this.I);
        this.J.addObserver(this.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.Y.values());
        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("selected_target_list", arrayList);
        getBaseActivity().setResult(-1, intent);
        getBaseActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        if (this.Y.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("contacts.fragment.TroopFragment", 2, "forward2MultiTargets map is empty !");
                return;
            }
            return;
        }
        if (this.f175883h0 == null) {
            this.f175883h0 = com.tencent.mobileqq.forward.k.d(getBaseActivity().getIntent(), this.J, getBaseActivity());
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.Y.values());
        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, arrayList);
        this.f175883h0.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle);
        this.f175883h0.reportForward();
    }

    private String Rh() {
        if (!TextUtils.isEmpty(this.T)) {
            return this.T;
        }
        return HardCodeUtil.qqStr(R.string.mpq);
    }

    private String Sh(String str, int i3) {
        return i3 + "_" + str;
    }

    private List<String> Th() {
        if (this.U) {
            return this.W;
        }
        return null;
    }

    private String Uh(int i3) {
        return "(" + i3 + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Vh() {
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.Y.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh() {
        if (this.V == null) {
            this.V = new f();
        }
    }

    private void Yh() {
        this.f175881f0 = (InputMethodManager) this.K.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.P = (SelectedAndSearchBar) this.L.findViewById(R.id.imi);
        this.Z = ((IQQAvatarService) this.J.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.J);
        IQQGuildService iQQGuildService = (IQQGuildService) this.J.getRuntimeService(IQQGuildService.class, "");
        this.f175876a0 = iQQGuildService;
        this.P.t(null, this.Z, this.f175879d0, iQQGuildService);
    }

    private void Zh(List<ResultRecord> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<ResultRecord> it = list.iterator();
            while (it.hasNext()) {
                Nh(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ai(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.Y.containsKey(Sh(str, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(DialogInterface dialogInterface, int i3) {
        if (!getBaseActivity().isFinishing()) {
            this.f175882g0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci() {
        this.W.clear();
        this.W.addAll(Vh());
        oi();
        com.tencent.mobileqq.search.view.f fVar = this.f175878c0;
        if (fVar != null) {
            fVar.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(View view) {
        ResultRecord resultRecord = ((ForwardRecentItemView) view).J;
        if (resultRecord != null && ai(resultRecord.uin, resultRecord.getUinType())) {
            hi(resultRecord.uin, resultRecord.getUinType());
        } else {
            Nh(resultRecord);
        }
        this.C.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei() {
        com.tencent.mobileqq.search.view.f fVar;
        this.f175881f0.hideSoftInputFromWindow(getBaseActivity().getWindow().peekDecorView().getWindowToken(), 0);
        this.P.u();
        this.P.v();
        FrameLayout frameLayout = this.N;
        if (frameLayout != null && frameLayout.getVisibility() == 0 && (fVar = this.f175878c0) != null) {
            fVar.y8();
        }
        this.N.setVisibility(8);
    }

    private void fi() {
        this.M.setRightType(1);
        if (this.Y.isEmpty()) {
            this.M.setRightText(Rh());
            this.M.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
            return;
        }
        this.M.setRightText(Rh() + Uh(this.Y.size()));
        this.M.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Y.remove(Sh(str, i3));
        fi();
        this.P.H(new ArrayList(this.Y.values()), true);
        this.W.remove(str);
        oi();
    }

    private void ii() {
        this.J.removeObserver(this.E);
        this.J.removeObserver(this.F);
        this.J.removeObserver(this.G);
        this.J.removeObserver(this.H);
        this.J.removeObserver(this.I);
        this.J.removeObserver(this.X);
    }

    private void initData() {
        Zh(getArguments().getParcelableArrayList("selected_target_list"));
    }

    private void initReport() {
        int i3;
        this.f175884i0 = new com.tencent.mobileqq.matchfriend.utils.d(this.K);
        HashMap hashMap = new HashMap();
        int i16 = 1;
        if (this.R) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("choose_fri_multiple_type", Integer.valueOf(i3));
        if (this.Q != 9) {
            i16 = 0;
        }
        hashMap.put("choose_fri_multiple_source", Integer.valueOf(i16));
        hashMap.put("choose_fri_multiple_page_type", 2);
        this.f175884i0.c("pg_choose_fri_multiple", hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_choose_fri_multiple_search");
        arrayList.add("em_choose_multiple_finish");
        this.f175884i0.b(arrayList);
        ki(hashMap);
    }

    private void initTitleBar() {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) this.L.findViewById(R.id.f165271ve1);
        this.M = qUISecNavBar;
        qUISecNavBar.setLeftType(2);
        String string = getArguments().getString("extra_forward_title");
        if (!TextUtils.isEmpty(string)) {
            this.M.setCenterText(string);
        } else {
            this.M.setCenterText(HardCodeUtil.qqStr(R.string.mrf));
        }
        fi();
        this.M.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new a());
        this.M.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new b());
    }

    private void initView() {
        if (this.R) {
            ((RoundFrameLayout) this.L.findViewById(R.id.ifd)).setRadius(ViewUtils.dip2px(10.0f));
        }
        SwipPinnedHeaderExpandableListView swipPinnedHeaderExpandableListView = (SwipPinnedHeaderExpandableListView) this.L.findViewById(R.id.f166069ec1);
        this.D = swipPinnedHeaderExpandableListView;
        swipPinnedHeaderExpandableListView.setSelector(R.color.ajr);
        this.D.setNeedCheckSpringback(true);
        this.D.setGroupIndicator(null);
        this.D.setDivider(null);
        this.D.setPadding(0, 0, 0, BaseAIOUtils.f(54.0f, getResources()));
        this.D.setClipToPadding(false);
        this.D.setScrollBarStyle(33554432);
        this.N = (FrameLayout) this.L.findViewById(R.id.result_layout);
        Yh();
        initTitleBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji() {
        if (this.f175884i0 != null) {
            Iterator it = new ArrayList(this.Y.values()).iterator();
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
            this.f175884i0.e("em_choose_multiple_finish", hashMap);
        }
    }

    private void ki(Map<String, Object> map) {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.f175884i0;
        if (dVar != null) {
            dVar.i(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.f175884i0;
        if (dVar != null) {
            dVar.d("em_choose_fri_multiple_search");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.f175884i0;
        if (dVar != null) {
            dVar.l("em_choose_fri_multiple_search", "ev_choose_multiple_enter");
        }
    }

    private void ni() {
        if (this.D != null) {
            cc ccVar = this.C;
            if (ccVar != null) {
                ccVar.destroy();
            }
            cc ccVar2 = new cc(getBaseActivity(), this.J, this.D, this.f175877b0);
            this.C = ccVar2;
            this.D.setAdapter(ccVar2);
            this.D.setOnGroupClickListener(this.C);
        }
    }

    private void oi() {
        List<String> Vh = Vh();
        com.tencent.mobileqq.search.view.f fVar = this.f175878c0;
        if (fVar != null) {
            fVar.B5(Vh, Th());
        }
    }

    private void qi() {
        if (this.f175882g0 == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, String.format(getString(R.string.f199254ox), 9), (String) null, getString(R.string.cpy), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.cd
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ForwardTroopListFragment.this.bi(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            this.f175882g0 = createCustomDialog;
            createCustomDialog.setCanceledOnTouchOutside(false);
        }
        if (!getBaseActivity().isFinishing()) {
            this.f175882g0.show();
        }
    }

    public void Wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.R) {
            return;
        }
        try {
            pi();
            Window window = getBaseActivity().getWindow();
            window.setFormat(-3);
            WindowManager.LayoutParams attributes = window.getAttributes();
            int height = getBaseActivity().getWindowManager().getDefaultDisplay().getHeight() - ViewUtils.dpToPx(88.0f);
            attributes.height = height;
            this.S = height;
            attributes.gravity = 81;
            window.setAttributes(attributes);
            View decorView = window.getDecorView();
            decorView.setScaleX(1.0f);
            decorView.setScaleY(1.0f);
        } catch (Exception e16) {
            QLog.e("contacts.fragment.TroopFragment", 1, "initMiniWindow ", e16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.R) {
            return super.dispatchTouchEvent(motionEvent);
        }
        Display defaultDisplay = getBaseActivity().getWindowManager().getDefaultDisplay();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        motionEvent.offsetLocation(((x16 - ((defaultDisplay.getWidth() * 0.0f) / 2.0f)) / 1.0f) - x16, ((y16 - ((defaultDisplay.getHeight() * 0.0f) / 2.0f)) / 1.0f) - y16);
        if (!super.dispatchTouchEvent(motionEvent)) {
            if (y16 > this.S || y16 < 0.0f) {
                getBaseActivity().finish();
                return true;
            }
            return false;
        }
        return false;
    }

    void gi() {
        cc ccVar = this.C;
        if (ccVar != null) {
            ccVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154423k);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean needDispatchTouchEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.N.getVisibility() != 8) {
            ei();
            return true;
        }
        if (this.P.E()) {
            ei();
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(this.Y.values()));
            baseActivity.setResult(0, intent);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (getArguments() == null) {
                getBaseActivity().finish();
            }
            this.R = getArguments().getBoolean("extra_mini_mode", false);
            this.T = getArguments().getString("extra_select_finish_text");
            this.Q = getArguments().getInt("extra_choose_friend", 0);
            this.U = getArguments().getBoolean("key_is_search_default_single_mode", false);
            this.J = getBaseActivity().app;
            this.K = getBaseActivity();
            this.L = layoutInflater.inflate(R.layout.f167973o8, (ViewGroup) null);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.L.setFitsSystemWindows(true);
                this.L.setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
            }
            Wh();
            initView();
            initData();
            initReport();
            view = this.L;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
        }
        cc ccVar = this.C;
        if (ccVar != null) {
            ccVar.destroy();
        }
        this.Z.destory();
        ii();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroyView();
        ForwardBaseOption forwardBaseOption = this.f175883h0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.R) {
            getBaseActivity().overridePendingTransition(0, R.anim.f154423k);
        }
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onPause();
            ii();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        Oh();
        if (this.C == null) {
            ni();
        }
        this.D.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ForwardTroopListFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardTroopListFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ForwardTroopListFragment.this.C.notifyDataSetChanged();
                }
            }
        }, 200L);
    }

    public void pi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(getBaseActivity());
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarVisible(2, 0);
        }
    }
}
