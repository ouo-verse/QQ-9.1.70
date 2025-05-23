package com.tencent.mobileqq.guild.media.thirdapp;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/a;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "I", "e", "()I", "topPlaceHolder", "b", "leftPlaceHolder", "c", "rightPlaceHolder", "d", "bottomPlaceHolder", "Lcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;", "Lcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;", "()Lcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "<init>", "(IIIILcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.thirdapp.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ContentSize {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int topPlaceHolder;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int leftPlaceHolder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rightPlaceHolder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bottomPlaceHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ScreenMode screenMode;

    public ContentSize(int i3, int i16, int i17, int i18, @NotNull ScreenMode screenMode) {
        Intrinsics.checkNotNullParameter(screenMode, "screenMode");
        this.topPlaceHolder = i3;
        this.leftPlaceHolder = i16;
        this.rightPlaceHolder = i17;
        this.bottomPlaceHolder = i18;
        this.screenMode = screenMode;
    }

    /* renamed from: a, reason: from getter */
    public final int getBottomPlaceHolder() {
        return this.bottomPlaceHolder;
    }

    /* renamed from: b, reason: from getter */
    public final int getLeftPlaceHolder() {
        return this.leftPlaceHolder;
    }

    /* renamed from: c, reason: from getter */
    public final int getRightPlaceHolder() {
        return this.rightPlaceHolder;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ScreenMode getScreenMode() {
        return this.screenMode;
    }

    /* renamed from: e, reason: from getter */
    public final int getTopPlaceHolder() {
        return this.topPlaceHolder;
    }

    public boolean equals(@Nullable Object other) {
        ContentSize contentSize;
        if (other instanceof ContentSize) {
            contentSize = (ContentSize) other;
        } else {
            contentSize = null;
        }
        if (contentSize == null || this.topPlaceHolder != contentSize.topPlaceHolder || this.leftPlaceHolder != contentSize.leftPlaceHolder || this.rightPlaceHolder != contentSize.rightPlaceHolder || this.bottomPlaceHolder != contentSize.bottomPlaceHolder || this.screenMode != contentSize.screenMode) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((this.topPlaceHolder * 31) + this.leftPlaceHolder) * 31) + this.rightPlaceHolder) * 31) + this.bottomPlaceHolder) * 31) + this.screenMode.hashCode();
    }

    @NotNull
    public String toString() {
        return "ContentSize(topPlaceHolder=" + this.topPlaceHolder + ", leftPlaceHolder=" + this.leftPlaceHolder + ", rightPlaceHolder=" + this.rightPlaceHolder + ", bottomPlaceHolder=" + this.bottomPlaceHolder + ", screenMode=" + this.screenMode + ")";
    }
}
