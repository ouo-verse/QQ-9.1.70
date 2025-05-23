package com.tencent.biz.qui.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends QFixToast {

    /* renamed from: f, reason: collision with root package name */
    private static b f95388f;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f95389c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f95390d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f95391e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f95392d;

        a(View.OnClickListener onClickListener) {
            this.f95392d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            d.a("QUICenterToast", d.f438811e, "[onClick] click text");
            this.f95392d.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(Context context) {
        super(context);
    }

    private static void h(Context context) {
        d.a("QUICenterToast", d.f438809c, "[initCustomToastView]");
        f95388f = new b(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168948hg1, (ViewGroup) null);
        f95388f.f95389c = (ImageView) inflate.findViewById(R.id.toast_icon);
        f95388f.f95390d = (TextView) inflate.findViewById(R.id.f110036hf);
        f95388f.f95391e = (TextView) inflate.findViewById(R.id.f1068069p);
        f95388f.setGravity(17, 0, 0);
        f95388f.setView(inflate);
    }

    public static b i(@NotNull Context context, Drawable drawable, String str, String str2, View.OnClickListener onClickListener) {
        int i3;
        if (f95388f == null) {
            f95388f = new b(context);
        }
        f95388f.cancel();
        h(context);
        ImageView imageView = f95388f.f95389c;
        int i16 = 8;
        if (drawable == null) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        if (drawable != null) {
            f95388f.f95389c.setImageDrawable(drawable);
            f95388f.f95389c.setColorFilter(ie0.a.f().g(context, R.color.qui_common_icon_white, 1000));
        }
        f95388f.f95390d.setText(str);
        TextView textView = f95388f.f95391e;
        if (!TextUtils.isEmpty(str2)) {
            i16 = 0;
        }
        textView.setVisibility(i16);
        if (!TextUtils.isEmpty(str2)) {
            f95388f.f95391e.setText(str2);
            f95388f.f95391e.setOnClickListener(new a(onClickListener));
        }
        f95388f.setDuration(1);
        return f95388f;
    }

    public static b j(Context context, String str) {
        return i(context, null, str, "", null);
    }
}
