package com.tencent.sqshow.widget.pag;

import android.graphics.drawable.Drawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0004H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/widget/pag/a;", "Lu74/a;", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", "c", "Lorg/libpag/PAGView$PAGViewListener;", "listener", "a", "stop", "", "value", "setRepeatCount", "", HippyQQPagView.FunctionName.SET_PROGRESS, "Landroid/graphics/drawable/Drawable;", "drawable", "setLoadingDrawable", "resetView", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface a extends u74.a {
    void a(pu4.g material, PAGView.PAGViewListener listener);

    void c(pu4.g material);

    void resetView();

    void setLoadingDrawable(Drawable drawable);

    void setProgress(double value);

    void setRepeatCount(int value);

    void stop();
}
