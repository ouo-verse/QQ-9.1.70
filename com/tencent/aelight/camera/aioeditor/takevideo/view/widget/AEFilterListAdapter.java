package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.capture.view.c;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fr.f;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFilterListAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    private List<QIMFilterCategoryItem> f68934d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private int f68935e = 1;

    /* renamed from: f, reason: collision with root package name */
    private ColorDrawable f68936f = new ColorDrawable(872415231);

    /* renamed from: h, reason: collision with root package name */
    protected ProviderView.a f68937h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f68938d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QIMFilterCategoryItem f68939e;

        a(b bVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
            this.f68938d = bVar;
            this.f68939e = qIMFilterCategoryItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == null) {
                ms.a.c("AEFilterListAdapter", "view is null.");
            } else {
                ProviderView.a aVar = AEFilterListAdapter.this.f68937h;
                if (aVar != null) {
                    aVar.b0(this.f68938d.getAdapterPosition(), this.f68939e);
                }
                AEFilterListAdapter.this.q(view.getContext(), this.f68939e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private ImageView f68941d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f68942e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f68943f;

        /* renamed from: h, reason: collision with root package name */
        private TextView f68944h;

        /* renamed from: i, reason: collision with root package name */
        private RelativeLayout f68945i;

        /* renamed from: m, reason: collision with root package name */
        private QIMCommonLoadingView f68946m;

        public b(View view) {
            super(view);
            this.f68946m = (QIMCommonLoadingView) view.findViewById(R.id.ser);
            this.f68945i = (RelativeLayout) view.findViewById(R.id.f75213yc);
            this.f68941d = (ImageView) view.findViewById(R.id.xyq);
            this.f68942e = (ImageView) view.findViewById(R.id.f165886xz1);
            this.f68943f = (ImageView) view.findViewById(R.id.xyo);
            this.f68944h = (TextView) view.findViewById(R.id.f1052665j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Context context, QIMFilterCategoryItem qIMFilterCategoryItem) {
        if (!(context instanceof Activity)) {
            ms.a.c("AEFilterListAdapter", "context error.");
            return;
        }
        if (qIMFilterCategoryItem.n()) {
            l.g(context, qIMFilterCategoryItem, 2);
            return;
        }
        com.tencent.aelight.camera.ae.report.b.b().p0(qIMFilterCategoryItem.e() ? 1 : 2, qIMFilterCategoryItem.f66697d);
        d dVar = (d) f.c(5);
        Bundle bundle = new Bundle();
        bundle.putInt("apply_source", 1);
        bundle.putInt("capture_scene", this.f68935e);
        Activity activity = (Activity) context;
        dVar.m(qIMFilterCategoryItem, activity, bundle);
        ((d) f.c(5)).J(this.f68935e, activity);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<QIMFilterCategoryItem> list = this.f68934d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<QIMFilterCategoryItem> r() {
        return this.f68934d;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167582du3, viewGroup, false));
    }

    public void v(int i3) {
        this.f68935e = i3;
    }

    public void w(ProviderView.a aVar) {
        this.f68937h = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
    
        if (r1 != 3) goto L21;
     */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(b bVar, int i3) {
        AppRuntime peekAppRuntime;
        Context context = bVar.f68941d.getContext();
        QIMFilterCategoryItem qIMFilterCategoryItem = this.f68934d.get(bVar.getAdapterPosition());
        bVar.f68944h.setText(qIMFilterCategoryItem.f66698e);
        bVar.f68946m.setBgCorner(QIMCommonLoadingView.b(7.0f, context));
        bVar.f68941d.setImageDrawable(null);
        bVar.f68941d.setBackgroundResource(0);
        boolean z16 = true;
        if (qIMFilterCategoryItem.k()) {
            bVar.f68946m.setVisibility(8);
            bVar.f68943f.setVisibility(8);
            bVar.f68941d.setBackgroundResource(R.drawable.f160080mk1);
        } else if (qIMFilterCategoryItem.e()) {
            bVar.f68946m.setVisibility(8);
            bVar.f68943f.setVisibility(8);
            UIUtils.t(bVar.f68941d, qIMFilterCategoryItem.f66700h, UIUtils.b(context, 70.0f), UIUtils.b(context, 70.0f), this.f68936f, null);
        } else {
            UIUtils.t(bVar.f68941d, qIMFilterCategoryItem.f66700h, UIUtils.b(context, 70.0f), UIUtils.b(context, 70.0f), this.f68936f, null);
            j s16 = ((d) f.c(5)).s(qIMFilterCategoryItem);
            if (s16.f66706e == 1) {
                bVar.f68946m.setVisibility(0);
                bVar.f68946m.a(c.c(s16));
            } else {
                bVar.f68946m.setVisibility(8);
            }
            int v3 = s16.v();
            if (v3 != 1) {
                if (v3 == 2) {
                    bVar.f68943f.setVisibility(0);
                }
            }
            bVar.f68943f.setVisibility(8);
        }
        QIMFilterCategoryItem i16 = m.n().i(this.f68935e);
        if (i16 != null) {
            z16 = TextUtils.equals(i16.f66697d, qIMFilterCategoryItem.f66697d);
        } else if (!qIMFilterCategoryItem.k()) {
            z16 = false;
        }
        if (z16) {
            bVar.f68942e.setVisibility(0);
        } else {
            bVar.f68942e.setVisibility(8);
        }
        bVar.f68945i.setOnClickListener(new a(bVar, qIMFilterCategoryItem));
        if (AppSetting.f99565y && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable")) {
            bVar.f68945i.setSelected(z16);
        }
    }

    public void u(Context context, List<QIMFilterCategoryItem> list) {
        if (list == null) {
            ms.a.c("AEFilterListAdapter", "filter items null.");
            return;
        }
        this.f68934d.clear();
        this.f68934d.addAll(list);
        m.g(context, this.f68934d);
        com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.view.widget.AEFilterListAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                AEFilterListAdapter.this.notifyDataSetChanged();
            }
        });
    }
}
