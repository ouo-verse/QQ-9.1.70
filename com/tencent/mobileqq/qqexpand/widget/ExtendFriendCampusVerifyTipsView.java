package com.tencent.mobileqq.qqexpand.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendCampusVerifyTipsView extends FrameLayout implements View.OnClickListener {
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f264118d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f264119e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f264120f;

    /* renamed from: h, reason: collision with root package name */
    private Button f264121h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f264122i;

    /* renamed from: m, reason: collision with root package name */
    private int f264123m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void T5(int i3);

        void d7(int i3);
    }

    public ExtendFriendCampusVerifyTipsView(Context context) {
        this(context, null);
    }

    private void b() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.d7(this.f264123m);
        }
    }

    private void c() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.T5(this.f264123m);
        }
    }

    private void e() {
        int i3 = this.f264123m;
        if (i3 == 1) {
            this.f264118d.setVisibility(8);
            this.f264119e.setVisibility(0);
            this.f264120f.setVisibility(0);
            this.f264121h.setVisibility(0);
            this.f264119e.setText(R.string.f198994o8);
            this.f264120f.setText(R.string.f198984o7);
            this.f264121h.setText(R.string.f198974o6);
            this.f264121h.setTextColor(-1);
            this.f264121h.setBackgroundResource(R.drawable.kqb);
            return;
        }
        if (i3 == 2) {
            this.f264118d.setVisibility(0);
            this.f264119e.setVisibility(0);
            this.f264120f.setVisibility(8);
            this.f264121h.setVisibility(8);
            this.f264118d.setImageResource(R.drawable.nea);
            this.f264119e.setText(R.string.f199004o9);
            return;
        }
        if (i3 == 3) {
            this.f264118d.setVisibility(0);
            this.f264119e.setVisibility(0);
            this.f264120f.setVisibility(8);
            this.f264121h.setVisibility(0);
            this.f264118d.setImageResource(R.drawable.ne_);
            this.f264119e.setText(R.string.f198964o5);
            this.f264121h.setText(R.string.f198954o4);
            this.f264121h.setTextColor(-16777216);
            this.f264121h.setBackgroundResource(R.drawable.kqc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f97825lf) {
            b();
        } else {
            if (id5 != R.id.f97845lh) {
                return;
            }
            c();
        }
    }

    public void setOnClickListener(a aVar) {
        this.C = aVar;
    }

    public void setTipsType(int i3) {
        this.f264123m = i3;
        e();
    }

    public ExtendFriendCampusVerifyTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendFriendCampusVerifyTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264123m = 1;
        View.inflate(context, R.layout.gwm, this);
        d();
        e();
    }

    private void d() {
        this.f264118d = (ImageView) findViewById(R.id.f97905ln);
        this.f264119e = (TextView) findViewById(R.id.f97935lq);
        this.f264120f = (TextView) findViewById(R.id.f97915lo);
        Button button = (Button) findViewById(R.id.f97825lf);
        this.f264121h = button;
        ba.a aVar = ba.f77070d;
        button.setOnTouchListener(aVar);
        this.f264121h.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.f97845lh);
        this.f264122i = imageView;
        imageView.setOnTouchListener(aVar);
        this.f264122i.setOnClickListener(this);
    }

    public static void a(Activity activity, QQAppInterface qQAppInterface) {
        if (activity == null || qQAppInterface == null) {
            return;
        }
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        Object x16 = eVar.x();
        if (x16 instanceof com.tencent.mobileqq.profile.i) {
            com.tencent.mobileqq.profile.i iVar = (com.tencent.mobileqq.profile.i) x16;
            if (TextUtils.isEmpty(iVar.f260185d)) {
                CampusHelper.f(activity, eVar.G());
            } else {
                CampusHelper.e(activity, iVar.f260182a, iVar.f260185d, iVar.f260184c);
            }
        }
    }
}
