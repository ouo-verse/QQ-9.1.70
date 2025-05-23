package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantNovelSpeciesView;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.manager.g;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ElegantNovelSpeciesView extends IntimateContentItemBaseView {
    private static final boolean K = VasToggle.VAS_NOVEL_SPECIES_NEW.isEnable(true);
    private g.c F;
    private TextView G;
    private TextView H;
    private ImageView I;
    private TextView J;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ElegantNovelSpeciesView> f179212a;

        public a(ElegantNovelSpeciesView elegantNovelSpeciesView) {
            super(Looper.getMainLooper());
            this.f179212a = new WeakReference<>(elegantNovelSpeciesView);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                Object obj = message.obj;
                if (obj instanceof g.c) {
                    g.c cVar = (g.c) obj;
                    WeakReference<ElegantNovelSpeciesView> weakReference = this.f179212a;
                    if (weakReference != null && weakReference.get() != null) {
                        this.f179212a.get().w(cVar);
                    }
                }
            }
        }
    }

    public ElegantNovelSpeciesView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(a aVar, g.c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = cVar;
        aVar.sendMessage(obtain);
    }

    private void v(g.c cVar) {
        this.F = null;
        this.G.setText(cVar.f391290a);
        this.H.setText(cVar.f391292c);
        if (cVar.f391294e == 0) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.J.setText(String.valueOf(cVar.f391294e));
        if (QLog.isColorLevel()) {
            QLog.i("ElegantNovelSpeciesView", 1, "url: " + cVar.f391291b);
        }
        this.I.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(cVar.f391291b).a());
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() && K) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.f168211fd1, (ViewGroup) this, true);
        this.G = (TextView) inflate.findViewById(R.id.xez);
        this.H = (TextView) inflate.findViewById(R.id.f165738xf4);
        this.I = (ImageView) inflate.findViewById(R.id.f165736xf2);
        this.J = (TextView) inflate.findViewById(R.id.yx7);
        inflate.setOnClickListener(this);
        inflate.setOnTouchListener(this);
        MobileReportManager.getInstance().reportAction("yangcheng", "4", "ZengzhiOpen", "new_species", "1", 101, 0, 0L);
        MobileReportManager.getInstance().reportAction("ZengzhiOpen", "new_species", "1", 111, 0, 0L);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
        String stringDataSet = VasToggle.VAS_NOVEL_SPECIES.getStringDataSet("url", "");
        if (TextUtils.isEmpty(stringDataSet)) {
            QLog.e("ElegantNovelSpeciesView", 1, "doOnClick url == null");
            return;
        }
        String replace = stringDataSet.replace("\u5408\u517b\u4eba", this.f179220e);
        QLog.d("ElegantNovelSpeciesView", 1, "doOnClick url == " + replace);
        Context context = view.getContext();
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, replace);
        } else {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", replace);
            context.startActivity(intent);
        }
        MobileReportManager.getInstance().reportAction("yangcheng", "4", "ZengzhiOpen", "new_species", "1", 102, 0, 0L);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_newelement", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
        g.c cVar = this.F;
        if (cVar != null) {
            v(cVar);
        }
    }

    public void t(String str) {
        if (!a()) {
            return;
        }
        final a aVar = new a(this);
        if (TextUtils.isEmpty(str)) {
            QLog.e("ElegantNovelSpeciesView", 1, "getNovelSpeciesValue friendUin == null");
        } else {
            new g().b(Long.parseLong(str), 1, new g.b() { // from class: com.tencent.mobileqq.activity.aio.intimate.view.a
                @Override // cooperation.vip.manager.g.b
                public final void a(g.c cVar) {
                    ElegantNovelSpeciesView.u(ElegantNovelSpeciesView.a.this, cVar);
                }
            });
        }
    }

    public void w(g.c cVar) {
        if (!a()) {
            return;
        }
        if (cVar.a()) {
            QLog.e("ElegantNovelSpeciesView", 1, "updateViewData NovelInfo isEmpty");
        } else if (this.G == null) {
            QLog.e("ElegantNovelSpeciesView", 1, "updateViewData mContentView == null");
            this.F = cVar;
        } else {
            v(cVar);
        }
    }

    public ElegantNovelSpeciesView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ElegantNovelSpeciesView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
