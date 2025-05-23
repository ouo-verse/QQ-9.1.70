package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bt;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;
import tencent.im.msg.obj_msg$ObjMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f301968a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f301969b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f301970c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f301968a = 48;
        f301969b = new String[]{"\\", "/", ":", "*", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "\"", "<", ">", "|"};
        f301970c = false;
    }

    public static void A(QQAppInterface qQAppInterface, long j3, List<com.tencent.mobileqq.troop.data.n> list) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (com.tencent.mobileqq.troop.data.n nVar : list) {
                List list2 = (List) hashMap.get(Long.valueOf(j3));
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(Long.valueOf(j3), list2);
                }
                com.tencent.mobileqq.troop.data.t Y = QFileUtils.Y(qQAppInterface, j3, nVar);
                if (Y != null && Y.f294985s != null) {
                    list2.add(Y);
                } else {
                    return;
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                long longValue = ((Long) entry.getKey()).longValue();
                List<com.tencent.mobileqq.troop.data.t> list3 = (List) entry.getValue();
                TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, longValue);
                if (O != null) {
                    O.z0(list3);
                }
            }
        }
    }

    public static void B(QQAppInterface qQAppInterface, long j3, List<AIOMsgItem> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<AIOMsgItem> it = list.iterator();
            while (it.hasNext()) {
                MsgElement firstTypeElement = it.next().getFirstTypeElement(3);
                if (firstTypeElement != null && firstTypeElement.getFileElement() != null) {
                    FileElement fileElement = firstTypeElement.getFileElement();
                    com.tencent.mobileqq.troop.data.t tVar = new com.tencent.mobileqq.troop.data.t();
                    tVar.f294985s = fileElement.getFileUuid();
                    tVar.f294987u = fileElement.getFileName();
                    tVar.f294976j = fileElement.getFileSize();
                    if (fileElement.getFileBizId() != null) {
                        tVar.f294988v = fileElement.getFileBizId().intValue();
                    }
                    if (!TextUtils.isEmpty(tVar.f294985s)) {
                        arrayList.add(tVar);
                    }
                }
            }
            TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
            if (!arrayList.isEmpty() && O != null) {
                O.z0(arrayList);
            }
        }
    }

    public static void C(Context context, QQAppInterface qQAppInterface, AIOMsgItem aIOMsgItem) {
        int i3;
        if (qQAppInterface != null && aIOMsgItem != null && com.tencent.mobileqq.aio.utils.d.x(aIOMsgItem) && aIOMsgItem.getMsgRecord().getChatType() == 2) {
            MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
            MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(3);
            if (firstTypeElement == null) {
                return;
            }
            FileElement fileElement = firstTypeElement.getFileElement();
            TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, msgRecord.getPeerUin());
            if (O == null || fileElement.getFileUuid() == null) {
                return;
            }
            com.tencent.mobileqq.filemanager.util.d.d(context.getString(R.string.f170978be3));
            if (fileElement.getFileBizId() != null) {
                i3 = fileElement.getFileBizId().intValue();
            } else {
                i3 = 0;
            }
            O.w0(fileElement.getFileUuid(), fileElement.getFileName(), fileElement.getFileSize(), i3, null);
        }
    }

    public static void D(Context context, QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        TroopFileTransferManager O;
        com.tencent.mobileqq.troop.data.t m3;
        if (chatMessage != null && (chatMessage instanceof MessageForTroopFile) && (O = TroopFileTransferManager.O(qQAppInterface, Long.parseLong(chatMessage.frienduin))) != null && (m3 = m(qQAppInterface, (MessageForTroopFile) chatMessage)) != null && m3.f294985s != null) {
            com.tencent.mobileqq.filemanager.util.d.d(context.getString(R.string.f170978be3));
            O.w0(m3.f294985s, m3.f294987u, m3.f294976j, m3.f294988v, null);
        }
    }

    public static void E(Context context, QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        if (chatMessage == null || !(chatMessage instanceof MessageForTroopFile) || TroopFileTransferManager.O(qQAppInterface, Long.parseLong(chatMessage.frienduin)) == null) {
            return;
        }
        MessageForTroopFile messageForTroopFile = (MessageForTroopFile) chatMessage;
        QFileUtils.m0(qQAppInterface, context, Long.parseLong(messageForTroopFile.frienduin), messageForTroopFile.uuid, messageForTroopFile.url, messageForTroopFile.fileName, messageForTroopFile.fileSize, messageForTroopFile.bisID);
    }

    public static void F(QQAppInterface qQAppInterface, long j3) {
        TroopFileError.h(qQAppInterface, j3, 106);
    }

    public static boolean a(QQAppInterface qQAppInterface, long j3) {
        TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(j3 + "");
        if (k3 != null && k3.isOwnerOrAdmin()) {
            return true;
        }
        return false;
    }

    public static void b(QQAppInterface qQAppInterface, String str, boolean z16, long j3, String str2, String str3, String str4, String str5, int i3, long j16, long j17, String str6, String str7, int i16) {
        long j18 = 0;
        long currentTimeMillis = j3 == 0 ? System.currentTimeMillis() : j3;
        long currentTimeMillis2 = currentTimeMillis < 1 ? 0L : System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 <= 0) {
            currentTimeMillis2 = 0;
        } else {
            j18 = j16 / currentTimeMillis2;
        }
        int netWorkType = HttpUtil.getNetWorkType();
        String[] strArr = AppConstants.NET_TYPE_NAME;
        String str8 = (netWorkType >= strArr.length || netWorkType < 0) ? "NONE" : strArr[netWorkType];
        HashMap hashMap = new HashMap();
        hashMap.put("netType", str8);
        hashMap.put("serverip", String.valueOf(str2));
        hashMap.put("troopUin", String.valueOf(str3));
        hashMap.put("filePath", str5);
        hashMap.put("errorCode", String.valueOf(i3));
        hashMap.put("transferedSize", String.valueOf(j16));
        hashMap.put("fileSize", String.valueOf(j17));
        hashMap.put("url", String.valueOf(str6));
        hashMap.put("rspHeader", String.valueOf(str7));
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, String.valueOf(i16));
        ReportController.o(qQAppInterface, "P_CliOper", "BizTechReport", "", "troop_troopfile", str, 0, z16 ? 0 : 1, str3, str4, j18 + "KB/s", hashMap.toString());
        if (QLog.isColorLevel()) {
            QLog.d("BizTechReport", 2, "ReportTransferFailedInfo actType[" + str + "], isSuccess[" + String.valueOf(z16) + "], errorCode[" + String.valueOf(i3) + "], startTime[" + String.valueOf(currentTimeMillis) + "], duration[" + String.valueOf(currentTimeMillis2) + "],  transferSize[" + String.valueOf(j16) + "], fileSize[" + String.valueOf(j17) + "], fileType[" + str4 + "], netType[" + str8 + "], fileTransferSpeed[" + String.valueOf(j18) + " KB/s], serverip[" + str2 + "], url[" + String.valueOf(str6) + "], rspHeader[" + String.valueOf(str7) + "], retryTimes[" + String.valueOf(i16) + "]");
        }
    }

    public static int c(Context context) {
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        if (systemNetwork == 0) {
            return 0;
        }
        if (2 != systemNetwork && 3 != systemNetwork && 4 != systemNetwork) {
            return 2;
        }
        return 1;
    }

    public static int d(QQAppInterface qQAppInterface, Context context, long j3) {
        int c16 = c(context);
        if (c16 == 0) {
            TroopFileError.h(qQAppInterface, j3, 106);
        }
        return c16;
    }

    public static String e(Context context, long j3) {
        long j16 = j3 * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (j16 <= currentTimeMillis) {
            return context.getString(R.string.ekr);
        }
        return (((j16 - currentTimeMillis) / 86400000) + 1) + context.getString(R.string.f171380ek4);
    }

    public static TroopFileData f(obj_msg$ObjMsg obj_msg_objmsg) {
        if (obj_msg_objmsg == null || obj_msg_objmsg.uint32_msg_type.get() != 6 || !obj_msg_objmsg.msg_content_info.has()) {
            return null;
        }
        TroopFileData troopFileData = new TroopFileData();
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_path.has()) {
            troopFileData.fileUrl = new String(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_path.get().toByteArray());
        } else {
            QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. bytes_file_path is null");
        }
        if (TextUtils.isEmpty(troopFileData.fileUrl)) {
            return null;
        }
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.uint32_bus_id.has()) {
            troopFileData.bisID = obj_msg_objmsg.msg_content_info.get(0).msg_file.uint32_bus_id.get();
        } else {
            QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. uint32_bus_id is null");
        }
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.str_file_name.has()) {
            troopFileData.fileName = obj_msg_objmsg.msg_content_info.get(0).msg_file.str_file_name.get();
        } else {
            QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. str_file_name is null");
        }
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.uint64_file_size.has()) {
            troopFileData.lfileSize = obj_msg_objmsg.msg_content_info.get(0).msg_file.uint64_file_size.get();
        } else {
            QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. uint64_file_size is null");
        }
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.int64_dead_time.has()) {
            troopFileData.lastTime = obj_msg_objmsg.msg_content_info.get(0).msg_file.int64_dead_time.get();
        } else if (QLog.isDevelopLevel()) {
            QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. int64_dead_time is null");
        }
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_sha1.has()) {
            troopFileData.sha1 = new String(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_sha1.get().toByteArray());
        } else {
            QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. bytes_file_sha1 is null");
        }
        troopFileData.uuid = UUID.nameUUIDFromBytes(troopFileData.fileUrl.getBytes()).toString();
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_ext.has()) {
            try {
                JSONObject jSONObject = new JSONObject(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_ext.get().toStringUtf8());
                troopFileData.width = jSONObject.optInt("width");
                troopFileData.height = jSONObject.optInt("height");
                troopFileData.duration = jSONObject.optInt("duration");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        String str = new String(obj_msg_objmsg.bytes_title.get().toByteArray());
        troopFileData.dspFileName = str;
        troopFileData.dspFileName = FileManagerUtil.getFileName(str);
        if (obj_msg_objmsg.rpt_bytes_abstact.has() && !obj_msg_objmsg.rpt_bytes_abstact.get().isEmpty()) {
            troopFileData.dspFileSize = new String(obj_msg_objmsg.rpt_bytes_abstact.get(0).toByteArray());
        }
        return troopFileData;
    }

    public static String g(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) < 0) {
                sb5.append(charArray[i3]);
            } else if (codePointAt > 65535 && length >= i3 + 2) {
                i3++;
            }
            i3++;
        }
        return sb5.toString();
    }

    public static boolean h(String str, String str2, int i3, int i16) {
        Bitmap i17 = i(str, i3, i16);
        if (i17 == null) {
            return false;
        }
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    i17.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
                    i17.recycle();
                    try {
                        bufferedOutputStream2.flush();
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e17.toString());
                        }
                    }
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e18.toString());
                            return true;
                        }
                        return true;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e.toString());
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                        } catch (IOException e26) {
                            if (QLog.isColorLevel()) {
                                QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e26.toString());
                            }
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e27) {
                            if (QLog.isColorLevel()) {
                                QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e27.toString());
                            }
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                        } catch (IOException e28) {
                            if (QLog.isColorLevel()) {
                                QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e28.toString());
                            }
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e29) {
                            if (QLog.isColorLevel()) {
                                QLog.e("TroopFileUtils", 2, "generateMiniThumb" + e29.toString());
                            }
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e36) {
                e = e36;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static Bitmap i(String str, int i3, int i16) {
        int i17;
        Bitmap bitmap;
        if (i16 < i3) {
            i17 = i16;
        } else {
            i17 = i3;
        }
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(str, BaseImageUtil.calculateInSampleSize2(str, i17));
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopFile", 2, "", e16);
            }
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            if (width <= i3 && height <= i16) {
                return bitmap;
            }
            float max = Math.max(i3 / width, i16 / height);
            Matrix matrix = new Matrix();
            matrix.setScale(max, max);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                createBitmap.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                }
                int width2 = createBitmap.getWidth();
                int height2 = createBitmap.getHeight();
                Rect rect = new Rect();
                if (width2 >= i3) {
                    rect.left = (width2 - i3) / 2;
                    width2 = i3;
                }
                if (height2 >= i16) {
                    rect.top = 0;
                    height2 = i16;
                }
                rect.bottom = rect.top + height2;
                rect.right = rect.left + width2;
                Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                if (createBitmap2 != null) {
                    createBitmap2.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
                    new Canvas(createBitmap2).drawBitmap(createBitmap, rect, new Rect(0, 0, i3, i16), (Paint) null);
                }
                createBitmap.recycle();
                return createBitmap2;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String j(long j3) {
        if (j3 < 1024) {
            return j3 + "B";
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        double d16 = j3;
        if (d16 < 1048576.0d) {
            return decimalFormat.format(d16 / 1024.0d) + "K";
        }
        if (d16 < 1.073741824E9d) {
            return decimalFormat.format(d16 / 1048576.0d) + "M";
        }
        return decimalFormat.format(d16 / 1.073741824E9d) + "G";
    }

    public static com.tencent.mobileqq.troop.data.t k(QQAppInterface qQAppInterface, long j3, String str, String str2, String str3, long j16, int i3) {
        com.tencent.mobileqq.troop.data.t tVar;
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
        if (O != null && !TextUtils.isEmpty(str)) {
            tVar = O.I(UUID.fromString(str));
        } else {
            tVar = null;
        }
        if (tVar == null && !TextUtils.isEmpty(str2)) {
            tVar = O.H(str2);
        }
        com.tencent.mobileqq.troop.data.t tVar2 = new com.tencent.mobileqq.troop.data.t(tVar);
        if (tVar2.f294971e == 0) {
            tVar2.f294971e = j3;
        }
        if (TextUtils.isEmpty(tVar2.f294987u)) {
            tVar2.f294987u = str3;
        }
        if (tVar2.f294976j == 0) {
            tVar2.f294976j = j16;
        }
        if (i3 != 0) {
            tVar2.f294988v = i3;
        }
        if (TextUtils.isEmpty(tVar2.f294985s)) {
            tVar2.f294985s = str2;
        }
        if (tVar2.f294975i == 0 && tVar != null) {
            tVar2.f294975i = tVar.f294975i;
        }
        return tVar2;
    }

    public static com.tencent.mobileqq.troop.data.t l(QQAppInterface qQAppInterface, long j3, String str, String str2, String str3, long j16, int i3, String str4) {
        com.tencent.mobileqq.troop.data.t tVar;
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
        if (O != null && !TextUtils.isEmpty(str)) {
            tVar = O.I(UUID.fromString(str));
        } else {
            tVar = null;
        }
        if (tVar == null && !TextUtils.isEmpty(str2)) {
            tVar = O.H(str2);
        }
        if (tVar == null) {
            return null;
        }
        com.tencent.mobileqq.troop.data.t tVar2 = new com.tencent.mobileqq.troop.data.t(tVar);
        if (tVar2.f294971e == 0) {
            tVar2.f294971e = j3;
        }
        if (TextUtils.isEmpty(tVar2.f294987u)) {
            tVar2.f294987u = str3;
        }
        if (tVar2.f294976j == 0) {
            tVar2.f294976j = j16;
        }
        if (i3 != 0) {
            tVar2.f294988v = i3;
        }
        if (TextUtils.isEmpty(tVar2.f294985s)) {
            if (!TextUtils.isEmpty(str2)) {
                tVar2.f294985s = str2;
            } else {
                tVar2.f294985s = str4;
            }
        }
        return tVar2;
    }

    public static com.tencent.mobileqq.troop.data.t m(QQAppInterface qQAppInterface, MessageForTroopFile messageForTroopFile) {
        com.tencent.mobileqq.troop.data.t tVar = null;
        if (messageForTroopFile == null) {
            return null;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.parseLong(messageForTroopFile.frienduin));
        if (O != null && !TextUtils.isEmpty(messageForTroopFile.uuid)) {
            tVar = O.I(UUID.fromString(messageForTroopFile.uuid));
        }
        if (O != null && tVar == null && !TextUtils.isEmpty(messageForTroopFile.url)) {
            tVar = O.H(messageForTroopFile.url);
        }
        com.tencent.mobileqq.troop.data.t tVar2 = new com.tencent.mobileqq.troop.data.t(tVar);
        if (TextUtils.isEmpty(tVar2.f294987u)) {
            tVar2.f294987u = messageForTroopFile.fileName;
        }
        if (tVar2.f294976j == 0) {
            tVar2.f294976j = messageForTroopFile.fileSize;
        }
        int i3 = messageForTroopFile.bisID;
        if (i3 != 0) {
            tVar2.f294988v = i3;
        }
        if (!TextUtils.isEmpty(messageForTroopFile.url)) {
            tVar2.f294985s = messageForTroopFile.url;
        }
        if (!TextUtils.isEmpty(messageForTroopFile.frienduin)) {
            tVar2.f294971e = Long.valueOf(messageForTroopFile.frienduin).longValue();
        }
        if (!TextUtils.isEmpty(messageForTroopFile.sha1)) {
            tVar2.f294986t = messageForTroopFile.sha1;
        }
        long j3 = messageForTroopFile.uniseq;
        if (j3 > 0) {
            tVar2.f294970d = j3;
        }
        tVar2.B = messageForTroopFile.yybApkPackageName;
        tVar2.C = messageForTroopFile.yybApkName;
        tVar2.D = messageForTroopFile.yybApkIconUrl;
        return tVar2;
    }

    public static com.tencent.mobileqq.troop.data.t n(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        return k(qQAppInterface, fileManagerEntity.TroopUin, fileManagerEntity.strTroopFileID, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId);
    }

    public static com.tencent.mobileqq.troop.data.t o(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, boolean z16) {
        return l(qQAppInterface, fileManagerEntity.TroopUin, fileManagerEntity.strTroopFileID, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId, fileManagerEntity.Uuid);
    }

    public static String p(String str) {
        String str2 = "";
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if ((lastIndexOf != -1 && lastIndexOf <= 9) || (lastIndexOf == -1 && str.length() <= 13)) {
            return str;
        }
        if (lastIndexOf != -1) {
            str2 = str.substring(lastIndexOf);
            str = str.substring(0, lastIndexOf);
        }
        return (str.substring(0, 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX + str.substring(str.length() - 3)) + str2;
    }

    public static String q(long j3, String str, int i3) {
        if (i3 == 128) {
            return AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH + TroopFileTransferManager.Item.ThumbnailFilePrefix + j3 + "-" + str;
        }
        if (i3 == 383) {
            return AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH + TroopFileTransferManager.Item.ThumbnailFilePrefix + 320 + j3 + "-" + str;
        }
        return AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH + TroopFileTransferManager.Item.ThumbnailFilePrefix + i3 + j3 + "-" + str;
    }

    public static long r(QQAppInterface qQAppInterface, String str, String str2, long j3, String str3, int i3, String str4, long j16, int i16, int i17, int i18, long j17, int i19, Bundle bundle) {
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(d16.uniseq, j17, i19);
        d16.selfuin = qQAppInterface.getCurrentAccountUin();
        d16.frienduin = str;
        d16.senderuin = qQAppInterface.getCurrentAccountUin();
        d16.msgUid = com.tencent.mobileqq.service.message.s.f(i3);
        d16.f203106msg = bt.i(null);
        d16.msgtype = MessageRecord.MSG_TYPE_TROOP_OBJ_MSG;
        d16.isread = true;
        d16.issend = 1;
        d16.istroop = 1;
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(d16.senderuin, 1);
        if (l16 != null && !l16.isEmpty()) {
            d16.shmsgseq = l16.get(l16.size() - 1).shmsgseq;
        } else {
            d16.shmsgseq = Math.abs(new Random().nextInt());
        }
        d16.time = com.tencent.mobileqq.service.message.e.K0();
        MessageForTroopFile messageForTroopFile = (MessageForTroopFile) d16;
        messageForTroopFile.fileName = str2;
        messageForTroopFile.uuid = str3;
        messageForTroopFile.fileSize = j3;
        messageForTroopFile.FromUin = str4;
        messageForTroopFile.entitySessionId = j16;
        messageForTroopFile.width = i16;
        messageForTroopFile.height = i17;
        messageForTroopFile.duration = i18;
        if (d16.isSend()) {
            ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(d16);
        }
        com.tencent.mobileqq.filemanager.util.k.b(d16, bundle);
        messageForTroopFile.serial();
        ThreadManagerV2.post(new Runnable(d16) { // from class: com.tencent.mobileqq.troop.utils.TroopFileUtils.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MessageRecord f301972e;

            {
                this.f301972e = d16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, (Object) d16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQAppInterface.this.getMessageFacade().c(this.f301972e, QQAppInterface.this.getCurrentAccountUin());
                }
            }
        }, 8, null, false);
        QLog.i("TroopFile", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(d16.uniseq) + "], selfuin[" + FileManagerUtil.enCodecString(d16.selfuin) + "], frienduin[" + FileManagerUtil.enCodecString(d16.frienduin) + "], senderuin[" + FileManagerUtil.enCodecString(d16.senderuin) + "], issend[" + String.valueOf(d16.issend) + "], istroop[" + String.valueOf(d16.istroop) + "], shmsgseq[" + String.valueOf(d16.shmsgseq) + "], msgUid[" + String.valueOf(d16.msgUid) + "], time[" + String.valueOf(d16.time) + "], vipBubbleID[" + String.valueOf(-1) + "]");
        return d16.uniseq;
    }

    public static long s(QQAppInterface qQAppInterface, String str, String str2, long j3, String str3, int i3, String str4, long j16, int i16, int i17, long j17, int i18) {
        return r(qQAppInterface, str, str2, j3, str3, i3, str4, j16, i16, i17, 0, j17, i18, null);
    }

    public static long t(QQAppInterface qQAppInterface, String str, String str2, long j3, String str3, int i3, String str4, long j16, long j17, int i16) {
        return s(qQAppInterface, str, str2, j3, str3, i3, str4, j16, 0, 0, j17, i16);
    }

    public static boolean u(QQAppInterface qQAppInterface) {
        return ((IFileDataStorageUtil) QRoute.api(IFileDataStorageUtil.class)).getBool(qQAppInterface, "https_troop_down", false);
    }

    public static boolean v(QQAppInterface qQAppInterface) {
        return ((IFileDataStorageUtil) QRoute.api(IFileDataStorageUtil.class)).getBool(qQAppInterface, "https_troopzip_down", false);
    }

    public static boolean w(QQAppInterface qQAppInterface) {
        return ((IFileDataStorageUtil) QRoute.api(IFileDataStorageUtil.class)).getBool(qQAppInterface, "https_troop_thumb", false);
    }

    public static boolean x(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean y(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : f301969b) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void z(Activity activity, QQAppInterface qQAppInterface, List<ChatMessage> list) {
        if (list != null && list.size() >= 1) {
            HashMap hashMap = new HashMap();
            for (ChatMessage chatMessage : list) {
                long parseLong = Long.parseLong(chatMessage.frienduin);
                List list2 = (List) hashMap.get(Long.valueOf(parseLong));
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(Long.valueOf(parseLong), list2);
                }
                com.tencent.mobileqq.troop.data.t m3 = m(qQAppInterface, (MessageForTroopFile) chatMessage);
                if (m3 != null && m3.f294985s != null) {
                    list2.add(m3);
                } else {
                    return;
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                long longValue = ((Long) entry.getKey()).longValue();
                List<com.tencent.mobileqq.troop.data.t> list3 = (List) entry.getValue();
                TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, longValue);
                if (O != null) {
                    com.tencent.mobileqq.filemanager.util.d.d(activity.getString(R.string.f170978be3));
                    O.z0(list3);
                }
            }
        }
    }
}
