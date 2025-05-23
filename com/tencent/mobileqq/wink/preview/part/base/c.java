package com.tencent.mobileqq.wink.preview.part.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H&J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u0006\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/base/c;", "Lp53/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "back", "B9", "close", "C9", "", "t", "F9", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "f", "title", tl.h.F, "Ljava/lang/String;", "titleText", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class c extends p53.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView back;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView close;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String titleText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(c this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.B9(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(c this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.C9(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    public abstract void B9(@NotNull View back);

    public abstract void C9(@NotNull View close);

    public final void F9(@NotNull String t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        this.titleText = t16;
        TextView textView = this.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(this.titleText);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView);
        View findViewById = rootView.findViewById(R.id.f164559a43);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(R.id.back)");
        this.back = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.close)");
        this.close = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.title)");
        this.title = (TextView) findViewById3;
        ImageView imageView = this.back;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("back");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preview.part.base.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.D9(c.this, view);
            }
        });
        TextView textView2 = this.close;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preview.part.base.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.E9(c.this, view);
            }
        });
        String str = this.titleText;
        if (str != null) {
            TextView textView3 = this.title;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView3 = null;
            }
            textView3.setText(str);
        }
        TextView textView4 = this.close;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            textView4 = null;
        }
        VideoReport.setElementId(textView4, "em_xsj_close_button");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        TextView textView5 = this.close;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
        } else {
            textView = textView5;
        }
        VideoReport.setElementParams(textView, buildElementParams);
    }
}
