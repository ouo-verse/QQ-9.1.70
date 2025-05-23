package com.qzone.album.business.photolist.ui.interactingbar;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.ui.interactingbar.a;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.util.ar;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class HostAlbumInteractingBarUIContainer extends com.qzone.album.business.photolist.ui.interactingbar.b {

    /* renamed from: w, reason: collision with root package name */
    private static boolean f43540w = u5.b.D("keyShortcutNoticeExposed", false);

    /* renamed from: f, reason: collision with root package name */
    public String f43541f;

    /* renamed from: g, reason: collision with root package name */
    public String f43542g;

    /* renamed from: h, reason: collision with root package name */
    public String f43543h;

    /* renamed from: i, reason: collision with root package name */
    public String f43544i;

    /* renamed from: j, reason: collision with root package name */
    public String f43545j;

    /* renamed from: k, reason: collision with root package name */
    public int f43546k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f43547l;

    /* renamed from: m, reason: collision with root package name */
    public String f43548m;

    /* renamed from: n, reason: collision with root package name */
    public HashMap<Integer, HashMap<String, String>> f43549n;

    /* renamed from: o, reason: collision with root package name */
    public JSONObject f43550o;

    /* renamed from: p, reason: collision with root package name */
    public RelativeLayout f43551p;

    /* renamed from: q, reason: collision with root package name */
    public RelativeLayout f43552q;

    /* renamed from: r, reason: collision with root package name */
    public RelativeLayout f43553r;

    /* renamed from: s, reason: collision with root package name */
    public RelativeLayout f43554s;

    /* renamed from: t, reason: collision with root package name */
    public RelativeLayout f43555t;

    /* renamed from: u, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.menu.a f43556u;

    /* renamed from: v, reason: collision with root package name */
    private Runnable f43557v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = HostAlbumInteractingBarUIContainer.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.b(view, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = HostAlbumInteractingBarUIContainer.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.g(view, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f43562d;

        d(HashMap hashMap) {
            this.f43562d = hashMap;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            yo.d.d((String) this.f43562d.get("iconSchema"), HostAlbumInteractingBarUIContainer.this.f43578b, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HostAlbumInteractingBarUIContainer.this.f43580d.f(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HostAlbumInteractingBarUIContainer.this.f43580d.h(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HostAlbumInteractingBarUIContainer.this.f43580d.c(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HostAlbumInteractingBarUIContainer.this.f43580d.b(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HostAlbumInteractingBarUIContainer.this.f43580d.g(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = HostAlbumInteractingBarUIContainer.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.f(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = HostAlbumInteractingBarUIContainer.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.h(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = HostAlbumInteractingBarUIContainer.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.c(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public HostAlbumInteractingBarUIContainer(Activity activity, BasePhotoModelController basePhotoModelController, a.InterfaceC0344a interfaceC0344a) {
        super(activity, basePhotoModelController, interfaceC0344a);
        this.f43541f = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumEdit", "\u7f16\u8f91\u76f8\u518c");
        this.f43542g = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumpProcessBatch", "\u6279\u91cf\u7ba1\u7406");
        this.f43543h = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumMakeDynamicAlbum", "\u5236\u4f5c");
        this.f43544i = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSharing", "\u5206\u4eab");
        this.f43545j = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumMore", "\u66f4\u591a");
        this.f43546k = 5;
        this.f43547l = true;
        this.f43557v = new Runnable() { // from class: com.qzone.album.business.photolist.ui.interactingbar.HostAlbumInteractingBarUIContainer.6
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = HostAlbumInteractingBarUIContainer.this.f43578b;
                if (activity2 == null || !activity2.isFinishing()) {
                    HostAlbumInteractingBarUIContainer.this.f43556u.b(HostAlbumInteractingBarUIContainer.this.f43555t, 0, -ar.e(130.0f));
                    HostAlbumInteractingBarUIContainer.f43540w = true;
                    u5.b.o0("keyShortcutNoticeExposed", true);
                }
            }
        };
    }

    private RelativeLayout l(int i3, HashMap<Integer, HashMap<String, String>> hashMap) {
        if (this.f43578b == null) {
            return null;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f43578b);
        ImageView imageView = new ImageView(this.f43578b);
        imageView.setId(1);
        relativeLayout.addView(imageView);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, ar.d(6.0f), 0, 0);
        layoutParams.width = ar.e(25.0f);
        layoutParams.height = ar.e(25.0f);
        TextView textView = new TextView(this.f43578b);
        textView.setId(2);
        textView.setTextColor(Color.parseColor("#838383"));
        textView.setTextSize(10.0f);
        relativeLayout.addView(textView);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.addRule(3, 1);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, ar.d(1.0f), 0, 0);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        if (i3 == 0) {
            imageView.setImageResource(R.drawable.fuq);
            textView.setText(this.f43541f);
            relativeLayout.setOnClickListener(new j());
        } else if (i3 == 1) {
            imageView.setImageResource(R.drawable.fvl);
            textView.setText(this.f43542g);
            relativeLayout.setOnClickListener(new k());
        } else if (i3 == 2) {
            imageView.setImageResource(R.drawable.fvk);
            textView.setText(this.f43543h);
            relativeLayout.setOnClickListener(new l());
            com.qzone.album.env.common.a.m().P(326, 2, "31", true, m());
        } else if (i3 == 3) {
            imageView.setImageResource(R.drawable.fwn);
            textView.setText(this.f43544i);
            relativeLayout.setOnClickListener(new a());
        } else if (i3 != 4) {
            q(i3, hashMap, imageView, textView, relativeLayout);
        } else {
            imageView.setImageResource(R.drawable.fvo);
            textView.setText(this.f43545j);
            relativeLayout.setOnClickListener(new b());
        }
        return relativeLayout;
    }

    private String m() {
        BasePhotoModelController basePhotoModelController = this.f43579c;
        if (basePhotoModelController == null) {
            return "";
        }
        if (basePhotoModelController.i3()) {
            return "travel";
        }
        if (this.f43579c.e3()) {
            return HippyNestedScrollComponent.PRIORITY_PARENT;
        }
        if (this.f43579c.Y2()) {
            return "lover";
        }
        return "common";
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public int a() {
        return this.f43546k;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public ImageView b() {
        return null;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void d() {
        Activity activity = this.f43578b;
        if (activity == null || this.f43579c == null || this.f43580d == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.e4t);
        this.f43577a = linearLayout;
        if (linearLayout == null) {
            return;
        }
        if (!this.f43547l) {
            try {
                if (!TextUtils.isEmpty(this.f43548m) && this.f43548m.toCharArray() != null && this.f43548m.toCharArray().length > 0) {
                    LinearLayout linearLayout2 = (LinearLayout) this.f43577a.findViewById(R.id.e4u);
                    if (linearLayout2 != null) {
                        linearLayout2.removeAllViews();
                        for (char c16 : this.f43548m.toCharArray()) {
                            RelativeLayout l3 = l(Integer.parseInt(c16 + ""), this.f43549n);
                            linearLayout2.addView(l3);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) l3.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            layoutParams.height = -1;
                            layoutParams.width = 0;
                        }
                        return;
                    }
                } else {
                    this.f43547l = true;
                }
            } catch (Exception e16) {
                com.qzone.album.env.common.a.m().g(com.qzone.album.business.photolist.ui.interactingbar.b.f43576e, e16);
                this.f43547l = true;
            }
        }
        if (this.f43547l) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f43578b.findViewById(R.id.hb5);
            this.f43551p = relativeLayout;
            relativeLayout.setOnClickListener(new e());
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f43578b.findViewById(R.id.hd7);
            this.f43552q = relativeLayout2;
            relativeLayout2.setOnClickListener(new f());
            RelativeLayout relativeLayout3 = (RelativeLayout) this.f43578b.findViewById(R.id.haz);
            this.f43553r = relativeLayout3;
            relativeLayout3.setOnClickListener(new g());
            com.qzone.album.env.common.a.m().P(326, 2, "31", true, m());
            RelativeLayout relativeLayout4 = (RelativeLayout) this.f43578b.findViewById(R.id.hd9);
            this.f43554s = relativeLayout4;
            relativeLayout4.setOnClickListener(new h());
            RelativeLayout relativeLayout5 = (RelativeLayout) this.f43578b.findViewById(R.id.hcc);
            this.f43555t = relativeLayout5;
            relativeLayout5.setOnClickListener(new i());
            o();
        }
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void f() {
        JSONArray optJSONArray;
        if (this.f43550o == null || this.f43547l) {
            return;
        }
        try {
            this.f43549n = new HashMap<>();
            int optInt = this.f43550o.optInt("count", 5);
            this.f43546k = optInt;
            if (optInt > 5 && (optJSONArray = this.f43550o.optJSONArray("addList")) != null) {
                for (int i3 = 0; i3 < this.f43546k - 5; i3++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    String optString = jSONObject.optString("iconUrl");
                    String optString2 = jSONObject.optString("iconName");
                    String optString3 = jSONObject.optString("iconSchema");
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("iconUrl", optString);
                    hashMap.put("iconName", optString2);
                    hashMap.put("iconSchema", optString3);
                    this.f43549n.put(Integer.valueOf(i3), hashMap);
                }
            }
            this.f43548m = this.f43550o.optString("order");
        } catch (JSONException e16) {
            com.qzone.album.env.common.a.m().g(com.qzone.album.business.photolist.ui.interactingbar.b.f43576e, e16);
        }
    }

    public void k() {
        if (f43540w || !QZoneAlbumUtil.c()) {
            return;
        }
        this.f43556u = new com.qzone.album.business.photolist.ui.menu.a(this.f43578b);
        QzoneHandlerThreadFactory.getMainHandler().removeCallbacks(this.f43557v);
        QzoneHandlerThreadFactory.getMainHandler().postDelayed(this.f43557v, 1000L);
    }

    public void n() {
        if (f43540w) {
            return;
        }
        QzoneHandlerThreadFactory.getMainHandler().removeCallbacks(this.f43557v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f43560d;

        c(ImageView imageView) {
            this.f43560d = imageView;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                this.f43560d.setBackgroundDrawable(drawable);
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

    private void o() {
        RelativeLayout[] relativeLayoutArr = {this.f43551p, this.f43552q, this.f43553r, this.f43554s, this.f43555t};
        String[] strArr = {this.f43541f, this.f43542g, this.f43543h, this.f43544i, this.f43545j};
        for (int i3 = 0; i3 < 5; i3++) {
            p(relativeLayoutArr[i3], strArr[i3]);
        }
    }

    private void q(int i3, HashMap<Integer, HashMap<String, String>> hashMap, ImageView imageView, TextView textView, RelativeLayout relativeLayout) {
        HashMap<String, String> hashMap2;
        if (hashMap == null || hashMap.isEmpty() || imageView == null || textView == null || relativeLayout == null || (hashMap2 = hashMap.get(Integer.valueOf(i3 - 5))) == null || hashMap2.isEmpty()) {
            return;
        }
        ImageLoader.getInstance().loadImageAsync(hashMap2.get("iconUrl"), new c(imageView));
        textView.setText(hashMap2.get("iconName"));
        relativeLayout.setOnClickListener(new d(hashMap2));
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public boolean e() {
        try {
            JSONObject jSONObject = new JSONObject(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_INTERACTING_BAR_HOST_USE_ORIGINAL_LAYOUT, QzoneConfig.DefaultValue.DEFAULT_USE_ORIGINAL));
            this.f43550o = jSONObject;
            if (Integer.valueOf(jSONObject.optString("useOriginal")).intValue() != 1) {
                this.f43547l = false;
                return true;
            }
            this.f43547l = true;
            return false;
        } catch (JSONException e16) {
            com.qzone.album.env.common.a.m().g(com.qzone.album.business.photolist.ui.interactingbar.b.f43576e, e16);
            this.f43547l = true;
            return false;
        }
    }

    private void p(View view, String str) {
        if (view == null || str == null || "".equals(str)) {
            return;
        }
        AccessibilityUtil.p(view, str);
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void g(int i3) {
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void h(boolean z16, int i3) {
    }
}
