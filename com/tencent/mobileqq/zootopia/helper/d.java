package com.tencent.mobileqq.zootopia.helper;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.ipc.g;
import com.tencent.mobileqq.zootopia.ipc.h;
import com.tencent.qphone.base.util.QLog;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/helper/d;", "", "", "j", "", "from", "", "i", "Lcom/tencent/mobileqq/zootopia/ipc/h;", "callback", "f", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f328319a = new d();

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        ((g) i.INSTANCE.a(g.class)).clearCachedSceneLoadingAvatarTexture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final h hVar) {
        ((g) i.INSTANCE.a(g.class)).getSceneLoadingAvatarTexture(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin(), 800, 800, new h() { // from class: com.tencent.mobileqq.zootopia.helper.c
            @Override // com.tencent.mobileqq.zootopia.ipc.h
            public final void a(String str) {
                d.h(h.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h hVar, String avatarImagePath) {
        Intrinsics.checkNotNullParameter(avatarImagePath, "avatarImagePath");
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaAvatarTextureHelper", 1, "avatarImagePath:" + avatarImagePath);
        }
        if (hVar != null) {
            hVar.a(avatarImagePath);
        }
    }

    public final void d() {
        if (j()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.e();
                }
            }, 16, null, true);
        }
    }

    public final void f(final h callback) {
        if (j()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.g(h.this);
                }
            }, 16, null, true);
        } else if (callback != null) {
            callback.a("");
        }
    }

    public final void i(int from) {
        if (j()) {
            QLog.i("ZootopiaAvatarTextureHelper", 1, "preloadSceneLoadingAvatarTexture, from:" + from);
            f(null);
        }
    }

    public final boolean j() {
        return false;
    }
}
