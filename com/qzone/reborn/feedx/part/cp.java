package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.Observer;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.qzone.homepage.ui.woo.StepOnZoneDirector;
import com.qzone.homepage.ui.woo.wizard.StepOnZoneWizard;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.qroute.QRoute;
import e7.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cp extends com.qzone.reborn.base.k implements StepOnZoneWizard.c {
    private static final List<b.a> I = new ArrayList();
    private static User J;
    private static int K;
    private boolean C;
    private List<b.a> D;
    private long E;
    private String F;
    private com.qzone.reborn.feedx.viewmodel.w G;
    private boolean H = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("qzone_skip_loading_detection", Boolean.TRUE).booleanValue();

    /* renamed from: d, reason: collision with root package name */
    private StepOnZoneDirector f55130d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55131e;

    /* renamed from: f, reason: collision with root package name */
    private String f55132f;

    /* renamed from: h, reason: collision with root package name */
    private long f55133h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f55134i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f55135m;

    private void D9() {
        if (this.f55135m && this.C) {
            this.f55130d.setVisibility(0);
            this.f55130d.w0(new e7.b(this.E, this.F, this.D));
            this.f55134i = true;
        }
    }

    public void C9(x6.a aVar) {
        if (this.f55130d == null || aVar == null) {
            return;
        }
        if (!this.f55131e) {
            List<b.a> list = I;
            if (list.size() > 0 && J != null) {
                com.qzone.proxy.feedcomponent.util.j.f("WooTest", "updateUserInfo: " + list.size());
                this.f55132f = UUID.randomUUID().toString();
                HashSet hashSet = new HashSet();
                this.D = new ArrayList(list);
                list.clear();
                Iterator<b.a> it = this.D.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().f395815a);
                }
                StepOnZoneWizard.h().k(this.f55132f, hashSet, this, K);
                User user = J;
                this.E = user.uin;
                this.F = user.nickName;
                J = null;
                this.f55135m = true;
            } else {
                ArrayList<FunnySpaceModel> arrayList = aVar.funnySpaceModels;
                if (arrayList != null && arrayList.size() > 0) {
                    this.f55132f = UUID.randomUUID().toString();
                    this.f55133h = System.nanoTime();
                    StepOnZoneWizard h16 = StepOnZoneWizard.h();
                    String str = this.f55132f;
                    ArrayList<FunnySpaceModel> arrayList2 = aVar.funnySpaceModels;
                    h16.j(str, arrayList2, this, arrayList2.get(0).dataSource);
                    this.f55130d.v0(aVar.uin);
                    this.f55130d.x0(aVar.funnySpaceTotalCount);
                    this.f55135m = false;
                    K = aVar.funnySpaceModels.get(0).itemId;
                }
            }
            this.f55131e = true;
        }
        if (this.f55130d.getVisibility() == 0) {
            this.f55130d.x0(aVar.funnySpaceTotalCount);
        }
    }

    @Override // com.qzone.homepage.ui.woo.wizard.StepOnZoneWizard.c
    public void Q0(String str, List<e7.a> list, boolean z16) {
        String str2;
        if (this.f55130d != null && (str2 = this.f55132f) != null && str2.equals(str)) {
            if (this.f55130d == null) {
                com.qzone.proxy.feedcomponent.util.j.i("QZoneUserHomeStepOnPart", "mWooDir is null");
                return;
            }
            if (list == null) {
                com.qzone.proxy.feedcomponent.util.j.i("QZoneUserHomeStepOnPart", "onLoad: load failed: " + str);
                return;
            }
            if (this.f55135m) {
                com.qzone.proxy.feedcomponent.util.j.f("WooTest", "onLoad: show mode loaded");
                this.f55130d.s0(list);
                this.C = true;
                D9();
                return;
            }
            if (!z16 && System.nanoTime() - this.f55133h >= 2000000 && !this.H) {
                com.qzone.proxy.feedcomponent.util.j.f("QZoneUserHomeStepOnPart", "onLoad: loaded too late : " + str);
            } else {
                com.qzone.proxy.feedcomponent.util.j.f("QZoneUserHomeStepOnPart", "onLoad: loaded: " + str);
                this.f55130d.setVisibility(0);
                this.f55130d.s0(list);
                this.f55134i = true;
            }
            this.f55130d.z0();
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onLoad: wrong load key: ");
        sb5.append(str);
        sb5.append(" ");
        sb5.append(this.f55130d != null);
        com.qzone.proxy.feedcomponent.util.j.i("QZoneUserHomeStepOnPart", sb5.toString());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeStepOnPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View inflate = ((ViewStub) view.findViewById(R.id.ncu)).inflate();
        this.f55130d = new StepOnZoneDirector(getActivity(), inflate, inflate.findViewById(R.id.klg));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        StepOnZoneDirector stepOnZoneDirector = this.f55130d;
        if (stepOnZoneDirector != null) {
            stepOnZoneDirector.w0(null);
            this.f55130d.s0(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        StepOnZoneDirector stepOnZoneDirector = this.f55130d;
        if (stepOnZoneDirector != null) {
            stepOnZoneDirector.C0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.f55131e = false;
        this.f55134i = false;
        this.C = false;
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.G = wVar;
        wVar.C2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.co
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cp.this.C9((x6.a) obj);
            }
        });
    }
}
