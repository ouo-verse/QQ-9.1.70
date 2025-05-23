package com.tencent.av.opengl.effects;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f73985a = com.tencent.av.b.d() + "SKINCOLOR" + File.separator;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f73986a;

        /* renamed from: b, reason: collision with root package name */
        public String f73987b;

        /* renamed from: c, reason: collision with root package name */
        public String f73988c;

        public b(int i3, String str, String str2) {
            this.f73986a = i3;
            this.f73987b = str;
            this.f73988c = str2;
        }
    }

    private static void a(Context context, String str, String str2) {
        b bVar;
        b bVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            bVar = c(str);
        } else {
            bVar = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            bVar2 = c(str2);
        }
        if (bVar == null) {
            FileUtils.deleteDirectory(f73985a);
        } else if (bVar2 != null && !bVar.f73988c.equals(bVar2.f73988c)) {
            FileUtils.deleteDirectory(f73985a);
        }
    }

    private static boolean b() {
        int i3 = com.tencent.av.utils.af.d(180, com.tencent.av.utils.af.f76962q).getInt("qav_effect_beauty_config_first_launch", 0);
        AVCoreLog.printColorLog("EffectBeautyTools", "getIsFirstLauncher:" + i3);
        if (i3 != 0) {
            return false;
        }
        return true;
    }

    private static b c(String str) {
        int intValue;
        String string;
        String string2;
        b bVar;
        b bVar2 = null;
        if (TextUtils.isEmpty(str)) {
            AVCoreLog.printColorLog("EffectBeautyTools", "parseConfig|content is empty.");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("skinColorFilter");
            try {
                intValue = Integer.valueOf(jSONObject.getString(QCircleSchemeAttr.Polymerize.FILTER_ID)).intValue();
                string = jSONObject.getString("resurl");
                string2 = jSONObject.getString("md5");
                bVar = new b(intValue, string, string2);
            } catch (JSONException e16) {
                e = e16;
            }
            try {
                AVCoreLog.printColorLog("EffectBeautyTools", "parseConfig:" + intValue + "|" + string + "|" + string2);
                return bVar;
            } catch (JSONException e17) {
                e = e17;
                bVar2 = bVar;
                e.printStackTrace();
                AVCoreLog.printColorLog("EffectBeautyTools", "parseConfig failed. info = " + jSONObject);
                return bVar2;
            }
        } catch (JSONException e18) {
            e18.printStackTrace();
            AVCoreLog.printColorLog("EffectBeautyTools", "parseConfig|parse failed.context = " + str);
        }
    }

    public static void d(Context context) {
        try {
            if (b()) {
                e();
                String str = f73985a;
                if (new File(str).exists()) {
                    FileUtils.deleteDirectory(str);
                }
            }
            b c16 = c(com.tencent.av.utils.af.f(180, com.tencent.av.utils.af.f76962q));
            if (c16 != null && !TextUtils.isEmpty(c16.f73987b)) {
                File file = new File(f73985a + IVideoFilterTools.CONFIG_FILE);
                AVCoreLog.printColorLog("EffectBeautyTools", "preDownloadResource :" + file.exists());
                if (!file.exists()) {
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = c16.f73987b;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = com.tencent.av.b.d() + "skin_color.zip";
                    httpNetReq.setUserData(c16);
                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void e() {
        SharedPreferences.Editor edit = com.tencent.av.utils.af.d(180, com.tencent.av.utils.af.f76962q).edit();
        edit.putInt("qav_effect_beauty_config_first_launch", 1);
        edit.commit();
    }

    public static void f(Context context, String str, int i3, boolean z16) {
        a(context, str, com.tencent.av.utils.af.f(180, com.tencent.av.utils.af.f76962q));
        com.tencent.av.utils.af.M(180, com.tencent.av.utils.af.f76962q, i3, str);
        if (z16) {
            d(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements INetEngineListener {
        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            b bVar = (b) netResp.mReq.getUserData();
            AVCoreLog.printColorLog("EffectBeautyTools", "download file call back. file = " + bVar.f73987b);
            if (netResp.mResult != 0) {
                AVCoreLog.printColorLog("EffectBeautyTools", "download file faild. errcode = " + netResp.mErrCode);
                return;
            }
            if (!bVar.f73988c.equalsIgnoreCase(SecUtil.getFileMd5(netResp.mReq.mOutPath))) {
                AVCoreLog.printColorLog("EffectBeautyTools", "download file faild : md5 is not match.");
                FileUtils.deleteFile(netResp.mReq.mOutPath);
                return;
            }
            AVCoreLog.printColorLog("EffectBeautyTools", "download file successed.");
            try {
                FileUtils.uncompressZip(netResp.mReq.mOutPath, com.tencent.av.b.d(), false);
                FileUtils.deleteFile(netResp.mReq.mOutPath);
            } catch (IOException e16) {
                e16.printStackTrace();
                AVCoreLog.printColorLog("EffectBeautyTools", "unzip file faild.");
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
