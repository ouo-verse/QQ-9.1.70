package com.tencent.mobileqq.troop.troopsetting.modules.base;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J,\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/base/h;", "", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarDataService;", "avatarCache", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "troopUin", "", "d", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "decoder", "Lkotlin/Function1;", "callback", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f301151a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f301151a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String troopUin, Function1 callback, int i3, int i16, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (bitmap != null && str != null) {
            if (!Intrinsics.areEqual(str, troopUin)) {
                QLog.e("TroopSettingAvatarUtils", 1, "troop uin not invalid.");
            } else {
                callback.invoke(bitmap);
            }
        }
    }

    @JvmStatic
    public static final void d(@NotNull IQQAvatarDataService avatarCache, @NotNull Bitmap bitmap, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(avatarCache, "avatarCache");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String faceBitmapCacheKey = avatarCache.getFaceBitmapCacheKey(4, troopUin, (byte) 3, 0, 0, true);
        Intrinsics.checkNotNullExpressionValue(faceBitmapCacheKey, "avatarCache.getFaceBitma\u2026           true\n        )");
        avatarCache.putBitmapToCache(faceBitmapCacheKey, bitmap, (byte) 0);
    }

    public final void b(@Nullable IFaceDecoder decoder, @NotNull final String troopUin, @NotNull final Function1<? super Bitmap, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, decoder, troopUin, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (decoder != null) {
            Bitmap bitmapFromCache = decoder.getBitmapFromCache(4, troopUin);
            if (bitmapFromCache != null) {
                callback.invoke(bitmapFromCache);
                return;
            }
            if (!decoder.isPausing()) {
                decoder.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.base.g
                    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
                    public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                        h.c(troopUin, callback, i3, i16, str, bitmap);
                    }
                });
                decoder.requestDecodeFace(troopUin, 4, true);
                return;
            } else {
                Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
                Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "getDefaultFaceBitmap()");
                callback.invoke(defaultFaceBitmap);
                return;
            }
        }
        Bitmap defaultFaceBitmap2 = BaseImageUtil.getDefaultFaceBitmap();
        Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap2, "getDefaultFaceBitmap()");
        callback.invoke(defaultFaceBitmap2);
    }
}
