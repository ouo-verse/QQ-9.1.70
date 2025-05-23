package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u0019\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R.\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/bq;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialAdapter;", "ptvTemplateAdapter", "", "position", "", "k", "", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "tabList", "j", "getCount", "index", "f", tl.h.F, "category", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView;", "i", "Landroid/view/View;", "view", "", "object", "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "destroyItem", "e", "d", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "mMaterialPanelListener", "Ljava/util/List;", "mTabList", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "g", "()Ljava/util/HashMap;", "setMGridViewMap", "(Ljava/util/HashMap;)V", "mGridViewMap", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "mTemplateManager", "<init>", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bq extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowMaterialPanel.a mMaterialPanelListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<? extends AEMaterialCategory> mTabList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private HashMap<Integer, AEFlashShowGridView> mGridViewMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AEFlashShowMaterialManager mTemplateManager;

    public bq(Context mContext, AEFlashShowMaterialPanel.a aVar) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mMaterialPanelListener = aVar;
        this.mGridViewMap = new HashMap<>();
        com.tencent.aelight.camera.ae.control.b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        this.mTemplateManager = (AEFlashShowMaterialManager) b16;
    }

    private final void k(AEFlashShowMaterialAdapter ptvTemplateAdapter, int position) {
        this.mTemplateManager.p(ptvTemplateAdapter, 112);
        this.mTemplateManager.p(ptvTemplateAdapter, 113);
        this.mTemplateManager.p(ptvTemplateAdapter, 1024);
        this.mTemplateManager.p(ptvTemplateAdapter, 114);
        this.mTemplateManager.p(ptvTemplateAdapter, 111);
        this.mTemplateManager.p(ptvTemplateAdapter, 115);
    }

    public final void d() {
        for (Map.Entry<Integer, AEFlashShowGridView> entry : this.mGridViewMap.entrySet()) {
            AEFlashShowGridView value = entry.getValue();
            if (value != null) {
                RecyclerView.Adapter adapter = value.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter");
                k((AEFlashShowMaterialAdapter) adapter, entry.getKey().intValue());
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView(this.mGridViewMap.get(Integer.valueOf(position)));
        AEFlashShowGridView aEFlashShowGridView = this.mGridViewMap.get(Integer.valueOf(position));
        if (aEFlashShowGridView != null) {
            RecyclerView.Adapter adapter = aEFlashShowGridView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter");
            this.mTemplateManager.d0((AEFlashShowMaterialAdapter) adapter);
        }
    }

    public final void e() {
        Iterator<Map.Entry<Integer, AEFlashShowGridView>> it = this.mGridViewMap.entrySet().iterator();
        while (it.hasNext()) {
            AEFlashShowGridView value = it.next().getValue();
            if (value != null) {
                RecyclerView.Adapter adapter = value.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter");
                this.mTemplateManager.d0((AEFlashShowMaterialAdapter) adapter);
            }
        }
    }

    public final AEMaterialCategory f(int index) {
        List<? extends AEMaterialCategory> list = this.mTabList;
        if (list == null || list.size() <= index || index < 0) {
            return null;
        }
        return list.get(index);
    }

    public final HashMap<Integer, AEFlashShowGridView> g() {
        return this.mGridViewMap;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<? extends AEMaterialCategory> list = this.mTabList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void h() {
        Collection<AEFlashShowGridView> values = this.mGridViewMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mGridViewMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((AEFlashShowGridView) it.next()).c();
        }
    }

    public final AEFlashShowGridView i(int position, AEMaterialCategory category) {
        AEFlashShowGridView aEFlashShowGridView = this.mGridViewMap.get(Integer.valueOf(position));
        if (aEFlashShowGridView == null) {
            aEFlashShowGridView = new AEFlashShowGridView(this.mContext);
            AEFlashShowMaterialAdapter aEFlashShowMaterialAdapter = new AEFlashShowMaterialAdapter(this.mContext, aEFlashShowGridView, this.mMaterialPanelListener, position == 0);
            k(aEFlashShowMaterialAdapter, position);
            aEFlashShowMaterialAdapter.S(category);
            aEFlashShowGridView.setAdapter(aEFlashShowMaterialAdapter);
            this.mGridViewMap.put(Integer.valueOf(position), aEFlashShowGridView);
        }
        return aEFlashShowGridView;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // androidx.viewpager.widget.PagerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object instantiateItem(ViewGroup container, int position) {
        String str;
        boolean areEqual;
        AEFlashShowMaterialAdapter aEFlashShowMaterialAdapter;
        Object orNull;
        Object orNull2;
        Intrinsics.checkNotNullParameter(container, "container");
        AEFlashShowGridView aEFlashShowGridView = this.mGridViewMap.get(Integer.valueOf(position));
        List<? extends AEMaterialCategory> list = this.mTabList;
        AEMaterialCategory aEMaterialCategory = null;
        if (list != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list, position);
            AEMaterialCategory aEMaterialCategory2 = (AEMaterialCategory) orNull2;
            if (aEMaterialCategory2 != null) {
                str = aEMaterialCategory2.f69047h;
                areEqual = Intrinsics.areEqual(str, "\u6536\u85cf");
                if (aEFlashShowGridView != null) {
                    ms.a.a("AEFlashShowMaterialTabAdapter", "create new grid view");
                    aEFlashShowGridView = new AEFlashShowGridView(this.mContext);
                    aEFlashShowMaterialAdapter = new AEFlashShowMaterialAdapter(this.mContext, aEFlashShowGridView, this.mMaterialPanelListener, areEqual);
                    k(aEFlashShowMaterialAdapter, position);
                    this.mGridViewMap.put(Integer.valueOf(position), aEFlashShowGridView);
                } else {
                    ms.a.a("AEFlashShowMaterialTabAdapter", "use cached grid view");
                    RecyclerView.Adapter adapter = aEFlashShowGridView.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter");
                    aEFlashShowMaterialAdapter = (AEFlashShowMaterialAdapter) adapter;
                    k(aEFlashShowMaterialAdapter, position);
                }
                if (!areEqual) {
                    this.mTemplateManager.b0();
                } else {
                    List<? extends AEMaterialCategory> list2 = this.mTabList;
                    if (list2 != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(list2, position);
                        aEMaterialCategory = (AEMaterialCategory) orNull;
                    }
                    aEFlashShowMaterialAdapter.S(aEMaterialCategory);
                }
                aEFlashShowGridView.setAdapter(aEFlashShowMaterialAdapter);
                container.addView(aEFlashShowGridView);
                if (ms.a.g()) {
                    ms.a.f("AEFlashShowMaterialTabAdapter", "instantiateItem: invoked. info: ptvTemplateAdapter = " + aEFlashShowMaterialAdapter);
                }
                return aEFlashShowGridView;
            }
        }
        str = null;
        areEqual = Intrinsics.areEqual(str, "\u6536\u85cf");
        if (aEFlashShowGridView != null) {
        }
        if (!areEqual) {
        }
        aEFlashShowGridView.setAdapter(aEFlashShowMaterialAdapter);
        container.addView(aEFlashShowGridView);
        if (ms.a.g()) {
        }
        return aEFlashShowGridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return view == object;
    }

    public final void j(List<? extends AEMaterialCategory> tabList) {
        this.mTabList = tabList;
    }
}
