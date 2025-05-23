package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00038\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 \u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/SpecifyHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/DefaultHbView;", "Landroid/widget/TextView;", "", "name", "h1", "", "initView", "D0", "K0", "Lcom/tencent/qqnt/qwallet/aio/hb/SpecifyHbViewModel;", "N", "Lkotlin/Lazy;", "i1", "()Lcom/tencent/qqnt/qwallet/aio/hb/SpecifyHbViewModel;", "viewModel", "P", "Ljava/lang/String;", "V0", "()Ljava/lang/String;", "typeText", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "Q0", "()I", "layoutResId", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "subtitleView", "Landroidx/lifecycle/Observer;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/Observer;", "nickNameObserver", "Landroid/graphics/drawable/Drawable;", "T", "avatarObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SpecifyHbView extends DefaultHbView {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int layoutResId;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView subtitleView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> nickNameObserver;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Observer<Drawable> avatarObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecifyHbView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SpecifyHbViewModel>() { // from class: com.tencent.qqnt.qwallet.aio.hb.SpecifyHbView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SpecifyHbViewModel invoke() {
                return new SpecifyHbViewModel();
            }
        });
        this.viewModel = lazy;
        this.typeText = "\u4e13\u5c5e\u7ea2\u5305";
        this.layoutResId = R.layout.hhu;
        this.nickNameObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpecifyHbView.k1(SpecifyHbView.this, (String) obj);
            }
        };
        this.avatarObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpecifyHbView.g1(SpecifyHbView.this, (Drawable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(SpecifyHbView this$0, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0().setImageDrawable(drawable);
    }

    private final String h1(TextView textView, String str) {
        String string = textView.getContext().getString(R.string.f228186t2, str);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026title_for_somebody, name)");
        if (textView.getPaint().measureText(string) < textView.getWidth() * textView.getMaxLines()) {
            return string;
        }
        for (int length = str.length() - 2; length > 0; length--) {
            Context context = textView.getContext();
            String substring = str.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String string2 = context.getString(R.string.f228186t2, substring + MiniBoxNoticeInfo.APPNAME_SUFFIX);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026substring(0, index)}...\")");
            if (textView.getPaint().measureText(string2) < textView.getWidth() * textView.getMaxLines()) {
                return string2;
            }
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(final SpecifyHbView this$0, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.subtitleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
            textView = null;
        }
        textView.post(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.hb.q
            @Override // java.lang.Runnable
            public final void run() {
                SpecifyHbView.l1(SpecifyHbView.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(SpecifyHbView this$0, String name) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.subtitleView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
            textView = null;
        }
        TextView textView3 = this$0.subtitleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        } else {
            textView2 = textView3;
        }
        Intrinsics.checkNotNullExpressionValue(name, "name");
        textView.setText(this$0.h1(textView2, name));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void D0() {
        super.D0();
        W0().b2().observeForever(this.nickNameObserver);
        W0().a2().observeForever(this.avatarObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void K0() {
        super.K0();
        W0().b2().removeObserver(this.nickNameObserver);
        W0().a2().removeObserver(this.avatarObserver);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    /* renamed from: Q0, reason: from getter */
    protected int getLayoutResId() {
        return this.layoutResId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: V0, reason: from getter */
    public String getTypeText() {
        return this.typeText;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public SpecifyHbViewModel W0() {
        return (SpecifyHbViewModel) this.viewModel.getValue();
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void initView() {
        super.initView();
        View findViewById = findViewById(R.id.f166934j82);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.subtitle_view)");
        this.subtitleView = (TextView) findViewById;
    }
}
