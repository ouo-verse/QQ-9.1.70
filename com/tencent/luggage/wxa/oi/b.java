package com.tencent.luggage.wxa.oi;

import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.nio.ByteBuffer;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static com.tencent.luggage.wxa.qb.b a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, String str3, String str4, a0.a aVar, String str5) {
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            w.d("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", str2, str4);
            com.tencent.luggage.wxa.qb.b bVar = new com.tencent.luggage.wxa.qb.b();
            bVar.f138577n = str;
            bVar.f138564a = str2;
            bVar.f138574k = str5;
            bVar.f138565b = str3;
            bVar.f138572i = 0;
            try {
                JSONObject jSONObject = new JSONObject(str4);
                int optInt = jSONObject.optInt("startTime", 0);
                boolean optBoolean = jSONObject.optBoolean("autoplay", false);
                boolean optBoolean2 = jSONObject.optBoolean("loop", false);
                double optDouble = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
                double optDouble2 = jSONObject.optDouble("playbackRate", 1.0d);
                bVar.f138567d = optInt;
                bVar.f138568e = optInt;
                bVar.f138570g = optBoolean;
                bVar.f138571h = optBoolean2;
                bVar.f138575l = optDouble;
                bVar.f138576m = optDouble2;
            } catch (JSONException e16) {
                w.a("MicroMsg.Audio.AudioPlayerParamParser", e16, "parseAudioPlayParam", new Object[0]);
            }
            if (str3.startsWith("file://")) {
                String substring = str3.substring(7);
                bVar.f138566c = substring;
                w.d("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", substring);
            } else if (str3.contains("base64") && str3.startsWith("data:audio")) {
                String a16 = g.a(str3.substring(str3.indexOf("base64,") + 7).trim());
                bVar.f138566c = a16;
                w.d("MicroMsg.Audio.AudioPlayerParamParser", "base64 decode filePath:%s", a16);
            } else if (str3.startsWith("wxblob://")) {
                i iVar = new i();
                if (dVar.getFileSystem().readFile(str3, iVar) == l.OK) {
                    bVar.C = (ByteBuffer) iVar.f141499a;
                    bVar.f138566c = str3;
                    w.d("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read ok");
                } else {
                    w.b("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read fail");
                    v privateAbsoluteFile = dVar.getFileSystem().getPrivateAbsoluteFile(str3);
                    if (privateAbsoluteFile != null && privateAbsoluteFile.e()) {
                        bVar.f138566c = privateAbsoluteFile.g();
                    } else {
                        w.b("MicroMsg.Audio.AudioPlayerParamParser", "wxblob localFile is null");
                    }
                }
            } else if (!str3.startsWith("http://") && !str3.startsWith("https://")) {
                com.tencent.luggage.wxa.qb.f a17 = f.a(aVar);
                if (a17 != null && a17.isOpen()) {
                    bVar.f138566c = str3;
                    bVar.f138588y = a17;
                } else {
                    w.b("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", str3);
                    IOUtils.closeQuietly(a17);
                    return null;
                }
            }
            return bVar;
        }
        w.b("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", str4, str3);
        return null;
    }
}
