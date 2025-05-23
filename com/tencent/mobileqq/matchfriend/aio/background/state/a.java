package com.tencent.mobileqq.matchfriend.aio.background.state;

import android.widget.TextView;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate;
import com.tencent.ttpic.videoshelf.data.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/state/a;", "", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "params", "", "immediate", "", "b", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\n\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "a", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "b", "()Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "pagView", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "c", "()Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "d", "()Landroid/widget/TextView;", "textView", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", Constants.PAG_FILE_PATH, "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;Landroid/widget/TextView;Ljava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.background.state.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class AnimatorParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final PAGViewDelegate pagView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final QUIPolarLightView polarLightView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final TextView textView;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private String pagFilePath;

        public AnimatorParams(PAGViewDelegate pagView, QUIPolarLightView polarLightView, TextView textView, String pagFilePath) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            Intrinsics.checkNotNullParameter(polarLightView, "polarLightView");
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(pagFilePath, "pagFilePath");
            this.pagView = pagView;
            this.polarLightView = polarLightView;
            this.textView = textView;
            this.pagFilePath = pagFilePath;
        }

        /* renamed from: a, reason: from getter */
        public final String getPagFilePath() {
            return this.pagFilePath;
        }

        /* renamed from: b, reason: from getter */
        public final PAGViewDelegate getPagView() {
            return this.pagView;
        }

        /* renamed from: c, reason: from getter */
        public final QUIPolarLightView getPolarLightView() {
            return this.polarLightView;
        }

        /* renamed from: d, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pagFilePath = str;
        }

        public int hashCode() {
            return (((((this.pagView.hashCode() * 31) + this.polarLightView.hashCode()) * 31) + this.textView.hashCode()) * 31) + this.pagFilePath.hashCode();
        }

        public String toString() {
            return "AnimatorParams(pagView=" + this.pagView + ", polarLightView=" + this.polarLightView + ", textView=" + this.textView + ", pagFilePath=" + this.pagFilePath + ")";
        }

        public /* synthetic */ AnimatorParams(PAGViewDelegate pAGViewDelegate, QUIPolarLightView qUIPolarLightView, TextView textView, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(pAGViewDelegate, qUIPolarLightView, textView, (i3 & 8) != 0 ? "" : str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimatorParams)) {
                return false;
            }
            AnimatorParams animatorParams = (AnimatorParams) other;
            return Intrinsics.areEqual(this.pagView, animatorParams.pagView) && Intrinsics.areEqual(this.polarLightView, animatorParams.polarLightView) && Intrinsics.areEqual(this.textView, animatorParams.textView) && Intrinsics.areEqual(this.pagFilePath, animatorParams.pagFilePath);
        }
    }

    void a(AnimatorParams params);

    void b(BaseMutualMarkAIOBackgroundProxy.f state, AnimatorParams params, boolean immediate);
}
