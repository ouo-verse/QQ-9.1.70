package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.i;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ClassificationSearchActivity extends SearchBaseActivity implements i.a {
    static IPatchRedirector $redirector_;
    private static un2.a F0;
    public static int G0;
    public static int H0;
    public static int I0;
    public static int J0;
    public static int K0;
    public static String L0;
    static String M0;
    static String N0;
    List<Object> A0;
    private View.OnClickListener B0;
    private TextView.OnEditorActionListener C0;
    private View.OnTouchListener D0;
    protected Handler E0;

    /* renamed from: q0, reason: collision with root package name */
    XListView f180698q0;

    /* renamed from: r0, reason: collision with root package name */
    View f180699r0;

    /* renamed from: s0, reason: collision with root package name */
    View f180700s0;

    /* renamed from: t0, reason: collision with root package name */
    View f180701t0;

    /* renamed from: u0, reason: collision with root package name */
    View f180702u0;

    /* renamed from: v0, reason: collision with root package name */
    View f180703v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f180704w0;

    /* renamed from: x0, reason: collision with root package name */
    List<ReadInJoySearchHistoryEntity> f180705x0;

    /* renamed from: y0, reason: collision with root package name */
    int f180706y0;

    /* renamed from: z0, reason: collision with root package name */
    View f180707z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity$10, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass10 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ClassificationSearchActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            EntityManager createEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
            List<? extends Entity> query = createEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
            Message obtainMessage = this.this$0.E0.obtainMessage(1);
            obtainMessage.obj = query;
            this.this$0.E0.sendMessage(obtainMessage);
            createEntityManager.close();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
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
            if (i3 != 1) {
                if (i3 == 2) {
                    ClassificationSearchActivity.this.W2((List) message.obj, false);
                    return;
                }
                return;
            }
            ClassificationSearchActivity.this.W2((List) message.obj, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i3;
            String string;
            ClassificationSearchActivity classificationSearchActivity;
            SearchBaseFragment searchBaseFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = ClassificationSearchActivity.this.f180765h0.getText().toString();
            ImageView imageView = ClassificationSearchActivity.this.f180764g0;
            if (obj.equals("")) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            ClassificationSearchActivity classificationSearchActivity2 = ClassificationSearchActivity.this;
            if (classificationSearchActivity2.f180706y0 == ClassificationSearchActivity.I0) {
                classificationSearchActivity2.f180763f0.setText(classificationSearchActivity2.getResources().getString(R.string.cancel));
            } else {
                TextView textView = classificationSearchActivity2.f180763f0;
                if (!obj.equals("")) {
                    string = ClassificationSearchActivity.this.getResources().getString(R.string.ha5);
                } else {
                    string = ClassificationSearchActivity.this.getResources().getString(R.string.cancel);
                }
                textView.setText(string);
            }
            if (obj.equals("") && (searchBaseFragment = (classificationSearchActivity = ClassificationSearchActivity.this).f180768k0) != null) {
                int i16 = classificationSearchActivity.f180706y0;
                if (i16 == ClassificationSearchActivity.G0 || i16 == ClassificationSearchActivity.J0) {
                    classificationSearchActivity.U2();
                } else {
                    searchBaseFragment.wh();
                }
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                InputMethodManager inputMethodManager = (InputMethodManager) ClassificationSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null && inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(ClassificationSearchActivity.this.getWindow().getDecorView().getWindowToken(), 0);
                }
                ClassificationSearchActivity.this.setResult(1);
                ClassificationSearchActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ClassificationSearchActivity.this.f180765h0.setText("");
                ClassificationSearchActivity classificationSearchActivity = ClassificationSearchActivity.this;
                int i3 = classificationSearchActivity.f180706y0;
                if (i3 == ClassificationSearchActivity.G0 || i3 == ClassificationSearchActivity.J0) {
                    classificationSearchActivity.U2();
                } else {
                    classificationSearchActivity.f180768k0.wh();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (!TextUtils.isEmpty(ClassificationSearchActivity.this.f180765h0.getText())) {
                    ClassificationSearchActivity classificationSearchActivity = ClassificationSearchActivity.this;
                    if (classificationSearchActivity.f180706y0 != ClassificationSearchActivity.I0) {
                        String obj = classificationSearchActivity.f180765h0.getText().toString();
                        if (ClassificationSearchActivity.this.f180706y0 == ClassificationSearchActivity.G0 && !TextUtils.isEmpty(obj.trim())) {
                            ClassificationSearchActivity.this.T2(obj);
                            ClassificationSearchActivity.this.S2(obj);
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X80067C4", "0X80067C4", 0, 0, "", "", obj, "", true);
                        } else {
                            ClassificationSearchActivity classificationSearchActivity2 = ClassificationSearchActivity.this;
                            if (classificationSearchActivity2.f180706y0 == ClassificationSearchActivity.J0) {
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800742D", "0X800742D", 0, 0, obj, "", "", "");
                                ClassificationSearchActivity.this.S2(obj);
                            } else {
                                classificationSearchActivity2.f180768k0.Bh(obj, false);
                            }
                        }
                    }
                }
                InputMethodManager inputMethodManager = (InputMethodManager) ClassificationSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null && inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(ClassificationSearchActivity.this.getWindow().getDecorView().getWindowToken(), 0);
                }
                ClassificationSearchActivity.this.setResult(0);
                ClassificationSearchActivity.this.finish();
                ClassificationSearchActivity classificationSearchActivity3 = ClassificationSearchActivity.this;
                int i3 = classificationSearchActivity3.f180706y0;
                if (i3 == ClassificationSearchActivity.J0 || i3 == ClassificationSearchActivity.K0) {
                    classificationSearchActivity3.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                z16 = false;
            } else {
                String obj = ClassificationSearchActivity.this.f180765h0.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    if (ClassificationSearchActivity.this.f180706y0 == ClassificationSearchActivity.G0 && !TextUtils.isEmpty(obj.trim())) {
                        ClassificationSearchActivity.this.T2(obj);
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X80067C4", "0X80067C4", 0, 0, "", "", obj, "", true);
                        ClassificationSearchActivity.this.S2(obj);
                    } else {
                        ClassificationSearchActivity classificationSearchActivity = ClassificationSearchActivity.this;
                        if (classificationSearchActivity.f180706y0 == ClassificationSearchActivity.J0) {
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800742D", "0X800742D", 0, 0, obj, "", "", "");
                            ClassificationSearchActivity.this.S2(obj);
                        } else {
                            classificationSearchActivity.f180768k0.Bh(obj, false);
                        }
                    }
                } else {
                    ClassificationSearchActivity classificationSearchActivity2 = ClassificationSearchActivity.this;
                    if (classificationSearchActivity2.f180706y0 == ClassificationSearchActivity.G0) {
                        String charSequence = classificationSearchActivity2.f180765h0.getHint().toString();
                        if (!TextUtils.isEmpty(charSequence.trim()) && !TextUtils.equals(charSequence, HardCodeUtil.qqStr(R.string.km7)) && !TextUtils.equals(charSequence, HardCodeUtil.qqStr(R.string.kml))) {
                            ClassificationSearchActivity.this.T2(charSequence);
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X80067C4", "0X80067C4", 0, 0, "", "", charSequence, "", true);
                            ClassificationSearchActivity.this.S2(charSequence);
                        }
                    }
                }
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class g implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) ClassificationSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            ClassificationSearchActivity.this.f180765h0.clearFocus();
            ClassificationSearchActivity.this.f180765h0.setSelection(ClassificationSearchActivity.this.f180765h0.getText().toString().length());
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        G0 = 1;
        H0 = 2;
        I0 = 3;
        J0 = 4;
        K0 = 5;
        L0 = "is_from";
        M0 = "";
        N0 = "";
    }

    public ClassificationSearchActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180704w0 = false;
        this.f180705x0 = new ArrayList();
        this.f180706y0 = 0;
        this.A0 = new ArrayList();
        this.B0 = new e();
        this.C0 = new f();
        this.D0 = new g();
        this.E0 = new a();
    }

    private String Q2(int i3) {
        switch (i3) {
            case 80000000:
                return HardCodeUtil.qqStr(R.string.km9);
            case 80000001:
                return HardCodeUtil.qqStr(R.string.kme);
            case 80000002:
                if (UniteSearchActivity.f282684b0 == 12) {
                    return HardCodeUtil.qqStr(R.string.kmb) + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext());
                }
                return HardCodeUtil.qqStr(R.string.kmi);
            case 80000003:
                return HardCodeUtil.qqStr(R.string.kma);
            default:
                return "";
        }
    }

    private void R2() {
        this.f180702u0 = LayoutInflater.from(this).inflate(R.layout.f168551a45, (ViewGroup) null);
        this.f180702u0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        XListView xListView = (XListView) this.f180702u0.findViewById(R.id.ijs);
        this.f180698q0 = xListView;
        xListView.setOnTouchListener(this.D0);
        View inflate = LayoutInflater.from(this).inflate(R.layout.f168409vb, (ViewGroup) null);
        this.f180699r0 = inflate;
        inflate.setOnTouchListener(this.D0);
        this.f180700s0 = this.f180699r0.findViewById(R.id.iju);
        this.f180701t0 = this.f180699r0.findViewById(R.id.jnc);
        this.f180703v0 = this.f180699r0.findViewById(R.id.atl);
        this.f180698q0.addHeaderView(this.f180699r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(String str) {
        String trim = str.trim();
        try {
            trim = URLEncoder.encode(trim, "utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
        String readinjoySearchUrl = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadinjoySearchUrl();
        if (readinjoySearchUrl != null) {
            if (readinjoySearchUrl.contains("keyword")) {
                readinjoySearchUrl = readinjoySearchUrl.replace("keyword", trim);
            }
        } else {
            readinjoySearchUrl = "https://so.mp.qq.com/search/index?key=" + trim + "&_wv=3&_bid=2321";
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this, IPublicAccountBrowser.ROUTE_NAME);
        activityURIRequest.extra().putString("url", readinjoySearchUrl);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2() {
        List<ReadInJoySearchHistoryEntity> list;
        List<Object> list2 = this.A0;
        if ((list2 != null && list2.size() != 0) || ((list = this.f180705x0) != null && list.size() != 0)) {
            this.f180768k0.Zh(this.f180702u0);
            this.f180703v0.setVisibility(0);
            List<Object> list3 = this.A0;
            if (list3 != null && list3.size() != 0) {
                this.f180701t0.setVisibility(0);
            } else {
                this.f180701t0.setVisibility(8);
            }
            List<ReadInJoySearchHistoryEntity> list4 = this.f180705x0;
            if (list4 != null && list4.size() != 0) {
                this.f180700s0.setVisibility(0);
            } else {
                this.f180700s0.setVisibility(8);
            }
            this.f180698q0.setSelection(0);
            P2(true);
            return;
        }
        SearchBaseFragment searchBaseFragment = this.f180768k0;
        if (searchBaseFragment != null) {
            searchBaseFragment.wh();
            P2(false);
        }
    }

    public static void V2(Activity activity, Intent intent, un2.a aVar) {
        F0 = aVar;
        N0 = intent.getStringExtra("last_hint");
        activity.startActivityForResult(intent, 1);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.i.a
    public void D2(ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) readInJoySearchHistoryEntity);
            return;
        }
        if (this.f180706y0 == G0) {
            this.f180765h0.setText(readInJoySearchHistoryEntity.keyWord);
            if (!TextUtils.isEmpty(readInJoySearchHistoryEntity.keyWord)) {
                EditText editText = this.f180765h0;
                editText.setSelection(editText.getText().length());
            }
            S2(readInJoySearchHistoryEntity.keyWord);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006819", "0X8006819", 0, 0, readInJoySearchHistoryEntity.keyWord, "", "", "");
            return;
        }
        this.f180768k0.Bh(readInJoySearchHistoryEntity.keyWord, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.I2();
        Intent intent = getIntent();
        if (intent.hasExtra(L0)) {
            this.f180706y0 = intent.getIntExtra(L0, 0);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    protected SearchBaseFragment J2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SearchBaseFragment) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        un2.a aVar = F0;
        if (aVar == null && ((i3 = this.f180706y0) == G0 || i3 == J0 || i3 == K0 || i3 == H0 || i3 == I0)) {
            return ClassificationSearchFragment.ki(i3);
        }
        return ClassificationSearchFragment.li(aVar);
    }

    public void P2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (ThemeUtil.isInNightMode(this.app)) {
            if (z16) {
                this.f180768k0.J.setBackgroundColor(-1);
                View view = this.f180707z0;
                if (view != null) {
                    ((ViewGroup) view.getParent()).removeView(this.f180707z0);
                }
                View view2 = new View(this);
                this.f180707z0 = view2;
                view2.setBackgroundColor(1996488704);
                addContentView(this.f180707z0, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            LinearLayout linearLayout = this.f180768k0.J;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(0);
            }
            View view3 = this.f180707z0;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public void T2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f180712d;

                {
                    this.f180712d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    EntityManager createEntityManager = ClassificationSearchActivity.this.app.getEntityManagerFactory().createEntityManager();
                    List<? extends Entity> query = createEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
                    if (query != null) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                readInJoySearchHistoryEntity = (ReadInJoySearchHistoryEntity) it.next();
                                if (readInJoySearchHistoryEntity.keyWord.equals(this.f180712d)) {
                                    createEntityManager.remove(readInJoySearchHistoryEntity);
                                    break;
                                }
                            } else {
                                readInJoySearchHistoryEntity = null;
                                break;
                            }
                        }
                        if (readInJoySearchHistoryEntity != null) {
                            query.remove(readInJoySearchHistoryEntity);
                        }
                        if (query.size() == 20) {
                            createEntityManager.remove((Entity) query.get(query.size() - 1));
                            query.remove(query.size() - 1);
                        }
                    } else {
                        query = new ArrayList<>();
                    }
                    ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity2 = new ReadInJoySearchHistoryEntity();
                    readInJoySearchHistoryEntity2.keyWord = this.f180712d;
                    readInJoySearchHistoryEntity2.timestamp = System.currentTimeMillis();
                    createEntityManager.persist(readInJoySearchHistoryEntity2);
                    query.add(0, readInJoySearchHistoryEntity2);
                    createEntityManager.close();
                    Message obtainMessage = ClassificationSearchActivity.this.E0.obtainMessage(1);
                    obtainMessage.obj = query;
                    ClassificationSearchActivity.this.E0.sendMessage(obtainMessage);
                }
            }, 10, null, true);
        }
    }

    protected void W2(List<ReadInJoySearchHistoryEntity> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, Boolean.valueOf(z16));
            return;
        }
        this.f180705x0 = list;
        if (z16) {
            U2();
        }
        if (this.f180698q0.getAdapter() == null) {
            this.f180698q0.setAdapter((ListAdapter) new i(this, list, this));
            return;
        }
        if (this.f180698q0.getAdapter() instanceof HeaderViewListAdapter) {
            i iVar = (i) ((HeaderViewListAdapter) this.f180698q0.getAdapter()).getWrappedAdapter();
            if (iVar != null) {
                iVar.b(list);
                return;
            }
            return;
        }
        ((i) this.f180698q0.getAdapter()).b(list);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).booleanValue();
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        this.f180765h0.setText(this.f180759b0);
        if (!TextUtils.isEmpty(this.f180759b0)) {
            this.f180765h0.requestFocus();
            EditText editText = this.f180765h0;
            editText.setSelection(editText.getText().length());
        }
        this.f180704w0 = true;
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.doOnResume();
        int i3 = this.f180706y0;
        if (i3 == G0 || i3 == J0 || i3 == K0) {
            ((ClassificationSearchFragment) this.f180768k0).oi(true);
        }
        if (((ClassificationSearchFragment) this.f180768k0).ji()) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    ClassificationSearchActivity.this.f180765h0.requestFocus();
                    ((InputMethodManager) ClassificationSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(ClassificationSearchActivity.this.f180765h0, 0);
                    return false;
                }
            });
            ((ClassificationSearchFragment) this.f180768k0).oi(false);
        }
        if (this.f180706y0 == G0) {
            if (!TextUtils.isEmpty(N0)) {
                this.f180765h0.setEllipsize(TextUtils.TruncateAt.END);
                this.f180765h0.setHint(N0);
            } else if (!TextUtils.isEmpty("")) {
                this.f180765h0.setEllipsize(TextUtils.TruncateAt.END);
                this.f180765h0.setHint("");
            } else {
                this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.kmm));
            }
            U2();
        }
        if (this.f180706y0 == J0) {
            this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.kmd));
            U2();
        }
        if (this.f180706y0 == H0) {
            this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.km5));
            U2();
            if (!TextUtils.isEmpty(M0) && this.f180704w0) {
                this.f180768k0.Bh(M0, false);
            }
        }
        if (this.f180706y0 == I0) {
            this.f180766i0.setVisibility(8);
            if (this.f180765h0.getText().toString().equals("")) {
                this.f180768k0.wh();
            }
            this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.km6));
        }
        if (this.f180706y0 == K0) {
            if (this.f180765h0.getText().toString().equals("")) {
                this.f180768k0.wh();
            }
            this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.km_));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnStop();
        if (((ClassificationSearchFragment) this.f180768k0).ji()) {
            this.f180768k0.wh();
        }
        this.f180704w0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    public void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.initViews();
        un2.a aVar = F0;
        if (aVar != null) {
            this.f180765h0.setHint(Q2(aVar.f439268a));
        }
        this.f180765h0.addTextChangedListener(new b());
        this.f180765h0.setOnEditorActionListener(this.C0);
        this.f180766i0.setOnClickListener(new c());
        this.f180763f0.setOnClickListener(this.B0);
        if (AppSetting.f99565y) {
            this.f180765h0.setContentDescription(HardCodeUtil.qqStr(R.string.kmf) + this.f180759b0);
        }
        this.f180764g0.setOnClickListener(new d());
        int i3 = this.f180706y0;
        if (i3 == G0 || i3 == J0) {
            R2();
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    ClassificationSearchActivity.this.f180765h0.requestFocus();
                    ((InputMethodManager) ClassificationSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(ClassificationSearchActivity.this.f180765h0, 0);
                    return false;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.i.a
    public void k1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClassificationSearchActivity.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.11.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    EntityManager createEntityManager = ClassificationSearchActivity.this.app.getEntityManagerFactory().createEntityManager();
                                    List<? extends Entity> query = createEntityManager.query(ReadInJoySearchHistoryEntity.class);
                                    if (query == null) {
                                        return;
                                    }
                                    Iterator<? extends Entity> it = query.iterator();
                                    while (it.hasNext()) {
                                        createEntityManager.remove((ReadInJoySearchHistoryEntity) it.next());
                                    }
                                    query.clear();
                                    Message obtainMessage = ClassificationSearchActivity.this.E0.obtainMessage(1);
                                    obtainMessage.obj = query;
                                    ClassificationSearchActivity.this.E0.sendMessage(obtainMessage);
                                    createEntityManager.close();
                                }
                            }, 10, null, true);
                            return;
                        }
                        return;
                    }
                    dialogInterface.dismiss();
                }
            }
        };
        createCustomDialog.setPositiveButton(R.string.f171271dn1, onClickListener);
        createCustomDialog.setNegativeButton(R.string.f171270dn0, onClickListener);
        String string = getString(R.string.f171272dn2);
        createCustomDialog.setTitle(R.string.f171377ej4);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setTextColor(getResources().getColor(R.color.f156931fl));
        textView.setText(string);
        textView.setGravity(1);
        createCustomDialog.addView(textView);
        createCustomDialog.show();
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
