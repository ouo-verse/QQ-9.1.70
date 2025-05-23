package b7;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.WidgetQzoneVipData;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private View f28034a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f28035a;

        /* renamed from: b, reason: collision with root package name */
        public String f28036b;

        /* renamed from: c, reason: collision with root package name */
        public String f28037c;

        /* renamed from: d, reason: collision with root package name */
        public String f28038d;

        a() {
        }

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                aVar.f28035a = jSONObject.optString("vip_text_color_main");
                aVar.f28036b = jSONObject.optString("vip_text_color_second");
                aVar.f28037c = jSONObject.optString("vip_background_image");
                aVar.f28038d = jSONObject.optString("vip_separate_color");
                aVar.f28035a = com.qzone.homepage.diy.util.a.c(aVar.f28035a, "#A3ffffff");
                aVar.f28036b = com.qzone.homepage.diy.util.a.c(aVar.f28036b, TipsElementData.DEFAULT_COLOR);
                aVar.f28038d = com.qzone.homepage.diy.util.a.c(aVar.f28038d, TipsElementData.DEFAULT_COLOR);
                return aVar;
            } catch (JSONException e16) {
                MonitorManager.f().h(24, 4, "parse vip json error = " + str, false);
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b extends g<a> {
        private TextView E;
        private TextView F;
        private TextView G;
        private TextView H;
        private TextView I;
        private RelativeLayout J;
        private ImageView K;
        private View L;
        private RelativeLayout M;
        private TextView N;
        private TextView P;
        private WidgetQzoneVipData Q;
        private VipResourcesListener R;
        private ImageLoader.ImageLoadListener S;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes39.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f28039d;

            a(String str) {
                this.f28039d = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.this.Q != null && view.getTag() != null && (view.getTag() instanceof Boolean)) {
                    if (((Boolean) view.getTag()).booleanValue()) {
                        PersonalityEnv.clickUnionVip(((e15.f) b.this).f395367e.getContext(), b.this.Q.uin);
                    } else {
                        if (TextUtils.isEmpty(this.f28039d)) {
                            str = "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source=guajian&qua={qua}";
                        } else {
                            str = this.f28039d;
                        }
                        yo.d.d(str, ((e15.f) b.this).f395367e.getContext(), null);
                    }
                }
                com.qzone.homepage.diy.util.a.d(8);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(String str, View view) {
            super(str, view);
            this.R = new C0107b();
            this.S = new c();
        }

        private void G(a aVar) {
            Drawable loadImage;
            if (!TextUtils.isEmpty(aVar.f28035a)) {
                int parseColor = Color.parseColor(aVar.f28035a);
                this.E.setTextColor(parseColor);
                this.G.setTextColor(parseColor);
                this.N.setTextColor(parseColor);
            }
            if (!TextUtils.isEmpty(aVar.f28036b)) {
                int parseColor2 = Color.parseColor(aVar.f28036b);
                this.F.setTextColor(parseColor2);
                this.H.setTextColor(parseColor2);
                this.I.setTextColor(parseColor2);
                this.P.setTextColor(parseColor2);
            }
            if (!TextUtils.isEmpty(aVar.f28038d)) {
                this.L.setBackgroundColor(Color.parseColor(aVar.f28038d));
            }
            if (TextUtils.isEmpty(aVar.f28037c) || (loadImage = ImageLoader.getInstance().loadImage(aVar.f28037c, this)) == null) {
                return;
            }
            this.J.setBackgroundDrawable(loadImage);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00a5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void H(long j3) {
            Drawable comVipIcon;
            boolean z16;
            VasCommonReporter.getHistoryFeature().setValue1("qzoneVipWidget").setValue2("diyView").report();
            WidgetQzoneVipData qzoneVipFromCache = QzoneWidgetService.getInstance().getQzoneVipFromCache(j3);
            this.Q = qzoneVipFromCache;
            String str = "";
            if (qzoneVipFromCache != null) {
                String str2 = qzoneVipFromCache.vipurl;
                this.F.setText(this.Q.vipSpeed + "");
                this.H.setText(this.Q.vipKeepdays + "");
                WidgetQzoneVipData widgetQzoneVipData = this.Q;
                int i3 = widgetQzoneVipData.comVipType;
                int i16 = widgetQzoneVipData.comViplevel;
                String str3 = widgetQzoneVipData.personalizedYellowVipUrl;
                boolean z17 = widgetQzoneVipData.isComAnnualVip;
                boolean z18 = widgetQzoneVipData.isComAnnualVipEver;
                boolean z19 = widgetQzoneVipData.isCustomDiamondUser;
                String str4 = widgetQzoneVipData.customDiamondUrl;
                if (widgetQzoneVipData.showNewVip) {
                    comVipIcon = E(cooperation.vip.vipcomponent.util.c.g(7, -1, widgetQzoneVipData.qqNewIconMap));
                } else if (widgetQzoneVipData.isUnionVip && widgetQzoneVipData.showUnionVip) {
                    comVipIcon = E(cooperation.vip.vipcomponent.util.c.g(7, widgetQzoneVipData.unionVipLevel, widgetQzoneVipData.qqUnionIconMap));
                    z16 = true;
                    if (comVipIcon != null) {
                        this.K.setImageDrawable(comVipIcon);
                    }
                    this.J.setTag(Boolean.valueOf(z16));
                    if (!this.Q.isVip) {
                        this.E.setVisibility(0);
                        this.F.setVisibility(0);
                        this.K.setVisibility(0);
                        this.L.setVisibility(0);
                        this.G.setVisibility(0);
                        this.H.setVisibility(0);
                        this.I.setVisibility(0);
                        this.M.setVisibility(8);
                    } else {
                        this.K.setVisibility(0);
                        this.K.setImageResource(R.drawable.g0d);
                        this.F.setVisibility(8);
                        this.F.setVisibility(8);
                        this.L.setVisibility(8);
                        this.G.setVisibility(8);
                        this.H.setVisibility(8);
                        this.I.setVisibility(8);
                        this.M.setVisibility(0);
                    }
                    str = str2;
                } else {
                    comVipIcon = VipComponentProxy.f50997g.getUiInterface().getComVipIcon(i16, i3, z17, z18, z19, str4, 7, str3, this.R);
                }
                z16 = false;
                if (comVipIcon != null) {
                }
                this.J.setTag(Boolean.valueOf(z16));
                if (!this.Q.isVip) {
                }
                str = str2;
            } else {
                this.K.setVisibility(0);
                this.K.setImageResource(R.drawable.g0d);
            }
            this.J.setOnClickListener(new a(str));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public a w(String str) {
            return a.a(str);
        }

        @Override // e15.f, android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj;
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2 && (obj = message.obj) != null && (obj instanceof Drawable)) {
                    this.K.setImageDrawable((Drawable) obj);
                }
            } else {
                Object obj2 = message.obj;
                if (obj2 != null && (obj2 instanceof Drawable)) {
                    this.J.setBackgroundDrawable((Drawable) obj2);
                }
            }
            return super.handleMessage(message);
        }

        @Override // b7.g, android.view.View.OnClickListener
        public void onClick(View view) {
            WidgetQzoneVipData widgetQzoneVipData;
            EventCollector.getInstance().onViewClickedBefore(view);
            super.onClick(view);
            if (view.getId() == R.id.kz_ && (widgetQzoneVipData = this.Q) != null) {
                yo.d.d(widgetQzoneVipData.vipurl, this.f395367e.getContext(), null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // e15.f
        public void p() {
            ViewGroup.LayoutParams layoutParams;
            super.p();
            View view = this.f395367e;
            if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.width = ViewUtils.dip2px(132.0f);
            layoutParams.height = ViewUtils.dip2px(48.0f);
            this.f395367e.setLayoutParams(layoutParams);
        }

        @Override // b7.g
        String u() {
            return "content";
        }

        @Override // b7.g
        void v() {
            this.E = (TextView) this.f395367e.findViewById(R.id.f167115kz4);
            this.F = (TextView) this.f395367e.findViewById(R.id.kz5);
            this.G = (TextView) this.f395367e.findViewById(R.id.kz6);
            this.H = (TextView) this.f395367e.findViewById(R.id.kz8);
            this.I = (TextView) this.f395367e.findViewById(R.id.kz7);
            this.J = (RelativeLayout) this.f395367e.findViewById(R.id.kz_);
            this.K = (ImageView) this.f395367e.findViewById(R.id.kyy);
            this.L = this.f395367e.findViewById(R.id.kww);
            this.M = (RelativeLayout) this.f395367e.findViewById(R.id.iec);
            this.N = (TextView) this.f395367e.findViewById(R.id.kyz);
            this.P = (TextView) this.f395367e.findViewById(R.id.f167113kz0);
            this.J.setOnClickListener(this);
        }

        @Override // b7.g
        public void z(long j3, x6.a aVar) {
            super.z(j3, aVar);
            H(j3);
        }

        /* compiled from: P */
        /* renamed from: b7.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0107b implements VipResourcesListener {
            C0107b() {
            }

            @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
            public void onLoaded(Drawable drawable) {
                if (drawable != null) {
                    b.this.x(2, drawable);
                }
            }

            @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
            public void onFailed() {
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class c implements ImageLoader.ImageLoadListener {
            c() {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                if (drawable != null) {
                    b.this.x(2, drawable);
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        }

        private Drawable E(QQUnionIconInfo qQUnionIconInfo) {
            if (qQUnionIconInfo == null || TextUtils.isEmpty(qQUnionIconInfo.mIconUrl)) {
                return null;
            }
            Drawable loadImage = ImageLoader.getInstance().loadImage(qQUnionIconInfo.mIconUrl, this.S);
            ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = ViewUtils.dpToPx(qQUnionIconInfo.mIconWidth / 2.0f);
                layoutParams.height = ViewUtils.dpToPx(qQUnionIconInfo.mIconHeight / 2.0f);
                this.K.setLayoutParams(layoutParams);
            }
            return loadImage;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public void A(a aVar) {
            if (aVar != null) {
                G(aVar);
            }
        }
    }

    public f(Context context) {
        this.f28034a = LayoutInflater.from(context).inflate(R.layout.bk6, (ViewGroup) null, true);
    }

    public View a() {
        return this.f28034a;
    }
}
