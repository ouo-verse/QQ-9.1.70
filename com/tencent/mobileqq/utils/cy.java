package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cy extends ReportDialog {
    TextView C;
    TextView D;
    TextView E;
    TextView F;
    TextView G;
    Button H;
    LinearLayout I;
    ListView J;
    TextView K;
    TextView L;
    ImageView M;
    View N;
    String[] P;
    LayoutInflater Q;
    DialogInterface.OnClickListener R;
    private BaseAdapter S;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = cy.this.P;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            cy cyVar = cy.this;
            if (cyVar.Q == null) {
                cyVar.Q = (LayoutInflater) cyVar.getContext().getSystemService("layout_inflater");
            }
            if (view == null) {
                view = cy.this.Q.inflate(R.layout.custom_dialog_list_item, (ViewGroup) null);
                e eVar = new e();
                eVar.f307589a = (TextView) view.findViewById(R.id.dr5);
                view.setTag(eVar);
            }
            e eVar2 = (e) view.getTag();
            TextView textView = eVar2.f307589a;
            if (textView != null) {
                textView.setText(cy.this.P[i3]);
                eVar2.f307589a.setOnClickListener(new d(i3));
                int paddingTop = eVar2.f307589a.getPaddingTop();
                int paddingLeft = eVar2.f307589a.getPaddingLeft();
                int paddingRight = eVar2.f307589a.getPaddingRight();
                int paddingBottom = eVar2.f307589a.getPaddingBottom();
                String[] strArr = cy.this.P;
                if (strArr.length == 1) {
                    eVar2.f307589a.setBackgroundResource(R.drawable.custom_dialog_list_item_single_bg_selector);
                } else if (i3 == 0) {
                    eVar2.f307589a.setBackgroundResource(R.drawable.custom_dialog_list_item_up_bg_selector);
                } else if (i3 == strArr.length - 1) {
                    eVar2.f307589a.setBackgroundResource(R.drawable.custom_dialog_list_item_down_bg_selector);
                }
                eVar2.f307589a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307583d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f307583d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307583d;
            if (onClickListener != null) {
                onClickListener.onClick(cy.this, 1);
            }
            cy.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307585d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f307585d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307585d;
            if (onClickListener != null) {
                onClickListener.onClick(cy.this, 0);
            }
            cy.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        int f307587d;

        public d(int i3) {
            this.f307587d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cy cyVar = cy.this;
            DialogInterface.OnClickListener onClickListener = cyVar.R;
            if (onClickListener != null) {
                onClickListener.onClick(cyVar, cyVar.customWhichToCallBack(this.f307587d));
                cy.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class e {

        /* renamed from: a, reason: collision with root package name */
        TextView f307589a;

        e() {
        }
    }

    public cy(Context context, int i3) {
        super(context, i3);
        this.S = new a();
    }

    public cy N(String str, float f16) {
        if (!TextUtils.isEmpty(str)) {
            this.D.setText(new QQText(str, 5, 20));
            this.D.setContentDescription(str);
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        return this;
    }

    public cy O(int i3, int i16, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.H.setVisibility(8);
            return this;
        }
        this.H.setBackgroundResource(i3);
        this.H.setContentDescription(getContext().getString(i16));
        this.H.setVisibility(0);
        this.H.setOnClickListener(new c(onClickListener));
        setSeperatorState();
        return this;
    }

    public cy P(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(new QQText(str, 5, 20));
        this.F.setContentDescription(str);
        this.F.setVisibility(0);
        this.F.setOnClickListener(new b(onClickListener));
        setSeperatorState();
        return this;
    }

    public cy Q(String str) {
        if (str != null) {
            this.C.setText(new QQText(str, 5, 24));
            this.D.setContentDescription(str);
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        this.D = (TextView) findViewById(R.id.dialogText);
        this.E = (TextView) findViewById(R.id.bit);
        this.G = (TextView) findViewById(R.id.biu);
        this.L = (TextView) findViewById(R.id.bqm);
        this.K = (TextView) findViewById(R.id.fyd);
        this.M = (ImageView) findViewById(R.id.cla);
        this.N = findViewById(R.id.cl_);
        this.H = (Button) findViewById(R.id.dialogLeftBtn);
        this.F = (TextView) findViewById(R.id.dialogRightBtn);
        this.H.setVisibility(8);
        this.F.setVisibility(8);
        this.I = (LinearLayout) findViewById(R.id.abb);
        this.J = (ListView) findViewById(R.id.eap);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.C.setText(i3);
        this.D.setContentDescription(getContext().getString(i3));
        this.C.setVisibility(0);
    }

    protected void setSeperatorState() {
    }

    protected int customWhichToCallBack(int i3) {
        return i3;
    }
}
