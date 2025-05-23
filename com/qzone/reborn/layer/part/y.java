package com.qzone.reborn.layer.part;

import android.view.View;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class y extends RFWLayerBasePart implements IDelegateAndSectionProvider, pk.c {

    /* renamed from: d, reason: collision with root package name */
    private RFWLayerState f58061d;

    @Override // pk.c
    public int T7() {
        return tk.j.f436437a.b(this.f58061d);
    }

    @Override // pk.c
    public int getCurrentPosition() {
        return tk.j.f436437a.a(this.f58061d);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    public List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> getExtDelegates() {
        return new ArrayList();
    }

    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(sk.a.class);
        return arrayList;
    }

    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RFWLayerIOCUtil.registerPicLoader(view, com.tencent.mobileqq.qzone.picload.c.a().c());
        RFWLayerIOCUtil.registerSectionProvider(view, this);
        RFWIocAbilityProvider.g().registerIoc(view, this, pk.c.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(RFWLayerState rFWLayerState) {
        super.updateLayerState(rFWLayerState);
        this.f58061d = rFWLayerState;
        VideoReport.traverseExposure();
    }
}
