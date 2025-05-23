package com.tencent.mobileqq.proavatar.transform;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.proavatar.merge.exception.AvatarException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.layer.c;
import com.tencent.qqnt.avatar.meta.transform.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/proavatar/transform/a;", "Lcom/tencent/qqnt/avatar/meta/transform/b;", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArr", "", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Z", "Landroid/graphics/Bitmap;", "bitmapArr", "b", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements com.tencent.qqnt.avatar.meta.transform.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/proavatar/transform/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.transform.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    public boolean a(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarBean, (Object) avatarInfoArr)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        if (4 != avatarBean.a() && 113 != avatarBean.a()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    @Nullable
    public Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, avatarBean, avatarInfoArr, bitmapArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        Intrinsics.checkNotNullParameter(bitmapArr, "bitmapArr");
        if (bitmapArr.length == 1) {
            return null;
        }
        try {
            Context applicationContext = MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
            com.tencent.mobileqq.proavatar.merge.a aVar = new com.tencent.mobileqq.proavatar.merge.a(applicationContext);
            aVar.j(bitmapArr);
            aVar.n(new com.tencent.mobileqq.proavatar.merge.layout.a());
            aVar.p(avatarBean.e());
            aVar.l(1);
            aVar.m(avatarBean.n());
            return aVar.a();
        } catch (AvatarException e16) {
            QLog.e("GroupAvatarTransformHandler", 1, "AvatarException :" + e16);
            return null;
        }
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    @Nullable
    public c c(@NotNull com.tencent.qqnt.avatar.meta.b bVar, @NotNull com.tencent.qqnt.avatar.meta.info.a[] aVarArr, @NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, this, bVar, aVarArr, bitmap);
        }
        return b.a.a(this, bVar, aVarArr, bitmap);
    }
}
