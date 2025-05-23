package com.tencent.mobileqq.activity.qcircle.bubble;

import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import qqcircle.QQCircleCounterStyle$StyleBubble;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0002\n\u0011BC\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\n\u0010\u0014R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u0011\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/activity/qcircle/bubble/IconType;", "a", "Lcom/tencent/mobileqq/activity/qcircle/bubble/IconType;", "d", "()Lcom/tencent/mobileqq/activity/qcircle/bubble/IconType;", "iconType", "", "Lcom/tencent/mobileqq/activity/qcircle/bubble/k$b;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "iconInfoList", "Lcom/tencent/mobileqq/activity/qcircle/bubble/g;", "contentElementList", "Lqqcircle/QQCircleCounterMsg$RedDisplayInfo;", "e", "qCircleBubbleAvatarList", "", "J", "()J", "expiredTime", "<init>", "(Lcom/tencent/mobileqq/activity/qcircle/bubble/IconType;Ljava/util/List;Ljava/util/List;Ljava/util/List;J)V", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.activity.qcircle.bubble.k, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class QCircleTabRedPointBubbleInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IconType iconType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IconInfo> iconInfoList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<QCircleTabRedPointBubbleContentElement> contentElementList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<QQCircleCounterMsg$RedDisplayInfo> qCircleBubbleAvatarList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long expiredTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/k$a;", "", "Lqqcircle/QQCircleCounterStyle$StyleBubble;", "styleBubble", "", "Landroid/graphics/drawable/Drawable;", "iconList", "Lqqcircle/QQCircleCounterMsg$RedDisplayInfo;", "redDisplayInfoList", "Lcom/tencent/mobileqq/activity/qcircle/bubble/k;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.qcircle.bubble.k$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final QCircleTabRedPointBubbleInfo a(@NotNull QQCircleCounterStyle$StyleBubble styleBubble, @NotNull List<? extends Drawable> iconList, @NotNull List<QQCircleCounterMsg$RedDisplayInfo> redDisplayInfoList) {
            Intrinsics.checkNotNullParameter(styleBubble, "styleBubble");
            Intrinsics.checkNotNullParameter(iconList, "iconList");
            Intrinsics.checkNotNullParameter(redDisplayInfoList, "redDisplayInfoList");
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble = styleBubble.get();
            Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble, "styleBubble.get()");
            IconType d16 = com.tencent.mobileqq.activity.qcircle.utils.d.d(qQCircleCounterStyle$StyleBubble);
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble2 = styleBubble.get();
            Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble2, "styleBubble.get()");
            List<IconInfo> c16 = com.tencent.mobileqq.activity.qcircle.utils.d.c(qQCircleCounterStyle$StyleBubble2, iconList);
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble3 = styleBubble.get();
            Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble3, "styleBubble.get()");
            return new QCircleTabRedPointBubbleInfo(d16, c16, com.tencent.mobileqq.activity.qcircle.utils.d.b(qQCircleCounterStyle$StyleBubble3), redDisplayInfoList, styleBubble.expireTime.get());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/k$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "b", "()Landroid/graphics/drawable/Drawable;", "drawable", "", UserInfo.SEX_FEMALE, "()F", com.tencent.luggage.wxa.c8.c.f123400v, "<init>", "(Landroid/graphics/drawable/Drawable;F)V", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.qcircle.bubble.k$b, reason: from toString */
    /* loaded from: classes10.dex */
    public static final /* data */ class IconInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Drawable drawable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float alpha;

        public IconInfo(@NotNull Drawable drawable, float f16) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.drawable = drawable;
            this.alpha = f16;
        }

        /* renamed from: a, reason: from getter */
        public final float getAlpha() {
            return this.alpha;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IconInfo)) {
                return false;
            }
            IconInfo iconInfo = (IconInfo) other;
            if (Intrinsics.areEqual(this.drawable, iconInfo.drawable) && Float.compare(this.alpha, iconInfo.alpha) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.drawable.hashCode() * 31) + Float.floatToIntBits(this.alpha);
        }

        @NotNull
        public String toString() {
            return "IconInfo(drawable=" + this.drawable + ", alpha=" + this.alpha + ")";
        }
    }

    public QCircleTabRedPointBubbleInfo(@NotNull IconType iconType, @NotNull List<IconInfo> iconInfoList, @NotNull List<QCircleTabRedPointBubbleContentElement> contentElementList, @NotNull List<QQCircleCounterMsg$RedDisplayInfo> qCircleBubbleAvatarList, long j3) {
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Intrinsics.checkNotNullParameter(iconInfoList, "iconInfoList");
        Intrinsics.checkNotNullParameter(contentElementList, "contentElementList");
        Intrinsics.checkNotNullParameter(qCircleBubbleAvatarList, "qCircleBubbleAvatarList");
        this.iconType = iconType;
        this.iconInfoList = iconInfoList;
        this.contentElementList = contentElementList;
        this.qCircleBubbleAvatarList = qCircleBubbleAvatarList;
        this.expiredTime = j3;
    }

    @NotNull
    public final List<QCircleTabRedPointBubbleContentElement> a() {
        return this.contentElementList;
    }

    /* renamed from: b, reason: from getter */
    public final long getExpiredTime() {
        return this.expiredTime;
    }

    @NotNull
    public final List<IconInfo> c() {
        return this.iconInfoList;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final IconType getIconType() {
        return this.iconType;
    }

    @NotNull
    public final List<QQCircleCounterMsg$RedDisplayInfo> e() {
        return this.qCircleBubbleAvatarList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCircleTabRedPointBubbleInfo)) {
            return false;
        }
        QCircleTabRedPointBubbleInfo qCircleTabRedPointBubbleInfo = (QCircleTabRedPointBubbleInfo) other;
        if (this.iconType == qCircleTabRedPointBubbleInfo.iconType && Intrinsics.areEqual(this.iconInfoList, qCircleTabRedPointBubbleInfo.iconInfoList) && Intrinsics.areEqual(this.contentElementList, qCircleTabRedPointBubbleInfo.contentElementList) && Intrinsics.areEqual(this.qCircleBubbleAvatarList, qCircleTabRedPointBubbleInfo.qCircleBubbleAvatarList) && this.expiredTime == qCircleTabRedPointBubbleInfo.expiredTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.iconType.hashCode() * 31) + this.iconInfoList.hashCode()) * 31) + this.contentElementList.hashCode()) * 31) + this.qCircleBubbleAvatarList.hashCode()) * 31) + androidx.fragment.app.a.a(this.expiredTime);
    }

    @NotNull
    public String toString() {
        return "QCircleTabRedPointBubbleInfo(iconType=" + this.iconType + ", iconInfoList=" + this.iconInfoList + ", contentElementList=" + this.contentElementList + ", qCircleBubbleAvatarList=" + this.qCircleBubbleAvatarList + ", expiredTime=" + this.expiredTime + ")";
    }
}
