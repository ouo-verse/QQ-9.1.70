package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.CountdownTimeTask;
import com.tencent.mobileqq.rely.SingleLineHotwordTextView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.m;
import com.tencent.mobileqq.teamworkforgroup.b;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopTeamWorkFileSearchDialog extends ReportDialog implements Handler.Callback, m {

    /* renamed from: h0, reason: collision with root package name */
    public static int f292536h0 = 10;

    /* renamed from: i0, reason: collision with root package name */
    public static int f292537i0 = 16;
    protected XListView C;
    public GroupTeamWordkMoreView D;
    protected ViewGroup E;
    protected TextView F;
    protected TextView G;
    protected View H;
    protected ImageButton I;
    protected EditText J;
    protected RelativeLayout K;
    protected com.tencent.mobileqq.teamworkforgroup.e L;
    protected AppInterface M;
    protected Activity N;
    protected Handler P;
    protected CountdownTimeTask Q;
    protected boolean R;
    protected Object S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected String W;
    protected int X;
    protected boolean Y;
    protected int Z;

    /* renamed from: a0, reason: collision with root package name */
    protected long f292538a0;

    /* renamed from: b0, reason: collision with root package name */
    protected long f292539b0;

    /* renamed from: c0, reason: collision with root package name */
    protected IGroupTeamWorkHandler f292540c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f292541d0;

    /* renamed from: e0, reason: collision with root package name */
    protected List<GPadInfo> f292542e0;

    /* renamed from: f0, reason: collision with root package name */
    protected com.tencent.mobileqq.teamworkforgroup.g f292543f0;

    /* renamed from: g0, reason: collision with root package name */
    private Bitmap f292544g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TroopTeamWorkFileSearchDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        int f292553d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f292554e = 0;

        b() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            this.f292554e = i17;
            this.f292553d = ((i3 + i16) - 1) - 1;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public synchronized void onScrollStateChanged(AbsListView absListView, int i3) {
            TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog = TroopTeamWorkFileSearchDialog.this;
            if (troopTeamWorkFileSearchDialog.X > 0) {
                return;
            }
            if (i3 == 0 && troopTeamWorkFileSearchDialog.f292542e0 != null && this.f292553d == this.f292554e - 2) {
                if (troopTeamWorkFileSearchDialog.Y) {
                    troopTeamWorkFileSearchDialog.i0(true);
                } else {
                    troopTeamWorkFileSearchDialog.i0(false);
                    TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog2 = TroopTeamWorkFileSearchDialog.this;
                    troopTeamWorkFileSearchDialog2.Q(troopTeamWorkFileSearchDialog2.f292538a0, troopTeamWorkFileSearchDialog2.W, troopTeamWorkFileSearchDialog2.f292541d0, 50, 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                InputMethodUtil.hide(view);
                TroopTeamWorkFileSearchDialog.this.S();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PadInfo padInfo = (PadInfo) ((b.a) view.getTag()).f292582a;
            Bundle bundle = new Bundle();
            bundle.putString("url", TroopTeamWorkFileSearchDialog.P(padInfo.pad_url, "_bid=2517"));
            bundle.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, padInfo.type);
            bundle.putString(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_TITLE, padInfo.title);
            bundle.putString(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_SOURCE_URL, padInfo.pad_url);
            bundle.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_PAD_LIST_TYPE, padInfo.type_list);
            bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_GRPFILE);
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(TroopTeamWorkFileSearchDialog.this.N, bundle, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16;
            if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                z16 = false;
            } else {
                InputMethodUtil.hide(TroopTeamWorkFileSearchDialog.this.J);
                TroopTeamWorkFileSearchDialog.this.S();
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TroopTeamWorkFileSearchDialog.this.J.setText("");
            TroopTeamWorkFileSearchDialog.this.c0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TroopTeamWorkFileSearchDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class h extends com.tencent.mobileqq.teamworkforgroup.g {
        h() {
        }

        @Override // com.tencent.mobileqq.teamworkforgroup.g
        public void d(boolean z16, int i3, String str, List<GPadInfo> list, int i16, boolean z17) {
            Message obtainMessage;
            TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog = TroopTeamWorkFileSearchDialog.this;
            troopTeamWorkFileSearchDialog.X--;
            if (z16 && i3 == 0) {
                synchronized (troopTeamWorkFileSearchDialog.S) {
                    TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog2 = TroopTeamWorkFileSearchDialog.this;
                    List<GPadInfo> list2 = troopTeamWorkFileSearchDialog2.f292542e0;
                    if (list2 != null) {
                        list2.clear();
                    } else {
                        troopTeamWorkFileSearchDialog2.f292542e0 = new ArrayList();
                    }
                }
                TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog3 = TroopTeamWorkFileSearchDialog.this;
                troopTeamWorkFileSearchDialog3.f292541d0 = i16;
                troopTeamWorkFileSearchDialog3.Y = z17;
                if (list != null) {
                    troopTeamWorkFileSearchDialog3.Z = list.size();
                    synchronized (TroopTeamWorkFileSearchDialog.this.S) {
                        TroopTeamWorkFileSearchDialog.this.f292542e0.addAll(list);
                    }
                    TroopTeamWorkFileSearchDialog.this.P.sendMessage(TroopTeamWorkFileSearchDialog.this.P.obtainMessage(5));
                    return;
                }
            }
            TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog4 = TroopTeamWorkFileSearchDialog.this;
            if (troopTeamWorkFileSearchDialog4.T) {
                obtainMessage = troopTeamWorkFileSearchDialog4.P.obtainMessage(3);
            } else {
                obtainMessage = troopTeamWorkFileSearchDialog4.P.obtainMessage(5);
            }
            TroopTeamWorkFileSearchDialog.this.P.sendMessage(obtainMessage);
        }
    }

    public TroopTeamWorkFileSearchDialog(Activity activity, View view, AppInterface appInterface, long j3) {
        super(activity, R.style.f173640hx);
        this.P = null;
        this.Q = null;
        this.R = true;
        this.S = new Object();
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = "";
        this.X = 0;
        this.Y = false;
        this.Z = 0;
        this.f292538a0 = 0L;
        this.f292539b0 = 0L;
        this.f292542e0 = null;
        this.f292543f0 = new h();
        this.N = activity;
        this.M = appInterface;
        this.f292540c0 = (IGroupTeamWorkHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getGroupTeamWorkHandlerName());
        this.f292538a0 = j3;
        b0(activity);
        this.K = (RelativeLayout) findViewById(R.id.result_layout);
        this.C = (XListView) findViewById(R.id.search_result_list);
        this.E = (ViewGroup) findViewById(R.id.f166132ef4);
        this.F = (TextView) findViewById(R.id.ef6);
        this.G = (TextView) findViewById(R.id.kaf);
        this.H = findViewById(R.id.ayb);
        this.I = (ImageButton) findViewById(R.id.ib_clear_text);
        this.P = new Handler(this);
        a0();
        Y();
        Z(activity, appInterface);
        this.M.addObserver(this.f292543f0);
        g0(view);
    }

    public static String P(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains("#")) {
                String[] split = str.split("\\#");
                String str3 = split[0];
                int length = split.length;
                String str4 = "";
                for (int i3 = 1; i3 < length; i3++) {
                    str4 = str4 + "#" + split[i3];
                }
                if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    return str3.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER) + str4;
                }
                return str3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + str4;
            }
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER);
            }
            return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        return str;
    }

    private void Y() {
        this.I.setOnClickListener(new f());
        Button button = (Button) findViewById(R.id.btn_cancel_search);
        button.setVisibility(0);
        button.setOnClickListener(new g());
    }

    public final synchronized void Q(long j3, String str, int i3, int i16, int i17) {
        if (this.X > 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopTeamWorkFileSearchDialog", 4, "doReqTroopFileSearch err keyWord =" + str);
            }
        } else {
            this.f292539b0 = System.currentTimeMillis();
            this.X++;
            IGroupTeamWorkHandler iGroupTeamWorkHandler = this.f292540c0;
            if (iGroupTeamWorkHandler != null) {
                iGroupTeamWorkHandler.reqSearchGroupTeamWorkList(j3, str, i3, i16, i17);
            }
        }
    }

    protected synchronized void R(String str) {
        if (this.U) {
            return;
        }
        this.P.sendEmptyMessage(1);
        Q(this.f292538a0, str, 0, 50, 0);
    }

    protected void S() {
        if (this.G.getVisibility() != 0) {
            this.G.setText(X(this.Z));
            this.G.setVisibility(0);
            this.V = true;
            String W = W(this.J.getText().toString());
            if (!TextUtils.isEmpty(W)) {
                this.J.setText(W);
                this.J.setSelection(W.length());
            }
        }
    }

    protected float U() {
        float width = this.J.getWidth() - al.a(this.N, 20.0f);
        if (this.Z > 0) {
            width -= this.J.getPaint().measureText(X(this.Z)) + al.a(this.N, 16.0f);
        }
        if (this.I.getVisibility() == 0) {
            return width - (this.I.getWidth() + al.a(this.N, 8.0f));
        }
        return width;
    }

    protected String W(String str) {
        float U = U();
        TextPaint paint = this.J.getPaint();
        if (!TextUtils.isEmpty(str) && paint.measureText(str) > U) {
            return str.substring(0, paint.breakText(str, true, U - paint.measureText("\u2026"), null)) + "\u2026";
        }
        return str;
    }

    protected String X(int i3) {
        if (i3 > 1000) {
            return this.N.getString(R.string.ele);
        }
        return this.N.getString(R.string.elc, Integer.valueOf(i3));
    }

    protected void Z(Activity activity, AppInterface appInterface) {
        GroupTeamWordkMoreView groupTeamWordkMoreView = new GroupTeamWordkMoreView(activity);
        this.D = groupTeamWordkMoreView;
        groupTeamWordkMoreView.setBackgroundResource(R.drawable.bg_texture);
        this.D.setTextColor(activity.getResources().getColor(R.color.skin_black));
        this.C.addFooterView(this.D);
        this.D.setVisibility(8);
        com.tencent.mobileqq.teamworkforgroup.e eVar = new com.tencent.mobileqq.teamworkforgroup.e(this.M, this.N, this, this.P);
        this.L = eVar;
        this.C.setAdapter((ListAdapter) eVar);
        this.C.setOnScrollListener(new b());
        this.C.setOnTouchListener(new c());
        this.L.c(new d());
    }

    protected void a0() {
        EditText editText = (EditText) findViewById(R.id.et_search_keyword);
        this.J = editText;
        editText.setHint(this.N.getResources().getString(R.string.h_j));
        this.J.setImeOptions(3);
        this.J.setOnEditorActionListener(new e());
        this.J.addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj;
                TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog = TroopTeamWorkFileSearchDialog.this;
                if (troopTeamWorkFileSearchDialog.V) {
                    troopTeamWorkFileSearchDialog.V = false;
                    return;
                }
                if (editable == null) {
                    obj = "";
                } else {
                    obj = editable.toString();
                }
                if (obj.trim().equals("")) {
                    TroopTeamWorkFileSearchDialog.this.c0();
                    return;
                }
                TroopTeamWorkFileSearchDialog.this.I.setVisibility(0);
                if (!NetworkUtil.isNetworkAvailable(TroopTeamWorkFileSearchDialog.this.N)) {
                    CountdownTimeTask countdownTimeTask = TroopTeamWorkFileSearchDialog.this.Q;
                    if (countdownTimeTask != null) {
                        countdownTimeTask.h();
                        TroopTeamWorkFileSearchDialog.this.Q = null;
                    }
                    TroopTeamWorkFileSearchDialog.this.k0();
                    return;
                }
                TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog2 = TroopTeamWorkFileSearchDialog.this;
                troopTeamWorkFileSearchDialog2.U = false;
                CountdownTimeTask countdownTimeTask2 = troopTeamWorkFileSearchDialog2.Q;
                if (countdownTimeTask2 == null) {
                    troopTeamWorkFileSearchDialog2.Q = new CountdownTimeTask(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog3 = TroopTeamWorkFileSearchDialog.this;
                            if (troopTeamWorkFileSearchDialog3.U) {
                                troopTeamWorkFileSearchDialog3.Q = null;
                                return;
                            }
                            if (troopTeamWorkFileSearchDialog3.X > 0) {
                                troopTeamWorkFileSearchDialog3.Q = null;
                                return;
                            }
                            troopTeamWorkFileSearchDialog3.W = troopTeamWorkFileSearchDialog3.J.getText().toString().trim().toLowerCase();
                            TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog4 = TroopTeamWorkFileSearchDialog.this;
                            troopTeamWorkFileSearchDialog4.Z = 0;
                            troopTeamWorkFileSearchDialog4.T = true;
                            troopTeamWorkFileSearchDialog4.R(troopTeamWorkFileSearchDialog4.W);
                            TroopTeamWorkFileSearchDialog.this.Q = null;
                        }
                    }, 800);
                    ThreadManagerV2.post(TroopTeamWorkFileSearchDialog.this.Q, 5, null, true);
                } else if (countdownTimeTask2.e() > 0) {
                    TroopTeamWorkFileSearchDialog.this.Q.f();
                } else if (QLog.isColorLevel()) {
                    QLog.e("TroopTeamWorkFileSearchDialog", 2, "!!!!!! \u8fd9\u662f\u4e2a\u4ec0\u4e48\u60c5\u51b5,\u903b\u8f91\u51fa\u9519\u4e86 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog = TroopTeamWorkFileSearchDialog.this;
                boolean z16 = troopTeamWorkFileSearchDialog.V;
                if (z16 && (!z16 || troopTeamWorkFileSearchDialog.Z > 0)) {
                    troopTeamWorkFileSearchDialog.G.setVisibility(0);
                } else {
                    troopTeamWorkFileSearchDialog.G.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.J.setSelection(0);
        this.J.requestFocus();
    }

    protected void b0(Activity activity) {
        requestWindowFeature(1);
        getWindow().setSoftInputMode(36);
        if (!VersionUtils.isHoneycomb()) {
            getWindow().setBackgroundDrawable(new ColorDrawable());
        } else {
            getWindow().setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.f157170kc)));
        }
        setContentView(R.layout.a2f);
        findViewById(R.id.local_search).setOnClickListener(new a());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
            int color = activity.getResources().getColor(R.color.skin_color_title_immersive_bar);
            if (ImmersiveUtils.setStatusBarDarkMode(getWindow(), true)) {
                color = activity.getResources().getColor(R.color.f157995aj3);
            }
            new SystemBarCompact((Dialog) this, true, color).init();
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.local_search);
            linearLayout.setFitsSystemWindows(true);
            linearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(activity), 0, 0);
        }
    }

    protected void c0() {
        this.G.setVisibility(8);
        this.U = true;
        this.P.removeCallbacksAndMessages(null);
        CountdownTimeTask countdownTimeTask = this.Q;
        if (countdownTimeTask != null) {
            countdownTimeTask.h();
            this.Q = null;
        }
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.C.setVisibility(8);
        InputMethodUtil.show(this.J);
    }

    protected void d0(final View view, final boolean z16, Bitmap bitmap) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.11
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                View view2 = view;
                if (view2 != null) {
                    view2.setDrawingCacheEnabled(z16);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("mBlurBackground == null :");
                    if (TroopTeamWorkFileSearchDialog.this.f292544g0 == null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    sb5.append(z17);
                    QLog.d("TroopTeamWorkFileSearchDialog", 2, sb5.toString());
                }
            }
        });
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.U = true;
        InputMethodUtil.hide(this.J);
        SingleLineHotwordTextView.i();
        List<GPadInfo> list = this.f292542e0;
        if (list != null) {
            list.clear();
            this.f292542e0 = null;
        }
        CountdownTimeTask countdownTimeTask = this.Q;
        if (countdownTimeTask != null) {
            countdownTimeTask.h();
            this.Q = null;
        }
        Handler handler = this.P;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.tencent.mobileqq.teamworkforgroup.e eVar = this.L;
        if (eVar != null) {
            eVar.e();
            this.L = null;
        }
        this.M.removeObserver(this.f292543f0);
        try {
            super.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected void e0(final View view, final boolean z16, final Bitmap bitmap) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.10
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null) {
                    TroopTeamWorkFileSearchDialog.this.d0(view, z16, bitmap2);
                    return;
                }
                try {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTeamWorkFileSearchDialog", 2, "createScaledBitmap");
                        }
                        TroopTeamWorkFileSearchDialog troopTeamWorkFileSearchDialog = TroopTeamWorkFileSearchDialog.this;
                        Bitmap bitmap3 = bitmap;
                        troopTeamWorkFileSearchDialog.f292544g0 = Bitmap.createScaledBitmap(bitmap3, bitmap3.getWidth() / TroopTeamWorkFileSearchDialog.f292536h0, bitmap.getHeight() / TroopTeamWorkFileSearchDialog.f292536h0, true);
                        Canvas canvas = new Canvas();
                        canvas.setBitmap(TroopTeamWorkFileSearchDialog.this.f292544g0);
                        canvas.drawColor(Color.parseColor("#50ffffff"), PorterDuff.Mode.LIGHTEN);
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTeamWorkFileSearchDialog", 2, "start blur");
                        }
                        eh.a(TroopTeamWorkFileSearchDialog.this.f292544g0, TroopTeamWorkFileSearchDialog.f292537i0);
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur end");
                        }
                    } catch (Exception e16) {
                        TroopTeamWorkFileSearchDialog.this.f292544g0 = null;
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur error", e16);
                        }
                    } catch (OutOfMemoryError e17) {
                        TroopTeamWorkFileSearchDialog.this.f292544g0 = null;
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur error", e17);
                        }
                    }
                } finally {
                    TroopTeamWorkFileSearchDialog.this.d0(view, z16, bitmap);
                }
            }
        }, 8, null, true);
    }

    protected void f0(String str, boolean z16) {
        if (this.Z <= 0) {
            this.G.setVisibility(8);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        float U = U() - this.J.getPaint().measureText(str);
        if (U < 0.0f) {
            this.G.setVisibility(8);
        } else if (z16) {
            this.G.setText(X(this.Z));
            this.G.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
            QLog.e("zivonchen", 2, "resetResultNumTextVisible compareWidth = " + U + ", time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void g0(View view) {
        Bitmap bitmap;
        if (view == null) {
            return;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, isDrawingCacheEnabled:" + isDrawingCacheEnabled + " view:" + view.getHeight() + "," + view.getWidth());
        }
        if (!isDrawingCacheEnabled) {
            view.setDrawingCacheEnabled(true);
        }
        try {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, getDrawingCache");
                }
                Bitmap drawingCache = view.getDrawingCache(true);
                if (drawingCache == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, start thread");
                }
                try {
                    bitmap = Bitmap.createBitmap(drawingCache);
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blurBitmap error", e16);
                    }
                    bitmap = null;
                }
                e0(view, isDrawingCacheEnabled, bitmap);
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache exception, " + e17.getMessage());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
                }
            }
        } catch (Throwable unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.U) {
            return true;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            l0(false);
                            f0(this.J.getText().toString(), true);
                            if (this.K.getVisibility() != 0) {
                                this.K.setVisibility(0);
                            }
                            if (this.T) {
                                this.L.e();
                            }
                            if (this.R) {
                                this.R = false;
                                InputMethodUtil.hide(this.J);
                            }
                            i0(this.Y);
                            this.L.d(this.f292542e0);
                            this.L.notifyDataSetChanged();
                            if (this.T) {
                                this.T = false;
                            }
                            long currentTimeMillis = System.currentTimeMillis() - this.f292539b0;
                            String lowerCase = this.J.getText().toString().trim().toLowerCase();
                            if (QLog.isColorLevel()) {
                                QLog.e("zivonchen", 2, "REFRESH_LIST text = " + lowerCase + ", lastHotword = " + this.W + ", time = " + currentTimeMillis);
                            }
                            if (!lowerCase.equals(this.W) && currentTimeMillis >= 800) {
                                this.T = true;
                                this.W = lowerCase;
                                R(lowerCase);
                                this.Q = null;
                            }
                        }
                    } else {
                        j0(false);
                    }
                } else {
                    j0(true);
                }
            } else {
                l0(false);
            }
        } else {
            l0(true);
        }
        return false;
    }

    protected void i0(boolean z16) {
        if (this.C.getFirstVisiblePosition() == 0) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setVisibility(0);
        if (z16) {
            this.D.setText(R.string.hql);
            this.D.a();
        } else {
            this.D.setText(R.string.cuy);
            this.D.setTextLeftDrawable(R.drawable.jiy);
        }
    }

    public void j0(boolean z16) {
        l0(false);
        if (z16) {
            if (this.K.getVisibility() != 0) {
                this.K.setVisibility(0);
            }
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.C.setVisibility(8);
            this.F.setText(this.N.getString(R.string.el_, this.W));
            this.F.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.e3n, 0, 0);
            return;
        }
        this.C.setVisibility(0);
        Object obj = this.F.getCompoundDrawables()[0];
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
        this.F.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
    }

    public void k0() {
        if (this.K.getVisibility() != 0) {
            this.K.setVisibility(0);
        }
        this.E.setVisibility(0);
        this.F.setVisibility(0);
        this.C.setVisibility(8);
        this.F.setText(this.N.getString(R.string.f171139ci4));
        this.F.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public void l0(boolean z16) {
        if (z16) {
            if (this.K.getVisibility() != 0) {
                this.K.setVisibility(0);
            }
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.C.setVisibility(8);
            this.F.setCompoundDrawablesWithIntrinsicBounds(R.drawable.jiy, 0, 0, 0);
            this.F.setText(R.string.cuy);
            Object obj = this.F.getCompoundDrawables()[0];
            if (obj instanceof Animatable) {
                ((Animatable) obj).start();
                return;
            }
            return;
        }
        this.C.setVisibility(0);
        Object obj2 = this.F.getCompoundDrawables()[0];
        if (obj2 instanceof Animatable) {
            ((Animatable) obj2).stop();
        }
        this.F.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        Handler handler = this.P;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Bitmap bitmap = this.f292544g0;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f292544g0.recycle();
            this.f292544g0 = null;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.m
    public void D1(PadInfo padInfo) {
    }

    @Override // com.tencent.mobileqq.teamwork.m
    public void X1(PadInfo padInfo) {
    }
}
