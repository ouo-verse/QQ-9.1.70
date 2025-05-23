package p5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.album.util.c;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends ReportDialog {
    private TextView C;
    private TextView D;
    private TextView E;
    private View F;
    private AsyncImageView G;
    private TextView H;
    private TextView I;

    /* compiled from: P */
    /* renamed from: p5.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class ViewOnClickListenerC10980a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f425340d;

        ViewOnClickListenerC10980a(DialogInterface.OnClickListener onClickListener) {
            this.f425340d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f425340d;
            if (onClickListener != null) {
                onClickListener.onClick(a.this, 0);
            }
            try {
                if (a.this.isShowing()) {
                    a.this.dismiss();
                }
            } catch (Exception e16) {
                QZLog.e("QzoneReshipDialog", 2, "negative btn click exception ", e16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f425342d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f425342d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f425342d;
            if (onClickListener != null) {
                onClickListener.onClick(a.this, 1);
            }
            try {
                if (a.this.isShowing()) {
                    a.this.dismiss();
                }
            } catch (Exception e16) {
                QZLog.e("QzoneReshipDialog", 2, "negative btn click exception ", e16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(Context context, int i3) {
        super(context, i3);
    }

    public a N(String str) {
        if (this.D == null) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            this.D.setText(str);
        }
        return this;
    }

    public a O(View.OnClickListener onClickListener) {
        View view = this.F;
        if (view != null && onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        return this;
    }

    public a P(String str) {
        if (this.E == null) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
            this.E.setText(str);
        }
        return this;
    }

    public a Q(String str, boolean z16) {
        AsyncImageView asyncImageView = this.G;
        if (asyncImageView == null) {
            return this;
        }
        if (!z16) {
            asyncImageView.setVisibility(8);
        } else {
            asyncImageView.setVisibility(0);
            this.G.setAsyncImage(str);
        }
        return this;
    }

    public a R(int i3, DialogInterface.OnClickListener onClickListener) {
        TextView textView = this.H;
        if (textView == null) {
            return this;
        }
        textView.setText(i3);
        this.H.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.H.setOnClickListener(new ViewOnClickListenerC10980a(onClickListener));
        return this;
    }

    public a S(int i3, DialogInterface.OnClickListener onClickListener) {
        TextView textView = this.I;
        if (textView == null) {
            return this;
        }
        textView.setText(i3);
        this.I.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.I.setOnClickListener(new b(onClickListener));
        return this;
    }

    public a U(String str) {
        if (this.C == null) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            this.C.setVisibility(8);
        } else {
            this.C.setVisibility(0);
            this.C.setText(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.bir);
        this.G = asyncImageView;
        c.b(asyncImageView);
        this.D = (TextView) findViewById(R.id.bio);
        this.E = (TextView) findViewById(R.id.biq);
        this.F = findViewById(R.id.bip);
        this.H = (TextView) findViewById(R.id.dialogLeftBtn);
        this.I = (TextView) findViewById(R.id.dialogRightBtn);
    }
}
