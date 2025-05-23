package com.tencent.mobileqq.poke;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.poke.ClickedWaveView;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class NTPokePanel extends RelativeLayout implements View.OnClickListener, ClickedWaveView.a, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;

    @QAutoInject(configPath = "AutoInjectYml/Business/PlusPanel/Inject_PokeVas.yml", version = 1)
    private static com.tencent.qqnt.pluspanel.logic.c W;

    /* renamed from: a0, reason: collision with root package name */
    public static boolean f258962a0;

    /* renamed from: b0, reason: collision with root package name */
    private static ArrayList f258963b0;
    private com.tencent.aio.api.runtime.a C;
    private boolean D;
    private boolean E;
    public boolean F;
    public boolean G;
    private IPokeSendHelper H;
    private ArrayList<int[]> I;
    CallBacker J;
    private final int[] K;
    private final int[] L;
    private final int[] M;
    private final int[] N;
    private final int[] P;
    private final int[] Q;
    long R;
    long S;
    int T;
    int U;
    com.tencent.mobileqq.apollo.handler.c V;

    /* renamed from: d, reason: collision with root package name */
    private ListView f258964d;

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f258965e;

    /* renamed from: f, reason: collision with root package name */
    private g f258966f;

    /* renamed from: h, reason: collision with root package name */
    private String f258967h;

    /* renamed from: i, reason: collision with root package name */
    HandlerThread f258968i;

    /* renamed from: m, reason: collision with root package name */
    MqqHandler f258969m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f258981a;

        a(String str) {
            this.f258981a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokePanel.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTPokePanel.this.w(updateListenerParams, this.f258981a);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NTPokePanel.this.w(updateListenerParams, this.f258981a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f258983a;

        b(String str) {
            this.f258983a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokePanel.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTPokePanel.this.w(updateListenerParams, this.f258983a);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NTPokePanel.this.w(updateListenerParams, this.f258983a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f258985a;

        c(String str) {
            this.f258985a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokePanel.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            QLog.i("Q.aio.PokePanel", 1, "sendPokeMsg downloaded fail code: " + updateListenerParams.mErrorCode + " hc:" + updateListenerParams.mHttpCode);
            NTPokePanel.this.w(updateListenerParams, this.f258985a);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            QLog.i("Q.aio.PokePanel", 1, "sendPokeMsg downloaded success, scid:" + updateListenerParams.mBusinessUpdateParams.mScid);
            NTPokePanel.this.w(updateListenerParams, this.f258985a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f258987a;

        d(String str) {
            this.f258987a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokePanel.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            QLog.i("Q.aio.PokePanel", 1, "sendPokeMsg downloaded fail code: " + updateListenerParams.mErrorCode + " hc:" + updateListenerParams.mHttpCode);
            NTPokePanel.this.w(updateListenerParams, this.f258987a);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            QLog.i("Q.aio.PokePanel", 1, "sendPokeMsg downloaded success, scid:" + updateListenerParams.mBusinessUpdateParams.mScid);
            NTPokePanel.this.w(updateListenerParams, this.f258987a);
        }
    }

    /* loaded from: classes16.dex */
    class e implements com.tencent.mobileqq.apollo.handler.c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokePanel.this);
            }
        }

        protected void a(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            Bundle bundle = (Bundle) obj;
            int i3 = bundle.getInt(IProfileCardConst.KEY_FROM_TYPE);
            if (i3 != 0) {
                QLog.d("Q.aio.PokePanel", 1, "onPokeAuth unknown from type : ", Integer.valueOf(i3));
                return;
            }
            int i16 = bundle.getInt("id");
            bundle.getInt(VipFunCallConstants.KEY_FEET_TYPE);
            QLog.d("Q.aio.PokePanel", 1, "onPokeAuth success : ", Boolean.valueOf(z16));
            if (z16) {
                String string = bundle.getString("name");
                String string2 = bundle.getString("minVersion");
                AIOElementType.b bVar = new AIOElementType.b();
                bVar.F(126);
                bVar.c0(string);
                bVar.a0(i16);
                bVar.b0(string2);
                bVar.N(string);
                bVar.C(NTPokePanel.this.getContext().getString(R.string.o39));
                NTPokePanel.this.H.sendPokeMsg(NTPokePanel.this.C, bVar);
                if (true == f.N) {
                    f.N = false;
                    return;
                }
                return;
            }
            long j3 = bundle.getLong("result");
            String string3 = bundle.getString("msg");
            NTPokePanel.this.T = bundle.getInt("id", 0);
            String qqStr = HardCodeUtil.qqStr(R.string.pae);
            QLog.d("Q.aio.PokePanel", 1, "onPokeAuth result : ", Long.valueOf(j3), " msg : ", string3);
            if (j3 == 0) {
                NTPokePanel.this.U = 1;
                if (true == f.N) {
                    f.N = false;
                    return;
                }
                return;
            }
            if (j3 == 4002) {
                NTPokePanel.this.U = 2;
                string3 = HardCodeUtil.qqStr(R.string.pah);
            } else if (j3 == 5002) {
                NTPokePanel.this.U = 4;
                string3 = HardCodeUtil.qqStr(R.string.pag);
            } else {
                NTPokePanel.this.U = 1;
                qqStr = HardCodeUtil.qqStr(R.string.ket);
                QLog.e("Q.aio.PokePanel", 1, "vas poke auth fail, result: " + j3);
            }
            String str = string3;
            String str2 = qqStr;
            if (j3 != 0) {
                AppRuntime appRuntime = NTPokePanel.this.f258965e;
                Activity activity = (Activity) NTPokePanel.this.getContext();
                NTPokePanel nTPokePanel = NTPokePanel.this;
                f.t(appRuntime, activity, str, str2, nTPokePanel.T, nTPokePanel.U, NTPokePanel.W);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 23) {
                a(z16, obj);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f258963b0 = arrayList;
        arrayList.add(o61.a.class);
        f258962a0 = false;
    }

    public NTPokePanel(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = new CallBacker() { // from class: com.tencent.mobileqq.poke.NTPokePanel.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTPokePanel.this);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
            
                if (r11 != 0) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
            
                r1 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
            
                r2 = r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
            
                if (r11 != 0) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
                String str4;
                String substring;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z16 = true;
                boolean z17 = false;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (j3 == 21) {
                    if (str.equals(VasUpdateConstants.SCID_POKE_EFFECT_LIST) && i3 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.aio.PokePanel", 2, "download vas poke list, refresh now.");
                        }
                        ThreadManager.getUIHandler().post(new Runnable(NTPokePanel.this.f258965e) { // from class: com.tencent.mobileqq.poke.NTPokePanel.5.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ AppRuntime f258975d;

                            {
                                this.f258975d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    NTPokePanel.this.u(f.h(this.f258975d));
                                }
                            }
                        });
                    } else {
                        str4 = VasUpdateConstants.SCID_POKE_PANEL_PREFIX;
                        if (str.startsWith(VasUpdateConstants.SCID_POKE_PANEL_PREFIX)) {
                            substring = str.substring(17, str.length());
                        } else {
                            str4 = VasUpdateConstants.SCID_POKE_EFFECT_PREFIX;
                            if (str.startsWith(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX)) {
                                substring = str.substring(14, str.length());
                            }
                        }
                        if (TextUtils.isEmpty(str4)) {
                            ThreadManager.getUIHandler().post(new Runnable(str4, substring, z17) { // from class: com.tencent.mobileqq.poke.NTPokePanel.5.2
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f258977d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ String f258978e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ boolean f258979f;

                                {
                                    this.f258977d = str4;
                                    this.f258978e = substring;
                                    this.f258979f = z17;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass5.this, str4, substring, Boolean.valueOf(z17));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        NTPokePanel.this.f258966f.d(this.f258977d, Integer.valueOf(this.f258978e).intValue(), false, this.f258979f);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    str4 = "";
                    substring = "";
                    if (TextUtils.isEmpty(str4)) {
                    }
                }
            }
        };
        this.K = new int[]{R.string.ihf, R.drawable.cej, 3};
        this.L = new int[]{R.string.cxi, R.drawable.cdo, 1};
        this.M = new int[]{R.string.f170999bk0, R.drawable.cdm, 2};
        this.N = new int[]{R.string.bp7, R.drawable.ceh, 4};
        this.P = new int[]{R.string.bpe, R.drawable.cei, 5};
        this.Q = new int[]{R.string.bni, R.drawable.cdp, 6};
        this.R = 0L;
        this.S = 0L;
        this.T = -1;
        this.U = 1;
        this.V = new e();
    }

    public static void k(AppRuntime appRuntime) {
        if (!f258962a0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.poke.NTPokePanel.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppRuntime.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.aio.PokePanel", 2, "checkAllSourceDowned onShow First");
                    }
                    NTPokePanel.l(AppRuntime.this);
                }
            }, 64, null, true);
        }
    }

    public static boolean l(AppRuntime appRuntime) {
        if (f258962a0 || m(appRuntime)) {
            return true;
        }
        W.c();
        f258962a0 = false;
        return false;
    }

    public static boolean m(AppRuntime appRuntime) {
        if (f258962a0) {
            return true;
        }
        if (f.m(2) && f.m(3) && f.m(4) && f.m(5) && f.m(6) && h.a()) {
            f.c(appRuntime, null, W);
            f258962a0 = true;
            return true;
        }
        return false;
    }

    public static void n() {
        if (W == null) {
            q();
        }
        if (W == null) {
            QLog.w("Q.aio.PokePanel", 1, "vasInject is null");
        }
    }

    public static com.tencent.qqnt.pluspanel.logic.c o() {
        return W;
    }

    @QAutoInitMethod
    private static void q() {
        W = (com.tencent.qqnt.pluspanel.logic.c) com.tencent.mobileqq.qroute.utils.b.a(f258963b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            switch (str.charAt(i3)) {
                case '1':
                    this.I.add(this.L);
                    break;
                case '2':
                    this.I.add(this.M);
                    break;
                case '3':
                    this.I.add(this.K);
                    break;
                case '4':
                    this.I.add(this.N);
                    break;
                case '5':
                    this.I.add(this.P);
                    break;
                case '6':
                    this.I.add(this.Q);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ArrayList<i> arrayList) {
        String str;
        for (int i3 = 0; i3 < this.I.size(); i3++) {
            int[] iArr = this.I.get(i3);
            i iVar = new i();
            int i16 = iArr[2];
            if (i16 == 1 && !f.m(i16)) {
                String str2 = MobileQQ.QQ_PACKAGE_NAME;
                iVar.f259067b = BaseApplication.getContext().getResources().getDrawable(R.drawable.c2a);
            } else {
                int i17 = iArr[2];
                if (i17 != 0 && f.m(i17)) {
                    switch (iArr[2]) {
                        case 1:
                            str = f.T + "/chuo_icon/chuo_icon_";
                            break;
                        case 2:
                            str = f.T + "/bixin_icon/bixin_icon_";
                            break;
                        case 3:
                            str = f.T + "/zan_icon/zan_icon_";
                            break;
                        case 4:
                            str = f.T + "/xinsui_icon/xinsui_icon_";
                            break;
                        case 5:
                            str = f.T + "/666_icon/666_icon_";
                            break;
                        case 6:
                            str = f.T + "/dazhao_icon/dazhao_icon_";
                            break;
                        default:
                            str = f.T + "/chuo_icon/chuo_icon_";
                            break;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 1;
                    options.inMutable = true;
                    Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(str + "01.png", options);
                    String str3 = MobileQQ.QQ_PACKAGE_NAME;
                    CustomFrameAnimationDrawable customFrameAnimationDrawable = new CustomFrameAnimationDrawable(BaseApplication.getContext().getResources(), decodeFileWithBufferedStream, this.f258969m);
                    int i18 = 0;
                    while (i18 < 22) {
                        int i19 = i18 + 1;
                        if (i19 < 10) {
                            customFrameAnimationDrawable.f(i18, 40, str + "0" + i19 + ".png");
                        } else {
                            customFrameAnimationDrawable.f(i18, 40, str + i19 + ".png");
                        }
                        i18 = i19;
                    }
                    iVar.f259067b = customFrameAnimationDrawable;
                } else {
                    String str4 = MobileQQ.QQ_PACKAGE_NAME;
                    iVar.f259067b = BaseApplication.getContext().getResources().getDrawable(iArr[1]);
                }
            }
            iVar.f259066a = iArr[2];
            iVar.f259068c = iArr[1];
            String str5 = MobileQQ.QQ_PACKAGE_NAME;
            iVar.f259069d = BaseApplication.getContext().getResources().getString(iArr[0]);
            iVar.f259070e = BaseApplication.getContext().getResources().getString(iArr[0]) + HardCodeUtil.qqStr(R.string.pai);
            iVar.f259073h = false;
            arrayList.add(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0158 A[Catch: Exception -> 0x0250, all -> 0x025c, TRY_ENTER, TryCatch #0 {Exception -> 0x0250, blocks: (B:10:0x003f, B:12:0x0049, B:14:0x004f, B:17:0x0056, B:18:0x005f, B:20:0x0065, B:22:0x009b, B:24:0x00a1, B:31:0x00c9, B:35:0x00f2, B:37:0x0107, B:38:0x0113, B:39:0x012a, B:42:0x0158, B:43:0x01af, B:45:0x01b5, B:46:0x01e5, B:48:0x01f3, B:52:0x0205, B:54:0x021b, B:55:0x0227, B:60:0x023e, B:63:0x018b), top: B:9:0x003f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b5 A[Catch: Exception -> 0x0250, all -> 0x025c, TryCatch #0 {Exception -> 0x0250, blocks: (B:10:0x003f, B:12:0x0049, B:14:0x004f, B:17:0x0056, B:18:0x005f, B:20:0x0065, B:22:0x009b, B:24:0x00a1, B:31:0x00c9, B:35:0x00f2, B:37:0x0107, B:38:0x0113, B:39:0x012a, B:42:0x0158, B:43:0x01af, B:45:0x01b5, B:46:0x01e5, B:48:0x01f3, B:52:0x0205, B:54:0x021b, B:55:0x0227, B:60:0x023e, B:63:0x018b), top: B:9:0x003f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f3 A[Catch: Exception -> 0x0250, all -> 0x025c, TryCatch #0 {Exception -> 0x0250, blocks: (B:10:0x003f, B:12:0x0049, B:14:0x004f, B:17:0x0056, B:18:0x005f, B:20:0x0065, B:22:0x009b, B:24:0x00a1, B:31:0x00c9, B:35:0x00f2, B:37:0x0107, B:38:0x0113, B:39:0x012a, B:42:0x0158, B:43:0x01af, B:45:0x01b5, B:46:0x01e5, B:48:0x01f3, B:52:0x0205, B:54:0x021b, B:55:0x0227, B:60:0x023e, B:63:0x018b), top: B:9:0x003f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023e A[Catch: Exception -> 0x0250, all -> 0x025c, TRY_LEAVE, TryCatch #0 {Exception -> 0x0250, blocks: (B:10:0x003f, B:12:0x0049, B:14:0x004f, B:17:0x0056, B:18:0x005f, B:20:0x0065, B:22:0x009b, B:24:0x00a1, B:31:0x00c9, B:35:0x00f2, B:37:0x0107, B:38:0x0113, B:39:0x012a, B:42:0x0158, B:43:0x01af, B:45:0x01b5, B:46:0x01e5, B:48:0x01f3, B:52:0x0205, B:54:0x021b, B:55:0x0227, B:60:0x023e, B:63:0x018b), top: B:9:0x003f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018b A[Catch: Exception -> 0x0250, all -> 0x025c, TryCatch #0 {Exception -> 0x0250, blocks: (B:10:0x003f, B:12:0x0049, B:14:0x004f, B:17:0x0056, B:18:0x005f, B:20:0x0065, B:22:0x009b, B:24:0x00a1, B:31:0x00c9, B:35:0x00f2, B:37:0x0107, B:38:0x0113, B:39:0x012a, B:42:0x0158, B:43:0x01af, B:45:0x01b5, B:46:0x01e5, B:48:0x01f3, B:52:0x0205, B:54:0x021b, B:55:0x0227, B:60:0x023e, B:63:0x018b), top: B:9:0x003f, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<i> t(AppRuntime appRuntime, CallBacker callBacker) {
        File file;
        String str;
        Object obj;
        char c16;
        int i3;
        long j3;
        boolean z16;
        ArrayList<i> arrayList = new ArrayList<>();
        QQVasUpdateBusiness e16 = f.e();
        if (e16 != null) {
            file = new File(e16.getBusinessItemInfo(21L, VasUpdateConstants.SCID_POKE_EFFECT_LIST).mSavePath);
        } else {
            file = new File(f.H);
        }
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
                try {
                    if (!jSONObject.optBoolean("lottieEnable", true)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.aio.PokePanel", 2, "lottie disable");
                        }
                        return arrayList;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
                    int i16 = 0;
                    int i17 = 0;
                    while (i17 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i17);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("name");
                        int optInt = jSONObject2.optInt(VipFunCallConstants.KEY_FEET_TYPE, i16);
                        int optInt2 = jSONObject2.optInt("status", i16);
                        int optInt3 = jSONObject2.optInt(ViewStickEventHelper.IS_SHOW, i16);
                        String optString3 = jSONObject2.optString("minVersion");
                        if (!f.n(optString3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.aio.PokePanel", 2, "curr ver: " + AppSetting.f99551k + ", config qqVer:" + optString3);
                            }
                        } else if (optInt2 == 1 && optInt3 == 1) {
                            i iVar = new i();
                            iVar.f259066a = 126;
                            int parseInt = Integer.parseInt(optString);
                            iVar.f259068c = parseInt;
                            iVar.f259069d = optString2;
                            iVar.f259072g = optInt;
                            iVar.f259070e = optString2;
                            iVar.f259075j = optString3;
                            if (!f.v("effect.gif", parseInt)) {
                                iVar.f259074i = true;
                                String str2 = VasUpdateConstants.SCID_POKE_PANEL_PREFIX + iVar.f259068c;
                                if (e16 != null) {
                                    e16.addDownLoadListener(str2, new a(str2));
                                    e16.startDownload(str2);
                                } else {
                                    IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "");
                                    str = "";
                                    obj = IVasQuickUpdateService.class;
                                    iVasQuickUpdateService.downloadItem(21L, str2, "parseVasPokeConfig");
                                    iVasQuickUpdateService.addCallBacker(callBacker);
                                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                                    obtain.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
                                    obtain.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
                                    obtain.mPlayGifImage = true;
                                    obtain.mGifRoundCorner = 0.0f;
                                    if (e16 == null) {
                                        iVar.f259067b = URLDrawable.getDrawable(new File(e16.getSavePath(VasUpdateConstants.SCID_POKE_PANEL_PREFIX + iVar.f259068c) + "/effect.gif"), obtain);
                                    } else {
                                        iVar.f259067b = URLDrawable.getDrawable(new File(f.G + iVar.f259068c + "/effect.gif"), obtain);
                                    }
                                    if (!QLog.isColorLevel()) {
                                        c16 = 2;
                                        QLog.i("Q.aio.PokePanel", 2, "name: " + iVar.f259069d + " resId: " + iVar.f259068c + " feeType: " + iVar.f259072g);
                                    } else {
                                        c16 = 2;
                                    }
                                    arrayList.add(iVar);
                                    if (f.v("bubble", iVar.f259068c)) {
                                        iVar.f259073h = true;
                                        if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 1) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        if (z16) {
                                            String str3 = VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + iVar.f259068c;
                                            if (e16 != null) {
                                                e16.addDownLoadListener(str3, new b(str3));
                                                e16.startDownload(str3);
                                            } else {
                                                IVasQuickUpdateService iVasQuickUpdateService2 = (IVasQuickUpdateService) appRuntime.getRuntimeService(obj, str);
                                                j3 = 21;
                                                iVasQuickUpdateService2.downloadItem(21L, str3, "parseVasPokeConfig");
                                                iVasQuickUpdateService2.addCallBacker(callBacker);
                                                i3 = 0;
                                            }
                                        }
                                        j3 = 21;
                                        i3 = 0;
                                    } else {
                                        i3 = 0;
                                        j3 = 21;
                                        iVar.f259073h = false;
                                    }
                                    i17++;
                                    i16 = i3;
                                }
                            }
                            str = "";
                            obj = IVasQuickUpdateService.class;
                            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                            obtain2.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
                            obtain2.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
                            obtain2.mPlayGifImage = true;
                            obtain2.mGifRoundCorner = 0.0f;
                            if (e16 == null) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                            arrayList.add(iVar);
                            if (f.v("bubble", iVar.f259068c)) {
                            }
                            i17++;
                            i16 = i3;
                        }
                        i3 = 0;
                        c16 = 2;
                        j3 = 21;
                        i17++;
                        i16 = i3;
                    }
                } catch (Exception e17) {
                    QLog.e("PokeItemHelper", 1, "parse json config fail", e17);
                }
            } catch (Throwable th5) {
                QLog.e("Q.aio.PokePanel", 1, "getJsonOOM,json_name:vasPoke", th5);
            }
        } else {
            f.c(appRuntime, callBacker, W);
        }
        return arrayList;
    }

    private void v(Bundle bundle) {
        int i3 = bundle.getInt("type");
        int i16 = bundle.getInt("id");
        String string = bundle.getString("name");
        String string2 = bundle.getString("minVersion");
        int i17 = bundle.getInt(VipFunCallConstants.KEY_FEET_TYPE);
        AIOElementType.b bVar = new AIOElementType.b();
        bVar.F(i3);
        bVar.C(getContext().getResources().getString(R.string.o39));
        String j3 = this.C.g().r().c().j();
        if (i16 == R.drawable.cdo) {
            this.H.sendPokeMsg(this.C, bVar);
            ReportController.o(this.f258965e, "CliOper", "", j3, "0X8007F22", "0X8007F22", 1, 0, "", "", "", "");
        } else if (i16 == R.drawable.cdm) {
            this.H.sendPokeMsg(this.C, bVar);
            ReportController.o(this.f258965e, "CliOper", "", j3, "0X8007F22", "0X8007F22", 2, 0, "", "", "", "");
        } else if (i16 == R.drawable.ceh) {
            this.H.sendPokeMsg(this.C, bVar);
            ReportController.o(this.f258965e, "CliOper", "", j3, "0X8007F22", "0X8007F22", 4, 0, "", "", "", "");
        } else if (i16 == R.drawable.cej) {
            this.H.sendPokeMsg(this.C, bVar);
            ReportController.o(this.f258965e, "CliOper", "", j3, "0X8007F22", "0X8007F22", 3, 0, "", "", "", "");
        } else if (i16 == R.drawable.cei) {
            if (this.R == 0) {
                this.R = SystemClock.currentThreadTimeMillis();
            } else if (SystemClock.currentThreadTimeMillis() - this.R < 500) {
                return;
            } else {
                this.R = SystemClock.currentThreadTimeMillis();
            }
            this.R = SystemClock.currentThreadTimeMillis();
            this.H.sendPokeMsg(this.C, bVar);
            ReportController.o(this.f258965e, "CliOper", "", j3, "0X8007F22", "0X8007F22", 5, 0, "", "", "", "");
        } else if (i16 == R.drawable.cdp) {
            if (this.S == 0) {
                this.S = SystemClock.currentThreadTimeMillis();
            } else if (SystemClock.currentThreadTimeMillis() - this.S < 500) {
                return;
            } else {
                this.S = SystemClock.currentThreadTimeMillis();
            }
            this.H.sendPokeMsg(this.C, bVar);
            ReportController.o(this.f258965e, "CliOper", "", j3, "0X8007F22", "0X8007F22", 6, 0, "", "", "", "");
        }
        if (126 == i3) {
            if (bundle.getBoolean("isShowLoading")) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.PokePanel", 2, "poke item is downloading, do nothing");
                    return;
                }
                return;
            }
            boolean z16 = true;
            if (bundle.getBoolean("isShowDownload")) {
                this.f258966f.d(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX, i16, true, false);
                QQVasUpdateBusiness e16 = f.e();
                if (e16 == null) {
                    z16 = false;
                }
                IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) this.f258965e.getRuntimeService(IVasQuickUpdateService.class, "");
                if (!f.v("effect.gif", i16)) {
                    String str = VasUpdateConstants.SCID_POKE_PANEL_PREFIX + i16;
                    if (z16) {
                        e16.addDownLoadListener(str, new c(str));
                        e16.startDownload(str);
                    } else {
                        iVasQuickUpdateService.downloadItem(21L, VasUpdateConstants.SCID_POKE_PANEL_PREFIX + i16, "clickDownload");
                    }
                }
                if (z16) {
                    String str2 = VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + i16;
                    e16.addDownLoadListener(str2, new d(str2));
                    e16.startDownload(str2);
                    return;
                }
                iVasQuickUpdateService.downloadItem(21L, VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + i16, "clickDownload");
                iVasQuickUpdateService.addCallBacker(this.J);
                return;
            }
            if (!f.N) {
                f.N = true;
                W.d((AppInterface) this.f258965e, i16, string, i17, string2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(UpdateListenerParams updateListenerParams, String str) {
        if (this.J != null && TextUtils.equals(updateListenerParams.mBusinessUpdateParams.mScid, str)) {
            BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
            this.J.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
        }
    }

    @Override // com.tencent.mobileqq.poke.ClickedWaveView.a
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.D = true;
        }
    }

    @Override // com.tencent.mobileqq.poke.ClickedWaveView.a
    public void a(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        if (!this.E) {
            v(bundle);
        }
        this.E = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.G) {
            return;
        }
        this.G = true;
        try {
            this.f258969m.removeCallbacksAndMessages(null);
            this.f258968i.quit();
            this.f258968i = null;
            ArrayList<i> c16 = this.f258966f.c();
            if (c16 != null && c16.size() > 0) {
                Iterator<i> it = c16.iterator();
                while (it.hasNext()) {
                    Drawable drawable = it.next().f259067b;
                    if (drawable instanceof CustomFrameAnimationDrawable) {
                        ((CustomFrameAnimationDrawable) drawable).g();
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d("Q.aio.PokePanel", 1, "ondestroy err " + e16);
        }
        ((AppInterface) this.f258965e).removeObserver(this.V);
        ((IVasQuickUpdateService) this.f258965e.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.J);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onDetachedFromWindow();
            onDestroy();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) absListView, i3);
        } else if (i3 != 0 && this.D) {
            this.E = true;
        } else {
            this.E = false;
        }
    }

    public void p(AppRuntime appRuntime, String str, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, aVar);
            return;
        }
        this.f258965e = appRuntime;
        this.C = aVar;
        ListView listView = (ListView) findViewById(R.id.d_r);
        this.f258964d = listView;
        listView.setOnScrollListener(this);
        ((AppInterface) this.f258965e).addObserver(this.V);
        this.f258967h = str;
        this.H = (IPokeSendHelper) QRoute.api(IPokeSendHelper.class);
        n();
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        ArrayList<int[]> arrayList = this.I;
        if (arrayList == null) {
            this.I = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        ArrayList arrayList2 = new ArrayList();
        if (this.f258968i == null) {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("PokePanelAnimThread", 0);
            this.f258968i = newFreeHandlerThread;
            newFreeHandlerThread.start();
            this.f258969m = new MqqHandler(this.f258968i.getLooper());
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.PokePanel", 2, "[pokepanel]reload()");
        }
        g gVar = new g(BaseApplication.getContext());
        this.f258966f = gVar;
        gVar.e(this);
        this.f258966f.f(this);
        this.f258964d.setAdapter((ListAdapter) this.f258966f);
        ThreadManager.getFileThreadHandler().post(new Runnable(str, arrayList2) { // from class: com.tencent.mobileqq.poke.NTPokePanel.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f258971d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList f258972e;

            {
                this.f258971d = str;
                this.f258972e = arrayList2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, NTPokePanel.this, str, arrayList2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.PokePanel", 2, "[pokepanel]start parsing config");
                }
                NTPokePanel.this.r(this.f258971d);
                NTPokePanel.this.s(this.f258972e);
                NTPokePanel nTPokePanel = NTPokePanel.this;
                this.f258972e.addAll(nTPokePanel.t(nTPokePanel.f258965e, NTPokePanel.this.J));
                if (this.f258972e.size() > 0) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.poke.NTPokePanel.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.aio.PokePanel", 2, "[pokepanel]update UI start");
                            }
                            NTPokePanel.this.f258966f.a(AnonymousClass2.this.f258972e);
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.aio.PokePanel", 2, "[pokepanel]update UI end");
                            }
                        }
                    });
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.PokePanel", 2, "[pokepanel] parsing config end");
                }
            }
        });
    }

    public NTPokePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = new CallBacker() { // from class: com.tencent.mobileqq.poke.NTPokePanel.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTPokePanel.this);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
            
                if (r11 != 0) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
            
                r1 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
            
                r2 = r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
            
                if (r11 != 0) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
                String str4;
                String substring;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z16 = true;
                boolean z17 = false;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (j3 == 21) {
                    if (str.equals(VasUpdateConstants.SCID_POKE_EFFECT_LIST) && i3 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.aio.PokePanel", 2, "download vas poke list, refresh now.");
                        }
                        ThreadManager.getUIHandler().post(new Runnable(NTPokePanel.this.f258965e) { // from class: com.tencent.mobileqq.poke.NTPokePanel.5.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ AppRuntime f258975d;

                            {
                                this.f258975d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    NTPokePanel.this.u(f.h(this.f258975d));
                                }
                            }
                        });
                    } else {
                        str4 = VasUpdateConstants.SCID_POKE_PANEL_PREFIX;
                        if (str.startsWith(VasUpdateConstants.SCID_POKE_PANEL_PREFIX)) {
                            substring = str.substring(17, str.length());
                        } else {
                            str4 = VasUpdateConstants.SCID_POKE_EFFECT_PREFIX;
                            if (str.startsWith(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX)) {
                                substring = str.substring(14, str.length());
                            }
                        }
                        if (TextUtils.isEmpty(str4)) {
                            ThreadManager.getUIHandler().post(new Runnable(str4, substring, z17) { // from class: com.tencent.mobileqq.poke.NTPokePanel.5.2
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f258977d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ String f258978e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ boolean f258979f;

                                {
                                    this.f258977d = str4;
                                    this.f258978e = substring;
                                    this.f258979f = z17;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass5.this, str4, substring, Boolean.valueOf(z17));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        NTPokePanel.this.f258966f.d(this.f258977d, Integer.valueOf(this.f258978e).intValue(), false, this.f258979f);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    str4 = "";
                    substring = "";
                    if (TextUtils.isEmpty(str4)) {
                    }
                }
            }
        };
        this.K = new int[]{R.string.ihf, R.drawable.cej, 3};
        this.L = new int[]{R.string.cxi, R.drawable.cdo, 1};
        this.M = new int[]{R.string.f170999bk0, R.drawable.cdm, 2};
        this.N = new int[]{R.string.bp7, R.drawable.ceh, 4};
        this.P = new int[]{R.string.bpe, R.drawable.cei, 5};
        this.Q = new int[]{R.string.bni, R.drawable.cdp, 6};
        this.R = 0L;
        this.S = 0L;
        this.T = -1;
        this.U = 1;
        this.V = new e();
    }
}
