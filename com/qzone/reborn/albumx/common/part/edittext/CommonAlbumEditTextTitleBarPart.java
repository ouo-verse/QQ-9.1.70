package com.qzone.reborn.albumx.common.part.edittext;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.viewmodel.d;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/edittext/CommonAlbumEditTextTitleBarPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "initViewModel", "E9", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "titleBarText", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "btnBack", h.F, "btnDone", "Lcom/qzone/reborn/albumx/common/viewmodel/d;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "G9", "()Lcom/qzone/reborn/albumx/common/viewmodel/d;", "editVM", "<init>", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumEditTextTitleBarPart extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String titleBarText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView btnBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView btnDone;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy editVM;

    public CommonAlbumEditTextTitleBarPart(String titleBarText) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(titleBarText, "titleBarText");
        this.titleBarText = titleBarText;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.qzone.reborn.albumx.common.part.edittext.CommonAlbumEditTextTitleBarPart$editVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return (d) CommonAlbumEditTextTitleBarPart.this.getViewModel(d.class);
            }
        });
        this.editVM = lazy;
    }

    private final void E9() {
        ImageView imageView = this.btnBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageView = null;
        }
        fo.c.q(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null);
    }

    private final void F9() {
        TextView textView = this.btnDone;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDone");
            textView = null;
        }
        fo.c.q(textView, "em_qz_finish_button", null);
    }

    private final d G9() {
        return (d) this.editVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        MutableLiveData<Boolean> M1 = G9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.common.part.edittext.CommonAlbumEditTextTitleBarPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                TextView textView;
                TextView textView2;
                textView = CommonAlbumEditTextTitleBarPart.this.btnDone;
                TextView textView3 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnDone");
                    textView = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                textView.setAlpha(it.booleanValue() ? 1.0f : 0.3f);
                textView2 = CommonAlbumEditTextTitleBarPart.this.btnDone;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnDone");
                } else {
                    textView3 = textView2;
                }
                textView3.setEnabled(it.booleanValue());
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.edittext.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumEditTextTitleBarPart.H9(Function1.this, obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f19465r) {
            broadcastMessage("ACTION_BACK_CLICK", null);
        } else if (valueOf != null && valueOf.intValue() == R.id.f19515w) {
            broadcastMessage("ACTION_DONE", null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.nkf);
            TextView textView = (TextView) findViewById;
            textView.setText(this.titleBarText);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R\u2026itleBarText\n            }");
            this.tvTitle = textView;
            View findViewById2 = rootView.findViewById(R.id.f19465r);
            ImageView imageView = (ImageView) findViewById2;
            imageView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(\u2026tleBarPart)\n            }");
            this.btnBack = imageView;
            View findViewById3 = rootView.findViewById(R.id.f19515w);
            TextView textView2 = (TextView) findViewById3;
            textView2.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026tleBarPart)\n            }");
            this.btnDone = textView2;
            E9();
            F9();
            initViewModel();
        }
    }
}
