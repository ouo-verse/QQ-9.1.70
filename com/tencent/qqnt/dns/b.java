package com.tencent.qqnt.dns;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.transfile.ipv6.IpStrategy;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 \u001d2\u00020\u0001:\u00011B\u0011\b\u0000\u0012\u0006\u0010.\u001a\u00020\u0007\u00a2\u0006\u0004\b/\u00100J8\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ,\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tJ<\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJD\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bJ\"\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u0018\u001a\u00020\u0016H\u0016J6\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0004J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\"\u0010\u001d\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014JZ\u0010\"\u001aJ\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001fj,\u0012\u0004\u0012\u00020\u0007\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 `!\u0018\u0001`!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0004J\b\u0010#\u001a\u00020\u0007H\u0004Rf\u0010)\u001aF\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001f0\u001fj*\u0012\u0004\u0012\u00020\u0007\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 `!`!8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010-\u001a\u00020\u00078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/dns/b;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/transfile/dns/IpData;", "Lkotlin/collections/ArrayList;", "ipDataList", "p", "", "domain", "", "businessType", "", "allowIpc", "i", "ipType", "j", h.F, "k", "l", "addPort", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sourceIp", "", "g", "onAppDestroy", DomainData.DOMAIN_NAME, "b", "e", "ip", "f", "mapString", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/transfile/dns/DomainData;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "o", "(Ljava/util/HashMap;)V", "mNetMap", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "moduleName", "<init>", "(Ljava/lang/String;)V", "a", "nt_dns_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, HashMap<String, DomainData>> mNetMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/dns/b$a;", "", "", "ACTION_NOTIFY_SYNC_DATA", "Ljava/lang/String;", "ACTION_REPORT_BAD_IP", "ACTION_REQ_DOMAIN_TO_IP_LIST", "DOMAIN_ARRAY", "", "INPUT_INVALID", "I", "IPC_ADDRESS_DATA", "IPC_BUSINESS_TYPE", "IPC_DOMAIN", "IPC_EXCEPTION", "IPC_IP", "IPC_MODULE_NAME", "IP_LIST_INVALID", "NET_IDENTIFIER", "NO_DOMAIN_FOUND", "NO_NET_FOUND", "OTHER_PROCESS_BIND", "STORAGE_MMKV_KEY", "SUCCEED", "<init>", "()V", "nt_dns_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.dns.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) moduleName);
            return;
        }
        this.mNetMap = new HashMap<>();
        this.TAG = InnerDns.TAG + MobileQQ.processName;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        HashMap<String, HashMap<String, DomainData>> q16 = q(from.decodeString("NtInnerDns_DomainIP", null));
        if (q16 != null) {
            this.mNetMap = new HashMap<>(q16);
        }
    }

    private final String i(String domain, int businessType, boolean allowIpc) {
        if (IpStrategyFactory.createIpv6Flag()) {
            return j(domain, businessType, allowIpc, 28);
        }
        return j(domain, businessType, allowIpc, 1);
    }

    private final String j(String domain, int businessType, boolean allowIpc, int ipType) {
        String str;
        ArrayList<String> m3 = m(domain, businessType, allowIpc, ipType, true);
        if (m3 != null && m3.size() > 0) {
            str = m3.get(0);
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "reqDns after dns:" + str);
        }
        return str;
    }

    private final synchronized ArrayList<IpData> p(ArrayList<IpData> ipDataList) {
        if (ipDataList != null) {
            if (ipDataList.size() != 0) {
                Iterator<IpData> it = ipDataList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "ipDataList.iterator()");
                while (it.hasNext()) {
                    IpData next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                    if (next.mFailedCount > 0) {
                        it.remove();
                    }
                }
                if (ipDataList.size() > 1 && Random.INSTANCE.nextInt() % 10 == 0) {
                    Collections.shuffle(ipDataList);
                }
                return ipDataList;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ArrayList<IpData> b(@Nullable String domain, int businessType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) domain, businessType);
        }
        synchronized (this) {
            String d16 = d();
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getIpDataListLocal, get domainMap by currentNetType, currentNetType=" + d16 + " businessType=" + businessType);
            }
            HashMap<String, DomainData> hashMap = this.mNetMap.get(d16);
            if (hashMap == null) {
                if (QLog.isColorLevel()) {
                    QLog.w(this.TAG, 2, "getIpDataListLocal, domainMap is null.");
                }
                e();
                i3 = 60;
            } else if (hashMap.containsKey(domain)) {
                DomainData domainData = hashMap.get(domain);
                Intrinsics.checkNotNull(domainData);
                ArrayList<IpData> p16 = p(domainData.mIpList);
                if (p16 != null && p16.size() > 0) {
                    if (QLog.isColorLevel() && domain != null) {
                        QLog.w(this.TAG, 2, "getIpDataListLocal succeed, domain = " + domain);
                    }
                    return p16;
                }
                i3 = 30;
            } else {
                i3 = 50;
            }
            Unit unit = Unit.INSTANCE;
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getIpDataListLocal error:" + i3);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, HashMap<String, DomainData>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNetMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext());
        if (systemNetwork != 2 && systemNetwork != 3 && systemNetwork != 4 && systemNetwork != 6) {
            return String.valueOf(systemNetwork);
        }
        return "2";
    }

    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(@Nullable String domain, @NotNull String ip5, int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, domain, ip5, Integer.valueOf(businessType))).intValue();
        }
        Intrinsics.checkNotNullParameter(ip5, "ip");
        String d16 = d();
        HashMap<String, HashMap<String, DomainData>> hashMap = this.mNetMap;
        if (hashMap != null) {
            Intrinsics.checkNotNull(hashMap);
            if (hashMap.containsKey(d16)) {
                synchronized (this) {
                    HashMap<String, HashMap<String, DomainData>> hashMap2 = this.mNetMap;
                    Intrinsics.checkNotNull(hashMap2);
                    HashMap<String, DomainData> hashMap3 = hashMap2.get(d16);
                    if (hashMap3 != null && hashMap3.containsKey(domain)) {
                        DomainData domainData = hashMap3.get(domain);
                        Intrinsics.checkNotNull(domainData);
                        ArrayList<IpData> arrayList = domainData.mIpList;
                        if (arrayList != null) {
                            Iterator<IpData> it = arrayList.iterator();
                            while (it.hasNext()) {
                                IpData next = it.next();
                                if (Intrinsics.areEqual(ip5, next.mIp)) {
                                    next.mFailedCount++;
                                }
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return 0;
            }
        }
        return 60;
    }

    public final void g(@Nullable String domain, @Nullable String sourceIp, int businessType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, domain, sourceIp, Integer.valueOf(businessType));
            return;
        }
        if (!TextUtils.isEmpty(domain) && !TextUtils.isEmpty(sourceIp) && !Intrinsics.areEqual(domain, sourceIp)) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "reportBadIp domian: " + domain + " ip:" + sourceIp + " busiType:" + businessType);
            }
            Intrinsics.checkNotNull(sourceIp);
            i3 = f(domain, new Regex("\\[(.*)\\]").replace(sourceIp, "$1"), businessType);
        } else {
            i3 = 40;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "reportBadIp errorCode=" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.TAG;
    }

    @Nullable
    public final String h(@NotNull String domain, int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) domain, businessType);
        }
        Intrinsics.checkNotNullParameter(domain, "domain");
        return i(domain, businessType, true);
    }

    @Nullable
    public final ArrayList<String> k(@Nullable String domain, int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this, (Object) domain, businessType);
        }
        ArrayList<String> m3 = m(domain, businessType, true, 1, true);
        ArrayList<String> m16 = m(domain, businessType, true, 28, true);
        IpStrategy createDownStrategy = IpStrategyFactory.createDownStrategy();
        Intrinsics.checkNotNullExpressionValue(createDownStrategy, "createDownStrategy()");
        return createDownStrategy.selectIpList(m16, m3, NetConnInfoCenter.getActiveNetIpFamily(true));
    }

    @Nullable
    public final ArrayList<String> l(@Nullable String domain, int businessType, boolean allowIpc, int ipType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, this, domain, Integer.valueOf(businessType), Boolean.valueOf(allowIpc), Integer.valueOf(ipType));
        }
        return m(domain, businessType, allowIpc, ipType, true);
    }

    @Nullable
    public final ArrayList<String> m(@Nullable String domain, int businessType, boolean allowIpc, int ipType, boolean addPort) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, this, domain, Integer.valueOf(businessType), Boolean.valueOf(allowIpc), Integer.valueOf(ipType), Boolean.valueOf(addPort));
        }
        ArrayList<IpData> n3 = n(domain, businessType, allowIpc);
        if (n3 != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<IpData> it = n3.iterator();
            while (it.hasNext()) {
                IpData next = it.next();
                int i16 = next.mType;
                if (i16 == ipType) {
                    String str = next.mIp;
                    if (i16 == 1 && (i3 = next.mPort) != 80 && addPort) {
                        str = str + ":" + i3;
                    } else if (i16 == 28) {
                        str = "[" + str + "]";
                        int i17 = next.mPort;
                        if (i17 != 80 && addPort) {
                            str = str + ":" + i17;
                        }
                    }
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return null;
    }

    @Nullable
    public abstract ArrayList<IpData> n(@Nullable String domain, int businessType, boolean allowIpc);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(@NotNull HashMap<String, HashMap<String, DomainData>> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hashMap);
        } else {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            this.mNetMap = hashMap;
        }
    }

    public void onAppDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final HashMap<String, HashMap<String, DomainData>> q(@Nullable String mapString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (HashMap) iPatchRedirector.redirect((short) 14, (Object) this, (Object) mapString);
        }
        if (mapString == null) {
            return null;
        }
        try {
            HashMap<String, HashMap<String, DomainData>> hashMap = new HashMap<>();
            JSONArray jSONArray = new JSONArray(mapString);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String netIdentifier = jSONObject.getString("net_identifier");
                HashMap<String, DomainData> unParse = DomainData.unParse(jSONObject.getString("domain_map"));
                if (unParse != null) {
                    Intrinsics.checkNotNullExpressionValue(netIdentifier, "netIdentifier");
                    hashMap.put(netIdentifier, unParse);
                }
            }
            return hashMap;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 2, "unParse failed", e16);
            }
            return null;
        }
    }
}
