package com.tencent.mobileqq.proavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.proavatar.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.avatar.meta.MetaResourceFetcher;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00052\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eBs\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\"\u001a\u00020 \u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010'\u001a\u00020 \u0012\u0006\u0010(\u001a\u00020 \u0012\u0006\u0010)\u001a\u00020\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010.\u001a\u00020\u0006\u00a2\u0006\u0004\b/\u00100B\u0083\u0001\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\"\u001a\u00020 \u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010'\u001a\u00020 \u0012\u0006\u0010(\u001a\u00020 \u0012\u0006\u0010)\u001a\u00020\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010.\u001a\u00020\u0006\u0012\u0006\u00101\u001a\u00020\u0006\u0012\u0006\u00102\u001a\u00020 \u00a2\u0006\u0004\b/\u00103J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/proavatar/g;", "Lcom/tencent/mobileqq/app/face/FaceDrawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Lcom/tencent/qqnt/avatar/meta/refresh/b;", "Lcom/tencent/qqnt/avatar/meta/b;", "d", "", "forceRefresh", "", "c", "Lcom/tencent/common/app/AppInterface;", "app", "setApp", "Landroid/graphics/Bitmap;", "getBitmapFromCache", "getSettingJustFromCache", "requestDecode", "onNeedDownload", "Landroid/graphics/drawable/Drawable;", "who", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "scheduleDrawable", "unscheduleDrawable", "cancel", "Lcom/tencent/qqnt/avatar/meta/refresh/bean/a;", "refreshInfo", "a", "appInterface", "", "headType", "idType", "", "id", "", "level", "shape", "sizeType", "smartMode", "loadingDrawable", "failureDrawable", "Lcom/tencent/mobileqq/app/face/FaceDrawable$OnLoadingStateChangeListener;", "listener", "isDynamicMode", "<init>", "(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;BIIZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcom/tencent/mobileqq/app/face/FaceDrawable$OnLoadingStateChangeListener;Z)V", "isZplanOutbound", "outboundSceneId", "(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;BIIZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcom/tencent/mobileqq/app/face/FaceDrawable$OnLoadingStateChangeListener;ZZI)V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g extends FaceDrawable implements Drawable.Callback, com.tencent.qqnt.avatar.meta.refresh.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/proavatar/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.g$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/proavatar/g$b", "Lcom/tencent/qqnt/avatar/core/a$a;", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements a.InterfaceC9507a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.meta.b f259598b;

        b(com.tencent.qqnt.avatar.meta.b bVar) {
            this.f259598b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(g this$0, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onDecodeTaskCompleted(((FaceDrawable) this$0).mFaceInfo, bitmap);
        }

        @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
        public void a(@NotNull com.tencent.qqnt.avatar.fetch.d result) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            if (((FaceDrawable) g.this).mFaceInfo == null) {
                QLog.e("QQProAvatarFaceDrawable", 1, "onResult [" + this.f259598b.d() + "] mFaceInfo is null ");
                return;
            }
            com.tencent.qqnt.avatar.layer.d<? extends Object> b16 = result.b();
            final Bitmap bitmap = null;
            if (b16 != null) {
                obj = b16.d();
            } else {
                obj = null;
            }
            if (obj instanceof Bitmap) {
                bitmap = (Bitmap) obj;
            }
            QLog.d("QQProAvatarFaceDrawable", 4, "onResult [" + this.f259598b.d() + "] bitmap:" + bitmap);
            if (bitmap == null) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = g.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.c(g.this, bitmap);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@Nullable AppInterface appInterface, int i3, int i16, @Nullable String str, byte b16, int i17, int i18, boolean z16, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z17) {
        super(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z17, false, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            com.tencent.qqnt.avatar.meta.refresh.a.f352938a.b(this);
        } else {
            iPatchRedirector.redirect((short) 1, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Boolean.valueOf(z17));
        }
    }

    private final void c(boolean forceRefresh) {
        com.tencent.qqnt.avatar.meta.b d16 = d();
        if (d16 == null) {
            return;
        }
        b bVar = new b(d16);
        MetaResourceFetcher metaResourceFetcher = MetaResourceFetcher.f352881b;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        metaResourceFetcher.a(applicationContext, d16, bVar, forceRefresh);
    }

    private final com.tencent.qqnt.avatar.meta.b d() {
        FaceInfo faceInfo = this.mFaceInfo;
        boolean z16 = true;
        if (faceInfo == null) {
            QLog.e("QQProAvatarFaceDrawable", 1, "getBean faceInfo is null ");
            return null;
        }
        int i3 = faceInfo.headType;
        if (i3 == 113) {
            i3 = 4;
        }
        int i16 = i3;
        int i17 = faceInfo.sizeType;
        if (i17 <= 0) {
            i17 = 140;
        }
        int i18 = i17;
        int i19 = faceInfo.shape;
        if (((byte) i19) == 1 || ((byte) i19) == 5) {
            z16 = false;
        }
        String str = faceInfo.uin;
        Intrinsics.checkNotNullExpressionValue(str, "mFaceInfo.uin");
        return new b.a(i16, str, i18, false, 8, null).m(z16).b();
    }

    @Override // com.tencent.qqnt.avatar.meta.refresh.b
    public void a(@NotNull com.tencent.qqnt.avatar.meta.refresh.bean.a refreshInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) refreshInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshInfo, "refreshInfo");
        QLog.d("QQProAvatarFaceDrawable", 4, "refresh " + refreshInfo.a() + "_" + refreshInfo.b() + " cb: " + getCallback());
        c(true);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable, com.tencent.mobileqq.util.AsynLoadDrawable
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.cancel();
            com.tencent.qqnt.avatar.meta.refresh.a.f352938a.c(this);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    @Nullable
    protected Bitmap getBitmapFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.qqnt.avatar.meta.b d16 = d();
        if (d16 == null) {
            return null;
        }
        Bitmap j3 = MetaResourceFetcher.f352881b.j(d16);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQProAvatarFaceDrawable", 4, "getBitmapFromCache [" + d16.d() + "] cacheBitmap: " + j3);
        }
        return j3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) who);
            return;
        }
        Intrinsics.checkNotNullParameter(who, "who");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected void onNeedDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected boolean requestDecode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        c(false);
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long when) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, who, what, Long.valueOf(when));
            return;
        }
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected void setApp(@Nullable AppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) app);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) who, (Object) what);
            return;
        }
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    public g(@Nullable AppInterface appInterface, int i3, int i16, @Nullable String str, byte b16, int i17, int i18, boolean z16, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z17, boolean z18, int i19) {
        super(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z17, false, i19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            com.tencent.qqnt.avatar.meta.refresh.a.f352938a.b(this);
        } else {
            iPatchRedirector.redirect((short) 2, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i19));
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    @Nullable
    protected Bitmap getBitmapFromCache(boolean getSettingJustFromCache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? getBitmapFromCache() : (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, getSettingJustFromCache);
    }
}
