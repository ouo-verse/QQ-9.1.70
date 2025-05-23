package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TroopTransferActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected QUISecNavBar f177419a0;

    /* renamed from: b0, reason: collision with root package name */
    protected LinearLayout f177420b0;

    /* renamed from: c0, reason: collision with root package name */
    protected LinearLayout f177421c0;

    /* renamed from: d0, reason: collision with root package name */
    protected XListView f177422d0;

    /* renamed from: e0, reason: collision with root package name */
    protected n f177423e0;

    /* renamed from: f0, reason: collision with root package name */
    protected Dialog f177424f0;

    /* renamed from: g0, reason: collision with root package name */
    protected EditText f177425g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ImageButton f177426h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f177427i0;

    /* renamed from: j0, reason: collision with root package name */
    protected RelativeLayout f177428j0;

    /* renamed from: k0, reason: collision with root package name */
    protected XListView f177429k0;

    /* renamed from: l0, reason: collision with root package name */
    protected View f177430l0;

    /* renamed from: m0, reason: collision with root package name */
    protected List<m> f177431m0;

    /* renamed from: n0, reason: collision with root package name */
    protected j f177432n0;

    /* renamed from: o0, reason: collision with root package name */
    protected String f177433o0;

    /* renamed from: p0, reason: collision with root package name */
    protected String f177434p0;

    /* renamed from: q0, reason: collision with root package name */
    protected String f177435q0;

    /* renamed from: r0, reason: collision with root package name */
    protected long f177436r0;

    /* renamed from: s0, reason: collision with root package name */
    protected int f177437s0;

    /* renamed from: t0, reason: collision with root package name */
    protected boolean f177438t0;

    /* renamed from: u0, reason: collision with root package name */
    protected com.tencent.mobileqq.widget.ap f177439u0;

    /* renamed from: v0, reason: collision with root package name */
    protected Integer f177440v0;

    /* renamed from: w0, reason: collision with root package name */
    com.tencent.mobileqq.avatar.observer.a f177441w0;

    /* renamed from: x0, reason: collision with root package name */
    com.tencent.mobileqq.app.ar f177442x0;

    /* renamed from: y0, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.e f177443y0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16 && !TextUtils.isEmpty(str) && TroopTransferActivity.this.f177423e0.k(str) != null) {
                TroopTransferActivity.this.f177423e0.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            m k3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else {
                if (!z16 || TextUtils.isEmpty(str) || (k3 = TroopTransferActivity.this.f177423e0.k(str)) == null) {
                    return;
                }
                TroopTransferActivity.this.p3(k3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopMemberCardInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), arrayList);
            } else if (z16 && arrayList != null && arrayList.size() > 0) {
                TroopTransferActivity.this.r3(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onModifyTroopInfoPushResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList);
            } else if (z16 && arrayList != null && arrayList.size() > 0) {
                TroopTransferActivity.this.r3(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onModifyTroopInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, str);
            } else if (z16 && arrayList != null && arrayList.size() > 0) {
                TroopTransferActivity.this.r3(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f177449d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f177450e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f177451f;

        d(TranslateAnimation translateAnimation, TranslateAnimation translateAnimation2, int i3) {
            this.f177449d = translateAnimation;
            this.f177450e = translateAnimation2;
            this.f177451f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopTransferActivity.this, translateAnimation, translateAnimation2, Integer.valueOf(i3));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            try {
                if (animation == this.f177449d) {
                    Dialog dialog = TroopTransferActivity.this.f177424f0;
                    if (dialog != null) {
                        try {
                            dialog.show();
                        } catch (Exception unused) {
                        }
                        TroopTransferActivity.this.f177421c0.setAnimation(null);
                        TroopTransferActivity.this.f177419a0.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (animation == this.f177450e) {
                    TroopTransferActivity.this.f177421c0.setAnimation(null);
                    TroopTransferActivity.this.f177421c0.offsetTopAndBottom(this.f177451f);
                    TroopTransferActivity.this.f177421c0.requestLayout();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
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
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f177453d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f177454e;

        e(int i3, TranslateAnimation translateAnimation) {
            this.f177453d = i3;
            this.f177454e = translateAnimation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopTransferActivity.this, Integer.valueOf(i3), translateAnimation);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            try {
                TroopTransferActivity.this.f177421c0.offsetTopAndBottom(-this.f177453d);
                TroopTransferActivity.this.f177419a0.setVisibility(0);
                TroopTransferActivity.this.f177421c0.startAnimation(this.f177454e);
                InputMethodManager inputMethodManager = (InputMethodManager) TroopTransferActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(TroopTransferActivity.this.getWindow().peekDecorView().getWindowToken(), 0);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopTransferActivity.this.f177425g0.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopTransferActivity.this.f177424f0.cancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopTransferActivity.this.f177424f0.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) TroopTransferActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j extends com.tencent.mobileqq.adapter.j {
        static IPatchRedirector $redirector_;
        private final List<m> F;

        public j(List<m> list) {
            super(TroopTransferActivity.this, TroopTransferActivity.this.app, TroopTransferActivity.this.f177429k0, 1, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this, (Object) list);
            } else {
                this.F = list;
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            List<m> list = this.F;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < this.F.size()) {
                return this.F.get(i3);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            o oVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = TroopTransferActivity.this.getLayoutInflater().inflate(R.layout.byh, viewGroup, false);
                    oVar = new o();
                    oVar.f187212f = (ImageView) view.findViewById(R.id.dvo);
                    oVar.f177481m = (TextView) view.findViewById(R.id.tv_name);
                    ((TextView) view.findViewById(R.id.kaw)).setText("");
                    view.setTag(oVar);
                } else {
                    oVar = (o) view.getTag();
                }
                m mVar = this.F.get(i3);
                if (!TextUtils.isEmpty(mVar.f177469h) && !mVar.f177469h.equals(mVar.f177466e)) {
                    oVar.f177481m.setText(mVar.f177466e + "(" + mVar.f177469h + ")");
                } else {
                    oVar.f177481m.setText(mVar.f177466e);
                }
                String str = mVar.f177464c;
                oVar.f187210d = str;
                oVar.f177480i = mVar;
                oVar.f187212f.setImageBitmap(c(1, str));
                view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements Comparator<m> {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(m mVar, m mVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mVar, (Object) mVar2)).intValue();
            }
            return mVar.f177470i.compareToIgnoreCase(mVar2.f177470i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements TextWatcher {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) editable);
            } else {
                TroopTransferActivity.this.refreshSearchResultList(TroopTransferActivity.this.f177425g0.getText().toString().trim());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f177462a;

        /* renamed from: b, reason: collision with root package name */
        public int f177463b;

        /* renamed from: c, reason: collision with root package name */
        public String f177464c;

        /* renamed from: d, reason: collision with root package name */
        public String f177465d;

        /* renamed from: e, reason: collision with root package name */
        public String f177466e;

        /* renamed from: f, reason: collision with root package name */
        public String f177467f;

        /* renamed from: g, reason: collision with root package name */
        public String f177468g;

        /* renamed from: h, reason: collision with root package name */
        public String f177469h;

        /* renamed from: i, reason: collision with root package name */
        public String f177470i;

        /* renamed from: j, reason: collision with root package name */
        public String f177471j;

        /* renamed from: k, reason: collision with root package name */
        public String f177472k;

        /* renamed from: l, reason: collision with root package name */
        public String f177473l;

        /* renamed from: m, reason: collision with root package name */
        public String f177474m;

        /* renamed from: n, reason: collision with root package name */
        public String f177475n;

        /* renamed from: o, reason: collision with root package name */
        public String f177476o;

        /* renamed from: p, reason: collision with root package name */
        public String f177477p;

        /* renamed from: q, reason: collision with root package name */
        public String f177478q;

        /* renamed from: r, reason: collision with root package name */
        public String f177479r;

        protected m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f177464c = "";
            this.f177465d = "";
            this.f177466e = "";
            this.f177467f = "";
            this.f177468g = "";
            this.f177469h = "";
            this.f177470i = "";
            this.f177471j = "";
            this.f177472k = "";
            this.f177473l = "";
            this.f177474m = "";
            this.f177475n = "";
            this.f177476o = "";
            this.f177477p = "";
            this.f177478q = "";
            this.f177479r = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n extends com.tencent.mobileqq.adapter.j {
        static IPatchRedirector $redirector_;
        protected ArrayList<m> F;
        protected LayoutInflater G;

        public n(Context context, ArrayList<String> arrayList) {
            super(context, TroopTransferActivity.this.app, TroopTransferActivity.this.f177422d0, 1, true);
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopTransferActivity.this, context, arrayList);
                return;
            }
            this.G = (LayoutInflater) context.getSystemService("layout_inflater");
            this.F = new ArrayList<>();
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                String str = arrayList.get(i3);
                if (!TextUtils.isEmpty(str) && Pattern.matches("\\d{5,}+\\|+\\d{1,}", str)) {
                    int indexOf = str.indexOf(124);
                    String substring = str.substring(0, indexOf);
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1));
                    if (!TextUtils.isEmpty(substring) && (parseInt & 1) == 1) {
                        m mVar = new m();
                        mVar.f177462a = 1;
                        mVar.f177464c = substring;
                        mVar.f177463b = parseInt;
                        arrayList2.add(mVar);
                    } else if (!TextUtils.isEmpty(substring) && (parseInt & 1) == 0) {
                        m mVar2 = new m();
                        mVar2.f177462a = 1;
                        mVar2.f177464c = substring;
                        mVar2.f177463b = parseInt;
                        arrayList3.add(mVar2);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                m mVar3 = new m();
                mVar3.f177462a = 0;
                mVar3.f177463b = 1;
                this.F.add(0, mVar3);
                this.F.addAll(arrayList2);
            }
            if (arrayList3.size() > 0) {
                m mVar4 = new m();
                mVar4.f177462a = 0;
                mVar4.f177463b = 0;
                this.F.add(mVar4);
                this.F.addAll(arrayList3);
            }
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(TroopTransferActivity.this.f177433o0, TroopTransferActivity.this, false, "Q.troopdisband.transfer", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.iw
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z16, List list) {
                    TroopTransferActivity.n.this.l(z16, list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(boolean z16, List list) {
            n(new ArrayList(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m() {
            notifyDataSetChanged();
        }

        private void n(List<TroopMemberInfo> list) {
            Friends v3;
            HashMap hashMap = new HashMap();
            for (TroopMemberInfo troopMemberInfo : list) {
                hashMap.put(troopMemberInfo.memberuin, troopMemberInfo);
            }
            int size = this.F.size();
            FriendsManager friendsManager = (FriendsManager) TroopTransferActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            ArrayList<String> arrayList = new ArrayList<>();
            String str = null;
            for (int i3 = 0; i3 < size; i3++) {
                m mVar = this.F.get(i3);
                if (!TextUtils.isEmpty(mVar.f177464c)) {
                    if (friendsManager == null) {
                        v3 = null;
                    } else {
                        v3 = friendsManager.v(mVar.f177464c);
                    }
                    if (v3 != null && !TextUtils.isEmpty(v3.name)) {
                        mVar.f177471j = v3.name;
                    }
                    if (v3 != null && !TextUtils.isEmpty(v3.remark)) {
                        mVar.f177474m = v3.remark;
                    }
                    TroopMemberInfo troopMemberInfo2 = (TroopMemberInfo) hashMap.get(mVar.f177464c);
                    if (troopMemberInfo2 != null) {
                        str = troopMemberInfo2.nickInfo.getShowName();
                        mVar.f177465d = troopMemberInfo2.memberUid;
                    }
                    if (!TextUtils.isEmpty(str) && !str.equals(mVar.f177464c)) {
                        mVar.f177477p = str;
                    } else {
                        TroopMemberInfo troopMemberInfo3 = (TroopMemberInfo) hashMap.get(mVar.f177464c);
                        if (troopMemberInfo3 != null && !TextUtils.isEmpty(troopMemberInfo3.troopColorNick)) {
                            mVar.f177477p = troopMemberInfo3.troopColorNick;
                        }
                    }
                    if (!TextUtils.isEmpty(mVar.f177477p)) {
                        mVar.f177466e = mVar.f177477p;
                    } else if (!TextUtils.isEmpty(mVar.f177474m)) {
                        mVar.f177466e = mVar.f177474m;
                    } else if (!TextUtils.isEmpty(mVar.f177471j)) {
                        mVar.f177466e = mVar.f177471j;
                    } else if (!TextUtils.isEmpty(mVar.f177464c)) {
                        String str2 = mVar.f177464c;
                        mVar.f177466e = str2;
                        arrayList.add(str2);
                    }
                    if (!TextUtils.isEmpty(mVar.f177466e)) {
                        mVar.f177467f = ChnToSpell.d(mVar.f177466e, 2);
                        mVar.f177468g = ChnToSpell.d(mVar.f177466e, 1);
                    } else {
                        mVar.f177467f = "";
                        mVar.f177468g = "";
                    }
                    if (!TextUtils.isEmpty(mVar.f177471j)) {
                        mVar.f177472k = ChnToSpell.d(mVar.f177471j, 2);
                        mVar.f177473l = ChnToSpell.d(mVar.f177471j, 1);
                    } else {
                        mVar.f177472k = "";
                        mVar.f177473l = "";
                    }
                    if (!TextUtils.isEmpty(mVar.f177474m)) {
                        mVar.f177475n = ChnToSpell.d(mVar.f177474m, 2);
                        mVar.f177476o = ChnToSpell.d(mVar.f177474m, 1);
                    } else {
                        mVar.f177475n = "";
                        mVar.f177476o = "";
                    }
                    if (!TextUtils.isEmpty(mVar.f177477p)) {
                        mVar.f177478q = ChnToSpell.d(mVar.f177477p, 2);
                        mVar.f177479r = ChnToSpell.d(mVar.f177477p, 1);
                    } else {
                        mVar.f177478q = "";
                        mVar.f177479r = "";
                    }
                }
            }
            com.tencent.mobileqq.troop.api.handler.e eVar = (com.tencent.mobileqq.troop.api.handler.e) TroopTransferActivity.this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
            if (QLog.isColorLevel()) {
                QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + arrayList.size() + ", frh = " + eVar);
            }
            if (arrayList.size() > 0 && eVar != null) {
                TroopTransferActivity troopTransferActivity = TroopTransferActivity.this;
                eVar.i1(troopTransferActivity.f177433o0, troopTransferActivity.f177434p0, arrayList);
            }
            try {
                TroopTransferActivity troopTransferActivity2 = TroopTransferActivity.this;
                if (troopTransferActivity2 != null && !troopTransferActivity2.isFinishing()) {
                    TroopTransferActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.ix
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopTransferActivity.n.this.m();
                        }
                    });
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.troopdisband.transfer", 2, e16.toString());
                }
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.F.size();
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < this.F.size()) {
                return this.F.get(i3);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            m mVar = (m) getItem(i3);
            if ((mVar != null && mVar.f177462a == 0) || mVar == null || mVar.f177462a != 1) {
                return 0;
            }
            return 1;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            o oVar;
            View view2;
            View view3;
            TextView textView;
            o oVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int itemViewType = getItemViewType(i3);
                m mVar = (m) getItem(i3);
                String str = "";
                o oVar3 = null;
                String str2 = null;
                if (itemViewType == 0) {
                    if (view == null) {
                        view = this.G.inflate(R.layout.f168254qf, viewGroup, false);
                        oVar2 = new o();
                        oVar2.f187212f = null;
                        oVar2.f177481m = (TextView) view;
                        view.setTag(oVar2);
                    } else {
                        oVar2 = (o) view.getTag();
                    }
                    oVar3 = oVar2;
                    oVar3.f177480i = mVar;
                    if (mVar != null && mVar.f177463b == 1) {
                        oVar3.f177481m.setText(R.string.c7d);
                    } else if (mVar != null && mVar.f177463b == 0) {
                        oVar3.f177481m.setText(R.string.i67);
                    } else {
                        oVar3.f177481m.setText("");
                    }
                } else if (itemViewType == 1) {
                    if (view == null) {
                        view = this.G.inflate(R.layout.c1y, viewGroup, false);
                        view.findViewById(R.id.k5_).setVisibility(8);
                        view.findViewById(R.id.f164668ai4).setVisibility(8);
                        oVar = new o();
                        oVar.f187212f = (ImageView) view.findViewById(R.id.dvo);
                        oVar.f177481m = (TextView) view.findViewById(R.id.tv_name);
                        view.setTag(oVar);
                    } else {
                        oVar = (o) view.getTag();
                    }
                    oVar.f177480i = mVar;
                    if (mVar != null) {
                        str2 = mVar.f177464c;
                    }
                    if (!TextUtils.isEmpty(str2) && !str2.equals("0")) {
                        oVar.f187210d = str2;
                        oVar.f187212f.setImageBitmap(c(1, mVar.f177464c));
                    } else {
                        oVar.f187212f.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
                    }
                    if (mVar != null) {
                        str = mVar.f177466e;
                    }
                    oVar.f177481m.setText(str);
                    oVar3 = oVar;
                }
                if (oVar3 != null && (textView = oVar3.f177481m) != null) {
                    view.setContentDescription(textView.getText());
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 2;
        }

        public List<m> j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.F;
        }

        public m k(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (m) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            m mVar = null;
            for (int i3 = 0; mVar == null && i3 < this.F.size(); i3++) {
                m mVar2 = this.F.get(i3);
                if (mVar2 != null && Utils.p(mVar2.f177464c, str)) {
                    mVar = mVar2;
                }
            }
            return mVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class o extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public m f177480i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f177481m;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TroopTransferActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177431m0 = new ArrayList();
        this.f177440v0 = 0;
        this.f177441w0 = new a();
        this.f177442x0 = new b();
        this.f177443y0 = new c();
    }

    private void T2(final m mVar) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (this.f177439u0 == null) {
                this.f177439u0 = new com.tencent.mobileqq.widget.ap(this);
            }
            this.f177439u0.d(2, R.string.b3j, 1000);
            return;
        }
        QLog.i("Q.troopdisband.transfer", 1, "[doTransferTroop] newOwnerUid:" + mVar.f177465d);
        this.f177438t0 = true;
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).transferGroup(this.f177433o0, this.app.getCurrentUin(), this.app.getCurrentUid(), mVar.f177464c, mVar.f177465d, this, "Q.troopdisband.transfer", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.activity.ip
            @Override // com.tencent.qqnt.troop.i
            public final void onResult(boolean z16, int i3, String str) {
                TroopTransferActivity.this.Z2(mVar, z16, i3, str);
            }
        });
        if (this.f177439u0 == null) {
            this.f177439u0 = new com.tencent.mobileqq.widget.ap(this);
        }
        this.f177439u0.d(0, R.string.i4p, 1000);
        ReportController.o(this.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
    }

    private void V2(String str, boolean z16, int i3, String str2) {
        QLog.i("Q.troopdisband.transfer", 1, "[handleTransferGroup] suc:" + z16 + ",res:" + i3 + ",errMsg:" + str2);
        if (z16) {
            com.tencent.mobileqq.widget.ap apVar = this.f177439u0;
            if (apVar != null) {
                apVar.b();
            }
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            intent.putExtra(AppConstants.Key.FIN_TIP_MSG, getString(R.string.i6a));
            intent.putExtra("uin", str);
            setResult(-1, intent);
            finish();
            return;
        }
        if (i3 != 1 && i3 != 2 && i3 != 6 && i3 != 8 && i3 != 9 && i3 != 10 && i3 != 11) {
            if (i3 != 3 && i3 != 4 && i3 != 7 && i3 != 16 && i3 != 19) {
                if (i3 != 5 && i3 != 17 && i3 != 18) {
                    if (i3 == 20) {
                        com.tencent.mobileqq.widget.ap apVar2 = this.f177439u0;
                        if (apVar2 != null) {
                            apVar2.b();
                        }
                        QQToast.makeText(this, 1, getString(R.string.f236667ez), 0).show();
                        return;
                    }
                    if (i3 == 12) {
                        l3(getString(R.string.dt9), getString(R.string.f1788637t), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.is
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                TroopTransferActivity.this.c3(dialogInterface, i16);
                            }
                        }, getString(R.string.hkf), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.iu
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                TroopTransferActivity.this.d3(dialogInterface, i16);
                            }
                        });
                        return;
                    }
                    if (i3 == 15) {
                        j3(getString(R.string.f2328675p));
                        return;
                    } else if (i3 == 21 && !TextUtils.isEmpty(str2)) {
                        j3(str2);
                        return;
                    } else {
                        j3(getString(R.string.i5y));
                        return;
                    }
                }
                j3(getString(R.string.i5y));
                return;
            }
            l3(getString(R.string.i5z), getString(R.string.f1788637t), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ir
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    TroopTransferActivity.this.b3(dialogInterface, i16);
                }
            }, getString(R.string.hkf), null);
            return;
        }
        j3(getString(R.string.i5x));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y2(m mVar, boolean z16, int i3, String str) {
        this.f177438t0 = false;
        V2(mVar.f177464c, z16, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z2(final m mVar, final boolean z16, final int i3, final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.iq
            @Override // java.lang.Runnable
            public final void run() {
                TroopTransferActivity.this.Y2(mVar, z16, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(DialogInterface dialogInterface, int i3) {
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://kf.qq.com/touch/sappfaq/221025uYFBV7221025q2YjYf.html?platform=14");
        intent.putExtra("webStyle", "noBottomBar");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c3(DialogInterface dialogInterface, int i3) {
        ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_more", 0, 0, this.f177433o0, "", "", "");
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://kf.qq.com/touch/sappfaq/230628NRjiMN230628UVbQFv.html");
        intent.putExtra("webStyle", "noBottomBar");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d3(DialogInterface dialogInterface, int i3) {
        ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_know", 0, 0, this.f177433o0, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        clickSearchBar();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f3(DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
        qQCustomDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g3(DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
        qQCustomDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h3(m mVar, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        T2(mVar);
        qQCustomDialog.cancel();
    }

    private void j3(String str) {
        if (this.f177439u0 == null) {
            this.f177439u0 = new com.tencent.mobileqq.widget.ap(this);
        }
        this.f177439u0.e(2, str, 1500);
    }

    private void l3(String str, String str2, final DialogInterface.OnClickListener onClickListener, String str3, final DialogInterface.OnClickListener onClickListener2) {
        com.tencent.mobileqq.widget.ap apVar = this.f177439u0;
        if (apVar != null) {
            apVar.b();
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        createCustomDialog.setTitle(getString(R.string.dt8));
        createCustomDialog.setMessage(str);
        createCustomDialog.setNegativeButton(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.iv
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopTransferActivity.g3(onClickListener, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.il
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopTransferActivity.f3(onClickListener2, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initUI$0(View view, BaseAction baseAction) {
        if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
            com.tencent.mobileqq.widget.ap apVar = this.f177439u0;
            if (apVar != null) {
                apVar.b();
            }
            finish();
            return null;
        }
        return null;
    }

    private void setAccSoft() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        if (viewGroup != null) {
            IphoneTitleBarActivity.setLayerType(viewGroup);
        }
        View findViewById = findViewById(R.id.jo9);
        if (findViewById != null) {
            IphoneTitleBarActivity.setLayerType(findViewById);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            IphoneTitleBarActivity.setLayerType(textView);
        }
    }

    protected boolean R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.f177440v0.intValue() >= 2) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.troopdisband.transfer", 2, "too many update thread|total = " + this.f177440v0);
                return false;
            }
            return false;
        }
        synchronized (this.f177440v0) {
            this.f177440v0 = Integer.valueOf(this.f177440v0.intValue() + 1);
            if (QLog.isColorLevel()) {
                QLog.i("Q.troopdisband.transfer", 2, "add update thread |nTotalThreadCount = " + this.f177440v0);
            }
        }
        return true;
    }

    protected void S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            long parseLong = Long.parseLong(this.f177433o0);
            Long.parseLong(this.f177434p0);
            if (parseLong <= 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.troopdisband.transfer", 2, "troopuin = " + parseLong + " is illegal");
                }
                finish();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.troopdisband.transfer", 2, e16.toString());
            }
            finish();
        }
    }

    protected void U2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        if (z16) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.TroopTransferActivity.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        n nVar = TroopTransferActivity.this.f177423e0;
                        if (nVar != null) {
                            nVar.notifyDataSetChanged();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        synchronized (this.f177440v0) {
            this.f177440v0 = Integer.valueOf(this.f177440v0.intValue() - 1);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troopdisband.transfer", 2, "finUpdateThread|[" + this.f177440v0 + ", needUpdateUI = " + z16 + "]");
        }
    }

    protected void W2(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
            return;
        }
        this.f177420b0 = (LinearLayout) findViewById(R.id.k1o);
        this.f177421c0 = (LinearLayout) findViewById(R.id.f220302m);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f177420b0.setFitsSystemWindows(true);
        }
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById(R.id.jo9);
        this.f177419a0 = qUISecNavBar;
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.mobileqq.activity.in
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$initUI$0;
                lambda$initUI$0 = TroopTransferActivity.this.lambda$initUI$0((View) obj, (BaseAction) obj2);
                return lambda$initUI$0;
            }
        });
        this.f177422d0 = (XListView) findViewById(R.id.common_xlistview);
        QUISearchBar qUISearchBar = new QUISearchBar(this.f177420b0.getContext());
        qUISearchBar.updateStyle(1);
        qUISearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTransferActivity.this.e3(view);
            }
        });
        this.f177422d0.addHeaderView(qUISearchBar);
        n nVar = new n(this, arrayList);
        this.f177423e0 = nVar;
        this.f177422d0.setAdapter((ListAdapter) nVar);
        this.f177422d0.setOnItemClickListener(this);
    }

    protected void clickSearchBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int titleBarHeight = getTitleBarHeight();
        float f16 = -titleBarHeight;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        d dVar = new d(translateAnimation, translateAnimation2, titleBarHeight);
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(dVar);
        translateAnimation.setFillAfter(true);
        translateAnimation2.setDuration(300L);
        translateAnimation2.setAnimationListener(dVar);
        if (this.f177424f0 == null) {
            ReportDialog reportDialog = new ReportDialog(this);
            this.f177424f0 = reportDialog;
            reportDialog.setCanceledOnTouchOutside(true);
            this.f177424f0.requestWindowFeature(1);
            this.f177424f0.getWindow().setSoftInputMode(36);
            this.f177424f0.setContentView(R.layout.bxb);
            WindowManager.LayoutParams attributes = this.f177424f0.getWindow().getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -1;
            attributes.windowAnimations = android.R.style.Animation;
            attributes.gravity = 51;
            this.f177424f0.getWindow().setBackgroundDrawable(new ColorDrawable());
            this.f177424f0.setOnDismissListener(new e(titleBarHeight, translateAnimation2));
            this.f177430l0 = this.f177424f0.findViewById(R.id.root);
            EditText editText = (EditText) this.f177424f0.findViewById(R.id.et_search_keyword);
            this.f177425g0 = editText;
            editText.addTextChangedListener(new l());
            this.f177425g0.setSelection(0);
            this.f177425g0.requestFocus();
            ImageButton imageButton = (ImageButton) this.f177424f0.findViewById(R.id.ib_clear_text);
            this.f177426h0 = imageButton;
            imageButton.setOnClickListener(new f());
            Button button = (Button) this.f177424f0.findViewById(R.id.btn_cancel_search);
            button.setVisibility(0);
            button.setOnClickListener(new g());
            this.f177427i0 = this.f177424f0.findViewById(R.id.f166412fa0);
            RelativeLayout relativeLayout = (RelativeLayout) this.f177424f0.findViewById(R.id.result_layout);
            this.f177428j0 = relativeLayout;
            relativeLayout.setOnClickListener(new h());
            XListView xListView = (XListView) this.f177424f0.findViewById(R.id.searchList);
            this.f177429k0 = xListView;
            xListView.setBackgroundResource(R.drawable.bg_texture);
            this.f177429k0.setDividerHeight(0);
            this.f177431m0.clear();
            j jVar = new j(this.f177431m0);
            this.f177432n0 = jVar;
            this.f177429k0.setAdapter((ListAdapter) jVar);
            this.f177429k0.setOnTouchListener(new i());
            this.f177429k0.setOnItemClickListener(this);
        }
        this.f177421c0.startAnimation(translateAnimation);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f177438t0 = false;
        Bundle extras = getIntent().getExtras();
        this.f177433o0 = extras.getString("troop_uin");
        this.f177434p0 = extras.getString(AppConstants.Key.TROOP_CODE);
        this.f177435q0 = extras.getString("uinname");
        this.f177436r0 = extras.getLong(AppConstants.Key.TROOP_INFO_FLAG_EXT);
        this.f177437s0 = extras.getInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME);
        ArrayList<String> stringArrayList = extras.getStringArrayList("troopVipMembers");
        if (QLog.isColorLevel()) {
            QLog.i("Q.troopdisband.transfer", 2, "onCreate| mTroopUin = " + this.f177433o0 + "| mTroopCode = " + this.f177434p0 + "| mTroopName = " + this.f177435q0 + "| mVipMemberList" + stringArrayList);
        }
        S2();
        super.setContentView(R.layout.b3u);
        W2(stringArrayList);
        this.app.addObserver(this.f177443y0);
        this.app.addObserver(this.f177442x0);
        this.app.addObserver(this.f177441w0);
        setAccSoft();
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.app.removeObserver(this.f177443y0);
        this.app.removeObserver(this.f177442x0);
        this.app.removeObserver(this.f177441w0);
        com.tencent.mobileqq.widget.ap apVar = this.f177439u0;
        if (apVar != null) {
            apVar.b();
            this.f177439u0 = null;
        }
        n nVar = this.f177423e0;
        if (nVar != null) {
            nVar.destroy();
        }
        super.doOnDestroy();
    }

    protected void n3(final m mVar) {
        String string;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mVar);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("Q.troopdisband.transfer", 4, "[transferTroop] newUid:" + mVar.f177465d);
        }
        if ((this.f177436r0 & 2048) == 0 && this.f177437s0 == 0) {
            string = String.format(getString(R.string.i6_), mVar.f177466e);
        } else {
            string = getString(R.string.a8s, HardCodeUtil.qqStr(R.string.ura), HardCodeUtil.qqStr(R.string.ura));
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        createCustomDialog.setTitle(R.string.i4o);
        createCustomDialog.setMessage(string);
        createCustomDialog.setPositiveButton(getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ik
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopTransferActivity.this.h3(mVar, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButtonContentDescription(getString(R.string.acr));
        createCustomDialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.im
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQCustomDialog.this.cancel();
            }
        });
        createCustomDialog.setNegativeButtonContentDescription(getString(R.string.acq));
        createCustomDialog.show();
        QQAppInterface qQAppInterface = this.app;
        if (mVar.f177463b == 1) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, str, "", "", "");
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        m mVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (this.f177438t0) {
            return;
        }
        o oVar = (o) view.getTag();
        if (oVar != null) {
            mVar = oVar.f177480i;
        } else {
            mVar = null;
        }
        if (mVar != null && mVar.f177462a == 1) {
            n3(mVar);
        }
    }

    protected void p3(m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) mVar);
        } else {
            if (!R2()) {
                return;
            }
            ThreadManagerV2.post(new Runnable(mVar) { // from class: com.tencent.mobileqq.activity.TroopTransferActivity.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ m f177445d;

                {
                    this.f177445d = mVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this, (Object) mVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String r16;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f177445d.f177464c), "Q.troopdisband.transfer");
                    String str2 = null;
                    if (friendsSimpleInfoWithUid == null) {
                        r16 = null;
                    } else {
                        r16 = friendsSimpleInfoWithUid.r();
                    }
                    if (friendsSimpleInfoWithUid != null) {
                        str2 = friendsSimpleInfoWithUid.p();
                    }
                    boolean z16 = true;
                    if (!Utils.p(r16, this.f177445d.f177474m)) {
                        m mVar2 = this.f177445d;
                        mVar2.f177474m = r16;
                        if (!TextUtils.isEmpty(mVar2.f177477p)) {
                            m mVar3 = this.f177445d;
                            mVar3.f177475n = ChnToSpell.d(mVar3.f177477p, 2);
                            m mVar4 = this.f177445d;
                            mVar4.f177476o = ChnToSpell.d(mVar4.f177477p, 1);
                        } else {
                            m mVar5 = this.f177445d;
                            mVar5.f177475n = "";
                            mVar5.f177476o = "";
                        }
                    }
                    if (!Utils.p(str2, this.f177445d.f177471j)) {
                        this.f177445d.f177471j = str2;
                        if (!TextUtils.isEmpty(str2)) {
                            m mVar6 = this.f177445d;
                            mVar6.f177472k = ChnToSpell.d(mVar6.f177471j, 2);
                            m mVar7 = this.f177445d;
                            mVar7.f177473l = ChnToSpell.d(mVar7.f177471j, 1);
                        } else {
                            m mVar8 = this.f177445d;
                            mVar8.f177472k = "";
                            mVar8.f177473l = "";
                        }
                    }
                    if (!TextUtils.isEmpty(this.f177445d.f177474m)) {
                        str = this.f177445d.f177474m;
                    } else if (!TextUtils.isEmpty(this.f177445d.f177477p)) {
                        str = this.f177445d.f177477p;
                    } else if (!TextUtils.isEmpty(this.f177445d.f177471j)) {
                        str = this.f177445d.f177471j;
                    } else if (TextUtils.isEmpty(this.f177445d.f177464c)) {
                        str = "";
                    } else {
                        str = this.f177445d.f177464c;
                    }
                    if (!Utils.p(str, this.f177445d.f177466e)) {
                        this.f177445d.f177466e = str;
                        if (!TextUtils.isEmpty(str)) {
                            m mVar9 = this.f177445d;
                            mVar9.f177467f = ChnToSpell.d(mVar9.f177466e, 2);
                            m mVar10 = this.f177445d;
                            mVar10.f177468g = ChnToSpell.d(mVar10.f177466e, 1);
                        } else {
                            m mVar11 = this.f177445d;
                            mVar11.f177467f = "";
                            mVar11.f177468g = "";
                        }
                    } else {
                        z16 = false;
                    }
                    TroopTransferActivity.this.U2(z16);
                }
            }, 5, null, true);
        }
    }

    protected void r3(ArrayList<TroopMemberCardInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) arrayList);
            return;
        }
        TroopMemberCardInfo troopMemberCardInfo = arrayList.get(0);
        if (troopMemberCardInfo == null || !Utils.p(troopMemberCardInfo.troopuin, this.f177433o0) || !R2()) {
            return;
        }
        ThreadManagerV2.post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.activity.TroopTransferActivity.11
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f177444d;

            {
                this.f177444d = arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTransferActivity.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = false;
                for (int i3 = 0; i3 < this.f177444d.size(); i3++) {
                    TroopMemberCardInfo troopMemberCardInfo2 = (TroopMemberCardInfo) this.f177444d.get(i3);
                    m k3 = TroopTransferActivity.this.f177423e0.k(troopMemberCardInfo2.memberuin);
                    if (k3 != null) {
                        if (!Utils.p(troopMemberCardInfo2.name, k3.f177477p)) {
                            String str2 = troopMemberCardInfo2.name;
                            k3.f177477p = str2;
                            if (!TextUtils.isEmpty(str2)) {
                                k3.f177478q = ChnToSpell.d(k3.f177477p, 2);
                                k3.f177479r = ChnToSpell.d(k3.f177477p, 1);
                            } else {
                                k3.f177478q = "";
                                k3.f177479r = "";
                            }
                        }
                        if (!Utils.p(troopMemberCardInfo2.nick, k3.f177471j)) {
                            String str3 = troopMemberCardInfo2.nick;
                            k3.f177471j = str3;
                            if (!TextUtils.isEmpty(str3)) {
                                k3.f177472k = ChnToSpell.d(k3.f177471j, 2);
                                k3.f177473l = ChnToSpell.d(k3.f177471j, 1);
                            } else {
                                k3.f177472k = "";
                                k3.f177473l = "";
                            }
                        }
                        if (!TextUtils.isEmpty(k3.f177474m)) {
                            str = k3.f177474m;
                        } else if (!TextUtils.isEmpty(k3.f177477p)) {
                            str = k3.f177477p;
                        } else if (!TextUtils.isEmpty(k3.f177471j)) {
                            str = k3.f177471j;
                        } else if (TextUtils.isEmpty(k3.f177464c)) {
                            str = "";
                        } else {
                            str = k3.f177464c;
                        }
                        if (!Utils.p(str, k3.f177466e)) {
                            k3.f177466e = str;
                            if (!TextUtils.isEmpty(str)) {
                                k3.f177467f = ChnToSpell.d(k3.f177466e, 2);
                                k3.f177468g = ChnToSpell.d(k3.f177466e, 1);
                            } else {
                                k3.f177467f = "";
                                k3.f177468g = "";
                            }
                            z16 = true;
                        }
                    }
                }
                TroopTransferActivity.this.U2(z16);
            }
        }, 5, null, true);
    }

    void refreshSearchResultList(String str) {
        this.f177431m0.clear();
        this.f177430l0.getLayoutParams().height = -1;
        if (!str.equals("") && str.trim().length() != 0) {
            this.f177426h0.setVisibility(0);
            this.f177429k0.setVisibility(0);
            String lowerCase = str.toLowerCase();
            List<m> j3 = this.f177423e0.j();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < j3.size(); i3++) {
                m mVar = j3.get(i3);
                mVar.f177469h = "";
                mVar.f177470i = "";
                if (!mVar.f177477p.equalsIgnoreCase(lowerCase) && !mVar.f177479r.equalsIgnoreCase(lowerCase) && !mVar.f177478q.equalsIgnoreCase(lowerCase)) {
                    if (!mVar.f177474m.equalsIgnoreCase(lowerCase) && !mVar.f177476o.equalsIgnoreCase(lowerCase) && !mVar.f177475n.equalsIgnoreCase(lowerCase)) {
                        if (!mVar.f177471j.equalsIgnoreCase(lowerCase) && !mVar.f177473l.equalsIgnoreCase(lowerCase) && !mVar.f177472k.equalsIgnoreCase(lowerCase)) {
                            if (mVar.f177464c.equals(lowerCase)) {
                                mVar.f177469h = mVar.f177464c;
                                arrayList.add(mVar);
                            } else if (mVar.f177477p.toLowerCase().indexOf(lowerCase) != 0 && mVar.f177479r.toLowerCase().indexOf(lowerCase) != 0 && mVar.f177478q.toLowerCase().indexOf(lowerCase) != 0) {
                                if (mVar.f177474m.toLowerCase().indexOf(lowerCase) != 0 && mVar.f177476o.toLowerCase().indexOf(lowerCase) != 0 && mVar.f177475n.toLowerCase().indexOf(lowerCase) != 0) {
                                    if (mVar.f177471j.toLowerCase().indexOf(lowerCase) != 0 && mVar.f177473l.toLowerCase().indexOf(lowerCase) != 0 && mVar.f177472k.toLowerCase().indexOf(lowerCase) != 0) {
                                        if (mVar.f177464c.indexOf(lowerCase) == 0) {
                                            String str2 = mVar.f177464c;
                                            mVar.f177469h = str2;
                                            mVar.f177470i = str2;
                                            arrayList2.add(mVar);
                                        } else if (mVar.f177477p.toLowerCase().indexOf(lowerCase) <= 0 && mVar.f177479r.toLowerCase().indexOf(lowerCase) <= 0 && mVar.f177478q.toLowerCase().indexOf(lowerCase) <= 0) {
                                            if (mVar.f177474m.toLowerCase().indexOf(lowerCase) <= 0 && mVar.f177476o.toLowerCase().indexOf(lowerCase) <= 0 && mVar.f177475n.toLowerCase().indexOf(lowerCase) <= 0) {
                                                if (mVar.f177471j.toLowerCase().indexOf(lowerCase) <= 0 && mVar.f177473l.toLowerCase().indexOf(lowerCase) <= 0 && mVar.f177472k.toLowerCase().indexOf(lowerCase) <= 0) {
                                                    if (mVar.f177464c.indexOf(lowerCase) > 0) {
                                                        mVar.f177469h = mVar.f177464c;
                                                        arrayList3.add(mVar);
                                                    }
                                                } else {
                                                    mVar.f177469h = mVar.f177471j;
                                                    arrayList3.add(mVar);
                                                }
                                            } else {
                                                mVar.f177469h = mVar.f177474m;
                                                arrayList3.add(mVar);
                                            }
                                        } else {
                                            mVar.f177469h = mVar.f177477p;
                                            arrayList3.add(mVar);
                                        }
                                    } else {
                                        mVar.f177469h = mVar.f177471j;
                                        mVar.f177470i = mVar.f177472k;
                                        arrayList2.add(mVar);
                                    }
                                } else {
                                    mVar.f177469h = mVar.f177474m;
                                    mVar.f177470i = mVar.f177475n;
                                    arrayList2.add(mVar);
                                }
                            } else {
                                mVar.f177469h = mVar.f177477p;
                                mVar.f177470i = mVar.f177478q;
                                arrayList2.add(mVar);
                            }
                        } else {
                            mVar.f177469h = mVar.f177471j;
                            arrayList.add(mVar);
                        }
                    } else {
                        mVar.f177469h = mVar.f177474m;
                        arrayList.add(mVar);
                    }
                } else {
                    mVar.f177469h = mVar.f177477p;
                    arrayList.add(mVar);
                }
            }
            Collections.sort(arrayList2, new k());
            this.f177431m0.addAll(arrayList);
            this.f177431m0.addAll(arrayList2);
            this.f177431m0.addAll(arrayList3);
            if (this.f177431m0.isEmpty()) {
                this.f177427i0.setVisibility(0);
            } else {
                this.f177427i0.setVisibility(8);
            }
            this.f177432n0.notifyDataSetChanged();
            return;
        }
        this.f177426h0.setVisibility(8);
        this.f177429k0.setVisibility(8);
        this.f177427i0.setVisibility(8);
        this.f177432n0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
