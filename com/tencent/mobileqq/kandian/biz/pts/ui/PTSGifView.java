package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0011\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSGifView;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/gif/GifView;", "Lcom/tencent/pts/ui/view/IView;", "ptsNodeGif", "Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif;", "(Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onBindNodeInfo", "", "p0", "Lcom/tencent/pts/ui/PTSNodeInfo;", "Companion", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PTSGifView extends GifView implements IView {
    public static final String TAG = "PTSGifView";

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PTSGifView(PTSNodeGif ptsNodeGif) {
        this(ptsNodeGif.getContext());
        Intrinsics.checkNotNullParameter(ptsNodeGif, "ptsNodeGif");
    }

    public PTSGifView(Context context) {
        super(context);
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo p06) {
        QLog.d(TAG, 1, p06);
        displayGif();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PTSGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PTSGifView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }
}
