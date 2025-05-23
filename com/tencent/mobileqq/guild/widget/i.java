package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class i {

    /* renamed from: k, reason: collision with root package name */
    private static final int f236368k = ViewUtils.dpToPx(168.0f);

    /* renamed from: l, reason: collision with root package name */
    private static final float f236369l = ViewUtils.dpToPx(3.0f);

    /* renamed from: a, reason: collision with root package name */
    private final ArkViewImplement.LoadCallback f236370a = new a();

    /* renamed from: b, reason: collision with root package name */
    private int f236371b;

    /* renamed from: c, reason: collision with root package name */
    private int f236372c;

    /* renamed from: d, reason: collision with root package name */
    public ArkAppLoadLayout f236373d;

    /* renamed from: e, reason: collision with root package name */
    public ArkAppView f236374e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f236375f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f236376g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f236377h;

    /* renamed from: i, reason: collision with root package name */
    public ArkAppMessage f236378i;

    /* renamed from: j, reason: collision with root package name */
    public ArkAppContainer f236379j;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements ArkViewImplement.LoadCallback {
        a() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildArkViewContainer", 2, "onLoadFinish state=", Integer.valueOf(i3), ",app=", i.this.f236378i.appName);
            }
            if (i3 == 1) {
                Rect containerRect = i.this.f236379j.getContainerRect();
                float c16 = com.tencent.mobileqq.ark.f.c();
                int i16 = (int) ((containerRect.right - containerRect.left) * c16);
                int i17 = (int) (c16 * (containerRect.bottom - containerRect.top));
                ViewGroup.LayoutParams layoutParams = i.this.f236374e.getLayoutParams();
                if (QLog.isColorLevel()) {
                    QLog.i("GuildArkViewContainer", 1, "ArkFold.onLoadFinish arkContainer rect(" + i16 + "," + i17 + "), arkView layout rect(" + layoutParams.width + "," + layoutParams.height + "), init mArkWidth=" + i.this.f236371b + ",mArkHeight=" + i.this.f236372c + ",app=" + i.this.f236378i.appName);
                    return;
                }
                return;
            }
            QLog.e("GuildArkViewContainer", 1, String.format("onLoadState failed: state: %d", Integer.valueOf(i3)));
            i.this.f236375f.setVisibility(8);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int i3, int i16, String str, boolean z16) {
            QLog.e("GuildArkViewContainer", 1, String.format("onLoadFailed : state: %d, errorCode: %d, msg: %s, canRetry: %b", Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16)));
        }
    }

    private ArkAppMessage.Config e(t02.a aVar) {
        this.f236378i = new ArkAppMessage("", aVar.c(), aVar.a(), aVar.d(), aVar.b(), aVar.g(), aVar.e(), "");
        ArkAppMessage.Config config = new ArkAppMessage.Config();
        config.autoSize = 1;
        config.fromString(this.f236378i.config);
        return config;
    }

    public void c() {
        ArkAppContainer arkAppContainer = this.f236379j;
        if (arkAppContainer == null) {
            return;
        }
        arkAppContainer.doOnEvent(2);
        this.f236379j.detachView();
        this.f236379j = null;
    }

    public ViewGroup d(Context context, t02.a aVar, ViewGroup viewGroup) {
        ArkAppMessage.Config e16 = e(aVar);
        h(context, e16, aVar.f());
        return f(context, viewGroup, e16);
    }

    public void g() {
        ArkAppContainer arkAppContainer = this.f236379j;
        if (arkAppContainer != null) {
            arkAppContainer.invalidateRect();
        }
    }

    private ViewGroup f(Context context, ViewGroup viewGroup, ArkAppMessage.Config config) {
        if (viewGroup == null || !(viewGroup instanceof ArkAppRootLayout)) {
            viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.f167726f7, (ViewGroup) null);
        }
        this.f236374e = (ArkAppView) viewGroup.findViewById(R.id.y_);
        this.f236375f = (LinearLayout) viewGroup.findViewById(R.id.f164456yf);
        this.f236376g = (ImageView) viewGroup.findViewById(R.id.f164455ye);
        this.f236377h = (TextView) viewGroup.findViewById(R.id.f164457yg);
        ArkAppLoadLayout arkAppLoadLayout = (ArkAppLoadLayout) viewGroup.findViewById(R.id.eet);
        this.f236373d = arkAppLoadLayout;
        if (arkAppLoadLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) arkAppLoadLayout.getLayoutParams();
            layoutParams.width = ScreenUtil.getInstantScreenWidth(context);
            layoutParams.height = f236368k;
            layoutParams.setMargins(0, 0, 0, 0);
            this.f236373d.setLayoutParams(layoutParams);
        }
        viewGroup.findViewById(R.id.f164471yu).setPadding(0, 0, 0, 0);
        LinearLayout linearLayout = this.f236375f;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ((RelativeLayout.LayoutParams) this.f236374e.getLayoutParams()).addRule(13);
        this.f236374e.setLoadCallback(this.f236370a);
        this.f236374e.setClipRadius(f236369l);
        if (MessageForArkApp.isRectangleBorder(config)) {
            this.f236374e.setBorderType(0);
        } else {
            this.f236374e.setBorderType(1);
        }
        this.f236374e.a(this.f236379j, this.f236373d);
        ArkAppView arkAppView = this.f236374e;
        arkAppView.setOnTouchListener(arkAppView);
        return viewGroup;
    }

    private void h(Context context, ArkAppMessage.Config config, int i3) {
        Integer num = config.autoSize;
        boolean z16 = num != null && num.intValue() == 1;
        int instantScreenWidth = ScreenUtil.getInstantScreenWidth(context) - (i3 >= 0 ? i3 : 0);
        StringBuilder sb5 = new StringBuilder("isSetSize=");
        sb5.append(",param=[");
        ArkAppContainer arkAppContainer = new ArkAppContainer();
        this.f236379j = arkAppContainer;
        arkAppContainer.j(instantScreenWidth, f236368k);
        ArkAppContainer arkAppContainer2 = this.f236379j;
        ArkAppMessage arkAppMessage = this.f236378i;
        arkAppContainer2.h(arkAppMessage.appName, arkAppMessage.appView, arkAppMessage.bizSrc, arkAppMessage.appMinVersion, arkAppMessage.metaList, com.tencent.mobileqq.ark.f.c(), new SessionInfo());
        this.f236371b = z16 ? instantScreenWidth : -1;
        this.f236372c = -1;
        this.f236379j.setFixSize(z16 ? instantScreenWidth : -1, -1);
        sb5.append("arkConfig.width=");
        sb5.append(config.width);
        sb5.append(",arkConfig.height=");
        sb5.append(config.height);
        sb5.append("][autoSize=");
        sb5.append(z16);
        sb5.append(",maxSize=");
        sb5.append(instantScreenWidth);
        sb5.append("]");
        sb5.append(",app=");
        sb5.append(this.f236378i.appName);
        if (QLog.isColorLevel()) {
            QLog.i("GuildArkViewContainer", 1, sb5.toString());
            com.tencent.mobileqq.ark.f.g("GuildArkViewContainer.attachArkView", context);
        }
        int dp2px = MessageForArkApp.dp2px(30.0f);
        int dp2px2 = MessageForArkApp.dp2px(30.0f);
        this.f236379j.setMinSize(dp2px, dp2px2);
        this.f236379j.setHintSize(-1, dp2px2);
    }
}
