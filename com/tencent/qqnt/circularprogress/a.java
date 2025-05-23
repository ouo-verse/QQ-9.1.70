package com.tencent.qqnt.circularprogress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b!\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/circularprogress/a;", "Lcom/tencent/qqnt/circularprogress/b;", "Landroid/view/View;", "getView", "", "progress", "", HippyQQPagView.FunctionName.SET_PROGRESS, "", "state", "a", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "", "c", "I", "progressIconSize", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "stateIcon", "f", "bgImage", "Landroid/widget/FrameLayout;", "g", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", h.F, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int progressIconSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ProgressBar progressBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView stateIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView bgImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout container;

    public a(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.progressIconSize = i3;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f127113, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) inflate;
        if ((i3 > 0 ? i3 : 28) == 28) {
            progressBar.setProgressDrawable(progressBar.getContext().getDrawable(R.drawable.g_));
        } else {
            progressBar.setProgressDrawable(progressBar.getContext().getDrawable(R.drawable.f159650jw));
        }
        this.progressBar = progressBar;
        ImageView imageView = new ImageView(context);
        this.stateIcon = imageView;
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(imageView2.getContext().getDrawable(R.drawable.f13412));
        this.bgImage = imageView2;
        FrameLayout frameLayout = new FrameLayout(context);
        i3 = i3 <= 0 ? 28 : i3;
        ViewUtils viewUtils = ViewUtils.f352270a;
        frameLayout.addView(imageView2, new FrameLayout.LayoutParams(viewUtils.b(i3), viewUtils.b(i3), 17));
        frameLayout.addView(progressBar, new FrameLayout.LayoutParams(viewUtils.b(i3), viewUtils.b(i3), 17));
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(viewUtils.b(16), viewUtils.b(16), 17));
        this.container = frameLayout;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    @Override // com.tencent.qqnt.circularprogress.b
    public void a(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (state.hashCode()) {
            case -1001078227:
                if (state.equals("progress")) {
                    this.bgImage.setVisibility(0);
                    this.progressBar.setVisibility(0);
                    this.stateIcon.setVisibility(8);
                    return;
                }
                this.bgImage.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.stateIcon.setVisibility(8);
                return;
            case -838595071:
                if (state.equals(JobDbManager.TBL_UPLOAD)) {
                    this.bgImage.setVisibility(0);
                    this.progressBar.setVisibility(8);
                    this.stateIcon.setVisibility(0);
                    this.stateIcon.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.f13401, this.context.getTheme()));
                    return;
                }
                this.bgImage.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.stateIcon.setVisibility(8);
                return;
            case -563032561:
                if (state.equals("download_with_progress")) {
                    this.bgImage.setVisibility(0);
                    this.progressBar.setVisibility(0);
                    this.stateIcon.setVisibility(0);
                    this.stateIcon.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.f13390, this.context.getTheme()));
                    return;
                }
                this.bgImage.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.stateIcon.setVisibility(8);
                return;
            case 106440182:
                if (state.equals("pause")) {
                    this.bgImage.setVisibility(0);
                    this.progressBar.setVisibility(0);
                    this.stateIcon.setVisibility(0);
                    this.stateIcon.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.f13467, this.context.getTheme()));
                    return;
                }
                this.bgImage.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.stateIcon.setVisibility(8);
                return;
            case 1427818632:
                if (state.equals("download")) {
                    this.bgImage.setVisibility(0);
                    this.progressBar.setVisibility(8);
                    this.stateIcon.setVisibility(0);
                    this.stateIcon.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.f13390, this.context.getTheme()));
                    return;
                }
                this.bgImage.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.stateIcon.setVisibility(8);
                return;
            default:
                this.bgImage.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.stateIcon.setVisibility(8);
                return;
        }
    }

    @Override // com.tencent.qqnt.circularprogress.b
    public View getView() {
        return this.container;
    }

    @Override // com.tencent.qqnt.circularprogress.b
    public void setProgress(double progress) {
        this.progressBar.setProgress((int) (progress * 100));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        this(context, 28);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
