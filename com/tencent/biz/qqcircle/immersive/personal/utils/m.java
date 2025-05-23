package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.util.ArrayMap;
import com.tencent.biz.qqcircle.beans.QFSPrivateSettingBean;
import com.tencent.biz.qqcircle.requests.QCircleNewGetUserSwitchRequest;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import feedcloud.GetSwitchRsp;
import feedcloud.Switch;
import feedcloud.SwitchInfos;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nJ\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0012j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006`\u0013J\u001e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0002R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0012j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u001fj\b\u0012\u0004\u0012\u00020\u0018` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/m;", "", "", "i", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/GetSwitchRsp;", "rsp", "d", "switchKey", "f", "e", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "isSwitch", "type", "k", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/m$a;", "callback", "b", "j", "g", "Ljava/util/HashMap;", "mSwitchMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mLoadSwitchOnCallbackSet", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNewSwitchRequesting", "", "Ljava/util/Map;", "SWITCH_MAP", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f89099a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Boolean> mSwitchMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<a> mLoadSwitchOnCallbackSet = new HashSet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean mNewSwitchRequesting = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> SWITCH_MAP;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/m$a;", "", "", "", "", "switchMap", "", "m0", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void m0(@NotNull Map<String, Boolean> switchMap);
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        SWITCH_MAP = arrayMap;
        arrayMap.put(Switch.PROTECTION.name(), QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ONE_KEY_DEFEND);
    }

    m() {
    }

    private final void d(BaseRequest request, boolean isSuccess, long retCode, String errMsg, GetSwitchRsp rsp) {
        String traceId;
        if (request == null) {
            traceId = "";
        } else {
            traceId = request.getTraceId();
        }
        if (isSuccess && retCode == 0) {
            if (rsp == null) {
                RFWLog.d("QOK-QFSPersonalOneKeyDefendUtils", RFWLog.USR, "[loadNetworkSwitchData] current rsp not is GetSwitchRsp.");
                return;
            }
            SwitchInfos switchInfos = rsp.switch_.get(RFWApplication.getAccountId());
            if (switchInfos == null) {
                RFWLog.d("QOK-QFSPersonalOneKeyDefendUtils", RFWLog.USR, "[loadNetworkSwitchData] switch should not be null.");
                return;
            }
            for (String str : SWITCH_MAP.keySet()) {
                Map<String, Boolean> map = switchInfos.switchInfo;
                Intrinsics.checkNotNullExpressionValue(map, "switchVal.switchInfo");
                Boolean bool = map.get(str);
                RFWLog.d("QOK-QFSPersonalOneKeyDefendUtils", RFWLog.USR, "[loadNetworkSwitchData] isSwitch: " + bool + " | traceId: " + traceId);
                if (bool != null) {
                    f89099a.k(str, bool.booleanValue(), "type_privacy_switch_network");
                }
            }
            Iterator<a> it = mLoadSwitchOnCallbackSet.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.m0(mSwitchMap);
                }
            }
            i();
            mNewSwitchRequesting.set(false);
            return;
        }
        RFWLog.d("QOK-QFSPersonalOneKeyDefendUtils", RFWLog.USR, "[loadNetworkSwitchData] update fail, retCode: " + retCode + " | errMsg: " + errMsg + " | traceId: " + traceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(BaseRequest baseRequest, boolean z16, long j3, String str, GetSwitchRsp getSwitchRsp) {
        f89099a.d(baseRequest, z16, j3, str, getSwitchRsp);
    }

    private final void i() {
        Iterator<a> it = mLoadSwitchOnCallbackSet.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.m0(mSwitchMap);
            }
        }
    }

    public final void b(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        mLoadSwitchOnCallbackSet.add(callback);
    }

    @NotNull
    public final HashMap<String, Boolean> c() {
        return mSwitchMap;
    }

    public final boolean e(@NotNull String switchKey) {
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        Boolean bool = mSwitchMap.get(switchKey);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean f(@NotNull String switchKey) {
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        if (mSwitchMap.get(switchKey) == null) {
            return true;
        }
        return false;
    }

    public final void g() {
        List listOf;
        AtomicBoolean atomicBoolean = mNewSwitchRequesting;
        if (atomicBoolean.get()) {
            RFWLog.d("QOK-QFSPersonalOneKeyDefendUtils", RFWLog.USR, "[loadNetworkSwitchData] current new switch requesting.");
            return;
        }
        String accountId = RFWApplication.getAccountId();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Switch.PROTECTION.toString());
        QCircleNewGetUserSwitchRequest qCircleNewGetUserSwitchRequest = new QCircleNewGetUserSwitchRequest(accountId, listOf);
        atomicBoolean.set(true);
        VSNetworkHelper.getInstance().sendRequest(qCircleNewGetUserSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                m.h(baseRequest, z16, j3, str, (GetSwitchRsp) obj);
            }
        });
    }

    public final void j(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        mLoadSwitchOnCallbackSet.remove(callback);
    }

    public final void k(@NotNull String switchKey, boolean isSwitch, @NotNull String type) {
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        Intrinsics.checkNotNullParameter(type, "type");
        RFWLog.d("QOK-QFSPersonalOneKeyDefendUtils", RFWLog.USR, "[updateOpenOneKeyDefendSwitch] isSwitch: " + isSwitch + " | type: " + type);
        mSwitchMap.put(switchKey, Boolean.valueOf(isSwitch));
    }
}
