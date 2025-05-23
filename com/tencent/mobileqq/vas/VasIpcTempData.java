package com.tencent.mobileqq.vas;

import android.os.Parcelable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J-\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/VasIpcTempData;", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "(Ljava/lang/String;)V", "getBusinessName", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mobileqq/vas/VasMMKVProxy;", "get", "T", "Landroid/os/Parcelable;", "key", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "getBool", "", "default", "getLong", "", "getString", "set", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "value", "setBool", "setLong", "setString", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasIpcTempData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean isMainProcess;

    @NotNull
    private final String businessName;

    @NotNull
    private final VasMMKVProxy mmkv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/VasIpcTempData$Companion;", "", "()V", "isMainProcess", "", "()Z", "getKuikly", "Lcom/tencent/mobileqq/vas/VasIpcTempData;", "getTempVar", "getVipFeedWeb", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VasIpcTempData getKuikly() {
            return new VasIpcTempData("kuikly");
        }

        @JvmStatic
        @NotNull
        public final VasIpcTempData getTempVar() {
            return new VasIpcTempData("temp_var");
        }

        @JvmStatic
        @NotNull
        public final VasIpcTempData getVipFeedWeb() {
            return new VasIpcTempData("vip_feed_web");
        }

        public final boolean isMainProcess() {
            return VasIpcTempData.isMainProcess;
        }

        Companion() {
        }
    }

    static {
        boolean z16;
        try {
            z16 = Intrinsics.areEqual(MobileQQ.processName, BaseApplication.getContext().getPackageName());
        } catch (Exception unused) {
            z16 = false;
        }
        isMainProcess = z16;
        if (z16) {
            VasMMKVProxy ipcData = VasMMKV.INSTANCE.getIpcData();
            ipcData.removeKeyList(ipcData.allKey());
        }
    }

    public VasIpcTempData(@NotNull String businessName) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        this.businessName = businessName;
        this.mmkv = VasMMKV.INSTANCE.getIpcData();
    }

    @JvmStatic
    @NotNull
    public static final VasIpcTempData getKuikly() {
        return INSTANCE.getKuikly();
    }

    @JvmStatic
    @NotNull
    public static final VasIpcTempData getTempVar() {
        return INSTANCE.getTempVar();
    }

    @JvmStatic
    @NotNull
    public static final VasIpcTempData getVipFeedWeb() {
        return INSTANCE.getVipFeedWeb();
    }

    @Nullable
    public final <T extends Parcelable> T get(@NotNull String key, @NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.mmkv.decodeParcelable(this.businessName + key, clazz, null);
    }

    public final boolean getBool(@NotNull String key, boolean r56) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkv.decodeBool(this.businessName + key, r56);
    }

    @NotNull
    public final String getBusinessName() {
        return this.businessName;
    }

    public final long getLong(@NotNull String key, long r56) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkv.decodeLong(this.businessName + key, r56);
    }

    @Nullable
    public final String getString(@NotNull String key, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r56, "default");
        return this.mmkv.decodeString(this.businessName + key, r56);
    }

    @NotNull
    public final MMKVOptionEntity set(@NotNull String key, @NotNull Parcelable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.mmkv.encodeParcelable(this.businessName + key, value);
    }

    @NotNull
    public final MMKVOptionEntity setBool(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkv.encodeBool(this.businessName + key, value);
    }

    @NotNull
    public final MMKVOptionEntity setLong(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkv.encodeLong(this.businessName + key, value);
    }

    @NotNull
    public final MMKVOptionEntity setString(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.mmkv.encodeString(this.businessName + key, value);
    }
}
