package com.tencent.qqnt.aio.api.impl;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.gift.ITroopGiftComponent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.doutu.DuiButtonImageView;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOAnimationApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOAnimationApi;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/aio/api/IAIOAnimationApi$AnimationScene;", "scene", "", "doAIOAnimationEnd", "onAIOAnimationStart", "onAIOAnimationEnd", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOAnimationApiImpl implements IAIOAnimationApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOAnimation";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOAnimationApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.AIOAnimationApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOAnimationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void doAIOAnimationEnd(FragmentActivity activity, IAIOAnimationApi.AnimationScene scene) {
        AIOContact a16;
        try {
            AbstractGifImage.resumeAll();
            ApngImage.resumeAll();
            ApngImage.playByTag(0);
            URLDrawable.resume();
            DuiButtonImageView.d();
            AIOVideoViewer.INSTANCE.a();
            if (activity != null && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(activity)) != null) {
                com.tencent.qqnt.aio.utils.c cVar = com.tencent.qqnt.aio.utils.c.f352293a;
                cVar.b(activity, a16.j(), new AIOTroopGiftEvent.TroopGiftPlayEvent(false));
                ((ITroopGiftComponent) QRoute.api(ITroopGiftComponent.class)).setPause(false);
                cVar.b(activity, a16.j(), MsgItemExternalRefreshEvent.RefreshAvatarPendant.f192380d);
                cVar.b(activity, a16.j(), new MsgItemExternalRefreshEvent.EnterAIOAnimationEnd(scene));
            }
            com.tencent.cachedrawable.dynamicdrawable.api.b.e(com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, null, 2, null);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[doAIOAnimationEnd]: " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAIOAnimationEnd$lambda$2(AIOAnimationApiImpl this$0, FragmentActivity fragmentActivity, IAIOAnimationApi.AnimationScene scene) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scene, "$scene");
        this$0.doAIOAnimationEnd(fragmentActivity, scene);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOAnimationApi
    public void onAIOAnimationEnd(@Nullable final FragmentActivity activity, @NotNull final IAIOAnimationApi.AnimationScene scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) scene);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        QLog.i(TAG, 1, "onAIOAnimationEnd scene=" + scene);
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOAnimationApiImpl.onAIOAnimationEnd$lambda$2(AIOAnimationApiImpl.this, activity, scene);
            }
        }, 1L);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOAnimationApi
    public void onAIOAnimationStart(@Nullable FragmentActivity activity, @NotNull IAIOAnimationApi.AnimationScene scene) {
        AIOContact a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) scene);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        QLog.i(TAG, 1, "onAIOAnimationStart scene=" + scene);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            AbstractGifImage.pauseAll();
            ApngImage.pauseAll();
            ApngImage.pauseByTag(0);
            URLDrawable.pause();
            DuiButtonImageView.c();
            AIOVideoViewer.INSTANCE.b();
            if (activity != null && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(activity)) != null) {
                com.tencent.qqnt.aio.utils.c cVar = com.tencent.qqnt.aio.utils.c.f352293a;
                cVar.b(activity, a16.j(), new AIOTroopGiftEvent.TroopGiftPlayEvent(true));
                cVar.b(activity, a16.j(), new MsgItemExternalRefreshEvent.EnterAIOAnimationStart(scene));
                ((ITroopGiftComponent) QRoute.api(ITroopGiftComponent.class)).setPause(true);
            }
            com.tencent.cachedrawable.dynamicdrawable.api.b.c(com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, null, 2, null);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[onAIOAnimationStart]: " + th5);
        }
        QLog.d(TAG, 1, "onAIOAnimationStart call, cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }
}
