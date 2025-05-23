package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.FollowedSearchFragment;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.fragment.RecommendFriendFragment;
import com.tencent.mobileqq.search.fragment.UniteSearchFragment;
import com.tencent.mobileqq.search.m;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.MmkvKeys;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ab;
import com.tencent.mobileqq.search.util.ac;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.search.util.aw;
import com.tencent.mobileqq.search.util.t;
import com.tencent.mobileqq.search.util.x;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import tencent.im.oidb.search.DynamicTabSearch$SubHotWord;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ActiveEntitySearchActivity extends QBaseActivity implements TextView.OnEditorActionListener, TextWatcher, m, nn2.b, AssociateSearchWordsFragment.d, aw.a, AutoHintLayout.b {
    private static List<v> E0 = null;
    public static boolean F0 = true;
    public static boolean G0 = false;
    private boolean B0;
    private boolean C0;

    /* renamed from: b0, reason: collision with root package name */
    protected QuickPinyinEditText f282638b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f282639c0;

    /* renamed from: d0, reason: collision with root package name */
    protected ImageView f282640d0;

    /* renamed from: e0, reason: collision with root package name */
    protected ImageView f282641e0;

    /* renamed from: f0, reason: collision with root package name */
    protected QUISearchBar f282642f0;

    /* renamed from: g0, reason: collision with root package name */
    protected FragmentManager f282643g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ActiveEntitySearchFragment f282644h0;

    /* renamed from: i0, reason: collision with root package name */
    protected HotWordsForSubBussFragment f282645i0;

    /* renamed from: j0, reason: collision with root package name */
    protected RecommendFriendFragment f282646j0;

    /* renamed from: k0, reason: collision with root package name */
    protected AssociateSearchWordsFragment f282647k0;

    /* renamed from: l0, reason: collision with root package name */
    protected FollowedSearchFragment f282648l0;

    /* renamed from: m0, reason: collision with root package name */
    private AutoHintLayout f282649m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f282650n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f282651o0;

    /* renamed from: p0, reason: collision with root package name */
    View f282652p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f282653q0;

    /* renamed from: r0, reason: collision with root package name */
    public long[] f282654r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f282655s0;

    /* renamed from: t0, reason: collision with root package name */
    protected String f282656t0;

    /* renamed from: u0, reason: collision with root package name */
    protected String f282657u0;

    /* renamed from: x0, reason: collision with root package name */
    private volatile boolean f282660x0;

    /* renamed from: y0, reason: collision with root package name */
    private volatile boolean f282661y0;

    /* renamed from: a0, reason: collision with root package name */
    private String f282637a0 = "";

    /* renamed from: v0, reason: collision with root package name */
    private int f282658v0 = -1;

    /* renamed from: w0, reason: collision with root package name */
    private int f282659w0 = -1;

    /* renamed from: z0, reason: collision with root package name */
    public int f282662z0 = 1;
    private u60.c A0 = new u60.c();
    private AssociateSearchWordsFragment.f D0 = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements AssociateSearchWordsFragment.f {
        a() {
        }

        @Override // com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.f
        public void a() {
            ActiveEntitySearchActivity.this.N2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends ActionCallbackAdapter {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            ActiveEntitySearchActivity.this.r3("dt_clck");
            ActiveEntitySearchActivity.this.N2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements AssociateSearchWordsFragment.f {
        c() {
        }

        @Override // com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.f
        public void a() {
            ActiveEntitySearchActivity.this.N2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        this.f282656t0 = this.f282638b0.getText().toString().trim();
        String obj = this.f282638b0.getText().toString();
        String i3 = this.f282649m0.i();
        boolean z16 = true;
        if (this.f282653q0 != 1) {
            z16 = false;
        }
        if (!TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj.trim())) {
            QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.t66), 0).show();
        } else if (TextUtils.isEmpty(this.f282656t0) && ((!this.B0 && !z16) || TextUtils.isEmpty(i3) || TextUtils.equals(this.f282637a0, i3))) {
            QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.t66), 0).show();
        } else {
            this.f282650n0 = 5;
            this.f282662z0 = 3;
            A3();
        }
        hideInputMethod();
    }

    private void P2() {
        this.f282656t0 = this.f282638b0.getText().toString().trim();
        A3();
    }

    private void Q2(int i3) {
        FragmentTransaction beginTransaction = this.f282643g0.beginTransaction();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && this.f282643g0.findFragmentByTag("followed_search") != null) {
                            beginTransaction.hide(this.f282648l0);
                            beginTransaction.commitAllowingStateLoss();
                            return;
                        }
                        return;
                    }
                    if (this.f282643g0.findFragmentByTag("recommend_friend") != null) {
                        beginTransaction.hide(this.f282646j0);
                        beginTransaction.commitAllowingStateLoss();
                        return;
                    }
                    return;
                }
                if (this.f282643g0.findFragmentByTag(UniteSearchFragment.TAG_ASSOCIATED_WORDS) != null) {
                    beginTransaction.hide(this.f282647k0);
                    beginTransaction.commitAllowingStateLoss();
                    this.f282647k0.uh(null);
                    return;
                }
                return;
            }
            if (this.f282643g0.findFragmentByTag("hot_words") != null) {
                beginTransaction.hide(this.f282645i0);
                beginTransaction.commitAllowingStateLoss();
                return;
            }
            return;
        }
        if (this.f282643g0.findFragmentByTag("search_result") != null) {
            beginTransaction.hide(this.f282644h0);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private void S2() {
        int i3 = this.f282650n0;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 9) {
                    this.f282651o0 = 89;
                    return;
                } else {
                    this.f282651o0 = 82;
                    return;
                }
            }
            Intent intent = getIntent();
            this.f282651o0 = 89;
            if (intent != null) {
                this.f282651o0 = intent.getIntExtra(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 89);
                return;
            }
            return;
        }
        this.f282651o0 = 81;
    }

    private void U2() {
        findViewById(R.id.ik9).setVisibility(8);
        QUISearchBar qUISearchBar = (QUISearchBar) findViewById(R.id.search_box);
        this.f282642f0 = qUISearchBar;
        int i3 = 0;
        qUISearchBar.setVisibility(0);
        this.f282642f0.disableAutoFill();
        this.f282642f0.bindSearchChain(false);
        this.f282642f0.setActionCallback(new b());
        this.f282649m0 = this.f282642f0.getAutoHintLayout();
        this.f282638b0 = this.f282642f0.getInputWidget();
        this.f282640d0 = this.f282642f0.getClearView();
        this.f282639c0 = this.f282642f0.getCancelView();
        this.f282641e0 = this.f282642f0.getBackView();
        this.f282638b0.getInputExtras(true).putInt("QUICK_SEARCH", 1);
        w3();
        if (!TextUtils.isEmpty(this.f282656t0)) {
            if (this.f282656t0.length() > 50) {
                this.f282656t0 = this.f282656t0.substring(0, 50);
            }
            this.f282638b0.setText(this.f282656t0);
            this.f282638b0.setSelection(this.f282656t0.length());
            F0 = false;
        }
        this.f282638b0.addTextChangedListener(this);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("home_hint_words");
        s3();
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            i3 = 1;
        }
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            this.f282649m0.setHintList(stringArrayListExtra);
            this.f282649m0.setInterval(5000L);
            this.f282649m0.setAnimDuration(400);
            this.f282649m0.m(this);
            String stringExtra = getIntent().getStringExtra("default_hint_word");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f282637a0 = stringExtra;
            }
        }
        VideoReport.setElementParam(this.f282642f0, "is_shading", Integer.valueOf(i3));
        v3();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ActiveEntitySearchActivity.this.r3("dt_imp");
            }
        });
    }

    private boolean V2() {
        if (this.f282650n0 != 3 && !this.f282660x0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Y2(String str) {
        i3(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z2(boolean z16, String str, String str2) {
        if (V2()) {
            this.f282660x0 = true;
            u3(z16, str, str2);
        } else if (W2()) {
            this.f282661y0 = true;
            t3(z16, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3() {
        this.f282638b0.setText("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        if (((com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity) r8).f282650n0 == 9) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c3(Context context, String str, String str2, long[] jArr) {
        int i3;
        int i16 = 4;
        if (context instanceof UniteSearchActivity) {
            UniteSearchActivity uniteSearchActivity = (UniteSearchActivity) context;
            if (uniteSearchActivity.getCurrentPageType() == 1) {
                i16 = 3;
            } else if (uniteSearchActivity.getCurrentPageType() == 3) {
                i16 = 6;
            }
        } else {
            if (!(context instanceof PublicFragmentActivity)) {
                if (!(context instanceof ActiveEntitySearchActivity)) {
                    if (context instanceof SearchContactsActivity) {
                        i16 = 11;
                    }
                }
            }
            i3 = 9;
            d3(context, str, str2, jArr, i3, null);
        }
        i3 = i16;
        d3(context, str, str2, jArr, i3, null);
    }

    public static void d3(Context context, String str, String str2, long[] jArr, int i3, List<v> list) {
        Intent intent = new Intent(context, (Class<?>) ActiveEntitySearchActivity.class);
        intent.putExtra("group_name_string", str2);
        intent.putExtra("keyword", str);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, -1);
        intent.putExtra("group_mask_long_array", jArr);
        intent.putExtra("from_type_for_report", i3);
        if (list != null && !list.isEmpty()) {
            E0 = list;
        }
        startActivity(context, intent);
        if (i3 == 10 && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R.anim.f154454a3, 0);
        }
    }

    public static void e3(Context context, String str, long[] jArr, int i3, int i16, ArrayList<String> arrayList, String str2) {
        Intent intent = new Intent(context, (Class<?>) ActiveEntitySearchActivity.class);
        intent.putExtra("group_name_string", str);
        intent.putExtra("group_mask_long_array", jArr);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        intent.putExtra(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, i16);
        if (arrayList != null && !arrayList.isEmpty()) {
            intent.putStringArrayListExtra("home_hint_words", arrayList);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("default_hint_word", str2);
            }
        }
        startActivity(context, intent);
    }

    public static void f3(Context context, String str, long[] jArr, int i3, ArrayList<String> arrayList, String str2) {
        e3(context, str, jArr, i3, 89, arrayList, str2);
    }

    private void i3(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f282656t0 = str;
            this.f282638b0.removeTextChangedListener(this);
            this.f282638b0.setText(str);
            this.f282638b0.addTextChangedListener(this);
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onHistorySearchItemClick keyword=" + this.f282656t0);
            }
            this.f282638b0.setSelection(str.length());
            R2(false);
            this.f282650n0 = 12;
            A3();
            this.f282650n0 = 0;
        }
    }

    private void initView() {
        U2();
    }

    private void n3(boolean z16) {
        if (V2()) {
            this.A0.b(z16, "pg_search_more_result");
        } else if (W2()) {
            this.A0.b(z16, "pg_search_people_result");
        }
    }

    private void p3(String str) {
        if (this.f282658v0 != 1 && this.f282653q0 == 99) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_search_people_middle");
            VideoReport.reportEvent(str, this.f282638b0, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(String str) {
        if (this.f282658v0 != 1 && this.f282653q0 == 99) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_search_people_middle");
            VideoReport.reportEvent(str, this.f282639c0, hashMap);
        }
    }

    private static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
        if (intent.getLongArrayExtra("group_mask_long_array") == null && QLog.isDevelopLevel()) {
            throw new RuntimeException("startActivity. masks can not be null.");
        }
    }

    private void v3() {
        if (this.f282653q0 != 99) {
            return;
        }
        VideoReport.setElementId(this.f282638b0, "em_search_people_keyboard_search");
        QuickPinyinEditText quickPinyinEditText = this.f282638b0;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(quickPinyinEditText, clickPolicy);
        QuickPinyinEditText quickPinyinEditText2 = this.f282638b0;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(quickPinyinEditText2, exposurePolicy);
        VideoReport.setElementId(this.f282639c0, "em_search_people_top_search");
        VideoReport.setElementClickPolicy(this.f282639c0, clickPolicy);
        VideoReport.setElementExposePolicy(this.f282639c0, exposurePolicy);
    }

    private void w3() {
        String str = FunctionConfigManagerImpl.busiClueItemWordMap.get(FunctionConfigManagerImpl.convertGroupMaskToKey(this.f282654r0));
        if (!TextUtils.isEmpty(str)) {
            this.f282638b0.setHint(str);
        }
        if (!TextUtils.isEmpty(this.f282655s0)) {
            this.f282638b0.setHint("\u641c\u7d22" + this.f282655s0);
            return;
        }
        this.f282638b0.setHint(HardCodeUtil.qqStr(R.string.f211615la));
    }

    private boolean x3() {
        if (this.f282653q0 == 99) {
            return true;
        }
        return false;
    }

    private synchronized void y3(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "showFragment  fragment=" + i3);
        }
        if (i3 != this.f282658v0 && !isFinishing()) {
            if (this.C0 && i3 != 5) {
                P2();
                return;
            }
            this.f282658v0 = i3;
            FragmentTransaction beginTransaction = this.f282643g0.beginTransaction();
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                if (this.f282643g0.findFragmentByTag("followed_search") == null) {
                                    K2(i3);
                                }
                                beginTransaction.show(this.f282648l0);
                                beginTransaction.commitAllowingStateLoss();
                                Q2(2);
                                Q2(1);
                                Q2(3);
                                Q2(4);
                            }
                        } else {
                            if (this.f282643g0.findFragmentByTag("recommend_friend") == null) {
                                K2(i3);
                            }
                            beginTransaction.show(this.f282646j0);
                            beginTransaction.commitAllowingStateLoss();
                            Q2(2);
                            Q2(1);
                            Q2(3);
                            Q2(5);
                        }
                    } else {
                        if (this.f282643g0.findFragmentByTag(UniteSearchFragment.TAG_ASSOCIATED_WORDS) == null) {
                            K2(i3);
                        }
                        beginTransaction.show(this.f282647k0);
                        beginTransaction.commitAllowingStateLoss();
                        Q2(2);
                        Q2(1);
                        Q2(4);
                        Q2(5);
                    }
                } else {
                    if (this.f282643g0.findFragmentByTag("hot_words") == null) {
                        K2(i3);
                    }
                    beginTransaction.show(this.f282645i0);
                    beginTransaction.commitAllowingStateLoss();
                    Q2(3);
                    Q2(1);
                    Q2(4);
                    Q2(5);
                    SearchUtils.W0("sub_result", "exp_home", "", SearchUtils.e0(this.f282654r0), "", "");
                }
            } else {
                this.f282659w0 = this.f282658v0;
                if (this.f282643g0.findFragmentByTag("search_result") == null) {
                    K2(i3);
                }
                beginTransaction.show(this.f282644h0);
                beginTransaction.commitAllowingStateLoss();
                Q2(3);
                Q2(2);
                Q2(4);
                Q2(5);
            }
        }
    }

    private void z3(List<v> list) {
        this.A0.c();
        if (this.f282644h0 == null) {
            this.f282644h0 = h3();
        }
        this.f282644h0.Bh();
        ActiveEntitySearchFragment activeEntitySearchFragment = this.f282644h0;
        activeEntitySearchFragment.P = null;
        activeEntitySearchFragment.Qh(this.f282656t0, list);
        y3(1);
        this.f282657u0 = this.f282656t0;
        this.f282638b0.setCursorVisible(false);
        F0 = true;
        M2(true, this.f282656t0, "");
    }

    public void A3() {
        int i3;
        int i16 = 5;
        if (this.B0) {
            if (this.f282651o0 == 86) {
                i16 = 13;
                i3 = 2;
            } else {
                if (this.f282650n0 == 12) {
                    i16 = 22;
                }
                i3 = 3;
            }
            String str = this.f282656t0;
            if (TextUtils.isEmpty(str)) {
                str = this.f282649m0.i();
                this.f282656t0 = str;
                i16 = 27;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.i("Q.uniteSearch.ActiveEntitySearchActivity", 1, "startSearch  queryWord is empty");
            }
            SearchUtil.x((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), this, str, i16, i3);
            y3(4);
            if (ac.b()) {
                ab.h(MmkvKeys.MMKV_KEY_FIND_USER_AND_GROUP_SEARCH_HISTORY_KEY, str);
            }
            this.f282638b0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.activity.a
                @Override // java.lang.Runnable
                public final void run() {
                    ActiveEntitySearchActivity.this.b3();
                }
            }, 100L);
            return;
        }
        if (this.C0) {
            if (this.f282648l0 == null) {
                this.f282648l0 = g3();
            }
            this.f282648l0.uh();
            this.f282648l0.startSearch(this.f282656t0);
            y3(5);
            return;
        }
        this.A0.c();
        if (this.f282644h0 == null) {
            this.f282644h0 = h3();
        }
        this.f282644h0.Bh();
        ActiveEntitySearchFragment activeEntitySearchFragment = this.f282644h0;
        activeEntitySearchFragment.P = null;
        activeEntitySearchFragment.startSearch(this.f282656t0);
        y3(1);
        this.f282657u0 = this.f282656t0;
        this.f282638b0.setCursorVisible(false);
        t.f(this.f282650n0, this.f282654r0, this.f282655s0, this.f282656t0);
    }

    void K2(int i3) {
        FragmentTransaction beginTransaction = this.f282643g0.beginTransaction();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            if (this.f282648l0 == null) {
                                this.f282648l0 = g3();
                            }
                            beginTransaction.add(R.id.ijj, this.f282648l0, "followed_search");
                            beginTransaction.commitAllowingStateLoss();
                            return;
                        }
                        return;
                    }
                    if (this.f282646j0 == null) {
                        RecommendFriendFragment recommendFriendFragment = new RecommendFriendFragment(this.f282653q0, this.f282651o0);
                        this.f282646j0 = recommendFriendFragment;
                        recommendFriendFragment.sh(new Function1() { // from class: com.tencent.mobileqq.search.activity.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit Y2;
                                Y2 = ActiveEntitySearchActivity.this.Y2((String) obj);
                                return Y2;
                            }
                        });
                    }
                    beginTransaction.add(R.id.ijj, this.f282646j0, "recommend_friend");
                    beginTransaction.commitAllowingStateLoss();
                    return;
                }
                if (this.f282647k0 == null) {
                    this.f282647k0 = new AssociateSearchWordsFragment();
                }
                this.f282647k0.wh(new c());
                beginTransaction.add(R.id.ijj, this.f282647k0, UniteSearchFragment.TAG_ASSOCIATED_WORDS);
                beginTransaction.commitAllowingStateLoss();
                return;
            }
            if (this.f282645i0 == null) {
                this.f282645i0 = new HotWordsForSubBussFragment();
                Bundle bundle = new Bundle();
                bundle.putLongArray("group_masks", this.f282654r0);
                bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, this.f282653q0);
                this.f282645i0.setArguments(bundle);
                beginTransaction.add(R.id.ijj, this.f282645i0, "hot_words");
                beginTransaction.commitAllowingStateLoss();
                return;
            }
            return;
        }
        if (this.f282644h0 == null) {
            this.f282644h0 = h3();
        }
        beginTransaction.add(R.id.ijj, this.f282644h0, "search_result");
        beginTransaction.commitAllowingStateLoss();
    }

    public boolean L2(long[] jArr, long j3) {
        if (jArr != null && jArr.length != 0) {
            for (long j16 : jArr) {
                if (j16 == j3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void M2(final boolean z16, final String str, final String str2) {
        n3(z16);
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                ActiveEntitySearchActivity.this.Z2(z16, str, str2);
            }
        });
    }

    public void R2(boolean z16) {
        if (z16) {
            this.f282638b0.clearFocus();
        }
        ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f282638b0.getWindowToken(), 0);
    }

    public boolean W2() {
        int i3;
        if (this.f282653q0 != 99 && (i3 = this.f282650n0) != 9 && i3 != 11 && i3 != 10 && !G0 && !this.f282661y0) {
            return false;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = this.f282638b0.getText().toString();
        int i3 = 2;
        if (this.f282638b0.isInputtingPinYin()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "\u6b63\u5728\u8f93\u5165\u62fc\u97f3\uff0c\u4e0d\u89e6\u53d1\u6587\u672c\u53d8\u52a8\u903b\u8f91\u3002 keyword=" + obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "afterTextChanged keyword=" + obj);
        }
        String trim = obj.trim();
        this.f282656t0 = trim;
        ActiveEntitySearchFragment activeEntitySearchFragment = this.f282644h0;
        if (activeEntitySearchFragment != null) {
            activeEntitySearchFragment.C = trim;
        }
        if (TextUtils.isEmpty(trim)) {
            if (x3()) {
                i3 = 4;
            }
            y3(i3);
            this.f282640d0.setVisibility(8);
            return;
        }
        this.f282640d0.setVisibility(0);
        y3(3);
        AssociateSearchWordsFragment associateSearchWordsFragment = this.f282647k0;
        if (associateSearchWordsFragment != null) {
            associateSearchWordsFragment.xh(trim);
            this.f282647k0.vh(0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        List<v> list;
        super.doOnActivityResult(i3, i16, intent);
        ActiveEntitySearchFragment activeEntitySearchFragment = this.f282644h0;
        if (activeEntitySearchFragment != null && (list = activeEntitySearchFragment.H) != null && list.size() <= 2) {
            new Handler(getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    ActiveEntitySearchActivity.this.f282638b0.requestFocus();
                    ((InputMethodManager) ActiveEntitySearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(ActiveEntitySearchActivity.this.f282638b0, 1);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        boolean z17 = false;
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1) {
            this.mActNeedImmersive = false;
        }
        ca.a(this);
        super.doOnCreate(bundle);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate start");
        super.setContentView(R.layout.b4e);
        VideoReport.addToDetectionWhitelist(this);
        View findViewById = super.findViewById(R.id.root);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1 && findViewById != null) {
            findViewById.setFitsSystemWindows(true);
        }
        this.f282652p0 = findViewById(R.id.ijj);
        this.f282653q0 = getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, -1);
        this.f282654r0 = getIntent().getLongArrayExtra("group_mask_long_array");
        int i3 = 4;
        this.f282650n0 = getIntent().getIntExtra("from_type_for_report", 4);
        S2();
        this.f282655s0 = getIntent().getStringExtra("group_name_string");
        this.f282656t0 = getIntent().getStringExtra("keyword");
        if (this.f282653q0 == 99) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.B0 = z16;
        if (L2(this.f282654r0, 1114L) || L2(this.f282654r0, 1115L) || L2(this.f282654r0, 1116L)) {
            z17 = true;
        }
        this.C0 = z17;
        initView();
        T2();
        FragmentManager supportFragmentManager = super.getSupportFragmentManager();
        this.f282643g0 = supportFragmentManager;
        if (bundle != null) {
            if (supportFragmentManager.findFragmentByTag("search_result") != null) {
                this.f282644h0 = (ActiveEntitySearchFragment) this.f282643g0.findFragmentByTag("search_result");
            }
            if (this.f282643g0.findFragmentByTag(UniteSearchFragment.TAG_ASSOCIATED_WORDS) != null) {
                AssociateSearchWordsFragment associateSearchWordsFragment = (AssociateSearchWordsFragment) this.f282643g0.findFragmentByTag(UniteSearchFragment.TAG_ASSOCIATED_WORDS);
                this.f282647k0 = associateSearchWordsFragment;
                associateSearchWordsFragment.wh(this.D0);
            }
            if (this.f282643g0.findFragmentByTag("hot_words") != null) {
                this.f282645i0 = (HotWordsForSubBussFragment) this.f282643g0.findFragmentByTag("hot_words");
            }
            if (this.f282643g0.findFragmentByTag("recommend_friend") != null) {
                this.f282646j0 = (RecommendFriendFragment) this.f282643g0.findFragmentByTag("recommend_friend");
            }
            if (this.f282643g0.findFragmentByTag("followed_search") != null) {
                this.f282648l0 = (FollowedSearchFragment) this.f282643g0.findFragmentByTag("followed_search");
            }
        }
        if (this.f282648l0 == null && this.C0) {
            this.f282648l0 = g3();
        }
        if (this.f282644h0 == null && !this.B0 && !this.C0) {
            this.f282644h0 = h3();
        }
        if (!TextUtils.isEmpty(this.f282656t0)) {
            List<v> list = E0;
            if (list != null) {
                z3(list);
                E0 = null;
            } else {
                A3();
            }
        } else {
            if (!x3()) {
                i3 = 2;
            }
            y3(i3);
            new Handler(getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ActiveEntitySearchActivity.this.f282638b0.requestFocus();
                    ((InputMethodManager) ActiveEntitySearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(ActiveEntitySearchActivity.this.f282638b0, 1);
                }
            }, 500L);
        }
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        QuickPinyinEditText quickPinyinEditText = this.f282638b0;
        if (quickPinyinEditText != null) {
            quickPinyinEditText.setOnEditorActionListener(null);
        }
        removeObserver();
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        t.a();
        ApngImage.pauseByTag(38);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        t.d(this.f282650n0, this.f282654r0, this.f282655s0, this.f282656t0);
        ApngImage.playByTag(38);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnResume");
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.f282650n0 == 10) {
            overridePendingTransition(0, R.anim.f154458a7);
            hideInputMethod();
        }
        E0 = null;
        if (this.f282650n0 == 9) {
            Intent intent = new Intent();
            intent.setAction("search_might_know_finish");
            sendBroadcast(intent);
        }
    }

    public FollowedSearchFragment g3() {
        Bundle bundle = new Bundle();
        long[] jArr = this.f282654r0;
        if (jArr != null && jArr.length > 0) {
            bundle.putLong("group_mask_long", jArr[0]);
        }
        bundle.putString("keyword", this.f282656t0);
        FollowedSearchFragment followedSearchFragment = new FollowedSearchFragment();
        followedSearchFragment.setArguments(bundle);
        return followedSearchFragment;
    }

    @Override // nn2.b
    public long[] getCurrentPageMasks() {
        ActiveEntitySearchFragment activeEntitySearchFragment = this.f282644h0;
        if (activeEntitySearchFragment == null) {
            return this.f282654r0;
        }
        return activeEntitySearchFragment.f283136l0;
    }

    @Override // nn2.b
    public int getCurrentPageType() {
        return 3;
    }

    @Override // nn2.b
    public QBaseFragment getCurrentSearchFragment() {
        return this.f282644h0;
    }

    @Override // com.tencent.mobileqq.search.m
    public double getLat() {
        return 0.0d;
    }

    @Override // com.tencent.mobileqq.search.m
    public double getLon() {
        return 0.0d;
    }

    @Override // nn2.b
    public String getSearchKeyword() {
        return this.f282638b0.getText().toString();
    }

    protected ActiveEntitySearchFragment h3() {
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, this.f282653q0);
        bundle.putInt("from_type_for_report", this.f282650n0);
        bundle.putLongArray("group_mask_long_array", this.f282654r0);
        bundle.putString("group_name_string", this.f282655s0);
        bundle.putString("keyword", this.f282656t0);
        bundle.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, this.f282651o0);
        return ActiveEntitySearchFragment.Mh(bundle);
    }

    public void hideInputMethod() {
        R2(true);
    }

    @Override // nn2.b
    public boolean isInitiativeSearch() {
        return false;
    }

    @Override // nn2.b
    public boolean isInputPinyin() {
        QuickPinyinEditText quickPinyinEditText = this.f282638b0;
        if (quickPinyinEditText == null) {
            return false;
        }
        return quickPinyinEditText.isInputtingPinYin();
    }

    public void j3(DynamicTabSearch$SubHotWord dynamicTabSearch$SubHotWord) {
        String stringUtf8 = dynamicTabSearch$SubHotWord.search_word.get().toStringUtf8();
        if (!TextUtils.isEmpty(stringUtf8)) {
            this.f282656t0 = stringUtf8;
            this.f282638b0.removeTextChangedListener(this);
            this.f282638b0.setText(stringUtf8);
            this.f282638b0.addTextChangedListener(this);
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onSubHotWordItemClick keyword=" + this.f282656t0);
            }
            this.f282638b0.setSelection(stringUtf8.length());
            R2(false);
            this.f282650n0 = 8;
            this.f282662z0 = 2;
            A3();
        }
    }

    public void l3(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f282638b0.setHint(str);
        } else {
            this.f282638b0.setHint(HardCodeUtil.qqStr(R.string.f171544j21));
        }
    }

    @Override // com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.d
    public void onAssociateWordClick(String str, int i3) {
        SearchUtils.W0("sub_result", "clk_auto", getSearchKeyword(), SearchUtils.e0(this.f282654r0), str, "" + i3);
        if (!TextUtils.isEmpty(str)) {
            this.f282656t0 = str;
            this.f282638b0.removeTextChangedListener(this);
            this.f282638b0.setText(str);
            this.f282638b0.addTextChangedListener(this);
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onAssociateWordClick keyword=" + this.f282656t0);
            }
            this.f282638b0.setSelection(str.length());
            R2(false);
            this.f282650n0 = 2;
            A3();
        }
        com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("subweb_search").action("clk_thinkword_list").obj1(SearchUtils.e0(this.f282654r0)).ver1(getSearchKeyword()).ver4(str).ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        boolean z16;
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            z16 = false;
        } else {
            p3("dt_clck");
            N2();
            z16 = true;
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z16;
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int i3, String str, String str2) {
        QuickPinyinEditText inputWidget = this.f282642f0.getInputWidget();
        HashMap hashMap = new HashMap();
        hashMap.put("literal_text", str);
        VideoReport.setElementId(inputWidget, "em_search_grey_word");
        VideoReport.setElementParams(inputWidget, hashMap);
        VideoReport.reportEvent("dt_imp", inputWidget, hashMap);
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardClosed() {
        int i3 = this.f282658v0;
        if (i3 != 3 && i3 != 4) {
            this.f282639c0.setVisibility(8);
            this.f282640d0.setVisibility(8);
            this.f282638b0.setCursorVisible(false);
        }
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardOpened(int i3) {
        int i16;
        this.f282638b0.setCursorVisible(true);
        if (F0 && isResume() && this.f282658v0 != 3) {
            String trim = this.f282638b0.getText().toString().trim();
            this.f282656t0 = trim;
            ActiveEntitySearchFragment activeEntitySearchFragment = this.f282644h0;
            if (activeEntitySearchFragment != null) {
                activeEntitySearchFragment.C = trim;
            }
            if (TextUtils.isEmpty(trim)) {
                if (x3()) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                y3(i16);
                this.f282640d0.setVisibility(8);
            } else {
                this.f282640d0.setVisibility(0);
                y3(3);
            }
            p3("dt_imp");
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        String obj = this.f282638b0.getText().toString();
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onTextChanged keyword=" + obj + " activity keyword=" + this.f282656t0);
        }
    }

    protected void removeObserver() {
        AutoHintLayout autoHintLayout = this.f282649m0;
        if (autoHintLayout != null) {
            autoHintLayout.u(this);
        }
    }

    public void s3() {
        QUISearchBar qUISearchBar = this.f282642f0;
        if (qUISearchBar != null) {
            VideoReport.setElementId(qUISearchBar, "em_search_people_search_column");
            QUISearchBar qUISearchBar2 = this.f282642f0;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            VideoReport.setElementExposePolicy(qUISearchBar2, exposurePolicy);
            QUISearchBar qUISearchBar3 = this.f282642f0;
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(qUISearchBar3, clickPolicy);
            QUISearchBar qUISearchBar4 = this.f282642f0;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            VideoReport.setElementEndExposePolicy(qUISearchBar4, endExposurePolicy);
            QuickPinyinEditText inputWidget = this.f282642f0.getInputWidget();
            VideoReport.setElementId(inputWidget, "em_search_grey_word");
            VideoReport.setElementClickPolicy(inputWidget, clickPolicy);
            VideoReport.setElementExposePolicy(inputWidget, exposurePolicy);
            VideoReport.setElementEndExposePolicy(inputWidget, endExposurePolicy);
        }
    }

    public void t3(boolean z16, String str, String str2) {
        if (!L2(this.f282654r0, 1001L)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("search_query", str);
        hashMap.put("search_query_text", str);
        hashMap.put("trace_id", x.k());
        hashMap.put("search_trace_id", str2);
        if (z16) {
            ai.j(this, findViewById(R.id.root), hashMap, G0);
        } else {
            ai.h(this, findViewById(R.id.root), hashMap);
        }
    }

    public void u3(boolean z16, String str, String str2) {
        String str3;
        if (L2(this.f282654r0, Constant.FROM_ID_START_ACTIVITY)) {
            str3 = String.valueOf(17);
        } else if (L2(this.f282654r0, 1001L)) {
            str3 = String.valueOf(8);
        } else if (L2(this.f282654r0, 1114L)) {
            str3 = String.valueOf(25);
        } else if (L2(this.f282654r0, 1115L)) {
            str3 = String.valueOf(26);
        } else if (L2(this.f282654r0, 1116L)) {
            str3 = String.valueOf(27);
        } else {
            str3 = "";
        }
        String str4 = str3;
        if (z16) {
            ai.i(this, findViewById(R.id.root), str4, "", str, str2);
        } else {
            ai.g(this, findViewById(R.id.root), str4, str, str2);
        }
        ImageView imageView = this.f282641e0;
        if (imageView != null) {
            ai.c(imageView);
        }
        TextView textView = this.f282639c0;
        if (textView != null) {
            ai.d(textView);
        }
        QuickPinyinEditText quickPinyinEditText = this.f282638b0;
        if (quickPinyinEditText != null) {
            ai.l(quickPinyinEditText);
        }
    }

    protected void T2() {
    }

    @Override // com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.d
    public void onAssociateWordInput(String str) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
