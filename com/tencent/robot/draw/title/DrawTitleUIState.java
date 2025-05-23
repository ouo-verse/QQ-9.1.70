package com.tencent.robot.draw.title;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/draw/title/DrawTitleUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "TitleBannerState", "Lcom/tencent/robot/draw/title/DrawTitleUIState$TitleBannerState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class DrawTitleUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/draw/title/DrawTitleUIState$TitleBannerState;", "Lcom/tencent/robot/draw/title/DrawTitleUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "e", "c", "url", "f", "a", "tips", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class TitleBannerState extends DrawTitleUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tips;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleBannerState(@NotNull String title, @NotNull String url, @NotNull String tips) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(tips, "tips");
            this.title = title;
            this.url = url;
            this.tips = tips;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTips() {
            return this.tips;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TitleBannerState)) {
                return false;
            }
            TitleBannerState titleBannerState = (TitleBannerState) other;
            if (Intrinsics.areEqual(this.title, titleBannerState.title) && Intrinsics.areEqual(this.url, titleBannerState.url) && Intrinsics.areEqual(this.tips, titleBannerState.tips)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.url.hashCode()) * 31) + this.tips.hashCode();
        }

        @NotNull
        public String toString() {
            return "TitleBannerState(title=" + this.title + ", url=" + this.url + ", tips=" + this.tips + ")";
        }
    }

    public /* synthetic */ DrawTitleUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    DrawTitleUIState() {
    }
}
