package com.tencent.mobileqq.guild.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/guild/config/aa;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/guild/config/aa;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "ConfigBeanDTO", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class QQGuildShareConfigProcessor extends com.tencent.mobileqq.config.l<QQGuildShareConfigBean> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor$ConfigBeanDTO;", "Ljava/io/Serializable;", "time", "", "kaNavigateUrl", "", "kaShouldNavigate", "", "(JLjava/lang/String;Z)V", "getKaNavigateUrl", "()Ljava/lang/String;", "getKaShouldNavigate", "()Z", "getTime", "()J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class ConfigBeanDTO implements Serializable {

        @SerializedName("kaNavigateUrl")
        @NotNull
        private final String kaNavigateUrl;

        @SerializedName("kaShouldNavigate")
        private final boolean kaShouldNavigate;

        @SerializedName("time")
        private final long time;

        public ConfigBeanDTO() {
            this(0L, null, false, 7, null);
        }

        public static /* synthetic */ ConfigBeanDTO copy$default(ConfigBeanDTO configBeanDTO, long j3, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = configBeanDTO.time;
            }
            if ((i3 & 2) != 0) {
                str = configBeanDTO.kaNavigateUrl;
            }
            if ((i3 & 4) != 0) {
                z16 = configBeanDTO.kaShouldNavigate;
            }
            return configBeanDTO.copy(j3, str, z16);
        }

        /* renamed from: component1, reason: from getter */
        public final long getTime() {
            return this.time;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getKaNavigateUrl() {
            return this.kaNavigateUrl;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getKaShouldNavigate() {
            return this.kaShouldNavigate;
        }

        @NotNull
        public final ConfigBeanDTO copy(long time, @NotNull String kaNavigateUrl, boolean kaShouldNavigate) {
            Intrinsics.checkNotNullParameter(kaNavigateUrl, "kaNavigateUrl");
            return new ConfigBeanDTO(time, kaNavigateUrl, kaShouldNavigate);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigBeanDTO)) {
                return false;
            }
            ConfigBeanDTO configBeanDTO = (ConfigBeanDTO) other;
            if (this.time == configBeanDTO.time && Intrinsics.areEqual(this.kaNavigateUrl, configBeanDTO.kaNavigateUrl) && this.kaShouldNavigate == configBeanDTO.kaShouldNavigate) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getKaNavigateUrl() {
            return this.kaNavigateUrl;
        }

        public final boolean getKaShouldNavigate() {
            return this.kaShouldNavigate;
        }

        public final long getTime() {
            return this.time;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((androidx.fragment.app.a.a(this.time) * 31) + this.kaNavigateUrl.hashCode()) * 31;
            boolean z16 = this.kaShouldNavigate;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "ConfigBeanDTO(time=" + this.time + ", kaNavigateUrl=" + this.kaNavigateUrl + ", kaShouldNavigate=" + this.kaShouldNavigate + ")";
        }

        public ConfigBeanDTO(long j3, @NotNull String kaNavigateUrl, boolean z16) {
            Intrinsics.checkNotNullParameter(kaNavigateUrl, "kaNavigateUrl");
            this.time = j3;
            this.kaNavigateUrl = kaNavigateUrl;
            this.kaShouldNavigate = z16;
        }

        public /* synthetic */ ConfigBeanDTO(long j3, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z16);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor$a;", "", "Lcom/google/gson/Gson;", "gson", "Lcom/tencent/mobileqq/config/ai;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor$ConfigBeanDTO;", "b", "", "TAG", "Ljava/lang/String;", "", "TASK_ID", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.QQGuildShareConfigProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ConfigBeanDTO b(Gson gson, ai item) {
            try {
                return (ConfigBeanDTO) gson.fromJson(item.f202268b, ConfigBeanDTO.class);
            } catch (JsonSyntaxException e16) {
                QLog.e("Guild.config.QQGuildShareConfigProcessor", 1, "Parse TaskId: " + item.f202267a + " Error!", e16);
                return null;
            }
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QQGuildShareConfigBean migrateOldOrDefaultContent(int type) {
        return new QQGuildShareConfigBean(false, null, 3, null);
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QQGuildShareConfigBean onParsed(@NotNull ai[] confFiles) {
        Intrinsics.checkNotNullParameter(confFiles, "confFiles");
        Gson gson = new GsonBuilder().create();
        long j3 = Long.MIN_VALUE;
        QQGuildShareConfigBean qQGuildShareConfigBean = null;
        for (ai aiVar : confFiles) {
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(gson, "gson");
            ConfigBeanDTO b16 = companion.b(gson, aiVar);
            if (b16 != null && b16.getTime() > j3) {
                j3 = b16.getTime();
                qQGuildShareConfigBean = new QQGuildShareConfigBean(b16.getKaShouldNavigate(), b16.getKaNavigateUrl());
            }
        }
        if (qQGuildShareConfigBean == null) {
            qQGuildShareConfigBean = new QQGuildShareConfigBean(false, null, 3, null);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildShareConfigProcessor", 2, "onParsed result: " + qQGuildShareConfigBean);
        }
        QQGuildShareConfigBean.INSTANCE.a(qQGuildShareConfigBean);
        return qQGuildShareConfigBean;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@Nullable QQGuildShareConfigBean newConf) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildShareConfigProcessor", 2, "onUpdate: " + newConf);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<QQGuildShareConfigBean> clazz() {
        return QQGuildShareConfigBean.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return MiniReportManager.EventId.SDK_EMBEDDED_VIDEO;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
    }
}
