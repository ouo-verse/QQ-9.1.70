package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.CGetChiefReq;
import QC.CGetChiefRsp;
import QC.ModuleData;
import QC.UniBusiGetUserInfoRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopNickRequest implements com.tencent.mobileqq.vas.troopnick.shop.adapter.b {

    /* renamed from: h, reason: collision with root package name */
    public static final String f311069h = BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "list_cache";

    /* renamed from: a, reason: collision with root package name */
    private int f311070a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.mobileqq.vas.troopnick.shop.widget.a f311071b;

    /* renamed from: c, reason: collision with root package name */
    private long f311072c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f311073d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f311074e;

    /* renamed from: f, reason: collision with root package name */
    protected int f311075f;

    /* renamed from: g, reason: collision with root package name */
    private List<Object> f311076g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj instanceof UniBusiGetUserInfoRsp) {
                return -1;
            }
            if (obj2 instanceof UniBusiGetUserInfoRsp) {
                return 1;
            }
            if (obj instanceof CGetChiefRsp) {
                return -1;
            }
            if (obj2 instanceof CGetChiefRsp) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements BusinessObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            TroopNickRequest.this.a(obj);
        }
    }

    public TroopNickRequest(int i3, long j3, com.tencent.mobileqq.vas.troopnick.shop.widget.a aVar) {
        this.f311070a = i3;
        this.f311071b = aVar;
        this.f311072c = j3;
    }

    public void a(Object obj) {
        final Object[] array;
        ArrayList<ModuleData> arrayList;
        if (obj instanceof CGetChiefRsp) {
            CGetChiefRsp cGetChiefRsp = (CGetChiefRsp) obj;
            if (cGetChiefRsp.ret == 0 && (arrayList = cGetChiefRsp.modData) != null && arrayList.size() > 0) {
                ArrayList<ModuleData> arrayList2 = cGetChiefRsp.modData;
                Iterator<ModuleData> it = arrayList2.iterator();
                while (it.hasNext()) {
                    this.f311074e = "true".equals(it.next().extModParams.get("NoMore"));
                }
                this.f311075f = arrayList2.size();
            }
        }
        synchronized (this.f311076g) {
            this.f311076g.clear();
            this.f311076g.add(obj);
            Collections.sort(this.f311076g, new a());
            array = this.f311076g.toArray();
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickRequest.2
            @Override // java.lang.Runnable
            public void run() {
                TroopNickRequest.this.f311071b.E(array);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.b
    public void request() {
        VasUtil.getService().getJceRequset().build("QC.MallChiefServer.MallChiefObj", "QCMallChief.getChiefList", 1).request("getChiefList", new CGetChiefReq(IJce.Util.getLoginInfo(), this.f311070a, 3, this.f311072c, null), new CGetChiefRsp(), new b(), this.f311073d);
    }

    @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.b
    public void loadMore() {
    }
}
