package com.tencent.qqlive.superplayer.vinfo.live;

import android.net.ParseException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ads.data.AdParam;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.superplayer.tools.utils.f;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.qqlive.superplayer.tools.utils.h;
import com.tencent.qqlive.superplayer.tools.utils.i;
import com.tencent.qqlive.superplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vt3.d;
import vt3.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKLiveInfoRequest {

    /* renamed from: l, reason: collision with root package name */
    private static long f345603l;

    /* renamed from: m, reason: collision with root package name */
    private static long f345604m;

    /* renamed from: a, reason: collision with root package name */
    private String f345605a;

    /* renamed from: b, reason: collision with root package name */
    private TVKUserInfo f345606b;

    /* renamed from: c, reason: collision with root package name */
    private String f345607c;

    /* renamed from: d, reason: collision with root package name */
    private a f345608d;

    /* renamed from: e, reason: collision with root package name */
    private int f345609e;

    /* renamed from: f, reason: collision with root package name */
    private String f345610f;

    /* renamed from: g, reason: collision with root package name */
    private String f345611g;

    /* renamed from: h, reason: collision with root package name */
    private int f345612h;

    /* renamed from: i, reason: collision with root package name */
    private int f345613i = 0;

    /* renamed from: j, reason: collision with root package name */
    @UrlState
    private int f345614j;

    /* renamed from: k, reason: collision with root package name */
    private c f345615k;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface UrlState {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TVKLiveInfoRequest(int i3, TVKUserInfo tVKUserInfo, String str, String str2, a aVar, c cVar) {
        this.f345605a = "";
        this.f345607c = "";
        this.f345608d = null;
        if (aVar != null) {
            if (str != null) {
                String trim = str.trim();
                if (trim.length() != 0) {
                    this.f345606b = tVKUserInfo;
                    this.f345605a = trim;
                    this.f345607c = str2;
                    this.f345608d = aVar;
                    this.f345609e = i3;
                    this.f345615k = cVar;
                    return;
                }
                throw new NullPointerException("progId is blank");
            }
            throw new NullPointerException("progId is null");
        }
        throw new NullPointerException("callback is null");
    }

    private void A(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (65 == d.G.a().intValue()) {
            map.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.ENCRYPT_VER_4);
        } else if (66 == d.G.a().intValue()) {
            map.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.ENCRYPT_VER_4_2);
        } else {
            map.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.ENCRYPT_VER_5);
        }
    }

    private void B(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (this.f345606b.getLoginType() == 2) {
            map.put(TPReportKeys.Common.COMMON_LOGIN_TYPE, "1");
        } else if (this.f345606b.getLoginType() == 3) {
            map.put(TPReportKeys.Common.COMMON_LOGIN_TYPE, "2");
        }
    }

    private void C(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (this.f345606b.isVip()) {
            map.put("vip_status", String.valueOf(1));
        } else {
            map.put("vip_status", String.valueOf(0));
        }
    }

    static /* synthetic */ int c(TVKLiveInfoRequest tVKLiveInfoRequest) {
        int i3 = tVKLiveInfoRequest.f345612h;
        tVKLiveInfoRequest.f345612h = i3 + 1;
        return i3;
    }

    static /* synthetic */ int j(TVKLiveInfoRequest tVKLiveInfoRequest) {
        int i3 = tVKLiveInfoRequest.f345613i;
        tVKLiveInfoRequest.f345613i = i3 + 1;
        return i3;
    }

    private String k(@UrlState int i3) {
        if (1 == i3) {
            return vt3.c.f443370n;
        }
        if (2 == i3) {
            return vt3.c.f443371o;
        }
        return vt3.c.f443370n;
    }

    private String m(int i3, String str) {
        c cVar = this.f345615k;
        if (cVar != null && cVar.f()) {
            String cKey = CKeyFacade.getCKey(tt3.a.e(), e.f443494a, this.f345605a, tt3.a.d(), String.valueOf(i3), str, new int[]{1}, 1, "");
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "[vinfo][getvinfo] GenCkey guid = " + tt3.a.e() + " thisTime = " + e.f443494a + " vid = " + this.f345605a + " appVer = " + tt3.a.d() + " platform = " + i3 + " sdtFrom = " + str + " ckey= " + cKey);
            return cKey;
        }
        int[] iArr = {0, 0, 0};
        c cVar2 = this.f345615k;
        if (cVar2 != null && cVar2.a() != null && this.f345615k.a().containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_TOUSHE) && this.f345615k.a().containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM)) {
            String str2 = this.f345615k.a().get(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM);
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "toushe, from_platform =" + str2);
            iArr[0] = 16;
            iArr[1] = g.i(str2, i3);
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        String cKey2 = CKeyFacade.getCKey(tt3.a.e(), e.f443494a, this.f345605a, tt3.a.d(), String.valueOf(i3), str, iArr, 3, "");
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "[vinfo][getvinfo] GenCkey guid = " + tt3.a.e() + " thisTime = " + e.f443494a + " vid = " + this.f345605a + " appVer = " + tt3.a.d() + " platform = " + i3 + " sdtFrom = " + str + " externs[0] = " + iArr[0] + " externs[1] = " + iArr[1] + " externs[2] = " + iArr[2] + " ckey= " + cKey2);
        return cKey2;
    }

    private Map<String, String> n() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "qqlive");
        TVKUserInfo tVKUserInfo = this.f345606b;
        if (tVKUserInfo != null && !TextUtils.isEmpty(tVKUserInfo.getLoginCookie())) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "cookie = " + this.f345606b.getLoginCookie());
            hashMap.put("Cookie", this.f345606b.getLoginCookie());
        } else {
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "cookie is empty");
        }
        return hashMap;
    }

    private int o() {
        if (h.q(tt3.a.c())) {
            if (h.m(tt3.a.c()) == 1) {
                return 1;
            }
            if (h.m(tt3.a.c()) == 2) {
                return 2;
            }
            if (h.m(tt3.a.c()) == 3 || h.m(tt3.a.c()) != 4) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private int p() {
        int f16 = tt3.a.f();
        c cVar = this.f345615k;
        if (cVar != null && cVar.d() != null) {
            return this.f345615k.d().getPlatform();
        }
        return f16;
    }

    private void r(TVKLiveVideoInfo tVKLiveVideoInfo, JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("formats");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                if (optJSONArray.getJSONObject(i3) != null) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    TVKNetVideoInfo.DefnInfo defnInfo = new TVKNetVideoInfo.DefnInfo();
                    defnInfo.setDefn(jSONObject2.optString("fn"));
                    defnInfo.setDefnShowName(jSONObject2.optString("fnname"));
                    defnInfo.setVip(jSONObject2.optInt("vip"));
                    defnInfo.setDefnId(jSONObject2.optInt("id"));
                    defnInfo.setDefnName(jSONObject2.optString("defnname"));
                    defnInfo.setDefnRate(jSONObject2.optString("defnrate"));
                    if (tVKLiveVideoInfo.getCurDefinition() != null && tVKLiveVideoInfo.getCurDefinition().getDefn() != null && tVKLiveVideoInfo.getCurDefinition().getDefn().equalsIgnoreCase(defnInfo.getDefn())) {
                        tVKLiveVideoInfo.getCurDefinition().setDefnName(defnInfo.getDefnName());
                        tVKLiveVideoInfo.getCurDefinition().setVip(defnInfo.isVip());
                        tVKLiveVideoInfo.getCurDefinition().setDefnShowName(defnInfo.getDefnShowName());
                        tVKLiveVideoInfo.getCurDefinition().setDefnRate(defnInfo.getDefnRate());
                    }
                    tVKLiveVideoInfo.addDefinition(defnInfo);
                }
            }
        }
    }

    private void s(TVKLiveVideoInfo tVKLiveVideoInfo, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject.has("live360_info") && (optJSONObject = jSONObject.optJSONObject("live360_info")) != null && optJSONObject.has("lens_direction")) {
            int optInt = optJSONObject.optInt("lens_direction");
            if (1 == optInt) {
                tVKLiveVideoInfo.setLensDirection(1);
            } else if (2 == optInt) {
                tVKLiveVideoInfo.setLensDirection(2);
            }
        }
    }

    private int u(JSONObject jSONObject, String str, int i3) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return i3;
    }

    private long v(JSONObject jSONObject, String str, long j3) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return j3;
    }

    private String w(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return str2;
    }

    private TVKLiveVideoInfo x(String str) throws JSONException {
        TVKLiveVideoInfo tVKLiveVideoInfo = new TVKLiveVideoInfo();
        tVKLiveVideoInfo.setXml(str);
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt("iretcode");
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "errcode " + optInt);
        tVKLiveVideoInfo.setRetCode(optInt);
        tVKLiveVideoInfo.setErrtitle(w(jSONObject, "errtitle", null));
        tVKLiveVideoInfo.setSubErrType(u(jSONObject, "type", 0));
        if (jSONObject.has("playurl")) {
            String optString = jSONObject.optString("playurl");
            tVKLiveVideoInfo.setPlayUrl(optString);
            tVKLiveVideoInfo.setOriginalPlayUrl(optString);
        }
        c cVar = this.f345615k;
        if (cVar != null) {
            tVKLiveVideoInfo.setGetDlnaUrl(cVar.f());
            tVKLiveVideoInfo.setGetPreviewInfo(this.f345615k.b());
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("backurl_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            String[] strArr = new String[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                strArr[i3] = optJSONArray.getJSONObject(i3).getString("url");
            }
            tVKLiveVideoInfo.setBackPlayUrl(strArr);
        }
        tVKLiveVideoInfo.setCdnId(u(jSONObject, TPReportKeys.Common.COMMON_CDN_ID, 0));
        tVKLiveVideoInfo.setPlayTime(u(jSONObject, TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, 0));
        tVKLiveVideoInfo.setStream(u(jSONObject, "stream", 0));
        tVKLiveVideoInfo.setPrePlayTime(u(jSONObject, "totalplaytime", 0));
        tVKLiveVideoInfo.setNeedPay(u(jSONObject, "ispay", 0));
        tVKLiveVideoInfo.setPay(u(jSONObject, TPReportKeys.LiveExKeys.LIVE_EX_IS_USER_PAY, 0));
        tVKLiveVideoInfo.setPrePlayCountPerDay(u(jSONObject, "previewcnt", 0));
        tVKLiveVideoInfo.setRestPrePlayCount(u(jSONObject, "restpreviewcnt", 0));
        tVKLiveVideoInfo.setServerTime(v(jSONObject, "svrtick", 0L));
        tVKLiveVideoInfo.setErrInfo(w(jSONObject, "errinfo", null));
        tVKLiveVideoInfo.setRand(w(jSONObject, "rand", null));
        tVKLiveVideoInfo.setBufferLoadingTime(u(jSONObject, "load", 0));
        tVKLiveVideoInfo.setSecondBufferTime(u(jSONObject, "buffer", 0));
        tVKLiveVideoInfo.setSecondMinBufferTime(u(jSONObject, Element.ELEMENT_NAME_MIN, 0));
        tVKLiveVideoInfo.setSecondMaxBufferTime(u(jSONObject, "max", 0));
        tVKLiveVideoInfo.setTargetId(w(jSONObject, "targetid", null));
        tVKLiveVideoInfo.setDanmuState(u(jSONObject, "bullet_flag", 0));
        tVKLiveVideoInfo.setQueueStatus(u(jSONObject, "queue_status", 0));
        tVKLiveVideoInfo.setQueueRank(u(jSONObject, "queue_rank", 0));
        tVKLiveVideoInfo.setQueueVipJump(u(jSONObject, "queue_vip_jump", 0));
        tVKLiveVideoInfo.setQueueSessionKey(w(jSONObject, "queue_session_key", null));
        tVKLiveVideoInfo.setIretDetailCode(u(jSONObject, "iretdetailcode", 0));
        tVKLiveVideoInfo.setLive360(u(jSONObject, "live360", 0));
        tVKLiveVideoInfo.setAcode(u(jSONObject, "acode", 0));
        tVKLiveVideoInfo.setVcode(u(jSONObject, "vcode", 0));
        int optInt2 = jSONObject.optInt("acode");
        int optInt3 = jSONObject.optInt("vcode");
        if (optInt3 == 2) {
            tVKLiveVideoInfo.setIsHevc(true);
        } else {
            tVKLiveVideoInfo.setIsHevc(false);
        }
        if (jSONObject.has("defn")) {
            TVKNetVideoInfo.DefnInfo defnInfo = new TVKNetVideoInfo.DefnInfo();
            defnInfo.setVideoCodec(optInt3);
            defnInfo.setAudioCodec(optInt2);
            defnInfo.setDefn(jSONObject.optString("defn"));
            defnInfo.setDefnName(com.tencent.qqlive.superplayer.tools.utils.a.a(jSONObject.optString("defn")));
            tVKLiveVideoInfo.setCurDefinition(defnInfo);
        }
        if (jSONObject.has("playback") && !TextUtils.isEmpty(jSONObject.getString("playback"))) {
            try {
                tVKLiveVideoInfo.setPlayBackStart(new JSONObject(jSONObject.getString("playback")).optLong("playbackstart"));
                tVKLiveVideoInfo.setPlayBackTime(r4.optInt("playbacktime"));
                tVKLiveVideoInfo.setSvrTick(r4.optInt("svrtick"));
            } catch (JSONException e16) {
                com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayerMgr[TVKLiveInfoRequest.java]", "parseJson error = " + e16.toString());
            }
        }
        r(tVKLiveVideoInfo, jSONObject);
        s(tVKLiveVideoInfo, jSONObject);
        tVKLiveVideoInfo.setHlsp2p(jSONObject.optInt("hlsp2p"));
        return tVKLiveVideoInfo;
    }

    private void z(Map<String, String> map) {
        if (map == null) {
            return;
        }
        c cVar = this.f345615k;
        if (cVar != null && cVar.e()) {
            map.put("audio_format", "2");
        } else {
            map.put("audio_format", "1");
        }
    }

    public void l() {
        this.f345611g = q(this.f345614j);
        com.tencent.qqlive.superplayer.tools.utils.c.a().b(this.f345611g, n(), 5000, new ITVKHttpProcessor.b() { // from class: com.tencent.qqlive.superplayer.vinfo.live.TVKLiveInfoRequest.1
            @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
            public void onFailure(IOException iOException) {
                com.tencent.qqlive.superplayer.tools.utils.d.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "livecgi error = " + iOException.toString());
                if (TVKLiveInfoRequest.this.f345612h <= 3) {
                    if (TVKLiveInfoRequest.this.f345614j == 1) {
                        TVKLiveInfoRequest.this.f345614j = 2;
                    } else {
                        TVKLiveInfoRequest.this.f345614j = 1;
                    }
                    com.tencent.qqlive.superplayer.tools.utils.d.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", " change host, retry");
                    TVKLiveInfoRequest.c(TVKLiveInfoRequest.this);
                    com.tencent.qqlive.superplayer.tools.utils.d.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", " retry count " + TVKLiveInfoRequest.this.f345612h);
                    TVKLiveInfoRequest.this.l();
                    return;
                }
                TVKLiveVideoInfo tVKLiveVideoInfo = new TVKLiveVideoInfo();
                tVKLiveVideoInfo.setErrModule(10000);
                tVKLiveVideoInfo.setRetCode(141001);
                tVKLiveVideoInfo.setErrInfo("getvinfo retry count Limit exceeded!");
                TVKLiveInfoRequest.this.f345608d.b(TVKLiveInfoRequest.this.f345609e, tVKLiveVideoInfo);
            }

            @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
            public void onSuccess(ITVKHttpProcessor.a aVar) {
                final String str = new String(aVar.f345470b);
                if (str.length() > 0) {
                    try {
                        if (!TVKLiveInfoRequest.this.t(str) || TVKLiveInfoRequest.this.f345613i >= 3) {
                            TVKLiveInfoRequest.this.f345613i = 0;
                            TVKLiveInfoRequest.this.f345614j = 1;
                            TVKLiveInfoRequest.this.f345612h = 1;
                            try {
                                f.f345491a.execute(new Runnable() { // from class: com.tencent.qqlive.superplayer.vinfo.live.TVKLiveInfoRequest.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            TVKLiveVideoInfo y16 = TVKLiveInfoRequest.this.y(str);
                                            if (y16 != null) {
                                                if (!TVKLiveInfoRequest.this.f345608d.a()) {
                                                    TVKLiveInfoRequest.this.f345608d.c(TVKLiveInfoRequest.this.f345609e, y16);
                                                    return;
                                                }
                                                return;
                                            }
                                            throw new Exception("parse failed");
                                        } catch (ParseException e16) {
                                            com.tencent.qqlive.superplayer.tools.utils.d.b("MediaPlayerMgr[TVKLiveInfoRequest.java]", e16);
                                            TVKLiveVideoInfo tVKLiveVideoInfo = new TVKLiveVideoInfo();
                                            tVKLiveVideoInfo.setErrModule(10000);
                                            tVKLiveVideoInfo.setErrInfo("json \u89e3\u6790\u5f02\u5e38");
                                            tVKLiveVideoInfo.setRetCode(121008);
                                            TVKLiveInfoRequest.this.f345608d.b(TVKLiveInfoRequest.this.f345609e, tVKLiveVideoInfo);
                                        } catch (Throwable th5) {
                                            com.tencent.qqlive.superplayer.tools.utils.d.b("MediaPlayerMgr[TVKLiveInfoRequest.java]", th5);
                                            TVKLiveVideoInfo tVKLiveVideoInfo2 = new TVKLiveVideoInfo();
                                            tVKLiveVideoInfo2.setErrModule(10000);
                                            tVKLiveVideoInfo2.setErrInfo(VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT);
                                            tVKLiveVideoInfo2.setRetCode(141001);
                                            TVKLiveInfoRequest.this.f345608d.b(TVKLiveInfoRequest.this.f345609e, tVKLiveVideoInfo2);
                                        }
                                    }
                                });
                                return;
                            } catch (Throwable th5) {
                                com.tencent.qqlive.superplayer.tools.utils.d.b("MediaPlayerMgr[TVKLiveInfoRequest.java]", th5);
                                return;
                            }
                        }
                        com.tencent.qqlive.superplayer.tools.utils.d.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", String.format("[err85]On success:ResponseBody = %s,", str));
                        TVKLiveInfoRequest.this.l();
                        TVKLiveInfoRequest.j(TVKLiveInfoRequest.this);
                    } catch (ParseException e16) {
                        com.tencent.qqlive.superplayer.tools.utils.d.b("MediaPlayerMgr[TVKLiveInfoRequest.java]", e16);
                        TVKLiveVideoInfo tVKLiveVideoInfo = new TVKLiveVideoInfo();
                        tVKLiveVideoInfo.setErrModule(10000);
                        tVKLiveVideoInfo.setErrInfo(e16.getMessage());
                        tVKLiveVideoInfo.setRetCode(121008);
                        TVKLiveInfoRequest.this.f345608d.b(TVKLiveInfoRequest.this.f345609e, tVKLiveVideoInfo);
                    }
                }
            }
        });
    }

    protected String q(@UrlState int i3) {
        Map<String, String> hashMap;
        int c16;
        String k3 = k(i3);
        if (!TextUtils.isEmpty(tt3.a.f437461b) && tt3.a.f437460a != null && h.r(tt3.a.c()) && !this.f345615k.f()) {
            hashMap = tt3.a.f437460a;
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put(TVKLiveRequestBuilder.RequestParamKey.SID, this.f345605a);
        hashMap.put("cmd", "2");
        int p16 = p();
        String g16 = tt3.a.g();
        c cVar = this.f345615k;
        if (cVar != null && cVar.d() != null) {
            g16 = tt3.a.h(p16);
        }
        hashMap.put("platform", String.valueOf(p16));
        hashMap.put("sdtfrom", g16);
        c cVar2 = this.f345615k;
        if (cVar2 == null) {
            c16 = 2;
        } else {
            c16 = cVar2.c();
        }
        hashMap.put("stream", String.valueOf(c16));
        hashMap.put(AdParam.APPVER, tt3.a.d());
        hashMap.put("guid", tt3.a.e());
        hashMap.put("qq", this.f345606b.getUin());
        hashMap.put("wxopenid", this.f345606b.getWxOpenID());
        hashMap.put("defn", this.f345607c);
        hashMap.put(AdParam.OTYPE, ark.ARKMETADATA_JSON);
        hashMap.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(Math.random()));
        z(hashMap);
        c cVar3 = this.f345615k;
        if (cVar3 != null && cVar3.b()) {
            hashMap.put("getpreviewinfo", "1");
        }
        B(hashMap);
        C(hashMap);
        A(hashMap);
        if (!TextUtils.isEmpty(this.f345606b.getOauthConsumeKey())) {
            hashMap.put("openid", this.f345606b.getOpenId());
            hashMap.put(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, this.f345606b.getAccessToken());
            hashMap.put(AdParam.PF, this.f345606b.getPf());
            hashMap.put(AdParam.CONSUMERID, this.f345606b.getOauthConsumeKey());
        }
        hashMap.put("newnettype", String.valueOf(o()));
        long j3 = e.f443494a;
        if (j3 == 0 && f345604m == 0) {
            e.f443494a = System.currentTimeMillis() / 1000;
        } else if (j3 == 0 && f345604m != 0) {
            e.f443494a = ((System.currentTimeMillis() / 1000) - f345604m) + f345603l;
        }
        hashMap.put("fntick", String.valueOf(e.f443494a));
        f345604m = System.currentTimeMillis() / 1000;
        f345603l = e.f443494a;
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): GenCkey version = " + tt3.a.d() + " time=" + e.f443494a + " lasttime = " + f345603l + " vid= " + this.f345605a + " platform=" + p16 + ", sdtfrom=" + g16);
        this.f345610f = m(p16, g16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getRequestUrl(): ckey5 = ");
        sb5.append(this.f345610f);
        sb5.append(" platform =");
        sb5.append(p16);
        sb5.append(", sdtfrom=");
        sb5.append(g16);
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", sb5.toString());
        hashMap.put("cKey", this.f345610f);
        c cVar4 = this.f345615k;
        if (cVar4 != null && cVar4.a() != null) {
            for (Map.Entry<String, String> entry : this.f345615k.a().entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (d.I2.a().booleanValue()) {
            hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_ACTIVE_SP, "1");
        }
        String c17 = new i().d(k3).b(hashMap).c();
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): url = " + c17);
        return c17;
    }

    protected boolean t(String str) {
        TVKLiveVideoInfo y16 = y(str);
        if (y16 != null && y16.getRetCode() == 32 && y16.getSubErrType() == -3) {
            e.f443494a = y16.getServerTime();
            e.f443496c = y16.getRand();
            e.f443495b = SystemClock.elapsedRealtime();
            return true;
        }
        return false;
    }

    protected TVKLiveVideoInfo y(String str) throws ParseException {
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr", "[TVKLiveInfoProcessor] httpBodyText = " + str);
        try {
            return x(str);
        } catch (JSONException e16) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr", "[TVKLiveInfoProcessor] parse error!");
            com.tencent.qqlive.superplayer.tools.utils.d.b("MediaPlayerMgr[TVKLiveInfoRequest.java]", e16);
            return null;
        }
    }
}
