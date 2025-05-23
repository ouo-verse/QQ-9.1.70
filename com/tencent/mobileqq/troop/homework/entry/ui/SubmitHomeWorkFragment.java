package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import kotlinx.coroutines.DebugKt;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SubmitHomeWorkFragment extends QIphoneTitleBarFragment implements InputMethodGuard.a, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    protected static String f297001g0;
    protected View C;
    protected InputMethodGuard D;
    protected View E;
    protected XMediaEditor F;
    protected XMediaEditor G;
    protected ViewGroup H;
    protected View I;
    protected ActionSheet J;
    protected CommonRecordSoundPanel K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected String P;
    protected String Q;
    protected com.tencent.mobileqq.troop.homework.a R;
    protected LinkedList<JSONObject> S;
    protected long T;
    protected String U;
    protected AppInterface V;
    protected HomeworkHandler W;
    protected com.tencent.mobileqq.troop.homework.observer.a X;
    protected j Y;
    protected QQProgressDialog Z;

    /* renamed from: a0, reason: collision with root package name */
    protected int f297002a0;

    /* renamed from: b0, reason: collision with root package name */
    protected long f297003b0;

    /* renamed from: c0, reason: collision with root package name */
    protected long f297004c0;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f297005d0;

    /* renamed from: e0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.homework.a f297006e0;

    /* renamed from: f0, reason: collision with root package name */
    protected BroadcastReceiver f297007f0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (SubmitHomeWorkFragment.this.K != null) {
                String action = intent.getAction();
                if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SubmitHomeWorkFragment", 2, "receive action_recv_video_request");
                    }
                    SubmitHomeWorkFragment.this.K.n(102);
                } else if ("android.intent.action.PHONE_STATE".equals(action)) {
                    if (SystemMethodProxy.getCallState((TelephonyManager) SubmitHomeWorkFragment.this.getActivity().getSystemService("phone")) == 1 && QLog.isColorLevel()) {
                        QLog.d("SubmitHomeWorkFragment", 2, "receive action_phone_state_changed|call_state_ringing");
                    }
                    SubmitHomeWorkFragment.this.K.n(102);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends com.tencent.mobileqq.troop.homework.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        public void c(boolean z16, com.tencent.mobileqq.troop.homework.a aVar) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
                return;
            }
            super.c(z16, aVar);
            SubmitHomeWorkFragment.this.dismissDialog();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u83b7\u53d6\u4f5c\u4e1a\u4fe1\u606f");
                if (z16) {
                    str2 = "\u6210\u529f";
                } else {
                    str2 = "\u5931\u8d25";
                }
                sb5.append(str2);
                QLog.d("SubmitHomeWorkFragment", 2, sb5.toString());
            }
            if (z16 && aVar != null && (str = aVar.f296263d) != null) {
                SubmitHomeWorkFragment.this.R = aVar;
                try {
                    SubmitHomeWorkFragment.this.Hh(new JSONObject().put("c", new JSONObject(str).getJSONArray("c")).toString());
                    return;
                } catch (Exception unused) {
                    SubmitHomeWorkFragment.this.Bh(3, null, null, null);
                    return;
                }
            }
            SubmitHomeWorkFragment.this.Bh(3, null, null, null);
            SubmitHomeWorkFragment submitHomeWorkFragment = SubmitHomeWorkFragment.this;
            submitHomeWorkFragment.R = null;
            submitHomeWorkFragment.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        public void e(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            super.e(z16, i3);
            SubmitHomeWorkFragment.this.dismissDialog();
            if (z16) {
                SubmitHomeWorkFragment.this.Ch();
                return;
            }
            if (i3 == 1002) {
                SubmitHomeWorkFragment.this.Bh(2, null, null, null);
            } else if (i3 == 10022) {
                SubmitHomeWorkFragment.this.Bh(1, null, null, null);
            } else {
                SubmitHomeWorkFragment.this.Bh(3, null, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                InputMethodUtil.hide(view);
                SubmitHomeWorkFragment.this.getQBaseActivity().doOnBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                InputMethodUtil.hide(view);
                SubmitHomeWorkFragment.this.Ah();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.homework.a f297011d;

        e(com.tencent.mobileqq.troop.homework.a aVar) {
            this.f297011d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this, (Object) aVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                SubmitHomeWorkFragment submitHomeWorkFragment = SubmitHomeWorkFragment.this;
                if (submitHomeWorkFragment.T > 0) {
                    submitHomeWorkFragment.Mh(this.f297011d);
                } else {
                    submitHomeWorkFragment.Bh(3, null, null, this.f297011d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements ActionSheet.WatchDismissActions {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SubmitHomeWorkFragment.this.K.onBackEvent();
                SubmitHomeWorkFragment.this.Nh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f297014d;

        g(ActionSheet actionSheet) {
            this.f297014d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this, (Object) actionSheet);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f297014d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1) {
                SubmitHomeWorkFragment.super.onBackEvent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class i implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class j extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<SubmitHomeWorkFragment> f297018a;

        j(SubmitHomeWorkFragment submitHomeWorkFragment, Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) submitHomeWorkFragment, (Object) looper);
            } else {
                this.f297018a = new WeakReference<>(submitHomeWorkFragment);
            }
        }

        void a(SubmitHomeWorkFragment submitHomeWorkFragment) {
            LinkedList<JSONObject> linkedList = submitHomeWorkFragment.S;
            if (linkedList != null && submitHomeWorkFragment.F != null) {
                if (linkedList.isEmpty()) {
                    submitHomeWorkFragment.F.setVisibility(8);
                    submitHomeWorkFragment.G.G();
                    submitHomeWorkFragment.G.setHint(submitHomeWorkFragment.getActivity().getString(R.string.eok));
                    submitHomeWorkFragment.G.getAdapter().notifyDataSetChanged();
                    return;
                }
                if (!submitHomeWorkFragment.M) {
                    submitHomeWorkFragment.F.l();
                    Iterator<JSONObject> it = submitHomeWorkFragment.S.iterator();
                    while (it.hasNext()) {
                        JSONObject next = it.next();
                        if (QLog.isColorLevel()) {
                            QLog.d("SubmitHomeWorkFragment", 2, "insert special item: " + next.optString("type"));
                        }
                        submitHomeWorkFragment.F.C(com.tencent.mobileqq.troop.homework.xmediaeditor.model.c.a(next, submitHomeWorkFragment.U));
                    }
                    submitHomeWorkFragment.M = true;
                    if (submitHomeWorkFragment.Q == null) {
                        submitHomeWorkFragment.Q = submitHomeWorkFragment.F.q();
                    }
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            SubmitHomeWorkFragment submitHomeWorkFragment = this.f297018a.get();
            if (submitHomeWorkFragment != null && submitHomeWorkFragment.isAdded()) {
                int i3 = message.what;
                if (i3 != 3) {
                    if (i3 != 513) {
                        if (i3 != 101) {
                            if (i3 == 102) {
                                int i16 = (int) submitHomeWorkFragment.K.i();
                                if (i16 < 1000) {
                                    QQToast.makeText(submitHomeWorkFragment.getActivity(), HardCodeUtil.qqStr(R.string.twx), 0).show();
                                    submitHomeWorkFragment.K.reset();
                                    return;
                                }
                                if (!NetworkUtil.isNetSupport(submitHomeWorkFragment.getActivity())) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SubmitHomeWorkFragment", 2, "no network toast");
                                    }
                                    QQToast.makeText(submitHomeWorkFragment.getActivity(), R.string.f171375ei3, 0).show();
                                    submitHomeWorkFragment.L = false;
                                    submitHomeWorkFragment.uh();
                                    return;
                                }
                                String obj = message.obj.toString();
                                File file = new File(obj);
                                if (file.exists()) {
                                    j3 = file.length();
                                } else {
                                    j3 = 0;
                                }
                                submitHomeWorkFragment.G.C(new com.tencent.mobileqq.troop.homework.xmediaeditor.model.a(obj, null, i16 / 1000, (int) j3, submitHomeWorkFragment.U));
                                submitHomeWorkFragment.L = false;
                                submitHomeWorkFragment.uh();
                                return;
                            }
                            return;
                        }
                        submitHomeWorkFragment.L = false;
                        submitHomeWorkFragment.uh();
                        return;
                    }
                    a(submitHomeWorkFragment);
                    return;
                }
                submitHomeWorkFragment.L = true;
                submitHomeWorkFragment.J.setOutsideDismissEnableCompat(false);
            }
        }
    }

    public SubmitHomeWorkFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = null;
        this.K = null;
        this.L = false;
        this.M = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.T = 0L;
        this.U = "";
        this.Z = null;
        this.f297002a0 = 0;
        this.f297003b0 = 0L;
        this.f297004c0 = 0L;
        this.f297005d0 = false;
        this.f297006e0 = null;
        this.f297007f0 = new a();
    }

    public static void Kh(Activity activity) {
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(activity);
    }

    protected void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(getActivity())) {
            QQToast.makeText(getActivity(), 0, R.string.f171137ci2, 0).show();
            return;
        }
        String[] strArr = new String[1];
        String str = this.U;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        eu.g("Grp_edu", "homework", "CompleteHw_Sub", 0, 0, strArr);
        com.tencent.mobileqq.troop.homework.a aVar = new com.tencent.mobileqq.troop.homework.a();
        aVar.f296270k = this.T;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<Boolean> wh5 = wh(jSONArray, jSONArray2);
        wh5.get(1).booleanValue();
        boolean booleanValue = wh5.get(2).booleanValue();
        if (wh5.get(3).booleanValue()) {
            this.F.t();
            if (!TextUtils.isEmpty("")) {
                QQToast.makeText(getActivity(), getActivity().getString(R.string.eoh, ""), 0).show();
                return;
            }
        } else if (!booleanValue) {
            QQToast.makeText(getActivity(), R.string.eog, 0).show();
            return;
        }
        JSONArray jSONArray3 = new JSONArray();
        int length = jSONArray2.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
            if (optJSONObject != null) {
                jSONArray3.mo162put(optJSONObject);
            }
        }
        int length2 = jSONArray.length();
        for (int i16 = 0; i16 < length2; i16++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i16);
            if (optJSONObject2 != null) {
                jSONArray3.mo162put(optJSONObject2);
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("c", jSONArray3);
            if (QLog.isColorLevel()) {
                QLog.d("SubmitHomeWorkFragment", 2, jSONObject.toString());
            }
            try {
                if (TextUtils.isEmpty(this.U)) {
                    aVar.f296260a = 0L;
                } else {
                    aVar.f296260a = Long.valueOf(this.U).longValue();
                }
                aVar.f296263d = jSONObject.toString();
            } catch (Exception unused) {
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
            e eVar = new e(aVar);
            createCustomDialog.setMessage(R.string.eof);
            createCustomDialog.setPositiveButton(R.string.eny, eVar);
            createCustomDialog.setNegativeButton(R.string.ens, eVar);
            createCustomDialog.show();
        } catch (JSONException unused2) {
            Bh(3, null, null, null);
        }
    }

    protected void Bh(int i3, ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList, ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList2, com.tencent.mobileqq.troop.homework.a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), arrayList, arrayList2, aVar);
            return;
        }
        if (i3 == 0) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.addAll(th(it.next()));
            }
            Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                arrayList3.addAll(th(it5.next()));
            }
            ArrayList arrayList4 = new ArrayList(new TreeSet(arrayList3));
            if (arrayList4.isEmpty()) {
                str = "";
            } else if (arrayList4.size() == 1) {
                str = (String) arrayList4.get(0);
            } else {
                str = ((String) arrayList4.get(0)) + "\u3001" + ((String) arrayList4.get(1)) + HardCodeUtil.qqStr(R.string.twr);
            }
            int i16 = this.f297002a0;
            if (i16 == 0) {
                this.f297002a0 = i16 + 1;
                if (this.G != null && !arrayList.isEmpty()) {
                    this.G.F(arrayList);
                }
                if (this.F != null && !arrayList2.isEmpty()) {
                    this.F.F(arrayList2);
                }
                QQToast.makeText(getActivity(), getString(R.string.eou, str), 0).show();
            } else {
                QQToast.makeText(getActivity(), getString(R.string.eos, str), 0).show();
            }
        } else if (i3 == 1) {
            QQToast.makeText(getActivity(), R.string.enz, 0).show();
        } else if (i3 == 3) {
            QQToast.makeText(getActivity(), R.string.eoo, 0).show();
        } else if (i3 == 2) {
            QQToast.makeText(getActivity(), R.string.ci_, 0).show();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "Error, reason_code = " + i3 + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
        }
    }

    protected void Ch() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        String[] strArr = new String[3];
        String str2 = this.U;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        strArr[0] = str2;
        strArr[1] = "";
        com.tencent.mobileqq.troop.homework.a aVar = this.f297006e0;
        if (aVar != null && (str = aVar.f296263d) != null) {
            str3 = str;
        }
        strArr[2] = str3;
        eu.g("Grp_edu", "homework", "CompleteHw_Success", 0, 0, strArr);
        qh(1, "CompleteHw_Pic", true);
        qh(2, "CompleteHw_Video", true);
        qh(3, "CompleteHw_Voice", true);
        Intent intent = new Intent();
        intent.putExtra("SubmitHomeWorkFragment:js_callback", "{\"submit\":\"true\", \"hw_id\":" + this.f297003b0 + "}");
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    protected void Dh(@NonNull ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(th(it.next()));
        }
        ArrayList arrayList3 = new ArrayList(new TreeSet(arrayList2));
        if (arrayList3.isEmpty()) {
            str = "";
        } else if (arrayList3.size() == 1) {
            str = (String) arrayList3.get(0);
        } else {
            str = ((String) arrayList3.get(0)) + "\u3001" + ((String) arrayList3.get(1)) + HardCodeUtil.qqStr(R.string.f172744tx0);
        }
        QQToast.makeText(getActivity(), getString(R.string.eou, str), 0).show();
    }

    protected void Eh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "onVideoBtnClick");
        }
        if (this.G.u(1) + this.G.u(2) >= 10) {
            if (System.currentTimeMillis() - this.f297004c0 >= 2000) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.f172747tx3) + 10 + HardCodeUtil.qqStr(R.string.twu), 0).show();
                this.f297004c0 = System.currentTimeMillis();
                return;
            }
            return;
        }
        f297001g0 = TroopHWJsPlugin.D(getActivity(), 260);
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "onVideoBtnClick", String.format("mCameraPath=%s", f297001g0));
        }
        InputMethodUtil.hide(getActivity());
    }

    protected void Fh() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        String[] strArr = new String[1];
        String str = this.U;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        eu.g("Grp_edu", "homework", "Subhw_hwDetail", 0, 0, strArr);
        ActionSheet create = ActionSheet.create(getActivity());
        ViewGroup viewGroup = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.f168599aj0, (ViewGroup) null);
        XMediaEditor xMediaEditor = (XMediaEditor) viewGroup.findViewById(R.id.d9v);
        xMediaEditor.setMaxHeight(((ScreenUtil.SCREEN_HIGHT - this.f211174vg.getHeight()) - ViewUtils.getStatusBarHeight(getActivity())) - ScreenUtil.dip2px(122.0f));
        xMediaEditor.setShowType(1);
        TextView textView = (TextView) viewGroup.findViewById(R.id.d76);
        View findViewById = viewGroup.findViewById(R.id.d75);
        com.tencent.mobileqq.troop.homework.a aVar = this.R;
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.f296262c)) {
                textView.setText(this.R.f296262c);
            }
            if (!TextUtils.isEmpty(this.R.f296266g) && (num = com.tencent.mobileqq.troop.homework.entry.ui.a.f297032n.get(this.R.f296266g)) != null) {
                findViewById.setBackgroundResource(num.intValue());
            }
        }
        View findViewById2 = viewGroup.findViewById(R.id.f165704d74);
        Oh(findViewById2);
        findViewById2.setOnClickListener(new g(create));
        if (!TextUtils.isEmpty(this.P)) {
            xMediaEditor.setData(this.P, this.U);
        }
        create.addView(viewGroup);
        InputMethodUtil.hide(getActivity());
        create.setAnimationTime(300);
        create.show();
    }

    protected void Gh() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("extra.GROUP_UIN");
            String[] strArr = new String[1];
            if (string == null) {
                str = "";
            } else {
                str = string;
            }
            strArr[0] = str;
            eu.g("Grp_edu", "homework", "CompleteHw_Show", 0, 0, strArr);
            if (!TextUtils.isEmpty(string)) {
                this.U = string;
                long j3 = arguments.getLong("HomeWorkConstants:homework_id_default_request_key");
                this.T = j3;
                if (j3 > 0) {
                    showProgressDialog(R.string.enh);
                    this.W.F2(this.T);
                    return;
                } else {
                    QQToast.makeText(getActivity(), R.string.eoq, 0).show();
                    getActivity().finish();
                    return;
                }
            }
            QQToast.makeText(getActivity(), R.string.eoq, 0).show();
            getActivity().finish();
            return;
        }
        QQToast.makeText(getActivity(), R.string.eoq, 0).show();
        getActivity().finish();
    }

    protected void Hh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("c")) {
                JSONArray jSONArray = jSONObject.getJSONArray("c");
                if (jSONArray != null) {
                    this.P = jSONArray.toString();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2 != null) {
                            String string = jSONObject2.getString("type");
                            if (!TextUtils.isEmpty(string)) {
                                if (Arrays.asList(com.tencent.mobileqq.troop.homework.entry.ui.a.f297021c).contains(string)) {
                                    this.S.add(jSONObject2);
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("SubmitHomeWorkFragment", 2, "home work must contains type key");
                            }
                        }
                    }
                }
                Jh();
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("home work json format error");
            if (QLog.isColorLevel()) {
                QLog.e("SubmitHomeWorkFragment", 2, illegalArgumentException, new Object[0]);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SubmitHomeWorkFragment", 2, "parse homework json error", e16);
            }
        }
    }

    protected void Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        setLeftButton(R.string.eoe, new c());
        setRightButton(R.string.eom, new d());
        setTitle(getResources().getString(R.string.eon));
        this.F.setShowType(2);
        this.F.setExtraValue("troopuin", this.U);
        this.F.setScrollable(false);
        this.G.setShowType(0);
        this.G.setMinimumHeight((int) (ScreenUtil.SCREEN_HIGHT * 0.4d));
        this.G.setSizeLimit(500);
        this.G.setExtraValue("troopuin", this.U);
        this.G.setHint(getActivity().getString(R.string.eoj));
    }

    protected void Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 513;
        this.Y.sendMessage(obtain);
    }

    protected void Lh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else if (z16) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }

    protected void Mh(com.tencent.mobileqq.troop.homework.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> z16 = this.G.z();
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> z17 = this.F.z();
        if (z16 == null) {
            z16 = new ArrayList<>();
        }
        if (z17 == null) {
            z17 = new ArrayList<>();
        }
        if (z16.isEmpty() && z17.isEmpty()) {
            if (this.W != null && aVar != null) {
                showProgressDialog(R.string.enq);
                this.f297006e0 = aVar;
                long j3 = aVar.f296270k;
                this.f297003b0 = j3;
                this.W.L2(j3, aVar.f296260a, aVar.f296263d);
                return;
            }
            Bh(3, null, null, aVar);
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList2 = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList3 = new ArrayList<>();
        Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it = z16.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.g next = it.next();
            if (next != null) {
                if (next.f() == 1) {
                    arrayList3.add(next);
                } else if (next.f() == 2 || next.f() == 0) {
                    arrayList.add(next);
                }
            }
        }
        Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it5 = z17.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.g next2 = it5.next();
            if (next2 != null) {
                if (next2.f() == 1) {
                    arrayList3.add(next2);
                } else if (next2.f() == 2 || next2.f() == 0) {
                    arrayList2.add(next2);
                }
            }
        }
        if (!arrayList3.isEmpty()) {
            Dh(arrayList3);
        } else if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            Bh(3, null, null, aVar);
        } else {
            Bh(0, arrayList, arrayList2, aVar);
        }
    }

    protected void Nh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.Y.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SubmitHomeWorkFragment submitHomeWorkFragment = SubmitHomeWorkFragment.this;
                    EditText rh5 = submitHomeWorkFragment.rh(submitHomeWorkFragment.C);
                    if (QLog.isColorLevel()) {
                        QLog.d("SubmitHomeWorkFragment", 2, "\u5f39\u8d77\u952e\u76d8");
                    }
                    if (rh5 != null) {
                        InputMethodUtil.show(rh5);
                    }
                }
            }, 400L);
        }
    }

    protected void Oh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) view);
        } else if (view != null) {
            view.setOnTouchListener(new i());
        }
    }

    protected void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.J == null) {
            this.J = ActionSheet.create(getActivity());
            CommonRecordSoundPanel commonRecordSoundPanel = (CommonRecordSoundPanel) getActivity().getLayoutInflater().inflate(R.layout.a18, (ViewGroup) null);
            this.K = commonRecordSoundPanel;
            commonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.K));
            this.K.setBackgroundColor(-1);
            this.K.k(this.V, getQBaseActivity(), this.Y, 0);
            this.K.setTimeOutTime(360000);
            this.K.setMinimumHeight((int) (ScreenUtil.SCREEN_HIGHT * 0.3f));
            this.K.setPermissionBusinessParams(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK_RECORD_AUDIO);
            this.J.addView(this.K);
            this.J.setAnimationTime(50);
            this.J.registerWatchDisMissActionListener(new f());
        }
        this.K.reset();
        this.J.setOutsideDismissEnableCompat(true);
        InputMethodUtil.hide(getActivity());
        this.J.show();
    }

    @Override // com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a
    public void Xb(boolean z16, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("detect input method state changed, current state is ");
            if (z16) {
                str = "on";
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            sb5.append(str);
            QLog.d("SubmitHomeWorkFragment", 2, sb5.toString());
        }
        Lh(z16);
    }

    protected void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.Z;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.Z.dismiss();
            } catch (Exception unused) {
            }
        }
        this.Z = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        getActivity().getWindow().setSoftInputMode(16);
        vh();
        sh();
        Gh();
        Ih();
        if (MobileQQ.sProcessId != 9) {
            Kh(getActivity());
        }
    }

    protected <T extends View> T findViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (T) iPatchRedirector.redirect((short) 39, (Object) this, i3);
        }
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.aio;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "onActivityResult. requestCode=", Integer.valueOf(i3), ", resultCode=", Integer.valueOf(i16));
        }
        if (i3 != 258) {
            if (i3 == 260 && i16 == -1) {
                if (!NetworkUtil.isNetSupport(getActivity())) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SubmitHomeWorkFragment", 2, "no network toast from capture");
                    }
                    QQToast.makeText(getActivity(), R.string.f171375ei3, 0).show();
                    return;
                } else {
                    if (!TextUtils.isEmpty(f297001g0)) {
                        try {
                            BaseImageUtil.savePhotoToSysAlbum(getActivity(), f297001g0);
                        } catch (Exception e16) {
                            QLog.d("SubmitHomeWorkFragment", 1, "onActivityResult save exception", e16);
                        }
                        this.G.C(new ImageInfo(f297001g0, this.U));
                        return;
                    }
                    QQToast.makeText(getActivity(), R.string.cwi, 0).show();
                    QLog.d("SubmitHomeWorkFragment", 1, "onActivityResult path=%s", f297001g0);
                    return;
                }
            }
            return;
        }
        if (intent != null && i16 == 257) {
            int intExtra = intent.getIntExtra("HomeWorkConstants:homework_default_index_key", Integer.MIN_VALUE);
            String stringExtra = intent.getStringExtra("HomeWorkConstants:homework_default_result_key");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (intExtra != Integer.MIN_VALUE) {
                    this.F.E(intExtra, stringExtra);
                    if (QLog.isColorLevel()) {
                        QLog.d("SubmitHomeWorkFragment", 2, "merging: " + this.F.q());
                    }
                    this.F.invalidate();
                } else if (QLog.isColorLevel()) {
                    QLog.d("SubmitHomeWorkFragment", 2, "no index found");
                }
            }
            if (!TextUtils.isEmpty(stringExtra) && QLog.isColorLevel()) {
                QLog.d("SubmitHomeWorkFragment", 2, "\u63d0\u4ea4\u65b0\u4f5c\u4e1a->" + stringExtra);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "Return from entry");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        if (wh(new JSONArray(), new JSONArray()).get(0).booleanValue()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
            h hVar = new h();
            createCustomDialog.setMessage(R.string.eoi);
            createCustomDialog.setPositiveButton(R.string.enx, hVar);
            createCustomDialog.setNegativeButton(R.string.ens, hVar);
            createCustomDialog.show();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.g57) {
                yh(view);
            } else if (id5 == R.id.g5d) {
                Eh(view);
            } else if (id5 == R.id.g5e) {
                zh(view);
            } else if (id5 == R.id.f0_) {
                Fh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.tencent.mobileqq.troop.homework.observer.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        super.onDestroyView();
        AppInterface appInterface = this.V;
        if (appInterface != null && (aVar = this.X) != null) {
            appInterface.removeObserver(aVar);
        }
        com.tencent.mobileqq.troop.homework.utils.b.a();
        if (this.f297005d0) {
            getActivity().unregisterReceiver(this.f297007f0);
            this.f297005d0 = false;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            super.onDetach();
            this.Y.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.onFinish();
            getActivity().overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else if (intent != null && intent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0) == 259) {
            this.N = new ImageItem(this.G).x(this.G, intent, this.N, this.U);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.onPause();
        }
    }

    protected void qh(int i3, String str, boolean z16) {
        XMediaEditor xMediaEditor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            xMediaEditor = this.G;
        } else {
            xMediaEditor = this.F;
        }
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> v3 = xMediaEditor.v(i3);
        JSONArray jSONArray = new JSONArray();
        Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> it = v3.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.b next = it.next();
            if (next != null) {
                jSONArray.mo162put(next.a());
            }
        }
        if (!v3.isEmpty()) {
            String[] strArr = new String[4];
            String str2 = this.U;
            if (str2 == null) {
                str2 = "";
            }
            strArr[0] = str2;
            strArr[1] = "";
            strArr[2] = String.valueOf(v3.size());
            strArr[3] = jSONArray.toString();
            eu.g("Grp_edu", "homework", str, 0, 0, strArr);
        }
    }

    protected EditText rh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (EditText) iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
        }
        EditText editText = null;
        if (view == null) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                EditText rh5 = rh(viewGroup.getChildAt(i3));
                if (rh5 != null) {
                    editText = rh5;
                }
            }
            return editText;
        }
        if (!(view instanceof EditText) || !view.isFocused()) {
            return null;
        }
        return (EditText) view;
    }

    protected void sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (((QIphoneTitleBarFragment) this).mContentView == null) {
            return;
        }
        this.C = findViewById(R.id.j6s);
        this.E = findViewById(R.id.adi);
        InputMethodGuard inputMethodGuard = (InputMethodGuard) findViewById(R.id.dmx);
        this.D = inputMethodGuard;
        inputMethodGuard.setOnInputMethodChangeListener(this);
        this.G = (XMediaEditor) findViewById(R.id.d9p);
        ViewGroup viewGroup = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.ain, (ViewGroup) null, false);
        this.H = viewGroup;
        this.G.setHeaderView(viewGroup);
        XMediaEditor xMediaEditor = (XMediaEditor) this.H.findViewById(R.id.d9w);
        this.F = xMediaEditor;
        xMediaEditor.setLeftRightPadding(x.c(getActivity(), 12.0f));
        this.G.setLeftRightPadding(x.c(getActivity(), 12.0f));
        View findViewById = findViewById(R.id.f09);
        this.I = findViewById;
        Oh(findViewById.findViewById(R.id.f0_));
        this.I.findViewById(R.id.f0_).setOnClickListener(this);
        View findViewById2 = findViewById(R.id.g57);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        View findViewById3 = findViewById(R.id.g5d);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
        View findViewById4 = findViewById(R.id.g5e);
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this);
        }
    }

    protected void showProgressDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        try {
            if (!getActivity().isFinishing()) {
                if (this.Z == null) {
                    QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
                    this.Z = qQProgressDialog;
                    qQProgressDialog.setCancelable(false);
                    this.Z.show();
                }
                this.Z.setMessage(i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @NonNull
    protected List<String> th(com.tencent.mobileqq.troop.homework.xmediaeditor.model.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) gVar);
        }
        ArrayList arrayList = new ArrayList();
        if (gVar != null) {
            if (gVar instanceof VideoInfo) {
                arrayList.add(HardCodeUtil.qqStr(R.string.f172746tx2) + "");
            } else if (gVar instanceof ImageInfo) {
                arrayList.add(HardCodeUtil.qqStr(R.string.twv) + "");
            } else if (gVar instanceof com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) {
                arrayList.add(HardCodeUtil.qqStr(R.string.twp) + "");
            }
        }
        return arrayList;
    }

    protected void uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.J.dismiss();
        }
    }

    protected void vh() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.U = "";
        this.Y = new j(this, Looper.getMainLooper());
        this.S = new LinkedList<>();
        if (getActivity() == null) {
            appInterface = null;
        } else {
            appInterface = (AppInterface) getQBaseActivity().getAppRuntime();
        }
        this.V = appInterface;
        if (appInterface == null) {
            getActivity().finish();
            return;
        }
        this.W = (HomeworkHandler) appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName());
        b bVar = new b();
        this.X = bVar;
        this.V.addObserver(bVar);
        if (!this.f297005d0) {
            this.f297005d0 = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            getActivity().registerReceiver(this.f297007f0, intentFilter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    List<Boolean> wh(@NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        ArrayList arrayList = new ArrayList(3);
        boolean z26 = false;
        try {
            JSONArray jSONArray3 = new JSONArray(this.G.q());
            JSONArray jSONArray4 = new JSONArray(this.F.q());
            int length = jSONArray3.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray3.optJSONObject(i3);
                if (xh(optJSONObject)) {
                    jSONArray.mo162put(optJSONObject);
                }
            }
            int length2 = jSONArray4.length();
            for (int i16 = 0; i16 < length2; i16++) {
                JSONObject optJSONObject2 = jSONArray4.optJSONObject(i16);
                if (xh(optJSONObject2)) {
                    jSONArray2.mo162put(optJSONObject2);
                }
            }
            if (!this.S.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            try {
                z19 = !this.S.isEmpty() ? !this.F.q().equals(this.Q) : false;
                z17 = z19;
                try {
                    if (jSONArray.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                } catch (Exception e16) {
                    e = e16;
                    z18 = false;
                }
            } catch (Exception e17) {
                e = e17;
                z17 = false;
                z18 = z17;
                if (QLog.isColorLevel()) {
                    QLog.e("SubmitHomeWorkFragment", 2, "check isHomeWorkModify error", e);
                }
                z19 = z26;
                arrayList.add(Boolean.valueOf(z19));
                arrayList.add(Boolean.valueOf(z17));
                arrayList.add(Boolean.valueOf(z18));
                arrayList.add(Boolean.valueOf(z16));
                return arrayList;
            }
        } catch (Exception e18) {
            e = e18;
            z16 = false;
            z17 = false;
        }
        if (!z19) {
            try {
                if (jSONArray.length() > 0) {
                    z26 = true;
                }
            } catch (Exception e19) {
                e = e19;
                z26 = z19;
                if (QLog.isColorLevel()) {
                }
                z19 = z26;
                arrayList.add(Boolean.valueOf(z19));
                arrayList.add(Boolean.valueOf(z17));
                arrayList.add(Boolean.valueOf(z18));
                arrayList.add(Boolean.valueOf(z16));
                return arrayList;
            }
            z19 = z26;
        }
        arrayList.add(Boolean.valueOf(z19));
        arrayList.add(Boolean.valueOf(z17));
        arrayList.add(Boolean.valueOf(z18));
        arrayList.add(Boolean.valueOf(z16));
        return arrayList;
    }

    protected boolean xh(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSONObject)).booleanValue();
        }
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        if ("str".equals(optString) && TextUtils.isEmpty(jSONObject.optString("text"))) {
            return false;
        }
        return true;
    }

    protected void yh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "onPictureBtnClick");
        }
        int u16 = this.G.u(1) + this.G.u(2);
        if (u16 >= 10) {
            if (System.currentTimeMillis() - this.f297004c0 >= 2000) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.f172745tx1) + 10 + HardCodeUtil.qqStr(R.string.twz), 0).show();
                this.f297004c0 = System.currentTimeMillis();
                return;
            }
            return;
        }
        Intent selectMediaIntent = TroopHWJsPlugin.getSelectMediaIntent(10 - u16, getActivity(), this.V.getCurrentAccountUin());
        selectMediaIntent.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivity(selectMediaIntent);
        InputMethodUtil.hide(getActivity());
    }

    protected void zh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "onRecordBtnClick");
        }
        if (this.G.u(3) >= 6) {
            if (System.currentTimeMillis() - this.f297004c0 >= 2000) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.tww) + 6 + HardCodeUtil.qqStr(R.string.twq), 0).show();
                this.f297004c0 = System.currentTimeMillis();
                return;
            }
            return;
        }
        InputMethodUtil.hide(view);
        Ph();
    }
}
