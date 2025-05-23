package com.tencent.mobileqq.wxshare;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wxshare/d;", "", "", "picPath", "", "g", "Landroid/graphics/drawable/Drawable;", "drawable", "", "isDynamicImage", "d", "sharePicPath", "f", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f327839a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wxshare/d$a", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "resp", "", "onWXShareResp", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(@NotNull BaseResp resp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resp);
                return;
            }
            Intrinsics.checkNotNullParameter(resp, "resp");
            QLog.d("WXPicShareUtil", 1, "doSharePicInner errCode=" + resp.errCode + ", errStr=" + resp.errStr);
            WXShareHelper.b0().q0(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f327839a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(String picPath, Drawable drawable, boolean isDynamicImage) {
        String f16 = f(picPath, drawable);
        Bitmap d16 = com.tencent.open.base.b.d(f16, 200, 200, true);
        WXShareHelper.b0().A(new a());
        QLog.e("WXPicShareUtil", 2, "doSharePicInner originPicPath=" + picPath + ", path=" + f16);
        if (isDynamicImage) {
            WXShareHelper.b0().s0(picPath, d16, 200, 0, "img" + System.currentTimeMillis());
            return;
        }
        WXShareHelper.b0().v0(f16, d16, 200, 0, "img" + System.currentTimeMillis());
    }

    static /* synthetic */ void e(d dVar, String str, Drawable drawable, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        dVar.d(str, drawable, z16);
    }

    private final String f(String sharePicPath, Drawable drawable) {
        File parentFile;
        if (drawable == null) {
            QLog.e("WXPicShareUtil", 1, "makePicOpaque error, currDrawable is null!");
            return sharePicPath;
        }
        if (drawable.getOpacity() == -1) {
            return sharePicPath;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            boolean z16 = false;
            drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            String str = MobileQQ.sMobileQQ.getCacheDir().toString() + "/file/tmp/wx_share_pic_tmp.jpg";
            File file = new File(str);
            File parentFile2 = file.getParentFile();
            if (parentFile2 != null && parentFile2.exists()) {
                z16 = true;
            }
            if (!z16 && (parentFile = file.getParentFile()) != null) {
                parentFile.mkdirs();
            }
            FileUtils.saveBitmapToFile(createBitmap, str, Bitmap.CompressFormat.JPEG, 100);
            return str;
        } catch (OutOfMemoryError e16) {
            QLog.e("WXPicShareUtil", 1, "makePicOpaque error. ", e16);
            return sharePicPath;
        }
    }

    @JvmStatic
    public static final void g(@NotNull final String picPath) {
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        if (!FileUtils.fileExistsAndNotEmpty(picPath)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxshare.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.h();
                }
            });
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if (!WXShareHelper.b0().e0()) {
            intRef.element = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            intRef.element = R.string.f173258ih2;
        }
        if (intRef.element != -1) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxshare.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.i(Ref.IntRef.this);
                }
            });
        } else {
            QQPicLoader.f201806a.d().loadImage(Option.obtain().setLocalPath(picPath), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wxshare.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    d.j(picPath, loadState, option);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        QQToast.makeText(BaseApplication.getContext(), R.string.f173140hj4, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Ref.IntRef nTipId) {
        Intrinsics.checkNotNullParameter(nTipId, "$nTipId");
        QQToast.makeText(BaseApplication.getContext(), nTipId.element, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String picPath, LoadState loadState, Option option) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(picPath, "$picPath");
        boolean z16 = true;
        if (loadState != LoadState.STATE_DOWNLOAD_FAILED && loadState != LoadState.STATE_DECODE_FAILED) {
            if (loadState == LoadState.STATE_SUCCESS) {
                if (option.getResultBitMap() != null) {
                    drawable = new BitmapDrawable(option.getResultBitMap());
                } else {
                    if (option.getAnimatable() instanceof Drawable) {
                        Object animatable = option.getAnimatable();
                        Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                        drawable = (Drawable) animatable;
                        f327839a.d(picPath, drawable, z16);
                        return;
                    }
                    drawable = null;
                }
                z16 = false;
                f327839a.d(picPath, drawable, z16);
                return;
            }
            return;
        }
        QLog.e("WXPicShareUtil", 1, "loadImage fail, state=" + loadState + ".");
        e(f327839a, picPath, null, false, 4, null);
    }
}
