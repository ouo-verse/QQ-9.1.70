package dh2;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends QQCustomDialog {

    /* compiled from: P */
    /* renamed from: dh2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class ViewOnClickListenerC10181a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f393843d;

        ViewOnClickListenerC10181a(DialogInterface.OnClickListener onClickListener) {
            this.f393843d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f393843d.onClick(a.this, 1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f393845d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f393845d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f393845d.onClick(a.this, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(Context context) {
        super(context, R.style.qZoneInputDialog);
        setContentView(R.layout.f167856jn);
        setTitle((String) null);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        this.lBtn.setContentDescription(str + getContext().getString(R.string.a_n));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        this.rBtn.setContentDescription(str + getContext().getString(R.string.a_n));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new ViewOnClickListenerC10181a(onClickListener));
        return this;
    }
}
