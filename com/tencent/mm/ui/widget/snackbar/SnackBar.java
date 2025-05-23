package com.tencent.mm.ui.widget.snackbar;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.q;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SnackBar {
    public static final short LONG_SNACK = 2500;
    public static final short MED_SNACK = 3500;
    public static final short SHORT_SNACK = 1500;

    /* renamed from: a, reason: collision with root package name */
    public SnackContainer f153810a;

    /* renamed from: b, reason: collision with root package name */
    public View f153811b;

    /* renamed from: c, reason: collision with root package name */
    public OnMessageClickListener f153812c;

    /* renamed from: d, reason: collision with root package name */
    public OnVisibilityChangeListener f153813d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f153814e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f153815f = new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.snackbar.SnackBar.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SnackBar.this.f153812c != null && SnackBar.this.f153810a.isShowing()) {
                SnackBar.this.f153812c.onMessageClick();
            }
            SnackBar.this.f153814e.postDelayed(new Runnable() { // from class: com.tencent.mm.ui.widget.snackbar.SnackBar.1.1
                @Override // java.lang.Runnable
                public void run() {
                    SnackBar.this.f153810a.hide();
                }
            }, 100L);
        }
    };

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnMessageClickListener {
        void onMessageClick();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnVisibilityChangeListener {
        void onHide();

        void onShow();

        void startHide();
    }

    public SnackBar(Activity activity, int i3) {
        View findViewById = activity.findViewById(R.id.content);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        layoutInflater.inflate(com.tencent.mobileqq.R.layout.hqi, viewGroup);
        a(viewGroup, layoutInflater.inflate(com.tencent.mobileqq.R.layout.hqj, viewGroup, false), i3, activity);
    }

    public void clear(boolean z16) {
        this.f153810a.clearSnacks(z16);
    }

    public View getContainerView() {
        return this.f153811b;
    }

    public int getHeight() {
        View view = this.f153811b;
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f153811b.getHeight(), Integer.MIN_VALUE));
        return this.f153811b.getMeasuredHeight();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.f153810a.restoreState(bundle, this.f153811b);
    }

    public Bundle onSaveInstanceState() {
        return this.f153810a.saveState();
    }

    public void clear() {
        clear(true);
    }

    public final void a(ViewGroup viewGroup, View view, int i3, Context context) {
        if (viewGroup == null) {
            return;
        }
        SnackContainer snackContainer = (SnackContainer) viewGroup.findViewById(com.tencent.mobileqq.R.id.f86694sc);
        this.f153810a = snackContainer;
        if (snackContainer == null) {
            this.f153810a = new SnackContainer(viewGroup);
        }
        this.f153811b = view;
        if (i3 == 36) {
            this.f153810a.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.snackbar.SnackBar.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (SnackBarAlert.isShow() && SnackBar.this.f153810a.isShowing()) {
                        SnackBarAlert.setShowMode(false);
                        SnackBar.this.f153814e.postDelayed(new Runnable() { // from class: com.tencent.mm.ui.widget.snackbar.SnackBar.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SnackBar.this.f153810a.hide();
                            }
                        }, 100L);
                        return true;
                    }
                    return true;
                }
            });
        }
        ((TextView) view.findViewById(com.tencent.mobileqq.R.id.f86684sb)).setOnClickListener(this.f153815f);
        boolean d16 = q.d(context);
        int c16 = q.c(context);
        n.c("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", Boolean.valueOf(d16), Integer.valueOf(c16));
        boolean a16 = a((Activity) context);
        n.c("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", Boolean.valueOf(a16));
        if (a16 && d16) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(com.tencent.mobileqq.R.id.f86624s6);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams.bottomMargin = c16;
            linearLayout.setLayoutParams(marginLayoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public SnackBar f153820a;

        /* renamed from: b, reason: collision with root package name */
        public Context f153821b;

        /* renamed from: c, reason: collision with root package name */
        public String f153822c;

        /* renamed from: d, reason: collision with root package name */
        public String f153823d;

        /* renamed from: f, reason: collision with root package name */
        public Parcelable f153825f;

        /* renamed from: k, reason: collision with root package name */
        public View f153830k;

        /* renamed from: e, reason: collision with root package name */
        public int f153824e = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f153826g = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;

        /* renamed from: h, reason: collision with root package name */
        public int f153827h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f153828i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f153829j = 0;

        public Builder(Activity activity) {
            this.f153821b = activity.getApplicationContext();
            this.f153820a = new SnackBar(activity, this.f153828i);
        }

        public final int a() {
            return this.f153821b.getResources().getColor(com.tencent.mobileqq.R.color.cyl);
        }

        public String getActionMessage() {
            return this.f153823d;
        }

        public Context getContext() {
            return this.f153821b;
        }

        public String getMessage() {
            return this.f153822c;
        }

        public SnackBar show() {
            String str;
            String str2 = this.f153822c;
            String str3 = this.f153823d;
            if (str3 != null) {
                str = str3.toUpperCase();
            } else {
                str = null;
            }
            String str4 = str;
            int i3 = this.f153824e;
            Parcelable parcelable = this.f153825f;
            int i16 = this.f153826g;
            int i17 = this.f153827h;
            if (i17 == -1) {
                i17 = a();
            }
            this.f153820a.a(new Snack(str2, str4, i3, parcelable, i16, i17, this.f153829j, this.f153830k));
            return this.f153820a;
        }

        public Builder withActionIconId(int i3) {
            this.f153824e = i3;
            return this;
        }

        public Builder withActionMessage(String str) {
            this.f153823d = str;
            return this;
        }

        public Builder withActionMessageId(int i3) {
            if (i3 > 0) {
                this.f153823d = this.f153821b.getString(i3);
            }
            return this;
        }

        public Builder withBottomMargin(int i3) {
            this.f153829j = i3;
            return this;
        }

        public Builder withCustomView(View view) {
            this.f153830k = view;
            return this;
        }

        public Builder withDuration(int i3) {
            this.f153826g = i3;
            return this;
        }

        public Builder withFromSource(int i3) {
            this.f153828i = i3;
            return this;
        }

        public Builder withMessage(String str) {
            this.f153822c = str;
            return this;
        }

        public Builder withMessageId(int i3) {
            this.f153822c = this.f153821b.getString(i3);
            return this;
        }

        public Builder withOnClickListener(OnMessageClickListener onMessageClickListener) {
            this.f153820a.a(onMessageClickListener);
            return this;
        }

        public Builder withTextColorId(int i3) {
            this.f153827h = this.f153821b.getResources().getColor(i3);
            return this;
        }

        public Builder withToken(Parcelable parcelable) {
            this.f153825f = parcelable;
            return this;
        }

        public Builder withVisibilityChangeListener(OnVisibilityChangeListener onVisibilityChangeListener) {
            this.f153820a.a(onVisibilityChangeListener);
            return this;
        }

        public Builder(Context context, View view) {
            this.f153821b = context;
            this.f153820a = new SnackBar(context, view, 0);
        }
    }

    public SnackBar(Context context, View view, int i3) {
        if (view == null && (context instanceof Activity)) {
            view = ((Activity) context).findViewById(R.id.content);
        }
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        ViewGroup viewGroup = (ViewGroup) view;
        layoutInflater.inflate(com.tencent.mobileqq.R.layout.hqi, viewGroup);
        a(viewGroup, layoutInflater.inflate(com.tencent.mobileqq.R.layout.hqj, viewGroup, false), i3, context);
    }

    public final void a(Snack snack) {
        SnackContainer snackContainer = this.f153810a;
        if (snackContainer != null) {
            snackContainer.showSnack(snack, this.f153811b, this.f153813d);
        }
    }

    public final SnackBar a(OnMessageClickListener onMessageClickListener) {
        this.f153812c = onMessageClickListener;
        return this;
    }

    public final SnackBar a(OnVisibilityChangeListener onVisibilityChangeListener) {
        this.f153813d = onVisibilityChangeListener;
        return this;
    }

    public final boolean a(Activity activity) {
        int i3 = activity.getWindow().getAttributes().flags;
        return i3 == (((-134217729) & i3) | 134217728);
    }
}
