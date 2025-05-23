package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomDialogThreeBtns extends ReportDialog {
    private BaseAdapter adapter;
    LinearLayout bodyLayout;
    LayoutInflater inflater;
    String[] items;
    TextView lBtn;
    ListView list;
    TextView mBtn;
    DialogInterface.OnClickListener onArrayItemClick;
    TextView previewImage;
    TextView rBtn;
    TextView text;
    TextView title;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class CustomDialogItemOnClickListener implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        int f307169i;

        public CustomDialogItemOnClickListener(int i3) {
            this.f307169i = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomDialogThreeBtns qQCustomDialogThreeBtns = QQCustomDialogThreeBtns.this;
            DialogInterface.OnClickListener onClickListener = qQCustomDialogThreeBtns.onArrayItemClick;
            if (onClickListener != null) {
                onClickListener.onClick(qQCustomDialogThreeBtns, qQCustomDialogThreeBtns.customWhichToCallBack(this.f307169i));
                QQCustomDialogThreeBtns.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class Holder {
        TextView text;

        Holder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = QQCustomDialogThreeBtns.this.items;
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
            QQCustomDialogThreeBtns qQCustomDialogThreeBtns = QQCustomDialogThreeBtns.this;
            if (qQCustomDialogThreeBtns.inflater == null) {
                qQCustomDialogThreeBtns.inflater = (LayoutInflater) qQCustomDialogThreeBtns.getContext().getSystemService("layout_inflater");
            }
            if (view == null) {
                view = QQCustomDialogThreeBtns.this.inflater.inflate(R.layout.custom_dialog_list_item, (ViewGroup) null);
                Holder holder = new Holder();
                holder.text = (TextView) view.findViewById(R.id.dr5);
                view.setTag(holder);
            }
            Holder holder2 = (Holder) view.getTag();
            TextView textView = holder2.text;
            if (textView != null) {
                textView.setText(QQCustomDialogThreeBtns.this.items[i3]);
                holder2.text.setOnClickListener(new CustomDialogItemOnClickListener(i3));
                int paddingTop = holder2.text.getPaddingTop();
                int paddingLeft = holder2.text.getPaddingLeft();
                int paddingRight = holder2.text.getPaddingRight();
                int paddingBottom = holder2.text.getPaddingBottom();
                String[] strArr = QQCustomDialogThreeBtns.this.items;
                if (strArr.length == 1) {
                    holder2.text.setBackgroundResource(R.drawable.custom_dialog_list_item_single_bg_selector);
                } else if (i3 == 0) {
                    holder2.text.setBackgroundResource(R.drawable.custom_dialog_list_item_up_bg_selector);
                } else if (i3 == strArr.length - 1) {
                    holder2.text.setBackgroundResource(R.drawable.custom_dialog_list_item_down_bg_selector);
                }
                holder2.text.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307171d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f307171d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307171d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogThreeBtns.this, 0);
            }
            QQCustomDialogThreeBtns.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307173d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f307173d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307173d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogThreeBtns.this, 0);
            }
            QQCustomDialogThreeBtns.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307175d;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f307175d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307175d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogThreeBtns.this, 0);
            }
            QQCustomDialogThreeBtns.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307177d;

        e(DialogInterface.OnClickListener onClickListener) {
            this.f307177d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307177d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogThreeBtns.this, 0);
            }
            QQCustomDialogThreeBtns.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307179d;

        f(DialogInterface.OnClickListener onClickListener) {
            this.f307179d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307179d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogThreeBtns.this, 0);
            }
            QQCustomDialogThreeBtns.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307181d;

        g(DialogInterface.OnClickListener onClickListener) {
            this.f307181d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307181d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogThreeBtns.this, 0);
            }
            QQCustomDialogThreeBtns.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QQCustomDialogThreeBtns(Context context) {
        super(context);
        this.adapter = new a();
    }

    private void setDefaultHightLightBtn() {
        if (this.rBtn.getVisibility() != 0 && this.mBtn.getVisibility() != 0) {
            this.lBtn.getVisibility();
        }
    }

    private void setSeperatorState() {
        setDefaultHightLightBtn();
    }

    public QQCustomDialogThreeBtns addView(View view) {
        this.text.setVisibility(8);
        this.bodyLayout.addView(view, new LinearLayout.LayoutParams(-1, -2));
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
        this.title = (TextView) findViewById(R.id.dialogTitle);
        this.text = (TextView) findViewById(R.id.dialogText);
        this.previewImage = (TextView) findViewById(R.id.fyd);
        this.lBtn = (TextView) findViewById(R.id.dialogLeftBtn);
        this.mBtn = (TextView) findViewById(R.id.bj7);
        this.rBtn = (TextView) findViewById(R.id.dialogRightBtn);
        this.lBtn.setVisibility(8);
        this.mBtn.setVisibility(8);
        this.rBtn.setVisibility(8);
        this.bodyLayout = (LinearLayout) findViewById(R.id.abb);
        this.list = (ListView) findViewById(R.id.eap);
    }

    public QQCustomDialogThreeBtns setItems(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        this.items = strArr;
        this.text.setVisibility(8);
        this.lBtn.setVisibility(8);
        this.mBtn.setVisibility(8);
        this.rBtn.setVisibility(8);
        this.bodyLayout.setVisibility(8);
        this.onArrayItemClick = onClickListener;
        this.list.setVisibility(0);
        this.list.setAdapter((ListAdapter) this.adapter);
        this.list.setDivider(null);
        this.list.setDividerHeight(0);
        return this;
    }

    public QQCustomDialogThreeBtns setLeftButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new b(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialogThreeBtns setMessage(int i3) {
        this.text.setText(i3);
        this.text.setVisibility(0);
        return this;
    }

    public QQCustomDialogThreeBtns setMessageMaxLine(int i3) {
        TextView textView = this.text;
        if (textView != null) {
            textView.setMaxLines(i3);
            this.text.setEllipsize(TextUtils.TruncateAt.END);
        }
        return this;
    }

    public QQCustomDialogThreeBtns setMiddleButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.mBtn.setVisibility(8);
            return this;
        }
        this.mBtn.setText(str);
        this.mBtn.setVisibility(0);
        this.mBtn.setOnClickListener(new c(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialogThreeBtns setPreviewImage(Drawable drawable) {
        this.previewImage.setPadding(0, 0, 0, 0);
        this.previewImage.setCompoundDrawablePadding(0);
        this.previewImage.setCompoundDrawables(drawable, null, null, null);
        if (drawable != null) {
            this.previewImage.setVisibility(0);
        } else {
            this.previewImage.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialogThreeBtns setRightButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new d(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialogThreeBtns setText(String str, int i3) {
        TextView textView;
        if ((findViewById(i3) instanceof TextView) && (textView = (TextView) findViewById(i3)) != null) {
            textView.setText(str);
        }
        return this;
    }

    public QQCustomDialogThreeBtns setTitle(String str) {
        if (str != null) {
            this.title.setText(str);
            this.title.setVisibility(0);
        } else {
            this.title.setVisibility(8);
        }
        return this;
    }

    protected QQCustomDialogThreeBtns(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        this.adapter = new a();
    }

    public QQCustomDialogThreeBtns setMessage(String str) {
        if (str != null) {
            this.text.setText(str);
            this.text.setVisibility(0);
        } else {
            this.text.setVisibility(8);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.title.setText(i3);
        this.title.setVisibility(0);
    }

    public QQCustomDialogThreeBtns(Context context, int i3) {
        super(context, i3);
        this.adapter = new a();
    }

    public QQCustomDialogThreeBtns setLeftButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(i3);
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new e(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialogThreeBtns setMiddleButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.mBtn.setVisibility(8);
            return this;
        }
        this.mBtn.setText(i3);
        this.mBtn.setVisibility(0);
        this.mBtn.setOnClickListener(new f(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialogThreeBtns setRightButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new g(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialogThreeBtns setItems(int i3, DialogInterface.OnClickListener onClickListener) {
        String[] strArr;
        try {
            strArr = getContext().getResources().getStringArray(i3);
        } catch (Resources.NotFoundException e16) {
            e16.printStackTrace();
            strArr = null;
        }
        return setItems(strArr, onClickListener);
    }

    protected int customWhichToCallBack(int i3) {
        return i3;
    }
}
