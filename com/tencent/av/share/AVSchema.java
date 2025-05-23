package com.tencent.av.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.av.ReqGroupVideo$ReqCheckGroupCanJoin;
import com.tencent.av.ReqGroupVideo$ReqShareBackflowVerify;
import com.tencent.av.ReqGroupVideo$RspCheckGroupCanJoin;
import com.tencent.av.ReqGroupVideo$RspShareBackflowVerify;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PopupDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.util.LiuHaiUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AVSchema extends PublicBaseFragment {
    private static String K;
    Handler D;
    QQAppInterface F;
    h C = new h();
    Runnable E = null;
    boolean G = false;
    QQCustomDialog H = null;
    i I = new i();
    boolean J = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.share.AVSchema$2, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass2 extends MessageHandler.b<ReqGroupVideo$ReqCheckGroupCanJoin, ReqGroupVideo$RspCheckGroupCanJoin> {
        AnonymousClass2() {
        }

        @Override // com.tencent.av.business.handler.MessageHandler.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(final long j3, boolean z16, ReqGroupVideo$ReqCheckGroupCanJoin reqGroupVideo$ReqCheckGroupCanJoin, final ReqGroupVideo$RspCheckGroupCanJoin reqGroupVideo$RspCheckGroupCanJoin, Object obj) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.av.share.AVSchema.2.1

                /* compiled from: P */
                /* renamed from: com.tencent.av.share.AVSchema$2$1$a */
                /* loaded from: classes32.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        com.tencent.av.share.a.d();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AVSchema aVSchema = AVSchema.this;
                        aVSchema.Eh(j3, aVSchema.C);
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.av.share.AVSchema$2$1$b */
                /* loaded from: classes32.dex */
                class b implements DialogInterface.OnClickListener {
                    b() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        com.tencent.av.share.a.c();
                        AVSchema.this.Ih(false);
                        AVSchema.this.finish();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (AVSchema.this.isDetached()) {
                        return;
                    }
                    boolean z17 = reqGroupVideo$RspCheckGroupCanJoin.is_can_join.get();
                    if (z17) {
                        com.tencent.av.share.a.i();
                        PopupDialog.o0(AVSchema.this.getBaseActivity(), 230, null, reqGroupVideo$RspCheckGroupCanJoin.join_wording.get().toStringUtf8(), R.string.cancel, R.string.f171151ok, new a(), new b());
                    } else {
                        AVSchema aVSchema = AVSchema.this;
                        aVSchema.Eh(j3, aVSchema.C);
                    }
                    QLog.d(AVSchema.K, 1, "join group check[" + z17 + "]");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class MyMsgListener extends MessageHandler.b<ReqGroupVideo$ReqShareBackflowVerify, ReqGroupVideo$RspShareBackflowVerify> {

        /* renamed from: a, reason: collision with root package name */
        h f74396a;

        MyMsgListener(h hVar) {
            this.f74396a = hVar;
        }

        @Override // com.tencent.av.business.handler.MessageHandler.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(final long j3, boolean z16, ReqGroupVideo$ReqShareBackflowVerify reqGroupVideo$ReqShareBackflowVerify, final ReqGroupVideo$RspShareBackflowVerify reqGroupVideo$RspShareBackflowVerify, Object obj) {
            if (AVSchema.this.isDetached()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.av.share.AVSchema.MyMsgListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AVSchema.this.isDetached()) {
                        return;
                    }
                    int F2 = MessageHandler.F2(reqGroupVideo$RspShareBackflowVerify.result);
                    String G2 = MessageHandler.G2(reqGroupVideo$RspShareBackflowVerify.result);
                    String str = reqGroupVideo$RspShareBackflowVerify.uint64_group_code.get() + "";
                    long j16 = reqGroupVideo$RspShareBackflowVerify.uint64_room_id.get();
                    int i3 = reqGroupVideo$RspShareBackflowVerify.uint32_room_create_time.get();
                    int i16 = reqGroupVideo$RspShareBackflowVerify.enum_verify_status.has() ? reqGroupVideo$RspShareBackflowVerify.enum_verify_status.get() : 99;
                    String stringUtf8 = reqGroupVideo$RspShareBackflowVerify.bytes_wording.get().toStringUtf8();
                    MyMsgListener myMsgListener = MyMsgListener.this;
                    boolean Ch = AVSchema.Ch(AVSchema.this.C, myMsgListener.f74396a);
                    QLog.w(AVSchema.K, 1, "onReceiveResult.callback, result[" + F2 + "], errMsg[" + G2 + "], verifyStatus[" + i16 + "], groupUin[" + str + "], roomId[" + j16 + "], roomCreateTime[" + i3 + "], warning[" + stringUtf8 + "], isSameInfo[" + Ch + "], Activity[" + AVSchema.this.getBaseActivity() + "], isResume[" + AVSchema.this.isResumed() + "], seq[" + j3 + "]");
                    if (Ch) {
                        AVSchema.this.Ih(false);
                        if (TextUtils.isEmpty(stringUtf8) && (F2 != 0 || (i16 != 0 && F2 == 0))) {
                            stringUtf8 = HardCodeUtil.qqStr(R.string.jvd);
                        }
                        AVSchema aVSchema = AVSchema.this;
                        aVSchema.C.f74414c = i16;
                        if (i16 != 99) {
                            switch (i16) {
                                case 0:
                                    com.tencent.av.share.a.j(0);
                                    AVSchema.this.uh(str);
                                    return;
                                case 1:
                                case 2:
                                case 3:
                                case 6:
                                    break;
                                case 4:
                                    com.tencent.av.share.a.j(4);
                                    AVSchema.this.zh(j3, stringUtf8, str);
                                    return;
                                case 5:
                                    com.tencent.av.share.a.j(5);
                                    com.tencent.av.share.a.j(0);
                                    AVSchema.this.uh(str);
                                    AVSchema.this.Ah(j3, stringUtf8, str);
                                    return;
                                default:
                                    aVSchema.yh(j3, stringUtf8);
                                    if (com.tencent.av.utils.e.j()) {
                                        String str2 = HardCodeUtil.qqStr(R.string.jva) + i16 + "], warning[" + stringUtf8 + "], seq[" + j3 + "]";
                                        QLog.w(AVSchema.K, 1, str2);
                                        throw new RuntimeException(str2);
                                    }
                                    return;
                            }
                        }
                        com.tencent.av.share.a.j(i16);
                        AVSchema.this.yh(j3, stringUtf8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ChatActivityUtils.u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f74401a;

        a(long j3) {
            this.f74401a = j3;
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void a() {
            QLog.w(AVSchema.K, 1, "joinVideoChat.onAfterStartActivity, isDetached[" + AVSchema.this.isDetached() + "], seq[" + this.f74401a + "]");
            AVSchema.this.finish();
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void b() {
            QLog.w(AVSchema.K, 1, "joinVideoChat.onBeforeStartActivity, isDetached[" + AVSchema.this.isDetached() + "], seq[" + this.f74401a + "]");
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void onCancel() {
            QLog.w(AVSchema.K, 1, "joinVideoChat.onCancel, isDetached[" + AVSchema.this.isDetached() + "], seq[" + this.f74401a + "]");
            AVSchema.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74403d;

        b(String str) {
            this.f74403d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AVSchema.this.wh(this.f74403d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74405d;

        c(String str) {
            this.f74405d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.av.share.a.f();
            AVSchema.this.xh(this.f74405d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AVSchema aVSchema = AVSchema.this;
            if (dialogInterface == aVSchema.H) {
                aVSchema.H = null;
            }
            aVSchema.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements Function2<Boolean, TroopInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f74410d;

        g(WeakReference weakReference) {
            this.f74410d = weakReference;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, TroopInfo troopInfo) {
            i iVar = (i) this.f74410d.get();
            if (iVar == null) {
                return null;
            }
            iVar.a(bool.booleanValue(), troopInfo, "");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        String f74412a = null;

        /* renamed from: b, reason: collision with root package name */
        String f74413b = null;

        /* renamed from: c, reason: collision with root package name */
        int f74414c = 99;

        h() {
        }

        public String toString() {
            return this.f74412a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i {

        /* renamed from: a, reason: collision with root package name */
        String f74415a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f74417d;

            a(long j3) {
                this.f74417d = j3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (AVSchema.this.Bh("checkQAVPermission.callback", this.f74417d)) {
                    return;
                }
                if (i3 == 1) {
                    i iVar = i.this;
                    AVSchema.this.Dh(this.f74417d, iVar.f74415a);
                } else {
                    AVSchema.this.finish();
                }
            }
        }

        i() {
        }

        protected void a(boolean z16, TroopInfo troopInfo, String str) {
            long d16 = com.tencent.av.utils.e.d();
            if (AVSchema.this.Bh("onGetSimpleTroopInfoResult", d16) || troopInfo == null) {
                return;
            }
            String str2 = troopInfo.troopuin;
            if (!TextUtils.isEmpty(this.f74415a) && TextUtils.equals(this.f74415a, str2)) {
                QLog.w(AVSchema.K, 1, "onGetSimpleTroopInfoResult, isSuc[" + z16 + "], enumVerifyStatus[" + AVSchema.this.C.f74414c + "], seq[" + d16 + "]");
                AVSchema aVSchema = AVSchema.this;
                h hVar = aVSchema.C;
                hVar.f74413b = troopInfo.troopname;
                if (hVar.f74414c == 0) {
                    if (!ChatActivityUtils.m(aVSchema.getBaseActivity(), true, new a(d16))) {
                        QLog.w(AVSchema.K, 1, "onGetSimpleTroopInfoResult, \u7b49\u6743\u9650\u786e\u8ba4, seq[" + d16 + "]");
                        return;
                    }
                    AVSchema.this.Dh(d16, this.f74415a);
                }
            }
        }
    }

    public AVSchema() {
        String str = "AVSchema." + com.tencent.av.utils.e.d();
        K = str;
        QLog.w(str, 1, "AVSchema");
    }

    static h vh(Bundle bundle) {
        h hVar = new h();
        hVar.f74412a = bundle.getString("guid");
        return hVar;
    }

    void Ah(long j3, String str, String str2) {
        QQCustomDialog sh5 = sh();
        if (sh5 == null) {
            return;
        }
        sh5.setMessage(str);
        Gh(sh5);
        sh5.setPositiveButton(HardCodeUtil.qqStr(R.string.jvb), new b(str2));
        sh5.show();
        QLog.w(K, 1, "handleResult_ROOM_CLOSE, msg[" + str + "], seq[" + j3 + "]");
    }

    boolean Bh(String str, long j3) {
        if (isDetached()) {
            QLog.w(K, 1, str + ", isDetached, seq[" + j3 + "]");
            return true;
        }
        if (getBaseActivity() != null) {
            return false;
        }
        QLog.w(K, 1, str + ", !Activity, seq[" + j3 + "]");
        return true;
    }

    void Dh(long j3, String str) {
        if (this.J) {
            return;
        }
        com.tencent.av.share.a.h();
        boolean V = AVNotifyCenter.V();
        QLog.w(K, 1, "joinVideoChat, groupUin[" + str + "], isBeInvitingOnDoubleVideo[" + V + "], seq[" + j3 + "]");
        if (V) {
            QQToast.makeText(getBaseActivity(), R.string.dkm, 1).show(getBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        this.J = true;
        Bundle bundle = new Bundle();
        bundle.putInt("MultiAVType", 10);
        com.tencent.av.utils.e.p(K + ".joinVideoChat");
        ChatActivityUtils.f0(th(), th().getApp(), 1, str, true, true, new a(j3), bundle);
    }

    void Eh(long j3, h hVar) {
        ReqGroupVideo$ReqShareBackflowVerify reqGroupVideo$ReqShareBackflowVerify = new ReqGroupVideo$ReqShareBackflowVerify();
        reqGroupVideo$ReqShareBackflowVerify.uint64_uin.set(th().getLongAccountUin());
        reqGroupVideo$ReqShareBackflowVerify.bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(hVar.f74412a));
        MessageHandler.I2(j3, th(), "QQRTCSvc.group_video_share_backflow_verify", reqGroupVideo$ReqShareBackflowVerify, new MyMsgListener(hVar));
        QLog.w(K, 1, "realyRequest, info[" + hVar + "], seq[" + j3 + "]");
    }

    void Fh(long j3) {
        Bundle arguments = getArguments();
        com.tencent.av.utils.e.m(K + ".request_seq[" + j3 + "]", arguments);
        h vh5 = vh(arguments);
        boolean Ch = Ch(this.C, vh5);
        QLog.w(K, 1, "request, isSameInfo[" + Ch + "], mInfo[" + this.C + "], seq[" + j3 + "]");
        if (Ch) {
            return;
        }
        if (this.D != null && this.E == null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.av.share.AVSchema.1
                @Override // java.lang.Runnable
                public void run() {
                    AVSchema.this.Ih(true);
                }
            };
            this.E = runnable;
            this.D.postDelayed(runnable, 1000L);
        }
        qh(j3, this.C);
        this.C = vh5;
        if (vh5 == null) {
            return;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        ReqGroupVideo$ReqCheckGroupCanJoin reqGroupVideo$ReqCheckGroupCanJoin = new ReqGroupVideo$ReqCheckGroupCanJoin();
        reqGroupVideo$ReqCheckGroupCanJoin.uint64_uin.set(th().getLongAccountUin());
        reqGroupVideo$ReqCheckGroupCanJoin.bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(vh5.f74412a));
        MessageHandler.I2(j3, th(), "QQRTCSvc.share_backflow_check_group_can_join", reqGroupVideo$ReqCheckGroupCanJoin, anonymousClass2);
    }

    void Ih(boolean z16) {
        View findViewById;
        Runnable runnable;
        if (getBaseActivity() == null || (findViewById = getBaseActivity().findViewById(R.id.lac)) == null) {
            return;
        }
        View view = (View) findViewById.getParent();
        if (z16) {
            findViewById.setVisibility(0);
            view.setBackgroundColor(-271725107);
            ((TextView) view.findViewById(R.id.f18)).setText(R.string.cpr);
            return;
        }
        findViewById.setVisibility(4);
        view.setBackgroundColor(16777216);
        Handler handler = this.D;
        if (handler == null || (runnable = this.E) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.E = null;
    }

    void finish() {
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
        }
        QLog.w(K, 1, "finish", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        long d16 = com.tencent.av.utils.e.d();
        com.tencent.av.utils.e.m(K + ".onActivityCreated_seq[" + d16 + "]", bundle);
        QLog.w(K, 1, "onActivityCreated, seq[" + d16 + "]");
        Fh(d16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        QLog.w(K, 1, "onAttach, activity[" + activity + "]");
        LiuHaiUtils.initLiuHaiProperty(activity);
        this.D = new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        QLog.w(K, 1, "onDetach", QLog.isDevelopLevel() ? new Throwable("\u6253\u5370\u8c03\u7528\u6808") : null);
        this.I.f74415a = "";
        Handler handler = this.D;
        if (handler != null) {
            Runnable runnable = this.E;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
                this.E = null;
            }
            this.D = null;
        }
        rh();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        long d16 = com.tencent.av.utils.e.d();
        com.tencent.av.utils.e.l(K + ".onNewIntent_seq[" + d16 + "]", intent);
        Fh(d16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.w(K, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(K, 1, "onResume, seq[" + d16 + "], mQQCustomDialog[" + this.H + "]");
        Fh(d16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.w(K, 1, "onViewCreated, view[" + view + "]");
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        QLog.w(K, 1, "onWindowFocusChanged, hasFocus[" + z16 + "]");
    }

    void qh(long j3, h hVar) {
        QLog.w(K, 1, "cancelLastRequest, info[" + hVar + "], seq[" + j3 + "]");
    }

    void rh() {
        QQCustomDialog qQCustomDialog = this.H;
        this.H = null;
        if (qQCustomDialog != null) {
            try {
                qQCustomDialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    QQCustomDialog sh() {
        rh();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing()) {
            return null;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 230);
        this.H = createCustomDialog;
        createCustomDialog.setCancelable(true);
        this.H.setOnDismissListener(new d());
        return this.H;
    }

    QQAppInterface th() {
        if (this.F == null && (getBaseActivity().getAppInterface() instanceof QQAppInterface)) {
            this.F = (QQAppInterface) getBaseActivity().getAppInterface();
        }
        return this.F;
    }

    void uh(String str) {
        this.I.f74415a = str;
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(str, K, null, new g(new WeakReference(this.I)));
    }

    void wh(String str) {
        QLog.w(K, 1, "gotoAIO, groupUin[" + str + "], mHadGotoAIO[" + this.G + "]");
        if (this.G) {
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(BaseApplicationImpl.getApplication()), new int[]{2});
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 1);
        m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 8);
        BaseApplicationImpl.getApplication().startActivity(m3);
        this.G = true;
    }

    void yh(final long j3, String str) {
        QQCustomDialog sh5 = sh();
        if (sh5 == null) {
            return;
        }
        sh5.setMessage(str);
        Hh(sh5);
        sh5.show();
        QLog.w(K, 1, "handleResult_I_Known, msg[" + str + "], seq[" + j3 + "]");
        new MqqHandler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.av.share.AVSchema.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.w(AVSchema.K, 1, "handleResult_I_Known, msg[" + AVSchema.this.isResumed() + "], seq[" + j3 + "]");
                QQCustomDialog qQCustomDialog = AVSchema.this.H;
                if (qQCustomDialog != null) {
                    try {
                        qQCustomDialog.show();
                        AVSchema.this.H.getWindow().getDecorView().requestLayout();
                        AVSchema.this.getBaseActivity().getWindow().getDecorView().requestLayout();
                        AVSchema.this.getBaseActivity().getWindow().getDecorView().invalidate();
                    } catch (Exception unused) {
                    }
                }
            }
        }, 100L);
    }

    void zh(long j3, String str, String str2) {
        QQCustomDialog sh5 = sh();
        if (sh5 == null) {
            return;
        }
        sh5.setMessage(str);
        Gh(sh5);
        sh5.setPositiveButton(HardCodeUtil.qqStr(R.string.jvc), new c(str2));
        sh5.show();
        QLog.w(K, 1, "handleResult_NEED_ADMIN_CONFIRM, msg[" + str + "], seq[" + j3 + "]");
    }

    void xh(String str) {
        TroopUtils.I(getActivity(), aq.b(str, 14), 2);
    }

    void Gh(QQCustomDialog qQCustomDialog) {
        qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new f());
    }

    void Hh(QQCustomDialog qQCustomDialog) {
        qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.jv_), new e());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.qq_progress_dialog, viewGroup, false);
        inflate.getLayoutParams().height = -1;
        int notchInScreenHeight = LiuHaiUtils.getNotchInScreenHeight(getBaseActivity());
        View findViewById = inflate.findViewById(R.id.lac);
        ((FrameLayout.LayoutParams) findViewById.getLayoutParams()).topMargin = notchInScreenHeight;
        findViewById.setVisibility(4);
        ((View) findViewById.getParent()).setBackgroundColor(16777216);
        QLog.w(K, 1, "onCreateView, view[" + inflate + "], statusBarHeight[" + notchInScreenHeight + "]");
        return inflate;
    }

    static boolean Ch(h hVar, h hVar2) {
        if (hVar == null || hVar2 == null) {
            return false;
        }
        return TextUtils.equals(hVar.f74412a, hVar2.f74412a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
