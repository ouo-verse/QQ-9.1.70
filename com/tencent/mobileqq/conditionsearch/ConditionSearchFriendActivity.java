package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.service.LBSInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.conditionsearch.widget.b;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.aw;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.t;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QBidirectionalSeekBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.LocationSelectorView;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConditionSearchFriendActivity extends IphoneTitleBarActivity implements View.OnClickListener, View.OnTouchListener, aw.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d1, reason: collision with root package name */
    private static final int f201877d1;

    /* renamed from: e1, reason: collision with root package name */
    private static final int f201878e1;

    /* renamed from: f1, reason: collision with root package name */
    private static final int f201879f1;

    /* renamed from: g1, reason: collision with root package name */
    private static int f201880g1;

    /* renamed from: h1, reason: collision with root package name */
    private static int f201881h1;
    View A0;
    private LinearLayout B0;
    private QBidirectionalSeekBar C0;
    private TextView D0;
    private View E0;
    private LocationSelectorView F0;
    private Dialog G0;
    private final int H0;
    boolean I0;
    boolean J0;
    boolean K0;
    private boolean L0;
    private boolean M0;
    String N0;
    BaseAddress O0;
    Object[] P0;
    int Q0;
    BaseAddress[] R0;
    int[] S0;
    String[] T0;
    private List<BaseAddress> U0;
    Handler V0;
    QQProgressDialog W0;
    int X0;
    ConditionSearchManager.e Y0;
    ConditionSearchManager.c Z0;

    /* renamed from: a0, reason: collision with root package name */
    ConditionSearchManager f201882a0;

    /* renamed from: a1, reason: collision with root package name */
    bh f201883a1;

    /* renamed from: b0, reason: collision with root package name */
    private aw f201884b0;

    /* renamed from: b1, reason: collision with root package name */
    private final QBidirectionalSeekBar.b f201885b1;

    /* renamed from: c0, reason: collision with root package name */
    String f201886c0;

    /* renamed from: c1, reason: collision with root package name */
    private final LocationSelectorView.e f201887c1;

    /* renamed from: d0, reason: collision with root package name */
    volatile int f201888d0;

    /* renamed from: e0, reason: collision with root package name */
    volatile int f201889e0;

    /* renamed from: f0, reason: collision with root package name */
    volatile int f201890f0;

    /* renamed from: g0, reason: collision with root package name */
    volatile int f201891g0;

    /* renamed from: h0, reason: collision with root package name */
    volatile int f201892h0;

    /* renamed from: i0, reason: collision with root package name */
    volatile int f201893i0;

    /* renamed from: j0, reason: collision with root package name */
    volatile int f201894j0;

    /* renamed from: k0, reason: collision with root package name */
    EditText f201895k0;

    /* renamed from: l0, reason: collision with root package name */
    private ImageButton f201896l0;

    /* renamed from: m0, reason: collision with root package name */
    boolean f201897m0;

    /* renamed from: n0, reason: collision with root package name */
    FormSimpleItem f201898n0;

    /* renamed from: o0, reason: collision with root package name */
    FormSimpleItem f201899o0;

    /* renamed from: p0, reason: collision with root package name */
    FormSimpleItem f201900p0;

    /* renamed from: q0, reason: collision with root package name */
    FormSimpleItem f201901q0;

    /* renamed from: r0, reason: collision with root package name */
    Button f201902r0;

    /* renamed from: s0, reason: collision with root package name */
    TextView f201903s0;

    /* renamed from: t0, reason: collision with root package name */
    TextView f201904t0;

    /* renamed from: u0, reason: collision with root package name */
    TextView f201905u0;

    /* renamed from: v0, reason: collision with root package name */
    TextView f201906v0;

    /* renamed from: w0, reason: collision with root package name */
    View f201907w0;

    /* renamed from: x0, reason: collision with root package name */
    View f201908x0;

    /* renamed from: y0, reason: collision with root package name */
    View f201909y0;

    /* renamed from: z0, reason: collision with root package name */
    View f201910z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity$11, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass11 implements LocationSelectorView.g {
        static IPatchRedirector $redirector_;

        AnonymousClass11() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.g
        public void a(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), strArr);
            } else if (z16 && strArr != null && strArr.length >= 4) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(strArr) { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.11.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String[] f201912d;

                    {
                        this.f201912d = strArr;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this, (Object) strArr);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.d("ConditionSearchFriendActivity", 2, "onLocationStrUpdate: " + Arrays.toString(this.f201912d));
                        if (!ConditionSearchFriendActivity.this.N0.equals(this.f201912d[0])) {
                            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                            conditionSearchFriendActivity.N0 = this.f201912d[0];
                            conditionSearchFriendActivity.l3(true);
                            ConditionSearchFriendActivity.this.F0.A(ConditionSearchFriendActivity.this.O0);
                        }
                        ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
                        conditionSearchFriendActivity2.T0 = this.f201912d;
                        LocationSelectorView locationSelectorView = conditionSearchFriendActivity2.F0;
                        ConditionSearchFriendActivity conditionSearchFriendActivity3 = ConditionSearchFriendActivity.this;
                        locationSelectorView.z(conditionSearchFriendActivity3.T0, conditionSearchFriendActivity3.O0.name, conditionSearchFriendActivity3.f201882a0.R(conditionSearchFriendActivity3.d3(false, false)));
                        ConditionSearchFriendActivity conditionSearchFriendActivity4 = ConditionSearchFriendActivity.this;
                        FormSimpleItem formSimpleItem = conditionSearchFriendActivity4.f201898n0;
                        if (formSimpleItem != null) {
                            formSimpleItem.setRightText(conditionSearchFriendActivity4.f201882a0.R(conditionSearchFriendActivity4.d3(true, true)));
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.11.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    ConditionSearchFriendActivity.this.A3();
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        }, 64, null, false);
                    }
                });
            } else {
                QLog.e("ConditionSearchFriendActivity", 1, "OnLocationUpdate fail");
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.g
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity$12, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass12 implements LocationSelectorView.e {
        static IPatchRedirector $redirector_;

        AnonymousClass12() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.e
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!ConditionSearchFriendActivity.this.isFinishing()) {
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                if (conditionSearchFriendActivity.app != null) {
                    conditionSearchFriendActivity.checkAndEnableLbs(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.12.1
                        static IPatchRedirector $redirector_;

                        /* compiled from: P */
                        /* renamed from: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity$12$1$a */
                        /* loaded from: classes5.dex */
                        class a extends QQPermission.BasePermissionsListener {
                            static IPatchRedirector $redirector_;

                            a() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                            public void onAllGranted() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    super.onAllGranted();
                                    ConditionSearchFriendActivity.this.x3();
                                }
                            }

                            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                            public void onDenied(List<String> list, List<Integer> list2) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                                    return;
                                }
                                super.onDenied(list, list2);
                                if (ConditionSearchFriendActivity.this.F0 != null) {
                                    ConditionSearchFriendActivity.this.F0.o();
                                }
                            }
                        }

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass12.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                if (ConditionSearchFriendActivity.this.isFinishing()) {
                                    return;
                                }
                                QQPermissionFactory.getQQPermission(ConditionSearchFriendActivity.this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CONDITION_SEARCH, QQPermissionConstants.Business.SCENE.CONDITION_SEARCH_LOCATION)).requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, new a());
                            }
                        }
                    });
                }
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (ConditionSearchFriendActivity.this.F0 != null) {
                ConditionSearchFriendActivity.this.F0.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity$16, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass16 implements LocationSelectorView.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocationSelectorView f201918a;

        AnonymousClass16(LocationSelectorView locationSelectorView) {
            this.f201918a = locationSelectorView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this, (Object) locationSelectorView);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.g
        public void a(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), strArr);
            } else if (z16 && strArr != null && strArr.length >= 4) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(strArr) { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.16.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String[] f201920d;

                    {
                        this.f201920d = strArr;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass16.this, (Object) strArr);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.d("ConditionSearchFriendActivity", 2, "onLocationStrUpdate: " + Arrays.toString(this.f201920d));
                        String str = ConditionSearchFriendActivity.this.N0;
                        if (str != null && !str.equals(this.f201920d[0])) {
                            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                            conditionSearchFriendActivity.N0 = this.f201920d[0];
                            conditionSearchFriendActivity.l3(false);
                            AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                            anonymousClass16.f201918a.A(ConditionSearchFriendActivity.this.O0);
                        }
                        AnonymousClass16 anonymousClass162 = AnonymousClass16.this;
                        ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
                        String[] strArr2 = this.f201920d;
                        conditionSearchFriendActivity2.T0 = strArr2;
                        anonymousClass162.f201918a.z(strArr2, conditionSearchFriendActivity2.O0.name, conditionSearchFriendActivity2.f201882a0.R(conditionSearchFriendActivity2.d3(false, false)));
                        ConditionSearchFriendActivity conditionSearchFriendActivity3 = ConditionSearchFriendActivity.this;
                        FormSimpleItem formSimpleItem = conditionSearchFriendActivity3.f201899o0;
                        if (formSimpleItem != null) {
                            formSimpleItem.setRightText(conditionSearchFriendActivity3.f201882a0.R(conditionSearchFriendActivity3.d3(true, true)));
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.16.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    ConditionSearchFriendActivity.this.z3();
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        }, 64, null, false);
                    }
                });
            } else {
                QLog.e("ConditionSearchFriendActivity", 1, "OnLocationUpdate fail");
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.g
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements QActionSheet.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.b f201924d;

        a(com.tencent.mobileqq.widget.selectorview.b bVar) {
            this.f201924d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            ConditionSearchFriendActivity.this.f201891g0 = this.f201924d.o();
            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
            FormSimpleItem formSimpleItem = conditionSearchFriendActivity.f201901q0;
            if (formSimpleItem != null) {
                formSimpleItem.setRightText(com.tencent.mobileqq.widget.selectorview.b.f317391h[conditionSearchFriendActivity.f201891g0]);
            }
            ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
            ConditionSearchManager conditionSearchManager = conditionSearchFriendActivity2.f201882a0;
            if (conditionSearchManager != null) {
                conditionSearchManager.b0(conditionSearchFriendActivity2.f201891g0);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f201926d;

        b(Runnable runnable) {
            this.f201926d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this, (Object) runnable);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                if (!ConditionSearchFriendActivity.this.isLbsEnabled()) {
                    if (ConditionSearchFriendActivity.this.f201887c1 != null) {
                        ConditionSearchFriendActivity.this.f201887c1.b();
                        return;
                    }
                    return;
                }
                this.f201926d.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ConditionSearchFriendActivity.this.G0 != null && ConditionSearchFriendActivity.this.G0.isShowing()) {
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                conditionSearchFriendActivity.e3(conditionSearchFriendActivity.G0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (ConditionSearchFriendActivity.this.app != null) {
                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(ConditionSearchFriendActivity.this.app.getAccount(), true);
                }
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                conditionSearchFriendActivity.e3(conditionSearchFriendActivity.G0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EditText editText = ConditionSearchFriendActivity.this.f201895k0;
                if (editText != null) {
                    editText.setText("");
                }
                ConditionSearchFriendActivity.this.showInputMethod();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            } else {
                ConditionSearchFriendActivity.this.f201897m0 = true;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int i18;
            int i19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (charSequence != null) {
                i18 = charSequence.length();
            } else {
                i18 = 0;
            }
            if (ConditionSearchFriendActivity.this.f201896l0 != null) {
                ImageButton imageButton = ConditionSearchFriendActivity.this.f201896l0;
                if (i18 > 0) {
                    i19 = 0;
                } else {
                    i19 = 8;
                }
                imageButton.setVisibility(i19);
            }
            if (i18 > 11) {
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                if (conditionSearchFriendActivity.f201895k0 != null) {
                    QQToast.makeText(conditionSearchFriendActivity, "\u6635\u79f0\u9650\u5ea6\u4e3a11\u5b57\uff0c\u8bf7\u4fee\u6539\u540e\u91cd\u8bd5\u3002", 0).show();
                    Editable text = ConditionSearchFriendActivity.this.f201895k0.getText();
                    if (text == null) {
                        return;
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    ConditionSearchFriendActivity.this.f201895k0.setText(charSequence.subSequence(0, 11));
                    Editable text2 = ConditionSearchFriendActivity.this.f201895k0.getText();
                    if (selectionEnd > text2.length()) {
                        selectionEnd = text2.length();
                    }
                    Selection.setSelection(text2, selectionEnd);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g extends Handler {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 1000) {
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                int i3 = conditionSearchFriendActivity.X0;
                if (i3 == 1 || i3 == 2) {
                    conditionSearchFriendActivity.dismissWaittingDialog();
                    QQToast.makeText(ConditionSearchFriendActivity.this, R.string.a8c, 0).show(ConditionSearchFriendActivity.this.getTitleBarHeight());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h implements ConditionSearchManager.e {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.e
        public void a(boolean z16, List<CondFitUser> list, boolean z17, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Boolean.valueOf(z17), Integer.valueOf(i3));
                return;
            }
            ConditionSearchFriendActivity.this.dismissWaittingDialog();
            if (i3 != 1) {
                return;
            }
            if (!z16) {
                QQToast.makeText(ConditionSearchFriendActivity.this, R.string.f170773a81, 0).show(ConditionSearchFriendActivity.this.getTitleBarHeight());
            } else if (list != null && !list.isEmpty()) {
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                SearchResultActivity.Q2(conditionSearchFriendActivity, conditionSearchFriendActivity.f201886c0, conditionSearchFriendActivity.f201889e0, ConditionSearchFriendActivity.this.f201890f0, ConditionSearchFriendActivity.this.f201888d0, ConditionSearchFriendActivity.this.f201882a0.B(), ConditionSearchFriendActivity.this.f201882a0.z(), ConditionSearchFriendActivity.this.f201892h0, ConditionSearchFriendActivity.this.f201891g0, list, z17);
            } else {
                QQToast.makeText(ConditionSearchFriendActivity.this, R.string.f170777a84, 0).show(ConditionSearchFriendActivity.this.getTitleBarHeight());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class i implements ConditionSearchManager.c {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearchFriendActivity", 2, "onGetConfig | mDialogType = " + ConditionSearchFriendActivity.this.X0 + ", isSuccess = " + z16 + ", resultCode = " + i3);
            }
            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
            int i16 = conditionSearchFriendActivity.X0;
            if (i16 == 1 || i16 == 2) {
                if (!z16) {
                    conditionSearchFriendActivity.dismissWaittingDialog();
                    QQToast.makeText(ConditionSearchFriendActivity.this, R.string.a8c, 0).show(ConditionSearchFriendActivity.this.getTitleBarHeight());
                } else if (i3 == 2) {
                    conditionSearchFriendActivity.dismissWaittingDialog();
                    ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
                    conditionSearchFriendActivity2.C3(conditionSearchFriendActivity2.X0);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class j extends bh {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bh
        public void onGetUserLocation(boolean z16, LBSInfo lBSInfo) {
            String[] strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), lBSInfo);
                return;
            }
            if (z16) {
                strArr = lBSInfo.a();
            } else {
                strArr = null;
            }
            if (strArr == null || strArr.length != 4) {
                strArr = new String[]{"-1", "-1", "-1", "-1"};
            }
            if ("-1".equals(strArr[0])) {
                return;
            }
            ConditionSearchFriendActivity.this.f201882a0.U(strArr);
            String Q = ConditionSearchFriendActivity.this.f201882a0.Q(strArr);
            ConditionSearchFriendActivity.this.f201882a0.Y(0, Q);
            ConditionSearchFriendActivity.this.f201882a0.X(strArr);
            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
            conditionSearchFriendActivity.f201898n0.setRightText(conditionSearchFriendActivity.f201882a0.R(Q));
            if (!ConditionSearchFriendActivity.this.N0.equals(strArr[0])) {
                ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
                conditionSearchFriendActivity2.N0 = strArr[0];
                conditionSearchFriendActivity2.l3(true);
                if (ConditionSearchFriendActivity.this.F0 != null) {
                    ConditionSearchFriendActivity.this.F0.A(ConditionSearchFriendActivity.this.O0);
                }
            }
            ConditionSearchFriendActivity conditionSearchFriendActivity3 = ConditionSearchFriendActivity.this;
            conditionSearchFriendActivity3.T0 = strArr;
            if (conditionSearchFriendActivity3.F0 != null) {
                ConditionSearchFriendActivity.this.F0.o();
                LocationSelectorView locationSelectorView = ConditionSearchFriendActivity.this.F0;
                ConditionSearchFriendActivity conditionSearchFriendActivity4 = ConditionSearchFriendActivity.this;
                locationSelectorView.z(conditionSearchFriendActivity4.T0, conditionSearchFriendActivity4.O0.name, conditionSearchFriendActivity4.f201882a0.R(conditionSearchFriendActivity4.d3(false, false)));
            }
            ConditionSearchFriendActivity conditionSearchFriendActivity5 = ConditionSearchFriendActivity.this;
            conditionSearchFriendActivity5.J0 = true;
            conditionSearchFriendActivity5.K0 = false;
            conditionSearchFriendActivity5.v3();
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearchFriendActivity", 2, "onGetUserLocation|isSuccess : " + z16 + ", mIsFirstReqLocation : " + ConditionSearchFriendActivity.this.I0 + ", locationCodes[0] : " + strArr[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class k implements QBidirectionalSeekBar.b {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QBidirectionalSeekBar.b
        public void onChange(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QLog.d("ConditionSearchFriendActivity", 2, "age change: [" + i3 + ", " + i16 + "]");
            if (!ConditionSearchFriendActivity.this.C0.k()) {
                QLog.d("ConditionSearchFriendActivity", 2, "age change is invalid: [" + i3 + ", " + i16 + "]");
                return;
            }
            ConditionSearchFriendActivity.this.f201889e0 = i3;
            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
            if (i16 < 99) {
                i17 = i16;
            }
            conditionSearchFriendActivity.f201890f0 = i17;
            ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
            ConditionSearchManager conditionSearchManager = conditionSearchFriendActivity2.f201882a0;
            if (conditionSearchManager != null) {
                conditionSearchManager.T(conditionSearchFriendActivity2.f201889e0, ConditionSearchFriendActivity.this.f201890f0);
            }
            ConditionSearchFriendActivity.this.D3(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class l implements b.c {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.b.c
        public void onUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            ConditionSearchFriendActivity.this.f201892h0 = i3;
            ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
            ConditionSearchManager conditionSearchManager = conditionSearchFriendActivity.f201882a0;
            if (conditionSearchManager != null) {
                conditionSearchManager.W(conditionSearchFriendActivity.f201892h0);
            }
            ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
            FormSimpleItem formSimpleItem = conditionSearchFriendActivity2.f201900p0;
            if (formSimpleItem != null) {
                String[] strArr = ConditionSearchManager.f194488p0;
                formSimpleItem.setRightText(strArr[conditionSearchFriendActivity2.f201892h0]);
                if (AppSetting.f99565y) {
                    ConditionSearchFriendActivity.this.f201900p0.setContentDescription(HardCodeUtil.qqStr(R.string.kxz) + strArr[ConditionSearchFriendActivity.this.f201892h0]);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f201877d1 = Color.parseColor("#00CEFF");
        f201878e1 = Color.parseColor("#0099FF");
        f201879f1 = Color.parseColor("#0066CC");
    }

    public ConditionSearchFriendActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f201897m0 = false;
        this.H0 = 20;
        this.I0 = false;
        this.J0 = true;
        this.K0 = true;
        this.L0 = false;
        this.M0 = false;
        this.V0 = new g();
        this.X0 = 0;
        this.Y0 = new h();
        this.Z0 = new i();
        this.f201883a1 = new j();
        this.f201885b1 = new k();
        this.f201887c1 = new AnonymousClass12();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3() {
        String[] strArr;
        if (this.O0 != null && (strArr = this.T0) != null && strArr.length == 4) {
            this.f201882a0.Y(0, d3(true, true));
            this.f201882a0.X(this.T0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3(int i3, int i16) {
        Object valueOf;
        if (this.D0 == null) {
            return;
        }
        String valueOf2 = String.valueOf(i3);
        if (i16 >= 99) {
            valueOf = "99+";
        } else {
            valueOf = Integer.valueOf(i16);
        }
        String valueOf3 = String.valueOf(valueOf);
        if (i3 != i16) {
            valueOf3 = valueOf2 + "-" + valueOf3;
        }
        this.D0.setText(valueOf3);
        if (j3()) {
            AccessibilityUtil.n(this.E0, true);
            AccessibilityUtil.s(this.E0, HardCodeUtil.qqStr(R.string.a85) + valueOf3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E3() {
        int i3;
        int i16;
        if (this.C0 != null) {
            if (this.f201889e0 == 0) {
                i3 = 18;
            } else {
                i3 = this.f201889e0;
            }
            if (this.f201890f0 == 0) {
                i16 = 99;
            } else {
                i16 = this.f201890f0;
            }
            int max = Math.max(i16, i3);
            this.C0.v(i3, max);
            D3(i3, max);
        }
    }

    private void F3(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = f201881h1;
        } else {
            i3 = f201880g1;
        }
        view.setBackgroundResource(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3() {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (this.f201888d0 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f201888d0 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f201888d0 == 1) {
            z18 = true;
        }
        this.f201909y0.setSelected(z16);
        this.f201907w0.setSelected(z17);
        this.f201908x0.setSelected(z18);
        F3(this.f201909y0, z16);
        F3(this.f201907w0, z17);
        F3(this.f201908x0, z18);
        if (AppSetting.f99565y) {
            this.f201909y0.setContentDescription(HardCodeUtil.qqStr(R.string.kyb));
            this.f201908x0.setContentDescription(HardCodeUtil.qqStr(R.string.f171781ky4));
            this.f201907w0.setContentDescription(HardCodeUtil.qqStr(R.string.ky9));
        }
    }

    private void Z2() {
        f201880g1 = R.drawable.kpe;
        f201881h1 = R.drawable.kph;
        if (QQTheme.isNowThemeIsNight()) {
            LinearLayout linearLayout = this.B0;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.ljx);
            }
            EditText editText = this.f201895k0;
            if (editText != null) {
                editText.setBackgroundResource(R.drawable.ljx);
            }
            f201880g1 = R.drawable.kpf;
            f201881h1 = R.drawable.kpg;
            View view = this.f201907w0;
            if (view != null) {
                view.setBackgroundResource(R.drawable.kpf);
                this.f201903s0.setTextColor(-1);
            }
            View view2 = this.f201908x0;
            if (view2 != null) {
                view2.setBackgroundResource(f201880g1);
                this.f201904t0.setTextColor(-1);
            }
            View view3 = this.f201909y0;
            if (view3 != null) {
                view3.setBackgroundResource(f201880g1);
                this.f201905u0.setTextColor(-1);
            }
            TextView textView = this.D0;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.qui_common_brand_standard));
                return;
            }
            return;
        }
        if (QQTheme.isNowSimpleUI()) {
            f201880g1 = R.drawable.kpi;
            f201881h1 = R.drawable.kpj;
            View view4 = this.f201907w0;
            if (view4 != null) {
                view4.setBackgroundResource(R.drawable.kpi);
            }
            View view5 = this.f201908x0;
            if (view5 != null) {
                view5.setBackgroundResource(f201880g1);
            }
            View view6 = this.f201909y0;
            if (view6 != null) {
                view6.setBackgroundResource(f201880g1);
            }
            TextView textView2 = this.D0;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.qui_common_brand_standard));
            }
        }
    }

    private String c3(boolean z16) {
        BaseAddress baseAddress;
        BaseAddress baseAddress2;
        StringBuilder sb5 = new StringBuilder();
        if (!"0".equals(this.N0) && (baseAddress = this.O0) != null) {
            if (z16) {
                sb5.append(baseAddress.name);
                sb5.append("-");
            }
            for (int i3 = 0; i3 < this.Q0; i3++) {
                BaseAddress[] baseAddressArr = this.R0;
                if (baseAddressArr != null && (baseAddress2 = baseAddressArr[i3]) != null && !"0".equals(baseAddress2.code)) {
                    sb5.append(this.R0[i3].name);
                    sb5.append("-");
                }
            }
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        return sb6.substring(0, sb6.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d3(boolean z16, boolean z17) {
        String[] N;
        String str;
        String[] strArr = this.T0;
        if (strArr != null && strArr.length == 4 && this.f201882a0 != null) {
            String[] strArr2 = new String[strArr.length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            if (!z17 && this.T0.length > 3) {
                strArr2[3] = "0";
            }
            if ((!z16 && "0".equals(this.T0[1])) || (N = this.f201882a0.N(strArr2)) == null) {
                return IProfileCardConst.NAME_NO_LIMIT;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            for (int i3 = 0; i3 < N.length; i3++) {
                if (!TextUtils.isEmpty(N[i3]) && (z16 || i3 != 0)) {
                    if (sb5.toString().isEmpty()) {
                        str = "";
                    } else {
                        str = "-";
                    }
                    sb5.append(str);
                    sb5.append(N[i3]);
                }
            }
            return sb5.toString();
        }
        QLog.e("ConditionSearchFriendActivity", 2, "createLocationStringByCodes return empty");
        return IProfileCardConst.NAME_NO_LIMIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(Dialog dialog) {
        try {
            try {
                dialog.dismiss();
            } catch (Exception e16) {
                QLog.e("ConditionSearchFriendActivity", 2, "dialogDismiss error", e16);
            }
        } finally {
            sy3.a.a(dialog);
        }
    }

    private void f3(int i3, boolean z16) {
        if (!z16) {
            h3(i3);
            i3();
        }
        if (i3 == 1) {
            if (IProfileCardConst.NAME_NO_LIMIT.equals(this.f201898n0.d().getText())) {
                this.f201898n0.setRightText(this.f201882a0.R(c3(true)));
            }
            t3();
        } else if (i3 == 2) {
            if (IProfileCardConst.NAME_NO_LIMIT.equals(this.f201899o0.d().getText())) {
                this.f201899o0.setRightText(this.f201882a0.R(c3(true)));
            }
            r3();
        }
    }

    private int g3(ArrayList<? extends BaseAddress> arrayList, String str) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).code.equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    private void h3(int i3) {
        String[] strArr;
        if (i3 == 1) {
            strArr = this.f201882a0.B();
            String str = strArr[0];
            this.N0 = str;
            if (str.equals("0")) {
                strArr = this.f201882a0.y();
                String str2 = strArr[0];
                this.N0 = str2;
                if (str2.equals("0")) {
                    this.N0 = "1";
                }
            }
        } else if (i3 == 2) {
            strArr = this.f201882a0.z();
            String str3 = strArr[0];
            this.N0 = str3;
            if (str3.equals("0")) {
                this.N0 = "1";
            }
        } else {
            strArr = null;
        }
        this.T0 = new String[]{"0", "0", "0", "0"};
        if (strArr != null) {
            int length = strArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                this.T0[i16] = strArr[i16];
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "initLocationCode|type : " + i3 + ", mLocationCountyCode : " + this.N0);
        }
    }

    private void i3() {
        String str;
        if ("0".equals(this.N0) || "-1".equals(this.N0)) {
            this.N0 = "1";
        }
        this.O0 = this.f201882a0.w(this.N0);
        this.U0 = this.f201882a0.x();
        BaseAddress baseAddress = this.O0;
        if (baseAddress != null) {
            int columnNember = baseAddress.getColumnNember();
            this.Q0 = columnNember;
            this.P0 = new Object[columnNember];
            this.R0 = new BaseAddress[columnNember];
            this.S0 = new int[columnNember];
            if (columnNember == 0) {
                return;
            }
            BaseAddress baseAddress2 = this.O0;
            int length = this.T0.length;
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                if (!"0".equals(this.T0[i16])) {
                    Object[] objArr = this.P0;
                    if (i3 >= objArr.length) {
                        break;
                    }
                    objArr[i3] = baseAddress2.getDataList();
                    BaseAddress[] baseAddressArr = this.R0;
                    baseAddress2 = baseAddress2.dataMap.get(this.T0[i16]);
                    baseAddressArr[i3] = baseAddress2;
                    this.S0[i3] = g3((ArrayList) this.P0[i3], this.T0[i16]);
                    i3++;
                    if (baseAddress2 == null) {
                        return;
                    }
                }
            }
            if (i3 < this.Q0) {
                this.P0[i3] = baseAddress2.getDataList();
                this.R0[i3] = baseAddress2.dataMap.get(0);
                this.S0[i3] = 0;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initLocationData|mLocationColumCount : ");
            sb5.append(this.Q0);
            sb5.append(", mLocationCountry.name : ");
            BaseAddress baseAddress3 = this.O0;
            if (baseAddress3 == null) {
                str = "null";
            } else {
                str = baseAddress3.name;
            }
            sb5.append(str);
            QLog.d("ConditionSearchFriendActivity", 2, sb5.toString());
        }
    }

    private void initUI() {
        this.I0 = getIntent().getBooleanExtra("key_first_req_location", false);
        this.f201882a0 = (ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        this.L0 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
        ImageButton imageButton = this.f201896l0;
        if (imageButton != null) {
            imageButton.setOnClickListener(new e());
        }
        TextView textView = this.f201905u0;
        if (textView != null && this.L0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.o17, 0, 0, 0);
        }
        this.D0 = (TextView) findViewById(R.id.u3q);
        QBidirectionalSeekBar qBidirectionalSeekBar = this.C0;
        if (qBidirectionalSeekBar != null) {
            qBidirectionalSeekBar.n(18, 99, this.f201885b1);
        }
        if (j3()) {
            this.E0 = findViewById(R.id.u3p);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchFriendActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ConditionSearchFriendActivity conditionSearchFriendActivity = ConditionSearchFriendActivity.this;
                conditionSearchFriendActivity.f201888d0 = conditionSearchFriendActivity.f201882a0.D();
                int[] q16 = ConditionSearchFriendActivity.this.f201882a0.q();
                ConditionSearchFriendActivity.this.f201889e0 = q16[0];
                ConditionSearchFriendActivity.this.f201890f0 = q16[1];
                ConditionSearchFriendActivity conditionSearchFriendActivity2 = ConditionSearchFriendActivity.this;
                conditionSearchFriendActivity2.f201893i0 = conditionSearchFriendActivity2.u3(q16[0]);
                ConditionSearchFriendActivity conditionSearchFriendActivity3 = ConditionSearchFriendActivity.this;
                conditionSearchFriendActivity3.f201894j0 = conditionSearchFriendActivity3.u3(q16[1]);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            ConditionSearchFriendActivity.this.G3();
                            ConditionSearchFriendActivity.this.E3();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        });
        this.f201891g0 = this.f201882a0.E();
        this.f201892h0 = this.f201882a0.A();
        int i3 = this.f201892h0;
        int[] iArr = ConditionSearchManager.f194492t0;
        if (i3 == iArr[0] || this.f201892h0 == iArr[1]) {
            this.f201892h0 = 0;
            this.f201882a0.W(this.f201892h0);
        }
        this.f201895k0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f201895k0.addTextChangedListener(new f());
        this.f201898n0 = (FormSimpleItem) findViewById(R.id.f164876b74);
        this.f201899o0 = (FormSimpleItem) findViewById(R.id.f164874b72);
        this.f201900p0 = (FormSimpleItem) findViewById(R.id.f164875b73);
        this.f201901q0 = (FormSimpleItem) findViewById(R.id.b75);
        this.f201902r0 = (Button) findViewById(R.id.b_a);
        this.f201907w0.setOnClickListener(this);
        this.f201907w0.setOnTouchListener(this);
        this.f201908x0.setOnClickListener(this);
        this.f201908x0.setOnTouchListener(this);
        this.f201909y0.setOnClickListener(this);
        this.f201909y0.setOnTouchListener(this);
        this.f201900p0.setVisibility(0);
        this.f201900p0.setLeftIcon(null);
        this.f201900p0.setLeftText(getResources().getString(R.string.a88));
        FormSimpleItem formSimpleItem = this.f201900p0;
        String[] strArr = ConditionSearchManager.f194488p0;
        formSimpleItem.setRightText(strArr[this.f201892h0]);
        if (AppSetting.f99565y) {
            this.f201900p0.setContentDescription(HardCodeUtil.qqStr(R.string.ky5) + strArr[this.f201892h0]);
        }
        this.f201900p0.setOnClickListener(this);
        this.f201898n0.setLeftIcon(null);
        this.f201898n0.setLeftText(getResources().getString(R.string.a89));
        String C = this.f201882a0.C(0);
        String R = this.f201882a0.R(C);
        FormSimpleItem formSimpleItem2 = this.f201898n0;
        boolean equals = "0".equals(R);
        String str = IProfileCardConst.NAME_NO_LIMIT;
        if (equals) {
            R = IProfileCardConst.NAME_NO_LIMIT;
        }
        formSimpleItem2.setRightText(R);
        if (AppSetting.f99565y) {
            this.f201898n0.setContentDescription(HardCodeUtil.qqStr(R.string.kxx) + C);
        }
        this.f201898n0.setOnClickListener(this);
        this.f201899o0.setLeftIcon(null);
        this.f201899o0.setLeftText(getResources().getString(R.string.a87));
        String C2 = this.f201882a0.C(1);
        String R2 = this.f201882a0.R(C2);
        FormSimpleItem formSimpleItem3 = this.f201899o0;
        if (!"0".equals(R2)) {
            str = R2;
        }
        formSimpleItem3.setRightText(str);
        if (AppSetting.f99565y) {
            this.f201899o0.setContentDescription(HardCodeUtil.qqStr(R.string.kya) + C2);
        }
        this.f201899o0.setOnClickListener(this);
        this.f201901q0.setLeftIcon(null);
        this.f201901q0.setLeftText(getResources().getString(R.string.a8b));
        FormSimpleItem formSimpleItem4 = this.f201901q0;
        String[] strArr2 = ConditionSearchManager.f194487o0;
        formSimpleItem4.setRightText(strArr2[this.f201891g0]);
        if (AppSetting.f99565y) {
            this.f201901q0.setContentDescription(HardCodeUtil.qqStr(R.string.f171777ky0) + strArr2[this.f201891g0]);
        }
        this.f201901q0.setOnClickListener(this);
        this.f201902r0.setOnClickListener(this);
        if (AppSetting.f99565y) {
            this.f201902r0.setContentDescription(getString(R.string.f170787aa1));
        }
        SimpleModeHelper.i(this.f201902r0);
        G3();
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "init|mIsFirstReqLocation : " + this.I0 + ", locDesc : " + C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLbsEnabled() {
        return ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).isObtainLocAllowed(this.app.getAccount());
    }

    private boolean j3() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("android_8956_bug_feature");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(boolean z16) {
        TextView textView;
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "onCountryChanged | codes = " + this.N0);
        }
        BaseAddress w3 = this.f201882a0.w(this.N0);
        this.O0 = w3;
        if (w3 == null) {
            return;
        }
        int columnNember = w3.getColumnNember();
        y3();
        if (columnNember > 0 && columnNember <= 3 && (textView = this.f201906v0) != null) {
            textView.setText(this.O0.name);
        }
        if (z16) {
            this.f201898n0.setRightText(this.O0.name);
        } else {
            this.f201899o0.setRightText(this.O0.name);
        }
    }

    private void n3(View view, MotionEvent motionEvent) {
        if (view == null) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            view.setAlpha(0.7f);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            view.setAlpha(1.0f);
        }
    }

    private void p3() {
        com.tencent.mobileqq.widget.selectorview.b bVar = new com.tencent.mobileqq.widget.selectorview.b(this, this.L0);
        bVar.p(this.f201891g0);
        if (bVar.e() == null) {
            bVar.i(new a(bVar));
        }
        bVar.m();
    }

    private void r3() {
        BaseAddress baseAddress = this.O0;
        if (baseAddress == null) {
            QLog.e("ConditionSearchFriendActivity", 1, "popUpHomeLandSelectorView fail, BaseAddress=null, countryCode=" + this.N0);
            return;
        }
        LocationSelectorView locationSelectorView = new LocationSelectorView(baseAddress, this.U0, false, this.L0);
        locationSelectorView.p(this, this.app, new AnonymousClass16(locationSelectorView), null);
        String R = this.f201882a0.R(d3(false, true));
        FormSimpleItem formSimpleItem = this.f201899o0;
        if (formSimpleItem != null) {
            if (IProfileCardConst.NAME_NO_LIMIT.equals(R)) {
                R = this.O0.name;
            }
            formSimpleItem.setRightText(R);
        }
        locationSelectorView.B(this.T0, this.O0.name, this.f201882a0.R(d3(false, false)));
        locationSelectorView.x();
        z3();
    }

    private void s3() {
        new com.tencent.mobileqq.conditionsearch.widget.b(this, this.f201892h0, new l()).show();
    }

    private void showEnableLbsDialog(Runnable runnable) {
        b bVar = new b(runnable);
        Dialog a16 = t.a(this, R.string.zn6, R.string.zn5, R.string.f170775zn4, R.string.f170774zn3, new c(), new d());
        this.G0 = a16;
        a16.setOnDismissListener(bVar);
        try {
            if (!isFinishing()) {
                this.G0.show();
            }
        } catch (Exception e16) {
            QLog.e("ConditionSearchFriendActivity", 1, "action sheet show error", e16);
        }
    }

    private void t3() {
        BaseAddress baseAddress = this.O0;
        if (baseAddress == null) {
            QLog.e("ConditionSearchFriendActivity", 1, "popUpHomeLandSelectorView fail, BaseAddress=null, countryCode=" + this.N0);
            return;
        }
        this.F0 = new LocationSelectorView(baseAddress, this.U0, true, this.L0);
        this.F0.p(this, this.app, new AnonymousClass11(), this.f201887c1);
        String R = this.f201882a0.R(d3(false, true));
        FormSimpleItem formSimpleItem = this.f201898n0;
        if (formSimpleItem != null) {
            if (IProfileCardConst.NAME_NO_LIMIT.equals(R)) {
                R = this.O0.name;
            }
            formSimpleItem.setRightText(R);
        }
        this.F0.B(this.T0, this.O0.name, this.f201882a0.R(d3(false, false)));
        this.F0.x();
        A3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u3(int i3) {
        if ((i3 >= 0 && i3 <= 17) || i3 <= 17) {
            return 0;
        }
        return i3 - 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3() {
        ConditionSearchManager conditionSearchManager;
        String[] strArr = this.T0;
        if (strArr != null && strArr.length >= 4) {
            if (!this.N0.equals(strArr[0])) {
                this.N0 = this.T0[0];
                l3(true);
            }
            FormSimpleItem formSimpleItem = this.f201898n0;
            if (formSimpleItem != null && (conditionSearchManager = this.f201882a0) != null) {
                formSimpleItem.setRightText(conditionSearchManager.R(d3(true, true)));
            }
        }
    }

    private void w3(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_search", "seachFriend | restart = keyword = " + this.f201886c0 + " | sexIndex = " + this.f201888d0 + " | ageIndex1 = " + this.f201889e0 + " | ageIndex2 = " + this.f201890f0 + " | jobIndex = " + this.f201892h0 + " | xingzuoIndex = " + this.f201891g0 + " | location = " + this.f201882a0.C(0) + " | hometown = " + this.f201882a0.C(1));
        com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_search", "dt_clck", hashMap);
        ReportController.o(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3() {
        LBSHandler lBSHandler;
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, R.string.f171139ci4, 0).show();
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && (lBSHandler = (LBSHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)) != null) {
            lBSHandler.J2();
        }
    }

    private void y3() {
        this.S0 = null;
        this.R0 = null;
        this.P0 = null;
        this.Q0 = 0;
        this.T0 = new String[]{"0", "0", "0", "0"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z3() {
        String[] strArr;
        if (this.O0 != null && (strArr = this.T0) != null && strArr.length == 4) {
            this.f201882a0.Y(1, d3(true, true));
            this.f201882a0.V(this.T0);
        }
    }

    void B3(int i3, String str) {
        this.X0 = i3;
        if (this.W0 == null) {
            this.W0 = new QQProgressDialog(this, getTitleBarHeight());
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "showWaitingDialog | type = " + i3 + ", str = " + str + ", dlg=" + this.W0);
        }
        this.W0.setMessage(str);
        this.W0.show();
    }

    void C3(int i3) {
        int j3 = this.f201882a0.j();
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|checkUpdate result = " + j3);
        }
        boolean z16 = false;
        if (j3 != 0) {
            int h06 = this.f201882a0.h0(j3, true);
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|update updateResult = " + h06);
            }
            if (h06 == 2) {
                QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
                return;
            } else if (h06 == 0) {
                B3(i3, getString(R.string.a8f));
                this.f201882a0.g(this.Z0);
                return;
            } else {
                B3(i3, getString(R.string.a8f));
                this.V0.sendEmptyMessageDelayed(1000, 20000L);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|type : " + i3 + ", mNeedInitLocation" + this.K0 + ", mNeedInitHome : " + this.J0 + ", mLocationColumCount : " + this.Q0 + ", mLocationCountyCode : " + this.N0);
        }
        if (i3 == 1) {
            if (this.K0) {
                h3(1);
                i3();
                this.K0 = false;
                this.J0 = true;
                z16 = true;
            }
            f3(i3, z16);
            return;
        }
        if (i3 == 2) {
            if (this.J0) {
                h3(2);
                i3();
                this.J0 = false;
                this.K0 = true;
                z16 = true;
            }
            f3(i3, z16);
        }
    }

    void b3() {
        if (this.f201897m0) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
            this.f201897m0 = false;
        }
    }

    protected void checkAndEnableLbs(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        } else if (isLbsEnabled()) {
            runnable.run();
        } else {
            showEnableLbsDialog(runnable);
        }
    }

    void dismissWaittingDialog() {
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog | type = " + this.W0);
        }
        QQProgressDialog qQProgressDialog = this.W0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.X0 = 0;
            this.W0.dismiss();
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog dismiss");
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        this.mNeedStatusTrans = !isInMultiWindow();
        ca.a(this);
        super.doOnCreate(bundle);
        this.mNeedStatusTrans = true;
        setContentView(R.layout.asu);
        View findViewById = findViewById(R.id.root);
        this.f201910z0 = findViewById;
        findViewById.setOnTouchListener(this);
        com.tencent.mobileqq.conditionsearch.datareport.a.b(this, this.f201910z0, "pg_searching_people", null);
        aw awVar = new aw(super.findViewById(R.id.root));
        this.f201884b0 = awVar;
        awVar.a(this);
        EditText editText = (EditText) findViewById(R.id.f165112bz0);
        this.f201895k0 = editText;
        editText.setCursorVisible(false);
        this.f201895k0.clearFocus();
        this.f201896l0 = (ImageButton) findViewById(R.id.xcl);
        this.B0 = (LinearLayout) findViewById(R.id.f59242s7);
        this.f201907w0 = findViewById(R.id.csr);
        this.f201908x0 = findViewById(R.id.cst);
        this.f201909y0 = findViewById(R.id.csp);
        this.f201903s0 = (TextView) findViewById(R.id.c9z);
        this.f201904t0 = (TextView) findViewById(R.id.em5);
        this.f201905u0 = (TextView) findViewById(R.id.t9f);
        this.A0 = findViewById(R.id.dlj);
        this.C0 = (QBidirectionalSeekBar) findViewById(R.id.u3r);
        setContentBackgroundResource(R.drawable.bg_texture);
        setTitle(R.string.a7y);
        this.f201882a0 = (ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        initUI();
        Z2();
        addObserver(this.f201883a1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        b3();
        super.doOnDestroy();
        this.V0.removeCallbacksAndMessages(null);
        this.f201882a0.o(this);
        this.f201882a0.S(this.Z0);
        this.f201882a0.S(this.Y0);
        removeObserver(this.f201883a1);
        EditText editText = this.f201895k0;
        if (editText != null) {
            editText.setFocusable(false);
            this.f201895k0.setFocusableInTouchMode(false);
            this.f201895k0.setVisibility(8);
            if (this.f201895k0.getParent() != null) {
                ((ViewGroup) this.f201895k0.getParent()).removeView(this.f201895k0);
            }
            this.f201895k0.setOnEditorActionListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnStart();
        ConditionSearchManager conditionSearchManager = this.f201882a0;
        if (conditionSearchManager != null) {
            conditionSearchManager.h(this);
        }
    }

    public void hideInputMethod() {
        InputMethodManager inputMethodManager;
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.M0 && (inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null && (editText = this.f201895k0) != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            this.f201895k0.clearFocus();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            b3();
            int id5 = view.getId();
            if (id5 == R.id.b_a) {
                if (!u.a().b()) {
                    w3(view);
                    if (!NetworkUtil.isNetSupport(this)) {
                        QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
                    } else {
                        this.f201886c0 = this.f201895k0.getText().toString();
                        String[] B = this.f201882a0.B();
                        String[] z16 = this.f201882a0.z();
                        this.f201882a0.g(this.Y0);
                        this.f201882a0.c0(true, this.f201886c0, this.f201888d0, this.f201889e0, this.f201890f0, B, z16, this.f201892h0, this.f201891g0, 1);
                        B3(3, getString(R.string.a8g));
                    }
                }
            } else if (id5 == R.id.f164875b73) {
                if (!u.a().b()) {
                    com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_job", "dt_clck", null);
                    s3();
                }
            } else if (id5 == R.id.f164874b72) {
                if (!u.a().b()) {
                    com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_hometown", "dt_clck", null);
                    ReportController.o(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
                    C3(2);
                }
            } else if (id5 == R.id.f164876b74) {
                if (!u.a().b()) {
                    com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_location", "dt_clck", null);
                    this.I0 = false;
                    this.f201882a0.i();
                    ReportController.o(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
                    C3(1);
                }
            } else if (id5 == R.id.b75) {
                if (!u.a().b()) {
                    com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_horoscope", "dt_clck", null);
                    p3();
                }
            } else if (id5 == R.id.csr) {
                com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_sex", "dt_clck", null);
                this.f201888d0 = 2;
                G3();
                this.f201882a0.a0(this.f201888d0);
                ReportController.o(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.f201888d0 + "", "", "", "");
            } else if (id5 == R.id.cst) {
                com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_sex", "dt_clck", null);
                this.f201888d0 = 1;
                G3();
                this.f201882a0.a0(this.f201888d0);
                ReportController.o(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.f201888d0 + "", "", "", "");
            } else if (id5 == R.id.csp) {
                com.tencent.mobileqq.conditionsearch.datareport.a.a(view, "em_searching_people_sex", "dt_clck", null);
                this.f201888d0 = 0;
                G3();
                this.f201882a0.a0(this.f201888d0);
                ReportController.o(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.f201888d0 + "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.M0 = false;
        EditText editText = this.f201895k0;
        if (editText != null) {
            editText.setCursorVisible(false);
        }
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardOpened(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.conditionsearch.datareport.a.a(this.f201895k0, "em_searching_people_keyword", "dt_clck", null);
        this.M0 = true;
        EditText editText = this.f201895k0;
        if (editText != null) {
            editText.setCursorVisible(true);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        int id5 = view.getId();
        if (id5 != R.id.f165112bz0 && id5 != R.id.xcl) {
            if (id5 == R.id.csp || id5 == R.id.csr || id5 == R.id.cst) {
                n3(view, motionEvent);
            }
            hideInputMethod();
        }
        return false;
    }

    public void showInputMethod() {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && (editText = this.f201895k0) != null) {
            inputMethodManager.showSoftInput(editText, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public void showStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!isInMultiWindow()) {
            super.showStatusBar();
        }
    }
}
