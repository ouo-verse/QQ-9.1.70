package cooperation.troop_homework;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.h;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.d;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TroopHomeworkHelper {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class UploadFileTask {

        /* renamed from: a, reason: collision with root package name */
        OkHttpClient f390897a;

        /* renamed from: b, reason: collision with root package name */
        String f390898b;

        /* renamed from: c, reason: collision with root package name */
        String f390899c;

        /* renamed from: d, reason: collision with root package name */
        String f390900d;

        /* renamed from: e, reason: collision with root package name */
        f f390901e;

        /* renamed from: f, reason: collision with root package name */
        AppRuntime f390902f;

        /* renamed from: g, reason: collision with root package name */
        String f390903g;

        /* renamed from: h, reason: collision with root package name */
        JSONObject f390904h;

        /* renamed from: i, reason: collision with root package name */
        int f390905i;

        /* renamed from: k, reason: collision with root package name */
        boolean f390907k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f390908l = true;

        /* renamed from: j, reason: collision with root package name */
        long f390906j = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public class a implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f390909a;

            a(File file) {
                this.f390909a = file;
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.d
            public void f(JSONObject jSONObject) {
                UploadFileTask.this.i(jSONObject, this.f390909a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public class b implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f390911a;

            b(File file) {
                this.f390911a = file;
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.d
            public void f(JSONObject jSONObject) {
                UploadFileTask.this.h(jSONObject, this.f390911a);
            }
        }

        public UploadFileTask(AppRuntime appRuntime, String str, String str2) {
            this.f390900d = str;
            this.f390902f = appRuntime;
            this.f390903g = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:157:0x01cc, code lost:
        
            r3.close();
         */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0253 A[Catch: all -> 0x02ad, TryCatch #8 {all -> 0x02ad, blocks: (B:103:0x0239, B:105:0x0253, B:122:0x0278, B:132:0x0297), top: B:102:0x0239 }] */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0297 A[Catch: all -> 0x02ad, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x02ad, blocks: (B:103:0x0239, B:105:0x0253, B:122:0x0278, B:132:0x0297), top: B:102:0x0239 }] */
        /* JADX WARN: Removed duplicated region for block: B:144:0x02b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:152:? A[Catch: InvalidParameterException -> 0x02c0, IOException -> 0x02c3, FileNotFoundException -> 0x02c6, all -> 0x0411, SYNTHETIC, TRY_LEAVE, TryCatch #40 {all -> 0x0411, blocks: (B:31:0x00c1, B:58:0x032a, B:60:0x0345, B:61:0x0349, B:49:0x0379, B:51:0x0394, B:52:0x0398, B:36:0x03c7, B:38:0x03e2, B:39:0x03e6, B:66:0x00ca, B:67:0x00d9, B:80:0x01dd, B:88:0x01e4, B:126:0x0280, B:130:0x0288, B:109:0x028f, B:115:0x02a2, B:135:0x029b, B:145:0x02b5, B:151:0x02bf, B:150:0x02bc, B:157:0x01cc, B:161:0x01d8, B:167:0x01ee, B:171:0x01f8), top: B:5:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:221:0x0417 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:228:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x03e2 A[Catch: all -> 0x0411, TryCatch #40 {all -> 0x0411, blocks: (B:31:0x00c1, B:58:0x032a, B:60:0x0345, B:61:0x0349, B:49:0x0379, B:51:0x0394, B:52:0x0398, B:36:0x03c7, B:38:0x03e2, B:39:0x03e6, B:66:0x00ca, B:67:0x00d9, B:80:0x01dd, B:88:0x01e4, B:126:0x0280, B:130:0x0288, B:109:0x028f, B:115:0x02a2, B:135:0x029b, B:145:0x02b5, B:151:0x02bf, B:150:0x02bc, B:157:0x01cc, B:161:0x01d8, B:167:0x01ee, B:171:0x01f8), top: B:5:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x040d A[Catch: IOException -> 0x0305, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x0305, blocks: (B:63:0x0370, B:54:0x03bf, B:41:0x040d, B:124:0x0300), top: B:6:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0394 A[Catch: all -> 0x0411, TryCatch #40 {all -> 0x0411, blocks: (B:31:0x00c1, B:58:0x032a, B:60:0x0345, B:61:0x0349, B:49:0x0379, B:51:0x0394, B:52:0x0398, B:36:0x03c7, B:38:0x03e2, B:39:0x03e6, B:66:0x00ca, B:67:0x00d9, B:80:0x01dd, B:88:0x01e4, B:126:0x0280, B:130:0x0288, B:109:0x028f, B:115:0x02a2, B:135:0x029b, B:145:0x02b5, B:151:0x02bf, B:150:0x02bc, B:157:0x01cc, B:161:0x01d8, B:167:0x01ee, B:171:0x01f8), top: B:5:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x03bf A[Catch: IOException -> 0x0305, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x0305, blocks: (B:63:0x0370, B:54:0x03bf, B:41:0x040d, B:124:0x0300), top: B:6:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0345 A[Catch: all -> 0x0411, TryCatch #40 {all -> 0x0411, blocks: (B:31:0x00c1, B:58:0x032a, B:60:0x0345, B:61:0x0349, B:49:0x0379, B:51:0x0394, B:52:0x0398, B:36:0x03c7, B:38:0x03e2, B:39:0x03e6, B:66:0x00ca, B:67:0x00d9, B:80:0x01dd, B:88:0x01e4, B:126:0x0280, B:130:0x0288, B:109:0x028f, B:115:0x02a2, B:135:0x029b, B:145:0x02b5, B:151:0x02bf, B:150:0x02bc, B:157:0x01cc, B:161:0x01d8, B:167:0x01ee, B:171:0x01f8), top: B:5:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0370 A[Catch: IOException -> 0x0305, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x0305, blocks: (B:63:0x0370, B:54:0x03bf, B:41:0x040d, B:124:0x0300), top: B:6:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:232:0x0306 -> B:41:0x0410). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void c() {
            Throwable th5;
            RandomAccessFile randomAccessFile;
            String str;
            RandomAccessFile randomAccessFile2;
            f fVar;
            f fVar2;
            f fVar3;
            RandomAccessFile randomAccessFile3;
            long j3;
            int i3;
            String str2;
            Throwable th6;
            Response response;
            int i16;
            Exception exc;
            int i17;
            String str3 = "appendFile:";
            String str4 = "response.close error: ";
            String str5 = "TroopHomeworkHelper";
            if (this.f390897a == null) {
                OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                this.f390897a = newBuilder.connectTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).build();
            }
            int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
            this.f390899c = this.f390904h.optString("host");
            this.f390898b = this.f390904h.optString("file_url");
            JSONArray optJSONArray = this.f390904h.optJSONArray("authorizations");
            this.f390905i = 3;
            try {
                try {
                    try {
                        randomAccessFile3 = new RandomAccessFile(this.f390900d, "r");
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        str = "appendFile:";
                        randomAccessFile2 = null;
                    } catch (IOException e17) {
                        e = e17;
                        str = "appendFile:";
                        randomAccessFile2 = null;
                    } catch (InvalidParameterException e18) {
                        e = e18;
                        str = "appendFile:";
                        randomAccessFile2 = null;
                    } catch (Throwable th7) {
                        th5 = th7;
                        randomAccessFile = null;
                    }
                    try {
                        try {
                            long length = randomAccessFile3.length();
                            long j16 = this.f390906j;
                            while (true) {
                                long j17 = this.f390906j;
                                if (j17 < length) {
                                    if (this.f390907k) {
                                        try {
                                            randomAccessFile3.close();
                                            return;
                                        } catch (IOException e19) {
                                            e19.printStackTrace();
                                            return;
                                        }
                                    }
                                    if (length - j17 > 4096) {
                                        try {
                                            this.f390906j = j17 + 1048576;
                                        } catch (Throwable th8) {
                                            th5 = th8;
                                            randomAccessFile = randomAccessFile3;
                                            if (randomAccessFile == null) {
                                            }
                                        }
                                    } else {
                                        this.f390906j = length;
                                    }
                                    long j18 = this.f390906j - j16;
                                    int i18 = (int) j18;
                                    String str6 = str3;
                                    try {
                                        byte[] bArr = new byte[i18];
                                        randomAccessFile3.seek(j16);
                                        byte[] bArr2 = new byte[4096];
                                        String str7 = str4;
                                        String str8 = str5;
                                        int i19 = 0;
                                        while (true) {
                                            try {
                                                int read = randomAccessFile3.read(bArr2);
                                                if (read > 0) {
                                                    randomAccessFile2 = randomAccessFile3;
                                                    int i26 = i19 + read;
                                                    j3 = length;
                                                    if (i26 <= j18) {
                                                        try {
                                                            System.arraycopy(bArr2, 0, bArr, i19, read);
                                                            i19 = i26;
                                                            randomAccessFile3 = randomAccessFile2;
                                                            length = j3;
                                                        } catch (FileNotFoundException e26) {
                                                            e = e26;
                                                            str = str6;
                                                            str5 = str8;
                                                            QLog.e(str5, 1, str + e.getMessage(), e);
                                                            fVar3 = this.f390901e;
                                                            if (fVar3 != null) {
                                                            }
                                                            eu.j("grp_hw", "upload_video", "-10", "", networkType + "", "");
                                                            this.f390906j = 0L;
                                                            if (randomAccessFile2 != null) {
                                                            }
                                                        } catch (IOException e27) {
                                                            e = e27;
                                                            str = str6;
                                                            str5 = str8;
                                                            QLog.e(str5, 1, str + e.getMessage(), e);
                                                            fVar2 = this.f390901e;
                                                            if (fVar2 != null) {
                                                            }
                                                            eu.j("grp_hw", "upload_video", "-11", "", networkType + "", "");
                                                            this.f390906j = 0L;
                                                            if (randomAccessFile2 != null) {
                                                            }
                                                        } catch (InvalidParameterException e28) {
                                                            e = e28;
                                                            str = str6;
                                                            str5 = str8;
                                                            QLog.e(str5, 1, str + e.getMessage(), e);
                                                            fVar = this.f390901e;
                                                            if (fVar != null) {
                                                            }
                                                            eu.j("grp_hw", "upload_video", "-12", "", networkType + "", "");
                                                            this.f390906j = 0L;
                                                            if (randomAccessFile2 != null) {
                                                            }
                                                        }
                                                    } else {
                                                        System.arraycopy(bArr2, 0, bArr, i19, (int) (j18 - i19));
                                                        i3 = i18;
                                                        break;
                                                    }
                                                } else {
                                                    j3 = length;
                                                    randomAccessFile2 = randomAccessFile3;
                                                    i3 = i19;
                                                    break;
                                                }
                                            } catch (FileNotFoundException e29) {
                                                e = e29;
                                                randomAccessFile2 = randomAccessFile3;
                                            } catch (IOException e36) {
                                                e = e36;
                                                randomAccessFile2 = randomAccessFile3;
                                            } catch (InvalidParameterException e37) {
                                                e = e37;
                                                randomAccessFile2 = randomAccessFile3;
                                            }
                                        }
                                        try {
                                            response = this.f390897a.newCall(new Request.Builder().url(this.f390898b + "?append&position=" + j16).addHeader("Host", this.f390899c).addHeader("Connection", "Keep-Alive").addHeader("Content-Type", "application/octet-stream").addHeader("Authorization", g((int) j16, optJSONArray)).post(RequestBody.create(MediaType.parse("application/octet-stream"), bArr, 0, i3)).build()).execute();
                                            try {
                                                try {
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    str2 = str7;
                                                    str5 = str8;
                                                }
                                            } catch (IOException e38) {
                                                e = e38;
                                                str2 = str7;
                                                str5 = str8;
                                            }
                                        } catch (IOException e39) {
                                            e = e39;
                                            str2 = str7;
                                            str5 = str8;
                                            response = null;
                                        } catch (Throwable th10) {
                                            str2 = str7;
                                            str5 = str8;
                                            th6 = th10;
                                            response = null;
                                        }
                                        if (response.isSuccessful()) {
                                            try {
                                                try {
                                                    f fVar4 = this.f390901e;
                                                    if (fVar4 != null) {
                                                        fVar4.onProgress((int) (((i3 + j16) * 100) / j3));
                                                        if (this.f390906j >= j3) {
                                                            eu.j("grp_hw", "upload_video", "0", "2", networkType + "", "");
                                                            this.f390901e.onComplete(this.f390898b);
                                                        }
                                                    }
                                                } catch (IOException e46) {
                                                    e = e46;
                                                    str2 = str7;
                                                    str5 = str8;
                                                    try {
                                                        StringBuilder sb5 = new StringBuilder();
                                                        str = str6;
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                    }
                                                    try {
                                                        sb5.append(str);
                                                        sb5.append(e.getMessage());
                                                        QLog.e(str5, 2, sb5.toString(), e);
                                                        i16 = this.f390905i - 1;
                                                        this.f390905i = i16;
                                                        if (i16 <= 0) {
                                                        }
                                                        str4 = str2;
                                                        str3 = str;
                                                        randomAccessFile3 = randomAccessFile2;
                                                        length = j3;
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        th6 = th;
                                                        if (response != null) {
                                                            try {
                                                                response.close();
                                                                throw th6;
                                                            } catch (Exception e47) {
                                                                QLog.e(str5, 1, str2, e47);
                                                                throw th6;
                                                            }
                                                        }
                                                        throw th6;
                                                    }
                                                }
                                                try {
                                                    this.f390905i = 3;
                                                    j16 = this.f390906j;
                                                    str2 = str7;
                                                    str5 = str8;
                                                    try {
                                                        response.close();
                                                    } catch (Exception e48) {
                                                        try {
                                                            QLog.e(str5, 1, str2, e48);
                                                        } catch (FileNotFoundException e49) {
                                                            e = e49;
                                                            str = str6;
                                                            QLog.e(str5, 1, str + e.getMessage(), e);
                                                            fVar3 = this.f390901e;
                                                            if (fVar3 != null) {
                                                            }
                                                            eu.j("grp_hw", "upload_video", "-10", "", networkType + "", "");
                                                            this.f390906j = 0L;
                                                            if (randomAccessFile2 != null) {
                                                            }
                                                        } catch (IOException e56) {
                                                            e = e56;
                                                            str = str6;
                                                            QLog.e(str5, 1, str + e.getMessage(), e);
                                                            fVar2 = this.f390901e;
                                                            if (fVar2 != null) {
                                                            }
                                                            eu.j("grp_hw", "upload_video", "-11", "", networkType + "", "");
                                                            this.f390906j = 0L;
                                                            if (randomAccessFile2 != null) {
                                                            }
                                                        } catch (InvalidParameterException e57) {
                                                            e = e57;
                                                            str = str6;
                                                            QLog.e(str5, 1, str + e.getMessage(), e);
                                                            fVar = this.f390901e;
                                                            if (fVar != null) {
                                                            }
                                                            eu.j("grp_hw", "upload_video", "-12", "", networkType + "", "");
                                                            this.f390906j = 0L;
                                                            if (randomAccessFile2 != null) {
                                                            }
                                                        }
                                                    }
                                                    str = str6;
                                                } catch (IOException e58) {
                                                    e = e58;
                                                    str2 = str7;
                                                    str5 = str8;
                                                    StringBuilder sb52 = new StringBuilder();
                                                    str = str6;
                                                    sb52.append(str);
                                                    sb52.append(e.getMessage());
                                                    QLog.e(str5, 2, sb52.toString(), e);
                                                    i16 = this.f390905i - 1;
                                                    this.f390905i = i16;
                                                    if (i16 <= 0) {
                                                        eu.j("grp_hw", "upload_video", "-9", "", networkType + "", "");
                                                        f fVar5 = this.f390901e;
                                                        if (fVar5 != null) {
                                                            fVar5.onError(6);
                                                            this.f390906j = j16;
                                                            if (response != null) {
                                                                try {
                                                                    response.close();
                                                                } catch (Exception e59) {
                                                                    QLog.e(str5, 1, str2, e59);
                                                                }
                                                            }
                                                            randomAccessFile2.close();
                                                        }
                                                        if (response != null) {
                                                            try {
                                                                response.close();
                                                            } catch (Exception e65) {
                                                                exc = e65;
                                                                i17 = 1;
                                                                try {
                                                                    QLog.e(str5, i17, str2, exc);
                                                                    str4 = str2;
                                                                    str3 = str;
                                                                    randomAccessFile3 = randomAccessFile2;
                                                                    length = j3;
                                                                } catch (FileNotFoundException e66) {
                                                                    e = e66;
                                                                    QLog.e(str5, 1, str + e.getMessage(), e);
                                                                    fVar3 = this.f390901e;
                                                                    if (fVar3 != null) {
                                                                        fVar3.onError(6);
                                                                    }
                                                                    eu.j("grp_hw", "upload_video", "-10", "", networkType + "", "");
                                                                    this.f390906j = 0L;
                                                                    if (randomAccessFile2 != null) {
                                                                        randomAccessFile2.close();
                                                                    }
                                                                    return;
                                                                } catch (IOException e67) {
                                                                    e = e67;
                                                                    QLog.e(str5, 1, str + e.getMessage(), e);
                                                                    fVar2 = this.f390901e;
                                                                    if (fVar2 != null) {
                                                                        fVar2.onError(6);
                                                                    }
                                                                    eu.j("grp_hw", "upload_video", "-11", "", networkType + "", "");
                                                                    this.f390906j = 0L;
                                                                    if (randomAccessFile2 != null) {
                                                                        randomAccessFile2.close();
                                                                    }
                                                                    return;
                                                                } catch (InvalidParameterException e68) {
                                                                    e = e68;
                                                                    QLog.e(str5, 1, str + e.getMessage(), e);
                                                                    fVar = this.f390901e;
                                                                    if (fVar != null) {
                                                                        fVar.onError(6);
                                                                    }
                                                                    eu.j("grp_hw", "upload_video", "-12", "", networkType + "", "");
                                                                    this.f390906j = 0L;
                                                                    if (randomAccessFile2 != null) {
                                                                        randomAccessFile2.close();
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        this.f390906j = j16;
                                                        if (response != null) {
                                                            try {
                                                                response.close();
                                                            } catch (Exception e69) {
                                                                exc = e69;
                                                                i17 = 1;
                                                                QLog.e(str5, i17, str2, exc);
                                                                str4 = str2;
                                                                str3 = str;
                                                                randomAccessFile3 = randomAccessFile2;
                                                                length = j3;
                                                            }
                                                        }
                                                    }
                                                    str4 = str2;
                                                    str3 = str;
                                                    randomAccessFile3 = randomAccessFile2;
                                                    length = j3;
                                                }
                                                str4 = str2;
                                                str3 = str;
                                                randomAccessFile3 = randomAccessFile2;
                                                length = j3;
                                            } catch (Throwable th13) {
                                                th6 = th13;
                                                str2 = str7;
                                                str5 = str8;
                                                if (response != null) {
                                                }
                                            }
                                        } else {
                                            int i27 = this.f390905i - 1;
                                            this.f390905i = i27;
                                            if (i27 <= 0) {
                                                eu.j("grp_hw", "upload_video", "-8", "", networkType + "", "");
                                                f fVar6 = this.f390901e;
                                                if (fVar6 != null) {
                                                    fVar6.onError(response.code());
                                                    this.f390906j = j16;
                                                    try {
                                                        break;
                                                    } catch (Exception e75) {
                                                        str5 = str8;
                                                        QLog.e(str5, 1, str7, e75);
                                                    }
                                                }
                                                str2 = str7;
                                                str5 = str8;
                                                response.close();
                                                str = str6;
                                                str4 = str2;
                                                str3 = str;
                                                randomAccessFile3 = randomAccessFile2;
                                                length = j3;
                                            } else {
                                                str2 = str7;
                                                str5 = str8;
                                                try {
                                                    this.f390906j = j16;
                                                    try {
                                                        response.close();
                                                    } catch (Exception e76) {
                                                        QLog.e(str5, 1, str2, e76);
                                                    }
                                                    str = str6;
                                                } catch (IOException e77) {
                                                    e = e77;
                                                    StringBuilder sb522 = new StringBuilder();
                                                    str = str6;
                                                    sb522.append(str);
                                                    sb522.append(e.getMessage());
                                                    QLog.e(str5, 2, sb522.toString(), e);
                                                    i16 = this.f390905i - 1;
                                                    this.f390905i = i16;
                                                    if (i16 <= 0) {
                                                    }
                                                    str4 = str2;
                                                    str3 = str;
                                                    randomAccessFile3 = randomAccessFile2;
                                                    length = j3;
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    th6 = th;
                                                    if (response != null) {
                                                    }
                                                }
                                                str4 = str2;
                                                str3 = str;
                                                randomAccessFile3 = randomAccessFile2;
                                                length = j3;
                                            }
                                        }
                                    } catch (FileNotFoundException e78) {
                                        e = e78;
                                        randomAccessFile2 = randomAccessFile3;
                                    } catch (IOException e79) {
                                        e = e79;
                                        randomAccessFile2 = randomAccessFile3;
                                    } catch (InvalidParameterException e85) {
                                        e = e85;
                                        randomAccessFile2 = randomAccessFile3;
                                    }
                                } else {
                                    randomAccessFile2 = randomAccessFile3;
                                    break;
                                }
                            }
                            randomAccessFile2.close();
                        } catch (FileNotFoundException e86) {
                            e = e86;
                            str = str3;
                            randomAccessFile2 = randomAccessFile3;
                        } catch (IOException e87) {
                            e = e87;
                            str = str3;
                            randomAccessFile2 = randomAccessFile3;
                        } catch (InvalidParameterException e88) {
                            e = e88;
                            str = str3;
                            randomAccessFile2 = randomAccessFile3;
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        RandomAccessFile randomAccessFile4 = randomAccessFile3;
                        th5 = th;
                        randomAccessFile = randomAccessFile4;
                        if (randomAccessFile == null) {
                            try {
                                randomAccessFile.close();
                                throw th5;
                            } catch (IOException e89) {
                                e89.printStackTrace();
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e95) {
                    e95.printStackTrace();
                }
            } catch (Throwable th16) {
                th = th16;
            }
        }

        private void e() {
            this.f390907k = false;
            File file = new File(this.f390900d);
            String o16 = TroopHomeworkHelper.o(this.f390900d);
            if (TextUtils.isEmpty(o16)) {
                QLog.e("TroopHomeworkHelper", 1, "got positions failed:" + o16);
            }
            TroopHomeworkHelper.j(this.f390902f, file.getName(), this.f390903g, o16, new b(file));
        }

        private void f() {
            String lowerCase = ah.Q0(ah.C0(new String(this.f390900d))).toLowerCase();
            File file = new File(this.f390900d);
            TroopHomeworkHelper.l(this.f390902f, file.getName(), this.f390903g, lowerCase, new a(file));
        }

        private String g(int i3, JSONArray jSONArray) throws InvalidParameterException {
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i16);
                if (optJSONObject.optInt("position") == i3) {
                    return optJSONObject.optString(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION);
                }
            }
            throw new InvalidParameterException("not found auth data");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(JSONObject jSONObject, File file) {
            int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
            if (jSONObject != null && jSONObject.optInt("retcode") == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    QLog.w("TroopHomeworkHelper", 1, "getAppendUploadAuthSync failed, dataObject == null");
                    eu.j("grp_hw", "upload_video", "-1", "", networkType + "", "");
                    f fVar = this.f390901e;
                    if (fVar != null) {
                        fVar.onError(2);
                        return;
                    }
                    return;
                }
                String optString = optJSONObject.optString("file_url");
                this.f390898b = optString;
                if (TextUtils.isEmpty(optString)) {
                    QLog.w("TroopHomeworkHelper", 1, "getAppendUploadAuthSync failed, TextUtils.isEmpty(appendUrl)");
                    eu.j("grp_hw", "upload_video", "-2", "", networkType + "", "");
                    f fVar2 = this.f390901e;
                    if (fVar2 != null) {
                        fVar2.onError(2);
                        return;
                    }
                    return;
                }
                String optString2 = optJSONObject.optString("max_size", "0");
                if (!TextUtils.isEmpty(optString2)) {
                    try {
                        long parseLong = Long.parseLong(optString2);
                        if (parseLong != 0 && file.length() > parseLong) {
                            QLog.w("TroopHomeworkHelper", 1, "getAppendUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + parseLong + ", filesize:" + file.length());
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(networkType);
                            sb5.append("");
                            eu.j("grp_hw", "upload_video", "-3", "", sb5.toString(), "");
                            f fVar3 = this.f390901e;
                            if (fVar3 != null) {
                                fVar3.onError(3);
                                return;
                            }
                            return;
                        }
                    } catch (NumberFormatException e16) {
                        QLog.w("TroopHomeworkHelper", 1, "handleAppendFileResult, get MaxSize exception:" + e16.getMessage());
                    }
                }
                this.f390904h = optJSONObject;
                c();
                return;
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("retcode") != 1006) {
                    QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, ret:" + jSONObject);
                    eu.j("grp_hw", "upload_video", "-6", "", networkType + "", "");
                    f fVar4 = this.f390901e;
                    if (fVar4 != null) {
                        fVar4.onError(2);
                        return;
                    }
                    return;
                }
                QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, \u8fbe\u5230\u5f53\u65e5\u4e0a\u4f20\u6b21\u6570\u9650\u5236, ret:" + jSONObject);
                eu.j("grp_hw", "upload_video", "-5", "", networkType + "", "");
                if (this.f390908l) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.5
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.uhx), 0).show();
                        }
                    });
                }
                f fVar5 = this.f390901e;
                if (fVar5 != null) {
                    fVar5.onError(4);
                    return;
                }
                return;
            }
            QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, result == null");
            eu.j("grp_hw", "upload_video", "-7", "", networkType + "", "");
            f fVar6 = this.f390901e;
            if (fVar6 != null) {
                fVar6.onError(2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(JSONObject jSONObject, File file) {
            String lowerCase = ah.Q0(ah.C0(new String(this.f390900d))).toLowerCase();
            int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
            if (jSONObject != null && jSONObject.optInt("retcode") == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, dataObject == null");
                    eu.j("grp_hw", "upload_video", "-1", "", networkType + "", "");
                    f fVar = this.f390901e;
                    if (fVar != null) {
                        fVar.onError(2);
                        return;
                    }
                    return;
                }
                String optString = optJSONObject.optString("file_url");
                if (TextUtils.isEmpty(optString)) {
                    QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, TextUtils.isEmpty(putUrl)");
                    eu.j("grp_hw", "upload_video", "-2", "", networkType + "", "");
                    f fVar2 = this.f390901e;
                    if (fVar2 != null) {
                        fVar2.onError(2);
                        return;
                    }
                    return;
                }
                String optString2 = optJSONObject.optString("max_size", "0");
                if (!TextUtils.isEmpty(optString2)) {
                    try {
                        long parseLong = Long.parseLong(optString2);
                        if (parseLong != 0 && file.length() > parseLong) {
                            QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + parseLong + ", filesize:" + file.length());
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(networkType);
                            sb5.append("");
                            eu.j("grp_hw", "upload_video", "-3", "", sb5.toString(), "");
                            f fVar3 = this.f390901e;
                            if (fVar3 != null) {
                                fVar3.onError(3);
                                return;
                            }
                            return;
                        }
                    } catch (NumberFormatException e16) {
                        QLog.w("TroopHomeworkHelper", 1, "UploadVideoJob, get MaxSize exception:" + e16.getMessage());
                    }
                }
                int g16 = TroopHomeworkHelper.g(jSONObject, this.f390900d, lowerCase);
                if (g16 == 0) {
                    QLog.i("TroopHomeworkHelper", 1, "doPutCOSData success");
                    eu.j("grp_hw", "upload_video", "0", "1", networkType + "", "");
                    f fVar4 = this.f390901e;
                    if (fVar4 != null) {
                        fVar4.onComplete(optString);
                        return;
                    }
                    return;
                }
                QLog.w("TroopHomeworkHelper", 1, "doPutCOSData failed, putResult =" + g16);
                eu.j("grp_hw", "upload_video", "-4", "", networkType + "", "");
                f fVar5 = this.f390901e;
                if (fVar5 != null) {
                    fVar5.onError(5);
                    return;
                }
                return;
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("retcode") != 1006) {
                    QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, ret:" + jSONObject);
                    eu.j("grp_hw", "upload_video", "-6", "", networkType + "", "");
                    f fVar6 = this.f390901e;
                    if (fVar6 != null) {
                        fVar6.onError(2);
                        return;
                    }
                    return;
                }
                QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, \u8fbe\u5230\u5f53\u65e5\u4e0a\u4f20\u6b21\u6570\u9650\u5236, ret:" + jSONObject);
                eu.j("grp_hw", "upload_video", "-5", "", networkType + "", "");
                if (this.f390908l) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.3
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.uhw), 0).show();
                        }
                    });
                }
                f fVar7 = this.f390901e;
                if (fVar7 != null) {
                    fVar7.onError(4);
                    return;
                }
                return;
            }
            QLog.w("TroopHomeworkHelper", 1, "getCosUploadAuthSync failed, result == null");
            eu.j("grp_hw", "upload_video", "-7", "", networkType + "", "");
            f fVar8 = this.f390901e;
            if (fVar8 != null) {
                fVar8.onError(2);
            }
        }

        public void d() {
            this.f390907k = true;
        }

        public void j() {
            f fVar;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ThreadManagerV2.post(new Runnable() { // from class: cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.6
                    @Override // java.lang.Runnable
                    public void run() {
                        UploadFileTask.this.j();
                    }
                }, 8, null, true);
                return;
            }
            File file = new File(this.f390900d);
            if ((!file.exists() || file.length() == 0) && (fVar = this.f390901e) != null) {
                fVar.onError(-1);
                eu.j("grp_hw", "upload_video", "-13", "", NetworkUtil.getNetworkType(BaseApplication.getContext()) + "", "");
                return;
            }
            if (file.length() > 4096) {
                if (this.f390904h != null) {
                    if (this.f390906j >= file.length()) {
                        f fVar2 = this.f390901e;
                        if (fVar2 != null) {
                            fVar2.onComplete(this.f390898b);
                            return;
                        }
                        return;
                    }
                    c();
                    return;
                }
                e();
                return;
            }
            f();
        }

        public void k(f fVar) {
            this.f390901e = fVar;
        }

        public void l() {
            f fVar;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ThreadManagerV2.post(new Runnable() { // from class: cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UploadFileTask.this.l();
                    }
                }, 8, null, true);
                return;
            }
            File file = new File(this.f390900d);
            if ((!file.exists() || file.length() == 0) && (fVar = this.f390901e) != null) {
                fVar.onError(-1);
                eu.j("grp_hw", "upload_video", "-13", "", NetworkUtil.getNetworkType(BaseApplication.getContext()) + "", "");
                return;
            }
            if (file.length() > 4096) {
                e();
            } else {
                f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements com.tencent.mobileqq.troop.homework.common.upload.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.homework.common.upload.b f390913a;

        a(com.tencent.mobileqq.troop.homework.common.upload.b bVar) {
            this.f390913a = bVar;
        }

        @Override // com.tencent.mobileqq.troop.homework.common.upload.b
        public void onFail() {
            com.tencent.mobileqq.troop.homework.common.upload.b bVar = this.f390913a;
            if (bVar != null) {
                bVar.onFail();
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.common.upload.b
        public void onProgress(int i3) {
            com.tencent.mobileqq.troop.homework.common.upload.b bVar = this.f390913a;
            if (bVar != null) {
                bVar.onProgress(i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.common.upload.b
        public void onSuccess() {
            com.tencent.mobileqq.troop.homework.common.upload.b bVar = this.f390913a;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f390914a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f390915b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f390916c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f390917d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f390918e;

        b(String str, String str2, String str3, AppRuntime appRuntime, d dVar) {
            this.f390914a = str;
            this.f390915b = str2;
            this.f390916c = str3;
            this.f390917d = appRuntime;
            this.f390918e = dVar;
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onFailed(@Nullable String str) {
            com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.e(BaseApplication.getContext());
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onSuccess(@Nullable List<d.b> list) {
            String str;
            if (list != null && !list.isEmpty()) {
                str = list.get(0).a();
            } else {
                str = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("filename", this.f390914a);
            bundle.putString("gc", this.f390915b);
            bundle.putString("file_sha1", this.f390916c);
            bundle.putString("bkn", String.valueOf(((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getBknBySkey(TroopHomeworkHelper.q(str, 10))));
            Bundle bundle2 = new Bundle();
            bundle2.putString("Cookie", "uin=" + this.f390917d.getAccount() + ";p_uin=" + this.f390917d.getAccount() + ";p_skey=" + str);
            this.f390918e.f(cooperation.troop_homework.a.a().b() ? TroopHomeworkHelper.n(this.f390917d, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", bundle, bundle2) : TroopHomeworkHelper.m(this.f390917d, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", bundle, bundle2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f390919a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f390920b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f390921c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f390922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f390923e;

        c(String str, String str2, String str3, AppRuntime appRuntime, d dVar) {
            this.f390919a = str;
            this.f390920b = str2;
            this.f390921c = str3;
            this.f390922d = appRuntime;
            this.f390923e = dVar;
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onFailed(@Nullable String str) {
            com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.e(BaseApplication.getContext());
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onSuccess(@Nullable List<d.b> list) {
            String str;
            if (list != null && !list.isEmpty()) {
                str = list.get(0).a();
            } else {
                str = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("filename", this.f390919a);
            bundle.putString("gc", this.f390920b);
            bundle.putString("positions", this.f390921c);
            bundle.putString("bkn", String.valueOf(((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getBknBySkey(TroopHomeworkHelper.q(str, 10))));
            Bundle bundle2 = new Bundle();
            bundle2.putString("Cookie", "uin=" + this.f390922d.getAccount() + ";p_uin=" + this.f390922d.getAccount() + ";p_skey=" + str);
            this.f390923e.f(cooperation.troop_homework.a.a().b() ? TroopHomeworkHelper.n(this.f390922d, "https://qun.qq.com/cgi-bin/grouphw/upload_append", bundle, bundle2) : TroopHomeworkHelper.m(this.f390922d, "https://qun.qq.com/cgi-bin/grouphw/upload_append", bundle, bundle2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface d {
        void f(JSONObject jSONObject);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface f {
        void onComplete(String str);

        void onError(int i3);

        void onProgress(int i3);
    }

    public static int d(Context context, String str, String str2) {
        return e(context, str, str2, null);
    }

    public static int e(Context context, String str, String str2, com.tencent.mobileqq.troop.homework.common.upload.b bVar) {
        boolean h16 = com.tencent.mobileqq.troop.config.b.f294691a.h("102860", true);
        QLog.i("TroopHomeworkHelper", 1, "[compressVideo] isSwitchOn = " + h16);
        if (h16 && new File(str).length() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            QLog.i("TroopHomeworkHelper", 1, "[compressVideo] no need compress!");
            return 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = -1;
        if (ShortVideoTrimmer.initVideoTrim(context)) {
            VideoConverterConfig compressConfig = ShortVideoTrimmer.getCompressConfig(str);
            if (compressConfig != null && compressConfig.isNeedCompress) {
                e eVar = new e(str2, (int) (compressConfig.srcBitrate * 1024), (int) compressConfig.srcFrameRate, new a(bVar));
                VideoConverter videoConverter = new VideoConverter(new h());
                videoConverter.setCompressMode(1);
                int startCompress = videoConverter.startCompress(context, str, eVar, true);
                if (startCompress == 0) {
                    i3 = 0;
                }
                QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: compress completed using MediaCodec ret = " + i3 + ", compressRet:" + startCompress);
                if (i3 != 0) {
                    i3 = ShortVideoTrimmer.compressVideo(context, str, str2, compressConfig);
                    QLog.d("TroopHomeworkHelper", 1, "CompressTask, step:compress completed using ShortVideoTrimmer.compressVideo, ret = " + i3);
                }
                if (i3 != 0 && h16) {
                    i3 = f(str, str2);
                }
            } else {
                i3 = 1;
            }
            QLog.d("TroopHomeworkHelper", 1, "CompressTask\uff0cstep: ShortVideoTrimmer compress ret = " + i3 + ", cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, fileSourceSize=" + new File(str).length() + ", fileTargetSize=" + new File(str2).length());
        } else {
            QLog.e("TroopHomeworkHelper", 1, "CompressTask\uff0cstep: ShortVideoTrimmer init failure, ignore compress");
        }
        return i3;
    }

    public static int f(String str, String str2) {
        int i3;
        Object obj = new Object();
        int i16 = -1;
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        try {
            FFmpegUtils.compressVideoWithBitrate(str, str2, 3000, new VideoCompositeHelper.c(obj, atomicInteger, 1));
            synchronized (obj) {
                obj.wait(MiniBoxNoticeInfo.MIN_5);
                i3 = atomicInteger.get();
                QLog.i("TroopHomeworkHelper", 1, "[compressVideoByFfmpeg] encodeRequest result = " + i3);
            }
            i16 = i3;
        } catch (Exception e16) {
            QLog.i("TroopHomeworkHelper", 1, "[compressVideoByFfmpeg] exception = " + e16, e16);
        }
        QLog.i("TroopHomeworkHelper", 1, "[compressVideoByFfmpeg] resultCode = " + i16);
        return i16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.io.OutputStream, java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(JSONObject jSONObject, String str, String str2) {
        ?? r16;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString = optJSONObject.optString("file_url");
        String optString2 = optJSONObject.optString("host");
        ?? optString3 = optJSONObject.optString(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                r16 = (HttpURLConnection) new URL(optString).openConnection();
                try {
                    r16.setConnectTimeout(30000);
                    r16.setReadTimeout(30000);
                    r16.setDoOutput(true);
                    r16.setDoInput(true);
                    r16.setUseCaches(false);
                    r16.setRequestMethod(HttpPut.METHOD_NAME);
                    r16.setRequestProperty("Connection", "Keep-Alive");
                    r16.setRequestProperty("Host", optString2);
                    r16.setRequestProperty("Authorization", optString3);
                    r16.setRequestProperty("Content-Type", "application/octet-stream");
                    r16.setRequestProperty("x-cos-content-sha1", str2);
                    optString3 = new DataOutputStream(r16.getOutputStream());
                } catch (Exception e16) {
                    e = e16;
                    optString3 = 0;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    optString3 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    optString3 = 0;
                }
            } catch (Exception e18) {
                e = e18;
                optString3 = 0;
            } catch (OutOfMemoryError e19) {
                e = e19;
                optString3 = 0;
            } catch (Throwable th6) {
                th = th6;
                optString3 = 0;
            }
            try {
                File file = new File(str);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
                byte[] bArr = new byte[3072];
                while (true) {
                    try {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            optString3.write(bArr, 0, read);
                        } catch (OutOfMemoryError e26) {
                            QLog.e("TroopHomeworkHelper", 1, "uploadImage OOM: fileSize = " + file.length() + ", name = " + file.getAbsolutePath(), e26);
                            optString3.flush();
                            optString3.close();
                            r16.disconnect();
                            try {
                                bufferedInputStream.close();
                                try {
                                    optString3.close();
                                } catch (IOException unused) {
                                }
                                return -1;
                            } catch (Exception e27) {
                                e = e27;
                                QLog.e("TroopHomeworkHelper", 1, "doPutCOSData exception: ", e);
                                if (httpURLConnection != null) {
                                }
                                if (optString3 == 0) {
                                }
                                try {
                                    optString3.close();
                                } catch (IOException unused2) {
                                    return -1;
                                }
                            } catch (OutOfMemoryError e28) {
                                e = e28;
                                QLog.e("TroopHomeworkHelper", 1, "doPutCOSDataexception: OutOfMemoryError", e);
                                if (httpURLConnection != null) {
                                }
                                if (optString3 == 0) {
                                }
                                optString3.close();
                            }
                        }
                    } catch (Throwable th7) {
                        bufferedInputStream.close();
                        throw th7;
                    }
                }
                bufferedInputStream.close();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(r16.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                }
                bufferedReader.close();
                r16.disconnect();
                try {
                    optString3.close();
                } catch (IOException unused3) {
                }
                return 0;
            } catch (Exception e29) {
                e = e29;
                httpURLConnection = r16;
                QLog.e("TroopHomeworkHelper", 1, "doPutCOSData exception: ", e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (optString3 == 0) {
                    return -1;
                }
                optString3.close();
            } catch (OutOfMemoryError e36) {
                e = e36;
                httpURLConnection = r16;
                QLog.e("TroopHomeworkHelper", 1, "doPutCOSDataexception: OutOfMemoryError", e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (optString3 == 0) {
                    return -1;
                }
                optString3.close();
            } catch (Throwable th8) {
                th = th8;
                httpURLConnection = r16;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (optString3 != 0) {
                    try {
                        optString3.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static String h(String str) {
        return i(str, p(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(String str, String str2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        HttpURLConnection httpURLConnection;
        ?? r65;
        File file = new File(str2);
        HttpURLConnection httpURLConnection2 = null;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e16) {
                QLog.e("TroopHomeworkHelper", 1, "downloadAudio exception" + e16, e16);
                return null;
            }
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e17) {
            e = e17;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            fileOutputStream = null;
            if (httpURLConnection2 != null) {
            }
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
        }
        try {
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            inputStream = httpURLConnection.getInputStream();
        } catch (Exception e18) {
            e = e18;
            inputStream = null;
            r65 = inputStream;
            QLog.e("TroopHomeworkHelper", 1, "\u4e0b\u8f7d\u5f55\u97f3\u6587\u4ef6\u51fa\u9519" + str, e);
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (r65 != 0) {
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            r65 = 0;
        }
        try {
            r65 = new FileOutputStream(file, true);
        } catch (Exception e19) {
            e = e19;
            r65 = 0;
        } catch (Throwable th7) {
            th = th7;
            r65 = 0;
            httpURLConnection2 = httpURLConnection;
            fileOutputStream = r65;
            if (httpURLConnection2 != null) {
            }
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    r65.write(bArr, 0, read);
                }
                httpURLConnection.disconnect();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                try {
                    r65.close();
                } catch (IOException unused2) {
                }
                return str2;
            } catch (Throwable th8) {
                th = th8;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = r65;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception e26) {
            e = e26;
            QLog.e("TroopHomeworkHelper", 1, "\u4e0b\u8f7d\u5f55\u97f3\u6587\u4ef6\u51fa\u9519" + str, e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (r65 != 0) {
                try {
                    r65.close();
                } catch (IOException unused6) {
                }
            }
            return null;
        }
    }

    public static void j(AppRuntime appRuntime, String str, String str2, String str3, d dVar) {
        com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.c(appRuntime, new String[]{FlockBaseRequest.QUN_DOMAIN}, new c(str, str2, str3, appRuntime, dVar));
    }

    public static String k(String str) {
        String str2 = AppConstants.SDCARD_HOMEWORK_AUDIO;
        long nanoTime = System.nanoTime();
        StringBuilder sb5 = new StringBuilder(str2);
        sb5.append("stream");
        sb5.append(nanoTime);
        if (str.toLowerCase().endsWith(".slk")) {
            sb5.append(".slk");
        } else {
            sb5.append(".amr");
        }
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    public static void l(AppRuntime appRuntime, String str, String str2, String str3, d dVar) {
        com.tencent.mobileqq.troop.homework.entry.ui.utils.d.f297051a.c(appRuntime, new String[]{FlockBaseRequest.QUN_DOMAIN}, new b(str, str2, str3, appRuntime, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject m(AppRuntime appRuntime, String str, Bundle bundle, Bundle bundle2) {
        boolean z16 = false;
        try {
            try {
                try {
                    String openUrl = HttpUtil.openUrl(appRuntime.getApplication().getApplicationContext(), str, "GET", bundle, bundle2);
                    if (openUrl == null) {
                        openUrl = "";
                    }
                    return new JSONObject(openUrl);
                } catch (IOException e16) {
                    try {
                        QLog.w("TroopHomeworkHelper", 1, e16.getMessage(), e16);
                        QLog.e("TroopHomeworkHelper", 1, "getCosUploadByHttpClient io error, use getCosUploadByHttpURLConnection again");
                        return n(appRuntime, str, bundle, bundle2);
                    } catch (Throwable th5) {
                        th = th5;
                        z16 = true;
                        if (z16) {
                        }
                        throw th;
                    }
                } catch (OutOfMemoryError e17) {
                    QLog.w("TroopHomeworkHelper", 1, e17.getMessage(), e17);
                    return null;
                }
            } catch (JSONException e18) {
                QLog.w("TroopHomeworkHelper", 1, e18.getMessage(), e18);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            if (z16) {
                QLog.e("TroopHomeworkHelper", 1, "getCosUploadByHttpClient io error, use getCosUploadByHttpURLConnection again");
                n(appRuntime, str, bundle, bundle2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject n(AppRuntime appRuntime, String str, Bundle bundle, Bundle bundle2) {
        try {
            String c16 = com.tencent.mobileqq.troop.homework.utils.c.c(appRuntime.getApplication().getApplicationContext(), str, bundle, bundle2);
            if (c16 == null) {
                c16 = "";
            }
            return new JSONObject(c16);
        } catch (IOException e16) {
            QLog.w("TroopHomeworkHelper", 1, e16.getMessage(), e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.w("TroopHomeworkHelper", 1, e17.getMessage(), e17);
            return null;
        } catch (JSONException e18) {
            QLog.w("TroopHomeworkHelper", 1, e18.getMessage(), e18);
            return null;
        }
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopHomeworkHelper", 1, "getFilePositions file name is Empty:" + str);
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("TroopHomeworkHelper", 1, "getFilePositions failed for file is not exist:" + str);
            return null;
        }
        long length = file.length();
        if (length == 0) {
            QLog.e("TroopHomeworkHelper", 1, "getFilePositions failed for fileSize is 0:" + str);
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        for (long j3 = 0; j3 < length; j3 += 1048576) {
            sb5.append(j3 + ",");
            if (length - j3 <= 4096) {
                break;
            }
        }
        sb5.deleteCharAt(sb5.length() - 1);
        return sb5.toString();
    }

    public static String p(String str) {
        String str2 = AppConstants.SDCARD_HOMEWORK_AUDIO;
        String format = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(System.currentTimeMillis()));
        StringBuilder sb5 = new StringBuilder(str2);
        sb5.append("stream");
        sb5.append(format);
        if (str.toLowerCase().endsWith(".slk")) {
            sb5.append(".slk");
        } else {
            sb5.append(".amr");
        }
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(String str, int i3) {
        if (i3 > 0 && !TextUtils.isEmpty(str) && str.length() >= i3) {
            return str.substring(0, i3);
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ea, code lost:
    
        if (r4 != null) goto L83;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.OutputStream, java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String r(String str, String str2, String str3, String str4, long j3) {
        OutputStream outputStream;
        InputStream inputStream;
        ?? r46;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        StringBuffer stringBuffer;
        ?? r26 = str3;
        ?? r36 = "\"";
        String str5 = "--";
        HttpURLConnection httpURLConnection2 = null;
        r8 = null;
        String str6 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123821742118716");
                    httpURLConnection.setRequestProperty("cookie", "uin=o" + r26 + ";p_uin=o" + r26 + ";p_skey=" + str4);
                    r26 = new DataOutputStream(httpURLConnection.getOutputStream());
                } catch (Exception e16) {
                    e = e16;
                    r26 = 0;
                    r36 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    r26 = 0;
                    r36 = 0;
                }
            } catch (Exception e17) {
                e = e17;
                r26 = 0;
                r36 = 0;
                bufferedReader = null;
                httpURLConnection = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                inputStream = null;
                r46 = 0;
                if (httpURLConnection2 != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                if (r46 != 0) {
                }
            }
            try {
                stringBuffer = new StringBuffer();
                stringBuffer.append("\r\n");
                stringBuffer.append("--");
                stringBuffer.append("---------------------------123821742118716");
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"hw_id\"\r\n\r\n");
                stringBuffer.append("\"" + j3 + "\"");
                r26.write(stringBuffer.toString().getBytes());
                stringBuffer.setLength(0);
                stringBuffer.append("\r\n");
                stringBuffer.append("--");
                stringBuffer.append("---------------------------123821742118716");
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + str2 + "\"\r\n");
                String str7 = str2.endsWith(".png") ? "image/png" : null;
                if (str7 == null || str7.equals("")) {
                    str7 = "application/octet-stream";
                }
                stringBuffer.append("Content-Type: " + str7 + HttpRsp.HTTP_HEADER_END);
                r26.write(stringBuffer.toString().getBytes());
                r36 = new DataInputStream(new FileInputStream(str2));
            } catch (Exception e18) {
                e = e18;
                r36 = 0;
                r26 = r26;
                bufferedReader = r36;
                QLog.e("TroopHomeworkHelper", 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                if (httpURLConnection != null) {
                }
                if (r36 != 0) {
                }
                if (r26 != 0) {
                }
            } catch (Throwable th7) {
                th = th7;
                r36 = 0;
                r26 = r26;
                str5 = r36;
                httpURLConnection2 = httpURLConnection;
                outputStream = r26;
                inputStream = r36;
                r46 = str5;
                if (httpURLConnection2 != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                if (r46 != 0) {
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = r36.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    r26.write(bArr, 0, read);
                }
                r26.write(("\r\n-----------------------------123821742118716--\r\n").getBytes());
                r26.flush();
                stringBuffer.setLength(0);
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } catch (Exception e19) {
                        e = e19;
                        QLog.e("TroopHomeworkHelper", 1, "\u53d1\u9001POST\u8bf7\u6c42\u51fa\u9519\u3002" + str, e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (r36 != 0) {
                            try {
                                r36.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (r26 != 0) {
                            try {
                                r26.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
                str6 = stringBuffer.toString();
                httpURLConnection.disconnect();
                try {
                    r36.close();
                } catch (IOException unused3) {
                }
                try {
                    r26.close();
                } catch (IOException unused4) {
                }
            } catch (Exception e26) {
                e = e26;
                bufferedReader = null;
            } catch (Throwable th8) {
                th = th8;
                str5 = null;
                httpURLConnection2 = httpURLConnection;
                outputStream = r26;
                inputStream = r36;
                r46 = str5;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (r46 != 0) {
                    try {
                        r46.close();
                        throw th;
                    } catch (IOException unused7) {
                        throw th;
                    }
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused8) {
                return str6;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class e implements VideoConverter.Processor {

        /* renamed from: a, reason: collision with root package name */
        final String f390924a;

        /* renamed from: b, reason: collision with root package name */
        final int f390925b;

        /* renamed from: c, reason: collision with root package name */
        final int f390926c;

        /* renamed from: d, reason: collision with root package name */
        final com.tencent.mobileqq.troop.homework.common.upload.b f390927d;

        e(String str, int i3, int i16, com.tencent.mobileqq.troop.homework.common.upload.b bVar) {
            this.f390924a = str;
            this.f390925b = i3;
            this.f390927d = bVar;
            if (i16 > 0) {
                this.f390926c = i16;
            } else {
                this.f390926c = 30;
            }
            if (str != null) {
            } else {
                throw new IllegalArgumentException("null == outputFilePath");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0078  */
        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            int i17;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            String[] split;
            int i29;
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            if (i3 <= i16) {
                i3 = i16;
            }
            videoConverterConfig.output = this.f390924a;
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lvcc.name(), IDPCApiConstant.LONG_VIDEO_COMPRESS_CONFIG_DEFAULT);
            int i36 = 0;
            if (featureValue != null && featureValue.length() > 0 && (split = featureValue.split("\\|")) != null && split.length > 4) {
                try {
                    i29 = Integer.valueOf(split[1]).intValue();
                    try {
                        i18 = Integer.valueOf(split[2]).intValue();
                        try {
                            i19 = Integer.valueOf(split[3]).intValue();
                        } catch (NumberFormatException e16) {
                            e = e16;
                            i19 = 0;
                        }
                    } catch (NumberFormatException e17) {
                        e = e17;
                        i18 = 0;
                        i19 = i18;
                        if (QLog.isColorLevel()) {
                        }
                        i17 = i36;
                        i36 = i29;
                        if (i36 <= 0) {
                        }
                        if (i18 <= 0) {
                        }
                        if (i19 <= 0) {
                        }
                        if (i17 <= 0) {
                        }
                        float f16 = i36 / i3;
                        videoConverterConfig.scaleRate = f16;
                        i26 = (int) ((this.f390925b * f16 * f16) + 0.5f);
                        videoConverterConfig.videoBitRate = i26;
                        i27 = i19 * 1024;
                        if (i26 > i27) {
                        }
                        i28 = this.f390926c;
                        if (i28 <= i17) {
                        }
                        videoConverterConfig.videoFrameRate = i17;
                        if (QLog.isColorLevel()) {
                        }
                        return videoConverterConfig;
                    }
                } catch (NumberFormatException e18) {
                    e = e18;
                    i29 = 0;
                    i18 = 0;
                }
                try {
                    i36 = Integer.valueOf(split[4]).intValue();
                } catch (NumberFormatException e19) {
                    e = e19;
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopHomeworkHelper", 2, "getEncodeConfig -> get DpcConfig Erro", e);
                    }
                    i17 = i36;
                    i36 = i29;
                    if (i36 <= 0) {
                    }
                    if (i18 <= 0) {
                    }
                    if (i19 <= 0) {
                    }
                    if (i17 <= 0) {
                    }
                    float f162 = i36 / i3;
                    videoConverterConfig.scaleRate = f162;
                    i26 = (int) ((this.f390925b * f162 * f162) + 0.5f);
                    videoConverterConfig.videoBitRate = i26;
                    i27 = i19 * 1024;
                    if (i26 > i27) {
                    }
                    i28 = this.f390926c;
                    if (i28 <= i17) {
                    }
                    videoConverterConfig.videoFrameRate = i17;
                    if (QLog.isColorLevel()) {
                    }
                    return videoConverterConfig;
                }
                i17 = i36;
                i36 = i29;
            } else {
                i17 = 0;
                i18 = 0;
                i19 = 0;
            }
            if (i36 <= 0) {
                i36 = 640;
            }
            if (i18 <= 0) {
                i18 = MsgConstant.KRMFILETHUMBSIZE384;
            }
            if (i19 <= 0) {
                i19 = 768;
            }
            if (i17 <= 0) {
                i17 = 30;
            }
            float f1622 = i36 / i3;
            videoConverterConfig.scaleRate = f1622;
            i26 = (int) ((this.f390925b * f1622 * f1622) + 0.5f);
            videoConverterConfig.videoBitRate = i26;
            i27 = i19 * 1024;
            if (i26 > i27) {
                videoConverterConfig.videoBitRate = i27;
            } else {
                int i37 = i18 * 1024;
                if (i26 < i37) {
                    videoConverterConfig.videoBitRate = i37;
                }
            }
            i28 = this.f390926c;
            if (i28 <= i17) {
                i17 = i28;
            }
            videoConverterConfig.videoFrameRate = i17;
            if (QLog.isColorLevel()) {
                QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + videoConverterConfig.setRotation);
            }
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onFailed");
            }
            com.tencent.mobileqq.troop.homework.common.upload.b bVar = this.f390927d;
            if (bVar != null) {
                bVar.onFail();
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onProgress:" + i3);
            }
            com.tencent.mobileqq.troop.homework.common.upload.b bVar = this.f390927d;
            if (bVar != null) {
                bVar.onProgress(i3);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
            if (QLog.isColorLevel()) {
                QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
            }
            com.tencent.mobileqq.troop.homework.common.upload.b bVar = this.f390927d;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
        }
    }
}
