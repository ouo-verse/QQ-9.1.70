package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.ui.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

/* loaded from: classes3.dex */
public class MultiVideoEnterPageMembersControlUI extends MultiMembersVideoUI {
    public static int V = 1;
    public static int W = 2;
    int M;
    TextView N;
    TextView P;
    Button Q;
    Button R;
    TextView S;
    ProgressBar T;
    View U;

    public MultiVideoEnterPageMembersControlUI(Context context) {
        super(context);
        this.M = W;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        m(context);
    }

    @Override // com.tencent.av.ui.MultiMembersVideoUI
    public void j(ArrayList<com.tencent.av.e> arrayList) {
        super.j(arrayList);
        n();
    }

    @TargetApi(9)
    void m(Context context) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f74914d = weakReference;
        BaseActivity baseActivity = (BaseActivity) weakReference.get();
        if (baseActivity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
                return;
            }
            return;
        }
        VideoAppInterface videoAppInterface = (VideoAppInterface) baseActivity.getAppRuntime();
        this.E = videoAppInterface;
        if (videoAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
            }
            baseActivity.finish();
            return;
        }
        if (com.tencent.av.r.h0() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
            }
            baseActivity.finish();
            return;
        }
        this.F = LayoutInflater.from(this.f74914d.get());
        LayoutInflater.from(context).inflate(m.k.f76054b, this);
        this.D = this;
        this.f74918i = (GridView) super.findViewById(R.id.f49);
        this.C = (HorizontalScrollView) super.findViewById(R.id.f47);
        this.N = (TextView) super.findViewById(R.id.g8j);
        this.P = (TextView) super.findViewById(R.id.g8i);
        this.U = super.findViewById(R.id.g8d);
        this.Q = (Button) super.findViewById(R.id.g8h);
        this.R = (Button) super.findViewById(R.id.g8a);
        this.f74918i.setNumColumns(-1);
        this.f74918i.setGravity(17);
        this.f74918i.setSelector(new ColorDrawable(0));
        this.f74918i.setOverScrollMode(2);
        MultiMembersVideoUI.c cVar = new MultiMembersVideoUI.c();
        this.f74919m = cVar;
        this.f74918i.setAdapter((ListAdapter) cVar);
        this.f74918i.setOnItemClickListener(this.K);
        this.f74918i.setOnTouchListener(this.L);
        this.S = (TextView) super.findViewById(R.id.g8g);
        ProgressBar progressBar = (ProgressBar) super.findViewById(R.id.g8e);
        this.T = progressBar;
        progressBar.setVisibility(0);
    }

    void n() {
        int i3 = this.M;
        if (i3 == V) {
            int size = this.G.size();
            if (size > 0) {
                this.N.setText(String.format(HardCodeUtil.qqStr(R.string.oc7), Integer.valueOf(size)));
            } else {
                this.N.setText(HardCodeUtil.qqStr(R.string.f172211oc4));
            }
            this.P.setText(HardCodeUtil.qqStr(R.string.oc9));
            this.Q.setText(HardCodeUtil.qqStr(R.string.oc6));
            return;
        }
        if (i3 == W) {
            int size2 = this.G.size();
            if (size2 > 0) {
                this.N.setText(String.format(getResources().getString(R.string.dfh), Integer.valueOf(size2)));
            } else {
                this.N.setText(R.string.d97);
            }
            this.P.setText(R.string.dfe);
            this.Q.setText(R.string.dfc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i3) {
        this.M = i3;
        n();
        int i16 = this.M;
        if (i16 == V) {
            Drawable drawable = super.getResources().getDrawable(R.drawable.dch);
            int i17 = (int) (super.getResources().getDisplayMetrics().density * 20.0f);
            drawable.setBounds(0, 0, i17, i17);
            this.N.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        if (i16 == W) {
            Drawable drawable2 = super.getResources().getDrawable(R.drawable.dci);
            int i18 = (int) (super.getResources().getDisplayMetrics().density * 20.0f);
            drawable2.setBounds(0, 0, i18, i18);
            this.N.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    public void setLowHeightMode() {
        float f16 = super.getResources().getDisplayMetrics().density;
        if (super.getResources().getDisplayMetrics().heightPixels / f16 < 600.0f) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int i3 = (int) (10.0f * f16);
            layoutParams.setMargins(0, i3, 0, 0);
            this.N.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
            layoutParams2.setMargins(0, (int) (4.0f * f16), 0, 0);
            this.P.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams3.setMargins(0, i3, 0, 0);
            this.C.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
            int i16 = (int) (f16 * 20.0f);
            layoutParams4.setMargins(0, i3, 0, i16);
            this.Q.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            layoutParams5.setMargins(0, i3, 0, i16);
            this.R.setLayoutParams(layoutParams5);
        }
    }

    @TargetApi(9)
    public MultiVideoEnterPageMembersControlUI(Context context, AttributeSet attributeSet) {
        super(context);
        this.M = W;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        m(context);
    }
}
