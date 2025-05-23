package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.commonModule.d;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85$GetRankListReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85$GetRankListRspBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85$ReportScoreReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85$ReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85$RspBody;
import tencent.im.oidb.ranklist_comm.ranklist_comm$ExtraParam;
import tencent.im.oidb.ranklist_comm.ranklist_comm$RankItem;
import tencent.im.oidb.ranklist_comm.ranklist_comm$ReportItem;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends com.tencent.mobileqq.Doraemon.e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final String f154148c;

    /* renamed from: b, reason: collision with root package name */
    private final String f154149b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.commonModule.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7078a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.c f154150d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f154151e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154152f;

        C7078a(d.c cVar, JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154150d = cVar;
            this.f154151e = jSONObject;
            this.f154152f = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, cVar, jSONObject, aVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(a.f154148c, 2, "onResult appid=" + ((com.tencent.mobileqq.Doraemon.e) a.this).f154095a.f154071c + ", openid=" + this.f154150d.f154173a + ", openkey=" + this.f154150d.f154174b + ", code=" + i3 + ", req param=" + this.f154151e);
            }
            if (i3 == 0 && bArr != null) {
                Oidb_0xb85$RspBody oidb_0xb85$RspBody = new Oidb_0xb85$RspBody();
                try {
                    oidb_0xb85$RspBody.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    oidb_0xb85$RspBody = null;
                }
                if (oidb_0xb85$RspBody != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Oidb_0xb85$GetRankListRspBody oidb_0xb85$GetRankListRspBody = oidb_0xb85$RspBody.get_ranklist_rsp.get();
                        for (ranklist_comm$RankItem ranklist_comm_rankitem : oidb_0xb85$GetRankListRspBody.rpt_rank_item.get()) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("nickName", ranklist_comm_rankitem.nick.get());
                                jSONObject2.put(PhotoCategorySummaryInfo.AVATAR_URL, ranklist_comm_rankitem.figure.get());
                                jSONObject2.put(LocalPhotoFaceInfo.SCORE, ranklist_comm_rankitem.value.get());
                                jSONObject2.put("rank", ranklist_comm_rankitem.rank.get());
                                jSONArray.mo162put(jSONObject2);
                            } catch (JSONException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(a.f154148c, 2, e17.getMessage(), e17);
                                }
                            }
                        }
                        jSONObject.put("rankingList", jSONArray);
                        JSONObject jSONObject3 = new JSONObject();
                        ranklist_comm$RankItem ranklist_comm_rankitem2 = oidb_0xb85$GetRankListRspBody.self_rank_item.get();
                        jSONObject3.put("nickName", ranklist_comm_rankitem2.nick.get());
                        jSONObject3.put(PhotoCategorySummaryInfo.AVATAR_URL, ranklist_comm_rankitem2.figure.get());
                        jSONObject3.put(LocalPhotoFaceInfo.SCORE, ranklist_comm_rankitem2.value.get());
                        jSONObject3.put("rank", ranklist_comm_rankitem2.rank.get());
                        jSONObject.put("selfRank", jSONObject3);
                    } catch (JSONException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e(a.f154148c, 2, e18.getMessage(), e18);
                        }
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i(a.f154148c, 2, "result is, " + jSONObject.toString());
                    }
                    DoraemonUtil.e(this.f154152f, jSONObject);
                    return;
                }
                DoraemonUtil.c(this.f154152f, -1, "parse result error, try again");
                return;
            }
            DoraemonUtil.c(this.f154152f, i3, "getRankingList result error, try again");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.c f154154d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f154155e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154156f;

        b(d.c cVar, JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154154d = cVar;
            this.f154155e = jSONObject;
            this.f154156f = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, cVar, jSONObject, aVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(a.f154148c, 2, "onResult appid=" + ((com.tencent.mobileqq.Doraemon.e) a.this).f154095a.f154071c + ", openid=" + this.f154154d.f154173a + ", openkey=" + this.f154154d.f154174b + ", code=" + i3 + ", req param=" + this.f154155e);
            }
            if (i3 == 0 && bArr != null) {
                DoraemonUtil.e(this.f154156f, com.tencent.mobileqq.Doraemon.c.f154094a);
            } else {
                DoraemonUtil.c(this.f154156f, i3, "reportScore result error, try again");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f154148c = "DoraemonOpenAPI." + a.class.getSimpleName();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f154149b = "OidbSvc.0xb85";
        }
    }

    private void g(JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i(f154148c + ".getRankingList", 2, "params = " + jSONObject);
        }
        int optInt = jSONObject.optInt("rankingID", 0);
        int optInt2 = jSONObject.optInt("topCount", 10);
        String optString = jSONObject.optString("rankKey", "");
        int optInt3 = jSONObject.optInt("rankValueType", 0);
        int optInt4 = jSONObject.optInt("rankOrderType", 0);
        if (optInt <= 0) {
            DoraemonUtil.c(aVar, -100, "rankingID must be bigger than 0");
            return;
        }
        d dVar = (d) this.f154095a.i(d.class, false);
        if (dVar == null) {
            DoraemonUtil.c(aVar, -10, "internal error, try again.");
            return;
        }
        Oidb_0xb85$ReqBody oidb_0xb85$ReqBody = new Oidb_0xb85$ReqBody();
        d.c f16 = dVar.f();
        oidb_0xb85$ReqBody.appid.set(Integer.valueOf(this.f154095a.f154071c).intValue());
        oidb_0xb85$ReqBody.service_id.set(this.f154095a.f154070b);
        oidb_0xb85$ReqBody.openid.set(f16.f154173a);
        oidb_0xb85$ReqBody.openkey.set(f16.f154174b);
        Oidb_0xb85$GetRankListReqBody oidb_0xb85$GetRankListReqBody = new Oidb_0xb85$GetRankListReqBody();
        oidb_0xb85$GetRankListReqBody.ranklist_id.set(optInt);
        oidb_0xb85$GetRankListReqBody.top_count.set(optInt2);
        if (!TextUtils.isEmpty(optString)) {
            oidb_0xb85$GetRankListReqBody.rank_key.set(optString);
        }
        oidb_0xb85$GetRankListReqBody.rank_value_type.set(optInt3);
        oidb_0xb85$GetRankListReqBody.rank_order_type.set(optInt4);
        oidb_0xb85$ReqBody.get_ranklist_req.set(oidb_0xb85$GetRankListReqBody);
        ProtoUtils.c(BaseApplicationImpl.getApplication().getRuntime(), new C7078a(f16, jSONObject, aVar), oidb_0xb85$ReqBody.toByteArray(), "OidbSvc.0xb85", 2949, 2, null, 0L);
    }

    private void h(JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i(f154148c + ".reportScore", 2, "params = " + jSONObject);
        }
        int i3 = 0;
        int optInt = jSONObject.optInt("rankingID", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("scoreList");
        if (optInt <= 0) {
            DoraemonUtil.c(aVar, -100, "rankingID \u6ca1\u6709\u4f20\u6216\u8005\u503c\u5c0f\u4e8e\u7b49\u4e8e0");
            return;
        }
        d dVar = (d) this.f154095a.i(d.class, false);
        if (dVar == null) {
            QLog.e(f154148c, 1, "reportScore, getAPIModule UserInfoModule return null");
            return;
        }
        Oidb_0xb85$ReqBody oidb_0xb85$ReqBody = new Oidb_0xb85$ReqBody();
        d.c f16 = dVar.f();
        oidb_0xb85$ReqBody.appid.set(Integer.valueOf(this.f154095a.f154071c).intValue());
        oidb_0xb85$ReqBody.service_id.set(this.f154095a.f154070b);
        oidb_0xb85$ReqBody.openid.set(f16.f154173a);
        oidb_0xb85$ReqBody.openkey.set(f16.f154174b);
        Oidb_0xb85$ReportScoreReqBody oidb_0xb85$ReportScoreReqBody = new Oidb_0xb85$ReportScoreReqBody();
        oidb_0xb85$ReportScoreReqBody.ranklist_id.set(optInt);
        try {
            int length = optJSONArray.length();
            int i16 = 0;
            while (i16 < length) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                ranklist_comm$ReportItem ranklist_comm_reportitem = new ranklist_comm$ReportItem();
                ranklist_comm_reportitem.openid.set(jSONObject2.getString("openid"));
                ranklist_comm_reportitem.score.set(jSONObject2.getInt(LocalPhotoFaceInfo.SCORE));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("extraList");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    int i17 = i3;
                    while (i17 < length2) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i17);
                        ranklist_comm$ExtraParam ranklist_comm_extraparam = new ranklist_comm$ExtraParam();
                        ranklist_comm_extraparam.param_key.set(jSONObject3.getString("key"));
                        ranklist_comm_extraparam.param_value.set(jSONObject3.getInt("value"));
                        ranklist_comm_extraparam.param_type.set(jSONObject3.getInt("type"));
                        ranklist_comm_reportitem.rpt_extra_param.add(ranklist_comm_extraparam);
                        i17++;
                        length = length;
                    }
                }
                int i18 = length;
                oidb_0xb85$ReportScoreReqBody.rpt_report_item.add(ranklist_comm_reportitem);
                i16++;
                length = i18;
                i3 = 0;
            }
            oidb_0xb85$ReqBody.report_score_req.set(oidb_0xb85$ReportScoreReqBody);
            ProtoUtils.c(BaseApplicationImpl.getApplication().getRuntime(), new b(f16, jSONObject, aVar), oidb_0xb85$ReqBody.toByteArray(), "OidbSvc.0xb85", 2949, 1, null, 0L);
        } catch (Exception e16) {
            DoraemonUtil.c(aVar, -101, "\u53c2\u6570\u5904\u7406\u9519\u8bef, \u662f\u5426\u662f\u7c7b\u578b\u4e0d\u5bf9? \u67e5\u770b\u4e00\u4e0b\u6587\u6863\u5427. \nerrorMsg: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 8) {
            if (i3 != 24) {
                return false;
            }
            h(jSONObject, aVar);
        } else {
            g(jSONObject, aVar);
        }
        return true;
    }
}
