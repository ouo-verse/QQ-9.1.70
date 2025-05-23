package com.tencent.zplan.meme.model;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.zplan.common.utils.GsonUtil;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lx4.d;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BW\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#B\t\b\u0016\u00a2\u0006\u0004\b\"\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/tencent/zplan/meme/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "type", "I", "getType", "()I", "", "chinLocation", UserInfo.SEX_FEMALE, "getChinLocation", "()F", "gender", "getGender", "topLocation", "getTopLocation", "windowsillLocation", "getWindowsillLocation", "bottomLocation", "getBottomLocation", "recordTimeGetAvatarInfo", "getRecordTimeGetAvatarInfo", "recordTimeCOS", "getRecordTimeCOS", "fps", "getFps", "totalFrameCount", "getTotalFrameCount", "<init>", "(IFIFFFFFII)V", "()V", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.meme.model.e, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class Properties {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("bottomLocation")
    private final float bottomLocation;

    @SerializedName("chinLocation")
    private final float chinLocation;

    @SerializedName("fps")
    private final int fps;

    @SerializedName("gender")
    private final int gender;

    @SerializedName("recordTimeCOS")
    private final float recordTimeCOS;

    @SerializedName("recordTimeGetAvatarInfo")
    private final float recordTimeGetAvatarInfo;

    @SerializedName("topLocation")
    private final float topLocation;

    @SerializedName("totalFrameCount")
    private final int totalFrameCount;

    @SerializedName("type")
    private final int type;

    @SerializedName("windowsillLocation")
    private final float windowsillLocation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/zplan/meme/model/e$a;", "", "", "propertiesString", "Lcom/tencent/zplan/meme/model/e;", "b", "path", "a", "filePath", "", "d", "recordKey", "c", "", "DEFAULT_FPS", "I", "DEFAULT_REAL_COUNT", "PROPERTIES", "Ljava/lang/String;", "TAG", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.model.e$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final Properties a(@NotNull String path) {
            String str;
            BufferedReader bufferedReader;
            Intrinsics.checkNotNullParameter(path, "path");
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            File file = new File(path);
            if (!file.exists() || !file.isFile()) {
                return null;
            }
            boolean z16 = true;
            try {
                Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                try {
                    str = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                } finally {
                }
            } catch (Throwable th5) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("[zplan][Properties]", 1, "properties fromFilePath readText error", th5);
                }
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            return b(str);
        }

        @Nullable
        public final Properties b(@NotNull String propertiesString) {
            boolean z16;
            Intrinsics.checkNotNullParameter(propertiesString, "propertiesString");
            if (propertiesString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            try {
                return (Properties) GsonUtil.f385283b.a().fromJson(propertiesString, Properties.class);
            } catch (JsonSyntaxException e16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 == null) {
                    return null;
                }
                a16.e("[zplan][Properties]", 1, "fromString exception, " + propertiesString + TokenParser.SP, e16);
                return null;
            }
        }

        @NotNull
        public final String c(@NotNull String recordKey) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            return Constant.f385743c.a() + "/.properties/" + recordKey + "_properties";
        }

        public final boolean d(@NotNull String filePath, @NotNull String propertiesString) {
            boolean z16;
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(propertiesString, "propertiesString");
            boolean z17 = false;
            if (filePath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.b(a16, "[zplan][Properties]", 1, "save properties to file error, path empty.", null, 8, null);
                }
                return false;
            }
            File file = new File(filePath);
            if (file.exists()) {
                lx4.d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, "[zplan][Properties]", 1, "already have cache file, delete.", null, 8, null);
                }
                file.delete();
            }
            com.tencent.zplan.common.utils.c.f385288a.c(filePath);
            FileWriter fileWriter = new FileWriter(file);
            try {
                try {
                    fileWriter.write(propertiesString);
                    fileWriter.flush();
                    try {
                        lx4.d a18 = LogUtil.f385285b.a();
                        if (a18 != null) {
                            d.a.c(a18, "[zplan][Properties]", 1, "save file success. " + file.getAbsolutePath(), null, 8, null);
                        }
                        return true;
                    } catch (Exception e16) {
                        e = e16;
                        z17 = true;
                        lx4.d a19 = LogUtil.f385285b.a();
                        if (a19 != null) {
                            a19.e("[zplan][Properties]", 1, "save properties to file error, " + file.getAbsolutePath(), e);
                        }
                        fileWriter.close();
                        return z17;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } finally {
                fileWriter.close();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Properties(int i3, float f16, int i16, float f17, float f18, float f19, float f26, float f27, int i17, int i18) {
        this.type = i3;
        this.chinLocation = f16;
        this.gender = i16;
        this.topLocation = f17;
        this.windowsillLocation = f18;
        this.bottomLocation = f19;
        this.recordTimeGetAvatarInfo = f26;
        this.recordTimeCOS = f27;
        this.fps = i17;
        this.totalFrameCount = i18;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Properties) {
                Properties properties = (Properties) other;
                if (this.type != properties.type || Float.compare(this.chinLocation, properties.chinLocation) != 0 || this.gender != properties.gender || Float.compare(this.topLocation, properties.topLocation) != 0 || Float.compare(this.windowsillLocation, properties.windowsillLocation) != 0 || Float.compare(this.bottomLocation, properties.bottomLocation) != 0 || Float.compare(this.recordTimeGetAvatarInfo, properties.recordTimeGetAvatarInfo) != 0 || Float.compare(this.recordTimeCOS, properties.recordTimeCOS) != 0 || this.fps != properties.fps || this.totalFrameCount != properties.totalFrameCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((this.type * 31) + Float.floatToIntBits(this.chinLocation)) * 31) + this.gender) * 31) + Float.floatToIntBits(this.topLocation)) * 31) + Float.floatToIntBits(this.windowsillLocation)) * 31) + Float.floatToIntBits(this.bottomLocation)) * 31) + Float.floatToIntBits(this.recordTimeGetAvatarInfo)) * 31) + Float.floatToIntBits(this.recordTimeCOS)) * 31) + this.fps) * 31) + this.totalFrameCount;
    }

    @NotNull
    public String toString() {
        return "Properties(type=" + this.type + ", chinLocation=" + this.chinLocation + ", gender=" + this.gender + ", topLocation=" + this.topLocation + ", windowsillLocation=" + this.windowsillLocation + ", bottomLocation=" + this.bottomLocation + ", recordTimeGetAvatarInfo=" + this.recordTimeGetAvatarInfo + ", recordTimeCOS=" + this.recordTimeCOS + ", fps=" + this.fps + ", totalFrameCount=" + this.totalFrameCount + ")";
    }

    public Properties() {
        this(0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 30, 0);
    }
}
