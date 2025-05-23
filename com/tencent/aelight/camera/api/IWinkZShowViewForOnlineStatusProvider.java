package com.tencent.aelight.camera.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\b\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$b;", DownloadInfo.spKey_Config, "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$a;", "getLoadingView", "a", "b", "aelight-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IWinkZShowViewForOnlineStatusProvider extends QRouteApi {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$a;", "", "", "show", "Landroid/widget/TextView;", "f0", "hide", "aelight-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public interface a {
        @NotNull
        TextView f0();

        void hide();

        void show();
    }

    @NotNull
    a getLoadingView(@NotNull Context context, @NotNull LoadViewConfig config);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "text", "b", "I", "f", "()I", "textSize", "c", "e", "textColor", "Z", "()Z", "showProgress", "iconSize", "bottomForIcon", "<init>", "(Ljava/lang/String;IIZII)V", "aelight-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider$b, reason: from toString */
    /* loaded from: classes3.dex */
    public static final /* data */ class LoadViewConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int textSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int textColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showProgress;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int iconSize;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bottomForIcon;

        public LoadViewConfig(@NotNull String text, int i3, int i16, boolean z16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.textSize = i3;
            this.textColor = i16;
            this.showProgress = z16;
            this.iconSize = i17;
            this.bottomForIcon = i18;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottomForIcon() {
            return this.bottomForIcon;
        }

        /* renamed from: b, reason: from getter */
        public final int getIconSize() {
            return this.iconSize;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShowProgress() {
            return this.showProgress;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: e, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadViewConfig)) {
                return false;
            }
            LoadViewConfig loadViewConfig = (LoadViewConfig) other;
            if (Intrinsics.areEqual(this.text, loadViewConfig.text) && this.textSize == loadViewConfig.textSize && this.textColor == loadViewConfig.textColor && this.showProgress == loadViewConfig.showProgress && this.iconSize == loadViewConfig.iconSize && this.bottomForIcon == loadViewConfig.bottomForIcon) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.text.hashCode() * 31) + this.textSize) * 31) + this.textColor) * 31;
            boolean z16 = this.showProgress;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((((hashCode + i3) * 31) + this.iconSize) * 31) + this.bottomForIcon;
        }

        @NotNull
        public String toString() {
            return "LoadViewConfig(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", showProgress=" + this.showProgress + ", iconSize=" + this.iconSize + ", bottomForIcon=" + this.bottomForIcon + ')';
        }

        public /* synthetic */ LoadViewConfig(String str, int i3, int i16, boolean z16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i19 & 2) != 0 ? ViewUtils.dip2px(16.0f) : i3, (i19 & 4) != 0 ? -1 : i16, (i19 & 8) != 0 ? false : z16, (i19 & 16) != 0 ? ViewUtils.dpToPx(160.0f) : i17, (i19 & 32) != 0 ? ViewUtils.dpToPx(10.0f) : i18);
        }
    }
}
