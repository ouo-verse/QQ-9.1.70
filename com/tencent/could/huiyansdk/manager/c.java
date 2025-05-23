package com.tencent.could.huiyansdk.manager;

import android.os.Message;
import android.util.SparseArray;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.AuthState;
import com.tencent.could.huiyansdk.enums.HuiYanAuthEvent;
import com.tencent.could.huiyansdk.enums.HuiYanAuthTipsEvent;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.could.huiyansdk.callback.a f100132a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.could.huiyansdk.callback.b f100133b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f100134c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f100135d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f100136e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f100137f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f100138g;

    /* renamed from: h, reason: collision with root package name */
    public int f100139h;

    /* renamed from: i, reason: collision with root package name */
    public int f100140i;

    /* renamed from: j, reason: collision with root package name */
    public int f100141j;

    /* renamed from: k, reason: collision with root package name */
    public l f100142k;

    /* renamed from: l, reason: collision with root package name */
    public SparseArray<HuiYanAuthTipsEvent> f100143l;

    /* renamed from: m, reason: collision with root package name */
    public HuiYanAuthTipsEvent f100144m;

    /* renamed from: n, reason: collision with root package name */
    public int f100145n;

    /* renamed from: o, reason: collision with root package name */
    public int f100146o;

    /* renamed from: p, reason: collision with root package name */
    public int f100147p;

    /* renamed from: q, reason: collision with root package name */
    public int f100148q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f100149r;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.could.huiyansdk.callback.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f100150a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f100151b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f100152c;

        public a(boolean z16, String str, String str2) {
            this.f100150a = z16;
            this.f100151b = str;
            this.f100152c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Boolean.valueOf(z16), str, str2);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            k.a.f100197a.a(2, "AuthStateManager", "start compare.");
            c.this.a(AuthState.AUTH_END, (Object) null);
            HuiYanSdkImp.getInstance().onAuthEvent(HuiYanAuthEvent.LOCAL_DETECTION_DONE);
            if (this.f100150a) {
                HuiYanSdkImp.getInstance().onCompareSuccess(this.f100151b, this.f100152c);
            } else {
                HuiYanSdkImp.getInstance().onCompareSuccess(this.f100151b, "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final c f100154a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10473);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100154a = new c();
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AuthState authState = AuthState.PREPARE;
        this.f100134c = false;
        this.f100139h = -1;
        this.f100140i = -1;
        this.f100141j = 3;
        this.f100149r = false;
        this.f100135d = new int[]{R.string.fl_no_face, R.string.fl_incomplete_face, R.string.fl_pose_incorrect, R.string.fl_no_left_face, R.string.fl_no_right_face, R.string.fl_no_chin, R.string.fl_no_mouth, R.string.fl_no_nose, R.string.fl_no_left_eye, R.string.fl_no_right_eye, R.string.fl_pose_closer, R.string.fl_pose_farer, R.string.fl_too_many_faces, R.string.fl_pose_open_eye, R.string.fl_close_mouth, R.string.fl_pose_open_eye, R.string.msg_fsm_pause};
        this.f100136e = new int[]{R.string.fl_act_blink, R.string.fl_act_open_mouth, R.string.fl_act_shake_head, R.string.fl_act_nod_head, R.string.fl_pose_keep};
        this.f100137f = new int[]{R.string.fl_act_screen_shaking};
        this.f100138g = new int[]{R.string.rst_succeed, R.string.rst_failed, R.string.net_fetch_data, R.string.net_fetch_failed, R.string.net_reporting, R.string.msg_net_error, R.string.msg_param_error, R.string.msg_inner_error, R.string.msg_user_cancel, R.string.msg_cam_error, R.string.msg_light_dark, R.string.msg_light_norm, R.string.msg_light_bright};
        a();
    }

    public void a(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        k.a.f100197a.a(2, "AuthStateManager", "do live compare result");
        l lVar = this.f100142k;
        if (lVar == null) {
            b(str, true, "");
        } else {
            lVar.c(new com.tencent.could.huiyansdk.callback.h() { // from class: com.tencent.could.huiyansdk.manager.m
                @Override // com.tencent.could.huiyansdk.callback.h
                public final void a(boolean z16, String str2) {
                    c.this.b(str, z16, str2);
                }
            });
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f100143l == null) {
            SparseArray<HuiYanAuthTipsEvent> sparseArray = new SparseArray<>(20);
            this.f100143l = sparseArray;
            sparseArray.put(R.string.fl_act_open_mouth, HuiYanAuthTipsEvent.ACT_OPEN_MOUTH);
            this.f100143l.put(R.string.fl_act_blink, HuiYanAuthTipsEvent.ACT_BLINK);
            this.f100143l.put(R.string.fl_act_nod_head, HuiYanAuthTipsEvent.ACT_NOD_HEAD);
            this.f100143l.put(R.string.fl_act_shake_head, HuiYanAuthTipsEvent.ACT_SHAKE_HEAD);
            this.f100143l.put(R.string.fl_act_screen_shaking, HuiYanAuthTipsEvent.ACT_SCREEN_SHAKING);
            this.f100143l.put(R.string.fl_no_face, HuiYanAuthTipsEvent.NO_FACE);
            this.f100143l.put(R.string.fl_no_left_face, HuiYanAuthTipsEvent.NO_LEFT_FACE);
            this.f100143l.put(R.string.fl_no_right_face, HuiYanAuthTipsEvent.NO_RIGHT_FACE);
            this.f100143l.put(R.string.fl_no_chin, HuiYanAuthTipsEvent.NO_CHIN);
            this.f100143l.put(R.string.fl_no_mouth, HuiYanAuthTipsEvent.NO_MOUTH);
            this.f100143l.put(R.string.fl_no_nose, HuiYanAuthTipsEvent.NO_NOSE);
            this.f100143l.put(R.string.fl_no_left_eye, HuiYanAuthTipsEvent.NO_LEFT_EYE);
            this.f100143l.put(R.string.fl_no_right_eye, HuiYanAuthTipsEvent.NO_RIGHT_EYE);
            this.f100143l.put(R.string.fl_pose_keep, HuiYanAuthTipsEvent.POSE_KEEP);
            this.f100143l.put(R.string.fl_incomplete_face, HuiYanAuthTipsEvent.INCOMPLETE_FACE);
            this.f100143l.put(R.string.fl_pose_closer, HuiYanAuthTipsEvent.POSE_CLOSER);
            this.f100143l.put(R.string.fl_pose_farer, HuiYanAuthTipsEvent.POSE_FARTHER);
            this.f100143l.put(R.string.fl_pose_incorrect, HuiYanAuthTipsEvent.POSE_INCORRECT);
            this.f100143l.put(R.string.fl_too_many_faces, HuiYanAuthTipsEvent.TOO_MANY_FACE);
            this.f100143l.put(R.string.fl_pose_open_eye, HuiYanAuthTipsEvent.POSE_OPEN_EYE);
        }
        this.f100144m = HuiYanAuthTipsEvent.NONE;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(String str, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), str2);
            return;
        }
        com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
        a aVar = new a(z16, str, str2);
        TuringResultCacheEntity turingResultCacheEntity = fVar.f100277f;
        if (!(turingResultCacheEntity != null ? turingResultCacheEntity.isNeedFrameCheck() : false)) {
            aVar.a();
            return;
        }
        if (fVar.f100276e) {
            aVar.a();
            return;
        }
        fVar.f100280i = aVar;
        if (fVar.f100285n != null) {
            Message obtainMessage = fVar.f100285n.obtainMessage();
            obtainMessage.what = 4;
            fVar.f100285n.sendMessageDelayed(obtainMessage, fVar.f100272a);
            return;
        }
        k.a.f100197a.a(2, "TuringSdkHelper", "waiting handler is null!");
    }

    public void a(AuthState authState, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) authState, obj);
            return;
        }
        com.tencent.could.huiyansdk.callback.a aVar = this.f100132a;
        if (aVar != null) {
            aVar.a(authState, obj);
        }
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        com.tencent.could.huiyansdk.callback.b bVar = this.f100133b;
        if (bVar != null) {
            ((com.tencent.could.huiyansdk.fragments.e) bVar).b(i3);
        }
    }

    public final boolean a(int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) iArr)).booleanValue();
        }
        for (int i16 : iArr) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }
}
