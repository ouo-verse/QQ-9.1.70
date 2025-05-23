package com.tencent.mobileqq.teamwork.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes18.dex */
public class FilePanelMenuPage extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f292150d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f292151e;

    /* renamed from: f, reason: collision with root package name */
    private MenuTabViewBase.a f292152f;

    public FilePanelMenuPage(Context context) {
        this(context, null);
    }

    private View b(au auVar) {
        View inflate = this.f292150d.inflate(R.layout.g6x, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.eq5)).setImageResource(auVar.f292248c);
        ((TextView) inflate.findViewById(R.id.eqi)).setText(auVar.f292247b);
        return inflate;
    }

    private int c(int i3) {
        return (int) com.tencent.mobileqq.utils.al.a(getContext(), i3);
    }

    private void d() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f292150d = layoutInflater;
        layoutInflater.inflate(R.layout.g6y, this);
        this.f292151e = (LinearLayout) findViewById(R.id.epy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(au auVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        MenuTabViewBase.a aVar = this.f292152f;
        if (aVar != null) {
            aVar.a(auVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(List<Integer> list) {
        this.f292151e.removeAllViews();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            final au clone = MenuConfigImpl.a(it.next().intValue()).clone();
            View b16 = b(clone);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c(52));
            layoutParams.setMargins(c(10), 0, c(10), 0);
            b16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FilePanelMenuPage.this.e(clone, view);
                }
            });
            this.f292151e.addView(b16, layoutParams);
        }
    }

    public void setMenuClickListener(MenuTabViewBase.a aVar) {
        this.f292152f = aVar;
    }

    public FilePanelMenuPage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilePanelMenuPage(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d();
    }
}
