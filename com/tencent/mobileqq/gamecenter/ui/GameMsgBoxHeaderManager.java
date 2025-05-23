package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$OperateContentReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$OperateContentRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$RedDotMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameMsgBoxHeaderManager implements WadlTrpcListener, com.tencent.mobileqq.gamecenter.api.e {

    /* renamed from: d, reason: collision with root package name */
    private final FrameLayout f213253d;

    /* renamed from: e, reason: collision with root package name */
    private final u f213254e;

    /* renamed from: f, reason: collision with root package name */
    private final r f213255f;

    /* renamed from: h, reason: collision with root package name */
    private final List<b> f213256h;

    /* renamed from: i, reason: collision with root package name */
    private final d f213257i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.c
        public void a() {
            GameMsgMgrSvr$RedDotMsg i3 = GameMsgBoxHeaderManager.this.f213254e.i();
            if (i3 != null) {
                GameMsgBoxHeaderManager.this.m(i3, 2);
                GameMsgBoxHeaderManager.this.f213257i.g();
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.c
        public void b() {
            GameMsgMgrSvr$RedDotMsg i3 = GameMsgBoxHeaderManager.this.f213254e.i();
            if (i3 != null) {
                GameMsgBoxHeaderManager.this.m(i3, 1);
                GameMsgBoxHeaderManager.this.f213257i.i(i3.item_id.get());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        protected Context f213259a;

        /* renamed from: b, reason: collision with root package name */
        protected c f213260b;

        public b(Context context) {
            this.f213259a = context;
        }

        public abstract void a(@NonNull FrameLayout frameLayout);

        public abstract void b();

        public abstract boolean c();

        public abstract void d(String str);

        public void e(c cVar) {
            this.f213260b = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        long f213261a;

        /* renamed from: b, reason: collision with root package name */
        int f213262b;

        /* renamed from: c, reason: collision with root package name */
        long f213263c;

        /* renamed from: d, reason: collision with root package name */
        String f213264d;

        /* renamed from: e, reason: collision with root package name */
        int f213265e;

        /* renamed from: f, reason: collision with root package name */
        int f213266f;

        /* renamed from: g, reason: collision with root package name */
        long f213267g;

        /* renamed from: h, reason: collision with root package name */
        GameMsgMgrSvr$RedDotMsg f213268h;

        d() {
        }

        private String a(String str) {
            String str2;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str2 = peekAppRuntime.getCurrentUin();
            } else {
                str2 = "";
            }
            return str2 + "_" + str;
        }

        private MMKVOptionEntity c() {
            return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        }

        public GameMsgMgrSvr$RedDotMsg b() {
            if (System.currentTimeMillis() - this.f213261a > 3600000 || this.f213265e >= 2) {
                return null;
            }
            return this.f213268h;
        }

        public boolean d() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f213261a < 3600000) {
                return false;
            }
            if (DateUtils.isToday(this.f213263c) && this.f213262b >= 3) {
                return false;
            }
            if (this.f213266f >= 3 && currentTimeMillis - this.f213267g < 604800000) {
                return false;
            }
            return true;
        }

        public void e() {
            String decodeString = c().decodeString(a("game_msg_box_reddot_record"), null);
            QLog.i("GameMsgBoxHeaderManager", 2, "[loadRedDotRecord] record=" + decodeString);
            if (!TextUtils.isEmpty(decodeString)) {
                try {
                    JSONObject jSONObject = new JSONObject(decodeString);
                    this.f213261a = jSONObject.optLong("lastReqTime");
                    this.f213262b = jSONObject.optInt("reqCountToday");
                    this.f213263c = jSONObject.optLong("reqCountDateTime");
                    this.f213264d = jSONObject.optString("lastExposeItemId");
                    this.f213265e = jSONObject.optInt("lastItemExposeCount");
                    this.f213266f = jSONObject.optInt("exposeOnlyItemCount");
                    this.f213267g = jSONObject.optLong("exposeOnlyStartTime");
                } catch (JSONException e16) {
                    QLog.e("GameMsgBoxHeaderManager", 2, "[loadRedDotRecord] parse json error:", e16);
                }
            }
            byte[] decodeBytes = c().decodeBytes(a("game_msg_box_reddot_rawdata"), null);
            if (decodeBytes != null) {
                try {
                    GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg = new GameMsgMgrSvr$RedDotMsg();
                    gameMsgMgrSvr$RedDotMsg.mergeFrom(decodeBytes);
                    this.f213268h = gameMsgMgrSvr$RedDotMsg;
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.e("GameMsgBoxHeaderManager", 2, "[loadRedDotRecord] parse pb error:", e17);
                }
            }
        }

        public void f() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lastReqTime", this.f213261a);
                jSONObject.put("reqCountToday", this.f213262b);
                jSONObject.put("reqCountDateTime", this.f213263c);
                jSONObject.put("lastExposeItemId", this.f213264d);
                jSONObject.put("lastItemExposeCount", this.f213265e);
                jSONObject.put("exposeOnlyItemCount", this.f213266f);
                jSONObject.put("exposeOnlyStartTime", this.f213267g);
            } catch (JSONException e16) {
                QLog.e("GameMsgBoxHeaderManager", 2, "[saveRedDotRecord] error:", e16);
            }
            String jSONObject2 = jSONObject.toString();
            c().encodeString(a("game_msg_box_reddot_record"), jSONObject2);
            QLog.i("GameMsgBoxHeaderManager", 2, "[saveRedDotRecord] record=" + jSONObject2);
            GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg = this.f213268h;
            if (gameMsgMgrSvr$RedDotMsg != null) {
                c().encodeBytes(a("game_msg_box_reddot_rawdata"), gameMsgMgrSvr$RedDotMsg.toByteArray());
            } else {
                c().removeKey(a("game_msg_box_reddot_rawdata"));
            }
        }

        public void g() {
            this.f213266f = 0;
            this.f213267g = 0L;
            this.f213268h = null;
            f();
        }

        public void h(GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg) {
            this.f213268h = gameMsgMgrSvr$RedDotMsg;
            this.f213261a = System.currentTimeMillis();
            if (DateUtils.isToday(this.f213263c)) {
                this.f213262b++;
            } else {
                this.f213263c = this.f213261a;
                this.f213262b = 1;
            }
            f();
        }

        public void i(String str) {
            if (TextUtils.equals(str, this.f213264d)) {
                this.f213265e++;
            } else {
                this.f213265e = 1;
                this.f213264d = str;
                int i3 = this.f213266f + 1;
                this.f213266f = i3;
                if (i3 == 3) {
                    this.f213267g = System.currentTimeMillis();
                }
            }
            f();
        }
    }

    public GameMsgBoxHeaderManager(Context context) {
        this.f213253d = new FrameLayout(context);
        u uVar = new u(context);
        this.f213254e = uVar;
        r rVar = new r(context);
        this.f213255f = rVar;
        this.f213256h = Arrays.asList(uVar, rVar);
        this.f213257i = new d();
        f();
        h();
    }

    private void f() {
        this.f213254e.e(new a());
    }

    private void g() {
        boolean z16 = false;
        for (b bVar : this.f213256h) {
            if (bVar.c() && !z16) {
                QLog.i("GameMsgBoxHeaderManager", 2, "[changeHeaderItemShowStatus] show item=" + bVar);
                bVar.a(this.f213253d);
                z16 = true;
            } else {
                bVar.b();
            }
        }
    }

    private void h() {
        this.f213257i.e();
        GameMsgMgrSvr$RedDotMsg b16 = this.f213257i.b();
        if (b16 != null) {
            QLog.i("GameMsgBoxHeaderManager", 2, "[initData] use lastRedDotData");
            this.f213254e.n(b16);
            g();
            l(false, true);
            return;
        }
        boolean d16 = this.f213257i.d();
        QLog.i("GameMsgBoxHeaderManager", 2, "[initData] allowRedDotReq=" + d16);
        l(d16, true);
    }

    private static boolean i(GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg) {
        if (gameMsgMgrSvr$RedDotMsg != null && !TextUtils.isEmpty(gameMsgMgrSvr$RedDotMsg.item_id.get()) && !TextUtils.isEmpty(gameMsgMgrSvr$RedDotMsg.jump_url.get())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void j(GameMsgMgrSvr$OperateContentRsp gameMsgMgrSvr$OperateContentRsp) {
        if (i(gameMsgMgrSvr$OperateContentRsp.red_dot_msg)) {
            QLog.i("GameMsgBoxHeaderManager", 2, "[onGetRspData] has valid RedDotMsg data");
            this.f213254e.n(gameMsgMgrSvr$OperateContentRsp.red_dot_msg);
            this.f213257i.h(gameMsgMgrSvr$OperateContentRsp.red_dot_msg);
        }
        this.f213255f.l(gameMsgMgrSvr$OperateContentRsp.gift);
        g();
    }

    private void l(boolean z16, boolean z17) {
        QLog.i("GameMsgBoxHeaderManager", 2, "[requestData]");
        GameMsgMgrSvr$OperateContentReq gameMsgMgrSvr$OperateContentReq = new GameMsgMgrSvr$OperateContentReq();
        gameMsgMgrSvr$OperateContentReq.opt_type.set(0);
        gameMsgMgrSvr$OperateContentReq.need_gift.set(z17);
        gameMsgMgrSvr$OperateContentReq.need_red_dot_msg.set(z16);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1275", false, gameMsgMgrSvr$OperateContentReq.toByteArray());
        Bundle bundle = new Bundle();
        bundle.putString("cmd", "/v1/1275");
        bundle.putInt("req_opt_type", 0);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg, int i3) {
        GameMsgMgrSvr$OperateContentReq gameMsgMgrSvr$OperateContentReq = new GameMsgMgrSvr$OperateContentReq();
        gameMsgMgrSvr$OperateContentReq.opt_type.set(i3);
        gameMsgMgrSvr$OperateContentReq.red_dot_msg.set(gameMsgMgrSvr$RedDotMsg);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1275", false, gameMsgMgrSvr$OperateContentReq.toByteArray());
        Bundle bundle = new Bundle();
        bundle.putString("cmd", "/v1/1275");
        bundle.putInt("req_opt_type", i3);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.e
    public void a(String str) {
        Iterator<b> it = this.f213256h.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
        g();
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.2
            {
                add("/v1/1275");
            }
        };
    }

    @Override // com.tencent.mobileqq.gamecenter.api.e
    public View getRootView() {
        return this.f213253d;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && TextUtils.equals("/v1/1275", str)) {
            if (j3 == 0 && trpcInovkeRsp != null) {
                if (trpcInovkeRsp.data.get() == null) {
                    QLog.e("GameMsgBoxHeaderManager", 1, "[onTrpcRsp] data err, ret=" + j3 + ", rsp.ret=" + trpcInovkeRsp.ret + ", rsp.msg=" + trpcInovkeRsp.f106731msg);
                    return;
                }
                int intExtra = intent.getIntExtra("req_opt_type", -1);
                QLog.i("GameMsgBoxHeaderManager", 2, "[onTrpcRsp] ret=" + j3 + ", cmd=" + str + ", optType=" + intExtra);
                if (intExtra == 0) {
                    try {
                        final GameMsgMgrSvr$OperateContentRsp gameMsgMgrSvr$OperateContentRsp = new GameMsgMgrSvr$OperateContentRsp();
                        gameMsgMgrSvr$OperateContentRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameMsgBoxHeaderManager.this.j(gameMsgMgrSvr$OperateContentRsp);
                            }
                        });
                        return;
                    } catch (Exception e16) {
                        QLog.e("GameMsgBoxHeaderManager", 1, e16, new Object[0]);
                        return;
                    }
                }
                return;
            }
            QLog.e("GameMsgBoxHeaderManager", 1, "[onTrpcRsp] data err, illegal ret or empty rsp, ret=" + j3);
            return;
        }
        QLog.e("GameMsgBoxHeaderManager", 1, "[onTrpcRsp] cmd error, cmd=" + str);
    }
}
