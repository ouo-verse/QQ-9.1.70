package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J2\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOPokeApi;", "", "imagePath", "Landroid/graphics/Bitmap;", "getBitmap", "", "isBigResReady", "Lmqq/app/AppRuntime;", "appRuntime", "", "considerGetPokeBigRes", "isVasPokeShockSupport", "res", "", "resId", "vasPokeResExist", "", "pokeSvipMap", "Lkotlin/Function1;", "vasResourceCallback", "init", "vasPokeId", "downloadVasItem", "destroy", "<init>", "()V", "Companion", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOPokeApiNtImpl implements IAIOPokeApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOPokeApiNtImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOPokeApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58103);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOPokeApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void considerGetPokeBigRes(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void downloadVasItem(int vasPokeId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, vasPokeId);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    @Nullable
    public Bitmap getBitmap(@NotNull String imagePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) imagePath);
        }
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(imagePath);
        if (f16 == null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(imagePath, options);
                imageCacheHelper.i(imagePath, decodeFile, Business.AIO);
                return decodeFile;
            } catch (Throwable th5) {
                QLog.i(TAG, 1, "getBitmap error " + th5.getMessage());
                return null;
            }
        }
        return f16;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void init(@NotNull Map<Integer, Integer> pokeSvipMap, @Nullable Function1<? super String, Unit> vasResourceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pokeSvipMap, (Object) vasResourceCallback);
        } else {
            Intrinsics.checkNotNullParameter(pokeSvipMap, "pokeSvipMap");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public boolean isBigResReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public boolean isVasPokeShockSupport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void sendPokeMsg(@NotNull com.tencent.aio.api.runtime.a aVar, @NotNull AIOElementType.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar, (Object) bVar);
        } else {
            IAIOPokeApi.b.a(this, aVar, bVar);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public boolean vasPokeResExist(@NotNull String res, int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) res, resId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(res, "res");
        if (!Intrinsics.areEqual("bubble", res) && !Intrinsics.areEqual(ReportConst.ACTION.FULLSCREEN, res) && !Intrinsics.areEqual("view_aio", res)) {
            return new File(com.tencent.mobileqq.aio.msglist.holder.component.poke.ag.f191654d + resId + "/" + res).exists();
        }
        String str = com.tencent.mobileqq.aio.msglist.holder.component.poke.ag.f191654d;
        String str2 = File.separator;
        return new File(str + resId + str2 + res + str2 + res + Sticker.JSON_SUFFIX).exists();
    }
}
