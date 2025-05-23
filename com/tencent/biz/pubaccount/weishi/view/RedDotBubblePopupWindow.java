package com.tencent.biz.pubaccount.weishi.view;

import UserGrowth.stNotificationRedDot;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes32.dex */
public class RedDotBubblePopupWindow extends PopupWindow implements View.OnClickListener {
    private static final int F = ViewUtils.dip2px(8.0f);
    protected Handler C;
    private a D;
    private DisPopupRunnable E;

    /* renamed from: d, reason: collision with root package name */
    private Activity f82381d;

    /* renamed from: e, reason: collision with root package name */
    private View f82382e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f82383f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f82384h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f82385i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<View> f82386m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class DisPopupRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<RedDotBubblePopupWindow> f82388d;

        DisPopupRunnable(RedDotBubblePopupWindow redDotBubblePopupWindow) {
            this.f82388d = new WeakReference<>(redDotBubblePopupWindow);
        }

        @Override // java.lang.Runnable
        public void run() {
            RedDotBubblePopupWindow.this.f();
        }
    }

    /* loaded from: classes32.dex */
    public interface a {
        void a();
    }

    public RedDotBubblePopupWindow(Activity activity, a aVar) {
        super(activity);
        this.f82386m = new ArrayList<>();
        this.C = new Handler(Looper.getMainLooper());
        this.f82381d = activity;
        this.D = aVar;
    }

    private void e() {
        Iterator<View> it = this.f82386m.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            View next = it.next();
            if (next.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = next.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3 == 0 ? 0 : F;
                }
                i3++;
            }
        }
    }

    public void f() {
        DisPopupRunnable disPopupRunnable;
        if (isShowing()) {
            dismiss();
        }
        Handler handler = this.C;
        if (handler != null && (disPopupRunnable = this.E) != null) {
            handler.removeCallbacksAndMessages(disPopupRunnable);
            this.E = null;
        }
        this.f82382e = null;
        this.f82381d = null;
    }

    public void h(final View view, ArrayList<stNotificationRedDot> arrayList) {
        if (isShowing()) {
            dismiss();
        }
        if (view == null) {
            return;
        }
        if (this.f82382e == null) {
            setBackgroundDrawable(new BitmapDrawable());
            View inflate = LayoutInflater.from(this.f82381d).inflate(R.layout.fvl, (ViewGroup) null);
            this.f82382e = inflate;
            g(inflate, arrayList);
            setContentView(this.f82382e);
            setWidth(-2);
            setHeight(-2);
            e();
        }
        view.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.view.RedDotBubblePopupWindow.1
            @Override // java.lang.Runnable
            public void run() {
                if (RedDotBubblePopupWindow.this.f82382e == null) {
                    return;
                }
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                RedDotBubblePopupWindow.this.f82382e.measure(0, 0);
                int measuredWidth = RedDotBubblePopupWindow.this.f82382e.getMeasuredWidth();
                x.f("RedDotBubblePopupWindow", "popupWidth:" + measuredWidth + " popupHeight:" + RedDotBubblePopupWindow.this.f82382e.getMeasuredHeight() + "   location[0]:" + iArr[0] + " location[1]:" + iArr[1] + " getWidth:" + view.getWidth() + " getHeight:" + view.getHeight());
                if (RedDotBubblePopupWindow.this.f82381d == null || RedDotBubblePopupWindow.this.f82381d.isFinishing()) {
                    return;
                }
                if (RedDotBubblePopupWindow.this.E == null) {
                    RedDotBubblePopupWindow redDotBubblePopupWindow = RedDotBubblePopupWindow.this;
                    redDotBubblePopupWindow.E = new DisPopupRunnable(redDotBubblePopupWindow);
                }
                RedDotBubblePopupWindow redDotBubblePopupWindow2 = RedDotBubblePopupWindow.this;
                View view2 = view;
                redDotBubblePopupWindow2.showAtLocation(view2, 0, (iArr[0] + (view2.getWidth() / 2)) - (measuredWidth / 2), iArr[1] + view.getHeight() + ViewUtils.dip2px(2.0f));
                RedDotBubblePopupWindow redDotBubblePopupWindow3 = RedDotBubblePopupWindow.this;
                redDotBubblePopupWindow3.C.postDelayed(redDotBubblePopupWindow3.E, 3000L);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ypv) {
            a aVar = this.D;
            if (aVar != null) {
                aVar.a();
            }
            f();
        }
    }

    private void g(View view, ArrayList<stNotificationRedDot> arrayList) {
        String str;
        String str2;
        view.findViewById(R.id.ypv).setOnClickListener(this);
        this.f82386m.clear();
        this.f82386m.add(view.findViewById(R.id.e9g));
        this.f82386m.add(view.findViewById(R.id.f165135v04));
        this.f82386m.add(view.findViewById(R.id.f216901p));
        this.f82383f = (TextView) view.findViewById(R.id.yi7);
        this.f82384h = (TextView) view.findViewById(R.id.v0l);
        this.f82385i = (TextView) view.findViewById(R.id.f217001q);
        String str3 = "";
        if (arrayList == null) {
            str = "";
            str2 = str;
        } else {
            Iterator<stNotificationRedDot> it = arrayList.iterator();
            str = "";
            str2 = str;
            while (it.hasNext()) {
                stNotificationRedDot next = it.next();
                int i3 = next.type;
                if (i3 == 2) {
                    str3 = next.text;
                } else if (i3 == 3) {
                    str = next.text;
                } else if (i3 == 1) {
                    str2 = next.text;
                }
            }
        }
        if (TextUtils.isEmpty(str3)) {
            this.f82386m.get(0).setVisibility(8);
        } else {
            this.f82386m.get(0).setVisibility(0);
            this.f82383f.setText(str3);
        }
        if (TextUtils.isEmpty(str)) {
            this.f82386m.get(1).setVisibility(8);
        } else {
            this.f82386m.get(1).setVisibility(0);
            this.f82384h.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f82386m.get(2).setVisibility(8);
        } else {
            this.f82386m.get(2).setVisibility(0);
            this.f82385i.setText(str2);
        }
    }
}
