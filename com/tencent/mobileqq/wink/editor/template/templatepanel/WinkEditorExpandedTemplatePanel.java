package com.tencent.mobileqq.wink.editor.template.templatepanel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.editor.template.g;
import com.tencent.mobileqq.wink.view.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB)\b\u0007\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010A\u001a\u00020\u0011\u00a2\u0006\u0004\bB\u0010CJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J8\u0010\f\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J$\u0010\u0018\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014JL\u0010\u001b\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001a\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010!\u001a\u0004\u0018\u00010\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u000e\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#J\u0012\u0010&\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplatePanel;", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorTemplatePanelBase;", "", "categoryId", "categoryName", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "categoryMaterials", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "favouriteMaterials", "recommendMaterials", "B", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "o", "Lcom/tencent/mobileqq/wink/view/x$a;", "categoryItemVH", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "r", "materialCategories", "categoryDividerIndex", "setData", "targetMaterial", "H", "E", "setSelectedMaterial", "G", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/template/g$a;", "listener", "setContentItemSelectListener", "setEditableOverlay", "Landroid/support/v7/widget/RecyclerView;", "J", "Landroid/support/v7/widget/RecyclerView;", "D", "()Landroid/support/v7/widget/RecyclerView;", "setMContentRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mContentRecyclerView", "Landroid/support/v7/widget/GridLayoutManager;", "K", "Landroid/support/v7/widget/GridLayoutManager;", "mContentGridLayoutManager", "Lq73/a;", "L", "Lq73/a;", "mContentAdapter", "Lq73/b;", "M", "Lq73/b;", "mContentDecoration", "", "N", "Ljava/util/List;", "mMaterials", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorExpandedTemplatePanel extends WinkEditorTemplatePanelBase {

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mContentRecyclerView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GridLayoutManager mContentGridLayoutManager;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private q73.a mContentAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private q73.b mContentDecoration;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private List<MetaMaterial> mMaterials;

    @NotNull
    public Map<Integer, View> P;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplatePanel$b", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "", com.tencent.luggage.wxa.c8.c.G, "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int pos) {
            List<MetaMaterial> B;
            Object orNull;
            q73.a aVar = WinkEditorExpandedTemplatePanel.this.mContentAdapter;
            if (aVar != null && (B = aVar.B()) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(B, pos);
                MetaMaterial metaMaterial = (MetaMaterial) orNull;
                if (metaMaterial != null && Intrinsics.areEqual(metaMaterial.f30533id, "star_empty_template_id")) {
                    return 4;
                }
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplatePanel$c", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@Nullable RecyclerView recyclerView, int newState) {
            if (1 == newState && WinkEditorExpandedTemplatePanel.this.mContentAdapter != null) {
                q73.a aVar = WinkEditorExpandedTemplatePanel.this.mContentAdapter;
                if (aVar != null) {
                    aVar.R = false;
                }
                q73.a aVar2 = WinkEditorExpandedTemplatePanel.this.mContentAdapter;
                if (aVar2 != null) {
                    aVar2.S = false;
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(@Nullable RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Integer num;
            if (WinkEditorExpandedTemplatePanel.this.mContentAdapter != null) {
                q73.a aVar = WinkEditorExpandedTemplatePanel.this.mContentAdapter;
                boolean z17 = true;
                int i3 = 0;
                if (aVar != null && !aVar.R) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    q73.a aVar2 = WinkEditorExpandedTemplatePanel.this.mContentAdapter;
                    if (aVar2 == null || aVar2.S) {
                        z17 = false;
                    }
                    if (z17) {
                        GridLayoutManager gridLayoutManager = WinkEditorExpandedTemplatePanel.this.mContentGridLayoutManager;
                        if (gridLayoutManager != null) {
                            num = Integer.valueOf(gridLayoutManager.findFirstVisibleItemPosition());
                        } else {
                            num = null;
                        }
                        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = WinkEditorExpandedTemplatePanel.this;
                        List<MetaCategory> list = winkEditorExpandedTemplatePanel.F;
                        List list2 = winkEditorExpandedTemplatePanel.mMaterials;
                        if (num != null) {
                            i3 = num.intValue();
                        }
                        WinkEditorExpandedTemplatePanel.this.D.B(com.tencent.mobileqq.wink.editor.c.f(list, list2, i3));
                    }
                }
            }
        }
    }

    @JvmOverloads
    public WinkEditorExpandedTemplatePanel(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    private final void A(String categoryId, String categoryName, List<MetaMaterial> categoryMaterials) {
        IntRange until;
        int collectionSizeOrDefault;
        if (categoryMaterials == null) {
            return;
        }
        int size = this.mMaterials.size();
        if (Intrinsics.areEqual(categoryId, "star") && categoryMaterials.isEmpty()) {
            List<MetaMaterial> list = this.mMaterials;
            MetaMaterial metaMaterial = new MetaMaterial();
            metaMaterial.f30533id = "star_empty_template_id";
            com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "star");
            com.tencent.mobileqq.wink.editor.c.p1(metaMaterial, "\u6536\u85cf");
            m.s0(metaMaterial, true);
            m.r0(metaMaterial, true);
            list.add(metaMaterial);
            return;
        }
        this.mMaterials.addAll(categoryMaterials);
        int size2 = categoryMaterials.size() % 4;
        if (size2 != 0) {
            List<MetaMaterial> list2 = this.mMaterials;
            until = RangesKt___RangesKt.until(0, 4 - size2);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                MetaMaterial f16 = com.tencent.mobileqq.wink.editor.c.f1();
                com.tencent.mobileqq.wink.editor.c.o1(f16, categoryId);
                com.tencent.mobileqq.wink.editor.c.p1(f16, categoryName);
                arrayList.add(f16);
            }
            list2.addAll(arrayList);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            List<MetaMaterial> list3 = this.mMaterials;
            int i16 = size + i3;
            MetaMaterial copy = list3.get(i16).copy();
            Intrinsics.checkNotNullExpressionValue(copy, "mMaterials[offset + i].copy()");
            list3.set(i16, copy);
            if (i3 == 0) {
                m.r0(this.mMaterials.get(i16), true);
            }
            m.s0(this.mMaterials.get(i16), true);
        }
    }

    private final void B(List<MetaMaterial> favouriteMaterials, List<MetaMaterial> recommendMaterials, List<MetaMaterial> categoryMaterials) {
        boolean z16;
        this.mMaterials.clear();
        A("star", "\u6536\u85cf", favouriteMaterials);
        List<MetaMaterial> list = recommendMaterials;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            A("recommend", "\u63a8\u8350", recommendMaterials);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (categoryMaterials != null) {
            for (MetaMaterial metaMaterial : categoryMaterials) {
                List list2 = (List) linkedHashMap.get(com.tencent.mobileqq.wink.editor.c.o(metaMaterial));
                if (list2 == null) {
                    list2 = new ArrayList();
                    linkedHashMap.put(com.tencent.mobileqq.wink.editor.c.o(metaMaterial), list2);
                }
                list2.add(metaMaterial);
            }
        }
        List<MetaCategory> list3 = this.F;
        if (list3 != null) {
            for (MetaCategory metaCategory : list3) {
                if (!Intrinsics.areEqual(metaCategory.f30532id, "star") && !Intrinsics.areEqual(metaCategory.f30532id, "recommend")) {
                    String str = metaCategory.f30532id;
                    Intrinsics.checkNotNullExpressionValue(str, "category.id");
                    String str2 = metaCategory.name;
                    Intrinsics.checkNotNullExpressionValue(str2, "category.name");
                    A(str, str2, (List) linkedHashMap.get(metaCategory.f30532id));
                }
            }
        }
    }

    @Nullable
    public final MetaMaterial C() {
        Integer num;
        Object orNull;
        GridLayoutManager gridLayoutManager = this.mContentGridLayoutManager;
        if (gridLayoutManager != null) {
            num = Integer.valueOf(gridLayoutManager.findFirstVisibleItemPosition());
        } else {
            num = null;
        }
        List<MetaMaterial> list = this.mMaterials;
        Intrinsics.checkNotNull(num);
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, num.intValue());
        return (MetaMaterial) orNull;
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final RecyclerView getMContentRecyclerView() {
        return this.mContentRecyclerView;
    }

    @NotNull
    public final List<MetaMaterial> E() {
        return this.mMaterials;
    }

    @Nullable
    public final String F() {
        MetaCategory t16 = this.D.t();
        if (t16 != null) {
            return t16.f30532id;
        }
        return null;
    }

    @Nullable
    public MetaMaterial G() {
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            return aVar.E();
        }
        return null;
    }

    public final void H(@Nullable MetaMaterial targetMaterial) {
        int i3 = 0;
        int max = Math.max(com.tencent.mobileqq.wink.editor.c.g(this.mMaterials, targetMaterial), 0);
        RecyclerView recyclerView = this.mContentRecyclerView;
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            i3 = aVar.D();
        }
        com.tencent.mobileqq.wink.utils.b.l(recyclerView, i3, max, false, false, 0.0f, 32, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    protected void m() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        q73.a aVar = new q73.a(context, WinkEditorViewModel.EditMode.Video);
        this.mContentAdapter = aVar;
        RecyclerView recyclerView = this.mContentRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(aVar);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    protected void n(@Nullable AttributeSet attrs) {
        RecyclerView.ItemAnimator itemAnimator;
        v(false);
        RecyclerView recyclerView = this.f322424e;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView2 = new RecyclerView(getContext());
        this.mContentRecyclerView = recyclerView2;
        recyclerView2.setOverScrollMode(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        this.mContentGridLayoutManager = gridLayoutManager;
        gridLayoutManager.setAutoMeasureEnabled(false);
        GridLayoutManager gridLayoutManager2 = this.mContentGridLayoutManager;
        if (gridLayoutManager2 != null) {
            gridLayoutManager2.setSpanSizeLookup(new b());
        }
        RecyclerView recyclerView3 = this.mContentRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(this.mContentGridLayoutManager);
        }
        RecyclerView recyclerView4 = this.mContentRecyclerView;
        if (recyclerView4 != null) {
            itemAnimator = recyclerView4.getItemAnimator();
        } else {
            itemAnimator = null;
        }
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        int c16 = x.c(getContext(), 10.0f);
        int c17 = x.c(getContext(), 16.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(c17, c16, c17, 0);
        addView(this.mContentRecyclerView, layoutParams);
        RecyclerView recyclerView5 = this.mContentRecyclerView;
        if (recyclerView5 != null) {
            recyclerView5.setPadding(0, 0, 0, c17);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        q73.b bVar = new q73.b(context);
        this.mContentDecoration = bVar;
        RecyclerView recyclerView6 = this.mContentRecyclerView;
        if (recyclerView6 != null) {
            recyclerView6.addItemDecoration(bVar);
        }
        RecyclerView recyclerView7 = this.mContentRecyclerView;
        if (recyclerView7 != null) {
            recyclerView7.addOnScrollListener(new c());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public int o() {
        return 1;
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    protected void r(@Nullable x.a categoryItemVH, int position, @Nullable MetaCategory category) {
        int i3;
        int e16 = com.tencent.mobileqq.wink.editor.c.e(this.F, this.mMaterials, position);
        RecyclerView recyclerView = this.mContentRecyclerView;
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            i3 = aVar.D();
        } else {
            i3 = 0;
        }
        com.tencent.mobileqq.wink.utils.b.l(recyclerView, i3, e16, false, false, 0.0f, 32, null);
    }

    public final void setContentItemSelectListener(@NotNull g.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            aVar.W(listener);
        }
    }

    public final void setData(@Nullable List<MetaCategory> materialCategories, @Nullable List<MetaMaterial> favouriteMaterials, @Nullable List<MetaMaterial> recommendMaterials, @NotNull List<MetaMaterial> categoryMaterials, int categoryDividerIndex) {
        Intrinsics.checkNotNullParameter(categoryMaterials, "categoryMaterials");
        this.F = materialCategories;
        B(favouriteMaterials, recommendMaterials, categoryMaterials);
        q73.b bVar = this.mContentDecoration;
        if (bVar != null) {
            bVar.b(this.mMaterials);
        }
        this.D.E(this.F);
        this.E.b(categoryDividerIndex);
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            aVar.i0(this.mMaterials, this.G);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setEditableOverlay(@Nullable MetaMaterial targetMaterial) {
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            aVar.v0(targetMaterial);
        }
    }

    public final void setMContentRecyclerView(@Nullable RecyclerView recyclerView) {
        this.mContentRecyclerView = recyclerView;
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setSelectedMaterial(@Nullable MetaMaterial targetMaterial) {
        q73.a aVar = this.mContentAdapter;
        if (aVar != null) {
            aVar.e0(targetMaterial);
        }
    }

    @JvmOverloads
    public WinkEditorExpandedTemplatePanel(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkEditorExpandedTemplatePanel(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = new LinkedHashMap();
        this.mMaterials = new ArrayList();
    }

    public /* synthetic */ WinkEditorExpandedTemplatePanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
