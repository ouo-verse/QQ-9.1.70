package com.tencent.mobileqq.wink.edit.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetIsUserPublishedReq;
import camera.SHADOW_BACKEND_INTERFACE.GetIsUserPublishedRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.FilterableInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.intermediate.protocol.SHADOW_BACKEND_INTERFACE.GetMaterialInfoByIdsRsp;
import com.tencent.mobileqq.wink.pb.GetMediaMaterialRecommendationRsp;
import com.tencent.mobileqq.wink.pb.MediaMatRecInfo;
import com.tencent.mobileqq.wink.request.material.WinkEditorMaterialReq;
import com.tencent.mobileqq.wink.request.material.WinkGetMaterialByIdsReq;
import com.tencent.mobileqq.wink.request.material.WinkRecommendationMaterialReq;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import qshadow.QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp;
import qshadow.QShadowMaterialDistribution$GetMaterialInfoByIdsRsp;
import qshadow.QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp;
import qshadow.QzoneAIGC$O3TextCheckRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkDataServiceHandler extends WinkDataBaseServiceHandler {

    /* renamed from: d */
    private HashMap<String, Long> f318229d;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends TypeToken<List<MetaMaterial>> {
        a() {
        }
    }

    public WinkDataServiceHandler(AppInterface appInterface) {
        super(appInterface);
        this.f318229d = new HashMap<>();
    }

    private String K2(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + "." + str2;
    }

    public static byte[] L2(String str, int i3) {
        int round;
        int i16;
        Bitmap createScaledBitmap;
        byte[] byteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(str, options);
        int i17 = options.outWidth;
        int i18 = options.outHeight;
        if (i17 > i18) {
            round = Math.round((i17 * 1.0f) / i3);
            i16 = (i18 * i3) / i17;
        } else {
            round = Math.round((i18 * 1.0f) / i3);
            int i19 = (i17 * i3) / i18;
            i16 = i3;
            i3 = i19;
        }
        int i26 = 0;
        options.inJustDecodeBounds = false;
        options.inSampleSize = Math.max(round, 1);
        Bitmap d16 = com.tencent.mobileqq.wink.utils.f.d(str, options);
        while (true) {
            createScaledBitmap = Bitmap.createScaledBitmap(d16, i3, i16, true);
            if (createScaledBitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray.length <= 102400) {
                    break;
                }
                int i27 = i26 + 1;
                if (i26 >= 6) {
                    break;
                }
                i16 = (int) (i16 * 0.8d);
                i3 = (int) (i3 * 0.8d);
                i26 = i27;
            }
        }
        if (d16 != null && !d16.isRecycled()) {
            d16.recycle();
        }
        if (!createScaledBitmap.isRecycled()) {
            createScaledBitmap.recycle();
        }
        return byteArray;
    }

    private boolean M2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetIsUserPublishedReq getIsUserPublishedReq = new GetIsUserPublishedReq();
        getIsUserPublishedReq.Uin = this.appRuntime.getAccount();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.GetIsUserPublished");
        uniPacket.put("ShadowBackendSvc.GetIsUserPublished", getIsUserPublishedReq);
        return true;
    }

    private void O2(WinkEditorMaterialReq winkEditorMaterialReq, GetCatMatTreeRsp getCatMatTreeRsp) {
        if ("MqKuaishanPictureRecommend".equals(winkEditorMaterialReq.getServiceId())) {
            W2(null, getCatMatTreeRsp);
            return;
        }
        if ("MqKuaishanRedPacket".equals(winkEditorMaterialReq.getServiceId())) {
            d3(null, getCatMatTreeRsp);
            return;
        }
        if ("ZplanAISculpt".equals(winkEditorMaterialReq.getServiceId())) {
            N2(getCatMatTreeRsp);
            return;
        }
        if ("wordpicture".equals(winkEditorMaterialReq.getServiceId())) {
            P2(null, getCatMatTreeRsp);
            return;
        }
        if ("qzoneMagicStudio".equals(winkEditorMaterialReq.getServiceId())) {
            Y2(getCatMatTreeRsp);
            return;
        }
        if ("XsjRemberTemplate".equals(winkEditorMaterialReq.getServiceId())) {
            T2(getCatMatTreeRsp);
            return;
        }
        if ("OpeningEndingTemplate".equals(winkEditorMaterialReq.getServiceId())) {
            U2(getCatMatTreeRsp);
            return;
        }
        if ("MagicAvatar".equals(winkEditorMaterialReq.getServiceId())) {
            S2(getCatMatTreeRsp);
            return;
        }
        if ("MqQzonePhotoEditTemplate".equals(winkEditorMaterialReq.getServiceId())) {
            c3(getCatMatTreeRsp);
            return;
        }
        if ("QZonePhotoTemplate".equals(winkEditorMaterialReq.getServiceId())) {
            X2(getCatMatTreeRsp);
        } else if ("UGCBotStyle".equals(winkEditorMaterialReq.getServiceId())) {
            e3(getCatMatTreeRsp);
        } else {
            Q2(getCatMatTreeRsp, winkEditorMaterialReq.getServiceId());
        }
    }

    public void V2(final boolean z16, final long j3, String str, final BaseRequest baseRequest, final MessageMicro messageMicro) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkDataServiceHandler.this.h3(z16, j3, baseRequest, messageMicro);
            }
        }, 64, null, false);
    }

    private void Z2(QzoneAIGC$O3TextCheckRsp qzoneAIGC$O3TextCheckRsp) {
        w53.b.f("WinkDataServiceHandler", "[onReceive] handleQzoneResponse = " + qzoneAIGC$O3TextCheckRsp.is_legal.get());
        WinkEditorResourceManager.a1().y1().postValue(Boolean.valueOf(qzoneAIGC$O3TextCheckRsp.is_legal.get()));
    }

    private void a3(GetMediaMaterialRecommendationRsp getMediaMaterialRecommendationRsp) {
        Object obj;
        MediaMatRecInfo[] mediaMatRecInfoArr;
        if (getMediaMaterialRecommendationRsp != null && getMediaMaterialRecommendationRsp.Code == 0 && (mediaMatRecInfoArr = getMediaMaterialRecommendationRsp.Materials) != null && mediaMatRecInfoArr.length != 0) {
            ArrayList<MetaMaterial> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (MediaMatRecInfo mediaMatRecInfo : getMediaMaterialRecommendationRsp.Materials) {
                MetaMaterial metaMaterial = mediaMatRecInfo.materialInfo;
                if (metaMaterial != null) {
                    arrayList.add(y53.b.b(metaMaterial));
                    arrayList2.add(mediaMatRecInfo.reason);
                }
            }
            j3(arrayList);
            h.d().o(arrayList, arrayList2);
            WinkEditorResourceManager.a1().p3();
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleRecommendAutoTemplate, ");
        if (getMediaMaterialRecommendationRsp != null) {
            obj = Integer.valueOf(getMediaMaterialRecommendationRsp.Code);
        } else {
            obj = "null";
        }
        sb5.append(obj);
        w53.b.g("WinkDataServiceHandler", sb5.toString());
        h.d().k();
        WinkEditorResourceManager.a1().p3();
    }

    private void b3(GetMediaMaterialRecommendationRsp getMediaMaterialRecommendationRsp) {
        MediaMatRecInfo[] mediaMatRecInfoArr;
        if (getMediaMaterialRecommendationRsp != null && getMediaMaterialRecommendationRsp.Code == 0 && (mediaMatRecInfoArr = getMediaMaterialRecommendationRsp.Materials) != null && mediaMatRecInfoArr.length != 0) {
            ArrayList<MetaMaterial> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (MediaMatRecInfo mediaMatRecInfo : getMediaMaterialRecommendationRsp.Materials) {
                arrayList.add(mediaMatRecInfo.materialInfo);
                arrayList2.add(mediaMatRecInfo.reason);
            }
            h.d().q(arrayList, arrayList2);
            WinkEditorResourceManager.a1().j3();
        }
    }

    private void f3(FromServiceMsg fromServiceMsg, Object obj) {
        GetIsUserPublishedRsp getIsUserPublishedRsp;
        if (obj != null) {
            getIsUserPublishedRsp = (GetIsUserPublishedRsp) obj;
        } else {
            getIsUserPublishedRsp = null;
        }
        if (getIsUserPublishedRsp != null) {
            AECameraPrefsUtil.c().h(AECameraPrefsUtil.f318470h, getIsUserPublishedRsp.IsPublished, 4);
        }
    }

    private static boolean g3() {
        return false;
    }

    public /* synthetic */ void h3(boolean z16, long j3, BaseRequest baseRequest, MessageMicro messageMicro) {
        if (z16 && j3 == 0) {
            i3(baseRequest, messageMicro);
        } else {
            i3(baseRequest, null);
        }
    }

    private void j3(List<MetaMaterial> list) {
        LocalMultiProcConfig.putString(IWinkEditorResourceAPI.RECOMMEND_METAMATERIALS, new Gson().toJson(list, new a().getType()));
    }

    private void k3(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        this.f318229d.put(K2(toServiceMsg.getServiceCmd(), toServiceMsg.extraData.getString("ServiceId")), Long.valueOf(System.currentTimeMillis()));
    }

    private void l3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        Long l3;
        if (!(obj instanceof GetCatMatTreeRsp)) {
            return;
        }
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        String serviceCmd = toServiceMsg.getServiceCmd();
        String string = toServiceMsg.extraData.getString("ServiceId");
        String K2 = K2(serviceCmd, string);
        if (this.f318229d.containsKey(K2) && (l3 = this.f318229d.get(K2)) != null) {
            j3 = System.currentTimeMillis() - l3.longValue();
        } else {
            j3 = -1;
        }
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportCameraServer(fromServiceMsg.getResultCode(), String.valueOf(j3), serviceCmd + "." + string, getCatMatTreeRsp.Code);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public Object D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetIsUserPublished")) {
            return E2(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetIsUserPublished", new GetIsUserPublishedRsp());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public boolean F2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        k3(toServiceMsg, uniPacket);
        try {
            if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetIsUserPublished")) {
                return M2(toServiceMsg, uniPacket);
            }
            return false;
        } catch (Throwable th5) {
            w53.b.c("WinkDataServiceHandler", "encodeReqMsg|exception :" + th5.getMessage());
            return false;
        }
    }

    protected void N2(GetCatMatTreeRsp getCatMatTreeRsp) {
        ArrayList<MetaCategory> arrayList;
        String str;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
            while (it.hasNext()) {
                MetaCategory next = it.next();
                MetaCategory a16 = y53.b.a(next);
                String str2 = "";
                if ("ZplanAISculptAnimojiMaterial".equals(next.f30532id)) {
                    str = "ae_key_editor_zplan_filament_face_camera_material_json";
                } else if (!"ZplanAISculptThumbnailMaterial".equals(next.f30532id)) {
                    str = "";
                } else {
                    str = "ae_key_editor_zplan_filament_face_thumbnail_material_json";
                }
                ArrayList<MetaMaterial> arrayList2 = a16.materials;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
                    MetaMaterial metaMaterial = a16.materials.get(0);
                    aEMaterialMetaData.f69050id = metaMaterial.f30533id;
                    aEMaterialMetaData.resurl = metaMaterial.packageUrl;
                    aEMaterialMetaData.md5 = metaMaterial.packageMd5;
                    aEMaterialMetaData.name = metaMaterial.showName;
                    w53.b.a("WinkDataServiceHandler", "update AiFace material " + next.f30532id + ", resUrl:" + aEMaterialMetaData.resurl);
                    str2 = new Gson().toJson(aEMaterialMetaData);
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    ar.f326685a.r(str, str2);
                }
            }
        }
    }

    protected void P2(FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<MetaCategory> arrayList;
        boolean z16;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
            while (it.hasNext()) {
                MetaCategory next = it.next();
                if ("muban".equals(next.f30532id)) {
                    String json = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handleMoodMaterials] .put, dataStr = " + json);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438396i, "editor_daily_sign_muban_template.json"), json);
                    WinkEditorResourceManager.a1().X2(next.f30532id);
                } else if ("background".equals(next.f30532id)) {
                    String json2 = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handleMoodMaterials] .put, dataStr = " + json2);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438396i, "editor_daily_sign_background_template.json"), json2);
                    WinkEditorResourceManager.a1().Q2("background");
                } else if ("music".equals(next.f30532id)) {
                    String json3 = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handleMoodMaterials] .put, dataStr = " + json3);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438396i, "editor_daily_sign_music_template.json"), json3);
                    WinkEditorResourceManager.a1().Q2("music");
                } else if ("mood".equals(next.f30532id)) {
                    String json4 = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handleMoodMaterials] .put, dataStr = " + json4);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438396i, "editor_daily_sign_mood_template.json"), json4);
                    WinkEditorResourceManager.a1().Q2("mood");
                } else {
                    z16 = false;
                }
                w53.b.a("WinkDataServiceHandler", next.f30532id + " isWriteFile:" + z16);
            }
        }
    }

    protected void Q2(GetCatMatTreeRsp getCatMatTreeRsp, String str) {
        Object obj;
        ArrayList<MetaCategory> arrayList;
        ArrayList<String> arrayList2;
        if (g3()) {
            if (getCatMatTreeRsp == null) {
                w53.b.c("WinkDataServiceHandler", "[handleEditorMaterials] response data is null");
            } else {
                w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] response.code = " + getCatMatTreeRsp.Code);
                ArrayList<MetaCategory> arrayList3 = getCatMatTreeRsp.Categories;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] response.Categories.size = " + getCatMatTreeRsp.Categories.size());
                    Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
                    while (it.hasNext()) {
                        MetaCategory next = it.next();
                        w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] categories.name = " + next.name);
                        w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] categories.subCategories = " + next.subCategories.size());
                        w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] categories.materials = " + next.materials.size());
                    }
                }
            }
        }
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            if (!com.tencent.mobileqq.wink.request.material.a.f326269a.b()) {
                StringBuilder sb5 = new StringBuilder();
                ArrayList<FilterableInfo> arrayList4 = getCatMatTreeRsp.FilterableInfos;
                if (arrayList4 != null && !arrayList4.isEmpty()) {
                    Iterator<FilterableInfo> it5 = getCatMatTreeRsp.FilterableInfos.iterator();
                    while (it5.hasNext()) {
                        FilterableInfo next2 = it5.next();
                        if (next2.FilterableField.equals(AECameraPrefsUtil.f318477o) && (arrayList2 = next2.FilterableEnumValue) != null) {
                            arrayList2.remove(AECameraPrefsUtil.f318480r);
                            w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] material rhythm data = " + next2.FilterableEnumValue);
                            Collections.sort(next2.FilterableEnumValue);
                            w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] material rhythm sorted data = " + next2.FilterableEnumValue);
                            Iterator<String> it6 = next2.FilterableEnumValue.iterator();
                            while (it6.hasNext()) {
                                sb5.append(it6.next());
                                sb5.append(AECameraPrefsUtil.f318481s);
                            }
                        }
                    }
                }
                AECameraPrefsUtil.c().k(AECameraPrefsUtil.f318482t, sb5.toString(), 4);
            }
            Iterator<MetaCategory> it7 = getCatMatTreeRsp.Categories.iterator();
            while (true) {
                boolean z16 = false;
                if (!it7.hasNext()) {
                    break;
                }
                MetaCategory next3 = it7.next();
                if (next3.f30532id.equals("10004")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438404q, "editor_filter_update_template.json"), new Gson().toJson(next3.subCategories));
                    WinkEditorResourceManager.a1().V2();
                } else if (next3.f30532id.equals("10002")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438389b, "editor_text_sticker_update_template.json"), new Gson().toJson(next3.subCategories));
                    WinkEditorResourceManager.a1().j3();
                } else if (next3.f30532id.equals(HippyQQConstants.HIPPY_CHANNEL)) {
                    List linkedList = new LinkedList();
                    ArrayList<MetaCategory> arrayList5 = next3.subCategories;
                    if (arrayList5 != null) {
                        linkedList = y53.b.c(arrayList5);
                    }
                    MetaCategory metaCategory = new MetaCategory();
                    metaCategory.materials = next3.materials;
                    metaCategory.f30532id = WinkMaterialViewModel.UNCATEGORIZED_METACATEGORY;
                    metaCategory.name = "\u672a\u5206\u7c7b";
                    linkedList.add(metaCategory);
                    String json = new Gson().toJson(linkedList);
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handleEditorMaterials] autoTemplate.put, dataStr = " + json);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438391d, "editor_auto_template_update_template.json"), json);
                    WinkEditorResourceManager.a1().p3();
                } else if (next3.f30532id.equals("10003")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438405r, "editor_text_update_template.json"), new Gson().toJson(next3.subCategories));
                    WinkEditorResourceManager.a1().l3();
                } else if (next3.f30532id.equals("10010")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438390c, "editor_special_effect_update_template.json"), new Gson().toJson(next3.subCategories));
                    WinkEditorResourceManager.a1().U2();
                } else if (next3.f30532id.equals("10006")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438409v, "editor_lyric_stickers_update_template.json"), new Gson().toJson(next3.subCategories));
                    WinkEditorResourceManager.a1().Y2();
                } else if (next3.f30532id.equals("10007")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438410w, "cover_template.json"), new Gson().toJson(next3.subCategories));
                    WinkEditorResourceManager.a1().P2();
                } else if (next3.f30532id.equals("10008")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438392e, "editor_first_template_update_template.json"), new Gson().toJson(y53.b.c(Collections.singletonList(next3))));
                    WinkEditorResourceManager.a1().W2();
                } else if (next3.f30532id.equals("10009")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438411x, "background_template.json"), new Gson().toJson(y53.b.c(Collections.singletonList(next3))));
                    WinkEditorResourceManager.a1().O2();
                } else if (next3.f30532id.equals("10012")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438401n, "editor_avatar_update_template.json"), new Gson().toJson(y53.b.c(Collections.singletonList(next3))));
                    WinkEditorResourceManager.a1().X2(next3.f30532id);
                } else if (next3.f30532id.equals("10013")) {
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438401n, "editor_low_threshold_update_template.json"), new Gson().toJson(y53.b.c(Collections.singletonList(next3))));
                    WinkEditorResourceManager.a1().X2(next3.f30532id);
                }
                w53.b.a("WinkDataServiceHandler", next3.f30532id + " isWriteFile:" + z16);
            }
            WinkEditorResourceManager.a1().A(false);
            if (g3()) {
                StringBuilder sb6 = new StringBuilder();
                Iterator<MetaCategory> it8 = getCatMatTreeRsp.Categories.iterator();
                while (it8.hasNext()) {
                    sb6.append(it8.next().name + ", ");
                }
                w53.b.a("WinkDataServiceHandler", "###  updateData (downloaded), category = " + sb6.toString());
            }
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("WinkEditorMaterialReq response code:");
            if (getCatMatTreeRsp != null) {
                obj = Integer.valueOf(getCatMatTreeRsp.Code);
            } else {
                obj = "null";
            }
            sb7.append(obj);
            w53.b.a("WinkDataServiceHandler", sb7.toString());
        }
        notifyUI(1, true, null);
    }

    protected void S2(Object obj) {
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp.Categories);
            if (g3()) {
                w53.b.f("WinkDataServiceHandler", "[handleMagicAvatarMaterials] .put, dataStr = " + json);
            }
            FileUtils.writeFile(h.d().b(u53.f.f438394g, "editor_magic_avatar_template.json"), json);
            WinkEditorResourceManager.a1().Z2();
        }
    }

    protected void T2(Object obj) {
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp.Categories);
            if (g3()) {
                w53.b.f("WinkDataServiceHandler", "[handleMoodMaterials] .put, dataStr = " + json);
            }
            FileUtils.writeFile(h.d().b(u53.f.f438399l, "editor_memory_album_config_template.json"), json);
            WinkEditorResourceManager.a1().b3();
        }
    }

    protected void U2(Object obj) {
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && ((getCatMatTreeRsp.Code == 0 || getCatMatTreeRsp.Categories != null) && !getCatMatTreeRsp.Categories.isEmpty())) {
            FileUtils.writeFile(h.d().b(u53.f.f438400m, "editor_opening_ending_template.json"), new Gson().toJson(y53.b.c(getCatMatTreeRsp.Categories)));
            WinkEditorResourceManager.a1().c3();
            return;
        }
        w53.b.c("WinkDataServiceHandler", "handleOpeningEndingMaterials failed, response is empty");
    }

    protected void W2(FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<MetaCategory> arrayList;
        boolean z16;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
            while (it.hasNext()) {
                MetaCategory next = it.next();
                if ("10002".equals(next.f30532id)) {
                    String json = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handlePicRecommendMaterials] autoTemplate.put, dataStr = " + json);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438393f, "editor_pic_recommend_update_template.json"), json);
                    WinkEditorResourceManager.a1().d3();
                } else if ("10003".equals(next.f30532id)) {
                    String json2 = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handlePicRecommendMaterials] autoTemplate.put, dataStr = " + json2);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.f438402o, "editor_pic_recommend_user_published_update_template.json"), json2);
                    WinkEditorResourceManager.a1().o3();
                } else {
                    z16 = false;
                }
                w53.b.a("WinkDataServiceHandler", next.f30532id + " isWriteFile:" + z16);
            }
        }
    }

    protected void X2(Object obj) {
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp.Categories);
            if (g3()) {
                w53.b.f("WinkDataServiceHandler", "[SHADOW_BACKEND_INTERFACE] .put, dataStr = " + json);
            }
            FileUtils.writeFile(h.d().b(u53.f.f438398k, "editor_qzone_image_template.json"), json);
            WinkEditorResourceManager.a1().f3();
            return;
        }
        w53.b.c("WinkDataServiceHandler", "handleQzoneImageTemplateMaterials failed: " + getCatMatTreeRsp);
    }

    protected void Y2(Object obj) {
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp.Categories);
            if (g3()) {
                w53.b.f("WinkDataServiceHandler", "[handleQzoneMagicStudioMaterials] .put, dataStr = " + json);
            }
            FileUtils.writeFile(h.d().b(u53.f.f438395h, "editor_qzone_magic_studio_template.json"), json);
            WinkEditorResourceManager.a1().g3();
        }
    }

    protected void c3(Object obj) {
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp.Categories);
            if (g3()) {
                w53.b.f("WinkDataServiceHandler", "[handleRecommendTemplateMaterials] .put, dataStr = " + json);
            }
            FileUtils.writeFile(h.d().b(u53.f.C, "qzone_auto_template_recommend.json"), json);
            WinkEditorResourceManager.a1().h3();
        }
    }

    protected void d3(FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<MetaCategory> arrayList;
        boolean z16;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
            while (it.hasNext()) {
                MetaCategory next = it.next();
                if ("RedPacket".equals(next.f30532id)) {
                    String json = new Gson().toJson(y53.b.c(Collections.singletonList(next)));
                    if (g3()) {
                        w53.b.f("WinkDataServiceHandler", "[handleRedPacketMaterials] autoTemplate.put, dataStr = " + json);
                    }
                    z16 = FileUtils.writeFile(h.d().b(u53.f.A, "editor_red_packet_template.json"), json);
                    WinkEditorResourceManager.a1().i3();
                } else {
                    z16 = false;
                }
                w53.b.a("WinkDataServiceHandler", next.f30532id + " isWriteFile:" + z16);
            }
        }
    }

    protected void e3(Object obj) {
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp.Categories);
            if (g3()) {
                w53.b.f("WinkDataServiceHandler", "[handleUgcBotMaterials] .put, dataStr = " + json);
            }
            FileUtils.writeFile(h.d().b(u53.f.f438397j, "editor_ugc_bot_template.json"), json);
            WinkEditorResourceManager.a1().n3();
        }
    }

    protected void i3(BaseRequest baseRequest, MessageMicro messageMicro) {
        char c16;
        GetMediaMaterialRecommendationRsp getMediaMaterialRecommendationRsp;
        if (baseRequest == null) {
            return;
        }
        try {
            String str = baseRequest.get$cmd();
            switch (str.hashCode()) {
                case -961577193:
                    if (str.equals("trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_circle_material_lite")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -650749715:
                    if (str.equals("trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_o3_security_check")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 317238394:
                    if (str.equals("trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_materialinfo_by_ids")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1872459510:
                    if (str.equals("trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_media_material_recommendation")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        if (c16 == 3) {
                            Z2((QzoneAIGC$O3TextCheckRsp) messageMicro);
                            return;
                        }
                        return;
                    }
                    R2(v53.a.g((QShadowMaterialDistribution$GetMaterialInfoByIdsRsp) messageMicro));
                    return;
                }
                WinkRecommendationMaterialReq winkRecommendationMaterialReq = (WinkRecommendationMaterialReq) baseRequest;
                if (winkRecommendationMaterialReq.getBusiId() == 65538) {
                }
                if (messageMicro != null) {
                    getMediaMaterialRecommendationRsp = v53.a.h((QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp) messageMicro);
                } else {
                    getMediaMaterialRecommendationRsp = null;
                }
                if (winkRecommendationMaterialReq.getBusiId() == 65538) {
                    a3(getMediaMaterialRecommendationRsp);
                    return;
                } else {
                    if (winkRecommendationMaterialReq.getBusiId() == 65537) {
                        b3(getMediaMaterialRecommendationRsp);
                        return;
                    }
                    return;
                }
            }
            WinkEditorMaterialReq winkEditorMaterialReq = (WinkEditorMaterialReq) baseRequest;
            O2(winkEditorMaterialReq, winkEditorMaterialReq.getCatMatTreeRepFromPB(messageMicro));
        } catch (Throwable th5) {
            w53.b.c("WinkDataServiceHandler", "[onReceive] exception = " + th5.getMessage());
            if (0 != 0) {
                a3(null);
            }
        }
    }

    public void m3(String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.g("WinkDataServiceHandler", "[requestEditorMaterialsPB] no network....");
            return;
        }
        w53.b.f("WinkDataServiceHandler", "\u3010REQUEST\u3011requestEditorMaterialsPB" + str);
        w93.e.f445096a.g(new WinkEditorMaterialReq(str), new w93.a() { // from class: com.tencent.mobileqq.wink.edit.manager.a
            @Override // w93.a
            public final void a(boolean z16, long j3, String str2, BaseRequest baseRequest, MessageMicro messageMicro) {
                WinkDataServiceHandler.this.V2(z16, j3, str2, baseRequest, (QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp) messageMicro);
            }
        }, ", serviceId:" + str);
    }

    public void n3(String str, String... strArr) {
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.g("WinkDataServiceHandler", "requestMaterialInfo, no network....");
            return;
        }
        w53.b.a("WinkDataServiceHandler", "requestMaterialInfo, materialIds: " + Arrays.toString(strArr));
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        w93.e.f445096a.f(new WinkGetMaterialByIdsReq(str, arrayList), new w93.a() { // from class: com.tencent.mobileqq.wink.edit.manager.b
            @Override // w93.a
            public final void a(boolean z16, long j3, String str2, BaseRequest baseRequest, MessageMicro messageMicro) {
                WinkDataServiceHandler.this.V2(z16, j3, str2, baseRequest, (QShadowMaterialDistribution$GetMaterialInfoByIdsRsp) messageMicro);
            }
        });
    }

    public void o3(@Nullable List<LocalMediaInfo> list, List<byte[]> list2, int i3) {
        if (!NetworkUtil.isNetworkAvailable()) {
            h.d().k();
            return;
        }
        if (list2 == null) {
            list2 = Collections.emptyList();
        }
        w93.e.f445096a.f(new WinkRecommendationMaterialReq(65538, list, list2, i3), new d(this));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return WinkEditorFragment.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        w93.e.f445096a.c();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (g3()) {
            w53.b.f("WinkDataServiceHandler", "[onReceive] req = " + toServiceMsg);
            w53.b.f("WinkDataServiceHandler", "[onReceive] res = " + fromServiceMsg);
        }
        l3(toServiceMsg, fromServiceMsg, obj);
        try {
            if (toServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetIsUserPublished")) {
                f3(fromServiceMsg, obj);
            }
        } catch (Throwable th5) {
            w53.b.c("WinkDataServiceHandler", "[onReceive] exception = " + th5.getMessage());
        }
    }

    public void p3(List<byte[]> list, int i3) {
        if (!NetworkUtil.isNetworkAvailable()) {
            h.d().k();
            return;
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        w93.e.f445096a.f(new WinkRecommendationMaterialReq(65537, null, list, i3), new d(this));
    }

    public void q3() {
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.g("WinkDataServiceHandler", "[requestUserPublished] no network....");
        } else {
            w53.b.f("WinkDataServiceHandler", "\u3010REQUEST\u3011requestUserPublished");
            x53.c.a(new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetIsUserPublished"), getClass().getName(), x53.b.class);
        }
    }

    protected void R2(GetMaterialInfoByIdsRsp getMaterialInfoByIdsRsp) {
    }
}
