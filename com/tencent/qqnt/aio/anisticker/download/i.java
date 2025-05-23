package com.tencent.qqnt.aio.anisticker.download;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.aio.anisticker.view.e;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.rlottie.a;
import com.tencent.util.UiThreadUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000  *\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ6\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J6\u0010\u000f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J6\u0010\u0012\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/i;", "T", "Lcom/tencent/qqnt/aio/anisticker/download/l;", "Landroid/content/Context;", "context", "", "filePath", "Lcom/tencent/qqnt/aio/anisticker/view/e$a;", "builder", "", "limitFps", "Lcom/tencent/qqnt/aio/anisticker/download/m;", "listener", "", "r", "j", "Landroidx/lifecycle/LifecycleOwner;", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "runnable", "t", "options", "u", "(Ljava/lang/Object;)V", DomainData.DOMAIN_NAME, "i", "()Ljava/lang/String;", "g", "cacheKey", "<init>", "()V", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class i<T> implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0004X\u0084T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0004X\u0084T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/i$a;", "", "", "LOTTIE_EMOTION_LIBRA_SWTICH", "Ljava/lang/String;", "TAG", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anisticker.download.i$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LifecycleOwner h(Context context) {
        Object lastOrNull;
        if (!(context instanceof FragmentActivity)) {
            if (context instanceof LifecycleOwner) {
                return (LifecycleOwner) context;
            }
            return null;
        }
        List<Fragment> fragments = ((FragmentActivity) context).getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "context.supportFragmentManager.fragments");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        return (LifecycleOwner) lastOrNull;
    }

    private final void j(Context context, String filePath, e.a builder, boolean limitFps, final m listener) {
        boolean z16;
        String str;
        AniStickerLottieView d16;
        Context context2;
        if ((!builder.j()) && com.tencent.qqnt.aio.anisticker.view.h.f348873a.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("precache", Boolean.valueOf(z16));
        AniStickerInfo l3 = builder.l();
        if (l3 != null) {
            str = l3.getCacheKey();
        } else {
            str = null;
        }
        final LibraRequestKey build = new LibraRequestKey.Builder(new LibraDownloadKey(str + new Random().nextInt(1000))).build();
        Option option = Option.obtain().setLocalPath(filePath).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setPreferDecoder(com.tencent.libra.extension.b.class).setRequestWidth(builder.o()).setRequestHeight(builder.n()).setExtraData(hashMap).setPathKey(build);
        if (QQSysFaceSwitcher.f204652a.d() && (d16 = builder.d()) != null && (context2 = d16.getContext()) != null) {
            option.setLifecycleOwner(h(context2));
        }
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(option, "option");
        iPicAIOApi.loadPic(option, new IPicLoadStateListener() { // from class: com.tencent.qqnt.aio.anisticker.download.g
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                i.k(LibraRequestKey.this, this, listener, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LibraRequestKey libraRequestKey, i this$0, final m mVar, LoadState loadState, Option option) {
        r01.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState != LoadState.STATE_SUCCESS) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (option.getAnimatable() instanceof r01.c) {
            Animatable animatable = option.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            objectRef.element = (T) new com.tencent.qqnt.aio.anisticker.drawable.a(cVar);
            if (QLog.isDevelopLevel()) {
                QLog.d("BaseLottieResDownloader", 4, "loadLottieRes result option.animatable = " + option.getAnimatable() + ", pathKey = " + libraRequestKey + ", drawable = " + objectRef.element);
            }
        }
        if (objectRef.element != null) {
            this$0.t(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.download.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.l(m.this, objectRef);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(m mVar, Ref.ObjectRef drawable) {
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        if (mVar != null) {
            mVar.a((com.tencent.qqnt.aio.anisticker.drawable.f) drawable.element);
        }
    }

    private final void m(Context context, String filePath, e.a builder, boolean limitFps, m listener) {
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("lottie_emotion_libra_116207832_9030", false)) {
            j(context, filePath, builder, limitFps, listener);
        } else {
            r(context, filePath, builder, limitFps, listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(m mVar, Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "$e");
        if (mVar != null) {
            mVar.onFail(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(m mVar, final i this$0, final e.a builder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(builder, "$builder");
        if (mVar != null) {
            mVar.onLottieResLoading(this$0.g());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.download.e
            @Override // java.lang.Runnable
            public final void run() {
                i.q(e.a.this, this$0);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(e.a builder, i this$0) {
        Intrinsics.checkNotNullParameter(builder, "$builder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            ((QQSysFaceResImpl) resImpl).addAniStickerReloadDrawable(builder.c(), this$0.g());
        }
    }

    private final void r(Context context, String filePath, e.a builder, boolean limitFps, final m listener) {
        boolean z16 = true;
        if (!(!builder.j()) || !com.tencent.qqnt.aio.anisticker.view.h.f348873a.c()) {
            z16 = false;
        }
        final com.tencent.qqnt.aio.anisticker.drawable.e eVar = new com.tencent.qqnt.aio.anisticker.drawable.e(a.C9743a.b(context, filePath, builder.o(), builder.n(), z16, limitFps));
        t(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.download.f
            @Override // java.lang.Runnable
            public final void run() {
                i.s(m.this, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(m mVar, com.tencent.qqnt.aio.anisticker.drawable.e drawable) {
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        if (mVar != null) {
            mVar.a(drawable);
        }
    }

    private final void t(Runnable runnable) {
        UiThreadUtil.runOnUiThreadWithCheck(runnable);
    }

    @NotNull
    public abstract String g();

    @Nullable
    public abstract String i();

    public void n(@NotNull final e.a builder, @Nullable final m listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) builder, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (QLog.isDevelopLevel()) {
            QLog.d("BaseLottieResDownloader", 4, "loadLottieRes filePath = " + i() + ", builder.viewWidth = " + builder.o() + ", builder.viewHeight = " + builder.n() + ", builder.showLastFrame = " + builder.j());
        }
        if (checkFileExists()) {
            try {
                m(BaseApplication.getContext(), i(), builder, true, listener);
                Unit unit = Unit.INSTANCE;
                return;
            } catch (Exception e16) {
                t(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.download.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.o(m.this, e16);
                    }
                });
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseLottieResDownloader", 2, "lottie file no found, path is " + i());
        }
        t(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.download.d
            @Override // java.lang.Runnable
            public final void run() {
                i.p(m.this, this, builder);
            }
        });
    }

    public abstract void u(T options);
}
