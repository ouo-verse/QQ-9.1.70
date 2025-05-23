package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z0 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122600a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122600a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122600a[com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122600a[com.tencent.luggage.wxa.rc.l.ERR_IS_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122600a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122600a[com.tencent.luggage.wxa.rc.l.ERR_SYMLINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f122600a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.rc.l readDir = dVar.getFileSystem().readDir(str, iVar);
        com.tencent.luggage.wxa.h6.c.a(linkedList, (List) iVar.f141499a);
        switch (a.f122600a[readDir.ordinal()]) {
            case 1:
            case 2:
                return new f("fail no such file or directory \"%s\"", str);
            case 3:
                return new f("fail not a directory \"%s\"", str);
            case 4:
                return new f("fail permission denied, open \"%s\"", str);
            case 5:
                return new f("fail \"%s\" is not a regular file", str);
            case 6:
                JSONArray jSONArray = new JSONArray();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(((com.tencent.luggage.wxa.rc.j) it.next()).f139536a);
                }
                return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]).a("files", jSONArray);
            default:
                return new f("fail " + readDir.name(), new Object[0]);
        }
    }
}
