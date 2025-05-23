package com.tencent.mobileqq.vas.pendant.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback;
import com.tencent.mobileqq.vas.pendant.api.IMaskDownloadDispatch;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.api.VasMaskDownloadCallback;
import com.tencent.mobileqq.vas.pendant.api.impl.SpecialShapeAvatarMaskLayerImpl;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.AvatarMaskBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0016J2\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\"\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016RC\u0010'\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0!0 j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0!`\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&RW\u0010,\u001a>\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0(j\b\u0012\u0004\u0012\u00020\u001c`)0 j\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0(j\b\u0012\u0004\u0012\u00020\u001c`)`\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/RP\u00100\u001a>\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180(j\b\u0012\u0004\u0012\u00020\u0018`)0 j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180(j\b\u0012\u0004\u0012\u00020\u0018`)`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R0\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/impl/SpecialShapeAvatarMaskLayerImpl;", "Lcom/tencent/mobileqq/vas/pendant/api/ISpecialShapeAvatarMaskLayer;", "Lcom/tencent/mobileqq/vas/pendant/api/IMaskDownloadDispatch;", "", "specialShapeMaskId", "", "w", h.F, "", "key", "Landroid/graphics/Bitmap;", "bm", "newWidth", "newHeight", "zoomImg", "", "isSupportSpecialShapeMask", "uin", "isSpecialShapeAvatar", "Landroid/content/Context;", "context", "sizeW", "sizeH", "getMaskLayer", "Lcom/tencent/mobileqq/vas/pendant/api/ILoadResultCallback;", "resultCallback", "", "startLoadLayer", "Lcom/tencent/mobileqq/vas/pendant/api/VasMaskDownloadCallback;", "callback", "registerDispatchCallback", "unregisterDispatchCallback", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "maskMap$delegate", "Lkotlin/Lazy;", "getMaskMap", "()Ljava/util/HashMap;", "maskMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "maskDownloadCallbackMap$delegate", "getMaskDownloadCallbackMap", "maskDownloadCallbackMap", "", "taskLock", "Ljava/lang/Object;", "downloadResultCallbackMap", "Ljava/util/HashMap;", "downloadFailIdMap", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class SpecialShapeAvatarMaskLayerImpl implements ISpecialShapeAvatarMaskLayer, IMaskDownloadDispatch {
    private static final int MAX_DOWNLOAD_FAIL_COUNT = 3;

    @NotNull
    private static final String TAG = "SpecialShapeAvatarMaskLayerImpl";
    private static final float headRatio = 1.0f;

    @NotNull
    private static final Lazy<Boolean> isAvatarSpecialShape$delegate;

    @NotNull
    private final HashMap<Integer, Integer> downloadFailIdMap;

    @NotNull
    private final HashMap<Integer, ArrayList<ILoadResultCallback>> downloadResultCallbackMap;

    /* renamed from: maskDownloadCallbackMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy maskDownloadCallbackMap;

    /* renamed from: maskMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy maskMap;

    @NotNull
    private final Object taskLock;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/impl/SpecialShapeAvatarMaskLayerImpl$a;", "", "", "b", "isAvatarSpecialShape$delegate", "Lkotlin/Lazy;", "a", "()Z", "isAvatarSpecialShape", "", "MAX_DOWNLOAD_FAIL_COUNT", "I", "", "TAG", "Ljava/lang/String;", "", "headRatio", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.pendant.api.impl.SpecialShapeAvatarMaskLayerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean a() {
            return ((Boolean) SpecialShapeAvatarMaskLayerImpl.isAvatarSpecialShape$delegate.getValue()).booleanValue();
        }

        public final boolean b() {
            if (!SimpleUIUtil.isNowSimpleMode() && a()) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/pendant/api/impl/SpecialShapeAvatarMaskLayerImpl$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f310435b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f310436c;

        b(int i3, String str) {
            this.f310435b = i3;
            this.f310436c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ArrayList list) {
            Intrinsics.checkNotNullParameter(list, "$list");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ILoadResultCallback) it.next()).onSuccess();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(SpecialShapeAvatarMaskLayerImpl this$0, String uin) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(uin, "$uin");
            ArrayList arrayList = (ArrayList) this$0.getMaskDownloadCallbackMap().get(uin);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((VasMaskDownloadCallback) it.next()).dispatch(uin);
                }
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            Object obj = SpecialShapeAvatarMaskLayerImpl.this.taskLock;
            SpecialShapeAvatarMaskLayerImpl specialShapeAvatarMaskLayerImpl = SpecialShapeAvatarMaskLayerImpl.this;
            int i3 = this.f310435b;
            synchronized (obj) {
                HashMap hashMap = specialShapeAvatarMaskLayerImpl.downloadFailIdMap;
                Integer valueOf = Integer.valueOf(i3);
                Integer num = (Integer) specialShapeAvatarMaskLayerImpl.downloadFailIdMap.get(Integer.valueOf(i3));
                if (num == null) {
                    num = 0;
                }
                hashMap.put(valueOf, Integer.valueOf(num.intValue() + 1));
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            Object obj = SpecialShapeAvatarMaskLayerImpl.this.taskLock;
            SpecialShapeAvatarMaskLayerImpl specialShapeAvatarMaskLayerImpl = SpecialShapeAvatarMaskLayerImpl.this;
            int i3 = this.f310435b;
            synchronized (obj) {
                final ArrayList arrayList = (ArrayList) specialShapeAvatarMaskLayerImpl.downloadResultCallbackMap.remove(Integer.valueOf(i3));
                if (arrayList != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            SpecialShapeAvatarMaskLayerImpl.b.c(arrayList);
                        }
                    });
                }
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final SpecialShapeAvatarMaskLayerImpl specialShapeAvatarMaskLayerImpl2 = SpecialShapeAvatarMaskLayerImpl.this;
            final String str = this.f310436c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    SpecialShapeAvatarMaskLayerImpl.b.d(SpecialShapeAvatarMaskLayerImpl.this, str);
                }
            });
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.SpecialShapeAvatarMaskLayerImpl$Companion$isAvatarSpecialShape$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(VasLongToggle.AVATAR_SPECIAL_SHAPE.isEnable(true));
            }
        });
        isAvatarSpecialShape$delegate = lazy;
    }

    public SpecialShapeAvatarMaskLayerImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, WeakReference<Bitmap>>>() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.SpecialShapeAvatarMaskLayerImpl$maskMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, WeakReference<Bitmap>> invoke() {
                return new HashMap<>();
            }
        });
        this.maskMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, ArrayList<VasMaskDownloadCallback>>>() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.SpecialShapeAvatarMaskLayerImpl$maskDownloadCallbackMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, ArrayList<VasMaskDownloadCallback>> invoke() {
                return new HashMap<>();
            }
        });
        this.maskDownloadCallbackMap = lazy2;
        this.taskLock = new Object();
        this.downloadResultCallbackMap = new HashMap<>();
        this.downloadFailIdMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, ArrayList<VasMaskDownloadCallback>> getMaskDownloadCallbackMap() {
        return (HashMap) this.maskDownloadCallbackMap.getValue();
    }

    private final HashMap<String, WeakReference<Bitmap>> getMaskMap() {
        return (HashMap) this.maskMap.getValue();
    }

    private final String key(int specialShapeMaskId, float w3, float h16) {
        return specialShapeMaskId + "_" + w3 + "_" + h16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLoadLayer$lambda$6(SpecialShapeAvatarMaskLayerImpl this$0, int i3, ILoadResultCallback iLoadResultCallback, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        synchronized (this$0.taskLock) {
            Integer it = this$0.downloadFailIdMap.get(Integer.valueOf(i3));
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.intValue() >= 3) {
                    return;
                }
            }
            if (iLoadResultCallback != null) {
                ArrayList<ILoadResultCallback> arrayList = this$0.downloadResultCallbackMap.get(Integer.valueOf(i3));
                if (arrayList == null) {
                    ArrayList<ILoadResultCallback> arrayList2 = new ArrayList<>();
                    arrayList2.add(iLoadResultCallback);
                    this$0.downloadResultCallbackMap.put(Integer.valueOf(i3), arrayList2);
                } else {
                    arrayList.add(iLoadResultCallback);
                    this$0.downloadResultCallbackMap.put(Integer.valueOf(i3), arrayList);
                    return;
                }
            }
            QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 333L);
            if (businessInstance.isFileExists(i3)) {
                ArrayList<ILoadResultCallback> remove = this$0.downloadResultCallbackMap.remove(Integer.valueOf(i3));
                if (remove != null) {
                    Intrinsics.checkNotNullExpressionValue(remove, "remove(specialShapeMaskId)");
                    Iterator<T> it5 = remove.iterator();
                    while (it5.hasNext()) {
                        ((ILoadResultCallback) it5.next()).onSuccess();
                    }
                }
                return;
            }
            businessInstance.addDownLoadListener(i3, new b(i3, uin));
            businessInstance.startDownload(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Bitmap zoomImg(Bitmap bm5, int newWidth, int newHeight) {
        int width = bm5.getWidth();
        int height = bm5.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((newWidth * 1.0f) / width, (newHeight * 1.0f) / height);
        Bitmap createBitmap = Bitmap.createBitmap(bm5, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bm, 0, 0, w\u2026th, height, matrix, true)");
        return createBitmap;
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer
    @Nullable
    public Bitmap getMaskLayer(@NotNull Context context, @NotNull String uin, int specialShapeMaskId, int sizeW, int sizeH) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Bitmap bitmap = null;
        if (!isSupportSpecialShapeMask() || sizeW <= 0 || sizeH <= 0) {
            return null;
        }
        float f16 = sizeW * 1.0f;
        float f17 = sizeH * 1.0f;
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            WeakReference<Bitmap> weakReference = getMaskMap().get(key(specialShapeMaskId, f16, f17));
            if (weakReference != null) {
                bitmap = weakReference.get();
            }
            Unit unit = Unit.INSTANCE;
            if (bitmap == null) {
                String maskPath = ((AvatarMaskBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(AvatarMaskBusiness.class)).getMaskPath(specialShapeMaskId);
                if (new File(maskPath).exists()) {
                    bitmap = BitmapFactory.decodeFile(maskPath);
                    int i16 = (int) f16;
                    if (bitmap.getWidth() != i16 || bitmap.getHeight() != ((int) f17)) {
                        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                        bitmap = zoomImg(bitmap, i16, (int) f17);
                    }
                    ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
                    int i17 = 0;
                    if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                        i3 = reentrantReadWriteLock.getReadHoldCount();
                    } else {
                        i3 = 0;
                    }
                    for (int i18 = 0; i18 < i3; i18++) {
                        readLock2.unlock();
                    }
                    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                    writeLock.lock();
                    try {
                        getMaskMap().put(key(specialShapeMaskId, f16, f17), new WeakReference<>(bitmap));
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                        while (i17 < i3) {
                            readLock2.lock();
                            i17++;
                        }
                        writeLock.unlock();
                    }
                }
            }
            return bitmap;
        } finally {
            readLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer
    public boolean isSpecialShapeAvatar(@NotNull String uin) {
        long j3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        try {
            j3 = Long.parseLong(uin);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "uin is invalid, uin: " + uin, e16);
            j3 = 0L;
        }
        if (j3 <= 0) {
            return false;
        }
        IVipDataUtils iVipDataUtils = (IVipDataUtils) QRoute.api(IVipDataUtils.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        VipData vipDataForFriends = iVipDataUtils.getVipDataForFriends(sb5.toString());
        if (isSupportSpecialShapeMask() && vipDataForFriends.getSpecialAvatarId() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer
    public boolean isSupportSpecialShapeMask() {
        return INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IMaskDownloadDispatch
    public void registerDispatchCallback(@NotNull String uin, @Nullable VasMaskDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (callback == null) {
            return;
        }
        ArrayList<VasMaskDownloadCallback> arrayList = getMaskDownloadCallbackMap().get(uin);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            arrayList.add(callback);
        } else if (arrayList.contains(callback)) {
            return;
        } else {
            arrayList.add(callback);
        }
        getMaskDownloadCallbackMap().put(uin, arrayList);
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer
    public void startLoadLayer(@NotNull final String uin, final int specialShapeMaskId, @Nullable final ILoadResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!isSupportSpecialShapeMask()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                SpecialShapeAvatarMaskLayerImpl.startLoadLayer$lambda$6(SpecialShapeAvatarMaskLayerImpl.this, specialShapeMaskId, resultCallback, uin);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IMaskDownloadDispatch
    public void unregisterDispatchCallback(@NotNull String uin, @Nullable VasMaskDownloadCallback callback) {
        ArrayList<VasMaskDownloadCallback> arrayList;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (callback == null || (arrayList = getMaskDownloadCallbackMap().get(uin)) == null) {
            return;
        }
        arrayList.remove(callback);
    }
}
