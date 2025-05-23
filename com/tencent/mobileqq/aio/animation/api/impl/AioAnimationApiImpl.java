package com.tencent.mobileqq.aio.animation.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.api.IAIOAnimationMsgManager;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.aio.animation.data.b;
import com.tencent.mobileqq.aio.animation.data.d;
import com.tencent.mobileqq.aio.animation.data.e;
import com.tencent.mobileqq.aio.animation.data.h;
import com.tencent.mobileqq.aio.animation.q;
import com.tencent.mobileqq.aio.animation.util.AioAnimationConfigHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u71.a;
import u71.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J6\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020!H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010&H\u0016R$\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/api/impl/AioAnimationApiImpl;", "Lcom/tencent/mobileqq/aio/animation/api/IAioAnimationApi;", "", "version", "", "url", "", "updateConfig", "updateResourceIfConfigChanged", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/animation/data/h;", "createContainer", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "Lcom/tencent/mobileqq/aio/animation/data/b;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mobileqq/aio/animation/data/d;", SessionDbHelper.SESSION_ID, "animContainer", "", "forceUpdateMsgSeq", "handleNewMsg", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "msgSeq", "setMsgHasRead", "cancelAll", "cleanup", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "convertMsgRecord", "Lcom/tencent/aio/data/AIOSession;", "convertSession", "Lu71/c;", "delegate", "setMsgDelegate", "Lu71/a;", "setTroopInfoDelegate", "aioMsgElementDelegate", "Lu71/c;", "getAioMsgElementDelegate", "()Lu71/c;", "setAioMsgElementDelegate", "(Lu71/c;)V", "aioInfoDelegate", "Lu71/a;", "getAioInfoDelegate", "()Lu71/a;", "setAioInfoDelegate", "(Lu71/a;)V", "<init>", "()V", "Companion", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AioAnimationApiImpl implements IAioAnimationApi {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private a aioInfoDelegate;

    @Nullable
    private c aioMsgElementDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/api/impl/AioAnimationApiImpl$a;", "", "Lcom/tencent/mobileqq/aio/animation/api/impl/AioAnimationApiImpl;", "a", "()Lcom/tencent/mobileqq/aio/animation/api/impl/AioAnimationApiImpl;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.api.impl.AioAnimationApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final AioAnimationApiImpl a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AioAnimationApiImpl) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRouteApi api = QRoute.api(IAioAnimationApi.class);
            Intrinsics.checkNotNull(api, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.api.impl.AioAnimationApiImpl");
            return (AioAnimationApiImpl) api;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29446);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AioAnimationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        q b16 = q.INSTANCE.b();
        if (b16 != null) {
            b16.n();
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void cleanup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            q.INSTANCE.a().w();
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    @NotNull
    public b convertMsgRecord(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (b) iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return new com.tencent.mobileqq.aio.animation.data.c(msgRecord);
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    @NotNull
    public d convertSession(@NotNull AIOSession session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (d) iPatchRedirector.redirect((short) 14, (Object) this, (Object) session);
        }
        Intrinsics.checkNotNullParameter(session, "session");
        return new e(session);
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    @NotNull
    public h createContainer(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (h) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new AIOAnimationContainer(context, null);
    }

    @Nullable
    public final a getAioInfoDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aioInfoDelegate;
    }

    @Nullable
    public final c getAioMsgElementDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aioMsgElementDelegate;
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void handleNewMsg(@NotNull BaseQQAppInterface app, @NotNull List<? extends b> msgList, @NotNull d session, @NotNull h animContainer, boolean forceUpdateMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, app, msgList, session, animContainer, Boolean.valueOf(forceUpdateMsgSeq));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(animContainer, "animContainer");
        q.INSTANCE.a().H(app, msgList, session, (AIOAnimationContainer) animContainer, forceUpdateMsgSeq);
    }

    public final void setAioInfoDelegate(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.aioInfoDelegate = aVar;
        }
    }

    public final void setAioMsgElementDelegate(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.aioMsgElementDelegate = cVar;
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void setMsgDelegate(@Nullable c delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) delegate);
        } else {
            this.aioMsgElementDelegate = delegate;
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void setMsgHasRead(@NotNull Contact contact, long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, contact, Long.valueOf(msgSeq));
        } else {
            Intrinsics.checkNotNullParameter(contact, "contact");
            ((IAIOAnimationMsgManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IAIOAnimationMsgManager.class, "")).updateParsedMsgSeq(contact, msgSeq);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void setTroopInfoDelegate(@Nullable a delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) delegate);
        } else {
            this.aioInfoDelegate = delegate;
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void updateConfig(long version, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(version), url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            AioAnimationConfigHolder.f188156a.k(version, url);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAioAnimationApi
    public void updateResourceIfConfigChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AioAnimationConfigHolder aioAnimationConfigHolder = AioAnimationConfigHolder.f188156a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aioAnimationConfigHolder.g(context);
    }
}
