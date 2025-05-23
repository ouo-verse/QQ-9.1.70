package com.tencent.mobileqq.wink.editor.sticker.text;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c extends RecyclerView.Adapter<b> {

    /* renamed from: h, reason: collision with root package name */
    private static int f322052h = 4;

    /* renamed from: d, reason: collision with root package name */
    private int f322053d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f322054e = "";

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC9038c f322055f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f322056d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f322057e;

        a(int i3, b bVar) {
            this.f322056d = i3;
            this.f322057e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.f322053d = this.f322056d;
            c.this.notifyDataSetChanged();
            c.this.f322055f.a(this.f322056d);
            HashMap hashMap = new HashMap();
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_TYPE, Integer.valueOf(this.f322056d));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_USE_TEXT_SOURCE, c.this.f322054e);
            c.this.s(this.f322057e.f322059d, hashMap);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private View f322059d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f322060e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f322061f;

        public b(View view) {
            super(view);
            this.f322059d = view;
            this.f322060e = (ImageView) view.findViewById(R.id.y0s);
            this.f322061f = (ImageView) view.findViewById(R.id.y8z);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.text.c$c, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9038c {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view, Map<String, Object> map) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_CHAR_PATTERN_UNDERLAY_TEXT);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(map);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.reportEvent("dt_clck", view, map);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return f322052h;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, @SuppressLint({"RecyclerView"}) int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    bVar.f322060e.setImageResource(R.drawable.jtb);
                } else {
                    bVar.f322060e.setImageResource(R.drawable.jta);
                }
            } else {
                bVar.f322060e.setImageResource(R.drawable.jtd);
            }
        } else {
            bVar.f322060e.setImageResource(R.drawable.jtc);
        }
        if (this.f322053d == i3) {
            bVar.f322061f.setVisibility(0);
        } else {
            bVar.f322061f.setVisibility(4);
        }
        bVar.f322059d.setOnClickListener(new a(i3, bVar));
        EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hfd, viewGroup, false));
    }

    public void v(int i3) {
        this.f322053d = i3;
    }

    public void w(InterfaceC9038c interfaceC9038c) {
        this.f322055f = interfaceC9038c;
    }

    public void x(String str) {
        this.f322054e = str;
    }
}
