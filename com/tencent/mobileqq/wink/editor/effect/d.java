package com.tencent.mobileqq.wink.editor.effect;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectAdapter;
import com.tencent.mobileqq.wink.editor.effect.d;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002/7\u0018\u00002\u00020\u0001:\u0002\u001b\u001fB'\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020,0&j\b\u0012\u0004\u0012\u00020,`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010*R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/d;", "", "", "o", "Landroid/view/View;", "view", "", NodeProps.ENABLED, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "i", "", "position", "k", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "type", "Lcom/tencent/mobileqq/wink/editor/model/b;", "effectMaterialVO", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/editor/effect/d$b;", "callback", "l", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "b", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "categoryTabLayout", "Landroid/support/v7/widget/RecyclerView;", "c", "Landroid/support/v7/widget/RecyclerView;", "rvMaterial", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "d", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "categoryList", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "f", "materialList", "com/tencent/mobileqq/wink/editor/effect/d$f", "g", "Lcom/tencent/mobileqq/wink/editor/effect/d$f;", "innerAdapterItemListener", "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectAdapter$b;", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectAdapter$b;", "innerAdapterLongClickInterceptor", "com/tencent/mobileqq/wink/editor/effect/d$g", "Lcom/tencent/mobileqq/wink/editor/effect/d$g;", "innerTipsListener", "j", "Lcom/tencent/mobileqq/wink/editor/effect/d$b;", "effectMaterialOp", "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectAdapter;", "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectAdapter;", "effectAdapter", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/widget/TabLayoutCompat;Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabLayoutCompat categoryTabLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView rvMaterial;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorViewModel.EditMode editMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MetaCategory> categoryList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MetaMaterial> materialList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f innerAdapterItemListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorEffectAdapter.b innerAdapterLongClickInterceptor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g innerTipsListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b effectMaterialOp;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorEffectAdapter effectAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\n\u001a\u00020\tH&J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/d$b;", "", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "e", "b", "", "d", "posX", "posY", com.tencent.luggage.wxa.c8.c.G, "a", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "tab", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(int posX, int posY, int pos, @NotNull MetaMaterial material);

        void b(int position, @Nullable MetaMaterial material);

        void c(@NotNull TabLayoutCompat.f tab);

        boolean d();

        void e(int position, @Nullable MetaMaterial material);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/d$c;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "a", "Landroid/view/View;", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "tvContent", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView tvContent;

        public c(@NotNull View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.itemView = itemView;
            View findViewById = itemView.findViewById(R.id.f10511655);
            TextView textView = (TextView) findViewById;
            textView.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{-1, itemView.getContext().getColor(R.color.czu)}));
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Te\u2026tates, colors))\n        }");
            this.tvContent = textView;
        }

        public final void a(@NotNull MetaCategory category) {
            Intrinsics.checkNotNullParameter(category, "category");
            this.tvContent.setText(category.name);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.editor.effect.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public /* synthetic */ class C9026d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320066a;

        static {
            int[] iArr = new int[WinkEffectCatType.values().length];
            try {
                iArr[WinkEffectCatType.TypeFace.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f320066a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/d$e", "Lcom/tencent/mobileqq/wink/flow/a;", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "F1", "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends com.tencent.mobileqq.wink.flow.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d this$0, int i3, MetaMaterial material) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(material, "$material");
            this$0.effectAdapter.E0(i3, material);
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void F1(@NotNull ApplyMaterialTask.Status downloadStatus, final int position, @NotNull final MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
            Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (d.this.effectAdapter.F0(position)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final d dVar = d.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.effect.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.e.b(d.this, position, material);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void g(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/d$f", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter$d;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements AbsWinkMaterialPanelContentAdapter.d {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.d
        public void a(int position, @Nullable MetaMaterial material) {
            d.this.categoryTabLayout.setClickable(true);
            d dVar = d.this;
            dVar.m(dVar.categoryTabLayout, true);
            b bVar = d.this.effectMaterialOp;
            if (bVar != null) {
                bVar.e(position, material);
            }
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.c
        public void b(int position, @Nullable MetaMaterial material) {
            d.this.categoryTabLayout.setClickable(true);
            d dVar = d.this;
            dVar.m(dVar.categoryTabLayout, true);
            b bVar = d.this.effectMaterialOp;
            if (bVar != null) {
                bVar.b(position, material);
            }
        }
    }

    public d(@NotNull Context context, @NotNull TabLayoutCompat categoryTabLayout, @NotNull RecyclerView rvMaterial, @NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(categoryTabLayout, "categoryTabLayout");
        Intrinsics.checkNotNullParameter(rvMaterial, "rvMaterial");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        this.context = context;
        this.categoryTabLayout = categoryTabLayout;
        this.rvMaterial = rvMaterial;
        this.editMode = editMode;
        this.categoryList = new ArrayList<>();
        ArrayList<MetaMaterial> arrayList = new ArrayList<>();
        this.materialList = arrayList;
        f fVar = new f();
        this.innerAdapterItemListener = fVar;
        WinkEditorEffectAdapter.b bVar = new WinkEditorEffectAdapter.b() { // from class: com.tencent.mobileqq.wink.editor.effect.c
            @Override // com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectAdapter.b
            public final boolean interceptor() {
                boolean j3;
                j3 = d.j(d.this);
                return j3;
            }
        };
        this.innerAdapterLongClickInterceptor = bVar;
        g gVar = new g();
        this.innerTipsListener = gVar;
        WinkEditorEffectAdapter winkEditorEffectAdapter = new WinkEditorEffectAdapter(context, editMode, fVar);
        this.effectAdapter = winkEditorEffectAdapter;
        rvMaterial.setLayoutManager(new LinearLayoutManager(context, 0, false));
        rvMaterial.setAdapter(winkEditorEffectAdapter);
        winkEditorEffectAdapter.K0(bVar);
        winkEditorEffectAdapter.L0(gVar);
        winkEditorEffectAdapter.Y(arrayList);
        winkEditorEffectAdapter.S(i());
        categoryTabLayout.setTabMode(0);
        categoryTabLayout.setTabGravity(0);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        categoryTabLayout.setSelectedTabIndicatorHeight(eVar.a(2.0f));
        categoryTabLayout.setSelectedTabIndicatorPaddingLeft(eVar.a(23.0f));
        categoryTabLayout.setSelectedTabIndicatorPaddingRight(eVar.a(23.0f));
        categoryTabLayout.setSelectedTabIndicatorPaddingBottom(eVar.a(4.0f));
        categoryTabLayout.setSelectedTabIndicatorColor(-1);
        categoryTabLayout.setScrollableTabMinWidth(eVar.a(64.0f));
        categoryTabLayout.g(new a());
    }

    private final ApplyMaterialTask i() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.effectMaterialOp;
        if (bVar != null) {
            return bVar.d();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View child = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(child, "child");
                m(child, enabled);
            }
        }
    }

    private final void o() {
        View inflate;
        if (this.categoryTabLayout.A() > this.categoryList.size()) {
            int A = this.categoryTabLayout.A() - this.categoryList.size();
            for (int i3 = 0; i3 < A; i3++) {
                this.categoryTabLayout.I(0);
            }
        }
        int i16 = 0;
        for (Object obj : this.categoryList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MetaCategory metaCategory = (MetaCategory) obj;
            TabLayoutCompat.f z16 = this.categoryTabLayout.z(i16);
            if (z16 == null || (inflate = z16.b()) == null) {
                inflate = LayoutInflater.from(this.context).inflate(R.layout.i5b, (ViewGroup) null, false);
                TabLayoutCompat.f m3 = this.categoryTabLayout.E().m(inflate);
                Intrinsics.checkNotNullExpressionValue(m3, "categoryTabLayout.newTab\u2026setCustomView(customView)");
                this.categoryTabLayout.h(m3);
            }
            View tabCustomView = inflate;
            Intrinsics.checkNotNullExpressionValue(tabCustomView, "tabCustomView");
            new c(tabCustomView).a(metaCategory);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY_NAME, metaCategory.f30532id);
            Unit unit = Unit.INSTANCE;
            Map<String, ?> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
            buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY_NAME, metaCategory.f30532id);
            eVar.q("ev_xsj_abnormal_imp", tabCustomView, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_CATEGORY, buildElementParams, buildElementParams2);
            i16 = i17;
        }
    }

    public final void k(int position) {
        TabLayoutCompat.f z16 = this.categoryTabLayout.z(position);
        if (z16 != null) {
            z16.j();
        }
        this.materialList.clear();
        if (this.categoryList.size() > 0) {
            this.materialList.addAll(this.categoryList.get(position).materials);
            this.effectAdapter.J0(this.categoryList.get(position).name);
        }
        this.effectAdapter.notifyDataSetChanged();
        this.categoryTabLayout.scrollTo(0, 0);
        this.rvMaterial.scrollToPosition(0);
    }

    public final void l(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.effectMaterialOp = callback;
    }

    public final void n(@NotNull WinkEffectCatType type, @Nullable com.tencent.mobileqq.wink.editor.model.b effectMaterialVO) {
        MetaCategory metaCategory;
        Intrinsics.checkNotNullParameter(type, "type");
        if (effectMaterialVO == null) {
            this.categoryList.clear();
            o();
            this.materialList.clear();
            this.effectAdapter.notifyDataSetChanged();
            return;
        }
        Object obj = null;
        if (C9026d.f320066a[type.ordinal()] == 1) {
            List<MetaCategory> a16 = effectMaterialVO.a();
            Intrinsics.checkNotNullExpressionValue(a16, "effectMaterialVO.metaCategories");
            Iterator<T> it = a16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "100102")) {
                    obj = next;
                    break;
                }
            }
            metaCategory = (MetaCategory) obj;
        } else {
            List<MetaCategory> a17 = effectMaterialVO.a();
            Intrinsics.checkNotNullExpressionValue(a17, "effectMaterialVO.metaCategories");
            Iterator<T> it5 = a17.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                if (Intrinsics.areEqual(((MetaCategory) next2).f30532id, "100101")) {
                    obj = next2;
                    break;
                }
            }
            metaCategory = (MetaCategory) obj;
        }
        if (metaCategory != null && metaCategory.subCategories.size() > 0) {
            this.categoryList.clear();
            this.categoryList.addAll(metaCategory.subCategories);
            o();
            this.materialList.clear();
            this.materialList.addAll(metaCategory.subCategories.get(0).materials);
            this.effectAdapter.J0(metaCategory.subCategories.get(0).name);
            this.effectAdapter.notifyDataSetChanged();
            return;
        }
        this.categoryList.clear();
        o();
        this.materialList.clear();
        this.effectAdapter.notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/d$g", "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectAdapter$c;", "", "posX", "posY", com.tencent.luggage.wxa.c8.c.G, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements WinkEditorEffectAdapter.c {
        g() {
        }

        @Override // com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectAdapter.c
        public void a(int posX, int posY, int pos, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            b bVar = d.this.effectMaterialOp;
            if (bVar != null) {
                bVar.a(posX, posY, pos, material);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectAdapter.c
        public void b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/d$a", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$c;", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "tab", "", "c", "l3", "J8", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements TabLayoutCompat.c {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void c(@NotNull TabLayoutCompat.f tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            if (d.this.categoryList.size() > 0) {
                Object obj = d.this.categoryList.get(tab.d());
                Intrinsics.checkNotNullExpressionValue(obj, "categoryList[position]");
                MetaCategory metaCategory = (MetaCategory) obj;
                d.this.materialList.clear();
                d.this.materialList.addAll(metaCategory.materials);
                d.this.effectAdapter.J0(metaCategory.name);
                d.this.effectAdapter.notifyDataSetChanged();
                d.this.rvMaterial.scrollToPosition(0);
                com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
                View b16 = tab.b();
                Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY_NAME, metaCategory.f30532id);
                Unit unit = Unit.INSTANCE;
                Map<String, ?> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
                buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY_NAME, metaCategory.f30532id);
                eVar.q("ev_xsj_abnormal_clck", b16, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_CATEGORY, buildElementParams, buildElementParams2);
            }
            b bVar = d.this.effectMaterialOp;
            if (bVar != null) {
                bVar.c(tab);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void J8(@Nullable TabLayoutCompat.f tab) {
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void l3(@Nullable TabLayoutCompat.f tab) {
        }
    }
}
