package com.tencent.mobileqq.guild.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J(\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R<\u0010\u0019\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u0013j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00150\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/share/h;", "", "", "c", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", QCircleAlphaUserReporter.KEY_USER, "Landroid/widget/ImageView;", "imageView", "Lt02/d;", "callback", "e", "", "guildId", "f", "g", "Lcom/tencent/mobileqq/armap/f;", "d", "Ljava/util/HashMap;", "", "Lmqq/util/WeakReference;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "sHeaderLoaderMap", "", "Lcom/tencent/mobileqq/armap/e;", "Ljava/util/List;", "sFaceObservers", "<init>", "()V", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f234995a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, WeakReference<com.tencent.mobileqq.armap.f>> sHeaderLoaderMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<WeakReference<com.tencent.mobileqq.armap.e>> sFaceObservers = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/share/h$a;", "Lcom/tencent/mobileqq/armap/e;", "", "uin", "headPath", "Landroid/graphics/Bitmap;", "head", "", tl.h.F, "Lcom/tencent/mobileqq/armap/f;", "d", "Lcom/tencent/mobileqq/armap/f;", "avatarLoader", "Lt02/d;", "e", "Lt02/d;", "callback", "<init>", "(Lcom/tencent/mobileqq/armap/f;Lt02/d;)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements com.tencent.mobileqq.armap.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.mobileqq.armap.f avatarLoader;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final t02.d callback;

        public a(com.tencent.mobileqq.armap.f avatarLoader, t02.d callback) {
            Intrinsics.checkNotNullParameter(avatarLoader, "avatarLoader");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.avatarLoader = avatarLoader;
            this.callback = callback;
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String uin, String headPath, Bitmap head) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(headPath, "headPath");
            if (head == null) {
                return;
            }
            this.avatarLoader.f(this);
            this.callback.h(uin, headPath, head);
        }
    }

    h() {
    }

    @JvmStatic
    public static final void c() {
        Logger.f235387a.d().d("GuildRecentUserLoadTask", 1, "dona_t clearAvatarLoader loaderSize:" + sHeaderLoaderMap.size() + " observeSize:" + sFaceObservers.size());
        Collection<WeakReference<com.tencent.mobileqq.armap.f>> values = sHeaderLoaderMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "sHeaderLoaderMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Iterator<T> it5 = sFaceObservers.iterator();
            while (it5.hasNext()) {
                WeakReference weakReference2 = (WeakReference) it5.next();
                com.tencent.mobileqq.armap.f fVar = (com.tencent.mobileqq.armap.f) weakReference.get();
                if (fVar != null) {
                    fVar.f((com.tencent.mobileqq.armap.e) weakReference2.get());
                }
            }
        }
        sFaceObservers.clear();
        sHeaderLoaderMap.clear();
    }

    private final com.tencent.mobileqq.armap.f d(Context context, GuildRecentUser user) {
        if (user.getHeadType() == -1) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getAvatarLoader faceType invalid user:" + user;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildRecentUserLoadTask", 1, (String) it.next(), null);
            }
            return null;
        }
        HashMap<Integer, WeakReference<com.tencent.mobileqq.armap.f>> hashMap = sHeaderLoaderMap;
        WeakReference<com.tencent.mobileqq.armap.f> weakReference = hashMap.get(Integer.valueOf(user.getHeadType()));
        com.tencent.mobileqq.armap.f fVar = weakReference != null ? weakReference.get() : null;
        if (fVar != null) {
            return fVar;
        }
        com.tencent.mobileqq.armap.f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(context, user.getHeadType());
        nonMainAppHeadLoader.e((byte) 3);
        nonMainAppHeadLoader.init();
        hashMap.put(Integer.valueOf(user.getHeadType()), new WeakReference<>(nonMainAppHeadLoader));
        return nonMainAppHeadLoader;
    }

    @JvmStatic
    public static final void e(Context context, GuildRecentUser user, ImageView imageView, t02.d callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (user.getType() == 10014) {
            f234995a.f(user.getGuildId(), imageView);
        } else {
            f234995a.g(context, user, imageView, callback);
        }
    }

    private final void f(String guildId, ImageView imageView) {
        String guildAvatarUrlIPC;
        Unit unit;
        if (MobileQQ.sProcessId == 1) {
            guildAvatarUrlIPC = "";
            IGProGuildInfo guildInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(guildId);
            String avatarUrl = guildInfo != null ? guildInfo.getAvatarUrl(100) : null;
            if (avatarUrl != null) {
                guildAvatarUrlIPC = avatarUrl;
            }
        } else {
            guildAvatarUrlIPC = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildAvatarUrlIPC(guildId, 100);
        }
        imageView.setTag(guildId);
        Drawable guildFaceIcon = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(guildAvatarUrlIPC, 100, BaseImageUtil.getDefaultFaceDrawable(false), true);
        if (guildFaceIcon != null) {
            imageView.setImageDrawable(guildFaceIcon);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "loadGuildAvatar null for gId:" + guildId;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildRecentUserLoadTask", 1, (String) it.next(), null);
            }
        }
    }

    private final void g(Context context, GuildRecentUser user, ImageView imageView, t02.d callback) {
        com.tencent.mobileqq.armap.f d16 = d(context, user);
        if (d16 == null) {
            return;
        }
        imageView.setTag(user.getUin());
        a aVar = new a(d16, callback);
        sFaceObservers.add(new WeakReference<>(aVar));
        d16.a(aVar);
        Bitmap b16 = d16.b(user.getUin(), true);
        if (b16 == null) {
            return;
        }
        imageView.setImageBitmap(b16);
    }
}
