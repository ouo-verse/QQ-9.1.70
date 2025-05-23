package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public int f198218a;

    /* renamed from: b, reason: collision with root package name */
    public String f198219b;

    /* renamed from: c, reason: collision with root package name */
    public int f198220c;

    /* renamed from: d, reason: collision with root package name */
    public String f198221d;

    /* renamed from: e, reason: collision with root package name */
    public int f198222e;

    /* renamed from: f, reason: collision with root package name */
    public int f198223f;

    /* renamed from: g, reason: collision with root package name */
    public String f198224g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<a> f198225h;

    /* renamed from: i, reason: collision with root package name */
    public FaceStatus[] f198226i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f198227a;

        /* renamed from: b, reason: collision with root package name */
        public int f198228b;

        /* renamed from: c, reason: collision with root package name */
        public String f198229c;

        /* renamed from: d, reason: collision with root package name */
        public String f198230d;

        /* renamed from: e, reason: collision with root package name */
        public String f198231e;

        /* renamed from: f, reason: collision with root package name */
        public String f198232f;

        /* renamed from: g, reason: collision with root package name */
        public String f198233g;

        /* renamed from: h, reason: collision with root package name */
        public float f198234h;

        public String toString() {
            return "StarInfo{faceID=" + this.f198228b + ", uin=" + this.f198227a + ", name='" + this.f198229c + "', pinyin_name='" + this.f198230d + "', wiki='" + this.f198231e + "', wikiTitle='" + this.f198232f + "', wikiURL='" + this.f198233g + "', confidence='" + this.f198234h + "'}";
        }
    }

    public static boolean a(o oVar) {
        boolean z16;
        if (oVar != null && oVar.f198218a == 0 && oVar.f198220c == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARRspFaceResult", 2, "[ScanStarFace]isRecogSuccess result = " + z16);
        }
        return z16;
    }

    public String toString() {
        return "ARCloudRecogRspFaceResult{errCode_MQ=" + this.f198218a + ", errMsg_MQ='" + this.f198219b + "', errCode_YT=" + this.f198220c + ", errMsg_YT=" + this.f198221d + ", time_ms_YT=" + this.f198222e + ", group_size_YT=" + this.f198223f + ", sessionID='" + this.f198224g + "', starInfoList=" + this.f198225h + ", faceStatus[]=" + this.f198226i + '}';
    }
}
