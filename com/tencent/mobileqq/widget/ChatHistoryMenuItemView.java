package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ChatHistoryMenuItemView extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<TextView> f315479d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<a> f315480e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(int i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ArrayList<a> arrayList = this.f315480e;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this.f315479d.indexOf(view));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
