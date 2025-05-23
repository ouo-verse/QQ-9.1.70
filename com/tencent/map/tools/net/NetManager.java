package com.tencent.map.tools.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.adapter.URLNetImpl;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mapsdk.internal.lr;
import com.tencent.mapsdk.internal.md;
import com.tencent.tencentmap.mapsdk.maps.model.LocationRegion;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetManager {
    private static NetManager sInstance;
    private NetAdapter mAdapter;
    private String mGlobalSecretKey;
    private LocationRegion thisLocationRegion;
    private boolean mInited = false;
    private boolean mGlobalForceHttps = true;
    private final HashMap<String, String> mGlobalNetFlowRuleList = new HashMap<>();
    private final HashSet<Class<? extends md>> mGlobalNetFlowProcessorClzList = new HashSet<>();
    private final LocationRegion.LocationRegionChangedListener thisRegionChangedListener = new LocationRegion.LocationRegionChangedListener() { // from class: com.tencent.map.tools.net.NetManager.1
        @Override // com.tencent.tencentmap.mapsdk.maps.model.LocationRegion.LocationRegionChangedListener
        public final void onLocationRegionChanged(LocationRegion locationRegion, LocationRegion locationRegion2) {
            LogUtil.b(ky.f149120z, "onLocationRegionChanged prev:" + locationRegion + " cur:" + locationRegion2);
            NetManager.this.thisLocationRegion = locationRegion2;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.map.tools.net.NetManager$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f147601a;

        static {
            int[] iArr = new int[AdapterType.values().length];
            f147601a = iArr;
            try {
                iArr[AdapterType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147601a[AdapterType.URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147601a[AdapterType.Halley.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    NetManager() {
    }

    static NetAdapter createAdapter(Context context, NetConfig netConfig) {
        if (netConfig == null) {
            netConfig = NetConfig.create().setForceHttps(true).setAdapterType(AdapterType.URL);
        }
        int[] iArr = AnonymousClass2.f147601a;
        netConfig.getAdapterType().ordinal();
        lr lrVar = new lr();
        lrVar.initNet(context, netConfig);
        return lrVar;
    }

    public static synchronized NetManager getInstance() {
        NetManager netManager;
        synchronized (NetManager.class) {
            if (sInstance == null) {
                sInstance = new NetManager();
            }
            netManager = sInstance;
        }
        return netManager;
    }

    public static void init(Context context, NetConfig netConfig) {
        getInstance().setAdapter(createAdapter(context, netConfig));
    }

    public void appendNetFlowRules(HashMap<String, String> hashMap) {
        NetAdapter netAdapter = this.mAdapter;
        if (netAdapter != null) {
            netAdapter.getNetFlowRuleList().putAll(hashMap);
        }
    }

    public boolean available() {
        if (this.mAdapter != null && this.mInited) {
            return true;
        }
        return false;
    }

    public NetRequest.NetRequestBuilder builder() {
        return builder("");
    }

    public NetResponse doGet(String str, String str2, int i3, int i16, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        return builder().url(str).retryNum(i3).header(hashMap).userAgent(str2).timeOut(i16).canceler(httpCanceler).doGet();
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i3, int i16, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        return builder().url(str).userAgent(str2).postData(bArr).retryNum(i3).header(hashMap).timeOut(i16).canceler(httpCanceler).doPost();
    }

    public NetResponse doRequest(NetRequest netRequest) {
        return builder(netRequest).doRequest();
    }

    public NetResponse doStream(NetRequest netRequest) {
        return builder(netRequest).doStream();
    }

    public LocationRegion.LocationRegionChangedListener getRegionChangedListener() {
        return this.thisRegionChangedListener;
    }

    public void setAdapter(Context context, NetAdapter netAdapter) {
        if (netAdapter instanceof URLNetImpl) {
            ((URLNetImpl) netAdapter).setProxyAdapter(createAdapter(context, NetConfig.create()));
        }
        setAdapter(netAdapter);
    }

    public NetRequest.NetRequestBuilder builder(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.mGlobalSecretKey;
        }
        NetRequest.NetRequestBuilder netRequestBuilder = new NetRequest.NetRequestBuilder(this.mAdapter, str, this.thisLocationRegion);
        netRequestBuilder.forceHttps(this.mGlobalForceHttps);
        return netRequestBuilder;
    }

    private void init() {
        NetAdapter netAdapter;
        if (this.mInited || (netAdapter = this.mAdapter) == null) {
            return;
        }
        this.mInited = true;
        this.thisLocationRegion = null;
        this.mGlobalForceHttps = netAdapter.isForceHttps();
        this.mGlobalSecretKey = this.mAdapter.getSecretKey();
        this.mGlobalNetFlowRuleList.putAll(this.mAdapter.getNetFlowRuleList());
        this.mGlobalNetFlowProcessorClzList.addAll(this.mAdapter.getNetFlowProcessor());
    }

    private NetRequest.NetRequestBuilder builder(NetRequest netRequest) {
        return new NetRequest.NetRequestBuilder(this.mAdapter, this.mGlobalSecretKey, this.thisLocationRegion, netRequest);
    }

    void setAdapter(NetAdapter netAdapter) {
        NetAdapter netAdapter2;
        if (netAdapter == null || (netAdapter2 = this.mAdapter) == netAdapter) {
            return;
        }
        this.mInited = false;
        if (netAdapter2 != null) {
            netAdapter.getNetFlowRuleList().putAll(this.mAdapter.getNetFlowRuleList());
        }
        this.mAdapter = netAdapter;
        init();
    }
}
