package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetManager;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse;
import com.tencent.mapsdk.core.components.protocol.jce.sso.CmdResult;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Header;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Package;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Tag;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response;
import com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t;
import com.tencent.mapsdk.internal.co;
import com.tencent.tencentmap.mapsdk.maps.CustomLocationProvider;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import com.tencent.tencentmap.mapsdk.maps.model.LocationRegion;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class cr extends bo implements cn, TencentMapProtocol {

    /* renamed from: b, reason: collision with root package name */
    private static final String f148064b = "cuid";

    /* renamed from: c, reason: collision with root package name */
    private static final String f148065c = "duid";

    /* renamed from: d, reason: collision with root package name */
    private static final String f148066d = "sessionid";

    /* renamed from: g, reason: collision with root package name */
    private static final Stack<cj> f148067g = new Stack<>();

    /* renamed from: e, reason: collision with root package name */
    private cj f148068e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f148069f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private String f148070h;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a implements TencentMapServiceProtocol.IMapService {

        /* renamed from: a, reason: collision with root package name */
        co.a f148071a;

        public a(co.a aVar) {
            this.f148071a = aVar;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService
        public final void setAllow(boolean z16) {
            this.f148071a.a(z16);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService
        public final void setUseHttps(boolean z16) {
            this.f148071a.c(z16);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService
        public final void setUseTest(boolean z16) {
            this.f148071a.b(z16);
        }
    }

    public cr() {
    }

    private void b(String str, String str2) {
        if (hs.a(str2)) {
            return;
        }
        this.f148069f.put(str, str2);
    }

    public static ct f() {
        Stack<cj> stack = f148067g;
        if (stack.isEmpty()) {
            return new cu();
        }
        return stack.peek().f148048b;
    }

    private static HashMap<String, Map<String, String>> g() {
        HashMap<String, Map<String, String>> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        if (CustomLocationProvider.getInstance().hasLocationSource()) {
            hashMap2.put("apikey.map.qq.com", "apikey-cn.map.qq.com");
            hashMap2.put("s0.map.gtimg.com", "s0-cn.map.gtimg.com");
            hashMap2.put("s1.map.gtimg.com", "s1-cn.map.gtimg.com");
            hashMap2.put("s2.map.gtimg.com", "s2-cn.map.gtimg.com");
            hashMap2.put("s3.map.gtimg.com", "s3-cn.map.gtimg.com");
            hashMap2.put("overseactrl.map.qq.com", "overseactrl-cn.map.qq.com");
            hashMap2.put("sdkgw.map.qq.com", "sdkgw-cn.map.qq.com");
            hashMap2.put("pr.map.qq.com", "pr-cn.map.qq.com");
            hashMap2.put("datalayer.map.qq.com", "datalayer-cn.map.qq.com");
            hashMap2.put("vectorsdk.map.qq.com", "vectorsdk-cn.map.qq.com");
            hashMap2.put("tafrtt.map.qq.com", "tafrtt-cn.map.qq.com");
            hashMap2.put("p0.map.gtimg.com", "p0-cn.map.gtimg.com");
            hashMap2.put("p1.map.gtimg.com", "p1-cn.map.gtimg.com");
            hashMap2.put("p2.map.gtimg.com", "p2-cn.map.gtimg.com");
            hashMap2.put("p3.map.gtimg.com", "p3-cn.map.gtimg.com");
        }
        hashMap.put(LocationRegion.RegionName.INLAND_WITHOUT_SAR_OF_CHINA.name(), hashMap2);
        return hashMap;
    }

    private static HashMap<String, String> h() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("apikey.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
        hashMap.put("apikey-cn.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
        hashMap.put("vectorsdk.map.qq.com/mvd_map", "map_nf_mvd");
        hashMap.put("vectorsdk-cn.map.qq.com/mvd_map", "map_nf_mvd");
        hashMap.put("vectorsdk.map.qq.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("vectorsdk-cn.map.qq.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("p0.map.gtimg.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("p0-cn.map.gtimg.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("vectorsdk.map.qq.com/indoormap2", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormap2", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormap2/index", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormap2/index", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormapx", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormapx", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormapx/index", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormapx/index", "map_nf_indoor");
        hashMap.put("tafrtt.map.qq.com/rttserverex/", "map_nf_trfc");
        hashMap.put("tafrtt-cn.map.qq.com/rttserverex/", "map_nf_trfc");
        hashMap.put("p0.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p0-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p1.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p1-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p2.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p2-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p3.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p3-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("apikey.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
        hashMap.put("apikey-cn.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
        hashMap.put("overseactrl.map.qq.com", "map_nf_wdVer");
        hashMap.put("overseactrl-cn.map.qq.com", "map_nf_wdVer");
        hashMap.put("s0.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s0-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s1.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s1-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s2.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s2-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s3.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s3-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("confinfo.map.qq.com/confinfo", "map_nf_hdVer");
        hashMap.put("confinfo-cn.map.qq.com/confinfo", "map_nf_hdVer");
        hashMap.put("p0.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p0-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p1.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p1-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p2.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p2-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p3.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p3-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("sdkgw.map.qq.com/map/traffic/event", "map_nf_pnt");
        hashMap.put("sdkgw-cn.map.qq.com/map/traffic/event", "map_nf_pnt");
        hashMap.put("sdkgw.map.qq.com/map/poi/detail", "map_nf_aoi");
        hashMap.put("sdkgw-cn.map.qq.com/map/poi/detail", "map_nf_aoi");
        hashMap.put("mapapi.qq.com/sdk/", "map_nf_res");
        hashMap.put("wecar.myapp.com/myapp/mapwecar", "map_nf_res");
        hashMap.put("map.myapp.com/soso_map/", "map_nf_off");
        hashMap.put("pr.map.qq.com/ditusdk/monitor", "map_nf_pr");
        hashMap.put("pr-cn.map.qq.com/ditusdk/monitor", "map_nf_pr");
        hashMap.put("pr.map.qq.com/pingd", "map_nf_pr");
        hashMap.put("pr-cn.map.qq.com/pingd", "map_nf_pr");
        hashMap.put("sdkgw.map.qq.com/sdk/log", "map_nf_pr");
        hashMap.put("sdkgw-cn.map.qq.com/sdk/log", "map_nf_pr");
        hashMap.put("s0.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s0-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s1.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s1-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s2.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s2-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s3.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s3-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("datalayer.map.qq.com/console/datalayer/data", "map_nf_visLyr");
        hashMap.put("datalayer-cn.map.qq.com/console/datalayer/data", "map_nf_visLyr");
        return hashMap;
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void a(bp bpVar, Bundle bundle) {
        super.a(bpVar, bundle);
        ho.a(f().a());
    }

    @Override // com.tencent.mapsdk.internal.cn
    public final Map<String, String> a_() {
        if (!TextUtils.isEmpty(this.f148070h)) {
            b(f148064b, this.f148070h);
        }
        b(f148065c, ho.e());
        b(f148066d, ht.a());
        return this.f148069f;
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void d(bp bpVar) {
        cj cjVar;
        super.d(bpVar);
        Stack<cj> stack = f148067g;
        if (!stack.isEmpty() && (cjVar = this.f148068e) != null) {
            stack.remove(cjVar);
            this.f148068e = null;
        }
    }

    public final cj e() {
        if (this.f148068e == null) {
            Stack<cj> stack = f148067g;
            if (!stack.isEmpty()) {
                this.f148068e = stack.peek();
            } else {
                this.f148068e = new ck();
            }
        }
        return this.f148068e;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol
    public TencentMapServiceProtocol.IMapService getMapService(String str) {
        cp b16;
        cj e16 = e();
        this.f148068e = e16;
        if (e16 != null && (b16 = e16.b(str)) != null) {
            return new a(b16);
        }
        return null;
    }

    cr(cj cjVar) {
        this.f148068e = cjVar;
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void a(bp bpVar) {
        cj a16;
        super.a(bpVar);
        if (bpVar == null) {
            return;
        }
        TencentMapOptions tencentMapOptions = bpVar.f147915b;
        if (tencentMapOptions != null) {
            this.f148070h = tencentMapOptions.getCustomUserId();
            Object protocolDataDesc = tencentMapOptions.getProtocolDataDesc();
            String str = bpVar.D().f147925a;
            if (this.f148068e == null) {
                this.f148068e = new ck();
            }
            if (protocolDataDesc != null) {
                int protocolFrom = tencentMapOptions.getProtocolFrom();
                if (protocolFrom == -1) {
                    a16 = a(bpVar, str, (String) protocolDataDesc);
                } else if (protocolFrom != 1) {
                    a16 = protocolFrom != 3 ? null : a(str, (String) protocolDataDesc);
                } else {
                    a16 = a(str, bpVar.getContext().getResources().openRawResource(((Integer) protocolDataDesc).intValue()));
                }
                if (a16 != null) {
                    this.f148068e = a16;
                }
            }
            cj cjVar = this.f148068e;
            if (cjVar != null) {
                cjVar.f148047a = str;
            } else {
                this.f148068e = new ck();
            }
            f148067g.push(this.f148068e);
            Context c16 = c();
            NetConfig arguments = NetConfig.create().setAdapterType(tencentMapOptions.getNetAdapterType()).setLogEnable(tf.f150437d).setForceHttps(tencentMapOptions.isForceHttps()).setArguments(tencentMapOptions.getNetParams());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("apikey.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
            hashMap.put("apikey-cn.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
            hashMap.put("vectorsdk.map.qq.com/mvd_map", "map_nf_mvd");
            hashMap.put("vectorsdk-cn.map.qq.com/mvd_map", "map_nf_mvd");
            hashMap.put("vectorsdk.map.qq.com/fileupdate", "map_nf_mapcfg");
            hashMap.put("vectorsdk-cn.map.qq.com/fileupdate", "map_nf_mapcfg");
            hashMap.put("p0.map.gtimg.com/fileupdate", "map_nf_mapcfg");
            hashMap.put("p0-cn.map.gtimg.com/fileupdate", "map_nf_mapcfg");
            hashMap.put("vectorsdk.map.qq.com/indoormap2", "map_nf_indoor");
            hashMap.put("vectorsdk-cn.map.qq.com/indoormap2", "map_nf_indoor");
            hashMap.put("vectorsdk.map.qq.com/indoormap2/index", "map_nf_indoor");
            hashMap.put("vectorsdk-cn.map.qq.com/indoormap2/index", "map_nf_indoor");
            hashMap.put("vectorsdk.map.qq.com/indoormapx", "map_nf_indoor");
            hashMap.put("vectorsdk-cn.map.qq.com/indoormapx", "map_nf_indoor");
            hashMap.put("vectorsdk.map.qq.com/indoormapx/index", "map_nf_indoor");
            hashMap.put("vectorsdk-cn.map.qq.com/indoormapx/index", "map_nf_indoor");
            hashMap.put("tafrtt.map.qq.com/rttserverex/", "map_nf_trfc");
            hashMap.put("tafrtt-cn.map.qq.com/rttserverex/", "map_nf_trfc");
            hashMap.put("p0.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p0-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p1.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p1-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p2.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p2-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p3.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("p3-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
            hashMap.put("apikey.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
            hashMap.put("apikey-cn.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
            hashMap.put("overseactrl.map.qq.com", "map_nf_wdVer");
            hashMap.put("overseactrl-cn.map.qq.com", "map_nf_wdVer");
            hashMap.put("s0.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s0-cn.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s1.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s1-cn.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s2.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s2-cn.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s3.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("s3-cn.map.gtimg.com/oversea", "map_nf_wdTile");
            hashMap.put("confinfo.map.qq.com/confinfo", "map_nf_hdVer");
            hashMap.put("confinfo-cn.map.qq.com/confinfo", "map_nf_hdVer");
            hashMap.put("p0.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p0-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p1.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p1-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p2.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p2-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p3.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("p3-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
            hashMap.put("sdkgw.map.qq.com/map/traffic/event", "map_nf_pnt");
            hashMap.put("sdkgw-cn.map.qq.com/map/traffic/event", "map_nf_pnt");
            hashMap.put("sdkgw.map.qq.com/map/poi/detail", "map_nf_aoi");
            hashMap.put("sdkgw-cn.map.qq.com/map/poi/detail", "map_nf_aoi");
            hashMap.put("mapapi.qq.com/sdk/", "map_nf_res");
            hashMap.put("wecar.myapp.com/myapp/mapwecar", "map_nf_res");
            hashMap.put("map.myapp.com/soso_map/", "map_nf_off");
            hashMap.put("pr.map.qq.com/ditusdk/monitor", "map_nf_pr");
            hashMap.put("pr-cn.map.qq.com/ditusdk/monitor", "map_nf_pr");
            hashMap.put("pr.map.qq.com/pingd", "map_nf_pr");
            hashMap.put("pr-cn.map.qq.com/pingd", "map_nf_pr");
            hashMap.put("sdkgw.map.qq.com/sdk/log", "map_nf_pr");
            hashMap.put("sdkgw-cn.map.qq.com/sdk/log", "map_nf_pr");
            hashMap.put("s0.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s0-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s1.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s1-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s2.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s2-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s3.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("s3-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
            hashMap.put("datalayer.map.qq.com/console/datalayer/data", "map_nf_visLyr");
            hashMap.put("datalayer-cn.map.qq.com/console/datalayer/data", "map_nf_visLyr");
            NetConfig netFlowRuleList = arguments.setNetFlowRuleList(hashMap);
            HashMap<String, Map<String, String>> hashMap2 = new HashMap<>();
            HashMap hashMap3 = new HashMap();
            if (CustomLocationProvider.getInstance().hasLocationSource()) {
                hashMap3.put("apikey.map.qq.com", "apikey-cn.map.qq.com");
                hashMap3.put("s0.map.gtimg.com", "s0-cn.map.gtimg.com");
                hashMap3.put("s1.map.gtimg.com", "s1-cn.map.gtimg.com");
                hashMap3.put("s2.map.gtimg.com", "s2-cn.map.gtimg.com");
                hashMap3.put("s3.map.gtimg.com", "s3-cn.map.gtimg.com");
                hashMap3.put("overseactrl.map.qq.com", "overseactrl-cn.map.qq.com");
                hashMap3.put("sdkgw.map.qq.com", "sdkgw-cn.map.qq.com");
                hashMap3.put("pr.map.qq.com", "pr-cn.map.qq.com");
                hashMap3.put("datalayer.map.qq.com", "datalayer-cn.map.qq.com");
                hashMap3.put("vectorsdk.map.qq.com", "vectorsdk-cn.map.qq.com");
                hashMap3.put("tafrtt.map.qq.com", "tafrtt-cn.map.qq.com");
                hashMap3.put("p0.map.gtimg.com", "p0-cn.map.gtimg.com");
                hashMap3.put("p1.map.gtimg.com", "p1-cn.map.gtimg.com");
                hashMap3.put("p2.map.gtimg.com", "p2-cn.map.gtimg.com");
                hashMap3.put("p3.map.gtimg.com", "p3-cn.map.gtimg.com");
            }
            hashMap2.put(LocationRegion.RegionName.INLAND_WITHOUT_SAR_OF_CHINA.name(), hashMap3);
            NetManager.init(c16, netFlowRuleList.setRegionHostList(hashMap2).setProcessor(gr.class).setProxyRuleList(f().b()));
        }
        ho.a(f().a());
    }

    @Override // com.tencent.mapsdk.internal.cn
    public final List<Class<? extends p>> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Basic.class);
        arrayList.add(Detail.class);
        arrayList.add(Response.class);
        arrayList.add(RttRequest.class);
        arrayList.add(RttResponse.class);
        arrayList.add(user_login_t.class);
        arrayList.add(CmdResult.class);
        arrayList.add(Header.class);
        arrayList.add(Package.class);
        arrayList.add(Tag.class);
        arrayList.add(CSFileUpdateReq.class);
        arrayList.add(FileUpdateReq.class);
        arrayList.add(FileUpdateRsp.class);
        arrayList.add(SCFileUpdateRsp.class);
        return arrayList;
    }

    private static void a(Context context, TencentMapOptions tencentMapOptions) {
        NetConfig arguments = NetConfig.create().setAdapterType(tencentMapOptions.getNetAdapterType()).setLogEnable(tf.f150437d).setForceHttps(tencentMapOptions.isForceHttps()).setArguments(tencentMapOptions.getNetParams());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("apikey.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
        hashMap.put("apikey-cn.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
        hashMap.put("vectorsdk.map.qq.com/mvd_map", "map_nf_mvd");
        hashMap.put("vectorsdk-cn.map.qq.com/mvd_map", "map_nf_mvd");
        hashMap.put("vectorsdk.map.qq.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("vectorsdk-cn.map.qq.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("p0.map.gtimg.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("p0-cn.map.gtimg.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("vectorsdk.map.qq.com/indoormap2", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormap2", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormap2/index", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormap2/index", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormapx", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormapx", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormapx/index", "map_nf_indoor");
        hashMap.put("vectorsdk-cn.map.qq.com/indoormapx/index", "map_nf_indoor");
        hashMap.put("tafrtt.map.qq.com/rttserverex/", "map_nf_trfc");
        hashMap.put("tafrtt-cn.map.qq.com/rttserverex/", "map_nf_trfc");
        hashMap.put("p0.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p0-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p1.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p1-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p2.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p2-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p3.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p3-cn.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("apikey.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
        hashMap.put("apikey-cn.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
        hashMap.put("overseactrl.map.qq.com", "map_nf_wdVer");
        hashMap.put("overseactrl-cn.map.qq.com", "map_nf_wdVer");
        hashMap.put("s0.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s0-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s1.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s1-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s2.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s2-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s3.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s3-cn.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("confinfo.map.qq.com/confinfo", "map_nf_hdVer");
        hashMap.put("confinfo-cn.map.qq.com/confinfo", "map_nf_hdVer");
        hashMap.put("p0.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p0-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p1.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p1-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p2.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p2-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p3.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p3-cn.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("sdkgw.map.qq.com/map/traffic/event", "map_nf_pnt");
        hashMap.put("sdkgw-cn.map.qq.com/map/traffic/event", "map_nf_pnt");
        hashMap.put("sdkgw.map.qq.com/map/poi/detail", "map_nf_aoi");
        hashMap.put("sdkgw-cn.map.qq.com/map/poi/detail", "map_nf_aoi");
        hashMap.put("mapapi.qq.com/sdk/", "map_nf_res");
        hashMap.put("wecar.myapp.com/myapp/mapwecar", "map_nf_res");
        hashMap.put("map.myapp.com/soso_map/", "map_nf_off");
        hashMap.put("pr.map.qq.com/ditusdk/monitor", "map_nf_pr");
        hashMap.put("pr-cn.map.qq.com/ditusdk/monitor", "map_nf_pr");
        hashMap.put("pr.map.qq.com/pingd", "map_nf_pr");
        hashMap.put("pr-cn.map.qq.com/pingd", "map_nf_pr");
        hashMap.put("sdkgw.map.qq.com/sdk/log", "map_nf_pr");
        hashMap.put("sdkgw-cn.map.qq.com/sdk/log", "map_nf_pr");
        hashMap.put("s0.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s0-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s1.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s1-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s2.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s2-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s3.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s3-cn.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("datalayer.map.qq.com/console/datalayer/data", "map_nf_visLyr");
        hashMap.put("datalayer-cn.map.qq.com/console/datalayer/data", "map_nf_visLyr");
        NetConfig netFlowRuleList = arguments.setNetFlowRuleList(hashMap);
        HashMap<String, Map<String, String>> hashMap2 = new HashMap<>();
        HashMap hashMap3 = new HashMap();
        if (CustomLocationProvider.getInstance().hasLocationSource()) {
            hashMap3.put("apikey.map.qq.com", "apikey-cn.map.qq.com");
            hashMap3.put("s0.map.gtimg.com", "s0-cn.map.gtimg.com");
            hashMap3.put("s1.map.gtimg.com", "s1-cn.map.gtimg.com");
            hashMap3.put("s2.map.gtimg.com", "s2-cn.map.gtimg.com");
            hashMap3.put("s3.map.gtimg.com", "s3-cn.map.gtimg.com");
            hashMap3.put("overseactrl.map.qq.com", "overseactrl-cn.map.qq.com");
            hashMap3.put("sdkgw.map.qq.com", "sdkgw-cn.map.qq.com");
            hashMap3.put("pr.map.qq.com", "pr-cn.map.qq.com");
            hashMap3.put("datalayer.map.qq.com", "datalayer-cn.map.qq.com");
            hashMap3.put("vectorsdk.map.qq.com", "vectorsdk-cn.map.qq.com");
            hashMap3.put("tafrtt.map.qq.com", "tafrtt-cn.map.qq.com");
            hashMap3.put("p0.map.gtimg.com", "p0-cn.map.gtimg.com");
            hashMap3.put("p1.map.gtimg.com", "p1-cn.map.gtimg.com");
            hashMap3.put("p2.map.gtimg.com", "p2-cn.map.gtimg.com");
            hashMap3.put("p3.map.gtimg.com", "p3-cn.map.gtimg.com");
        }
        hashMap2.put(LocationRegion.RegionName.INLAND_WITHOUT_SAR_OF_CHINA.name(), hashMap3);
        NetManager.init(context, netFlowRuleList.setRegionHostList(hashMap2).setProcessor(gr.class).setProxyRuleList(f().b()));
    }

    private void a(bp bpVar, TencentMapOptions tencentMapOptions) {
        cj a16;
        Object protocolDataDesc = tencentMapOptions.getProtocolDataDesc();
        String str = bpVar.D().f147925a;
        if (this.f148068e == null) {
            this.f148068e = new ck();
        }
        if (protocolDataDesc != null) {
            int protocolFrom = tencentMapOptions.getProtocolFrom();
            if (protocolFrom == -1) {
                a16 = a(bpVar, str, (String) protocolDataDesc);
            } else if (protocolFrom != 1) {
                a16 = protocolFrom != 3 ? null : a(str, (String) protocolDataDesc);
            } else {
                a16 = a(str, bpVar.getContext().getResources().openRawResource(((Integer) protocolDataDesc).intValue()));
            }
            if (a16 != null) {
                this.f148068e = a16;
            }
        }
        cj cjVar = this.f148068e;
        if (cjVar != null) {
            cjVar.f148047a = str;
        } else {
            this.f148068e = new ck();
        }
        f148067g.push(this.f148068e);
    }

    private cj a(bp bpVar, String str, String str2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = bpVar.getContext().getResources().getAssets().open(str2);
        } catch (IOException e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            ku.a((Closeable) inputStream2);
            throw th;
        }
        try {
            try {
                cj a16 = a(str, inputStream);
                ku.a((Closeable) inputStream);
                return a16;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                ku.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            e.printStackTrace();
            ku.a((Closeable) inputStream);
            return null;
        }
    }

    private cj a(bp bpVar, String str, int i3) {
        return a(str, bpVar.getContext().getResources().openRawResource(i3));
    }

    private cj a(String str, InputStream inputStream) {
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (-1 != read) {
                                byteArrayOutputStream2.write(bArr, 0, read);
                            } else {
                                cj a16 = a(str, new String(byteArrayOutputStream2.toByteArray(), Charset.forName("UTF-8")));
                                ku.a(byteArrayOutputStream2);
                                ku.a((Closeable) inputStream);
                                return a16;
                            }
                        } catch (IOException e16) {
                            e = e16;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            e.printStackTrace();
                            ku.a(byteArrayOutputStream);
                            ku.a((Closeable) inputStream);
                            return new ck();
                        } catch (Throwable th5) {
                            th = th5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            ku.a(byteArrayOutputStream);
                            ku.a((Closeable) inputStream);
                            throw th;
                        }
                    }
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return new ck();
    }

    private cj a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(cl.f148056c, "-1");
            String optString2 = jSONObject.optString(cl.f148057d, "_unknown");
            if (!"-1".equals(optString) && optString2.equals(str)) {
                cq cqVar = new cq();
                cqVar.f148047a = str;
                cqVar.a(this);
                JSONArray optJSONArray = jSONObject.optJSONArray("services");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        cqVar.a(optJSONArray.getJSONObject(i3));
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(cm.f148058e);
                if (optJSONObject != null) {
                    cs csVar = (cs) JsonUtils.parseToModel(optJSONObject, cs.class, new Object[0]);
                    cu cuVar = cqVar.f148048b;
                    cuVar.f148074a = csVar.f148072a;
                    cuVar.f148075b = csVar.f148073b;
                }
                return cqVar;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return new ck();
    }

    public static <S extends cp> S a(Class<S> cls) {
        Stack<cj> stack = f148067g;
        if (stack.isEmpty()) {
            return (S) new ck().c(cls);
        }
        return (S) stack.peek().c(cls);
    }

    @Override // com.tencent.mapsdk.internal.cn
    public final Map<String, Class<? extends co.a>> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, dm.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_INDOOR_DATA, Cdo.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_DATA, dr.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_STYLE, dt.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_RTT_DATA, dw.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_SATELLITE_DATA, dx.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_SKETCH_DATA, dy.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_OVERSEA_DATA, dv.class);
        hashMap.put("statistic", dz.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_TRAFFIC_EVENT, ea.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_OFFLINE_MAP_DATA, du.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_POI_DATA, ds.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_PROMOTE_IMAGE_DATA, ch.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_BEHAVIOUR, dq.class);
        return hashMap;
    }
}
