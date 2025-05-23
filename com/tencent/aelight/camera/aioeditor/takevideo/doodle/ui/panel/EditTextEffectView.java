package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.flashchat.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fr.f;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditTextEffectView extends RecyclerView implements Handler.Callback {
    public static final int F;
    public static final int G;
    public static final int H;
    private int C;
    public boolean D;
    com.tencent.aelight.camera.aioeditor.capture.music.b E;

    /* renamed from: d, reason: collision with root package name */
    b f68647d;

    /* renamed from: e, reason: collision with root package name */
    LinearLayoutManager f68648e;

    /* renamed from: f, reason: collision with root package name */
    d f68649f;

    /* renamed from: h, reason: collision with root package name */
    public Handler f68650h;

    /* renamed from: i, reason: collision with root package name */
    public Vector<DynamicTextConfigManager.DynamicTextConfigBean> f68651i;

    /* renamed from: m, reason: collision with root package name */
    int f68652m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends com.tencent.aelight.camera.aioeditor.capture.music.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.b
        public void g() {
            super.g();
            EditTextEffectView.this.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends RecyclerView.Adapter<c> {

        /* renamed from: d, reason: collision with root package name */
        List<DynamicTextConfigManager.DynamicTextConfigBean> f68654d;

        /* renamed from: e, reason: collision with root package name */
        public d f68655e;

        /* renamed from: f, reason: collision with root package name */
        public DynamicTextConfigManager f68656f = (DynamicTextConfigManager) f.c(7);

        public b(d dVar) {
            this.f68655e = dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<DynamicTextConfigManager.DynamicTextConfigBean> list = this.f68654d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i3) {
            DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean = this.f68654d.get(i3);
            cVar.f68659e = dynamicTextConfigBean;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) cVar.f68660f.getLayoutParams();
            marginLayoutParams.leftMargin = EditTextEffectView.G;
            marginLayoutParams.bottomMargin = EditTextEffectView.F;
            marginLayoutParams.topMargin = EditTextEffectView.H;
            cVar.f68662i.setVisibility(8);
            if (dynamicTextConfigBean.text_id == EditTextEffectView.this.f68652m) {
                cVar.f68663m.setVisibility(0);
            } else {
                cVar.f68663m.setVisibility(8);
            }
            cVar.f68661h.setImageResource(dynamicTextConfigBean.iconDrawableId);
            if (this.f68656f.q(dynamicTextConfigBean)) {
                cVar.D.setVisibility(8);
            } else {
                cVar.D.setVisibility(0);
            }
            cVar.E.setVisibility(8);
            cVar.F = i3;
            String c16 = DynamicTextBuilder.c(dynamicTextConfigBean.text_id);
            if (c16 != null) {
                cVar.f68660f.setContentDescription(HardCodeUtil.qqStr(R.string.lxe) + c16 + HardCodeUtil.qqStr(R.string.lxf));
                return;
            }
            cVar.f68660f.setContentDescription(null);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new c(LayoutInflater.from(EditTextEffectView.this.getContext()).inflate(R.layout.b5t, viewGroup, false), this.f68655e);
        }

        public void r(List<DynamicTextConfigManager.DynamicTextConfigBean> list) {
            this.f68654d = list;
        }
    }

    static {
        Resources resources = BaseApplicationImpl.sApplication.getResources();
        G = BaseAIOUtils.f(9.0f, resources);
        F = BaseAIOUtils.f(13.0f, resources);
        H = BaseAIOUtils.f(3.0f, resources);
    }

    public EditTextEffectView(Context context, d dVar) {
        super(context);
        this.f68647d = null;
        this.f68650h = null;
        this.f68651i = new Vector<>();
        this.f68652m = -1;
        this.D = false;
        this.E = new a();
        this.f68650h = new Handler(this);
        this.f68649f = dVar;
        setClipToPadding(false);
        f();
        g();
        setClipChildren(false);
    }

    private List<DynamicTextConfigManager.DynamicTextConfigBean> c(List<DynamicTextConfigManager.DynamicTextConfigBean> list) {
        Iterator<DynamicTextConfigManager.DynamicTextConfigBean> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().text_id >= 34) {
                it.remove();
            }
        }
        while (list.size() > 34) {
            list.remove(list.size() - 1);
        }
        return list;
    }

    public int d(int i3) {
        List<DynamicTextConfigManager.DynamicTextConfigBean> list;
        b bVar = this.f68647d;
        if (bVar == null || (list = bVar.f68654d) == null) {
            return -1;
        }
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            if (this.f68647d.f68654d.get(i16).text_id == i3) {
                return i16;
            }
        }
        return -1;
    }

    public DynamicTextConfigManager.DynamicTextConfigBean e(int i3) {
        List<DynamicTextConfigManager.DynamicTextConfigBean> list = this.f68647d.f68654d;
        if (list == null) {
            return null;
        }
        return list.get(i3);
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d("EditTextEffectView", 2, "loadData");
        }
        DynamicTextConfigManager dynamicTextConfigManager = (DynamicTextConfigManager) f.c(7);
        if (!dynamicTextConfigManager.o()) {
            dynamicTextConfigManager.m();
        }
        this.f68651i.clear();
        this.f68651i.addAll(c(dynamicTextConfigManager.i()));
        this.f68647d.r(this.f68651i);
        this.f68647d.notifyDataSetChanged();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        g();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppRuntime waitAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
        com.tencent.aelight.camera.aioeditor.capture.music.b bVar = new com.tencent.aelight.camera.aioeditor.capture.music.b();
        this.E = bVar;
        waitAppRuntime.registObserver(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseApplicationImpl.getApplication().waitAppRuntime(null).unRegistObserver(this.E);
    }

    public void setEditPhoto(boolean z16) {
        this.D = z16;
    }

    public void setOpIn(int i3) {
        this.C = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        View C;
        ImageView D;
        QIMCommonLoadingView E;
        int F;

        /* renamed from: d, reason: collision with root package name */
        d f68658d;

        /* renamed from: e, reason: collision with root package name */
        DynamicTextConfigManager.DynamicTextConfigBean f68659e;

        /* renamed from: f, reason: collision with root package name */
        View f68660f;

        /* renamed from: h, reason: collision with root package name */
        ImageView f68661h;

        /* renamed from: i, reason: collision with root package name */
        ImageView f68662i;

        /* renamed from: m, reason: collision with root package name */
        ImageView f68663m;

        public c(View view, d dVar) {
            super(view);
            this.f68658d = dVar;
            this.f68660f = view;
            this.f68661h = (ImageView) view.findViewById(R.id.btr);
            this.f68662i = (ImageView) view.findViewById(R.id.bts);
            this.f68663m = (ImageView) view.findViewById(R.id.btu);
            this.C = view.findViewById(R.id.btt);
            this.E = (QIMCommonLoadingView) view.findViewById(R.id.efn);
            this.D = (ImageView) view.findViewById(R.id.diz);
            view.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f68663m.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            layoutParams.width = marginLayoutParams.width;
            layoutParams.height = marginLayoutParams.height;
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            this.E.setLayoutParams(layoutParams);
            this.E.setBgCorner(QIMCommonLoadingView.b(7.0f, view.getContext()));
            layoutParams2.width = marginLayoutParams.width;
            layoutParams2.height = marginLayoutParams.height;
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            layoutParams2.addRule(11);
            this.f68663m.setLayoutParams(layoutParams2);
        }

        public void b(boolean z16) {
            if (this.E.getVisibility() != 8) {
                this.E.setVisibility(8);
            }
            if (z16) {
                if (this.D.getVisibility() != 8) {
                    this.D.setVisibility(8);
                }
            } else if (this.D.getVisibility() != 0) {
                this.D.setVisibility(0);
            }
            if (QLog.isColorLevel()) {
                QLog.i("DText", 2, "finish download pos is: " + this.F);
            }
        }

        public void d(float f16) {
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
            this.E.setProgress((int) f16);
            int measuredWidth = this.E.getMeasuredWidth();
            int measuredHeight = this.E.getMeasuredHeight();
            if (QLog.isColorLevel()) {
                QLog.i("DText", 2, "updateProgress progress is: " + f16 + " pos is: " + this.F + " width is: " + measuredWidth + "height is: " + measuredHeight);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == this.f68660f && (dVar = this.f68658d) != null) {
                dVar.t0(view, getAdapterPosition(), -1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void c(boolean z16) {
            if (z16) {
                if (this.f68663m.getVisibility() != 0) {
                    this.f68663m.setVisibility(0);
                }
            } else if (this.f68663m.getVisibility() != 8) {
                this.f68663m.setVisibility(8);
            }
        }
    }

    public void f() {
        setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f68648e = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        setLayoutManager(this.f68648e);
        b bVar = new b(this.f68649f);
        this.f68647d = bVar;
        setAdapter(bVar);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("EditTextEffectView", 2, "exittext panel visible");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("EditTextEffectView", 2, "exittext panel gone");
        }
    }

    public void h(int i3) {
        if (i3 == -1) {
            return;
        }
        List<DynamicTextConfigManager.DynamicTextConfigBean> list = this.f68647d.f68654d;
        if (list != null && i3 < list.size()) {
            this.f68652m = this.f68647d.f68654d.get(i3).text_id;
            int childCount = this.f68648e.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                c cVar = (c) getChildViewHolder(this.f68648e.getChildAt(i16));
                if (cVar.F != i3) {
                    cVar.c(false);
                } else {
                    cVar.c(true);
                    id0.a.n("video_edit_new", "text_element", this.C, 0, "0", String.valueOf(this.f68652m));
                }
            }
            return;
        }
        QLog.e("EditTextEffectView", 1, "select position = " + i3 + " no item");
    }
}
