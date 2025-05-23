package com.tencent.biz.subscribe.bizdapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnimationDrawableFactory {

    /* renamed from: b, reason: collision with root package name */
    private static volatile AnimationDrawableFactory f95716b;

    /* renamed from: a, reason: collision with root package name */
    private MQLruCache<String, AnimationDrawable> f95717a = new MQLruCache<>(10);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z16, Drawable drawable);
    }

    AnimationDrawableFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e(File file) {
        QLog.i("AnimationDrawableFactory", 2, "getBitMapFromFile fileName:" + file.getName());
        if (file.exists() && file.isFile()) {
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return null;
    }

    public static AnimationDrawableFactory f() {
        if (f95716b == null) {
            synchronized (AnimationDrawableFactory.class) {
                if (f95716b == null) {
                    f95716b = new AnimationDrawableFactory();
                }
            }
        }
        return f95716b;
    }

    public void c(String str) {
        MQLruCache<String, AnimationDrawable> mQLruCache = this.f95717a;
        if (mQLruCache != null && mQLruCache.get(str) != null) {
            this.f95717a.remove(str);
        }
    }

    @Deprecated
    public void d(final String str, final int i3, final a aVar, final boolean z16) {
        QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + str + " allDuration=" + i3 + " useCache=" + z16);
        if (TextUtils.isEmpty(str)) {
            QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
            if (aVar != null) {
                aVar.a(false, null);
            }
        }
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.1

            /* compiled from: P */
            /* renamed from: com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory$1$a */
            /* loaded from: classes5.dex */
            class a implements Comparator<File> {
                a() {
                }

                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(File file, File file2) {
                    return file.getName().compareToIgnoreCase(file2.getName());
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimationDrawable animationDrawable;
                if (z16 && AnimationDrawableFactory.this.f95717a != null && AnimationDrawableFactory.this.f95717a.get(str) != null) {
                    QLog.i("AnimationDrawableFactory", 2, "animationDrawable use cache" + str);
                    animationDrawable = (AnimationDrawable) AnimationDrawableFactory.this.f95717a.get(str);
                } else {
                    animationDrawable = null;
                }
                if (animationDrawable == null) {
                    File file = new File(str);
                    if (file.exists() && file.isDirectory()) {
                        QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            Arrays.sort(listFiles, new a());
                            int length = i3 / listFiles.length;
                            QLog.i("AnimationDrawableFactory", 2, "createFromDirectory perDuration=" + length);
                            AnimationDrawable animationDrawable2 = new AnimationDrawable();
                            new ArrayList();
                            for (File file2 : listFiles) {
                                try {
                                    Bitmap e16 = AnimationDrawableFactory.this.e(file2);
                                    if (e16 != null) {
                                        animationDrawable2.addFrame(new BitmapDrawable(e16), length);
                                    }
                                    if (AnimationDrawableFactory.this.f95717a != null) {
                                        AnimationDrawableFactory.this.f95717a.put((MQLruCache) str, (String) animationDrawable2);
                                    }
                                } catch (OutOfMemoryError unused) {
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.a(false, null);
                                        QLog.e("AnimationDrawableFactory", 2, "createFromDirectory OutOfMemoryError");
                                        return;
                                    }
                                }
                            }
                            animationDrawable = animationDrawable2;
                        }
                    }
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    if (animationDrawable != null) {
                        aVar3.a(true, animationDrawable);
                    } else {
                        aVar3.a(false, null);
                    }
                }
            }
        });
    }
}
