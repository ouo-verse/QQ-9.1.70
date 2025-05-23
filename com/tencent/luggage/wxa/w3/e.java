package com.tencent.luggage.wxa.w3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.weui.base.preference.CheckBoxPreference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends CheckBoxPreference {
    public e(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setLayoutResource(R.layout.fdg);
    }

    @Override // com.tencent.weui.base.preference.CheckBoxPreference, android.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.findViewById(R.id.i_m).setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) onCreateView.findViewById(R.id.content);
        linearLayout.setOrientation(1);
        linearLayout.removeAllViews();
        View.inflate(getContext(), R.layout.fkq, linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.tencent.luggage.wxa.ok.a.a(getContext(), 1));
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(R.color.bx4));
        linearLayout.addView(view, layoutParams);
        return onCreateView;
    }
}
