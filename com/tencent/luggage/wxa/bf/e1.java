package com.tencent.luggage.wxa.bf;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e1 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122541a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122541a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122541a[com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122541a[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122541a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static f b(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        LinkedList<com.tencent.luggage.wxa.rc.z> linkedList = new LinkedList();
        com.tencent.luggage.wxa.rc.l statDir = dVar.getFileSystem().statDir(str, linkedList);
        if (a.f122541a[statDir.ordinal()] != 1) {
            return new f("fail " + statDir.name(), new Object[0]);
        }
        f fVar = new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
        for (com.tencent.luggage.wxa.rc.z zVar : linkedList) {
            fVar.a(zVar.a(), a(zVar, new HashMap()));
        }
        return fVar;
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("recursive", false);
        FileStructStat fileStructStat = new FileStructStat();
        com.tencent.luggage.wxa.rc.l stat = dVar.getFileSystem().stat(str, fileStructStat);
        int i3 = a.f122541a[stat.ordinal()];
        if (i3 == 1) {
            if (fileStructStat.isDirectory() && optBoolean) {
                return b(dVar, str, jSONObject);
            }
            return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]).a(a(fileStructStat, new HashMap()));
        }
        if (i3 == 2 || i3 == 3) {
            return new f("fail no such file or directory \"%s\"", str);
        }
        if (i3 != 4) {
            return new f("fail " + stat.name(), new Object[0]);
        }
        return new f("fail permission denied, open \"%s\"", str);
    }

    public static Map a(FileStructStat fileStructStat, Map map) {
        map.put("mode", Integer.valueOf(fileStructStat.st_mode));
        map.put("size", Long.valueOf(fileStructStat.st_size));
        map.put("lastAccessedTime", Long.valueOf(fileStructStat.st_atime));
        map.put("lastModifiedTime", Long.valueOf(fileStructStat.st_mtime));
        return map;
    }
}
