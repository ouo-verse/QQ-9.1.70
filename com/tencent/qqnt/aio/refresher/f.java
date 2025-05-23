package com.tencent.qqnt.aio.refresher;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/f;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "bubbleId", "bubbleDiyTextId", "", "viewType", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "Lcom/tencent/qqnt/aio/refresher/h;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f extends com.tencent.mobileqq.aio.msglist.holder.external.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final h d(AIOMsgItem msgItem, String bubbleId, String bubbleDiyTextId, int viewType, CharSequence msgContent) {
        String valueOf = String.valueOf(msgItem.getMsgRecord().senderUin);
        long msgId = msgItem.getMsgId();
        boolean isSelf = msgItem.isSelf();
        QRouteApi api = QRoute.api(IBubbleManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBubbleManager::class.java)");
        IBubbleManager iBubbleManager = (IBubbleManager) api;
        if (!iBubbleManager.checkBubbleFile(Integer.parseInt(bubbleId))) {
            iBubbleManager.startDownload(Integer.parseInt(bubbleId), msgItem);
            return null;
        }
        String obj = msgContent.toString();
        AIOBubbleSkinInfo aIOBubbleSkinInfo = new AIOBubbleSkinInfo();
        Drawable background = iBubbleManager.getBackground(bubbleId, bubbleDiyTextId, valueOf, viewType, !isSelf);
        if (background == null) {
            return null;
        }
        AIOBubbleSkinInfo.BackgroundImageInfo backgroundImageInfo = new AIOBubbleSkinInfo.BackgroundImageInfo();
        backgroundImageInfo.b(background);
        backgroundImageInfo.i(0);
        backgroundImageInfo.h(0);
        aIOBubbleSkinInfo.h(backgroundImageInfo);
        aIOBubbleSkinInfo.i(com.tencent.mobileqq.aio.utils.n.f194168a.i(msgItem));
        Drawable animDrawable = iBubbleManager.getAnimDrawable(bubbleId, obj, viewType, !isSelf);
        AIOBubbleSkinInfo.b bVar = new AIOBubbleSkinInfo.b();
        bVar.b(animDrawable);
        aIOBubbleSkinInfo.j(bVar);
        IBubbleManager.Companion companion = IBubbleManager.INSTANCE;
        if (viewType == companion.d()) {
            Drawable animDrawable2 = iBubbleManager.getAnimDrawable(bubbleId, obj, companion.e(), !isSelf);
            AIOBubbleSkinInfo.b bVar2 = new AIOBubbleSkinInfo.b();
            bVar2.b(animDrawable2);
            aIOBubbleSkinInfo.n(bVar2);
            Drawable animDrawable3 = iBubbleManager.getAnimDrawable(bubbleId, obj, companion.c(), !isSelf);
            AIOBubbleSkinInfo.b bVar3 = new AIOBubbleSkinInfo.b();
            bVar3.b(animDrawable3);
            aIOBubbleSkinInfo.j(bVar3);
            Drawable animDrawable4 = iBubbleManager.getAnimDrawable(bubbleId, obj, companion.d(), !isSelf);
            AIOBubbleSkinInfo.b bVar4 = new AIOBubbleSkinInfo.b();
            bVar4.b(animDrawable4);
            aIOBubbleSkinInfo.m(bVar4);
        }
        aIOBubbleSkinInfo.k(1);
        AIOBubbleSkinInfo.c cVar = new AIOBubbleSkinInfo.c();
        IBubbleManager.BubbleTextInfo bubbleTextInfo = iBubbleManager.getBubbleTextInfo(bubbleId);
        if (bubbleTextInfo != null) {
            int calculateTransparentBubbleTextColor = ((IBubbleTextColorManager) QRoute.api(IBubbleTextColorManager.class)).calculateTransparentBubbleTextColor(bubbleId, bubbleTextInfo.getColor(), msgItem);
            IBubbleTextColorManager.Companion companion2 = IBubbleTextColorManager.INSTANCE;
            if (calculateTransparentBubbleTextColor == companion2.a()) {
                calculateTransparentBubbleTextColor = bubbleTextInfo.getColor();
            }
            int calculateTransparentBubbleTextColor2 = ((IBubbleTextColorManager) QRoute.api(IBubbleTextColorManager.class)).calculateTransparentBubbleTextColor(bubbleId, bubbleTextInfo.getLinkColor(), msgItem);
            if (calculateTransparentBubbleTextColor2 == companion2.a()) {
                calculateTransparentBubbleTextColor2 = bubbleTextInfo.getLinkColor();
            }
            cVar.h(ColorStateList.valueOf(calculateTransparentBubbleTextColor));
            cVar.g(Integer.valueOf(calculateTransparentBubbleTextColor));
            cVar.i(0);
            cVar.j(ColorStateList.valueOf(calculateTransparentBubbleTextColor2));
            aIOBubbleSkinInfo.l(cVar);
        }
        return new h(msgId, aIOBubbleSkinInfo);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        int c16;
        h d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof g)) {
            return;
        }
        g gVar = (g) request;
        if (gVar.e().getMsgRecord().msgType == 6) {
            c16 = IBubbleManager.INSTANCE.d();
        } else {
            c16 = IBubbleManager.INSTANCE.c();
        }
        int i3 = c16;
        if (gVar.e().p0() == 104) {
            return;
        }
        if (!((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(gVar.e().getMsgRecord().peerUin), Integer.valueOf(gVar.e().getMsgRecord().chatType)) && c(gVar.e()) && (d16 = d(gVar.e(), gVar.b(), gVar.a(), i3, gVar.d())) != null) {
            gVar.f(d16);
        }
    }

    public final boolean c(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        int i3 = msgItem.getMsgRecord().msgType;
        if (i3 != 19 && i3 != 25) {
            return true;
        }
        return false;
    }
}
