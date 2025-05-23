package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f76263e;

    /* renamed from: f, reason: collision with root package name */
    private View f76264f = null;

    public void A9(QavPanel qavPanel, String str) {
        TextView textView = (TextView) qavPanel.h1(m.l.U);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void B9(QavPanel qavPanel, int i3) {
        ImageView imageView = (ImageView) qavPanel.h1(m.l.V);
        if (i3 == 2) {
            imageView.setImageResource(R.drawable.n78);
        } else if (i3 == 1) {
            imageView.setImageResource(R.drawable.n77);
        } else {
            imageView.setImageDrawable(null);
        }
    }

    public void C9(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f421444d, 1, "updateBigVideoStatusViewVisible, show[" + i3 + "]", new Throwable("\u6253\u5370\u5806\u6808"));
        }
        View view = this.f76264f;
        if (view != null) {
            view.setVisibility(i3);
        }
        if (i3 != 0 || x9(this.f76263e) == null || x9(this.f76263e).J0 == null) {
            return;
        }
        x9(this.f76263e).J0.h1(0, false);
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        this.f76264f = null;
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76263e = new WeakReference<>(getContext());
        this.f76264f = view.findViewById(m.d.f76013k);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }
}
