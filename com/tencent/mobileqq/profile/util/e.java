package com.tencent.mobileqq.profile.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\u0006R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/profile/util/e;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "facePath", "", "c", "uin", "nickname", "Landroid/graphics/Bitmap;", "faceBitmap", "g", "f", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "mFacePath", "d", "Landroid/graphics/Bitmap;", "mFaceBitmap", "", "e", "Z", "mIsInShare", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f260359a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mFacePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Bitmap mFaceBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsInShare;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f260359a = new e();
            TAG = "ShareCardToWechatUtil";
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(final QQAppInterface app, final String facePath) {
        if (QLog.isColorLevel()) {
            String str = TAG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("decodeFace: %s", Arrays.copyOf(new Object[]{facePath}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(str, 2, format);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profile.util.c
            @Override // java.lang.Runnable
            public final void run() {
                e.d(facePath, app);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String facePath, final QQAppInterface app) {
        final Bitmap bitmap;
        Intrinsics.checkNotNullParameter(facePath, "$facePath");
        Intrinsics.checkNotNullParameter(app, "$app");
        try {
            if (q.p(facePath)) {
                bitmap = BitmapFactory.decodeFile(mFacePath);
                mFaceBitmap = bitmap;
            } else {
                Bitmap h16 = j.h(BaseApplicationImpl.getApplication().getResources(), R.drawable.coo);
                String str = TAG;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("decodeFace facePath: %s is not exist", Arrays.copyOf(new Object[]{facePath}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d(str, 2, format);
                bitmap = h16;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profile.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.e(QQAppInterface.this, bitmap);
                }
            });
        } catch (Exception e16) {
            QLog.d(TAG, 1, "decode bitmap exception...", e16);
        } catch (OutOfMemoryError e17) {
            QLog.d(TAG, 1, "decode bitmap oom...", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QQAppInterface app, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(app, "$app");
        String uin = app.getCurrentAccountUin();
        String nickName = ac.f(app, uin);
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return;
        }
        if (bitmap != null) {
            e eVar = f260359a;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            eVar.g(uin, nickName, bitmap);
            return;
        }
        QQToast.makeText(context, 1, R.string.hiu, 1).show();
    }

    private final void g(String uin, String nickname, Bitmap faceBitmap) {
        mIsInShare = false;
        WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), nickname, faceBitmap, "\u6765\u81eaQQ\u7684\u63a8\u8350\u597d\u53cb", "https://ti.qq.com/open_qq/index2.html?url=mqqapi%3a%2f%2fuserprofile%2ffriend_profile_card%3fsrc_type%3dweb%26version%3d1.0%26source%3d2%26uin%3d" + uin);
    }

    public final void f() {
        BaseApplication context;
        AppRuntime peekAppRuntime;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (mIsInShare || (context = BaseApplication.getContext()) == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String uin = qQAppInterface.getCurrentAccountUin();
        String nickName = ac.f((AppInterface) peekAppRuntime, uin);
        if (!WXShareHelper.b0().e0()) {
            i3 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i3 = R.string.f173258ih2;
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            QQToast.makeText(context, 1, i3, 1).show();
            QLog.d(TAG, 1, "shareToWXFriend, but wechat is not install or version is too low");
            return;
        }
        mIsInShare = true;
        Bitmap bitmap = mFaceBitmap;
        if (bitmap != null) {
            e eVar = f260359a;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            eVar.g(uin, nickName, bitmap);
            return;
        }
        if (q.p(mFacePath)) {
            String str = mFacePath;
            Intrinsics.checkNotNull(str);
            c(qQAppInterface, str);
        } else {
            String customFaceFilePath = qQAppInterface.getCustomFaceFilePath(1, uin, 0);
            mFacePath = customFaceFilePath;
            if (customFaceFilePath != null) {
                f260359a.c(qQAppInterface, customFaceFilePath);
            }
        }
    }
}
