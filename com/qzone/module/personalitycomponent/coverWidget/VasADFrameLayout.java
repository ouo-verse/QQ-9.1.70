package com.qzone.module.personalitycomponent.coverWidget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.util.ar;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VasADFrameLayout extends FrameLayout implements View.OnClickListener, TianShuGetAdvCallback {
    private static final int D = ar.d(111.0f);
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f48920d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f48921e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f48922f;

    /* renamed from: h, reason: collision with root package name */
    private ADInfo f48923h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48924i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f48925m;

    public VasADFrameLayout(Context context) {
        super(context);
        this.f48923h = null;
        this.f48924i = false;
        this.C = 0;
        f(context, null);
    }

    private void e() {
        ADInfo aDInfo = this.f48923h;
        if (aDInfo == null || TextUtils.isEmpty(aDInfo.getJumpUrl()) || getContext() == null) {
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.f48923h.getJumpUrl());
        intent.putExtra("fromQZone", true);
        getContext().startActivity(intent);
        l.f49003a.c(true, this.f48923h.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(FastDynamicDrawable fastDynamicDrawable) {
        FrameLayout frameLayout = this.f48920d;
        if (frameLayout == null || this.f48922f == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        int i3 = D;
        layoutParams.width = i3;
        layoutParams.height = ((int) ((i3 / fastDynamicDrawable.getIntrinsicWidth()) * fastDynamicDrawable.getIntrinsicHeight())) + ar.d(4.0f);
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).bottomMargin = this.C + ar.d(80.0f);
        }
        this.f48920d.setLayoutParams(layoutParams);
        this.f48922f.setVisibility(0);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h(final FastDynamicDrawable fastDynamicDrawable, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.q
            @Override // java.lang.Runnable
            public final void run() {
                VasADFrameLayout.this.g(fastDynamicDrawable);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        final FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(this.f48923h.getIconUrl()).a();
        ImageView imageView = this.f48921e;
        if (imageView != null) {
            imageView.setImageDrawable(a16);
        }
        a16.c0(new Function1() { // from class: com.qzone.module.personalitycomponent.coverWidget.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h16;
                h16 = VasADFrameLayout.this.h(a16, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                return h16;
            }
        });
        setVisibility(0);
    }

    public void f(Context context, AttributeSet attributeSet) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.cog, this);
        this.f48920d = frameLayout;
        this.f48922f = (ImageView) frameLayout.findViewById(R.id.f19716f);
        this.f48921e = (ImageView) this.f48920d.findViewById(R.id.f18653k);
        this.f48922f.setOnClickListener(this);
        this.f48921e.setOnClickListener(this);
        setVisibility(8);
    }

    public void k(Boolean bool, boolean z16) {
        this.f48925m = z16;
        this.f48924i = bool.booleanValue();
        l lVar = l.f49003a;
        if (lVar.a() && bool.booleanValue()) {
            lVar.d(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f19716f) {
            setVisibility(8);
        } else if (view.getId() == R.id.f18653k) {
            e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
    public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        l lVar = l.f49003a;
        ADInfo b16 = lVar.b(getAdsRsp);
        if (b16 == null) {
            QLog.e("QzoneWidgetTianShuTool", 1, "adinfo is null");
            return;
        }
        if (this.f48925m && this.f48924i) {
            if (TextUtils.isEmpty(b16.getIconUrl())) {
                QLog.e("QzoneWidgetTianShuTool", 1, "icon is null");
                return;
            } else {
                if (lVar.a()) {
                    this.f48923h = b16;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            VasADFrameLayout.this.j();
                        }
                    });
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            VasADFrameLayout.this.i();
                        }
                    }, 5000L);
                    lVar.c(false, b16.getInfo());
                    return;
                }
                return;
            }
        }
        QLog.e("QzoneWidgetTianShuTool", 1, "not is vip, master: " + this.f48924i + ", isVip: " + this.f48925m);
    }

    public void setBottomMargin(int i3) {
        this.C = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        setVisibility(8);
    }

    public VasADFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48923h = null;
        this.f48924i = false;
        this.C = 0;
        f(context, attributeSet);
    }
}
