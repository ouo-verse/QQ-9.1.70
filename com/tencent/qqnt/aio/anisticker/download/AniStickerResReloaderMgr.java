package com.tencent.qqnt.aio.anisticker.download;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.download.k;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/AniStickerResReloaderMgr;", "Lcom/tencent/qqnt/aio/anisticker/download/j;", "Lcom/tencent/qqnt/aio/anisticker/download/k$b;", "", "downloadType", "Lcom/tencent/qqnt/aio/anisticker/download/k;", "b", "", "cacheKey", "", "startReloadDrawable", "triggerDownloadRes", "<init>", "()V", "c", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AniStickerResReloaderMgr extends j implements k.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<AniStickerResReloaderMgr> f348804d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/AniStickerResReloaderMgr$a;", "", "Lcom/tencent/qqnt/aio/anisticker/download/AniStickerResReloaderMgr;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/aio/anisticker/download/AniStickerResReloaderMgr;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anisticker.download.AniStickerResReloaderMgr$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        public final AniStickerResReloaderMgr a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AniStickerResReloaderMgr) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (AniStickerResReloaderMgr) AniStickerResReloaderMgr.f348804d.getValue();
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
        Lazy<AniStickerResReloaderMgr> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AniStickerResReloaderMgr$Companion$instance$2.INSTANCE);
        f348804d = lazy;
    }

    public AniStickerResReloaderMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        List<Integer> listOf;
        if (QLog.isColorLevel()) {
            QLog.d("NT_AniStickerResReloaderMgr", 2, "trigger downloadEmoticonRes");
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{5, 9});
        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(listOf);
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.j
    @Nullable
    public k b(int downloadType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (k) iPatchRedirector.redirect((short) 2, (Object) this, downloadType);
        }
        if (downloadType == 1) {
            return new k(this);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.k.b
    public void startReloadDrawable(@Nullable String cacheKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cacheKey);
        } else {
            AniStickerLottieView.INSTANCE.h(cacheKey);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.k.b
    public void triggerDownloadRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.download.b
                @Override // java.lang.Runnable
                public final void run() {
                    AniStickerResReloaderMgr.f();
                }
            }, 128, null, false);
        }
    }
}
