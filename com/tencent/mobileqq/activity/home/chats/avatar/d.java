package com.tencent.mobileqq.activity.home.chats.avatar;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IAvatarGetterService;
import com.tencent.qqnt.chats.api.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.LogUtil;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b*\u0010+J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\u0011\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0019J,\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016R&\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R&\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00120!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/avatar/d;", "Lcom/tencent/qqnt/chats/inject/avatar/c;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "uin", "Landroid/widget/ImageView;", "view", "Landroid/graphics/drawable/Drawable;", "drawable", "", "f", "oldDrawable", "newDrawable", "", "i", "drawable1", "drawable2", h.F, "Landroid/graphics/Bitmap;", "e", "j", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "c", "Landroid/view/View;", "g", "", "remainingTasks", "type", "", "avatar", "onDecodeTaskCompleted", "Ljava/util/concurrent/ConcurrentHashMap;", "Lmqq/util/WeakReference;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "ref", "drawableCache", "J", "decodeFaceStartTime", "faceCache", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d extends com.tencent.qqnt.chats.inject.avatar.c implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, WeakReference<ImageView>> ref;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, WeakReference<Drawable>> drawableCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long decodeFaceStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Bitmap> faceCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/home/chats/avatar/d$a", "Lcom/tencent/qqnt/chats/api/a$a;", "", "remainingTasks", "type", "", "uin", "Landroid/graphics/Bitmap;", "avatar", "", "onDecodeTaskCompleted", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements a.InterfaceC9560a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.qqnt.chats.api.a.InterfaceC9560a
        public void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(remainingTasks), Integer.valueOf(type), uin, avatar);
            } else {
                d.this.onDecodeTaskCompleted(remainingTasks, type, uin, avatar);
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.ref = new ConcurrentHashMap<>();
        this.drawableCache = new ConcurrentHashMap<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        IRuntimeService runtimeService = ((QQAppInterface) peekAppRuntime).getRuntimeService(IAvatarGetterService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IA\u2026va, ProcessConstant.MAIN)");
        ((IAvatarGetterService) runtimeService).registerDecodeComplete(new a());
        this.faceCache = new ConcurrentHashMap<>();
    }

    private final Bitmap e(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof FaceDrawable)) {
            return null;
        }
        return ((FaceDrawable) drawable).getLoadedBitmap();
    }

    private final void f(long uin, ImageView view, Drawable drawable) {
        Object tag = view.getTag(R.id.x8s);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Long");
        long longValue = ((Long) tag).longValue();
        QLog.d("QQAsyncFacadeAvatarProvider", 1, "settingUin: " + longValue + " async name:" + LogUtil.wrapLogUin(String.valueOf(uin)) + " setting: " + e(view.getDrawable()) + ", info: " + e(drawable) + ", infoDrawable: " + drawable);
        if (longValue == uin && i(uin, view.getDrawable(), drawable)) {
            QLog.d("QQAsyncFacadeAvatarProvider", 1, "async setting");
            view.setImageDrawable(drawable);
        }
    }

    private final boolean h(Drawable drawable1, Drawable drawable2) {
        return Intrinsics.areEqual(e(drawable1), e(drawable2));
    }

    private final boolean i(long uin, Drawable oldDrawable, Drawable newDrawable) {
        if (e(oldDrawable) == null) {
            return true;
        }
        if (newDrawable instanceof QQProAvatarDrawable) {
            return !Intrinsics.areEqual(newDrawable, oldDrawable);
        }
        if (h(oldDrawable, newDrawable)) {
            return false;
        }
        if ((newDrawable instanceof FaceDrawable) || e(newDrawable) != null) {
            return true;
        }
        return false;
    }

    private final void j() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.avatar.c
            @Override // java.lang.Runnable
            public final void run() {
                d.k(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (Map.Entry<String, Bitmap> entry : this$0.faceCache.entrySet()) {
            WeakReference<ImageView> weakReference = this$0.ref.get(entry.getKey());
            if (weakReference != null && (imageView = weakReference.get()) != null) {
                this$0.f(Long.parseLong(entry.getKey()), imageView, new BitmapDrawable(BaseApplication.getContext().getResources(), entry.getValue()));
            }
        }
        this$0.faceCache.clear();
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public boolean b(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.g().g() == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public void c(@NotNull g item, @NotNull ImageView view) {
        Drawable b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.g().c()) {
            item.g().j(false);
            b16 = null;
        } else {
            b16 = item.g().b();
        }
        if (b16 != null) {
            view.setImageDrawable(b16);
        } else {
            item.g().h(g(item, view));
            view.setImageDrawable(item.g().b());
        }
    }

    @Nullable
    public final Drawable g(@NotNull g item, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) view);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        b.f182877a.a(item);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        IRuntimeService runtimeService = ((QQAppInterface) peekAppRuntime).getRuntimeService(IAvatarGetterService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IA\u2026va, ProcessConstant.MAIN)");
        return ((IAvatarGetterService) runtimeService).getDrawable(item, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        r11 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r12);
     */
    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(remainingTasks), Integer.valueOf(type), uin, avatar);
            return;
        }
        if ((avatar != null || remainingTasks <= 0) && uin != null && longOrNull != null) {
            longOrNull.longValue();
            if (avatar != null) {
                try {
                    this.faceCache.put(uin, avatar);
                } catch (OutOfMemoryError e16) {
                    System.gc();
                    e16.printStackTrace();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.decodeFaceStartTime;
            if (j3 <= 0 || currentTimeMillis - j3 <= 500) {
                z16 = false;
            }
            if ((remainingTasks > 0 && !z16) || this.faceCache.size() == 0) {
                return;
            }
            if (remainingTasks == 0) {
                currentTimeMillis = 0;
            }
            this.decodeFaceStartTime = currentTimeMillis;
            j();
        }
    }
}
