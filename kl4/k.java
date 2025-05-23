package kl4;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012\u00a8\u0006*"}, d2 = {"Lkl4/k;", "Lcom/tencent/timi/game/ui/widget/a;", "Landroid/view/View;", "U", ExifInterface.LATITUDE_SOUTH, "", "content", "b0", "", "onBackPressed", "text", "f0", "d0", "Landroid/content/DialogInterface$OnClickListener;", "listener", "e0", "c0", "K", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "L", "Landroid/content/DialogInterface$OnClickListener;", "positiveButtonClickListener", "M", "negativeButtonClickListener", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "negativeButton", "P", "positiveButton", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "contentText", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "contentView", "bgView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class k extends com.tencent.timi.game.ui.widget.a {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnClickListener positiveButtonClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnClickListener negativeButtonClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextView negativeButton;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final TextView positiveButton;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TextView contentText;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final View bgView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.huk, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layout.tg_live_dialog, null)");
        this.rootView = inflate;
        setContentView(inflate);
        View findViewById = findViewById(R.id.f6w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.negativeButton)");
        TextView textView = (TextView) findViewById;
        this.negativeButton = textView;
        View findViewById2 = findViewById(R.id.fxl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.positiveButton)");
        TextView textView2 = (TextView) findViewById2;
        this.positiveButton = textView2;
        View findViewById3 = findViewById(R.id.u7y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.contentText)");
        this.contentText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.contentView)");
        this.contentView = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.t67);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.bgView)");
        this.bgView = findViewById5;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        textView.setOnClickListener(new View.OnClickListener() { // from class: kl4.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.Z(k.this, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: kl4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.a0(k.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogInterface.OnClickListener onClickListener = this$0.negativeButtonClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this$0, -2);
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogInterface.OnClickListener onClickListener = this$0.positiveButtonClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this$0, -1);
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    /* renamed from: S, reason: from getter */
    public View getBgView() {
        return this.bgView;
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    public View U() {
        return this.contentView;
    }

    @NotNull
    public final k b0(@Nullable String content) {
        if (content != null) {
            this.contentText.setText(content);
        }
        return this;
    }

    @NotNull
    public final k c0(@Nullable DialogInterface.OnClickListener listener) {
        this.negativeButtonClickListener = listener;
        return this;
    }

    @NotNull
    public final k d0(@Nullable String text) {
        if (text != null) {
            this.negativeButton.setText(text);
        }
        return this;
    }

    @NotNull
    public final k e0(@Nullable DialogInterface.OnClickListener listener) {
        this.positiveButtonClickListener = listener;
        return this;
    }

    @NotNull
    public final k f0(@Nullable String text) {
        if (text != null) {
            this.positiveButton.setText(text);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }
}
