package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.verifycode.VerifyCodeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Face2FaceAddContactFragment extends IphoneTitleBarFragment implements com.tencent.mobileqq.activity.contact.addcontact.face2face.e, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Face2FaceAddContactPresenter C;
    private com.tencent.mobileqq.activity.contact.addcontact.face2face.a D;
    private LinearLayout E;
    private TextView F;
    private TextView G;
    private TextView H;
    private RecyclerView I;
    private LinearLayout J;
    private LinearLayout K;
    private Button L;
    private TextView M;
    private Drawable N;
    private String[] P;
    private String Q;
    private long R;
    private boolean S;
    private VerifyCodeView T;
    Handler U;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactFragment.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 5) {
                Face2FaceAddContactFragment.this.G.setVisibility(0);
                Face2FaceAddContactFragment.this.G.setText(R.string.vzy);
                Face2FaceAddContactFragment.this.I.setVisibility(8);
                Face2FaceAddContactFragment.this.J.setVisibility(0);
                return;
            }
            if (i3 == 301) {
                Face2FaceAddContactFragment.this.Kh();
                return;
            }
            if (i3 == 500) {
                Face2FaceAddContactFragment.this.Ah();
                Face2FaceAddContactFragment.this.Nh();
            } else if (i3 == 401) {
                removeMessages(301);
                Face2FaceAddContactFragment.this.je();
            } else if (i3 == 6) {
                Face2FaceAddContactFragment.this.Ih();
                QQToast.makeText(Face2FaceAddContactFragment.this.getBaseActivity(), Face2FaceAddContactFragment.this.getString(R.string.f170776a83), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements VerifyCodeView.OnInputListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactFragment.this);
            }
        }

        @Override // com.tencent.widget.verifycode.VerifyCodeView.OnInputListener
        public void onInputFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Face2FaceAddContactFragment.this.Q = str;
                Face2FaceAddContactFragment.this.Fh(str.length());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
                Face2FaceAddContactFragment.this.onBackEvent();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f181027d;

        d(Dialog dialog) {
            this.f181027d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactFragment.this, (Object) dialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f181027d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f181029d;

        e(Dialog dialog) {
            this.f181029d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactFragment.this, (Object) dialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f181029d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public Face2FaceAddContactFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.P = new String[]{"1234", "0000", "1111", "2222", "3333"};
        this.Q = new String();
        this.U = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        this.T.reset();
    }

    private void Bh() {
        if (!isDetached() && getBaseActivity() != null) {
            if (getBaseActivity().isResume()) {
                Ih();
                QQToast.makeText(getBaseActivity(), getString(R.string.f170915w00), 0).show();
            } else {
                this.S = true;
            }
        }
    }

    private void Ch() {
        if (!isDetached() && getBaseActivity() != null) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getBaseActivity().getPackageName(), null));
            getBaseActivity().startActivityForResult(intent, 1002);
        }
    }

    private void Dh() {
        if (getActivity() == null) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getActivity().getWindow().peekDecorView().getWindowToken(), 0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Eh() {
        this.quiSecNavBar.setCenterType(1);
        this.quiSecNavBar.setCenterText(getString(R.string.vzp));
        this.quiSecNavBar.setLeftType(0);
        Lh();
        this.E = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.b9t);
        this.M = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.g2d);
        this.F = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.jk7);
        this.G = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.jk8);
        this.I = (RecyclerView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cx6);
        this.D = new com.tencent.mobileqq.activity.contact.addcontact.face2face.a(getBaseActivity(), getBaseActivity().app, this.I);
        this.I.setLayoutManager(new GridLayoutManager(getBaseActivity(), 5));
        this.I.setAdapter(this.D);
        this.J = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ggk);
        this.K = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.gi5);
        Button button = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.b88);
        this.L = button;
        button.setOnClickListener(this);
        this.H = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.kbs);
        this.T = (VerifyCodeView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f116536z0);
        if (FontSettingManager.isFontSizeLarge()) {
            FontSettingManager.resetViewSize2Normal(getContext(), this.T);
        }
        this.T.setOnInputListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(int i3) {
        if (i3 == 4) {
            if (!NetworkUtil.isNetSupport(getBaseActivity())) {
                QQToast.makeText(getBaseActivity(), R.string.cjm, 0).show();
                this.U.sendEmptyMessageDelayed(500, 500L);
            } else if (Gh(this.Q)) {
                QQToast.makeText(getBaseActivity(), getString(R.string.i3h), 0).show();
                com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB5F", "", "", this.Q.toString());
                this.U.sendEmptyMessageDelayed(500, 500L);
            } else {
                this.M.setVisibility(0);
                this.M.setBackgroundDrawable(this.N);
                ((Animatable) this.N).start();
                this.C.v(getBaseActivity(), this.Q, null);
            }
        }
    }

    private boolean Gh(String str) {
        return Arrays.asList(this.P).contains(str);
    }

    private void Hh() {
        this.K.setVisibility(8);
        this.E.setVisibility(0);
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        Jh(true, true);
    }

    private void Jh(boolean z16, boolean z17) {
        if (isDetached()) {
            return;
        }
        ((Animatable) this.N).stop();
        this.M.setVisibility(8);
        this.M.setBackgroundDrawable(null);
        this.D.s();
        this.H.setVisibility(0);
        this.H.setText(getString(R.string.f224866k3));
        this.T.setVisibility(0);
        this.F.setVisibility(0);
        this.G.setVisibility(8);
        if (z17) {
            Ah();
        }
        this.I.setVisibility(8);
        if (z16) {
            Nh();
        }
        this.J.setVisibility(8);
        Handler handler = this.U;
        if (handler != null) {
            handler.removeMessages(301);
            this.U.removeMessages(401);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        if (this.C != null && this.D != null && getBaseActivity() != null && !getBaseActivity().isFinishing()) {
            if (QLog.isDebugVersion()) {
                QLog.d("Face2FaceAddContactFragment", 2, "sendFace2FaceHeartBeat isNetworkAvailable:" + NetworkUtil.isNetworkAvailable());
            }
            if (NetworkUtil.isNetworkAvailable()) {
                List<com.tencent.mobileqq.activity.contact.addcontact.face2face.d> u16 = this.D.u();
                ArrayList arrayList = new ArrayList();
                for (com.tencent.mobileqq.activity.contact.addcontact.face2face.d dVar : u16) {
                    if (dVar != null) {
                        arrayList.add(dVar.f181080a);
                    }
                }
                this.C.x(arrayList);
                return;
            }
            ig(20000);
        }
    }

    private void Lh() {
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setRightText(getString(R.string.cancel));
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new c());
    }

    private void Mh() {
        ((Animatable) this.N).stop();
        this.M.setVisibility(8);
        this.M.setBackgroundDrawable(null);
        Ph(0);
        this.D.notifyDataSetChanged();
        this.I.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        getActivity().getWindow().setSoftInputMode(16);
        VerifyCodeView verifyCodeView = this.T;
        if (verifyCodeView != null) {
            verifyCodeView.requestFocus();
            ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.T, 1);
        }
    }

    public static void Oh(Context context, Intent intent) {
        PublicFragmentActivity.start(context, intent, Face2FaceAddContactFragment.class);
    }

    private void Ph(int i3) {
        if (this.G != null && !isDetached()) {
            if (this.G.getVisibility() != 0) {
                this.T.setVisibility(8);
                this.F.setVisibility(8);
                this.G.setVisibility(0);
            }
            if (i3 > 0) {
                this.G.setVisibility(0);
                String string = getString(R.string.vzw, Integer.valueOf(i3));
                int indexOf = string.indexOf(String.valueOf(i3));
                if (indexOf < 0) {
                    this.G.setText(string);
                    return;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), indexOf, String.valueOf(i3).length() + indexOf, 33);
                this.G.setText(spannableStringBuilder);
                return;
            }
            this.G.setText(getString(R.string.vzv));
        }
    }

    private void initData() {
        this.C = new Face2FaceAddContactPresenter(this);
        this.N = getResources().getDrawable(R.drawable.common_loading6);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void A5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            Bh();
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void Cd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            return;
        }
        if (!isDetached() && getBaseActivity() != null) {
            Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", getBaseActivity().app.getCurrentUin());
            intent.putExtra("url", str);
            try {
                getBaseActivity().startActivityForResult(intent, 1001);
                com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB65", "", "", "");
            } catch (SecurityException unused) {
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void E5(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
            return;
        }
        if (!isDetached() && getBaseActivity() != null && list != null && getBaseActivity().app != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactHeartBeat() missingList.size() = " + list.size());
            }
            if (list.size() > 0) {
                IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    com.tencent.mobileqq.activity.contact.addcontact.face2face.d dVar = new com.tencent.mobileqq.activity.contact.addcontact.face2face.d();
                    dVar.f181080a = str;
                    dVar.f181082c = 1;
                    if (!this.D.u().contains(dVar)) {
                        String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(str);
                        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "Face2FaceAddContactFragment")) {
                            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                            aVar.d(uidFromUin);
                            dVar.f181081b = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                            arrayList.add(dVar);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    F3(getBaseActivity().app.getCurrentUin(), arrayList);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void F3(String str, List<com.tencent.mobileqq.activity.contact.addcontact.face2face.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) list);
            return;
        }
        if (!isDetached() && getBaseActivity() != null && list != null && list.size() > 0 && this.D.u() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactPush() faceFriends.size() = " + list.size());
            }
            if (this.I.getVisibility() != 0) {
                this.I.setVisibility(0);
                this.J.setVisibility(8);
            }
            int size = this.D.u().size();
            for (com.tencent.mobileqq.activity.contact.addcontact.face2face.d dVar : list) {
                if (!this.D.u().contains(dVar)) {
                    this.D.u().add(size, dVar);
                }
            }
            int size2 = this.D.u().size();
            if (size != size2) {
                this.D.notifyItemRangeInserted(size, size2 - size);
            }
            Ph(size2);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void G5(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (!isDetached() && getBaseActivity() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactFragment", 2, "onEnterFace2FaceAddContactSuccess() expireTimeMs:" + i3);
            }
            this.R = SystemClock.elapsedRealtime();
            Mh();
            if (this.U != null && getBaseActivity() != null && !getBaseActivity().isFinishing()) {
                this.U.removeMessages(401);
                this.U.sendEmptyMessageDelayed(401, i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void Ge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        this.K.setVisibility(0);
        this.E.setVisibility(8);
        com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB60", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void Yg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (!isDetached() && getBaseActivity() != null) {
            Ih();
            QQToast.makeText(getBaseActivity(), getString(R.string.hnh), 0).show();
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void a9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (!isDetached() && getBaseActivity() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactFragment", 2, "onExitFace2FaceAddContact()");
            }
            Jh(false, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void deleteFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delFriendUin:" + str);
        }
        if (!isDetached() && getBaseActivity() != null && !TextUtils.isEmpty(str)) {
            int i3 = 0;
            while (true) {
                if (i3 < this.D.u().size()) {
                    if (str.equals(this.D.u().get(i3).f181080a)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (QLog.isDebugVersion()) {
                QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delIndex:" + i3);
            }
            if (i3 != -1) {
                this.D.u().remove(i3);
                this.D.notifyItemRemoved(i3);
                Ph(this.D.u().size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initData();
        Eh();
        this.C.k(getBaseActivity());
        zh();
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (!isDetached() && getBaseActivity() != null) {
            Ih();
            QQToast.makeText(getBaseActivity(), getString(R.string.f170916w01), 0).show();
            com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB64", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f167947ap2;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void ig(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "startFace2FaceAddContactHeartBeat delayTimeMs:" + i3);
        }
        if (this.U != null && getBaseActivity() != null && !getBaseActivity().isFinishing()) {
            this.U.sendEmptyMessageDelayed(301, i3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.initWindowStyleAndAnimation(activity);
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected boolean isTransparent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void je() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            Bh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult resultCode:" + i16 + " requestCode:" + i3);
        }
        if (i3 != 1001) {
            if (i3 == 1002 && getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                Hh();
                return;
            }
            return;
        }
        if (intent != null && i16 == -1) {
            String stringExtra = intent.getStringExtra("ticket");
            if (!TextUtils.isEmpty(this.Q) && this.Q.length() == 4) {
                this.C.v(getBaseActivity(), this.Q.toString(), stringExtra);
            }
            if (QLog.isDebugVersion()) {
                QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult VERIFY_REQUEST_CODE, verifySig:" + stringExtra);
            }
            com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB66", "", "", "");
            return;
        }
        if (i16 == 0) {
            Ih();
            QQToast.makeText(getBaseActivity(), getString(R.string.f170918w03), 0).show();
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Face2FaceAddContactPresenter face2FaceAddContactPresenter = this.C;
        if (face2FaceAddContactPresenter != null) {
            face2FaceAddContactPresenter.w();
        }
        com.tencent.mobileqq.activity.contact.addcontact.face2face.a aVar = this.D;
        if (aVar != null) {
            com.tencent.mobileqq.activity.contact.addcontact.face2face.c.a(this.R, aVar.u());
        }
        Dh();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnRightText) {
                onBackEvent();
            } else if (id5 == R.id.b88) {
                Ch();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        Face2FaceAddContactPresenter face2FaceAddContactPresenter = this.C;
        if (face2FaceAddContactPresenter != null) {
            face2FaceAddContactPresenter.r();
        }
        com.tencent.mobileqq.activity.contact.addcontact.face2face.a aVar = this.D;
        if (aVar != null) {
            aVar.onDestroy();
        }
        Handler handler = this.U;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Dh();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onFinish();
        if (getBaseActivity() != null) {
            getBaseActivity().overridePendingTransition(0, R.anim.f154423k);
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
        if (getBaseActivity() != null && this.S) {
            this.S = false;
            Ih();
            QQToast.makeText(getBaseActivity(), getString(R.string.f170915w00), 0).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            super.onStart();
            Nh();
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void onTimeout() {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else if (!isDetached() && getBaseActivity() != null && (handler = this.U) != null) {
            handler.sendEmptyMessage(5);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void rc() {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (!isDetached() && getBaseActivity() != null && (handler = this.U) != null) {
            handler.sendEmptyMessage(6);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.e
    public void w5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!isDetached() && getBaseActivity() != null) {
            Ih();
            QQToast.makeText(getBaseActivity(), getString(R.string.i3h), 0).show();
            String str = this.Q;
            if (str != null) {
                com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB5F", "", "", str);
            }
        }
    }

    public void zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (!com.tencent.mobileqq.activity.contact.addcontact.face2face.c.c(getBaseActivity().app)) {
            return;
        }
        com.tencent.mobileqq.activity.contact.addcontact.face2face.c.d(getBaseActivity().app);
        ReportDialog reportDialog = new ReportDialog(getBaseActivity(), R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167561xg);
        Button button = (Button) reportDialog.findViewById(R.id.lfp);
        Button button2 = (Button) reportDialog.findViewById(R.id.bij);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = getResources().getDrawable(R.drawable.l0e);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mRequestHeight = BaseAIOUtils.f(170.0f, getResources());
        reportDialog.findViewById(R.id.lfq).setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200114/bd76e3d896aa49cd91e73aa332b1ff22.png", obtain));
        button.setOnClickListener(new d(reportDialog));
        button2.setOnClickListener(new e(reportDialog));
        reportDialog.show();
    }
}
