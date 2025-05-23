package com.tencent.mobileqq.search.searchdetail.content.template;

import android.graphics.drawable.Animatable;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "", "url", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "b", "", "radius", "e", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class u {
    public static final void b(@NotNull ImageView imageView, @NotNull String url, @Nullable final IPicLoadStateListener iPicLoadStateListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option targetView = Option.obtain().setUrl(url).setTargetView(imageView);
        Intrinsics.checkNotNullExpressionValue(targetView, "obtain().setUrl(url).setTargetView(this)");
        qQPicLoader.e(targetView, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.t
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                u.d(IPicLoadStateListener.this, loadState, option);
            }
        });
    }

    public static /* synthetic */ void c(ImageView imageView, String str, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iPicLoadStateListener = null;
        }
        b(imageView, str, iPicLoadStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IPicLoadStateListener iPicLoadStateListener, LoadState loadState, Option option) {
        r01.c cVar;
        Animatable animatable = option.getAnimatable();
        if (animatable instanceof r01.c) {
            cVar = (r01.c) animatable;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.setLoopCount(65535);
        }
        if (cVar != null) {
            cVar.start();
        }
        if (iPicLoadStateListener != null) {
            iPicLoadStateListener.onStateChange(loadState, option);
        }
    }

    public static final void e(@NotNull ImageView imageView, float f16) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        com.tencent.mobileqq.widget.listitem.ab.d(imageView, f16);
        imageView.setBackgroundColor(0);
    }
}
