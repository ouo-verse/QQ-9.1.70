package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StatusView extends BaseWidgetView {
    private View E;
    private ImageView F;
    private TextView G;
    private ImageView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private LinearLayout L;
    private String M;
    private String N;
    private int P;
    private int Q;

    public StatusView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = getResources().getString(R.string.f171701ka4);
        this.P = 18;
        this.Q = -16777216;
    }

    private void v(boolean z16) {
        if (!z16 && getVisibility() == 0) {
            setVisibility(8);
        }
        if (z16 && getVisibility() == 8) {
            setVisibility(0);
        }
    }

    public void A(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        setHintImageFilePath(SubscribeUtils.j() + "/certified_account_feeds_empty.png");
        y(HardCodeUtil.qqStr(R.string.vyo), 13, getResources().getColor(R.color.f157977zw));
        LinearLayout linearLayout = this.L;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.J.setOnClickListener(onClickListener);
            this.K.setOnClickListener(onClickListener2);
        }
    }

    public void B(String str) {
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (!str.equals(this.M)) {
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.b8c);
                    obtain.mFailedDrawable = getResources().getDrawable(R.drawable.b8c);
                    this.H.setImageDrawable(URLDrawable.getFileDrawable(str, obtain));
                    this.M = str;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            v(true);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c6u;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = view.findViewById(R.id.idg);
        this.F = (ImageView) view.findViewById(R.id.lnm);
        this.H = (ImageView) view.findViewById(R.id.f165946lo2);
        this.G = (TextView) view.findViewById(R.id.mcb);
        this.I = (TextView) view.findViewById(R.id.e8d);
        this.J = (TextView) view.findViewById(R.id.e_c);
        this.K = (TextView) view.findViewById(R.id.e9s);
        this.L = (LinearLayout) view.findViewById(R.id.f166106bl0);
        setHintImageFilePath(SubscribeUtils.j() + "/certified_account_feed_error.png");
        setBackgroundColor(-1);
    }

    public ImageView s() {
        return this.H;
    }

    public void setHintImageFilePath(String str) {
        if (this.F != null) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.b8c);
                obtain.mFailedDrawable = getResources().getDrawable(R.drawable.b8c);
                this.F.setImageDrawable(URLDrawable.getFileDrawable(str, obtain));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void setTextHint(String str) {
        setTextHint(str, this.P, this.Q);
    }

    public void t() {
        v(false);
    }

    public void u() {
        this.H.setVisibility(8);
        v(false);
    }

    public void w() {
        TextView textView = this.G;
        if (textView != null && textView.getVisibility() == 8) {
            this.G.setVisibility(0);
        }
        ImageView imageView = this.F;
        if (imageView != null && imageView.getVisibility() == 8) {
            this.F.setVisibility(0);
        }
        v(true);
    }

    public void x(String str) {
        y(str, this.P, this.Q);
    }

    public void y(String str, int i3, int i16) {
        setTextHint(str, i3, i16);
        w();
    }

    public void z(View.OnClickListener onClickListener) {
        setHintImageFilePath(SubscribeUtils.j() + "/certified_account_feeds_empty.png");
        y(HardCodeUtil.qqStr(R.string.vyl), 13, getResources().getColor(R.color.f157977zw));
        TextView textView = this.I;
        if (textView != null) {
            textView.setVisibility(0);
            this.I.setOnClickListener(onClickListener);
        }
    }

    public void setTextHint(String str, float f16, int i3) {
        if (str == null) {
            str = this.N;
        }
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(str);
            this.G.setTextSize(f16);
            this.G.setTextColor(i3);
        }
    }

    public StatusView(Context context) {
        super(context);
        this.N = getResources().getString(R.string.f171701ka4);
        this.P = 18;
        this.Q = -16777216;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
    }
}
