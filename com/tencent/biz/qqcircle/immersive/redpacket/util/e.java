package com.tencent.biz.qqcircle.immersive.redpacket.util;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/util/e;", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "", "e", "Ljava/lang/String;", "url", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends QCirclePicStateListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    public e(@Nullable View view, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.view = view;
        this.url = url;
        if (view != null) {
            view.setTag(R.id.f489321b, url);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
    public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(option, "option");
        View view = this.view;
        if (view != null && Intrinsics.areEqual(view.getTag(R.id.f489321b), this.url) && loadState == LoadState.STATE_SUCCESS) {
            View view2 = this.view;
            if (view2 instanceof ImageView) {
                ((ImageView) view2).setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
            } else {
                view2.setBackground(new BitmapDrawable(option.getResultBitMap()));
            }
        }
    }
}
