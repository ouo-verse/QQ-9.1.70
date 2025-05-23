package com.tencent.qqnt.aio.adapter.api;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import java.util.Map;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\f\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J2\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOPokeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "imagePath", "Landroid/graphics/Bitmap;", "getBitmap", "", "isBigResReady", "Lmqq/app/AppRuntime;", "appRuntime", "", "considerGetPokeBigRes", "isVasPokeShockSupport", "res", "", "resId", "vasPokeResExist", "", "pokeSvipMap", "Lkotlin/Function1;", "vasResourceCallback", "init", "vasPokeId", "downloadVasItem", "destroy", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "sendPokeMsg", "Companion", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOPokeApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int POKE_TYPE_APPROVE = 3;
    public static final int POKE_TYPE_GIVING_HEART = 2;
    public static final int POKE_TYPE_GREAT_MOVE = 6;
    public static final int POKE_TYPE_HEART_BREAK = 4;
    public static final int POKE_TYPE_HI_TOGETHER = 5;
    public static final int POKE_TYPE_POKE = 1;
    public static final int POKE_TYPE_POKE_OLD = 0;
    public static final int POKE_TYPE_VAS_POKE = 126;

    @NotNull
    public static final String VAS_BUBBLE = "bubble";

    @NotNull
    public static final String VAS_POKE_RES_NORMAL = "/normal.png";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOPokeApi$a;", "", "Ljava/util/Vector;", "", "b", "Ljava/util/Vector;", "a", "()Ljava/util/Vector;", "AUTO_DOWNLOAD_VAS_POKE", "c", "CLICK_DOWNLOAD_VAS_POKE", "d", "DOWNLOADING_VAS_POKE_PANEL", "e", "DOWNLOADING_VAS_POKE_EFFECT", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.IAIOPokeApi$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f348497a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Vector<Integer> AUTO_DOWNLOAD_VAS_POKE;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Vector<Integer> CLICK_DOWNLOAD_VAS_POKE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Vector<Integer> DOWNLOADING_VAS_POKE_PANEL;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Vector<Integer> DOWNLOADING_VAS_POKE_EFFECT;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50450);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
                return;
            }
            f348497a = new Companion();
            AUTO_DOWNLOAD_VAS_POKE = new Vector<>();
            CLICK_DOWNLOAD_VAS_POKE = new Vector<>();
            DOWNLOADING_VAS_POKE_PANEL = new Vector<>();
            DOWNLOADING_VAS_POKE_EFFECT = new Vector<>();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Vector<Integer> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Vector) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return AUTO_DOWNLOAD_VAS_POKE;
        }

        @NotNull
        public final Vector<Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Vector) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return CLICK_DOWNLOAD_VAS_POKE;
        }

        @NotNull
        public final Vector<Integer> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Vector) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return DOWNLOADING_VAS_POKE_EFFECT;
        }

        @NotNull
        public final Vector<Integer> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Vector) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return DOWNLOADING_VAS_POKE_PANEL;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class b {
        public static void a(@NotNull IAIOPokeApi iAIOPokeApi, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOElementType.b item) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(50456), (Class<?>) IAIOPokeApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f348497a;
        }
    }

    void considerGetPokeBigRes(@Nullable AppRuntime appRuntime);

    void destroy();

    void downloadVasItem(int vasPokeId);

    @Nullable
    Bitmap getBitmap(@NotNull String imagePath);

    void init(@NotNull Map<Integer, Integer> pokeSvipMap, @Nullable Function1<? super String, Unit> vasResourceCallback);

    boolean isBigResReady();

    boolean isVasPokeShockSupport();

    void sendPokeMsg(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOElementType.b item);

    boolean vasPokeResExist(@NotNull String res, int resId);
}
