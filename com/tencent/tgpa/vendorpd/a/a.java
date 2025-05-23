package com.tencent.tgpa.vendorpd.a;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.tgpa.vendorpd.CombinationInfo;
import com.tencent.tgpa.vendorpd.GamePredownloader;
import com.tencent.tgpa.vendorpd.b.f;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qzone.report.lp.LpReportInfo_dc02467;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f375984a;

    /* renamed from: b, reason: collision with root package name */
    public long f375985b;

    /* renamed from: c, reason: collision with root package name */
    public long f375986c;

    /* renamed from: d, reason: collision with root package name */
    private long f375987d;

    /* renamed from: e, reason: collision with root package name */
    private final CombinationInfo f375988e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.tgpa.vendorpd.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9914a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f375989a;

        /* renamed from: b, reason: collision with root package name */
        public int f375990b;

        /* renamed from: c, reason: collision with root package name */
        public String f375991c;

        public C9914a(long j3, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), str);
                return;
            }
            this.f375989a = j3;
            this.f375990b = i3;
            this.f375991c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<c> f375992a;

        /* renamed from: b, reason: collision with root package name */
        private final String f375993b;

        public b(String str, ArrayList<c> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) arrayList);
            } else {
                this.f375993b = str;
                this.f375992a = arrayList;
            }
        }

        private boolean b(c cVar) {
            f.b("can not delete predownload file content.");
            return false;
        }

        private boolean c(c cVar) {
            f.b("use modify instead of insert predownload file content.");
            return a(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x005c, code lost:
        
            if (r5.equals("insert") == false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a() {
            ArrayList<c> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.f375993b == null || (arrayList = this.f375992a) == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<c> it = this.f375992a.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    return true;
                }
                c next = it.next();
                String str = next.f375995b;
                str.hashCode();
                switch (str.hashCode()) {
                    case -1335458389:
                        if (str.equals("delete")) {
                            z16 = false;
                            break;
                        }
                        break;
                    case -1183792455:
                        break;
                    case -1068795718:
                        if (str.equals("modify")) {
                            z16 = 2;
                            break;
                        }
                        break;
                }
                z16 = -1;
                switch (z16) {
                    case false:
                        if (!b(next)) {
                            return false;
                        }
                        break;
                    case true:
                        if (!c(next)) {
                            return false;
                        }
                        break;
                    case true:
                        if (!a(next)) {
                            return false;
                        }
                        break;
                }
            }
        }

        private boolean a(c cVar) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f375993b), "rw");
                long length = randomAccessFile.length();
                long j3 = cVar.f375996c;
                int i3 = cVar.f375997d;
                byte[] b16 = com.tencent.tgpa.vendorpd.b.c.b(cVar.f375998e);
                if (b16.length != i3) {
                    Log.e("TGPA", "cloud operation's content size is not matched, ple check it.");
                    return false;
                }
                randomAccessFile.seek(length - j3);
                randomAccessFile.write(b16, 0, i3);
                randomAccessFile.close();
                return true;
            } catch (IOException e16) {
                e16.printStackTrace();
                Log.e("TGPA", "can not modify predownload file content.");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f375994a;

        /* renamed from: b, reason: collision with root package name */
        public String f375995b;

        /* renamed from: c, reason: collision with root package name */
        public long f375996c;

        /* renamed from: d, reason: collision with root package name */
        public int f375997d;

        /* renamed from: e, reason: collision with root package name */
        public String f375998e;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public boolean a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject)).booleanValue();
            }
            if (!jSONObject.has("index") || !jSONObject.has("action") || !jSONObject.has("offset") || !jSONObject.has("size") || !jSONObject.has("content")) {
                return false;
            }
            try {
                this.f375994a = jSONObject.getInt("index");
                this.f375995b = jSONObject.getString("action");
                this.f375996c = jSONObject.getLong("offset");
                this.f375997d = jSONObject.getInt("size");
                this.f375998e = jSONObject.getString("content");
                return true;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return false;
            }
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }

    public a(CombinationInfo combinationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) combinationInfo);
            return;
        }
        this.f375984a = 0L;
        this.f375987d = 0L;
        this.f375985b = 0L;
        this.f375986c = 0L;
        this.f375988e = combinationInfo;
    }

    public GamePredownloader.CombinationError a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (GamePredownloader.CombinationError) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (str == null) {
            f.d("combine package request failed, please check. ");
            return GamePredownloader.CombinationError.NetWorkRequestFailed;
        }
        f.a("combine package response: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("ret")) {
                f.b("combine package response parse exception, no ret, please check!");
                return GamePredownloader.CombinationError.JsonParseFailed;
            }
            int i3 = jSONObject.getInt("ret");
            if (i3 != 0) {
                f.a("combine package request error, ret is not 0, ret = %d , please check!", Integer.valueOf(i3));
                return GamePredownloader.CombinationError.ServerCheckError;
            }
            if (jSONObject.has("data")) {
                return GamePredownloader.CombinationError.Success;
            }
            f.b("combine package request error, no data, please check!");
            return GamePredownloader.CombinationError.JsonParseFailed;
        } catch (JSONException e16) {
            e16.printStackTrace();
            f.d("combine package response parse to json exception.");
            return GamePredownloader.CombinationError.JsonParseFailed;
        }
    }

    public ArrayList<c> b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSONObject);
        }
        AnonymousClass1 anonymousClass1 = null;
        if (jSONObject == null || !jSONObject.has("alter_list") || (optJSONArray = jSONObject.optJSONArray("alter_list")) == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList<c> arrayList = new ArrayList<>();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject == null || optJSONObject.optInt("index") != i3) {
                return null;
            }
            c cVar = new c(anonymousClass1);
            if (!cVar.a(optJSONObject)) {
                f.b("File operation parse exception, index: " + i3);
                return null;
            }
            arrayList.add(cVar);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f375985b = System.currentTimeMillis();
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public HashMap<String, String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event_name", "CombineApk");
        hashMap.put(CrashRtInfoHolder.BeaconKey.GAME_NAME, this.f375988e.gamePackageName);
        hashMap.put(QCircleLpReportDc05502.KEY_BEGIN_TIME, String.valueOf(this.f375984a));
        hashMap.put("load_time", String.valueOf(this.f375984a));
        hashMap.put("end_time", String.valueOf(this.f375987d));
        hashMap.put("md5_time", String.valueOf(this.f375986c));
        hashMap.put(LpReportInfo_dc02467.REQUEST_TIME, String.valueOf(this.f375985b - this.f375984a));
        hashMap.put("run_time", String.valueOf(this.f375987d - this.f375984a));
        hashMap.put("report_time", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("predown_file", String.valueOf(this.f375988e.predownFilePath));
        hashMap.put("file_name", String.valueOf(this.f375988e.cdnUrl));
        hashMap.put("file_md5", String.valueOf(this.f375988e.cdnMD5));
        hashMap.put("predownfile_md5", this.f375988e.predownFileMD5);
        return hashMap;
    }

    private boolean c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        return jSONObject.has("channel_tag") && (optJSONObject = jSONObject.optJSONObject("channel_tag")) != null && optJSONObject.has("offset") && optJSONObject.has("size") && optJSONObject.has("content");
    }

    public GamePredownloader.CombinationError a(String str, CombinationInfo combinationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (GamePredownloader.CombinationError) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) combinationInfo);
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            int i3 = jSONObject.getInt("status");
            if (!c(jSONObject)) {
                f.b("cloud channel tag parse failed, ple check it.");
                return GamePredownloader.CombinationError.CloudChannelTagIsNotCorrect;
            }
            C9914a a16 = a(jSONObject);
            ArrayList<c> b16 = b(jSONObject);
            if (b16 != null) {
                return a(combinationInfo.cdnMD5, combinationInfo.predownFilePath, i3, a16, b16);
            }
            f.b("cloud operation parse failed, ple check it.");
            return GamePredownloader.CombinationError.JsonParseFailed;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return GamePredownloader.CombinationError.JsonParseFailed;
        } catch (Exception e17) {
            e17.printStackTrace();
            f.d("combine apk failed because of unkown exception. ple call the developer.");
            return GamePredownloader.CombinationError.CodeRunTimeException;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f375987d = System.currentTimeMillis();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    private GamePredownloader.CombinationError a(String str, String str2, int i3, C9914a c9914a, ArrayList<c> arrayList) {
        long j3 = c9914a.f375989a;
        int i16 = c9914a.f375990b;
        String str3 = c9914a.f375991c;
        if (i3 != 0 && i3 != 1) {
            f.a("current server forbid to combine apk. status: %d", Integer.valueOf(i3));
            return GamePredownloader.CombinationError.ServerForbidCombineApk;
        }
        try {
            byte[] b16 = com.tencent.tgpa.vendorpd.b.c.b(str3);
            if (b16.length != i16) {
                f.b("cloud channel tag's content size is not matched, ple check it.");
                return GamePredownloader.CombinationError.CloudChannelTagSizeNotMatch;
            }
            byte[] a16 = a(j3, i16, str2);
            if (a16 == null) {
                return GamePredownloader.CombinationError.ReadPredownloadFileException;
            }
            if (i3 != 0) {
                return i3 == 1 ? !new b(str2, arrayList).a() ? GamePredownloader.CombinationError.OperationExecuteFailed : !a(str, str2) ? GamePredownloader.CombinationError.LocalFileMd5IsNotMatched : GamePredownloader.CombinationError.Success : GamePredownloader.CombinationError.ServerForbidCombineApk;
            }
            f.a("local tag: %s, cloud tag: %s", String.valueOf(com.tencent.tgpa.vendorpd.b.c.a(a16)), str3);
            if (!a(a16, b16)) {
                f.b("you can't combine other channels' predownload file.");
                return GamePredownloader.CombinationError.ServerForbidCombineApkOverChannels;
            }
            if (new b(str2, arrayList).a()) {
                return !a(str, str2) ? GamePredownloader.CombinationError.LocalFileMd5IsNotMatched : GamePredownloader.CombinationError.Success;
            }
            f.b("cloud operation do failed, ple check it.");
            return GamePredownloader.CombinationError.OperationExecuteFailed;
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.e("TGPA", "cloud channel tag's content decrypt failed. ");
            return GamePredownloader.CombinationError.ContentDecryptException;
        }
    }

    public C9914a a(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (C9914a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("channel_tag");
        return new C9914a(optJSONObject.getLong("offset"), optJSONObject.getInt("size"), optJSONObject.getString("content"));
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f375984a = System.currentTimeMillis();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            f.b("combine apk cdnMD5 is null, do not need check.");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = com.tencent.tgpa.vendorpd.b.c.a(new File(str2));
        this.f375986c = System.currentTimeMillis() - currentTimeMillis;
        if (a16 == null || !a16.equals(str)) {
            f.b("combine apk failed, md5 is not matched. md5: %s", a16);
            return false;
        }
        return true;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (Arrays.equals(bArr, bArr2)) {
            return true;
        }
        Log.e("TGPA", "predownload file's channel tag is not matched in cloud config.");
        return false;
    }

    private byte[] a(long j3, int i3, String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "rw");
            randomAccessFile.seek(randomAccessFile.length() - j3);
            byte[] bArr = new byte[i3];
            randomAccessFile.read(bArr, 0, i3);
            randomAccessFile.close();
            return bArr;
        } catch (IOException e16) {
            e16.printStackTrace();
            Log.e("TGPA", "can not read tgpa channel in predownload file content.");
            return null;
        }
    }
}
