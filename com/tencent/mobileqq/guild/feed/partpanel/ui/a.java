package com.tencent.mobileqq.guild.feed.partpanel.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.pad.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC7770a f222639d;

    /* renamed from: f, reason: collision with root package name */
    private c f222641f;

    /* renamed from: i, reason: collision with root package name */
    private int f222643i;

    /* renamed from: e, reason: collision with root package name */
    private final List<bn1.c> f222640e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private String f222642h = "";

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.partpanel.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC7770a {
        void a(bn1.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f222644a;

        /* renamed from: b, reason: collision with root package name */
        TextView f222645b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f222646c;

        b() {
        }
    }

    public a(int i3) {
        this.f222643i = i3;
    }

    private static void a(b bVar, c cVar) {
        ViewGroup.LayoutParams d16 = d(bVar.f222644a.getLayoutParams());
        d16.width = -1;
        d16.height = cVar.f222654a.f222662a;
        bVar.f222644a.setLayoutParams(d16);
        bVar.f222644a.setBackgroundResource(cVar.f222656c.f222674b);
        bVar.f222645b.setTextColor(cVar.f222655b.f222658a);
    }

    private void b(View view, b bVar, ViewGroup viewGroup) {
        bVar.f222644a = (LinearLayout) view;
        bVar.f222645b = (TextView) view.findViewById(R.id.f2255041);
        bVar.f222646c = (ImageView) view.findViewById(R.id.f2254040);
        view.setTag(bVar);
        a(bVar, this.f222641f);
    }

    private void c(View view, ViewGroup viewGroup) {
        Object obj;
        if (!i.b()) {
            return;
        }
        int width = view.getWidth();
        int width2 = viewGroup.getWidth();
        if (width2 > 0 && width != width2) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("itemWidth = ");
                sb5.append(width);
                sb5.append(", parentWidth = ");
                sb5.append(width2);
                sb5.append(" item's layout_width = ");
                if (layoutParams != null) {
                    obj = Integer.valueOf(layoutParams.width);
                } else {
                    obj = "null";
                }
                sb5.append(obj);
                QLog.e("GuildHashtagListAdapter", 2, sb5.toString());
            }
            ViewGroup.LayoutParams d16 = d(layoutParams);
            d16.width = viewGroup.getWidth();
            view.setLayoutParams(d16);
        }
    }

    private static ViewGroup.LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return layoutParams;
    }

    private Map<String, String> e(View view, bn1.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_sub_channel_id", cVar.f28687a);
        hashMap.put("sgrp_section_name", cVar.f28689c);
        VideoReport.setElementId(view, "em_sgrp_choose_section_panel");
        int i3 = this.f222643i;
        if (i3 == 2) {
            hashMap.put("dt_pgid", "pg_sgrp_forum_editor");
        } else if (i3 == 3) {
            hashMap.put("dt_pgid", "pg_sgrp_forum_short_editor");
        }
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        return hashMap;
    }

    private void g(b bVar, bn1.c cVar) {
        boolean z16;
        if (cVar == null) {
            return;
        }
        bVar.f222645b.setText(cVar.f28689c);
        int i3 = 0;
        if (!TextUtils.isEmpty(this.f222642h) && this.f222642h.equals(cVar.f28687a)) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageView imageView = bVar.f222646c;
        if (!z16) {
            i3 = 4;
        }
        imageView.setVisibility(i3);
        if (z16) {
            bVar.f222645b.setAlpha(1.0f);
            bVar.f222645b.setTextColor(this.f222641f.f222655b.f222660c);
        } else if (!cVar.f28690d.booleanValue() && this.f222643i != 1) {
            bVar.f222645b.setAlpha(0.3f);
            bVar.f222645b.setTextColor(this.f222641f.f222655b.f222658a);
        } else {
            bVar.f222645b.setAlpha(1.0f);
            bVar.f222645b.setTextColor(this.f222641f.f222655b.f222658a);
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public bn1.c getItem(int i3) {
        if (i3 >= 0 && i3 < getCount()) {
            return this.f222640e.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f222640e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eq9, (ViewGroup) null);
        }
        if (view.getTag() != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b();
            b(view, bVar, viewGroup);
        }
        g(bVar, getItem(i3));
        c(view, viewGroup);
        VideoReport.reportEvent("imp", view, e(view, getItem(i3)));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void h(List<IGProChannel> list) {
        this.f222640e.clear();
        if (list != null && !list.isEmpty()) {
            for (IGProChannel iGProChannel : list) {
                bn1.c a16 = bn1.c.a(iGProChannel);
                if (iGProChannel.getHiddenPostChannel() == 1) {
                    a16.f28688b = 2;
                    a16.f28689c = "\u4e0d\u9009\u62e9\u7248\u5757";
                    this.f222640e.add(0, a16);
                } else {
                    this.f222640e.add(a16);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void i(String str) {
        this.f222642h = str;
    }

    public void j(InterfaceC7770a interfaceC7770a) {
        this.f222639d = interfaceC7770a;
    }

    public void k(c cVar) {
        this.f222641f = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        bn1.c item = getItem(i3);
        if (item != null) {
            InterfaceC7770a interfaceC7770a = this.f222639d;
            if (interfaceC7770a != null) {
                interfaceC7770a.a(item);
            }
            VideoReport.reportEvent("clck", view, e(view, item));
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }
}
