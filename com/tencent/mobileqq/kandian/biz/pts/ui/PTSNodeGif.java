package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "appInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "setAttribute", "", "key", "", "value", "", "Builder", "Companion", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PTSNodeGif extends PTSNodeVirtual {
    public static final String VIDEO_TAG = "PTSNodeGif";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif$Builder;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual$a;", "Landroid/content/Context;", "context", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "ptsNodeVirtual", "Landroid/view/View;", "buildNativeView", "Lcom/tencent/pts/core/PTSAppInstance;", "ptsAppInstance", "buildNodeVirtual", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class Builder implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual ptsNodeVirtual) {
            return new PTSGifView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance ptsAppInstance) {
            return new PTSNodeGif(ptsAppInstance);
        }
    }

    public PTSNodeGif(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "view", "qq-rij-gif");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0093, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(java.lang.String.valueOf(r5));
     */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean setAttribute(String key, Object value) {
        Integer intOrNull;
        QLog.d(VIDEO_TAG, 1, "key:" + key + ",value:" + value);
        if (key != null) {
            switch (key.hashCode()) {
                case -1654132239:
                    if (key.equals("pts-gif:scale-type") && intOrNull != null) {
                        int intValue = intOrNull.intValue();
                        View view = getView();
                        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
                        ((PTSGifView) view).setScaleType(intValue);
                        break;
                    }
                    break;
                case -767755323:
                    if (key.equals("pts-gif:cover-url")) {
                        View view2 = getView();
                        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
                        ((PTSGifView) view2).setCoverUrl(String.valueOf(value));
                        break;
                    }
                    break;
                case -545139630:
                    if (key.equals("pts-gif:gif-url")) {
                        View view3 = getView();
                        Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
                        ((PTSGifView) view3).setGifUrl(String.valueOf(value));
                        break;
                    }
                    break;
                case 1149179075:
                    if (key.equals("pts-gif:need-gif-url")) {
                        View view4 = getView();
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
                        ((PTSGifView) view4).setNeedGifUrl(Intrinsics.areEqual("true", String.valueOf(value)));
                        break;
                    }
                    break;
            }
        }
        return super.setAttribute(key, value);
    }
}
