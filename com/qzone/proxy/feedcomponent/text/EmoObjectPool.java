package com.qzone.proxy.feedcomponent.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.qzone.widget.x;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.libra.LoadState;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.raft.codegenmeta.utils.RLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes39.dex */
public class EmoObjectPool {

    /* renamed from: e, reason: collision with root package name */
    private static EmoObjectPool f50528e;

    /* renamed from: d, reason: collision with root package name */
    private static int f50527d = ViewUtils.dip2px(5.0f);

    /* renamed from: f, reason: collision with root package name */
    private static Object f50529f = new Object();

    /* renamed from: c, reason: collision with root package name */
    private Handler f50532c = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, SparseArray<SoftReference<EmoCell>>> f50531b = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<Drawable> f50530a = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        private int f50549d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<TextLayoutBase> f50550e;

        /* renamed from: f, reason: collision with root package name */
        private com.qzone.proxy.feedcomponent.text.font.a f50551f;

        public b(int i3, TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
            this.f50549d = i3;
            this.f50550e = new WeakReference<>(textLayoutBase);
            this.f50551f = aVar;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState != LoadState.STATE_SUCCESS) {
                return;
            }
            Map<String, Object> extraData = option.getExtraData();
            Bitmap resultBitMap = option.getResultBitMap();
            Animatable animatable = (!loadState.isFinishSuccess() || option.getAnimatable() == null) ? null : option.getAnimatable();
            Object obj = extraData.get("cell");
            WeakReference<TextLayoutBase> weakReference = this.f50550e;
            if (weakReference == null) {
                return;
            }
            TextLayoutBase textLayoutBase = weakReference.get();
            if (resultBitMap != null && (obj instanceof EmoCell) && textLayoutBase != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), option.getResultBitMap());
                EmoCell emoCell = (EmoCell) obj;
                EmoObjectPool.r(bitmapDrawable, this.f50549d);
                emoCell.emoDrawable = bitmapDrawable;
                emoCell.isDrawableLoaded = true;
                if (bitmapDrawable.getBounds().width() != this.f50549d) {
                    textLayoutBase.postRequestLayout();
                    textLayoutBase.postInvalidate();
                } else {
                    textLayoutBase.postInvalidate();
                }
            } else if (animatable != null && (obj instanceof EmoCell) && textLayoutBase != null && (animatable instanceof GifDrawable)) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(BaseApplication.getContext().getResources(), ((GifDrawable) animatable).b());
                EmoCell emoCell2 = (EmoCell) obj;
                EmoObjectPool.r(bitmapDrawable2, this.f50549d);
                emoCell2.emoDrawable = bitmapDrawable2;
                emoCell2.isDrawableLoaded = true;
                if (bitmapDrawable2.getBounds().width() != this.f50549d) {
                    textLayoutBase.postRequestLayout();
                    textLayoutBase.postInvalidate();
                } else {
                    textLayoutBase.postInvalidate();
                }
            }
            com.qzone.proxy.feedcomponent.text.font.a aVar = this.f50551f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class c implements TextUtils.LoadSysEmojiCallback {

        /* renamed from: a, reason: collision with root package name */
        private SystemEmoCell f50553a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<TextLayoutBase> f50554b;

        /* renamed from: c, reason: collision with root package name */
        private com.qzone.proxy.feedcomponent.text.font.a f50555c;

        public c(TextLayoutBase textLayoutBase, SystemEmoCell systemEmoCell, com.qzone.proxy.feedcomponent.text.font.a aVar) {
            this.f50553a = systemEmoCell;
            this.f50554b = new WeakReference<>(textLayoutBase);
            this.f50555c = aVar;
        }

        @Override // com.tencent.mobileqq.text.TextUtils.LoadSysEmojiCallback
        public void callbackWhenSysEmojiLoaded(Drawable drawable) {
            SystemEmoCell systemEmoCell = this.f50553a;
            if (systemEmoCell != null && drawable != null) {
                systemEmoCell.isDrawableLoaded = true;
                systemEmoCell.emoDrawable = drawable;
                EmoObjectPool.r(drawable, systemEmoCell.mHeight);
                WeakReference<TextLayoutBase> weakReference = this.f50554b;
                if (weakReference == null) {
                    return;
                }
                TextLayoutBase textLayoutBase = weakReference.get();
                if (textLayoutBase != null) {
                    if (drawable.getBounds().width() != this.f50553a.mWidth) {
                        textLayoutBase.postRequestLayout();
                        textLayoutBase.postInvalidate();
                    } else {
                        textLayoutBase.postInvalidate();
                    }
                }
            }
            com.qzone.proxy.feedcomponent.text.font.a aVar = this.f50555c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    EmoObjectPool() {
    }

    private synchronized Drawable c(int i3) {
        Drawable drawable = this.f50530a.get(i3);
        if (drawable == null) {
            try {
                drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.f162386o04);
                if (drawable == null) {
                    return new ColorDrawable(Color.parseColor("#e8e8e8"));
                }
                drawable.setBounds(0, 0, i3, i3);
                this.f50530a.put(i3, drawable);
            } catch (Exception unused) {
                return new ColorDrawable(Color.parseColor("#e8e8e8"));
            }
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Drawable d(String str, Resources resources) {
        try {
            return resources.getDrawable(i(str));
        } catch (Throwable th5) {
            QZLog.e(RLog.ERROR, "PICTURE NOT\u3000FOUND\uff01", th5);
            return null;
        }
    }

    public static EmoObjectPool f() {
        if (f50528e == null) {
            synchronized (f50529f) {
                if (f50528e == null) {
                    f50528e = new EmoObjectPool();
                }
            }
        }
        return f50528e;
    }

    private static String g(String str) {
        int indexOf = str.indexOf("[dra]") + 5;
        int indexOf2 = str.indexOf("[/dra]");
        if (indexOf == -1 || indexOf2 == -1) {
            return null;
        }
        return str.substring(indexOf, indexOf2);
    }

    private static int i(String str) {
        if (android.text.TextUtils.isEmpty(str) || !str.equals("qzone_famous_icon")) {
            return 0;
        }
        return R.drawable.qzone_famous_icon;
    }

    public static int k(String str) {
        int codePointAt;
        int i3;
        int doubleEmoji;
        if (!android.text.TextUtils.isEmpty(str)) {
            int length = str.length();
            int length2 = str.length();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            for (int i16 = 0; i16 < length; i16++) {
                int codePointAt2 = sb5.codePointAt(i16);
                int singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt2);
                if (codePointAt2 > 65535) {
                    int i17 = i16 + 2;
                    if (length2 > i17) {
                        codePointAt = sb5.codePointAt(i17);
                    }
                    codePointAt = -1;
                } else {
                    int i18 = i16 + 1;
                    if (length2 > i18) {
                        codePointAt = sb5.codePointAt(i18);
                        if (codePointAt == 65039 && length2 > (i3 = i16 + 2)) {
                            codePointAt = sb5.codePointAt(i3);
                        }
                    }
                    codePointAt = -1;
                }
                boolean isSkinEmoji = EmotcationConstants.isSkinEmoji(codePointAt);
                if ((singleEmoji == -1 || isSkinEmoji) && (doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt)) != -1) {
                    singleEmoji = doubleEmoji;
                }
                if (singleEmoji != -1) {
                    return singleEmoji;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(EmoCell emoCell, String str, int i3, TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        String str2;
        Drawable loadImage;
        if (QQSysFaceUtil.getLocalIdFromEMCode(str) != -1) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.obj = emoCell;
            obtain.useMainThread = true;
            obtain.disableHitRateReport = true;
            m(QQSysFaceUtil.getLocalIdFromEMCode(str), 1, new a(i3, textLayoutBase, aVar), obtain);
        } else if (QQEmojiUtil.getLocalIdFromEMCode(str) != -1) {
            ImageLoader.Options obtain2 = ImageLoader.Options.obtain();
            obtain2.obj = emoCell;
            obtain2.useMainThread = true;
            obtain2.disableHitRateReport = true;
            m(QQEmojiUtil.getLocalIdFromEMCode(str), 2, new a(i3, textLayoutBase, aVar), obtain2);
        } else if (str.startsWith("[dra]")) {
            ImageLoader.Options obtain3 = ImageLoader.Options.obtain();
            obtain3.obj = emoCell;
            obtain3.useMainThread = true;
            obtain3.disableHitRateReport = true;
            n(g(str), i3, new a(i3, textLayoutBase, aVar), obtain3);
        } else {
            int indexOf = str.indexOf(QzoneEmotionUtils.EMO_PREFIX) + 4;
            int indexOf2 = str.indexOf(QzoneEmotionUtils.EMO_TAIL);
            if (indexOf == -1 || indexOf2 == -1) {
                return;
            }
            String substring = str.substring(indexOf, indexOf2);
            try {
                str2 = QzoneEmotionUtils.getEmoUrlFromConfig(substring);
            } catch (Exception unused) {
                str2 = QzoneEmotionUtils.SIGN_ICON_URL_PREFIX + substring + QzoneEmotionUtils.SIGN_ICON_URL_END;
            }
            if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                HashMap hashMap = new HashMap();
                hashMap.put("cell", emoCell);
                com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str2).setExtraData(hashMap), new b(i3, textLayoutBase, aVar));
            } else {
                ImageLoader.Options obtain4 = ImageLoader.Options.obtain();
                obtain4.obj = emoCell;
                obtain4.useMainThread = true;
                obtain4.disableHitRateReport = true;
                obtain4.type = "qzEmod";
                loadImage = ImageLoader.getInstance().loadImage(str2, new a(i3, textLayoutBase, aVar), obtain4);
                if (loadImage == null) {
                    r(loadImage, i3);
                    emoCell.emoDrawable = loadImage;
                    emoCell.isDrawableLoaded = true;
                    return;
                }
                return;
            }
        }
        loadImage = null;
        if (loadImage == null) {
        }
    }

    private void m(final int i3, final int i16, final ImageLoader.ImageLoadListener imageLoadListener, final ImageLoader.Options options) {
        PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: com.qzone.proxy.feedcomponent.text.EmoObjectPool.1
            @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
            public Object run(ThreadPool.JobContext jobContext) {
                final Drawable emojiDrawable;
                ImageLoader.ImageLoadListener imageLoadListener2;
                if (imageLoadListener == null) {
                    return null;
                }
                if (i16 == 1) {
                    emojiDrawable = QQSysFaceUtil.getFaceDrawable(i3);
                } else {
                    emojiDrawable = QQEmojiUtil.getEmojiDrawable(i3);
                }
                if (emojiDrawable != null) {
                    ImageLoader.Options options2 = options;
                    if (!options2.useMainThread && (imageLoadListener2 = imageLoadListener) != null) {
                        imageLoadListener2.onImageLoaded(null, emojiDrawable, options2);
                    } else {
                        EmoObjectPool.this.f50532c.post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.EmoObjectPool.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                ImageLoader.ImageLoadListener imageLoadListener3 = imageLoadListener;
                                if (imageLoadListener3 != null) {
                                    imageLoadListener3.onImageLoaded(null, emojiDrawable, options);
                                }
                            }
                        });
                    }
                }
                return null;
            }
        }, PriorityThreadPool.Priority.HIGH);
    }

    private void n(final String str, int i3, final ImageLoader.ImageLoadListener imageLoadListener, final ImageLoader.Options options) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.EmoObjectPool.2
            @Override // java.lang.Runnable
            public void run() {
                final Drawable d16 = EmoObjectPool.d(str, BaseApplication.getContext().getResources());
                if (d16 != null) {
                    ImageLoader.Options options2 = options;
                    if (!options2.useMainThread) {
                        imageLoadListener.onImageLoaded("", d16, options2);
                    } else {
                        EmoObjectPool.this.f50532c.post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.EmoObjectPool.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                imageLoadListener.onImageLoaded("", d16, options);
                            }
                        });
                    }
                }
            }
        });
    }

    public EmoCell e(String str, int i3, TextLayoutBase textLayoutBase) {
        SparseArray<SoftReference<EmoCell>> sparseArray = this.f50531b.get(str);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        Drawable c16 = c(i3);
        SoftReference<EmoCell> softReference = sparseArray.get(i3);
        if (softReference != null) {
            EmoCell emoCell = softReference.get();
            if (emoCell != null && emoCell.emoDrawable.getBounds().isEmpty()) {
                r(emoCell.emoDrawable, i3);
            }
            if (emoCell != null && emoCell.emoDrawable == c16) {
                emoCell.isDrawableLoaded = false;
                l(emoCell, str, i3, textLayoutBase, null);
            }
        }
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        EmoCell emoCell2 = new EmoCell(str, c16);
        if (emoCell2.emoDrawable.getBounds().isEmpty()) {
            r(emoCell2.emoDrawable, i3);
        }
        emoCell2.isDrawableLoaded = false;
        l(emoCell2, str, i3, textLayoutBase, null);
        sparseArray.put(i3, new SoftReference<>(emoCell2));
        this.f50531b.put(str, sparseArray);
        return emoCell2;
    }

    public NetImageCell h(String str, int i3, TextLayoutBase textLayoutBase) {
        Drawable colorDrawable;
        NetImageCell l3 = x.l(str);
        try {
            colorDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.f162386o04);
        } catch (Exception unused) {
            colorDrawable = new ColorDrawable(Color.parseColor("#e8e8e8"));
        }
        if (colorDrawable == null) {
            colorDrawable = new ColorDrawable(Color.parseColor("#e8e8e8"));
        }
        l3.emoDrawable = colorDrawable;
        l3.emoCode = str;
        int i16 = l3.mHeight;
        if (i16 != 0) {
            i3 = i16;
        }
        int i17 = l3.mWidth;
        int i18 = ((i17 <= 0 || i16 <= 0) ? i3 : (int) ((i3 * i17) / i16)) + f50527d;
        l3.mWidth = i18;
        l3.mHeight = i3;
        colorDrawable.setBounds(0, 0, i18, i3);
        p(l3, textLayoutBase, null);
        return l3;
    }

    public SystemEmoCell j(String str, int i3, TextLayoutBase textLayoutBase) {
        SystemEmoCell systemEmoCell = new SystemEmoCell(str, i3);
        systemEmoCell.isDrawableLoaded = false;
        q(systemEmoCell, textLayoutBase, null);
        return systemEmoCell;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private int f50545d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<TextLayoutBase> f50546e;

        /* renamed from: f, reason: collision with root package name */
        private com.qzone.proxy.feedcomponent.text.font.a f50547f;

        public a(int i3, TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
            this.f50545d = i3;
            this.f50546e = new WeakReference<>(textLayoutBase);
            this.f50547f = aVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            if (options == null || (obj = options.obj) == null) {
                return;
            }
            EmoCell emoCell = (EmoCell) obj;
            if (drawable != null) {
                Drawable newDrawable = drawable instanceof BitmapRefDrawable ? ((BitmapRefDrawable) drawable).newDrawable() : drawable;
                EmoObjectPool.r(newDrawable, this.f50545d);
                emoCell.emoDrawable = newDrawable;
                emoCell.isDrawableLoaded = true;
                WeakReference<TextLayoutBase> weakReference = this.f50546e;
                if (weakReference == null) {
                    return;
                }
                TextLayoutBase textLayoutBase = weakReference.get();
                if (textLayoutBase != null) {
                    if (drawable.getBounds().width() != this.f50545d) {
                        textLayoutBase.postRequestLayout();
                        textLayoutBase.postInvalidate();
                    } else {
                        textLayoutBase.postInvalidate();
                    }
                }
            }
            com.qzone.proxy.feedcomponent.text.font.a aVar = this.f50547f;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public void o(EmoCell emoCell, TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        if (emoCell == null) {
            return;
        }
        if (emoCell instanceof NetImageCell) {
            p((NetImageCell) emoCell, textLayoutBase, aVar);
            return;
        }
        int width = (int) emoCell.getWidth(null);
        if (emoCell.emoDrawable == c(width)) {
            l(emoCell, emoCell.emoCode, width, textLayoutBase, aVar);
        }
    }

    public void p(NetImageCell netImageCell, TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        Drawable loadImage;
        if (netImageCell == null) {
            return;
        }
        if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("cell", netImageCell);
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(netImageCell.emoUrl).setExtraData(hashMap), new b(netImageCell.mHeight, textLayoutBase, aVar));
            loadImage = null;
        } else {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.obj = netImageCell;
            obtain.useMainThread = true;
            obtain.type = "qzEmod";
            obtain.disableHitRateReport = true;
            loadImage = ImageLoader.getInstance().loadImage(netImageCell.emoUrl, new a(netImageCell.mHeight, textLayoutBase, aVar), obtain);
        }
        if (loadImage != null) {
            netImageCell.isDrawableLoaded = true;
            if (loadImage instanceof BitmapRefDrawable) {
                loadImage = ((BitmapRefDrawable) loadImage).newDrawable();
            }
            netImageCell.emoDrawable = loadImage;
            r(loadImage, netImageCell.mHeight);
            netImageCell.mWidth = netImageCell.emoDrawable.getBounds().width();
            return;
        }
        netImageCell.isDrawableLoaded = false;
    }

    public void q(SystemEmoCell systemEmoCell, TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        Drawable emojiDrawable;
        if (systemEmoCell == null) {
            return;
        }
        int k3 = k(systemEmoCell.text);
        if (k3 >= 0 && (emojiDrawable = TextUtils.getEmojiDrawable(k3, new c(textLayoutBase, systemEmoCell, aVar))) != null) {
            systemEmoCell.isDrawableLoaded = true;
            systemEmoCell.emoDrawable = emojiDrawable;
            r(emojiDrawable, systemEmoCell.mHeight);
            systemEmoCell.mWidth = emojiDrawable.getBounds().width();
            return;
        }
        systemEmoCell.isDrawableLoaded = false;
    }

    protected static Drawable r(Drawable drawable, int i3) {
        if (drawable != null && i3 != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i16 = (intrinsicWidth <= 0 || intrinsicHeight <= 0) ? i3 : (int) ((i3 * intrinsicWidth) / intrinsicHeight);
            Drawable.Callback callback = drawable.getCallback();
            drawable.setCallback(null);
            drawable.setBounds(0, 0, i16, i3);
            drawable.setCallback(callback);
        }
        return drawable;
    }
}
