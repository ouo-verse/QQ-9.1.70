package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public class q extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    private final String f400466h;

    public q() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0103 A[Catch: OutOfMemoryError -> 0x016e, TRY_LEAVE, TryCatch #3 {OutOfMemoryError -> 0x016e, blocks: (B:24:0x0072, B:26:0x0078, B:34:0x00b0, B:37:0x00c0, B:44:0x00d0, B:46:0x00e7, B:48:0x00ed, B:50:0x00f8, B:54:0x0103, B:67:0x0127, B:70:0x013f, B:72:0x014d, B:73:0x0167, B:78:0x0096, B:75:0x0090, B:59:0x0112, B:61:0x0118, B:63:0x011e, B:41:0x00ca), top: B:23:0x0072, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013f A[Catch: OutOfMemoryError -> 0x016e, TryCatch #3 {OutOfMemoryError -> 0x016e, blocks: (B:24:0x0072, B:26:0x0078, B:34:0x00b0, B:37:0x00c0, B:44:0x00d0, B:46:0x00e7, B:48:0x00ed, B:50:0x00f8, B:54:0x0103, B:67:0x0127, B:70:0x013f, B:72:0x014d, B:73:0x0167, B:78:0x0096, B:75:0x0090, B:59:0x0112, B:61:0x0118, B:63:0x011e, B:41:0x00ca), top: B:23:0x0072, inners: #0, #1, #2, #4 }] */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        Bitmap decodeFile;
        Bitmap c16;
        Bitmap decodeFile2;
        Bitmap i3;
        Bitmap a16;
        String str = bVar.f400393j;
        if (TextUtils.isEmpty(str)) {
            super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
            return;
        }
        String str2 = this.f400466h;
        if (str2 == null) {
            str2 = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
        }
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        String str3 = publishVideoEntry.doodleRawPath;
        String str4 = publishVideoEntry.doodlePath;
        String stringExtra = publishVideoEntry.getStringExtra("dynamic_Sticker_image_path", null);
        String stringExtra2 = bVar.f400387d.getStringExtra("pl_pic", null);
        boolean z16 = true;
        if (str3 == null && str4 == null && stringExtra == null) {
            hd0.c.b("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", str2);
            if (com.tencent.biz.qqstory.utils.d.e(new File(str), new File(str2))) {
                bVar.f400387d.thumbPath = str2;
            } else {
                hd0.c.v("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", str, str2);
                z16 = false;
            }
        } else {
            try {
                decodeFile = BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e16) {
                hd0.c.g("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + e16);
            }
            if (decodeFile == null) {
                super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.o0m)));
                return;
            }
            if (stringExtra != null) {
                try {
                    c16 = com.tencent.biz.qqstory.utils.b.c(stringExtra);
                } catch (OutOfMemoryError e17) {
                    hd0.c.h("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str4 + " failed", e17);
                }
                if (c16 != null && str3 != null) {
                    try {
                        c16 = com.tencent.biz.qqstory.utils.b.t(str3, null);
                        hd0.c.v("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", str3);
                    } catch (IOException e18) {
                        hd0.c.h("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", e18);
                    }
                }
                if (c16 == null && str4 != null) {
                    try {
                        c16 = com.tencent.biz.qqstory.utils.b.c(str4);
                    } catch (OutOfMemoryError e19) {
                        hd0.c.h("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str4 + " failed", e19);
                    }
                }
                if (c16 != null && (bVar.f400386c instanceof EditLocalVideoSource) && bVar.f400387d.getBooleanExtra("landscape_video", false) && (a16 = c.a(c16, -90)) != null) {
                    c16 = a16;
                }
                if (c16 != null) {
                    Bitmap i16 = com.tencent.biz.qqstory.utils.b.i(decodeFile, c16);
                    c16.recycle();
                    decodeFile.recycle();
                    decodeFile = i16;
                }
                if (decodeFile != null && stringExtra2 != null) {
                    try {
                        decodeFile2 = BitmapFactory.decodeFile(stringExtra2);
                        if (decodeFile2 != null && (i3 = com.tencent.biz.qqstory.utils.b.i(decodeFile, decodeFile2)) != null) {
                            decodeFile.recycle();
                            decodeFile2.recycle();
                            decodeFile = i3;
                        }
                    } catch (OutOfMemoryError e26) {
                        hd0.c.h("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + stringExtra2 + " failed", e26);
                    }
                }
                if (decodeFile == null) {
                    com.tencent.biz.qqstory.utils.d.c(vc0.a.f441365e);
                    boolean b16 = com.tencent.biz.qqstory.utils.b.b(decodeFile, str2);
                    decodeFile.recycle();
                    if (b16) {
                        bVar.f400387d.thumbPath = str2;
                        hd0.c.a("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + str2);
                    } else {
                        hd0.c.t("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
                    }
                }
                z16 = false;
            }
            c16 = null;
            if (c16 != null) {
                c16 = com.tencent.biz.qqstory.utils.b.t(str3, null);
                hd0.c.v("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", str3);
            }
            if (c16 == null) {
                c16 = com.tencent.biz.qqstory.utils.b.c(str4);
            }
            if (c16 != null) {
                c16 = a16;
            }
            if (c16 != null) {
            }
            if (decodeFile != null) {
                decodeFile2 = BitmapFactory.decodeFile(stringExtra2);
                if (decodeFile2 != null) {
                    decodeFile.recycle();
                    decodeFile2.recycle();
                    decodeFile = i3;
                }
            }
            if (decodeFile == null) {
            }
            z16 = false;
        }
        if (z16) {
            com.tencent.biz.qqstory.utils.d.e(new File(bVar.f400387d.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.f94261g0));
            super.notifyResult(bVar);
        } else {
            super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.o0p)));
        }
    }

    public q(String str) {
        this.f400466h = str;
    }
}
