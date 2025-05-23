package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.s;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.panel.RichTextPanelRecyclerView;
import com.tencent.mobileqq.panel.RichTextPanelView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.e;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class ZhituPanelView extends RichTextPanelView {
    private static String K = "ZhituManager.PanelView";
    private static String L = HardCodeUtil.qqStr(R.string.vnw);
    public static int M = 6;
    private com.tencent.aio.api.runtime.a C;
    private com.tencent.qqnt.aio.api.e D;
    RichTextPanelRecyclerView E;
    TextView F;
    private com.tencent.mobileqq.activity.aio.zhitu.c G;
    private Button H;
    private com.tencent.mobileqq.panel.f I;
    private String J;

    /* renamed from: f, reason: collision with root package name */
    GridLayoutManager f180343f;

    /* renamed from: h, reason: collision with root package name */
    private int f180344h;

    /* renamed from: i, reason: collision with root package name */
    private c f180345i;

    /* renamed from: m, reason: collision with root package name */
    private ColorDrawable f180346m;

    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* loaded from: classes10.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        public boolean f180350d = false;

        public b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == gridLayoutManager.getItemCount() && this.f180350d) {
                    ((c) recyclerView.getAdapter()).p();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            boolean z16;
            super.onScrolled(recyclerView, i3, i16);
            if (i16 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f180350d = z16;
        }
    }

    /* loaded from: classes10.dex */
    public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: f, reason: collision with root package name */
        public String f180354f;

        /* renamed from: h, reason: collision with root package name */
        public int f180355h;

        /* renamed from: m, reason: collision with root package name */
        public View f180357m;

        /* renamed from: i, reason: collision with root package name */
        public boolean f180356i = true;

        /* renamed from: d, reason: collision with root package name */
        public List<com.tencent.mobileqq.activity.aio.zhitu.c> f180352d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public List<com.tencent.mobileqq.activity.aio.zhitu.c> f180353e = new ArrayList();

        /* loaded from: classes10.dex */
        class a extends GridLayoutManager.SpanSizeLookup {
            a() {
            }

            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                int itemViewType = c.this.getItemViewType(i3);
                if (itemViewType == 2 || itemViewType == 3) {
                    return 3;
                }
                return 1;
            }
        }

        public c() {
            for (int i3 = 0; i3 < ZhituPanelView.M; i3++) {
                this.f180353e.add(new com.tencent.mobileqq.activity.aio.zhitu.c());
            }
            this.f180352d.addAll(this.f180353e);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size;
            List<com.tencent.mobileqq.activity.aio.zhitu.c> list = this.f180352d;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            if (this.f180356i) {
                size++;
            }
            if (this.f180357m != null) {
                return size + 1;
            }
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (this.f180357m != null && i3 == 0) {
                return 3;
            }
            if (!this.f180356i || i3 + 1 != getItemCount()) {
                return 1;
            }
            return 2;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanSizeLookup(new a());
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            int i16;
            AbstractGifImage abstractGifImage;
            Drawable drawable;
            if (getItemViewType(i3) != 3 && (viewHolder instanceof d)) {
                if (this.f180357m == null) {
                    i16 = i3;
                } else {
                    i16 = i3 - 1;
                }
                d dVar = (d) viewHolder;
                com.tencent.mobileqq.activity.aio.zhitu.c cVar = this.f180352d.get(i16);
                dVar.f180363i = new WeakReference<>(cVar);
                dVar.f180361f.setVisibility(0);
                dVar.f180362h.setChecked(cVar.f180394m);
                if (cVar.f180386e) {
                    String A = ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).A(cVar);
                    abstractGifImage = ZhituManager.H(A);
                    if (abstractGifImage == null) {
                        ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).V(cVar);
                        if (QLog.isColorLevel()) {
                            QLog.d(ZhituPanelView.K, 2, "get gif image from cache fail, " + A);
                        }
                    }
                } else {
                    abstractGifImage = null;
                }
                dVar.f180359d.getLayoutParams().height = ZhituPanelView.this.f180344h;
                if (ZhituPanelView.this.G() == 1) {
                    if (cVar.f180390i != null || abstractGifImage != null) {
                        QLog.d(ZhituPanelView.K, 2, "ZhituTest has a drawable data is " + cVar.toString());
                        Drawable drawable2 = cVar.f180390i;
                        dVar.f180360e.setTag(cVar.f180382a + cVar.f180389h);
                        if (abstractGifImage != null) {
                            drawable2 = new GifDrawable(abstractGifImage);
                        }
                        dVar.f180360e.setImageDrawable(drawable2);
                        dVar.f180360e.setBackgroundDrawable(null);
                        dVar.f180361f.setVisibility(8);
                    } else {
                        QLog.d(ZhituPanelView.K, 2, "ZhituTest has no drawable data is " + cVar.toString());
                        dVar.f180360e.setImageDrawable(ZhituPanelView.this.f180346m);
                        dVar.f180361f.setVisibility(0);
                        dVar.f180362h.setVisibility(8);
                    }
                } else if (cVar.f180390i == null && abstractGifImage == null) {
                    dVar.f180360e.setImageDrawable(ZhituPanelView.this.f180346m);
                    dVar.f180361f.setVisibility(0);
                    dVar.f180362h.setVisibility(8);
                } else {
                    dVar.f180359d.setMinimumWidth(0);
                    Drawable drawable3 = cVar.f180390i;
                    dVar.f180360e.setTag(cVar.f180382a + cVar.f180389h);
                    if (!cVar.f180394m && !cVar.f180395n && (drawable = cVar.f180391j) != null) {
                        drawable3 = drawable;
                    }
                    if (abstractGifImage != null) {
                        drawable3 = new GifDrawable(abstractGifImage);
                    }
                    dVar.f180360e.setImageDrawable(drawable3);
                    dVar.f180360e.setBackgroundDrawable(null);
                    dVar.f180361f.setVisibility(8);
                    dVar.f180362h.setVisibility(0);
                }
                dVar.f180359d.getLayoutParams().width = ZhituPanelView.this.f180344h;
                com.tencent.mobileqq.activity.aio.zhitu.d dVar2 = cVar.f180393l;
                if (dVar2 != null && !dVar2.f180404i) {
                    ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).q0(cVar);
                    cVar.f180393l.f180404i = true;
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            RecyclerView.ViewHolder dVar;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return new a(this.f180357m);
                }
                dVar = new a(LayoutInflater.from(ZhituPanelView.this.getContext()).inflate(R.layout.c4i, viewGroup, false));
            } else {
                dVar = new d(LayoutInflater.from(ZhituPanelView.this.getContext()).inflate(R.layout.c4j, viewGroup, false));
            }
            return dVar;
        }

        public void p() {
            if (QLog.isColorLevel()) {
                QLog.d(ZhituPanelView.K, 2, "loadMorePic");
            }
            int size = this.f180352d.size();
            if (size != 0 && !TextUtils.isEmpty(this.f180352d.get(size - 1).f180387f) && size > this.f180355h) {
                this.f180355h = size;
                ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).x0(this.f180352d.size(), this.f180354f);
            }
        }

        public void q() {
            TextView textView;
            if (QLog.isColorLevel()) {
                QLog.d(ZhituPanelView.K, 2, "[ZhituPicAdapter]-resetData");
            }
            this.f180352d.clear();
            View view = this.f180357m;
            if (view != null && (textView = (TextView) view.findViewById(R.id.l7g)) != null) {
                textView.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.f180357m.getLayoutParams();
                layoutParams.height = -2;
                this.f180357m.setLayoutParams(layoutParams);
            }
            this.f180352d.addAll(this.f180353e);
            this.f180354f = "";
            this.f180355h = -1;
            notifyDataSetChanged();
        }

        public void r(String str) {
            TextView textView;
            if (QLog.isColorLevel()) {
                QLog.d(ZhituPanelView.K, 2, "[ZhituPicAdapter]-setEmptyAndShowMsg, errorMsg is " + str);
            }
            this.f180352d.clear();
            View view = this.f180357m;
            if (view != null && (textView = (TextView) view.findViewById(R.id.l7g)) != null) {
                this.f180356i = false;
                textView.setVisibility(0);
                textView.setText(str);
                ViewGroup.LayoutParams layoutParams = this.f180357m.getLayoutParams();
                layoutParams.height = -1;
                this.f180357m.setLayoutParams(layoutParams);
            }
            notifyDataSetChanged();
        }

        public void s(View view) {
            this.f180357m = view;
            notifyItemInserted(0);
        }

        public void t(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = " + i3 + ",mReqKey = " + str + ",this.mReqKey =" + this.f180354f);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i3 > 0) {
                if (!str.equals(this.f180354f)) {
                    this.f180352d.clear();
                    ReportController.o(((RichTextPanelView) ZhituPanelView.this).f257150d, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.u(ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).B()), 0, "", "", "", "");
                }
                this.f180354f = str;
                for (int i16 = 0; i16 < i3; i16++) {
                    this.f180352d.add(new com.tencent.mobileqq.activity.aio.zhitu.c());
                }
                this.f180355h = -1;
                this.f180356i = true;
                notifyDataSetChanged();
                return;
            }
            this.f180356i = false;
            notifyDataSetChanged();
        }

        public void u(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
            if (cVar != null) {
                int i3 = cVar.f180388g;
                if (i3 >= 0 && i3 < this.f180352d.size()) {
                    com.tencent.mobileqq.activity.aio.zhitu.c cVar2 = this.f180352d.get(i3);
                    cVar2.a(cVar);
                    if (ZhituPanelView.this.G() != 1 && cVar2.f180394m) {
                        if (ZhituPanelView.this.G != null && ZhituPanelView.this.G != cVar2) {
                            ZhituPanelView.this.G.f180394m = false;
                        }
                        ZhituPanelView.this.G = cVar2;
                    }
                }
                notifyDataSetChanged();
                if (ZhituPanelView.this.G() != 1 && i3 == 0) {
                    ZhituPanelView.this.H.setEnabled(true);
                    ZhituPanelView.this.H.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        public RelativeLayout f180359d;

        /* renamed from: e, reason: collision with root package name */
        public BubbleImageView f180360e;

        /* renamed from: f, reason: collision with root package name */
        public ProgressBar f180361f;

        /* renamed from: h, reason: collision with root package name */
        public RadioButton f180362h;

        /* renamed from: i, reason: collision with root package name */
        public WeakReference<com.tencent.mobileqq.activity.aio.zhitu.c> f180363i;

        public d(View view) {
            super(view);
            this.f180359d = (RelativeLayout) view;
            BubbleImageView bubbleImageView = (BubbleImageView) view.findViewById(R.id.i_9);
            this.f180360e = bubbleImageView;
            bubbleImageView.m(false);
            this.f180360e.setRadius(5.0f);
            this.f180360e.f179329f = false;
            this.f180361f = (ProgressBar) view.findViewById(R.id.i__);
            view.setOnClickListener(this);
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.i_a);
            this.f180362h = radioButton;
            radioButton.setOnCheckedChangeListener(this);
            if (ZhituPanelView.this.G() == 1) {
                this.f180362h.setVisibility(8);
            } else {
                this.f180362h.setVisibility(0);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (ZhituPanelView.this.G() != 1 && z16) {
                onClick(compoundButton);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.activity.aio.zhitu.c cVar = this.f180363i.get();
            QLog.d(ZhituPanelView.K, 2, "onClick:" + cVar);
            if (cVar != null && cVar.f180382a != null && cVar.f180393l != null && ZhituPanelView.this.f180345i.f180352d != null) {
                boolean z16 = false;
                if (ZhituPanelView.this.G() == 1) {
                    ZhituPanelView.this.G = cVar;
                    ZhituManager I = ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d);
                    String str = ZhituPanelView.K;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("zhituManager.mZhituPanelView != null");
                    if (I.S != null) {
                        z16 = true;
                    }
                    sb5.append(z16);
                    QLog.d(str, 2, sb5.toString());
                    ZhituPanelView zhituPanelView = I.S;
                    if (zhituPanelView != null) {
                        zhituPanelView.I();
                        ReportController.o((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d, "dc00898", "", "", "0X800ACA1", "0X800ACA1", ZhituPanelView.this.D(), 0, "", "", "", "");
                    }
                } else if (ZhituPanelView.this.G != cVar) {
                    Iterator<com.tencent.mobileqq.activity.aio.zhitu.c> it = ZhituPanelView.this.f180345i.f180352d.iterator();
                    while (it.hasNext()) {
                        it.next().f180394m = false;
                    }
                    cVar.f180394m = true;
                    ZhituPanelView.this.H.setVisibility(0);
                    ZhituPanelView.this.H.setEnabled(true);
                    if (!cVar.f180392k) {
                        ZhituPanelView.this.G = cVar;
                        ZhituPanelView.this.f180345i.notifyDataSetChanged();
                    } else {
                        ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).b0(cVar);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ZhituPanelView(Context context, com.tencent.aio.api.runtime.a aVar, AppRuntime appRuntime, EditText editText, com.tencent.qqnt.aio.api.e eVar, com.tencent.mobileqq.panel.f fVar, Button button) {
        super(context);
        this.f180346m = new ColorDrawable();
        setAppRuntime(appRuntime);
        setEditText(editText);
        this.D = eVar;
        this.C = aVar;
        this.H = button;
        setClipToPadding(false);
        this.f180344h = E(context) / 3;
        this.I = fVar;
        H();
    }

    private View B(String str) {
        TextView textView = new TextView(getContext());
        textView.setId(R.id.l7g);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#878B99"));
        textView.setTextSize(2, 14.0f);
        textView.setGravity(17);
        textView.setVisibility(8);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return textView;
    }

    private View C() {
        com.tencent.mobileqq.flashchat.e d16 = com.tencent.mobileqq.flashchat.e.d((QQAppInterface) this.f257150d);
        L = d16.h();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (d16.m()) {
            TextView textView = new TextView(getContext());
            this.F = textView;
            textView.setId(R.id.l7i);
            this.F.setText(d16.g());
            this.F.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
            this.F.setTextSize(2, 14.0f);
            this.F.setPadding(0, BaseAIOUtils.f(8.0f, getResources()), 0, BaseAIOUtils.f(6.0f, getResources()));
            this.F.setGravity(1);
            linearLayout.addView(this.F);
        }
        linearLayout.addView(B(""), new LinearLayout.LayoutParams(-1, -1));
        return linearLayout;
    }

    private int E(Context context) {
        Size c16;
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT && (context instanceof FragmentActivity) && (c16 = m.c((FragmentActivity) context)) != null) {
            QLog.i(K, 1, "getRealScreenWidth  size:" + c16);
            return c16.getWidth();
        }
        return ViewUtils.getScreenWidth();
    }

    public int D() {
        int e16 = this.C.g().r().c().e();
        if (e16 == 1) {
            return 0;
        }
        if (e16 == 2) {
            return 1;
        }
        if (e16 == 3) {
            return 3000;
        }
        return -2;
    }

    public Button F() {
        return this.H;
    }

    public int G() {
        AppRuntime appRuntime = this.f257150d;
        if (appRuntime != null) {
            return com.tencent.mobileqq.flashchat.e.d((QQAppInterface) appRuntime).i();
        }
        return 0;
    }

    public void H() {
        View C = C();
        RichTextPanelRecyclerView richTextPanelRecyclerView = new RichTextPanelRecyclerView(getContext());
        this.E = richTextPanelRecyclerView;
        richTextPanelRecyclerView.setOverScrollMode(0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.f180343f = gridLayoutManager;
        this.E.setLayoutManager(gridLayoutManager);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.l7i);
        addView(this.E, layoutParams);
        c cVar = new c();
        this.f180345i = cVar;
        this.E.setAdapter(cVar);
        if (C != null) {
            this.f180345i.s(C);
        }
        this.E.addOnScrollListener(new b());
        this.E.setPanelExtendHelper(this.I);
    }

    public void I() {
        final com.tencent.mobileqq.activity.aio.zhitu.c cVar = this.G;
        final String str = this.J;
        QLog.d(K, 2, "realSendZhituPic:" + cVar);
        if (cVar != null && cVar.f180382a != null && cVar.f180393l != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.1
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    e.a emoCallbackDelegate;
                    com.tencent.mobileqq.activity.aio.zhitu.c cVar2 = cVar;
                    Bitmap bitmap = null;
                    String str2 = null;
                    if (!cVar2.f180392k) {
                        ZhituManager I = ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d);
                        com.tencent.mobileqq.activity.aio.zhitu.c cVar3 = cVar;
                        file = I.O(cVar3.f180382a, cVar3.f180384c);
                        Drawable drawable = cVar.f180390i;
                        if (drawable instanceof BitmapDrawable) {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        }
                        if (bitmap == null) {
                            return;
                        }
                        try {
                            if (!file.exists()) {
                                file.getParentFile().mkdirs();
                                file.createNewFile();
                            }
                            if (!FileUtils.saveBitmapToFile(bitmap, file.getAbsolutePath())) {
                                return;
                            }
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            return;
                        } catch (OutOfMemoryError e17) {
                            ZhituManager.w0(e17);
                            return;
                        }
                    } else if (cVar2.f180383b == null) {
                        try {
                            str2 = ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).z(cVar);
                        } catch (OutOfMemoryError e18) {
                            QLog.e(ZhituPanelView.K, 1, "oom when save bitmap");
                            ZhituManager.w0(e18);
                        }
                        if (str2 == null) {
                            return;
                        } else {
                            file = new File(str2);
                        }
                    } else {
                        ZhituManager I2 = ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d);
                        com.tencent.mobileqq.activity.aio.zhitu.c cVar4 = cVar;
                        file = I2.O(cVar4.f180382a, cVar4.f180384c);
                        FileUtils.copyFile(cVar.f180383b, file.getAbsolutePath());
                    }
                    if (ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).B() == 7220) {
                        cVar.f180383b = file.getAbsolutePath();
                        ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).m0(cVar);
                    } else if (ZhituPanelView.this.D != null && (emoCallbackDelegate = ((s) ZhituPanelView.this.D).getEmoCallbackDelegate()) != null) {
                        emoCallbackDelegate.h(file.getAbsolutePath(), 4, str, null, "");
                    }
                    ReportController.o(((RichTextPanelView) ZhituPanelView.this).f257150d, "dc00898", "", "", "0X8008C72", "0X8008C72", ZhituManager.u(ZhituManager.I((AppInterface) ((RichTextPanelView) ZhituPanelView.this).f257150d).B()), 0, "", "", "", "");
                }
            }, 8, null, false);
            ZhituManager.I((AppInterface) this.f257150d).p0(cVar);
            ReportController.o(this.f257150d, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
            this.f257151e.setText("");
            this.C.e().h(new PanelContainerMsgIntent.ShowKeyboardMsgIntent(K));
        }
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public String a() {
        return L;
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void b() {
        QLog.d("RichTextPanel", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ZhituManager I = ZhituManager.I((AppInterface) this.f257150d);
        I.S = null;
        I.U = null;
        super.b();
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void c(boolean z16) {
        ZhituManager I = ZhituManager.I((AppInterface) this.f257150d);
        if (z16) {
            I.S = this;
            I.U = this.f180345i;
            Editable text = this.f257151e.getText();
            if (text != null) {
                this.J = text.toString();
            } else {
                this.J = null;
            }
            I.a0((QQAppInterface) this.f257150d, this.f257151e.getText(), this.C.g().r().c().e(), false);
            return;
        }
        I.S = null;
        I.U = null;
    }
}
