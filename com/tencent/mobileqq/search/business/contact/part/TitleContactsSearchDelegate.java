package com.tencent.mobileqq.search.business.contact.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00100\u0005H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/TitleContactsSearchDelegate;", "Lcom/tencent/mobileqq/search/business/contact/part/c;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$e;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "TitleSection", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TitleContactsSearchDelegate extends c<UIType.TitleUI> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/TitleContactsSearchDelegate$TitleSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "Lhp2/e;", "d", "Lhp2/e;", "getBinding", "()Lhp2/e;", "setBinding", "(Lhp2/e;)V", "binding", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class TitleSection extends Section<UIType.TitleUI> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private hp2.e binding;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        @NotNull
        public int[] getViewStubLayoutId() {
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@Nullable View containerView) {
            if (containerView != null) {
                this.binding = hp2.e.e(containerView);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindData(@Nullable UIType.TitleUI data, int position, @Nullable List<Object> payload) {
            TextView textView;
            LinearLayout root;
            LinearLayout root2;
            String str;
            hp2.e eVar = this.binding;
            if (eVar != null) {
                textView = eVar.f405640b;
            } else {
                textView = null;
            }
            if (textView != null) {
                if (data == null || (str = data.getTitle()) == null) {
                    str = "";
                }
                textView.setText(str);
            }
            boolean z16 = false;
            if (data != null && data.getIsGapTop()) {
                z16 = true;
            }
            if (z16) {
                hp2.e eVar2 = this.binding;
                if (eVar2 != null && (root2 = eVar2.getRoot()) != null) {
                    com.tencent.mobileqq.search.searchdetail.multimedia.p.a(root2, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.part.TitleContactsSearchDelegate$TitleSection$onBindData$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                            invoke2(marginLayoutParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull ViewGroup.MarginLayoutParams updateLayoutParams) {
                            Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                            updateLayoutParams.topMargin = ViewUtils.dpToPx(12.0f);
                        }
                    });
                    return;
                }
                return;
            }
            hp2.e eVar3 = this.binding;
            if (eVar3 != null && (root = eVar3.getRoot()) != null) {
                com.tencent.mobileqq.search.searchdetail.multimedia.p.a(root, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.part.TitleContactsSearchDelegate$TitleSection$onBindData$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                        invoke2(marginLayoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ViewGroup.MarginLayoutParams updateLayoutParams) {
                        Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                        updateLayoutParams.topMargin = ViewUtils.dpToPx(0.0f);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull UIType item, @NotNull List<UIType> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof UIType.TitleUI;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.e4f;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<UIType.TitleUI>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(TitleSection.class);
    }
}
