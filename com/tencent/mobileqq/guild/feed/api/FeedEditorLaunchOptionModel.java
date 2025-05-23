package com.tencent.mobileqq.guild.feed.api;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001RB%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\bO\u0010PJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0007\u0010\u0012R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0011\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010(R$\u0010:\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010<\u001a\u0004\bM\u0010>\"\u0004\bN\u0010@\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "isBeyondGuild", "successAction", "feedType", "copy", "", "toString", "hashCode", "", "other", "equals", "Z", "()Z", "I", "getSuccessAction", "()I", "setSuccessAction", "(I)V", "getFeedType", "", "topicId", "Ljava/lang/Long;", "getTopicId", "()Ljava/lang/Long;", "setTopicId", "(Ljava/lang/Long;)V", "topicName", "Ljava/lang/String;", "getTopicName", "()Ljava/lang/String;", "setTopicName", "(Ljava/lang/String;)V", "isDisableDraft", "setDisableDraft", "(Z)V", "enterAnim", "Ljava/lang/Integer;", "getEnterAnim", "()Ljava/lang/Integer;", "setEnterAnim", "(Ljava/lang/Integer;)V", "exitAnim", "getExitAnim", "setExitAnim", "isPanicModeInMediaFilterStep", "setPanicModeInMediaFilterStep", "d", "Ljava/lang/Object;", "getProcessResult", "()Ljava/lang/Object;", "setProcessResult", "(Ljava/lang/Object;)V", "processResult", "showPostFailToast", "Ljava/lang/Boolean;", "getShowPostFailToast", "()Ljava/lang/Boolean;", "setShowPostFailToast", "(Ljava/lang/Boolean;)V", "showPostSuccessToast", "getShowPostSuccessToast", "setShowPostSuccessToast", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "getBackToThirdAppExtras", "()Landroid/os/Bundle;", "setBackToThirdAppExtras", "(Landroid/os/Bundle;)V", "backToThirdAppExtras", "redirectWithNewTask", "getRedirectWithNewTask", "setRedirectWithNewTask", "<init>", "(ZII)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class FeedEditorLaunchOptionModel implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private transient Object processResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private transient Bundle backToThirdAppExtras;

    @Nullable
    private Integer enterAnim;

    @Nullable
    private Integer exitAnim;
    private final int feedType;
    private final boolean isBeyondGuild;
    private boolean isDisableDraft;
    private boolean isPanicModeInMediaFilterStep;

    @Nullable
    private Boolean redirectWithNewTask;

    @Nullable
    private Boolean showPostFailToast;

    @Nullable
    private Boolean showPostSuccessToast;
    private int successAction;

    @Nullable
    private Long topicId;

    @Nullable
    private String topicName;

    public FeedEditorLaunchOptionModel() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ FeedEditorLaunchOptionModel copy$default(FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, boolean z16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            z16 = feedEditorLaunchOptionModel.isBeyondGuild;
        }
        if ((i17 & 2) != 0) {
            i3 = feedEditorLaunchOptionModel.successAction;
        }
        if ((i17 & 4) != 0) {
            i16 = feedEditorLaunchOptionModel.feedType;
        }
        return feedEditorLaunchOptionModel.copy(z16, i3, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsBeyondGuild() {
        return this.isBeyondGuild;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSuccessAction() {
        return this.successAction;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFeedType() {
        return this.feedType;
    }

    @NotNull
    public final FeedEditorLaunchOptionModel copy(boolean isBeyondGuild, int successAction, int feedType) {
        return new FeedEditorLaunchOptionModel(isBeyondGuild, successAction, feedType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedEditorLaunchOptionModel)) {
            return false;
        }
        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel = (FeedEditorLaunchOptionModel) other;
        if (this.isBeyondGuild == feedEditorLaunchOptionModel.isBeyondGuild && this.successAction == feedEditorLaunchOptionModel.successAction && this.feedType == feedEditorLaunchOptionModel.feedType) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Bundle getBackToThirdAppExtras() {
        return this.backToThirdAppExtras;
    }

    @Nullable
    public final Integer getEnterAnim() {
        return this.enterAnim;
    }

    @Nullable
    public final Integer getExitAnim() {
        return this.exitAnim;
    }

    public final int getFeedType() {
        return this.feedType;
    }

    @Nullable
    public final Object getProcessResult() {
        return this.processResult;
    }

    @Nullable
    public final Boolean getRedirectWithNewTask() {
        return this.redirectWithNewTask;
    }

    @Nullable
    public final Boolean getShowPostFailToast() {
        return this.showPostFailToast;
    }

    @Nullable
    public final Boolean getShowPostSuccessToast() {
        return this.showPostSuccessToast;
    }

    public final int getSuccessAction() {
        return this.successAction;
    }

    @Nullable
    public final Long getTopicId() {
        return this.topicId;
    }

    @Nullable
    public final String getTopicName() {
        return this.topicName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isBeyondGuild;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.successAction) * 31) + this.feedType;
    }

    public final boolean isBeyondGuild() {
        return this.isBeyondGuild;
    }

    /* renamed from: isDisableDraft, reason: from getter */
    public final boolean getIsDisableDraft() {
        return this.isDisableDraft;
    }

    /* renamed from: isPanicModeInMediaFilterStep, reason: from getter */
    public final boolean getIsPanicModeInMediaFilterStep() {
        return this.isPanicModeInMediaFilterStep;
    }

    public final void setBackToThirdAppExtras(@Nullable Bundle bundle) {
        this.backToThirdAppExtras = bundle;
    }

    public final void setDisableDraft(boolean z16) {
        this.isDisableDraft = z16;
    }

    public final void setEnterAnim(@Nullable Integer num) {
        this.enterAnim = num;
    }

    public final void setExitAnim(@Nullable Integer num) {
        this.exitAnim = num;
    }

    public final void setPanicModeInMediaFilterStep(boolean z16) {
        this.isPanicModeInMediaFilterStep = z16;
    }

    public final void setProcessResult(@Nullable Object obj) {
        this.processResult = obj;
    }

    public final void setRedirectWithNewTask(@Nullable Boolean bool) {
        this.redirectWithNewTask = bool;
    }

    public final void setShowPostFailToast(@Nullable Boolean bool) {
        this.showPostFailToast = bool;
    }

    public final void setShowPostSuccessToast(@Nullable Boolean bool) {
        this.showPostSuccessToast = bool;
    }

    public final void setSuccessAction(int i3) {
        this.successAction = i3;
    }

    public final void setTopicId(@Nullable Long l3) {
        this.topicId = l3;
    }

    public final void setTopicName(@Nullable String str) {
        this.topicName = str;
    }

    @NotNull
    public String toString() {
        return "FeedEditorLaunchOptionModel(isBeyondGuild=" + this.isBeyondGuild + ", successAction=" + this.successAction + ", feedType=" + this.feedType + ')';
    }

    public FeedEditorLaunchOptionModel(boolean z16, int i3, int i16) {
        this.isBeyondGuild = z16;
        this.successAction = i3;
        this.feedType = i16;
        this.isPanicModeInMediaFilterStep = true;
    }

    public /* synthetic */ FeedEditorLaunchOptionModel(boolean z16, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
    }
}
