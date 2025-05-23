package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.avatar.meta.MetaResourceFetcher;
import com.tencent.qqnt.avatar.meta.b;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b2\u00103J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J4\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016JL\u0010\u0018\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u001d\u001a\u00020\u00112\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bH\u0016J2\u0010!\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016JR\u0010&\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0011H\u0016J\u0014\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010*\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020+H\u0016R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/app/face/ProAvatarFaceDecoderImpl;", "Lcom/tencent/mobileqq/app/face/FaceDecoderBase;", "Lcom/tencent/qqnt/avatar/meta/refresh/b;", "", "headType", "", "uin", "sizeType", "", "shape", "Lcom/tencent/qqnt/avatar/meta/b;", "c", "", "runNextTask", "idType", "Landroid/graphics/Bitmap;", "getBitmapFromCache", "", "smartMode", "appendToTail", "level", "shapeType", "LAvatarInfo/QQHeadInfo;", "info", "requestDecodeFaceWithFaceInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/util/HeadRequest;", "Lkotlin/collections/ArrayList;", "requestList", "preloadFacesWithFaceInfo", "id", "", "timestamp", "refreshFaceWithTimeStamp", "Lcom/tencent/common/app/AppInterface;", "app", "setAppRuntime", "isDynamicMode", "requestDecodeFace", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/drawable/Drawable;", "getFaceDrawableByBitmap", "destory", "Lcom/tencent/qqnt/avatar/meta/refresh/bean/a;", "refreshInfo", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "loadAvatarBeanSet", "<init>", "()V", "e", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ProAvatarFaceDecoderImpl extends FaceDecoderBase implements com.tencent.qqnt.avatar.meta.refresh.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Handler f195548f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, com.tencent.qqnt.avatar.meta.b> loadAvatarBeanSet;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/face/ProAvatarFaceDecoderImpl$a;", "", "Lkotlin/Function0;", "", "block", "b", "", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "uiHandler", "Landroid/os/Handler;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        public final void b(@NotNull final Function0<Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) block);
                return;
            }
            Intrinsics.checkNotNullParameter(block, "block");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                block.invoke();
            } else {
                ProAvatarFaceDecoderImpl.f195548f.post(new Runnable() { // from class: com.tencent.mobileqq.app.face.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProAvatarFaceDecoderImpl.Companion.c(Function0.this);
                    }
                });
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
            f195548f = new Handler(Looper.getMainLooper());
        }
    }

    public ProAvatarFaceDecoderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.loadAvatarBeanSet = new ConcurrentHashMap<>();
            com.tencent.qqnt.avatar.meta.refresh.a.f352938a.b(this);
        }
    }

    private final com.tencent.qqnt.avatar.meta.b c(int headType, String uin, int sizeType, byte shape) {
        int i3;
        if (headType == 113) {
            headType = 4;
        }
        int i16 = headType;
        if (sizeType <= 140) {
            i3 = 140;
        } else {
            i3 = sizeType;
        }
        boolean z16 = true;
        if (shape != 1 && shape != 5) {
            shape = 3;
        }
        if (shape == 1 || shape == 5) {
            z16 = false;
        }
        return new b.a(i16, uin, i3, false, 8, null).m(z16).b();
    }

    @Override // com.tencent.qqnt.avatar.meta.refresh.b
    public void a(@NotNull com.tencent.qqnt.avatar.meta.refresh.bean.a refreshInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) refreshInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshInfo, "refreshInfo");
        final String b16 = refreshInfo.b();
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("ProAvatarFaceDecoderImpl", 1, "refresh uin is null or empty");
            return;
        }
        final com.tencent.qqnt.avatar.meta.b bVar = this.loadAvatarBeanSet.get(refreshInfo.a() + "_" + refreshInfo.b());
        if (bVar == null) {
            return;
        }
        a.InterfaceC9507a interfaceC9507a = new a.InterfaceC9507a(b16, this) { // from class: com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl$refresh$fetcherCb$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f195551b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ProAvatarFaceDecoderImpl f195552c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f195551b = b16;
                this.f195552c = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, com.tencent.qqnt.avatar.meta.b.this, b16, this);
                }
            }

            @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
            public void a(@NotNull com.tencent.qqnt.avatar.fetch.d result) {
                Object obj;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                com.tencent.qqnt.avatar.layer.d<? extends Object> b17 = result.b();
                final Bitmap bitmap = null;
                if (b17 != null) {
                    obj = b17.d();
                } else {
                    obj = null;
                }
                if (obj instanceof Bitmap) {
                    bitmap = (Bitmap) obj;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("ProAvatarFaceDecoderImpl", 4, "onResult [" + com.tencent.qqnt.avatar.meta.b.this.a() + "_" + this.f195551b + "_" + com.tencent.qqnt.avatar.meta.b.this.e() + "] bitmap:" + bitmap);
                }
                if (bitmap == null) {
                    return;
                }
                ProAvatarFaceDecoderImpl.Companion companion = ProAvatarFaceDecoderImpl.INSTANCE;
                final ProAvatarFaceDecoderImpl proAvatarFaceDecoderImpl = this.f195552c;
                final com.tencent.qqnt.avatar.meta.b bVar2 = com.tencent.qqnt.avatar.meta.b.this;
                final String str = this.f195551b;
                companion.b(new Function0<Unit>(bVar2, str, bitmap) { // from class: com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl$refresh$fetcherCb$1$onResult$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.qqnt.avatar.meta.b $bean;
                    final /* synthetic */ Bitmap $bitmap;
                    final /* synthetic */ String $uin;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$bean = bVar2;
                        this.$uin = str;
                        this.$bitmap = bitmap;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, ProAvatarFaceDecoderImpl.this, bVar2, str, bitmap);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DecodeTaskCompletionListener decodeTaskCompletionListener;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        DecodeTaskCompletionListener decodeTaskCompletionListener2 = ProAvatarFaceDecoderImpl.this.mDecodeTaskCompletionListener;
                        if (decodeTaskCompletionListener2 != null) {
                            decodeTaskCompletionListener2.onDecodeTaskCompleted(0, this.$bean.a(), this.$uin, this.$bitmap);
                        }
                        if (this.$bean.a() != 4 || (decodeTaskCompletionListener = ProAvatarFaceDecoderImpl.this.mDecodeTaskCompletionListener) == null) {
                            return;
                        }
                        decodeTaskCompletionListener.onDecodeTaskCompleted(0, 113, this.$uin, this.$bitmap);
                    }
                });
            }
        };
        MetaResourceFetcher metaResourceFetcher = MetaResourceFetcher.f352881b;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        metaResourceFetcher.a(applicationContext, bVar, interfaceC9507a, true);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.destory();
        this.loadAvatarBeanSet.clear();
        com.tencent.qqnt.avatar.meta.refresh.a.f352938a.c(this);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    @Nullable
    public Bitmap getBitmapFromCache(int headType, @Nullable String uin, int idType, byte shape, int sizeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(headType), uin, Integer.valueOf(idType), Byte.valueOf(shape), Integer.valueOf(sizeType));
        }
        if (uin == null || uin.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.e("ProAvatarFaceDecoderImpl", 1, "getBitmapFromCache uin is null");
            return null;
        }
        com.tencent.qqnt.avatar.meta.b c16 = c(headType, uin, sizeType, shape);
        Bitmap j3 = MetaResourceFetcher.f352881b.j(c16);
        QLog.d("ProAvatarFaceDecoderImpl", 4, "getBitmapFromCache [" + headType + "_" + uin + "_" + sizeType + "] cacheBitmap: " + j3 + " ");
        ConcurrentHashMap<String, com.tencent.qqnt.avatar.meta.b> concurrentHashMap = this.loadAvatarBeanSet;
        int a16 = c16.a();
        String c17 = c16.c();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a16);
        sb5.append("_");
        sb5.append(c17);
        concurrentHashMap.put(sb5.toString(), c16);
        return j3;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    @Nullable
    public Drawable getFaceDrawableByBitmap(@Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean preloadFacesWithFaceInfo(@Nullable ArrayList<HeadRequest> requestList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) requestList)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void refreshFaceWithTimeStamp(int headType, @Nullable String id5, int idType, long timestamp, int sizeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(headType), id5, Integer.valueOf(idType), Long.valueOf(timestamp), Integer.valueOf(sizeType));
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean requestDecodeFace(@Nullable final String uin, int idType, boolean smartMode, final int headType, boolean appendToTail, byte level, int shapeType, final int sizeType, boolean isDynamicMode) {
        boolean z16;
        Object obj;
        com.tencent.qqnt.avatar.layer.d<? extends Object> b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, uin, Integer.valueOf(idType), Boolean.valueOf(smartMode), Integer.valueOf(headType), Boolean.valueOf(appendToTail), Byte.valueOf(level), Integer.valueOf(shapeType), Integer.valueOf(sizeType), Boolean.valueOf(isDynamicMode))).booleanValue();
        }
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("ProAvatarFaceDecoderImpl", 1, "requestDecodeFace uin is null or empty");
            return false;
        }
        QLog.d("ProAvatarFaceDecoderImpl", 4, "requestDecodeFace [" + headType + "_" + uin + "_" + sizeType + "] ");
        com.tencent.qqnt.avatar.meta.b c16 = c(headType, uin, sizeType, (byte) shapeType);
        MetaResourceFetcher metaResourceFetcher = MetaResourceFetcher.f352881b;
        Bitmap bitmap = null;
        com.tencent.qqnt.avatar.fetch.d d16 = com.tencent.qqnt.avatar.core.a.d(metaResourceFetcher, c16, false, 2, null);
        if (d16 != null && (b16 = d16.b()) != null) {
            obj = b16.d();
        } else {
            obj = null;
        }
        if (obj instanceof Bitmap) {
            bitmap = (Bitmap) obj;
        }
        if (bitmap != null) {
            DecodeTaskCompletionListener decodeTaskCompletionListener = this.mDecodeTaskCompletionListener;
            if (decodeTaskCompletionListener != null) {
                decodeTaskCompletionListener.onDecodeTaskCompleted(0, headType, uin, bitmap);
            }
            return false;
        }
        a.InterfaceC9507a interfaceC9507a = new a.InterfaceC9507a(headType, uin, sizeType, this) { // from class: com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl$requestDecodeFace$fetcherCb$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f195553a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f195554b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f195555c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ProAvatarFaceDecoderImpl f195556d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f195553a = headType;
                this.f195554b = uin;
                this.f195555c = sizeType;
                this.f195556d = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(headType), uin, Integer.valueOf(sizeType), this);
                }
            }

            @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
            public void a(@NotNull com.tencent.qqnt.avatar.fetch.d result) {
                Object obj2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                com.tencent.qqnt.avatar.layer.d<? extends Object> b17 = result.b();
                final Bitmap bitmap2 = null;
                if (b17 != null) {
                    obj2 = b17.d();
                } else {
                    obj2 = null;
                }
                if (obj2 instanceof Bitmap) {
                    bitmap2 = (Bitmap) obj2;
                }
                QLog.d("ProAvatarFaceDecoderImpl", 4, "onResult [" + this.f195553a + "_" + this.f195554b + "_" + this.f195555c + "] bitmap:" + bitmap2);
                if (bitmap2 == null) {
                    return;
                }
                ProAvatarFaceDecoderImpl.Companion companion = ProAvatarFaceDecoderImpl.INSTANCE;
                final ProAvatarFaceDecoderImpl proAvatarFaceDecoderImpl = this.f195556d;
                final int i3 = this.f195553a;
                final String str = this.f195554b;
                companion.b(new Function0<Unit>(i3, str, bitmap2) { // from class: com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl$requestDecodeFace$fetcherCb$1$onResult$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Bitmap $bitmap;
                    final /* synthetic */ int $headType;
                    final /* synthetic */ String $uin;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$headType = i3;
                        this.$uin = str;
                        this.$bitmap = bitmap2;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, ProAvatarFaceDecoderImpl.this, Integer.valueOf(i3), str, bitmap2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        DecodeTaskCompletionListener decodeTaskCompletionListener2 = ProAvatarFaceDecoderImpl.this.mDecodeTaskCompletionListener;
                        if (decodeTaskCompletionListener2 != null) {
                            decodeTaskCompletionListener2.onDecodeTaskCompleted(0, this.$headType, this.$uin, this.$bitmap);
                        }
                    }
                });
            }
        };
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        metaResourceFetcher.a(applicationContext, c16, interfaceC9507a, false);
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean requestDecodeFaceWithFaceInfo(@Nullable String uin, int idType, boolean smartMode, int headType, boolean appendToTail, byte level, int shapeType, @Nullable QQHeadInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 4, this, uin, Integer.valueOf(idType), Boolean.valueOf(smartMode), Integer.valueOf(headType), Boolean.valueOf(appendToTail), Byte.valueOf(level), Integer.valueOf(shapeType), info)).booleanValue();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    protected void runNextTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void setAppRuntime(@Nullable AppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) app);
        }
    }
}
