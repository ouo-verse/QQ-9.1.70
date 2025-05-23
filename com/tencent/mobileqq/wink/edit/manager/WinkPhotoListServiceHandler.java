package com.tencent.mobileqq.wink.edit.manager;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetProcessMediaReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetProcessMediaRsp;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.g;
import com.tencent.mobileqq.wink.edit.util.AbortableCountDownLatch;
import com.tencent.mobileqq.wink.pb.ShadowInspirationAIReq;
import com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import org.json.JSONObject;
import qshadow.ShadowInspirationAI$InspirationAIReq;
import qshadow.ShadowInspirationAI$InspirationAIRsp;
import qshadow.ShadowInspirationAI$InspirationMediaInfo;
import y53.a;

/* loaded from: classes21.dex */
public class WinkPhotoListServiceHandler extends WinkDataServiceHandler {
    private CountDownLatch C;
    private CircleTemplateInfo D;
    private String E;

    /* renamed from: e, reason: collision with root package name */
    private int[] f318328e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f318329f;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, com.tencent.mobileqq.wink.edit.bean.a> f318330h;

    /* renamed from: i, reason: collision with root package name */
    private CountDownLatch f318331i;

    /* renamed from: m, reason: collision with root package name */
    private AbortableCountDownLatch f318332m;

    /* loaded from: classes21.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final int f318350a;

        /* renamed from: b, reason: collision with root package name */
        private final String f318351b;

        /* renamed from: c, reason: collision with root package name */
        private final String f318352c;

        /* renamed from: d, reason: collision with root package name */
        private final int f318353d;

        /* renamed from: e, reason: collision with root package name */
        private final String f318354e;

        /* renamed from: f, reason: collision with root package name */
        public LocalMediaInfo f318355f;

        /* renamed from: g, reason: collision with root package name */
        public String f318356g;

        /* renamed from: h, reason: collision with root package name */
        public int f318357h;

        /* renamed from: i, reason: collision with root package name */
        public int f318358i;

        /* renamed from: j, reason: collision with root package name */
        public long f318359j;

        /* renamed from: k, reason: collision with root package name */
        public MetaMaterial f318360k;

        /* renamed from: l, reason: collision with root package name */
        public int f318361l;

        /* renamed from: m, reason: collision with root package name */
        public List<Integer> f318362m;

        public d(int i3, String str, String str2, int i16, String str3) {
            this.f318352c = str2;
            this.f318350a = i3;
            this.f318351b = str;
            this.f318353d = i16;
            this.f318354e = str3;
        }
    }

    public WinkPhotoListServiceHandler(AppInterface appInterface) {
        super(appInterface);
        this.f318330h = new ConcurrentHashMap();
        this.E = "";
    }

    private boolean A3(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetProcessMediaReq getProcessMediaReq = new GetProcessMediaReq();
        getProcessMediaReq.BusiID = (String) toServiceMsg.getAttribute(AECameraConstants.REQ_BUSI_ID);
        getProcessMediaReq.MediaInfos = (ArrayList) toServiceMsg.getAttribute(AECameraConstants.REQ_MEDIA_INFOS);
        getProcessMediaReq.Extra = (String) toServiceMsg.getAttribute(AECameraConstants.REQ_EXTRA);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.InspirationAI");
        uniPacket.put("ShadowBackendSvc.InspirationAI", getProcessMediaReq);
        ArrayList<MediaInfo> arrayList = getProcessMediaReq.MediaInfos;
        if (arrayList != null && arrayList.size() > 0) {
            ms.a.a("WinkPhotoListServiceHandler", "[encodeProcessMediaRequest] url: " + getProcessMediaReq.MediaInfos.get(0).URL);
            return true;
        }
        return true;
    }

    private boolean B3(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCircleTemplateInfoReq getCircleTemplateInfoReq = new GetCircleTemplateInfoReq(toServiceMsg.getUin());
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.GetCircleTemplateInfo");
        uniPacket.put("ShadowBackendSvc.GetCircleTemplateInfo", getCircleTemplateInfoReq);
        return true;
    }

    private void E3(d dVar, ShadowInspirationAI$InspirationAIRsp shadowInspirationAI$InspirationAIRsp, String str) {
        AbortableCountDownLatch abortableCountDownLatch = this.f318332m;
        if (abortableCountDownLatch != null && abortableCountDownLatch.getCount() <= 0) {
            ms.a.f("WinkPhotoListServiceHandler", "[handleProcessMediaResponse] countDownLatch over");
            return;
        }
        if (!TextUtils.equals(this.E, str)) {
            ms.a.f("WinkPhotoListServiceHandler", "[handleProcessMediaResponse] sessionID is different");
            return;
        }
        List<ShadowInspirationAI$InspirationMediaInfo> list = shadowInspirationAI$InspirationAIRsp.MediaInfos.get();
        String str2 = shadowInspirationAI$InspirationAIRsp.Extra.get();
        com.tencent.mobileqq.wink.edit.bean.a aVar = new com.tencent.mobileqq.wink.edit.bean.a();
        aVar.inspirationAIMediaInfos = list;
        aVar.processedExtra = str2;
        aVar.busiID = dVar.f318352c;
        aVar.index = dVar.f318353d;
        aVar.originalMediaIndex = dVar.f318361l;
        aVar.mutipleIndexes = dVar.f318362m;
        if (!shadowInspirationAI$InspirationAIRsp.ReqID.get().isEmpty()) {
            aVar.reqId = Integer.parseInt(shadowInspirationAI$InspirationAIRsp.ReqID.get());
        }
        List<Integer> list2 = dVar.f318362m;
        if (list2 != null && !list2.isEmpty()) {
            this.f318330h.put(Integer.valueOf(dVar.f318361l), aVar);
        } else {
            this.f318330h.put(Integer.valueOf(dVar.f318353d), aVar);
        }
        AbortableCountDownLatch abortableCountDownLatch2 = this.f318332m;
        if (abortableCountDownLatch2 != null) {
            abortableCountDownLatch2.countDown();
        }
    }

    private void F3(FromServiceMsg fromServiceMsg, Object obj) {
        ToServiceMsg toServiceMsg;
        if (obj != null) {
            GetImgValidStatusRsp getImgValidStatusRsp = (GetImgValidStatusRsp) obj;
            ms.a.a("WinkPhotoListServiceHandler", "checkImageValid  response.ValidStatus: " + getImgValidStatusRsp.ValidStatus);
            if (fromServiceMsg != null && fromServiceMsg.isSuccess() && (toServiceMsg = (ToServiceMsg) fromServiceMsg.attributes.get("FromServiceMsg")) != null) {
                this.f318328e[((Integer) toServiceMsg.getAttribute("request_flag")).intValue()] = getImgValidStatusRsp.ValidStatus;
            }
        }
        this.f318331i.countDown();
    }

    private void G3(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ms.a.a("WinkPhotoListServiceHandler", "[handleGetTemplateUserInfoResponse]");
        GetCircleTemplateInfoRsp getCircleTemplateInfoRsp = (GetCircleTemplateInfoRsp) obj;
        if (getCircleTemplateInfoRsp != null && getCircleTemplateInfoRsp.Code == 0) {
            this.D = getCircleTemplateInfoRsp.TemplateInfo;
        } else {
            this.D = null;
        }
        WinkEditorResourceManager.a1().M1().postValue(this.D);
        CircleTemplateInfo circleTemplateInfo = this.D;
        if (circleTemplateInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        notifyUI(7, z16, circleTemplateInfo);
        CountDownLatch countDownLatch = this.C;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private void H3(com.tencent.mobileqq.wink.edit.bean.a aVar, CountDownLatch countDownLatch) {
        List<ShadowInspirationAI$InspirationMediaInfo> list;
        com.tencent.mobileqq.wink.edit.bean.a aVar2 = aVar;
        List<Integer> list2 = aVar2.mutipleIndexes;
        List<ShadowInspirationAI$InspirationMediaInfo> list3 = aVar2.inspirationAIMediaInfos;
        String[] strArr = new String[list3.size()];
        WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
        int i3 = aVar2.reqId;
        a16.t3(i3, Integer.valueOf(i3));
        int i16 = 0;
        while (i16 < list3.size()) {
            ShadowInspirationAI$InspirationMediaInfo shadowInspirationAI$InspirationMediaInfo = list3.get(i16);
            int i17 = shadowInspirationAI$InspirationMediaInfo.MediaType.get();
            if (i17 != 1 && i17 != 2) {
                if (i17 == 3 || i17 == 4) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", shadowInspirationAI$InspirationMediaInfo.MediaType.get());
                        jSONObject.put("data", shadowInspirationAI$InspirationMediaInfo.StringData.get());
                        jSONObject.put("index", shadowInspirationAI$InspirationMediaInfo.Index.get());
                        WinkEditorResourceManager.a1().s3(aVar2.reqId, jSONObject);
                    } catch (Exception e16) {
                        ms.a.c("WinkPhotoListServiceHandler", "[downloadMediaFiles] exception: " + e16.getMessage());
                    }
                    countDownLatch.countDown();
                }
            } else {
                String str = shadowInspirationAI$InspirationMediaInfo.URL.get();
                if (TextUtils.isEmpty(str)) {
                    ms.a.a("WinkPhotoListServiceHandler", "[downloadMediaFiles]  error: downloadUrl is empty!");
                    ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] error: precessMediaListMap - countDownLatch = " + countDownLatch.getCount());
                } else {
                    com.tencent.mobileqq.wink.utils.an anVar = com.tencent.mobileqq.wink.utils.an.f326680a;
                    String f16 = anVar.f(anVar.h(str));
                    list = list3;
                    y53.a.c().a(str, f16, new b(countDownLatch, f16, aVar, strArr, i16, list2, shadowInspirationAI$InspirationMediaInfo));
                    i16++;
                    aVar2 = aVar;
                    list3 = list;
                }
            }
            list = list3;
            i16++;
            aVar2 = aVar;
            list3 = list;
        }
    }

    private void I3(FromServiceMsg fromServiceMsg, Object obj) {
        Integer num;
        if (this.f318332m.getCount() <= 0) {
            ms.a.f("WinkPhotoListServiceHandler", "[handleProcessMediaResponse] countDownLatch over");
            return;
        }
        ms.a.a("WinkPhotoListServiceHandler", "[handleProcessMediaResponse]");
        GetProcessMediaRsp getProcessMediaRsp = (GetProcessMediaRsp) obj;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && getProcessMediaRsp != null && getProcessMediaRsp.Code == 0) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) fromServiceMsg.attributes.get("FromServiceMsg");
            J3(((Integer) toServiceMsg.getAttribute("request_flag")).intValue(), (String) toServiceMsg.getAttribute("request_origin_local_path"), ((Integer) toServiceMsg.getAttribute("request_origin_media_index")).intValue(), (String) toServiceMsg.getAttribute(AECameraConstants.REQ_BUSI_ID), getProcessMediaRsp);
            this.f318332m.countDown();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleProcessMediaResponse] failed -> res = ");
            sb5.append(fromServiceMsg);
            sb5.append(" response code = ");
            String str = null;
            if (getProcessMediaRsp != null) {
                num = Integer.valueOf(getProcessMediaRsp.Code);
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(" Msg = ");
            if (getProcessMediaRsp != null) {
                str = getProcessMediaRsp.Msg;
            }
            sb5.append(str);
            ms.a.i("WinkPhotoListServiceHandler", sb5.toString());
            this.f318332m.a();
        }
        ms.a.a("WinkPhotoListServiceHandler", "[handleProcessMediaResponse] countDownLatch = " + this.f318332m.getCount());
    }

    private void J3(int i3, String str, int i16, String str2, GetProcessMediaRsp getProcessMediaRsp) {
        long j3;
        com.tencent.mobileqq.wink.edit.bean.a aVar = new com.tencent.mobileqq.wink.edit.bean.a();
        aVar.processedMediaInfos = getProcessMediaRsp.MediaInfos;
        aVar.processedExtra = getProcessMediaRsp.Extra;
        aVar.busiID = str2;
        aVar.index = i3;
        aVar.originalMediaIndex = i16;
        this.f318330h.put(Integer.valueOf(i3), aVar);
        ArrayList<MediaInfo> arrayList = getProcessMediaRsp.MediaInfos;
        if (arrayList != null && arrayList.size() > 0) {
            ms.a.a("WinkPhotoListServiceHandler", "[handleProcessMediaResponse] success -> reponse url: " + getProcessMediaRsp.MediaInfos.get(0).URL);
            return;
        }
        String str3 = getProcessMediaRsp.Extra;
        if (str3 != null) {
            j3 = str3.length();
        } else {
            j3 = 0;
        }
        ms.a.c("WinkPhotoListServiceHandler", "[handleProcessMediaResponse] success -> response.mediaInfos == null or size = 0 ; extraLen" + j3);
    }

    private boolean K3(int[] iArr) {
        for (int i3 : iArr) {
            if (i3 != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit L3(d dVar, String str, BaseRequest baseRequest, Boolean bool, Long l3, String str2, ShadowInspirationAI$InspirationAIRsp shadowInspirationAI$InspirationAIRsp) {
        if (bool.booleanValue() && shadowInspirationAI$InspirationAIRsp != null && l3.longValue() == 0) {
            E3(dVar, shadowInspirationAI$InspirationAIRsp, str);
        } else {
            String a16 = y53.d.f449481a.a(l3.longValue());
            w53.b.c("WinkPhotoListServiceHandler", "ShadowInspirationAIReq response is: " + l3);
            AbortableCountDownLatch abortableCountDownLatch = this.f318332m;
            if (abortableCountDownLatch != null) {
                abortableCountDownLatch.b(a16);
            }
        }
        return Unit.INSTANCE;
    }

    private void M3(String str, int i3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), AECameraConstants.CMD_FACE_DETECT);
        toServiceMsg.addAttribute("Rawdata", WinkDataServiceHandler.L2(str, 512));
        toServiceMsg.addAttribute("request_flag", Integer.valueOf(i3));
        x53.c.a(toServiceMsg, getClass().getName(), x53.b.class);
    }

    private void O3(final d dVar, int i3) {
        ShadowInspirationAI$InspirationAIReq shadowInspirationAI$InspirationAIReq = new ShadowInspirationAI$InspirationAIReq();
        shadowInspirationAI$InspirationAIReq.BusiID.set(dVar.f318352c);
        shadowInspirationAI$InspirationAIReq.Extra.set(dVar.f318354e);
        shadowInspirationAI$InspirationAIReq.ReqID.set(String.valueOf(i3));
        ArrayList arrayList = new ArrayList();
        ShadowInspirationAI$InspirationMediaInfo shadowInspirationAI$InspirationMediaInfo = new ShadowInspirationAI$InspirationMediaInfo();
        shadowInspirationAI$InspirationMediaInfo.MediaType.set(1);
        shadowInspirationAI$InspirationMediaInfo.URL.set(dVar.f318351b);
        shadowInspirationAI$InspirationMediaInfo.Index.set(dVar.f318361l);
        arrayList.add(shadowInspirationAI$InspirationMediaInfo);
        shadowInspirationAI$InspirationAIReq.MediaInfos.set(arrayList);
        final String str = this.E;
        w93.e.f445096a.j(new ShadowInspirationAIReq(shadowInspirationAI$InspirationAIReq), new Function5() { // from class: com.tencent.mobileqq.wink.edit.manager.al
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit L3;
                L3 = WinkPhotoListServiceHandler.this.L3(dVar, str, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (ShadowInspirationAI$InspirationAIRsp) obj5);
                return L3;
            }
        });
    }

    private void P3(String str, String str2, String str3, int i3, int i16, int i17, String str4) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), "ShadowBackendSvc.InspirationAI");
        toServiceMsg.addAttribute(AECameraConstants.REQ_BUSI_ID, str3);
        toServiceMsg.addAttribute(AECameraConstants.REQ_EXTRA, str4);
        toServiceMsg.addAttribute("request_flag", Integer.valueOf(i16));
        toServiceMsg.addAttribute("request_origin_local_path", str);
        toServiceMsg.addAttribute("request_origin_media_index", Integer.valueOf(i17));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaInfo(str2, null, i3));
        toServiceMsg.addAttribute(AECameraConstants.REQ_MEDIA_INFOS, arrayList);
        x53.c.a(toServiceMsg, getClass().getName(), x53.b.class);
        w53.b.f("WinkPhotoListServiceHandler", "\u3010REQUEST\u3011requestProcessMedia mediaUrl: " + str2 + " busiID: " + str3);
    }

    private String u3(String str, int i3) {
        if (QAlbumUtil.getMediaType(str) == 0) {
            com.tencent.mobileqq.wink.utils.an anVar = com.tencent.mobileqq.wink.utils.an.f326680a;
            String f16 = anVar.f(anVar.h(str));
            if (com.tencent.mobileqq.wink.utils.f.o(str, f16, i3)) {
                return f16;
            }
            return str;
        }
        return str;
    }

    private void w3(d dVar, int i3) {
        boolean isLibtemplateInspirationAIPb = QzoneConfig.isLibtemplateInspirationAIPb();
        w53.b.c("WinkPhotoListServiceHandler", "isLibtemplateInspirationAIPb wns is: " + isLibtemplateInspirationAIPb);
        w53.b.c("WinkPhotoListServiceHandler", "isLibtemplateInspirationAIPb final is: " + isLibtemplateInspirationAIPb);
        if (isLibtemplateInspirationAIPb) {
            O3(dVar, i3);
        } else {
            P3(dVar.f318355f.path, dVar.f318351b, dVar.f318352c, dVar.f318350a, dVar.f318353d, dVar.f318361l, dVar.f318354e);
        }
    }

    private void x3(int i3) {
        ms.a.a("WinkPhotoListServiceHandler", "[downloadMediaFiles]");
        int i16 = 0;
        int i17 = 0;
        for (com.tencent.mobileqq.wink.edit.bean.a aVar : this.f318330h.values()) {
            Iterator<? extends MediaInfo> it = aVar.processedMediaInfos.iterator();
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(it.next().URL)) {
                    i17++;
                }
            }
            for (ShadowInspirationAI$InspirationMediaInfo shadowInspirationAI$InspirationMediaInfo : aVar.inspirationAIMediaInfos) {
                i17++;
                i16++;
            }
        }
        WinkEditorResourceManager.a1().j2(i16);
        CountDownLatch countDownLatch = new CountDownLatch(i17);
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.wink.edit.bean.a>> it5 = this.f318330h.entrySet().iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.wink.edit.bean.a value = it5.next().getValue();
            List<? extends MediaInfo> list = value.processedMediaInfos;
            if (!list.isEmpty()) {
                y3(value, countDownLatch, list);
            } else {
                ms.a.a("WinkPhotoListServiceHandler", "[downloadMediaFiles]  error: precessMediaListMap is empty!");
                ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] error: precessMediaListMap - countDownLatch = " + countDownLatch.getCount());
            }
            H3(value, countDownLatch);
        }
        try {
            countDownLatch.await();
            ms.a.a("WinkPhotoListServiceHandler", "[downloadMediaFiles]  Success localMediaFilePathMap: " + this.f318330h);
            notifyUI(i3, true, new ArrayList(this.f318330h.values()));
        } catch (InterruptedException e16) {
            ms.a.c("WinkPhotoListServiceHandler", "[downloadMediaFiles]  error: " + e16.getMessage());
            notifyUI(i3, false, new ArrayList(this.f318330h.values()));
        }
    }

    private void y3(com.tencent.mobileqq.wink.edit.bean.a aVar, CountDownLatch countDownLatch, List<? extends MediaInfo> list) {
        String[] strArr = new String[list.size()];
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = list.get(i3).URL;
            if (TextUtils.isEmpty(str)) {
                ms.a.a("WinkPhotoListServiceHandler", "[downloadMediaFiles]  error: downloadUrl is empty!");
                ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] error: precessMediaListMap - countDownLatch = " + countDownLatch.getCount());
            } else {
                com.tencent.mobileqq.wink.utils.an anVar = com.tencent.mobileqq.wink.utils.an.f326680a;
                String f16 = anVar.f(anVar.h(str));
                y53.a.c().a(str, f16, new c(countDownLatch, f16, aVar, strArr, i3));
            }
        }
    }

    private boolean z3(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetImgValidStatusReq getImgValidStatusReq = new GetImgValidStatusReq();
        getImgValidStatusReq.Rawdata = (byte[]) toServiceMsg.getAttribute("Rawdata");
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_FACE_DETECT);
        uniPacket.put(AECameraConstants.CMD_FACE_DETECT, getImgValidStatusReq);
        return true;
    }

    public CircleTemplateInfo C3() {
        return this.D;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public Object D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT)) {
            return E2(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_FACE_DETECT, new GetImgValidStatusRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.InspirationAI")) {
            return E2(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.InspirationAI", new GetProcessMediaRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleTemplateInfo")) {
            return E2(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCircleTemplateInfo", new GetCircleTemplateInfoRsp());
        }
        return super.D2(toServiceMsg, fromServiceMsg);
    }

    public Pair<String, CircleTemplateInfo> D3() {
        ms.a.a("WinkPhotoListServiceHandler", "[requestTemplateUserInfo]  begin");
        this.C = new CountDownLatch(1);
        requestTemplateUserInfo();
        try {
            this.C.await();
        } catch (InterruptedException e16) {
            ms.a.c("WinkPhotoListServiceHandler", "requestTemplateUserInfo error: " + e16.getMessage());
            notifyUI(7, false, this.D);
        }
        ms.a.a("WinkPhotoListServiceHandler", "[requestTemplateUserInfo]  end");
        return new Pair<>(this.appRuntime.getAccount(), this.D);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public boolean F2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT)) {
            return z3(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.InspirationAI")) {
            return A3(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleTemplateInfo")) {
            return B3(toServiceMsg, uniPacket);
        }
        return super.F2(toServiceMsg, uniPacket);
    }

    public void N3(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f318331i = new CountDownLatch(list.size());
            this.f318328e = null;
            this.f318328e = new int[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.f318328e[i3] = -1;
                M3(list.get(i3), i3);
            }
            try {
                this.f318331i.await();
                StringBuilder sb5 = new StringBuilder();
                for (int i16 : this.f318328e) {
                    sb5.append(i16);
                }
                ms.a.f("WinkPhotoListServiceHandler", "checkImageValid Success validStatusArray: " + sb5.toString());
                notifyUI(3, K3(this.f318328e), this.f318328e);
                return;
            } catch (InterruptedException e16) {
                ms.a.c("WinkPhotoListServiceHandler", "requestFaceDetect error: " + e16.getMessage());
                notifyUI(3, false, this.f318328e);
                return;
            }
        }
        ms.a.c("WinkPhotoListServiceHandler", "requestFaceDetect error: filePaths is null or emtpty");
    }

    public void Q3(ArrayList<d> arrayList, int i3) {
        R3(arrayList, i3, null);
    }

    public void R3(ArrayList<d> arrayList, int i3, @Nullable Consumer<Float> consumer) {
        ms.a.a("WinkPhotoListServiceHandler", "[requestProcessMedias] " + arrayList.size());
        if (arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next());
        }
        this.f318332m = new AbortableCountDownLatch(arrayList2.size());
        this.f318330h.clear();
        ms.a.a("WinkPhotoListServiceHandler", "[requestNormalProcessMedias] " + arrayList2.size());
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            d dVar = (d) arrayList2.get(i16);
            ms.a.a("WinkPhotoListServiceHandler", "[requestProcessMedias] index: " + i16 + " originDownloadUrl: " + dVar.f318351b);
            w3(dVar, i16);
        }
        try {
            this.f318332m.await();
            this.f318332m = null;
            ms.a.a("WinkPhotoListServiceHandler", "[requestProcessMedias] Success processResults: " + this.f318330h);
            x3(i3);
        } catch (Throwable th5) {
            ms.a.d("WinkPhotoListServiceHandler", "[requestProcessMedias] error: " + th5.getMessage(), th5);
            notifyUI(i3, false, th5);
        }
    }

    public void S3(List<Pair<String, Integer>> list) {
        ms.a.a("WinkPhotoListServiceHandler", "[uploadImages] ");
        if (list.isEmpty()) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        this.f318329f = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            ms.a.a("WinkPhotoListServiceHandler", "uploadImage index: " + i3);
            Pair<String, Integer> pair = list.get(i3);
            String u36 = u3(pair.getFirst(), pair.getSecond().intValue());
            g.c(u36, com.tencent.mobileqq.wink.utils.an.f326680a.h(u36), new a(pair, countDownLatch));
        }
        try {
            countDownLatch.await();
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = this.f318329f.values().iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
            }
            ms.a.a("WinkPhotoListServiceHandler", "uploadImages finish downloadUrlArray len: " + this.f318329f.size() + " downloadUrlArrayStr:" + sb5.toString());
            notifyUI(4, true, this.f318329f);
        } catch (InterruptedException e16) {
            ms.a.c("WinkPhotoListServiceHandler", "uploadImages error: " + e16.getMessage());
            notifyUI(4, false, this.f318329f);
        }
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return TemplateLibBaseMediaInterceptor.class;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT)) {
            F3(fromServiceMsg, obj);
        } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.InspirationAI")) {
            I3(fromServiceMsg, obj);
        } else if (toServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCircleTemplateInfo")) {
            G3(fromServiceMsg, obj);
        }
    }

    public void requestTemplateUserInfo() {
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.g("WinkPhotoListServiceHandler", "[requestTemplateUserInfo] no network....");
        } else {
            w53.b.f("WinkPhotoListServiceHandler", "\u3010REQUEST\u3011requestTemplateUserInfo");
            x53.c.a(new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCircleTemplateInfo"), getClass().getName(), x53.b.class);
        }
    }

    public void t3() {
        AbortableCountDownLatch abortableCountDownLatch = this.f318332m;
        if (abortableCountDownLatch != null) {
            abortableCountDownLatch.a();
        }
        this.f318332m = null;
        this.E = "";
    }

    public void v3() {
        this.E = "WinkPhotoListServiceHandler" + System.currentTimeMillis();
    }

    /* loaded from: classes21.dex */
    class a implements g.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Pair f318333d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f318334e;

        a(Pair pair, CountDownLatch countDownLatch) {
            this.f318333d = pair;
            this.f318334e = countDownLatch;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onCancel() {
            ms.a.a("WinkPhotoListServiceHandler", "[uploadImages]uploadImage Cancel ");
            this.f318334e.countDown();
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onFail() {
            ms.a.a("WinkPhotoListServiceHandler", "[uploadImages]uploadImage Fail ");
            this.f318334e.countDown();
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onSuccess(String str) {
            WinkPhotoListServiceHandler.this.f318329f.put((String) this.f318333d.getFirst(), str);
            this.f318334e.countDown();
            ms.a.a("WinkPhotoListServiceHandler", "[uploadImages]uploadImage Success imageDownLoadUrl: " + str);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onProgress(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f318336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318337b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.edit.bean.a f318338c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f318339d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f318340e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f318341f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ShadowInspirationAI$InspirationMediaInfo f318342g;

        b(CountDownLatch countDownLatch, String str, com.tencent.mobileqq.wink.edit.bean.a aVar, String[] strArr, int i3, List list, ShadowInspirationAI$InspirationMediaInfo shadowInspirationAI$InspirationMediaInfo) {
            this.f318336a = countDownLatch;
            this.f318337b = str;
            this.f318338c = aVar;
            this.f318339d = strArr;
            this.f318340e = i3;
            this.f318341f = list;
            this.f318342g = shadowInspirationAI$InspirationMediaInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean c(String str) {
            boolean z16;
            if (str != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }

        @Override // y53.a.InterfaceC11592a
        public void a(NetResp netResp) {
            String str;
            boolean all;
            ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] onDownloadFinish - countDownLatch = " + this.f318336a.getCount());
            if (netResp != null && netResp.mResult == 0) {
                str = this.f318337b;
            } else {
                str = "";
            }
            if (this.f318338c.busiID.equals(QQWinkConstants.INSPIRATION_WIREFRAME_AR_BUSI_ID)) {
                String[] strArr = this.f318339d;
                strArr[this.f318340e] = str;
                all = ArraysKt___ArraysKt.all(strArr, new Function1() { // from class: com.tencent.mobileqq.wink.edit.manager.am
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean c16;
                        c16 = WinkPhotoListServiceHandler.b.c((String) obj);
                        return c16;
                    }
                });
                if (all) {
                    for (String str2 : this.f318339d) {
                        this.f318338c.a(str2);
                    }
                }
            } else {
                List list = this.f318341f;
                if (list != null && !list.isEmpty()) {
                    if (this.f318340e < this.f318341f.size()) {
                        this.f318338c.d(((Integer) this.f318341f.get(this.f318340e)).intValue(), str);
                    }
                } else {
                    com.tencent.mobileqq.wink.edit.bean.a aVar = this.f318338c;
                    aVar.d(aVar.index, str);
                }
            }
            ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] downLoadOneResInternal-onDownloadFinish");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", this.f318342g.MediaType.get());
                jSONObject.put("data", str);
                jSONObject.put("index", this.f318342g.Index.get());
                WinkEditorResourceManager.a1().s3(this.f318338c.reqId, jSONObject);
            } catch (Exception e16) {
                ms.a.c("WinkPhotoListServiceHandler", "[downloadMediaFiles] exception: " + e16.getMessage());
            }
            this.f318336a.countDown();
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f318344a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318345b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.edit.bean.a f318346c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f318347d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f318348e;

        c(CountDownLatch countDownLatch, String str, com.tencent.mobileqq.wink.edit.bean.a aVar, String[] strArr, int i3) {
            this.f318344a = countDownLatch;
            this.f318345b = str;
            this.f318346c = aVar;
            this.f318347d = strArr;
            this.f318348e = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean c(String str) {
            boolean z16;
            if (str != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }

        @Override // y53.a.InterfaceC11592a
        public void a(NetResp netResp) {
            String str;
            boolean all;
            ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] onDownloadFinish - countDownLatch = " + this.f318344a.getCount());
            if (netResp != null && netResp.mResult == 0) {
                str = this.f318345b;
            } else {
                str = "";
            }
            if (this.f318346c.busiID.equals(QQWinkConstants.INSPIRATION_WIREFRAME_AR_BUSI_ID)) {
                String[] strArr = this.f318347d;
                strArr[this.f318348e] = str;
                all = ArraysKt___ArraysKt.all(strArr, new Function1() { // from class: com.tencent.mobileqq.wink.edit.manager.an
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean c16;
                        c16 = WinkPhotoListServiceHandler.c.c((String) obj);
                        return c16;
                    }
                });
                if (all) {
                    for (String str2 : this.f318347d) {
                        this.f318346c.a(str2);
                    }
                }
            } else {
                com.tencent.mobileqq.wink.edit.bean.a aVar = this.f318346c;
                aVar.d(aVar.index, str);
            }
            ms.a.f("WinkPhotoListServiceHandler", "[downloadMediaFiles] downLoadOneResInternal-onDownloadFinish");
            this.f318344a.countDown();
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int i3) {
        }
    }
}
