package com.tencent.mobileqq.matchfriend.aio.foreground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "model", "", "setData", "Lc51/b;", "d", "Lc51/b;", "binding", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StrangerGainMutualMarkView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c51.b binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrangerGainMutualMarkView(Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void setData(StrangerGainMutualMarkModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.binding.f30343h.setText(model.getDescriptionContent());
        this.binding.f30339d.setText(model.getCongratulationContent());
        this.binding.f30340e.setImageDrawable(URLDrawable.getDrawable(model.getLightResUrl(), (URLDrawable.URLDrawableOptions) null));
        this.binding.f30342g.setImageDrawable(URLDrawable.getFileDrawable(model.getMutualMarkIConPath(), null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrangerGainMutualMarkView(Context ctx, AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ StrangerGainMutualMarkView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\n\u0010\u0015R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010 R\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b\u001a\u0010 R\u0019\u0010(\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getCount", "()J", "count", "b", "getLevel", "level", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "mutualMarkIConPath", "d", "lightResUrl", "descriptionContent", "f", "congratulationContent", "g", "lottieJsonRes", tl.h.F, "Z", "()Z", "needMutualMarkViewTranslationAnimator", "i", "needLottieAnimation", "j", "Ljava/lang/Object;", "getSource", "()Ljava/lang/Object;", "source", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Object;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkView$a, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class StrangerGainMutualMarkModel {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long count;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long level;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String mutualMarkIConPath;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String lightResUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String descriptionContent;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final String congratulationContent;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final String lottieJsonRes;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needMutualMarkViewTranslationAnimator;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needLottieAnimation;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private final Object source;

        public StrangerGainMutualMarkModel(long j3, long j16, String mutualMarkIConPath, String lightResUrl, String descriptionContent, String congratulationContent, String lottieJsonRes, boolean z16, boolean z17, Object obj) {
            Intrinsics.checkNotNullParameter(mutualMarkIConPath, "mutualMarkIConPath");
            Intrinsics.checkNotNullParameter(lightResUrl, "lightResUrl");
            Intrinsics.checkNotNullParameter(descriptionContent, "descriptionContent");
            Intrinsics.checkNotNullParameter(congratulationContent, "congratulationContent");
            Intrinsics.checkNotNullParameter(lottieJsonRes, "lottieJsonRes");
            this.count = j3;
            this.level = j16;
            this.mutualMarkIConPath = mutualMarkIConPath;
            this.lightResUrl = lightResUrl;
            this.descriptionContent = descriptionContent;
            this.congratulationContent = congratulationContent;
            this.lottieJsonRes = lottieJsonRes;
            this.needMutualMarkViewTranslationAnimator = z16;
            this.needLottieAnimation = z17;
            this.source = obj;
        }

        /* renamed from: a, reason: from getter */
        public final String getCongratulationContent() {
            return this.congratulationContent;
        }

        /* renamed from: b, reason: from getter */
        public final String getDescriptionContent() {
            return this.descriptionContent;
        }

        /* renamed from: c, reason: from getter */
        public final String getLightResUrl() {
            return this.lightResUrl;
        }

        /* renamed from: d, reason: from getter */
        public final String getLottieJsonRes() {
            return this.lottieJsonRes;
        }

        /* renamed from: e, reason: from getter */
        public final String getMutualMarkIConPath() {
            return this.mutualMarkIConPath;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getNeedLottieAnimation() {
            return this.needLottieAnimation;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getNeedMutualMarkViewTranslationAnimator() {
            return this.needMutualMarkViewTranslationAnimator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((((((((((g.a(this.count) * 31) + g.a(this.level)) * 31) + this.mutualMarkIConPath.hashCode()) * 31) + this.lightResUrl.hashCode()) * 31) + this.descriptionContent.hashCode()) * 31) + this.congratulationContent.hashCode()) * 31) + this.lottieJsonRes.hashCode()) * 31;
            boolean z16 = this.needMutualMarkViewTranslationAnimator;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (a16 + i3) * 31;
            boolean z17 = this.needLottieAnimation;
            int i17 = (i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
            Object obj = this.source;
            return i17 + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "StrangerGainMutualMarkModel(count=" + this.count + ", level=" + this.level + ", mutualMarkIConPath=" + this.mutualMarkIConPath + ", lightResUrl=" + this.lightResUrl + ", descriptionContent=" + this.descriptionContent + ", congratulationContent=" + this.congratulationContent + ", lottieJsonRes=" + this.lottieJsonRes + ", needMutualMarkViewTranslationAnimator=" + this.needMutualMarkViewTranslationAnimator + ", needLottieAnimation=" + this.needLottieAnimation + ", source=" + this.source + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StrangerGainMutualMarkModel)) {
                return false;
            }
            StrangerGainMutualMarkModel strangerGainMutualMarkModel = (StrangerGainMutualMarkModel) other;
            return this.count == strangerGainMutualMarkModel.count && this.level == strangerGainMutualMarkModel.level && Intrinsics.areEqual(this.mutualMarkIConPath, strangerGainMutualMarkModel.mutualMarkIConPath) && Intrinsics.areEqual(this.lightResUrl, strangerGainMutualMarkModel.lightResUrl) && Intrinsics.areEqual(this.descriptionContent, strangerGainMutualMarkModel.descriptionContent) && Intrinsics.areEqual(this.congratulationContent, strangerGainMutualMarkModel.congratulationContent) && Intrinsics.areEqual(this.lottieJsonRes, strangerGainMutualMarkModel.lottieJsonRes) && this.needMutualMarkViewTranslationAnimator == strangerGainMutualMarkModel.needMutualMarkViewTranslationAnimator && this.needLottieAnimation == strangerGainMutualMarkModel.needLottieAnimation && Intrinsics.areEqual(this.source, strangerGainMutualMarkModel.source);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangerGainMutualMarkView(Context ctx, AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        c51.b f16 = c51.b.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }
}
