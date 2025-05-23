package com.tencent.mobileqq.mini.entry.aio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qqnt.aio.api.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/aio/EmptyBgView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/qqnt/aio/api/b;", "", "type", "", "backgroundResume", "Landroid/content/res/ColorStateList;", "getBgTextColor", "backgroundPause", "showBgView", "hideBgView", "Lcom/tencent/mobileqq/widget/AnyScaleTypeImageView;", "miniAppEmptyNotificationIv", "Lcom/tencent/mobileqq/widget/AnyScaleTypeImageView;", "Landroid/widget/TextView;", "text", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class EmptyBgView extends LinearLayout implements b {
    public static final int AIO_BACKGROUND_MINI = 1;
    private AnyScaleTypeImageView miniAppEmptyNotificationIv;
    private TextView text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyBgView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundResource(R.drawable.qui_msg_list_bg);
        LayoutInflater.from(context).inflate(R.layout.c6e, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.bwg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.empty_image)");
        this.miniAppEmptyNotificationIv = (AnyScaleTypeImageView) findViewById;
        View findViewById2 = findViewById(R.id.lgd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.empty_tips_text)");
        this.text = (TextView) findViewById2;
        this.miniAppEmptyNotificationIv.setImageResource(R.drawable.iom);
        this.text.setText("\u6682\u65e0\u901a\u77e5");
    }

    @Override // com.tencent.qqnt.aio.api.b
    public ColorStateList getBgTextColor() {
        return null;
    }

    public final void hideBgView() {
        this.miniAppEmptyNotificationIv.setVisibility(4);
        this.text.setVisibility(4);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyBackgourndUpdate() {
        b.C9449b.d(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyInputHeightChange(int i3) {
        b.C9449b.e(this, i3);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setAdapterNavigationBarImmersive(boolean z16) {
        b.C9449b.f(this, z16);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setInfo(String str, int i3, boolean z16) {
        b.C9449b.g(this, str, i3, z16);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setOnBackgroundChangedListener(b.c cVar) {
        b.C9449b.h(this, cVar);
    }

    public final void showBgView() {
        this.miniAppEmptyNotificationIv.setVisibility(0);
        this.text.setVisibility(0);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public int type() {
        return 1;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundPause() {
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundResume() {
    }
}
