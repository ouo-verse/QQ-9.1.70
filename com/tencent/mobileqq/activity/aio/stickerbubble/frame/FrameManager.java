package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.activity.aio.stickerbubble.frame.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FrameManager {

    /* renamed from: a, reason: collision with root package name */
    private Context f179879a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, BitmapDrawable[]> f179880b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Integer> f179881c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f179882d = new HashSet();

    public FrameManager(Context context, Map map, Map map2) {
        this.f179879a = context;
        this.f179880b = map;
        this.f179881c = map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d i(String str) {
        try {
            if (str.startsWith("id_")) {
                return new e(Integer.valueOf(str.substring(3)).intValue());
            }
            File file = new File(str);
            if (!file.exists()) {
                QLog.e("StickerBubble_FrameDecode", 1, "gifFile " + str + " is not exist");
                return null;
            }
            String[] split = file.getName().split("\\.");
            if (split[split.length - 1].equals("gif")) {
                return new c(file, false);
            }
            if (!ApngDrawable.isApngFile(file)) {
                return null;
            }
            return new a(file);
        } catch (Exception e16) {
            QLog.e("StickerBubble_FrameDecode", 1, "init frameDecoder failed ", e16);
            return null;
        }
    }

    private void j(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d i3 = FrameManager.this.i(str);
                    if (i3 == null) {
                        return;
                    }
                    FrameManager.this.f179881c.put(str, Integer.valueOf(i3.getFrameDelay()));
                    BitmapDrawable[] bitmapDrawableArr = new BitmapDrawable[i3.getFrameCount()];
                    Bitmap k3 = FrameManager.this.k(i3.a(), 0.7d);
                    if (k3 == null) {
                        k3 = i3.a();
                    }
                    bitmapDrawableArr[0] = new BitmapDrawable(FrameManager.this.f179879a.getResources(), k3);
                    FrameManager.this.l(i3, bitmapDrawableArr, str, i3.getFrameDelay());
                    FrameManager.this.f179880b.put(str, bitmapDrawableArr);
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerBubble_FrameDecode", 2, "decoded first frame of gif: " + str);
                    }
                } catch (OutOfMemoryError e16) {
                    QLog.e("StickerBubble_FrameDecode", 1, "oom when decode gif or scale first frame, " + e16);
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Bitmap k(@NonNull Bitmap bitmap, double d16) {
        double d17 = (d16 * this.f179879a.getResources().getDisplayMetrics().density) / 2.75d;
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * d17), (int) (bitmap.getHeight() * d17), true);
        } catch (OutOfMemoryError unused) {
            QLog.e("StickerBubble_FrameDecode", 1, "oom when scale bitmap");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final d dVar, final BitmapDrawable[] bitmapDrawableArr, final String str, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager.2
            @Override // java.lang.Runnable
            public void run() {
                BitmapDrawable[] bitmapDrawableArr2;
                BitmapDrawable bitmapDrawable;
                boolean z16 = false;
                int i16 = 1;
                while (true) {
                    bitmapDrawableArr2 = bitmapDrawableArr;
                    if (i16 >= bitmapDrawableArr2.length) {
                        break;
                    }
                    dVar.b();
                    Bitmap k3 = FrameManager.this.k(dVar.a(), 0.7d);
                    BitmapDrawable[] bitmapDrawableArr3 = bitmapDrawableArr;
                    if (k3 != null) {
                        bitmapDrawable = new BitmapDrawable(FrameManager.this.f179879a.getResources(), k3);
                    } else {
                        bitmapDrawable = null;
                    }
                    bitmapDrawableArr3[i16] = bitmapDrawable;
                    if (i16 != dVar.getCurrentFrameIndex()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("StickerBubble_FrameDecode", 2, "decode gif, i: ", Integer.valueOf(i16), " index: ", Integer.valueOf(dVar.getCurrentFrameIndex()), " len: ", Integer.valueOf(bitmapDrawableArr.length), " path: ", str);
                    }
                    i16++;
                }
                if (!z16) {
                    b.d(str, bitmapDrawableArr2, i3);
                }
                dVar.complete();
            }
        }, 64, null, true);
    }

    public void g(Set<String> set) {
        for (String str : set) {
            if (!this.f179880b.containsKey(str)) {
                b.a a16 = b.a(str);
                if (a16 != null) {
                    this.f179880b.put(str, a16.c());
                    this.f179881c.put(str, Integer.valueOf(a16.b()));
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerBubble_FrameDecode", 2, "get frames from cache");
                    }
                } else if (!this.f179882d.contains(str)) {
                    this.f179882d.add(str);
                    j(str);
                }
            }
        }
    }

    public void h() {
        this.f179880b.clear();
        this.f179881c.clear();
        this.f179882d.clear();
    }
}
