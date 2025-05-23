package com.tencent.mobileqq.wink.editor.template.templatepanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.util.Supplier;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wink.edit.manager.f;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.c;
import com.tencent.mobileqq.wink.editor.template.g;
import com.tencent.mobileqq.wink.editor.template.templatepanel.a;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB#\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a;", "Lcom/tencent/mobileqq/wink/editor/template/g;", "", "show", "", "w0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/wink/view/ab$a;", "o0", "index", "smoothScroll", "scrollOnSelect", "c0", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;", "W", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;", "mFavoriteClickCallback", "X", "Z", "showFavouriteView", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;)V", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class a extends g {

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private final InterfaceC9043a mFavoriteClickCallback;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean showFavouriteView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.template.templatepanel.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9043a {
        void a(@NotNull MetaMaterial material);

        void b(@NotNull MetaMaterial material);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b&\u0010'J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0014JN\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$b;", "Lcom/tencent/mobileqq/wink/view/ab$a;", "Landroid/view/View;", "favouriteView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "isFav", "", "p", "d", "", "position", "selectIndex", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "resReady", "Landroidx/core/util/Supplier;", "clickable", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter$c;", "itemClickListener", "f", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;", "H", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;", "clickCallback", "I", "Z", "showFavouriteView", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", DomainData.DOMAIN_NAME, "()Landroid/widget/ImageView;", "setMFavoriteView", "(Landroid/widget/ImageView;)V", "mFavoriteView", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/editor/template/templatepanel/a$a;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends ab.a {

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private final InterfaceC9043a clickCallback;

        /* renamed from: I, reason: from kotlin metadata */
        private final boolean showFavouriteView;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private ImageView mFavoriteView;

        public b(@Nullable View view, @Nullable InterfaceC9043a interfaceC9043a, boolean z16) {
            super(view);
            this.clickCallback = interfaceC9043a;
            this.showFavouriteView = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(b this$0, MetaMaterial material, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(material, "$material");
            ImageView imageView = this$0.mFavoriteView;
            Intrinsics.checkNotNull(imageView);
            Intrinsics.checkNotNull(this$0.mFavoriteView);
            imageView.setSelected(!r1.isSelected());
            ImageView imageView2 = this$0.mFavoriteView;
            Intrinsics.checkNotNull(imageView2);
            boolean isSelected = imageView2.isSelected();
            if (isSelected) {
                f.e().a(material.f30533id);
                InterfaceC9043a interfaceC9043a = this$0.clickCallback;
                if (interfaceC9043a != null) {
                    interfaceC9043a.a(material);
                }
            } else {
                f.e().b(material.f30533id);
                InterfaceC9043a interfaceC9043a2 = this$0.clickCallback;
                if (interfaceC9043a2 != null) {
                    interfaceC9043a2.b(material);
                }
            }
            this$0.p(this$0.mFavoriteView, material, isSelected);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void p(View favouriteView, MetaMaterial material, boolean isFav) {
            String str;
            Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_template_name", c.a0(material));
            buildElementParams.put("xsj_template_id", material.f30533id);
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY, c.p(material));
            if (isFav) {
                str = "\u6536\u85cf";
            } else {
                str = "\u53d6\u6d88\u6536\u85cf";
            }
            buildElementParams.put("xsj_action_type", str);
            e.f326265a.q("ev_xsj_abnormal_clck", favouriteView, "em_xsj_collect_button", buildElementParams, buildElementParams);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.wink.view.ab.a
        public void d() {
            super.d();
            this.mFavoriteView = (ImageView) this.itemView.findViewById(R.id.f6443368);
        }

        @Override // com.tencent.mobileqq.wink.view.ab.a
        public void f(@NotNull final MetaMaterial material, int position, int selectIndex, @Nullable WinkEditorViewModel.EditMode editMode, boolean resReady, @Nullable Supplier<Boolean> clickable, @Nullable AbsWinkMaterialPanelContentAdapter.c itemClickListener) {
            boolean z16;
            Intrinsics.checkNotNullParameter(material, "material");
            super.f(material, position, selectIndex, editMode, resReady, clickable, itemClickListener);
            if (this.showFavouriteView) {
                ImageView imageView = this.mFavoriteView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (selectIndex == position) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    ImageView imageView2 = this.mFavoriteView;
                    Intrinsics.checkNotNull(imageView2);
                    imageView2.setVisibility(0);
                    boolean f16 = f.e().f(material.f30533id);
                    w53.b.f("WinkEditorTemplateContentAdapter", "id:" + material.f30533id + " , isF: " + f16 + ", selectIndex: " + selectIndex);
                    ImageView imageView3 = this.mFavoriteView;
                    Intrinsics.checkNotNull(imageView3);
                    imageView3.setSelected(f16);
                } else {
                    ImageView imageView4 = this.mFavoriteView;
                    Intrinsics.checkNotNull(imageView4);
                    imageView4.setVisibility(4);
                }
                ImageView imageView5 = this.mFavoriteView;
                Intrinsics.checkNotNull(imageView5);
                imageView5.setOnClickListener(new View.OnClickListener() { // from class: q73.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.b.o(a.b.this, material, view);
                    }
                });
                return;
            }
            ImageView imageView6 = this.mFavoriteView;
            if (imageView6 != null) {
                imageView6.setVisibility(8);
            }
        }

        @Nullable
        /* renamed from: n, reason: from getter */
        public final ImageView getMFavoriteView() {
            return this.mFavoriteView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull WinkEditorViewModel.EditMode editMode, @Nullable InterfaceC9043a interfaceC9043a) {
        super(context, editMode);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        this.mFavoriteClickCallback = interfaceC9043a;
        this.showFavouriteView = true;
        q0(x.c(context, 12.0f));
    }

    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public void c0(int index, boolean smoothScroll, boolean scrollOnSelect) {
        MetaMaterial metaMaterial;
        if (index >= 0) {
            List<MetaMaterial> B = B();
            if (B != null) {
                metaMaterial = B.get(index);
            } else {
                metaMaterial = null;
            }
            if (metaMaterial != null) {
                metaMaterial.hasRedDot = false;
            }
        }
        super.c0(index, smoothScroll, scrollOnSelect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    @Nullable
    public ab.a o0(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(LayoutInflater.from(parent.getContext()).inflate(R.layout.hfm, parent, false), this.mFavoriteClickCallback, this.showFavouriteView);
    }

    public final void w0(boolean show) {
        this.showFavouriteView = show;
    }
}
