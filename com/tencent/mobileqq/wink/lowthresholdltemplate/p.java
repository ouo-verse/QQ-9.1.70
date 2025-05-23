package com.tencent.mobileqq.wink.lowthresholdltemplate;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u0003\b\u0010\u0012B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b\b\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$d;", "b", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$d;", "e", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$d;", "i", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$d;)V", "uiConfig", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;", "c", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;", "d", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;", tl.h.F, "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;)V", "templateConfig", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$b;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$b;", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$b;", "g", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$b;)V", "publishConfig", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$a;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$a;", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$a;", "f", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$a;)V", "performanceConfig", "<init>", "(Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fromType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public UIConfig uiConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public TemplateConfig templateConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public PublishConfig publishConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PerformanceConfig performanceConfig;

    public p(@NotNull String fromType) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        this.fromType = fromType;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFromType() {
        return this.fromType;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final PerformanceConfig getPerformanceConfig() {
        return this.performanceConfig;
    }

    @NotNull
    public final PublishConfig c() {
        PublishConfig publishConfig = this.publishConfig;
        if (publishConfig != null) {
            return publishConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("publishConfig");
        return null;
    }

    @NotNull
    public final TemplateConfig d() {
        TemplateConfig templateConfig = this.templateConfig;
        if (templateConfig != null) {
            return templateConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateConfig");
        return null;
    }

    @NotNull
    public final UIConfig e() {
        UIConfig uIConfig = this.uiConfig;
        if (uIConfig != null) {
            return uIConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        return null;
    }

    public final void f(@Nullable PerformanceConfig performanceConfig) {
        this.performanceConfig = performanceConfig;
    }

    public final void g(@NotNull PublishConfig publishConfig) {
        Intrinsics.checkNotNullParameter(publishConfig, "<set-?>");
        this.publishConfig = publishConfig;
    }

    public final void h(@NotNull TemplateConfig templateConfig) {
        Intrinsics.checkNotNullParameter(templateConfig, "<set-?>");
        this.templateConfig = templateConfig;
    }

    public final void i(@NotNull UIConfig uIConfig) {
        Intrinsics.checkNotNullParameter(uIConfig, "<set-?>");
        this.uiConfig = uIConfig;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "getCustomTopic", "customTopic", "c", "getCustomTitle", "customTitle", "d", "Z", "()Z", "needSaveToMedia", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.p$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class PublishConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String taskId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String customTopic;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String customTitle;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needSaveToMedia;

        public PublishConfig(@NotNull String taskId, @Nullable String str, @Nullable String str2, boolean z16) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            this.taskId = taskId;
            this.customTopic = str;
            this.customTitle = str2;
            this.needSaveToMedia = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedSaveToMedia() {
            return this.needSaveToMedia;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PublishConfig)) {
                return false;
            }
            PublishConfig publishConfig = (PublishConfig) other;
            if (Intrinsics.areEqual(this.taskId, publishConfig.taskId) && Intrinsics.areEqual(this.customTopic, publishConfig.customTopic) && Intrinsics.areEqual(this.customTitle, publishConfig.customTitle) && this.needSaveToMedia == publishConfig.needSaveToMedia) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.taskId.hashCode() * 31;
            String str = this.customTopic;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            String str2 = this.customTitle;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            int i17 = (i16 + i3) * 31;
            boolean z16 = this.needSaveToMedia;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            return i17 + i18;
        }

        @NotNull
        public String toString() {
            return "PublishConfig(taskId=" + this.taskId + ", customTopic=" + this.customTopic + ", customTitle=" + this.customTitle + ", needSaveToMedia=" + this.needSaveToMedia + ")";
        }

        public /* synthetic */ PublishConfig(String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012(\b\u0002\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f\u0012(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR7\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R7\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "DTPageId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "e", "()Ljava/util/HashMap;", "DTPageParamsMap", "c", "DTExtraParamsMap", "g", "PKNoPublishClickCountKey", "f", "PKLastShowTimeKey", "DENGTALoadResultTimeKey", "DENGTAPlayReadyTimeKey", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.p$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class PerformanceConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String DTPageId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final HashMap<String, Object> DTPageParamsMap;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final HashMap<String, Object> DTExtraParamsMap;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String PKNoPublishClickCountKey;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String PKLastShowTimeKey;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String DENGTALoadResultTimeKey;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String DENGTAPlayReadyTimeKey;

        public PerformanceConfig(@NotNull String DTPageId, @Nullable HashMap<String, Object> hashMap, @Nullable HashMap<String, Object> hashMap2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(DTPageId, "DTPageId");
            this.DTPageId = DTPageId;
            this.DTPageParamsMap = hashMap;
            this.DTExtraParamsMap = hashMap2;
            this.PKNoPublishClickCountKey = str;
            this.PKLastShowTimeKey = str2;
            this.DENGTALoadResultTimeKey = str3;
            this.DENGTAPlayReadyTimeKey = str4;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getDENGTALoadResultTimeKey() {
            return this.DENGTALoadResultTimeKey;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getDENGTAPlayReadyTimeKey() {
            return this.DENGTAPlayReadyTimeKey;
        }

        @Nullable
        public final HashMap<String, Object> c() {
            return this.DTExtraParamsMap;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getDTPageId() {
            return this.DTPageId;
        }

        @Nullable
        public final HashMap<String, Object> e() {
            return this.DTPageParamsMap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PerformanceConfig)) {
                return false;
            }
            PerformanceConfig performanceConfig = (PerformanceConfig) other;
            if (Intrinsics.areEqual(this.DTPageId, performanceConfig.DTPageId) && Intrinsics.areEqual(this.DTPageParamsMap, performanceConfig.DTPageParamsMap) && Intrinsics.areEqual(this.DTExtraParamsMap, performanceConfig.DTExtraParamsMap) && Intrinsics.areEqual(this.PKNoPublishClickCountKey, performanceConfig.PKNoPublishClickCountKey) && Intrinsics.areEqual(this.PKLastShowTimeKey, performanceConfig.PKLastShowTimeKey) && Intrinsics.areEqual(this.DENGTALoadResultTimeKey, performanceConfig.DENGTALoadResultTimeKey) && Intrinsics.areEqual(this.DENGTAPlayReadyTimeKey, performanceConfig.DENGTAPlayReadyTimeKey)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getPKLastShowTimeKey() {
            return this.PKLastShowTimeKey;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final String getPKNoPublishClickCountKey() {
            return this.PKNoPublishClickCountKey;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6 = this.DTPageId.hashCode() * 31;
            HashMap<String, Object> hashMap = this.DTPageParamsMap;
            int i3 = 0;
            if (hashMap == null) {
                hashCode = 0;
            } else {
                hashCode = hashMap.hashCode();
            }
            int i16 = (hashCode6 + hashCode) * 31;
            HashMap<String, Object> hashMap2 = this.DTExtraParamsMap;
            if (hashMap2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = hashMap2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str = this.PKNoPublishClickCountKey;
            if (str == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str2 = this.PKLastShowTimeKey;
            if (str2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str2.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str3 = this.DENGTALoadResultTimeKey;
            if (str3 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str3.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str4 = this.DENGTAPlayReadyTimeKey;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            return "PerformanceConfig(DTPageId=" + this.DTPageId + ", DTPageParamsMap=" + this.DTPageParamsMap + ", DTExtraParamsMap=" + this.DTExtraParamsMap + ", PKNoPublishClickCountKey=" + this.PKNoPublishClickCountKey + ", PKLastShowTimeKey=" + this.PKLastShowTimeKey + ", DENGTALoadResultTimeKey=" + this.DENGTALoadResultTimeKey + ", DENGTAPlayReadyTimeKey=" + this.DENGTAPlayReadyTimeKey + ")";
        }

        public /* synthetic */ PerformanceConfig(String str, HashMap hashMap, HashMap hashMap2, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : hashMap, (i3 & 4) != 0 ? null : hashMap2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) == 0 ? str5 : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\u001c\b\u0002\u0010#\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\"\u0018\u00010\u001d\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u0014\u0010 R+\u0010#\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\"\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b\u0010\u0010 R%\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\t\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "templateId", "b", "categoryId", "c", "e", "subCategoryId", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateProjectScene;", "d", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateProjectScene;", "getProjectId", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateProjectScene;", "projectId", "Z", "g", "()Z", "isRandomTemplate", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "Lkotlin/Pair;", "loadToLocalMediaList", "", tl.h.F, "Ljava/util/Map;", "()Ljava/util/Map;", "assetDataMap", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateProjectScene;ZLjava/util/List;Ljava/util/List;Ljava/util/Map;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.p$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class TemplateConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String templateId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String categoryId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String subCategoryId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WinkTemplateProjectScene projectId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isRandomTemplate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<LocalMediaInfo> mediaList;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<Pair<String, String>> loadToLocalMediaList;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Map<String, String> assetDataMap;

        /* JADX WARN: Multi-variable type inference failed */
        public TemplateConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull WinkTemplateProjectScene projectId, boolean z16, @Nullable List<? extends LocalMediaInfo> list, @Nullable List<Pair<String, String>> list2, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(projectId, "projectId");
            this.templateId = str;
            this.categoryId = str2;
            this.subCategoryId = str3;
            this.projectId = projectId;
            this.isRandomTemplate = z16;
            this.mediaList = list;
            this.loadToLocalMediaList = list2;
            this.assetDataMap = map;
        }

        @Nullable
        public final Map<String, String> a() {
            return this.assetDataMap;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getCategoryId() {
            return this.categoryId;
        }

        @Nullable
        public final List<Pair<String, String>> c() {
            return this.loadToLocalMediaList;
        }

        @Nullable
        public final List<LocalMediaInfo> d() {
            return this.mediaList;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getSubCategoryId() {
            return this.subCategoryId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TemplateConfig)) {
                return false;
            }
            TemplateConfig templateConfig = (TemplateConfig) other;
            if (Intrinsics.areEqual(this.templateId, templateConfig.templateId) && Intrinsics.areEqual(this.categoryId, templateConfig.categoryId) && Intrinsics.areEqual(this.subCategoryId, templateConfig.subCategoryId) && this.projectId == templateConfig.projectId && this.isRandomTemplate == templateConfig.isRandomTemplate && Intrinsics.areEqual(this.mediaList, templateConfig.mediaList) && Intrinsics.areEqual(this.loadToLocalMediaList, templateConfig.loadToLocalMediaList) && Intrinsics.areEqual(this.assetDataMap, templateConfig.assetDataMap)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getTemplateId() {
            return this.templateId;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsRandomTemplate() {
            return this.isRandomTemplate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            String str = this.templateId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.categoryId;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.subCategoryId;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int hashCode6 = (((i17 + hashCode3) * 31) + this.projectId.hashCode()) * 31;
            boolean z16 = this.isRandomTemplate;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            int i19 = (hashCode6 + i18) * 31;
            List<LocalMediaInfo> list = this.mediaList;
            if (list == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = list.hashCode();
            }
            int i26 = (i19 + hashCode4) * 31;
            List<Pair<String, String>> list2 = this.loadToLocalMediaList;
            if (list2 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = list2.hashCode();
            }
            int i27 = (i26 + hashCode5) * 31;
            Map<String, String> map = this.assetDataMap;
            if (map != null) {
                i3 = map.hashCode();
            }
            return i27 + i3;
        }

        @NotNull
        public String toString() {
            return "TemplateConfig(templateId=" + this.templateId + ", categoryId=" + this.categoryId + ", subCategoryId=" + this.subCategoryId + ", projectId=" + this.projectId + ", isRandomTemplate=" + this.isRandomTemplate + ", mediaList=" + this.mediaList + ", loadToLocalMediaList=" + this.loadToLocalMediaList + ", assetDataMap=" + this.assetDataMap + ")";
        }

        public /* synthetic */ TemplateConfig(String str, String str2, String str3, WinkTemplateProjectScene winkTemplateProjectScene, boolean z16, List list, List list2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? HippyQQConstants.HIPPY_CHANNEL : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? WinkTemplateProjectScene.EDIT : winkTemplateProjectScene, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? null : list, (i3 & 64) != 0 ? null : list2, (i3 & 128) == 0 ? map : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0019R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\t\u0010\u0019R\u0017\u0010%\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010#\u001a\u0004\b\u001f\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "i", "()I", "windowHeight", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "title", "c", "publishButtonText", "d", "placeholderImageUrl", "e", "Z", "()Z", "saveSyncQzoneStatus", "f", "j", "isSyncQzoneDefaultSelect", "saveSyncQzoneStatusKey", tl.h.F, "publishingToastText", "needHideTitle", "", "J", "()J", "titleValidTime", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZJ)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.p$d, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class UIConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int windowHeight;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String publishButtonText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String placeholderImageUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean saveSyncQzoneStatus;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSyncQzoneDefaultSelect;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String saveSyncQzoneStatusKey;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String publishingToastText;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needHideTitle;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private final long titleValidTime;

        public UIConfig(int i3, @NotNull String title, @NotNull String publishButtonText, @Nullable String str, boolean z16, boolean z17, @Nullable String str2, @Nullable String str3, boolean z18, long j3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(publishButtonText, "publishButtonText");
            this.windowHeight = i3;
            this.title = title;
            this.publishButtonText = publishButtonText;
            this.placeholderImageUrl = str;
            this.saveSyncQzoneStatus = z16;
            this.isSyncQzoneDefaultSelect = z17;
            this.saveSyncQzoneStatusKey = str2;
            this.publishingToastText = str3;
            this.needHideTitle = z18;
            this.titleValidTime = j3;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedHideTitle() {
            return this.needHideTitle;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPlaceholderImageUrl() {
            return this.placeholderImageUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getPublishButtonText() {
            return this.publishButtonText;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getPublishingToastText() {
            return this.publishingToastText;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getSaveSyncQzoneStatus() {
            return this.saveSyncQzoneStatus;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UIConfig)) {
                return false;
            }
            UIConfig uIConfig = (UIConfig) other;
            if (this.windowHeight == uIConfig.windowHeight && Intrinsics.areEqual(this.title, uIConfig.title) && Intrinsics.areEqual(this.publishButtonText, uIConfig.publishButtonText) && Intrinsics.areEqual(this.placeholderImageUrl, uIConfig.placeholderImageUrl) && this.saveSyncQzoneStatus == uIConfig.saveSyncQzoneStatus && this.isSyncQzoneDefaultSelect == uIConfig.isSyncQzoneDefaultSelect && Intrinsics.areEqual(this.saveSyncQzoneStatusKey, uIConfig.saveSyncQzoneStatusKey) && Intrinsics.areEqual(this.publishingToastText, uIConfig.publishingToastText) && this.needHideTitle == uIConfig.needHideTitle && this.titleValidTime == uIConfig.titleValidTime) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getSaveSyncQzoneStatusKey() {
            return this.saveSyncQzoneStatusKey;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: h, reason: from getter */
        public final long getTitleValidTime() {
            return this.titleValidTime;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3 = ((((this.windowHeight * 31) + this.title.hashCode()) * 31) + this.publishButtonText.hashCode()) * 31;
            String str = this.placeholderImageUrl;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            boolean z16 = this.saveSyncQzoneStatus;
            int i17 = 1;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            int i19 = (i16 + i18) * 31;
            boolean z17 = this.isSyncQzoneDefaultSelect;
            int i26 = z17;
            if (z17 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            String str2 = this.saveSyncQzoneStatusKey;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i28 = (i27 + hashCode2) * 31;
            String str3 = this.publishingToastText;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            int i29 = (i28 + i3) * 31;
            boolean z18 = this.needHideTitle;
            if (!z18) {
                i17 = z18 ? 1 : 0;
            }
            return ((i29 + i17) * 31) + androidx.fragment.app.a.a(this.titleValidTime);
        }

        /* renamed from: i, reason: from getter */
        public final int getWindowHeight() {
            return this.windowHeight;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsSyncQzoneDefaultSelect() {
            return this.isSyncQzoneDefaultSelect;
        }

        @NotNull
        public String toString() {
            return "UIConfig(windowHeight=" + this.windowHeight + ", title=" + this.title + ", publishButtonText=" + this.publishButtonText + ", placeholderImageUrl=" + this.placeholderImageUrl + ", saveSyncQzoneStatus=" + this.saveSyncQzoneStatus + ", isSyncQzoneDefaultSelect=" + this.isSyncQzoneDefaultSelect + ", saveSyncQzoneStatusKey=" + this.saveSyncQzoneStatusKey + ", publishingToastText=" + this.publishingToastText + ", needHideTitle=" + this.needHideTitle + ", titleValidTime=" + this.titleValidTime + ")";
        }

        public /* synthetic */ UIConfig(int i3, String str, String str2, String str3, boolean z16, boolean z17, String str4, String str5, boolean z18, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, str2, (i16 & 8) != 0 ? null : str3, (i16 & 16) != 0 ? true : z16, (i16 & 32) != 0 ? false : z17, (i16 & 64) != 0 ? null : str4, (i16 & 128) != 0 ? null : str5, (i16 & 256) != 0 ? false : z18, (i16 & 512) != 0 ? 3000L : j3);
        }
    }
}
