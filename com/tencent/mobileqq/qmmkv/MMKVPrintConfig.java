package com.tencent.mobileqq.qmmkv;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0017\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVPrintConfig;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "Lorg/json/JSONObject;", "jsonObj", "", "b", "", "d", "Z", "g", "()Z", "i", "(Z)V", "switchOn", "", "e", "I", "()I", "setFileSizeLimit", "(I)V", "fileSizeLimit", "f", "setLogSizeLimit", "logSizeLimit", tl.h.F, "setValidityTime", "validityTime", "c", "setBackgroundDelaytime", "backgroundDelaytime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "()Ljava/lang/String;", "setMmapId", "(Ljava/lang/String;)V", "mmapId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVPrintConfig implements IConfigData {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<MMKVPrintConfig> D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean switchOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int fileSizeLimit = 16384;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int logSizeLimit = 100;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int validityTime = 480;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int backgroundDelaytime = 30;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mmapId = "";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVPrintConfig$a;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVPrintConfig;", "sConfig$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qmmkv/MMKVPrintConfig;", "sConfig", "", "GROUPID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qmmkv.MMKVPrintConfig$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MMKVPrintConfig a() {
            return (MMKVPrintConfig) MMKVPrintConfig.D.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<MMKVPrintConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVPrintConfig>() { // from class: com.tencent.mobileqq.qmmkv.MMKVPrintConfig$Companion$sConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVPrintConfig invoke() {
                MMKVPrintConfigParser mMKVPrintConfigParser = new MMKVPrintConfigParser();
                MMKVPrintConfig c16 = mMKVPrintConfigParser.c();
                c16.i(mMKVPrintConfigParser.isSwitchOn(false));
                QLog.d("MMKVPrint_Config", 1, "init switchOn: " + c16.getSwitchOn());
                return c16;
            }
        });
        D = lazy;
    }

    public final void b(@NotNull JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("MMKVPrint_Config", 2, "from json:" + jsonObj);
        }
        String optString = jsonObj.optString("mmapId");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"mmapId\")");
        this.mmapId = optString;
        this.fileSizeLimit = jsonObj.optInt("fileSizeLimit", 16384);
        this.logSizeLimit = jsonObj.optInt("logSizeLimit", 100);
        this.validityTime = jsonObj.optInt("validityTime", 480);
        this.backgroundDelaytime = jsonObj.optInt("backgroundDelaytime", 30);
    }

    /* renamed from: c, reason: from getter */
    public final int getBackgroundDelaytime() {
        return this.backgroundDelaytime;
    }

    /* renamed from: d, reason: from getter */
    public final int getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    /* renamed from: e, reason: from getter */
    public final int getLogSizeLimit() {
        return this.logSizeLimit;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getMmapId() {
        return this.mmapId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getSwitchOn() {
        return this.switchOn;
    }

    /* renamed from: h, reason: from getter */
    public final int getValidityTime() {
        return this.validityTime;
    }

    public final void i(boolean z16) {
        this.switchOn = z16;
    }

    @NotNull
    public String toString() {
        return "MMKVPrintConfig:{ mmapId:" + this.mmapId + " fileSizeLimit:" + this.fileSizeLimit + " Kb, logSizeLimit:" + this.logSizeLimit + " Mb, validityTime:" + this.validityTime + " min, delayTime:" + this.backgroundDelaytime + " s }";
    }
}
