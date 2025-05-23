package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tribe.async.async.JobContext;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends o<b, b> implements xc0.a {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.lang.Throwable] */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        Bitmap t16;
        boolean z16;
        boolean z17;
        Throwable th5;
        ?? r152;
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        if (publishVideoEntry.thumbPath == null) {
            super.notifyError(new ErrorMessage(-1, "DoodleRotateSegment error, you must merger everything first"));
            return;
        }
        String str = publishVideoEntry.doodleRawPath;
        String str2 = publishVideoEntry.doodlePath;
        if (str2 == null && str == null) {
            super.notifyResult(bVar);
            return;
        }
        int i3 = bVar.f400392i.f400432g;
        int i16 = bVar.f400385b;
        if (i16 != 2 && i16 != 3 && i16 != 5 && i16 != 6) {
            super.notifyResult(bVar);
            return;
        }
        boolean z18 = false;
        BufferedInputStream bufferedInputStream = null;
        if (str != null) {
            try {
                t16 = com.tencent.biz.qqstory.utils.b.t(str, null);
                z16 = true;
            } catch (Throwable th6) {
                hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "unSerializeBitmapFromFile failed", th6);
            }
            if (t16 == null) {
                try {
                    try {
                    } catch (Throwable th7) {
                        th5 = th7;
                        bufferedInputStream = r152;
                    }
                } catch (IOException e16) {
                    hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "close exception", e16);
                }
                if (str2 != null) {
                    try {
                        r152 = new BufferedInputStream(new FileInputStream(str2));
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        r152 = 0;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        r152 = 0;
                    } catch (Throwable th8) {
                        th5 = th8;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                                throw th5;
                            } catch (IOException e19) {
                                hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "close exception", e19);
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                    try {
                        t16 = BitmapFactory.decodeStream(r152);
                        try {
                            r152.close();
                        } catch (IOException e26) {
                            r152 = e26;
                            hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "close exception", r152);
                        }
                    } catch (FileNotFoundException e27) {
                        e = e27;
                        hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "decodeFile FileNotFoundException", e);
                        if (r152 != 0) {
                            r152.close();
                            r152 = r152;
                        }
                        if (t16 == null) {
                        }
                    } catch (OutOfMemoryError e28) {
                        e = e28;
                        hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "decodeFile failed", e);
                        if (r152 != 0) {
                            r152.close();
                            r152 = r152;
                        }
                        if (t16 == null) {
                        }
                    }
                }
            }
            if (t16 == null) {
                int i17 = i3 != 270 ? i3 == 90 ? -90 : 0 : 90;
                if (bVar.f400386c instanceof EditLocalVideoSource) {
                    hd0.c.g("Q.qqstory.publish.edit.DoodleRotateSegment", "doodleBitmap orientation= " + i3 + " mOrientation=0");
                    i17 = 0;
                }
                Bitmap a16 = c.a(t16, i17);
                if (a16 != null) {
                    if (z16) {
                        try {
                            com.tencent.biz.qqstory.utils.b.s(a16, str, null);
                            z17 = true;
                        } catch (IOException e29) {
                            hd0.c.h("Q.qqstory.publish.edit.DoodleRotateSegment", "serializeBitmapToFile failed", e29);
                        }
                        z18 = (!z17 || str2 == null) ? z17 : com.tencent.biz.qqstory.utils.b.a(a16, Bitmap.CompressFormat.PNG, 60, str2);
                        a16.recycle();
                    }
                    z17 = false;
                    if (z17) {
                    }
                    a16.recycle();
                }
                if (a16 != null && !z18) {
                    super.notifyError(new ErrorMessage(-1, "bitmap compress failed"));
                    return;
                } else {
                    super.notifyResult(bVar);
                    return;
                }
            }
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.DoodleRotateSegment", 6));
            return;
        }
        z16 = false;
        t16 = null;
        if (t16 == null) {
        }
        if (t16 == null) {
        }
    }
}
