package com.tencent.mobileqq.nearby.redtouch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes15.dex */
public class RedPointView extends FrameLayout {
    protected boolean C;
    protected Handler D;
    protected int E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    protected int P;
    protected boolean Q;
    protected boolean R;
    protected List<BusinessInfoCheckUpdate.RedTypeInfo> S;

    /* renamed from: d, reason: collision with root package name */
    protected int f253049d;

    /* renamed from: e, reason: collision with root package name */
    protected int f253050e;

    /* renamed from: f, reason: collision with root package name */
    protected int f253051f;

    /* renamed from: h, reason: collision with root package name */
    protected int f253052h;

    /* renamed from: i, reason: collision with root package name */
    protected Context f253053i;

    /* renamed from: m, reason: collision with root package name */
    protected View f253054m;

    public RedPointView(Context context) {
        this(context, null);
    }

    private void a() {
        this.J = this.E;
        this.K = this.F;
        this.L = this.G;
        this.M = this.H;
        this.N = this.I;
        this.P = 99;
        this.S = new ArrayList();
        this.D = new Handler(Looper.getMainLooper());
        this.f253049d = 10;
        this.f253050e = 20;
        this.f253051f = 30;
        this.f253052h = 40;
    }

    public void setMaxNum(int i3) {
        this.P = i3;
    }

    public RedPointView(Context context, View view) {
        super(context);
        this.C = false;
        this.E = 21;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.Q = false;
        this.R = true;
        this.f253053i = context;
        this.f253054m = view;
        a();
    }
}
