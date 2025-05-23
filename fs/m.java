package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public class m extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    private final String f400459h;

    public m() {
        this(null);
    }

    public m(String str) {
        this.f400459h = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(12:33|34|(11:80|81|82|37|(2:40|41)|(2:47|48)|(3:54|55|56)|59|(3:62|63|(2:67|68))|(2:73|(1:75)(1:76))|23)|36|37|(2:40|41)|(2:47|48)|(0)|59|(3:62|63|(3:65|67|68))|(0)|23) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x010b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010c, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0143, code lost:
    
        hd0.c.g("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "merge doodle and thumb image failed : " + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137 A[Catch: OutOfMemoryError -> 0x010b, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x010b, blocks: (B:41:0x00fc, B:44:0x010f, B:52:0x0120, B:54:0x0137, B:48:0x0119), top: B:37:0x00f8, inners: #3, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018c  */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap;
        Bitmap decodeFile;
        Bitmap i3;
        Bitmap c16;
        String str = bVar.f400393j;
        if (TextUtils.isEmpty(str)) {
            super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
            return;
        }
        String str2 = this.f400459h;
        if (str2 == null) {
            str2 = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
        }
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        String str3 = publishVideoEntry.doodleRawPath;
        String str4 = publishVideoEntry.doodlePath;
        BufferedInputStream bufferedInputStream2 = null;
        r10 = null;
        r10 = null;
        Bitmap bitmap2 = null;
        String stringExtra = publishVideoEntry.getStringExtra("dynamic_Sticker_image_path", null);
        String stringExtra2 = bVar.f400387d.getStringExtra("pl_pic", null);
        boolean z16 = true;
        if (str3 == null && str4 == null && stringExtra == null && stringExtra2 == null) {
            hd0.c.b("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", str2);
            if (com.tencent.biz.qqstory.utils.d.e(new File(str), new File(str2))) {
                bVar.f400387d.thumbPath = str2;
            } else {
                hd0.c.v("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "copy failed, original = %s, target = %s", str, str2);
                z16 = false;
            }
        } else {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedInputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    bufferedInputStream = null;
                } catch (Throwable th6) {
                    th5 = th6;
                }
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(bufferedInputStream);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e18) {
                            hd0.c.u("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", " IOException", e18);
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                        hd0.c.u("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", " FileNotFoundException", e);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        bitmap = null;
                        if (bitmap != null) {
                        }
                    } catch (OutOfMemoryError e26) {
                        e = e26;
                        hd0.c.u("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", " OutOfMemoryError", e);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        bitmap = null;
                        if (bitmap != null) {
                        }
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                            throw th5;
                        } catch (IOException e27) {
                            hd0.c.u("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", " IOException", e27);
                            throw th5;
                        }
                    }
                    throw th5;
                }
            } catch (IOException e28) {
                hd0.c.u("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", " IOException", e28);
                bitmap = null;
                if (bitmap != null) {
                }
            }
            if (bitmap != null) {
                super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.ncv)));
                return;
            }
            try {
            } catch (OutOfMemoryError e29) {
                e = e29;
            }
            if (stringExtra != null) {
                try {
                    c16 = com.tencent.biz.qqstory.utils.b.c(stringExtra);
                } catch (OutOfMemoryError e36) {
                    hd0.c.h("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "decode " + str4 + " failed", e36);
                }
                if (c16 == null && str3 != null) {
                    try {
                        c16 = com.tencent.biz.qqstory.utils.b.t(str3, null);
                        hd0.c.v("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "unSerializeBitmapFromFile success %s", str3);
                    } catch (IOException e37) {
                        hd0.c.h("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "unSerializeBitmapFromFile failed", e37);
                    }
                }
                if (c16 == null && str4 != null) {
                    try {
                        c16 = BitmapFactory.decodeFile(str4);
                    } catch (OutOfMemoryError e38) {
                        hd0.c.h("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "decode " + str4 + " failed", e38);
                    }
                }
                if (c16 != null) {
                    bitmap2 = com.tencent.biz.qqstory.utils.b.i(bitmap, c16);
                    c16.recycle();
                    bitmap.recycle();
                    bitmap = bitmap2;
                }
                bitmap2 = bitmap;
                if (bitmap2 != null && stringExtra2 != null) {
                    try {
                        decodeFile = BitmapFactory.decodeFile(stringExtra2);
                        if (decodeFile != null && (i3 = com.tencent.biz.qqstory.utils.b.i(bitmap2, decodeFile)) != null) {
                            bitmap2.recycle();
                            decodeFile.recycle();
                            bitmap2 = i3;
                        }
                    } catch (OutOfMemoryError e39) {
                        hd0.c.h("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "decode " + stringExtra2 + " failed", e39);
                    }
                }
                if (bitmap2 != null) {
                    com.tencent.biz.qqstory.utils.d.c(vc0.a.f441365e);
                    boolean b16 = com.tencent.biz.qqstory.utils.b.b(bitmap2, str2);
                    bitmap2.recycle();
                    if (b16) {
                        bVar.f400387d.thumbPath = str2;
                        hd0.c.a("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "merge doodle and thumb image success : " + str2);
                    } else {
                        hd0.c.t("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "merge doodle and thumb image failed");
                    }
                }
                z16 = false;
            }
            c16 = null;
            if (c16 == null) {
                c16 = com.tencent.biz.qqstory.utils.b.t(str3, null);
                hd0.c.v("Q.qqstory.publish.edit.HWEncodeMergeThumbSegment", "unSerializeBitmapFromFile success %s", str3);
            }
            if (c16 == null) {
                c16 = BitmapFactory.decodeFile(str4);
            }
            if (c16 != null) {
            }
            bitmap2 = bitmap;
            if (bitmap2 != null) {
                decodeFile = BitmapFactory.decodeFile(stringExtra2);
                if (decodeFile != null) {
                    bitmap2.recycle();
                    decodeFile.recycle();
                    bitmap2 = i3;
                }
            }
            if (bitmap2 != null) {
            }
            z16 = false;
        }
        if (!z16) {
            super.notifyResult(bVar);
        } else {
            super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.ncy)));
        }
    }
}
