package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends m implements e {

    /* renamed from: k, reason: collision with root package name */
    private static a f283754k = new a();

    /* renamed from: h, reason: collision with root package name */
    private b f283755h;

    /* renamed from: i, reason: collision with root package name */
    private ArkNodeContainer f283756i;

    /* renamed from: j, reason: collision with root package name */
    private int f283757j = 0;

    public d(b bVar) {
        this.f283755h = bVar;
        if (bVar != null && QLog.isColorLevel()) {
            QLog.d("ArkRichNode", 2, "id:" + this.f283755h.e() + " appname:" + this.f283755h.a() + " viewname:" + this.f283755h.f() + " miniversion:" + this.f283755h.c() + " path\uff1a" + this.f283755h.b());
        }
    }

    private boolean n() {
        if ("com.tencent.weather".equals(this.f283755h.f283745b) && !com.tencent.mobileqq.weather.util.i.b(this.f283763b, QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.rich.e
    public void a(int i3) {
        this.f283757j = i3;
        h();
    }

    @Override // com.tencent.mobileqq.search.rich.m, com.tencent.mobileqq.search.rich.f
    public void f(String str, String str2, String str3) {
        super.f(str, str2, str3);
        ArkNodeContainer arkNodeContainer = this.f283756i;
        if (arkNodeContainer != null) {
            arkNodeContainer.updateMetaData(getData());
        }
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public int getType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.search.rich.m
    public h i(Context context) {
        if (this.f283755h == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkRichNode", 2, "onCreate config = null");
                return null;
            }
            return null;
        }
        c cVar = new c(this, context);
        if (n()) {
            cVar.s().setVisibility(8);
            return cVar;
        }
        cVar.u(this);
        cVar.a(context);
        f283754k.d(this);
        this.f283756i = new ArkNodeContainer(f283754k);
        this.f283756i.c(this.f283755h, getData(), context.getResources().getDisplayMetrics().scaledDensity);
        this.f283756i.setFixSize(-1, -1);
        cVar.t(this.f283756i);
        this.f283756i.activateView(true, false);
        return cVar;
    }

    @Override // com.tencent.mobileqq.search.rich.m
    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("ArkRichNode", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        a aVar = f283754k;
        if (aVar != null) {
            aVar.e(this);
        }
        ArkNodeContainer arkNodeContainer = this.f283756i;
        if (arkNodeContainer != null) {
            arkNodeContainer.doOnEvent(2);
            this.f283756i.d();
            this.f283756i = null;
        }
        this.f283755h = null;
    }

    public void k(boolean z16) {
        ArkNodeContainer arkNodeContainer = this.f283756i;
        if (arkNodeContainer != null) {
            arkNodeContainer.activateView(z16, false);
        }
    }

    public ArkNodeContainer l() {
        return this.f283756i;
    }

    public int m() {
        return this.f283757j;
    }

    public void o(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkRichNode", 2, "onNotifyEvent, key:" + str + " value:" + str2);
        }
        g(str, str2);
    }

    public void p(String str) {
        h b16;
        if (QLog.isColorLevel()) {
            QLog.d("ArkRichNode", 2, "onSetTalkBackText:" + str);
        }
        if (TextUtils.isEmpty(str) || (b16 = b()) == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        View view = b16.getView();
        if (view != null) {
            view.setContentDescription(sb5);
        }
        if (b16 instanceof c) {
            View s16 = ((c) b16).s();
            if (s16 instanceof ArkAppView) {
                ((ArkAppView) s16).setContentDescription(sb5);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.rich.m, com.tencent.mobileqq.search.rich.f
    public void pause() {
        super.pause();
        ArkNodeContainer arkNodeContainer = this.f283756i;
        if (arkNodeContainer != null) {
            arkNodeContainer.doOnEvent(0);
        }
    }

    @Override // com.tencent.mobileqq.search.rich.m, com.tencent.mobileqq.search.rich.f
    public void resume() {
        super.resume();
        ArkNodeContainer arkNodeContainer = this.f283756i;
        if (arkNodeContainer != null) {
            arkNodeContainer.doOnEvent(1);
        }
    }
}
