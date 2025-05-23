package com.tencent.biz.pubaccount;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a implements View.OnClickListener {
    protected float E;
    protected AccountDetailTopGestureLayout F;
    ImageView G;
    TextView H;
    protected ImageView I;
    Button J;
    private ViewGroup K;
    private PublicAccountDetailImpl L;
    private ViewGroup M;
    private BaseActivity N;
    private View.OnClickListener P;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f78839d;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f78841f;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f78842h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f78843i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f78844m;

    /* renamed from: e, reason: collision with root package name */
    int f78840e = 0;
    protected int C = 0;
    public boolean D = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0797a {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f78845a;

        public C0797a(LayoutInflater layoutInflater, ViewGroup viewGroup, String str, String str2) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.i99, viewGroup);
            this.f78845a = viewGroup2;
            TextView textView = (TextView) viewGroup2.findViewById(R.id.s8j);
            TextView textView2 = (TextView) this.f78845a.findViewById(R.id.s8i);
            textView.setText(str);
            textView2.setText(str2);
        }

        public View a() {
            return this.f78845a;
        }
    }

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener, ViewGroup viewGroup) {
        this.N = baseActivity;
        this.M = viewGroup;
        this.P = onClickListener;
        b();
    }

    private void a() {
        int statusBarHeight;
        int dpToPx;
        RelativeLayout relativeLayout = (RelativeLayout) this.M.findViewById(R.id.e8z);
        this.f78839d = relativeLayout;
        relativeLayout.setOnClickListener(null);
        if (c()) {
            float f16 = this.E;
            dpToPx = (int) (64.0f * f16);
            statusBarHeight = (int) (f16 * 4.0f);
        } else {
            statusBarHeight = ViewUtils.getStatusBarHeight(this.M.getContext());
            dpToPx = ViewUtils.dpToPx(64.0f) + statusBarHeight;
        }
        this.f78839d.setLayoutParams(new RelativeLayout.LayoutParams(-1, dpToPx));
        this.f78839d.setPadding(0, statusBarHeight, 0, 0);
        this.f78840e = dpToPx;
        AccountDetailTopGestureLayout accountDetailTopGestureLayout = this.F;
        if (accountDetailTopGestureLayout != null) {
            accountDetailTopGestureLayout.setTitleHeight(dpToPx);
        }
        ImageView imageView = (ImageView) this.M.findViewById(R.id.e8y);
        this.G = imageView;
        imageView.setImageResource(R.drawable.qui_chevron_left_icon_primary_selector);
        this.G.setOnClickListener(this);
        TextView textView = (TextView) this.M.findViewById(R.id.ivTitleBtnRightText);
        this.H = textView;
        textView.setText("");
        ImageView imageView2 = (ImageView) this.M.findViewById(R.id.ivTitleBtnRightImage);
        this.I = imageView2;
        imageView2.setImageResource(R.drawable.qui_more_icon_primary);
        this.I.setContentDescription(this.N.getString(R.string.epf));
        this.I.setVisibility(0);
        this.I.setOnClickListener(this);
        this.f78841f = (ImageView) this.M.findViewById(R.id.f165731da0);
        this.f78842h = (ImageView) this.M.findViewById(R.id.d_a);
        this.f78843i = (ImageView) this.M.findViewById(R.id.asv);
        Button button = (Button) this.M.findViewById(R.id.f163879b1);
        this.J = button;
        button.setOnClickListener(this);
    }

    private void b() {
        this.E = this.N.getResources().getDisplayMetrics().density;
        a();
        this.K = (ViewGroup) this.M.findViewById(R.id.s8l);
        TextView textView = (TextView) this.M.findViewById(R.id.s8k);
        this.f78844m = textView;
        textView.setSingleLine();
        TextView textView2 = this.f78844m;
        textView2.setTextColor(textView2.getResources().getColor(R.color.qui_common_text_primary, null));
    }

    private boolean c() {
        return false;
    }

    public void d(PublicAccountDetailImpl publicAccountDetailImpl) {
        this.L = publicAccountDetailImpl;
        this.K.removeAllViews();
        if (this.L == null) {
            return;
        }
        this.f78841f.setVisibility(0);
        this.f78841f.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.N.app, 1, this.L.uin));
        this.f78842h.setVisibility(0);
        this.f78843i.setVisibility(8);
        this.f78844m.setText(this.L.name);
        new Paint().setTextSize(this.f78844m.getTextSize());
        ViewGroup.LayoutParams layoutParams = this.f78844m.getLayoutParams();
        layoutParams.width = (int) (((int) r7.measureText(this.L.name)) + (this.E * 4.0f));
        this.f78844m.setLayoutParams(layoutParams);
        LayoutInflater from = LayoutInflater.from(this.N);
        String str = this.L.certifiedDescription;
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            int indexOf = str.indexOf(":");
            String substring = str.substring(0, indexOf);
            int i3 = indexOf + 1;
            if (str.length() > i3) {
                this.K.addView(new C0797a(from, null, substring, str.substring(i3)).a());
            }
        }
        if (!TextUtils.isEmpty(this.L.summary)) {
            this.K.addView(new C0797a(from, null, "\u4fe1\u606f\u7b80\u4ecb", this.L.summary).a());
        }
        if (!TextUtils.isEmpty(this.L.certifiedEnterprise)) {
            this.K.addView(new C0797a(from, null, "\u8ba4\u8bc1\u6765\u6e90", this.L.certifiedEnterprise).a());
        }
        String pickOutFreakingPhoneNumber = PublicAccountUtilImpl.pickOutFreakingPhoneNumber(this.L);
        if (TextUtils.isEmpty(pickOutFreakingPhoneNumber)) {
            return;
        }
        this.K.addView(new C0797a(from, null, "\u8054\u7cfb\u7535\u8bdd", pickOutFreakingPhoneNumber).a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.e8y) {
            this.N.doOnBackPressed();
        } else {
            this.P.onClick(view);
        }
    }
}
