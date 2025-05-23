package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.bf.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b1 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122530a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122530a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_ILLEGAL_READ_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122530a[com.tencent.luggage.wxa.rc.l.ERR_ILLEGAL_READ_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122530a[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122530a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122530a[com.tencent.luggage.wxa.rc.l.ERR_FS_NOT_MOUNTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        com.tencent.luggage.wxa.cp.v allocTempFile;
        String str2;
        e eVar;
        String str3;
        JSONArray jSONArray;
        String str4;
        int i3;
        String str5;
        f fVar;
        String str6;
        com.tencent.luggage.wxa.tk.i iVar;
        e eVar2;
        HashMap hashMap;
        com.tencent.luggage.wxa.tk.i iVar2;
        e eVar3;
        String str7;
        com.tencent.luggage.wxa.cp.v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
        if (absoluteFile != null && absoluteFile.e()) {
            if (absoluteFile.p() || com.tencent.luggage.wxa.rc.m.a(absoluteFile)) {
                return new f("fail permission denied, open \"%s\"", str);
            }
            z17 = false;
        } else {
            if (dVar.getFileSystem().access(str) != com.tencent.luggage.wxa.rc.l.OK || (allocTempFile = dVar.getFileSystem().allocTempFile(URLEncoder.encode(str))) == null) {
                z16 = false;
            } else {
                com.tencent.luggage.wxa.tk.i iVar3 = new com.tencent.luggage.wxa.tk.i();
                dVar.getFileSystem().readFile(str, iVar3);
                try {
                    Channels.newChannel(com.tencent.luggage.wxa.cp.x.b(allocTempFile)).write((ByteBuffer) iVar3.f141499a);
                    absoluteFile = new com.tencent.luggage.wxa.cp.v(allocTempFile.g());
                    z16 = true;
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", "copy ByteBuffer failed e = %s", e16);
                    z16 = false;
                    absoluteFile = null;
                }
            }
            if (absoluteFile == null) {
                return new f("fail no such file \"%s\"", str);
            }
            z17 = z16;
        }
        f fVar2 = new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
        com.tencent.luggage.wxa.tk.i iVar4 = new com.tencent.luggage.wxa.tk.i();
        iVar4.f141499a = fVar2;
        HashMap hashMap2 = new HashMap();
        com.tencent.luggage.wxa.tk.i iVar5 = new com.tencent.luggage.wxa.tk.i();
        iVar5.f141499a = hashMap2;
        String str8 = "";
        String str9 = "fail invalid encoding";
        String str10 = "encoding";
        if ("all".equals(jSONObject.optString("entries", ""))) {
            String optString = jSONObject.optString("encoding");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", "call, all files, path %s, encoding %s", str, optString);
            if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
                eVar3 = null;
            } else {
                e eVar4 = (e) e.a.f122536a.get(optString.toLowerCase());
                if (eVar4 == null) {
                    return new f("fail invalid encoding", new Object[0]);
                }
                eVar3 = eVar4;
            }
            com.tencent.luggage.wxa.tk.i iVar6 = new com.tencent.luggage.wxa.tk.i();
            try {
                str7 = "MicroMsg.AppBrand.FileSystem.UnitReadZipEntry";
                try {
                    com.tencent.luggage.wxa.rc.l readZipEntry = dVar.getFileSystem().readZipEntry(str, iVar6, "", 0L, Long.MAX_VALUE);
                    a(z17, absoluteFile.g());
                    if (readZipEntry == com.tencent.luggage.wxa.rc.l.OK && iVar6.f141499a != null) {
                        a(iVar6, eVar3, iVar4, iVar5);
                        return fVar2.a("entries", hashMap2);
                    }
                    return a(readZipEntry, str);
                } catch (Exception e17) {
                    e = e17;
                    com.tencent.luggage.wxa.tn.w.a(str7, e, "read zip stream, all files mode", new Object[0]);
                    return new f("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail read zip data", new Object[0]);
                }
            } catch (Exception e18) {
                e = e18;
                str7 = "MicroMsg.AppBrand.FileSystem.UnitReadZipEntry";
            }
        } else {
            String str11 = "entries";
            HashMap hashMap3 = hashMap2;
            String str12 = "MicroMsg.AppBrand.FileSystem.UnitReadZipEntry";
            f fVar3 = fVar2;
            JSONArray optJSONArray = jSONObject.optJSONArray(str11);
            if (optJSONArray == null) {
                return new f("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail invalid input: entries format wrong", new Object[0]);
            }
            int i16 = 0;
            while (i16 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    JSONArray jSONArray2 = optJSONArray;
                    if (!com.tencent.luggage.wxa.tn.w0.c(optJSONObject.optString("path"))) {
                        String optString2 = optJSONObject.optString("path");
                        String optString3 = optJSONObject.optString(str10, str8);
                        int i17 = i16;
                        String str13 = str12;
                        f fVar4 = fVar3;
                        long optLong = optJSONObject.optLong("position", 0L);
                        String str14 = str11;
                        long optLong2 = optJSONObject.optLong("length", Long.MAX_VALUE);
                        String str15 = str10;
                        try {
                            try {
                                if (com.tencent.luggage.wxa.tn.w0.c(optString3)) {
                                    str2 = str8;
                                    eVar = null;
                                } else {
                                    str2 = str8;
                                    e eVar5 = (e) e.a.f122536a.get(optString3.toLowerCase());
                                    if (eVar5 == null) {
                                        HashMap hashMap4 = new HashMap();
                                        hashMap4.put("errMsg", str9);
                                        hashMap3.put(HippyBridge.URI_SCHEME_FILE + optString2, hashMap4);
                                        str3 = str;
                                        jSONArray = jSONArray2;
                                        str4 = str9;
                                        i3 = i17;
                                        str5 = str13;
                                        fVar = fVar4;
                                        str6 = str14;
                                        str10 = str15;
                                        str8 = str2;
                                        str9 = str4;
                                        fVar3 = fVar;
                                        str12 = str5;
                                        str11 = str6;
                                        i16 = i3 + 1;
                                        optJSONArray = jSONArray;
                                    } else {
                                        eVar = eVar5;
                                    }
                                }
                                com.tencent.luggage.wxa.rc.l readZipEntry2 = dVar.getFileSystem().readZipEntry(str, iVar, optString2, optLong, optLong2);
                                a(z17, absoluteFile.g());
                                if (readZipEntry2 == com.tencent.luggage.wxa.rc.l.OK) {
                                    iVar2 = iVar;
                                    if (iVar2.f141499a != null && ((Map) iVar2.f141499a).size() > 0) {
                                        a(iVar2, eVar2, iVar4, iVar5);
                                        str3 = str;
                                        hashMap3 = hashMap;
                                        str10 = str15;
                                        str8 = str2;
                                        str9 = str4;
                                        fVar3 = fVar;
                                        str12 = str5;
                                        str11 = str6;
                                        i16 = i3 + 1;
                                        optJSONArray = jSONArray;
                                    }
                                } else {
                                    iVar2 = iVar;
                                }
                                if (iVar2.f141499a != null && ((Map) iVar2.f141499a).size() == 0) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("errMsg", "fail no such file");
                                    hashMap3 = hashMap;
                                    hashMap3.put(HippyBridge.URI_SCHEME_FILE + optString2, hashMap5);
                                    str3 = str;
                                    str10 = str15;
                                    str8 = str2;
                                    str9 = str4;
                                    fVar3 = fVar;
                                    str12 = str5;
                                    str11 = str6;
                                    i16 = i3 + 1;
                                    optJSONArray = jSONArray;
                                } else {
                                    hashMap3 = hashMap;
                                    int i18 = a.f122530a[readZipEntry2.ordinal()];
                                    if (i18 == 1) {
                                        str3 = str;
                                        HashMap hashMap6 = new HashMap();
                                        hashMap6.put("errMsg", "fail the value of position is out of range");
                                        hashMap3.put(HippyBridge.URI_SCHEME_FILE + optString2, hashMap6);
                                    } else {
                                        if (i18 != 2) {
                                            return a(readZipEntry2, str);
                                        }
                                        str3 = str;
                                        HashMap hashMap7 = new HashMap();
                                        hashMap7.put("errMsg", "fail the value of length is out of range");
                                        hashMap3.put(HippyBridge.URI_SCHEME_FILE + optString2, hashMap7);
                                    }
                                    str10 = str15;
                                    str8 = str2;
                                    str9 = str4;
                                    fVar3 = fVar;
                                    str12 = str5;
                                    str11 = str6;
                                    i16 = i3 + 1;
                                    optJSONArray = jSONArray;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                com.tencent.luggage.wxa.tn.w.a(str5, e, "read zip stream, single file mode", new Object[0]);
                                return new f("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail read ZipEntry", new Object[0]);
                            }
                            jSONArray = jSONArray2;
                            i3 = i17;
                            str4 = str9;
                            eVar2 = eVar;
                            hashMap = hashMap3;
                            str5 = str13;
                            fVar = fVar4;
                            str6 = str14;
                        } catch (Exception e26) {
                            e = e26;
                            str5 = str13;
                        }
                        iVar = new com.tencent.luggage.wxa.tk.i();
                    }
                }
                return new f("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryinvalid input data", new Object[0]);
            }
            return fVar3.a(str11, hashMap3);
        }
    }

    public final void a(boolean z16, String str) {
        if (z16) {
            com.tencent.luggage.wxa.cp.x.c(str);
        }
    }

    public final void a(com.tencent.luggage.wxa.tk.i iVar, e eVar, com.tencent.luggage.wxa.tk.i iVar2, com.tencent.luggage.wxa.tk.i iVar3) {
        if (iVar.f141499a == null || iVar2.f141499a == null || iVar3.f141499a == null) {
            return;
        }
        for (Map.Entry entry : ((Map) iVar.f141499a).entrySet()) {
            HashMap hashMap = new HashMap();
            if (eVar == null) {
                Object value = entry.getValue();
                ((f) iVar2.f141499a).a(HippyBridge.URI_SCHEME_FILE + ((String) entry.getKey()), value);
                hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            } else {
                hashMap.put("data", eVar.a((ByteBuffer) entry.getValue()));
                hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            }
            ((Map) iVar3.f141499a).put(HippyBridge.URI_SCHEME_FILE + ((String) entry.getKey()), hashMap);
        }
    }

    public final f a(com.tencent.luggage.wxa.rc.l lVar, String str) {
        int i3 = a.f122530a[lVar.ordinal()];
        if (i3 == 3) {
            return new f("fail no such file or directory, open \"%s\"", str);
        }
        if (i3 == 4) {
            return new f("fail permission denied, open \"%s\"", str);
        }
        if (i3 != 5) {
            return new f("fail " + lVar.name(), new Object[0]);
        }
        return new f("fail sdcard not mounted", new Object[0]);
    }
}
