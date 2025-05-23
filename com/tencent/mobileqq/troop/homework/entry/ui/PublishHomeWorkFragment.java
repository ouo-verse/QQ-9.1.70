package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseFragment;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.CourseInfo;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.TroopHwCourseMgrRsp;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.b;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.d;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.handler.HomeworkCourseHandler;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.homework.logic.WenKuEntranceHelper;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class PublishHomeWorkFragment extends QIphoneTitleBarFragment implements InputMethodGuard.a, View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected String A0;
    protected String B0;
    protected long C;
    protected boolean C0;
    protected int D;
    protected boolean D0;
    protected InputMethodGuard E;
    protected boolean E0;
    protected ViewGroup F;
    protected long F0;
    protected ViewGroup G;
    protected SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> G0;
    protected TextView H;
    private long H0;
    protected TroopHwCourseMgrRsp I;
    protected BroadcastReceiver I0;
    protected CourseInfo J;
    protected EditText K;
    protected XMediaEditor L;
    protected View M;
    protected View N;
    protected ViewGroup P;
    protected ViewGroup Q;
    protected ViewGroup R;
    protected ViewGroup S;
    protected QFormSimpleItem T;
    protected QFormSimpleItem U;
    protected FormSwitchItem V;
    protected boolean W;
    protected boolean X;
    protected boolean Y;
    protected List<Pair<Integer, View>> Z;

    /* renamed from: a0, reason: collision with root package name */
    protected ActionSheet f296956a0;

    /* renamed from: b0, reason: collision with root package name */
    protected CommonRecordSoundPanel f296957b0;

    /* renamed from: c0, reason: collision with root package name */
    protected View f296958c0;

    /* renamed from: d0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.homework.entry.ui.utils.b f296959d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f296960e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f296961f0;

    /* renamed from: g0, reason: collision with root package name */
    protected boolean f296962g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ArrayList<String> f296963h0;

    /* renamed from: i0, reason: collision with root package name */
    protected List<String> f296964i0;

    /* renamed from: j0, reason: collision with root package name */
    protected boolean f296965j0;

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f296966k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f296967l0;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f296968m0;

    /* renamed from: n0, reason: collision with root package name */
    protected AppInterface f296969n0;

    /* renamed from: o0, reason: collision with root package name */
    protected HomeworkHandler f296970o0;

    /* renamed from: p0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.homework.observer.a f296971p0;

    /* renamed from: q0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.homework.a f296972q0;

    /* renamed from: r0, reason: collision with root package name */
    protected q f296973r0;

    /* renamed from: s0, reason: collision with root package name */
    protected QQProgressDialog f296974s0;

    /* renamed from: t0, reason: collision with root package name */
    protected int f296975t0;

    /* renamed from: u0, reason: collision with root package name */
    protected long f296976u0;

    /* renamed from: v0, reason: collision with root package name */
    protected boolean f296977v0;

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f296978w0;

    /* renamed from: x0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.homework.a f296979x0;

    /* renamed from: y0, reason: collision with root package name */
    protected String f296980y0;

    /* renamed from: z0, reason: collision with root package name */
    protected boolean f296981z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements b.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.b.c
        public void a(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            long f16 = com.tencent.mobileqq.troop.homework.entry.ui.utils.a.f(PublishHomeWorkFragment.this.f296959d0, i3, i16, i17) / 1000;
            if (!PublishHomeWorkFragment.this.yh(f16)) {
                com.tencent.mobileqq.troop.homework.entry.ui.utils.b bVar = PublishHomeWorkFragment.this.f296959d0;
                com.tencent.mobileqq.troop.homework.entry.ui.utils.a.g(bVar, (com.tencent.mobileqq.troop.homework.entry.ui.utils.a) bVar.n());
                return;
            }
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            publishHomeWorkFragment.F0 = f16;
            publishHomeWorkFragment.f296959d0.m();
            PublishHomeWorkFragment publishHomeWorkFragment2 = PublishHomeWorkFragment.this;
            publishHomeWorkFragment2.U.setRightText(publishHomeWorkFragment2.Ph(f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements b.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.b.d
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements ActionSheet.WatchDismissActions {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                PublishHomeWorkFragment.this.f296957b0.onBackEvent();
                PublishHomeWorkFragment.this.Bi();
            }
        }
    }

    /* loaded from: classes19.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1) {
                PublishHomeWorkFragment.super.onBackEvent();
            }
        }
    }

    /* loaded from: classes19.dex */
    class e extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (PublishHomeWorkFragment.this.f296957b0 != null) {
                String action = intent.getAction();
                if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                    QLog.d("PublishHomeWorkFragment", 1, "receive action_recv_video_request");
                    PublishHomeWorkFragment.this.f296957b0.n(102);
                } else if ("android.intent.action.PHONE_STATE".equals(action)) {
                    if (SystemMethodProxy.getCallState((TelephonyManager) PublishHomeWorkFragment.this.getActivity().getSystemService("phone")) == 1) {
                        QLog.d("PublishHomeWorkFragment", 1, "receive action_phone_state_changed|call_state_ringing");
                    }
                    PublishHomeWorkFragment.this.f296957b0.n(102);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class f implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.homework.a f296987a;

        f(com.tencent.mobileqq.troop.homework.a aVar) {
            this.f296987a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onFailed(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.e(BaseApplication.getContext());
            long elapsedRealtime = SystemClock.elapsedRealtime() - PublishHomeWorkFragment.this.H0;
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            com.tencent.mobileqq.troop.homework.utils.a.a(-1, str, elapsedRealtime, publishHomeWorkFragment.D, publishHomeWorkFragment.f296969n0.getCurrentUin(), PublishHomeWorkFragment.this.f296961f0);
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onSuccess(List<d.b> list) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            if (list != null && !list.isEmpty()) {
                str = list.get(0).a();
            } else {
                str = null;
            }
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            publishHomeWorkFragment.Gh(this.f296987a, publishHomeWorkFragment.Nh(str, 10), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class g implements e.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, jSONObject, Integer.valueOf(i3), bundle);
                return;
            }
            PublishHomeWorkFragment.this.dismissDialog();
            if (jSONObject != null && jSONObject.has("retcode")) {
                int optInt = jSONObject.optInt("retcode");
                if (optInt == 0) {
                    QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), R.string.f180523ba, 0).show();
                    Intent m3 = BaseAIOUtils.m(new Intent(), new int[]{2});
                    m3.addFlags(268435456);
                    m3.putExtra("uin", PublishHomeWorkFragment.this.f296961f0);
                    m3.putExtra("uintype", 1);
                    RouteUtils.startActivity(PublishHomeWorkFragment.this.getActivity(), m3, RouterConstants.UI_ROUTER_SPLASH);
                    PublishHomeWorkFragment.this.getActivity().overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
                    long elapsedRealtime = SystemClock.elapsedRealtime() - PublishHomeWorkFragment.this.H0;
                    PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
                    com.tencent.mobileqq.troop.homework.utils.a.a(optInt, "\u4fee\u6539\u4f5c\u4e1a\u53d1\u5e03\u6210\u529f", elapsedRealtime, publishHomeWorkFragment.D, publishHomeWorkFragment.f296969n0.getCurrentUin(), PublishHomeWorkFragment.this.f296961f0);
                    return;
                }
                if (optInt == 111000) {
                    QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), R.string.f180513b_, 0).show();
                } else {
                    QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), R.string.f180633bl, 0).show();
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - PublishHomeWorkFragment.this.H0;
                PublishHomeWorkFragment publishHomeWorkFragment2 = PublishHomeWorkFragment.this;
                com.tencent.mobileqq.troop.homework.utils.a.a(optInt, "\u4fee\u6539\u4f5c\u4e1a\u53d1\u5e03\u5931\u8d25", elapsedRealtime2, publishHomeWorkFragment2.D, publishHomeWorkFragment2.f296969n0.getCurrentUin(), PublishHomeWorkFragment.this.f296961f0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class h extends com.tencent.mobileqq.troop.homework.observer.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        public void a(boolean z16, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            super.a(z16, j3, i3);
            PublishHomeWorkFragment.this.dismissDialog();
            PublishHomeWorkFragment.this.Th(z16, i3);
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        public void c(boolean z16, com.tencent.mobileqq.troop.homework.a aVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
                return;
            }
            super.c(z16, aVar);
            PublishHomeWorkFragment.this.dismissDialog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u83b7\u53d6\u4f5c\u4e1a\u4fe1\u606f");
            if (z16) {
                str = "\u6210\u529f";
            } else {
                str = "\u5931\u8d25";
            }
            sb5.append(str);
            QLog.d("PublishHomeWorkFragment", 1, sb5.toString());
            if (z16 && aVar != null && aVar.f296263d != null) {
                PublishHomeWorkFragment.this.Rh(aVar);
            } else {
                PublishHomeWorkFragment.this.getActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        public void d(boolean z16, String str, String str2, int i3, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), str3, str4);
                return;
            }
            super.d(z16, str, str2, i3, str3, str4);
            QLog.d("PublishHomeWorkFragment", 1, "onGetHomeworkTroopIdentity: isSuccess:" + z16 + ", identity:" + i3 + ", course:" + str3);
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            if (!publishHomeWorkFragment.f296978w0) {
                publishHomeWorkFragment.Uh(i3, str3, str4);
                if (z16) {
                    PublishHomeWorkFragment publishHomeWorkFragment2 = PublishHomeWorkFragment.this;
                    publishHomeWorkFragment2.f296960e0 = str3;
                    publishHomeWorkFragment2.Sh();
                } else {
                    QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), HardCodeUtil.qqStr(R.string.f172338po0), 0).show();
                }
                QLog.i("PublishHomeWorkFragment", 1, "init data success");
                PublishHomeWorkFragment.this.vi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class i implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.homework.a f296990a;

        i(com.tencent.mobileqq.troop.homework.a aVar) {
            this.f296990a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onFailed(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.e(BaseApplication.getContext());
            long elapsedRealtime = SystemClock.elapsedRealtime() - PublishHomeWorkFragment.this.H0;
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            com.tencent.mobileqq.troop.homework.utils.a.a(-1, str, elapsedRealtime, publishHomeWorkFragment.D, publishHomeWorkFragment.f296969n0.getCurrentUin(), PublishHomeWorkFragment.this.f296961f0);
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onSuccess(List<d.b> list) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            if (list != null && !list.isEmpty()) {
                str = list.get(0).a();
            } else {
                str = null;
            }
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            publishHomeWorkFragment.Hh(this.f296990a, publishHomeWorkFragment.Nh(str, 10), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class j implements e.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, jSONObject, Integer.valueOf(i3), bundle);
                return;
            }
            PublishHomeWorkFragment.this.dismissDialog();
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("retcode")) {
                        int optInt = jSONObject.optInt("retcode");
                        if (optInt == 0) {
                            PublishHomeWorkFragment.this.ni();
                            long elapsedRealtime = SystemClock.elapsedRealtime() - PublishHomeWorkFragment.this.H0;
                            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
                            com.tencent.mobileqq.troop.homework.utils.a.a(optInt, "\u65b0\u5efa\u4f5c\u4e1a\u53d1\u5e03\u6210\u529f", elapsedRealtime, publishHomeWorkFragment.D, publishHomeWorkFragment.f296969n0.getCurrentUin(), PublishHomeWorkFragment.this.f296961f0);
                            return;
                        }
                        if (!jSONObject.has("wording")) {
                            str = "";
                        } else {
                            str = jSONObject.optString("wording", "");
                        }
                        if (!TextUtils.isEmpty(str)) {
                            QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), str, 0).show();
                        } else if (optInt == 111000) {
                            QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), R.string.f180513b_, 0).show();
                        } else {
                            QQToast.makeText(PublishHomeWorkFragment.this.getActivity(), R.string.f180633bl, 0).show();
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - PublishHomeWorkFragment.this.H0;
                        PublishHomeWorkFragment publishHomeWorkFragment2 = PublishHomeWorkFragment.this;
                        com.tencent.mobileqq.troop.homework.utils.a.a(optInt, str, elapsedRealtime2, publishHomeWorkFragment2.D, publishHomeWorkFragment2.f296969n0.getCurrentUin(), PublishHomeWorkFragment.this.f296961f0);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class k implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                PublishHomeWorkFragment.this.ji(compoundButton, z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class l implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            if (baseAction == BaseAction.ACTION_LEFT_TEXT) {
                InputMethodUtil.hide(view);
                PublishHomeWorkFragment.this.getQBaseActivity().doOnBackPressed();
                return null;
            }
            if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
                InputMethodUtil.hide(view);
                try {
                    PublishHomeWorkFragment.this.li();
                    return null;
                } catch (JSONException e16) {
                    QLog.e("PublishHomeWorkFragment", 1, "on publish homework error, parse json error", e16);
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class m implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
                return;
            }
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            publishHomeWorkFragment.W = !z16;
            if (z16) {
                publishHomeWorkFragment.C0 = true;
                publishHomeWorkFragment.yi(publishHomeWorkFragment.E.i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class n implements XMediaEditor.d {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.d
        public void onFocusChanged(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            } else if (z16) {
                PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
                publishHomeWorkFragment.yi(publishHomeWorkFragment.E.i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class o extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f296997a;

        o(int i3) {
            this.f296997a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                PublishHomeWorkFragment.this.Hi(this.f296997a);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class p extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
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
            PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
            publishHomeWorkFragment.f296967l0 = TroopHWJsPlugin.D(publishHomeWorkFragment.getActivity(), 260);
            InputMethodUtil.hide(PublishHomeWorkFragment.this.getActivity());
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public static class q extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<PublishHomeWorkFragment> f297000a;

        q(PublishHomeWorkFragment publishHomeWorkFragment, Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) publishHomeWorkFragment, (Object) looper);
            } else {
                this.f297000a = new WeakReference<>(publishHomeWorkFragment);
            }
        }

        void a() {
            PublishHomeWorkFragment publishHomeWorkFragment = this.f297000a.get();
            if (publishHomeWorkFragment != null) {
                if (publishHomeWorkFragment.isAdded() || publishHomeWorkFragment.K != null) {
                    if (publishHomeWorkFragment.f296960e0 == null) {
                        publishHomeWorkFragment.f296960e0 = "";
                    }
                    if (publishHomeWorkFragment.D == 1) {
                        Calendar calendar = Calendar.getInstance();
                        int i3 = calendar.get(2) + 1;
                        int i16 = calendar.get(5);
                        String trim = publishHomeWorkFragment.getString(R.string.enj, Integer.valueOf(i3), Integer.valueOf(i16), publishHomeWorkFragment.f296960e0).trim();
                        String trim2 = publishHomeWorkFragment.getString(R.string.enj, Integer.valueOf(i3), Integer.valueOf(i16), "").trim();
                        String obj = publishHomeWorkFragment.K.getText().toString();
                        if (TextUtils.isEmpty(obj) || trim2.equals(obj)) {
                            publishHomeWorkFragment.K.setText(trim);
                        }
                        publishHomeWorkFragment.Ei();
                        publishHomeWorkFragment.Fi();
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
            QLog.d("PublishHomeWorkFragment", 1, "handle msg " + message.what);
            PublishHomeWorkFragment publishHomeWorkFragment = this.f297000a.get();
            if (publishHomeWorkFragment != null && publishHomeWorkFragment.isAdded()) {
                int i3 = message.what;
                if (i3 != 3) {
                    if (i3 != 16711687) {
                        if (i3 != 101) {
                            if (i3 != 102) {
                                switch (i3) {
                                    case 513:
                                        a();
                                        return;
                                    case 514:
                                        publishHomeWorkFragment.Fi();
                                        return;
                                    case 515:
                                        QLog.d("PublishHomeWorkFragment", 1, "init data time out");
                                        publishHomeWorkFragment.f296978w0 = true;
                                        a();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            int i16 = (int) publishHomeWorkFragment.f296957b0.i();
                            if (i16 < 1000) {
                                QQToast.makeText(publishHomeWorkFragment.getActivity(), HardCodeUtil.qqStr(R.string.po7), 0).show();
                                publishHomeWorkFragment.f296957b0.reset();
                                return;
                            }
                            if (!NetworkUtil.isNetSupport(publishHomeWorkFragment.getActivity())) {
                                QLog.d("PublishHomeWorkFragment", 1, "no network toast");
                                QQToast.makeText(publishHomeWorkFragment.getActivity(), R.string.f171375ei3, 0).show();
                                publishHomeWorkFragment.f296966k0 = false;
                                publishHomeWorkFragment.Xh();
                                return;
                            }
                            String obj = message.obj.toString();
                            File file = new File(obj);
                            if (file.exists()) {
                                j3 = file.length();
                            } else {
                                j3 = 0;
                            }
                            publishHomeWorkFragment.L.C(new com.tencent.mobileqq.troop.homework.xmediaeditor.model.a(obj, null, i16 / 1000, (int) j3, publishHomeWorkFragment.f296961f0));
                            publishHomeWorkFragment.f296966k0 = false;
                            publishHomeWorkFragment.Xh();
                            return;
                        }
                        publishHomeWorkFragment.f296966k0 = false;
                        publishHomeWorkFragment.Xh();
                        return;
                    }
                    QQToast.makeText(publishHomeWorkFragment.getActivity(), 1, R.string.f213725qz, 0).show();
                    return;
                }
                publishHomeWorkFragment.f296966k0 = true;
                publishHomeWorkFragment.f296956a0.setOutsideDismissEnableCompat(false);
                return;
            }
            QLog.d("PublishHomeWorkFragment", 1, "reference null");
        }
    }

    public PublishHomeWorkFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = 0L;
        this.D = 1;
        this.W = true;
        this.X = false;
        this.Y = false;
        this.Z = new LinkedList();
        this.f296956a0 = null;
        this.f296957b0 = null;
        this.f296958c0 = null;
        this.f296960e0 = "";
        this.f296961f0 = "";
        this.f296962g0 = false;
        this.f296965j0 = false;
        this.f296966k0 = false;
        this.f296972q0 = null;
        this.f296973r0 = null;
        this.f296974s0 = null;
        this.f296975t0 = 0;
        this.f296976u0 = 0L;
        this.f296977v0 = false;
        this.f296978w0 = false;
        this.f296979x0 = null;
        this.f296980y0 = null;
        this.f296981z0 = false;
        this.A0 = null;
        this.B0 = null;
        this.C0 = false;
        this.D0 = false;
        this.E0 = false;
        this.F0 = 0L;
        this.G0 = new SparseArrayCompat<>();
        this.H0 = 0L;
        this.I0 = new e();
    }

    private void Ah(int i3, int i16, Intent intent) {
        for (int i17 = 0; i17 < this.G0.size(); i17++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i17)).onActivityResult(i3, i16, intent);
        }
    }

    private void Ai(int i3, com.tencent.mobileqq.troop.homework.logic.a aVar) {
        this.G0.put(i3, aVar);
    }

    private void Bh(int i3) {
        for (int i16 = 0; i16 < this.G0.size(); i16++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i16)).g(i3);
        }
    }

    private void Ch(JSONObject jSONObject) {
        for (int i3 = 0; i3 < this.G0.size(); i3++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i3)).d(jSONObject);
        }
    }

    private void Dh() {
        for (int i3 = 0; i3 < this.G0.size(); i3++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i3)).a();
        }
    }

    private void Eh(boolean z16) {
        for (int i3 = 0; i3 < this.G0.size(); i3++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i3)).e(z16);
        }
    }

    private void Fh(JSONArray jSONArray) {
        for (int i3 = 0; i3 < this.G0.size(); i3++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i3)).b(jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(com.tencent.mobileqq.troop.homework.a aVar, String str, String str2) {
        String str3;
        Bundle bundle = new Bundle();
        bundle.putString("homework_id", Long.toString(aVar.f296270k));
        bundle.putString("group_id", this.f296961f0);
        if (this.J != null) {
            bundle.putString("course_id", this.J.getCourseId() + "");
            bundle.putString(Element.ELEMENT_NAME_COURSE_NAME, this.J.getCourseName());
        }
        bundle.putString("title", aVar.f296262c);
        if (aVar.f296265f) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        bundle.putString("need_feedback", str3);
        bundle.putString("c", aVar.f296263d);
        String currentUin = this.f296969n0.getCurrentUin();
        HashMap<String, Object> hashMap = new HashMap<>();
        bundle.putString("bkn", "" + ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getBknBySkey(str));
        bundle.putString("Cookie", "uin=o" + currentUin + ";skey=" + str + ";p_uin=o" + currentUin + ";p_skey=" + str2);
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", this.f296969n0.getApp().getApplicationContext());
        new com.tencent.mobileqq.troop.utils.f("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new g(), 1000, null).b(hashMap);
    }

    public static void Gi(Activity activity, @Nullable Bundle bundle, @Nullable String str) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("hide_title_left_arrow", true);
        bundle.putString("PublishHomeWorkFragment:valid", "PublishHomeWorkFragment:valid");
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("extra.GROUP_UIN", str);
        }
        intent.putExtras(bundle);
        QPublicFragmentActivity.start(activity, intent, PublishHomeWorkFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(com.tencent.mobileqq.troop.homework.a aVar, String str, String str2) {
        String str3;
        Bundle bundle = new Bundle();
        bundle.putString("group_id", this.f296961f0);
        if (this.J != null) {
            bundle.putString("course_id", this.J.getCourseId() + "");
            bundle.putString(Element.ELEMENT_NAME_COURSE_NAME, this.J.getCourseName());
        }
        bundle.putString("title", aVar.f296262c);
        bundle.putString("send_gray_top_banner", "0");
        if (!aVar.f296265f) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        bundle.putString("need_feedback", str3);
        bundle.putString("c", aVar.f296263d);
        bundle.putString("team_id", "0");
        bundle.putString("hw_type", "0");
        bundle.putString("tsfeedback", String.valueOf(this.F0));
        List<Long> list = aVar.f296269j;
        if (list != null && list.size() > 0) {
            String str4 = "[";
            int i3 = 0;
            while (i3 < aVar.f296269j.size() - 1) {
                str4 = str4 + String.valueOf(aVar.f296269j.get(i3)) + ",";
                i3++;
            }
            bundle.putString("syncgids", str4 + String.valueOf(aVar.f296269j.get(i3)) + "]");
        }
        String currentUin = this.f296969n0.getCurrentUin();
        HashMap<String, Object> hashMap = new HashMap<>();
        bundle.putString("bkn", "" + ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getBknBySkey(str));
        bundle.putString("Cookie", "uin=o" + currentUin + ";skey=" + str + ";p_uin=o" + currentUin + ";p_skey=" + str2);
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", this.f296969n0.getApp().getApplicationContext());
        new com.tencent.mobileqq.troop.utils.f("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new j(), 1000, null).b(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi(int i3) {
        Intent selectMediaIntent;
        if (((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
            selectMediaIntent = new com.tencent.mobileqq.troop.homework.album.a().e(10 - i3, getContext(), false);
        } else {
            selectMediaIntent = TroopHWJsPlugin.getSelectMediaIntent(10 - i3, getActivity(), this.f296969n0.getCurrentAccountUin());
            selectMediaIntent.putExtra("HomeWorkConstants:homework_request_code_key", 259);
            selectMediaIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        }
        startActivityForResult(selectMediaIntent, 259);
        InputMethodUtil.hide(getActivity());
    }

    private void Ii() {
        if (this.J != null && getContext() != null) {
            this.G.setVisibility(0);
            this.G.setBackground(com.tencent.mobileqq.troop.homework.coursemgr.ui.a.f296927a.a(this.J.getCourseName()));
            this.H.setText(this.J.getCourseName().substring(0, 1));
            Calendar calendar = Calendar.getInstance();
            this.K.setText(getString(R.string.enj, Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), this.J.getCourseName()));
        }
    }

    private void Kh() {
        HomeworkCourseHandler.f297080a.e(this.f296961f0, new Function2() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit ei5;
                ei5 = PublishHomeWorkFragment.this.ei((Boolean) obj, (TroopHwCourseMgrRsp) obj2);
                return ei5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Nh(String str, int i3) {
        if (i3 > 0 && !TextUtils.isEmpty(str) && str.length() >= i3) {
            return str.substring(0, i3);
        }
        return "";
    }

    private boolean Vh(QQPermission qQPermission) {
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            return true;
        }
        return false;
    }

    private boolean Wh(QQPermission qQPermission) {
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    private void Zh() {
        com.tencent.mobileqq.troop.homework.entry.ui.utils.b a16 = com.tencent.mobileqq.troop.homework.entry.ui.utils.a.a(getActivity());
        this.f296959d0 = a16;
        a16.o(new a());
        this.f296959d0.p(new b());
    }

    private void ai() {
        Ai(3, new WenKuEntranceHelper(this, this.f296961f0));
        Ai(2, new com.tencent.mobileqq.troop.homework.logic.e(this, this.f296961f0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit ei(Boolean bool, TroopHwCourseMgrRsp troopHwCourseMgrRsp) {
        this.I = troopHwCourseMgrRsp;
        QLog.i("PublishHomeWorkFragment", 1, "getHomeworkCourseList, mTeacherType:" + this.f296960e0);
        if (this.D == 1) {
            this.J = troopHwCourseMgrRsp.getDefaultSelectCourseInfo(this.f296960e0);
            Ii();
            return null;
        }
        return null;
    }

    private void gi(com.tencent.mobileqq.troop.homework.a aVar) {
        com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.c(this.f296969n0, new String[]{FlockBaseRequest.QUN_DOMAIN}, new f(aVar));
    }

    private void hi() {
        TroopHwCourseFragment.INSTANCE.a(getQBaseActivity(), 272, this.f296961f0, this.I, this.J);
        this.L.B();
    }

    private void xi(com.tencent.mobileqq.troop.homework.a aVar) {
        com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.c(this.f296969n0, new String[]{FlockBaseRequest.QUN_DOMAIN}, new i(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yh(long j3) {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + 1;
        if (this.f296959d0 == null) {
            return false;
        }
        if (j3 < currentTimeMillis) {
            QQToast.makeText(getActivity(), R.string.f180603bi, 0).show();
            return false;
        }
        return true;
    }

    protected void Bi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            this.f296973r0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PublishHomeWorkFragment publishHomeWorkFragment = PublishHomeWorkFragment.this;
                    EditText Ih = publishHomeWorkFragment.Ih(publishHomeWorkFragment.M);
                    QLog.d("PublishHomeWorkFragment", 1, "\u5f39\u8d77\u952e\u76d8");
                    if (Ih != null) {
                        InputMethodUtil.show(Ih);
                    }
                }
            }, 400L);
        }
    }

    public void Ci(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        boolean c16 = this.G0.get(i3).c();
        if (c16 && i3 == 1) {
            if (this.f296959d0 != null) {
                this.U.setVisibility(0);
                if (this.D == 1) {
                    if (this.F0 == 0) {
                        long c17 = com.tencent.mobileqq.troop.homework.entry.ui.utils.a.c();
                        this.F0 = c17;
                        this.U.setRightText(Ph(c17));
                    }
                    this.U.setClickable(true);
                } else {
                    long j3 = this.f296972q0.f296268i;
                    if (j3 != 0) {
                        this.U.setRightText(Ph(j3));
                    }
                    this.U.setClickable(false);
                }
            }
        } else {
            this.F0 = 0L;
            this.U.setRightText("");
            this.U.setVisibility(8);
        }
        for (int i16 = 0; i16 < this.G0.size(); i16++) {
            SparseArrayCompat<com.tencent.mobileqq.troop.homework.logic.a> sparseArrayCompat = this.G0;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i16)).f(i3, c16);
        }
    }

    protected void Di() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        if (this.f296956a0 == null) {
            this.f296956a0 = ActionSheet.create(getActivity());
            CommonRecordSoundPanel commonRecordSoundPanel = (CommonRecordSoundPanel) getActivity().getLayoutInflater().inflate(R.layout.a18, (ViewGroup) null);
            this.f296957b0 = commonRecordSoundPanel;
            commonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.f296957b0));
            this.f296957b0.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.qui_common_bg_bottom_light_bg));
            this.f296957b0.k(this.f296969n0, getQBaseActivity(), this.f296973r0, 0);
            this.f296957b0.setTimeOutTime(360000);
            this.f296957b0.setMinimumHeight((int) (ScreenUtil.SCREEN_HIGHT * 0.3f));
            this.f296957b0.setPermissionBusinessParams(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK_RECORD_AUDIO);
            TextView textView = (TextView) this.f296957b0.findViewById(R.id.fy8);
            TextView textView2 = (TextView) this.f296957b0.findViewById(R.id.j1o);
            TextView textView3 = (TextView) this.f296957b0.findViewById(R.id.i46);
            textView.setTextColor(getActivity().getColor(R.color.qui_common_text_secondary));
            textView2.setTextColor(getActivity().getColor(R.color.qui_common_text_secondary));
            textView3.setTextColor(getActivity().getColor(R.color.qui_common_text_secondary));
            this.f296956a0.addView(this.f296957b0);
            this.f296956a0.setAnimationTime(50);
            this.f296956a0.getActionContentView().setGravity(17);
            this.f296956a0.registerWatchDisMissActionListener(new c());
        }
        this.f296957b0.reset();
        this.f296956a0.setOutsideDismissEnableCompat(true);
        InputMethodUtil.hide(getActivity());
        this.f296956a0.show();
    }

    protected void Ei() {
        List<Pair<Integer, View>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (!this.Y && (list = this.Z) != null && !list.isEmpty()) {
            Iterator<Pair<Integer, View>> it = this.Z.iterator();
            while (it.hasNext()) {
                xh(it.next());
            }
            this.Y = true;
        }
    }

    protected void Fi() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (!this.Z.isEmpty()) {
            Iterator<Pair<Integer, View>> it = this.Z.iterator();
            while (it.hasNext()) {
                z16 = true;
                if (it.next().first.intValue() == 1) {
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            yi(this.E.i());
            if (this.P.getVisibility() == 8 || this.P.getHeight() <= 0) {
                Message obtain = Message.obtain();
                obtain.what = 514;
                this.f296973r0.sendMessageDelayed(obtain, 100L);
            }
            this.P.setVisibility(0);
            return;
        }
        this.P.setVisibility(8);
    }

    protected EditText Ih(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (EditText) iPatchRedirector.redirect((short) 45, (Object) this, (Object) view);
        }
        EditText editText = null;
        if (view == null) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                EditText Ih = Ih(viewGroup.getChildAt(i3));
                if (Ih != null) {
                    editText = Ih;
                }
            }
            return editText;
        }
        if (!(view instanceof EditText) || !view.isFocused()) {
            return null;
        }
        return (EditText) view;
    }

    protected void Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (((QIphoneTitleBarFragment) this).mContentView == null) {
            return;
        }
        this.M = findViewById(R.id.g5_);
        this.f296958c0 = findViewById(R.id.jyp);
        this.E = (InputMethodGuard) findViewById(R.id.dmx);
        ViewGroup viewGroup = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.ail, (ViewGroup) null, false);
        this.F = viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.xc6);
        this.G = viewGroup2;
        viewGroup2.setOnClickListener(this);
        this.H = (TextView) this.F.findViewById(R.id.xc7);
        this.K = (EditText) this.F.findViewById(R.id.g4z);
        XMediaEditor xMediaEditor = (XMediaEditor) findViewById(R.id.g59);
        this.L = xMediaEditor;
        xMediaEditor.setHeaderView(this.F);
        this.N = findViewById(R.id.adi);
        this.P = (ViewGroup) findViewById(R.id.f166900j02);
        this.R = (ViewGroup) findViewById(R.id.f166899j01);
        this.Q = (ViewGroup) findViewById(R.id.f166898j00);
        this.S = (ViewGroup) findViewById(R.id.f164862b60);
        QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) findViewById(R.id.f166558g55);
        this.T = qFormSimpleItem;
        qFormSimpleItem.setOnClickListener(this);
        QFormSimpleItem qFormSimpleItem2 = (QFormSimpleItem) findViewById(R.id.f29200l0);
        this.U = qFormSimpleItem2;
        qFormSimpleItem2.setVisibility(8);
        this.U.setOnClickListener(this);
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById(R.id.g56);
        this.V = formSwitchItem;
        formSwitchItem.setChecked(true);
        this.V.setOnClickListener(this);
        this.f296962g0 = this.V.isChecked();
        this.V.setOnCheckedChangeListener(new k());
        Dh();
        if (this.D == 2) {
            this.T.setVisibility(8);
            this.V.setVisibility(8);
        }
        this.E.setOnInputMethodChangeListener(this);
        View findViewById = findViewById(R.id.g57);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.g5d);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        View findViewById3 = findViewById(R.id.g5e);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
        if (this.f296959d0 == null) {
            try {
                Zh();
                com.tencent.mobileqq.troop.homework.entry.ui.utils.b bVar = this.f296959d0;
                if (bVar != null && (bVar.n() instanceof com.tencent.mobileqq.troop.homework.entry.ui.utils.a)) {
                    com.tencent.mobileqq.troop.homework.entry.ui.utils.b bVar2 = this.f296959d0;
                    com.tencent.mobileqq.troop.homework.entry.ui.utils.a.g(bVar2, (com.tencent.mobileqq.troop.homework.entry.ui.utils.a) bVar2.n());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public XMediaEditor Lh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (XMediaEditor) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.L;
    }

    public int Mh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.D;
    }

    public Bundle Oh() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bundle) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        Bundle bundle = new Bundle();
        String str2 = this.f296980y0;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("reportIdentity", str2);
        if (!this.f296981z0 ? (str = this.B0) != null : (str = this.A0) != null) {
            str3 = str;
        }
        bundle.putString("reportCourse", str3);
        return bundle;
    }

    public String Ph(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this, j3);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String valueOf = String.valueOf(calendar.get(1));
        String valueOf2 = String.valueOf(calendar.get(2) + 1);
        String valueOf3 = String.valueOf(calendar.get(5));
        String.valueOf(calendar.get(7));
        String valueOf4 = String.valueOf(calendar.get(11));
        if (valueOf4 != null && valueOf4.length() == 1) {
            valueOf4 = "0" + valueOf4;
        }
        String valueOf5 = String.valueOf(calendar.get(12));
        if (valueOf5 != null && valueOf5.length() == 1) {
            valueOf5 = "0" + valueOf5;
        }
        return valueOf + HardCodeUtil.qqStr(R.string.f180623bk) + valueOf2 + HardCodeUtil.qqStr(R.string.f180613bj) + valueOf3 + HardCodeUtil.qqStr(R.string.f180593bh) + " " + valueOf4 + ":" + valueOf5;
    }

    @NonNull
    protected List<String> Qh(com.tencent.mobileqq.troop.homework.xmediaeditor.model.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (List) iPatchRedirector.redirect((short) 27, (Object) this, (Object) gVar);
        }
        ArrayList arrayList = new ArrayList();
        if (gVar != null) {
            if (gVar instanceof VideoInfo) {
                arrayList.add(HardCodeUtil.qqStr(R.string.pof) + "");
            } else if (gVar instanceof ImageInfo) {
                arrayList.add(HardCodeUtil.qqStr(R.string.pnz) + "");
            } else if (gVar instanceof com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) {
                arrayList.add(HardCodeUtil.qqStr(R.string.po5) + "");
            }
        }
        return arrayList;
    }

    protected void Rh(com.tencent.mobileqq.troop.homework.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
            return;
        }
        this.f296972q0 = aVar;
        try {
            JSONArray jSONArray = new JSONObject(aVar.f296263d).getJSONArray("c");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    Ch(jSONObject);
                }
            }
            ti(new JSONObject().put("c", jSONArray).toString());
            EditText editText = this.K;
            if (editText != null && editText.getText().toString().isEmpty()) {
                this.K.setText(this.f296972q0.f296262c);
                this.K.setFocusable(false);
                this.K.setFocusableInTouchMode(false);
            }
            String str = aVar.f296266g;
            if (this.H != null && str != null && !str.isEmpty()) {
                this.J = new CourseInfo(aVar.f296267h, str, "");
                this.G.setVisibility(0);
                this.G.setBackground(com.tencent.mobileqq.troop.homework.coursemgr.ui.a.f296927a.a(str));
                this.H.setText(str.substring(0, 1));
            }
        } catch (Exception unused) {
        }
    }

    protected void Sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        String str = this.f296960e0;
        if (str == null) {
            QLog.d("PublishHomeWorkFragment", 1, "[handleGetIdentitySucc] mTeacherType is null");
            QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.f172338po0), 0).show();
            return;
        }
        if (str.isEmpty()) {
            this.f296960e0 = com.tencent.mobileqq.troop.homework.entry.ui.a.f297023e;
        }
        QLog.d("PublishHomeWorkFragment", 1, "\u68c0\u6d4b\u5230\u4f60\u662f" + this.f296960e0 + "\u8001\u5e08\uff0c\u5c06\u6309\u7167\u9700\u6c42\u5b9a\u5236\u5165\u53e3");
        List<Pair<Integer, View>> fi5 = fi(this.f296960e0);
        if (fi5 != null) {
            this.Z.clear();
            this.Z.addAll(fi5);
        }
        Kh();
    }

    protected void Th(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            ni();
            return;
        }
        if (i3 == 10022) {
            mi(1, null, null);
            return;
        }
        if (i3 == 1002) {
            mi(2, null, null);
            return;
        }
        QLog.e("PublishHomeWorkFragment", 1, "UPLOAD_ERROR_UNKNOWN_ERROR: server error " + i3);
        mi(3, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
    
        if (r14 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void Uh(int i3, String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), str, str2);
            return;
        }
        switch (i3) {
            case 332:
                this.f296980y0 = "classteacher";
                this.f296981z0 = true;
                break;
            case 333:
                this.f296980y0 = "teacher";
                this.f296981z0 = true;
                break;
            case 334:
                this.f296980y0 = HippyNestedScrollComponent.PRIORITY_PARENT;
                this.f296981z0 = false;
                break;
            case 335:
                this.f296980y0 = "student";
                this.f296981z0 = false;
                break;
            default:
                this.f296980y0 = "";
                this.f296981z0 = false;
                break;
        }
        this.A0 = str;
        this.B0 = str2;
        String[] strArr = new String[4];
        String str4 = this.f296961f0;
        if (str4 == null) {
            str4 = "";
        }
        strArr[0] = str4;
        strArr[1] = this.f296980y0;
        if (!this.f296981z0) {
            if (str2 != null) {
                str = str2;
            }
            str = "";
        }
        strArr[2] = str;
        if (this.D == 1) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        strArr[3] = str3;
        eu.g("Grp_edu", "homework", "CreateHw_Show", 0, 0, strArr);
    }

    @Override // com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a
    public void Xb(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.X = true;
        this.R.setVisibility(8);
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PublishHomeWorkFragment.this.R.setVisibility(0);
                }
            }
        }, 10L);
        yi(z16);
        View view = this.f296958c0;
        if (z16) {
            i16 = 8;
        }
        view.setVisibility(i16);
        if (com.tencent.mobileqq.troop.homework.entry.ui.a.f297023e.equals(this.f296960e0)) {
            this.f296958c0.setVisibility(8);
        }
    }

    protected void Xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.f296956a0.dismiss();
        }
    }

    protected void Yh() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f296961f0 = "";
        this.f296973r0 = new q(this, Looper.getMainLooper());
        this.f296962g0 = false;
        this.f296963h0 = new ArrayList<>();
        this.f296964i0 = new ArrayList();
        if (getActivity() == null) {
            appInterface = null;
        } else {
            appInterface = (AppInterface) getQBaseActivity().getAppRuntime();
        }
        this.f296969n0 = appInterface;
        if (appInterface == null) {
            getActivity().finish();
            return;
        }
        this.f296970o0 = (HomeworkHandler) appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName());
        h hVar = new h();
        this.f296971p0 = hVar;
        this.f296969n0.addObserver(hVar);
        if (!this.D0) {
            this.D0 = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            getActivity().registerReceiver(this.I0, intentFilter);
        }
    }

    boolean bi() {
        JSONObject jSONObject;
        try {
            JSONArray jSONArray = new JSONArray(this.L.q());
            int length = jSONArray.length();
            if (length > 0) {
                if (length != 1 || (jSONObject = jSONArray.getJSONObject(0)) == null) {
                    return false;
                }
                String string = jSONObject.getString("type");
                if (!TextUtils.isEmpty(string)) {
                    if (!"str".equals(string)) {
                        return false;
                    }
                    if (!TextUtils.isEmpty(jSONObject.getString("text"))) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    protected boolean ci(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) jSONObject)).booleanValue();
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

    protected void di() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else if (!TextUtils.isEmpty(this.f296961f0)) {
            HomeWorkTroopSelectorFragment.uh(getActivity(), this.f296961f0, this.f296963h0);
        }
    }

    protected void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f296974s0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f296974s0.dismiss();
            } catch (Exception unused) {
            }
        }
        this.f296974s0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Yh();
        si();
        ai();
        Jh();
        ui();
        ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).initBossForMediaItem();
        if (MobileQQ.sProcessId != 9) {
            SubmitHomeWorkFragment.Kh(getActivity());
        }
    }

    List<Pair<Integer, View>> fi(String str) {
        return new ArrayList();
    }

    public <T extends View> T findViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (T) iPatchRedirector.redirect((short) 59, (Object) this, i3);
        }
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.aim;
    }

    protected void ii(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) view);
            return;
        }
        QLog.d("PublishHomeWorkFragment", 1, "onClickSelectTime");
        if (this.f296959d0 == null) {
            try {
                Zh();
                com.tencent.mobileqq.troop.homework.entry.ui.utils.b bVar = this.f296959d0;
                if (bVar != null && (bVar.n() instanceof com.tencent.mobileqq.troop.homework.entry.ui.utils.a)) {
                    com.tencent.mobileqq.troop.homework.entry.ui.utils.b bVar2 = this.f296959d0;
                    com.tencent.mobileqq.troop.homework.entry.ui.utils.a.g(bVar2, (com.tencent.mobileqq.troop.homework.entry.ui.utils.a) bVar2.n());
                }
            } catch (Throwable unused) {
                return;
            }
        }
        this.f296959d0.r();
    }

    protected void ji(CompoundButton compoundButton, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, compoundButton, Boolean.valueOf(z16));
        } else {
            this.f296962g0 = z16;
        }
    }

    protected void ki(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) view);
            return;
        }
        QLog.d("PublishHomeWorkFragment", 1, "onPictureBtnClick");
        int u16 = this.L.u(1) + this.L.u(2);
        if (u16 >= 10) {
            if (System.currentTimeMillis() - this.f296976u0 >= 2000) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.pny) + 10 + HardCodeUtil.qqStr(R.string.f172340po2), 0).show();
                this.f296976u0 = System.currentTimeMillis();
                return;
            }
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getQBaseActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
        if (!Wh(qQPermission)) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new o(u16));
        } else {
            Hi(u16);
        }
    }

    protected void li() throws JSONException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        this.H0 = SystemClock.elapsedRealtime();
        JSONArray jSONArray = new JSONArray(this.L.q());
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        String[] strArr = new String[3];
        String str2 = this.f296961f0;
        if (str2 == null) {
            str2 = "";
        }
        strArr[0] = str2;
        strArr[1] = this.f296980y0;
        if (this.D == 1) {
            str = "1";
        } else {
            str = "2";
        }
        strArr[2] = str;
        eu.g("Grp_edu", "homework", "CreateHw_Sub", 0, 0, strArr);
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (ci(optJSONObject)) {
                jSONArray2.mo162put(optJSONObject);
            }
        }
        if (jSONArray2.length() <= 0) {
            QQToast.makeText(getActivity(), R.string.enu, 0).show();
            return;
        }
        if (this.f296963h0.contains(this.f296961f0)) {
            this.f296963h0.remove(this.f296961f0);
        }
        com.tencent.mobileqq.troop.homework.a aVar = new com.tencent.mobileqq.troop.homework.a();
        aVar.f296261b = 0L;
        String obj = this.K.getText().toString();
        aVar.f296262c = obj;
        if (TextUtils.isEmpty(obj.trim())) {
            QQToast.makeText(getActivity(), R.string.env, 0).show();
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(getActivity())) {
            QQToast.makeText(getActivity(), 0, R.string.f171137ci2, 0).show();
            return;
        }
        if (this.J == null) {
            QQToast.makeText(getActivity(), getString(R.string.f23411793), 0).show();
            return;
        }
        try {
            aVar.f296261b = Long.parseLong(this.f296969n0.getCurrentUin());
            if (TextUtils.isEmpty(this.f296961f0)) {
                aVar.f296260a = 0L;
            } else {
                aVar.f296260a = Long.parseLong(this.f296961f0);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.f296963h0.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Long.parseLong(it.next())));
            }
            aVar.f296269j = arrayList;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f296965j0) {
            jSONArray2.mo162put(new JSONObject("{\"type\":\"calculation\"}"));
        }
        Fh(jSONArray2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("c", jSONArray2);
        aVar.f296265f = this.f296962g0;
        aVar.f296263d = jSONObject.toString();
        if (this.D == 2) {
            aVar.f296270k = this.C;
            aVar.f296265f = this.f296972q0.f296265f;
        }
        this.f296979x0 = aVar;
        zi(aVar);
    }

    protected void mi(int i3, ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList, com.tencent.mobileqq.troop.homework.a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), arrayList, aVar);
            return;
        }
        if (i3 == 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(Qh(it.next()));
            }
            ArrayList arrayList3 = new ArrayList(new TreeSet(arrayList2));
            if (arrayList3.isEmpty()) {
                str = "";
            } else if (arrayList3.size() == 1) {
                str = (String) arrayList3.get(0);
            } else {
                str = ((String) arrayList3.get(0)) + "\u3001" + ((String) arrayList3.get(1)) + HardCodeUtil.qqStr(R.string.pnx);
            }
            int i16 = this.f296975t0;
            if (i16 == 0) {
                this.f296975t0 = i16 + 1;
                if (this.L != null && !arrayList.isEmpty()) {
                    this.L.F(arrayList);
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
        QLog.d("PublishHomeWorkFragment", 1, "Error, reason_code = " + i3 + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:10:0x0013, B:14:0x0029, B:17:0x003a, B:20:0x0047, B:22:0x0051, B:25:0x0063, B:26:0x0068, B:28:0x006f, B:30:0x0073, B:33:0x0085, B:34:0x008e, B:36:0x0092, B:38:0x0096, B:40:0x009c, B:43:0x00af, B:45:0x00c6, B:50:0x0035), top: B:9:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ni() {
        String[] strArr;
        String str;
        com.tencent.mobileqq.troop.homework.a aVar;
        String str2;
        String str3;
        com.tencent.mobileqq.troop.homework.a aVar2;
        com.tencent.mobileqq.troop.homework.a aVar3;
        List<Long> list;
        String str4;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        try {
            strArr = new String[4];
            String str6 = this.f296961f0;
            str = "";
            if (str6 == null) {
                str6 = "";
            }
            strArr[0] = str6;
            strArr[1] = this.f296980y0;
            aVar = this.f296979x0;
        } catch (Exception unused) {
        }
        if (aVar != null) {
            str2 = aVar.f296263d;
            if (str2 == null) {
            }
            strArr[2] = str2;
            if (!this.f296962g0) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            strArr[3] = str3;
            eu.g("Grp_edu", "homework", "CreateHw_Complete", 0, 0, strArr);
            if (this.C0) {
                String[] strArr2 = new String[1];
                String str7 = this.f296961f0;
                if (str7 == null) {
                    str7 = "";
                }
                strArr2[0] = str7;
                eu.g("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, strArr2);
            }
            Bh(1);
            aVar2 = this.f296979x0;
            if (aVar2 != null && aVar2.f296265f) {
                String[] strArr3 = new String[2];
                str5 = this.f296961f0;
                if (str5 == null) {
                    str5 = "";
                }
                strArr3[0] = str5;
                strArr3[1] = this.f296980y0;
                eu.g("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, strArr3);
            }
            aVar3 = this.f296979x0;
            if (aVar3 != null && (list = aVar3.f296269j) != null && !list.isEmpty()) {
                String[] strArr4 = new String[3];
                str4 = this.f296961f0;
                if (str4 == null) {
                    str = str4;
                }
                strArr4[0] = str;
                strArr4[1] = this.f296980y0;
                strArr4[2] = String.valueOf(this.f296979x0.f296269j.size());
                eu.g("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, strArr4);
            }
            zh(1, "CreateHw_Pic");
            zh(2, "CreateHw_Video");
            zh(3, "CreateHw_Voice");
            QQToast.makeText(getActivity(), R.string.eo5, 0).show();
            Intent m3 = BaseAIOUtils.m(new Intent(), new int[]{2});
            m3.addFlags(268435456);
            m3.putExtra("uin", this.f296961f0);
            m3.putExtra("uintype", 1);
            RouteUtils.startActivity(getActivity(), m3, RouterConstants.UI_ROUTER_SPLASH);
            getActivity().overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        }
        str2 = "";
        strArr[2] = str2;
        if (!this.f296962g0) {
        }
        strArr[3] = str3;
        eu.g("Grp_edu", "homework", "CreateHw_Complete", 0, 0, strArr);
        if (this.C0) {
        }
        Bh(1);
        aVar2 = this.f296979x0;
        if (aVar2 != null) {
            String[] strArr32 = new String[2];
            str5 = this.f296961f0;
            if (str5 == null) {
            }
            strArr32[0] = str5;
            strArr32[1] = this.f296980y0;
            eu.g("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, strArr32);
        }
        aVar3 = this.f296979x0;
        if (aVar3 != null) {
            String[] strArr42 = new String[3];
            str4 = this.f296961f0;
            if (str4 == null) {
            }
            strArr42[0] = str;
            strArr42[1] = this.f296980y0;
            strArr42[2] = String.valueOf(this.f296979x0.f296269j.size());
            eu.g("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, strArr42);
        }
        zh(1, "CreateHw_Pic");
        zh(2, "CreateHw_Video");
        zh(3, "CreateHw_Voice");
        QQToast.makeText(getActivity(), R.string.eo5, 0).show();
        Intent m36 = BaseAIOUtils.m(new Intent(), new int[]{2});
        m36.addFlags(268435456);
        m36.putExtra("uin", this.f296961f0);
        m36.putExtra("uintype", 1);
        RouteUtils.startActivity(getActivity(), m36, RouterConstants.UI_ROUTER_SPLASH);
        getActivity().overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
    }

    protected void oi(@NonNull ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(Qh(it.next()));
        }
        ArrayList arrayList3 = new ArrayList(new TreeSet(arrayList2));
        if (arrayList3.isEmpty()) {
            str = "";
        } else if (arrayList3.size() == 1) {
            str = (String) arrayList3.get(0);
        } else {
            str = ((String) arrayList3.get(0)) + "\u3001" + ((String) arrayList3.get(1)) + HardCodeUtil.qqStr(R.string.po8);
        }
        QQToast.makeText(getActivity(), getString(R.string.eou, str), 0).show();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        QLog.d("PublishHomeWorkFragment", 1, "onActivityResult. requestCode=", Integer.valueOf(i3), ", resultCode=", Integer.valueOf(i16));
        if (i3 != 263) {
            if (i3 != 272) {
                switch (i3) {
                    case 258:
                        if (intent != null && i16 == 257) {
                            int intExtra = intent.getIntExtra("HomeWorkConstants:homework_default_index_key", Integer.MIN_VALUE);
                            String stringExtra = intent.getStringExtra("HomeWorkConstants:homework_default_result_key");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                if (intExtra != Integer.MIN_VALUE) {
                                    this.L.E(intExtra, stringExtra);
                                    this.L.invalidate();
                                } else {
                                    this.L.C(com.tencent.mobileqq.troop.homework.xmediaeditor.model.c.b(stringExtra, this.f296961f0));
                                    this.L.invalidate();
                                    z16 = true;
                                }
                                qi(stringExtra, z16);
                            }
                            if (!TextUtils.isEmpty(stringExtra)) {
                                QLog.d("PublishHomeWorkFragment", 1, "\u63d0\u4ea4\u65b0\u4f5c\u4e1a->" + stringExtra);
                            }
                        }
                        QLog.d("PublishHomeWorkFragment", 1, "return from entry");
                        break;
                    case 259:
                        this.f296968m0 = new ImageItem(this.L).x(this.L, intent, this.f296968m0, this.f296961f0);
                        break;
                    case 260:
                        if (i16 == -1) {
                            if (!NetworkUtil.isNetSupport(getActivity())) {
                                QLog.d("PublishHomeWorkFragment", 1, "no network toast from capture");
                                QQToast.makeText(getActivity(), R.string.f171375ei3, 0).show();
                                return;
                            } else {
                                BaseImageUtil.savePhotoToSysAlbum(getActivity(), this.f296967l0);
                                this.L.C(new ImageInfo(this.f296967l0, this.f296961f0));
                                break;
                            }
                        }
                        break;
                }
            } else if (i16 == -1 && intent != null) {
                try {
                    TroopHwCourseMgrRsp troopHwCourseMgrRsp = (TroopHwCourseMgrRsp) intent.getSerializableExtra("result_params_key_course_json");
                    CourseInfo courseInfo = (CourseInfo) intent.getSerializableExtra("result_params_key_select_course");
                    if (troopHwCourseMgrRsp != null && courseInfo != null) {
                        this.I = troopHwCourseMgrRsp;
                        this.J = courseInfo;
                        Ii();
                    }
                } catch (Exception e16) {
                    QLog.e("PublishHomeWorkFragment", 1, "[onActivityResult] result from course manage, e = " + e16);
                }
            }
        } else if (intent != null && i16 == 262) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
            if (stringArrayListExtra != null) {
                this.f296963h0.clear();
                this.f296963h0.addAll(stringArrayListExtra);
            }
            if (stringArrayListExtra2 != null) {
                this.f296964i0.clear();
                this.f296964i0.addAll(stringArrayListExtra2);
            }
            if (this.T != null) {
                if (this.f296964i0.isEmpty()) {
                    this.T.setRightText("");
                } else if (this.f296964i0.size() == 1) {
                    this.T.setRightText(this.f296964i0.get(0));
                } else if (this.f296964i0.size() > 1) {
                    if (this.f296964i0.get(0).length() > 6) {
                        str = this.f296964i0.get(0).substring(0, 5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    } else {
                        str = this.f296964i0.get(0);
                    }
                    this.T.setRightText(str + HardCodeUtil.qqStr(R.string.po6) + this.f296964i0.size() + HardCodeUtil.qqStr(R.string.f172339po1));
                }
            }
        }
        Ah(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        if (!bi()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
            d dVar = new d();
            int i3 = this.D;
            if (i3 == 1) {
                createCustomDialog.setMessage(R.string.enw);
            } else if (i3 == 2) {
                createCustomDialog.setMessage(R.string.f180503b9);
            }
            createCustomDialog.setPositiveButton(R.string.enx, dVar);
            createCustomDialog.setNegativeButton(R.string.ens, dVar);
            createCustomDialog.show();
            InputMethodUtil.hide(getActivity());
            return true;
        }
        InputMethodUtil.hide(getActivity());
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.g57) {
                ki(view);
            } else if (id5 == R.id.g5d) {
                ri(view);
            } else if (id5 == R.id.g5e) {
                pi(view);
            } else if (id5 == R.id.f166558g55) {
                di();
            } else if (id5 == R.id.f29200l0) {
                ii(view);
            } else if (id5 == R.id.xc6) {
                hi();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        this.L.getAdapter().notifyDataSetChanged();
        this.L.requestLayout();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        super.onDestroyView();
        com.tencent.mobileqq.troop.homework.observer.a aVar = this.f296971p0;
        if (aVar != null && (appInterface = this.f296969n0) != null) {
            appInterface.removeObserver(aVar);
        }
        com.tencent.mobileqq.troop.homework.utils.b.a();
        if (this.D0) {
            getActivity().unregisterReceiver(this.I0);
            this.D0 = false;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        } else {
            super.onDetach();
            this.f296973r0.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        FragmentActivity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        super.onFinish();
        if (!this.f296977v0 && (activity = getActivity()) != null) {
            activity.overridePendingTransition(0, R.anim.f155032h8);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else if (intent != null && intent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0) == 259) {
            this.f296968m0 = new ImageItem(this.L).x(this.L, intent, this.f296968m0, this.f296961f0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPause();
            InputMethodUtil.hide(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
        }
    }

    protected void pi(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) view);
            return;
        }
        QLog.d("PublishHomeWorkFragment", 1, "onRecordBtnClick");
        if (this.L.u(3) >= 6) {
            if (System.currentTimeMillis() - this.f296976u0 >= 2000) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.pnw) + 6 + HardCodeUtil.qqStr(R.string.f172341po3), 0).show();
                this.f296976u0 = System.currentTimeMillis();
                return;
            }
            return;
        }
        Di();
    }

    protected void qi(String str, boolean z16) {
        FormSwitchItem formSwitchItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, str, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            try {
                if ("recite".equals(new JSONObject(str).getString("type")) && (formSwitchItem = this.V) != null) {
                    formSwitchItem.setChecked(true);
                }
            } catch (Exception e16) {
                QLog.e("PublishHomeWorkFragment", 1, "onSpecialHomeWorkChanged error ", e16);
            }
        }
    }

    protected void ri(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) view);
            return;
        }
        QLog.d("PublishHomeWorkFragment", 1, "onVideoBtnClick");
        if (this.L.u(1) + this.L.u(2) >= 10) {
            if (System.currentTimeMillis() - this.f296976u0 >= 2000) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.pnu) + 10 + HardCodeUtil.qqStr(R.string.poa), 0).show();
                this.f296976u0 = System.currentTimeMillis();
                return;
            }
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getQBaseActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
        if (!Vh(qQPermission)) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new p());
        } else {
            this.f296967l0 = TroopHWJsPlugin.D(getActivity(), 260);
            InputMethodUtil.hide(getActivity());
        }
    }

    protected void showProgressDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, i3);
            return;
        }
        try {
            if (!getActivity().isFinishing()) {
                if (this.f296974s0 == null) {
                    QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
                    this.f296974s0 = qQProgressDialog;
                    qQProgressDialog.setCancelable(false);
                    this.f296974s0.show();
                }
                this.f296974s0.setMessage(i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected void si() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("extra.GROUP_UIN");
            this.D = arguments.getInt("publish_homework_mode", 1);
            this.C = arguments.getLong("hw_id", 0L);
            if (!TextUtils.isEmpty(string)) {
                this.f296961f0 = string;
                QLog.d("PublishHomeWorkFragment", 1, "uin: " + string);
                vi();
                wi(8000L);
                if (this.D == 1) {
                    this.f296970o0.w2(this.f296961f0, this.f296969n0.getCurrentUin());
                }
                if (this.D == 2) {
                    if (this.C > 0) {
                        showProgressDialog(R.string.f180583bg);
                        this.f296970o0.w2(this.f296961f0, this.f296969n0.getCurrentUin());
                        this.f296970o0.F2(this.C);
                        return;
                    } else {
                        QQToast.makeText(getActivity(), R.string.eoq, 0).show();
                        getActivity().finish();
                        return;
                    }
                }
                return;
            }
            QQToast.makeText(getActivity(), R.string.eoq, 0).show();
            getActivity().finish();
            return;
        }
        QQToast.makeText(getActivity(), R.string.eoq, 0).show();
        getActivity().finish();
    }

    protected void ti(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("c")) {
                JSONArray jSONArray = jSONObject.getJSONArray("c");
                if (jSONArray != null) {
                    this.L.setDataByEdit(jSONArray, this.f296961f0);
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.3
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                PublishHomeWorkFragment.this.L.G();
                            }
                        }
                    }, 550L);
                }
            } else {
                QLog.e("PublishHomeWorkFragment", 1, new IllegalArgumentException("home work json format error"), new Object[0]);
            }
        } catch (JSONException e16) {
            QLog.e("PublishHomeWorkFragment", 1, "parse homework json error", e16);
        }
    }

    protected void ui() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.quiSecNavBar.setLeftType(1);
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.enr));
        this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.f171394eo4));
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new l());
        int i3 = this.D;
        if (i3 == 1) {
            setTitle(getResources().getString(R.string.eo6));
        } else if (i3 == 2) {
            setTitle(getResources().getString(R.string.f180533bb));
        }
        this.K.setOnFocusChangeListener(new m());
        this.L.setFocusChangeListener(new n());
        this.L.setSizeLimit(500);
        this.L.setHint(getString(R.string.f171390eo0));
        this.L.setExtraValue("troopuin", this.f296961f0);
        if (this.D == 1) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PublishHomeWorkFragment.this.L.G();
                    }
                }
            }, 550L);
        }
        this.K.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
        vi();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        return true;
    }

    public void vi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 513;
        this.f296973r0.sendMessage(obtain);
    }

    protected void wi(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 515;
        this.f296973r0.sendMessageDelayed(obtain, j3);
    }

    protected void xh(Pair<Integer, View> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) pair);
            return;
        }
        if (this.R != null && pair != null) {
            int intValue = pair.first.intValue();
            if (intValue != 1) {
                if (intValue == 2) {
                    this.Q.addView(pair.second, 0);
                    return;
                }
                return;
            }
            this.R.addView(pair.second);
        }
    }

    protected void yi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
            return;
        }
        if (z16) {
            int i3 = 8;
            this.S.setVisibility(8);
            ((LinearLayout.LayoutParams) this.N.getLayoutParams()).bottomMargin = this.E.h() + ImmersiveUtils.getStatusBarHeight(getContext());
            View view = this.N;
            if (this.W) {
                i3 = 0;
            }
            view.setVisibility(i3);
        } else {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.16
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishHomeWorkFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PublishHomeWorkFragment.this.N.setVisibility(8);
                        PublishHomeWorkFragment.this.S.setVisibility(0);
                    }
                }
            }, 20L);
        }
        Eh(z16);
    }

    protected void zh(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) str);
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> v3 = this.L.v(i3);
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
            String str2 = this.f296961f0;
            if (str2 == null) {
                str2 = "";
            }
            strArr[0] = str2;
            strArr[1] = this.f296980y0;
            strArr[2] = String.valueOf(v3.size());
            strArr[3] = jSONArray.toString();
            eu.g("Grp_edu", "homework", str, 0, 0, strArr);
        }
    }

    protected void zi(com.tencent.mobileqq.troop.homework.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) aVar);
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> z16 = this.L.z();
        if (z16 != null && !z16.isEmpty()) {
            ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList = new ArrayList<>();
            ArrayList<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> arrayList2 = new ArrayList<>();
            Iterator<com.tencent.mobileqq.troop.homework.xmediaeditor.model.g> it = z16.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.troop.homework.xmediaeditor.model.g next = it.next();
                if (next != null) {
                    if (next.f() == 1) {
                        arrayList.add(next);
                    } else if (next.f() == 2 || next.f() == 0) {
                        arrayList2.add(next);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                oi(arrayList);
                return;
            } else if (!arrayList2.isEmpty()) {
                mi(0, arrayList2, aVar);
                return;
            } else {
                QLog.e("PublishHomeWorkFragment", 1, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
                mi(3, arrayList2, aVar);
                return;
            }
        }
        if (aVar != null) {
            showProgressDialog(R.string.eob);
            int i3 = this.D;
            if (i3 == 1) {
                xi(aVar);
                return;
            } else {
                if (i3 == 2) {
                    gi(aVar);
                    return;
                }
                return;
            }
        }
        QLog.e("PublishHomeWorkFragment", 1, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
        mi(3, null, aVar);
    }
}
