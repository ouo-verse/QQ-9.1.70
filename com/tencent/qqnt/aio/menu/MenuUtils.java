package com.tencent.qqnt.aio.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOBlurApi;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015J\n\u0010!\u001a\u00020\u0004*\u00020 J\n\u0010#\u001a\u00020\"*\u00020 R\u001b\u0010'\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010$\u001a\u0004\b(\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuUtils;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "isSelfMsg", "useToken", "", "f", "g", "j", "i", "Lcom/tencent/qqnt/aio/menu/processor/b;", "menuMessager", "o", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "anchorView", "d", tl.h.F, "", "e", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "c", "screenLocation", "windowLocation", "a", "Landroid/content/Context;", DomainData.DOMAIN_NAME, "", "k", "Lkotlin/Lazy;", "getChangeToken", "()Z", com.tencent.mobileqq.msf.core.auth.d.f247424j, "l", "menuSeparateEmoReply", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MenuUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MenuUtils f351230a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy changeToken;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy menuSeparateEmoReply;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f351230a = new MenuUtils();
        lazy = LazyKt__LazyJVMKt.lazy(MenuUtils$changeToken$2.INSTANCE);
        changeToken = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(MenuUtils$menuSeparateEmoReply$2.INSTANCE);
        menuSeparateEmoReply = lazy2;
    }

    MenuUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int f(AIOMsgItem msgItem, boolean isSelfMsg, boolean useToken) {
        Pair<Boolean, Integer> paddingLeft = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getPaddingLeft(msgItem);
        boolean booleanValue = paddingLeft.component1().booleanValue();
        int intValue = paddingLeft.component2().intValue();
        if (booleanValue) {
            return intValue;
        }
        if (useToken) {
            a.c cVar = a.c.f192425a;
            if (isSelfMsg) {
                return cVar.a();
            }
            return cVar.b();
        }
        a.b bVar = a.b.f192418a;
        if (isSelfMsg) {
            return bVar.a();
        }
        return bVar.b();
    }

    private final int g(AIOMsgItem msgItem, boolean isSelfMsg, boolean useToken) {
        Pair<Boolean, Integer> paddingRight = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getPaddingRight(msgItem);
        boolean booleanValue = paddingRight.component1().booleanValue();
        int intValue = paddingRight.component2().intValue();
        if (booleanValue) {
            return intValue;
        }
        if (useToken) {
            a.c cVar = a.c.f192425a;
            if (isSelfMsg) {
                return cVar.b();
            }
            return cVar.a();
        }
        a.b bVar = a.b.f192418a;
        if (isSelfMsg) {
            return bVar.b();
        }
        return bVar.a();
    }

    private final int i(AIOMsgItem msgItem, boolean useToken) {
        Pair<Boolean, Integer> paddingBottom = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getPaddingBottom(msgItem);
        boolean booleanValue = paddingBottom.component1().booleanValue();
        int intValue = paddingBottom.component2().intValue();
        if (booleanValue) {
            return intValue;
        }
        if (useToken) {
            return a.c.f192425a.c();
        }
        return a.b.f192418a.c();
    }

    private final int j(AIOMsgItem msgItem, boolean useToken) {
        Pair<Boolean, Integer> paddingTop = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getPaddingTop(msgItem);
        boolean booleanValue = paddingTop.component1().booleanValue();
        int intValue = paddingTop.component2().intValue();
        if (booleanValue) {
            return intValue;
        }
        if (useToken) {
            return a.c.f192425a.d();
        }
        return a.b.f192418a.d();
    }

    @NotNull
    public final int[] a(@NotNull int[] screenLocation, @NotNull int[] windowLocation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (int[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) screenLocation, (Object) windowLocation);
        }
        Intrinsics.checkNotNullParameter(screenLocation, "screenLocation");
        Intrinsics.checkNotNullParameter(windowLocation, "windowLocation");
        return new int[]{screenLocation[0] - windowLocation[0], screenLocation[1] - windowLocation[1]};
    }

    public final boolean b(@Nullable com.tencent.qqnt.aio.menu.ui.c menu) {
        com.tencent.qqnt.aio.menu.ui.d b16;
        AIOMsgItem d16;
        MsgRecord msgRecord;
        String str;
        com.tencent.qqnt.aio.menu.ui.d b17;
        AIOMsgItem d17;
        MsgRecord msgRecord2;
        AIOMsgItem d18;
        MsgRecord msgRecord3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) menu)).booleanValue();
        }
        if (menu != null && menu.d() > 0 && (b16 = menu.b(0)) != null && (d16 = b16.d()) != null && (msgRecord = d16.getMsgRecord()) != null) {
            int i3 = msgRecord.chatType;
            com.tencent.qqnt.aio.menu.ui.d b18 = menu.b(0);
            if (b18 != null && (d18 = b18.d()) != null && (msgRecord3 = d18.getMsgRecord()) != null) {
                str = msgRecord3.peerUid;
            } else {
                str = null;
            }
            if (str != null && (b17 = menu.b(0)) != null && (d17 = b17.d()) != null && (msgRecord2 = d17.getMsgRecord()) != null) {
                return ((IAIOBlurApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOBlurApi.class)).enableBlur(new com.tencent.qqnt.aio.data.b(Integer.valueOf(i3), str, Long.valueOf(msgRecord2.peerUin), false));
            }
        }
        return false;
    }

    public final boolean c(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgRecord)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        int i3 = msgRecord.chatType;
        return ((IAIOBlurApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOBlurApi.class)).enableBlur(new com.tencent.qqnt.aio.data.b(Integer.valueOf(i3), msgRecord.peerUid, Long.valueOf(msgRecord.peerUin), false));
    }

    public final int d(@NotNull View anchorView, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) anchorView, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        boolean c16 = com.tencent.mobileqq.aio.utils.m.f194167a.c(msgItem);
        return (anchorView.getHeight() - j(msgItem, c16)) - i(msgItem, c16);
    }

    @NotNull
    public final int[] e(@NotNull View anchorView, boolean isSelfMsg, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, this, anchorView, Boolean.valueOf(isSelfMsg), msgItem);
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        boolean c16 = com.tencent.mobileqq.aio.utils.m.f194167a.c(msgItem);
        anchorView.getLocationOnScreen(r1);
        int[] iArr = {iArr[0] + f(msgItem, isSelfMsg, c16), iArr[1] + j(msgItem, c16)};
        return iArr;
    }

    public final int h(@NotNull View anchorView, boolean isSelfMsg, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, anchorView, Boolean.valueOf(isSelfMsg), msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        boolean c16 = com.tencent.mobileqq.aio.utils.m.f194167a.c(msgItem);
        return (anchorView.getWidth() - f(msgItem, isSelfMsg, c16)) - g(msgItem, isSelfMsg, c16);
    }

    public final float k(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (n(context)) {
            return 0.9f;
        }
        return 1.0f;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((Boolean) menuSeparateEmoReply.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final View m(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
        if (view == null) {
            return null;
        }
        try {
            ViewParent viewParent = view.getParent();
            while (viewParent != 0 && !(viewParent instanceof RecyclerView)) {
                viewParent = viewParent.getParent();
            }
            if (!(viewParent instanceof View)) {
                return null;
            }
            return (View) viewParent;
        } catch (Exception e16) {
            QLog.w("MenuUtils", 1, "[getParent]: " + e16);
            return null;
        }
    }

    public final boolean n(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Math.min(ViewUtils.pxToDp(ScreenUtil.getInstantScreenWidth(context)), ViewUtils.pxToDp(com.tencent.mobileqq.aio.utils.e.f194142a.d())) <= 380.0d) {
            return true;
        }
        return false;
    }

    public final boolean o(@NotNull com.tencent.qqnt.aio.menu.processor.b menuMessager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) menuMessager)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(menuMessager, "menuMessager");
        p.g gVar = new p.g(false, 1, null);
        menuMessager.p0(gVar);
        return gVar.a();
    }
}
