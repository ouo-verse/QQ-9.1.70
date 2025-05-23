package com.tencent.aelight.camera.ae.camera.aibeauty;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/aibeauty/b;", "Landroid/app/Dialog;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/image/URLImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/image/URLImageView;", "mIvHead", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mTvConfirm", "", "E", "Z", MiniGamePAHippyBaseFragment.KEY_THEME, "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private URLImageView mIvHead;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTvConfirm;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isNightMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context ctx) {
        super(ctx, R.style.f243450u);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.isNightMode = i.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.isNightMode ? R.layout.dkv : R.layout.dku);
        View findViewById = findViewById(R.id.rvv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_head)");
        this.mIvHead = (URLImageView) findViewById;
        View findViewById2 = findViewById(R.id.s3d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_confirm)");
        TextView textView = (TextView) findViewById2;
        this.mTvConfirm = textView;
        URLImageView uRLImageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvConfirm");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.aibeauty.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.O(b.this, view);
            }
        });
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        obtain.mRequestWidth = UIUtils.b(getContext(), 296.0f);
        obtain.mRequestHeight = UIUtils.b(getContext(), 170.0f);
        obtain.mRetryCount = 3;
        URLDrawable drawable = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/ai_beauty/ai_beauty_dialog.png", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(\"https://dow\u2026uty_dialog.png\", options)");
        if (drawable.getStatus() == 2) {
            drawable.restartDownload();
        }
        URLImageView uRLImageView2 = this.mIvHead;
        if (uRLImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvHead");
        } else {
            uRLImageView = uRLImageView2;
        }
        uRLImageView.setImageDrawable(drawable);
    }
}
