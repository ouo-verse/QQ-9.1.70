package com.tencent.mobileqq.c2cshortcutbar.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.b;
import com.tencent.mobileqq.c2cshortcutbar.f;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.widget.LabelTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends DialogFromBottom implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private ViewGroup D;
    private View E;
    private ImageView F;
    private LinearLayout G;
    private RecyclerView H;
    private FormSwitchItem I;
    private d J;
    private List<com.tencent.mobileqq.c2cshortcutbar.b> K;
    private com.tencent.mobileqq.c2cshortcutbar.store.c L;
    private String M;
    private boolean N;
    private boolean P;
    private float Q;
    private float R;
    private boolean S;
    private List<String> T;
    f U;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                b.this.Q = motionEvent.getY();
                ba.setViewAlpha(view, 0.5f);
                return false;
            }
            if (motionEvent.getAction() == 1) {
                ba.setViewAlpha(view, 1.0f);
                b.this.R = motionEvent.getY();
                if (b.this.R - b.this.Q > 50.0f) {
                    if (b.this.L != null) {
                        b.this.L.c();
                    }
                    return true;
                }
                return false;
            }
            if (motionEvent.getAction() == 3) {
                ba.setViewAlpha(view, 1.0f);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.c2cshortcutbar.store.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C7443b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        C7443b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
            } else if (i3 == 0) {
                b.this.c0(recyclerView);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (b.this.S) {
                b.this.S = false;
                b.this.c0(recyclerView);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.f
        public void c(boolean z16, String str, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                return;
            }
            if (z16) {
                if (b.this.I != null && z17 != b.this.I.isChecked()) {
                    b.this.I.setOnCheckedChangeListener(null);
                    b.this.I.setChecked(z17);
                    b.this.I.setOnCheckedChangeListener(b.this);
                    return;
                }
                return;
            }
            QQToast makeText = QQToast.makeText(BaseApplication.getContext(), 1, R.string.zgv, 0);
            makeText.show(makeText.getTitleBarHeight());
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d extends RecyclerView.Adapter<e> {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f200975d;

            a(int i3) {
                this.f200975d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, i3);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (b.this.L != null) {
                    b.this.L.b(this.f200975d, (com.tencent.mobileqq.c2cshortcutbar.b) b.this.K.get(this.f200975d));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return b.this.K.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        @SuppressLint({"RecyclerView"})
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(e eVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar, i3);
            } else {
                com.tencent.mobileqq.c2cshortcutbar.b bVar = (com.tencent.mobileqq.c2cshortcutbar.b) b.this.K.get(i3);
                Context context = b.this.getContext();
                ImageView imageView = eVar.f200978e;
                String str = bVar.f200938d;
                boolean z16 = true;
                if (bVar.f200943i != 1) {
                    z16 = false;
                }
                r.l(context, imageView, str, 19.0f, z16);
                eVar.f200979f.setText(bVar.f200937c);
                eVar.f200981i.setText(bVar.f200940f);
                if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                    eVar.f200979f.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    eVar.f200979f.setTextColor(Color.parseColor("#FF03081A"));
                }
                ArrayList<b.a> arrayList = bVar.f200947m;
                if (arrayList != null && arrayList.size() > 0) {
                    Paint paint = new Paint();
                    paint.setTextSize(ViewUtils.dpToPx(17.0f));
                    b.this.d0((int) ((ViewUtils.getScreenWidth() - paint.measureText(bVar.f200937c)) - ba.dp2px(b.this.getContext(), 72.0f)), eVar.f200980h, bVar.f200947m);
                } else {
                    eVar.f200980h.setVisibility(8);
                }
                eVar.f200977d.setOnTouchListener(ba.f77070d);
                eVar.f200977d.setOnClickListener(new a(i3));
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(eVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.e0t, viewGroup, false));
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public ViewGroup f200977d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f200978e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f200979f;

        /* renamed from: h, reason: collision with root package name */
        public LinearLayout f200980h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f200981i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f200982m;

        public e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) view);
                return;
            }
            this.f200977d = (ViewGroup) view.findViewById(R.id.tkp);
            this.f200978e = (ImageView) view.findViewById(R.id.tkn);
            this.f200979f = (TextView) view.findViewById(R.id.tkr);
            this.f200980h = (LinearLayout) view.findViewById(R.id.tko);
            this.f200981i = (TextView) view.findViewById(R.id.tkq);
            this.f200982m = (TextView) view.findViewById(R.id.tks);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(QQAppInterface qQAppInterface, Context context, String str, boolean z16, boolean z17, List<com.tencent.mobileqq.c2cshortcutbar.b> list, com.tencent.mobileqq.c2cshortcutbar.store.c cVar) {
        super(context, R.style.f243781q);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, context, str, Boolean.valueOf(z16), Boolean.valueOf(z17), list, cVar);
            return;
        }
        this.S = true;
        this.T = new ArrayList();
        this.U = new c();
        this.C = qQAppInterface;
        this.L = cVar;
        ArrayList arrayList = new ArrayList();
        this.K = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.M = str;
        this.N = z16;
        this.P = z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getVisibility() == 0 && recyclerView.isShown() && recyclerView.getGlobalVisibleRect(new Rect())) {
            try {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int[] iArr = {linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
                for (int i3 = iArr[0]; i3 <= iArr[1]; i3++) {
                    List<com.tencent.mobileqq.c2cshortcutbar.b> list = this.K;
                    if (list != null && i3 < list.size() && this.K.get(i3) != null && !TextUtils.isEmpty(this.K.get(i3).f200935a) && !this.T.contains(this.K.get(i3).f200935a)) {
                        this.T.add(this.K.get(i3).f200935a);
                        ReportController.o(null, "dc00898", "", "", "0X800B32C", "0X800B32C", com.tencent.mobileqq.c2cshortcutbar.e.d(this.C).f(this.M), 0, this.K.get(i3).f200935a, i3 + "", "", "");
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d0(int i3, LinearLayout linearLayout, List<b.a> list) {
        linearLayout.removeAllViews();
        int dpToPx = ViewUtils.dpToPx(12.0f);
        int dpToPx2 = ViewUtils.dpToPx(1.0f);
        int dpToPx3 = ViewUtils.dpToPx(8.0f);
        int dpToPx4 = ViewUtils.dpToPx(6.0f);
        Paint paint = new Paint();
        float f16 = 12;
        paint.setTextSize(ViewUtils.dpToPx(f16));
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i16 = i3;
        int i17 = 0;
        while (true) {
            if (i17 >= size) {
                break;
            }
            b.a aVar = list.get(i17);
            if (aVar != null && !TextUtils.isEmpty(aVar.f200949a)) {
                int measureText = (int) (paint.measureText(aVar.f200949a) + (dpToPx3 * 2));
                if (i16 >= measureText + dpToPx4) {
                    arrayList.add(aVar);
                    i16 = (i16 - measureText) - dpToPx4;
                } else if (i17 == 0) {
                    arrayList.add(aVar);
                }
            }
            i17++;
        }
        int size2 = arrayList.size();
        for (int i18 = 0; i18 < size2; i18++) {
            b.a aVar2 = (b.a) arrayList.get(i18);
            LabelTextView labelTextView = new LabelTextView(getContext());
            labelTextView.setParam(Color.parseColor(aVar2.f200950b), Color.parseColor(aVar2.f200951c), dpToPx);
            labelTextView.setTextSize(f16);
            labelTextView.setText(aVar2.f200949a);
            labelTextView.setPadding(dpToPx3, dpToPx2, dpToPx3, dpToPx2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i18 != 0) {
                layoutParams.leftMargin = dpToPx4;
            }
            linearLayout.addView(labelTextView, layoutParams);
        }
        return arrayList.size();
    }

    @Override // com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.dismiss();
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.U);
            this.C = null;
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, compoundButton, Boolean.valueOf(z16));
        } else {
            FormSwitchItem formSwitchItem = this.I;
            if (formSwitchItem != null && formSwitchItem.getSwitch() == compoundButton) {
                com.tencent.mobileqq.c2cshortcutbar.store.c cVar = this.L;
                if (cVar != null) {
                    cVar.a(z16, this.M);
                }
                ReportController.o(null, "dc00898", "", "", "0X800B32F", "0X800B32F", com.tencent.mobileqq.c2cshortcutbar.e.d(this.C).f(this.M), 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.tkt) {
                com.tencent.mobileqq.c2cshortcutbar.store.c cVar = this.L;
                if (cVar != null) {
                    cVar.c();
                }
            } else if (id5 == R.id.tkl) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom, android.app.Dialog
    public void onCreate(Bundle bundle) {
        int i3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -1;
        attributes.gravity = 81;
        int screenWidth = DisplayHelper.getScreenWidth(getContext());
        int screenHeight = DisplayHelper.getScreenHeight(getContext());
        if (screenWidth >= screenHeight) {
            screenWidth = screenHeight;
        }
        attributes.width = screenWidth;
        getWindow().setAttributes(attributes);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(67108864);
        boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.e0s, (ViewGroup) null);
        this.D = viewGroup;
        View findViewById = viewGroup.findViewById(R.id.tkl);
        this.E = findViewById;
        findViewById.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.D.findViewById(R.id.tku);
        this.G = linearLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.G.setLayoutParams(layoutParams);
        if (isInNightMode) {
            this.G.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.jew));
        } else {
            this.G.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.jev));
        }
        ImageView imageView = (ImageView) this.D.findViewById(R.id.tkt);
        this.F = imageView;
        imageView.setOnClickListener(this);
        this.F.setOnTouchListener(new a());
        this.H = (RecyclerView) this.D.findViewById(R.id.tkv);
        int i16 = 0;
        this.H.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        d dVar = new d();
        this.J = dVar;
        this.H.setAdapter(dVar);
        this.H.addOnScrollListener(new C7443b());
        View findViewById2 = this.D.findViewById(R.id.tkm);
        if (this.N) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        if (isInNightMode) {
            str = "#3D3D41";
        } else {
            str = "#EBEDF5";
        }
        findViewById2.setBackgroundColor(Color.parseColor(str));
        FormSwitchItem formSwitchItem = (FormSwitchItem) this.D.findViewById(R.id.tkw);
        this.I = formSwitchItem;
        if (!this.N) {
            i16 = 8;
        }
        formSwitchItem.setVisibility(i16);
        if (this.N) {
            if (isInNightMode) {
                str2 = "#282828";
            } else {
                str2 = "#FFFFFF";
            }
            this.I.setBackgroundColor(Color.parseColor(str2));
            this.I.setChecked(this.P);
            this.I.setOnCheckedChangeListener(this);
            this.I.setOnClickListener(this);
            ReportController.o(null, "dc00898", "", "", "0X800B32E", "0X800B32E", com.tencent.mobileqq.c2cshortcutbar.e.d(this.C).f(this.M), 0, "", "", "", "");
        }
        setContentView(this.D);
    }

    @Override // com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.show();
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.U);
        }
    }
}
