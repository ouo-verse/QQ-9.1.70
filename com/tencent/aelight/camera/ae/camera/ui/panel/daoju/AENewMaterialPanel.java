package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dq.b;
import dq.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002>?B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b7\u0010;B#\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J$\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u0010008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00103\u00a8\u0006@"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;", "Landroid/widget/FrameLayout;", "", "position", "", "E", "Ljava/lang/Runnable;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ldq/b;", "repository", "Ldq/a;", "environment", "r", "", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "categoryList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "category", BdhLogUtil.LogTag.Tag_Conn, "D", "", "id", "", "enable", "v", "categoryName", "itemId", ReportConstant.COSTREPORT_PREFIX, "p", "w", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView;", "d", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView;", "tabBar", "Lcom/tencent/mobileqq/widget/QQViewPager;", "e", "Lcom/tencent/mobileqq/widget/QQViewPager;", "viewPager", "Landroid/view/View;", "f", "Landroid/view/View;", "clearButton", h.F, "Ldq/b;", "i", "Ldq/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "I", "currentPosition", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AENewMaterialPanel extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int currentPosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QIMSlidingTabView tabBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQViewPager viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View clearButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b repository;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dq.a environment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<AEMaterialCategory> categoryList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AENewMaterialPanel(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(AENewMaterialPanel this$0, List categoryList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(categoryList, "$categoryList");
        QQViewPager qQViewPager = this$0.viewPager;
        QIMSlidingTabView qIMSlidingTabView = null;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        PagerAdapter adapter = qQViewPager.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.PanelPageAdapter");
        ((c) adapter).g(this$0.currentPosition);
        int i3 = this$0.currentPosition;
        if (i3 < 0 || i3 >= categoryList.size() - 1) {
            return;
        }
        QIMSlidingTabView qIMSlidingTabView2 = this$0.tabBar;
        if (qIMSlidingTabView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
        } else {
            qIMSlidingTabView = qIMSlidingTabView2;
        }
        qIMSlidingTabView.onTabChecked(this$0.currentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int position) {
        c cVar;
        i d16;
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        PagerAdapter adapter = qQViewPager.getAdapter();
        if (!(adapter instanceof c) || (d16 = (cVar = (c) adapter).d(position)) == null) {
            return;
        }
        AEMaterialCategory e16 = cVar.e(position);
        d16.K(e16);
        List<AEMaterialMetaData> list = e16 != null ? e16.f69044d : null;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        d16.L(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AENewMaterialPanel this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.f("AEBottomPanelPart", "tab checked to index: " + i3);
        QQViewPager qQViewPager = this$0.viewPager;
        QQViewPager qQViewPager2 = null;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        if (qQViewPager.getCurrentItem() != i3) {
            QQViewPager qQViewPager3 = this$0.viewPager;
            if (qQViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                qQViewPager2 = qQViewPager3;
            }
            qQViewPager2.setCurrentItem(i3);
        }
        this$0.currentPosition = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AENewMaterialPanel this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.repository;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repository");
            bVar = null;
        }
        AEMaterialMetaData MATERIAL_NONE = AEMaterialMetaData.MATERIAL_NONE;
        Intrinsics.checkNotNullExpressionValue(MATERIAL_NONE, "MATERIAL_NONE");
        bVar.a(MATERIAL_NONE);
        AEBaseReportParam.U().R0(-1);
        AEBaseReportParam.U().S0("none");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(Runnable callback) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f));
        animationSet.setDuration(300L);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setAnimationListener(new d(callback));
        startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Runnable runnable, final String str, final AENewMaterialPanel this$0, final String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (runnable != null) {
            runnable.run();
        }
        if (str != null) {
            this$0.post(new Runnable() { // from class: dq.p
                @Override // java.lang.Runnable
                public final void run() {
                    AENewMaterialPanel.u(AENewMaterialPanel.this, str2, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AENewMaterialPanel this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AENewMaterialPanel this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQViewPager qQViewPager = this$0.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        qQViewPager.setCurrentItem(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(AENewMaterialPanel this$0, int i3, AEMaterialCategory category, int i16, AEMaterialMetaData aEMaterialMetaData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(category, "$category");
        QQViewPager qQViewPager = this$0.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        PagerAdapter adapter = qQViewPager.getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        AEGridView f16 = cVar != null ? cVar.f(i3) : null;
        if (f16 == null) {
            QQViewPager qQViewPager2 = this$0.viewPager;
            if (qQViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                qQViewPager2 = null;
            }
            PagerAdapter adapter2 = qQViewPager2.getAdapter();
            c cVar2 = adapter2 instanceof c ? (c) adapter2 : null;
            f16 = cVar2 != null ? cVar2.h(i3, category) : null;
        }
        if (f16 != null) {
            f16.h(i16);
        }
        ms.a.f("AEBottomPanelPart", "scroll down " + f16 + " to position = " + i16);
        Object adapter3 = f16 != null ? f16.getAdapter() : null;
        i iVar = adapter3 instanceof i ? (i) adapter3 : null;
        if (iVar != null) {
            iVar.I(aEMaterialMetaData);
        }
    }

    private final void z(Runnable callback) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f));
        animationSet.setDuration(300L);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setAnimationListener(new e(callback));
        setVisibility(0);
        startAnimation(animationSet);
    }

    public final void A(final List<? extends AEMaterialCategory> categoryList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        ms.a.f("AEBottomPanelPart", "update data");
        boolean z16 = categoryList.size() != this.categoryList.size();
        this.categoryList.clear();
        this.categoryList.addAll(categoryList);
        QIMSlidingTabView qIMSlidingTabView = this.tabBar;
        QQViewPager qQViewPager = null;
        if (qIMSlidingTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qIMSlidingTabView = null;
        }
        List<? extends AEMaterialCategory> list = categoryList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (AEMaterialCategory aEMaterialCategory : list) {
            QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
            String str = aEMaterialCategory.f69047h;
            dVar.f67316a = str;
            setContentDescription(str);
            arrayList.add(dVar);
        }
        qIMSlidingTabView.initTabItemsWithRedDot(new ArrayList<>(arrayList));
        QQViewPager qQViewPager2 = this.viewPager;
        if (qQViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager2 = null;
        }
        PagerAdapter adapter = qQViewPager2.getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar == null) {
            QQViewPager qQViewPager3 = this.viewPager;
            if (qQViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                qQViewPager = qQViewPager3;
            }
            qQViewPager.setAdapter(new c());
        } else {
            cVar.i();
            if (z16) {
                cVar.notifyDataSetChanged();
            }
        }
        if (cVar == null || z16) {
            this.currentPosition = Math.max(0, Math.min(1, categoryList.size() - 1));
        }
        post(new Runnable() { // from class: dq.l
            @Override // java.lang.Runnable
            public final void run() {
                AENewMaterialPanel.B(AENewMaterialPanel.this, categoryList);
            }
        });
    }

    public final void C(AEMaterialCategory category, int position) {
        Intrinsics.checkNotNullParameter(category, "category");
        if (position < 0 || position >= this.categoryList.size()) {
            return;
        }
        this.categoryList.set(position, category);
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        PagerAdapter adapter = qQViewPager.getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar != null) {
            cVar.j(position);
        }
    }

    public final void D() {
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        PagerAdapter adapter = qQViewPager.getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar != null) {
            cVar.i();
        }
    }

    public final void p(Runnable callback) {
        if (getVisibility() == 0) {
            q(callback);
        } else if (callback != null) {
            callback.run();
        }
    }

    public final void r(b repository, dq.a environment) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(environment, "environment");
        ms.a.f("AEBottomPanelPart", "init View");
        this.repository = repository;
        this.environment = environment;
    }

    public final void s(final String categoryName, final String itemId, final Runnable callback) {
        ms.a.f("AEBottomPanelPart", "open material panel with categoryName [" + categoryName + "], materialId [" + itemId + "]");
        Runnable runnable = new Runnable() { // from class: dq.m
            @Override // java.lang.Runnable
            public final void run() {
                AENewMaterialPanel.t(callback, itemId, this, categoryName);
            }
        };
        if (getVisibility() == 0) {
            runnable.run();
            return;
        }
        z(runnable);
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        E(qQViewPager.getCurrentItem());
    }

    public final void v(String id5, boolean enable) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : this.categoryList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List<AEMaterialMetaData> list = ((AEMaterialCategory) obj).f69044d;
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "cat.materialList");
                boolean z16 = false;
                for (AEMaterialMetaData aEMaterialMetaData : list) {
                    if (Intrinsics.areEqual(aEMaterialMetaData.f69050id, id5)) {
                        aEMaterialMetaData.editablewatermark = enable;
                        z16 = true;
                    }
                }
                if (z16) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            i3 = i16;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            QQViewPager qQViewPager = this.viewPager;
            if (qQViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                qQViewPager = null;
            }
            PagerAdapter adapter = qQViewPager.getAdapter();
            c cVar = adapter instanceof c ? (c) adapter : null;
            if (cVar != null) {
                cVar.j(intValue);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[LOOP:0: B:4:0x0012->B:18:0x004f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w(String categoryName, String itemId) {
        final int i3;
        final int i16;
        boolean z16;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        int i17 = 0;
        if (categoryName == null) {
            Iterator<AEMaterialCategory> it = this.categoryList.iterator();
            int i18 = 0;
            while (it.hasNext()) {
                List<AEMaterialMetaData> list = it.next().f69044d;
                if (list != null) {
                    Intrinsics.checkNotNullExpressionValue(list, "cat.materialList");
                    Iterator<AEMaterialMetaData> it5 = list.iterator();
                    int i19 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            i19 = -1;
                            break;
                        } else if (Intrinsics.areEqual(it5.next().f69050id, itemId)) {
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i19 >= 0) {
                        z16 = true;
                        if (!z16) {
                            i3 = i18;
                            break;
                        }
                        i18++;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            i3 = -1;
        } else {
            Iterator<AEMaterialCategory> it6 = this.categoryList.iterator();
            int i26 = 0;
            while (it6.hasNext()) {
                if (Intrinsics.areEqual(it6.next().f69047h, categoryName)) {
                    i3 = i26;
                    break;
                }
                i26++;
            }
            i3 = -1;
        }
        if (i3 < 0) {
            return;
        }
        post(new Runnable() { // from class: dq.n
            @Override // java.lang.Runnable
            public final void run() {
                AENewMaterialPanel.x(AENewMaterialPanel.this, i3);
            }
        });
        final AEMaterialCategory aEMaterialCategory = this.categoryList.get(i3);
        List<AEMaterialMetaData> list2 = aEMaterialCategory.f69044d;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator<AEMaterialMetaData> it7 = list2.iterator();
        while (true) {
            if (!it7.hasNext()) {
                i16 = -1;
                break;
            } else {
                if (Intrinsics.areEqual(it7.next().f69050id, itemId)) {
                    i16 = i17;
                    break;
                }
                i17++;
            }
        }
        final AEMaterialMetaData aEMaterialMetaData = i16 >= 0 ? aEMaterialCategory.f69044d.get(i16) : null;
        if (aEMaterialMetaData != null) {
            if (aEMaterialMetaData.isWsBanner()) {
                l.g(getContext(), aEMaterialMetaData, 1);
            } else {
                postDelayed(new Runnable() { // from class: dq.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        AENewMaterialPanel.y(AENewMaterialPanel.this, i3, aEMaterialCategory, i16, aEMaterialMetaData);
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$c;", "Landroidx/viewpager/widget/PagerAdapter;", "", "i", "", "position", "j", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "category", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEGridView;", h.F, "f", "e", "Ldq/i;", "d", "Landroid/view/View;", "view", "", "object", "", "isViewFromObject", "getCount", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "destroyItem", "g", "", "Ljava/util/Map;", "getPageCache", "()Ljava/util/Map;", "pageCache", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public final class c extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Map<Integer, AEGridView> pageCache = new LinkedHashMap();

        public c() {
        }

        public final i d(int position) {
            AEGridView aEGridView = this.pageCache.get(Integer.valueOf(position));
            RecyclerView.Adapter adapter = aEGridView != null ? aEGridView.getAdapter() : null;
            if (adapter instanceof i) {
                return (i) adapter;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            container.removeView((AEGridView) object);
        }

        public final AEGridView f(int position) {
            return this.pageCache.get(Integer.valueOf(position));
        }

        public final void g(int position) {
            if (this.pageCache.get(Integer.valueOf(position)) == null) {
                AEGridView aEGridView = new AEGridView(AENewMaterialPanel.this.getContext());
                this.pageCache.put(Integer.valueOf(position), aEGridView);
                Context context = AENewMaterialPanel.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                b bVar = AENewMaterialPanel.this.repository;
                dq.a aVar = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repository");
                    bVar = null;
                }
                dq.a aVar2 = AENewMaterialPanel.this.environment;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("environment");
                } else {
                    aVar = aVar2;
                }
                aEGridView.setAdapter(new i(context, bVar, aVar));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return AENewMaterialPanel.this.categoryList.size();
        }

        public final AEGridView h(int position, AEMaterialCategory category) {
            AEGridView aEGridView = this.pageCache.get(Integer.valueOf(position));
            if (aEGridView == null) {
                aEGridView = new AEGridView(AENewMaterialPanel.this.getContext());
                AENewMaterialPanel aENewMaterialPanel = AENewMaterialPanel.this;
                Context context = aEGridView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                b bVar = aENewMaterialPanel.repository;
                dq.a aVar = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repository");
                    bVar = null;
                }
                dq.a aVar2 = aENewMaterialPanel.environment;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("environment");
                } else {
                    aVar = aVar2;
                }
                aEGridView.setAdapter(new i(context, bVar, aVar));
                this.pageCache.put(Integer.valueOf(position), aEGridView);
                if (category != null && position >= 0 && position < AENewMaterialPanel.this.categoryList.size()) {
                    AENewMaterialPanel.this.categoryList.set(position, category);
                    RecyclerView.Adapter adapter = aEGridView.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialAdapter");
                    i iVar = (i) adapter;
                    iVar.K(category);
                    List<AEMaterialMetaData> list = category.f69044d;
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(list, "category.materialList ?: emptyList()");
                    }
                    iVar.L(list);
                }
            }
            return aEGridView;
        }

        public final void i() {
            Iterator<T> it = this.pageCache.keySet().iterator();
            while (it.hasNext()) {
                j(((Number) it.next()).intValue());
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            AEGridView aEGridView = this.pageCache.get(Integer.valueOf(position));
            if (aEGridView == null) {
                aEGridView = new AEGridView(AENewMaterialPanel.this.getContext());
                this.pageCache.put(Integer.valueOf(position), aEGridView);
                Context context = AENewMaterialPanel.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                b bVar = AENewMaterialPanel.this.repository;
                dq.a aVar = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repository");
                    bVar = null;
                }
                dq.a aVar2 = AENewMaterialPanel.this.environment;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("environment");
                } else {
                    aVar = aVar2;
                }
                aEGridView.setAdapter(new i(context, bVar, aVar));
            }
            AEGridView aEGridView2 = aEGridView;
            if (aEGridView2.getParent() instanceof ViewGroup) {
                ViewParent parent = aEGridView2.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(aEGridView);
            }
            container.addView(aEGridView, new ViewGroup.LayoutParams(-1, -1));
            return aEGridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(object, "object");
            return Intrinsics.areEqual(view, object);
        }

        public final void j(int position) {
            i d16 = d(position);
            if (d16 == null) {
                return;
            }
            AEMaterialCategory e16 = e(position);
            d16.K(e16);
            List<AEMaterialMetaData> list = e16 != null ? e16.f69044d : null;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            d16.L(list);
        }

        public final AEMaterialCategory e(int position) {
            if (position < 0 || position >= AENewMaterialPanel.this.categoryList.size()) {
                return null;
            }
            return (AEMaterialCategory) AENewMaterialPanel.this.categoryList.get(position);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AENewMaterialPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AENewMaterialPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.categoryList = new ArrayList();
        this.currentPosition = -1;
        LayoutInflater.from(getContext()).inflate(R.layout.dnu, this);
        View findViewById = findViewById(R.id.s1z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.stv_tab_bar)");
        QIMSlidingTabView qIMSlidingTabView = (QIMSlidingTabView) findViewById;
        this.tabBar = qIMSlidingTabView;
        QQViewPager qQViewPager = null;
        if (qIMSlidingTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qIMSlidingTabView = null;
        }
        qIMSlidingTabView.setTabCheckListener(new QIMSlidingTabView.c() { // from class: dq.j
            @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
            public final void onTabChecked(int i16) {
                AENewMaterialPanel.h(AENewMaterialPanel.this, i16);
            }
        });
        View findViewById2 = findViewById(R.id.f163763rw0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_none_material)");
        this.clearButton = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: dq.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AENewMaterialPanel.i(AENewMaterialPanel.this, view);
            }
        });
        View findViewById3 = findViewById(R.id.s4x);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.vp_materials)");
        QQViewPager qQViewPager2 = (QQViewPager) findViewById3;
        this.viewPager = qQViewPager2;
        if (qQViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            qQViewPager = qQViewPager2;
        }
        qQViewPager.setOnPageChangeListener(new a());
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "state", "", "onPageScrollStateChanged", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ms.a.f("AEBottomPanelPart", "page scrolled to position: " + position);
            QIMSlidingTabView qIMSlidingTabView = AENewMaterialPanel.this.tabBar;
            if (qIMSlidingTabView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qIMSlidingTabView = null;
            }
            qIMSlidingTabView.onTabChecked(position);
            AENewMaterialPanel.this.currentPosition = position;
            AENewMaterialPanel.this.E(position);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f63197e;

        d(Runnable runnable) {
            this.f63197e = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AENewMaterialPanel.this.setVisibility(8);
            Runnable runnable = this.f63197e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationStart", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f63198d;

        e(Runnable runnable) {
            this.f63198d = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.f63198d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
