package com.tencent.biz.qqstory.model.lbs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.b;
import com.tencent.biz.qqstory.network.pb.qqstory_service$ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct$Address;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LbsManager implements com.tencent.biz.qqstory.model.e {

    /* renamed from: f, reason: collision with root package name */
    public static com.tencent.biz.qqstory.model.lbs.a f94053f;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f94054a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.biz.qqstory.model.lbs.a f94055b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f94056c = false;

    /* renamed from: d, reason: collision with root package name */
    private List<b> f94057d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private Object f94058e = new Object();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqstory.model.lbs.LbsManager$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f94059d;
        final /* synthetic */ LbsManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            hd0.c.v("LbsManager", "onLocation Timeout  %d ms", Integer.valueOf(this.f94059d));
            LbsManager lbsManager = this.this$0;
            lbsManager.e(false, lbsManager.f94055b);
            this.this$0.f94056c = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends SosoInterfaceOnLocationListener {
        a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
            super(i3, z16, z17, j3, z18, z19, str);
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            boolean z16;
            hd0.c.a("LbsManager", "onLocationFinish.");
            if (i3 == 0 && sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                LbsManager.this.f94055b = com.tencent.biz.qqstory.model.lbs.a.a(sosoLbsInfo.mLocation);
                hd0.c.c("LbsManager", "onLocationFinish success, [longitude=%s, latitude=%s]", Integer.valueOf(LbsManager.this.f94055b.f94079b), Integer.valueOf(LbsManager.this.f94055b.f94078a));
            } else {
                hd0.c.v("LbsManager", "onLocationFinish errorCode = %d", Integer.valueOf(i3));
            }
            if (!LbsManager.this.f94056c) {
                LbsManager lbsManager = LbsManager.this;
                lbsManager.e(z16, lbsManager.f94055b);
            }
            LbsManager.this.f94054a = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z16, com.tencent.biz.qqstory.model.lbs.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class c extends SosoInterfaceOnLocationListener {
        public c(String str) {
            super(0, true, false, MiniBoxNoticeInfo.MIN_5, false, false, str);
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                LbsManager.f94053f = new com.tencent.biz.qqstory.model.lbs.a((int) (sosoLocation.mLat02 * 1000000.0d), (int) (sosoLocation.mLon02 * 1000000.0d));
                hd0.c.a("LbsManager", "onLocationFinish success : " + LbsManager.f94053f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(int i3, e eVar, List<TroopBarPOI> list);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final int f94071a;

        /* renamed from: b, reason: collision with root package name */
        boolean f94072b = true;

        /* renamed from: c, reason: collision with root package name */
        boolean f94073c = true;

        /* renamed from: d, reason: collision with root package name */
        String f94074d = "";

        /* renamed from: e, reason: collision with root package name */
        String f94075e = "";

        /* renamed from: f, reason: collision with root package name */
        HashSet<String> f94076f = new HashSet<>();

        /* renamed from: g, reason: collision with root package name */
        public final Bundle f94077g = new Bundle();

        public e(int i3) {
            this.f94071a = i3;
        }

        public static e a() {
            return new e(20);
        }

        public void b() {
            this.f94074d = "";
            this.f94076f.clear();
            this.f94073c = true;
        }

        public void c(String str) {
            if (!TextUtils.equals(str, this.f94075e)) {
                this.f94075e = str;
                b();
            }
        }
    }

    public static com.tencent.biz.qqstory.model.lbs.a c() {
        return f94053f;
    }

    public com.tencent.biz.qqstory.model.lbs.a d() {
        return this.f94055b;
    }

    protected void e(boolean z16, com.tencent.biz.qqstory.model.lbs.a aVar) {
        Iterator<b> it = this.f94057d.iterator();
        while (it.hasNext()) {
            it.next().a(z16, aVar);
        }
    }

    public void f(@NonNull b bVar) {
        if (!this.f94057d.contains(bVar)) {
            hd0.c.b("LbsManager", "registerLbsListener:%s", bVar.getClass().getName());
            this.f94057d.add(bVar);
        }
    }

    public void g() {
        this.f94056c = false;
        if (this.f94054a) {
            hd0.c.t("LbsManager", "is locating..... return directly.");
            return;
        }
        synchronized (this.f94058e) {
            if (this.f94054a) {
                hd0.c.t("LbsManager", "is locating..... return directly.");
                return;
            }
            hd0.c.a("LbsManager", "requestLbs...");
            this.f94054a = true;
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a(0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
        }
    }

    public void h(@NonNull com.tencent.biz.qqstory.model.lbs.a aVar, final e eVar, d dVar) {
        hd0.c.e("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(aVar.f94078a), Integer.valueOf(aVar.f94079b), Integer.valueOf(aVar.f94080c), eVar);
        final WeakReference weakReference = new WeakReference(dVar);
        if (eVar == null) {
            eVar = e.a();
        } else if (!TextUtils.isEmpty(eVar.f94074d)) {
            eVar.f94073c = false;
        }
        hd0.c.a("LbsManager", "requestPoiList");
        String d16 = xc0.c.d("StorySvc.get_poi_list");
        qqstory_service$ReqGetPOIList qqstory_service_reqgetpoilist = new qqstory_service$ReqGetPOIList();
        if (!TextUtils.isEmpty(eVar.f94074d)) {
            qqstory_service_reqgetpoilist.start_cookie.set(ByteStringMicro.copyFromUtf8(eVar.f94074d));
        }
        qqstory_service_reqgetpoilist.coordinate.set(aVar.f94080c);
        qqstory_service_reqgetpoilist.count.set(eVar.f94071a);
        if (!TextUtils.isEmpty(eVar.f94075e)) {
            qqstory_service_reqgetpoilist.keyword.set(ByteStringMicro.copyFromUtf8(eVar.f94075e));
        }
        qqstory_service_reqgetpoilist.gps.lat.set(aVar.f94078a);
        qqstory_service_reqgetpoilist.gps.lng.set(aVar.f94079b);
        qqstory_service_reqgetpoilist.gps.setHasFlag(true);
        com.tencent.biz.qqstory.channel.b.a().b(new cd0.a(d16, qqstory_service_reqgetpoilist, new Bundle()), new b.InterfaceC0941b<cd0.a<qqstory_service$ReqGetPOIList>, dd0.a>() { // from class: com.tencent.biz.qqstory.model.lbs.LbsManager.3
            @Override // com.tencent.biz.qqstory.channel.b.InterfaceC0941b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void v(@NonNull cd0.a<qqstory_service$ReqGetPOIList> aVar2, @Nullable dd0.a aVar3, @NonNull final ErrorMessage errorMessage) {
                boolean z16;
                int i3;
                int i16;
                if (aVar3 == null) {
                    hd0.c.t("LbsManager", "response is null");
                    final d dVar2 = (d) weakReference.get();
                    if (dVar2 != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqstory.model.lbs.LbsManager.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                dVar2.a(errorMessage.errorCode, eVar, Collections.EMPTY_LIST);
                            }
                        });
                        return;
                    }
                    return;
                }
                final qqstory_service$RspGetPOIList qqstory_service_rspgetpoilist = new qqstory_service$RspGetPOIList();
                try {
                    qqstory_service_rspgetpoilist.mergeFrom(aVar3.f393623c);
                } catch (InvalidProtocolBufferMicroException e16) {
                    hd0.c.g("LbsManager", "InvalidProtocolBufferMicroException: " + e16.getMessage());
                }
                final ArrayList arrayList = new ArrayList();
                if (qqstory_service_rspgetpoilist.result.error_code.get() == 0) {
                    List<qqstory_struct$Address> list = qqstory_service_rspgetpoilist.poi_list.get();
                    hd0.c.a("LbsManager", "poiListSize = " + qqstory_service_rspgetpoilist.poi_list.size());
                    hd0.c.a("LbsManager", "poiList isend = " + qqstory_service_rspgetpoilist.is_end.get());
                    if (list.size() > 0) {
                        if (qqstory_service_rspgetpoilist.is_end.get() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        eVar.f94072b = !z16;
                        String stringUtf8 = qqstory_service_rspgetpoilist.next_cookie.get().toStringUtf8();
                        if (!eVar.f94076f.contains(stringUtf8)) {
                            for (int i17 = 0; i17 < list.size(); i17++) {
                                qqstory_struct$Address qqstory_struct_address = list.get(i17);
                                String stringUtf82 = qqstory_struct_address.city.get().toStringUtf8();
                                String stringUtf83 = qqstory_struct_address.building.get().toStringUtf8();
                                if (qqstory_struct_address.gps.has()) {
                                    i3 = qqstory_struct_address.gps.lng.get();
                                } else {
                                    i3 = 0;
                                }
                                String stringUtf84 = qqstory_struct_address.street.get().toStringUtf8();
                                if (qqstory_struct_address.gps.has()) {
                                    i16 = qqstory_struct_address.gps.lat.get();
                                } else {
                                    i16 = 0;
                                }
                                arrayList.add(new TroopBarPOI("", stringUtf82, stringUtf83, i3, stringUtf84, i16, qqstory_struct_address.province.get().toString()));
                            }
                            eVar.f94076f.add(stringUtf8);
                            eVar.f94074d = stringUtf8;
                        }
                    }
                }
                final d dVar3 = (d) weakReference.get();
                if (dVar3 != null) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqstory.model.lbs.LbsManager.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            dVar3.a(qqstory_service_rspgetpoilist.result.error_code.get(), eVar, arrayList);
                        }
                    });
                } else {
                    hd0.c.t("LbsManager", "POIListRequestCallback has been recycled.");
                }
            }
        });
    }

    public void i(@NonNull b bVar) {
        if (this.f94057d.contains(bVar)) {
            hd0.c.b("LbsManager", "unregisterLbsListener:%s", bVar.getClass().getName());
            this.f94057d.remove(bVar);
        }
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onDestroy() {
        hd0.c.a("LbsManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.f94057d.clear();
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onInit() {
        hd0.c.a("LbsManager", "onInit");
    }
}
