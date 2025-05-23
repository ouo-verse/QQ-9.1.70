package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends RecyclerView.Adapter<ViewOnClickListenerC9029b> {

    /* renamed from: d, reason: collision with root package name */
    private Context f320787d;

    /* renamed from: f, reason: collision with root package name */
    public a f320789f;

    /* renamed from: h, reason: collision with root package name */
    private final int f320790h;

    /* renamed from: e, reason: collision with root package name */
    private List<WinkEditorMusicInfo> f320788e = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f320791i = false;

    /* renamed from: m, reason: collision with root package name */
    private Set<ViewOnClickListenerC9029b> f320792m = new HashSet();
    private int C = ViewUtils.dip2px(6.0f);
    private int D = ViewUtils.dip2px(2.0f);
    private int E = ViewUtils.dip2px(16.0f);

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        WinkEditorViewModel.EditMode A();

        void a(@Nullable WinkEditorMusicInfo winkEditorMusicInfo, int i3, boolean z16, int i16, View view);
    }

    public b(@NonNull Context context, @Nullable a aVar) {
        this.f320787d = context;
        this.f320789f = aVar;
        this.f320790h = context.getResources().getDimensionPixelSize(R.dimen.f158175bz0);
    }

    public static void r(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_ITEM);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f320788e.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(View view, WinkEditorMusicInfo winkEditorMusicInfo) {
        Object obj;
        a aVar;
        if (winkEditorMusicInfo != null) {
            String q16 = winkEditorMusicInfo.q();
            String str = winkEditorMusicInfo.E;
            long o16 = winkEditorMusicInfo.o();
            Long l3 = WinkEditorMusicInfo.H;
            String str2 = "1";
            String str3 = "0";
            if (o16 == l3.longValue()) {
                q16 = "\u6a21\u7248\u97f3\u4e50";
                str = "\u63a8\u8350";
            } else if (winkEditorMusicInfo.f321262i != 3) {
                obj = "1";
                if (winkEditorMusicInfo.o() != l3.longValue() || winkEditorMusicInfo.f321262i == 3 || (aVar = this.f320789f) == null || aVar.A() == WinkEditorViewModel.EditMode.Image) {
                    str2 = "0";
                }
                Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put("xsj_music_id", winkEditorMusicInfo.p());
                buildElementParams.put("xsj_music_name", q16);
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str);
                if (winkEditorMusicInfo.j() != null) {
                    str3 = String.valueOf(winkEditorMusicInfo.j().f320655i);
                }
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, str3);
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_COLLECT, obj);
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_CUT, str2);
                VideoReport.setElementParams(view, buildElementParams);
                VideoReport.setElementReuseIdentifier(view, winkEditorMusicInfo.p());
            }
            obj = "0";
            if (winkEditorMusicInfo.o() != l3.longValue()) {
            }
            str2 = "0";
            Map<String, Object> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
            buildElementParams2.put("xsj_music_id", winkEditorMusicInfo.p());
            buildElementParams2.put("xsj_music_name", q16);
            buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str);
            if (winkEditorMusicInfo.j() != null) {
            }
            buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, str3);
            buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_COLLECT, obj);
            buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_CUT, str2);
            VideoReport.setElementParams(view, buildElementParams2);
            VideoReport.setElementReuseIdentifier(view, winkEditorMusicInfo.p());
        }
    }

    public List<WinkEditorMusicInfo> q() {
        return new LinkedList(this.f320788e);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewOnClickListenerC9029b viewOnClickListenerC9029b, int i3) {
        viewOnClickListenerC9029b.d(this.f320788e.get(i3), i3, this.f320788e.size());
        p(viewOnClickListenerC9029b.f320794e, this.f320788e.get(i3));
        EventCollector.getInstance().onRecyclerBindViewHolder(viewOnClickListenerC9029b, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public ViewOnClickListenerC9029b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ViewOnClickListenerC9029b viewOnClickListenerC9029b = new ViewOnClickListenerC9029b(LayoutInflater.from(this.f320787d).inflate(R.layout.hdj, viewGroup, false), this.f320789f, this.f320790h);
        viewOnClickListenerC9029b.e(this.C, this.D, this.E);
        r(viewOnClickListenerC9029b.f320794e);
        return viewOnClickListenerC9029b;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(ViewOnClickListenerC9029b viewOnClickListenerC9029b) {
        super.onViewAttachedToWindow(viewOnClickListenerC9029b);
        this.f320792m.add(viewOnClickListenerC9029b);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(ViewOnClickListenerC9029b viewOnClickListenerC9029b) {
        super.onViewDetachedFromWindow(viewOnClickListenerC9029b);
        this.f320792m.remove(viewOnClickListenerC9029b);
    }

    public void w(@NonNull List<WinkEditorMusicInfo> list) {
        this.f320788e.clear();
        this.f320788e.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.music.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class ViewOnClickListenerC9029b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView C;
        private TextView D;
        private a E;
        private SparseArray<Boolean> F;
        private WinkEditorMusicInfo G;
        private int H;
        private final int I;

        /* renamed from: d, reason: collision with root package name */
        private View f320793d;

        /* renamed from: e, reason: collision with root package name */
        private FrameLayout f320794e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f320795f;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f320796h;

        /* renamed from: i, reason: collision with root package name */
        private FrameLayout f320797i;

        /* renamed from: m, reason: collision with root package name */
        private ImageView f320798m;

        public ViewOnClickListenerC9029b(@NonNull View view, @Nullable a aVar, int i3) {
            super(view);
            this.F = new SparseArray<>();
            this.f320793d = view;
            this.f320794e = (FrameLayout) view.findViewById(R.id.f70583lu);
            this.f320795f = (ImageView) view.findViewById(R.id.f165949y61);
            this.f320796h = (ImageView) view.findViewById(R.id.t36);
            this.f320797i = (FrameLayout) view.findViewById(R.id.v8b);
            this.f320798m = (ImageView) view.findViewById(R.id.f165950y62);
            this.C = (ImageView) view.findViewById(R.id.y5f);
            this.D = (TextView) view.findViewById(R.id.f109466fw);
            this.f320794e.setOnClickListener(this);
            this.E = aVar;
            this.I = i3;
        }

        public void d(@NonNull WinkEditorMusicInfo winkEditorMusicInfo, int i3, int i16) {
            String q16;
            this.G = winkEditorMusicInfo;
            this.H = i3;
            if (winkEditorMusicInfo.f321262i == 2 && !TextUtils.isEmpty(winkEditorMusicInfo.c())) {
                this.f320795f.setVisibility(0);
                ViewUtilsKt.j(this.f320795f, winkEditorMusicInfo.c());
            } else {
                this.f320795f.setVisibility(4);
            }
            String e16 = this.G.e();
            if (TextUtils.isEmpty(e16)) {
                this.f320796h.setVisibility(4);
                this.f320796h.setImageDrawable(null);
            } else {
                this.f320796h.setVisibility(0);
                QQPicLoader.f201806a.e(Option.obtain().setUrl(e16).setTargetView(this.f320796h), null);
            }
            if (winkEditorMusicInfo.f321259e) {
                this.D.setTextColor(this.f320793d.getContext().getResources().getColor(R.color.f158017al3));
                if (winkEditorMusicInfo.f321262i == 3) {
                    this.f320795f.setVisibility(0);
                    this.f320795f.setImageResource(R.drawable.ont);
                }
                this.f320797i.setVisibility(0);
                this.f320797i.setBackgroundResource(R.drawable.f162010l52);
                Boolean bool = this.F.get(i3);
                if (winkEditorMusicInfo.f321260f != 2 && (bool == null || !bool.booleanValue())) {
                    if (winkEditorMusicInfo.f321260f == 1) {
                        this.f320798m.setVisibility(8);
                        if (winkEditorMusicInfo.f321261h > 0) {
                            this.C.setVisibility(0);
                        } else {
                            this.C.setVisibility(8);
                        }
                    } else {
                        this.f320798m.setVisibility(8);
                        this.C.setVisibility(8);
                    }
                } else {
                    this.F.put(i3, Boolean.TRUE);
                    this.C.setVisibility(8);
                }
                TextView textView = this.D;
                textView.setTypeface(textView.getTypeface(), 1);
            } else {
                this.D.setTextColor(this.f320793d.getContext().getResources().getColor(R.color.bfq));
                int i17 = winkEditorMusicInfo.f321262i;
                if (i17 == 0) {
                    this.f320797i.setVisibility(0);
                    this.f320798m.setVisibility(8);
                } else if (i17 == 1) {
                    this.f320797i.setVisibility(0);
                    this.f320797i.setBackgroundColor(this.f320793d.getContext().getResources().getColor(R.color.bdf));
                    this.f320798m.setVisibility(0);
                    this.f320798m.setImageResource(R.drawable.m4z);
                    this.C.setVisibility(8);
                } else if (i17 == 3) {
                    this.f320797i.setVisibility(4);
                    this.f320797i.setBackgroundResource(R.drawable.f162010l52);
                    this.f320798m.setVisibility(8);
                    this.C.setVisibility(8);
                    this.f320795f.setVisibility(0);
                    this.f320795f.setImageResource(R.drawable.ont);
                } else {
                    if (winkEditorMusicInfo.f321260f == 1) {
                        if (winkEditorMusicInfo.f321261h > 0) {
                            this.C.setVisibility(0);
                        } else {
                            this.C.setVisibility(8);
                        }
                    } else {
                        this.f320797i.setVisibility(8);
                        this.C.setVisibility(8);
                    }
                    this.f320798m.setVisibility(8);
                }
                this.D.setTypeface(null, 0);
            }
            int i18 = winkEditorMusicInfo.f321262i;
            if (i18 == 1) {
                q16 = this.D.getContext().getString(R.string.ym9);
            } else if (i18 == 3) {
                q16 = this.D.getContext().getString(R.string.ym_);
            } else if (TextUtils.isEmpty(winkEditorMusicInfo.q())) {
                q16 = "";
            } else if (winkEditorMusicInfo.q().length() > 5 && !winkEditorMusicInfo.f321259e) {
                q16 = winkEditorMusicInfo.q().substring(0, 5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            } else {
                q16 = winkEditorMusicInfo.q();
            }
            this.D.setText(q16);
            this.f320795f.setContentDescription(q16);
            this.D.setContentDescription(q16);
            this.f320793d.setContentDescription(q16);
            if (winkEditorMusicInfo.f321259e) {
                this.D.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.D.setMarqueeRepeatLimit(-1);
                this.D.setSingleLine();
                this.D.setFocusable(true);
                this.D.setSelected(true);
            } else {
                this.D.setEllipsize(TextUtils.TruncateAt.END);
                this.D.setFocusable(false);
                this.D.setSelected(false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f320793d.getLayoutParams();
            if (i3 == 0) {
                marginLayoutParams.leftMargin = -ViewUtils.dip2px(8.0f);
                marginLayoutParams.rightMargin = -ViewUtils.dip2px(2.0f);
            } else if (i3 == i16 - 1) {
                marginLayoutParams.leftMargin = -ViewUtils.dip2px(2.0f);
                marginLayoutParams.rightMargin = ViewUtils.dip2px(12.0f);
            } else {
                marginLayoutParams.leftMargin = -ViewUtils.dip2px(2.0f);
                marginLayoutParams.rightMargin = -ViewUtils.dip2px(2.0f);
            }
            this.f320793d.setLayoutParams(marginLayoutParams);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WinkEditorMusicInfo winkEditorMusicInfo;
            int i3;
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.f70583lu && (winkEditorMusicInfo = this.G) != null && (i3 = winkEditorMusicInfo.f321262i) != 0 && this.E != null) {
                if (i3 == 2) {
                    Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                    String str2 = "";
                    if (TextUtils.isEmpty(this.G.p())) {
                        str = "";
                    } else {
                        str = this.G.p();
                    }
                    if (!TextUtils.isEmpty(this.G.q())) {
                        str2 = this.G.q();
                    }
                    buildElementParams.put("xsj_music_id", str);
                    buildElementParams.put("xsj_music_name", str2);
                    VideoReport.reportEvent("dt_clck", this.itemView, buildElementParams);
                }
                this.E.a(this.G, getAdapterPosition(), !r0.f321259e, this.G.f321262i, this.itemView);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i3, int i16, int i17) {
        }
    }
}
