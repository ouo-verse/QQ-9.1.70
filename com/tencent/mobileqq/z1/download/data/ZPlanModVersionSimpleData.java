package com.tencent.mobileqq.z1.download.data;

import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pv4.y;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b4\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010*\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "downloadEntity", "", "updateEntityValue", "", "component1", "mapId", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getMapId", "()I", "nowMapVer", "Ljava/lang/String;", "getNowMapVer", "()Ljava/lang/String;", "setNowMapVer", "(Ljava/lang/String;)V", "cosUrl", "getCosUrl", "setCosUrl", "runScript", "getRunScript", "setRunScript", "", "dataSize", "J", "getDataSize", "()J", "setDataSize", "(J)V", "scriptType", "getScriptType", "setScriptType", "(I)V", "md5", "getMd5", "setMd5", "pakMd5", "getPakMd5", "setPakMd5", "packType", "getPackType", "setPackType", "<init>", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ZPlanModVersionSimpleData implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long dataSize;
    private final int mapId;
    private int packType;
    private int scriptType;

    @NotNull
    private String nowMapVer = "";

    @NotNull
    private String cosUrl = "";

    @NotNull
    private String runScript = "";

    @NotNull
    private String md5 = "";

    @NotNull
    private String pakMd5 = "";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData$a;", "", "Lpv4/y;", "verControlInfo", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "b", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "downloadEntity", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ZPlanModVersionSimpleData a(@NotNull ZootopiaDownloadEntity downloadEntity) {
            int i3;
            Integer intOrNull;
            Integer intOrNull2;
            Intrinsics.checkNotNullParameter(downloadEntity, "downloadEntity");
            String str = downloadEntity.zootopiaId;
            int i16 = 0;
            if (str != null && intOrNull2 != null) {
                i3 = intOrNull2.intValue();
            } else {
                i3 = 0;
            }
            ZPlanModVersionSimpleData zPlanModVersionSimpleData = new ZPlanModVersionSimpleData(i3);
            String str2 = downloadEntity.version;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "downloadEntity.version ?: \"\"");
            }
            zPlanModVersionSimpleData.setNowMapVer(str2);
            String str4 = downloadEntity.url;
            if (str4 == null) {
                str4 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "downloadEntity.url ?: \"\"");
            }
            zPlanModVersionSimpleData.setCosUrl(str4);
            String str5 = downloadEntity.runScript;
            if (str5 == null) {
                str5 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "downloadEntity.runScript ?: \"\"");
            }
            zPlanModVersionSimpleData.setRunScript(str5);
            zPlanModVersionSimpleData.setDataSize(downloadEntity.size);
            String scriptType = downloadEntity.scriptType;
            if (scriptType != null) {
                Intrinsics.checkNotNullExpressionValue(scriptType, "scriptType");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(scriptType);
                if (intOrNull != null) {
                    i16 = intOrNull.intValue();
                }
            }
            zPlanModVersionSimpleData.setScriptType(i16);
            String str6 = downloadEntity.md5;
            if (str6 == null) {
                str6 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str6, "downloadEntity.md5 ?: \"\"");
            }
            zPlanModVersionSimpleData.setMd5(str6);
            String str7 = downloadEntity.pakMd5;
            if (str7 != null) {
                Intrinsics.checkNotNullExpressionValue(str7, "downloadEntity.pakMd5 ?: \"\"");
                str3 = str7;
            }
            zPlanModVersionSimpleData.setPakMd5(str3);
            zPlanModVersionSimpleData.setPackType(downloadEntity.packType);
            return zPlanModVersionSimpleData;
        }

        @NotNull
        public final ZPlanModVersionSimpleData b(@NotNull y verControlInfo) {
            Intrinsics.checkNotNullParameter(verControlInfo, "verControlInfo");
            ZPlanModVersionSimpleData zPlanModVersionSimpleData = new ZPlanModVersionSimpleData(verControlInfo.f427728a);
            String str = verControlInfo.f427731d;
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "verControlInfo.nowMapVer ?: \"\"");
            }
            zPlanModVersionSimpleData.setNowMapVer(str);
            String str3 = verControlInfo.f427732e;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "verControlInfo.cosURL ?: \"\"");
            }
            zPlanModVersionSimpleData.setCosUrl(str3);
            String str4 = verControlInfo.f427733f;
            if (str4 == null) {
                str4 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "verControlInfo.runScript ?: \"\"");
            }
            zPlanModVersionSimpleData.setRunScript(str4);
            zPlanModVersionSimpleData.setDataSize(verControlInfo.f427734g);
            zPlanModVersionSimpleData.setScriptType(verControlInfo.f427735h);
            String str5 = verControlInfo.f427738k;
            if (str5 == null) {
                str5 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "verControlInfo.md5 ?: \"\"");
            }
            zPlanModVersionSimpleData.setMd5(str5);
            String str6 = verControlInfo.f427740m;
            if (str6 != null) {
                Intrinsics.checkNotNullExpressionValue(str6, "verControlInfo.pakMd5 ?: \"\"");
                str2 = str6;
            }
            zPlanModVersionSimpleData.setPakMd5(str2);
            zPlanModVersionSimpleData.setPackType(verControlInfo.f427743p);
            return zPlanModVersionSimpleData;
        }

        Companion() {
        }
    }

    public ZPlanModVersionSimpleData(int i3) {
        this.mapId = i3;
    }

    public static /* synthetic */ ZPlanModVersionSimpleData copy$default(ZPlanModVersionSimpleData zPlanModVersionSimpleData, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = zPlanModVersionSimpleData.mapId;
        }
        return zPlanModVersionSimpleData.copy(i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMapId() {
        return this.mapId;
    }

    @NotNull
    public final ZPlanModVersionSimpleData copy(int mapId) {
        return new ZPlanModVersionSimpleData(mapId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ZPlanModVersionSimpleData) && this.mapId == ((ZPlanModVersionSimpleData) other).mapId) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCosUrl() {
        return this.cosUrl;
    }

    public final long getDataSize() {
        return this.dataSize;
    }

    public final int getMapId() {
        return this.mapId;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final String getNowMapVer() {
        return this.nowMapVer;
    }

    public final int getPackType() {
        return this.packType;
    }

    @NotNull
    public final String getPakMd5() {
        return this.pakMd5;
    }

    @NotNull
    public final String getRunScript() {
        return this.runScript;
    }

    public final int getScriptType() {
        return this.scriptType;
    }

    public int hashCode() {
        return this.mapId;
    }

    public final void setCosUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cosUrl = str;
    }

    public final void setDataSize(long j3) {
        this.dataSize = j3;
    }

    public final void setMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void setNowMapVer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nowMapVer = str;
    }

    public final void setPackType(int i3) {
        this.packType = i3;
    }

    public final void setPakMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pakMd5 = str;
    }

    public final void setRunScript(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.runScript = str;
    }

    public final void setScriptType(int i3) {
        this.scriptType = i3;
    }

    @NotNull
    public String toString() {
        return "ZPlanModVersionSimpleData(mapId=" + this.mapId + ')';
    }

    public final void updateEntityValue(@NotNull ZootopiaDownloadEntity downloadEntity) {
        Intrinsics.checkNotNullParameter(downloadEntity, "downloadEntity");
        downloadEntity.version = this.nowMapVer;
        downloadEntity.url = this.cosUrl;
        downloadEntity.runScript = this.runScript;
        downloadEntity.size = this.dataSize;
        downloadEntity.scriptType = String.valueOf(this.scriptType);
        downloadEntity.md5 = this.md5;
        downloadEntity.pakMd5 = this.pakMd5;
        downloadEntity.packType = this.packType;
    }
}
