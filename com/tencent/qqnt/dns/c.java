package com.tencent.qqnt.dns;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.configpush.DomainIp$NameRspBody;
import tencent.im.mobileqq.configpush.DomainIp$ServerList;
import tencent.im.mobileqq.configpush.DomainIp$SubCmd_name_Rsp;
import tencent.im.mobileqq.configpush.DomainIp$iplistInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J,\u0010\t\u001a\u00020\b2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002JX\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J.\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J4\u0010\u0015\u001a\u00020\u00052\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002JV\u0010\u0017\u001a\u0004\u0018\u00010\u00042J\u0010\u0016\u001aF\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003j*\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006`\u0006H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0014J6\u0010)\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$H\u0016J\u0016\u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020$J\u0006\u0010.\u001a\u00020\bJ\u0012\u0010/\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00100\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00101\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00102\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00103\u001a\u00020\bH\u0016J\b\u00104\u001a\u00020\bH\u0016R\u0016\u00107\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/dns/c;", "Lcom/tencent/qqnt/dns/b;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/transfile/dns/DomainData;", "Lkotlin/collections/HashMap;", "domainMap", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Ltencent/im/mobileqq/configpush/DomainIp$iplistInfo;", "domainServerList", "y", "name", "", "type", "Ltencent/im/mobileqq/configpush/DomainIp$ServerList;", "serverLists", "ipDomainData", "r", "t", "netData", "v", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "action", "Landroid/os/Bundle;", "params", "callbackId", "Leipc/EIPCResult;", "onCall", "onAppDestroy", "e", "domain", "businessType", "", "allowIpc", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/transfile/dns/IpData;", "Lkotlin/collections/ArrayList;", DomainData.DOMAIN_NAME, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "isPush", "u", "w", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", h.F, "Z", "mIsRequestingIPDomaining", "<init>", "()V", "i", "a", "nt_dns_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends b implements INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsRequestingIPDomaining;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/dns/c$a;", "", "", "MAX_IP_DATA_SIZE", "I", "RESULT_OK", "<init>", "()V", "nt_dns_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.dns.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        super(InnerDns.NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, this);
        }
    }

    private final void r(String name, int type, List<DomainIp$ServerList> serverLists, DomainData ipDomainData) {
        for (DomainIp$ServerList domainIp$ServerList : serverLists) {
            IpData ipData = new IpData();
            ipData.mIp = domainIp$ServerList.string_IP.get();
            ipData.mPort = domainIp$ServerList.uint32_Port.get();
            ipData.mType = type;
            ipDomainData.mIpList.add(ipData);
            if (QLog.isColorLevel()) {
                QLog.d(getTAG(), 2, "onDomainServerListUpdate type=" + type + " d:" + name + " " + ipData.mIp + " " + ipData.mPort);
            }
        }
    }

    private final void s() {
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "clearWifiData");
        }
        synchronized (this) {
            c().remove("1");
        }
    }

    private final DomainData t(HashMap<String, DomainData> domainMap, String name) {
        if (domainMap.containsKey(name) && domainMap.get(name) != null) {
            DomainData domainData = domainMap.get(name);
            Intrinsics.checkNotNull(domainData);
            DomainData domainData2 = domainData;
            if (domainData2.mIpList == null) {
                domainData2.mIpList = new ArrayList<>();
                return domainData2;
            }
            return domainData2;
        }
        return new DomainData(name, new ArrayList());
    }

    private final String v(HashMap<String, HashMap<String, DomainData>> netData) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, HashMap<String, DomainData>> entry : netData.entrySet()) {
                Intrinsics.checkNotNullExpressionValue(entry, "next()");
                String key = entry.getKey();
                HashMap<String, DomainData> value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("net_identifier", key);
                jSONObject.put("domain_map", DomainData.parse(value));
                jSONArray.mo162put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable th5) {
            QLog.d(getTAG(), 1, "parse failed", th5);
            return null;
        }
    }

    private final String x() {
        String v3 = v(c());
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("NtInnerDns_DomainIP", v3);
        return v3;
    }

    private final HashMap<String, DomainData> y(List<DomainIp$iplistInfo> domainServerList, HashMap<String, DomainData> domainMap) {
        if (domainServerList == null) {
            return domainMap;
        }
        if (domainMap == null) {
            domainMap = new HashMap<>();
        }
        for (DomainIp$iplistInfo domainIp$iplistInfo : domainServerList) {
            String dName = domainIp$iplistInfo.string_dname.get();
            if (!TextUtils.isEmpty(dName) && domainIp$iplistInfo.int32_result.get() == 0) {
                int i3 = domainIp$iplistInfo.uint32_type.get();
                if (i3 != 1 && i3 != 28) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(getTAG(), 2, "onDomainServerListUpdate unexpected type=" + i3);
                    }
                } else {
                    List<DomainIp$ServerList> list = domainIp$iplistInfo.ServerList_data.get();
                    if (list != null) {
                        Intrinsics.checkNotNullExpressionValue(dName, "dName");
                        DomainData t16 = t(domainMap, dName);
                        r(dName, i3, list, t16);
                        if (t16.mIpList.size() > 0) {
                            domainMap.put(dName, t16);
                        }
                    }
                }
            }
        }
        return domainMap;
    }

    private final void z(HashMap<String, DomainData> domainMap) {
        String d16 = d();
        if (c().size() >= 3 && !c().containsKey(d16)) {
            if (QLog.isColorLevel()) {
                QLog.d(getTAG(), 2, "updateNetMap, mNetMap.size() = " + c().size() + " , clear mNetMap.");
            }
            c().clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "updateNetMap, write to mNetMap by currentNetType, currentNetType = " + d16);
        }
        c().put(d16, domainMap);
    }

    @Override // com.tencent.qqnt.dns.b
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            w();
        }
    }

    @Override // com.tencent.qqnt.dns.b
    @Nullable
    public ArrayList<IpData> n(@Nullable String domain, int businessType, boolean allowIpc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, this, domain, Integer.valueOf(businessType), Boolean.valueOf(allowIpc));
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "reqDns, processId:" + MobileQQ.sProcessId + " domain:" + domain + ", businessType:" + businessType);
        }
        if (TextUtils.isEmpty(domain)) {
            return null;
        }
        return b(domain, businessType);
    }

    @Override // com.tencent.qqnt.dns.b
    public void onAppDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this) {
            s();
            x();
        }
        AppNetConnInfo.unregisterNetInfoHandler(this);
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@NotNull String action, @NotNull Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "action = " + action + ", params = " + params);
        }
        Bundle bundle = new Bundle();
        if (Intrinsics.areEqual("reqDomain2IpList", action)) {
            bundle.putParcelableArrayList("ip", b(params.getString("domain"), params.getInt("businessType")));
        } else if (Intrinsics.areEqual("reportBadIp", action)) {
            g(params.getString("domain"), params.getString("ip"), params.getInt("businessType"));
        }
        return EIPCResult.createSuccessResult(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onNetMobile2None");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(@Nullable String s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) s16);
        } else if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onNetMobile2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(@Nullable String s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) s16);
        } else if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onNetNone2Mobile");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(@Nullable String s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) s16);
        } else if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onNetNone2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(@Nullable String s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) s16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onNetWifi2Mobile");
        }
        s();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onNetWifi2None");
        }
        s();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0112 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(@NotNull FromServiceMsg response, boolean isPush) {
        String x16;
        List<DomainIp$iplistInfo> list;
        List<DomainIp$iplistInfo> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, response, Boolean.valueOf(isPush));
            return;
        }
        Intrinsics.checkNotNullParameter(response, "response");
        this.mIsRequestingIPDomaining = false;
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onReceiveFromServer:" + MobileQQ.sProcessId + ", isPush:" + isPush);
        }
        HashMap<String, DomainData> hashMap = new HashMap<>();
        try {
            byte[] bArr = new byte[r8.getInt() - 4];
            ByteBuffer.wrap(response.getWupBuffer()).get(bArr);
            DomainIp$NameRspBody domainIp$NameRspBody = new DomainIp$NameRspBody();
            domainIp$NameRspBody.mergeFrom(bArr);
            DomainIp$SubCmd_name_Rsp domainIp$SubCmd_name_Rsp = domainIp$NameRspBody.SubCmd_name_Rsp.get();
            if (domainIp$SubCmd_name_Rsp != null) {
                list = domainIp$SubCmd_name_Rsp.iplistInfo.get();
                list2 = domainIp$SubCmd_name_Rsp.iplistInfoV6.get();
            } else {
                list = null;
                list2 = null;
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "decode failed.", e16);
        }
        if (list != null || list2 != null) {
            hashMap = y(list2, y(list, hashMap));
            if (!z16) {
                synchronized (this) {
                    z(hashMap);
                    x16 = x();
                    Unit unit = Unit.INSTANCE;
                }
                if (x16 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("addressData", x16);
                    QIPCServerHelper qIPCServerHelper = QIPCServerHelper.getInstance();
                    ArrayList<EIPCConnection> clientConnectionList = qIPCServerHelper.getServer().getClientConnectionList();
                    Intrinsics.checkNotNullExpressionValue(clientConnectionList, "server.clientConnectionList");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : clientConnectionList) {
                        if (((EIPCConnection) obj).isAvailable()) {
                            arrayList.add(obj);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        qIPCServerHelper.callClient(((EIPCConnection) it.next()).procName, InnerDns.NAME, "notifySyncAddressData", bundle, null);
                    }
                    return;
                }
                return;
            }
            return;
        }
        z16 = false;
        if (!z16) {
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.mIsRequestingIPDomaining) {
            if (QLog.isColorLevel()) {
                QLog.d(getTAG(), 2, "startPullFromServer.");
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            peekAppRuntime.startServlet(new NewIntent(peekAppRuntime.getApp(), a.class));
            this.mIsRequestingIPDomaining = true;
        }
    }
}
