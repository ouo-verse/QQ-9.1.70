package com.tencent.mobileqq.search.business.game;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lo2.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c f283032a;

    /* renamed from: b, reason: collision with root package name */
    private WadlTrpcListener f283033b = new C8528a();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.business.game.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8528a implements WadlTrpcListener {
        C8528a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("/v1/483");
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (a.this.f283032a == null) {
                QLog.e("GameSearchHandler", 1, "onTrpcRsp mGameSearchListener == null");
            } else if ("/v1/483".equals(str)) {
                a.this.d(intent, j3, trpcInovkeRsp);
            }
        }
    }

    public a(c cVar) {
        this.f283032a = cVar;
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f283033b);
    }

    protected s b(String str, GameCenterSearchGame$UnifyGameInfo gameCenterSearchGame$UnifyGameInfo) {
        UnifySearchCommon$ResultItem c16 = c(gameCenterSearchGame$UnifyGameInfo);
        if (c16 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        s sVar = new s(str, 1109, arrayList, c16, -1);
        sVar.f415274g0 = true;
        return sVar;
    }

    protected UnifySearchCommon$ResultItem c(GameCenterSearchGame$UnifyGameInfo gameCenterSearchGame$UnifyGameInfo) {
        if (gameCenterSearchGame$UnifyGameInfo == null) {
            return null;
        }
        try {
            String str = gameCenterSearchGame$UnifyGameInfo.appid.get();
            String str2 = gameCenterSearchGame$UnifyGameInfo.name.get();
            String str3 = gameCenterSearchGame$UnifyGameInfo.icon.get();
            String str4 = gameCenterSearchGame$UnifyGameInfo.jump_url.get();
            List<String> list = gameCenterSearchGame$UnifyGameInfo.tags.get();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.mo162put(list.get(i3));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", str);
            jSONObject.put(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, jSONArray);
            UnifySearchCommon$ResultItem unifySearchCommon$ResultItem = new UnifySearchCommon$ResultItem();
            unifySearchCommon$ResultItem.name.set(ByteStringMicro.copyFromUtf8(str2));
            unifySearchCommon$ResultItem.pic_url.set(ByteStringMicro.copyFromUtf8(str3));
            unifySearchCommon$ResultItem.jmp_url.set(ByteStringMicro.copyFromUtf8(str4));
            unifySearchCommon$ResultItem.layout_id.set(21);
            unifySearchCommon$ResultItem.layout_content.set(ByteStringMicro.copyFromUtf8(jSONObject.toString()));
            unifySearchCommon$ResultItem.group_mask.set(1109L);
            return unifySearchCommon$ResultItem;
        } catch (JSONException e16) {
            QLog.e("GameSearchHandler", 1, "covertToResultItem e:", e16);
            return null;
        }
    }

    protected void d(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (this.f283032a != null && intent != null) {
            String stringExtra = intent.getStringExtra("search_words");
            if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
                try {
                    GameCenterSearchGame$UnifySearchGameRsp gameCenterSearchGame$UnifySearchGameRsp = new GameCenterSearchGame$UnifySearchGameRsp();
                    gameCenterSearchGame$UnifySearchGameRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    this.f283032a.kc(stringExtra, 0L, f(stringExtra, gameCenterSearchGame$UnifySearchGameRsp));
                    return;
                } catch (Throwable th5) {
                    QLog.e("GameSearchHandler", 1, "handleGameSearch error:", th5);
                    return;
                }
            }
            this.f283032a.kc(stringExtra, j3, null);
            QLog.e("GameSearchHandler", 1, "handleGameSearch failed, ret:", Long.valueOf(j3));
        }
    }

    public void e() {
        this.f283032a = null;
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f283033b);
    }

    protected List<s> f(String str, GameCenterSearchGame$UnifySearchGameRsp gameCenterSearchGame$UnifySearchGameRsp) {
        ArrayList arrayList = new ArrayList();
        if (!gameCenterSearchGame$UnifySearchGameRsp.games.has()) {
            return arrayList;
        }
        for (int i3 = 0; i3 < gameCenterSearchGame$UnifySearchGameRsp.games.size(); i3++) {
            s b16 = b(str, gameCenterSearchGame$UnifySearchGameRsp.games.get(i3));
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        return arrayList;
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            GameCenterSearchGame$UnifySearchGameReq gameCenterSearchGame$UnifySearchGameReq = new GameCenterSearchGame$UnifySearchGameReq();
            gameCenterSearchGame$UnifySearchGameReq.search_key.set(str);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/483", false, gameCenterSearchGame$UnifySearchGameReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putString("search_words", str);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Throwable th5) {
            QLog.e("GameSearchHandler", 1, "searchGameList error:", th5);
        }
    }
}
