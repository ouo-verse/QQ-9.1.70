package com.tencent.aelight.camera.aioeditor.capture.control;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.c;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import fr.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GetSingleFullMusicInfoTask extends AsyncStep<b> implements INetEngineListener {
    protected FlowMusic C;

    /* renamed from: d, reason: collision with root package name */
    private String f66670d;

    /* renamed from: e, reason: collision with root package name */
    private String f66671e;

    /* renamed from: f, reason: collision with root package name */
    private IHttpEngineService f66672f;

    /* renamed from: h, reason: collision with root package name */
    private ns.a f66673h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f66674i = new Object();

    /* renamed from: m, reason: collision with root package name */
    protected FlowMusic f66675m;

    public GetSingleFullMusicInfoTask(FlowMusic flowMusic, ns.a aVar) {
        this.f66675m = flowMusic;
        this.f66673h = aVar;
        QIMMusicConfigManager qIMMusicConfigManager = (QIMMusicConfigManager) f.c(2);
        this.f66671e = qIMMusicConfigManager.c().getCurrentAccountUin();
        this.f66672f = qIMMusicConfigManager.R;
    }

    private static Map<String, String> b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(MsfConstants.ATTRIBUTE_LOGIN_TYPE, String.valueOf(1));
        hashMap.put("uin", str);
        hashMap.put("ticket_type", "skey");
        hashMap.put(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, str2);
        return hashMap;
    }

    private String c(String str, Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (!map.isEmpty()) {
            boolean z16 = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z16) {
                    sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    z16 = false;
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "genQQMusicReqUrl url" + sb5.toString());
        }
        return sb5.toString();
    }

    private static String d(long j3) {
        String str = "OpitrtqeGzopIlwxs_2000000228_TCOHANTCNlddnsTY_uZliVvhTJzkDPlHX_" + j3;
        String lowerCase = c.b(str).toLowerCase();
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "generate the sign string, pre=" + str + ", md5=" + lowerCase);
        }
        return lowerCase;
    }

    private void g(boolean z16, FlowMusic flowMusic) {
        ns.a aVar = this.f66673h;
        if (aVar != null) {
            aVar.a(z16, flowMusic);
            return;
        }
        synchronized (this.f66674i) {
            this.f66674i.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        String str;
        FlowMusic flowMusic = this.f66675m;
        if (flowMusic != null) {
            str = flowMusic.songMid;
        } else {
            str = this.f66670d;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mPrioty = 1;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        httpNetReq.mCallback = this;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", "2000000228");
        hashMap.put("app_key", "TCOHANTCNlddnsTY");
        hashMap.put("device_id", ah.z());
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("sign", d(currentTimeMillis));
        hashMap.put("song_mid", str);
        hashMap.putAll(b(this.f66671e, "_FAKESKEY_"));
        httpNetReq.mReqUrl = c("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "QQMusicReq SingleFullMusicInfoTask songId:" + str);
        }
        IHttpEngineService iHttpEngineService = this.f66672f;
        if (iHttpEngineService != null) {
            iHttpEngineService.sendReq(httpNetReq);
            if (this.f66673h != null) {
                return 7;
            }
            synchronized (this.f66674i) {
                try {
                    this.f66674i.wait(30000L);
                } catch (Exception unused) {
                }
            }
            return 7;
        }
        QLog.e("IAutomator", 1, "QQMusicReq SingleFullMusicInfoTask do step failed, mHttpEngine is null!");
        return 6;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0116 -> B:18:0x0156). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0118 -> B:18:0x0156). Please report as a decompilation issue!!! */
    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        JSONObject optJSONObject;
        if (netResp.mHttpCode == 200) {
            byte[] bArr = netResp.mRespData;
            if (bArr != null) {
                String str = new String(bArr);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "GetSingleFullMusicInfoTask respJson =" + str);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("ret", -1) == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("songlist");
                        if (optJSONArray != null && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                            FlowMusic flowMusic = new FlowMusic();
                            this.C = flowMusic;
                            flowMusic.albumId = optJSONObject.optInt(QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID);
                            this.C.albumMid = optJSONObject.optString("album_mid");
                            this.C.albumName = optJSONObject.optString("album_name");
                            this.C.albumUrl = optJSONObject.optString("album_pic");
                            this.C.singerId = optJSONObject.optInt("singer_id");
                            this.C.singerMid = optJSONObject.optString("singer_mid");
                            this.C.singerName = optJSONObject.optString("singer_name");
                            this.C.songId = optJSONObject.optInt("song_id");
                            this.C.songMid = optJSONObject.optString("song_mid");
                            this.C.songName = optJSONObject.optString("song_name");
                            this.C.songPlayTime = optJSONObject.optInt("song_play_time");
                            this.C.userOwnRule = optJSONObject.optInt("user_own_rule");
                            this.C.url = optJSONObject.optString("song_play_url");
                            this.C.size = optJSONObject.optLong("song_size");
                            this.C.playable = optJSONObject.optInt("playable", 1);
                            this.C.storeTimeStamp = System.currentTimeMillis();
                            g(true, this.C);
                        }
                    } else {
                        g(false, null);
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "GetSingleFullMusicInfoTask e:" + e16.toString());
                    }
                }
                return;
            }
            g(false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + netResp.mHttpCode);
        }
        g(false, null);
    }

    public GetSingleFullMusicInfoTask(String str, ns.a aVar) {
        this.f66670d = str;
        this.f66673h = aVar;
        QIMMusicConfigManager qIMMusicConfigManager = (QIMMusicConfigManager) f.c(2);
        this.f66671e = qIMMusicConfigManager.c().getCurrentAccountUin();
        this.f66672f = qIMMusicConfigManager.R;
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
    }
}
