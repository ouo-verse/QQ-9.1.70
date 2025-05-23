package com.tencent.mobileqq.wink.editor.draft;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, WinkEditDataWrapper> f319941a = new ConcurrentHashMap();

    public static void a(String str) {
        w53.b.f("WinkEditDataHelper", "clearMediaData, missionId:" + str);
        if (TextUtils.isEmpty(str)) {
            w53.b.c("WinkEditDataHelper", "clearMediaData, clearMediaData is null");
            return;
        }
        AECameraPrefsUtil.c().l(AECameraPrefsUtil.f318471i + str, 4);
    }

    public static WinkEditDataWrapper b(String str) {
        w53.b.a("WinkEditDataHelper", "getMediaModelForCover missionId:" + str);
        return c(j.o(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1 A[Catch: IOException -> 0x00f5, TRY_LEAVE, TryCatch #4 {IOException -> 0x00f5, blocks: (B:37:0x00ec, B:39:0x00f1), top: B:36:0x00ec }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WinkEditDataWrapper c(String str) {
        ObjectInputStream objectInputStream;
        w53.b.a("WinkEditDataHelper", "getMediaModelForEdit missionId:" + str);
        ObjectInputStream objectInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            ms.a.c("WinkEditDataHelper", "missionId is null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String g16 = AECameraPrefsUtil.c().g(AECameraPrefsUtil.f318471i + str, "", 4);
        if (!TextUtils.isEmpty(g16)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(g16, 0));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                try {
                    byteArrayInputStream.close();
                    if (objectInputStream2 != null) {
                    }
                } catch (IOException e17) {
                    ms.a.e("WinkEditDataHelper", e17);
                }
                throw th;
            }
            try {
                try {
                    WinkEditDataWrapper winkEditDataWrapper = (WinkEditDataWrapper) objectInputStream.readObject();
                    g(winkEditDataWrapper);
                    w53.b.f("WinkEditDataHelper", "getMediaModel success, missionId:" + str + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    try {
                        byteArrayInputStream.close();
                        objectInputStream.close();
                    } catch (IOException e18) {
                        ms.a.e("WinkEditDataHelper", e18);
                    }
                    return winkEditDataWrapper;
                } catch (Throwable th6) {
                    th = th6;
                    objectInputStream2 = objectInputStream;
                    byteArrayInputStream.close();
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                ms.a.e("WinkEditDataHelper", e);
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.b(new WinkPublishQualityReportData.Builder().eventId("E_DATA_DECODE_ERROR").traceId("0").retCode("0").desc("wrapper\u89e3\u7801\u5931\u8d25").attachInfo(e.getMessage()).getReportData(), "QCIRCLE");
                }
                try {
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (IOException e26) {
                    ms.a.e("WinkEditDataHelper", e26);
                }
                w53.b.f("WinkEditDataHelper", "getMediaModel error, missionId:" + str);
                return null;
            }
        }
        ms.a.c("WinkEditDataHelper", "getMediaModelFromDraft error media is null");
        w53.b.f("WinkEditDataHelper", "getMediaModel error, missionId:" + str);
        return null;
    }

    public static WinkEditDataWrapper d(String str) {
        if (TextUtils.isEmpty(str)) {
            ms.a.c("WinkEditDataHelper", "getMediaModelForExport missionId is null");
            return null;
        }
        String o16 = j.o(str);
        w53.b.a("WinkEditDataHelper", "getMediaModelForExport missionId:" + o16);
        return c(o16);
    }

    public static WinkEditDataWrapper e(String str) {
        w53.b.a("WinkEditDataHelper", "getMediaModelForMerge missionId:" + str);
        return c("merge_data_" + str);
    }

    public static WinkEditDataWrapper f(String str) {
        w53.b.a("WinkEditDataHelper", "getMediaModelForPreview missionId:" + str);
        if (TextUtils.isEmpty(str)) {
            ms.a.c("WinkEditDataHelper", "missionId is null");
            return null;
        }
        WinkEditDataWrapper c16 = c(j.p(str));
        if (c16 != null) {
            w53.b.f("WinkEditDataHelper", "getMediaModel from cache, missionId:" + str);
            return c16;
        }
        return c(str);
    }

    private static void g(WinkEditDataWrapper winkEditDataWrapper) {
        ArrayList<WinkEditData> editDatas;
        if (winkEditDataWrapper != null && (editDatas = winkEditDataWrapper.getEditDatas()) != null && editDatas.size() > 0) {
            Iterator<WinkEditData> it = editDatas.iterator();
            while (it.hasNext()) {
                WinkEditData next = it.next();
                if (next.getStickerModelMap() != null) {
                    Iterator<String> it5 = next.getStickerModelMap().keySet().iterator();
                    while (it5.hasNext()) {
                        String next2 = it5.next();
                        if (next.getStickerExtraMap() != null) {
                            WinkStickerModel winkStickerModel = next.getStickerModelMap().get(next2);
                            WinkStickerModelExtra winkStickerModelExtra = next.getStickerExtraMap().get(next2);
                            if (winkStickerModel != null || winkStickerModelExtra != null) {
                                if (winkStickerModel != null && winkStickerModelExtra != null) {
                                    WinkEditData winkEditData = next;
                                    WinkStickerModel winkStickerModel2 = new WinkStickerModel(winkStickerModel.id, winkStickerModel.filePath, winkStickerModel.startTime, winkStickerModel.duration, winkStickerModel.layerIndex, winkStickerModel.scaleX, winkStickerModel.scaleY, winkStickerModel.rotate, winkStickerModel.centerX, winkStickerModel.centerY, winkStickerModel.editable, winkStickerModel.width, winkStickerModel.height, winkStickerModel.minScale, winkStickerModel.maxScale, winkStickerModel.textItems, winkStickerModel.thumbUrl, winkStickerModel.timelineTrackIndex, winkStickerModel.animationMode, winkStickerModel.type, winkStickerModel.materialId, winkStickerModel.captionInfo, winkStickerModel.localThumbId, winkStickerModel.editingLayerIndex, winkStickerModel.playEndDuration, winkStickerModel.actionType, winkStickerModel.bgConfig, winkStickerModel.bgPath, winkStickerModel.configType, winkStickerModel.frameScale, winkStickerModel.watermarkModel, winkStickerModel.imageType, winkStickerModel.unknownFields(), winkStickerModelExtra.getInitStickerScale(), winkStickerModelExtra.getDownScaleRecord(), winkStickerModelExtra.getOriginPointInView(), winkStickerModelExtra.getSizeInView(), winkStickerModelExtra.getCenterInView(), winkStickerModelExtra.getLeftTopInView(), winkStickerModelExtra.getRightBottomInView(), winkStickerModelExtra.getMaterial(), winkStickerModelExtra.getNormalizedLeftTopInView(), winkStickerModelExtra.getNormalizedRightBottomInView(), winkStickerModelExtra.getClickBoundsLeftTopInView(), winkStickerModelExtra.getClickBoundsRightBottomInView(), winkStickerModelExtra.isTraceSticker(), winkStickerModelExtra.getStickerTrackerResult(), winkStickerModelExtra.getEntityName(), winkStickerModelExtra.isTimeRangeChangedByUser(), 1.0f, 0.0f, winkStickerModelExtra.getTtsAudioInfo(), winkStickerModelExtra.getHasChooseTTS());
                                    winkStickerModel2.setLastDownScaleX(winkStickerModelExtra.getLastDownScaleX());
                                    winkStickerModel2.setLastDownScaleY(winkStickerModelExtra.getLastDownScaleY());
                                    winkStickerModel2.setLastDownRotate(winkStickerModelExtra.getLastDownRotate());
                                    winkEditData.getStickerModelMap().put(next2, winkStickerModel2);
                                    it = it;
                                    it5 = it5;
                                    next = winkEditData;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void h(WinkEditDataWrapper winkEditDataWrapper, String str) {
        ObjectOutputStream objectOutputStream;
        w53.b.f("WinkEditDataHelper", "saveMediaData, missionId:" + str);
        if (winkEditDataWrapper == null) {
            w53.b.c("WinkEditDataHelper", "saveMediaData, mediaModel is null");
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                objectOutputStream.writeObject(winkEditDataWrapper);
                String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                AECameraPrefsUtil.c().k(AECameraPrefsUtil.f318471i + str, str2, 4);
                QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeString(AECameraPrefsUtil.f318471i, str);
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Throwable th6) {
                th = th6;
                objectOutputStream2 = objectOutputStream;
                try {
                    ms.a.e("WinkEditDataHelper", th);
                    byteArrayOutputStream.close();
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream.close();
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                    } catch (IOException e16) {
                        ms.a.e("WinkEditDataHelper", e16);
                    }
                    throw th7;
                }
            }
        } catch (IOException e17) {
            ms.a.e("WinkEditDataHelper", e17);
        }
    }

    public static void i(WinkEditDataWrapper winkEditDataWrapper, String str) {
        w53.b.f("WinkEditDataHelper", "saveMediaDataForExport missionId:" + str);
        h(winkEditDataWrapper, j.o(str));
    }

    public static void j(WinkEditDataWrapper winkEditDataWrapper, String str) {
        w53.b.f("WinkEditDataHelper", "saveMediaDataForMerge missionId:" + str);
        h(winkEditDataWrapper, "merge_data_" + str);
    }

    public static void k(WinkEditDataWrapper winkEditDataWrapper, String str) {
        w53.b.f("WinkEditDataHelper", "saveMediaDataForExport missionId:" + str);
        h(winkEditDataWrapper, j.p(str));
    }
}
