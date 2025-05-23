package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    private TextView f76296e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f76297f;

    public void A9(int i3) {
        TextView textView = this.f76296e;
        if (textView != null) {
            textView.setVisibility(i3);
        }
        RelativeLayout relativeLayout = this.f76297f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        z9(getContext(), nw.b.b());
        this.f76296e = (TextView) view.findViewById(m.l.F);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(m.d.f76010h);
        this.f76297f = relativeLayout;
        if (relativeLayout == null || com.tencent.av.utils.e.e(0) != 1) {
            return;
        }
        this.f76297f.setBackgroundColor(2147483392);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    @Override // nw.a
    public void onDestroy() {
        this.f76296e = null;
        this.f76297f = null;
    }
}
