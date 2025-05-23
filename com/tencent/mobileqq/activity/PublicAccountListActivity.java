package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;

/* loaded from: classes9.dex */
public class PublicAccountListActivity extends BaseActivity implements IndexView.b, ThreadExcutor.IThreadListener {
    static IPatchRedirector $redirector_;
    List<o> A0;
    p B0;
    IPublicAccountDataManager C0;
    private RedTouch D0;
    private MqqHandler E0;
    Handler.Callback F0;
    Runnable G0;
    private com.tencent.mobileqq.app.ar H0;
    private IPublicAccountObserver I0;
    private boolean J0;
    private com.tencent.mobileqq.observer.a K0;
    private AdapterView.OnItemClickListener L0;
    View.OnClickListener M0;
    private Comparator<o> N0;

    /* renamed from: a0, reason: collision with root package name */
    Drawable f176659a0;

    /* renamed from: b0, reason: collision with root package name */
    LinearLayout f176660b0;

    /* renamed from: c0, reason: collision with root package name */
    View f176661c0;

    /* renamed from: d0, reason: collision with root package name */
    TextView f176662d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f176663e0;

    /* renamed from: f0, reason: collision with root package name */
    TextView f176664f0;

    /* renamed from: g0, reason: collision with root package name */
    RelativeLayout f176665g0;

    /* renamed from: h0, reason: collision with root package name */
    View f176666h0;

    /* renamed from: i0, reason: collision with root package name */
    View f176667i0;

    /* renamed from: j0, reason: collision with root package name */
    TextView f176668j0;

    /* renamed from: k0, reason: collision with root package name */
    RelativeLayout f176669k0;

    /* renamed from: l0, reason: collision with root package name */
    XListView f176670l0;

    /* renamed from: m0, reason: collision with root package name */
    View f176671m0;

    /* renamed from: n0, reason: collision with root package name */
    EditText f176672n0;

    /* renamed from: o0, reason: collision with root package name */
    ImageButton f176673o0;

    /* renamed from: p0, reason: collision with root package name */
    s f176674p0;

    /* renamed from: q0, reason: collision with root package name */
    List<o> f176675q0;

    /* renamed from: r0, reason: collision with root package name */
    r f176676r0;

    /* renamed from: s0, reason: collision with root package name */
    boolean f176677s0;

    /* renamed from: t0, reason: collision with root package name */
    Dialog f176678t0;

    /* renamed from: u0, reason: collision with root package name */
    PinnedDividerListView f176679u0;

    /* renamed from: v0, reason: collision with root package name */
    IndexView f176680v0;

    /* renamed from: w0, reason: collision with root package name */
    View f176681w0;

    /* renamed from: x0, reason: collision with root package name */
    View f176682x0;

    /* renamed from: y0, reason: collision with root package name */
    View f176683y0;

    /* renamed from: z0, reason: collision with root package name */
    LayoutInflater f176684z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PublicAccountListActivity.this.f176672n0.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PublicAccountListActivity.this.f176678t0.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16) {
                PublicAccountListActivity.this.refresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    class d extends com.tencent.mobileqq.observer.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.a, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (PublicAccountListActivity.this.J0) {
                PublicAccountListActivity.this.N2();
            }
        }
    }

    /* loaded from: classes9.dex */
    class e implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            o oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (view == null) {
                QLog.w("PublicAccountListActivity", 1, "the view is null, position is:" + i3);
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof q) {
                oVar = ((q) tag).f176709i;
            } else if (tag instanceof u) {
                oVar = ((u) tag).f176713i;
            } else {
                oVar = null;
            }
            if (oVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("PublicAccountListActivity", 2, "onItemClick - info = null[position = " + i3 + "]");
                    return;
                }
                return;
            }
            Intent intent = new Intent(PublicAccountListActivity.this, (Class<?>) ChatActivity.class);
            String uin = oVar.f176706a.getUin();
            if (oVar.f176706a.extendType == 2) {
                intent.putExtra("chat_subType", 1);
            } else {
                i16 = 1008;
            }
            if (TextUtils.isEmpty(uin)) {
                if (QLog.isColorLevel()) {
                    QLog.w("PublicAccountListActivity", 2, "onItemClick - uin = null");
                    return;
                }
                return;
            }
            intent.putExtra("uin", uin);
            intent.putExtra("uintype", i16);
            intent.putExtra("uinname", oVar.f176706a.name);
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, PublicAccountListActivity.this.getString(R.string.f171208d54));
            intent.putExtra("jump_from", 3);
            PublicAccountListActivity.this.startActivity(intent);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(PublicAccountListActivity.this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, uin, "mp_msg_sys_4", "contacts_aio", 0, 0, uin, "", "", "", false);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(PublicAccountListActivity.this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800573B", "0X800573B", 0, 0, uin, "", "", "", false);
        }
    }

    /* loaded from: classes9.dex */
    class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.ivTitleBtnLeft) {
                    PublicAccountListActivity.this.finish();
                } else if (id5 == R.id.ivTitleBtnRightText) {
                    em.b(PublicAccountListActivity.this);
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(PublicAccountListActivity.this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
                    IRedTouchManager iRedTouchManager = (IRedTouchManager) PublicAccountListActivity.this.app.getRuntimeService(IRedTouchManager.class, "");
                    BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("101000.101001");
                    if (appInfoByPath != null && appInfoByPath.iNewFlag.get() == 1) {
                        ReportController.o(PublicAccountListActivity.this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
                    }
                    iRedTouchManager.onRedTouchItemClick("101000.101001");
                } else if (id5 == R.id.ao6) {
                    String str = (String) view.getTag(-1);
                    String str2 = (String) view.getTag(-2);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        PublicAccountListActivity publicAccountListActivity = PublicAccountListActivity.this;
                        CrmUtils.z(publicAccountListActivity.app, publicAccountListActivity, str2, str, "IvrEnterpriseDetailEngineFalse");
                    } else if (QLog.isColorLevel()) {
                        QLog.w("PublicAccountListActivity", 2, "onClick - uin = " + str + ", name = " + str2);
                    }
                } else if (id5 == R.id.g4g) {
                    PublicAccountListActivity publicAccountListActivity2 = PublicAccountListActivity.this;
                    em.c(publicAccountListActivity2, (String) publicAccountListActivity2.f176671m0.getTag());
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(PublicAccountListActivity.this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
                } else if (id5 == R.id.ik7) {
                    PublicAccountListActivity publicAccountListActivity3 = PublicAccountListActivity.this;
                    em.c(publicAccountListActivity3, (String) publicAccountListActivity3.f176671m0.getTag());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes9.dex */
    class g implements Comparator<o> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(o oVar, o oVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar, (Object) oVar2)).intValue();
            }
            String str = oVar.f176706a.name;
            String str2 = oVar2.f176706a.name;
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null && str2 != null) {
                return -1;
            }
            if (str != null && str2 == null) {
                return 1;
            }
            int length = str.length();
            int length2 = str2.length();
            int min = Math.min(length, length2);
            for (int i3 = 0; i3 < min; i3++) {
                char charAt = str.charAt(i3);
                char charAt2 = str2.charAt(i3);
                if (charAt != charAt2) {
                    ChnToSpell.a b16 = ChnToSpell.b(charAt, i3);
                    ChnToSpell.a b17 = ChnToSpell.b(charAt2, i3);
                    int i16 = b16.f306904a;
                    int i17 = b17.f306904a;
                    if (i16 == i17) {
                        return b16.f306905b.compareTo(b17.f306905b);
                    }
                    return i16 - i17;
                }
            }
            if (length < length2) {
                return -1;
            }
            if (length <= length2) {
                return 0;
            }
            return 1;
        }
    }

    /* loaded from: classes9.dex */
    class h extends IPublicAccountObserver.c {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, obj);
            } else if (i3 == 0) {
                PublicAccountListActivity.this.refresh();
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, obj);
            } else if (i3 == 0) {
                PublicAccountListActivity.this.refresh();
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUpdateUserFollowList(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (z16) {
                PublicAccountListActivity.this.refresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    class i implements Handler.Callback {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == 0) {
                PublicAccountListActivity.this.refresh();
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class j implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                PublicAccountListActivity.this.clickSearchBar();
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(PublicAccountListActivity.this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800573C", "0X800573C", 0, 0, "", "", "", "", false);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class k implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f176695d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f176696e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f176697f;

        k(TranslateAnimation translateAnimation, TranslateAnimation translateAnimation2, int i3) {
            this.f176695d = translateAnimation;
            this.f176696e = translateAnimation2;
            this.f176697f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PublicAccountListActivity.this, translateAnimation, translateAnimation2, Integer.valueOf(i3));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            if (animation == this.f176695d) {
                PublicAccountListActivity.this.f176678t0.show();
                PublicAccountListActivity.this.f176660b0.setAnimation(null);
                PublicAccountListActivity.this.f176661c0.setVisibility(8);
            } else if (animation == this.f176696e) {
                PublicAccountListActivity.this.f176660b0.setAnimation(null);
                PublicAccountListActivity.this.f176660b0.offsetTopAndBottom(this.f176697f);
                PublicAccountListActivity.this.f176660b0.requestLayout();
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
    /* loaded from: classes9.dex */
    public class l implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f176699d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f176700e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ InputMethodManager f176701f;

        l(int i3, TranslateAnimation translateAnimation, InputMethodManager inputMethodManager) {
            this.f176699d = i3;
            this.f176700e = translateAnimation;
            this.f176701f = inputMethodManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PublicAccountListActivity.this, Integer.valueOf(i3), translateAnimation, inputMethodManager);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            PublicAccountListActivity.this.f176671m0.setTag("");
            PublicAccountListActivity publicAccountListActivity = PublicAccountListActivity.this;
            publicAccountListActivity.f176677s0 = false;
            publicAccountListActivity.f176660b0.offsetTopAndBottom(-this.f176699d);
            PublicAccountListActivity.this.f176661c0.setVisibility(0);
            PublicAccountListActivity.this.f176660b0.startAnimation(this.f176700e);
            this.f176701f.hideSoftInputFromWindow(PublicAccountListActivity.this.getWindow().peekDecorView().getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PublicAccountListActivity.this.f176678t0.cancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class n implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputMethodManager f176704d;

        n(InputMethodManager inputMethodManager) {
            this.f176704d = inputMethodManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this, (Object) inputMethodManager);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            this.f176704d.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class o {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public PublicAccountInfo f176706a;

        /* renamed from: b, reason: collision with root package name */
        public String f176707b;

        /* renamed from: c, reason: collision with root package name */
        public String f176708c;

        public o(PublicAccountInfo publicAccountInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) publicAccountInfo);
                return;
            }
            this.f176707b = "";
            this.f176708c = "";
            this.f176706a = publicAccountInfo;
        }

        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            if (str == null) {
                str = "";
            }
            this.f176708c = str;
        }

        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (str == null) {
                str = "";
            }
            this.f176707b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class p extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        public LinkedHashMap<String, List<o>> D;
        public int[] E;
        public String[] F;
        public int G;
        public int H;

        public p() {
            super(PublicAccountListActivity.this, PublicAccountListActivity.this.app, PublicAccountListActivity.this.f176679u0, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
                return;
            }
            this.D = new LinkedHashMap<>();
            this.E = new int[0];
            this.F = new String[0];
            this.G = 0;
            this.H = 0;
        }

        private void g() {
            char c16;
            int i3;
            String str;
            this.D.clear();
            List<o> list = PublicAccountListActivity.this.A0;
            if (list == null) {
                return;
            }
            Iterator<o> it = list.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                i3 = 0;
                String str2 = "#";
                if (!hasNext) {
                    break;
                }
                o next = it.next();
                if (!PublicAccountListActivity.this.L2(next)) {
                    String str3 = next.f176707b;
                    if (str3 == null || str3.length() == 0) {
                        str = "#";
                    } else {
                        str = next.f176707b.substring(0, 1);
                    }
                    char charAt = str.charAt(0);
                    if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                        str2 = str.toUpperCase();
                    }
                    if (this.D.get(str2) == null) {
                        this.D.put(str2, new ArrayList());
                    }
                    this.D.get(str2).add(next);
                }
            }
            LinkedHashMap<String, List<o>> linkedHashMap = this.D;
            this.D = new LinkedHashMap<>();
            for (c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                if (linkedHashMap.get(String.valueOf(c16)) != null) {
                    List<o> list2 = linkedHashMap.get(String.valueOf(c16));
                    Collections.sort(list2, PublicAccountListActivity.this.N0);
                    this.D.put(String.valueOf(c16), list2);
                }
            }
            if (linkedHashMap.get("#") != null) {
                List<o> list3 = linkedHashMap.get("#");
                Collections.sort(list3, PublicAccountListActivity.this.N0);
                this.D.put("#", list3);
            }
            linkedHashMap.clear();
            int[] iArr = new int[this.D.keySet().size()];
            this.E = iArr;
            this.F = new String[iArr.length];
            Iterator<String> it5 = this.D.keySet().iterator();
            int[] iArr2 = this.E;
            if (iArr2.length == 0) {
                return;
            }
            iArr2[0] = 0;
            int i16 = 1;
            while (true) {
                int[] iArr3 = this.E;
                if (i16 >= iArr3.length) {
                    break;
                }
                iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + this.D.get(it5.next()).size() + 1;
                i16++;
            }
            Iterator<String> it6 = this.D.keySet().iterator();
            while (it6.hasNext()) {
                this.F[i3] = it6.next();
                i3++;
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
                return;
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            String[] strArr = this.F;
            if (binarySearch >= strArr.length) {
                return;
            }
            ((TextView) view).setText(strArr[binarySearch]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.adapter.e
        public boolean f(com.tencent.mobileqq.adapter.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) kVar)).booleanValue();
            }
            if (kVar.f187212f == null) {
                return false;
            }
            return super.f(kVar);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int[] iArr = this.E;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.D.get(this.F[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return R.layout.f168254qf;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch >= 0) {
                return null;
            }
            return this.D.get(this.F[(-(binarySearch + 1)) - 1]).get((i3 - this.E[r0]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            q qVar;
            View view2;
            View view3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int binarySearch = Arrays.binarySearch(this.E, i3);
                if (view == null) {
                    view2 = PublicAccountListActivity.this.f176684z0.inflate(R.layout.f168421vo, viewGroup, false);
                    qVar = new q();
                    qVar.f187212f = null;
                    qVar.K = (QQProAvatarView) view2.findViewById(R.id.icon);
                    qVar.f176710m = (ImageView) view2.findViewById(R.id.ao6);
                    qVar.F = (TextView) view2.findViewById(R.id.text1);
                    qVar.C = (TextView) view2.findViewById(R.id.g4_);
                    qVar.E = (TextView) view2.findViewById(R.id.g3t);
                    qVar.D = (TextView) view2.findViewById(R.id.g4j);
                    qVar.G = (TextView) view2.findViewById(R.id.text2);
                    qVar.H = (TextView) view2.findViewById(R.id.k8u);
                    qVar.I = view2.findViewById(R.id.g47);
                    qVar.J = (ImageView) view2.findViewById(R.id.anv);
                    view2.setTag(qVar);
                } else {
                    qVar = (q) view.getTag();
                    view2 = view;
                }
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    o oVar = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
                    qVar.f176709i = oVar;
                    qVar.f187210d = String.valueOf(oVar.f176706a.uin);
                    qVar.I.setVisibility(0);
                    qVar.H.setVisibility(8);
                    qVar.F.setVisibility(0);
                    qVar.F.setText(oVar.f176706a.name);
                    if (oVar.f176706a.certifiedGrade > 0) {
                        PublicAccountListActivity publicAccountListActivity = PublicAccountListActivity.this;
                        if (publicAccountListActivity.f176659a0 == null) {
                            publicAccountListActivity.f176659a0 = publicAccountListActivity.getResources().getDrawable(R.drawable.br7);
                            PublicAccountListActivity.this.f176659a0.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0f), ImmersiveUtils.dpToPx(15.0f));
                        }
                        ThemeUtil.setThemeFilter(PublicAccountListActivity.this.f176659a0, ThemeUtil.curThemeId);
                        qVar.F.setCompoundDrawables(null, null, PublicAccountListActivity.this.f176659a0, null);
                    } else {
                        qVar.F.setCompoundDrawables(null, null, null, null);
                    }
                    qVar.G.setText(oVar.f176706a.summary);
                    QQProAvatarView qQProAvatarView = qVar.K;
                    if (qQProAvatarView != null) {
                        qQProAvatarView.w(1, qVar.f187210d);
                    } else {
                        ImageView imageView = qVar.f187212f;
                        if (imageView != null) {
                            imageView.setImageBitmap(super.b(qVar.f187210d));
                        }
                    }
                    PublicAccountInfo publicAccountInfo = oVar.f176706a;
                    if (publicAccountInfo.extendType == 2) {
                        z16 = CrmUtils.o(PublicAccountListActivity.this.app, publicAccountInfo.getUin(), 1024);
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        qVar.f176710m.setTag(-1, oVar.f176706a.getUin());
                        qVar.f176710m.setTag(-2, oVar.f176706a.name);
                        qVar.f176710m.setOnClickListener(PublicAccountListActivity.this.M0);
                        qVar.f176710m.setVisibility(0);
                    } else {
                        qVar.f176710m.setTag(-1, "");
                        qVar.f176710m.setTag(-2, "");
                        qVar.f176710m.setOnClickListener(null);
                        qVar.f176710m.setVisibility(4);
                    }
                    if (!z16) {
                        qVar.J.setTag(-1, "");
                        qVar.J.setTag(-2, "");
                        qVar.J.setOnClickListener(null);
                        qVar.J.setVisibility(4);
                    }
                    qVar.E.setVisibility(8);
                    qVar.C.setVisibility(8);
                    qVar.D.setVisibility(8);
                    if (AppSetting.f99565y) {
                        StringBuilder sb5 = new StringBuilder(24);
                        sb5.append(qVar.F.getText());
                        sb5.append(" \u7b80\u4ecb ");
                        sb5.append(qVar.G.getText());
                        view2.setContentDescription(sb5);
                        view2.setFocusable(true);
                        view2.setFocusableInTouchMode(true);
                    }
                } else {
                    qVar.f176709i = null;
                    qVar.f187210d = "";
                    qVar.I.setVisibility(8);
                    qVar.H.setVisibility(0);
                    String valueOf = String.valueOf(this.F[binarySearch]);
                    qVar.H.setText(valueOf);
                    if (AppSetting.f99565y) {
                        qVar.H.setContentDescription(String.format(PublicAccountListActivity.this.getString(R.string.aud), valueOf.toLowerCase()));
                    }
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).intValue();
            }
            if (this.F != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.F;
                    if (i3 < strArr.length) {
                        if (strArr[i3].equals(str)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    return this.E[i3];
                }
            }
            return -1;
        }

        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this);
            } else {
                g();
                super.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(this.E, i3) >= 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.adapter.e, com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            }
        }
    }

    /* loaded from: classes9.dex */
    static class q extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public TextView D;
        public TextView E;
        public TextView F;
        public TextView G;
        public TextView H;
        public View I;
        public ImageView J;
        public QQProAvatarView K;

        /* renamed from: i, reason: collision with root package name */
        public o f176709i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f176710m;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class r extends com.tencent.mobileqq.adapter.j {
        static IPatchRedirector $redirector_;
        private List<o> F;

        public r(List<o> list) {
            super(PublicAccountListActivity.this, PublicAccountListActivity.this.app, PublicAccountListActivity.this.f176670l0, 1, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this, (Object) list);
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
            List<o> list = this.F;
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
            u uVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = PublicAccountListActivity.this.f176684z0.inflate(R.layout.f168423vq, viewGroup, false);
                    uVar = new u();
                    uVar.f187212f = (ImageView) view.findViewById(R.id.icon);
                    uVar.f176714m = (TextView) view.findViewById(R.id.f5e);
                    view.setTag(uVar);
                } else {
                    uVar = (u) view.getTag();
                }
                Object item = getItem(i3);
                if (item != null) {
                    o oVar = (o) item;
                    String uin = oVar.f176706a.getUin();
                    uVar.f187210d = uin;
                    uVar.f176713i = oVar;
                    uVar.f187212f.setImageBitmap(super.d(uin, 1, (byte) 0));
                    uVar.f176714m.setText(oVar.f176706a.name);
                    if (oVar.f176706a.certifiedGrade > 0) {
                        PublicAccountListActivity publicAccountListActivity = PublicAccountListActivity.this;
                        if (publicAccountListActivity.f176659a0 == null) {
                            publicAccountListActivity.f176659a0 = publicAccountListActivity.getResources().getDrawable(R.drawable.br7);
                            PublicAccountListActivity.this.f176659a0.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0f), ImmersiveUtils.dpToPx(15.0f));
                            ThemeUtil.setThemeFilter(PublicAccountListActivity.this.f176659a0, ThemeUtil.curThemeId);
                        }
                        uVar.f176714m.setCompoundDrawables(null, null, PublicAccountListActivity.this.f176659a0, null);
                    } else {
                        uVar.f176714m.setCompoundDrawables(null, null, null, null);
                    }
                    if (AppSetting.f99565y) {
                        view.setContentDescription(uVar.f176714m.getText());
                    }
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes9.dex */
    public class s implements Comparator<o> {
        static IPatchRedirector $redirector_;

        public s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(o oVar, o oVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar, (Object) oVar2)).intValue();
            }
            return (int) (oVar2.f176706a.certifiedGrade - oVar.f176706a.certifiedGrade);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class t implements TextWatcher {
        static IPatchRedirector $redirector_;

        protected t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) editable);
            } else {
                PublicAccountListActivity.this.refreshSearchResultList(PublicAccountListActivity.this.f176672n0.getText().toString().trim());
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

    /* loaded from: classes9.dex */
    static class u extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public o f176713i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f176714m;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PublicAccountListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176674p0 = new s();
        this.f176675q0 = new ArrayList();
        this.f176677s0 = false;
        this.A0 = new ArrayList();
        this.B0 = null;
        this.F0 = new i();
        this.G0 = new Runnable() { // from class: com.tencent.mobileqq.activity.PublicAccountListActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PublicAccountListActivity.this.C0.initPublicAccountDataManager();
                }
            }
        };
        this.H0 = new c();
        this.J0 = false;
        this.K0 = new d();
        this.L0 = new e();
        this.M0 = new f();
        this.N0 = new g();
    }

    private o J2(PublicAccountInfo publicAccountInfo) {
        o oVar = new o(publicAccountInfo);
        oVar.b(ChnToSpell.d(publicAccountInfo.name, 2));
        oVar.a(ChnToSpell.d(publicAccountInfo.name, 1));
        return oVar;
    }

    private void K2() {
        View view = this.f176683y0;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f176681w0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L2(o oVar) {
        return false;
    }

    private void M2() {
        if (this.f176683y0 == null) {
            ViewStub viewStub = (ViewStub) super.findViewById(R.id.bww);
            if (viewStub == null) {
                return;
            }
            View inflate = viewStub.inflate();
            this.f176683y0 = inflate;
            inflate.findViewById(R.id.ik7).setOnClickListener(this.M0);
        }
        this.f176683y0.setVisibility(0);
        this.f176681w0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        if (this.D0 != null) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("101000.101001");
            if (appInfoByPath != null && appInfoByPath.iNewFlag.get() == 1) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
            }
            this.D0.parseRedTouch(appInfoByPath);
            iRedTouchManager.onReportRedPointExposure(appInfoByPath);
        }
    }

    private void initListView() {
        View inflate = super.getLayoutInflater().inflate(R.layout.f168418vl, (ViewGroup) this.f176679u0, false);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.iir);
        this.f176665g0 = relativeLayout;
        ((EditText) relativeLayout.findViewById(R.id.et_search_keyword)).setOnTouchListener(new j());
        ((Button) this.f176665g0.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        this.f176679u0.addHeaderView(inflate);
        p pVar = new p();
        this.B0 = pVar;
        this.f176679u0.setAdapter((ListAdapter) pVar);
        this.f176680v0.setIndex(new String[]{"$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.f176680v0.setOnIndexChangedListener(this);
        initSearchDialogAndSearchList();
    }

    private void initSearchDialogAndSearchList() {
        ReportDialog reportDialog = new ReportDialog(this);
        this.f176678t0 = reportDialog;
        reportDialog.setCanceledOnTouchOutside(true);
        this.f176678t0.requestWindowFeature(1);
        this.f176678t0.getWindow().setSoftInputMode(36);
        this.f176678t0.setContentView(R.layout.f168425vs);
        WindowManager.LayoutParams attributes = this.f176678t0.getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        this.f176678t0.getWindow().setBackgroundDrawable(new ColorDrawable());
        InputMethodManager inputMethodManager = (InputMethodManager) super.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        XListView xListView = (XListView) this.f176678t0.findViewById(R.id.searchList);
        this.f176670l0 = xListView;
        xListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_texture));
        this.f176670l0.setDividerHeight(0);
        View inflate = this.f176684z0.inflate(R.layout.f168424vr, (ViewGroup) this.f176670l0, false);
        this.f176671m0 = inflate;
        inflate.setOnClickListener(this.M0);
        this.f176670l0.addFooterView(this.f176671m0);
        this.f176671m0.setTag("");
        this.f176675q0.clear();
        r rVar = new r(this.f176675q0);
        this.f176676r0 = rVar;
        this.f176670l0.setAdapter((ListAdapter) rVar);
        this.f176670l0.setOnItemClickListener(this.L0);
        this.f176670l0.setOnTouchListener(new n(inputMethodManager));
        this.f176666h0 = this.f176678t0.findViewById(R.id.root);
        EditText editText = (EditText) this.f176678t0.findViewById(R.id.et_search_keyword);
        this.f176672n0 = editText;
        editText.addTextChangedListener(new t());
        ImageButton imageButton = (ImageButton) this.f176678t0.findViewById(R.id.ib_clear_text);
        this.f176673o0 = imageButton;
        imageButton.setOnClickListener(new a());
        RelativeLayout relativeLayout = (RelativeLayout) this.f176678t0.findViewById(R.id.result_layout);
        this.f176669k0 = relativeLayout;
        relativeLayout.setOnClickListener(new b());
        this.f176667i0 = this.f176678t0.findViewById(R.id.d5s);
        this.f176668j0 = (TextView) this.f176678t0.findViewById(R.id.bgt);
        ((Button) this.f176667i0.findViewById(R.id.ik7)).setOnClickListener(this.M0);
    }

    private void initTitleBar() {
        this.f176662d0.setText(R.string.f171208d54);
        this.f176663e0.setText(R.string.d5c);
        this.f176664f0.setText(R.string.f170028dd);
        RedTouch redTouch = new RedTouch(this, this.f176664f0);
        this.D0 = redTouch;
        redTouch.setGravity(53).setTopMargin(5.0f).setRightMargin(5.0f).applyTo();
        this.f176663e0.setOnClickListener(this.M0);
        this.f176664f0.setOnClickListener(this.M0);
        if (AppSetting.f99565y) {
            TextView textView = this.f176662d0;
            textView.setContentDescription(textView.getText());
            this.f176663e0.setContentDescription(((Object) this.f176663e0.getText()) + HardCodeUtil.qqStr(R.string.pmb));
        }
    }

    @TargetApi(14)
    private void initViews() {
        this.f176660b0 = (LinearLayout) super.findViewById(R.id.g4b);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f176660b0.setFitsSystemWindows(true);
        }
        this.f176661c0 = super.findViewById(R.id.jo9);
        this.f176662d0 = (TextView) super.findViewById(R.id.ivTitleName);
        this.f176663e0 = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
        TextView textView = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        this.f176664f0 = textView;
        textView.setVisibility(0);
        this.f176681w0 = super.findViewById(R.id.b_7);
        this.f176679u0 = (PinnedDividerListView) super.findViewById(R.id.g49);
        this.f176680v0 = (IndexView) super.findViewById(R.id.djh);
        this.f176682x0 = super.findViewById(R.id.g2d);
        this.f176679u0.setOnItemClickListener(this.L0);
    }

    protected void clickSearchBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) super.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        int height = this.f176661c0.getHeight();
        float f16 = -height;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.f176660b0.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        translateAnimation2.setDuration(300L);
        translateAnimation.setAnimationListener(new k(translateAnimation, translateAnimation2, height));
        this.f176678t0.setOnDismissListener(new l(height, translateAnimation2, inputMethodManager));
        this.f176672n0.setText("");
        this.f176672n0.setSelection(0);
        this.f176672n0.requestFocus();
        Button button = (Button) this.f176678t0.findViewById(R.id.btn_cancel_search);
        button.setVisibility(0);
        button.setOnClickListener(new m());
        this.f176675q0.clear();
        this.f176676r0.notifyDataSetChanged();
        this.f176677s0 = true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.C0 = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        super.setContentView(R.layout.f168417vk);
        this.f176684z0 = super.getLayoutInflater();
        initViews();
        initTitleBar();
        initListView();
        if (this.C0.isCached()) {
            refresh();
        } else {
            ThreadManagerV2.post(this.G0, 5, this, true);
        }
        setAccSoft();
        IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
        this.I0 = iPublicAccountObserver;
        iPublicAccountObserver.setOnCallback(new h());
        super.addObserver(this.I0.getBusinessObserver());
        super.addObserver(this.H0);
        this.app.registObserver(this.K0);
        this.E0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.F0);
        this.app.setHandler(getClass(), this.E0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.removeObserver(this.I0.getBusinessObserver());
        super.removeObserver(this.H0);
        p pVar = this.B0;
        if (pVar != null) {
            pVar.destroy();
        }
        r rVar = this.f176676r0;
        if (rVar != null) {
            rVar.destroy();
        }
        super.doOnDestroy();
        this.app.unRegistObserver(this.K0);
        this.app.removeHandler(getClass());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.doOnPause();
            this.J0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnResume();
        this.J0 = true;
        try {
            getWindow().setSoftInputMode(48);
        } catch (Exception unused) {
        }
        View view = this.f176661c0;
        if (view != null) {
            view.destroyDrawingCache();
            this.f176661c0.requestLayout();
            this.f176661c0.invalidate();
        }
        N2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.doOnStop();
            getWindow().setSoftInputMode(16);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onAdded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.f176679u0.setSelection(0);
            return;
        }
        int h16 = this.B0.h(str);
        if (h16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.f176679u0;
            pinnedDividerListView.setSelection(h16 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPostRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.PublicAccountListActivity.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublicAccountListActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PublicAccountListActivity.this.refresh();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPreRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (z16) {
            com.tencent.mobileqq.utils.cc.a("pubAcc_follow_list_display", null, "");
        }
    }

    void refresh() {
        this.A0.clear();
        ArrayList<Entity> publicAccountListNotIVR = this.C0.getPublicAccountListNotIVR();
        if (publicAccountListNotIVR != null && publicAccountListNotIVR.size() > 0) {
            K2();
            Iterator<Entity> it = publicAccountListNotIVR.iterator();
            while (it.hasNext()) {
                this.A0.add(J2((PublicAccountInfo) it.next()));
            }
            if (publicAccountListNotIVR.size() < 15) {
                this.f176680v0.setVisibility(8);
            } else {
                this.f176680v0.setVisibility(0);
            }
        } else {
            M2();
        }
        this.B0.i();
        if (this.f176677s0) {
            this.f176678t0.dismiss();
        }
    }

    protected void refreshSearchResultList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f176675q0.clear();
        this.f176666h0.getLayoutParams().height = -1;
        if (str != null && str.trim().length() != 0) {
            this.f176673o0.setVisibility(0);
            this.f176670l0.setVisibility(0);
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (o oVar : this.A0) {
                String str2 = oVar.f176706a.displayNumber;
                if (str2 != null && str2.equalsIgnoreCase(lowerCase)) {
                    arrayList4.add(oVar);
                } else {
                    String lowerCase2 = oVar.f176706a.name.toLowerCase();
                    if (!lowerCase2.equals(lowerCase) && !oVar.f176708c.equals(lowerCase) && !oVar.f176707b.equals(lowerCase)) {
                        if (lowerCase2.indexOf(lowerCase) != 0 && oVar.f176708c.indexOf(lowerCase) != 0 && oVar.f176707b.indexOf(lowerCase) != 0) {
                            if (lowerCase2.indexOf(lowerCase) > 0 || oVar.f176708c.indexOf(lowerCase) > 0 || oVar.f176707b.indexOf(lowerCase) > 0) {
                                arrayList3.add(oVar);
                            }
                        } else {
                            arrayList2.add(oVar);
                        }
                    } else {
                        arrayList.add(oVar);
                    }
                }
            }
            Collections.sort(arrayList4, this.f176674p0);
            Collections.sort(arrayList, this.f176674p0);
            Collections.sort(arrayList2, this.f176674p0);
            Collections.sort(arrayList3, this.f176674p0);
            this.f176675q0.addAll(arrayList4);
            this.f176675q0.addAll(arrayList);
            this.f176675q0.addAll(arrayList2);
            this.f176675q0.addAll(arrayList3);
            if (this.f176675q0.isEmpty()) {
                this.f176668j0.setText(getString(R.string.d5l, lowerCase));
                this.f176667i0.setVisibility(0);
                this.f176670l0.setVisibility(8);
            } else {
                this.f176667i0.setVisibility(8);
                this.f176670l0.setVisibility(0);
            }
            this.f176671m0.setTag(lowerCase);
            this.f176676r0.notifyDataSetChanged();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("PublicAccountListActivity", 2, "refreshSearchResultList:" + lowerCase + "," + (currentTimeMillis2 - currentTimeMillis) + "," + this.f176675q0.size() + "," + this.A0.size());
                return;
            }
            return;
        }
        this.f176673o0.setVisibility(8);
        this.f176670l0.setVisibility(8);
        this.f176667i0.setVisibility(8);
        this.f176676r0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.requestWindowFeature(1);
        }
    }

    protected void setAccSoft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.rlCommenTitle);
        if (viewGroup != null) {
            IphoneTitleBarActivity.setLayerType(viewGroup);
        }
        View findViewById = super.findViewById(R.id.jo9);
        if (findViewById != null) {
            IphoneTitleBarActivity.setLayerType(findViewById);
        }
        TextView textView = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            IphoneTitleBarActivity.setLayerType(textView);
        }
    }
}
