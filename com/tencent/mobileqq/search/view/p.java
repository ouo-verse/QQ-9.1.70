package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;
import com.tencent.mobileqq.search.presenter.k;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.core.AssetExtension;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qzone.util.QZoneImageUtils;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends com.tencent.mobileqq.search.rich.o {

    /* renamed from: i, reason: collision with root package name */
    private View f285155i;

    /* renamed from: m, reason: collision with root package name */
    private a f285156m;

    public p(com.tencent.mobileqq.search.rich.f fVar, Context context) {
        super(fVar, context);
    }

    private void r() {
        String l3 = l();
        if (!TextUtils.isEmpty(l3)) {
            if (QLog.isColorLevel()) {
                QLog.e("RichTemplateOneSearchResultView", 2, "data->" + l3);
            }
            this.f285156m.g();
            this.f285156m.e(l3);
            this.f285156m.b();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("RichTemplateOneSearchResultView", 2, "empty data");
        }
    }

    private void s(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.a0_, (ViewGroup) null, false);
        this.f285155i = inflate;
        this.f285156m.f(inflate);
    }

    @Override // com.tencent.mobileqq.search.rich.o
    public View n(Context context) {
        this.f285156m = new a(context);
        s(context);
        r();
        return this.f285155i;
    }

    public String q() {
        return this.f285156m.c();
    }

    public void t(k.d dVar) {
        this.f285156m.i(dVar);
    }

    @Override // com.tencent.mobileqq.search.rich.h
    public void update() {
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements View.OnClickListener {
        private QUIButton C;
        private View F;
        private View G;
        private int I;
        private String J;
        private String K;
        private String L;
        private String M;
        private String N;
        private String P;
        private int S;
        private int T;
        private String U;
        protected k.d V;

        /* renamed from: d, reason: collision with root package name */
        private Context f285157d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f285158e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f285159f;

        /* renamed from: h, reason: collision with root package name */
        private TextView f285160h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f285161i;

        /* renamed from: m, reason: collision with root package name */
        private TextView f285162m;
        private final TextView[] D = new TextView[3];
        private final View[] E = new View[3];
        private int H = 0;
        private final String[] Q = new String[3];
        private final String[] R = new String[3];

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.search.view.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public class ViewTreeObserverOnGlobalLayoutListenerC8552a implements ViewTreeObserver.OnGlobalLayoutListener {
            ViewTreeObserverOnGlobalLayoutListenerC8552a() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.f285159f != null) {
                    a.this.f285159f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.f285159f.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = (int) (a.this.f285159f.getWidth() / 2.3f);
                        a.this.f285159f.requestLayout();
                    }
                }
            }
        }

        public a(Context context) {
            this.f285157d = context;
        }

        private void d(String str) {
            Intent intent = new Intent(this.f285157d, (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("param_force_internal_browser", true);
            intent.putExtra("url", str);
            WebAccelerator.s(this.f285157d, intent, str);
        }

        private void h(String str, ImageView imageView) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("RichTemplateOneSearchResultView", 2, "setImageUrl " + str);
                }
                imageView.setImageDrawable(URLDrawable.getDrawable(new URL(str), 0, 0, (Drawable) new ColorDrawable(-1315339), (Drawable) new ColorDrawable(-1315339), true));
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("RichTemplateOneSearchResultView", 2, "setImageUrl error " + e16.toString());
                }
                imageView.setImageDrawable(new ColorDrawable(-1315339));
            }
        }

        void b() {
            int i3;
            int i16;
            String str = this.K;
            String str2 = "";
            if (str != null) {
                this.f285160h.setText(str);
            } else {
                this.f285160h.setText("");
            }
            String str3 = this.L;
            if (str3 != null) {
                this.f285161i.setText(str3);
            } else {
                this.f285161i.setText("");
            }
            if (!TextUtils.isEmpty(this.J)) {
                h(this.J, this.f285158e);
            } else {
                this.f285158e.setImageDrawable(null);
            }
            if (!TextUtils.isEmpty(this.M)) {
                this.F.setOnClickListener(this);
                View view = this.F;
                String str4 = this.N;
                if (str4 != null) {
                    str2 = str4;
                }
                view.setContentDescription(str2);
                this.F.setVisibility(0);
                h(this.M, this.f285159f);
            } else {
                this.F.setVisibility(8);
                this.f285159f.setImageDrawable(null);
            }
            if (!TextUtils.isEmpty(this.N)) {
                TextView textView = this.f285162m;
                if (aq.a()) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                textView.setVisibility(i3);
                this.f285162m.setText(this.N);
                QUIButton qUIButton = this.C;
                if (aq.a()) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                qUIButton.setVisibility(i16);
                this.C.setText(this.N);
            } else {
                this.f285162m.setVisibility(8);
                this.C.setVisibility(8);
            }
            for (int i17 = 0; i17 < 3; i17++) {
                if (!TextUtils.isEmpty(this.Q[i17])) {
                    this.D[i17].setVisibility(0);
                    this.D[i17].setText(this.Q[i17]);
                    this.D[i17].setOnClickListener(this);
                    this.E[i17].setVisibility(0);
                } else {
                    this.D[i17].setVisibility(8);
                    this.E[i17].setVisibility(8);
                }
                if (this.H == 1) {
                    this.E[i17].setBackgroundColor(this.f285157d.getResources().getColor(R.color.aci));
                } else {
                    this.E[i17].setBackgroundColor(-1315339);
                }
            }
            this.G.setOnClickListener(new c());
        }

        public String c() {
            return this.K;
        }

        void e(String str) {
            JSONObject jSONObject;
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    Object obj = optJSONObject.get("serverdata");
                    if (obj != null) {
                        if (obj instanceof String) {
                            jSONObject = new JSONObject((String) obj);
                        } else if (obj instanceof JSONObject) {
                            jSONObject = (JSONObject) obj;
                        } else {
                            jSONObject = new JSONObject();
                        }
                        this.I = jSONObject.optInt("appid");
                        this.J = jSONObject.optString(AssetExtension.SCENE_THUMBNAIL);
                        this.K = jSONObject.optString("title");
                        this.L = jSONObject.optString("sub_title");
                        this.M = jSONObject.optString("bg_pic_url");
                        this.N = jSONObject.optString("bg_main_btn_text");
                        this.P = jSONObject.optString("bg_main_btn_url");
                        JSONArray optJSONArray = jSONObject.optJSONArray("bottom_btn_list");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i3 = 0; i3 < length; i3++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                                if (optJSONObject2 != null && i3 < 3) {
                                    this.Q[i3] = optJSONObject2.optString("bottom_btn_text");
                                    this.R[i3] = optJSONObject2.optString("bottom_btn_url");
                                }
                            }
                        }
                    }
                    JSONObject jSONObject2 = optJSONObject.getJSONObject("extradata");
                    if (jSONObject2 != null) {
                        this.S = jSONObject2.getInt("entry");
                        this.T = jSONObject2.getInt(QZoneImageUtils.KEY_MATCH);
                        this.U = jSONObject2.getString("keyword");
                        this.H = jSONObject2.optInt("nightmode", 0);
                    }
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("RichTemplateOneSearchResultView", 2, "initData error " + e16.toString());
                }
            }
        }

        void f(View view) {
            if (view != null) {
                this.f285158e = (ImageView) view.findViewById(R.id.d_7);
                this.f285159f = (ImageView) view.findViewById(R.id.a7w);
                this.f285160h = (TextView) view.findViewById(R.id.f5j);
                this.f285161i = (TextView) view.findViewById(R.id.f164969bh1);
                this.f285162m = (TextView) view.findViewById(R.id.ele);
                this.C = (QUIButton) view.findViewById(R.id.yw4);
                this.D[0] = (TextView) view.findViewById(R.id.amb);
                this.D[1] = (TextView) view.findViewById(R.id.amc);
                this.D[2] = (TextView) view.findViewById(R.id.amd);
                this.F = view.findViewById(R.id.a7x);
                this.E[0] = view.findViewById(R.id.abj);
                this.E[1] = view.findViewById(R.id.abl);
                this.E[2] = view.findViewById(R.id.abk);
                this.G = view.findViewById(R.id.ame);
                ImageView imageView = this.f285158e;
                if (imageView instanceof ThemeImageView) {
                    ((ThemeImageView) imageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
                }
                ImageView imageView2 = this.f285159f;
                if (imageView2 instanceof ThemeImageView) {
                    ((ThemeImageView) imageView2).setMaskShape(ThemeImageWrapper.MODE_OTHER);
                }
                if (aq.a()) {
                    for (TextView textView : this.D) {
                        if (textView != null) {
                            textView.setTextColor(view.getResources().getColorStateList(R.color.qui_common_text_primary));
                        }
                    }
                    RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) view.findViewById(R.id.f17);
                    roundCorneredFrameLayout.f199761d = 0;
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) roundCorneredFrameLayout.getLayoutParams();
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    roundCorneredFrameLayout.setLayoutParams(layoutParams);
                }
                this.f285159f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC8552a());
                view.setOnClickListener(new b());
            }
        }

        void g() {
            this.I = 0;
            this.J = null;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = null;
            this.P = null;
            this.H = 0;
            this.S = 0;
            this.T = 0;
            this.U = null;
            for (int i3 = 0; i3 < 3; i3++) {
                this.Q[i3] = null;
                this.R[i3] = null;
            }
        }

        protected void i(k.d dVar) {
            this.V = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005e  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            int i3;
            int i16;
            k.d dVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.a7x) {
                str = this.P;
                i16 = 4;
            } else {
                if (id5 == R.id.amb) {
                    str = this.R[0];
                    i3 = 1;
                } else if (id5 == R.id.amc) {
                    str = this.R[1];
                    i3 = 2;
                } else if (id5 == R.id.amd) {
                    str = this.R[2];
                    i16 = 3;
                } else {
                    str = null;
                    i3 = 0;
                }
                if (this.T != 1) {
                    com.tencent.mobileqq.search.report.b.i(null, this.S, 0, "0X8009D2D", this.I, i3, this.U);
                } else {
                    com.tencent.mobileqq.search.report.b.i(null, this.S, 0, "0X8009D41", this.I, i3, this.U);
                }
                if (str != null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("RichTemplateOneSearchResultView", 2, "onClick " + str);
                    }
                    if (str.startsWith("http")) {
                        d(str);
                    } else {
                        ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), this.f285157d, str);
                        if (c16 != null) {
                            c16.b();
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e("RichTemplateOneSearchResultView", 2, "wrong url " + str);
                            }
                            d(str);
                        }
                    }
                }
                dVar = this.V;
                if (dVar != null) {
                    dVar.onAction();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
            i3 = i16;
            if (this.T != 1) {
            }
            if (str != null) {
            }
            dVar = this.V;
            if (dVar != null) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }
    }
}
