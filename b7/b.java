package b7;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import common.config.service.QzoneConfig;
import cooperation.vip.manager.MonitorManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private View f28014a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: b7.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0106b {

        /* renamed from: a, reason: collision with root package name */
        public String f28017a;

        /* renamed from: b, reason: collision with root package name */
        public String f28018b;

        /* renamed from: c, reason: collision with root package name */
        public String f28019c;

        /* renamed from: d, reason: collision with root package name */
        public String f28020d;

        C0106b() {
        }

        public static C0106b a(String str) {
            try {
                C0106b c0106b = new C0106b();
                JSONObject jSONObject = new JSONObject(str);
                c0106b.f28017a = jSONObject.optString("intimacy_text_color_main");
                c0106b.f28018b = jSONObject.optString("intimacy_text_color_second");
                c0106b.f28019c = jSONObject.optString("intimacy_background_image");
                c0106b.f28020d = jSONObject.optString("intimacy_background_icon");
                c0106b.f28017a = com.qzone.homepage.diy.util.a.c(c0106b.f28017a, "#A3ffffff");
                c0106b.f28018b = com.qzone.homepage.diy.util.a.c(c0106b.f28018b, TipsElementData.DEFAULT_COLOR);
                return c0106b;
            } catch (JSONException e16) {
                MonitorManager.f().h(24, 4, "parse intimacy json error = " + str, false);
                e16.printStackTrace();
                return null;
            }
        }
    }

    public b(Context context) {
        this.f28014a = LayoutInflater.from(context).inflate(R.layout.f169005bk3, (ViewGroup) null, true);
    }

    public View a() {
        return this.f28014a;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends g<C0106b> {
        private TextView E;
        private TextView F;
        private AsyncImageView G;
        private LinearLayout H;
        private String I;

        /* compiled from: P */
        /* renamed from: b7.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class ViewOnClickListenerC0105a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f28015d;

            ViewOnClickListenerC0105a(long j3) {
                this.f28015d = j3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!TextUtils.isEmpty(a.this.I)) {
                    com.qzone.homepage.diy.util.a.d(7);
                    vo.c.k(((e15.f) a.this).f395367e.getContext(), a.this.I, this.f28015d);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(String str, View view) {
            super(str, view);
            this.I = "";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0106b w(String str) {
            return C0106b.a(str);
        }

        @Override // e15.f, android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj;
            if (message.what == 1 && (obj = message.obj) != null && (obj instanceof Drawable)) {
                this.H.setBackgroundDrawable((Drawable) obj);
            }
            return super.handleMessage(message);
        }

        @Override // e15.f
        public void p() {
            ViewGroup.LayoutParams layoutParams;
            super.p();
            View view = this.f395367e;
            if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.width = ViewUtils.dip2px(84.0f);
            layoutParams.height = ViewUtils.dip2px(24.0f);
            this.f395367e.setLayoutParams(layoutParams);
        }

        @Override // b7.g
        String u() {
            return "content";
        }

        @Override // b7.g
        void v() {
            this.E = (TextView) this.f395367e.findViewById(R.id.dns);
            this.F = (TextView) this.f395367e.findViewById(R.id.dnt);
            this.G = (AsyncImageView) this.f395367e.findViewById(R.id.dnq);
            this.H = (LinearLayout) this.f395367e.findViewById(R.id.dnr);
        }

        @Override // b7.g
        public void z(long j3, x6.a aVar) {
            super.z(j3, aVar);
            if (!y6.b.f(j3)) {
                this.H.setVisibility(8);
                return;
            }
            if (this.D != null) {
                this.E.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewScore", "\u4eb2\u5bc6\u5ea6"));
                x6.a aVar2 = this.D;
                this.I = aVar2.friendshipJumpUrl;
                this.F.setText(String.valueOf(aVar2.friendship));
            } else {
                this.H.setVisibility(8);
            }
            this.H.setOnClickListener(new ViewOnClickListenerC0105a(j3));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public void A(C0106b c0106b) {
            Drawable loadImage;
            if (c0106b != null) {
                if (!TextUtils.isEmpty(c0106b.f28017a)) {
                    this.E.setTextColor(Color.parseColor(c0106b.f28017a));
                }
                if (!TextUtils.isEmpty(c0106b.f28018b)) {
                    this.F.setTextColor(Color.parseColor(c0106b.f28018b));
                }
                if (!TextUtils.isEmpty(c0106b.f28020d)) {
                    this.G.setAsyncImage(c0106b.f28020d);
                }
                if (TextUtils.isEmpty(c0106b.f28019c) || (loadImage = ImageLoader.getInstance().loadImage(c0106b.f28019c, this)) == null) {
                    return;
                }
                this.H.setBackgroundDrawable(loadImage);
            }
        }
    }
}
