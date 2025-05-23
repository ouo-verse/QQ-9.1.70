package fs;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    String f400437a;

    /* renamed from: b, reason: collision with root package name */
    String f400438b;

    /* renamed from: c, reason: collision with root package name */
    int f400439c;

    /* renamed from: d, reason: collision with root package name */
    int f400440d;

    /* renamed from: e, reason: collision with root package name */
    int f400441e;

    /* renamed from: f, reason: collision with root package name */
    float f400442f;

    /* renamed from: g, reason: collision with root package name */
    boolean f400443g;

    /* renamed from: h, reason: collision with root package name */
    boolean f400444h;

    /* renamed from: i, reason: collision with root package name */
    double f400445i;

    /* renamed from: j, reason: collision with root package name */
    double f400446j;

    /* renamed from: k, reason: collision with root package name */
    int f400447k;

    /* renamed from: l, reason: collision with root package name */
    int f400448l;

    /* renamed from: m, reason: collision with root package name */
    String f400449m;

    /* renamed from: n, reason: collision with root package name */
    int f400450n;

    /* renamed from: o, reason: collision with root package name */
    boolean f400451o;

    /* renamed from: p, reason: collision with root package name */
    Bitmap f400452p;

    public j(Bitmap bitmap, String str, int i3, int i16, int i17, float f16, double d16, double d17, int i18) {
        this.f400437a = str;
        this.f400441e = i17;
        this.f400442f = f16;
        this.f400445i = d16;
        this.f400446j = d17;
        this.f400447k = i3;
        this.f400448l = i16;
        this.f400450n = i18;
        this.f400452p = bitmap;
    }

    private int c() {
        String str;
        Bitmap bitmap = this.f400452p;
        if (bitmap != null && (str = this.f400437a) != null) {
            if (!com.tencent.biz.qqstory.utils.b.b(bitmap, str)) {
                hd0.c.g("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. compress thumb bitmap to file error.");
                return 1;
            }
            try {
                BaseImageUtil.updateLBSExif(this.f400437a, this.f400445i, this.f400446j);
            } catch (UnsupportedOperationException unused) {
                id0.a.k("video_edit", "update_LBS_exif_failed", 0, 0, this.f400437a, String.valueOf(this.f400437a != null ? new File(this.f400437a).exists() : false));
            }
            if (new File(this.f400437a).exists()) {
                return 0;
            }
            hd0.c.i("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", this.f400438b, this.f400437a);
            return 1;
        }
        hd0.c.g("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. bitmap = null or path = null.");
        return 1;
    }

    public Integer a(Void... voidArr) {
        b();
        return Integer.valueOf(c());
    }

    private void b() {
        this.f400439c = 320;
        int i3 = (int) (320 / this.f400442f);
        this.f400440d = i3;
        if (i3 % 2 > 0) {
            this.f400440d = i3 - 1;
        }
        int i16 = this.f400447k;
        if (i16 > 0) {
            this.f400439c = i16;
        }
        int i17 = this.f400448l;
        if (i17 > 0) {
            this.f400440d = i17;
        }
        hd0.c.a("Q.qqstory.publish.edit.GenerateThumbTask", "FlowSendTask():mFileDir:" + this.f400438b + ", mThumbWidth: " + this.f400439c + ", mThumbHeight:" + this.f400440d + ", mThumbOK:" + this.f400444h + ", mShowLastFrameThumb:" + this.f400443g + ", mExistThumbPath:" + this.f400449m + ", mExistThumbOk:" + this.f400451o);
    }
}
