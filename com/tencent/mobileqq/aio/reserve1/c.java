package com.tencent.mobileqq.aio.reserve1;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.lateinit.LatinitCreateModeIntent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.reserve1.AIOReserve1UIState;
import com.tencent.mobileqq.aio.reserve1.a;
import com.tencent.mobileqq.aio.reserve1.audio.AIOAudioBtnVB;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurVB;
import com.tencent.mobileqq.aio.reserve1.emotion.AIOEmotionAnimContainerVB;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVB;
import com.tencent.mobileqq.aio.reserve1.navigation.NavigationVB;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadBubbleVB;
import com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelSwipeAnimateVB;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001\u001a\b\u0007\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\"\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/c;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/c;", "Lcom/tencent/mobileqq/aio/reserve1/a;", "Lcom/tencent/mobileqq/aio/reserve1/AIOReserve1UIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/reflect/KClass;", "Lcom/tencent/mobileqq/aio/lateinit/LatinitCreateModeIntent;", "p", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/a;", "childVB", "t", "u", "modelName", DomainData.DOMAIN_NAME, "com/tencent/mobileqq/aio/reserve1/c$b", h.F, "Lcom/tencent/mobileqq/aio/reserve1/c$b;", "mAction", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class c extends com.tencent.qqnt.aio.lazy.lazyInit.c<a, AIOReserve1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                c.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.BottomLayoutHeightChange) {
            updateUI(new AIOReserve1UIState.BottomLayoutHeightChanged(((AIOMsgListEvent.BottomLayoutHeightChange) intent).a()));
        } else if (intent instanceof AIOTitleContainerMsgIntent.NotifyTitleHeight) {
            updateUI(new AIOReserve1UIState.TitleHeightChanged(((AIOTitleContainerMsgIntent.NotifyTitleHeight) intent).a()));
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.BottomLayoutHeightChange");
        hashSet.add("com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent.NotifyTitleHeight");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.qqnt.aio.lazy.lazyInit.c
    @Nullable
    public com.tencent.aio.base.mvvm.a<?, ?> n(@NotNull String modelName, @NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) modelName, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.i("AIOReserve1VM", 1, "generateChildVB " + modelName);
        switch (modelName.hashCode()) {
            case -1920226373:
                if (modelName.equals("audio_button")) {
                    return new AIOAudioBtnVB(intent);
                }
                return null;
            case -1835279817:
                if (modelName.equals("photo_panel_swipe_animation")) {
                    return new PhotoPanelSwipeAnimateVB(intent);
                }
                return null;
            case -842911816:
                if (modelName.equals("fast_image")) {
                    return new AIOFastImageVB(intent);
                }
                return null;
            case -731088337:
                if (modelName.equals("aio_emotion_anim_container")) {
                    return new AIOEmotionAnimContainerVB(intent);
                }
                return null;
            case -321417692:
                if (modelName.equals("aio_unread_bubble")) {
                    return new UnreadBubbleVB(intent);
                }
                return null;
            case 1491704331:
                if (modelName.equals("aio_blur_bottom")) {
                    return new BottomBlurVB(intent);
                }
                return null;
            case 1857168396:
                if (modelName.equals("aio_navigation")) {
                    return new NavigationVB(intent);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.lazy.lazyInit.c, com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        }
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.c
    @NotNull
    public KClass<? extends LatinitCreateModeIntent> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (KClass) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Reflection.getOrCreateKotlinClass(AIOReserve1CreateModelIntent.class);
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.c
    @NotNull
    public HashSet<String> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashSet) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("audio_button");
        hashSet.add("photo_panel_swipe_animation");
        hashSet.add("custom_float_nav_bar");
        hashSet.add("fast_image");
        hashSet.add("aio_navigation");
        hashSet.add("aio_emotion_anim_container");
        hashSet.add("aio_unread_bubble");
        hashSet.add("aio_blur_bottom");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.c
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public AIOReserve1UIState m(@NotNull com.tencent.aio.base.mvvm.a<?, ?> childVB) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIOReserve1UIState) iPatchRedirector.redirect((short) 6, (Object) this, (Object) childVB);
        }
        Intrinsics.checkNotNullParameter(childVB, "childVB");
        return new AIOReserve1UIState.AddChildVB(childVB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7342a) {
            ((a.C7342a) intent).b(((com.tencent.aio.api.runtime.a) getMContext()).g().l().getInt("key_msg_head_padding", 0));
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.e().f(this, this.mAction);
    }
}
