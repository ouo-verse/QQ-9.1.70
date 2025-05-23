package com.tencent.mobileqq.gamecenter.logic;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.gamecenter.data.k;
import com.tencent.mobileqq.gamecenter.data.l;
import com.tencent.mobileqq.gamecenter.protocols.d;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$LoginGuide;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import hp3.GameCenterAuthPermission;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements d.b, com.tencent.mobileqq.gamecenter.api.b {

    /* renamed from: a, reason: collision with root package name */
    private d f212152a;

    /* renamed from: b, reason: collision with root package name */
    private Context f212153b;

    /* renamed from: c, reason: collision with root package name */
    private String f212154c;

    /* renamed from: d, reason: collision with root package name */
    private k f212155d;

    /* renamed from: e, reason: collision with root package name */
    private l f212156e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.tencent.mobileqq.gamecenter.data.b> f212157f;

    /* renamed from: g, reason: collision with root package name */
    private String f212158g;

    /* renamed from: h, reason: collision with root package name */
    private String f212159h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.gamecenter.logic.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7640a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f212160d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f212161e;

        C7640a(int i3, ActionSheet actionSheet) {
            this.f212160d = i3;
            this.f212161e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            a aVar = a.this;
            aVar.s(this.f212160d, aVar.l(i3));
            this.f212161e.dismiss();
        }
    }

    public a(Context context, String str, k kVar) {
        this(context, str, kVar, 3);
    }

    private com.tencent.mobileqq.gamecenter.data.b i(int i3) {
        for (com.tencent.mobileqq.gamecenter.data.b bVar : this.f212157f) {
            if (bVar.f211987a == i3) {
                return bVar;
            }
        }
        return null;
    }

    private int j(int i3) {
        List<com.tencent.mobileqq.gamecenter.data.b> list = this.f212157f;
        if (list != null && list.size() != 0) {
            for (com.tencent.mobileqq.gamecenter.data.b bVar : this.f212157f) {
                if (bVar.f211987a == i3) {
                    return bVar.f211988b;
                }
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return 1;
        }
        return 3;
    }

    private String m(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            return this.f212153b.getString(R.string.f1367404z);
        }
        return this.f212153b.getString(R.string.f1367004v);
    }

    private void n(int i3) {
        d dVar = new d(this.f212154c, i3);
        this.f212152a = dVar;
        dVar.e();
        this.f212152a.q(this);
    }

    private void o(List<com.tencent.mobileqq.gamecenter.data.b> list) {
        k kVar = this.f212155d;
        if (kVar == null) {
            return;
        }
        kVar.onAuthRangeChanged(list);
    }

    @Override // com.tencent.mobileqq.gamecenter.protocols.d.b
    public void a(GameDataAuthorizeSvr$LoginGuide gameDataAuthorizeSvr$LoginGuide) {
        l lVar = this.f212156e;
        if (lVar != null) {
            lVar.g7(gameDataAuthorizeSvr$LoginGuide);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.protocols.d.b
    public void b(List<com.tencent.mobileqq.gamecenter.data.b> list) {
        QLog.i("GameAuthLogicHandler", 1, "[onSetAuths]");
        if (list != null && list.size() != 0) {
            for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                com.tencent.mobileqq.gamecenter.data.b i3 = i(bVar.f211987a);
                if (i3 != null) {
                    i3.f211988b = bVar.f211988b;
                }
            }
            o(list);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.b
    public void c(int i3) {
        boolean z16;
        boolean z17;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f212153b, null);
        String string = this.f212153b.getResources().getString(R.string.f1366804t);
        int j3 = j(i3);
        actionSheet.setMainTitle(string);
        boolean z18 = false;
        if (j3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        actionSheet.addRadioButton(R.string.f1366504q, z16);
        if (j3 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        actionSheet.addRadioButton(R.string.f1366604r, z17);
        if (j3 == 3) {
            z18 = true;
        }
        actionSheet.addRadioButton(R.string.f1365904k, z18);
        actionSheet.addCancelButton(this.f212153b.getResources().getString(R.string.cancel));
        actionSheet.setOnButtonClickListener(new C7640a(i3, actionSheet));
        actionSheet.show();
    }

    @Override // com.tencent.mobileqq.gamecenter.protocols.d.b
    public void d(String str, String str2, List<com.tencent.mobileqq.gamecenter.data.b> list) {
        QLog.i("GameAuthLogicHandler", 1, "[onGetAuths]");
        this.f212158g = str;
        k kVar = this.f212155d;
        if (kVar != null) {
            kVar.onGetRangeUrl(str, str2);
        }
        if (list != null) {
            QLog.i("GameAuthLogicHandler", 1, "auth item size:" + list.size());
            this.f212157f = list;
            o(list);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.b
    public void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.gamecenter.data.b.a(1, 1));
        arrayList.add(com.tencent.mobileqq.gamecenter.data.b.a(2, 1));
        this.f212152a.r(arrayList);
    }

    public void g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.gamecenter.data.b.a(1, 3));
        arrayList.add(com.tencent.mobileqq.gamecenter.data.b.a(2, 3));
        this.f212152a.r(arrayList);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.b
    public void getAuthFromServer() {
        this.f212152a.h(this.f212159h);
    }

    public List<GameCenterAuthPermission> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GameCenterAuthPermission(1, 3, m(1), ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(this.f212153b, 3)));
        arrayList.add(new GameCenterAuthPermission(2, 3, m(2), ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(this.f212153b, 3)));
        return arrayList;
    }

    @Nullable
    public List<GameCenterAuthPermission> k() {
        ArrayList<com.tencent.mobileqq.gamecenter.data.b> arrayList;
        synchronized (a.class) {
            if (this.f212157f != null) {
                arrayList = new ArrayList(this.f212157f);
            } else {
                arrayList = null;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (com.tencent.mobileqq.gamecenter.data.b bVar : arrayList) {
            int i3 = bVar.f211987a;
            arrayList2.add(new GameCenterAuthPermission(i3, bVar.f211988b, m(i3), ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(this.f212153b, bVar.f211988b)));
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.b
    public void onDestroy() {
        this.f212152a.k();
        this.f212155d = null;
    }

    public void p() {
        if (TextUtils.isEmpty(this.f212158g)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", this.f212158g);
        u(this.f212153b, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public void q(int i3, List<com.tencent.mobileqq.gamecenter.data.b> list) {
        this.f212152a.p(i3, list);
    }

    public void r(l lVar) {
        this.f212156e = lVar;
    }

    public void s(int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.gamecenter.data.b.a(i3, i16));
        this.f212152a.r(arrayList);
    }

    public void t(String str) {
        this.f212159h = str;
    }

    public void u(Context context, Intent intent, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public a(Context context, String str, k kVar, int i3) {
        this.f212157f = new ArrayList();
        this.f212153b = context;
        this.f212154c = str;
        this.f212155d = kVar;
        n(i3);
    }
}
