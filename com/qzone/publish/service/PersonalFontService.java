package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.material_cate_get_req;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import NS_MOBILE_MATERIAL.material_set_switch_rsp;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.album.protocol.QzoneGetDITFontListRequest;
import com.qzone.album.protocol.QzoneGetFontListRequest;
import com.qzone.album.protocol.QzoneSetFontSwitchRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.util.al;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import n7.a;

/* loaded from: classes39.dex */
public class PersonalFontService extends Observable implements IQZoneServiceListener {

    /* renamed from: m, reason: collision with root package name */
    private static final al<PersonalFontService, Void> f51260m = new a();

    /* renamed from: d, reason: collision with root package name */
    private PersonalFontData f51261d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f51262e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f51263f;

    /* renamed from: h, reason: collision with root package name */
    private final b f51264h;

    /* renamed from: i, reason: collision with root package name */
    private final b f51265i;

    /* loaded from: classes39.dex */
    class a extends al<PersonalFontService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PersonalFontService a(Void r16) {
            return new PersonalFontService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f51272a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f51273b;

        /* renamed from: c, reason: collision with root package name */
        String f51274c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f51275d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f51276e = new a();

        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("PersonalFontService", 4, "DbCacheManager onClosed PersonalFontService table:" + b.this.f51274c);
                }
                b bVar = b.this;
                bVar.f51272a = 0L;
                bVar.f51273b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f51274c = str;
            this.f51275d = cls;
        }
    }

    PersonalFontService() {
        super("PersonalFont");
        this.f51262e = false;
        this.f51263f = false;
        this.f51264h = new b("TABLE_PERSONAL_FONT", PersonalFontData.class);
        this.f51265i = new b("TABLE_PERSONAL_DIY_FONT", PersonalFontData.class);
    }

    public static PersonalFontService K() {
        return f51260m.get(null);
    }

    private void N(b bVar, long j3) {
        if (bVar.f51272a != j3) {
            synchronized (bVar) {
                if (bVar.f51272a != j3) {
                    F(bVar);
                }
            }
        }
    }

    public boolean J(long j3, Handler handler, int i3) {
        if (NetworkState.isNetSupport()) {
            QZoneRequest E = E(j3, i3);
            material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) E.req;
            if (material_cate_get_reqVar != null) {
                material_cate_get_reqVar.strAttachInfo = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_FONT_LIST_ATTACH_INFO, "start=0&num=1000");
            }
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(E, handler, this, 1));
            return true;
        }
        QZLog.w("PersonalFontService", "getBarrageEffectList , NetworkState.isNetSupport() is false");
        return false;
    }

    public DbCacheManager L(long j3, int i3) {
        b G = G(i3);
        N(G, j3);
        return G.f51273b;
    }

    public boolean M() {
        return !this.f51263f && this.f51262e;
    }

    public boolean U(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetFontSwitchRequest(j3), handler, this, 2));
            return true;
        }
        QZLog.w("PersonalFontService", "setBarrageEffectSwitch , NetworkState.isNetSupport() is false");
        return false;
    }

    public void V(final long j3, final PersonalFontData personalFontData, final int i3, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.PersonalFontService.2
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager L = PersonalFontService.this.L(j3, i16);
                if (L != null) {
                    if (personalFontData == null) {
                        L.b0("uin=?", new String[]{"" + j3});
                    } else {
                        L.r0("uin=?");
                        L.t0(new String[]{"" + j3});
                        PersonalFontData personalFontData2 = (PersonalFontData) L.k0("uin=?", new String[]{"" + j3});
                        if (personalFontData2 != null && j3 == personalFontData2.uin && i3 == 0) {
                            PersonalFontData personalFontData3 = personalFontData;
                            if (personalFontData3.defaultFont < 0) {
                                personalFontData3.defaultFont = personalFontData2.defaultFont;
                            }
                        }
                        L.o0(personalFontData, 2);
                    }
                }
                if (j3 == LoginData.getInstance().getUin()) {
                    PersonalFontService.this.f51261d = personalFontData;
                }
            }
        });
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d("PersonalFontService", 2, "PersonalFontService\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            Q(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            R(qZoneTask);
        }
    }

    private void Q(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        material_cate_get_rsp material_cate_get_rspVar = (material_cate_get_rsp) qZoneRequest.rsp;
        material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) qZoneRequest.req;
        if (material_cate_get_rspVar != null) {
            if (material_cate_get_rspVar.iCode == 0) {
                this.f51262e = true;
                PersonalFontData createFromResponse = PersonalFontData.createFromResponse(material_cate_get_reqVar.lUin, material_cate_get_rspVar);
                if (createFromResponse != null) {
                    QZoneRequest qZoneRequest2 = qZoneTask.mRequest;
                    int type = qZoneRequest2 instanceof QzoneGetFontListRequest ? ((QzoneGetFontListRequest) qZoneRequest2).getType() : 1;
                    createFromResponse.mType = type;
                    D(type, createFromResponse);
                    PersonalFontData.FontInfo H = H(createFromResponse);
                    if (H != null) {
                        ((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(createFromResponse.defaultFont, H.fontUrl, null, true, null);
                    }
                    V(material_cate_get_reqVar.lUin, createFromResponse, 0, type);
                    P(material_cate_get_reqVar.lUin, createFromResponse, 0);
                    return;
                }
                QZLog.e("PersonalFontService", "onGetFontListResponse fail, PersonalFontData.createFromResponse return null");
                return;
            }
            QZLog.e("PersonalFontService", "onGetFontListResponse fail, response.iCode = " + material_cate_get_rspVar.iCode);
            return;
        }
        QZLog.e("PersonalFontService", "onGetFontListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    private void R(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(2);
        material_set_switch_rsp material_set_switch_rspVar = (material_set_switch_rsp) qZoneTask.mRequest.rsp;
        if (material_set_switch_rspVar != null) {
            if (material_set_switch_rspVar.iCode != 0) {
                QZLog.e("PersonalFontService", "onSetFontSwitchResponse fail, response.iCode = " + material_set_switch_rspVar.iCode + ", response.errMsg = " + material_set_switch_rspVar.strErrMsg);
                return;
            }
            return;
        }
        QZLog.e("PersonalFontService", "onGetFontListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    public boolean I(long j3, Handler handler) {
        return J(j3, handler, 1);
    }

    public void O() {
        this.f51263f = true;
    }

    public void P(long j3, PersonalFontData personalFontData, int i3) {
        notify(1, Long.valueOf(j3), personalFontData, Integer.valueOf(i3));
    }

    public void S(long j3, int i3) {
        T(j3, false, i3);
    }

    private void D(int i3, PersonalFontData personalFontData) {
        ArrayList<PersonalFontData.FontInfo> arrayList;
        if (personalFontData == null || (arrayList = personalFontData.fontList) == null || i3 != 2) {
            return;
        }
        Iterator<PersonalFontData.FontInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            PersonalFontData.FontInfo next = it.next();
            if (next != null) {
                String str = next.iPrice;
                if (!TextUtils.isEmpty(str)) {
                    next.strPriceDesc = "\u00a5" + str.substring(0, str.indexOf(".")) + l.a(R.string.p1b);
                }
            }
        }
    }

    public void T(final long j3, boolean z16, final int i3) {
        PersonalFontData personalFontData;
        if (!z16 && (personalFontData = this.f51261d) != null && personalFontData.mType == i3 && j3 == LoginData.getInstance().getUin()) {
            P(j3, this.f51261d, 1);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.PersonalFontService.3
                @Override // java.lang.Runnable
                public void run() {
                    DbCacheManager L = PersonalFontService.this.L(j3, i3);
                    if (L == null) {
                        return;
                    }
                    L.r0("uin=?");
                    L.t0(new String[]{"" + j3});
                    PersonalFontData personalFontData2 = (PersonalFontData) L.k0("uin=?", new String[]{"" + j3});
                    if (personalFontData2 != null) {
                        if (j3 == LoginData.getInstance().getUin()) {
                            PersonalFontService.this.f51261d = personalFontData2;
                        }
                        PersonalFontService.this.P(j3, personalFontData2, 1);
                        return;
                    }
                    PersonalFontService.this.P(j3, null, 1);
                }
            });
        }
    }

    private void F(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f51272a || (dbCacheManager = bVar.f51273b) == null || dbCacheManager.isClosed()) {
            bVar.f51272a = uin;
            DbCacheManager e16 = c.g().e(bVar.f51275d, uin, bVar.f51274c);
            bVar.f51273b = e16;
            e16.U(bVar.f51276e);
        }
    }

    private PersonalFontData.FontInfo H(PersonalFontData personalFontData) {
        if (personalFontData != null && !personalFontData.fontList.isEmpty()) {
            Iterator<PersonalFontData.FontInfo> it = personalFontData.fontList.iterator();
            while (it.hasNext()) {
                PersonalFontData.FontInfo next = it.next();
                if (next.f51895id == personalFontData.defaultFont) {
                    return next;
                }
            }
        }
        return null;
    }

    private QZoneRequest E(long j3, int i3) {
        if (i3 == 1) {
            return new QzoneGetFontListRequest(j3, i3);
        }
        if (i3 != 2) {
            return new QzoneGetFontListRequest(j3, i3);
        }
        return new QzoneGetDITFontListRequest(j3, i3);
    }

    private b G(int i3) {
        if (i3 == 1) {
            return this.f51264h;
        }
        if (i3 != 2) {
            return this.f51264h;
        }
        return this.f51265i;
    }
}
