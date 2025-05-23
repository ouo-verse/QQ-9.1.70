package com.tencent.mobileqq.qmmkv;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001f\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J*\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\r\u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\"\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\"\u0010-\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b,\u0010\u001cR4\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R4\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVReduceConfig;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObj", "", "objKey", "", "", "e", "toString", "", "b", "", "d", "Z", "i", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "switchOn", "g", "setNeedSuicide", "needSuicide", "", "f", "I", "()I", "setMagicNumber", "(I)V", "magicNumber", "", tl.h.F, "J", "()J", "setDelayMs", "(J)V", "delayMs", "k", "setTimeStart", "timeStart", "j", "setTimeEnd", "timeEnd", BdhLogUtil.LogTag.Tag_Conn, "setReduceFileSizeLimit", "reduceFileSizeLimit", "D", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setAutoKeyMatchList", "(Ljava/util/Map;)V", "autoKeyMatchList", "E", "l", "setWhiteKeyMatchList", "whiteKeyMatchList", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVReduceConfig implements IConfigData {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<MMKVReduceConfig> G;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean switchOn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int magicNumber;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needSuicide = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long delayMs = 30000;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int timeStart = 3;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int timeEnd = 5;

    /* renamed from: C, reason: from kotlin metadata */
    private int reduceFileSizeLimit = 33554432;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Map<String, List<String>> autoKeyMatchList = new LinkedHashMap();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<String, List<String>> whiteKeyMatchList = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVReduceConfig$a;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVReduceConfig;", "sConfig$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qmmkv/MMKVReduceConfig;", "sConfig", "", "GROUPID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qmmkv.MMKVReduceConfig$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MMKVReduceConfig a() {
            return (MMKVReduceConfig) MMKVReduceConfig.G.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<MMKVReduceConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVReduceConfig>() { // from class: com.tencent.mobileqq.qmmkv.MMKVReduceConfig$Companion$sConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVReduceConfig invoke() {
                MMKVReduceConfigParser mMKVReduceConfigParser = new MMKVReduceConfigParser();
                MMKVReduceConfig c16 = mMKVReduceConfigParser.c();
                c16.m(mMKVReduceConfigParser.isSwitchOn(false));
                QLog.d("MMKVReduce_config", 1, "init switchOn: " + c16.getSwitchOn());
                return c16;
            }
        });
        G = lazy;
    }

    private final Map<String, List<String>> e(JSONObject jsonObj, String objKey) {
        String str;
        boolean z16;
        JSONObject optJSONObject = jsonObj.optJSONObject(objKey);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "obj.keys()");
            while (keys.hasNext()) {
                Object next = keys.next();
                String str2 = null;
                if (next instanceof String) {
                    str = (String) next;
                } else {
                    str = null;
                }
                if (str != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        str2 = str;
                    }
                    if (str2 != null) {
                        ArrayList<String> a16 = com.tencent.mobileqq.perf.process.config.g.a(optJSONObject, str2);
                        if (!a16.isEmpty()) {
                            linkedHashMap.put(str2, a16);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final void b(@NotNull JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("MMKVReduce_config", 2, "from json:" + jsonObj);
        }
        this.reduceFileSizeLimit = jsonObj.optInt("reduceFileSize", 33554432);
        boolean z16 = true;
        if (jsonObj.optInt("needSuicide", 0) != 1) {
            z16 = false;
        }
        this.needSuicide = z16;
        this.magicNumber = jsonObj.optInt("magic", 0);
        this.timeStart = jsonObj.optInt("timeStart", 3);
        this.timeEnd = jsonObj.optInt("timeEnd", 5);
        this.delayMs = jsonObj.optLong("delayMs", 30000L);
        this.autoKeyMatchList.putAll(e(jsonObj, "auto"));
        this.whiteKeyMatchList.putAll(e(jsonObj, "white"));
    }

    @NotNull
    public final Map<String, List<String>> c() {
        return this.autoKeyMatchList;
    }

    /* renamed from: d, reason: from getter */
    public final long getDelayMs() {
        return this.delayMs;
    }

    /* renamed from: f, reason: from getter */
    public final int getMagicNumber() {
        return this.magicNumber;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getNeedSuicide() {
        return this.needSuicide;
    }

    /* renamed from: h, reason: from getter */
    public final int getReduceFileSizeLimit() {
        return this.reduceFileSizeLimit;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getSwitchOn() {
        return this.switchOn;
    }

    /* renamed from: j, reason: from getter */
    public final int getTimeEnd() {
        return this.timeEnd;
    }

    /* renamed from: k, reason: from getter */
    public final int getTimeStart() {
        return this.timeStart;
    }

    @NotNull
    public final Map<String, List<String>> l() {
        return this.whiteKeyMatchList;
    }

    public final void m(boolean z16) {
        this.switchOn = z16;
    }

    @NotNull
    public String toString() {
        return "MMKVReduceConfig:{ fileSizeLimit:" + this.reduceFileSizeLimit + ", needSuicide:" + this.needSuicide + ", magic:" + this.magicNumber + ", delayMs:" + this.delayMs + ", auto:" + this.autoKeyMatchList + ", white:" + this.whiteKeyMatchList + " }";
    }
}
