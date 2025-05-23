package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel;
import com.tencent.aelight.camera.ae.flashshow.util.AEMaterialUtilKt;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u00af\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001X\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001bB\u0019\u0012\u0006\u0010]\u001a\u00020\\\u0012\b\u0010^\u001a\u0004\u0018\u00010H\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0011H\u0017J\b\u0010\u0018\u001a\u00020\nH\u0016J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011H\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\nJ \u0010&\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000eJ9\u0010,\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00112\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010'0*\"\u0004\u0018\u00010'H\u0016\u00a2\u0006\u0004\b,\u0010-J\b\u0010/\u001a\u0004\u0018\u00010.J\u0006\u00100\u001a\u00020\u0005J\b\u00101\u001a\u00020\u0005H\u0014J\b\u00102\u001a\u00020\u0005H\u0014R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\f098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010S\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010UR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006c"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView$c;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lyq2/c;", "", "i", "Ljava/util/ArrayList;", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView$d;", "f", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "d", "", "loadRecentList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", com.tencent.luggage.wxa.c8.c.G, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "tabIndex", "onTabChecked", "g", "", "v", "i1", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "onPageScrollStateChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "categoryName", tl.h.F, "itemId", "onlyDownload", DomainData.DOMAIN_NAME, "", "sender", "eventId", "", "args", "notify", "(Ljava/lang/Object;I[Ljava/lang/Object;)V", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "e", "r", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "mApp", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView;", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView;", "mTopTabBar", "", "Ljava/util/List;", "mTabList", "Landroid/view/View;", "Landroid/view/View;", "mApplyNoneMaterial", "Lcom/tencent/mobileqq/widget/QQViewPager;", "Lcom/tencent/mobileqq/widget/QQViewPager;", "mViewPager", "Lcom/tencent/aelight/camera/ae/flashshow/ui/bq;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/bq;", "mPageAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "mTemplateManager", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "D", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "panelListener", "E", "Z", "firstClickEvent", UserInfo.SEX_FEMALE, "materialSelected", "G", "I", "defaultPagerPos", "H", "Ljava/lang/String;", "mPresetMaterialId", "mTargetCategoryName", "com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialProviderView$b", "J", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialProviderView$b;", "mCaptureConfigUpdateObserver", "Landroid/content/Context;", "context", "listener", "<init>", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;)V", "K", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialProviderView extends FrameLayout implements QIMSlidingTabView.c, ViewPager.OnPageChangeListener, yq2.c {

    /* renamed from: C, reason: from kotlin metadata */
    private AEFlashShowMaterialManager mTemplateManager;

    /* renamed from: D, reason: from kotlin metadata */
    private AEFlashShowMaterialPanel.a panelListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean firstClickEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean materialSelected;

    /* renamed from: G, reason: from kotlin metadata */
    private int defaultPagerPos;

    /* renamed from: H, reason: from kotlin metadata */
    private String mPresetMaterialId;

    /* renamed from: I, reason: from kotlin metadata */
    private String mTargetCategoryName;

    /* renamed from: J, reason: from kotlin metadata */
    private final b mCaptureConfigUpdateObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AppInterface mApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QIMSlidingTabView mTopTabBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<? extends AEMaterialCategory> mTabList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mApplyNoneMaterial;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQViewPager mViewPager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private bq mPageAdapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialProviderView$b", "Lkq/a;", "", "c", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends kq.a {
        b() {
        }

        @Override // kq.a
        public void c() {
            if (ms.a.g()) {
                ms.a.a("AEFlashShowMaterialProviderView", "mCaptureConfigUpdateObserver material list updated!");
            }
            AEFlashShowMaterialProviderView.this.q(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialProviderView(Context context, AEFlashShowMaterialPanel.a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTabList = new CopyOnWriteArrayList();
        this.panelListener = aVar;
        this.firstClickEvent = true;
        this.defaultPagerPos = 1;
        this.mTargetCategoryName = "";
        this.mCaptureConfigUpdateObserver = new b();
        this.mApp = com.tencent.aelight.camera.aebase.a.a();
        i();
    }

    private final AEMaterialCategory d(String materialId) {
        if (TextUtils.isEmpty(materialId)) {
            return null;
        }
        for (AEMaterialCategory aEMaterialCategory : this.mTabList) {
            List<AEMaterialMetaData> list = aEMaterialCategory.f69044d;
            if (list != null) {
                for (AEMaterialMetaData aEMaterialMetaData : list) {
                    if (aEMaterialMetaData != null && Intrinsics.areEqual(materialId, aEMaterialMetaData.f69050id) && (this.mTabList.indexOf(aEMaterialCategory) != 0 || !Intrinsics.areEqual(aEMaterialCategory.f69047h, "\u6536\u85cf"))) {
                        return aEMaterialCategory;
                    }
                }
            }
        }
        return null;
    }

    private final ArrayList<QIMSlidingTabView.d> f() {
        ArrayList<QIMSlidingTabView.d> arrayList = new ArrayList<>();
        int size = this.mTabList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AEMaterialCategory aEMaterialCategory = this.mTabList.get(i3);
            if (aEMaterialCategory != null) {
                if (-1 == aEMaterialCategory.f69045e) {
                    this.defaultPagerPos = i3;
                }
                QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
                dVar.f67316a = aEMaterialCategory.f69047h;
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    private final void i() {
        LayoutInflater.from(getContext()).inflate(R.layout.dnu, this);
        QIMSlidingTabView qIMSlidingTabView = (QIMSlidingTabView) findViewById(R.id.s1z);
        this.mTopTabBar = qIMSlidingTabView;
        if (qIMSlidingTabView != null) {
            qIMSlidingTabView.setTabCheckListener(this);
        }
        this.mApplyNoneMaterial = findViewById(R.id.f163763rw0);
        r();
        View view = this.mApplyNoneMaterial;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bp
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AEFlashShowMaterialProviderView.j(AEFlashShowMaterialProviderView.this, view2);
                }
            });
        }
        this.mViewPager = (QQViewPager) findViewById(R.id.s4x);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mPageAdapter = new bq(context, this.panelListener);
        com.tencent.aelight.camera.ae.control.b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) b16;
        this.mTemplateManager = aEFlashShowMaterialManager;
        if (aEFlashShowMaterialManager != null) {
            aEFlashShowMaterialManager.F(false);
        }
        bq bqVar = this.mPageAdapter;
        if (bqVar != null) {
            bqVar.j(new ArrayList());
        }
        QQViewPager qQViewPager = this.mViewPager;
        if (qQViewPager != null) {
            qQViewPager.setOnPageChangeListener(this);
        }
        QQViewPager qQViewPager2 = this.mViewPager;
        if (qQViewPager2 != null) {
            qQViewPager2.setAdapter(this.mPageAdapter);
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.registObserver(this.mCaptureConfigUpdateObserver);
        }
        if (getContext() instanceof Activity) {
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            Intent intent = ((Activity) context2).getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "context as Activity).intent");
            Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
            if (serializableExtra instanceof HashMap) {
                HashMap hashMap = (HashMap) serializableExtra;
                if ((!hashMap.isEmpty()) && hashMap.containsKey("meterial") && !TextUtils.isEmpty((CharSequence) hashMap.get("meterial"))) {
                    String str = (String) hashMap.get("meterial");
                    this.mPresetMaterialId = str;
                    ms.a.f("AEFlashShowMaterialProviderView", "PresetMaterialId=" + str);
                }
            }
        }
        q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AEFlashShowMaterialProviderView this_run, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this_run.mTemplateManager;
        if (aEFlashShowMaterialManager != null) {
            aEFlashShowMaterialManager.m0(AEMaterialMetaData.MATERIAL_NONE, false);
        }
        AEFlashShowMaterialPanel.a aVar = this_run.panelListener;
        if (aVar != null) {
            aVar.c();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(AEFlashShowMaterialProviderView this$0, int i3, Ref.ObjectRef category, int i16, boolean z16, AEMaterialMetaData info) {
        HashMap<Integer, AEFlashShowGridView> g16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(category, "$category");
        Intrinsics.checkNotNullParameter(info, "$info");
        bq bqVar = this$0.mPageAdapter;
        AEFlashShowGridView aEFlashShowGridView = (bqVar == null || (g16 = bqVar.g()) == null) ? null : g16.get(Integer.valueOf(i3));
        if (aEFlashShowGridView == null) {
            bq bqVar2 = this$0.mPageAdapter;
            aEFlashShowGridView = bqVar2 != null ? bqVar2.i(i3, (AEMaterialCategory) category.element) : null;
        }
        if (aEFlashShowGridView != null) {
            RecyclerView.Adapter adapter = aEFlashShowGridView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter");
            AEFlashShowMaterialAdapter aEFlashShowMaterialAdapter = (AEFlashShowMaterialAdapter) adapter;
            aEFlashShowGridView.scrollToPosition(i16);
            if (z16) {
                aEFlashShowMaterialAdapter.O(info);
                return;
            } else {
                aEFlashShowMaterialAdapter.P(info);
                return;
            }
        }
        if (ms.a.g()) {
            ms.a.a("AEFlashShowMaterialProviderView", "gridView is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(int i3, AEFlashShowMaterialProviderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.f("AEFlashShowMaterialProviderView", "select category: " + i3);
        QQViewPager qQViewPager = this$0.mViewPager;
        if (qQViewPager != null) {
            qQViewPager.setCurrentItem(i3);
        }
        if (i3 == 0) {
            this$0.onPageSelected(i3);
        }
    }

    /* renamed from: e, reason: from getter */
    public final AEFlashShowMaterialManager getMTemplateManager() {
        return this.mTemplateManager;
    }

    @Override // android.view.View
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String getTag() {
        return "AEFlashShowMaterialProviderView";
    }

    public final void h(String categoryName) {
        List mutableList;
        List<? extends AEMaterialCategory> list;
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.mTargetCategoryName = categoryName;
        if (this.mTabList.isEmpty()) {
            q(true);
            return;
        }
        if (this.mTabList.size() != 1 || !Intrinsics.areEqual(this.mTabList.get(0).f69047h, categoryName)) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mTabList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : mutableList) {
                if (Intrinsics.areEqual(((AEMaterialCategory) obj).f69047h, categoryName)) {
                    arrayList.add(obj);
                }
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList);
            this.mTabList = copyOnWriteArrayList;
            if (copyOnWriteArrayList.isEmpty()) {
                ms.a.a("AEFlashShowMaterialProviderView", "hideOtherTab mTabList.isEmpty()\uff0creturn");
                return;
            }
            bq bqVar = this.mPageAdapter;
            if (bqVar != null) {
                list = CollectionsKt___CollectionsKt.toList(this.mTabList);
                bqVar.j(list);
            }
            bq bqVar2 = this.mPageAdapter;
            if (bqVar2 != null) {
                bqVar2.notifyDataSetChanged();
            }
            QIMSlidingTabView qIMSlidingTabView = this.mTopTabBar;
            if (qIMSlidingTabView != null) {
                qIMSlidingTabView.initTabItemsWithRedDot(f());
                return;
            }
            return;
        }
        ms.a.a("AEFlashShowMaterialProviderView", "hideOtherTab return");
    }

    public final void k(int pos) {
        ms.a.f("AEFlashShowMaterialProviderView", "locatePage: " + pos);
        QQViewPager qQViewPager = this.mViewPager;
        if (qQViewPager == null) {
            return;
        }
        qQViewPager.setCurrentItem(pos);
    }

    public final void l() {
        HashMap<Integer, AEFlashShowGridView> g16;
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this.mTemplateManager;
        if (aEFlashShowMaterialManager != null) {
            aEFlashShowMaterialManager.t();
        }
        AEFlashShowMaterialManager aEFlashShowMaterialManager2 = this.mTemplateManager;
        if (aEFlashShowMaterialManager2 != null) {
            aEFlashShowMaterialManager2.c0(111);
        }
        AEFlashShowMaterialManager aEFlashShowMaterialManager3 = this.mTemplateManager;
        if (aEFlashShowMaterialManager3 != null) {
            aEFlashShowMaterialManager3.c0(113);
        }
        AEFlashShowMaterialManager aEFlashShowMaterialManager4 = this.mTemplateManager;
        if (aEFlashShowMaterialManager4 != null) {
            aEFlashShowMaterialManager4.c0(112);
        }
        bq bqVar = this.mPageAdapter;
        if (bqVar != null && (g16 = bqVar.g()) != null) {
            Iterator<Map.Entry<Integer, AEFlashShowGridView>> it = g16.entrySet().iterator();
            while (it.hasNext()) {
                AEFlashShowGridView value = it.next().getValue();
                if (value.getAdapter() instanceof AEFlashShowMaterialAdapter) {
                    RecyclerView.Adapter adapter = value.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter");
                    AEFlashShowMaterialAdapter aEFlashShowMaterialAdapter = (AEFlashShowMaterialAdapter) adapter;
                    AEFlashShowMaterialManager aEFlashShowMaterialManager5 = this.mTemplateManager;
                    if (aEFlashShowMaterialManager5 != null) {
                        aEFlashShowMaterialManager5.d0(aEFlashShowMaterialAdapter);
                    }
                }
            }
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.unRegistObserver(this.mCaptureConfigUpdateObserver);
        }
    }

    public final void m() {
        AEFlashShowMaterialManager aEFlashShowMaterialManager;
        if (o83.a.f422212a.d() || (aEFlashShowMaterialManager = this.mTemplateManager) == null) {
            return;
        }
        aEFlashShowMaterialManager.h0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13, types: [com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory, T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Object] */
    public final void n(String categoryName, String itemId, final boolean onlyDownload) {
        final int i3;
        final AEMaterialMetaData aEMaterialMetaData;
        final int i16;
        int indexOf;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        if (ms.a.g()) {
            ms.a.a("AEFlashShowMaterialProviderView", "selectCategoryAndItem, categoryName=" + categoryName + ", itemId=" + itemId + ", mTabListSize=" + this.mTabList.size());
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.mTabList.isEmpty()) {
            q(true);
        }
        if (TextUtils.isEmpty(categoryName)) {
            ?? d16 = d(itemId);
            objectRef.element = d16;
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends ??>) ((List<? extends Object>) this.mTabList), d16);
            i3 = indexOf;
        } else {
            int size = this.mTabList.size();
            i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = 0;
                    break;
                } else {
                    if (categoryName != null && Intrinsics.areEqual(categoryName, this.mTabList.get(i3).f69047h)) {
                        objectRef.element = this.mTabList.get(i3);
                        break;
                    }
                    i3++;
                }
            }
        }
        T t16 = objectRef.element;
        if (t16 == 0) {
            return;
        }
        int size2 = ((AEMaterialCategory) t16).f69044d.size();
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i17 >= size2) {
                aEMaterialMetaData = null;
                i16 = 0;
                break;
            }
            AEMaterialMetaData aEMaterialMetaData2 = ((AEMaterialCategory) objectRef.element).f69044d.get(i17);
            if (AEFlashShowMaterialManager.INSTANCE.e(aEMaterialMetaData2)) {
                i18++;
            } else if (Intrinsics.areEqual(aEMaterialMetaData2.f69050id, itemId)) {
                i16 = (i17 - i18) + 1;
                aEMaterialMetaData = aEMaterialMetaData2;
                break;
            }
            i17++;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bn
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowMaterialProviderView.p(i3, this);
            }
        });
        if (ms.a.g()) {
            ms.a.a("AEFlashShowMaterialProviderView", "itemInfo= " + aEMaterialMetaData + ",index=" + i3 + ",pos=" + i16);
        }
        if (aEMaterialMetaData != null) {
            this.materialSelected = true;
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bo
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowMaterialProviderView.o(AEFlashShowMaterialProviderView.this, i3, objectRef, i16, onlyDownload, aEMaterialMetaData);
                }
            }, 200L);
        }
    }

    @Override // yq2.c
    public void notify(Object sender, int eventId, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bq bqVar = this.mPageAdapter;
        if (bqVar != null) {
            bqVar.d();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        bq bqVar = this.mPageAdapter;
        if (bqVar != null) {
            bqVar.h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bq bqVar = this.mPageAdapter;
        if (bqVar != null) {
            bqVar.e();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        QIMSlidingTabView qIMSlidingTabView = this.mTopTabBar;
        if (qIMSlidingTabView != null) {
            qIMSlidingTabView.onTabChecked(i3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
    public void onTabChecked(int tabIndex) {
        QQViewPager qQViewPager = this.mViewPager;
        if (qQViewPager != null) {
            qQViewPager.setCurrentItem(tabIndex);
        }
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this.mTemplateManager;
        if (aEFlashShowMaterialManager != null) {
            aEFlashShowMaterialManager.l0(this.mTabList.get(tabIndex));
        }
    }

    public final void q(boolean loadRecentList) {
        List<? extends AEMaterialCategory> list;
        bq bqVar;
        QQViewPager qQViewPager;
        AEMaterialCategory f16;
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this.mTemplateManager;
        List<AEMaterialCategory> A = aEFlashShowMaterialManager != null ? aEFlashShowMaterialManager.A(loadRecentList) : null;
        ms.a.a("AEFlashShowMaterialProviderView", "### updateData, totalList.size = " + (A != null ? Integer.valueOf(A.size()) : null));
        this.mTabList = new CopyOnWriteArrayList(AEMaterialUtilKt.f(A, this.mPresetMaterialId, this.mTargetCategoryName));
        int i3 = this.defaultPagerPos;
        int i16 = 0;
        if (!loadRecentList && (bqVar = this.mPageAdapter) != null && (qQViewPager = this.mViewPager) != null && bqVar != null) {
            if (!this.firstClickEvent && (f16 = bqVar.f(qQViewPager.getCurrentItem())) != null) {
                int size = this.mTabList.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size) {
                        break;
                    }
                    AEMaterialCategory aEMaterialCategory = this.mTabList.get(i17);
                    if (!TextUtils.isEmpty(aEMaterialCategory.f69047h) && Intrinsics.areEqual(aEMaterialCategory.f69047h, f16.f69047h)) {
                        i3 = i17;
                        break;
                    }
                    i17++;
                }
            }
            this.firstClickEvent = false;
        }
        bq bqVar2 = this.mPageAdapter;
        if (bqVar2 != null) {
            list = CollectionsKt___CollectionsKt.toList(this.mTabList);
            bqVar2.j(list);
        }
        bq bqVar3 = this.mPageAdapter;
        if (bqVar3 != null) {
            bqVar3.notifyDataSetChanged();
        }
        QQViewPager qQViewPager2 = this.mViewPager;
        if (qQViewPager2 != null) {
            qQViewPager2.setAdapter(this.mPageAdapter);
        }
        QIMSlidingTabView qIMSlidingTabView = this.mTopTabBar;
        if (qIMSlidingTabView != null) {
            qIMSlidingTabView.initTabItemsWithRedDot(f());
        }
        QIMSlidingTabView qIMSlidingTabView2 = this.mTopTabBar;
        if (qIMSlidingTabView2 != null) {
            qIMSlidingTabView2.setTabCheckListener(this);
        }
        if (i3 < this.mTabList.size() || !ms.a.g()) {
            i16 = i3;
        } else {
            ms.a.a("AEFlashShowMaterialProviderView", "resetPos " + i3 + " not exist, mTabList size = " + this.mTabList.size());
        }
        if (this.materialSelected || !(!this.mTabList.isEmpty()) || this.mViewPager == null || this.mTopTabBar == null) {
            return;
        }
        k(i16);
    }

    public final void r() {
        AEMaterialMetaData value = AEFlashShowBottomPanelViewModel.INSTANCE.d().getValue();
        View view = this.mApplyNoneMaterial;
        if (view == null) {
            return;
        }
        view.setSelected(value == null || value.isNoneMaterial());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float v3, int i16) {
    }
}
