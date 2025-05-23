package com.tencent.mobileqq.wink.publish.part;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.publish.multiselect.PublishMultiSelectPanelPart;
import com.tencent.mobileqq.wink.publish.multiselect.WinkMultiSelectData;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishJurisdictionPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "N9", "L9", "", "B9", "onInitView", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "jurisdictionLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "jurisdictionText", "Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart;", "f", "Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart;", "multiSelectPart", "Lcom/tencent/mobileqq/wink/publish/viewmodel/n;", tl.h.F, "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/n;", "viewModel", "<init>", "()V", "i", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishJurisdictionPart extends j {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f325737m = UploadConstants.TAG + "FSJurisdictionPart";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout jurisdictionLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView jurisdictionText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PublishMultiSelectPanelPart multiSelectPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishJurisdictionPart$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.part.PublishJurisdictionPart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return PublishJurisdictionPart.f325737m;
        }

        Companion() {
        }
    }

    public PublishJurisdictionPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.publish.viewmodel.n>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishJurisdictionPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.publish.viewmodel.n invoke() {
                return (com.tencent.mobileqq.wink.publish.viewmodel.n) PublishJurisdictionPart.this.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.n.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.publish.viewmodel.n H9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.wink.publish.viewmodel.n) value;
    }

    private final void I9(View rootView) {
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.f58262pj);
        if (viewStub == null) {
            return;
        }
        viewStub.inflate();
        Part part = getPartManager().getPart(PublishMultiSelectPanelPart.class.getName());
        Intrinsics.checkNotNull(part, "null cannot be cast to non-null type com.tencent.mobileqq.wink.publish.multiselect.PublishMultiSelectPanelPart");
        this.multiSelectPart = (PublishMultiSelectPanelPart) part;
        View findViewById = rootView.findViewById(R.id.f58252pi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026h_jurisdiction_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.jurisdictionLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jurisdictionLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishJurisdictionPart.J9(PublishJurisdictionPart.this, view);
            }
        });
        rootView.findViewById(R.id.f58272pk).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishJurisdictionPart.K9(PublishJurisdictionPart.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.f58282pl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ublish_jurisdiction_text)");
        this.jurisdictionText = (TextView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(PublishJurisdictionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(PublishJurisdictionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L9() {
        H9().L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishJurisdictionPart.M9(PublishJurisdictionPart.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(PublishJurisdictionPart this$0, Boolean bool) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d(f325737m, 2, "onUpdated... isPublic: " + bool);
        }
        if (bool == null) {
            return;
        }
        bool.booleanValue();
        if (bool.booleanValue()) {
            i3 = R.string.f196694i0;
        } else {
            i3 = R.string.f196674hy;
        }
        TextView textView = this$0.jurisdictionText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jurisdictionText");
            textView = null;
        }
        textView.setText(i3);
        if (this$0.getPartManager().getPart(PublishSharePart.class.getName()) != null) {
            Part part = this$0.getPartManager().getPart(PublishSharePart.class.getName());
            Intrinsics.checkNotNull(part, "null cannot be cast to non-null type com.tencent.mobileqq.wink.publish.part.PublishSharePart");
            ((PublishSharePart) part).P9(bool.booleanValue());
        }
    }

    private final void N9() {
        List<WinkMultiSelectData> listOf;
        Boolean value = H9().L1().getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        boolean booleanValue = value.booleanValue();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.knq);
        String string = getContext().getString(R.string.f196684hz);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026jurisdiction_public_text)");
        Drawable drawable2 = ContextCompat.getDrawable(getContext(), R.drawable.knr);
        String string2 = getContext().getString(R.string.f196674hy);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026ction_just_yourself_text)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new WinkMultiSelectData[]{new WinkMultiSelectData(drawable, null, string, booleanValue, 2, null), new WinkMultiSelectData(drawable2, null, string2, !booleanValue, 2, null)});
        PublishMultiSelectPanelPart publishMultiSelectPanelPart = this.multiSelectPart;
        if (publishMultiSelectPanelPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiSelectPart");
            publishMultiSelectPanelPart = null;
        }
        PublishMultiSelectPanelPart.Style style = PublishMultiSelectPanelPart.Style.STYLE_CHECK;
        String string3 = getContext().getString(R.string.f196704i1);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026_jurisdiction_title_text)");
        publishMultiSelectPanelPart.R9(style, string3, listOf, new Function1<List<? extends WinkMultiSelectData>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishJurisdictionPart$showJurisdictionPanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends WinkMultiSelectData> list) {
                invoke2((List<WinkMultiSelectData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<WinkMultiSelectData> resultList) {
                Object first;
                com.tencent.mobileqq.wink.publish.viewmodel.n H9;
                Intrinsics.checkNotNullParameter(resultList, "resultList");
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) resultList);
                boolean isChecked = ((WinkMultiSelectData) first).getIsChecked();
                H9 = PublishJurisdictionPart.this.H9();
                H9.N1(Boolean.valueOf(isChecked));
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return f325737m;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9(rootView);
        L9();
    }
}
