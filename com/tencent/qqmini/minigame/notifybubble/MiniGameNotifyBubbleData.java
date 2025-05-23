package com.tencent.qqmini.minigame.notifybubble;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u0012\b\b\u0002\u0010<\u001a\u00020\u0004\u00a2\u0006\u0004\b=\u0010>J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0011\u0010!\"\u0004\b\"\u0010#R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b\t\u0010!\"\u0004\b%\u0010#R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010 \u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b+\u0010#R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b\u0018\u0010!\"\u0004\b-\u0010#R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b'\u0010!\"\u0004\b0\u0010#R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b/\u0010!\"\u0004\b3\u0010#R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0019\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\"\u00108\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0019\u001a\u0004\b2\u0010\u001b\"\u0004\b;\u0010\u001d\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqmini/minigame/notifybubble/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "l", "()Z", "setValid", "(Z)V", AppConstants.Key.COLUMN_IS_VALID, "", "b", "J", "g", "()J", "setInterval", "(J)V", WidgetCacheConstellationData.INTERVAL, "c", "I", "e", "()I", "setBubbleType", "(I)V", "bubbleType", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "setBigBubbleTitle", "(Ljava/lang/String;)V", "bigBubbleTitle", "setBigBubbleSubTitle", "bigBubbleSubTitle", "f", h.F, "setSmallBubbleTitle", "smallBubbleTitle", "setBubbleIcon", "bubbleIcon", "setBubbleClickSchema", "bubbleClickSchema", "i", "setClosePopupText", "closePopupText", "j", "setTaskId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "k", "setTaskType", "taskType", "isTaskFinish", "setTaskFinish", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setTaskProgress", "taskProgress", "<init>", "(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZI)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.minigame.notifybubble.a, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class MiniGameNotifyBubbleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isValid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long interval;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int bubbleType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String bigBubbleTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String bigBubbleSubTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String smallBubbleTitle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String bubbleIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String bubbleClickSchema;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String closePopupText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String taskId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int taskType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isTaskFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int taskProgress;

    public MiniGameNotifyBubbleData() {
        this(false, 0L, 0, null, null, null, null, null, null, null, 0, false, 0, InitSkin.DRAWABLE_COUNT, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getBigBubbleSubTitle() {
        return this.bigBubbleSubTitle;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getBigBubbleTitle() {
        return this.bigBubbleTitle;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getBubbleClickSchema() {
        return this.bubbleClickSchema;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getBubbleIcon() {
        return this.bubbleIcon;
    }

    /* renamed from: e, reason: from getter */
    public final int getBubbleType() {
        return this.bubbleType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MiniGameNotifyBubbleData) {
                MiniGameNotifyBubbleData miniGameNotifyBubbleData = (MiniGameNotifyBubbleData) other;
                if (this.isValid != miniGameNotifyBubbleData.isValid || this.interval != miniGameNotifyBubbleData.interval || this.bubbleType != miniGameNotifyBubbleData.bubbleType || !Intrinsics.areEqual(this.bigBubbleTitle, miniGameNotifyBubbleData.bigBubbleTitle) || !Intrinsics.areEqual(this.bigBubbleSubTitle, miniGameNotifyBubbleData.bigBubbleSubTitle) || !Intrinsics.areEqual(this.smallBubbleTitle, miniGameNotifyBubbleData.smallBubbleTitle) || !Intrinsics.areEqual(this.bubbleIcon, miniGameNotifyBubbleData.bubbleIcon) || !Intrinsics.areEqual(this.bubbleClickSchema, miniGameNotifyBubbleData.bubbleClickSchema) || !Intrinsics.areEqual(this.closePopupText, miniGameNotifyBubbleData.closePopupText) || !Intrinsics.areEqual(this.taskId, miniGameNotifyBubbleData.taskId) || this.taskType != miniGameNotifyBubbleData.taskType || this.isTaskFinish != miniGameNotifyBubbleData.isTaskFinish || this.taskProgress != miniGameNotifyBubbleData.taskProgress) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getClosePopupText() {
        return this.closePopupText;
    }

    /* renamed from: g, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getSmallBubbleTitle() {
        return this.smallBubbleTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        boolean z16 = this.isValid;
        int i27 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        long j3 = this.interval;
        int i28 = ((((r06 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.bubbleType) * 31;
        String str = this.bigBubbleTitle;
        int i29 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i36 = (i28 + i3) * 31;
        String str2 = this.bigBubbleSubTitle;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i37 = (i36 + i16) * 31;
        String str3 = this.smallBubbleTitle;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i38 = (i37 + i17) * 31;
        String str4 = this.bubbleIcon;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i39 = (i38 + i18) * 31;
        String str5 = this.bubbleClickSchema;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i46 = (i39 + i19) * 31;
        String str6 = this.closePopupText;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i47 = (i46 + i26) * 31;
        String str7 = this.taskId;
        if (str7 != null) {
            i29 = str7.hashCode();
        }
        int i48 = (((i47 + i29) * 31) + this.taskType) * 31;
        boolean z17 = this.isTaskFinish;
        if (!z17) {
            i27 = z17 ? 1 : 0;
        }
        return ((i48 + i27) * 31) + this.taskProgress;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: j, reason: from getter */
    public final int getTaskProgress() {
        return this.taskProgress;
    }

    /* renamed from: k, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    @NotNull
    public String toString() {
        return "MiniGameNotifyBubbleData(isValid=" + this.isValid + ", interval=" + this.interval + ", bubbleType=" + this.bubbleType + ", bigBubbleTitle=" + this.bigBubbleTitle + ", bigBubbleSubTitle=" + this.bigBubbleSubTitle + ", smallBubbleTitle=" + this.smallBubbleTitle + ", bubbleIcon=" + this.bubbleIcon + ", bubbleClickSchema=" + this.bubbleClickSchema + ", closePopupText=" + this.closePopupText + ", taskId=" + this.taskId + ", taskType=" + this.taskType + ", isTaskFinish=" + this.isTaskFinish + ", taskProgress=" + this.taskProgress + ")";
    }

    public MiniGameNotifyBubbleData(boolean z16, long j3, int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i16, boolean z17, int i17) {
        this.isValid = z16;
        this.interval = j3;
        this.bubbleType = i3;
        this.bigBubbleTitle = str;
        this.bigBubbleSubTitle = str2;
        this.smallBubbleTitle = str3;
        this.bubbleIcon = str4;
        this.bubbleClickSchema = str5;
        this.closePopupText = str6;
        this.taskId = str7;
        this.taskType = i16;
        this.isTaskFinish = z17;
        this.taskProgress = i17;
    }

    public /* synthetic */ MiniGameNotifyBubbleData(boolean z16, long j3, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i16, boolean z17, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? false : z16, (i18 & 2) != 0 ? 0L : j3, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? null : str, (i18 & 16) != 0 ? null : str2, (i18 & 32) != 0 ? null : str3, (i18 & 64) != 0 ? null : str4, (i18 & 128) != 0 ? null : str5, (i18 & 256) != 0 ? null : str6, (i18 & 512) == 0 ? str7 : null, (i18 & 1024) != 0 ? 0 : i16, (i18 & 2048) != 0 ? false : z17, (i18 & 4096) == 0 ? i17 : 0);
    }
}
