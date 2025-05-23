package com.tencent.mobileqq.aio.notification.debug;

import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J7\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/debug/AIODebugNotificationProvider;", "Lcom/tencent/mobileqq/aio/notification/d;", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "type", "", "b", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "", "eventType", "", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", h.F, "", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "e", "Ljava/util/List;", "notificationList", "f", "Lcom/tencent/mobileqq/aio/notification/c;", "manager", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIODebugNotificationProvider implements com.tencent.mobileqq.aio.notification.d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final AIODebugNotificationProvider f192877d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<IAIONotificationUIModel> notificationList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.aio.notification.c manager;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192880a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53575);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AIONotificationBusiId.values().length];
            try {
                iArr[AIONotificationBusiId.DEBUG_LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIONotificationBusiId.DEBUG_TODO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f192880a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53577);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f192877d = new AIODebugNotificationProvider();
            notificationList = new ArrayList();
        }
    }

    AIODebugNotificationProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@NotNull AIONotificationBusiId type) {
        IAIONotificationUIModel.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        List<IAIONotificationUIModel> list = notificationList;
        int size = list.size();
        AIODebugNotificationProvider$addNotification$clickCallback$1 aIODebugNotificationProvider$addNotification$clickCallback$1 = AIODebugNotificationProvider$addNotification$clickCallback$1.INSTANCE;
        int i3 = a.f192880a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                bVar = new IAIONotificationUIModel.b(AIONotificationBusiId.DEBUG_APPLICATION, "\u5e94\u7528\u901a\u77e5" + size, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, aIODebugNotificationProvider$addNotification$clickCallback$1, 24, null);
            } else {
                IAIONotificationUIModel.c a16 = IAIONotificationUIModel.c.INSTANCE.a(AIONotificationBusiId.DEBUG_TODO, "[\u7fa4\u5f85\u529e]", "\u5f85\u529e\u901a\u77e5" + size, aIODebugNotificationProvider$addNotification$clickCallback$1);
                a16.i(IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW);
                bVar = a16;
            }
        } else {
            bVar = new IAIONotificationUIModel.b(AIONotificationBusiId.DEBUG_LIVE, "\u5b9e\u65f6\u6d3b\u52a8\u901a\u77e5" + size, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, aIODebugNotificationProvider$addNotification$clickCallback$1, 24, null);
        }
        list.add(bVar);
        com.tencent.mobileqq.aio.notification.c cVar = manager;
        if (cVar != null) {
            cVar.c(bVar);
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AIONotificationBusiId[]{AIONotificationBusiId.DEBUG_APPLICATION, AIONotificationBusiId.DEBUG_TODO, AIONotificationBusiId.DEBUG_LIVE});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        d.Companion companion = com.tencent.mobileqq.aio.notification.d.INSTANCE;
        if (eventType == companion.a()) {
            manager = notificationManager;
        }
        if (eventType == companion.c()) {
            manager = null;
            notificationList.clear();
        }
    }
}
