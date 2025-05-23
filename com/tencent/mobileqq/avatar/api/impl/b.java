package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.avatar.fetch.d;
import com.tencent.qqnt.avatar.meta.MetaResourceFetcher;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0007J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/b;", "", "", "headType", "", "uin", "", "shape", "sizeType", "Landroid/graphics/Bitmap;", "b", "Lcom/tencent/qqnt/avatar/meta/b;", "a", "bean", "", "c", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f199940a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/avatar/api/impl/b$a", "Lcom/tencent/qqnt/avatar/core/a$a;", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements a.InterfaceC9507a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.meta.b f199941a;

        a(com.tencent.qqnt.avatar.meta.b bVar) {
            this.f199941a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
        public void a(@NotNull d result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("QQAvatarCompatibleServiceImplUtils", 4, "onResult [" + this.f199941a.d());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f199940a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.avatar.meta.b a(int headType, String uin, int sizeType, byte shape) {
        int i3;
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
        return new b.a(headType, uin, i3, false, 8, null).m(z16).b();
    }

    @JvmStatic
    @Nullable
    public static final Bitmap b(int headType, @Nullable String uin, byte shape, int sizeType) {
        boolean z16;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QQAvatarCompatibleServiceImplUtils", 1, "realGetFaceBitmap uin is null");
            return null;
        }
        b bVar = f199940a;
        com.tencent.qqnt.avatar.meta.b a16 = bVar.a(headType, uin, sizeType, shape);
        ResourceOrganizer.Companion companion = ResourceOrganizer.INSTANCE;
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        Bitmap e16 = companion.e(sMobileQQ, a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQAvatarCompatibleServiceImplUtils", 4, "realGetFaceBitmap [" + headType + "_" + uin + "_" + sizeType + "] cacheBitmap: " + e16);
        }
        if (e16 != null) {
            return e16;
        }
        bVar.c(a16);
        return null;
    }

    private final void c(com.tencent.qqnt.avatar.meta.b bean) {
        MetaResourceFetcher metaResourceFetcher = MetaResourceFetcher.f352881b;
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        com.tencent.qqnt.avatar.core.a.b(metaResourceFetcher, sMobileQQ, bean, new a(bean), false, 8, null);
    }
}
