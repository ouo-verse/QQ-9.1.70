package ac3;

import com.epicgames.ue4.ZPlanVersion;
import com.tencent.halley.common.ParseDnsServerType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lac3/b;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f25856b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0014R\u0014\u0010\"\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0014\u0010#\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0014R\u0014\u0010$\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0014R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0014R\u0014\u0010&\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0014R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0014R\u0014\u0010(\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0014\u00a8\u0006+"}, d2 = {"Lac3/b$a;", "", "", "f", "Lac3/a;", "a", "Lac3/e;", "e", "Lac3/f;", "c", "Lac3/d;", "d", "Lac3/c;", "b", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "DEFAULT_DNS_DOMAIN_WHITELIST", "Ljava/util/ArrayList;", "DEFAULT_DNS_PARSE_TYPE", "Ljava/lang/String;", "DEFAULT_ENABLE_CRC_CHECK", "DEFAULT_ENABLE_DUAL_DOWNLOAD", "DEFAULT_ENABLE_MD5_CHECK", "DEFAULT_ENABLE_MULTI_THREAD", "", "DEFAULT_ENHANCE_THREAD_NUM", "I", "DEFAULT_FILE_TASK_LIMIT", "DEFAULT_L2N_TASK_LIMIT", "DEFAULT_MOD_TASK_LIMIT", "DEFAULT_MULTI_THREAD_FILE_SIZE", "DEFAULT_OTHER_TASK_LIMIT", "DEFAULT_USE_HTTP_DNS", "DNS_PARSE_OFF", "DNS_PARSE_TYPE_HALLEY", "DNS_PARSE_TYPE_HTTPDNS", "DNS_PARSE_TYPE_LOCALDNS", "SWITCH_OFF", "SWITCH_ON", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ac3.b$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanDownloadCommonConfig a() {
            Map<String, String> h26 = ZPlanFeatureSwitch.f369852a.h2();
            QLog.i("ZPlanDownloadConfigHelper", 1, "getZPlanDownloadCommonConfig= " + h26);
            String str = h26.get("enableCrcCheck");
            if (str == null) {
                str = "1";
            }
            boolean areEqual = Intrinsics.areEqual("1", str);
            String str2 = h26.get("enableBizMd5Check");
            if (str2 == null) {
                str2 = "0";
            }
            return new ZPlanDownloadCommonConfig(areEqual, Intrinsics.areEqual("1", str2));
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final ZPlanDownloadDnsConfig b() {
            ParseDnsServerType parseDnsServerType;
            List split$default;
            Map<String, String> i26 = ZPlanFeatureSwitch.f369852a.i2();
            String str = i26.get("dnsParseType");
            String str2 = str == null ? "1" : str;
            switch (str2.hashCode()) {
                case 49:
                    if (str2.equals("1")) {
                        parseDnsServerType = ParseDnsServerType.HTTP_DNS;
                        break;
                    }
                    parseDnsServerType = null;
                    break;
                case 50:
                    if (str2.equals("2")) {
                        parseDnsServerType = ParseDnsServerType.HALLEY;
                        break;
                    }
                    parseDnsServerType = null;
                    break;
                case 51:
                    if (str2.equals("3")) {
                        parseDnsServerType = ParseDnsServerType.LOCAL_DNS;
                        break;
                    }
                    parseDnsServerType = null;
                    break;
                default:
                    parseDnsServerType = null;
                    break;
            }
            ParseDnsServerType parseDnsServerType2 = parseDnsServerType;
            String str3 = i26.get("dnsDomainWhiteList");
            if (str3 == null) {
                str3 = "";
            }
            split$default = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{";"}, false, 0, 6, (Object) null);
            if (split$default.isEmpty()) {
                split$default = b.f25856b;
            }
            List list = split$default;
            boolean z16 = parseDnsServerType2 != null;
            String str4 = i26.get("enableHttpDns");
            if (str4 == null) {
                str4 = "1";
            }
            return new ZPlanDownloadDnsConfig(z16, parseDnsServerType2, list, Intrinsics.areEqual("1", str4), str2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
        
            r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x002d, code lost:
        
            r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
        
            r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ZPlanDownloadQueueManagerConfig c() {
            Integer intOrNull;
            Integer intOrNull2;
            Integer intOrNull3;
            Integer intOrNull4;
            Map<String, String> n26 = ZPlanFeatureSwitch.f369852a.n2();
            int i3 = 1;
            QLog.i("ZPlanDownloadConfigHelper", 1, "getZPlanDownloadQueueConfig= " + n26);
            String str = n26.get("ModTaskLimit");
            int i16 = 2;
            int intValue = (str == null || intOrNull4 == null) ? 2 : intOrNull4.intValue();
            String str2 = n26.get("FileTaskLimit");
            if (str2 != null && intOrNull3 != null) {
                i16 = intOrNull3.intValue();
            }
            String str3 = n26.get("L2NTaskLimit");
            int intValue2 = (str3 == null || intOrNull2 == null) ? 12 : intOrNull2.intValue();
            String str4 = n26.get("OtherTaskLimit");
            if (str4 != null && intOrNull != null) {
                i3 = intOrNull.intValue();
            }
            return new ZPlanDownloadQueueManagerConfig(intValue, i16, intValue2, i3);
        }

        public final ZPlanDownloadHttpDnsKey d() {
            Map<String, String> j26 = ZPlanFeatureSwitch.f369852a.j2();
            QLog.i("ZPlanDownloadConfigHelper", 1, "getZPlanDownloadHttpDnsKey= " + j26);
            String str = j26.get(com.heytap.mcssdk.a.a.f36102l);
            if (str == null) {
                str = "";
            }
            String str2 = j26.get("dnsId");
            if (str2 == null) {
                str2 = "";
            }
            String str3 = j26.get("dnsKey");
            ZPlanDownloadHttpDnsKey zPlanDownloadHttpDnsKey = new ZPlanDownloadHttpDnsKey(str, str2, str3 != null ? str3 : "");
            if (zPlanDownloadHttpDnsKey.getAppKey().length() > 0) {
                if (zPlanDownloadHttpDnsKey.getDnsId().length() > 0) {
                    if (zPlanDownloadHttpDnsKey.getDnsKey().length() > 0) {
                        return zPlanDownloadHttpDnsKey;
                    }
                }
            }
            return new ZPlanDownloadHttpDnsKey("-1", "-1", "-1");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
        
            r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ZPlanDownloadMultiThreadConfig e() {
            Integer intOrNull;
            Integer intOrNull2;
            Map<String, String> l26 = ZPlanFeatureSwitch.f369852a.l2();
            String str = l26.get("EnableMultiThread");
            if (str == null) {
                str = "1";
            }
            boolean areEqual = Intrinsics.areEqual("1", str);
            String str2 = l26.get("MultiThreadFileSize");
            int intValue = (str2 == null || intOrNull2 == null) ? 100 : intOrNull2.intValue();
            String str3 = l26.get("EnhanceNum");
            int intValue2 = (str3 == null || intOrNull == null) ? 3 : intOrNull.intValue();
            String str4 = l26.get("EnableDualDownload");
            if (str4 == null) {
                str4 = "1";
            }
            return new ZPlanDownloadMultiThreadConfig(areEqual, intValue, intValue2, Intrinsics.areEqual("1", str4));
        }

        public final boolean f() {
            return ZPlanFeatureSwitch.f369852a.c3();
        }

        Companion() {
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ZPlanVersion.CosDN);
        arrayList.add("mod.superqqshow.qq.com");
        f25856b = arrayList;
    }
}
