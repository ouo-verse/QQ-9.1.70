package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import xc0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LoadMoreLayout extends FrameLayout implements ILoadMoreLayout {
    protected String C;
    protected String D;
    protected String E;
    protected String F;

    /* renamed from: d, reason: collision with root package name */
    protected Context f94512d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f94513e;

    /* renamed from: f, reason: collision with root package name */
    protected ProgressBar f94514f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f94515h;

    /* renamed from: i, reason: collision with root package name */
    protected int f94516i;

    /* renamed from: m, reason: collision with root package name */
    protected String f94517m;

    public LoadMoreLayout(Context context) {
        super(context);
        this.f94516i = -1;
        this.f94512d = context;
        b();
        c();
    }

    private boolean a(int i3, int i16) {
        if (i3 >= 0 && i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                if (i16 == 0 || i16 == 1 || i16 == 2 || i16 == 3) {
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        if (i16 == 0 || i16 == 1 || i16 == 3) {
                            return true;
                        }
                        return false;
                    }
                    if (i16 == 0 || i16 == 1 || i16 == 2 || i16 == 4 || i16 == 5) {
                        return true;
                    }
                    return false;
                }
                if (i16 == 0 || i16 == 3 || i16 == 4 || i16 == 5) {
                    return true;
                }
                return false;
            }
            if (i16 != 0 && i16 != 3 && i16 != 4 && i16 != 5) {
                return false;
            }
        }
        return true;
    }

    private void b() {
        this.f94517m = HardCodeUtil.qqStr(R.string.nsa);
        this.D = HardCodeUtil.qqStr(R.string.nsc);
        this.E = HardCodeUtil.qqStr(R.string.ns_);
        this.C = c.c(R.string.fxg);
        this.F = HardCodeUtil.qqStr(R.string.nsb);
    }

    private void c() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f94512d).inflate(R.layout.bak, (ViewGroup) null);
        this.f94513e = linearLayout;
        this.f94514f = (ProgressBar) linearLayout.findViewById(R.id.g1o);
        this.f94515h = (TextView) this.f94513e.findViewById(R.id.jfb);
        super.addView(this.f94513e, new FrameLayout.LayoutParams(-1, -2));
        d(0);
    }

    private boolean d(int i3) {
        if (!a(this.f94516i, i3)) {
            return false;
        }
        this.f94516i = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.f94514f.setVisibility(8);
                                this.f94515h.setText(this.F);
                                this.f94513e.setVisibility(0);
                            }
                        } else {
                            this.f94513e.setVisibility(8);
                        }
                    } else {
                        this.f94514f.setVisibility(8);
                        this.f94515h.setText(this.f94517m);
                        this.f94513e.setVisibility(0);
                    }
                } else {
                    this.f94514f.setVisibility(0);
                    this.f94515h.setText(this.D);
                    this.f94513e.setVisibility(0);
                }
            } else {
                this.f94514f.setVisibility(0);
                this.f94515h.setText(this.C);
                this.f94513e.setVisibility(0);
            }
        } else {
            this.f94513e.setVisibility(8);
        }
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean checkState(int i3) {
        return a(this.f94516i, i3);
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public int getState() {
        return this.f94516i;
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean setState(int i3) {
        return d(i3);
    }

    public LoadMoreLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94516i = -1;
        this.f94512d = context;
        b();
        c();
    }

    public LoadMoreLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94516i = -1;
        this.f94512d = context;
        b();
        c();
    }
}
