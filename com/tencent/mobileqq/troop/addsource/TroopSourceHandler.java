package com.tencent.mobileqq.troop.addsource;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.protofile.source.QunJoinUrlSvrPB$ButtonItem;
import com.tencent.protofile.source.QunJoinUrlSvrPB$GetInfoReq;
import com.tencent.protofile.source.QunJoinUrlSvrPB$GetInfoRsp;
import com.tencent.protofile.source.QunSourceSvrPB$ApplyReportReq;
import com.tencent.protofile.source.QunSourceSvrPB$SourceItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSourceHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f293814a;

    /* renamed from: b, reason: collision with root package name */
    private QunJoinUrlSvrPB$ButtonItem f293815b;

    /* renamed from: c, reason: collision with root package name */
    private List<QunSourceSvrPB$SourceItem> f293816c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f293823d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.addsource.a f293824e;

        a(Context context, com.tencent.mobileqq.troop.addsource.a aVar) {
            this.f293823d = context;
            this.f293824e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopSourceHandler.this, context, aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopSourceHandler.this.h(this.f293823d);
                this.f293824e.c();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements QActionSheet.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.addsource.a f293826d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f293827e;

        b(com.tencent.mobileqq.troop.addsource.a aVar, d dVar) {
            this.f293826d = aVar;
            this.f293827e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopSourceHandler.this, aVar, dVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QunSourceSvrPB$SourceItem p16 = this.f293826d.p();
            QLog.i("TroopSourceHandler", 1, "[showSourceSelector] onConfirm, item = " + p16);
            if (p16 == null) {
                return;
            }
            this.f293827e.a(p16);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("TroopSourceHandler", 1, "[showSourceSelector] onDismiss");
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopTrpcRemoteResponse);
                return;
            }
            QLog.i("TroopSourceHandler", 1, "[applySourceReport] onError, errorResponse = " + troopTrpcRemoteResponse.f293941msg);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopTrpcRemoteResponse);
                return;
            }
            QLog.i("TroopSourceHandler", 1, "[applySourceReport] onSuccess, successResponse = " + troopTrpcRemoteResponse);
        }
    }

    public TroopSourceHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f293816c = new ArrayList();
            this.f293814a = str;
        }
    }

    public static void d(String str, String str2) {
        QLog.i("TroopSourceHandler", 1, "[applySourceReport] troopUin = " + str + ", source = " + str2);
        try {
            long parseLong = Long.parseLong(str);
            QunSourceSvrPB$ApplyReportReq qunSourceSvrPB$ApplyReportReq = new QunSourceSvrPB$ApplyReportReq();
            qunSourceSvrPB$ApplyReportReq.group_id.set(parseLong);
            qunSourceSvrPB$ApplyReportReq.src_id.set(str2);
            ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.ecom.qun_source_svr.QunSourceSvr", "/trpc.ecom.qun_source_svr.QunSourceSvr/ApplyReport", qunSourceSvrPB$ApplyReportReq.toByteArray(), 1, null, new c());
        } catch (Exception e16) {
            QLog.e("TroopSourceHandler", 1, "e = " + e16);
        }
    }

    private int g(QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
        List<QunSourceSvrPB$SourceItem> list;
        if (qunSourceSvrPB$SourceItem != null && (list = this.f293816c) != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < this.f293816c.size(); i3++) {
                if (qunSourceSvrPB$SourceItem.f342212id.get().equals(this.f293816c.get(i3).f342212id.get())) {
                    return i3;
                }
            }
        }
        return 0;
    }

    public boolean e(QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qunSourceSvrPB$SourceItem)).booleanValue();
        }
        if (qunSourceSvrPB$SourceItem != null && qunSourceSvrPB$SourceItem.f342212id.get() != null && this.f293816c != null) {
            QLog.i("TroopSourceHandler", 1, "[checkCurSelectedItemValidation] sourceItem id = " + qunSourceSvrPB$SourceItem.f342212id.get() + ", sourceItems = " + this.f293816c);
            for (QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem2 : this.f293816c) {
                if (qunSourceSvrPB$SourceItem2 != null && qunSourceSvrPB$SourceItem2.f342212id.get() != null && qunSourceSvrPB$SourceItem2.f342212id.get().equals(qunSourceSvrPB$SourceItem.f342212id.get()) && qunSourceSvrPB$SourceItem2.custom_qr_code_url.get().equals(qunSourceSvrPB$SourceItem.custom_qr_code_url.get())) {
                    return true;
                }
            }
            return false;
        }
        QLog.i("TroopSourceHandler", 1, "[checkCurSelectedItemValidation] sourceItem = " + qunSourceSvrPB$SourceItem);
        return false;
    }

    public QunSourceSvrPB$SourceItem f(String str) {
        List<QunSourceSvrPB$SourceItem> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QunSourceSvrPB$SourceItem) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (list = this.f293816c) != null) {
            for (QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem : list) {
                if (qunSourceSvrPB$SourceItem != null && qunSourceSvrPB$SourceItem.f342212id.get() != null && qunSourceSvrPB$SourceItem.f342212id.get().equals(str)) {
                    return qunSourceSvrPB$SourceItem;
                }
            }
            return null;
        }
        QLog.i("TroopSourceHandler", 1, "[checkCurSelectedItemValidation] sourceId = " + str);
        return null;
    }

    public void h(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        QunJoinUrlSvrPB$ButtonItem qunJoinUrlSvrPB$ButtonItem = this.f293815b;
        if (qunJoinUrlSvrPB$ButtonItem == null) {
            QLog.i("TroopSourceHandler", 1, "[goToEditSource], qrDisplayBottomInfo = null");
            return;
        }
        String str = qunJoinUrlSvrPB$ButtonItem.jump_url.get();
        QLog.i("TroopSourceHandler", 1, "[goToEditSource], gotoEditUrl = " + str);
        if (str != null && !str.isEmpty()) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            context.startActivity(intent);
        }
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        List<QunSourceSvrPB$SourceItem> list = this.f293816c;
        if (list != null && list.size() > 1) {
            return true;
        }
        return false;
    }

    public QunSourceSvrPB$SourceItem j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QunSourceSvrPB$SourceItem) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        QLog.i("TroopSourceHandler", 1, "[parseSourceItem] itemJSONString = " + str);
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("_value");
            if (optJSONObject == null || optJSONObject.optString("id").isEmpty()) {
                return null;
            }
            QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem = new QunSourceSvrPB$SourceItem();
            qunSourceSvrPB$SourceItem.f342212id.set(optJSONObject.optString("id"));
            qunSourceSvrPB$SourceItem.name.set(optJSONObject.optString("name"));
            qunSourceSvrPB$SourceItem.url.set(optJSONObject.optString("url"));
            qunSourceSvrPB$SourceItem.num.set(optJSONObject.optInt(WidgetCacheConstellationData.NUM));
            qunSourceSvrPB$SourceItem.group_id.set(optJSONObject.optLong("group_id"));
            qunSourceSvrPB$SourceItem.status.set(optJSONObject.optInt("status"));
            qunSourceSvrPB$SourceItem.create_time.set(optJSONObject.optLong(AlbumCacheData.CREATE_TIME));
            qunSourceSvrPB$SourceItem.update_time.set(optJSONObject.optLong("update_time"));
            qunSourceSvrPB$SourceItem.desc.set(optJSONObject.optString("desc"));
            return qunSourceSvrPB$SourceItem;
        } catch (Exception e16) {
            QLog.e("TroopSourceHandler", 1, "[parseSourceItem] exception = " + e16);
            return null;
        }
    }

    public void k(com.tencent.mobileqq.troop.addsource.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        QLog.i("TroopSourceHandler", 1, "[reqSourceList] invoke");
        f fVar = new f(bVar) { // from class: com.tencent.mobileqq.troop.addsource.TroopSourceHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.troop.addsource.b f293817a;

            {
                this.f293817a = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSourceHandler.this, (Object) bVar);
                }
            }

            @Override // com.tencent.mobileqq.troop.api.f
            public void a(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopTrpcRemoteResponse);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(troopTrpcRemoteResponse) { // from class: com.tencent.mobileqq.troop.addsource.TroopSourceHandler.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TroopTrpcRemoteResponse f293819d;

                        {
                            this.f293819d = troopTrpcRemoteResponse;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) troopTrpcRemoteResponse);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            QLog.i("TroopSourceHandler", 1, "[reqSourceList] onError, error = " + this.f293819d);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.troop.api.f
            public void b(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) troopTrpcRemoteResponse);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(troopTrpcRemoteResponse) { // from class: com.tencent.mobileqq.troop.addsource.TroopSourceHandler.1.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TroopTrpcRemoteResponse f293821d;

                        {
                            this.f293821d = troopTrpcRemoteResponse;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) troopTrpcRemoteResponse);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                if (this.f293821d.data != null) {
                                    QunJoinUrlSvrPB$GetInfoRsp qunJoinUrlSvrPB$GetInfoRsp = new QunJoinUrlSvrPB$GetInfoRsp();
                                    qunJoinUrlSvrPB$GetInfoRsp.mergeFrom(this.f293821d.data);
                                    TroopSourceHandler.this.f293815b = qunJoinUrlSvrPB$GetInfoRsp.button.get();
                                    TroopSourceHandler.this.f293816c = qunJoinUrlSvrPB$GetInfoRsp.items.get();
                                    AnonymousClass1.this.f293817a.a(qunJoinUrlSvrPB$GetInfoRsp);
                                    QLog.i("TroopSourceHandler", 1, "[reqSourceList] onSuccess, rsp = " + qunJoinUrlSvrPB$GetInfoRsp + ", sourceItems = " + TroopSourceHandler.this.f293816c);
                                } else {
                                    QLog.i("TroopSourceHandler", 1, "[reqSourceList] onSuccess, data = null");
                                }
                            } catch (Exception e16) {
                                QLog.e("TroopSourceHandler", 1, "[reqSourceList] onException = " + e16);
                            }
                        }
                    });
                }
            }
        };
        try {
            QunJoinUrlSvrPB$GetInfoReq qunJoinUrlSvrPB$GetInfoReq = new QunJoinUrlSvrPB$GetInfoReq();
            qunJoinUrlSvrPB$GetInfoReq.group_id.set(Long.parseLong(this.f293814a));
            ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.qun_join_url_svr.QunJoinUrlSvr", "/trpc.iqun.qun_join_url_svr.QunJoinUrlSvr/GetInfo", qunJoinUrlSvrPB$GetInfoReq.toByteArray(), 1, null, fVar);
        } catch (Exception e16) {
            QLog.i("TroopSourceHandler", 1, "[reqSourceList] exception = " + e16);
        }
    }

    public void l(Context context, QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, qunSourceSvrPB$SourceItem, dVar);
            return;
        }
        QLog.i("TroopSourceHandler", 1, "[showSourceSelector] context = " + context + ", selectedItemId = " + qunSourceSvrPB$SourceItem.f342212id);
        List<QunSourceSvrPB$SourceItem> list = this.f293816c;
        if (list != null && !list.isEmpty()) {
            com.tencent.mobileqq.troop.addsource.a aVar = new com.tencent.mobileqq.troop.addsource.a(context, "1103".equals(ThemeUtil.curThemeId));
            aVar.q(context, new a(context, aVar));
            aVar.r(this.f293816c);
            aVar.s(g(qunSourceSvrPB$SourceItem));
            if (aVar.e() == null) {
                aVar.i(new b(aVar, dVar));
            }
            aVar.m();
            return;
        }
        QQToast.makeText(context, 0, "\u8fd8\u672a\u8bbe\u7f6e\u7fa4\u6765\u6e90\uff0c\u8bf7\u524d\u5f80\u8bbe\u7f6e", 0);
    }
}
