package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.v;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.ba;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qphone.base.util.QLog;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends Part {

    /* renamed from: d, reason: collision with root package name */
    private Button f76416d;

    /* renamed from: e, reason: collision with root package name */
    private Button f76417e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f76418f;

    /* renamed from: h, reason: collision with root package name */
    m f76419h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f76420i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f76421m = null;
    ImageView C = null;
    ShimmerTextView D = null;
    ImageView E = null;
    View F = null;
    public v G = null;

    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.part.invite.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class ViewOnClickListenerC0769a implements View.OnClickListener {
        ViewOnClickListenerC0769a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long d16 = com.tencent.av.utils.e.d();
            m mVar = a.this.f76419h;
            if (mVar != null) {
                mVar.j(d16, true);
            } else {
                QLog.e("AVInviteAcceptPart", 1, "[mBtnAcceptByAudio onClick] get mInfoIoc error.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f76418f || !a.this.D9()) {
                long d16 = com.tencent.av.utils.e.d();
                m mVar = a.this.f76419h;
                if (mVar != null) {
                    mVar.j(d16, false);
                } else {
                    QLog.e("AVInviteAcceptPart", 1, "[mBtnAccept onClick] get mInfoIoc error.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DataReport.Y(false, false);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (a.this.f76417e != null) {
                a.this.f76417e.setEnabled(!bool.booleanValue());
            }
            if (a.this.f76416d != null) {
                a.this.f76416d.setEnabled(!bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (a.this.f76417e != null) {
                a.this.f76417e.setEnabled(!bool.booleanValue());
            }
            if (a.this.f76416d != null) {
                a.this.f76416d.setEnabled(!bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QavPanel.n nVar;
            v vVar = a.this.G;
            if (vVar == null || (nVar = vVar.f76630d) == null) {
                return;
            }
            nVar.a(true);
        }
    }

    public a(boolean z16) {
        this.f76418f = z16;
    }

    private void C9() {
        RelativeLayout.LayoutParams layoutParams;
        Button button;
        if (FontSettingManager.getFontLevel() == 20.0f || FontSettingManager.getFontLevel() == 18.0f || FontSettingManager.getFontLevel() == 17.0f) {
            if (FontSettingManager.getFontLevel() == 20.0f && !this.f76420i && (button = this.f76417e) != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) button.getLayoutParams();
                if (layoutParams2 == null) {
                    return;
                }
                layoutParams2.rightMargin = getActivity().getResources().getDimensionPixelSize(R.dimen.a1o);
                this.f76417e.setLayoutParams(layoutParams2);
            }
            if (getContext() == null) {
                return;
            }
            int screenWidth = ba.getScreenWidth(getContext());
            if ((screenWidth <= 800 || (ba.hasSmartBar() && screenWidth <= 1280)) && (layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams()) != null) {
                layoutParams.bottomMargin = 0;
                this.F.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D9() {
        VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (videoAppInterface == null || !videoAppInterface.b0()) {
            return false;
        }
        DataReport.Y(false, true);
        if (QLog.isColorLevel()) {
            QLog.d("AVInviteAcceptPart", 2, "startVideo phone is calling!");
        }
        String string = getContext().getString(R.string.d_l);
        PopupDialog.o0(getContext(), 230, getContext().getString(R.string.d_o), string, R.string.cancel, R.string.f171151ok, new c(), null);
        return true;
    }

    private void F9() {
        sw.a aVar = (sw.a) getViewModel(sw.a.class);
        if (aVar == null) {
            QLog.e("AVInviteAcceptPart", 1, "observeViewModel viewModel is null.");
        } else {
            aVar.M1().observe(getPartHost().getLifecycleOwner(), new d());
            aVar.N1().observe(getPartHost().getLifecycleOwner(), new e());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        Button button = this.f76416d;
        if (button != null) {
            button.setBackground(null);
            this.f76416d = null;
        }
        Button button2 = this.f76417e;
        if (button2 != null) {
            button2.setCompoundDrawables(null, null, null, null);
            this.f76417e = null;
        }
        ImageView imageView = this.f76421m;
        if (imageView != null) {
            imageView.setOnTouchListener(null);
            this.f76421m = null;
        }
        ImageView imageView2 = this.C;
        if (imageView2 != null) {
            imageView2.setBackground(null);
            this.C = null;
        }
        this.D = null;
        ImageView imageView3 = this.E;
        if (imageView3 != null) {
            imageView3.setBackground(null);
            this.E = null;
        }
        this.F = null;
        this.G = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements QavPanel.n {
        g() {
        }

        @Override // com.tencent.av.ui.QavPanel.n
        public void a(boolean z16) {
            if (z16) {
                long d16 = com.tencent.av.utils.e.d();
                m mVar = a.this.f76419h;
                if (mVar == null) {
                    QLog.e("AVInviteAcceptPart", 1, "[slideFinish] getIOC error.");
                } else {
                    mVar.j(d16, false);
                }
            }
        }
    }

    void E9(View view) {
        this.C = (ImageView) view.findViewById(R.id.f166577ga2);
        this.D = (ShimmerTextView) view.findViewById(R.id.f166578ga3);
        this.E = (ImageView) view.findViewById(R.id.g7e);
        this.F = view.findViewById(m.l.f76069o);
        this.f76421m = (ImageView) view.findViewById(m.l.f76070p);
        this.G = new v(getContext(), this.f76421m, this.C, this.D, this.E);
        ImageView imageView = this.f76421m;
        if (imageView == null) {
            QLog.e("AVInviteAcceptPart", 1, "mSlideAccept is null");
            return;
        }
        if (this.f76420i) {
            imageView.setBackgroundResource(R.drawable.d_2);
        } else {
            imageView.setBackgroundResource(R.drawable.d_8);
        }
        if (nw.b.c()) {
            this.f76421m.setContentDescription(getContext().getResources().getString(R.string.ic8));
            this.f76421m.setFocusable(true);
            this.f76421m.setClickable(true);
            this.f76421m.setOnClickListener(new f());
        } else {
            this.f76421m.setOnTouchListener(this.G);
        }
        this.G.c(new g());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        Button button;
        if (view == null) {
            QLog.e("AVInviteAcceptPart", 1, "onInitView rootView is null");
            return;
        }
        super.onInitView(view);
        mw.m mVar = (mw.m) RFWIocAbilityProvider.g().getIocInterface(mw.m.class, getPartRootView(), null);
        this.f76419h = mVar;
        this.f76420i = mVar.f();
        Button button2 = (Button) view.findViewById(m.l.f76065k);
        this.f76417e = button2;
        if (button2 != null) {
            if (getContext() != null && getContext().getResources() != null) {
                com.tencent.av.utils.e.a(getContext().getResources(), this.f76417e, R.drawable.d_5, R.color.f157463q4, R.color.f157463q4);
            }
            this.f76417e.setOnClickListener(new ViewOnClickListenerC0769a());
        }
        if (this.f76418f) {
            E9(view);
        } else {
            Button button3 = (Button) view.findViewById(m.l.f76064j);
            this.f76416d = button3;
            if (button3 != null) {
                button3.setOnClickListener(new b());
            }
        }
        if (!this.f76418f) {
            if (this.f76420i) {
                ba.setAccText(this.f76416d, getContext().getString(R.string.f170475se), this.f76419h.getSessionInfo() != null ? this.f76419h.getSessionInfo().f73063p : 0);
            } else {
                ba.setAccText(this.f76416d, getContext().getString(R.string.f237627hk));
            }
        } else {
            C9();
        }
        if (this.f76420i && (button = this.f76416d) != null) {
            button.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.f161313ur));
        }
        int i3 = this.f76419h.getSessionInfo() != null ? this.f76419h.getSessionInfo().f73067q : -1;
        Button button4 = this.f76417e;
        if (button4 != null) {
            if (i3 == 9500) {
                button4.setVisibility(8);
            } else if (this.f76420i) {
                button4.setVisibility(this.f76418f ? 8 : 4);
            }
        }
        F9();
    }
}
