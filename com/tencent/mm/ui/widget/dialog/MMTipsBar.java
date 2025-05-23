package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.lo.q;
import com.tencent.luggage.wxa.mo.x;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMTipsBar {
    public static final int BAR_BG_COLOR_RED = 1;
    public static final int BAR_BG_COLOR_WHITE = 0;
    public static final long DURATION_CONSTANT = 0;
    public static final long DURATION_SHORT = 2000;

    public static x showConstantNotice(Activity activity, int i3, int i16, int i17, int i18, String str, int i19, View.OnClickListener onClickListener, PopupWindow.OnDismissListener onDismissListener, View.OnClickListener onClickListener2) {
        x showConstantNotice = showConstantNotice(activity, i16, i17, i18, str, i19, onClickListener, onDismissListener, onClickListener2);
        showConstantNotice.getContentView().findViewById(R.id.f97975lu).setBackgroundColor(i3);
        return showConstantNotice;
    }

    public static x showNotice(Activity activity, int i3, int i16, String str, long j3) {
        return showNotice(activity, R.layout.hyc, i3, i16, str, j3);
    }

    public static x showNoticeRed(Activity activity, int i3, int i16, String str, long j3) {
        return showNotice(activity, R.layout.hyd, i3, i16, str, j3);
    }

    public static x showNotice(Activity activity, int i3, int i16, int i17, String str, long j3) {
        View inflate = View.inflate(activity, i3, null);
        TextView textView = (TextView) inflate.findViewById(R.id.f98015ly);
        textView.setText(str);
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.f97985lv);
        if (i16 == 0) {
            weImageView.setVisibility(8);
            int a16 = o.a(activity, 16);
            textView.setPadding(a16, 0, a16, 0);
        } else {
            weImageView.setImageResource(i16);
            weImageView.setIconColor(i17);
        }
        final x xVar = new x(inflate);
        xVar.setWidth(-1);
        xVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i18 = rect.top;
        int a17 = q.a(activity);
        if (i18 == 0) {
            i18 = q.f(activity);
        }
        xVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i18 + a17);
        if (j3 > 0) {
            new Handler() { // from class: com.tencent.mm.ui.widget.dialog.MMTipsBar.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    x.this.dismiss();
                    super.handleMessage(message);
                }
            }.sendEmptyMessageDelayed(0, j3);
        }
        return xVar;
    }

    public static x showConstantNotice(Activity activity, int i3, int i16, int i17, String str, int i18, View.OnClickListener onClickListener, PopupWindow.OnDismissListener onDismissListener, final View.OnClickListener onClickListener2) {
        View inflate = View.inflate(activity, R.layout.hye, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.t4e);
        if (i3 == 1) {
            linearLayout.setBackgroundResource(R.drawable.lux);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.f98015ly);
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.f97985lv);
        if (i16 == 0) {
            weImageView.setVisibility(8);
            int a16 = o.a(activity, 16);
            textView.setPadding(a16, 0, a16, 0);
        } else {
            weImageView.setImageResource(i16);
            weImageView.setIconColor(i17);
        }
        final x xVar = new x(inflate);
        xVar.setWidth(-1);
        xVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i19 = rect.top;
        int a17 = q.a(activity);
        if (i19 == 0) {
            i19 = q.f(activity);
        }
        xVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i19 + a17);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f98005lx);
        if (i18 == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i18);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMTipsBar.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.this.dismiss();
                View.OnClickListener onClickListener3 = onClickListener2;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        if (onDismissListener != null) {
            xVar.setOnDismissListener(onDismissListener);
        }
        return xVar;
    }
}
