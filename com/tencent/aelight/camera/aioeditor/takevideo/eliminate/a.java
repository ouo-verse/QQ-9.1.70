package com.tencent.aelight.camera.aioeditor.takevideo.eliminate;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.utils.ar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/eliminate/a;", "", "", "a", "", "b", "", "c", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f68697a = new a();

    a() {
    }

    @JvmStatic
    public static final int a() {
        return R.drawable.ivz;
    }

    @JvmStatic
    public static final boolean b() {
        boolean c16 = ar.f326685a.c("IS_CLICK_ELIMINATE_ICON" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), false);
        ms.a.f("EliminateConfig", "eliminateIconId isClicked: " + c16);
        return c16;
    }

    @JvmStatic
    public static final void c() {
        ar.f326685a.m("IS_CLICK_ELIMINATE_ICON" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), true);
    }
}
