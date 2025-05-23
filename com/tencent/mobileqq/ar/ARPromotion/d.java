package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f196885a = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f196886a;

        /* renamed from: b, reason: collision with root package name */
        public long f196887b;

        /* renamed from: c, reason: collision with root package name */
        public String f196888c;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("PlayGuideShowInfo{");
            stringBuffer.append("nStartTime=");
            stringBuffer.append(this.f196886a);
            stringBuffer.append(", nEndTime=");
            stringBuffer.append(this.f196887b);
            stringBuffer.append(", strShow=");
            stringBuffer.append(this.f196888c);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0073, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ARTransferDoorVideoInfo", 2, "TryPauseVideoInfo finally close has Exception", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0122, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fd, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d9, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d b(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        FileChannel fileChannel;
        ?? file = new File(str + "videoinfo.json");
        d dVar = null;
        if (file.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream((File) file);
                    try {
                        fileChannel = fileInputStream.getChannel();
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        fileChannel = null;
                    } catch (IOException e17) {
                        e = e17;
                        fileChannel = null;
                    } catch (Exception e18) {
                        e = e18;
                        fileChannel = null;
                    } catch (Throwable th6) {
                        th5 = th6;
                        file = 0;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e19) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("ARTransferDoorVideoInfo", 2, "TryPauseVideoInfo finally close has Exception", e19);
                                }
                                throw th5;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        throw th5;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                    fileChannel = null;
                    fileInputStream = null;
                } catch (IOException e27) {
                    e = e27;
                    fileChannel = null;
                    fileInputStream = null;
                } catch (Exception e28) {
                    e = e28;
                    fileChannel = null;
                    fileInputStream = null;
                } catch (Throwable th7) {
                    fileInputStream = null;
                    th5 = th7;
                    file = 0;
                }
                try {
                    String charBuffer = Charset.defaultCharset().decode(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size())).toString();
                    if (QLog.isColorLevel()) {
                        QLog.d("ARTransferDoorVideoInfo", 2, "ARTransferDoorVideoInfo parseJson fileContent: " + charBuffer);
                    }
                    dVar = c(charBuffer);
                    try {
                        fileInputStream.close();
                        fileChannel.close();
                    } catch (Exception e29) {
                        e = e29;
                    }
                } catch (FileNotFoundException e36) {
                    e = e36;
                    if (QLog.isColorLevel()) {
                        QLog.e("ARTransferDoorVideoInfo", 2, "TryPauseVideoInfo has FileNotFoundException", e);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e37) {
                            e = e37;
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return dVar;
                } catch (IOException e38) {
                    e = e38;
                    if (QLog.isColorLevel()) {
                        QLog.e("ARTransferDoorVideoInfo", 2, "TryPauseVideoInfo has TryPauseVideoInfo", e);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e39) {
                            e = e39;
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return dVar;
                } catch (Exception e46) {
                    e = e46;
                    if (QLog.isColorLevel()) {
                        QLog.e("ARTransferDoorVideoInfo", 2, "TryPauseVideoInfo has Exception", e);
                    }
                    if (QLog.isDebugVersion()) {
                        QLog.e("ARTransferDoorVideoInfo", 2, "\u5168\u666f\u89c6\u9891\u914d\u7f6e\u89e3\u6790\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u6587\u672c\u5185\u5bb9: " + e.toString());
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e47) {
                            e = e47;
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return dVar;
                }
            } catch (Throwable th8) {
                th5 = th8;
            }
        }
        return dVar;
    }

    public static d c(String str) {
        int length;
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            JSONArray jSONArray = jSONObject.getJSONArray("360senceinfo");
            if (jSONObject.has("360senceinfo") && (length = jSONArray.length()) > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    a aVar = new a();
                    if (jSONObject2.has("text")) {
                        aVar.f196888c = jSONObject2.optString("text");
                    }
                    if (jSONObject2.has(AEEditorConstants.VIDEO_CLIP_START_TIME)) {
                        aVar.f196886a = jSONObject2.optLong(AEEditorConstants.VIDEO_CLIP_START_TIME);
                    }
                    if (jSONObject2.has(AEEditorConstants.VIDEO_CLIP_END_TIME)) {
                        aVar.f196887b = jSONObject2.optLong(AEEditorConstants.VIDEO_CLIP_END_TIME);
                    }
                    dVar.f196885a.add(aVar);
                    if (QLog.isColorLevel()) {
                        QLog.d("ARTransferDoorVideoInfo", 2, "ARTransferDoorVideoInfo parseJson index: " + i3 + "," + aVar.toString());
                    }
                }
            }
            return dVar;
        } catch (Exception e16) {
            QLog.d("ARTransferDoorVideoInfo", 1, String.format("parseJson, Exception\n%s", e16));
            return null;
        }
    }

    public a a(long j3) {
        Iterator<a> it = this.f196885a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            long j16 = next.f196886a * 1000;
            if (j3 < next.f196887b * 1000 && j3 >= j16) {
                return next;
            }
        }
        return null;
    }
}
