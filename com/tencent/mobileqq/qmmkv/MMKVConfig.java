package com.tencent.mobileqq.qmmkv;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.freesia.IConfigData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 D2\u00020\u0001:\u0002EFB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010+\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u00101\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00109\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\"\u0010<\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\f\u001a\u0004\b\u001d\u0010.\"\u0004\b;\u00100R\"\u0010?\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b=\u0010.\"\u0004\b>\u00100R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\u0013\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVConfig;", "Lcom/tencent/freesia/IConfigData;", "", "k", "", "toString", "Lorg/json/JSONObject;", "jsonObj", "", "j", "", "d", "Z", "switchOn", "", "e", "D", "reportEncodeSizeRate", "f", "I", "p", "()I", "setReportEncodeByteSize", "(I)V", "reportEncodeByteSize", tl.h.F, "reportSyncOpRate", "i", "reportFileSizeRate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "setReportFileSizeLimit", "reportFileSizeLimit", "Lcom/tencent/mobileqq/qmmkv/MMKVConfig$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qmmkv/MMKVConfig$b;", "l", "()Lcom/tencent/mobileqq/qmmkv/MMKVConfig$b;", "setFreqAccessConfig", "(Lcom/tencent/mobileqq/qmmkv/MMKVConfig$b;)V", "freqAccessConfig", DomainData.DOMAIN_NAME, "setFreqBigDataConfig", "freqBigDataConfig", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "w", "(Z)V", "reportEncodeSizeSwitchOn", UserInfo.SEX_FEMALE, "t", "y", "reportSyncOpRateSwitchOn", "G", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "reportFileSizeSwitchOn", "H", "u", "freqAccessSwitchOn", "o", "v", "freqWriteBigDataSwitchOn", "J", "thisDeviceLevel", "<init>", "()V", "K", "a", "b", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVConfig implements IConfigData {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<MMKVConfig> L;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean reportEncodeSizeSwitchOn;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean reportSyncOpRateSwitchOn;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean reportFileSizeSwitchOn;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean freqAccessSwitchOn;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean freqWriteBigDataSwitchOn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean switchOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private double reportEncodeSizeRate = 0.001d;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int reportEncodeByteSize = 1024;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private double reportSyncOpRate = 0.001d;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private double reportFileSizeRate = 0.01d;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int reportFileSizeLimit = 64;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private b freqAccessConfig = new b();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private b freqBigDataConfig = new b();

    /* renamed from: J, reason: from kotlin metadata */
    private int thisDeviceLevel = 5;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVConfig$a;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVConfig;", "sConfig$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qmmkv/MMKVConfig;", "sConfig", "", "GROUPID", "Ljava/lang/String;", "KEY_DEVICE_LEVEL", "TAG", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qmmkv.MMKVConfig$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MMKVConfig a() {
            return (MMKVConfig) MMKVConfig.L.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\"\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\"\u0010&\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b!\u0010\u0012\"\u0004\b%\u0010\u0014R\"\u0010(\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b'\u0010\u0014R2\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010+\u001a\u0004\b\u0016\u0010,\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVConfig$b;", "", "", "toString", "Lorg/json/JSONObject;", "obj", "", "a", "", "D", "d", "()D", "setRate", "(D)V", "rate", "", "b", "I", "()I", "setDeivceLevel", "(I)V", "deivceLevel", "c", "g", "setReportIgnoreSizeLimit", "reportIgnoreSizeLimit", "j", "setTimesSinceStart", "timesSinceStart", "e", "i", "setTimesSinceForeground", "timesSinceForeground", "f", tl.h.F, "setTimeGap", "timeGap", "setReportCountLimit", "reportCountLimit", "setReportAvgSizeLimit", "reportAvgSizeLimit", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "setMatches", "(Ljava/util/HashSet;)V", "matches", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private double rate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int deivceLevel = 2;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int reportIgnoreSizeLimit = 64;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int timesSinceStart = 12;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int timesSinceForeground = 6;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int timeGap = 5;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int reportCountLimit = 15;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int reportAvgSizeLimit = 512;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashSet<String> matches = new HashSet<>();

        public final void a(@Nullable JSONObject obj) {
            if (obj == null) {
                return;
            }
            this.rate = obj.optDouble("rate", 0.0d);
            this.deivceLevel = obj.optInt("device", 2);
            this.reportIgnoreSizeLimit = obj.optInt("ignoreSize", 64);
            int optInt = obj.optInt("timeMask", 0);
            int optInt2 = obj.optInt("limitMask", 0);
            this.timesSinceStart = (optInt >>> 22) & 1023;
            this.timesSinceForeground = (optInt >>> 12) & 1023;
            this.timeGap = optInt & 4095;
            this.reportCountLimit = (optInt2 >>> 24) & 255;
            this.reportAvgSizeLimit = 16777215 & optInt2;
            this.matches.addAll(com.tencent.mobileqq.perf.process.config.g.a(obj, "matches"));
        }

        /* renamed from: b, reason: from getter */
        public final int getDeivceLevel() {
            return this.deivceLevel;
        }

        @NotNull
        public final HashSet<String> c() {
            return this.matches;
        }

        /* renamed from: d, reason: from getter */
        public final double getRate() {
            return this.rate;
        }

        /* renamed from: e, reason: from getter */
        public final int getReportAvgSizeLimit() {
            return this.reportAvgSizeLimit;
        }

        /* renamed from: f, reason: from getter */
        public final int getReportCountLimit() {
            return this.reportCountLimit;
        }

        /* renamed from: g, reason: from getter */
        public final int getReportIgnoreSizeLimit() {
            return this.reportIgnoreSizeLimit;
        }

        /* renamed from: h, reason: from getter */
        public final int getTimeGap() {
            return this.timeGap;
        }

        /* renamed from: i, reason: from getter */
        public final int getTimesSinceForeground() {
            return this.timesSinceForeground;
        }

        /* renamed from: j, reason: from getter */
        public final int getTimesSinceStart() {
            return this.timesSinceStart;
        }

        @NotNull
        public String toString() {
            return "rate: " + this.rate + " dL:" + this.deivceLevel + " ignoreSize:" + this.reportIgnoreSizeLimit + " times:[" + this.timesSinceStart + ", " + this.timesSinceForeground + ", " + this.timeGap + "] limit: [" + this.reportCountLimit + ", " + this.reportAvgSizeLimit + "] match:" + this.matches;
        }
    }

    static {
        Lazy<MMKVConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVConfig>() { // from class: com.tencent.mobileqq.qmmkv.MMKVConfig$Companion$sConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVConfig invoke() {
                int k3;
                boolean z16;
                boolean z17;
                int i3;
                double d16;
                double d17;
                double d18;
                boolean z18;
                int i16;
                int i17;
                MMKVConfigParser mMKVConfigParser = new MMKVConfigParser();
                MMKVConfig c16 = mMKVConfigParser.c();
                boolean z19 = false;
                c16.switchOn = mMKVConfigParser.isSwitchOn(false);
                k3 = c16.k();
                c16.thisDeviceLevel = k3;
                z16 = c16.switchOn;
                if (z16) {
                    double random = Math.random();
                    d16 = c16.reportSyncOpRate;
                    c16.y(random < d16);
                    double random2 = Math.random();
                    d17 = c16.reportFileSizeRate;
                    c16.x(random2 < d17);
                    double random3 = Math.random();
                    d18 = c16.reportEncodeSizeRate;
                    c16.w(random3 < d18);
                    if (!c16.getReportEncodeSizeSwitchOn()) {
                        i17 = c16.thisDeviceLevel;
                        if (i17 <= c16.getFreqAccessConfig().getDeivceLevel() && Math.random() < c16.getFreqAccessConfig().getRate()) {
                            z18 = true;
                            c16.u(z18);
                            if (!c16.getReportEncodeSizeSwitchOn() && !c16.getFreqAccessSwitchOn()) {
                                i16 = c16.thisDeviceLevel;
                                if (i16 <= c16.getFreqBigDataConfig().getDeivceLevel() && Math.random() < c16.getFreqBigDataConfig().getRate()) {
                                    z19 = true;
                                }
                            }
                            c16.v(z19);
                        }
                    }
                    z18 = false;
                    c16.u(z18);
                    if (!c16.getReportEncodeSizeSwitchOn()) {
                        i16 = c16.thisDeviceLevel;
                        if (i16 <= c16.getFreqBigDataConfig().getDeivceLevel()) {
                            z19 = true;
                        }
                    }
                    c16.v(z19);
                }
                z17 = c16.switchOn;
                i3 = c16.thisDeviceLevel;
                QLog.d("MMKVReport_config", 1, "switchOn: " + z17 + " thisDeviceLevel:" + i3 + " reportSyncOpRateSwitchOn:" + c16.getReportSyncOpRateSwitchOn() + " reportFileSizeSwitchOn:" + c16.getReportFileSizeSwitchOn() + " reportEncodeSizeSwitchOn:" + c16.getReportEncodeSizeSwitchOn() + " freqAccessSwitchOn:" + c16.getFreqAccessSwitchOn() + " freqWriteBigDataSwitchOn:" + c16.getFreqWriteBigDataSwitchOn());
                return c16;
            }
        });
        L = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k() {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int decodeInt = from.decodeInt("sp_key_device_level", Integer.MIN_VALUE);
        if (decodeInt == Integer.MIN_VALUE) {
            decodeInt = ((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel();
            from.encodeInt("sp_key_device_level", decodeInt);
            from.commitAsync();
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d("MMKVReport_config", 1, "deviceLevel=" + decodeInt + ", fromSp=" + z16);
        return decodeInt;
    }

    public final void j(@NotNull JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("MMKVReport_config", 2, "from json:" + jsonObj);
        }
        this.reportEncodeSizeRate = jsonObj.optDouble("reportEncodeSizeRate", 0.0d);
        this.reportEncodeByteSize = jsonObj.optInt("reportEncodeByteSize", 1024);
        this.reportFileSizeRate = jsonObj.optDouble("reportFileSizeRate", 0.0d);
        this.reportFileSizeLimit = jsonObj.optInt("reportFileSizeLimit", 64);
        this.reportSyncOpRate = jsonObj.optDouble("reportSyncOpRate", 0.0d);
        JSONObject optJSONObject = jsonObj.optJSONObject("freqAccess");
        if (optJSONObject != null) {
            this.freqAccessConfig.a(optJSONObject);
        }
        JSONObject optJSONObject2 = jsonObj.optJSONObject("freqBigData");
        if (optJSONObject2 != null) {
            this.freqBigDataConfig.a(optJSONObject2);
        }
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final b getFreqAccessConfig() {
        return this.freqAccessConfig;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getFreqAccessSwitchOn() {
        return this.freqAccessSwitchOn;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final b getFreqBigDataConfig() {
        return this.freqBigDataConfig;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getFreqWriteBigDataSwitchOn() {
        return this.freqWriteBigDataSwitchOn;
    }

    /* renamed from: p, reason: from getter */
    public final int getReportEncodeByteSize() {
        return this.reportEncodeByteSize;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getReportEncodeSizeSwitchOn() {
        return this.reportEncodeSizeSwitchOn;
    }

    /* renamed from: r, reason: from getter */
    public final int getReportFileSizeLimit() {
        return this.reportFileSizeLimit;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getReportFileSizeSwitchOn() {
        return this.reportFileSizeSwitchOn;
    }

    /* renamed from: t, reason: from getter */
    public final boolean getReportSyncOpRateSwitchOn() {
        return this.reportSyncOpRateSwitchOn;
    }

    @NotNull
    public String toString() {
        return "reportFileSizeRate:" + this.reportFileSizeRate + ", reportFileSizeLimit:" + this.reportFileSizeLimit + ", reportEncodeSizeRate:" + this.reportEncodeSizeRate + ", reportEncodeByteSize:" + this.reportEncodeByteSize + ", reportSyncOpRate:" + this.reportSyncOpRate + ", freqAccessConfig: " + this.freqAccessConfig + ",  freqConfigBigData: " + this.freqBigDataConfig;
    }

    public final void u(boolean z16) {
        this.freqAccessSwitchOn = z16;
    }

    public final void v(boolean z16) {
        this.freqWriteBigDataSwitchOn = z16;
    }

    public final void w(boolean z16) {
        this.reportEncodeSizeSwitchOn = z16;
    }

    public final void x(boolean z16) {
        this.reportFileSizeSwitchOn = z16;
    }

    public final void y(boolean z16) {
        this.reportSyncOpRateSwitchOn = z16;
    }
}
