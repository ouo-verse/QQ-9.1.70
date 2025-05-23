package com.tencent.mobileqq.proavatar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.proavatar.mask.FrameAvatarMask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002JX\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eR6\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u00168\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0013j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/proavatar/i;", "", "", "a", "Lcom/tencent/qqnt/avatar/layer/d;", "curLayer", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "Lkotlin/Function0;", "drawSelf", "drawableInvalidateSelf", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/proavatar/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getMaskHandlerList$annotations", "()V", "maskHandlerList", "c", "maskHandlerListImpl", "d", "Z", "isInit", "<init>", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f259610a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAvatarImpl/Inject_ProAvatarMaskInit.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<c>> maskHandlerList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<c> maskHandlerListImpl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isInit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f259610a = new i();
        ArrayList<Class<c>> arrayList = new ArrayList<>();
        maskHandlerList = arrayList;
        arrayList.add(b03.f.class);
        arrayList.add(com.tencent.mobileqq.proavatar.mask.a.class);
        arrayList.add(FrameAvatarMask.class);
        maskHandlerListImpl = new ArrayList<>();
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (isInit) {
            return;
        }
        isInit = true;
        Iterator<T> it = maskHandlerList.iterator();
        while (it.hasNext()) {
            maskHandlerListImpl.add(((Class) it.next()).getConstructor(new Class[0]).newInstance(new Object[0]));
        }
    }

    public final boolean b(@NotNull com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer, @NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint paint, @Nullable k viewConfig, @NotNull Function0<Unit> drawSelf, @NotNull Function0<Unit> drawableInvalidateSelf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, curLayer, canvas, bounds, paint, viewConfig, drawSelf, drawableInvalidateSelf)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(curLayer, "curLayer");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(drawSelf, "drawSelf");
        Intrinsics.checkNotNullParameter(drawableInvalidateSelf, "drawableInvalidateSelf");
        a();
        Iterator<T> it = maskHandlerListImpl.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).a(curLayer, canvas, bounds, paint, viewConfig, drawSelf, drawableInvalidateSelf)) {
                return true;
            }
        }
        return false;
    }
}
